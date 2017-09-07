package com.amobee.adsdk;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

class GmsAdsAdapter extends BaseAdapter {
    private AdRequest adRequest;
    private AdView adView;
    private boolean firedOnOverly = false;

    class C03241 extends AdListener {
        C03241() {
        }

        public void onAdClosed() {
            GmsAdsAdapter.this.fireOnOverlay(false);
            GmsAdsAdapter.this.am.setIsExpanded(false);
        }

        public void onAdFailedToLoad(int i) {
            GmsAdsAdapter.this.fireAdFailed(GmsAdsAdapter.this.networkName);
        }

        public void onAdLeftApplication() {
            GmsAdsAdapter.this.am.getAmobeeListener().amobeeOnLeavingApplication(GmsAdsAdapter.this.getPlaceHolder());
            if (!GmsAdsAdapter.this.firedOnOverly) {
                NetworkHelper.sendNotification(BaseAdapter.createNotificationURL(29, GmsAdsAdapter.this.getCorrelator()));
                GmsAdsAdapter.this.firedOnOverly = true;
            }
        }

        public void onAdLoaded() {
            GmsAdsAdapter.this.firedOnOverly = false;
            GmsAdsAdapter.this.fireAdRecieved(GmsAdsAdapter.this.networkName);
        }

        public void onAdOpened() {
            GmsAdsAdapter.this.am.setIsExpanded(true);
            if (GmsAdsAdapter.this.firedOnOverly) {
                GmsAdsAdapter.this.am.fireOnOverlay(true, GmsAdsAdapter.this.getPlaceHolder());
                return;
            }
            GmsAdsAdapter.this.fireOnOverlay(true);
            GmsAdsAdapter.this.firedOnOverly = true;
        }
    }

    GmsAdsAdapter(Context context, Parameters parameters, String str, String str2) {
        super(context, parameters);
        this.adView = new AdView((Activity) context);
        this.adView.setAdSize(AdSize.f815a);
        this.adView.setAdUnitId(str);
        this.adView.setLayoutParams(new LayoutParams(-1, -2, 17));
        this.adRequest = new Builder().m1395b(AdRequest.f813a).m1394a();
        updateParameters(parameters);
        this.adView.setAdListener(new C03241());
        if (str2 != null) {
            super.setCorrelator(str2);
        }
        getAd();
    }

    public void adFailed() {
    }

    public void adRecieved() {
    }

    public void getAd() {
        updateParameters(this.am.parameters());
        this.adView.m1402a(this.adRequest);
    }

    public View getAdView() {
        return this.adView;
    }

    public void onError() {
    }

    public void onLeavingApplication() {
    }

    public void onOverlay() {
    }

    public void onOverlayDismissed() {
    }

    public void updateParameters(Parameters parameters) {
        super.setParameters(parameters);
        Builder builder = new Builder();
        Date dob = parameters.getDob();
        if (dob != null) {
            new SimpleDateFormat("yyyyMMDD").format(dob);
            builder.m1392a(dob);
        }
        String gender = parameters.getGender();
        if (!(parameters.getGender() == null || parameters.getGender().equals(""))) {
            if (gender.equals("m")) {
                builder.m1389a(1);
            }
            if (gender.equals("f")) {
                builder.m1389a(2);
            }
        }
        String[] keywords = parameters.getKeywords(Parameters.KEYWORD);
        if (keywords != null) {
            HashSet hashSet = new HashSet(Arrays.asList(keywords));
            for (String a : keywords) {
                builder.m1391a(a);
            }
        }
        this.adRequest = builder.m1395b(AdRequest.f813a).m1394a();
    }
}
