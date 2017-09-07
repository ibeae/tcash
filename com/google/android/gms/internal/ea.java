package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.URI;
import java.net.URISyntaxException;

public class ea extends WebViewClient {
    private final String f1486a;
    private boolean f1487b = false;
    private final dt f1488c;
    private final ck f1489d;

    public ea(ck ckVar, dt dtVar, String str) {
        this.f1486a = m2189b(str);
        this.f1488c = dtVar;
        this.f1489d = ckVar;
    }

    private String m2189b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (str.endsWith("/")) {
                    str = str.substring(0, str.length() - 1);
                }
            } catch (IndexOutOfBoundsException e) {
                dq.m2115b(e.getMessage());
            }
        }
        return str;
    }

    protected boolean m2190a(String str) {
        Object b = m2189b(str);
        if (TextUtils.isEmpty(b)) {
            return false;
        }
        try {
            URI uri = new URI(b);
            if ("passback".equals(uri.getScheme())) {
                dq.m2112a("Passback received");
                this.f1489d.m1892b();
                return true;
            } else if (TextUtils.isEmpty(this.f1486a)) {
                return false;
            } else {
                URI uri2 = new URI(this.f1486a);
                String host = uri2.getHost();
                String host2 = uri.getHost();
                String path = uri2.getPath();
                String path2 = uri.getPath();
                if (!ej.m2331a(host, host2) || !ej.m2331a(path, path2)) {
                    return false;
                }
                dq.m2112a("Passback received");
                this.f1489d.m1892b();
                return true;
            }
        } catch (URISyntaxException e) {
            dq.m2115b(e.getMessage());
            return false;
        }
    }

    public void onLoadResource(WebView webView, String str) {
        dq.m2112a("JavascriptAdWebViewClient::onLoadResource: " + str);
        if (!m2190a(str)) {
            this.f1488c.m2142f().onLoadResource(this.f1488c, str);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        dq.m2112a("JavascriptAdWebViewClient::onPageFinished: " + str);
        if (!this.f1487b) {
            this.f1489d.m1889a();
            this.f1487b = true;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        dq.m2112a("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + str);
        if (!m2190a(str)) {
            return this.f1488c.m2142f().shouldOverrideUrlLoading(this.f1488c, str);
        }
        dq.m2112a("shouldOverrideUrlLoading: received passback url");
        return true;
    }
}
