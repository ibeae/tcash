package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

public final class C0840t {
    private final as f1787a;
    private final Context f1788b;
    private final C0825j f1789c;
    private AdListener f1790d;
    private C0815o f1791e;
    private String f1792f;
    private String f1793g;
    private AppEventListener f1794h;
    private PlayStorePurchaseListener f1795i;
    private InAppPurchaseListener f1796j;

    public C0840t(Context context) {
        this(context, C0825j.m2669a());
    }

    public C0840t(Context context, C0825j c0825j) {
        this.f1787a = new as();
        this.f1788b = context;
        this.f1789c = c0825j;
    }

    private void m2785b(String str) {
        if (this.f1792f == null) {
            m2786c(str);
        }
        this.f1791e = C0823h.m2662a(this.f1788b, new al(), this.f1792f, this.f1787a);
        if (this.f1790d != null) {
            this.f1791e.mo1077a(new C0822g(this.f1790d));
        }
        if (this.f1794h != null) {
            this.f1791e.mo1078a(new C0829l(this.f1794h));
        }
        if (this.f1796j != null) {
            this.f1791e.mo1074a(new cc(this.f1796j));
        }
        if (this.f1795i != null) {
            this.f1791e.mo1075a(new cg(this.f1795i), this.f1793g);
        }
    }

    private void m2786c(String str) {
        if (this.f1791e == null) {
            throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + str + " is called.");
        }
    }

    public void m2787a() {
        try {
            m2786c("show");
            this.f1791e.mo1088f();
        } catch (Throwable e) {
            dq.m2118c("Failed to show interstitial.", e);
        }
    }

    public void m2788a(AdListener adListener) {
        try {
            this.f1790d = adListener;
            if (this.f1791e != null) {
                this.f1791e.mo1077a(adListener != null ? new C0822g(adListener) : null);
            }
        } catch (Throwable e) {
            dq.m2118c("Failed to set the AdListener.", e);
        }
    }

    public void m2789a(C0838r c0838r) {
        try {
            if (this.f1791e == null) {
                m2785b("loadAd");
            }
            if (this.f1791e.mo1083a(this.f1789c.m2670a(this.f1788b, c0838r))) {
                this.f1787a.m1594a(c0838r.m2767i());
            }
        } catch (Throwable e) {
            dq.m2118c("Failed to load ad.", e);
        }
    }

    public void m2790a(String str) {
        if (this.f1792f != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.f1792f = str;
    }
}
