package com.google.p021a;

import java.util.Collection;
import java.util.HashSet;

final class ad implements C0505e {
    private final Collection<Integer> f445a = new HashSet();

    public ad(int... iArr) {
        if (iArr != null) {
            for (int valueOf : iArr) {
                this.f445a.add(Integer.valueOf(valueOf));
            }
        }
    }

    public boolean mo797a(C0607h c0607h) {
        for (Integer intValue : this.f445a) {
            if (c0607h.m1210a(intValue.intValue())) {
                return true;
            }
        }
        return false;
    }

    public boolean mo798a(Class<?> cls) {
        return false;
    }
}
