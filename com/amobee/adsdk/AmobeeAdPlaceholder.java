package com.amobee.adsdk;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.amobee.richmedia.view.AmobeeView;
import com.amobee.richmedia.view.AmobeeView.ViewState;

public final class AmobeeAdPlaceholder extends FrameLayout {
    static int DEFAULT_BANNER_HEIGHT = 50;
    static int DEFAULT_BANNER_WIDTH = 320;
    static int DEFAULT_IAB_LEADERBOARD_HEIGHT = 90;
    static int DEFAULT_IAB_LEADERBOARD_WIDTH = 728;
    static int MEDIUM_IAB_LEADERBOARD_HEIGHT = 75;
    static int MEDIUM_IAB_LEADERBOARD_WIDTH = 600;
    static int PIXEL = 1;
    private static final String TAG = "AmobeeAdPlaceHolder";
    String adSpace;
    public boolean amrp = false;
    private BaseAdapter currentAdapter;
    boolean firstRequest = true;
    protected boolean isResized = false;
    int mBannerHeight = 0;
    int mBannerWidth = 0;
    int mDefaultBannerHeight = DEFAULT_BANNER_HEIGHT;
    int mDefaultBannerWidth = DEFAULT_BANNER_WIDTH;
    private WindowManager mWindowManager;
    Context m_context;
    private BaseAdapter nextAdapter;
    Integer refreshInterval = Integer.valueOf(-1);
    boolean requestAdImmediately = false;
    boolean sizeWasSet = false;

    public AmobeeAdPlaceholder(Context context) {
        super(context);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        init(context);
    }

