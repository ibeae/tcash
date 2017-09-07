package com.appsflyer;

public class LogMessages {
    public static final String DEV_KEY_MISSING = "AppsFlyer dev key is missing!!! Please use  AppsFlyerLib.getInstance().setAppsFlyerKey(...) to set it. ";
    public static final String EVENT_CREATED_WITH_NAME = "******* sendTrackingWithEvent: ";
    public static final String EVENT_DATA = "data: ";
    public static final String LOG_TAG_PREFIX = "AppsFlyer_";
    public static final String PERMISSION_ACCESS_NETWORK_MISSING = "Permission android.permission.ACCESS_NETWORK_STATE is missing in the AndroidManifest.xml";
    public static final String PERMISSION_ACCESS_WIFI_MISSING = "Permission android.permission.ACCESS_WIFI_STATE is missing in the AndroidManifest.xml";
    public static final String PERMISSION_INTERNET_MISSING = "Permission android.permission.INTERNET is missing in the AndroidManifest.xml";
    public static final String PLAY_STORE_REFERRER_RECIEVED = "Play store referrer: ";
    public static final String SERVER_CALL_FAILRED = "failed to send requeset to server. ";
    public static final String SERVER_RESPONSE_CODE = "response code: ";
    public static final String START_LOG_MESSAGE = "Start tracking package: ";
    private static String devKey;
    private static String replacedKey;

    public static void logMessageMaskKey(String str) {
        if (devKey == null) {
            setDevKey(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY));
        } else if (devKey != null && str.contains(devKey)) {
            AFLogger.afLog(str.replace(devKey, replacedKey));
        }
    }

    public static void setDevKey(String str) {
        devKey = str;
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            if (i == 0 || i == 1 || i > str.length() - 5) {
                stringBuilder.append(str.charAt(i));
            } else {
                stringBuilder.append("*");
            }
            i++;
        }
        replacedKey = stringBuilder.toString();
    }
}
