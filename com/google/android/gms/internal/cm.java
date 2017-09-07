package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.C0663a;
import com.google.android.gms.common.C0665b.C0660b;
import com.google.android.gms.common.C0665b.C0664a;
import com.google.android.gms.internal.cl.C0731a;

public abstract class cm extends di {
    private final ds f1171a;
    private final C0731a f1172b;

    public static final class C0733a extends cm {
        private final Context f1173a;

        public C0733a(Context context, ds dsVar, C0731a c0731a) {
            super(dsVar, c0731a);
            this.f1173a = context;
        }

        public void mo949c() {
        }

        public cr mo950d() {
            return cs.m1963a(this.f1173a, new C0843w(), new ah(), new da());
        }
    }

    public static final class C0734b extends cm implements C0664a, C0660b {
        private final C0731a f1174a;
        private final cn f1175b;
        private final Object f1176c = new Object();

        public C0734b(Context context, ds dsVar, C0731a c0731a) {
            super(dsVar, c0731a);
            this.f1174a = c0731a;
            this.f1175b = new cn(context, this, this, dsVar.f1365k.f1566d);
            this.f1175b.m1932f();
        }

        public void mo951a(Bundle bundle) {
            m1741e();
        }

        public void mo952a(C0663a c0663a) {
            this.f1174a.mo948a(new du(0));
        }

        public void a_() {
            dq.m2112a("Disconnected from remote ad request service.");
        }

        public void mo949c() {
            synchronized (this.f1176c) {
                if (this.f1175b.mo954g() || this.f1175b.m1934h()) {
                    this.f1175b.mo1053i();
                }
            }
        }

        public cr mo950d() {
            cr c;
            synchronized (this.f1176c) {
                try {
                    c = this.f1175b.m1946c();
                } catch (IllegalStateException e) {
                    c = null;
                }
            }
            return c;
        }
    }

    public cm(ds dsVar, C0731a c0731a) {
        this.f1171a = dsVar;
        this.f1172b = c0731a;
    }

    private static du m1898a(cr crVar, ds dsVar) {
        du duVar = null;
        try {
            duVar = crVar.mo961a(dsVar);
        } catch (Throwable e) {
            dq.m2118c("Could not fetch ad response from ad request service.", e);
        } catch (Throwable e2) {
            dq.m2118c("Could not fetch ad response from ad request service due to an Exception.", e2);
        } catch (Throwable e22) {
            dq.m2118c("Could not fetch ad response from ad request service due to an Exception.", e22);
        }
        return duVar;
    }

    public final void mo931a() {
        try {
            du duVar;
            cr d = mo950d();
            if (d == null) {
                duVar = new du(0);
            } else {
                duVar = m1898a(d, this.f1171a);
                if (duVar == null) {
                    duVar = new du(0);
                }
            }
            mo949c();
            this.f1172b.mo948a(duVar);
        } catch (Throwable th) {
            mo949c();
        }
    }

    public final void mo932b() {
        mo949c();
    }

    public abstract void mo949c();

    public abstract cr mo950d();
}
