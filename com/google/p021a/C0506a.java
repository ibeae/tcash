package com.google.p021a;

final class C0506a implements C0505e {
    C0506a() {
    }

    private boolean m823b(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    public boolean mo797a(C0607h c0607h) {
        return m823b(c0607h.m1212c());
    }

    public boolean mo798a(Class<?> cls) {
        return m823b(cls);
    }
}
