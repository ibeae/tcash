package com.appsflyer;

import android.util.Log;

public class AFLogger {
    public static final String LOG_TAG = (LogMessages.LOG_TAG_PREFIX + AppsFlyerLib.SERVER_BUILD_NUMBER + "." + AppsFlyerLib.SDK_BUILD_NUMBER);

    public static void afDebugLog(String str) {
        if (shouldLog()) {
            Log.d(LOG_TAG, str);
        }
    }

    public static void afLog(String str) {
        if (shouldLog()) {
            Log.i(LOG_TAG, str);
        }
    }

    public static void afLogE(String str, Throwable th) {
        if (shouldLog()) {
            Log.e(LOG_TAG, str, th);
        }
    }

    public static void afLogM(String str) {
        if (!noLogsAllowed()) {
            Log.d(LOG_TAG, str);
        }
    }

    public static void afWarnLog(String str) {
        if (shouldLog()) {
            Log.w(LOG_TAG, str);
        }
    }

    private static boolean noLogsAllowed() {
        return AppsFlyerProperties.getInstance().isLogsDisabledCompletely();
    }

    private static boolean shouldLog() {
        return AppsFlyerProperties.getInstance().isEnableLog();
    }
}
