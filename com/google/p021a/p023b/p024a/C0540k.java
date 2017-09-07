package com.google.p021a.p023b.p024a;

import com.google.p021a.p023b.p024a.C0516q.C0514a;
import com.google.p021a.p025d.C0527a;
import com.google.p021a.p025d.C0530d;
import com.google.p021a.p026c.C0596a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class C0540k extends C0516q<Object> {
    public static final C0514a f512a = new C05381();
    private final C0537j f513b;

    static class C05381 implements C0514a {
        C05381() {
        }

        public <T> C0516q<T> mo802a(C0537j c0537j, C0596a<T> c0596a) {
            return c0596a.m1197a() == Object.class ? new C0540k(c0537j) : null;
        }
    }

    private C0540k(C0537j c0537j) {
        this.f513b = c0537j;
    }

    public void mo803a(C0530d c0530d, Object obj) {
        if (obj == null) {
            c0530d.mo832f();
            return;
        }
        C0516q a = this.f513b.m992a(obj.getClass());
        if (a instanceof C0540k) {
            c0530d.mo830d();
            c0530d.mo831e();
            return;
        }
        a.mo803a(c0530d, obj);
    }

    public Object mo804b(C0527a c0527a) {
        switch (c0527a.mo811f()) {
            case BEGIN_ARRAY:
                List arrayList = new ArrayList();
                c0527a.mo805a();
                while (c0527a.mo810e()) {
                    arrayList.add(mo804b(c0527a));
                }
                c0527a.mo806b();
                return arrayList;
            case BEGIN_OBJECT:
                Map linkedHashMap = new LinkedHashMap();
                c0527a.mo807c();
                while (c0527a.mo810e()) {
                    linkedHashMap.put(c0527a.mo812g(), mo804b(c0527a));
                }
                c0527a.mo809d();
                return linkedHashMap;
            case STRING:
                return c0527a.mo813h();
            case NUMBER:
                return Double.valueOf(c0527a.mo816k());
            case BOOLEAN:
                return Boolean.valueOf(c0527a.mo814i());
            case NULL:
                c0527a.mo815j();
                return null;
            default:
                throw new IllegalStateException();
        }
    }
}
