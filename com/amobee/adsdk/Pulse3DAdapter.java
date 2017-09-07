package com.amobee.adsdk;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.amobee.adsdk.AdManager.DebugLevel;
import com.amobee.pulse3d.Log;
import com.amobee.pulse3d.Pulse3DView;
import com.amobee.pulse3d.Pulse3DViewListener;
import com.amobee.richmedia.view.Browser;

class Pulse3DAdapter extends BaseAdapter implements Pulse3DViewListener {
    static final String TAG = "Pulse3DAdapter";
    boolean adIsLoadingFromCache;
    private boolean adReceivedDispatched;
    private String mAdURL;
    private Pulse3DView mPulse3DView;
    private boolean useCache;

    Pulse3DAdapter(Context context, Parameters parameters) {
        super(context, parameters);
        this.useCache = true;
        this.adReceivedDispatched = false;
        this.adIsLoadingFromCache = false;
        this.networkName = "Pulse3D";
        if (AdManager.debugLevel == DebugLevel.DEBUG) {
            Pulse3DView.debugLevel = Log.DebugLevel.DEBUG;
        }
        this.mPulse3DView = new Pulse3DView(context);
        this.mPulse3DView.setAdkUniqueUserId((String) parameters.getParameters().get("androidaid"));
        this.mPulse3DView.setPulse3DViewListener(this);
    }

    public void adFailed() {
    }

    public void adRecieved() {
    }

    protected LayoutParams defaultLayoutParams(AmobeeAdPlaceholder amobeeAdPlaceholder) {
        LayoutParams layoutParams = amobeeAdPlaceholder.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        if (-1 == layoutParams.width || -2 == layoutParams.width || -1 == layoutParams.width) {
            i = (int) (((double) amobeeAdPlaceholder.mDefaultBannerWidth) * this.am.getDensity());
        }
        if (-1 == layoutParams.height || -2 == layoutParams.height || -1 == layoutParams.height) {
            i2 = (int) (((double) amobeeAdPlaceholder.mDefaultBannerHeight) * this.am.getDensity());
        }
        return new FrameLayout.LayoutParams(i, i2);
    }

    public void getAd() {
    }

    String getAdURL() {
        return this.mAdURL;
    }

    public View getAdView() {
        return this.mPulse3DView;
    }

    boolean isAdCached(String str) {
        return Pulse3DView.isAdCached(this.m_context, this.mAdURL);
    }

    public void onEndTransition(Pulse3DView pulse3DView, boolean z) {
        if (!z) {
            onOverlayDismissed();
            this.am.setIsExpanded(false);
            this.am.fireOnOverlay(false, getPlaceHolder());
            this.am.getAd(true, this.am.getPlaceholders());
        }
    }

    public void onError() {
    }

    public void onFailLoadingSceneAtURL(final Pulse3DView pulse3DView, String str, Error error) {
        this.am.parameters().getParameters().put("pulse3d", "2");
        this.mAdURL = null;
        Log.m811d(TAG, "onFailLoadingSceneAtURL");
        ((AmobeeAdPlaceholder) pulse3DView.getParent()).post(new Runnable() {
            public void run() {
                pulse3DView.setVisibility(4);
                Pulse3DAdapter.this.fireAdFailed(Pulse3DAdapter.this.networkName);
            }
        });
    }

    public void onFinishLoadingSceneAtURL(final Pulse3DView pulse3DView, String str) {
        Log.m811d(TAG, "onFinishLoadingSceneAtURL");
        final AmobeeAdPlaceholder amobeeAdPlaceholder = (AmobeeAdPlaceholder) pulse3DView.getParent();
        if (!this.adReceivedDispatched) {
            amobeeAdPlaceholder.post(new Runnable() {
                public void run() {
                    amobeeAdPlaceholder.setCurrentAdapter(Pulse3DAdapter.this);
                    pulse3DView.setVisibility(0);
                    amobeeAdPlaceholder.setNextAdapter(null);
                    while (amobeeAdPlaceholder.getChildCount() > 1) {
                        if (amobeeAdPlaceholder.getChildAt(0) != Pulse3DAdapter.this.mPulse3DView) {
                            amobeeAdPlaceholder.removeViewAt(0);
                        } else {
                            amobeeAdPlaceholder.removeViewAt(1);
                        }
                    }
                    Pulse3DAdapter.this.fireAdRecieved(Pulse3DAdapter.this.networkName);
                }
            });
            this.am.parameters().getParameters().put("pulse3d", "2");
        }
    }

    public void onLeavingApplication() {
    }

    public void onLeavingApplication(Pulse3DView pulse3DView) {
        this.am.getAmobeeListener().amobeeOnLeavingApplication(getPlaceHolder());
    }

    public void onOverlay() {
        fireOnOverlay(true);
    }

