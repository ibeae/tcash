package com.google.p031b.p034c;

import com.google.p031b.C1198j;

public final class C1057f extends C1056i {
    public C1052b mo1418a(C1052b c1052b, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        return mo1419a(c1052b, i, i2, C1060k.m3890a(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16));
    }

    public C1052b mo1419a(C1052b c1052b, int i, int i2, C1060k c1060k) {
        if (i <= 0 || i2 <= 0) {
            throw C1198j.m4509a();
        }
        C1052b c1052b2 = new C1052b(i, i2);
        float[] fArr = new float[(i << 1)];
        for (int i3 = 0; i3 < i2; i3++) {
            int i4;
            int length = fArr.length;
            float f = ((float) i3) + 0.5f;
            for (i4 = 0; i4 < length; i4 += 2) {
                fArr[i4] = ((float) (i4 >> 1)) + 0.5f;
                fArr[i4 + 1] = f;
            }
            c1060k.m3894a(fArr);
            C1056i.m3873a(c1052b, fArr);
            i4 = 0;
            while (i4 < length) {
                try {
                    if (c1052b.m3848a((int) fArr[i4], (int) fArr[i4 + 1])) {
                        c1052b2.m3850b(i4 >> 1, i3);
                    }
                    i4 += 2;
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw C1198j.m4509a();
                }
            }
        }
        return c1052b2;
    }
}
