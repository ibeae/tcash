package com.amobee.adsdk;

import android.app.Activity;
import android.content.Context;
import android.test.suitebuilder.annotation.Suppress;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdView;
import com.google.ads.C0631a;
import com.google.ads.C0631a.C0629a;
import com.google.ads.C0631a.C0630b;
import com.google.ads.C0632b;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

@Suppress
class AdMobAdapter extends BaseAdapter implements AdListener {
    private C0631a adRequest;
    private AdView adView;
    private boolean firedOnOverly = false;

    AdMobAdapter(Context context, Parameters parameters, String str, String str2) {
        super(context, parameters);
        this.adView = new AdView((Activity) context, C0632b.f753b, str);
        this.adView.setLayoutParams(new LayoutParams(-1, -2, 17));
        this.adRequest = new C0631a();
        this.adRequest.addTestDevice(C0631a.f751a);
        updateParameters(parameters);
        this.adView.setAdListener(this);
        if (str2 != null) {
            super.setCorrelator(str2);
        }
        getAd();
    }

    public void adFailed() {
        fireAdFailed(this.networkName);
    }

    public void adRecieved() {
        this.firedOnOverly = false;
        super.fireAdRecieved(this.networkName);
    }

    public void getAd() {
        updateParameters(this.am.parameters());
        this.adView.loadAd(this.adRequest);
    }

    public View getAdView() {
        return this.adView;
    }

    public void onDismissScreen(Ad ad) {
        onOverlayDismissed();
    }

    public void onError() {
    }

    public void onFailedToReceiveAd(Ad ad, C0629a c0629a) {
        adFailed();
    }

    public void onLeaveApplication(Ad ad) {
        onLeavingApplication();
    }

    public void onLeavingApplication() {
        this.am.getAmobeeListener().amobeeOnLeavingApplication(getPlaceHolder());
        if (!this.firedOnOverly) {
            NetworkHelper.sendNotification(BaseAdapter.createNotificationURL(29, super.getCorrelator()));
            this.firedOnOverly = true;
        }
    }

    public void onOverlay() {
        this.am.setIsExpanded(true);
        if (this.firedOnOverly) {
            this.am.fireOnOverlay(true, getPlaceHolder());
            return;
        }
        super.fireOnOverlay(true);
        this.firedOnOverly = true;
    }

    public void onOverlayDismissed() {
        super.fireOnOverlay(false);
        this.am.setIsExpanded(false);
    }

    public void onPresentScreen(Ad ad) {
        onOverlay();
    }

    public void onReceiveAd(Ad ad) {
        adRecieved();
    }

    public void updateParameters(Parameters parameters) {
        super.setParameters(parameters);
        Date dob = parameters.getDob();
        if (dob != null) {
            this.adRequest.setBirthday(new SimpleDateFormat("yyyyMMDD").format(dob));
        }
        String gender = parameters.getGender();
        if (!(parameters.getGender() == null || parameters.getGender().equals(""))) {
            if (gender.equals("m")) {
                this.adRequest.setGender(C0630b.MALE);
            }
            if (gender.equals("f")) {
                this.adRequest.setGender(C0630b.FEMALE);
            }
        }
        String[] keywords = parameters.getKeywords(Parameters.KEYWORD);
        if (keywords != null) {
            this.adRequest.setKeywords(new HashSet(Arrays.asList(keywords)));
        }
        if (parameters.getLocation() != null) {
            this.adRequest.setLocation(parameters.getLocation());
        }
    }
}
