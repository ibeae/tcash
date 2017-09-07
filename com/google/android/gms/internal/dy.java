package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class dy extends dv {
    public dy(dt dtVar, boolean z) {
        super(dtVar, z);
    }

    protected WebResourceResponse m2181a(Context context, String str, String str2) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
        try {
            dk.m2069a(context, str, true, httpURLConnection);
            httpURLConnection.connect();
            WebResourceResponse webResourceResponse = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(dk.m2060a(new InputStreamReader(httpURLConnection.getInputStream())).getBytes("UTF-8")));
            return webResourceResponse;
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
                return super.shouldInterceptRequest(webView, str);
            }
            if (webView instanceof dt) {
                dt dtVar = (dt) webView;
                dtVar.m2142f().m2162c();
                if (dtVar.m2141e().f924e) {
                    dq.m2119d("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_interstitial.js)");
                    return m2181a(dtVar.getContext(), this.a.m2144h().f1564b, "http://media.admob.com/mraid/v1/mraid_app_interstitial.js");
                } else if (dtVar.m2145i()) {
                    dq.m2119d("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js)");
                    return m2181a(dtVar.getContext(), this.a.m2144h().f1564b, "http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js");
                } else {
                    dq.m2119d("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_banner.js)");
                    return m2181a(dtVar.getContext(), this.a.m2144h().f1564b, "http://media.admob.com/mraid/v1/mraid_app_banner.js");
                }
            }
            dq.m2120e("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return super.shouldInterceptRequest(webView, str);
        } catch (IOException e) {
            dq.m2120e("Could not fetching MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, str);
        }
    }
}
