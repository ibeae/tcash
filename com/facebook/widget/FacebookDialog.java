package com.facebook.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import com.amobee.richmedia.view.AmobeeView;
import com.facebook.AppEventsLogger;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphObjectException;
import com.facebook.NativeAppCallAttachmentStore;
import com.facebook.NativeAppCallContentProvider;
import com.facebook.Settings;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.DialogFeatureConfig;
import com.facebook.internal.Validate;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObject.Factory;
import com.facebook.model.GraphObjectList;
import com.facebook.model.OpenGraphAction;
import com.facebook.model.OpenGraphObject;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public class FacebookDialog {
    public static final String COMPLETION_GESTURE_CANCEL = "cancel";
    private static final String EXTRA_DIALOG_COMPLETE_KEY = "com.facebook.platform.extra.DID_COMPLETE";
    private static final String EXTRA_DIALOG_COMPLETION_GESTURE_KEY = "com.facebook.platform.extra.COMPLETION_GESTURE";
    private static final String EXTRA_DIALOG_COMPLETION_ID_KEY = "com.facebook.platform.extra.POST_ID";
    private static NativeAppCallAttachmentStore attachmentStore;
    private Activity activity;
    private PendingCall appCall;
    private Fragment fragment;
    private OnPresentCallback onPresentCallback;

    public interface Callback {
        void onComplete(PendingCall pendingCall, Bundle bundle);

        void onError(PendingCall pendingCall, Exception exception, Bundle bundle);
    }

    public static abstract class Builder<CONCRETE extends Builder<?>> {
        protected final Activity activity;
        protected final PendingCall appCall;
        protected final String applicationId;
        protected String applicationName;
        protected Fragment fragment;
        protected HashMap<String, File> imageAttachmentFiles = new HashMap();
        protected HashMap<String, Bitmap> imageAttachments = new HashMap();

        class C04641 implements OnPresentCallback {
            C04641() {
            }

            public void onPresent(Context context) {
                if (Builder.this.imageAttachments != null && Builder.this.imageAttachments.size() > 0) {
                    FacebookDialog.getAttachmentStore().addAttachmentsForCall(context, Builder.this.appCall.getCallId(), Builder.this.imageAttachments);
                }
                if (Builder.this.imageAttachmentFiles != null && Builder.this.imageAttachmentFiles.size() > 0) {
                    FacebookDialog.getAttachmentStore().addAttachmentFilesForCall(context, Builder.this.appCall.getCallId(), Builder.this.imageAttachmentFiles);
                }
            }
        }

        public Builder(Activity activity) {
            Validate.notNull(activity, "activity");
            this.activity = activity;
            this.applicationId = Utility.getMetadataApplicationId(activity);
            this.appCall = new PendingCall((int) NativeProtocol.DIALOG_REQUEST_CODE);
        }

        protected CONCRETE addImageAttachment(String str, Bitmap bitmap) {
            this.imageAttachments.put(str, bitmap);
            return this;
        }

        protected CONCRETE addImageAttachment(String str, File file) {
            this.imageAttachmentFiles.put(str, file);
            return this;
        }

        protected List<String> addImageAttachmentFiles(Collection<File> collection) {
            List arrayList = new ArrayList();
            for (File file : collection) {
                String uuid = UUID.randomUUID().toString();
                addImageAttachment(uuid, file);
                arrayList.add(NativeAppCallContentProvider.getAttachmentUrl(this.applicationId, this.appCall.getCallId(), uuid));
            }
            return arrayList;
        }

        protected List<String> addImageAttachments(Collection<Bitmap> collection) {
            List arrayList = new ArrayList();
            for (Bitmap bitmap : collection) {
                String uuid = UUID.randomUUID().toString();
                addImageAttachment(uuid, bitmap);
                arrayList.add(NativeAppCallContentProvider.getAttachmentUrl(this.applicationId, this.appCall.getCallId(), uuid));
            }
            return arrayList;
        }

        public FacebookDialog build() {
            validate();
            String access$100 = FacebookDialog.getActionForFeatures(getDialogFeatures());
            int access$300 = FacebookDialog.getProtocolVersionForNativeDialog(this.activity, access$100, FacebookDialog.getVersionSpecForFeatures(this.applicationId, access$100, getDialogFeatures()));
            Bundle methodArguments = NativeProtocol.isVersionCompatibleWithBucketedIntent(access$300) ? getMethodArguments() : setBundleExtras(new Bundle());
            Intent createPlatformActivityIntent = NativeProtocol.createPlatformActivityIntent(this.activity, this.appCall.getCallId().toString(), access$100, access$300, this.applicationName, methodArguments);
            if (createPlatformActivityIntent == null) {
                FacebookDialog.logDialogActivity(this.activity, this.fragment, FacebookDialog.getEventName(access$100, methodArguments.containsKey(NativeProtocol.EXTRA_PHOTOS)), AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED);
                throw new FacebookException("Unable to create Intent; this likely means the Facebook app is not installed.");
            }
            this.appCall.setRequestIntent(createPlatformActivityIntent);
            return new FacebookDialog(this.activity, this.fragment, this.appCall, getOnPresentCallback());
        }

        public boolean canPresent() {
            return FacebookDialog.handleCanPresent(this.activity, getDialogFeatures());
        }

        protected abstract EnumSet<? extends DialogFeature> getDialogFeatures();

        List<String> getImageAttachmentNames() {
            return new ArrayList(this.imageAttachments.keySet());
        }

        protected abstract Bundle getMethodArguments();

        OnPresentCallback getOnPresentCallback() {
            return new C04641();
        }

        protected String getWebFallbackUrlInternal() {
            String name;
            String action;
            Iterator it = getDialogFeatures().iterator();
            if (it.hasNext()) {
                DialogFeature dialogFeature = (DialogFeature) it.next();
                name = dialogFeature.name();
                action = dialogFeature.getAction();
            } else {
                action = null;
                name = null;
            }
            DialogFeatureConfig dialogFeatureConfig = Utility.getDialogFeatureConfig(this.applicationId, action, name);
            if (dialogFeatureConfig == null) {
                return null;
            }
            Uri fallbackUrl = dialogFeatureConfig.getFallbackUrl();
            if (fallbackUrl == null) {
                return null;
            }
            Bundle methodArguments = getMethodArguments();
            methodArguments = ServerProtocol.getQueryParamsForPlatformActivityIntentWebFallback(this.activity, this.appCall.getCallId().toString(), NativeProtocol.getLatestKnownVersion(), this.applicationName, methodArguments);
            if (methodArguments == null) {
                return null;
            }
            if (fallbackUrl.isRelative()) {
                fallbackUrl = Utility.buildUri(ServerProtocol.getDialogAuthority(), fallbackUrl.toString(), methodArguments);
            }
            return fallbackUrl.toString();
        }

        protected void putExtra(Bundle bundle, String str, String str2) {
            if (str2 != null) {
                bundle.putString(str, str2);
            }
        }

        public CONCRETE setApplicationName(String str) {
            this.applicationName = str;
            return this;
        }

        protected Bundle setBundleExtras(Bundle bundle) {
            return bundle;
        }

        public CONCRETE setFragment(Fragment fragment) {
            this.fragment = fragment;
            return this;
        }

        public CONCRETE setRequestCode(int i) {
            this.appCall.setRequestCode(i);
            return this;
        }

        void validate() {
        }
    }

    public interface DialogFeature {
        String getAction();

        int getMinVersion();

        String name();
    }

    interface OnPresentCallback {
        void onPresent(Context context);
    }

    private static abstract class ShareDialogBuilderBase<CONCRETE extends ShareDialogBuilderBase<?>> extends Builder<CONCRETE> {
        private String caption;
        private boolean dataErrorsFatal;
        private String description;
        private ArrayList<String> friends;
        protected String link;
        private String name;
        private String picture;
        private String place;
        private String ref;

        public ShareDialogBuilderBase(Activity activity) {
            super(activity);
        }

        protected Bundle getMethodArguments() {
            Bundle bundle = new Bundle();
            putExtra(bundle, NativeProtocol.METHOD_ARGS_TITLE, this.name);
            putExtra(bundle, NativeProtocol.METHOD_ARGS_SUBTITLE, this.caption);
            putExtra(bundle, NativeProtocol.METHOD_ARGS_DESCRIPTION, this.description);
            putExtra(bundle, NativeProtocol.METHOD_ARGS_LINK, this.link);
            putExtra(bundle, NativeProtocol.METHOD_ARGS_IMAGE, this.picture);
            putExtra(bundle, NativeProtocol.METHOD_ARGS_PLACE_TAG, this.place);
            putExtra(bundle, NativeProtocol.METHOD_ARGS_TITLE, this.name);
            putExtra(bundle, NativeProtocol.METHOD_ARGS_REF, this.ref);
            bundle.putBoolean(NativeProtocol.METHOD_ARGS_DATA_FAILURES_FATAL, this.dataErrorsFatal);
            if (!Utility.isNullOrEmpty(this.friends)) {
                bundle.putStringArrayList(NativeProtocol.METHOD_ARGS_FRIEND_TAGS, this.friends);
            }
            return bundle;
        }

        protected Bundle setBundleExtras(Bundle bundle) {
            putExtra(bundle, NativeProtocol.EXTRA_APPLICATION_ID, this.applicationId);
            putExtra(bundle, NativeProtocol.EXTRA_APPLICATION_NAME, this.applicationName);
            putExtra(bundle, NativeProtocol.EXTRA_TITLE, this.name);
            putExtra(bundle, NativeProtocol.EXTRA_SUBTITLE, this.caption);
            putExtra(bundle, NativeProtocol.EXTRA_DESCRIPTION, this.description);
            putExtra(bundle, NativeProtocol.EXTRA_LINK, this.link);
            putExtra(bundle, NativeProtocol.EXTRA_IMAGE, this.picture);
            putExtra(bundle, NativeProtocol.EXTRA_PLACE_TAG, this.place);
            putExtra(bundle, NativeProtocol.EXTRA_TITLE, this.name);
            putExtra(bundle, NativeProtocol.EXTRA_REF, this.ref);
            bundle.putBoolean(NativeProtocol.EXTRA_DATA_FAILURES_FATAL, this.dataErrorsFatal);
            if (!Utility.isNullOrEmpty(this.friends)) {
                bundle.putStringArrayList(NativeProtocol.EXTRA_FRIEND_TAGS, this.friends);
            }
            return bundle;
        }

        public CONCRETE setCaption(String str) {
            this.caption = str;
            return this;
        }

        public CONCRETE setDataErrorsFatal(boolean z) {
            this.dataErrorsFatal = z;
            return this;
        }

        public CONCRETE setDescription(String str) {
            this.description = str;
            return this;
        }

        public CONCRETE setFriends(List<String> list) {
            this.friends = new ArrayList(list);
            return this;
        }

        public CONCRETE setLink(String str) {
            this.link = str;
            return this;
        }

        public CONCRETE setName(String str) {
            this.name = str;
            return this;
        }

        public CONCRETE setPicture(String str) {
            this.picture = str;
            return this;
        }

        public CONCRETE setPlace(String str) {
            this.place = str;
            return this;
        }

        public CONCRETE setRef(String str) {
            this.ref = str;
            return this;
        }
    }

    public static class MessageDialogBuilder extends ShareDialogBuilderBase<MessageDialogBuilder> {
        public MessageDialogBuilder(Activity activity) {
            super(activity);
        }

        protected EnumSet<? extends DialogFeature> getDialogFeatures() {
            return EnumSet.of(MessageDialogFeature.MESSAGE_DIALOG);
        }

        public MessageDialogBuilder setFriends(List<String> list) {
            return this;
        }

        public MessageDialogBuilder setPlace(String str) {
            return this;
        }
    }

    public enum MessageDialogFeature implements DialogFeature {
        MESSAGE_DIALOG(NativeProtocol.PROTOCOL_VERSION_20140204),
        PHOTOS(NativeProtocol.PROTOCOL_VERSION_20140324);
        
        private int minVersion;

        private MessageDialogFeature(int i) {
            this.minVersion = i;
        }

        public String getAction() {
            return NativeProtocol.ACTION_MESSAGE_DIALOG;
        }

        public int getMinVersion() {
            return this.minVersion;
        }
    }

    private static abstract class OpenGraphDialogBuilderBase<CONCRETE extends OpenGraphDialogBuilderBase<?>> extends Builder<CONCRETE> {
        private OpenGraphAction action;
        private String actionType;
        private boolean dataErrorsFatal;
        private String previewPropertyName;

        public OpenGraphDialogBuilderBase(Activity activity, OpenGraphAction openGraphAction, String str) {
            super(activity);
            Validate.notNull(openGraphAction, AmobeeView.ACTION_KEY);
            Validate.notNullOrEmpty(openGraphAction.getType(), "action.getType()");
            Validate.notNullOrEmpty(str, "previewPropertyName");
            if (openGraphAction.getProperty(str) == null) {
                throw new IllegalArgumentException("A property named \"" + str + "\" was not found on the action.  The name of the preview property must match the name of an action property.");
            }
            this.action = openGraphAction;
            this.actionType = openGraphAction.getType();
            this.previewPropertyName = str;
        }

        @Deprecated
        public OpenGraphDialogBuilderBase(Activity activity, OpenGraphAction openGraphAction, String str, String str2) {
            super(activity);
            Validate.notNull(openGraphAction, AmobeeView.ACTION_KEY);
            Validate.notNullOrEmpty(str, "actionType");
            Validate.notNullOrEmpty(str2, "previewPropertyName");
            if (openGraphAction.getProperty(str2) == null) {
                throw new IllegalArgumentException("A property named \"" + str2 + "\" was not found on the action.  The name of the preview property must match the name of an action property.");
            }
            String type = openGraphAction.getType();
            if (Utility.isNullOrEmpty(type) || type.equals(str)) {
                this.action = openGraphAction;
                this.actionType = str;
                this.previewPropertyName = str2;
                return;
            }
            throw new IllegalArgumentException("'actionType' must match the type of 'action' if it is specified. Consider using OpenGraphDialogBuilderBase(Activity activity, OpenGraphAction action, String previewPropertyName) instead.");
        }

        private JSONObject flattenChildrenOfGraphObject(JSONObject jSONObject) {
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                Iterator keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    if (!str.equalsIgnoreCase("image")) {
                        jSONObject2.put(str, flattenObject(jSONObject2.get(str)));
                    }
                }
                return jSONObject2;
            } catch (Throwable e) {
                throw new FacebookException(e);
            }
        }

        private Object flattenObject(Object obj) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                return !jSONObject.optBoolean(NativeProtocol.OPEN_GRAPH_CREATE_OBJECT_KEY) ? jSONObject.has("id") ? jSONObject.getString("id") : jSONObject.has(NativeProtocol.IMAGE_URL_KEY) ? jSONObject.getString(NativeProtocol.IMAGE_URL_KEY) : obj : obj;
            } else if (!(obj instanceof JSONArray)) {
                return obj;
            } else {
                JSONArray jSONArray = (JSONArray) obj;
                JSONArray jSONArray2 = new JSONArray();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    jSONArray2.put(flattenObject(jSONArray.get(i)));
                }
                return jSONArray2;
            }
        }

        private void updateActionAttachmentUrls(List<String> list, boolean z) {
            List image = this.action.getImage();
            List arrayList = image == null ? new ArrayList(list.size()) : image;
            for (String str : list) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(NativeProtocol.IMAGE_URL_KEY, str);
                    if (z) {
                        jSONObject.put(NativeProtocol.IMAGE_USER_GENERATED_KEY, true);
                    }
                    arrayList.add(jSONObject);
                } catch (Throwable e) {
                    throw new FacebookException("Unable to attach images", e);
                }
            }
            this.action.setImage(arrayList);
        }

        protected Bundle getMethodArguments() {
            Bundle bundle = new Bundle();
            putExtra(bundle, NativeProtocol.METHOD_ARGS_PREVIEW_PROPERTY_NAME, this.previewPropertyName);
            putExtra(bundle, NativeProtocol.METHOD_ARGS_ACTION_TYPE, this.actionType);
            bundle.putBoolean(NativeProtocol.METHOD_ARGS_DATA_FAILURES_FATAL, this.dataErrorsFatal);
            putExtra(bundle, NativeProtocol.METHOD_ARGS_ACTION, flattenChildrenOfGraphObject(this.action.getInnerJSONObject()).toString());
            return bundle;
        }

        protected Bundle setBundleExtras(Bundle bundle) {
            putExtra(bundle, NativeProtocol.EXTRA_PREVIEW_PROPERTY_NAME, this.previewPropertyName);
            putExtra(bundle, NativeProtocol.EXTRA_ACTION_TYPE, this.actionType);
            bundle.putBoolean(NativeProtocol.EXTRA_DATA_FAILURES_FATAL, this.dataErrorsFatal);
            putExtra(bundle, NativeProtocol.EXTRA_ACTION, flattenChildrenOfGraphObject(this.action.getInnerJSONObject()).toString());
            return bundle;
        }

        public CONCRETE setDataErrorsFatal(boolean z) {
            this.dataErrorsFatal = z;
            return this;
        }

        public CONCRETE setImageAttachmentFilesForAction(List<File> list) {
            return setImageAttachmentFilesForAction(list, false);
        }

        public CONCRETE setImageAttachmentFilesForAction(List<File> list, boolean z) {
            Validate.containsNoNulls(list, "bitmapFiles");
            if (this.action == null) {
                throw new FacebookException("Can not set attachments prior to setting action.");
            }
            updateActionAttachmentUrls(addImageAttachmentFiles(list), z);
            return this;
        }

        public CONCRETE setImageAttachmentFilesForObject(String str, List<File> list) {
            return setImageAttachmentFilesForObject(str, list, false);
        }

        public CONCRETE setImageAttachmentFilesForObject(String str, List<File> list, boolean z) {
            Validate.notNull(str, "objectProperty");
            Validate.containsNoNulls(list, "bitmapFiles");
            if (this.action == null) {
                throw new FacebookException("Can not set attachments prior to setting action.");
            }
            updateObjectAttachmentUrls(str, addImageAttachmentFiles(list), z);
            return this;
        }

        public CONCRETE setImageAttachmentsForAction(List<Bitmap> list) {
            return setImageAttachmentsForAction(list, false);
        }

        public CONCRETE setImageAttachmentsForAction(List<Bitmap> list, boolean z) {
            Validate.containsNoNulls(list, "bitmaps");
            if (this.action == null) {
                throw new FacebookException("Can not set attachments prior to setting action.");
            }
            updateActionAttachmentUrls(addImageAttachments(list), z);
            return this;
        }

        public CONCRETE setImageAttachmentsForObject(String str, List<Bitmap> list) {
            return setImageAttachmentsForObject(str, list, false);
        }

        public CONCRETE setImageAttachmentsForObject(String str, List<Bitmap> list, boolean z) {
            Validate.notNull(str, "objectProperty");
            Validate.containsNoNulls(list, "bitmaps");
            if (this.action == null) {
                throw new FacebookException("Can not set attachments prior to setting action.");
            }
            updateObjectAttachmentUrls(str, addImageAttachments(list), z);
            return this;
        }

        void updateObjectAttachmentUrls(String str, List<String> list, boolean z) {
            try {
                OpenGraphObject openGraphObject = (OpenGraphObject) this.action.getPropertyAs(str, OpenGraphObject.class);
                if (openGraphObject == null) {
                    throw new IllegalArgumentException("Action does not contain a property '" + str + "'");
                } else if (openGraphObject.getCreateObject()) {
                    GraphObjectList image = openGraphObject.getImage();
                    GraphObjectList createList = image == null ? Factory.createList(GraphObject.class) : image;
                    for (String str2 : list) {
                        GraphObject create = Factory.create();
                        create.setProperty(NativeProtocol.IMAGE_URL_KEY, str2);
                        if (z) {
                            create.setProperty(NativeProtocol.IMAGE_USER_GENERATED_KEY, Boolean.valueOf(true));
                        }
                        createList.add(create);
                    }
                    openGraphObject.setImage(createList);
                } else {
                    throw new IllegalArgumentException("The Open Graph object in '" + str + "' is not marked for creation");
                }
            } catch (FacebookGraphObjectException e) {
                throw new IllegalArgumentException("Property '" + str + "' is not a graph object");
            }
        }
    }

    public static class OpenGraphActionDialogBuilder extends OpenGraphDialogBuilderBase<OpenGraphActionDialogBuilder> {
        public OpenGraphActionDialogBuilder(Activity activity, OpenGraphAction openGraphAction, String str) {
            super(activity, openGraphAction, str);
        }

        @Deprecated
        public OpenGraphActionDialogBuilder(Activity activity, OpenGraphAction openGraphAction, String str, String str2) {
            super(activity, openGraphAction, str, str2);
        }

        protected EnumSet<? extends DialogFeature> getDialogFeatures() {
            return EnumSet.of(OpenGraphActionDialogFeature.OG_ACTION_DIALOG);
        }
    }

    public enum OpenGraphActionDialogFeature implements DialogFeature {
        OG_ACTION_DIALOG(NativeProtocol.PROTOCOL_VERSION_20130618);
        
        private int minVersion;

        private OpenGraphActionDialogFeature(int i) {
            this.minVersion = i;
        }

        public String getAction() {
            return NativeProtocol.ACTION_OGACTIONPUBLISH_DIALOG;
        }

        public int getMinVersion() {
            return this.minVersion;
        }
    }

    public static class OpenGraphMessageDialogBuilder extends OpenGraphDialogBuilderBase<OpenGraphMessageDialogBuilder> {
        public OpenGraphMessageDialogBuilder(Activity activity, OpenGraphAction openGraphAction, String str) {
            super(activity, openGraphAction, str);
        }

        protected EnumSet<? extends DialogFeature> getDialogFeatures() {
            return EnumSet.of(OpenGraphMessageDialogFeature.OG_MESSAGE_DIALOG);
        }
    }

    public enum OpenGraphMessageDialogFeature implements DialogFeature {
        OG_MESSAGE_DIALOG(NativeProtocol.PROTOCOL_VERSION_20140204);
        
        private int minVersion;

        private OpenGraphMessageDialogFeature(int i) {
            this.minVersion = i;
        }

        public String getAction() {
            return NativeProtocol.ACTION_OGMESSAGEPUBLISH_DIALOG;
        }

        public int getMinVersion() {
            return this.minVersion;
        }
    }

    public static class PendingCall implements Parcelable {
        public static final Creator<PendingCall> CREATOR = new C04651();
        private UUID callId;
        private int requestCode;
        private Intent requestIntent;

        static class C04651 implements Creator<PendingCall> {
            C04651() {
            }

            public PendingCall createFromParcel(Parcel parcel) {
                return new PendingCall(parcel);
            }

            public PendingCall[] newArray(int i) {
                return new PendingCall[i];
            }
        }

        public PendingCall(int i) {
            this.callId = UUID.randomUUID();
            this.requestCode = i;
        }

        private PendingCall(Parcel parcel) {
            this.callId = UUID.fromString(parcel.readString());
            this.requestIntent = (Intent) parcel.readParcelable(null);
            this.requestCode = parcel.readInt();
        }

        private void setRequestCode(int i) {
            this.requestCode = i;
        }

        private void setRequestIntent(Intent intent) {
            this.requestIntent = intent;
        }

        public int describeContents() {
            return 0;
        }

        public UUID getCallId() {
            return this.callId;
        }

        public int getRequestCode() {
            return this.requestCode;
        }

        public Intent getRequestIntent() {
            return this.requestIntent;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.callId.toString());
            parcel.writeParcelable(this.requestIntent, 0);
            parcel.writeInt(this.requestCode);
        }
    }

    private static abstract class PhotoDialogBuilderBase<CONCRETE extends PhotoDialogBuilderBase<?>> extends Builder<CONCRETE> {
        static int MAXIMUM_PHOTO_COUNT = 6;
        private ArrayList<String> friends;
        private ArrayList<String> imageAttachmentUrls = new ArrayList();
        private String place;

        public PhotoDialogBuilderBase(Activity activity) {
            super(activity);
        }

        public CONCRETE addPhotoFiles(Collection<File> collection) {
            this.imageAttachmentUrls.addAll(addImageAttachmentFiles(collection));
            return this;
        }

        public CONCRETE addPhotos(Collection<Bitmap> collection) {
            this.imageAttachmentUrls.addAll(addImageAttachments(collection));
            return this;
        }

        abstract int getMaximumNumberOfPhotos();

        protected Bundle getMethodArguments() {
            Bundle bundle = new Bundle();
            putExtra(bundle, NativeProtocol.METHOD_ARGS_PLACE_TAG, this.place);
            bundle.putStringArrayList(NativeProtocol.METHOD_ARGS_PHOTOS, this.imageAttachmentUrls);
            if (!Utility.isNullOrEmpty(this.friends)) {
                bundle.putStringArrayList(NativeProtocol.METHOD_ARGS_FRIEND_TAGS, this.friends);
            }
            return bundle;
        }

        protected Bundle setBundleExtras(Bundle bundle) {
            putExtra(bundle, NativeProtocol.EXTRA_APPLICATION_ID, this.applicationId);
            putExtra(bundle, NativeProtocol.EXTRA_APPLICATION_NAME, this.applicationName);
            putExtra(bundle, NativeProtocol.EXTRA_PLACE_TAG, this.place);
            bundle.putStringArrayList(NativeProtocol.EXTRA_PHOTOS, this.imageAttachmentUrls);
            if (!Utility.isNullOrEmpty(this.friends)) {
                bundle.putStringArrayList(NativeProtocol.EXTRA_FRIEND_TAGS, this.friends);
            }
            return bundle;
        }

        public CONCRETE setFriends(List<String> list) {
            this.friends = new ArrayList(list);
            return this;
        }

        public CONCRETE setPlace(String str) {
            this.place = str;
            return this;
        }

        void validate() {
            super.validate();
            if (this.imageAttachmentUrls.isEmpty()) {
                throw new FacebookException("Must specify at least one photo.");
            } else if (this.imageAttachmentUrls.size() > getMaximumNumberOfPhotos()) {
                throw new FacebookException(String.format("Cannot add more than %d photos.", new Object[]{Integer.valueOf(getMaximumNumberOfPhotos())}));
            }
        }
    }

    public static class PhotoMessageDialogBuilder extends PhotoDialogBuilderBase<PhotoMessageDialogBuilder> {
        public PhotoMessageDialogBuilder(Activity activity) {
            super(activity);
        }

        protected EnumSet<? extends DialogFeature> getDialogFeatures() {
            return EnumSet.of(MessageDialogFeature.MESSAGE_DIALOG, MessageDialogFeature.PHOTOS);
        }

        int getMaximumNumberOfPhotos() {
            return MAXIMUM_PHOTO_COUNT;
        }

        public PhotoMessageDialogBuilder setFriends(List<String> list) {
            return this;
        }

        public PhotoMessageDialogBuilder setPlace(String str) {
            return this;
        }
    }

    public static class PhotoShareDialogBuilder extends PhotoDialogBuilderBase<PhotoShareDialogBuilder> {
        public PhotoShareDialogBuilder(Activity activity) {
            super(activity);
        }

        protected EnumSet<? extends DialogFeature> getDialogFeatures() {
            return EnumSet.of(ShareDialogFeature.SHARE_DIALOG, ShareDialogFeature.PHOTOS);
        }

        int getMaximumNumberOfPhotos() {
            return MAXIMUM_PHOTO_COUNT;
        }
    }

    public static class ShareDialogBuilder extends ShareDialogBuilderBase<ShareDialogBuilder> {
        public ShareDialogBuilder(Activity activity) {
            super(activity);
        }

        protected EnumSet<? extends DialogFeature> getDialogFeatures() {
            return EnumSet.of(ShareDialogFeature.SHARE_DIALOG);
        }
    }

    public enum ShareDialogFeature implements DialogFeature {
        SHARE_DIALOG(NativeProtocol.PROTOCOL_VERSION_20130618),
        PHOTOS(NativeProtocol.PROTOCOL_VERSION_20140204);
        
        private int minVersion;

        private ShareDialogFeature(int i) {
            this.minVersion = i;
        }

        public String getAction() {
            return NativeProtocol.ACTION_FEED_DIALOG;
        }

        public int getMinVersion() {
            return this.minVersion;
        }
    }

    private FacebookDialog(Activity activity, Fragment fragment, PendingCall pendingCall, OnPresentCallback onPresentCallback) {
        this.activity = activity;
        this.fragment = fragment;
        this.appCall = pendingCall;
        this.onPresentCallback = onPresentCallback;
    }

    public static boolean canPresentMessageDialog(Context context, MessageDialogFeature... messageDialogFeatureArr) {
        return handleCanPresent(context, EnumSet.of(MessageDialogFeature.MESSAGE_DIALOG, messageDialogFeatureArr));
    }

    public static boolean canPresentOpenGraphActionDialog(Context context, OpenGraphActionDialogFeature... openGraphActionDialogFeatureArr) {
        return handleCanPresent(context, EnumSet.of(OpenGraphActionDialogFeature.OG_ACTION_DIALOG, openGraphActionDialogFeatureArr));
    }

    public static boolean canPresentOpenGraphMessageDialog(Context context, OpenGraphMessageDialogFeature... openGraphMessageDialogFeatureArr) {
        return handleCanPresent(context, EnumSet.of(OpenGraphMessageDialogFeature.OG_MESSAGE_DIALOG, openGraphMessageDialogFeatureArr));
    }

    public static boolean canPresentShareDialog(Context context, ShareDialogFeature... shareDialogFeatureArr) {
        return handleCanPresent(context, EnumSet.of(ShareDialogFeature.SHARE_DIALOG, shareDialogFeatureArr));
    }

    private static String getActionForFeatures(Iterable<? extends DialogFeature> iterable) {
        Iterator it = iterable.iterator();
        return it.hasNext() ? ((DialogFeature) it.next()).getAction() : null;
    }

    private static NativeAppCallAttachmentStore getAttachmentStore() {
        if (attachmentStore == null) {
            attachmentStore = new NativeAppCallAttachmentStore();
        }
        return attachmentStore;
    }

    private static String getEventName(Intent intent) {
        return getEventName(intent.getStringExtra(NativeProtocol.EXTRA_PROTOCOL_ACTION), intent.hasExtra(NativeProtocol.EXTRA_PHOTOS));
    }

    private static String getEventName(String str, boolean z) {
        if (str.equals(NativeProtocol.ACTION_FEED_DIALOG)) {
            return z ? AnalyticsEvents.EVENT_NATIVE_DIALOG_TYPE_PHOTO_SHARE : AnalyticsEvents.EVENT_NATIVE_DIALOG_TYPE_SHARE;
        } else {
            if (str.equals(NativeProtocol.ACTION_MESSAGE_DIALOG)) {
                return z ? AnalyticsEvents.EVENT_NATIVE_DIALOG_TYPE_PHOTO_MESSAGE : AnalyticsEvents.EVENT_NATIVE_DIALOG_TYPE_MESSAGE;
            } else {
                if (str.equals(NativeProtocol.ACTION_OGACTIONPUBLISH_DIALOG)) {
                    return AnalyticsEvents.EVENT_NATIVE_DIALOG_TYPE_OG_SHARE;
                }
                if (str.equals(NativeProtocol.ACTION_OGMESSAGEPUBLISH_DIALOG)) {
                    return AnalyticsEvents.EVENT_NATIVE_DIALOG_TYPE_OG_MESSAGE;
                }
                if (str.equals(NativeProtocol.ACTION_LIKE_DIALOG)) {
                    return AnalyticsEvents.EVENT_NATIVE_DIALOG_TYPE_LIKE;
                }
                throw new FacebookException("An unspecified action was presented");
            }
        }
    }

    public static String getNativeDialogCompletionGesture(Bundle bundle) {
        return bundle.getString(EXTRA_DIALOG_COMPLETION_GESTURE_KEY);
    }

    public static boolean getNativeDialogDidComplete(Bundle bundle) {
        return bundle.getBoolean(EXTRA_DIALOG_COMPLETE_KEY, false);
    }

    public static String getNativeDialogPostId(Bundle bundle) {
        return bundle.getString(EXTRA_DIALOG_COMPLETION_ID_KEY);
    }

    private static int getProtocolVersionForNativeDialog(Context context, String str, int[] iArr) {
        return NativeProtocol.getLatestAvailableProtocolVersionForAction(context, str, iArr);
    }

    private static int[] getVersionSpecForFeature(String str, String str2, DialogFeature dialogFeature) {
        DialogFeatureConfig dialogFeatureConfig = Utility.getDialogFeatureConfig(str, str2, dialogFeature.name());
        if (dialogFeatureConfig != null) {
            return dialogFeatureConfig.getVersionSpec();
        }
        return new int[]{dialogFeature.getMinVersion()};
    }

    private static int[] getVersionSpecForFeatures(String str, String str2, Iterable<? extends DialogFeature> iterable) {
        int[] iArr = null;
        for (DialogFeature versionSpecForFeature : iterable) {
            iArr = Utility.intersectRanges(iArr, getVersionSpecForFeature(str, str2, versionSpecForFeature));
        }
        return iArr;
    }

    public static boolean handleActivityResult(Context context, PendingCall pendingCall, int i, Intent intent, Callback callback) {
        if (i != pendingCall.getRequestCode()) {
            return false;
        }
        if (attachmentStore != null) {
            attachmentStore.cleanupAttachmentsForCall(context, pendingCall.getCallId());
        }
        if (callback != null) {
            if (NativeProtocol.isErrorResult(intent)) {
                Bundle errorDataFromResultIntent = NativeProtocol.getErrorDataFromResultIntent(intent);
                callback.onError(pendingCall, NativeProtocol.getExceptionFromErrorData(errorDataFromResultIntent), errorDataFromResultIntent);
            } else {
                callback.onComplete(pendingCall, NativeProtocol.getSuccessResultsFromIntent(intent));
            }
        }
        return true;
    }

    private static boolean handleCanPresent(Context context, Iterable<? extends DialogFeature> iterable) {
        String actionForFeatures = getActionForFeatures(iterable);
        String applicationId = Settings.getApplicationId();
        if (Utility.isNullOrEmpty(applicationId)) {
            applicationId = Utility.getMetadataApplicationId(context);
        }
        return getProtocolVersionForNativeDialog(context, actionForFeatures, getVersionSpecForFeatures(applicationId, actionForFeatures, iterable)) != -1;
    }

    private static void logDialogActivity(Activity activity, Fragment fragment, String str, String str2) {
        Context activity2;
        if (fragment != null) {
            activity2 = fragment.getActivity();
        }
        AppEventsLogger newLogger = AppEventsLogger.newLogger(activity2);
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME, str2);
        newLogger.logSdkEvent(str, null, bundle);
    }

    public PendingCall present() {
        logDialogActivity(this.activity, this.fragment, getEventName(this.appCall.getRequestIntent()), AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED);
        if (this.onPresentCallback != null) {
            try {
                this.onPresentCallback.onPresent(this.activity);
            } catch (Throwable e) {
                throw new FacebookException(e);
            }
        }
        if (this.fragment != null) {
            this.fragment.startActivityForResult(this.appCall.getRequestIntent(), this.appCall.getRequestCode());
        } else {
            this.activity.startActivityForResult(this.appCall.getRequestIntent(), this.appCall.getRequestCode());
        }
        return this.appCall;
    }
}
