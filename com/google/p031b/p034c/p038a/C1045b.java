package com.google.p031b.p034c.p038a;

import com.google.p031b.C1178o;
import com.google.p031b.C1198j;
import com.google.p031b.p034c.C1052b;

public final class C1045b {
    private final C1052b f2154a;
    private final int f2155b;
    private final int f2156c;
    private final int f2157d;
    private final int f2158e;
    private final int f2159f;
    private final int f2160g;

    public C1045b(C1052b c1052b) {
        this.f2154a = c1052b;
        this.f2155b = c1052b.m3856e();
        this.f2156c = c1052b.m3855d();
        this.f2157d = (this.f2156c - 30) >> 1;
        this.f2158e = (this.f2156c + 30) >> 1;
        this.f2160g = (this.f2155b - 30) >> 1;
        this.f2159f = (this.f2155b + 30) >> 1;
        if (this.f2160g < 0 || this.f2157d < 0 || this.f2159f >= this.f2155b || this.f2158e >= this.f2156c) {
            throw C1198j.m4509a();
        }
    }

    public C1045b(C1052b c1052b, int i, int i2, int i3) {
        this.f2154a = c1052b;
        this.f2155b = c1052b.m3856e();
        this.f2156c = c1052b.m3855d();
        int i4 = i >> 1;
        this.f2157d = i2 - i4;
        this.f2158e = i2 + i4;
        this.f2160g = i3 - i4;
        this.f2159f = i4 + i3;
        if (this.f2160g < 0 || this.f2157d < 0 || this.f2159f >= this.f2155b || this.f2158e >= this.f2156c) {
            throw C1198j.m4509a();
        }
    }

    private C1178o m3796a(float f, float f2, float f3, float f4) {
        int a = C1044a.m3795a(C1044a.m3793a(f, f2, f3, f4));
        float f5 = (f3 - f) / ((float) a);
        float f6 = (f4 - f2) / ((float) a);
        for (int i = 0; i < a; i++) {
            int a2 = C1044a.m3795a((((float) i) * f5) + f);
            int a3 = C1044a.m3795a((((float) i) * f6) + f2);
            if (this.f2154a.m3848a(a2, a3)) {
                return new C1178o((float) a2, (float) a3);
            }
        }
        return null;
    }

    private boolean m3797a(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.f2154a.m3848a(i, i3)) {
                    return true;
                }
                i++;
            }
        } else {
            while (i <= i2) {
                if (this.f2154a.m3848a(i3, i)) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    private C1178o[] m3798a(C1178o c1178o, C1178o c1178o2, C1178o c1178o3, C1178o c1178o4) {
        float a = c1178o.m4396a();
        float b = c1178o.m4397b();
        float a2 = c1178o2.m4396a();
        float b2 = c1178o2.m4397b();
        float a3 = c1178o3.m4396a();
        float b3 = c1178o3.m4397b();
        float a4 = c1178o4.m4396a();
        float b4 = c1178o4.m4397b();
        if (a < ((float) this.f2156c) / 2.0f) {
            return new C1178o[]{new C1178o(a4 - 1.0f, b4 + 1.0f), new C1178o(a2 + 1.0f, b2 + 1.0f), new C1178o(a3 - 1.0f, b3 - 1.0f), new C1178o(a + 1.0f, b - 1.0f)};
        }
        return new C1178o[]{new C1178o(a4 + 1.0f, b4 + 1.0f), new C1178o(a2 + 1.0f, b2 - 1.0f), new C1178o(a3 - 1.0f, b3 + 1.0f), new C1178o(a - 1.0f, b - 1.0f)};
    }

    public C1178o[] m3799a() {
        int i;
        boolean z = false;
        int i2 = 1;
        int i3 = this.f2157d;
        int i4 = this.f2158e;
        int i5 = this.f2160g;
        int i6 = this.f2159f;
        boolean z2 = false;
        int i7 = 1;
        while (i7 != 0) {
            boolean z3 = true;
            boolean z4 = false;
            while (z3 && i4 < this.f2156c) {
                z3 = m3797a(i5, i6, i4, false);
                if (z3) {
                    i4++;
                    z4 = true;
                }
            }
            if (i4 >= this.f2156c) {
                z = true;
                i = i4;
                i4 = i6;
                i6 = i3;
                i3 = i5;
                break;
            }
            z3 = true;
            while (z3 && i6 < this.f2155b) {
                z3 = m3797a(i3, i4, i6, true);
                if (z3) {
                    i6++;
                    z4 = true;
                }
            }
            if (i6 >= this.f2155b) {
                z = true;
                i = i4;
                i4 = i6;
                i6 = i3;
                i3 = i5;
                break;
            }
            z3 = true;
            while (z3 && i3 >= 0) {
                z3 = m3797a(i5, i6, i3, false);
                if (z3) {
                    i3--;
                    z4 = true;
                }
            }
            if (i3 < 0) {
                z = true;
                i = i4;
                i4 = i6;
                i6 = i3;
                i3 = i5;
                break;
            }
            i7 = z4;
            z4 = true;
            while (z4 && i5 >= 0) {
                z4 = m3797a(i3, i4, i5, true);
                if (z4) {
                    i5--;
                    i7 = 1;
                }
            }
            if (i5 < 0) {
                z = true;
                i = i4;
                i4 = i6;
                i6 = i3;
                i3 = i5;
                break;
            } else if (i7 != 0) {
                z2 = true;
            }
        }
        i = i4;
        i4 = i6;
        i6 = i3;
        i3 = i5;
        if (z || !r0) {
            throw C1198j.m4509a();
        }
        int i8;
        C1178o c1178o;
        i7 = i - i6;
        C1178o c1178o2 = null;
        for (i8 = 1; i8 < i7; i8++) {
            c1178o2 = m3796a((float) i6, (float) (i4 - i8), (float) (i6 + i8), (float) i4);
            if (c1178o2 != null) {
                c1178o = c1178o2;
                break;
            }
        }
        c1178o = c1178o2;
        if (c1178o == null) {
            throw C1198j.m4509a();
        }
        C1178o c1178o3;
        c1178o2 = null;
        for (i8 = 1; i8 < i7; i8++) {
            c1178o2 = m3796a((float) i6, (float) (i3 + i8), (float) (i6 + i8), (float) i3);
            if (c1178o2 != null) {
                c1178o3 = c1178o2;
                break;
            }
        }
        c1178o3 = c1178o2;
        if (c1178o3 == null) {
            throw C1198j.m4509a();
        }
        C1178o c1178o4;
        c1178o2 = null;
        for (i8 = 1; i8 < i7; i8++) {
            c1178o2 = m3796a((float) i, (float) (i3 + i8), (float) (i - i8), (float) i3);
            if (c1178o2 != null) {
                c1178o4 = c1178o2;
                break;
            }
        }
        c1178o4 = c1178o2;
        if (c1178o4 == null) {
            throw C1198j.m4509a();
        }
        c1178o2 = null;
        while (i2 < i7) {
            c1178o2 = m3796a((float) i, (float) (i4 - i2), (float) (i - i2), (float) i4);
            if (c1178o2 != null) {
                break;
            }
            i2++;
        }
        if (c1178o2 != null) {
            return m3798a(c1178o2, c1178o, c1178o4, c1178o3);
        }
        throw C1198j.m4509a();
    }
}
