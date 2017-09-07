package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.webkit.WebView;
import com.google.android.gms.internal.dv.C0699a;

public class ck implements Runnable {
    protected final dt f1162a;
    protected boolean f1163b;
    protected boolean f1164c;
    private final Handler f1165d;
    private final long f1166e;
    private long f1167f;
    private C0699a f1168g;
    private final int f1169h;
    private final int f1170i;

    protected final class C0732a extends AsyncTask<Void, Void, Boolean> {
        final /* synthetic */ ck f1159a;
        private final WebView f1160b;
        private Bitmap f1161c;

        public C0732a(ck ckVar, WebView webView) {
            this.f1159a = ckVar;
            this.f1160b = webView;
        }

        protected synchronized Boolean m1880a(Void... voidArr) {
            Boolean valueOf;
            int width = this.f1161c.getWidth();
            int height = this.f1161c.getHeight();
            if (width == 0 || height == 0) {
                valueOf = Boolean.valueOf(false);
            } else {
                int i = 0;
                for (int i2 = 0; i2 < width; i2 += 10) {
                    for (int i3 = 0; i3 < height; i3 += 10) {
                        if (this.f1161c.getPixel(i2, i3) != 0) {
                            i++;
                        }
                    }
                }
                valueOf = Boolean.valueOf(((double) i) / (((double) (width * height)) / 100.0d) > 0.1d);
            }
            return valueOf;
        }

        protected void m1881a(Boolean bool) {
            ck.m1884c(this.f1159a);
            if (bool.booleanValue() || this.f1159a.m1893c() || this.f1159a.f1167f <= 0) {
                this.f1159a.f1164c = bool.booleanValue();
                this.f1159a.f1168g.mo921a(this.f1159a.f1162a);
            } else if (this.f1159a.f1167f > 0) {
                if (dq.m2114a(2)) {
                    dq.m2112a("Ad not detected, scheduling another run.");
                }
                this.f1159a.f1165d.postDelayed(this.f1159a, this.f1159a.f1166e);
            }
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m1880a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m1881a((Boolean) obj);
        }

        protected synchronized void onPreExecute() {
            this.f1161c = Bitmap.createBitmap(this.f1159a.f1170i, this.f1159a.f1169h, Config.ARGB_8888);
            this.f1160b.setVisibility(0);
            this.f1160b.measure(MeasureSpec.makeMeasureSpec(this.f1159a.f1170i, 0), MeasureSpec.makeMeasureSpec(this.f1159a.f1169h, 0));
            this.f1160b.layout(0, 0, this.f1159a.f1170i, this.f1159a.f1169h);
            this.f1160b.draw(new Canvas(this.f1161c));
            this.f1160b.invalidate();
        }
    }

    public ck(C0699a c0699a, dt dtVar, int i, int i2) {
        this(c0699a, dtVar, i, i2, 200, 50);
    }

    public ck(C0699a c0699a, dt dtVar, int i, int i2, long j, long j2) {
        this.f1166e = j;
        this.f1167f = j2;
        this.f1165d = new Handler(Looper.getMainLooper());
        this.f1162a = dtVar;
        this.f1168g = c0699a;
        this.f1163b = false;
        this.f1164c = false;
        this.f1169h = i2;
        this.f1170i = i;
    }

    static /* synthetic */ long m1884c(ck ckVar) {
        long j = ckVar.f1167f - 1;
        ckVar.f1167f = j;
        return j;
    }

    public void m1889a() {
        this.f1165d.postDelayed(this, this.f1166e);
    }

    public void m1890a(du duVar) {
        m1891a(duVar, new ea(this, this.f1162a, duVar.f1397q));
    }

    public void m1891a(du duVar, ea eaVar) {
        this.f1162a.setWebViewClient(eaVar);
        this.f1162a.loadDataWithBaseURL(TextUtils.isEmpty(duVar.f1382b) ? null : dk.m2061a(duVar.f1382b), duVar.f1383c, "text/html", "UTF-8", null);
    }

    public synchronized void m1892b() {
        this.f1163b = true;
    }

    public synchronized boolean m1893c() {
        return this.f1163b;
    }

    public boolean m1894d() {
        return this.f1164c;
    }

    public void run() {
        if (this.f1162a == null || m1893c()) {
            this.f1168g.mo921a(this.f1162a);
        } else {
            new C0732a(this, this.f1162a).execute(new Void[0]);
        }
    }
}
