package com.google.p031b.p045f.p046a.p047a.p048a;

final class C1098m {
    private int f2317a = 0;
    private C1097a f2318b = C1097a.NUMERIC;

    private enum C1097a {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    C1098m() {
    }

    int m3996a() {
        return this.f2317a;
    }

    void m3997a(int i) {
        this.f2317a = i;
    }

    void m3998b(int i) {
        this.f2317a += i;
    }

    boolean m3999b() {
        return this.f2318b == C1097a.ALPHA;
    }

    boolean m4000c() {
        return this.f2318b == C1097a.ISO_IEC_646;
    }

    void m4001d() {
        this.f2318b = C1097a.NUMERIC;
    }

    void m4002e() {
        this.f2318b = C1097a.ALPHA;
    }

    void m4003f() {
        this.f2318b = C1097a.ISO_IEC_646;
    }
}
