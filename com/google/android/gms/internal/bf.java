package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.internal.bl.C0704a;
import com.google.android.gms.internal.dv.C0699a;

public class bf extends C0704a {
    private static final int f1010a = Color.argb(0, 0, 0, 0);
    private final Activity f1011b;
    private ch f1012c;
    private bi f1013d;
    private dt f1014e;
    private C0703c f1015f;
    private bj f1016g;
    private boolean f1017h;
    private FrameLayout f1018i;
    private CustomViewCallback f1019j;
    private boolean f1020k;
    private boolean f1021l;
    private boolean f1022m;
    private RelativeLayout f1023n;

    class C07001 implements C0699a {
        final /* synthetic */ bf f1005a;

        C07001(bf bfVar) {
            this.f1005a = bfVar;
        }

        public void mo921a(dt dtVar) {
            dtVar.m2139c();
        }
    }

    private static final class C0701a extends Exception {
        public C0701a(String str) {
            super(str);
        }
    }

    private static final class C0702b extends RelativeLayout {
        private final dl f1006a;

        public C0702b(Context context, String str) {
            super(context);
            this.f1006a = new dl(context, str);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            this.f1006a.m2091a(motionEvent);
            return false;
        }
    }

    private static final class C0703c {
        public final int f1007a;
        public final LayoutParams f1008b;
        public final ViewGroup f1009c;

        public C0703c(dt dtVar) {
            this.f1008b = dtVar.getLayoutParams();
            ViewParent parent = dtVar.getParent();
            if (parent instanceof ViewGroup) {
                this.f1009c = (ViewGroup) parent;
                this.f1007a = this.f1009c.indexOfChild(dtVar);
                this.f1009c.removeView(dtVar);
                dtVar.m2136a(true);
                return;
            }
            throw new C0701a("Could not get the parent of the WebView for an overlay.");
        }
    }

