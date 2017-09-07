package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.facebook.internal.ServerProtocol;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class dt extends WebView implements DownloadListener {
    private final dv f1370a;
    private final C0752a f1371b;
    private final Object f1372c = new Object();
    private final fg f1373d;
    private final ev f1374e;
    private bf f1375f;
    private al f1376g;
    private boolean f1377h;
    private boolean f1378i;
    private boolean f1379j;
    private final WindowManager f1380k;

    private static class C0752a extends MutableContextWrapper {
        private Activity f1368a;
        private Context f1369b;

        public C0752a(Context context) {
            super(context);
            setBaseContext(context);
        }

        public Context m2124a() {
            return this.f1368a;
        }

        public void setBaseContext(Context context) {
            this.f1369b = context.getApplicationContext();
            this.f1368a = context instanceof Activity ? (Activity) context : null;
            super.setBaseContext(this.f1369b);
        }

        public void startActivity(Intent intent) {
            if (this.f1368a != null) {
                this.f1368a.startActivity(intent);
                return;
            }
            intent.setFlags(268435456);
            this.f1369b.startActivity(intent);
        }
    }

    private dt(C0752a c0752a, al alVar, boolean z, boolean z2, fg fgVar, ev evVar) {
        super(c0752a);
        this.f1371b = c0752a;
        this.f1376g = alVar;
        this.f1377h = z;
        this.f1373d = fgVar;
        this.f1374e = evVar;
        this.f1380k = (WindowManager) getContext().getSystemService("window");
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        dk.m2067a((Context) c0752a, evVar.f1564b, settings);
        if (VERSION.SDK_INT >= 17) {
            dn.m2100a(getContext(), settings);
        } else if (VERSION.SDK_INT >= 11) {
            dm.m2093a(getContext(), settings);
        }
        setDownloadListener(this);
        if (VERSION.SDK_INT >= 11) {
            this.f1370a = new dy(this, z2);
        } else {
            this.f1370a = new dv(this, z2);
        }
        setWebViewClient(this.f1370a);
        if (VERSION.SDK_INT >= 14) {
            setWebChromeClient(new dz(this));
        } else if (VERSION.SDK_INT >= 11) {
            setWebChromeClient(new dw(this));
        }
        m2126l();
    }

    public static dt m2125a(Context context, al alVar, boolean z, boolean z2, fg fgVar, ev evVar) {
        return new dt(new C0752a(context), alVar, z, z2, fgVar, evVar);
    }

    private void m2126l() {
        synchronized (this.f1372c) {
            if (this.f1377h || this.f1376g.f924e) {
                if (VERSION.SDK_INT < 14) {
                    dq.m2112a("Disabling hardware acceleration on an overlay.");
                    m2127m();
                } else {
                    dq.m2112a("Enabling hardware acceleration on an overlay.");
                    m2128n();
                }
            } else if (VERSION.SDK_INT < 18) {
                dq.m2112a("Disabling hardware acceleration on an AdView.");
                m2127m();
            } else {
                dq.m2112a("Enabling hardware acceleration on an AdView.");
                m2128n();
            }
        }
    }

    private void m2127m() {
        synchronized (this.f1372c) {
            if (!this.f1378i && VERSION.SDK_INT >= 11) {
                dm.m2094a((View) this);
            }
            this.f1378i = true;
        }
    }

    private void m2128n() {
        synchronized (this.f1372c) {
            if (this.f1378i && VERSION.SDK_INT >= 11) {
                dm.m2097b((View) this);
            }
            this.f1378i = false;
        }
    }

    public void m2129a() {
        if (m2142f().m2160a()) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Display defaultDisplay = this.f1380k.getDefaultDisplay();
            defaultDisplay.getMetrics(displayMetrics);
            float f = 160.0f / ((float) displayMetrics.densityDpi);
            try {
                m2138b("onScreenInfoChanged", new JSONObject().put("width", (int) (((float) displayMetrics.widthPixels) * f)).put("height", (int) (((float) (displayMetrics.heightPixels - dk.m2083c(getContext()))) * f)).put("density", (double) displayMetrics.density).put("rotation", defaultDisplay.getRotation()));
            } catch (Throwable e) {
                dq.m2116b("Error occured while obtaining screen information.", e);
            }
        }
    }

    public void m2130a(Context context, al alVar) {
        synchronized (this.f1372c) {
            this.f1371b.setBaseContext(context);
            this.f1375f = null;
            this.f1376g = alVar;
            this.f1377h = false;
            dk.m2081b((WebView) this);
            loadUrl("about:blank");
            this.f1370a.m2161b();
        }
    }

    public void m2131a(al alVar) {
        synchronized (this.f1372c) {
            this.f1376g = alVar;
            requestLayout();
        }
    }

    public void m2132a(bf bfVar) {
        synchronized (this.f1372c) {
            this.f1375f = bfVar;
        }
    }

    protected void m2133a(String str) {
        synchronized (this.f1372c) {
            if (m2147k()) {
                dq.m2120e("The webview is destroyed. Ignoring action.");
            } else {
                loadUrl(str);
            }
        }
    }

    public void m2134a(String str, Map<String, ?> map) {
        try {
            m2138b(str, dk.m2066a((Map) map));
        } catch (JSONException e) {
            dq.m2120e("Could not convert parameters to JSON.");
        }
    }

    public void m2135a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:" + str + "(");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        m2133a(stringBuilder.toString());
    }

    public void m2136a(boolean z) {
        synchronized (this.f1372c) {
            this.f1377h = z;
            m2126l();
        }
    }

    public void m2137b() {
        Map hashMap = new HashMap(1);
        hashMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.f1374e.f1564b);
        m2134a("onhide", hashMap);
    }

    public void m2138b(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:AFMA_ReceiveMessage('");
        stringBuilder.append(str);
        stringBuilder.append("'");
        stringBuilder.append(",");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        dq.m2119d("Dispatching AFMA event: " + stringBuilder);
        m2133a(stringBuilder.toString());
    }

    public void m2139c() {
        Map hashMap = new HashMap(1);
        hashMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.f1374e.f1564b);
        m2134a("onshow", hashMap);
    }

    public bf m2140d() {
        bf bfVar;
        synchronized (this.f1372c) {
            bfVar = this.f1375f;
        }
        return bfVar;
    }

    public void destroy() {
        synchronized (this.f1372c) {
            super.destroy();
            this.f1379j = true;
        }
    }

    public al m2141e() {
        al alVar;
        synchronized (this.f1372c) {
            alVar = this.f1376g;
        }
        return alVar;
    }

    public dv m2142f() {
        return this.f1370a;
    }

    public fg m2143g() {
        return this.f1373d;
    }

    public ev m2144h() {
        return this.f1374e;
    }

    public boolean m2145i() {
        boolean z;
        synchronized (this.f1372c) {
            z = this.f1377h;
        }
        return z;
    }

    public Context m2146j() {
        return this.f1371b.m2124a();
    }

    public boolean m2147k() {
        boolean z;
        synchronized (this.f1372c) {
            z = this.f1379j;
        }
        return z;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            dq.m2112a("Couldn't find an Activity to view url/mimetype: " + str + " / " + str4);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onMeasure(int r10, int r11) {
        /*
        r9 = this;
        r0 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r8 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = 8;
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r4 = r9.f1372c;
        monitor-enter(r4);
        r1 = r9.isInEditMode();	 Catch:{ all -> 0x00ae }
        if (r1 != 0) goto L_0x0016;
    L_0x0012:
        r1 = r9.f1377h;	 Catch:{ all -> 0x00ae }
        if (r1 == 0) goto L_0x001b;
    L_0x0016:
        super.onMeasure(r10, r11);	 Catch:{ all -> 0x00ae }
        monitor-exit(r4);	 Catch:{ all -> 0x00ae }
    L_0x001a:
        return;
    L_0x001b:
        r2 = android.view.View.MeasureSpec.getMode(r10);	 Catch:{ all -> 0x00ae }
        r3 = android.view.View.MeasureSpec.getSize(r10);	 Catch:{ all -> 0x00ae }
        r5 = android.view.View.MeasureSpec.getMode(r11);	 Catch:{ all -> 0x00ae }
        r1 = android.view.View.MeasureSpec.getSize(r11);	 Catch:{ all -> 0x00ae }
        if (r2 == r6) goto L_0x002f;
    L_0x002d:
        if (r2 != r8) goto L_0x00c7;
    L_0x002f:
        r2 = r3;
    L_0x0030:
        if (r5 == r6) goto L_0x0034;
    L_0x0032:
        if (r5 != r8) goto L_0x0035;
    L_0x0034:
        r0 = r1;
    L_0x0035:
        r5 = r9.f1376g;	 Catch:{ all -> 0x00ae }
        r5 = r5.f926g;	 Catch:{ all -> 0x00ae }
        if (r5 > r2) goto L_0x0041;
    L_0x003b:
        r2 = r9.f1376g;	 Catch:{ all -> 0x00ae }
        r2 = r2.f923d;	 Catch:{ all -> 0x00ae }
        if (r2 <= r0) goto L_0x00b1;
    L_0x0041:
        r0 = r9.f1371b;	 Catch:{ all -> 0x00ae }
        r0 = r0.getResources();	 Catch:{ all -> 0x00ae }
        r0 = r0.getDisplayMetrics();	 Catch:{ all -> 0x00ae }
        r0 = r0.density;	 Catch:{ all -> 0x00ae }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ae }
        r2.<init>();	 Catch:{ all -> 0x00ae }
        r5 = "Not enough space to show ad. Needs ";
        r2 = r2.append(r5);	 Catch:{ all -> 0x00ae }
        r5 = r9.f1376g;	 Catch:{ all -> 0x00ae }
        r5 = r5.f926g;	 Catch:{ all -> 0x00ae }
        r5 = (float) r5;	 Catch:{ all -> 0x00ae }
        r5 = r5 / r0;
        r5 = (int) r5;	 Catch:{ all -> 0x00ae }
        r2 = r2.append(r5);	 Catch:{ all -> 0x00ae }
        r5 = "x";
        r2 = r2.append(r5);	 Catch:{ all -> 0x00ae }
        r5 = r9.f1376g;	 Catch:{ all -> 0x00ae }
        r5 = r5.f923d;	 Catch:{ all -> 0x00ae }
        r5 = (float) r5;	 Catch:{ all -> 0x00ae }
        r5 = r5 / r0;
        r5 = (int) r5;	 Catch:{ all -> 0x00ae }
        r2 = r2.append(r5);	 Catch:{ all -> 0x00ae }
        r5 = " dp, but only has ";
        r2 = r2.append(r5);	 Catch:{ all -> 0x00ae }
        r3 = (float) r3;	 Catch:{ all -> 0x00ae }
        r3 = r3 / r0;
        r3 = (int) r3;	 Catch:{ all -> 0x00ae }
        r2 = r2.append(r3);	 Catch:{ all -> 0x00ae }
        r3 = "x";
        r2 = r2.append(r3);	 Catch:{ all -> 0x00ae }
        r1 = (float) r1;	 Catch:{ all -> 0x00ae }
        r0 = r1 / r0;
        r0 = (int) r0;	 Catch:{ all -> 0x00ae }
        r0 = r2.append(r0);	 Catch:{ all -> 0x00ae }
        r1 = " dp.";
        r0 = r0.append(r1);	 Catch:{ all -> 0x00ae }
        r0 = r0.toString();	 Catch:{ all -> 0x00ae }
        com.google.android.gms.internal.dq.m2120e(r0);	 Catch:{ all -> 0x00ae }
        r0 = r9.getVisibility();	 Catch:{ all -> 0x00ae }
        if (r0 == r7) goto L_0x00a6;
    L_0x00a2:
        r0 = 4;
        r9.setVisibility(r0);	 Catch:{ all -> 0x00ae }
    L_0x00a6:
        r0 = 0;
        r1 = 0;
        r9.setMeasuredDimension(r0, r1);	 Catch:{ all -> 0x00ae }
    L_0x00ab:
        monitor-exit(r4);	 Catch:{ all -> 0x00ae }
        goto L_0x001a;
    L_0x00ae:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x00ae }
        throw r0;
    L_0x00b1:
        r0 = r9.getVisibility();	 Catch:{ all -> 0x00ae }
        if (r0 == r7) goto L_0x00bb;
    L_0x00b7:
        r0 = 0;
        r9.setVisibility(r0);	 Catch:{ all -> 0x00ae }
    L_0x00bb:
        r0 = r9.f1376g;	 Catch:{ all -> 0x00ae }
        r0 = r0.f926g;	 Catch:{ all -> 0x00ae }
        r1 = r9.f1376g;	 Catch:{ all -> 0x00ae }
        r1 = r1.f923d;	 Catch:{ all -> 0x00ae }
        r9.setMeasuredDimension(r0, r1);	 Catch:{ all -> 0x00ae }
        goto L_0x00ab;
    L_0x00c7:
        r2 = r0;
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.dt.onMeasure(int, int):void");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f1373d != null) {
            this.f1373d.m2504a(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setContext(Context context) {
        this.f1371b.setBaseContext(context);
    }
}
