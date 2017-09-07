package com.amobee.adsdk;

import android.view.View;

interface IAmobee {
    void adFailed();

    void adRecieved();

    void getAd();

    View getAdView();

    void onError();

    void onLeavingApplication();

    void onOverlay();

    void onOverlayDismissed();
}
