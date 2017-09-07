package com.google.ads.mediation.customevent;

import android.app.Activity;
import com.google.ads.C0632b;
import com.google.ads.mediation.MediationAdRequest;

@Deprecated
public interface CustomEventBanner extends CustomEvent {
    void requestBannerAd(CustomEventBannerListener customEventBannerListener, Activity activity, String str, String str2, C0632b c0632b, MediationAdRequest mediationAdRequest, Object obj);
}
