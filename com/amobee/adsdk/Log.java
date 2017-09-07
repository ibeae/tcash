package com.amobee.adsdk;

import com.amobee.adsdk.AdManager.DebugLevel;

public final class Log {
    static int all = 0;
    static int f430d = 3;
    static int f431e = 2;
    static int f432i = 1;
    static int f433v = 4;
    static int f434w = 5;

    private static void LogHandler(int i, String str, String str2) {
        DebugLevel debugLevel;
        try {
            debugLevel = AdManager.debugLevel;
        } catch (Exception e) {
            debugLevel = DebugLevel.NODEBUG;
        }
        if (debugLevel != DebugLevel.NODEBUG) {
            android.util.Log.d(str, str2);
        }
    }

    public static void m811d(String str, String str2) {
        LogHandler(f430d, str, str2);
    }

    public static void m812e(String str, String str2) {
        LogHandler(f431e, str, str2);
    }

    public static void m813i(String str, String str2) {
        LogHandler(f432i, str, str2);
    }

    public static void m814v(String str, String str2) {
        LogHandler(f433v, str, str2);
    }

    public static void m815w(String str, String str2) {
        LogHandler(f434w, str, str2);
    }
}