    public AmobeeAdPlaceholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        init(context);
        if (AdManager.pulse3dSupport) {
            View surfaceView = new SurfaceView(context);
            surfaceView.setVisibility(4);
            addView(surfaceView, new LayoutParams(PIXEL, PIXEL));
        }
        String str = "http://schemas.android.com/apk/lib/com.amobee.adsdk.AmobeeAdPlaceholder";
        if (attributeSet != null) {
            String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.amobee.adsdk.AmobeeAdPlaceholder", "serverUrl");
            String attributeValue2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.amobee.adsdk.AmobeeAdPlaceholder", "acc");
            String attributeValue3 = attributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.amobee.adsdk.AmobeeAdPlaceholder", "adSpace");
            this.requestAdImmediately = attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/lib/com.amobee.adsdk.AmobeeAdPlaceholder", "requestAdImmediately", false);
            this.refreshInterval = Integer.valueOf(attributeSet.getAttributeIntValue("http://schemas.android.com/apk/lib/com.amobee.adsdk.AmobeeAdPlaceholder", "refreshInterval", -1));
            initRequestDetail(attributeValue, attributeValue2, attributeValue3, this.requestAdImmediately, this.refreshInterval, context);
        }
    }

    private void initRequestDetail(String str, String str2, String str3, boolean z, Integer num, Context context) {
        AdManager instance = AdManager.getInstance(context);
        if (str != null) {
            instance.setServerURL(str);
        }
        if (str3 != null) {
            setAdSpace(str3);
        }
        if (str2 != null) {
            instance.parameters().setTargetingParameter("acc", str2);
        }
    }

    private boolean vaildHeight(int i) {
        return i > 0 && ((double) this.mWindowManager.getDefaultDisplay().getHeight()) >= ((double) i) * AdManager.getInstance(this.m_context).getDensity();
    }

    private boolean vaildWidth(int i) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        return i > 0 && ((double) this.mWindowManager.getDefaultDisplay().getWidth()) >= ((double) i) * AdManager.getInstance(this.m_context).getDensity();
    }

    Point getAdSize() {
        Point point = new Point(this.mBannerWidth, this.mBannerHeight);
        if (this.mBannerWidth == 0) {
            point.x = this.mDefaultBannerWidth;
        }
        if (this.mBannerHeight == 0) {
            point.y = this.mDefaultBannerHeight;
        }
        return point;
    }

    public String getAdSpace() {
        return this.adSpace;
    }

    int getBannerHeight() {
        return this.mBannerHeight;
    }

    int getBannerWidth() {
        return this.mBannerWidth;
    }

    BaseAdapter getCurrentAdapter() {
        return this.currentAdapter;
    }

    BaseAdapter getNextAdapter() {
        return this.nextAdapter;
    }

    void init(Context context) {
        this.m_context = context;
        setLayoutParams(new LayoutParams(-1, -2));
        setBackgroundColor(0);
        AdManager instance = AdManager.getInstance(this.m_context);
        instance.addPlaceholder(this);
        if (!instance.isTablet(context)) {
            return;
        }
        if (instance.isMiniTablet(getContext())) {
            this.mDefaultBannerWidth = MEDIUM_IAB_LEADERBOARD_WIDTH;
            this.mDefaultBannerHeight = MEDIUM_IAB_LEADERBOARD_HEIGHT;
            return;
        }
        this.mDefaultBannerWidth = DEFAULT_IAB_LEADERBOARD_WIDTH;
        this.mDefaultBannerHeight = DEFAULT_IAB_LEADERBOARD_HEIGHT;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        AdManager.getInstance(this.m_context).addPlaceholder(this);
        if (this.currentAdapter != null && this.currentAdapter.getAdView() != null && (this.currentAdapter.getAdView() instanceof AmobeeView)) {
            try {
                Class.forName("android.webkit.WebView").getMethod("onResume", null).invoke((AmobeeView) this.currentAdapter.getAdView(), null);
            } catch (Exception e) {
            }
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AdManager instance = AdManager.getInstance(this.m_context);
        if (!(this.currentAdapter == null || this.currentAdapter.getAdView() == null || !(this.currentAdapter.getAdView() instanceof AmobeeView))) {
            AmobeeView amobeeView = (AmobeeView) this.currentAdapter.getAdView();
            if (AmobeeView.isExpanded || ((AmobeeView) this.currentAdapter.getAdView()).mViewState == ViewState.RESIZED || ((AmobeeView) this.currentAdapter.getAdView()).mViewState == ViewState.EXPANDED) {
                amobeeView = (AmobeeView) this.currentAdapter.getAdView();
                AmobeeView.isExpanded = false;
                this.isResized = false;
                ((AmobeeView) this.currentAdapter.getAdView()).parentView = null;
                instance.setIsExpanded(false);
            }
            ((AmobeeView) this.currentAdapter.getAdView()).hideVideo();
            try {
                Class.forName("android.webkit.WebView").getMethod("onPause", null).invoke((AmobeeView) this.currentAdapter.getAdView(), null);
            } catch (Exception e) {
                ((AmobeeView) this.currentAdapter.getAdView()).loadUrl("about:blank");
            }
        }
        instance.removePlaceholder(this);
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        AdManager instance = AdManager.getInstance(this.m_context);
        Log.m811d(TAG, "onWindowVisibilityChanged " + i);
        if (i == 0) {
            if (!(this.refreshInterval == null || -1 == this.refreshInterval.intValue())) {
                instance.setRefreshInterval(this.refreshInterval.intValue());
            }
            if (this.requestAdImmediately && instance.getRefreshInterval() == 0) {
                this.requestAdImmediately = false;
                instance.getAd(this);
                Log.m811d(TAG, "onWindowVisibilityChanged getad");
            } else if (this.requestAdImmediately) {
                this.requestAdImmediately = false;
                instance.getAd();
                Log.m811d(TAG, "onWindowVisibilityChanged getad");
            }
        }
    }

    public void setAdSpace(String str) {
        this.adSpace = str;
    }

    synchronized void setAdview(IAmobee iAmobee) {
        View childAt = getChildAt(0);
        int i = 0;
        while (i < getChildCount()) {
            if (!(getChildAt(i).getClass().getSimpleName().equals("Pulse3DView") || (getChildAt(i) instanceof SurfaceView))) {
                childAt = getChildAt(i);
            }
            i++;
        }
        View adView = iAmobee.getAdView();
        if (adView != null) {
            if (!(childAt == null || childAt.getVisibility() != 0 || childAt == iAmobee.getAdView())) {
                removeView(childAt);
            }
            if (adView.getParent() != this) {
                if (adView.getParent() != null) {
                    ((ViewGroup) adView.getParent()).removeView(adView);
                }
                addView(adView);
            }
        }
    }

    void setBannerHeight(int i) {
        this.mBannerHeight = i;
    }

    public void setBannerSize(int i, int i2) {
        if (vaildWidth(i)) {
            this.mBannerWidth = i;
        } else {
            Log.m811d(AdManager.TAG, "setBannerSize( int width , int height ): the width you set is invalid - default value will be set instead (320dp).");
        }
        if (vaildHeight(i2)) {
            this.mBannerHeight = i2;
        } else {
            Log.m811d(AdManager.TAG, "setBannerSize( int width , int height ): the height you set is invalid - default value will be set instead (50dp).");
        }
    }

    void setBannerWidth(int i) {
        this.mBannerWidth = i;
    }

    void setCurrentAdapter(BaseAdapter baseAdapter) {
        this.currentAdapter = baseAdapter;
        setAdview(baseAdapter);
    }

    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams.height > 0 || layoutParams.height > 0) {
            this.sizeWasSet = true;
        }
        if (!this.sizeWasSet || (layoutParams.height >= 0 && layoutParams.height >= 0)) {
            super.setLayoutParams(layoutParams);
        }
    }

    void setNextAdapter(BaseAdapter baseAdapter) {
        if (baseAdapter == null) {
            this.nextAdapter = null;
            return;
        }
        this.nextAdapter = baseAdapter;
        this.nextAdapter.getAdView().setVisibility(4);
        addView(this.nextAdapter.getAdView());
    }
}
