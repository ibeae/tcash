package com.telkom.mwallet.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.skcc.wallet.core.p057a.C1216a;

public class TCashWebview extends WebView {
    private static final String f5832a = TCashWebview.class.getSimpleName();
    private C1950b f5833b;

    public interface C1950b {
        void mo1573a(String str);
    }

    private class C2008a extends WebViewClient {
        final /* synthetic */ TCashWebview f5831a;

        public C2008a(TCashWebview tCashWebview) {
            this.f5831a = tCashWebview;
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            C1216a.m4522b("load merchantUrl", str);
            super.onPageStarted(webView, str, bitmap);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith("twallet://")) {
                C1216a.m4522b("returnUrl", str);
                this.f5831a.f5833b.mo1573a(str);
            } else {
                webView.loadUrl(str);
            }
            return true;
        }
    }

    public TCashWebview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8026a(context);
    }

    private void m8026a(Context context) {
        setWebViewClient(new C2008a(this));
        clearCache(true);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setRenderPriority(RenderPriority.HIGH);
        settings.setCacheMode(2);
        if (VERSION.SDK_INT < 14) {
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
        }
    }

    public void setTCashWebViewListener(C1950b c1950b) {
        this.f5833b = c1950b;
    }
}
