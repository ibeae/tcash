package com.google.ads.mediation.amobee;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.amobee.adsdk.AdManager;
import com.amobee.adsdk.AmobeeAdPlaceholder;
import com.amobee.adsdk.AmobeeInterstitial;
import com.amobee.adsdk.AmobeeInterstitialListener;
import com.amobee.adsdk.IAmobeeListener;
import com.amobee.adsdk.Parameters.Gender;
import com.google.ads.C0631a.C0629a;
import com.google.ads.C0631a.C0630b;
import com.google.ads.C0632b;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;

public final class AmobeeAdapter implements AmobeeInterstitialListener, IAmobeeListener, MediationBannerAdapter<AmobeeExtras, AmobeeServerParameters>, MediationInterstitialAdapter<AmobeeExtras, AmobeeServerParameters> {
    public static final String TAG = "Gooogle AmobeeAdapter";
    private AdManager adManager;
    private AmobeeAdPlaceholder amobeeAdPlaceholder = null;
    private AmobeeInterstitial amobeeInterstitial = null;
    private Activity bannerActivity = null;
    private MediationBannerListener bannerListener;
    private boolean bannerNeedToReportDismiss = false;
    private boolean interstitalNeedToReportDismiss = false;
    private Activity interstitialActivity = null;
    private MediationInterstitialListener interstitialListener;
    private boolean onClickWasCalledOnOverlay = false;

    private void configureRequestParameters(MediationAdRequest mediationAdRequest) {
        if (mediationAdRequest.getBirthday() != null) {
            this.adManager.parameters().setDob(mediationAdRequest.getBirthday());
        }
        if (mediationAdRequest.getAgeInYears() != null) {
            this.adManager.parameters().setAge(mediationAdRequest.getAgeInYears().intValue());
        }
        if (mediationAdRequest.getLocation() != null) {
            this.adManager.parameters().setLocation(mediationAdRequest.getLocation());
        }
        if (mediationAdRequest.getGender() != null) {
            C0630b gender = mediationAdRequest.getGender();
            if (gender == C0630b.MALE) {
                this.adManager.parameters().setGender(Gender.Male);
            } else if (gender == C0630b.FEMALE) {
                this.adManager.parameters().setGender(Gender.Female);
            }
        }
        if (mediationAdRequest.getKeywords() != null) {
            for (String addKeyword : mediationAdRequest.getKeywords()) {
                this.adManager.parameters().addKeyword(addKeyword);
            }
        }
    }

    private void configureServerUrl(AdManager adManager, AmobeeServerParameters amobeeServerParameters) {
        if (adManager.getServerURL() == null || adManager.getServerURL().equals("")) {
            adManager.setServerURL("http://rrmprod.amobee.com/upsteed/wap/adrequest");
        }
        if (amobeeServerParameters.domain != null && !amobeeServerParameters.domain.equals("")) {
            String str = amobeeServerParameters.domain;
            if (!str.startsWith("http")) {
                str = "http://" + str;
            }
            if (str.endsWith(".com")) {
                str = new StringBuilder(String.valueOf(str)).append("/upsteed/wap/adrequest").toString();
            }
            adManager.setServerURL(str);
        }
    }

