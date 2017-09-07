package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebSettings;

public final class dn {
    public static String m2099a(Context context) {
        return WebSettings.getDefaultUserAgent(context);
    }

    public static void m2100a(Context context, WebSettings webSettings) {
        dm.m2093a(context, webSettings);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
    }
}
