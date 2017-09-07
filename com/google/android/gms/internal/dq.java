package com.google.android.gms.internal;

import android.util.Log;

public final class dq {
    public static void m2112a(String str) {
        if (m2114a(3)) {
            Log.d("Ads", str);
        }
    }

    public static void m2113a(String str, Throwable th) {
        if (m2114a(3)) {
            Log.d("Ads", str, th);
        }
    }

    public static boolean m2114a(int i) {
        return (i >= 5 || Log.isLoggable("Ads", i)) && i != 2;
    }

    public static void m2115b(String str) {
        if (m2114a(6)) {
            Log.e("Ads", str);
        }
    }

    public static void m2116b(String str, Throwable th) {
        if (m2114a(6)) {
            Log.e("Ads", str, th);
        }
    }

    public static void m2117c(String str) {
        if (m2114a(4)) {
            Log.i("Ads", str);
        }
    }

    public static void m2118c(String str, Throwable th) {
        if (m2114a(5)) {
            Log.w("Ads", str, th);
        }
    }

    public static void m2119d(String str) {
        if (m2114a(2)) {
            Log.v("Ads", str);
        }
    }

    public static void m2120e(String str) {
        if (m2114a(5)) {
            Log.w("Ads", str);
        }
    }
}
