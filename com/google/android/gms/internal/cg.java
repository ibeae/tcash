package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.cb.C0724a;

public final class cg extends C0724a {
    private final PlayStorePurchaseListener f1120a;

    public cg(PlayStorePurchaseListener playStorePurchaseListener) {
        this.f1120a = playStorePurchaseListener;
    }

    public void mo946a(ca caVar) {
        this.f1120a.m1433a(new cd(caVar));
    }

    public boolean mo947a(String str) {
        return this.f1120a.m1434a(str);
    }
}
