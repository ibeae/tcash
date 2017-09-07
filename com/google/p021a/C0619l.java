package com.google.p021a;

import com.google.p021a.p023b.C0582g;
import com.google.p021a.p023b.C0587i;
import com.google.p021a.p023b.p024a.C0516q;
import com.google.p021a.p023b.p024a.C0516q.C0514a;
import com.google.p021a.p023b.p024a.C0537j;
import com.google.p021a.p025d.C0527a;
import com.google.p021a.p025d.C0530d;
import com.google.p021a.p026c.C0596a;
import java.lang.reflect.Type;

final class C0619l implements C0514a {
    private final C0582g<C0594z<?>> f732a;
    private final C0582g<C0593r<?>> f733b;
    private final C0614q f734c;
    private final C0616y f735d;

    public C0619l(final C0612j c0612j, C0582g<C0594z<?>> c0582g, C0582g<C0593r<?>> c0582g2) {
        this.f732a = c0582g;
        this.f733b = c0582g2;
        this.f734c = new C0614q(this) {
            final /* synthetic */ C0619l f722b;
        };
        this.f735d = new C0616y(this) {
            final /* synthetic */ C0619l f724b;
        };
    }

    public <T> C0516q<T> mo802a(C0537j c0537j, C0596a<T> c0596a) {
        final Type b = c0596a.m1198b();
        final C0594z c0594z = (C0594z) this.f732a.m1172a(b, false);
        final C0593r c0593r = (C0593r) this.f733b.m1172a(b, false);
        if (c0594z == null && c0593r == null) {
            return null;
        }
        final C0537j c0537j2 = c0537j;
        final C0596a<T> c0596a2 = c0596a;
        return new C0516q<T>(this) {
            final /* synthetic */ C0619l f730f;
            private C0516q<T> f731g;

            private C0516q<T> m1254a() {
                C0516q<T> c0516q = this.f731g;
                if (c0516q != null) {
                    return c0516q;
                }
                c0516q = c0537j2.m990a(this.f730f, c0596a2);
                this.f731g = c0516q;
                return c0516q;
            }

            public void mo803a(C0530d c0530d, T t) {
                if (c0594z == null) {
                    m1254a().mo803a(c0530d, t);
                } else if (t == null) {
                    c0530d.mo832f();
                } else {
                    C0587i.m1180a(c0594z.mo837a(t, b, this.f730f.f735d), c0530d);
                }
            }

            public T mo804b(C0527a c0527a) {
                if (c0593r == null) {
                    return m1254a().mo804b(c0527a);
                }
                C0623s a = C0587i.m1178a(c0527a);
                return a.m1275j() ? null : c0593r.mo838b(a, b, this.f730f.f734c);
            }
        };
    }
}
