package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.internal.C0840t;

public final class InterstitialAd {
    private final C0840t f826a;

    public InterstitialAd(Context context) {
        this.f826a = new C0840t(context);
    }

    public void m1405a() {
        this.f826a.m2787a();
    }

    public void m1406a(AdListener adListener) {
        this.f826a.m2788a(adListener);
    }

    public void m1407a(AdRequest adRequest) {
        this.f826a.m2789a(adRequest.m1396a());
    }

    public void m1408a(String str) {
        this.f826a.m2790a(str);
    }
}
