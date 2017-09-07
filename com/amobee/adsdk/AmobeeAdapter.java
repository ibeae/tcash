package com.amobee.adsdk;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import com.amobee.richmedia.view.AmobeeView;
import com.amobee.richmedia.view.AmobeeView.OrmmaViewListener;

class AmobeeAdapter extends BaseAdapter {
    private int adHeight = 80;
    private int adWidth = -1;
    AdManager am = AdManager.getInstance();
    private String fragment;
    private Context mContext;
    private AmobeeView ormmaView = null;

    class C03001 implements OrmmaViewListener {
        C03001() {
        }

        public void handleRequest(String str) {
        }

        public boolean onEventFired() {
            return false;
        }

        public boolean onExpand() {
            AmobeeAdapter.this.onOverlay();
            AmobeeAdPlaceholder placeHolder = AmobeeAdapter.this.getPlaceHolder();
            AmobeeAdapter.this.am.setIsExpanded(true);
            AmobeeAdapter.this.am.fireOnOverlay(true, placeHolder);
            return false;
        }

        public boolean onExpandClose() {
            AmobeeAdPlaceholder placeHolder = AmobeeAdapter.this.getPlaceHolder();
            AmobeeAdapter.this.onOverlayDismissed();
            AmobeeAdapter.this.am.setIsExpanded(false);
            AmobeeAdapter.this.am.fireOnOverlay(false, placeHolder);
            AmobeeAdapter.this.am.getAd(true, AmobeeAdapter.this.am.getPlaceholders());
            return false;
        }

        public void onLeavingApplication() {
            AmobeeAdapter.this.onLeavingApplication();
        }

        public boolean onOverlay() {
            AmobeeAdapter.this.am.fireOnOverlay(true, AmobeeAdapter.this.getPlaceHolder());
            return false;
        }

        public boolean onPostitialClose() {
            return false;
        }

        public boolean onReady() {
            return false;
        }

        public boolean onResize() {
            AmobeeAdapter.this.onOverlay();
            AmobeeAdPlaceholder placeHolder = AmobeeAdapter.this.getPlaceHolder();
            AmobeeAdapter.this.am.fireOnOverlay(true, placeHolder);
            placeHolder.isResized = true;
            return false;
        }

        public boolean onResizeClose() {
            AmobeeAdapter.this.onOverlayDismissed();
            AmobeeAdPlaceholder placeHolder = AmobeeAdapter.this.getPlaceHolder();
            AmobeeAdapter.this.am.fireOnOverlay(false, placeHolder);
            AmobeeAdapter.this.am.getAd(true, AmobeeAdapter.this.am.getPlaceholders());
            placeHolder.isResized = false;
            return false;
        }
    }

    AmobeeAdapter(Context context, Parameters parameters, String str, int i, int i2) {
        super(context, parameters);
        this.fragment = str;
        this.mContext = context;
        determineAdHeight(i2);
        determineAdWidth(i);
        this.ormmaView = new AmobeeView(this.mContext, new C03001());
        this.ormmaView.setUserGestureRequiredToOpenAds(this.am.getUserGestureRequiredToOpenAds());
        this.ormmaView.setLayoutParams(new LayoutParams(this.adWidth, this.adHeight));
        this.ormmaView.setBackgroundColor(0);
        this.ormmaView.loadString(this.fragment, null);
    }

    private synchronized void determineAdHeight(int i) {
        Display defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        float f = displayMetrics.density;
        this.adHeight = (int) (((double) (50.0f * f)) + 0.5d);
        if (i != 0) {
            this.adHeight = (int) (((double) (f * ((float) i))) + 0.5d);
        }
    }

    private synchronized void determineAdWidth(int i) {
        if (i != 0) {
            this.adWidth = (int) ((((double) i) * this.am.getDensity()) + 0.5d);
        }
    }

    public void adFailed() {
        this.am.getAmobeeListener().amobeeOnAdFailed(getPlaceHolder());
    }

    public void adRecieved() {
        super.fireAdRecieved(this.networkName);
    }

    public void getAd() {
        this.am.getAd();
    }

    public View getAdView() {
        return this.ormmaView;
    }

    public String getFragment() {
        return this.fragment;
    }

    public void onError() {
        this.am.getAmobeeListener().amobeeOnError();
    }

    public void onLeavingApplication() {
        this.am.getAmobeeListener().amobeeOnLeavingApplication(getPlaceHolder());
    }

    public void onOverlay() {
    }

    public void onOverlayDismissed() {
    }

    public void setFragment(String str) {
        this.fragment = str;
    }

    void updateAdapter(Parameters parameters, String str) {
        this.fragment = str;
        this.ormmaView.setUserGestureRequiredToOpenAds(this.am.getUserGestureRequiredToOpenAds());
        this.ormmaView.loadString(this.fragment, null);
        adRecieved();
    }

    public void updateParameters(Parameters parameters) {
        super.setParameters(parameters);
    }
}
