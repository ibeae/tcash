package com.google.p021a;

import com.google.p021a.p022a.C0503c;
import com.google.p021a.p022a.C0504d;
import com.google.p021a.p023b.C0565a;

final class ah implements C0505e {
    private final double f448a;

    ah(double d) {
        C0565a.m1130a(d >= 0.0d);
        this.f448a = d;
    }

    private boolean m838a(C0503c c0503c) {
        return c0503c == null || c0503c.m819a() <= this.f448a;
    }

    private boolean m839a(C0503c c0503c, C0504d c0504d) {
        return m838a(c0503c) && m840a(c0504d);
    }

    private boolean m840a(C0504d c0504d) {
        return c0504d == null || c0504d.m820a() > this.f448a;
    }

    public boolean mo797a(C0607h c0607h) {
        return !m839a((C0503c) c0607h.m1209a(C0503c.class), (C0504d) c0607h.m1209a(C0504d.class));
    }

    public boolean mo798a(Class<?> cls) {
        return !m839a((C0503c) cls.getAnnotation(C0503c.class), (C0504d) cls.getAnnotation(C0504d.class));
    }
}
