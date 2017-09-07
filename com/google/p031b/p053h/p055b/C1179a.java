package com.google.p031b.p053h.p055b;

import com.google.p031b.C1178o;

public final class C1179a extends C1178o {
    private final float f2545a;

    C1179a(float f, float f2, float f3) {
        super(f, f2);
        this.f2545a = f3;
    }

    boolean m4398a(float f, float f2, float f3) {
        if (Math.abs(f2 - m4397b()) > f || Math.abs(f3 - m4396a()) > f) {
            return false;
        }
        float abs = Math.abs(f - this.f2545a);
        return abs <= 1.0f || abs <= this.f2545a;
    }

    C1179a m4399b(float f, float f2, float f3) {
        return new C1179a((m4396a() + f2) / 2.0f, (m4397b() + f) / 2.0f, (this.f2545a + f3) / 2.0f);
    }
}
