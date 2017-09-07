package com.google.android.gms.internal;

import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

public final class az implements MediationBannerListener, MediationInterstitialListener {
    private final av f983a;

    public az(av avVar) {
        this.f983a = avVar;
    }

    public void mo898a(MediationBannerAdapter mediationBannerAdapter) {
        ek.m2338b("onAdLoaded must be called on the main UI thread.");
        dq.m2112a("Adapter called onAdLoaded.");
        try {
            this.f983a.mo882e();
        } catch (Throwable e) {
            dq.m2118c("Could not call onAdLoaded.", e);
        }
    }

    public void mo899a(MediationBannerAdapter mediationBannerAdapter, int i) {
        ek.m2338b("onAdFailedToLoad must be called on the main UI thread.");
        dq.m2112a("Adapter called onAdFailedToLoad with error. " + i);
        try {
            this.f983a.mo878a(i);
        } catch (Throwable e) {
            dq.m2118c("Could not call onAdFailedToLoad.", e);
        }
    }

    public void mo900a(MediationInterstitialAdapter mediationInterstitialAdapter) {
        ek.m2338b("onAdLoaded must be called on the main UI thread.");
        dq.m2112a("Adapter called onAdLoaded.");
        try {
            this.f983a.mo882e();
        } catch (Throwable e) {
            dq.m2118c("Could not call onAdLoaded.", e);
        }
    }

    public void mo901a(MediationInterstitialAdapter mediationInterstitialAdapter, int i) {
        ek.m2338b("onAdFailedToLoad must be called on the main UI thread.");
        dq.m2112a("Adapter called onAdFailedToLoad with error " + i + ".");
        try {
            this.f983a.mo878a(i);
        } catch (Throwable e) {
            dq.m2118c("Could not call onAdFailedToLoad.", e);
        }
    }

    public void mo902b(MediationBannerAdapter mediationBannerAdapter) {
        ek.m2338b("onAdOpened must be called on the main UI thread.");
        dq.m2112a("Adapter called onAdOpened.");
        try {
            this.f983a.mo881d();
        } catch (Throwable e) {
            dq.m2118c("Could not call onAdOpened.", e);
        }
    }

    public void mo903b(MediationInterstitialAdapter mediationInterstitialAdapter) {
        ek.m2338b("onAdOpened must be called on the main UI thread.");
        dq.m2112a("Adapter called onAdOpened.");
        try {
            this.f983a.mo881d();
        } catch (Throwable e) {
            dq.m2118c("Could not call onAdOpened.", e);
        }
    }

    public void mo904c(MediationBannerAdapter mediationBannerAdapter) {
        ek.m2338b("onAdClosed must be called on the main UI thread.");
        dq.m2112a("Adapter called onAdClosed.");
        try {
            this.f983a.mo879b();
        } catch (Throwable e) {
            dq.m2118c("Could not call onAdClosed.", e);
        }
    }

    public void mo905c(MediationInterstitialAdapter mediationInterstitialAdapter) {
        ek.m2338b("onAdClosed must be called on the main UI thread.");
        dq.m2112a("Adapter called onAdClosed.");
        try {
            this.f983a.mo879b();
        } catch (Throwable e) {
            dq.m2118c("Could not call onAdClosed.", e);
        }
    }

    public void mo906d(MediationBannerAdapter mediationBannerAdapter) {
        ek.m2338b("onAdLeftApplication must be called on the main UI thread.");
        dq.m2112a("Adapter called onAdLeftApplication.");
        try {
            this.f983a.mo880c();
        } catch (Throwable e) {
            dq.m2118c("Could not call onAdLeftApplication.", e);
        }
    }

    public void mo907d(MediationInterstitialAdapter mediationInterstitialAdapter) {
        ek.m2338b("onAdLeftApplication must be called on the main UI thread.");
        dq.m2112a("Adapter called onAdLeftApplication.");
        try {
            this.f983a.mo880c();
        } catch (Throwable e) {
            dq.m2118c("Could not call onAdLeftApplication.", e);
        }
    }

    public void mo908e(MediationBannerAdapter mediationBannerAdapter) {
        ek.m2338b("onAdClicked must be called on the main UI thread.");
        dq.m2112a("Adapter called onAdClicked.");
        try {
            this.f983a.mo877a();
        } catch (Throwable e) {
            dq.m2118c("Could not call onAdClicked.", e);
        }
    }
}
