package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import java.util.Locale;

public final class cy {
    public final int f1239a;
    public final boolean f1240b;
    public final boolean f1241c;
    public final String f1242d;
    public final String f1243e;
    public final boolean f1244f;
    public final boolean f1245g;
    public final boolean f1246h;
    public final String f1247i;
    public final String f1248j;
    public final int f1249k;
    public final int f1250l;
    public final int f1251m;
    public final int f1252n;
    public final int f1253o;
    public final int f1254p;
    public final float f1255q;
    public final int f1256r;
    public final int f1257s;
    public final double f1258t;
    public final boolean f1259u;
    public final boolean f1260v;
    public final int f1261w;

    public cy(Context context) {
        boolean z = true;
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Locale locale = Locale.getDefault();
        PackageManager packageManager = context.getPackageManager();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.f1239a = audioManager.getMode();
        this.f1240b = m2015a(packageManager, "geo:0,0?q=donuts") != null;
        this.f1241c = m2015a(packageManager, "http://www.google.com") != null;
        this.f1242d = telephonyManager.getNetworkOperator();
        this.f1243e = locale.getCountry();
        this.f1244f = dp.m2110a();
        this.f1245g = audioManager.isMusicActive();
        this.f1246h = audioManager.isSpeakerphoneOn();
        this.f1247i = locale.getLanguage();
        this.f1248j = m2016a(packageManager);
        this.f1249k = audioManager.getStreamVolume(3);
        this.f1250l = m2014a(context, connectivityManager, packageManager);
        this.f1251m = telephonyManager.getNetworkType();
        this.f1252n = telephonyManager.getPhoneType();
        this.f1253o = audioManager.getRingerMode();
        this.f1254p = audioManager.getStreamVolume(2);
        this.f1255q = displayMetrics.density;
        this.f1256r = displayMetrics.widthPixels;
        this.f1257s = displayMetrics.heightPixels;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            this.f1258t = (double) (((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
            if (!(intExtra == 2 || intExtra == 5)) {
                z = false;
            }
            this.f1259u = z;
        } else {
            this.f1258t = -1.0d;
            this.f1259u = false;
        }
        if (VERSION.SDK_INT >= 16) {
            this.f1260v = connectivityManager.isActiveNetworkMetered();
            if (connectivityManager.getActiveNetworkInfo() != null) {
                this.f1261w = connectivityManager.getActiveNetworkInfo().getDetailedState().ordinal();
                return;
            } else {
                this.f1261w = -1;
                return;
            }
        }
        this.f1260v = false;
        this.f1261w = -1;
    }

    private static int m2014a(Context context, ConnectivityManager connectivityManager, PackageManager packageManager) {
        if (!dk.m2075a(packageManager, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
            return -2;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null ? activeNetworkInfo.getType() : -1;
    }

    private static ResolveInfo m2015a(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
    }

    private static String m2016a(PackageManager packageManager) {
        String str = null;
        ResolveInfo a = m2015a(packageManager, "market://details?id=com.google.android.gms.ads");
        if (a != null) {
            ActivityInfo activityInfo = a.activityInfo;
            if (activityInfo != null) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(activityInfo.packageName, 0);
                    if (packageInfo != null) {
                        str = packageInfo.versionCode + "." + activityInfo.packageName;
                    }
                } catch (NameNotFoundException e) {
                }
            }
        }
        return str;
    }
}
