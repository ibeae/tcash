package com.google.android.gms.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.p027a.C0651c;
import com.google.android.gms.p027a.C0654d;

public final class C0839s {
    private final as f1776a;
    private final C0825j f1777b;
    private AdListener f1778c;
    private C0815o f1779d;
    private AdSize[] f1780e;
    private String f1781f;
    private String f1782g;
    private ViewGroup f1783h;
    private AppEventListener f1784i;
    private InAppPurchaseListener f1785j;
    private PlayStorePurchaseListener f1786k;

    public C0839s(ViewGroup viewGroup) {
        this(viewGroup, null, false, C0825j.m2669a());
    }

    C0839s(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, C0825j c0825j) {
        this.f1776a = new as();
        this.f1783h = viewGroup;
        this.f1777b = c0825j;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                C0830m c0830m = new C0830m(context, attributeSet);
                this.f1780e = c0830m.m2715a(z);
                this.f1781f = c0830m.m2714a();
                if (viewGroup.isInEditMode()) {
                    dp.m2107a(viewGroup, new al(context, this.f1780e[0]), "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                dp.m2109a(viewGroup, new al(context, AdSize.f815a), e.getMessage(), e.getMessage());
            }
        }
    }

    private void m2770h() {
        try {
            C0651c a = this.f1779d.mo1072a();
            if (a != null) {
                this.f1783h.addView((View) C0654d.m1385a(a));
            }
        } catch (Throwable e) {
            dq.m2118c("Failed to get an ad frame.", e);
        }
    }

    private void m2771i() {
        if ((this.f1780e == null || this.f1781f == null) && this.f1779d == null) {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        Context context = this.f1783h.getContext();
        this.f1779d = C0823h.m2662a(context, new al(context, this.f1780e), this.f1781f, this.f1776a);
        if (this.f1778c != null) {
            this.f1779d.mo1077a(new C0822g(this.f1778c));
        }
        if (this.f1784i != null) {
            this.f1779d.mo1078a(new C0829l(this.f1784i));
        }
        if (this.f1785j != null) {
            this.f1779d.mo1074a(new cc(this.f1785j));
        }
        if (this.f1786k != null) {
            this.f1779d.mo1075a(new cg(this.f1786k), this.f1782g);
        }
        m2770h();
    }

    public void m2772a() {
        try {
            if (this.f1779d != null) {
                this.f1779d.mo1084b();
            }
        } catch (Throwable e) {
            dq.m2118c("Failed to destroy AdView.", e);
        }
    }

    public void m2773a(AdListener adListener) {
        try {
            this.f1778c = adListener;
            if (this.f1779d != null) {
                this.f1779d.mo1077a(adListener != null ? new C0822g(adListener) : null);
            }
        } catch (Throwable e) {
            dq.m2118c("Failed to set the AdListener.", e);
        }
    }

    public void m2774a(InAppPurchaseListener inAppPurchaseListener) {
        if (this.f1786k != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.f1785j = inAppPurchaseListener;
            if (this.f1779d != null) {
                this.f1779d.mo1074a(inAppPurchaseListener != null ? new cc(inAppPurchaseListener) : null);
            }
        } catch (Throwable e) {
            dq.m2118c("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void m2775a(C0838r c0838r) {
        try {
            if (this.f1779d == null) {
                m2771i();
            }
            if (this.f1779d.mo1083a(this.f1777b.m2670a(this.f1783h.getContext(), c0838r))) {
                this.f1776a.m1594a(c0838r.m2767i());
            }
        } catch (Throwable e) {
            dq.m2118c("Failed to load ad.", e);
        }
    }

    public void m2776a(String str) {
        if (this.f1781f != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.f1781f = str;
    }

    public void m2777a(AdSize... adSizeArr) {
        if (this.f1780e != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        m2779b(adSizeArr);
    }

    public AdListener m2778b() {
        return this.f1778c;
    }

    public void m2779b(AdSize... adSizeArr) {
        this.f1780e = adSizeArr;
        try {
            if (this.f1779d != null) {
                this.f1779d.mo1073a(new al(this.f1783h.getContext(), this.f1780e));
            }
        } catch (Throwable e) {
            dq.m2118c("Failed to set the ad size.", e);
        }
        this.f1783h.requestLayout();
    }

    public AdSize m2780c() {
        try {
            if (this.f1779d != null) {
                return this.f1779d.mo1091i().m1551a();
            }
        } catch (Throwable e) {
            dq.m2118c("Failed to get the current AdSize.", e);
        }
        return this.f1780e != null ? this.f1780e[0] : null;
    }

    public String m2781d() {
        return this.f1781f;
    }

    public InAppPurchaseListener m2782e() {
        return this.f1785j;
    }

    public void m2783f() {
        try {
            if (this.f1779d != null) {
                this.f1779d.mo1086d();
            }
        } catch (Throwable e) {
            dq.m2118c("Failed to call pause.", e);
        }
    }

    public void m2784g() {
        try {
            if (this.f1779d != null) {
                this.f1779d.mo1087e();
            }
        } catch (Throwable e) {
            dq.m2118c("Failed to call resume.", e);
        }
    }
}