    private void registerActivityLifecycleCallbacks(final Activity activity, final boolean z) {
        if (activity != null && VERSION.SDK_INT >= 14) {
            activity.getApplication().registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    Log.d(AmobeeAdapter.TAG, "onActivityCreated");
                }

                public void onActivityDestroyed(Activity activity) {
                    Log.d(AmobeeAdapter.TAG, "onActivityDestroyed");
                }

                public void onActivityPaused(Activity activity) {
                    Log.d(AmobeeAdapter.TAG, "onActivityPaused");
                }

                public void onActivityResumed(Activity activity) {
                    Log.d(AmobeeAdapter.TAG, "onActivityResumed");
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    Log.d(AmobeeAdapter.TAG, "onActivitySaveInstanceState");
                }

                public void onActivityStarted(Activity activity) {
                    Log.d(AmobeeAdapter.TAG, "onActivityStarted");
                    if (activity == activity) {
                        if (z && AmobeeAdapter.this.bannerNeedToReportDismiss) {
                            AmobeeAdapter.this.bannerListener.onDismissScreen(AmobeeAdapter.this);
                            AmobeeAdapter.this.bannerNeedToReportDismiss = false;
                        }
                        if (!z && AmobeeAdapter.this.interstitalNeedToReportDismiss) {
                            if (AmobeeAdapter.this.interstitialListener != null) {
                                AmobeeAdapter.this.interstitialListener.onDismissScreen(AmobeeAdapter.this);
                            }
                            AmobeeAdapter.this.interstitalNeedToReportDismiss = false;
                        }
                    }
                    activity.getApplication().unregisterActivityLifecycleCallbacks(this);
                }

                public void onActivityStopped(Activity activity) {
                    Log.d(AmobeeAdapter.TAG, "onActivityStopped");
                }
            });
        }
    }

    public void amobeeOnAdFailed(AmobeeAdPlaceholder amobeeAdPlaceholder) {
        if (this.bannerListener != null) {
            this.bannerListener.onFailedToReceiveAd(this, C0629a.NO_FILL);
        }
    }

    public void amobeeOnAdRecieved(AmobeeAdPlaceholder amobeeAdPlaceholder) {
        if (this.bannerListener != null) {
            this.bannerListener.onReceivedAd(this);
        }
    }

    public void amobeeOnError() {
    }

    public void amobeeOnLeavingApplication(AmobeeAdPlaceholder amobeeAdPlaceholder) {
        if (!this.onClickWasCalledOnOverlay) {
            this.bannerNeedToReportDismiss = true;
            if (this.bannerListener != null) {
                this.bannerListener.onClick(this);
                this.bannerListener.onPresentScreen(this);
            }
        }
        registerActivityLifecycleCallbacks(this.bannerActivity, true);
        if (this.bannerListener != null) {
            this.bannerListener.onLeaveApplication(this);
        }
    }

    public void amobeeOnOverlay(AmobeeAdPlaceholder amobeeAdPlaceholder) {
        this.onClickWasCalledOnOverlay = true;
        if (this.bannerListener != null) {
            this.bannerListener.onClick(this);
            this.bannerListener.onPresentScreen(this);
        }
    }

    public void amobeeOnOverlayDismissed(AmobeeAdPlaceholder amobeeAdPlaceholder) {
        this.onClickWasCalledOnOverlay = false;
        if (this.bannerListener != null) {
            this.bannerListener.onDismissScreen(this);
        }
    }

    public void destroy() {
        this.bannerListener = null;
        this.interstitialListener = null;
    }

    public Class<AmobeeExtras> getAdditionalParametersType() {
        return AmobeeExtras.class;
    }

    public View getBannerView() {
        return this.amobeeAdPlaceholder;
    }

    public Class<AmobeeServerParameters> getServerParametersType() {
        return AmobeeServerParameters.class;
    }

    public void interstitialClicked(AmobeeInterstitial amobeeInterstitial) {
        this.interstitalNeedToReportDismiss = true;
        registerActivityLifecycleCallbacks(this.interstitialActivity, false);
        if (this.interstitialListener != null) {
            this.interstitialListener.onLeaveApplication(this);
        }
    }

    public void interstitialClosed(AmobeeInterstitial amobeeInterstitial) {
        if (this.interstitialListener != null) {
            this.interstitialListener.onDismissScreen(this);
        }
    }

    public void interstitialFailed(AmobeeInterstitial amobeeInterstitial) {
        if (this.interstitialListener != null) {
            this.interstitialListener.onFailedToReceiveAd(this, C0629a.NO_FILL);
        }
    }

    public void interstitialRecieved(AmobeeInterstitial amobeeInterstitial) {
        if (this.interstitialListener != null) {
            this.interstitialListener.onReceivedAd(this);
        }
    }

    public void requestBannerAd(MediationBannerListener mediationBannerListener, Activity activity, AmobeeServerParameters amobeeServerParameters, C0632b c0632b, MediationAdRequest mediationAdRequest, AmobeeExtras amobeeExtras) {
        this.adManager = AdManager.getInstance(activity);
        this.bannerListener = mediationBannerListener;
        this.bannerActivity = activity;
        this.onClickWasCalledOnOverlay = false;
        if (this.amobeeAdPlaceholder == null) {
            this.amobeeAdPlaceholder = new AmobeeAdPlaceholder(activity);
        }
        this.amobeeAdPlaceholder.setLayoutParams(new LayoutParams(c0632b.m1303a(activity), c0632b.m1305b(activity)));
        if (c0632b.m1302a() < 0 || c0632b.m1304b() < 0) {
            double density = (double) AdManager.getDensity(activity);
            this.amobeeAdPlaceholder.setBannerSize((int) (((double) c0632b.m1303a(activity)) / density), (int) (((double) c0632b.m1305b(activity)) / density));
        } else {
            this.amobeeAdPlaceholder.setBannerSize(c0632b.m1302a(), c0632b.m1304b());
        }
        this.amobeeAdPlaceholder.amrp = true;
        configureServerUrl(this.adManager, amobeeServerParameters);
        configureRequestParameters(mediationAdRequest);
        this.adManager.setAmobeeListener(this);
        this.amobeeAdPlaceholder.setAdSpace(amobeeServerParameters.adspace);
        this.adManager.getAd(this.amobeeAdPlaceholder);
    }

    public void requestInterstitialAd(MediationInterstitialListener mediationInterstitialListener, Activity activity, AmobeeServerParameters amobeeServerParameters, MediationAdRequest mediationAdRequest, AmobeeExtras amobeeExtras) {
        this.adManager = AdManager.getInstance(activity);
        configureServerUrl(this.adManager, amobeeServerParameters);
        configureRequestParameters(mediationAdRequest);
        this.interstitialActivity = activity;
        this.interstitialListener = mediationInterstitialListener;
        this.amobeeInterstitial = new AmobeeInterstitial();
        this.amobeeInterstitial.setListener(this);
        this.amobeeInterstitial.getInterstitial(amobeeServerParameters.adspace);
    }

    public void showInterstitial() {
        if (this.amobeeInterstitial != null && this.interstitialActivity != null) {
            if (this.interstitialListener != null) {
                this.interstitialListener.onPresentScreen(this);
            }
            this.amobeeInterstitial.show(this.interstitialActivity);
        }
    }
}
