package com.google.p031b.p053h.p055b;

import com.google.p031b.C1084e;
import com.google.p031b.C1178o;
import com.google.p031b.C1198j;
import com.google.p031b.C1201p;
import com.google.p031b.p034c.C1010g;
import com.google.p031b.p034c.C1052b;
import com.google.p031b.p034c.C1056i;
import com.google.p031b.p034c.C1060k;
import com.google.p031b.p034c.p038a.C1044a;
import com.google.p031b.p053h.p054a.C1176j;
import java.util.Map;

public class C1181c {
    private final C1052b f2555a;
    private C1201p f2556b;

    public C1181c(C1052b c1052b) {
        this.f2555a = c1052b;
    }

    private float m4405a(int i, int i2, int i3, int i4) {
        float f;
        int i5;
        int i6 = 0;
        float b = m4410b(i, i2, i3, i4);
        int i7 = i - (i3 - i);
        if (i7 < 0) {
            f = ((float) i) / ((float) (i - i7));
            i5 = 0;
        } else if (i7 >= this.f2555a.m3855d()) {
            f = ((float) ((this.f2555a.m3855d() - 1) - i)) / ((float) (i7 - i));
            i5 = this.f2555a.m3855d() - 1;
        } else {
            i5 = i7;
            f = 1.0f;
        }
        i7 = (int) (((float) i2) - (f * ((float) (i4 - i2))));
        if (i7 < 0) {
            f = ((float) i2) / ((float) (i2 - i7));
        } else if (i7 >= this.f2555a.m3856e()) {
            f = ((float) ((this.f2555a.m3856e() - 1) - i2)) / ((float) (i7 - i2));
            i6 = this.f2555a.m3856e() - 1;
        } else {
            i6 = i7;
            f = 1.0f;
        }
        return (m4410b(i, i2, (int) ((f * ((float) (i5 - i))) + ((float) i)), i6) + b) - 1.0f;
    }

    private float m4406a(C1178o c1178o, C1178o c1178o2) {
        float a = m4405a((int) c1178o.m4396a(), (int) c1178o.m4397b(), (int) c1178o2.m4396a(), (int) c1178o2.m4397b());
        float a2 = m4405a((int) c1178o2.m4396a(), (int) c1178o2.m4397b(), (int) c1178o.m4396a(), (int) c1178o.m4397b());
        return Float.isNaN(a) ? a2 / 7.0f : Float.isNaN(a2) ? a / 7.0f : (a + a2) / 14.0f;
    }

    private static int m4407a(C1178o c1178o, C1178o c1178o2, C1178o c1178o3, float f) {
        int a = ((C1044a.m3795a(C1178o.m4393a(c1178o, c1178o2) / f) + C1044a.m3795a(C1178o.m4393a(c1178o, c1178o3) / f)) >> 1) + 7;
        switch (a & 3) {
            case 0:
                return a + 1;
            case 2:
                return a - 1;
            case 3:
                throw C1198j.m4509a();
            default:
                return a;
        }
    }

    private static C1052b m4408a(C1052b c1052b, C1060k c1060k, int i) {
        return C1056i.m3872a().mo1419a(c1052b, i, i, c1060k);
    }

    private static C1060k m4409a(C1178o c1178o, C1178o c1178o2, C1178o c1178o3, C1178o c1178o4, int i) {
        float a;
        float b;
        float f;
        float f2;
        float f3 = ((float) i) - 3.5f;
        if (c1178o4 != null) {
            a = c1178o4.m4396a();
            b = c1178o4.m4397b();
            f = f3 - 3.0f;
            f2 = f;
        } else {
            a = (c1178o2.m4396a() - c1178o.m4396a()) + c1178o3.m4396a();
            b = (c1178o2.m4397b() - c1178o.m4397b()) + c1178o3.m4397b();
            f = f3;
            f2 = f3;
        }
        return C1060k.m3890a(3.5f, 3.5f, f3, 3.5f, f2, f, 3.5f, f3, c1178o.m4396a(), c1178o.m4397b(), c1178o2.m4396a(), c1178o2.m4397b(), a, b, c1178o3.m4396a(), c1178o3.m4397b());
    }

