package com.google.p031b.p053h.p054a;

import com.google.p031b.C1178o;

public final class C1173i {
    private final boolean f2530a;

    C1173i(boolean z) {
        this.f2530a = z;
    }

    public void m4372a(C1178o[] c1178oArr) {
        if (this.f2530a && c1178oArr != null && c1178oArr.length >= 3) {
            C1178o c1178o = c1178oArr[0];
            c1178oArr[0] = c1178oArr[2];
            c1178oArr[2] = c1178o;
        }
    }
}
