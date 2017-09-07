package com.amobee.richmedia.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.amobee.adsdk.Log;
import com.amobee.richmedia.controller.Defines.Events;
import com.amobee.richmedia.controller.OrmmaController.RecurrenceProperties;
import com.amobee.richmedia.view.AmobeeView;
import com.amobee.richmedia.view.AmobeeView.ViewState;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class OrmmaUtilityController extends OrmmaController {
    private static final String LOG_TAG = "AmobeeViewUtilityController";
    private OrmmaAssetController mAssetController;
    public OrmmaDisplayController mDisplayController;
    private OrmmaLocationController mLocationController;
    private OrmmaNetworkController mNetworkController;
    private OrmmaSensorController mSensorController;
    private OrmmaCalendarController ormmaCalendarController = null;
    private boolean ormmaCalendarControllerFlag = false;

    public OrmmaUtilityController(AmobeeView amobeeView, Context context) {
        super(amobeeView, context);
        this.mAssetController = new OrmmaAssetController(amobeeView, context);
        this.mDisplayController = new OrmmaDisplayController(amobeeView, context);
        this.mLocationController = new OrmmaLocationController(amobeeView, context);
        this.mNetworkController = new OrmmaNetworkController(amobeeView, context);
        this.mSensorController = new OrmmaSensorController(amobeeView, context);
        amobeeView.addJavascriptInterface(this.mAssetController, "ORMMAAssetsControllerBridge");
        amobeeView.addJavascriptInterface(this.mDisplayController, "ORMMADisplayControllerBridge");
        amobeeView.addJavascriptInterface(this.mLocationController, "ORMMALocationControllerBridge");
        amobeeView.addJavascriptInterface(this.mNetworkController, "ORMMANetworkControllerBridge");
        amobeeView.addJavascriptInterface(this.mSensorController, "ORMMASensorControllerBridge");
    }

    private String createTelUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("tel:");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private String getSupports() {
        Object obj = 1;
        Object obj2 = "supports: [ 'level-1', 'level-2', 'screen', 'orientation', 'network'";
        Object obj3 = (this.mLocationController.allowLocationServices() && (this.mContext.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0 || this.mContext.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0)) ? 1 : null;
        if (obj3 != null) {
            obj2 = new StringBuilder(String.valueOf(obj2)).append(", 'location'").toString();
        }
        if ((this.mContext.checkCallingOrSelfPermission("android.permission.SEND_SMS") == 0 ? 1 : null) != null) {
            obj2 = new StringBuilder(String.valueOf(obj2)).append(", 'sms'").toString();
        }
        if ((this.mContext.checkCallingOrSelfPermission("android.permission.CALL_PHONE") == 0 ? 1 : null) != null) {
            obj2 = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(obj2)).append(", 'phone'").toString())).append(", 'tel'").toString();
        }
        obj3 = (this.mContext.checkCallingOrSelfPermission("android.permission.WRITE_CALENDAR") == 0 && this.mContext.checkCallingOrSelfPermission("android.permission.READ_CALENDAR") == 0) ? 1 : null;
        if (obj3 != null && Integer.parseInt(VERSION.SDK) >= 14) {
            obj2 = new StringBuilder(String.valueOf(obj2)).append(", 'calendar'").toString();
        }
        if (this.mContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            obj = null;
        }
        if (!(obj == null || this.mOrmmaView.mViewState == ViewState.POSTITIAL)) {
            obj2 = new StringBuilder(String.valueOf(obj2)).append(", 'storePicture'").toString();
        }
        if (this.mOrmmaView.mViewState != ViewState.POSTITIAL) {
            obj2 = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(obj2)).append(", 'video'").toString())).append(", 'inlineVideo'").toString();
        }
        return new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(obj2)).append(", 'audio'").toString())).append(", 'map'").toString())).append(", 'email' ]").toString();
    }

    @JavascriptInterface
    public void activate(String str) {
        if (str.equalsIgnoreCase(Events.NETWORK_CHANGE)) {
            this.mNetworkController.startNetworkListener();
        } else if (this.mLocationController.allowLocationServices() && str.equalsIgnoreCase(Events.LOCATION_CHANGE)) {
            this.mLocationController.startLocationListener();
        } else if (str.equalsIgnoreCase(Events.SHAKE)) {
            this.mSensorController.startShakeListener();
        } else if (str.equalsIgnoreCase(Events.TILT_CHANGE)) {
            this.mSensorController.startTiltListener();
        } else if (str.equalsIgnoreCase(Events.HEADING_CHANGE)) {
            this.mSensorController.startHeadingListener();
        } else if (str.equalsIgnoreCase(Events.ORIENTATION_CHANGE)) {
            this.mDisplayController.startConfigurationListener();
        }
    }

    public String copyTextFromJarIntoAssetDir(String str, String str2) {
        return this.mAssetController.copyTextFromJarIntoAssetDir(str, str2);
    }

    @JavascriptInterface
    @SuppressLint({"NewApi"})
    public void createCalendarEvent(String str, String str2) {
        if (Integer.parseInt(VERSION.SDK) >= 8) {
            RecurrenceProperties recurrenceProperties;
            this.ormmaCalendarControllerFlag = true;
            this.ormmaCalendarController = new OrmmaCalendarController(LOG_TAG, this.mContext, this.mDisplayController.mOrmmaView);
            if (str2 == null) {
                recurrenceProperties = null;
            } else {
                try {
                    recurrenceProperties = (RecurrenceProperties) OrmmaController.getFromJSON(new JSONObject(str2), RecurrenceProperties.class);
                } catch (NumberFormatException e) {
                    recurrenceProperties = null;
                } catch (NullPointerException e2) {
                    recurrenceProperties = null;
                } catch (IllegalAccessException e3) {
                    recurrenceProperties = null;
                } catch (InstantiationException e4) {
                    recurrenceProperties = null;
                } catch (JSONException e5) {
                    recurrenceProperties = null;
                }
            }
            this.ormmaCalendarController.createCalendarEvent(str, recurrenceProperties);
        }
    }

    @JavascriptInterface
    public void deactivate(String str) {
        if (str.equalsIgnoreCase(Events.NETWORK_CHANGE)) {
            this.mNetworkController.stopNetworkListener();
        } else if (str.equalsIgnoreCase(Events.LOCATION_CHANGE)) {
            this.mLocationController.stopAllListeners();
        } else if (str.equalsIgnoreCase(Events.SHAKE)) {
            this.mSensorController.stopShakeListener();
        } else if (str.equalsIgnoreCase(Events.TILT_CHANGE)) {
            this.mSensorController.stopTiltListener();
        } else if (str.equalsIgnoreCase(Events.HEADING_CHANGE)) {
            this.mSensorController.stopHeadingListener();
        } else if (str.equalsIgnoreCase(Events.ORIENTATION_CHANGE)) {
            this.mDisplayController.stopConfigurationListener();
        }
    }

    public void deleteOldAds() {
        this.mAssetController.deleteOldAds();
    }

    @SuppressLint({"NewApi"})
    public void handleCalendarEvent() {
        if (Integer.parseInt(VERSION.SDK) >= 14 && this.ormmaCalendarControllerFlag && this.ormmaCalendarController.isEventSaved()) {
            this.ormmaCalendarControllerFlag = false;
        }
    }

    public void init(float f) {
        int width;
        int height;
        int[] defaultPosition = this.mOrmmaView.getDefaultPosition();
        int width2 = (int) (((float) this.mOrmmaView.getWidth()) / f);
        width2 = (int) (((float) this.mOrmmaView.getHeight()) / f);
        String str = "default";
        String size = this.mDisplayController.getSize();
        if (this.mOrmmaView.parentView != null) {
            str = "expanded";
            width = (int) (((float) this.mOrmmaView.parentView.getWidth()) / f);
            height = (int) (((float) this.mOrmmaView.parentView.getHeight()) / f);
        } else if (this.mOrmmaView.mViewState == ViewState.INTERSTITIAL || this.mOrmmaView.mViewState == ViewState.POSTITIAL) {
            size = this.mDisplayController.getScreenSize();
            width = (int) (((float) this.mOrmmaView.metrics.widthPixels) / this.mOrmmaView.metrics.density);
            height = (int) (((float) this.mOrmmaView.metrics.heightPixels) / this.mOrmmaView.metrics.density);
        } else {
            width = (int) (((float) this.mOrmmaView.getWidth()) / f);
            height = (int) (((float) this.mOrmmaView.getHeight()) / f);
        }
        Object obj = "";
        if (this.mOrmmaView.mViewState == ViewState.INTERSTITIAL || this.mOrmmaView.mViewState == ViewState.POSTITIAL) {
            obj = new StringBuilder(String.valueOf(obj)).append("mraid.setPlacementType('interstitial');").toString();
        }
        this.mOrmmaView.injectJavaScriptRichMedia("setTimeout(\"try{" + new StringBuilder(String.valueOf(obj)).append("window.ormmaview.fireChangeEvent({ network: '").append(this.mNetworkController.getNetwork()).append("',").append(" size: ").append(size).append(",").append(" maxSize: ").append(this.mDisplayController.getMaxSize()).append(",").append(" screenSize: ").append(this.mDisplayController.getScreenSize()).append(",").append(" defaultPosition: { x:").append((int) (((float) defaultPosition[0]) / f)).append(", y: ").append((int) (((float) defaultPosition[1]) / f)).append(", width: ").append(width).append(", height: ").append(height).append(" },").append(" orientation:").append(this.mDisplayController.getOrientation()).append(",").append(getSupports()).append(",").append(" state: '").append(str).append("'});").toString() + "}catch(e){}\",100)");
    }

    @JavascriptInterface
    public void makeCall(String str) {
        String createTelUrl = createTelUrl(str);
        if (createTelUrl == null) {
            this.mOrmmaView.raiseError("Bad Phone Number", "makeCall");
            return;
        }
        Intent intent = new Intent("android.intent.action.CALL", Uri.parse(createTelUrl.toString()));
        intent.addFlags(268435456);
        this.mContext.startActivity(intent);
    }

    public void ready() {
        this.mOrmmaView.injectJavaScriptRichMedia("Ormma.setState(\"" + this.mOrmmaView.getState() + "\");");
        this.mOrmmaView.injectJavaScriptRichMedia("ORMMAReady();");
    }

    @JavascriptInterface
    public void sendMail(String str, String str2, String str3) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("plain/text");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
        intent.putExtra("android.intent.extra.SUBJECT", str2);
        intent.putExtra("android.intent.extra.TEXT", str3);
        intent.addFlags(268435456);
        this.mContext.startActivity(intent);
    }

    @JavascriptInterface
    public void sendSMS(String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.putExtra("address", str);
        intent.putExtra("sms_body", str2);
        intent.setType("vnd.android-dir/mms-sms");
        intent.addFlags(268435456);
        this.mContext.startActivity(intent);
    }

    public void setMaxSize(int i, int i2) {
        this.mDisplayController.setMaxSize(i, i2);
    }

    @JavascriptInterface
    public void showAlert(String str) {
        Log.m811d(LOG_TAG, str);
    }

    public void stopAllListeners() {
        try {
            this.mAssetController.stopAllListeners();
            this.mDisplayController.stopAllListeners();
            this.mLocationController.stopAllListeners();
            this.mNetworkController.stopAllListeners();
            this.mSensorController.stopAllListeners();
        } catch (Exception e) {
        }
    }

    public String writeToDiskWrap(InputStream inputStream, String str, boolean z, String str2, String str3, String str4) {
        return this.mAssetController.writeToDiskWrap(inputStream, str, z, str2, str3, str4);
    }
}
