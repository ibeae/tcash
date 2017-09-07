package com.google.p031b.p053h.p054a;

public enum C1170f {
    L(1),
    M(0),
    Q(3),
    H(2);
    
    private static final C1170f[] f2510e = null;
    private final int f2512f;

    static {
        f2510e = new C1170f[]{M, L, H, Q};
    }

    private C1170f(int i) {
        this.f2512f = i;
    }

    public static C1170f m4362a(int i) {
        if (i >= 0 && i < f2510e.length) {
            return f2510e[i];
        }
        throw new IllegalArgumentException();
    }

    public int m4363a() {
        return this.f2512f;
    }
}
