package com.actionbarsherlock.internal;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.ActionBarSherlock.Implementation;
import com.actionbarsherlock.ActionBarSherlock.OnActionModeFinishedListener;
import com.actionbarsherlock.ActionBarSherlock.OnActionModeStartedListener;
import com.actionbarsherlock.C0247R;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.internal.app.ActionBarImpl;
import com.actionbarsherlock.internal.view.StandaloneActionMode;
import com.actionbarsherlock.internal.view.menu.ActionMenuPresenter;
import com.actionbarsherlock.internal.view.menu.MenuBuilder;
import com.actionbarsherlock.internal.view.menu.MenuBuilder.Callback;
import com.actionbarsherlock.internal.view.menu.MenuItemImpl;
import com.actionbarsherlock.internal.view.menu.MenuPresenter;
import com.actionbarsherlock.internal.widget.ActionBarContainer;
import com.actionbarsherlock.internal.widget.ActionBarContextView;
import com.actionbarsherlock.internal.widget.ActionBarView;
import com.actionbarsherlock.internal.widget.IcsProgressBar;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.Window;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Implementation(api = 7)
public class ActionBarSherlockCompat extends ActionBarSherlock implements OnMenuItemClickListener, Callback, MenuPresenter.Callback, Window.Callback {
    protected static final int DEFAULT_FEATURES = 0;
    private static final String PANELS_TAG = "sherlock:Panels";
    private ActionBarImpl aActionBar;
    private ActionMode mActionMode;
    private ActionBarContextView mActionModeView;
    private IcsProgressBar mCircularProgressBar;
    private boolean mClosingActionMenu;
    private ViewGroup mContentParent;
    private ViewGroup mDecor;
    private int mFeatures = 0;
    private IcsProgressBar mHorizontalProgressBar;
    private boolean mIsDestroyed = false;
    private boolean mIsTitleReady = false;
    private MenuBuilder mMenu;
    private Bundle mMenuFrozenActionViewState;
    private boolean mMenuIsPrepared;
    private boolean mMenuRefreshContent;
    protected HashMap<MenuItem, MenuItemImpl> mNativeItemMap;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet = false;
    private int mUiOptions = 0;
    private ActionBarView wActionBar;

    class C02481 implements Runnable {
        C02481() {
        }

        public void run() {
            if (!ActionBarSherlockCompat.this.mIsDestroyed && !ActionBarSherlockCompat.this.mActivity.isFinishing() && ActionBarSherlockCompat.this.mMenu == null) {
                ActionBarSherlockCompat.this.dispatchInvalidateOptionsMenu();
            }
        }
    }

    private class ActionModeCallbackWrapper implements ActionMode.Callback {
        private final ActionMode.Callback mWrapped;

        public ActionModeCallbackWrapper(ActionMode.Callback callback) {
            this.mWrapped = callback;
        }

        public boolean onActionItemClicked(ActionMode actionMode, com.actionbarsherlock.view.MenuItem menuItem) {
            return this.mWrapped.onActionItemClicked(actionMode, menuItem);
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.mWrapped.onCreateActionMode(actionMode, menu);
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.mWrapped.onDestroyActionMode(actionMode);
            if (ActionBarSherlockCompat.this.mActionModeView != null) {
                ActionBarSherlockCompat.this.mActionModeView.setVisibility(8);
                ActionBarSherlockCompat.this.mActionModeView.removeAllViews();
            }
            if (ActionBarSherlockCompat.this.mActivity instanceof OnActionModeFinishedListener) {
                ((OnActionModeFinishedListener) ActionBarSherlockCompat.this.mActivity).onActionModeFinished(ActionBarSherlockCompat.this.mActionMode);
            }
            ActionBarSherlockCompat.this.mActionMode = null;
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.mWrapped.onPrepareActionMode(actionMode, menu);
        }
    }

    public ActionBarSherlockCompat(Activity activity, int i) {
        super(activity, i);
    }

