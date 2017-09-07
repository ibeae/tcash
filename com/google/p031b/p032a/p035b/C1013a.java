package com.google.p031b.p032a.p035b;

import com.google.p031b.C1178o;
import com.google.p031b.C1198j;
import com.google.p031b.p032a.C1011a;
import com.google.p031b.p034c.C1052b;
import com.google.p031b.p034c.C1056i;
import com.google.p031b.p034c.p038a.C1044a;
import com.google.p031b.p034c.p038a.C1045b;
import com.google.p031b.p034c.p039b.C1047a;
import com.google.p031b.p034c.p039b.C1049c;
import com.google.p031b.p034c.p039b.C1051e;

public final class C1013a {
    private static final int[] f2022g = new int[]{3808, 476, 2107, 1799};
    private final C1052b f2023a;
    private boolean f2024b;
    private int f2025c;
    private int f2026d;
    private int f2027e;
    private int f2028f;

    static final class C1012a {
        private final int f2020a;
        private final int f2021b;

        C1012a(int i, int i2) {
            this.f2020a = i;
            this.f2021b = i2;
        }

        C1178o m3665a() {
            return new C1178o((float) m3666b(), (float) m3667c());
        }

        int m3666b() {
            return this.f2020a;
        }

        int m3667c() {
            return this.f2021b;
        }

        public String toString() {
            return "<" + this.f2020a + ' ' + this.f2021b + '>';
        }
    }

    public C1013a(C1052b c1052b) {
        this.f2023a = c1052b;
    }

    private static float m3668a(C1178o c1178o, C1178o c1178o2) {
        return C1044a.m3793a(c1178o.m4396a(), c1178o.m4397b(), c1178o2.m4396a(), c1178o2.m4397b());
    }

    private static int m3669a(long j, boolean z) {
        int i;
        int i2;
        int i3 = 0;
        if (z) {
            i = 7;
            i2 = 2;
        } else {
            i = 10;
            i2 = 4;
        }
        int i4 = i - i2;
        int[] iArr = new int[i];
        for (i--; i >= 0; i--) {
            iArr[i] = ((int) j) & 15;
            j >>= 4;
        }
        try {
            new C1049c(C1047a.f2166d).m3843a(iArr, i4);
            for (int i5 = 0; i5 < i2; i5++) {
                i3 = iArr[i5] + (i3 << 4);
            }
            return i3;
        } catch (C1051e e) {
            throw C1198j.m4509a();
        }
    }

    private int m3670a(C1012a c1012a, C1012a c1012a2) {
        float b = C1013a.m3682b(c1012a, c1012a2);
        float b2 = ((float) (c1012a2.m3666b() - c1012a.m3666b())) / b;
        float c = ((float) (c1012a2.m3667c() - c1012a.m3667c())) / b;
        float b3 = (float) c1012a.m3666b();
        float c2 = (float) c1012a.m3667c();
        boolean a = this.f2023a.m3848a(c1012a.m3666b(), c1012a.m3667c());
        int i = 0;
        float f = b3;
        b3 = c2;
        for (int i2 = 0; ((float) i2) < b; i2++) {
            f += b2;
            b3 += c;
            if (this.f2023a.m3848a(C1044a.m3795a(f), C1044a.m3795a(b3)) != a) {
                i++;
            }
        }
        float f2 = ((float) i) / b;
        if (f2 > 0.1f && f2 < 0.9f) {
            return 0;
        }
        return ((f2 > 0.1f ? 1 : (f2 == 0.1f ? 0 : -1)) <= 0) == a ? 1 : -1;
    }

    private int m3671a(C1178o c1178o, C1178o c1178o2, int i) {
        int i2 = 0;
        float a = C1013a.m3668a(c1178o, c1178o2);
        float f = a / ((float) i);
        float a2 = c1178o.m4396a();
        float b = c1178o.m4397b();
        float a3 = ((c1178o2.m4396a() - c1178o.m4396a()) * f) / a;
        f = (f * (c1178o2.m4397b() - c1178o.m4397b())) / a;
        for (int i3 = 0; i3 < i; i3++) {
            if (this.f2023a.m3848a(C1044a.m3795a((((float) i3) * a3) + a2), C1044a.m3795a((((float) i3) * f) + b))) {
                i2 |= 1 << ((i - i3) - 1);
            }
        }
        return i2;
    }

