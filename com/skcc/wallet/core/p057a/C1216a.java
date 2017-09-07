package com.skcc.wallet.core.p057a;

import android.util.Log;

public class C1216a {
    public static void m4519a(String str, String str2) {
        Log.d(str, str2);
    }

    public static void m4520a(String str, String str2, Exception exception) {
        Log.w(str, new StringBuilder(String.valueOf(str2)).append("::").append(exception.toString()).toString());
    }

    public static void m4521a(String str, String str2, String str3) {
        Log.w(str, new StringBuilder(String.valueOf(str2)).append("::").append(str3).toString());
    }

    public static void m4522b(String str, String str2) {
        Log.e(str, str2);
    }

    public static void m4523c(String str, String str2) {
        Log.i(str, str2);
    }

    public static void m4524d(String str, String str2) {
        Log.w(str, str2);
    }

    public static void m4525e(String str, String str2) {
        Log.v(str, str2);
    }
}