    public static String cleanActivityName(String str, String str2) {
        return str2.charAt(0) == '.' ? str + str2 : str2.indexOf(46, 1) == -1 ? str + "." + str2 : str2;
    }

    private ViewGroup generateLayout() {
        TypedArray obtainStyledAttributes = this.mActivity.getTheme().obtainStyledAttributes(C0247R.styleable.SherlockTheme);
        if (obtainStyledAttributes.hasValue(59)) {
            if (obtainStyledAttributes.getBoolean(58, false)) {
                requestFeature(1);
            } else if (obtainStyledAttributes.getBoolean(59, false)) {
                requestFeature(8);
            }
            if (obtainStyledAttributes.getBoolean(60, false)) {
                requestFeature(9);
            }
            if (obtainStyledAttributes.getBoolean(61, false)) {
                requestFeature(10);
            }
            obtainStyledAttributes.recycle();
            int i = !hasFeature(1) ? hasFeature(9) ? C0247R.layout.abs__screen_action_bar_overlay : C0247R.layout.abs__screen_action_bar : (!hasFeature(10) || hasFeature(1)) ? C0247R.layout.abs__screen_simple : C0247R.layout.abs__screen_simple_overlay_action_mode;
            this.mDecor.addView(this.mActivity.getLayoutInflater().inflate(i, null), new LayoutParams(-1, -1));
            ViewGroup viewGroup = (ViewGroup) this.mDecor.findViewById(C0247R.id.abs__content);
            if (viewGroup == null) {
                throw new RuntimeException("Couldn't find content container view");
            }
            this.mDecor.setId(-1);
            viewGroup.setId(16908290);
            if (hasFeature(5)) {
                IcsProgressBar circularProgressBar = getCircularProgressBar(false);
                if (circularProgressBar != null) {
                    circularProgressBar.setIndeterminate(true);
                }
            }
            return viewGroup;
        }
        throw new IllegalStateException("You must use Theme.Sherlock, Theme.Sherlock.Light, Theme.Sherlock.Light.DarkActionBar, or a derivative.");
    }

    private IcsProgressBar getCircularProgressBar(boolean z) {
        if (this.mCircularProgressBar != null) {
            return this.mCircularProgressBar;
        }
        if (this.mContentParent == null && z) {
            installDecor();
        }
        this.mCircularProgressBar = (IcsProgressBar) this.mDecor.findViewById(C0247R.id.abs__progress_circular);
        if (this.mCircularProgressBar != null) {
            this.mCircularProgressBar.setVisibility(4);
        }
        return this.mCircularProgressBar;
    }

    private int getFeatures() {
        return this.mFeatures;
    }

    private IcsProgressBar getHorizontalProgressBar(boolean z) {
        if (this.mHorizontalProgressBar != null) {
            return this.mHorizontalProgressBar;
        }
        if (this.mContentParent == null && z) {
            installDecor();
        }
        this.mHorizontalProgressBar = (IcsProgressBar) this.mDecor.findViewById(C0247R.id.abs__progress_horizontal);
        if (this.mHorizontalProgressBar != null) {
            this.mHorizontalProgressBar.setVisibility(4);
        }
        return this.mHorizontalProgressBar;
    }

