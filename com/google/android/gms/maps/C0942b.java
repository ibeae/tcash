package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.internal.ek;
import com.google.android.gms.maps.model.C0993l;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.p029a.C0859a;

public final class C0942b {
    private static C0859a f1879a;

    private static C0859a m3225a() {
        return (C0859a) ek.m2333a(f1879a, (Object) "CameraUpdateFactory is not initialized");
    }

    public static C0941a m3226a(LatLng latLng, float f) {
        try {
            return new C0941a(C0942b.m3225a().mo1116a(latLng, f));
        } catch (RemoteException e) {
            throw new C0993l(e);
        }
    }

    static void m3227a(C0859a c0859a) {
        if (f1879a == null) {
            f1879a = (C0859a) ek.m2332a((Object) c0859a);
        }
    }
}
