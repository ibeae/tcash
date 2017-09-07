package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.facebook.internal.AnalyticsEvents;

public class de {
    private final Object f1307a = new Object();
    private final String f1308b;
    private int f1309c = 0;
    private long f1310d = -1;
    private long f1311e = -1;
    private int f1312f = 0;
    private int f1313g = -1;

    public de(String str) {
        this.f1308b = str;
    }

    public static boolean m2045a(Context context) {
        int identifier = context.getResources().getIdentifier("Theme.Translucent", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "android");
        if (identifier == 0) {
            dq.m2117c("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.google.android.gms.ads.AdActivity"), 0).theme) {
                return true;
            }
            dq.m2117c("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (NameNotFoundException e) {
            dq.m2120e("Fail to fetch AdActivity theme");
            dq.m2117c("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }

    public long m2046a() {
        return this.f1311e;
    }

    public Bundle m2047a(Context context, String str) {
        Bundle bundle;
        synchronized (this.f1307a) {
            bundle = new Bundle();
            bundle.putString("session_id", this.f1308b);
            bundle.putLong("basets", this.f1311e);
            bundle.putLong("currts", this.f1310d);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.f1313g);
            bundle.putInt("pclick", this.f1309c);
            bundle.putInt("pimp", this.f1312f);
            bundle.putBoolean("support_transparent_background", m2045a(context));
        }
        return bundle;
    }

    public void m2048a(ai aiVar, long j) {
        synchronized (this.f1307a) {
            if (this.f1311e == -1) {
                this.f1311e = j;
                this.f1310d = this.f1311e;
            } else {
                this.f1310d = j;
            }
            if (aiVar.f893c == null || aiVar.f893c.getInt("gw", 2) != 1) {
                this.f1313g++;
                return;
            }
        }
    }

    public void m2049b() {
        synchronized (this.f1307a) {
            this.f1309c++;
        }
    }

    public void m2050c() {
        synchronized (this.f1307a) {
            this.f1312f++;
        }
    }
}
