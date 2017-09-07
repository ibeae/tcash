package com.google.p031b.p045f;

import com.google.p031b.C1078l;
import com.google.p031b.C1199m;
import com.google.p031b.p034c.C1046a;

final class C1132q {
    private static final int[] f2417a = new int[]{1, 1, 2};
    private final C1130o f2418b = new C1130o();
    private final C1131p f2419c = new C1131p();

    C1132q() {
    }

    C1199m m4178a(int i, C1046a c1046a, int i2) {
        int[] a = C1122r.m4135a(c1046a, i2, false, f2417a);
        try {
            return this.f2419c.m4177a(i, c1046a, a);
        } catch (C1078l e) {
            return this.f2418b.m4171a(i, c1046a, a);
        }
    }
}
