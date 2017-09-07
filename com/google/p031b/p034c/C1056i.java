package com.google.p031b.p034c;

import com.google.p031b.C1198j;

public abstract class C1056i {
    private static C1056i f2230a = new C1057f();

    public static C1056i m3872a() {
        return f2230a;
    }

    protected static void m3873a(C1052b c1052b, float[] fArr) {
        int i;
        int d = c1052b.m3855d();
        int e = c1052b.m3856e();
        Object obj = 1;
        for (i = 0; i < fArr.length && r2 != null; i += 2) {
            int i2 = (int) fArr[i];
            int i3 = (int) fArr[i + 1];
            if (i2 < -1 || i2 > d || i3 < -1 || i3 > e) {
                throw C1198j.m4509a();
            }
            if (i2 == -1) {
                fArr[i] = 0.0f;
                obj = 1;
            } else if (i2 == d) {
                fArr[i] = (float) (d - 1);
                i2 = 1;
            } else {
                obj = null;
            }
            if (i3 == -1) {
                fArr[i + 1] = 0.0f;
                obj = 1;
            } else if (i3 == e) {
                fArr[i + 1] = (float) (e - 1);
                i2 = 1;
            }
        }
        Object obj2 = 1;
        for (i2 = fArr.length - 2; i2 >= 0 && r0 != null; i2 -= 2) {
            i = (int) fArr[i2];
            i3 = (int) fArr[i2 + 1];
            if (i < -1 || i > d || i3 < -1 || i3 > e) {
                throw C1198j.m4509a();
            }
            if (i == -1) {
                fArr[i2] = 0.0f;
                obj2 = 1;
            } else if (i == d) {
                fArr[i2] = (float) (d - 1);
                i = 1;
            } else {
                obj2 = null;
            }
            if (i3 == -1) {
                fArr[i2 + 1] = 0.0f;
                obj2 = 1;
            } else if (i3 == e) {
                fArr[i2 + 1] = (float) (e - 1);
                i = 1;
            }
        }
    }

    public abstract C1052b mo1418a(C1052b c1052b, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16);

    public abstract C1052b mo1419a(C1052b c1052b, int i, int i2, C1060k c1060k);
}
