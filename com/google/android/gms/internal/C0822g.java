package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.C0820n.C0821a;

public final class C0822g extends C0821a {
    private final AdListener f1642a;

    public C0822g(AdListener adListener) {
        this.f1642a = adListener;
    }

    public void mo1102a() {
        this.f1642a.onAdClosed();
    }

    public void mo1103a(int i) {
        this.f1642a.onAdFailedToLoad(i);
    }

    public void mo1104b() {
        this.f1642a.onAdLeftApplication();
    }

    public void mo1105c() {
        this.f1642a.onAdLoaded();
    }

    public void mo1106d() {
        this.f1642a.onAdOpened();
    }
}
