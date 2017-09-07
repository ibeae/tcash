package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.internal.ek;
import com.google.android.gms.maps.model.C0989h;
import com.google.android.gms.maps.model.C0993l;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.p030a.C0970f;
import com.google.android.gms.maps.p029a.C0868b;

public final class C0943c {
    private final C0868b f1880a;

    protected C0943c(C0868b c0868b) {
        this.f1880a = (C0868b) ek.m2332a((Object) c0868b);
    }

    C0868b m3228a() {
        return this.f1880a;
    }

    public final C0989h m3229a(MarkerOptions markerOptions) {
        try {
            C0970f a = this.f1880a.mo1129a(markerOptions);
            return a != null ? new C0989h(a) : null;
        } catch (RemoteException e) {
            throw new C0993l(e);
        }
    }

    public final void m3230a(C0941a c0941a) {
        try {
            this.f1880a.mo1152b(c0941a.m3224a());
        } catch (RemoteException e) {
            throw new C0993l(e);
        }
    }

    public final void m3231a(boolean z) {
        try {
            this.f1880a.mo1155c(z);
        } catch (RemoteException e) {
            throw new C0993l(e);
        }
    }
}
