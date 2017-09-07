package com.amobee.adsdk;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tapjoy.TapjoyConnect;
import com.tapjoy.TapjoyDisplayAdNotifier;

class TapJoyAdapter extends BaseAdapter implements TapjoyDisplayAdNotifier {
    View adView;

    TapJoyAdapter(Context context, Parameters parameters, String str, String str2, String str3) {
        super(context, parameters);
        TapjoyConnect.requestTapjoyConnect(context, str, str2);
        TapjoyConnect.getTapjoyConnectInstance().enableDisplayAdAutoRefresh(false);
        if (str3 != null) {
            super.setCorrelator(str3);
        }
        TapjoyConnect.getTapjoyConnectInstance().getDisplayAd(this);
    }

    public void adFailed() {
        fireAdFailed(this.networkName);
    }

    public void adRecieved() {
        fireAdRecieved(this.networkName);
    }

    public void getAd() {
        TapjoyConnect.getTapjoyConnectInstance().getDisplayAd(this);
    }

    public View getAdView() {
        return this.adView;
    }

    public void getDisplayAdResponse(View view) {
        this.adView = view;
        int i = this.adView.getLayoutParams().width;
        int i2 = this.adView.getLayoutParams().height;
        int i3 = 0;
        while (i3 < this.am.getPlaceholders().size()) {
            if (((AmobeeAdPlaceholder) this.am.getPlaceholders().get(i3)).getCurrentAdapter() != null && this == ((AmobeeAdPlaceholder) this.am.getPlaceholders().get(i3)).getCurrentAdapter()) {
                final AmobeeAdPlaceholder amobeeAdPlaceholder = (AmobeeAdPlaceholder) this.am.getPlaceholders().get(i3);
                int measuredWidth = amobeeAdPlaceholder.getMeasuredWidth();
                if (measuredWidth > i) {
                    measuredWidth = i;
                }
                this.adView.setLayoutParams(new LayoutParams(measuredWidth, (measuredWidth * i2) / i));
                ((Activity) this.am.getContext()).runOnUiThread(new Runnable() {
                    public void run() {
                        View childAt = amobeeAdPlaceholder.getChildAt(0);
                        View adView = TapJoyAdapter.this.getAdView();
                        if (childAt != adView) {
                            amobeeAdPlaceholder.removeView(childAt);
                        }
                        if (adView.getParent() != amobeeAdPlaceholder) {
                            if (adView.getParent() != null) {
                                ((ViewGroup) adView.getParent()).removeView(adView);
                            }
                            amobeeAdPlaceholder.addView(adView);
                        }
                    }
                });
            }
            i3++;
        }
        adRecieved();
    }

    public void getDisplayAdResponseFailed(String str) {
        adFailed();
    }

    public void onClickDisplayAd() {
        onLeavingApplication();
    }

    public void onError() {
    }

    public void onLeavingApplication() {
        NetworkHelper.sendNotification(BaseAdapter.createNotificationURL(29, super.getCorrelator()));
        this.am.getAmobeeListener().amobeeOnLeavingApplication(getPlaceHolder());
    }

    public void onOverlay() {
    }

    public void onOverlayDismissed() {
    }

    protected void updateParameters(Parameters parameters) {
    }
}
