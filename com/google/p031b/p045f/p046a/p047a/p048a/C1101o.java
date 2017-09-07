package com.google.p031b.p045f.p046a.p047a.p048a;

final class C1101o extends C1099q {
    private final String f2321a;
    private final int f2322b;
    private final boolean f2323c;

    C1101o(int i, String str) {
        super(i);
        this.f2321a = str;
        this.f2323c = false;
        this.f2322b = 0;
    }

    C1101o(int i, String str, int i2) {
        super(i);
        this.f2323c = true;
        this.f2322b = i2;
        this.f2321a = str;
    }

    String m4007a() {
        return this.f2321a;
    }

    boolean m4008b() {
        return this.f2323c;
    }

    int m4009c() {
        return this.f2322b;
    }
}
