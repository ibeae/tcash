package com.appsflyer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class AppsFlyerProperties {
    public static final String ADDITIONAL_CUSTOM_DATA = "additionalCustomData";
    public static final String AF_KEY = "AppsFlyerKey";
    private static final String AF_REFERRER = "AF_REFERRER";
    public static final String APP_ID = "appid";
    public static final String APP_USER_ID = "AppUserId";
    public static final String CHANNEL = "channel";
    public static final String COLLECT_ANDROID_ID = "collectAndroidId";
    public static final String COLLECT_FACEBOOK_ATTR_ID = "collectFacebookAttrId";
    public static final String COLLECT_FINGER_PRINT = "collectFingerPrint";
    public static final String COLLECT_IMEI = "collectIMEI";
    public static final String COLLECT_MAC = "collectMAC";
    public static final String CURRENCY_CODE = "currencyCode";
    public static final String DEVICE_TRACKING_DISABLED = "deviceTrackingDisabled";
    public static final String DISABLE_LOGS_COMPLETELY = "disableLogs";
    public static final String DISABLE_OTHER_SDK = "disableOtherSdk";
    public static final String EMAIL_CRYPT_TYPE = "userEmailsCryptType";
    public static final String ENABLE_GPS_FALLBACK = "enableGpsFallback";
    public static final String EXTENSION = "sdkExtension";
    static final String GCM_INSTANCE_ID = "gcmInstanceId";
    public static final String GCM_PROJECT_NUMBER = "gcmProjectNumber";
    static final String GCM_TOKEN = "gcmToken";
    static final String GCM_TOKEN_TIMESTAMP = "gcmTokenTimestamp";
    public static final String IS_MONITOR = "shouldMonitor";
    public static final String IS_UPDATE = "IS_UPDATE";
    public static final String PUSH_PAYLOAD_HISTORY_SIZE = "pushPayloadHistorySize";
    public static final String PUSH_PAYLOAD_MAX_AGING = "pushPayloadMaxAging";
    private static final String SAVED_PROPERTIES = "savedProperties";
    private static final String SHOULD_LOG = "shouldLog";
    public static final String USER_EMAIL = "userEmail";
    public static final String USER_EMAILS = "userEmails";
    public static final String USE_HTTP_FALLBACK = "useHttpFallback";
    private static AppsFlyerProperties instance = new AppsFlyerProperties();
    private boolean isLaunchCalled;
    private boolean isOnReceiveCalled;
    private Map<String, Object> properties = new HashMap();
    private String referrer;

    public enum EmailsCryptType {
        NONE(0),
        SHA1(1),
        MD5(2);
        
        private final int value;

        private EmailsCryptType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    private AppsFlyerProperties() {
    }

    public static AppsFlyerProperties getInstance() {
        return instance;
    }

    public void enableLogOutput(boolean z) {
        set(SHOULD_LOG, z);
    }

    public boolean getBoolean(String str, boolean z) {
        String string = getString(str);
        return string == null ? z : Boolean.valueOf(string).booleanValue();
    }

    public int getInt(String str, int i) {
        String string = getString(str);
        return string == null ? i : Integer.valueOf(string).intValue();
    }

    public long getLong(String str, long j) {
        String string = getString(str);
        return string == null ? j : Long.valueOf(string).longValue();
    }

    public String getReferrer(Context context) {
        return this.referrer != null ? this.referrer : getString(AF_REFERRER) != null ? getString(AF_REFERRER) : context != null ? context.getSharedPreferences("appsflyer-data", 0).getString("referrer", null) : null;
    }

    public String getString(String str) {
        return (String) this.properties.get(str);
    }

    public String[] getStringArray(String str) {
        return (String[]) this.properties.get(str);
    }

    public boolean isEnableLog() {
        return getBoolean(SHOULD_LOG, true);
    }

    protected boolean isFirstLaunchCalled() {
        return this.isLaunchCalled;
    }

    public boolean isLogsDisabledCompletely() {
        return getBoolean(DISABLE_LOGS_COMPLETELY, false);
    }

    protected boolean isOnReceiveCalled() {
        return this.isOnReceiveCalled;
    }

    public boolean isOtherSdkStringDisabled() {
        return getBoolean(DISABLE_OTHER_SDK, false);
    }

    public void loadProperties(Context context) {
        String string = context.getSharedPreferences("appsflyer-data", 0).getString(SAVED_PROPERTIES, null);
        if (string != null) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    string = (String) keys.next();
                    if (this.properties.get(string) == null) {
                        this.properties.put(string, jSONObject.getString(string));
                    }
                }
            } catch (Throwable e) {
                AFLogger.afLogE("Failed loading properties", e);
            }
        }
    }

    @SuppressLint({"CommitPrefEdits"})
    public void saveProperties(Context context) {
        String jSONObject = new JSONObject(this.properties).toString();
        Editor edit = context.getSharedPreferences("appsflyer-data", 0).edit();
        edit.putString(SAVED_PROPERTIES, jSONObject);
        if (VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    public void set(String str, int i) {
        this.properties.put(str, Integer.toString(i));
    }

    public void set(String str, long j) {
        this.properties.put(str, Long.toString(j));
    }

    public void set(String str, String str2) {
        this.properties.put(str, str2);
    }

    public void set(String str, boolean z) {
        this.properties.put(str, Boolean.toString(z));
    }

    public void set(String str, String[] strArr) {
        this.properties.put(str, strArr);
    }

    public void setCustomData(String str) {
        this.properties.put(ADDITIONAL_CUSTOM_DATA, str);
    }

    protected void setFirstLaunchCalled() {
        this.isLaunchCalled = true;
    }

    protected void setFirstLaunchCalled(boolean z) {
        this.isLaunchCalled = z;
    }

    protected void setOnReceiveCalled() {
        this.isOnReceiveCalled = true;
    }

    protected void setReferrer(String str) {
        set(AF_REFERRER, str);
        this.referrer = str;
    }

    public void setUserEmails(String str) {
        this.properties.put(USER_EMAILS, str);
    }
}
