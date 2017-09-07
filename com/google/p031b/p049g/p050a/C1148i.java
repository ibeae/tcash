package com.google.p031b.p049g.p050a;

import com.google.p031b.p049g.C1150a;
import java.lang.reflect.Array;

final class C1148i {
    private static final float[][] f2481a = ((float[][]) Array.newInstance(Float.TYPE, new int[]{C1150a.f2483a.length, 8}));

    static {
        for (int i = 0; i < C1150a.f2483a.length; i++) {
            int i2 = C1150a.f2483a[i];
            int i3 = i2 & 1;
            for (int i4 = 0; i4 < 8; i4++) {
                float f = 0.0f;
                while ((i2 & 1) == i3) {
                    f += 1.0f;
                    i2 >>= 1;
                }
                i3 = i2 & 1;
                f2481a[i][(8 - i4) - 1] = f / 17.0f;
            }
        }
    }

    static int m4275a(int[] iArr) {
        int c = C1148i.m4277c(C1148i.m4276b(iArr));
        return c != -1 ? c : C1148i.m4279e(iArr);
    }

    private static int[] m4276b(int[] iArr) {
        int i = 0;
        float a = (float) C1150a.m4304a(iArr);
        int[] iArr2 = new int[8];
        int i2 = 0;
        for (int i3 = 0; i3 < 17; i3++) {
            if (((float) (iArr[i2] + i)) <= (a / 34.0f) + ((((float) i3) * a) / 17.0f)) {
                i += iArr[i2];
                i2++;
            }
            iArr2[i2] = iArr2[i2] + 1;
        }
        return iArr2;
    }

    private static int m4277c(int[] iArr) {
        int d = C1148i.m4278d(iArr);
        return C1150a.m4303a((long) d) == -1 ? -1 : d;
    }

    private static int m4278d(int[] iArr) {
        long j = 0;
        for (int i = 0; i < iArr.length; i++) {
            int i2 = 0;
            while (i2 < iArr[i]) {
                i2++;
                j = (j << 1) | ((long) (i % 2 == 0 ? 1 : 0));
            }
        }
        return (int) j;
    }

    private static int m4279e(int[] iArr) {
        int i;
        int a = C1150a.m4304a(iArr);
        float[] fArr = new float[8];
        for (i = 0; i < fArr.length; i++) {
            fArr[i] = ((float) iArr[i]) / ((float) a);
        }
        float f = Float.MAX_VALUE;
        a = -1;
        for (i = 0; i < f2481a.length; i++) {
            float f2 = 0.0f;
            float[] fArr2 = f2481a[i];
            for (int i2 = 0; i2 < 8; i2++) {
                float f3 = fArr2[i2] - fArr[i2];
                f2 += f3 * f3;
                if (f2 >= f) {
                    break;
                }
            }
            if (f2 < f) {
                a = C1150a.f2483a[i];
                f = f2;
            }
        }
        return a;
    }
}
