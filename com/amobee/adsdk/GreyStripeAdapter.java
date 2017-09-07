package com.amobee.adsdk;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.greystripe.sdk.GSAd;
import com.greystripe.sdk.GSAdErrorCode;
import com.greystripe.sdk.GSAdListener;
import com.greystripe.sdk.GSMobileBannerAdView;

class GreyStripeAdapter extends BaseAdapter implements GSAdListener {
    private int AD_HIGHT = 50;
    private int AD_WIDTH = 320;
    private GSMobileBannerAdView adView;

    GreyStripeAdapter(Context context, Parameters parameters, String str, String str2) {
        super(context, parameters);
        this.adView = new GSMobileBannerAdView(context, str);
        this.adView.addListener(this);
        this.adView.setLayoutParams(new LayoutParams((int) ((((double) this.AD_WIDTH) * this.am.getDensity()) + 0.5d), (int) ((((double) this.AD_HIGHT) * this.am.getDensity()) + 0.5d), 17));
        if (str2 != null) {
            super.setCorrelator(str2);
        }
        getAd();
    }

    public void adFailed() {
        fireAdFailed(this.networkName);
    }

    public void adRecieved() {
        fireAdRecieved(this.networkName);
    }

    public void getAd() {
        this.adView.refresh();
    }

    public View getAdView() {
        return this.adView;
    }

    public void onAdClickthrough(GSAd gSAd) {
        onLeavingApplication();
    }

    public void onAdCollapse(GSAd gSAd) {
        onOverlayDismissed();
    }

    public void onAdDismissal(GSAd gSAd) {
        Log.m811d(AdManager.TAG, " GreyStripe onAdDismissal event:  this event is not handle by amobee , pls contact amobee ");
    }

    public void onAdExpansion(GSAd gSAd) {
        onOverlay();
    }

    public void onError() {
    }

    public void onFailedToFetchAd(GSAd gSAd, GSAdErrorCode gSAdErrorCode) {
        adFailed();
    }

    public void onFetchedAd(GSAd gSAd) {
        adRecieved();
    }

    public void onLeavingApplication() {
        NetworkHelper.sendNotification(BaseAdapter.createNotificationURL(29, super.getCorrelator()));
        this.am.getAmobeeListener().amobeeOnLeavingApplication(getPlaceHolder());
    }

    public void onOverlay() {
        super.fireOnOverlay(true);
    }

    public void onOverlayDismissed() {
        super.fireOnOverlay(false);
    }

    protected void updateParameters(Parameters parameters) {
    }
}
