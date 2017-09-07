package com.amobee.adsdk;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.amobee.adsdk.AdManager.DebugLevel;
import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMAdView;
import com.millennialmedia.android.MMException;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.MMRequest;
import com.millennialmedia.android.MMSDK;
import com.millennialmedia.android.RequestListener;
import java.util.Hashtable;

class MillennialAdapter extends BaseAdapter implements RequestListener {
    private static final int BANNER_AD_HEIGHT = 50;
    private static final int BANNER_AD_WIDTH = 320;
    private static final int IAB_LEADERBOARD_HEIGHT = 90;
    private static final int IAB_LEADERBOARD_WIDTH = 728;
    private static final int MED_BANNER_HEIGHT = 60;
    private static final int MED_BANNER_WIDTH = 480;
    private MMAdView adView;
    AdManager am = AdManager.getInstance();
    private boolean didReportClick = false;
    private Hashtable<String, String> map = new Hashtable();
    AmobeeAdPlaceholder placeholder;
    MMRequest request;

    MillennialAdapter(Context context, Parameters parameters, String str, String str2, AmobeeAdPlaceholder amobeeAdPlaceholder) {
        int i = IAB_LEADERBOARD_WIDTH;
        super(context, parameters);
        this.placeholder = amobeeAdPlaceholder;
        updateParameters(parameters);
        AdManager instance = AdManager.getInstance();
        try {
            MMSDK.initialize(context);
            this.adView = new MMAdView(context);
            this.adView.setApid(str);
            if (AdManager.debugLevel == DebugLevel.DEBUG) {
                MMLog.setLogLevel(1);
            }
            int i2 = 50;
            if (canFit(IAB_LEADERBOARD_WIDTH)) {
                i2 = IAB_LEADERBOARD_HEIGHT;
            } else if (canFit(MED_BANNER_WIDTH)) {
                i2 = 60;
                i = MED_BANNER_WIDTH;
            } else {
                i = BANNER_AD_WIDTH;
            }
            this.adView.setWidth(i);
            this.adView.setHeight(i2);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, (float) i, this.m_context.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, (float) i2, this.m_context.getResources().getDisplayMetrics()));
            layoutParams.addRule(10);
            layoutParams.addRule(14);
            this.adView.setLayoutParams(layoutParams);
            this.request = new MMRequest();
            this.request.setMetaValues(this.map);
            if (instance.parameters().lastKnownLocation != null) {
                MMRequest.setUserLocation(instance.parameters().lastKnownLocation);
            }
            this.adView.setMMRequest(this.request);
            this.adView.setId(MMSDK.getDefaultAdId());
            this.adView.setListener(this);
            if (str2 != null) {
                super.setCorrelator(str2);
            }
            getAd();
        } catch (VerifyError e) {
            adFailed();
        } catch (Exception e2) {
            adFailed();
        }
    }

    public void MMAdOverlayClosed(MMAd mMAd) {
        onOverlayDismissed();
    }

    public void MMAdOverlayLaunched(MMAd mMAd) {
        onOverlay();
    }

    public void MMAdRequestIsCaching(MMAd mMAd) {
    }

    public void adFailed() {
        this.didReportClick = false;
        super.fireAdFailed(this.networkName);
    }

    public void adRecieved() {
        this.didReportClick = false;
        super.fireAdRecieved(this.networkName);
    }

    protected boolean canFit(int i) {
        return this.m_context.getResources().getDisplayMetrics().widthPixels >= ((int) TypedValue.applyDimension(1, (float) i, this.m_context.getResources().getDisplayMetrics()));
    }

    public void getAd() {
        updateParameters(this.am.parameters());
        this.request.setMetaValues(this.map);
        this.adView.getAd();
    }

    public View getAdView() {
        return this.adView;
    }

    public void onError() {
        this.didReportClick = false;
        this.am.getAmobeeListener().amobeeOnError();
    }

    public void onLeavingApplication() {
        if (!this.didReportClick) {
            this.didReportClick = true;
            NetworkHelper.sendNotification(BaseAdapter.createNotificationURL(29, super.getCorrelator()));
        }
        this.am.getAmobeeListener().amobeeOnLeavingApplication(getPlaceHolder());
    }

    public void onOverlay() {
        if (!this.didReportClick) {
            this.didReportClick = true;
            super.fireOnOverlay(true);
        }
    }

    public void onOverlayDismissed() {
        super.fireOnOverlay(false);
        this.didReportClick = false;
    }

    public void onSingleTap(MMAd mMAd) {
        onLeavingApplication();
    }

    public void requestCompleted(MMAd mMAd) {
        adRecieved();
    }

    public void requestFailed(MMAd mMAd, MMException mMException) {
        adFailed();
    }

    public void updateParameters(Parameters parameters) {
        String gender;
        super.setParameters(parameters);
        if (parameters.getAge() == null || parameters.getAge().equals("")) {
            this.map.put("age", "unknown");
        } else {
            this.map.put("age", parameters.getAge());
        }
        if (parameters.getGender() != null) {
            gender = parameters.getGender();
            if (gender.equals("")) {
                this.map.put("gender", "unknown");
            } else {
                this.map.put("gender", gender.equals("m") ? "male" : "female");
            }
        }
        if (!(parameters.getZip() == null || parameters.getZip().equals(""))) {
            this.map.put("zip", parameters.getZip());
        }
        Object keywords = parameters.getKeywords(Parameters.KEYWORD);
        if (!(keywords == null || keywords.equals(""))) {
            gender = "";
            for (int i = 0; i < keywords.length; i++) {
                gender = !gender.equals("") ? new StringBuilder(String.valueOf(gender)).append(",").append(keywords[i]).toString() : new StringBuilder(String.valueOf(gender)).append(keywords[i]).toString();
            }
            this.map.put("keywords", gender);
        }
        gender = (String) parameters.getParameters().get("income");
        if (!(gender == null || gender.equals(""))) {
            this.map.put("income", gender);
        }
        gender = (String) parameters.getParameters().get("ethnicity");
        if (!(gender == null || gender.equals(""))) {
            this.map.put("ethnicity", gender);
        }
        gender = (String) parameters.getParameters().get("children");
        if (!(gender == null || gender.equals(""))) {
            this.map.put("children", gender);
        }
        gender = (String) parameters.getParameters().get("education");
        if (!(gender == null || gender.equals(""))) {
            this.map.put("education", gender);
        }
        gender = (String) parameters.getParameters().get("politics");
        if (!(gender == null || gender.equals(""))) {
            this.map.put("politics", gender);
        }
        gender = (String) parameters.getParameters().get("marital");
        if (!(gender == null || gender.equals(""))) {
            this.map.put("marital", gender);
        }
        if (this.placeholder.getBannerHeight() != 0) {
            this.map.put("hsht", new StringBuilder(String.valueOf(this.placeholder.getBannerHeight())).toString());
        }
        if (this.placeholder.getBannerWidth() != 0) {
            this.map.put("hswd", new StringBuilder(String.valueOf(this.placeholder.getBannerWidth())).toString());
        }
    }
}
