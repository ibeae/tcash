package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.C0631a.C0629a;
import com.google.ads.C0632b;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.internal.dq;

public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    private View f775n;
    private CustomEventBanner f776o;
    private CustomEventInterstitial f777p;

    private static final class C0636a implements CustomEventBannerListener {
        private final CustomEventAdapter f770q;
        private final MediationBannerListener f771r;

        public C0636a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f770q = customEventAdapter;
            this.f771r = mediationBannerListener;
        }

        public void onClick() {
            dq.m2112a("Custom event adapter called onFailedToReceiveAd.");
            this.f771r.onClick(this.f770q);
        }

        public void onDismissScreen() {
            dq.m2112a("Custom event adapter called onFailedToReceiveAd.");
            this.f771r.onDismissScreen(this.f770q);
        }

        public void onFailedToReceiveAd() {
            dq.m2112a("Custom event adapter called onFailedToReceiveAd.");
            this.f771r.onFailedToReceiveAd(this.f770q, C0629a.NO_FILL);
        }

        public void onLeaveApplication() {
            dq.m2112a("Custom event adapter called onFailedToReceiveAd.");
            this.f771r.onLeaveApplication(this.f770q);
        }

        public void onPresentScreen() {
            dq.m2112a("Custom event adapter called onFailedToReceiveAd.");
            this.f771r.onPresentScreen(this.f770q);
        }

        public void onReceivedAd(View view) {
            dq.m2112a("Custom event adapter called onReceivedAd.");
            this.f770q.m1309a(view);
            this.f771r.onReceivedAd(this.f770q);
        }
    }

    private class C0637b implements CustomEventInterstitialListener {
        private final CustomEventAdapter f772q;
        private final MediationInterstitialListener f773s;
        final /* synthetic */ CustomEventAdapter f774t;

        public C0637b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.f774t = customEventAdapter;
            this.f772q = customEventAdapter2;
            this.f773s = mediationInterstitialListener;
        }

        public void onDismissScreen() {
            dq.m2112a("Custom event adapter called onDismissScreen.");
            this.f773s.onDismissScreen(this.f772q);
        }

        public void onFailedToReceiveAd() {
            dq.m2112a("Custom event adapter called onFailedToReceiveAd.");
            this.f773s.onFailedToReceiveAd(this.f772q, C0629a.NO_FILL);
        }

        public void onLeaveApplication() {
            dq.m2112a("Custom event adapter called onLeaveApplication.");
            this.f773s.onLeaveApplication(this.f772q);
        }

        public void onPresentScreen() {
            dq.m2112a("Custom event adapter called onPresentScreen.");
            this.f773s.onPresentScreen(this.f772q);
        }

        public void onReceivedAd() {
            dq.m2112a("Custom event adapter called onReceivedAd.");
            this.f773s.onReceivedAd(this.f774t);
        }
    }

    private static <T> T m1308a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            dq.m2120e("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    private void m1309a(View view) {
        this.f775n = view;
    }

    public void destroy() {
        if (this.f776o != null) {
            this.f776o.destroy();
        }
        if (this.f777p != null) {
            this.f777p.destroy();
        }
    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public View getBannerView() {
        return this.f775n;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener mediationBannerListener, Activity activity, CustomEventServerParameters customEventServerParameters, C0632b c0632b, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f776o = (CustomEventBanner) m1308a(customEventServerParameters.className);
        if (this.f776o == null) {
            mediationBannerListener.onFailedToReceiveAd(this, C0629a.INTERNAL_ERROR);
        } else {
            this.f776o.requestBannerAd(new C0636a(this, mediationBannerListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, c0632b, mediationAdRequest, customEventExtras == null ? null : customEventExtras.m1431a(customEventServerParameters.label));
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener mediationInterstitialListener, Activity activity, CustomEventServerParameters customEventServerParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f777p = (CustomEventInterstitial) m1308a(customEventServerParameters.className);
        if (this.f777p == null) {
            mediationInterstitialListener.onFailedToReceiveAd(this, C0629a.INTERNAL_ERROR);
        } else {
            this.f777p.requestInterstitialAd(new C0637b(this, this, mediationInterstitialListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.m1431a(customEventServerParameters.label));
        }
    }

    public void showInterstitial() {
        this.f777p.showInterstitial();
    }
}
