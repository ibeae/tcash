package com.amobee.adsdk;

public interface IAmobeeListener {
    void amobeeOnAdFailed(AmobeeAdPlaceholder amobeeAdPlaceholder);

    void amobeeOnAdRecieved(AmobeeAdPlaceholder amobeeAdPlaceholder);

    void amobeeOnError();

    void amobeeOnLeavingApplication(AmobeeAdPlaceholder amobeeAdPlaceholder);

    void amobeeOnOverlay(AmobeeAdPlaceholder amobeeAdPlaceholder);

    void amobeeOnOverlayDismissed(AmobeeAdPlaceholder amobeeAdPlaceholder);
}