    private float m4410b(int i, int i2, int i3, int i4) {
        Object obj = Math.abs(i4 - i2) > Math.abs(i3 - i) ? 1 : null;
        if (obj == null) {
            int i5 = i4;
            i4 = i3;
            i3 = i5;
            int i6 = i2;
            i2 = i;
            i = i6;
        }
        int abs = Math.abs(i4 - i2);
        int abs2 = Math.abs(i3 - i);
        int i7 = (-abs) >> 1;
        int i8 = i2 < i4 ? 1 : -1;
        int i9 = i < i3 ? 1 : -1;
        int i10 = 0;
        int i11 = i4 + i8;
        int i12 = i2;
        int i13 = i7;
        i7 = i;
        while (i12 != i11) {
            int i14;
            int i15;
            if ((i10 == 1) != this.f2555a.m3848a(obj != null ? i7 : i12, obj != null ? i12 : i7)) {
                i14 = i10;
            } else if (i10 == 2) {
                return C1044a.m3794a(i12, i7, i2, i);
            } else {
                i14 = i10 + 1;
            }
            i10 = i13 + abs2;
            if (i10 <= 0) {
                i15 = i7;
                i7 = i10;
            } else if (i7 == i3) {
                i9 = i14;
                break;
            } else {
                i15 = i7 + i9;
                i7 = i10 - abs;
            }
            i12 += i8;
            i10 = i14;
            i13 = i7;
            i7 = i15;
        }
        i9 = i10;
        return i9 == 2 ? C1044a.m3794a(i4 + i8, i3, i2, i) : Float.NaN;
    }

    protected final float m4411a(C1178o c1178o, C1178o c1178o2, C1178o c1178o3) {
        return (m4406a(c1178o, c1178o2) + m4406a(c1178o, c1178o3)) / 2.0f;
    }

    protected final C1010g m4412a(C1187f c1187f) {
        C1178o b = c1187f.m4432b();
        C1178o c = c1187f.m4433c();
        C1178o a = c1187f.m4431a();
        float a2 = m4411a(b, c, a);
        if (a2 < 1.0f) {
            throw C1198j.m4509a();
        }
        C1178o[] c1178oArr;
        int a3 = C1181c.m4407a(b, c, a, a2);
        C1176j a4 = C1176j.m4379a(a3);
        int d = a4.m4387d() - 7;
        C1178o c1178o = null;
        if (a4.m4385b().length > 0) {
            float a5 = (c.m4396a() - b.m4396a()) + a.m4396a();
            float b2 = (c.m4397b() - b.m4397b()) + a.m4397b();
            float f = 1.0f - (3.0f / ((float) d));
            int a6 = (int) (((a5 - b.m4396a()) * f) + b.m4396a());
            d = (int) (b.m4397b() + (f * (b2 - b.m4397b())));
            int i = 4;
            while (i <= 16) {
                try {
                    c1178o = m4414a(a2, a6, d, (float) i);
                    break;
                } catch (C1198j e) {
                    i <<= 1;
                }
            }
        }
        C1052b a7 = C1181c.m4408a(this.f2555a, C1181c.m4409a(b, c, a, c1178o, a3), a3);
        if (c1178o == null) {
            c1178oArr = new C1178o[]{a, b, c};
        } else {
            c1178oArr = new C1178o[]{a, b, c, c1178o};
        }
        return new C1010g(a7, c1178oArr);
    }

    public final C1010g m4413a(Map<C1084e, ?> map) {
        this.f2556b = map == null ? null : (C1201p) map.get(C1084e.NEED_RESULT_POINT_CALLBACK);
        return m4412a(new C1186e(this.f2555a, this.f2556b).m4429a((Map) map));
    }

    protected final C1179a m4414a(float f, int i, int i2, float f2) {
        int i3 = (int) (f2 * f);
        int max = Math.max(0, i - i3);
        int min = Math.min(this.f2555a.m3855d() - 1, i + i3);
        if (((float) (min - max)) < f * 3.0f) {
            throw C1198j.m4509a();
        }
        int max2 = Math.max(0, i2 - i3);
        int min2 = Math.min(this.f2555a.m3856e() - 1, i3 + i2);
        if (((float) (min2 - max2)) < f * 3.0f) {
            throw C1198j.m4509a();
        }
        return new C1180b(this.f2555a, max, max2, min - max, min2 - max2, f, this.f2556b).m4404a();
    }
}
