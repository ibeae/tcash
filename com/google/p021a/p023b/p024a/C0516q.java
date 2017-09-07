package com.google.p021a.p023b.p024a;

import com.google.p021a.C0623s;
import com.google.p021a.C0625t;
import com.google.p021a.p025d.C0527a;
import com.google.p021a.p025d.C0530d;
import com.google.p021a.p026c.C0596a;

public abstract class C0516q<T> {

    public interface C0514a {
        <T> C0516q<T> mo802a(C0537j c0537j, C0596a<T> c0596a);
    }

    public C0623s m845a(T t) {
        try {
            C0530d c0531h = new C0531h();
            c0531h.m949b(true);
            mo803a(c0531h, t);
            return c0531h.mo825a();
        } catch (Throwable e) {
            throw new C0625t(e);
        }
    }

    public T m846a(C0623s c0623s) {
        try {
            C0527a c0528g = new C0528g(c0623s);
            c0528g.m902a(true);
            return mo804b(c0528g);
        } catch (Throwable e) {
            throw new C0625t(e);
        }
    }

    public abstract void mo803a(C0530d c0530d, T t);

    public abstract T mo804b(C0527a c0527a);
}
