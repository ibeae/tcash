package com.google.p021a;

import com.google.p021a.p023b.C0565a;
import java.util.Collection;

final class C0604d implements C0505e {
    private final Collection<C0505e> f666a;

    C0604d(Collection<C0505e> collection) {
        this.f666a = (Collection) C0565a.m1129a((Object) collection);
    }

    public boolean mo797a(C0607h c0607h) {
        for (C0505e a : this.f666a) {
            if (a.mo797a(c0607h)) {
                return true;
            }
        }
        return false;
    }

    public boolean mo798a(Class<?> cls) {
        for (C0505e a : this.f666a) {
            if (a.mo798a((Class) cls)) {
                return true;
            }
        }
        return false;
    }
}
