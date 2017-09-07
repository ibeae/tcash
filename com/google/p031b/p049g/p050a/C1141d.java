package com.google.p031b.p049g.p050a;

final class C1141d {
    private final int f2458a;
    private final int f2459b;
    private final int f2460c;
    private final int f2461d;
    private int f2462e = -1;

    C1141d(int i, int i2, int i3, int i4) {
        this.f2458a = i;
        this.f2459b = i2;
        this.f2460c = i3;
        this.f2461d = i4;
    }

    boolean m4228a() {
        return m4229a(this.f2462e);
    }

    boolean m4229a(int i) {
        return i != -1 && this.f2460c == (i % 3) * 3;
    }

    void m4230b() {
        this.f2462e = ((this.f2461d / 30) * 3) + (this.f2460c / 3);
    }

    void m4231b(int i) {
        this.f2462e = i;
    }

    int m4232c() {
        return this.f2459b - this.f2458a;
    }

    int m4233d() {
        return this.f2458a;
    }

    int m4234e() {
        return this.f2459b;
    }

    int m4235f() {
        return this.f2460c;
    }

    int m4236g() {
        return this.f2461d;
    }

    int m4237h() {
        return this.f2462e;
    }

    public String toString() {
        return this.f2462e + "|" + this.f2461d;
    }
}