    public void onOverlayDismissed() {
    }

    public void onStartTransition(Pulse3DView pulse3DView, boolean z) {
        if (z) {
            onOverlay();
            this.am.setIsExpanded(true);
        }
    }

    public void setURLFromFragment(String str) {
        String substring;
        AmobeeAdPlaceholder amobeeAdPlaceholder;
        this.adReceivedDispatched = false;
        String str2 = "";
        int indexOf = str.indexOf("<Pulse3DFileLocation>") + "<Pulse3DFileLocation>".length();
        if (indexOf > -1) {
            str2 = str.substring(indexOf);
            indexOf = str2.indexOf("</Pulse3DFileLocation>");
            if (indexOf > -1) {
                substring = str2.substring(0, indexOf);
                this.adIsLoadingFromCache = Pulse3DView.isAdCached(this.m_context, substring);
                amobeeAdPlaceholder = (AmobeeAdPlaceholder) this.mPulse3DView.getParent();
                if (shouldUseDefaultLayoutParms(amobeeAdPlaceholder)) {
                    this.mPulse3DView.setLayoutParams(defaultLayoutParams(amobeeAdPlaceholder));
                }
                if (this.mAdURL == null && substring.equals(this.mAdURL) && substring.equals(this.mPulse3DView.getURL())) {
                    Log.m811d(TAG, "consecutive pulse3d url, will not reload, just register impression again");
                    this.mPulse3DView.registerImpressionAgain();
                    super.fireAdRecieved(this.networkName);
                } else {
                    this.mPulse3DView.loadSceneAtURL(substring, this.useCache);
                    if (amobeeAdPlaceholder.getWindowVisibility() == 8) {
                        this.adReceivedDispatched = true;
                        amobeeAdPlaceholder.setCurrentAdapter(this);
                        this.mPulse3DView.setVisibility(0);
                        amobeeAdPlaceholder.setNextAdapter(null);
                        while (amobeeAdPlaceholder.getChildCount() > 1) {
                            if (amobeeAdPlaceholder.getChildAt(0) == this.mPulse3DView) {
                                amobeeAdPlaceholder.removeViewAt(0);
                            } else {
                                amobeeAdPlaceholder.removeViewAt(1);
                            }
                        }
                        fireAdRecieved(this.networkName);
                    }
                }
                this.mAdURL = substring;
            }
        }
        substring = str2;
        this.adIsLoadingFromCache = Pulse3DView.isAdCached(this.m_context, substring);
        amobeeAdPlaceholder = (AmobeeAdPlaceholder) this.mPulse3DView.getParent();
        if (shouldUseDefaultLayoutParms(amobeeAdPlaceholder)) {
            this.mPulse3DView.setLayoutParams(defaultLayoutParams(amobeeAdPlaceholder));
        }
        if (this.mAdURL == null) {
        }
        this.mPulse3DView.loadSceneAtURL(substring, this.useCache);
        if (amobeeAdPlaceholder.getWindowVisibility() == 8) {
            this.adReceivedDispatched = true;
            amobeeAdPlaceholder.setCurrentAdapter(this);
            this.mPulse3DView.setVisibility(0);
            amobeeAdPlaceholder.setNextAdapter(null);
            while (amobeeAdPlaceholder.getChildCount() > 1) {
                if (amobeeAdPlaceholder.getChildAt(0) == this.mPulse3DView) {
                    amobeeAdPlaceholder.removeViewAt(1);
                } else {
                    amobeeAdPlaceholder.removeViewAt(0);
                }
            }
            fireAdRecieved(this.networkName);
        }
        this.mAdURL = substring;
    }

    boolean shouldUseDefaultLayoutParms(AmobeeAdPlaceholder amobeeAdPlaceholder) {
        if (amobeeAdPlaceholder != null) {
            LayoutParams layoutParams = amobeeAdPlaceholder.getLayoutParams();
            if (-1 == layoutParams.width || -2 == layoutParams.width || -1 == layoutParams.width || -1 == layoutParams.height || -2 == layoutParams.height || -1 == layoutParams.height) {
                return true;
            }
        }
        return false;
    }

    protected void updateParameters(Parameters parameters) {
    }

    public boolean webLinkOutRequested(String str, boolean z) {
        Log.m811d(TAG, "open URL:" + str);
        try {
            Intent intent = new Intent(this.m_context, Browser.class);
            intent.putExtra(Browser.URL_EXTRA, str);
            intent.putExtra(Browser.SHOW_BACK_EXTRA, true);
            intent.putExtra(Browser.SHOW_FORWARD_EXTRA, true);
            intent.putExtra(Browser.SHOW_REFRESH_EXTRA, true);
            intent.addFlags(268435456);
            this.m_context.startActivity(intent);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
