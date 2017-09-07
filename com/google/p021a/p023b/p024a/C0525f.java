package com.google.p021a.p023b.p024a;

import com.google.p021a.C0505e;
import com.google.p021a.p023b.p024a.C0516q.C0514a;
import com.google.p021a.p025d.C0527a;
import com.google.p021a.p025d.C0530d;
import com.google.p021a.p026c.C0596a;

public final class C0525f implements C0514a {
    private final C0505e f466a;
    private final C0505e f467b;

    public C0525f(C0505e c0505e, C0505e c0505e2) {
        this.f466a = c0505e;
        this.f467b = c0505e2;
    }

    public <T> C0516q<T> mo802a(C0537j c0537j, C0596a<T> c0596a) {
        Class a = c0596a.m1197a();
        final boolean a2 = this.f466a.mo798a(a);
        final boolean a3 = this.f467b.mo798a(a);
        if (!a2 && !a3) {
            return null;
        }
        final C0537j c0537j2 = c0537j;
        final C0596a<T> c0596a2 = c0596a;
        return new C0516q<T>(this) {
            final /* synthetic */ C0525f f464e;
            private C0516q<T> f465f;

            private C0516q<T> m871a() {
                C0516q<T> c0516q = this.f465f;
                if (c0516q != null) {
                    return c0516q;
                }
                c0516q = c0537j2.m990a(this.f464e, c0596a2);
                this.f465f = c0516q;
                return c0516q;
            }

            public void mo803a(C0530d c0530d, T t) {
                if (a2) {
                    c0530d.mo832f();
                } else {
                    m871a().mo803a(c0530d, t);
                }
            }

            public T mo804b(C0527a c0527a) {
                if (!a3) {
                    return m871a().mo804b(c0527a);
                }
                c0527a.mo819n();
                return null;
            }
        };
    }
}
