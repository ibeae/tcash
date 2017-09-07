package com.google.p031b.p053h.p055b;

import com.google.p031b.C1178o;

public final class C1182d extends C1178o {
    private final float f2557a;
    private final int f2558b;

    C1182d(float f, float f2, float f3) {
        this(f, f2, f3, 1);
    }

    private C1182d(float f, float f2, float f3, int i) {
        super(f, f2);
        this.f2557a = f3;
        this.f2558b = i;
    }

    boolean m4415a(float f, float f2, float f3) {
        if (Math.abs(f2 - m4397b()) > f || Math.abs(f3 - m4396a()) > f) {
            return false;
        }
        float abs = Math.abs(f - this.f2557a);
        return abs <= 1.0f || abs <= this.f2557a;
    }

    C1182d m4416b(float f, float f2, float f3) {
        int i = this.f2558b + 1;
        return new C1182d(((((float) this.f2558b) * m4396a()) + f2) / ((float) i), ((((float) this.f2558b) * m4397b()) + f) / ((float) i), ((((float) this.f2558b) * this.f2557a) + f3) / ((float) i), i);
    }

    public float m4417c() {
        return this.f2557a;
    }

    int m4418d() {
        return this.f2558b;
    }
}
