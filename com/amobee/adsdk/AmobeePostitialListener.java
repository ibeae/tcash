package com.amobee.adsdk;

public interface AmobeePostitialListener {
    void postitialClicked(AmobeePostitial amobeePostitial);

    void postitialClosed(AmobeePostitial amobeePostitial);

    void postitialFailed(AmobeePostitial amobeePostitial);

    void postitialOnKey(int i);

    void postitialRecieved(AmobeePostitial amobeePostitial);
}