    private static int m3672a(int[] iArr, int i) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += (i4 & 1) + ((i4 >> (i - 2)) << 1);
        }
        int i5 = ((i3 & 1) << 11) + (i3 >> 1);
        while (i2 < 4) {
            if (Integer.bitCount(f2022g[i2] ^ i5) <= 2) {
                return i2;
            }
            i2++;
        }
        throw C1198j.m4509a();
    }

    private C1012a m3673a() {
        C1178o c1178o;
        C1178o c1178o2;
        C1178o c1178o3;
        C1178o c1178o4;
        int d;
        int e;
        try {
            C1178o[] a = new C1045b(this.f2023a).m3799a();
            c1178o = a[0];
            c1178o2 = a[1];
            c1178o3 = a[2];
            c1178o4 = a[3];
        } catch (C1198j e2) {
            d = this.f2023a.m3855d() / 2;
            e = this.f2023a.m3856e() / 2;
            c1178o = m3674a(new C1012a(d + 7, e - 7), false, 1, -1).m3665a();
            c1178o2 = m3674a(new C1012a(d + 7, e + 7), false, 1, 1).m3665a();
            c1178o3 = m3674a(new C1012a(d - 7, e + 7), false, -1, 1).m3665a();
            c1178o4 = m3674a(new C1012a(d - 7, e - 7), false, -1, -1).m3665a();
        }
        e = C1044a.m3795a((((c1178o.m4396a() + c1178o4.m4396a()) + c1178o2.m4396a()) + c1178o3.m4396a()) / 4.0f);
        d = C1044a.m3795a((((c1178o4.m4397b() + c1178o.m4397b()) + c1178o2.m4397b()) + c1178o3.m4397b()) / 4.0f);
        try {
            C1178o[] a2 = new C1045b(this.f2023a, 15, e, d).m3799a();
            c1178o = a2[0];
            c1178o2 = a2[1];
            c1178o3 = a2[2];
            c1178o4 = a2[3];
        } catch (C1198j e3) {
            c1178o = m3674a(new C1012a(e + 7, d - 7), false, 1, -1).m3665a();
            c1178o2 = m3674a(new C1012a(e + 7, d + 7), false, 1, 1).m3665a();
            c1178o3 = m3674a(new C1012a(e - 7, d + 7), false, -1, 1).m3665a();
            c1178o4 = m3674a(new C1012a(e - 7, d - 7), false, -1, -1).m3665a();
        }
        return new C1012a(C1044a.m3795a((((c1178o.m4396a() + c1178o4.m4396a()) + c1178o2.m4396a()) + c1178o3.m4396a()) / 4.0f), C1044a.m3795a((((c1178o4.m4397b() + c1178o.m4397b()) + c1178o2.m4397b()) + c1178o3.m4397b()) / 4.0f));
    }

    private C1012a m3674a(C1012a c1012a, boolean z, int i, int i2) {
        int b = c1012a.m3666b() + i;
        int c = c1012a.m3667c() + i2;
        while (m3677a(b, c) && this.f2023a.m3848a(b, c) == z) {
            b += i;
            c += i2;
        }
        int i3 = c - i2;
        c = b - i;
        while (m3677a(c, i3) && this.f2023a.m3848a(c, i3) == z) {
            c += i;
        }
        b = c - i;
        c = i3;
        while (m3677a(b, c) && this.f2023a.m3848a(b, c) == z) {
            c += i2;
        }
        return new C1012a(b, c - i2);
    }

    private C1052b m3675a(C1052b c1052b, C1178o c1178o, C1178o c1178o2, C1178o c1178o3, C1178o c1178o4) {
        C1056i a = C1056i.m3872a();
        int b = m3683b();
        float f = (((float) b) / 2.0f) - ((float) this.f2027e);
        float f2 = (((float) b) / 2.0f) + ((float) this.f2027e);
        return a.mo1418a(c1052b, b, b, f, f, f2, f, f2, f2, f, f2, c1178o.m4396a(), c1178o.m4397b(), c1178o2.m4396a(), c1178o2.m4397b(), c1178o3.m4396a(), c1178o3.m4397b(), c1178o4.m4396a(), c1178o4.m4397b());
    }

    private void m3676a(C1178o[] c1178oArr) {
        if (m3679a(c1178oArr[0]) && m3679a(c1178oArr[1]) && m3679a(c1178oArr[2]) && m3679a(c1178oArr[3])) {
            int[] iArr = new int[]{m3671a(c1178oArr[0], c1178oArr[1], r1), m3671a(c1178oArr[1], c1178oArr[2], r1), m3671a(c1178oArr[2], c1178oArr[3], r1), m3671a(c1178oArr[3], c1178oArr[0], this.f2027e * 2)};
            this.f2028f = C1013a.m3672a(iArr, this.f2027e * 2);
            long j = 0;
            for (int i = 0; i < 4; i++) {
                int i2 = iArr[(this.f2028f + i) % 4];
                if (this.f2024b) {
                    j = (j << 7) + ((long) ((i2 >> 1) & 127));
                } else {
                    j = (j << 10) + ((long) (((i2 >> 1) & 31) + ((i2 >> 2) & 992)));
                }
            }
            int a = C1013a.m3669a(j, this.f2024b);
            if (this.f2024b) {
                this.f2025c = (a >> 6) + 1;
                this.f2026d = (a & 63) + 1;
                return;
            }
            this.f2025c = (a >> 11) + 1;
            this.f2026d = (a & 2047) + 1;
            return;
        }
        throw C1198j.m4509a();
    }

    private boolean m3677a(int i, int i2) {
        return i >= 0 && i < this.f2023a.m3855d() && i2 > 0 && i2 < this.f2023a.m3856e();
    }

    private boolean m3678a(C1012a c1012a, C1012a c1012a2, C1012a c1012a3, C1012a c1012a4) {
        C1012a c1012a5 = new C1012a(c1012a.m3666b() - 3, c1012a.m3667c() + 3);
        C1012a c1012a6 = new C1012a(c1012a2.m3666b() - 3, c1012a2.m3667c() - 3);
        C1012a c1012a7 = new C1012a(c1012a3.m3666b() + 3, c1012a3.m3667c() - 3);
        C1012a c1012a8 = new C1012a(c1012a4.m3666b() + 3, 3 + c1012a4.m3667c());
        int a = m3670a(c1012a8, c1012a5);
        return a != 0 && m3670a(c1012a5, c1012a6) == a && m3670a(c1012a6, c1012a7) == a && m3670a(c1012a7, c1012a8) == a;
    }

    private boolean m3679a(C1178o c1178o) {
        return m3677a(C1044a.m3795a(c1178o.m4396a()), C1044a.m3795a(c1178o.m4397b()));
    }

    private C1178o[] m3680a(C1012a c1012a) {
        boolean z = true;
        this.f2027e = 1;
        C1012a c1012a2 = c1012a;
        C1012a c1012a3 = c1012a;
        C1012a c1012a4 = c1012a;
        while (this.f2027e < 9) {
            C1012a a = m3674a(c1012a4, z, 1, -1);
            C1012a a2 = m3674a(c1012a3, z, 1, 1);
            C1012a a3 = m3674a(c1012a2, z, -1, 1);
            C1012a a4 = m3674a(c1012a, z, -1, -1);
            if (this.f2027e > 2) {
                float b = (C1013a.m3682b(a4, a) * ((float) this.f2027e)) / (C1013a.m3682b(c1012a, c1012a4) * ((float) (this.f2027e + 2)));
                if (((double) b) >= 0.75d) {
                    if (((double) b) <= 1.25d) {
                        if (!m3678a(a, a2, a3, a4)) {
                            break;
                        }
                    }
                    break;
                }
                break;
            }
            z = !z;
            this.f2027e++;
            c1012a = a4;
            c1012a2 = a3;
            c1012a3 = a2;
            c1012a4 = a;
        }
        if (this.f2027e == 5 || this.f2027e == 7) {
            this.f2024b = this.f2027e == 5;
            C1178o c1178o = new C1178o(((float) c1012a4.m3666b()) + 0.5f, ((float) c1012a4.m3667c()) - 0.5f);
            C1178o c1178o2 = new C1178o(((float) c1012a3.m3666b()) + 0.5f, ((float) c1012a3.m3667c()) + 0.5f);
            C1178o c1178o3 = new C1178o(((float) c1012a2.m3666b()) - 0.5f, ((float) c1012a2.m3667c()) + 0.5f);
            C1178o c1178o4 = new C1178o(((float) c1012a.m3666b()) - 0.5f, ((float) c1012a.m3667c()) - 0.5f);
            return C1013a.m3681a(new C1178o[]{c1178o, c1178o2, c1178o3, c1178o4}, (float) ((this.f2027e * 2) - 3), (float) (this.f2027e * 2));
        }
        throw C1198j.m4509a();
    }

    private static C1178o[] m3681a(C1178o[] c1178oArr, float f, float f2) {
        float f3 = f2 / (2.0f * f);
        float a = c1178oArr[0].m4396a() - c1178oArr[2].m4396a();
        float b = c1178oArr[0].m4397b() - c1178oArr[2].m4397b();
        float a2 = (c1178oArr[0].m4396a() + c1178oArr[2].m4396a()) / 2.0f;
        float b2 = (c1178oArr[0].m4397b() + c1178oArr[2].m4397b()) / 2.0f;
        C1178o c1178o = new C1178o((f3 * a) + a2, (f3 * b) + b2);
        C1178o c1178o2 = new C1178o(a2 - (a * f3), b2 - (b * f3));
        a = c1178oArr[1].m4396a() - c1178oArr[3].m4396a();
        b = c1178oArr[1].m4397b() - c1178oArr[3].m4397b();
        a2 = (c1178oArr[1].m4396a() + c1178oArr[3].m4396a()) / 2.0f;
        b2 = (c1178oArr[1].m4397b() + c1178oArr[3].m4397b()) / 2.0f;
        C1178o c1178o3 = new C1178o((f3 * a) + a2, (f3 * b) + b2);
        C1178o c1178o4 = new C1178o(a2 - (a * f3), b2 - (f3 * b));
        return new C1178o[]{c1178o, c1178o3, c1178o2, c1178o4};
    }

    private static float m3682b(C1012a c1012a, C1012a c1012a2) {
        return C1044a.m3794a(c1012a.m3666b(), c1012a.m3667c(), c1012a2.m3666b(), c1012a2.m3667c());
    }

    private int m3683b() {
        return this.f2024b ? (this.f2025c * 4) + 11 : this.f2025c <= 4 ? (this.f2025c * 4) + 15 : ((this.f2025c * 4) + ((((this.f2025c - 4) / 8) + 1) * 2)) + 15;
    }

    private C1178o[] m3684b(C1178o[] c1178oArr) {
        return C1013a.m3681a(c1178oArr, (float) (this.f2027e * 2), (float) m3683b());
    }

    public C1011a m3685a(boolean z) {
        C1178o[] a = m3680a(m3673a());
        if (z) {
            C1178o c1178o = a[0];
            a[0] = a[2];
            a[2] = c1178o;
        }
        m3676a(a);
        return new C1011a(m3675a(this.f2023a, a[this.f2028f % 4], a[(this.f2028f + 1) % 4], a[(this.f2028f + 2) % 4], a[(this.f2028f + 3) % 4]), m3684b(a), this.f2024b, this.f2026d, this.f2025c);
    }
}
