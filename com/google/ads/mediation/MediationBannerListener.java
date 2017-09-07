package com.google.ads.mediation;

import com.google.ads.C0631a.C0629a;

@Deprecated
public interface MediationBannerListener {
    void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter);

    void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter);

    void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, C0629a c0629a);

    void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter);

    void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter);

    void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter);
}
