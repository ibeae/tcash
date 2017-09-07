package com.google.p031b.p053h.p055b;

import com.google.p031b.C1178o;
import com.google.p031b.C1198j;
import com.google.p031b.C1201p;
import com.google.p031b.p034c.C1052b;
import java.util.ArrayList;
import java.util.List;

final class C1180b {
    private final C1052b f2546a;
    private final List<C1179a> f2547b = new ArrayList(5);
    private final int f2548c;
    private final int f2549d;
    private final int f2550e;
    private final int f2551f;
    private final float f2552g;
    private final int[] f2553h;
    private final C1201p f2554i;

    C1180b(C1052b c1052b, int i, int i2, int i3, int i4, float f, C1201p c1201p) {
        this.f2546a = c1052b;
        this.f2548c = i;
        this.f2549d = i2;
        this.f2550e = i3;
        this.f2551f = i4;
        this.f2552g = f;
        this.f2553h = new int[3];
        this.f2554i = c1201p;
    }

    private float m4400a(int i, int i2, int i3, int i4) {
        C1052b c1052b = this.f2546a;
        int e = c1052b.m3856e();
        int[] iArr = this.f2553h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i5 = i;
        while (i5 >= 0 && c1052b.m3848a(i2, i5) && iArr[1] <= i3) {
            iArr[1] = iArr[1] + 1;
            i5--;
        }
        if (i5 < 0 || iArr[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && !c1052b.m3848a(i2, i5) && iArr[0] <= i3) {
            iArr[0] = iArr[0] + 1;
            i5--;
        }
        if (iArr[0] > i3) {
            return Float.NaN;
        }
        i5 = i + 1;
        while (i5 < e && c1052b.m3848a(i2, i5) && iArr[1] <= i3) {
            iArr[1] = iArr[1] + 1;
            i5++;
        }
        if (i5 == e || iArr[1] > i3) {
            return Float.NaN;
        }
        while (i5 < e && !c1052b.m3848a(i2, i5) && iArr[2] <= i3) {
            iArr[2] = iArr[2] + 1;
            i5++;
        }
        return (iArr[2] > i3 || Math.abs(((iArr[0] + iArr[1]) + iArr[2]) - i4) * 5 >= i4 * 2 || !m4403a(iArr)) ? Float.NaN : C1180b.m4401a(iArr, i5);
    }

    private static float m4401a(int[] iArr, int i) {
        return ((float) (i - iArr[2])) - (((float) iArr[1]) / 2.0f);
    }

    private C1179a m4402a(int[] iArr, int i, int i2) {
        int i3 = (iArr[0] + iArr[1]) + iArr[2];
        float a = C1180b.m4401a(iArr, i2);
        float a2 = m4400a(i, (int) a, iArr[1] * 2, i3);
        if (!Float.isNaN(a2)) {
            float f = ((float) ((iArr[0] + iArr[1]) + iArr[2])) / 3.0f;
            for (C1179a c1179a : this.f2547b) {
                if (c1179a.m4398a(f, a2, a)) {
                    return c1179a.m4399b(a2, a, f);
                }
            }
            C1178o c1179a2 = new C1179a(a, a2, f);
            this.f2547b.add(c1179a2);
            if (this.f2554i != null) {
                this.f2554i.mo1530a(c1179a2);
            }
        }
        return null;
    }

    private boolean m4403a(int[] iArr) {
        float f = this.f2552g;
        float f2 = f / 2.0f;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(f - ((float) iArr[i])) >= f2) {
                return false;
            }
        }
        return true;
    }

    C1179a m4404a() {
        int i = this.f2548c;
        int i2 = this.f2551f;
        int i3 = i + this.f2550e;
        int i4 = this.f2549d + (i2 >> 1);
        int[] iArr = new int[3];
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = i4 + ((i5 & 1) == 0 ? (i5 + 1) >> 1 : -((i5 + 1) >> 1));
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i7 = i;
            while (i7 < i3 && !this.f2546a.m3848a(i7, i6)) {
                i7++;
            }
            i7 = 0;
            for (int i8 = i7; i8 < i3; i8++) {
                C1179a a;
                if (!this.f2546a.m3848a(i8, i6)) {
                    if (i7 == 1) {
                        i7++;
                    }
                    iArr[i7] = iArr[i7] + 1;
                } else if (i7 == 1) {
                    iArr[i7] = iArr[i7] + 1;
                } else if (i7 == 2) {
                    if (m4403a(iArr)) {
                        a = m4402a(iArr, i6, i8);
                        if (a != null) {
                            return a;
                        }
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i7 = 1;
                } else {
                    i7++;
                    iArr[i7] = iArr[i7] + 1;
                }
            }
            if (m4403a(iArr)) {
                a = m4402a(iArr, i6, i3);
                if (a != null) {
                    return a;
                }
            }
        }
        if (!this.f2547b.isEmpty()) {
            return (C1179a) this.f2547b.get(0);
        }
        throw C1198j.m4509a();
    }
}
