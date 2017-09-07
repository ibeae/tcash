package com.google.p021a;

final class C0620m implements C0505e {
    C0620m() {
    }

    private boolean m1260b(Class<?> cls) {
        return cls.isMemberClass() && !m1261c(cls);
    }

    private boolean m1261c(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    public boolean mo797a(C0607h c0607h) {
        return m1260b(c0607h.m1212c());
    }

    public boolean mo798a(Class<?> cls) {
        return m1260b(cls);
    }
}
