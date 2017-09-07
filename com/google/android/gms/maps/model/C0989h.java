package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.ek;
import com.google.android.gms.maps.model.p030a.C0970f;

public final class C0989h {
    private final C0970f f2000a;

    public C0989h(C0970f c0970f) {
        this.f2000a = (C0970f) ek.m2332a((Object) c0970f);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0989h)) {
            return false;
        }
        try {
            return this.f2000a.mo1363a(((C0989h) obj).f2000a);
        } catch (RemoteException e) {
            throw new C0993l(e);
        }
    }

    public int hashCode() {
        try {
            return this.f2000a.mo1378k();
        } catch (RemoteException e) {
            throw new C0993l(e);
        }
    }
}
