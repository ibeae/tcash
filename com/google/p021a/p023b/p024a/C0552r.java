package com.google.p021a.p023b.p024a;

import com.google.p021a.p023b.p024a.C0545m.C0544a;
import com.google.p021a.p025d.C0527a;
import com.google.p021a.p025d.C0530d;
import com.google.p021a.p026c.C0596a;
import java.lang.reflect.Type;

final class C0552r<T> extends C0516q<T> {
    private final C0537j f535a;
    private final C0516q<T> f536b;
    private final Type f537c;

    C0552r(C0537j c0537j, C0516q<T> c0516q, Type type) {
        this.f535a = c0537j;
        this.f536b = c0516q;
        this.f537c = type;
    }

    public void mo803a(C0530d c0530d, T t) {
        C0516q c0516q = this.f536b;
        Type a = C0541l.m996a(this.f537c, t);
        if (a != this.f537c) {
            c0516q = this.f535a.m991a(C0596a.m1194a(a));
            if ((c0516q instanceof C0544a) && !(this.f536b instanceof C0544a)) {
                c0516q = this.f536b;
            }
        }
        c0516q.mo803a(c0530d, t);
    }

    public T mo804b(C0527a c0527a) {
        return this.f536b.mo804b(c0527a);
    }
}
