package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;

public final class dm {
    public static void m2093a(Context context, WebSettings webSettings) {
        webSettings.setAppCachePath(context.getCacheDir().getAbsolutePath());
        webSettings.setAppCacheMaxSize(0);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDatabasePath(context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
    }

    public static void m2094a(View view) {
        view.setLayerType(1, null);
    }

    public static void m2095a(Window window) {
        window.setFlags(16777216, 16777216);
    }

    public static void m2096a(WebView webView) {
        webView.onPause();
    }

    public static void m2097b(View view) {
        view.setLayerType(0, null);
    }

    public static void m2098b(WebView webView) {
        webView.onResume();
    }
}
