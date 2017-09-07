package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.by.C0714a;

public final class cc extends C0714a {
    private final InAppPurchaseListener f1109a;

    public cc(InAppPurchaseListener inAppPurchaseListener) {
        this.f1109a = inAppPurchaseListener;
    }

    public void mo944a(bx bxVar) {
        this.f1109a.m1432a(new cf(bxVar));
    }
}
