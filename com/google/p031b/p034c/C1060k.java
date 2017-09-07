package com.google.p031b.p034c;

public final class C1060k {
    private final float f2235a;
    private final float f2236b;
    private final float f2237c;
    private final float f2238d;
    private final float f2239e;
    private final float f2240f;
    private final float f2241g;
    private final float f2242h;
    private final float f2243i;

    private C1060k(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.f2235a = f;
        this.f2236b = f4;
        this.f2237c = f7;
        this.f2238d = f2;
        this.f2239e = f5;
        this.f2240f = f8;
        this.f2241g = f3;
        this.f2242h = f6;
        this.f2243i = f9;
    }

    public static C1060k m3889a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = ((f - f3) + f5) - f7;
        float f10 = ((f2 - f4) + f6) - f8;
        if (f9 == 0.0f && f10 == 0.0f) {
            return new C1060k(f3 - f, f5 - f3, f, f4 - f2, f6 - f4, f2, 0.0f, 0.0f, 1.0f);
        }
        float f11 = f3 - f5;
        float f12 = f7 - f5;
        float f13 = f4 - f6;
        float f14 = f8 - f6;
        float f15 = (f11 * f14) - (f12 * f13);
        float f16 = ((f14 * f9) - (f12 * f10)) / f15;
        float f17 = ((f10 * f11) - (f9 * f13)) / f15;
        return new C1060k((f3 - f) + (f16 * f3), (f7 - f) + (f17 * f7), f, (f16 * f4) + (f4 - f2), (f17 * f8) + (f8 - f2), f2, f16, f17, 1.0f);
    }

    public static C1060k m3890a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        return C1060k.m3889a(f9, f10, f11, f12, f13, f14, f15, f16).m3893a(C1060k.m3891b(f, f2, f3, f4, f5, f6, f7, f8));
    }

    public static C1060k m3891b(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        return C1060k.m3889a(f, f2, f3, f4, f5, f6, f7, f8).m3892a();
    }

    C1060k m3892a() {
        return new C1060k((this.f2239e * this.f2243i) - (this.f2240f * this.f2242h), (this.f2240f * this.f2241g) - (this.f2238d * this.f2243i), (this.f2238d * this.f2242h) - (this.f2239e * this.f2241g), (this.f2237c * this.f2242h) - (this.f2236b * this.f2243i), (this.f2235a * this.f2243i) - (this.f2237c * this.f2241g), (this.f2236b * this.f2241g) - (this.f2235a * this.f2242h), (this.f2236b * this.f2240f) - (this.f2237c * this.f2239e), (this.f2237c * this.f2238d) - (this.f2235a * this.f2240f), (this.f2235a * this.f2239e) - (this.f2236b * this.f2238d));
    }

    C1060k m3893a(C1060k c1060k) {
        return new C1060k(((this.f2235a * c1060k.f2235a) + (this.f2238d * c1060k.f2236b)) + (this.f2241g * c1060k.f2237c), ((this.f2235a * c1060k.f2238d) + (this.f2238d * c1060k.f2239e)) + (this.f2241g * c1060k.f2240f), ((this.f2235a * c1060k.f2241g) + (this.f2238d * c1060k.f2242h)) + (this.f2241g * c1060k.f2243i), ((this.f2236b * c1060k.f2235a) + (this.f2239e * c1060k.f2236b)) + (this.f2242h * c1060k.f2237c), ((this.f2236b * c1060k.f2238d) + (this.f2239e * c1060k.f2239e)) + (this.f2242h * c1060k.f2240f), ((this.f2236b * c1060k.f2241g) + (this.f2239e * c1060k.f2242h)) + (this.f2242h * c1060k.f2243i), ((this.f2237c * c1060k.f2235a) + (this.f2240f * c1060k.f2236b)) + (this.f2243i * c1060k.f2237c), ((this.f2237c * c1060k.f2238d) + (this.f2240f * c1060k.f2239e)) + (this.f2243i * c1060k.f2240f), ((this.f2237c * c1060k.f2241g) + (this.f2240f * c1060k.f2242h)) + (this.f2243i * c1060k.f2243i));
    }

    public void m3894a(float[] fArr) {
        int length = fArr.length;
        float f = this.f2235a;
        float f2 = this.f2236b;
        float f3 = this.f2237c;
        float f4 = this.f2238d;
        float f5 = this.f2239e;
        float f6 = this.f2240f;
        float f7 = this.f2241g;
        float f8 = this.f2242h;
        float f9 = this.f2243i;
        for (int i = 0; i < length; i += 2) {
            float f10 = fArr[i];
            float f11 = fArr[i + 1];
            float f12 = ((f3 * f10) + (f6 * f11)) + f9;
            fArr[i] = (((f * f10) + (f4 * f11)) + f7) / f12;
            fArr[i + 1] = (((f10 * f2) + (f11 * f5)) + f8) / f12;
        }
    }
}
