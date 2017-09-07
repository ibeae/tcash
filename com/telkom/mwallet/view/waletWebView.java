package com.telkom.mwallet.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class waletWebView extends WebView {
    private static final String f5850a = waletWebView.class.getSimpleName();
    private C2013a f5851b;

    public interface C2013a {
        void m8029a();
    }

    private class C2014b extends WebViewClient {
        final /* synthetic */ waletWebView f5849a;

        public C2014b(waletWebView com_telkom_mwallet_view_waletWebView) {
            this.f5849a = com_telkom_mwallet_view_waletWebView;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (this.f5849a.f5851b != null) {
                this.f5849a.f5851b.m8029a();
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }
    }

    public waletWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8031a(context);
    }

    private void m8031a(Context context) {
        setWebViewClient(new C2014b(this));
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setRenderPriority(RenderPriority.HIGH);
        if (VERSION.SDK_INT < 14) {
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
        }
    }

    public void setOnOptusPageFinishedListener(C2013a c2013a) {
        this.f5851b = c2013a;
    }
}
