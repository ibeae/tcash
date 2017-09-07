package com.google.android.gms.internal;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.HashMap;
import java.util.Map;

public class dv extends WebViewClient {
    protected final dt f1401a;
    private final HashMap<String, aa> f1402b = new HashMap();
    private final Object f1403c = new Object();
    private fs f1404d;
    private bh f1405e;
    private C0699a f1406f;
    private C0817y f1407g;
    private boolean f1408h = false;
    private ab f1409i;
    private ad f1410j;
    private boolean f1411k;
    private bk f1412l;

    public interface C0699a {
        void mo921a(dt dtVar);
    }

    public dv(dt dtVar, boolean z) {
        this.f1401a = dtVar;
        this.f1411k = z;
    }

    private static boolean m2148a(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    private void m2149b(Uri uri) {
        String path = uri.getPath();
        aa aaVar = (aa) this.f1402b.get(path);
        if (aaVar != null) {
            Map a = dk.m2062a(uri);
            if (dq.m2114a(2)) {
                dq.m2119d("Received GMSG: " + path);
                for (String path2 : a.keySet()) {
                    dq.m2119d("  " + path2 + ": " + ((String) a.get(path2)));
                }
            }
            aaVar.mo874a(this.f1401a, a);
            return;
        }
        dq.m2119d("No GMSG handler found for GMSG: " + uri);
    }

    public final void m2150a(ce ceVar) {
        bh bhVar = null;
        boolean i = this.f1401a.m2145i();
        fs fsVar = (!i || this.f1401a.m2141e().f924e) ? this.f1404d : null;
        if (!i) {
            bhVar = this.f1405e;
        }
        m2151a(new ch(ceVar, fsVar, bhVar, this.f1412l, this.f1401a.m2144h()));
    }

    protected void m2151a(ch chVar) {
        bf.m1684a(this.f1401a.getContext(), chVar);
    }

    public final void m2152a(C0699a c0699a) {
        this.f1406f = c0699a;
    }

    public void m2153a(fs fsVar, bh bhVar, C0817y c0817y, bk bkVar, boolean z, ab abVar) {
        m2155a("/appEvent", new C0844x(c0817y));
        m2155a("/canOpenURLs", C0853z.f1804b);
        m2155a("/click", C0853z.f1805c);
        m2155a("/close", C0853z.f1806d);
        m2155a("/customClose", C0853z.f1807e);
        m2155a("/httpTrack", C0853z.f1808f);
        m2155a("/log", C0853z.f1809g);
        m2155a("/open", new ae(abVar));
        m2155a("/touch", C0853z.f1810h);
        m2155a("/video", C0853z.f1811i);
        this.f1404d = fsVar;
        this.f1405e = bhVar;
        this.f1407g = c0817y;
        this.f1409i = abVar;
        this.f1412l = bkVar;
        m2156a(z);
    }

    public void m2154a(fs fsVar, bh bhVar, C0817y c0817y, bk bkVar, boolean z, ab abVar, ad adVar) {
        m2153a(fsVar, bhVar, c0817y, bkVar, z, abVar);
        m2155a("/setInterstitialProperties", new ac(adVar));
        this.f1410j = adVar;
    }

    public final void m2155a(String str, aa aaVar) {
        this.f1402b.put(str, aaVar);
    }

    public final void m2156a(boolean z) {
        this.f1408h = z;
    }

    public final void m2157a(boolean z, int i) {
        fs fsVar = (!this.f1401a.m2145i() || this.f1401a.m2141e().f924e) ? this.f1404d : null;
        m2151a(new ch(fsVar, this.f1405e, this.f1412l, this.f1401a, z, i, this.f1401a.m2144h()));
    }

    public final void m2158a(boolean z, int i, String str) {
        bh bhVar = null;
        boolean i2 = this.f1401a.m2145i();
        fs fsVar = (!i2 || this.f1401a.m2141e().f924e) ? this.f1404d : null;
        if (!i2) {
            bhVar = this.f1405e;
        }
        m2151a(new ch(fsVar, bhVar, this.f1407g, this.f1412l, this.f1401a, z, i, str, this.f1401a.m2144h(), this.f1409i));
    }

    public final void m2159a(boolean z, int i, String str, String str2) {
        boolean i2 = this.f1401a.m2145i();
        fs fsVar = (!i2 || this.f1401a.m2141e().f924e) ? this.f1404d : null;
        m2151a(new ch(fsVar, i2 ? null : this.f1405e, this.f1407g, this.f1412l, this.f1401a, z, i, str, str2, this.f1401a.m2144h(), this.f1409i));
    }

    public boolean m2160a() {
        boolean z;
        synchronized (this.f1403c) {
            z = this.f1411k;
        }
        return z;
    }

    public final void m2161b() {
        synchronized (this.f1403c) {
            this.f1402b.clear();
            this.f1404d = null;
            this.f1405e = null;
            this.f1406f = null;
            this.f1407g = null;
            this.f1408h = false;
            this.f1411k = false;
            this.f1409i = null;
            this.f1412l = null;
        }
    }

    public final void m2162c() {
        synchronized (this.f1403c) {
            this.f1408h = false;
            this.f1411k = true;
            final bf d = this.f1401a.m2140d();
            if (d != null) {
                if (dp.m2111b()) {
                    d.m1706k();
                } else {
                    dp.f1344a.post(new Runnable(this) {
                        final /* synthetic */ dv f1400b;

                        public void run() {
                            d.m1706k();
                        }
                    });
                }
            }
        }
    }

    public final void onLoadResource(WebView webView, String str) {
        dq.m2119d("Loading resource: " + str);
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m2149b(parse);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        if (this.f1406f != null) {
            this.f1406f.mo921a(this.f1401a);
            this.f1406f = null;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        dq.m2119d("AdWebView shouldOverrideUrlLoading: " + str);
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m2149b(parse);
        } else if (this.f1408h && webView == this.f1401a && m2148a(parse)) {
            return super.shouldOverrideUrlLoading(webView, str);
        } else {
            if (this.f1401a.willNotDraw()) {
                dq.m2120e("AdWebView unable to handle URL: " + str);
            } else {
                Uri uri;
                try {
                    fg g = this.f1401a.m2143g();
                    if (g != null && g.m2506b(parse)) {
                        parse = g.m2502a(parse, this.f1401a.getContext());
                    }
                    uri = parse;
                } catch (fi e) {
                    dq.m2120e("Unable to append parameter to URL: " + str);
                    uri = parse;
                }
                m2150a(new ce("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
            }
        }
        return true;
    }
}
