package com.google.p031b;

import com.google.p031b.p034c.p038a.C1044a;

public class C1178o {
    private final float f2543a;
    private final float f2544b;

    public C1178o(float f, float f2) {
        this.f2543a = f;
        this.f2544b = f2;
    }

    public static float m4393a(C1178o c1178o, C1178o c1178o2) {
        return C1044a.m3793a(c1178o.f2543a, c1178o.f2544b, c1178o2.f2543a, c1178o2.f2544b);
    }

    private static float m4394a(C1178o c1178o, C1178o c1178o2, C1178o c1178o3) {
        float f = c1178o2.f2543a;
        float f2 = c1178o2.f2544b;
        return ((c1178o3.f2543a - f) * (c1178o.f2544b - f2)) - ((c1178o.f2543a - f) * (c1178o3.f2544b - f2));
    }

    public static void m4395a(C1178o[] c1178oArr) {
        C1178o c1178o;
        C1178o c1178o2;
        C1178o c1178o3;
        float a = C1178o.m4393a(c1178oArr[0], c1178oArr[1]);
        float a2 = C1178o.m4393a(c1178oArr[1], c1178oArr[2]);
        float a3 = C1178o.m4393a(c1178oArr[0], c1178oArr[2]);
        if (a2 >= a && a2 >= a3) {
            c1178o = c1178oArr[0];
            c1178o2 = c1178oArr[1];
            c1178o3 = c1178oArr[2];
        } else if (a3 < a2 || a3 < a) {
            c1178o = c1178oArr[2];
            c1178o2 = c1178oArr[0];
            c1178o3 = c1178oArr[1];
        } else {
            c1178o = c1178oArr[1];
            c1178o2 = c1178oArr[0];
            c1178o3 = c1178oArr[2];
        }
        if (C1178o.m4394a(c1178o2, c1178o, c1178o3) >= 0.0f) {
            C1178o c1178o4 = c1178o3;
            c1178o3 = c1178o2;
            c1178o2 = c1178o4;
        }
        c1178oArr[0] = c1178o3;
        c1178oArr[1] = c1178o;
        c1178oArr[2] = c1178o2;
    }

    public final float m4396a() {
        return this.f2543a;
    }

    public final float m4397b() {
        return this.f2544b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1178o)) {
            return false;
        }
        C1178o c1178o = (C1178o) obj;
        return this.f2543a == c1178o.f2543a && this.f2544b == c1178o.f2544b;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f2543a) * 31) + Float.floatToIntBits(this.f2544b);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(25);
        stringBuilder.append('(');
        stringBuilder.append(this.f2543a);
        stringBuilder.append(',');
        stringBuilder.append(this.f2544b);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
