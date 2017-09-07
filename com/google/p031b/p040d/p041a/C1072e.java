package com.google.p031b.p040d.p041a;

import com.google.p031b.C1155g;

public final class C1072e {
    private static final C1072e[] f2271a = C1072e.m3931h();
    private final int f2272b;
    private final int f2273c;
    private final int f2274d;
    private final int f2275e;
    private final int f2276f;
    private final C1071b f2277g;
    private final int f2278h;

    static final class C1070a {
        private final int f2267a;
        private final int f2268b;

        private C1070a(int i, int i2) {
            this.f2267a = i;
            this.f2268b = i2;
        }

        int m3926a() {
            return this.f2267a;
        }

        int m3927b() {
            return this.f2268b;
        }
    }

    static final class C1071b {
        private final int f2269a;
        private final C1070a[] f2270b;

        private C1071b(int i, C1070a c1070a) {
            this.f2269a = i;
            this.f2270b = new C1070a[]{c1070a};
        }

        private C1071b(int i, C1070a c1070a, C1070a c1070a2) {
            this.f2269a = i;
            this.f2270b = new C1070a[]{c1070a, c1070a2};
        }

        int m3928a() {
            return this.f2269a;
        }

        C1070a[] m3929b() {
            return this.f2270b;
        }
    }

    private C1072e(int i, int i2, int i3, int i4, int i5, C1071b c1071b) {
        int i6 = 0;
        this.f2272b = i;
        this.f2273c = i2;
        this.f2274d = i3;
        this.f2275e = i4;
        this.f2276f = i5;
        this.f2277g = c1071b;
        int a = c1071b.m3928a();
        C1070a[] b = c1071b.m3929b();
        int length = b.length;
        int i7 = 0;
        while (i6 < length) {
            C1070a c1070a = b[i6];
            i7 += (c1070a.m3927b() + a) * c1070a.m3926a();
            i6++;
        }
        this.f2278h = i7;
    }

    public static C1072e m3930a(int i, int i2) {
        if ((i & 1) == 0 && (i2 & 1) == 0) {
            for (C1072e c1072e : f2271a) {
                if (c1072e.f2273c == i && c1072e.f2274d == i2) {
                    return c1072e;
                }
            }
            throw C1155g.m4329a();
        }
        throw C1155g.m4329a();
    }

    private static C1072e[] m3931h() {
        return new C1072e[]{new C1072e(1, 10, 10, 8, 8, new C1071b(5, new C1070a(1, 3))), new C1072e(2, 12, 12, 10, 10, new C1071b(7, new C1070a(1, 5))), new C1072e(3, 14, 14, 12, 12, new C1071b(10, new C1070a(1, 8))), new C1072e(4, 16, 16, 14, 14, new C1071b(12, new C1070a(1, 12))), new C1072e(5, 18, 18, 16, 16, new C1071b(14, new C1070a(1, 18))), new C1072e(6, 20, 20, 18, 18, new C1071b(18, new C1070a(1, 22))), new C1072e(7, 22, 22, 20, 20, new C1071b(20, new C1070a(1, 30))), new C1072e(8, 24, 24, 22, 22, new C1071b(24, new C1070a(1, 36))), new C1072e(9, 26, 26, 24, 24, new C1071b(28, new C1070a(1, 44))), new C1072e(10, 32, 32, 14, 14, new C1071b(36, new C1070a(1, 62))), new C1072e(11, 36, 36, 16, 16, new C1071b(42, new C1070a(1, 86))), new C1072e(12, 40, 40, 18, 18, new C1071b(48, new C1070a(1, 114))), new C1072e(13, 44, 44, 20, 20, new C1071b(56, new C1070a(1, 144))), new C1072e(14, 48, 48, 22, 22, new C1071b(68, new C1070a(1, 174))), new C1072e(15, 52, 52, 24, 24, new C1071b(42, new C1070a(2, 102))), new C1072e(16, 64, 64, 14, 14, new C1071b(56, new C1070a(2, 140))), new C1072e(17, 72, 72, 16, 16, new C1071b(36, new C1070a(4, 92))), new C1072e(18, 80, 80, 18, 18, new C1071b(48, new C1070a(4, 114))), new C1072e(19, 88, 88, 20, 20, new C1071b(56, new C1070a(4, 144))), new C1072e(20, 96, 96, 22, 22, new C1071b(68, new C1070a(4, 174))), new C1072e(21, 104, 104, 24, 24, new C1071b(56, new C1070a(6, 136))), new C1072e(22, 120, 120, 18, 18, new C1071b(68, new C1070a(6, 175))), new C1072e(23, 132, 132, 20, 20, new C1071b(62, new C1070a(8, 163))), new C1072e(24, 144, 144, 22, 22, new C1071b(62, new C1070a(8, 156), new C1070a(2, 155))), new C1072e(25, 8, 18, 6, 16, new C1071b(7, new C1070a(1, 5))), new C1072e(26, 8, 32, 6, 14, new C1071b(11, new C1070a(1, 10))), new C1072e(27, 12, 26, 10, 24, new C1071b(14, new C1070a(1, 16))), new C1072e(28, 12, 36, 10, 16, new C1071b(18, new C1070a(1, 22))), new C1072e(29, 16, 36, 14, 16, new C1071b(24, new C1070a(1, 32))), new C1072e(30, 16, 48, 14, 22, new C1071b(28, new C1070a(1, 49)))};
    }

    public int m3932a() {
        return this.f2272b;
    }

    public int m3933b() {
        return this.f2273c;
    }

    public int m3934c() {
        return this.f2274d;
    }

    public int m3935d() {
        return this.f2275e;
    }

    public int m3936e() {
        return this.f2276f;
    }

    public int m3937f() {
        return this.f2278h;
    }

    C1071b m3938g() {
        return this.f2277g;
    }

    public String toString() {
        return String.valueOf(this.f2272b);
    }
}
