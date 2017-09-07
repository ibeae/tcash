package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.C0665b.C0660b;
import com.google.android.gms.common.C0665b.C0664a;
import com.google.android.gms.internal.ed.C0780d;
import com.google.android.gms.internal.er.C0797a;

public class et extends ed<er> {
    private final ew<er> f1558a = new C0802a();
    private final es f1559e;
    private final ff f1560f;
    private final eo f1561g;
    private final String f1562h;

    private final class C0802a implements ew<er> {
        final /* synthetic */ et f1557a;

        private C0802a(et etVar) {
            this.f1557a = etVar;
        }

        public void mo1051a() {
            this.f1557a.m1937k();
        }

        public er m2450b() {
            return (er) this.f1557a.m1939m();
        }

        public /* synthetic */ IInterface mo1052c() {
            return m2450b();
        }
    }

    public et(Context context, C0664a c0664a, C0660b c0660b, String str) {
        super(context, c0664a, c0660b, new String[0]);
        this.f1559e = new es(context, this.f1558a);
        this.f1562h = str;
        this.f1560f = new ff(context.getPackageName(), this.f1558a);
        this.f1561g = eo.m2361a(context, null, this.f1558a);
    }

    protected er m2453a(IBinder iBinder) {
        return C0797a.m2439a(iBinder);
    }

    protected String mo957a() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    protected void mo958a(ei eiVar, C0780d c0780d) {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.f1562h);
        eiVar.mo995e(c0780d, 5089000, m1936j().getPackageName(), bundle);
    }

    protected /* synthetic */ IInterface mo959b(IBinder iBinder) {
        return m2453a(iBinder);
    }

    protected String mo960b() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    public Location m2458c() {
        return this.f1559e.m2443a();
    }

    public void mo1053i() {
        synchronized (this.f1559e) {
            if (mo954g()) {
                this.f1559e.m2445b();
                this.f1559e.m2446c();
            }
            super.mo1053i();
        }
    }
}
