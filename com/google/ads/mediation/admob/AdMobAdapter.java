package com.google.ads.mediation.admob;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.dp;
import java.util.Date;
import java.util.Set;

public final class AdMobAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
    private AdView f768i;
    private InterstitialAd f769j;

    private static final class C0633a extends AdListener {
        private final AdMobAdapter f764k;
        private final MediationBannerListener f765l;

        public C0633a(AdMobAdapter adMobAdapter, MediationBannerListener mediationBannerListener) {
            this.f764k = adMobAdapter;
            this.f765l = mediationBannerListener;
        }

        public void onAdClosed() {
            this.f765l.mo904c(this.f764k);
        }

        public void onAdFailedToLoad(int i) {
            this.f765l.mo899a(this.f764k, i);
        }

        public void onAdLeftApplication() {
            this.f765l.mo906d(this.f764k);
        }

        public void onAdLoaded() {
            this.f765l.mo898a(this.f764k);
        }

        public void onAdOpened() {
            this.f765l.mo908e(this.f764k);
            this.f765l.mo902b(this.f764k);
        }
    }

    private static final class C0634b extends AdListener {
        private final AdMobAdapter f766k;
        private final MediationInterstitialListener f767m;

        public C0634b(AdMobAdapter adMobAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f766k = adMobAdapter;
            this.f767m = mediationInterstitialListener;
        }

        public void onAdClosed() {
            this.f767m.mo905c(this.f766k);
        }

        public void onAdFailedToLoad(int i) {
            this.f767m.mo901a(this.f766k, i);
        }

        public void onAdLeftApplication() {
            this.f767m.mo907d(this.f766k);
        }

        public void onAdLoaded() {
            this.f767m.mo900a(this.f766k);
        }

        public void onAdOpened() {
            this.f767m.mo903b(this.f766k);
        }
    }

    private static AdRequest m1307a(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        Builder builder = new Builder();
        Date a = mediationAdRequest.mo894a();
        if (a != null) {
            builder.m1392a(a);
        }
        int b = mediationAdRequest.mo895b();
        if (b != 0) {
            builder.m1389a(b);
        }
        Set<String> c = mediationAdRequest.mo896c();
        if (c != null) {
            for (String a2 : c) {
                builder.m1391a(a2);
            }
        }
        if (mediationAdRequest.mo897d()) {
            builder.m1395b(dp.m2105a(context));
        }
        if (bundle2.getInt("tagForChildDirectedTreatment") != -1) {
            builder.m1393a(bundle2.getInt("tagForChildDirectedTreatment") == 1);
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("gw", 1);
        bundle.putString("mad_hac", bundle2.getString("mad_hac"));
        if (!TextUtils.isEmpty(bundle2.getString("adJson"))) {
            bundle.putString("_ad", bundle2.getString("adJson"));
        }
        bundle.putBoolean("_noRefresh", true);
        builder.m1390a(AdMobAdapter.class, bundle);
        return builder.m1394a();
    }

    public View getBannerView() {
        return this.f768i;
    }

    public void onDestroy() {
        if (this.f768i != null) {
            this.f768i.m1401a();
            this.f768i = null;
        }
        if (this.f769j != null) {
            this.f769j = null;
        }
    }

    public void onPause() {
        if (this.f768i != null) {
            this.f768i.m1403b();
        }
    }

    public void onResume() {
        if (this.f768i != null) {
            this.f768i.m1404c();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f768i = new AdView(context);
        this.f768i.setAdSize(new AdSize(adSize.m1399b(), adSize.m1397a()));
        this.f768i.setAdUnitId(bundle.getString("pubid"));
        this.f768i.setAdListener(new C0633a(this, mediationBannerListener));
        this.f768i.m1402a(m1307a(context, mediationAdRequest, bundle2, bundle));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f769j = new InterstitialAd(context);
        this.f769j.m1408a(bundle.getString("pubid"));
        this.f769j.m1406a(new C0634b(this, mediationInterstitialListener));
        this.f769j.m1407a(m1307a(context, mediationAdRequest, bundle2, bundle));
    }

    public void showInterstitial() {
        this.f769j.m1405a();
    }
}
