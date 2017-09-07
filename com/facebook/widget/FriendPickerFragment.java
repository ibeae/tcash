package com.facebook.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.facebook.AppEventsLogger;
import com.facebook.FacebookException;
import com.facebook.Request;
import com.facebook.Session;
import com.facebook.android.C0426R;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.model.GraphUser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FriendPickerFragment extends PickerFragment<GraphUser> {
    public static final String FRIEND_PICKER_TYPE_KEY = "com.facebook.widget.FriendPickerFragment.FriendPickerType";
    private static final String ID = "id";
    public static final String MULTI_SELECT_BUNDLE_KEY = "com.facebook.widget.FriendPickerFragment.MultiSelect";
    private static final String NAME = "name";
    public static final String USER_ID_BUNDLE_KEY = "com.facebook.widget.FriendPickerFragment.UserId";
    private FriendPickerType friendPickerType;
    private boolean multiSelect;
    private List<String> preSelectedFriendIds;
    private String userId;

    public enum FriendPickerType {
        FRIENDS("/friends", true),
        TAGGABLE_FRIENDS("/taggable_friends", false),
        INVITABLE_FRIENDS("/invitable_friends", false);
        
        private final boolean requestIsCacheable;
        private final String requestPath;

        private FriendPickerType(String str, boolean z) {
            this.requestPath = str;
            this.requestIsCacheable = z;
        }

        String getRequestPath() {
            return this.requestPath;
        }

        boolean isCacheable() {
            return this.requestIsCacheable;
        }
    }

    private class ImmediateLoadingStrategy extends LoadingStrategy {
        private ImmediateLoadingStrategy() {
            super();
        }

        private void followNextLink() {
            FriendPickerFragment.this.displayActivityCircle();
            this.loader.followNextLink();
        }

        protected boolean canSkipRoundTripIfCached() {
            return FriendPickerFragment.this.friendPickerType.isCacheable();
        }

        protected void onLoadFinished(GraphObjectPagingLoader<GraphUser> graphObjectPagingLoader, SimpleGraphObjectCursor<GraphUser> simpleGraphObjectCursor) {
            super.onLoadFinished(graphObjectPagingLoader, simpleGraphObjectCursor);
            if (simpleGraphObjectCursor != null && !graphObjectPagingLoader.isLoading()) {
                if (simpleGraphObjectCursor.areMoreObjectsAvailable()) {
                    followNextLink();
                    return;
                }
                FriendPickerFragment.this.hideActivityCircle();
                if (simpleGraphObjectCursor.isFromCache()) {
                    graphObjectPagingLoader.refreshOriginalRequest(simpleGraphObjectCursor.getCount() == 0 ? 2000 : 0);
                }
            }
        }
    }

    public FriendPickerFragment() {
        this(null);
    }

    @SuppressLint({"ValidFragment"})
    public FriendPickerFragment(Bundle bundle) {
        super(GraphUser.class, C0426R.layout.com_facebook_friendpickerfragment, bundle);
        this.multiSelect = true;
        this.friendPickerType = FriendPickerType.FRIENDS;
        this.preSelectedFriendIds = new ArrayList();
        setFriendPickerSettingsFromBundle(bundle);
    }

    private Request createRequest(String str, Set<String> set, Session session) {
        Request newGraphPathRequest = Request.newGraphPathRequest(session, str + this.friendPickerType.getRequestPath(), null);
        Iterable hashSet = new HashSet(set);
        hashSet.addAll(Arrays.asList(new String[]{ID, NAME}));
        String pictureFieldSpecifier = this.adapter.getPictureFieldSpecifier();
        if (pictureFieldSpecifier != null) {
            hashSet.add(pictureFieldSpecifier);
        }
        Bundle parameters = newGraphPathRequest.getParameters();
        parameters.putString("fields", TextUtils.join(",", hashSet));
        newGraphPathRequest.setParameters(parameters);
        return newGraphPathRequest;
    }

    private void setFriendPickerSettingsFromBundle(Bundle bundle) {
        if (bundle != null) {
            if (bundle.containsKey(USER_ID_BUNDLE_KEY)) {
                setUserId(bundle.getString(USER_ID_BUNDLE_KEY));
            }
            setMultiSelect(bundle.getBoolean(MULTI_SELECT_BUNDLE_KEY, this.multiSelect));
            if (bundle.containsKey(FRIEND_PICKER_TYPE_KEY)) {
                try {
                    this.friendPickerType = FriendPickerType.valueOf(bundle.getString(FRIEND_PICKER_TYPE_KEY));
                } catch (Exception e) {
                }
            }
        }
    }

    PickerFragmentAdapter<GraphUser> createAdapter() {
        PickerFragmentAdapter<GraphUser> c04671 = new PickerFragmentAdapter<GraphUser>(getActivity()) {
            protected int getDefaultPicture() {
                return C0426R.drawable.com_facebook_profile_default_icon;
            }

            protected int getGraphObjectRowLayoutId(GraphUser graphUser) {
                return C0426R.layout.com_facebook_picker_list_row;
            }
        };
        c04671.setShowCheckbox(true);
        c04671.setShowPicture(getShowPictures());
        c04671.setSortFields(Arrays.asList(new String[]{NAME}));
        c04671.setGroupByField(NAME);
        return c04671;
    }

    LoadingStrategy createLoadingStrategy() {
        return new ImmediateLoadingStrategy();
    }

    SelectionStrategy createSelectionStrategy() {
        return this.multiSelect ? new MultiSelectionStrategy() : new SingleSelectionStrategy();
    }

    String getDefaultTitleText() {
        return getString(C0426R.string.com_facebook_choose_friends);
    }

    public boolean getMultiSelect() {
        return this.multiSelect;
    }

    Request getRequestForLoadData(Session session) {
        if (this.adapter == null) {
            throw new FacebookException("Can't issue requests until Fragment has been created.");
        }
        return createRequest(this.userId != null ? this.userId : "me", this.extraFields, session);
    }

    public List<GraphUser> getSelection() {
        return getSelectedGraphObjects();
    }

    public String getUserId() {
        return this.userId;
    }

    public void loadData(boolean z) {
        super.loadData(z);
        setSelectedGraphObjects(this.preSelectedFriendIds);
    }

    void logAppEvents(boolean z) {
        AppEventsLogger newLogger = AppEventsLogger.newLogger(getActivity(), getSession());
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME, z ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
        bundle.putInt("num_friends_picked", getSelection().size());
        newLogger.logSdkEvent(AnalyticsEvents.EVENT_FRIEND_PICKER_USAGE, null, bundle);
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(attributeSet, C0426R.styleable.com_facebook_friend_picker_fragment);
        setMultiSelect(obtainStyledAttributes.getBoolean(C0426R.styleable.com_facebook_friend_picker_fragment_multi_select, this.multiSelect));
        obtainStyledAttributes.recycle();
    }

    void saveSettingsToBundle(Bundle bundle) {
        super.saveSettingsToBundle(bundle);
        bundle.putString(USER_ID_BUNDLE_KEY, this.userId);
        bundle.putBoolean(MULTI_SELECT_BUNDLE_KEY, this.multiSelect);
    }

    public void setFriendPickerType(FriendPickerType friendPickerType) {
        this.friendPickerType = friendPickerType;
    }

    public void setMultiSelect(boolean z) {
        if (this.multiSelect != z) {
            this.multiSelect = z;
            setSelectionStrategy(createSelectionStrategy());
        }
    }

    public void setSelection(List<GraphUser> list) {
        List arrayList = new ArrayList();
        for (GraphUser id : list) {
            arrayList.add(id.getId());
        }
        setSelectionByIds(arrayList);
    }

    public void setSelection(GraphUser... graphUserArr) {
        setSelection(Arrays.asList(graphUserArr));
    }

    public void setSelectionByIds(List<String> list) {
        this.preSelectedFriendIds.addAll(list);
    }

    public void setSelectionByIds(String... strArr) {
        setSelectionByIds(Arrays.asList(strArr));
    }

    public void setSettingsFromBundle(Bundle bundle) {
        super.setSettingsFromBundle(bundle);
        setFriendPickerSettingsFromBundle(bundle);
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