    private void hideProgressBars(IcsProgressBar icsProgressBar, IcsProgressBar icsProgressBar2) {
        int i = this.mFeatures;
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mActivity, 17432577);
        loadAnimation.setDuration(1000);
        if ((i & 32) != 0 && icsProgressBar2.getVisibility() == 0) {
            icsProgressBar2.startAnimation(loadAnimation);
            icsProgressBar2.setVisibility(4);
        }
        if ((i & 4) != 0 && icsProgressBar.getVisibility() == 0) {
            icsProgressBar.startAnimation(loadAnimation);
            icsProgressBar.setVisibility(4);
        }
    }

    private void initActionBar() {
        if (this.mDecor == null) {
            installDecor();
        }
        if (this.aActionBar == null && hasFeature(8) && !hasFeature(1) && !this.mActivity.isChild()) {
            this.aActionBar = new ActionBarImpl(this.mActivity, this.mFeatures);
            if (!this.mIsDelegate) {
                this.wActionBar.setWindowTitle(this.mActivity.getTitle());
            }
        }
    }

    private boolean initializePanelMenu() {
        Context contextThemeWrapper;
        Context context = this.mActivity;
        if (this.wActionBar != null) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(C0247R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                contextThemeWrapper = new ContextThemeWrapper(context, i);
                this.mMenu = new MenuBuilder(contextThemeWrapper);
                this.mMenu.setCallback(this);
                return true;
            }
        }
        contextThemeWrapper = context;
        this.mMenu = new MenuBuilder(contextThemeWrapper);
        this.mMenu.setCallback(this);
        return true;
    }

    private void installDecor() {
        if (this.mDecor == null) {
            this.mDecor = (ViewGroup) this.mActivity.getWindow().getDecorView().findViewById(16908290);
        }
        if (this.mContentParent == null) {
            List list = null;
            if (this.mDecor.getChildCount() > 0) {
                list = new ArrayList(1);
                int childCount = this.mDecor.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.mDecor.getChildAt(0);
                    this.mDecor.removeView(childAt);
                    list.add(childAt);
                }
            }
            this.mContentParent = generateLayout();
            if (r0 != null) {
                for (View addView : r0) {
                    this.mContentParent.addView(addView);
                }
            }
            this.wActionBar = (ActionBarView) this.mDecor.findViewById(C0247R.id.abs__action_bar);
            if (this.wActionBar != null) {
                this.wActionBar.setWindowCallback(this);
                if (this.wActionBar.getTitle() == null) {
                    this.wActionBar.setWindowTitle(this.mActivity.getTitle());
                }
                if (hasFeature(2)) {
                    this.wActionBar.initProgress();
                }
                if (hasFeature(5)) {
                    this.wActionBar.initIndeterminateProgress();
                }
                int loadUiOptionsFromManifest = loadUiOptionsFromManifest(this.mActivity);
                if (loadUiOptionsFromManifest != 0) {
                    this.mUiOptions = loadUiOptionsFromManifest;
                }
                boolean z = (this.mUiOptions & 1) != 0;
                boolean resources_getBoolean = z ? ResourcesCompat.getResources_getBoolean(this.mActivity, C0247R.bool.abs__split_action_bar_is_narrow) : this.mActivity.getTheme().obtainStyledAttributes(C0247R.styleable.SherlockTheme).getBoolean(62, false);
                ActionBarContainer actionBarContainer = (ActionBarContainer) this.mDecor.findViewById(C0247R.id.abs__split_action_bar);
                if (actionBarContainer != null) {
                    this.wActionBar.setSplitView(actionBarContainer);
                    this.wActionBar.setSplitActionBar(resources_getBoolean);
                    this.wActionBar.setSplitWhenNarrow(z);
                    this.mActionModeView = (ActionBarContextView) this.mDecor.findViewById(C0247R.id.abs__action_context_bar);
                    this.mActionModeView.setSplitView(actionBarContainer);
                    this.mActionModeView.setSplitActionBar(resources_getBoolean);
                    this.mActionModeView.setSplitWhenNarrow(z);
                } else if (resources_getBoolean) {
                    Log.e("ActionBarSherlock", "Requested split action bar with incompatible window decor! Ignoring request.");
                }
                this.mDecor.post(new C02481());
            }
        }
    }

    private boolean isReservingOverflow() {
        if (!this.mReserveOverflowSet) {
            this.mReserveOverflow = ActionMenuPresenter.reserveOverflow(this.mActivity);
            this.mReserveOverflowSet = true;
        }
        return this.mReserveOverflow;
    }

    private static int loadUiOptionsFromManifest(Activity activity) {
        int i;
        Exception e;
        try {
            String name = activity.getClass().getName();
            String str = activity.getApplicationInfo().packageName;
            XmlResourceParser openXmlResourceParser = activity.createPackageContext(str, 0).getAssets().openXmlResourceParser("AndroidManifest.xml");
            int eventType = openXmlResourceParser.getEventType();
            i = 0;
            while (eventType != 1) {
                if (eventType == 2) {
                    try {
                        String name2 = openXmlResourceParser.getName();
                        if (!"application".equals(name2)) {
                            if ("activity".equals(name2)) {
                                Object obj = null;
                                String str2 = null;
                                Integer num = null;
                                for (eventType = openXmlResourceParser.getAttributeCount() - 1; eventType >= 0; eventType--) {
                                    String attributeName = openXmlResourceParser.getAttributeName(eventType);
                                    if ("uiOptions".equals(attributeName)) {
                                        num = Integer.valueOf(openXmlResourceParser.getAttributeIntValue(eventType, 0));
                                    } else if ("name".equals(attributeName)) {
                                        str2 = cleanActivityName(str, openXmlResourceParser.getAttributeValue(eventType));
                                        if (!name.equals(str2)) {
                                            break;
                                        }
                                        int i2 = 1;
                                    }
                                    if (!(num == null || r4 == null)) {
                                        i = num.intValue();
                                    }
                                }
                                if (obj != null) {
                                    break;
                                }
                            }
                        }
                        for (eventType = openXmlResourceParser.getAttributeCount() - 1; eventType >= 0; eventType--) {
                            if ("uiOptions".equals(openXmlResourceParser.getAttributeName(eventType))) {
                                i = openXmlResourceParser.getAttributeIntValue(eventType, 0);
                                break;
                            }
                        }
                        eventType = i;
                        i = eventType;
                        eventType = openXmlResourceParser.nextToken();
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
                eventType = i;
                try {
                    i = eventType;
                    eventType = openXmlResourceParser.nextToken();
                } catch (Exception e3) {
                    Exception exception = e3;
                    i = eventType;
                    e = exception;
                }
            }
        } catch (Exception e32) {
            e = e32;
            i = 0;
            e.printStackTrace();
            return i;
        }
        return i;
    }

    private void onIntChanged(int i, int i2) {
        if (i == 2 || i == 5) {
            updateProgressBars(i2);
        }
    }

    private boolean preparePanel() {
        boolean z = false;
        if (this.mMenuIsPrepared) {
            return true;
        }
        if (this.mMenu == null || this.mMenuRefreshContent) {
            if (this.mMenu == null && (!initializePanelMenu() || this.mMenu == null)) {
                return false;
            }
            if (this.wActionBar != null) {
                this.wActionBar.setMenu(this.mMenu, this);
            }
            this.mMenu.stopDispatchingItemsChanged();
            if (callbackCreateOptionsMenu(this.mMenu)) {
                this.mMenuRefreshContent = false;
            } else {
                this.mMenu = null;
                if (this.wActionBar == null) {
                    return false;
                }
                this.wActionBar.setMenu(null, this);
                return false;
            }
        }
        this.mMenu.stopDispatchingItemsChanged();
        if (this.mMenuFrozenActionViewState != null) {
            this.mMenu.restoreActionViewStates(this.mMenuFrozenActionViewState);
            this.mMenuFrozenActionViewState = null;
        }
        if (callbackPrepareOptionsMenu(this.mMenu)) {
            KeyCharacterMap load = KeyCharacterMap.load(-1);
            MenuBuilder menuBuilder = this.mMenu;
            if (load.getKeyboardType() != 1) {
                z = true;
            }
            menuBuilder.setQwertyMode(z);
            this.mMenu.startDispatchingItemsChanged();
            this.mMenuIsPrepared = true;
            return true;
        }
        if (this.wActionBar != null) {
            this.wActionBar.setMenu(null, this);
        }
        this.mMenu.startDispatchingItemsChanged();
        return false;
    }

    private void reopenMenu(boolean z) {
        if (this.wActionBar != null && this.wActionBar.isOverflowReserved()) {
            if (this.wActionBar.isOverflowMenuShowing() && z) {
                this.wActionBar.hideOverflowMenu();
            } else if (this.wActionBar.getVisibility() == 0 && callbackPrepareOptionsMenu(this.mMenu)) {
                this.wActionBar.showOverflowMenu();
            }
        }
    }

    private void setFeatureInt(int i, int i2) {
        updateInt(i, i2, false);
    }

    private void showProgressBars(IcsProgressBar icsProgressBar, IcsProgressBar icsProgressBar2) {
        int i = this.mFeatures;
        if ((i & 32) != 0 && icsProgressBar2.getVisibility() == 4) {
            icsProgressBar2.setVisibility(0);
        }
        if ((i & 4) != 0 && icsProgressBar.getProgress() < 10000) {
            icsProgressBar.setVisibility(0);
        }
    }

    private void updateInt(int i, int i2, boolean z) {
        if (this.mContentParent != null) {
            if (((1 << i) & getFeatures()) != 0 || z) {
                onIntChanged(i, i2);
            }
        }
    }

    private void updateProgressBars(int i) {
        IcsProgressBar circularProgressBar = getCircularProgressBar(true);
        IcsProgressBar horizontalProgressBar = getHorizontalProgressBar(true);
        int i2 = this.mFeatures;
        if (i == -1) {
            if ((i2 & 4) != 0) {
                int i3 = (horizontalProgressBar.isIndeterminate() || horizontalProgressBar.getProgress() < 10000) ? 0 : 4;
                horizontalProgressBar.setVisibility(i3);
            }
            if ((i2 & 32) != 0) {
                circularProgressBar.setVisibility(0);
            }
        } else if (i == -2) {
            if ((i2 & 4) != 0) {
                horizontalProgressBar.setVisibility(8);
            }
            if ((i2 & 32) != 0) {
                circularProgressBar.setVisibility(8);
            }
        } else if (i == -3) {
            horizontalProgressBar.setIndeterminate(true);
        } else if (i == -4) {
            horizontalProgressBar.setIndeterminate(false);
        } else if (i >= 0 && i <= 10000) {
            horizontalProgressBar.setProgress(i + 0);
            if (i < 10000) {
                showProgressBars(horizontalProgressBar, circularProgressBar);
            } else {
                hideProgressBars(horizontalProgressBar, circularProgressBar);
            }
        } else if (20000 <= i && i <= 30000) {
            horizontalProgressBar.setSecondaryProgress(i - 20000);
            showProgressBars(horizontalProgressBar, circularProgressBar);
        }
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        if (this.mContentParent == null) {
            installDecor();
        }
        this.mContentParent.addView(view, layoutParams);
        initActionBar();
    }

    void checkCloseActionMenu(Menu menu) {
        if (!this.mClosingActionMenu) {
            this.mClosingActionMenu = true;
            this.wActionBar.dismissPopupMenus();
            this.mClosingActionMenu = false;
        }
    }

    public boolean dispatchCloseOptionsMenu() {
        return (isReservingOverflow() && this.wActionBar != null) ? this.wActionBar.hideOverflowMenu() : false;
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        if (this.aActionBar != null) {
            this.aActionBar.onConfigurationChanged(configuration);
        }
    }

    public boolean dispatchCreateOptionsMenu(android.view.Menu menu) {
        return true;
    }

    public void dispatchDestroy() {
        this.mIsDestroyed = true;
    }

    public void dispatchInvalidateOptionsMenu() {
        if (this.mMenu != null) {
            Bundle bundle = new Bundle();
            this.mMenu.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                this.mMenuFrozenActionViewState = bundle;
            }
            this.mMenu.stopDispatchingItemsChanged();
            this.mMenu.clear();
        }
        this.mMenuRefreshContent = true;
        if (this.wActionBar != null) {
            this.mMenuIsPrepared = false;
            preparePanel();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            int action = keyEvent.getAction();
            if (this.mActionMode != null) {
                if (action != 1) {
                    return true;
                }
                this.mActionMode.finish();
                return true;
            } else if (this.wActionBar != null && this.wActionBar.hasExpandedActionView()) {
                if (action != 1) {
                    return true;
                }
                this.wActionBar.collapseActionView();
                return true;
            }
        }
        return false;
    }

    public boolean dispatchMenuOpened(int i, android.view.Menu menu) {
        if (i != 8 && i != 0) {
            return false;
        }
        if (this.aActionBar == null) {
            return true;
        }
        this.aActionBar.dispatchMenuVisibilityChanged(true);
        return true;
    }

    public boolean dispatchOpenOptionsMenu() {
        return !isReservingOverflow() ? false : this.wActionBar.showOverflowMenu();
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        throw new IllegalStateException("Native callback invoked. Create a test case and report!");
    }

    public void dispatchPanelClosed(int i, android.view.Menu menu) {
        if ((i == 8 || i == 0) && this.aActionBar != null) {
            this.aActionBar.dispatchMenuVisibilityChanged(false);
        }
    }

    public void dispatchPause() {
        if (this.wActionBar != null && this.wActionBar.isOverflowMenuShowing()) {
            this.wActionBar.hideOverflowMenu();
        }
    }

    public void dispatchPostCreate(Bundle bundle) {
        if (this.mIsDelegate) {
            this.mIsTitleReady = true;
        }
        if (this.mDecor == null) {
            initActionBar();
        }
    }

    public void dispatchPostResume() {
        if (this.aActionBar != null) {
            this.aActionBar.setShowHideAnimationEnabled(true);
        }
    }

    public boolean dispatchPrepareOptionsMenu(android.view.Menu menu) {
        if (this.mActionMode != null) {
            return false;
        }
        this.mMenuIsPrepared = false;
        if (!preparePanel() || isReservingOverflow()) {
            return false;
        }
        if (this.mNativeItemMap == null) {
            this.mNativeItemMap = new HashMap();
        } else {
            this.mNativeItemMap.clear();
        }
        return this.mMenu != null ? this.mMenu.bindNativeOverflow(menu, this, this.mNativeItemMap) : false;
    }

    public void dispatchRestoreInstanceState(Bundle bundle) {
        this.mMenuFrozenActionViewState = (Bundle) bundle.getParcelable(PANELS_TAG);
    }

    public void dispatchSaveInstanceState(Bundle bundle) {
        if (this.mMenu != null) {
            this.mMenuFrozenActionViewState = new Bundle();
            this.mMenu.saveActionViewStates(this.mMenuFrozenActionViewState);
        }
        bundle.putParcelable(PANELS_TAG, this.mMenuFrozenActionViewState);
    }

    public void dispatchStop() {
        if (this.aActionBar != null) {
            this.aActionBar.setShowHideAnimationEnabled(false);
        }
    }

    public void dispatchTitleChanged(CharSequence charSequence, int i) {
        if ((!this.mIsDelegate || this.mIsTitleReady) && this.wActionBar != null) {
            this.wActionBar.setWindowTitle(charSequence);
        }
    }

    public void ensureActionBar() {
        if (this.mDecor == null) {
            initActionBar();
        }
    }

    public ActionBar getActionBar() {
        initActionBar();
        return this.aActionBar;
    }

    protected Context getThemedContext() {
        return this.aActionBar.getThemedContext();
    }

    public boolean hasFeature(int i) {
        return (this.mFeatures & (1 << i)) != 0;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        checkCloseActionMenu(menuBuilder);
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) this.mNativeItemMap.get(menuItem);
        if (menuItemImpl != null) {
            menuItemImpl.invoke();
        } else {
            Log.e("ActionBarSherlock", "Options item \"" + menuItem + "\" not found in mapping");
        }
        return true;
    }

    public boolean onMenuItemSelected(int i, com.actionbarsherlock.view.MenuItem menuItem) {
        return callbackOptionsItemSelected(menuItem);
    }

    public boolean onMenuItemSelected(MenuBuilder menuBuilder, com.actionbarsherlock.view.MenuItem menuItem) {
        return callbackOptionsItemSelected(menuItem);
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
        reopenMenu(true);
    }

    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        return true;
    }

    public boolean requestFeature(int i) {
        if (this.mContentParent != null) {
            throw new AndroidRuntimeException("requestFeature() must be called before adding content");
        }
        switch (i) {
            case 1:
            case 2:
            case 5:
            case 8:
            case 9:
            case 10:
                this.mFeatures |= 1 << i;
                return true;
            default:
                return false;
        }
    }

    public void setContentView(int i) {
        if (this.mContentParent == null) {
            installDecor();
        } else {
            this.mContentParent.removeAllViews();
        }
        this.mActivity.getLayoutInflater().inflate(i, this.mContentParent);
        android.view.Window.Callback callback = this.mActivity.getWindow().getCallback();
        if (callback != null) {
            callback.onContentChanged();
        }
        initActionBar();
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        if (this.mContentParent == null) {
            installDecor();
        } else {
            this.mContentParent.removeAllViews();
        }
        this.mContentParent.addView(view, layoutParams);
        android.view.Window.Callback callback = this.mActivity.getWindow().getCallback();
        if (callback != null) {
            callback.onContentChanged();
        }
        initActionBar();
    }

    public void setProgress(int i) {
        setFeatureInt(2, i + 0);
    }

    public void setProgressBarIndeterminate(boolean z) {
        setFeatureInt(2, z ? -3 : -4);
    }

    public void setProgressBarIndeterminateVisibility(boolean z) {
        setFeatureInt(5, z ? -1 : -2);
    }

    public void setProgressBarVisibility(boolean z) {
        setFeatureInt(2, z ? -1 : -2);
    }

    public void setSecondaryProgress(int i) {
        setFeatureInt(2, i + 20000);
    }

    public void setTitle(CharSequence charSequence) {
        dispatchTitleChanged(charSequence, 0);
    }

    public void setUiOptions(int i) {
        this.mUiOptions = i;
    }

    public void setUiOptions(int i, int i2) {
        this.mUiOptions = (this.mUiOptions & (i2 ^ -1)) | (i & i2);
    }

    public ActionMode startActionMode(ActionMode.Callback callback) {
        if (this.mActionMode != null) {
            this.mActionMode.finish();
        }
        ActionMode.Callback actionModeCallbackWrapper = new ActionModeCallbackWrapper(callback);
        initActionBar();
        ActionMode startActionMode = this.aActionBar != null ? this.aActionBar.startActionMode(actionModeCallbackWrapper) : null;
        if (startActionMode != null) {
            this.mActionMode = startActionMode;
        } else {
            if (this.mActionModeView == null) {
                ViewStub viewStub = (ViewStub) this.mDecor.findViewById(C0247R.id.abs__action_mode_bar_stub);
                if (viewStub != null) {
                    this.mActionModeView = (ActionBarContextView) viewStub.inflate();
                }
            }
            if (this.mActionModeView != null) {
                this.mActionModeView.killMode();
                startActionMode = new StandaloneActionMode(this.mActivity, this.mActionModeView, actionModeCallbackWrapper, true);
                if (callback.onCreateActionMode(startActionMode, startActionMode.getMenu())) {
                    startActionMode.invalidate();
                    this.mActionModeView.initForMode(startActionMode);
                    this.mActionModeView.setVisibility(0);
                    this.mActionMode = startActionMode;
                    this.mActionModeView.sendAccessibilityEvent(32);
                } else {
                    this.mActionMode = null;
                }
            }
        }
        if (this.mActionMode != null && (this.mActivity instanceof OnActionModeStartedListener)) {
            ((OnActionModeStartedListener) this.mActivity).onActionModeStarted(this.mActionMode);
        }
        return this.mActionMode;
    }
}
