package com.google.p021a.p023b.p024a;

import com.google.p021a.p023b.C0569b;
import com.google.p021a.p023b.p024a.C0516q.C0514a;
import com.google.p021a.p025d.C0527a;
import com.google.p021a.p025d.C0530d;
import com.google.p021a.p025d.C0600c;
import com.google.p021a.p026c.C0596a;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class C0517a<E> extends C0516q<Object> {
    public static final C0514a f449a = new C05151();
    private final Class<E> f450b;
    private final C0516q<E> f451c;

    static class C05151 implements C0514a {
        C05151() {
        }

        public <T> C0516q<T> mo802a(C0537j c0537j, C0596a<T> c0596a) {
            Type b = c0596a.m1198b();
            if (!(b instanceof GenericArrayType) && (!(b instanceof Class) || !((Class) b).isArray())) {
                return null;
            }
            b = C0569b.m1150g(b);
            return new C0517a(c0537j, c0537j.m991a(C0596a.m1194a(b)), C0569b.m1148e(b));
        }
    }

    public C0517a(C0537j c0537j, C0516q<E> c0516q, Class<E> cls) {
        this.f451c = new C0552r(c0537j, c0516q, cls);
        this.f450b = cls;
    }

    public void mo803a(C0530d c0530d, Object obj) {
        if (obj == null) {
            c0530d.mo832f();
            return;
        }
        c0530d.mo826b();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f451c.mo803a(c0530d, Array.get(obj, i));
        }
        c0530d.mo828c();
    }

    public Object mo804b(C0527a c0527a) {
        if (c0527a.mo811f() == C0600c.NULL) {
            c0527a.mo815j();
            return null;
        }
        List arrayList = new ArrayList();
        c0527a.mo805a();
        while (c0527a.mo810e()) {
            arrayList.add(this.f451c.mo804b(c0527a));
        }
        c0527a.mo806b();
        Object newInstance = Array.newInstance(this.f450b, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }
}
