package com.amobee.adsdk;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.amobee.richmedia.view.AmobeeView;
import com.amobee.richmedia.view.AmobeeView.ViewState;
import java.util.HashMap;
import java.util.Random;

public final class AmobeeInterstitial {
    private String mAdSpace;
    private Activity mContext;
    private String mHtml;
    private boolean mIsShowed = false;
    private AmobeeInterstitialListener mListener = new C03111();
    private int mRandom = new Random().nextInt(64000);
    int mStatusBarHeight = 0;

    class C03111 implements AmobeeInterstitialListener {
        C03111() {
        }

        public void interstitialClicked(AmobeeInterstitial amobeeInterstitial) {
        }

        public void interstitialClosed(AmobeeInterstitial amobeeInterstitial) {
        }

        public void interstitialFailed(AmobeeInterstitial amobeeInterstitial) {
        }

        public void interstitialRecieved(AmobeeInterstitial amobeeInterstitial) {
        }
    }

    class C03122 implements AmobeeInterstitialListener {
        C03122() {
        }

        public void interstitialClicked(AmobeeInterstitial amobeeInterstitial) {
        }

        public void interstitialClosed(AmobeeInterstitial amobeeInterstitial) {
        }

        public void interstitialFailed(AmobeeInterstitial amobeeInterstitial) {
        }

        public void interstitialRecieved(AmobeeInterstitial amobeeInterstitial) {
        }
    }

    class C03133 implements Runnable {
        C03133() {
        }

        public void run() {
            HashMap hashMap = new HashMap();
            String str = "";
            String str2 = "";
            HashMap requestInterstitial = NetworkHelper.requestInterstitial(AmobeeInterstitial.this.mAdSpace, AmobeeInterstitial.this.mRandom);
            if (requestInterstitial == null) {
                AmobeeInterstitial.this.mListener.interstitialFailed(AmobeeInterstitial.this);
                return;
            }
            if (requestInterstitial.get(NetworkHelper.FRAGMENT) != null) {
                str = (String) requestInterstitial.get(NetworkHelper.FRAGMENT);
                Log.m811d(AdManager.TAG, "Interstitial fragment: " + str);
            }
            String str3 = str;
            str = requestInterstitial.get(NetworkHelper.STATUS) != null ? (String) requestInterstitial.get(NetworkHelper.STATUS) : str2;
            if (str3.equals("") || !str.equals("6200")) {
                AmobeeInterstitial.this.mListener.interstitialFailed(AmobeeInterstitial.this);
                return;
            }
            AmobeeInterstitial.this.mHtml = str3;
            AmobeeInterstitial.this.mListener.interstitialRecieved(AmobeeInterstitial.this);
        }
    }

    class C03144 implements Runnable {
        C03144() {
        }

        public void run() {
            ViewGroup viewGroup = (ViewGroup) AmobeeInterstitial.this.mContext.getWindow().getDecorView().getRootView();
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            View frameLayout = new FrameLayout(AmobeeInterstitial.this.mContext);
            frameLayout.setId(AmobeeInterstitial.this.mRandom);
            frameLayout.setBackgroundColor(-1);
            View amobeeView = new AmobeeView(AmobeeInterstitial.this.mContext);
            frameLayout.setVisibility(8);
            viewGroup.addView(frameLayout);
            amobeeView.mViewState = ViewState.INTERSTITIAL;
            amobeeView.amobeeInterstitial = AmobeeInterstitial.this;
            amobeeView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            amobeeView.setUserGestureRequiredToOpenAds(AdManager.getInstance(AmobeeInterstitial.this.mContext).getUserGestureRequiredToOpenAds());
            frameLayout.addView(amobeeView, layoutParams);
            amobeeView.loadString(AmobeeInterstitial.this.mHtml, null);
            if (Integer.parseInt(VERSION.SDK) >= 14) {
                layoutParams.setMargins(0, AmobeeInterstitial.this.mStatusBarHeight, 0, 0);
            } else {
                frameLayout.setPadding(0, AmobeeInterstitial.this.mStatusBarHeight, 0, 0);
            }
        }
    }

    class C03155 implements Runnable {
        C03155() {
        }

        public void run() {
            AmobeeInterstitial.this.mIsShowed = false;
            FrameLayout frameLayout = (FrameLayout) AmobeeInterstitial.this.mContext.getWindow().getDecorView().getRootView();
            FrameLayout frameLayout2 = (FrameLayout) frameLayout.findViewById(AmobeeInterstitial.this.mRandom);
            if (frameLayout2 != null) {
                if (frameLayout2.getChildAt(0) != null && (frameLayout2.getChildAt(0) instanceof AmobeeView)) {
                    AmobeeView amobeeView = (AmobeeView) frameLayout2.getChildAt(0);
                    amobeeView.hideVideo();
                    amobeeView.hideMraidInterstitial();
                    if (VERSION.SDK_INT >= 19) {
                        amobeeView.onPause();
                    } else {
                        amobeeView.loadUrl("javascript:var videos = document.getElementsByTagName('video');for (i=0;i<videos.length;i++) {videos[i].pause();}");
                    }
                    amobeeView.setOrientationDefault();
                    amobeeView.amobeeInterstitial = null;
                }
                frameLayout2.removeAllViews();
                frameLayout.removeView(frameLayout2);
            }
        }
    }

    private void removeInterstitial() {
        this.mContext.runOnUiThread(new C03155());
    }

    public void closeInterstitial() {
        if (this.mIsShowed) {
            removeInterstitial();
            this.mListener.interstitialClosed(this);
        }
    }

    public void getInterstitial() {
        AdManager instance = AdManager.getInstance();
        if (instance == null || instance.parameters().getAdSpace() == null) {
            Log.m811d(AdManager.TAG, " AmobeeInterstitial - no ad space has been defined in the AdManager, adspace is mandatory in order to get ads.");
        } else {
            getInterstitial(instance.parameters().getAdSpace());
        }
    }

    public void getInterstitial(String str) {
        AdManager.getInstance();
        this.mAdSpace = str;
        if (this.mAdSpace == null || this.mAdSpace.equals("")) {
            Log.m811d(AdManager.TAG, " AmobeeInterstitial - The ad space field is mandatory in order to get ads.");
        } else {
            new Thread(new C03133()).start();
        }
    }

    public int getRandom() {
        return this.mRandom;
    }

    public void interstitialClicked() {
        removeInterstitial();
        this.mListener.interstitialClicked(this);
    }

    public void setListener(AmobeeInterstitialListener amobeeInterstitialListener) {
        if (amobeeInterstitialListener == null) {
            this.mListener = new C03122();
        } else {
            this.mListener = amobeeInterstitialListener;
        }
    }

    public synchronized void show(Activity activity) {
        this.mContext = activity;
        if (this.mContext instanceof Activity) {
            this.mStatusBarHeight = AdManager.getStatusBarHeight(this.mContext);
        }
        if (this.mIsShowed) {
            Log.m811d(AdManager.TAG, "interstitial is currently shown. please recall show() only after interstitialClosed(). ");
        } else if (this.mHtml == null || this.mHtml.equals("")) {
            Log.m811d(AdManager.TAG, "please call show() only after interstitialRecieved( AmobeeInterstitial ) is being called.");
        } else {
            this.mIsShowed = true;
            this.mContext.runOnUiThread(new C03144());
        }
    }
}
