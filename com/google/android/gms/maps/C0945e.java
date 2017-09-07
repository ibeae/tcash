package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.C0666c;
import com.google.android.gms.internal.ek;
import com.google.android.gms.maps.model.C0983b;
import com.google.android.gms.maps.model.C0993l;
import com.google.android.gms.maps.p029a.C0899m;
import com.google.android.gms.maps.p029a.ae;

public final class C0945e {
    public static int m3235a(Context context) {
        ek.m2332a((Object) context);
        try {
            C0945e.m3236a(ae.m2887a(context));
            return 0;
        } catch (C0666c e) {
            return e.f848a;
        }
    }

    public static void m3236a(C0899m c0899m) {
        try {
            C0942b.m3227a(c0899m.mo1251a());
            C0983b.m3600a(c0899m.mo1257b());
        } catch (RemoteException e) {
            throw new C0993l(e);
        }
    }
}
