package com.facebook.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SectionIndexer;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.facebook.FacebookException;
import com.facebook.android.C0426R;
import com.facebook.internal.ImageDownloader;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.ImageRequest.Builder;
import com.facebook.internal.ImageRequest.Callback;
import com.facebook.internal.ImageResponse;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObject.Factory;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

class GraphObjectAdapter<T extends GraphObject> extends BaseAdapter implements SectionIndexer {
    static final /* synthetic */ boolean $assertionsDisabled = (!GraphObjectAdapter.class.desiredAssertionStatus());
    private static final int ACTIVITY_CIRCLE_VIEW_TYPE = 2;
    private static final int DISPLAY_SECTIONS_THRESHOLD = 1;
    private static final int GRAPH_OBJECT_VIEW_TYPE = 1;
    private static final int HEADER_VIEW_TYPE = 0;
    private static final String ID = "id";
    private static final int MAX_PREFETCHED_PICTURES = 20;
    private static final String NAME = "name";
    private static final String PICTURE = "picture";
    private Context context;
    private GraphObjectCursor<T> cursor;
    private DataNeededListener dataNeededListener;
    private boolean displaySections;
    private Filter<T> filter;
    private Map<String, T> graphObjectsById = new HashMap();
    private Map<String, ArrayList<T>> graphObjectsBySection = new HashMap();
    private String groupByField;
    private final LayoutInflater inflater;
    private OnErrorListener onErrorListener;
    private final Map<String, ImageRequest> pendingRequests = new HashMap();
    private Map<String, ImageResponse> prefetchedPictureCache = new HashMap();
    private ArrayList<String> prefetchedProfilePictureIds = new ArrayList();
    private List<String> sectionKeys = new ArrayList();
    private boolean showCheckbox;
    private boolean showPicture;
    private List<String> sortFields;

    public interface DataNeededListener {
        void onDataNeeded();
    }

    interface Filter<T> {
        boolean includeItem(T t);
    }

    private interface ItemPicture extends GraphObject {
        ItemPictureData getData();
    }

    private interface ItemPictureData extends GraphObject {
        String getUrl();
    }

    public interface OnErrorListener {
        void onError(GraphObjectAdapter<?> graphObjectAdapter, FacebookException facebookException);
    }

    public static class SectionAndItem<T extends GraphObject> {
        public T graphObject;
        public String sectionKey;

        public enum Type {
            GRAPH_OBJECT,
            SECTION_HEADER,
            ACTIVITY_CIRCLE
        }

        public SectionAndItem(String str, T t) {
            this.sectionKey = str;
            this.graphObject = t;
        }

        public Type getType() {
            return this.sectionKey == null ? Type.ACTIVITY_CIRCLE : this.graphObject == null ? Type.SECTION_HEADER : Type.GRAPH_OBJECT;
        }
    }

    public GraphObjectAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    private void callOnErrorListener(Exception exception) {
        if (this.onErrorListener != null) {
            FacebookException facebookException;
            if (exception instanceof FacebookException) {
                Exception exception2 = exception;
            } else {
                facebookException = new FacebookException((Throwable) exception);
            }
            this.onErrorListener.onError(this, facebookException);
        }
    }

    private static int compareGraphObjects(GraphObject graphObject, GraphObject graphObject2, Collection<String> collection, Collator collator) {
        for (String str : collection) {
            String str2 = (String) graphObject.getProperty(str);
            String str3 = (String) graphObject2.getProperty(str3);
            if (str2 != null && str3 != null) {
                int compare = collator.compare(str2, str3);
                if (compare != 0) {
                    return compare;
                }
            } else if (str2 != null || str3 != null) {
                return str2 == null ? -1 : 1;
            }
        }
        return 0;
    }

    private void downloadProfilePicture(final String str, URI uri, final ImageView imageView) {
        if (uri != null) {
            Object obj = imageView == null ? 1 : null;
            if (obj != null || !uri.equals(imageView.getTag())) {
                if (obj == null) {
                    imageView.setTag(str);
                    imageView.setImageResource(getDefaultPicture());
                }
                ImageRequest build = new Builder(this.context.getApplicationContext(), uri).setCallerTag(this).setCallback(new Callback() {
                    public void onCompleted(ImageResponse imageResponse) {
                        GraphObjectAdapter.this.processImageResponse(imageResponse, str, imageView);
                    }
                }).build();
                this.pendingRequests.put(str, build);
                ImageDownloader.downloadAsync(build);
            }
        }
    }

