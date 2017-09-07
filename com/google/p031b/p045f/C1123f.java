package com.google.p031b.p045f;

import com.google.p031b.C1016a;
import com.google.p031b.C1198j;
import com.google.p031b.p034c.C1046a;

public final class C1123f extends C1122r {
    static final int[] f2399a = new int[]{0, 11, 13, 14, 19, 25, 28, 21, 22, 26};
    private final int[] f2400f = new int[4];

    private static void m4143a(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == f2399a[i2]) {
                stringBuilder.insert(0, (char) (i2 + 48));
                return;
            }
        }
        throw C1198j.m4509a();
    }

    protected int mo1429a(C1046a c1046a, int[] iArr, StringBuilder stringBuilder) {
        int i;
        int[] iArr2 = this.f2400f;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int a = c1046a.m3802a();
        int i2 = iArr[1];
        int i3 = 0;
        int i4 = 0;
        while (i3 < 6 && i2 < a) {
            int a2 = C1122r.m4132a(c1046a, iArr2, i2, e);
            stringBuilder.append((char) ((a2 % 10) + 48));
            i = i2;
            for (int i5 : iArr2) {
                i += i5;
            }
            if (a2 >= 10) {
                i4 |= 1 << (5 - i3);
            }
            i3++;
            i2 = i;
        }
        C1123f.m4143a(stringBuilder, i4);
        i4 = C1122r.m4135a(c1046a, i2, true, c)[1];
        i = 0;
        while (i < 6 && i4 < a) {
            stringBuilder.append((char) (C1122r.m4132a(c1046a, iArr2, i4, d) + 48));
            i2 = i4;
            for (int a22 : iArr2) {
                i2 += a22;
            }
            i++;
            i4 = i2;
        }
        return i4;
    }

    C1016a mo1430b() {
        return C1016a.EAN_13;
    }
}
