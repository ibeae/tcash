package com.google.p031b.p045f.p046a.p047a.p048a;

import com.google.p031b.C1155g;

final class C1102p extends C1099q {
    private final int f2324a;
    private final int f2325b;

    C1102p(int i, int i2, int i3) {
        super(i);
        if (i2 < 0 || i2 > 10 || i3 < 0 || i3 > 10) {
            throw C1155g.m4329a();
        }
        this.f2324a = i2;
        this.f2325b = i3;
    }

    int m4010a() {
        return this.f2324a;
    }

    int m4011b() {
        return this.f2325b;
    }

    boolean m4012c() {
        return this.f2324a == 10;
    }

    boolean m4013d() {
        return this.f2325b == 10;
    }
}