    private View getActivityCircleView(View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.inflater.inflate(C0426R.layout.com_facebook_picker_activity_circle_row, null);
        }
        ((ProgressBar) view.findViewById(C0426R.id.com_facebook_picker_row_activity_circle)).setVisibility(0);
        return view;
    }

    private void processImageResponse(ImageResponse imageResponse, String str, ImageView imageView) {
        this.pendingRequests.remove(str);
        if (imageResponse.getError() != null) {
            callOnErrorListener(imageResponse.getError());
        }
        if (imageView == null) {
            if (imageResponse.getBitmap() != null) {
                if (this.prefetchedPictureCache.size() >= 20) {
                    this.prefetchedPictureCache.remove((String) this.prefetchedProfilePictureIds.remove(0));
                }
                this.prefetchedPictureCache.put(str, imageResponse);
            }
        } else if (str.equals(imageView.getTag())) {
            Exception error = imageResponse.getError();
            Bitmap bitmap = imageResponse.getBitmap();
            if (error == null && bitmap != null) {
                imageView.setImageBitmap(bitmap);
                imageView.setTag(imageResponse.getRequest().getImageUri());
            }
        }
    }

    private void rebuildSections() {
        boolean z = false;
        this.sectionKeys = new ArrayList();
        this.graphObjectsBySection = new HashMap();
        this.graphObjectsById = new HashMap();
        this.displaySections = false;
        if (this.cursor != null && this.cursor.getCount() != 0) {
            this.cursor.moveToFirst();
            int i = 0;
            while (true) {
                int i2;
                GraphObject graphObject = this.cursor.getGraphObject();
                if (filterIncludesItem(graphObject)) {
                    i2 = i + 1;
                    String sectionKeyOfGraphObject = getSectionKeyOfGraphObject(graphObject);
                    if (!this.graphObjectsBySection.containsKey(sectionKeyOfGraphObject)) {
                        this.sectionKeys.add(sectionKeyOfGraphObject);
                        this.graphObjectsBySection.put(sectionKeyOfGraphObject, new ArrayList());
                    }
                    ((List) this.graphObjectsBySection.get(sectionKeyOfGraphObject)).add(graphObject);
                    this.graphObjectsById.put(getIdOfGraphObject(graphObject), graphObject);
                } else {
                    i2 = i;
                }
                if (!this.cursor.moveToNext()) {
                    break;
                }
                i = i2;
            }
            if (this.sortFields != null) {
                final Collator instance = Collator.getInstance();
                for (List sort : this.graphObjectsBySection.values()) {
                    Collections.sort(sort, new Comparator<GraphObject>() {
                        public int compare(GraphObject graphObject, GraphObject graphObject2) {
                            return GraphObjectAdapter.compareGraphObjects(graphObject, graphObject2, GraphObjectAdapter.this.sortFields, instance);
                        }
                    });
                }
            }
            Collections.sort(this.sectionKeys, Collator.getInstance());
            if (this.sectionKeys.size() > 1 && i2 > 1) {
                z = true;
            }
            this.displaySections = z;
        }
    }

    private boolean shouldShowActivityCircleCell() {
        return (this.cursor == null || !this.cursor.areMoreObjectsAvailable() || this.dataNeededListener == null || isEmpty()) ? false : true;
    }

    public boolean areAllItemsEnabled() {
        return this.displaySections;
    }

    public boolean changeCursor(GraphObjectCursor<T> graphObjectCursor) {
        if (this.cursor == graphObjectCursor) {
            return false;
        }
        if (this.cursor != null) {
            this.cursor.close();
        }
        this.cursor = graphObjectCursor;
        rebuildAndNotify();
        return true;
    }

    protected View createGraphObjectView(T t) {
        View inflate = this.inflater.inflate(getGraphObjectRowLayoutId(t), null);
        ViewStub viewStub = (ViewStub) inflate.findViewById(C0426R.id.com_facebook_picker_checkbox_stub);
        if (viewStub != null) {
            if (getShowCheckbox()) {
                updateCheckboxState((CheckBox) viewStub.inflate(), false);
            } else {
                viewStub.setVisibility(8);
            }
        }
        viewStub = (ViewStub) inflate.findViewById(C0426R.id.com_facebook_picker_profile_pic_stub);
        if (getShowPicture()) {
            ((ImageView) viewStub.inflate()).setVisibility(0);
        } else {
            viewStub.setVisibility(8);
        }
        return inflate;
    }

    boolean filterIncludesItem(T t) {
        return this.filter == null || this.filter.includeItem(t);
    }

    public int getCount() {
        int i = 0;
        if (this.sectionKeys.size() == 0) {
            return 0;
        }
        if (this.displaySections) {
            i = this.sectionKeys.size();
        }
        int i2 = i;
        for (List size : this.graphObjectsBySection.values()) {
            i2 = size.size() + i2;
        }
        if (shouldShowActivityCircleCell()) {
            i2++;
        }
        return i2;
    }

    public GraphObjectCursor<T> getCursor() {
        return this.cursor;
    }

    public DataNeededListener getDataNeededListener() {
        return this.dataNeededListener;
    }

    protected int getDefaultPicture() {
        return C0426R.drawable.com_facebook_profile_default_icon;
    }

    Filter<T> getFilter() {
        return this.filter;
    }

    protected int getGraphObjectRowLayoutId(T t) {
        return C0426R.layout.com_facebook_picker_list_row;
    }

    protected View getGraphObjectView(T t, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = createGraphObjectView(t);
        }
        populateGraphObjectView(view, t);
        return view;
    }

    public List<T> getGraphObjectsById(Collection<String> collection) {
        Set<String> hashSet = new HashSet();
        hashSet.addAll(collection);
        List arrayList = new ArrayList(hashSet.size());
        for (String str : hashSet) {
            GraphObject graphObject = (GraphObject) this.graphObjectsById.get(str);
            if (graphObject != null) {
                arrayList.add(graphObject);
            }
        }
        return arrayList;
    }

    public String getGroupByField() {
        return this.groupByField;
    }

    String getIdOfGraphObject(T t) {
        if (t.asMap().containsKey(ID)) {
            Object property = t.getProperty(ID);
            if (property instanceof String) {
                return (String) property;
            }
        }
        throw new FacebookException("Received an object without an ID.");
    }

    public Object getItem(int i) {
        SectionAndItem sectionAndItem = getSectionAndItem(i);
        return sectionAndItem.getType() == Type.GRAPH_OBJECT ? sectionAndItem.graphObject : null;
    }

    public long getItemId(int i) {
        SectionAndItem sectionAndItem = getSectionAndItem(i);
        if (!(sectionAndItem == null || sectionAndItem.graphObject == null)) {
            String idOfGraphObject = getIdOfGraphObject(sectionAndItem.graphObject);
            if (idOfGraphObject != null) {
                try {
                    return Long.parseLong(idOfGraphObject);
                } catch (NumberFormatException e) {
                }
            }
        }
        return 0;
    }

    public int getItemViewType(int i) {
        switch (getSectionAndItem(i).getType()) {
            case SECTION_HEADER:
                return 0;
            case GRAPH_OBJECT:
                return 1;
            case ACTIVITY_CIRCLE:
                return 2;
            default:
                throw new FacebookException("Unexpected type of section and item.");
        }
    }

    public OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    String getPictureFieldSpecifier() {
        ImageView imageView = (ImageView) createGraphObjectView(null).findViewById(C0426R.id.com_facebook_picker_image);
        if (imageView == null) {
            return null;
        }
        LayoutParams layoutParams = imageView.getLayoutParams();
        return String.format(Locale.US, "picture.height(%d).width(%d)", new Object[]{Integer.valueOf(layoutParams.height), Integer.valueOf(layoutParams.width)});
    }

    protected URI getPictureUriOfGraphObject(T t) {
        String str;
        Object property = t.getProperty(PICTURE);
        if (property instanceof String) {
            str = (String) property;
        } else {
            if (property instanceof JSONObject) {
                ItemPictureData data = ((ItemPicture) Factory.create((JSONObject) property).cast(ItemPicture.class)).getData();
                if (data != null) {
                    str = data.getUrl();
                }
            }
            str = null;
        }
        if (str != null) {
            try {
                return new URI(str);
            } catch (URISyntaxException e) {
            }
        }
        return null;
    }

    int getPosition(String str, T t) {
        int i;
        int i2 = 0;
        int i3 = 0;
        for (String str2 : this.sectionKeys) {
            if (this.displaySections) {
                i3++;
            }
            if (str2.equals(str)) {
                i = 1;
                break;
            }
            i3 = ((ArrayList) this.graphObjectsBySection.get(str2)).size() + i3;
        }
        i = 0;
        if (i == 0) {
            return -1;
        }
        if (t == null) {
            if (this.displaySections) {
                i2 = 1;
            }
            return i3 - i2;
        }
        Iterator it = ((ArrayList) this.graphObjectsBySection.get(str)).iterator();
        while (it.hasNext()) {
            if (Factory.hasSameId((GraphObject) it.next(), t)) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public int getPositionForSection(int i) {
        if (!this.displaySections) {
            return 0;
        }
        int max = Math.max(0, Math.min(i, this.sectionKeys.size() - 1));
        return max < this.sectionKeys.size() ? getPosition((String) this.sectionKeys.get(max), null) : 0;
    }

    SectionAndItem<T> getSectionAndItem(int i) {
        String str = null;
        if (this.sectionKeys.size() == 0) {
            return null;
        }
        GraphObject graphObject;
        String str2;
        List list;
        if (this.displaySections) {
            for (String str22 : this.sectionKeys) {
                int i2 = i - 1;
                if (i == 0) {
                    graphObject = null;
                    str = str22;
                    break;
                }
                list = (List) this.graphObjectsBySection.get(str22);
                if (i2 < list.size()) {
                    graphObject = (GraphObject) list.get(i2);
                    str = str22;
                    break;
                }
                i = i2 - list.size();
            }
            graphObject = null;
        } else {
            str22 = (String) this.sectionKeys.get(0);
            list = (List) this.graphObjectsBySection.get(str22);
            if (i >= 0 && i < list.size()) {
                graphObject = (GraphObject) ((ArrayList) this.graphObjectsBySection.get(str22)).get(i);
                str = str22;
            } else if ($assertionsDisabled || (this.dataNeededListener != null && this.cursor.areMoreObjectsAvailable())) {
                return new SectionAndItem(null, null);
            } else {
                throw new AssertionError();
            }
        }
        if (str != null) {
            return new SectionAndItem(str, graphObject);
        }
        throw new IndexOutOfBoundsException("position");
    }

    public int getSectionForPosition(int i) {
        SectionAndItem sectionAndItem = getSectionAndItem(i);
        return (sectionAndItem == null || sectionAndItem.getType() == Type.ACTIVITY_CIRCLE) ? 0 : Math.max(0, Math.min(this.sectionKeys.indexOf(sectionAndItem.sectionKey), this.sectionKeys.size() - 1));
    }

    protected View getSectionHeaderView(String str, View view, ViewGroup viewGroup) {
        view = (TextView) view;
        View view2 = view == null ? (TextView) this.inflater.inflate(C0426R.layout.com_facebook_picker_list_section_header, null) : view;
        view2.setText(str);
        return view2;
    }

    protected String getSectionKeyOfGraphObject(T t) {
        String str = null;
        if (this.groupByField != null) {
            str = (String) t.getProperty(this.groupByField);
            if (str != null && str.length() > 0) {
                str = str.substring(0, 1).toUpperCase();
            }
        }
        return str != null ? str : "";
    }

    public Object[] getSections() {
        return this.displaySections ? this.sectionKeys.toArray() : new Object[0];
    }

    public boolean getShowCheckbox() {
        return this.showCheckbox;
    }

    public boolean getShowPicture() {
        return this.showPicture;
    }

    public List<String> getSortFields() {
        return this.sortFields;
    }

    protected CharSequence getSubTitleOfGraphObject(T t) {
        return null;
    }

    protected CharSequence getTitleOfGraphObject(T t) {
        return (String) t.getProperty(NAME);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        SectionAndItem sectionAndItem = getSectionAndItem(i);
        switch (sectionAndItem.getType()) {
            case SECTION_HEADER:
                return getSectionHeaderView(sectionAndItem.sectionKey, view, viewGroup);
            case GRAPH_OBJECT:
                return getGraphObjectView(sectionAndItem.graphObject, view, viewGroup);
            case ACTIVITY_CIRCLE:
                if ($assertionsDisabled || (this.cursor.areMoreObjectsAvailable() && this.dataNeededListener != null)) {
                    this.dataNeededListener.onDataNeeded();
                    return getActivityCircleView(view, viewGroup);
                }
                throw new AssertionError();
            default:
                throw new FacebookException("Unexpected type of section and item.");
        }
    }

    public int getViewTypeCount() {
        return 3;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isEmpty() {
        return this.sectionKeys.size() == 0;
    }

    public boolean isEnabled(int i) {
        return getSectionAndItem(i).getType() == Type.GRAPH_OBJECT;
    }

    boolean isGraphObjectSelected(String str) {
        return false;
    }

    protected void populateGraphObjectView(View view, T t) {
        String idOfGraphObject = getIdOfGraphObject(t);
        view.setTag(idOfGraphObject);
        CharSequence titleOfGraphObject = getTitleOfGraphObject(t);
        TextView textView = (TextView) view.findViewById(C0426R.id.com_facebook_picker_title);
        if (textView != null) {
            textView.setText(titleOfGraphObject, BufferType.SPANNABLE);
        }
        titleOfGraphObject = getSubTitleOfGraphObject(t);
        textView = (TextView) view.findViewById(C0426R.id.picker_subtitle);
        if (textView != null) {
            if (titleOfGraphObject != null) {
                textView.setText(titleOfGraphObject, BufferType.SPANNABLE);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
        if (getShowCheckbox()) {
            updateCheckboxState((CheckBox) view.findViewById(C0426R.id.com_facebook_picker_checkbox), isGraphObjectSelected(idOfGraphObject));
        }
        if (getShowPicture()) {
            URI pictureUriOfGraphObject = getPictureUriOfGraphObject(t);
            if (pictureUriOfGraphObject != null) {
                ImageView imageView = (ImageView) view.findViewById(C0426R.id.com_facebook_picker_image);
                if (this.prefetchedPictureCache.containsKey(idOfGraphObject)) {
                    ImageResponse imageResponse = (ImageResponse) this.prefetchedPictureCache.get(idOfGraphObject);
                    imageView.setImageBitmap(imageResponse.getBitmap());
                    imageView.setTag(imageResponse.getRequest().getImageUri());
                    return;
                }
                downloadProfilePicture(idOfGraphObject, pictureUriOfGraphObject, imageView);
            }
        }
    }

    public void prioritizeViewRange(int i, int i2, int i3) {
        if (i2 >= i && this.sectionKeys.size() != 0) {
            int i4;
            int max;
            SectionAndItem sectionAndItem;
            for (i4 = i2; i4 >= 0; i4--) {
                SectionAndItem sectionAndItem2 = getSectionAndItem(i4);
                if (sectionAndItem2.graphObject != null) {
                    ImageRequest imageRequest = (ImageRequest) this.pendingRequests.get(getIdOfGraphObject(sectionAndItem2.graphObject));
                    if (imageRequest != null) {
                        ImageDownloader.prioritizeRequest(imageRequest);
                    }
                }
            }
            i4 = Math.min(i2 + i3, getCount() - 1);
            ArrayList arrayList = new ArrayList();
            for (max = Math.max(0, i - i3); max < i; max++) {
                sectionAndItem = getSectionAndItem(max);
                if (sectionAndItem.graphObject != null) {
                    arrayList.add(sectionAndItem.graphObject);
                }
            }
            for (max = i2 + 1; max <= i4; max++) {
                sectionAndItem = getSectionAndItem(max);
                if (sectionAndItem.graphObject != null) {
                    arrayList.add(sectionAndItem.graphObject);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GraphObject graphObject = (GraphObject) it.next();
                URI pictureUriOfGraphObject = getPictureUriOfGraphObject(graphObject);
                String idOfGraphObject = getIdOfGraphObject(graphObject);
                boolean remove = this.prefetchedProfilePictureIds.remove(idOfGraphObject);
                this.prefetchedProfilePictureIds.add(idOfGraphObject);
                if (!remove) {
                    downloadProfilePicture(idOfGraphObject, pictureUriOfGraphObject, null);
                }
            }
        }
    }

    public void rebuildAndNotify() {
        rebuildSections();
        notifyDataSetChanged();
    }

    public void setDataNeededListener(DataNeededListener dataNeededListener) {
        this.dataNeededListener = dataNeededListener;
    }

    void setFilter(Filter<T> filter) {
        this.filter = filter;
    }

    public void setGroupByField(String str) {
        this.groupByField = str;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.onErrorListener = onErrorListener;
    }

    public void setShowCheckbox(boolean z) {
        this.showCheckbox = z;
    }

    public void setShowPicture(boolean z) {
        this.showPicture = z;
    }

    public void setSortFields(List<String> list) {
        this.sortFields = list;
    }

    void updateCheckboxState(CheckBox checkBox, boolean z) {
    }
}
