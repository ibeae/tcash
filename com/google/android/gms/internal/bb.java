package com.google.android.gms.internal;

import com.google.ads.C0631a.C0629a;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

public final class bb<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final av f1002a;

    class C06891 implements Runnable {
        final /* synthetic */ bb f991a;

        C06891(bb bbVar) {
            this.f991a = bbVar;
        }

        public void run() {
            try {
                this.f991a.f1002a.mo877a();
            } catch (Throwable e) {
                dq.m2118c("Could not call onAdClicked.", e);
            }
        }
    }

    class C06913 implements Runnable {
        final /* synthetic */ bb f994a;

        C06913(bb bbVar) {
            this.f994a = bbVar;
        }

        public void run() {
            try {
                this.f994a.f1002a.mo880c();
            } catch (Throwable e) {
                dq.m2118c("Could not call onAdLeftApplication.", e);
            }
        }
    }

    class C06924 implements Runnable {
        final /* synthetic */ bb f995a;

        C06924(bb bbVar) {
            this.f995a = bbVar;
        }

        public void run() {
            try {
                this.f995a.f1002a.mo881d();
            } catch (Throwable e) {
                dq.m2118c("Could not call onAdOpened.", e);
            }
        }
    }

    class C06935 implements Runnable {
        final /* synthetic */ bb f996a;

        C06935(bb bbVar) {
            this.f996a = bbVar;
        }

        public void run() {
            try {
                this.f996a.f1002a.mo882e();
            } catch (Throwable e) {
                dq.m2118c("Could not call onAdLoaded.", e);
            }
        }
    }

    class C06946 implements Runnable {
        final /* synthetic */ bb f997a;

        C06946(bb bbVar) {
            this.f997a = bbVar;
        }

        public void run() {
            try {
                this.f997a.f1002a.mo879b();
            } catch (Throwable e) {
                dq.m2118c("Could not call onAdClosed.", e);
            }
        }
    }

    class C06968 implements Runnable {
        final /* synthetic */ bb f1000a;

        C06968(bb bbVar) {
            this.f1000a = bbVar;
        }

        public void run() {
            try {
                this.f1000a.f1002a.mo880c();
            } catch (Throwable e) {
                dq.m2118c("Could not call onAdLeftApplication.", e);
            }
        }
    }

    class C06979 implements Runnable {
        final /* synthetic */ bb f1001a;

        C06979(bb bbVar) {
            this.f1001a = bbVar;
        }

        public void run() {
            try {
                this.f1001a.f1002a.mo881d();
            } catch (Throwable e) {
                dq.m2118c("Could not call onAdOpened.", e);
            }
        }
    }

    public bb(av avVar) {
        this.f1002a = avVar;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        dq.m2112a("Adapter called onClick.");
        if (dp.m2111b()) {
            try {
                this.f1002a.mo877a();
                return;
            } catch (Throwable e) {
                dq.m2118c("Could not call onAdClicked.", e);
                return;
            }
        }
        dq.m2120e("onClick must be called on the main UI thread.");
        dp.f1344a.post(new C06891(this));
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        dq.m2112a("Adapter called onDismissScreen.");
        if (dp.m2111b()) {
            try {
                this.f1002a.mo879b();
                return;
            } catch (Throwable e) {
                dq.m2118c("Could not call onAdClosed.", e);
                return;
            }
        }
        dq.m2120e("onDismissScreen must be called on the main UI thread.");
        dp.f1344a.post(new C06946(this));
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        dq.m2112a("Adapter called onDismissScreen.");
        if (dp.m2111b()) {
            try {
                this.f1002a.mo879b();
                return;
            } catch (Throwable e) {
                dq.m2118c("Could not call onAdClosed.", e);
                return;
            }
        }
        dq.m2120e("onDismissScreen must be called on the main UI thread.");
        dp.f1344a.post(new Runnable(this) {
            final /* synthetic */ bb f990a;

            {
                this.f990a = r1;
            }

            public void run() {
                try {
                    this.f990a.f1002a.mo879b();
                } catch (Throwable e) {
                    dq.m2118c("Could not call onAdClosed.", e);
                }
            }
        });
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, final C0629a c0629a) {
        dq.m2112a("Adapter called onFailedToReceiveAd with error. " + c0629a);
        if (dp.m2111b()) {
            try {
                this.f1002a.mo878a(bc.m1665a(c0629a));
                return;
            } catch (Throwable e) {
                dq.m2118c("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        dq.m2120e("onFailedToReceiveAd must be called on the main UI thread.");
        dp.f1344a.post(new Runnable(this) {
            final /* synthetic */ bb f999b;

            public void run() {
                try {
                    this.f999b.f1002a.mo878a(bc.m1665a(c0629a));
                } catch (Throwable e) {
                    dq.m2118c("Could not call onAdFailedToLoad.", e);
                }
            }
        });
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, final C0629a c0629a) {
        dq.m2112a("Adapter called onFailedToReceiveAd with error " + c0629a + ".");
        if (dp.m2111b()) {
            try {
                this.f1002a.mo878a(bc.m1665a(c0629a));
                return;
            } catch (Throwable e) {
                dq.m2118c("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        dq.m2120e("onFailedToReceiveAd must be called on the main UI thread.");
        dp.f1344a.post(new Runnable(this) {
            final /* synthetic */ bb f993b;

            public void run() {
                try {
                    this.f993b.f1002a.mo878a(bc.m1665a(c0629a));
                } catch (Throwable e) {
                    dq.m2118c("Could not call onAdFailedToLoad.", e);
                }
            }
        });
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        dq.m2112a("Adapter called onLeaveApplication.");
        if (dp.m2111b()) {
            try {
                this.f1002a.mo880c();
                return;
            } catch (Throwable e) {
                dq.m2118c("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        dq.m2120e("onLeaveApplication must be called on the main UI thread.");
        dp.f1344a.post(new C06968(this));
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        dq.m2112a("Adapter called onLeaveApplication.");
        if (dp.m2111b()) {
            try {
                this.f1002a.mo880c();
                return;
            } catch (Throwable e) {
                dq.m2118c("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        dq.m2120e("onLeaveApplication must be called on the main UI thread.");
        dp.f1344a.post(new C06913(this));
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        dq.m2112a("Adapter called onPresentScreen.");
        if (dp.m2111b()) {
            try {
                this.f1002a.mo881d();
                return;
            } catch (Throwable e) {
                dq.m2118c("Could not call onAdOpened.", e);
                return;
            }
        }
        dq.m2120e("onPresentScreen must be called on the main UI thread.");
        dp.f1344a.post(new C06979(this));
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        dq.m2112a("Adapter called onPresentScreen.");
        if (dp.m2111b()) {
            try {
                this.f1002a.mo881d();
                return;
            } catch (Throwable e) {
                dq.m2118c("Could not call onAdOpened.", e);
                return;
            }
        }
        dq.m2120e("onPresentScreen must be called on the main UI thread.");
        dp.f1344a.post(new C06924(this));
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        dq.m2112a("Adapter called onReceivedAd.");
        if (dp.m2111b()) {
            try {
                this.f1002a.mo882e();
                return;
            } catch (Throwable e) {
                dq.m2118c("Could not call onAdLoaded.", e);
                return;
            }
        }
        dq.m2120e("onReceivedAd must be called on the main UI thread.");
        dp.f1344a.post(new Runnable(this) {
            final /* synthetic */ bb f989a;

            {
                this.f989a = r1;
            }

            public void run() {
                try {
                    this.f989a.f1002a.mo882e();
                } catch (Throwable e) {
                    dq.m2118c("Could not call onAdLoaded.", e);
                }
            }
        });
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        dq.m2112a("Adapter called onReceivedAd.");
        if (dp.m2111b()) {
            try {
                this.f1002a.mo882e();
                return;
            } catch (Throwable e) {
                dq.m2118c("Could not call onAdLoaded.", e);
                return;
            }
        }
        dq.m2120e("onReceivedAd must be called on the main UI thread.");
        dp.f1344a.post(new C06935(this));
    }
}
