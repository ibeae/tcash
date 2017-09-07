package com.amobee.adsdk;

import android.content.Context;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

abstract class BaseAdapter implements IAmobee {
    protected static final int AD_CLICK_EXPAND = 29;
    protected static final int AD_FAILED = 0;
    protected static final int AD_IMPRESSION = 2;
    protected static final int AD_REQUEST = 1;
    protected AdManager am = AdManager.getInstance();
    private String correlator = "";
    Context m_context;
    Parameters m_parameters;
    protected String networkName = "amobee";

    BaseAdapter(Context context, Parameters parameters) {
        this.m_parameters = parameters;
        this.m_context = context;
    }

    protected static String createNotificationURL(int i, String str) {
        if (str == null) {
            str = "";
        }
        String str2 = "";
        try {
            str2 = URLEncoder.encode(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS").format(new Date()));
        } catch (Exception e) {
        }
        AdManager instance = AdManager.getInstance();
        Object obj = instance.getServerURL().split("/wap/")[0];
        if (!(instance.getNotificationServerURL() == null || instance.getNotificationServerURL().equals(""))) {
            obj = instance.getNotificationServerURL();
        }
        return new StringBuilder(String.valueOf(obj)).append("/notification?event=").append(i).append("&correlator=").append(str).append("&time=").append(str2).toString();
    }

    protected void fireAdFailed(String str) {
        NetworkHelper.sendNotification(createNotificationURL(0, this.correlator));
        this.am.amobeeIncNW = this.am.amobeeIncNW.replace(str, "");
        AdManager.getInstance().getAd(getPlaceHolder());
    }

    protected void fireAdRecieved(String str) {
        if (!str.equals("amobee")) {
            NetworkHelper.sendNotification(createNotificationURL(2, this.correlator));
        }
        AdManager instance = AdManager.getInstance();
        instance.getAmobeeListener().amobeeOnAdRecieved(getPlaceHolder());
    }

    protected void fireOnOverlay(boolean z) {
        this.am.fireOnOverlay(z, getPlaceHolder());
        if (z) {
            NetworkHelper.sendNotification(createNotificationURL(29, this.correlator));
        } else {
            this.am.getAd(true, this.am.getPlaceholders());
        }
    }

    protected String getCorrelator() {
        return this.correlator;
    }

    protected Parameters getParameters() {
        return this.m_parameters;
    }

    AmobeeAdPlaceholder getPlaceHolder() {
        for (int i = 0; i < this.am.getPlaceholders().size(); i++) {
            AmobeeAdPlaceholder amobeeAdPlaceholder = (AmobeeAdPlaceholder) this.am.getPlaceholders().get(i);
            if (amobeeAdPlaceholder != null && amobeeAdPlaceholder.getCurrentAdapter() != null && this == amobeeAdPlaceholder.getCurrentAdapter()) {
                return amobeeAdPlaceholder;
            }
        }
        return null;
    }

    protected void setCorrelator(String str) {
        this.correlator = str;
    }

    protected void setParameters(Parameters parameters) {
        this.m_parameters = parameters;
    }

    protected abstract void updateParameters(Parameters parameters);
}
