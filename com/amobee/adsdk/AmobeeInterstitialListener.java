package com.amobee.adsdk;

public interface AmobeeInterstitialListener {
    void interstitialClicked(AmobeeInterstitial amobeeInterstitial);

    void interstitialClosed(AmobeeInterstitial amobeeInterstitial);

    void interstitialFailed(AmobeeInterstitial amobeeInterstitial);

    void interstitialRecieved(AmobeeInterstitial amobeeInterstitial);
}
