package com.google.p031b.p045f;

import com.google.p031b.C1016a;
import com.google.p031b.p034c.C1046a;

public final class C1124g extends C1122r {
    private final int[] f2401a = new int[4];

    protected int mo1429a(C1046a c1046a, int[] iArr, StringBuilder stringBuilder) {
        int[] iArr2 = this.f2401a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int a = c1046a.m3802a();
        int i = iArr[1];
        int i2 = 0;
        while (i2 < 4 && i < a) {
            stringBuilder.append((char) (C1122r.m4132a(c1046a, iArr2, i, d) + 48));
            int i3 = i;
            for (int i4 : iArr2) {
                i3 += i4;
            }
            i2++;
            i = i3;
        }
        i = C1122r.m4135a(c1046a, i, true, c)[1];
        i2 = 0;
        while (i2 < 4 && i < a) {
            stringBuilder.append((char) (C1122r.m4132a(c1046a, iArr2, i, d) + 48));
            i3 = i;
            for (int i42 : iArr2) {
                i3 += i42;
            }
            i2++;
            i = i3;
        }
        return i;
    }

    C1016a mo1430b() {
        return C1016a.EAN_8;
    }
}