    public static void m1684a(Context context, ch chVar) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", chVar.f1134n.f1567e);
        ch.m1853a(intent, chVar);
        intent.addFlags(524288);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    private static RelativeLayout.LayoutParams m1685c(int i, int i2, int i3, int i4) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        return layoutParams;
    }

    private void m1686c(boolean z) {
        if (!this.f1017h) {
            this.f1011b.requestWindowFeature(1);
        }
        Window window = this.f1011b.getWindow();
        if (!this.f1022m || this.f1012c.f1137q.f1799c) {
            window.setFlags(1024, 1024);
        }
        m1689a(this.f1012c.f1131k);
        if (VERSION.SDK_INT >= 11) {
            dq.m2112a("Enabling hardware acceleration on the AdActivity window.");
            dm.m2095a(window);
        }
        this.f1023n = new C0702b(this.f1011b, this.f1012c.f1136p);
        if (this.f1022m) {
            this.f1023n.setBackgroundColor(f1010a);
        } else {
            this.f1023n.setBackgroundColor(-16777216);
        }
        this.f1011b.setContentView(this.f1023n);
        mo930j();
        boolean a = this.f1012c.f1125e.m2142f().m2160a();
        if (z) {
            this.f1014e = dt.m2125a(this.f1011b, this.f1012c.f1125e.m2141e(), true, a, null, this.f1012c.f1134n);
            this.f1014e.m2142f().m2153a(null, null, this.f1012c.f1126f, this.f1012c.f1130j, true, this.f1012c.f1135o);
            this.f1014e.m2142f().m2152a(new C07001(this));
            if (this.f1012c.f1133m != null) {
                this.f1014e.loadUrl(this.f1012c.f1133m);
            } else if (this.f1012c.f1129i != null) {
                this.f1014e.loadDataWithBaseURL(this.f1012c.f1127g, this.f1012c.f1129i, "text/html", "UTF-8", null);
            } else {
                throw new C0701a("No URL or HTML to display in ad overlay.");
            }
        }
        this.f1014e = this.f1012c.f1125e;
        this.f1014e.setContext(this.f1011b);
        this.f1014e.m2132a(this);
        ViewParent parent = this.f1014e.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.f1014e);
        }
        if (this.f1022m) {
            this.f1014e.setBackgroundColor(f1010a);
        }
        this.f1023n.addView(this.f1014e, -1, -1);
        if (!z) {
            this.f1014e.m2139c();
        }
        m1693a(a);
    }

    private void m1687l() {
        if (this.f1011b.isFinishing() && !this.f1021l) {
            this.f1021l = true;
            if (this.f1011b.isFinishing()) {
                if (this.f1014e != null) {
                    this.f1014e.m2137b();
                    this.f1023n.removeView(this.f1014e);
                    if (this.f1015f != null) {
                        this.f1014e.m2136a(false);
                        this.f1015f.f1009c.addView(this.f1014e, this.f1015f.f1007a, this.f1015f.f1008b);
                    }
                }
                if (this.f1012c != null && this.f1012c.f1124d != null) {
                    this.f1012c.f1124d.mo1097o();
                }
            }
        }
    }

    public void m1688a() {
        this.f1011b.finish();
    }

    public void m1689a(int i) {
        this.f1011b.setRequestedOrientation(i);
    }

    public void m1690a(int i, int i2, int i3, int i4) {
        if (this.f1013d != null) {
            this.f1013d.setLayoutParams(m1685c(i, i2, i3, i4));
        }
    }

    public void mo922a(Bundle bundle) {
        boolean z = false;
        if (bundle != null) {
            z = bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        this.f1020k = z;
        try {
            this.f1012c = ch.m1852a(this.f1011b.getIntent());
            if (this.f1012c == null) {
                throw new C0701a("Could not get info for ad overlay.");
            }
            if (this.f1012c.f1137q != null) {
                this.f1022m = this.f1012c.f1137q.f1798b;
            } else {
                this.f1022m = false;
            }
            if (bundle == null) {
                if (this.f1012c.f1124d != null) {
                    this.f1012c.f1124d.mo1098p();
                }
                if (!(this.f1012c.f1132l == 1 || this.f1012c.f1123c == null)) {
                    this.f1012c.f1123c.mo1100r();
                }
            }
            switch (this.f1012c.f1132l) {
                case 1:
                    m1686c(false);
                    return;
                case 2:
                    this.f1015f = new C0703c(this.f1012c.f1125e);
                    m1686c(false);
                    return;
                case 3:
                    m1686c(true);
                    return;
                case 4:
                    if (this.f1020k) {
                        this.f1011b.finish();
                        return;
                    } else if (!bd.m1669a(this.f1011b, this.f1012c.f1122b, this.f1012c.f1130j)) {
                        this.f1011b.finish();
                        return;
                    } else {
                        return;
                    }
                default:
                    throw new C0701a("Could not determine ad overlay type.");
            }
        } catch (C0701a e) {
            dq.m2120e(e.getMessage());
            this.f1011b.finish();
        }
    }

    public void m1692a(View view, CustomViewCallback customViewCallback) {
        this.f1018i = new FrameLayout(this.f1011b);
        this.f1018i.setBackgroundColor(-16777216);
        this.f1018i.addView(view, -1, -1);
        this.f1011b.setContentView(this.f1018i);
        mo930j();
        this.f1019j = customViewCallback;
    }

    public void m1693a(boolean z) {
        this.f1016g = new bj(this.f1011b, z ? 50 : 32);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        this.f1016g.m1728a(this.f1012c.f1128h);
        this.f1023n.addView(this.f1016g, layoutParams);
    }

    public bi m1694b() {
        return this.f1013d;
    }

    public void m1695b(int i, int i2, int i3, int i4) {
        if (this.f1013d == null) {
            this.f1013d = new bi(this.f1011b, this.f1014e);
            this.f1023n.addView(this.f1013d, 0, m1685c(i, i2, i3, i4));
            this.f1014e.m2142f().m2156a(false);
        }
    }

    public void mo923b(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.f1020k);
    }

    public void m1697b(boolean z) {
        if (this.f1016g != null) {
            this.f1016g.m1728a(z);
        }
    }

    public void m1698c() {
        if (this.f1012c != null) {
            m1689a(this.f1012c.f1131k);
        }
        if (this.f1018i != null) {
            this.f1011b.setContentView(this.f1023n);
            mo930j();
            this.f1018i.removeAllViews();
            this.f1018i = null;
        }
        if (this.f1019j != null) {
            this.f1019j.onCustomViewHidden();
            this.f1019j = null;
        }
    }

    public void mo924d() {
    }

    public void mo925e() {
    }

    public void mo926f() {
        if (this.f1012c != null && this.f1012c.f1132l == 4) {
            if (this.f1020k) {
                this.f1011b.finish();
            } else {
                this.f1020k = true;
            }
        }
        if (this.f1014e != null) {
            dk.m2081b(this.f1014e);
        }
    }

    public void mo927g() {
        if (this.f1013d != null) {
            this.f1013d.m1725c();
        }
        m1698c();
        if (this.f1014e != null && (!this.f1011b.isFinishing() || this.f1015f == null)) {
            dk.m2070a(this.f1014e);
        }
        m1687l();
    }

    public void mo928h() {
        m1687l();
    }

    public void mo929i() {
        if (this.f1013d != null) {
            this.f1013d.m1719a();
        }
        if (this.f1014e != null) {
            this.f1023n.removeView(this.f1014e);
        }
        m1687l();
    }

    public void mo930j() {
        this.f1017h = true;
    }

    public void m1706k() {
        this.f1023n.removeView(this.f1016g);
        m1693a(true);
    }
}
