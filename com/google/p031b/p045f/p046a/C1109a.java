package com.google.p031b.p045f.p046a;

import com.google.p031b.C1198j;
import com.google.p031b.p045f.C1108l;

public abstract class C1109a extends C1108l {
    private final int[] f2341a = new int[4];
    private final int[] f2342b = new int[8];
    private final float[] f2343c = new float[4];
    private final float[] f2344d = new float[4];
    private final int[] f2345e = new int[(this.f2342b.length / 2)];
    private final int[] f2346f = new int[(this.f2342b.length / 2)];

    protected C1109a() {
    }

    protected static int m4051a(int[] iArr) {
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            i2 += iArr[i];
            i++;
        }
        return i2;
    }

    protected static int m4052a(int[] iArr, int[][] iArr2) {
        for (int i = 0; i < iArr2.length; i++) {
            if (C1108l.m4044a(iArr, iArr2[i], 115) < 51) {
                return i;
            }
        }
        throw C1198j.m4509a();
    }

    protected static void m4053a(int[] iArr, float[] fArr) {
        int i = 0;
        float f = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] > f) {
                f = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] + 1;
    }

    protected static void m4054b(int[] iArr, float[] fArr) {
        int i = 0;
        float f = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] < f) {
                f = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] - 1;
    }

    protected static boolean m4055b(int[] iArr) {
        int i = iArr[0] + iArr[1];
        float f = ((float) i) / ((float) ((iArr[2] + i) + iArr[3]));
        if (f < 0.7916667f || f > 0.89285713f) {
            return false;
        }
        int i2 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i3 = Integer.MIN_VALUE;
        int length = iArr.length;
        int i4 = 0;
        while (i4 < length) {
            i = iArr[i4];
            if (i > i3) {
                i3 = i;
            }
            if (i >= i2) {
                i = i2;
            }
            i4++;
            i2 = i;
        }
        return i3 < i2 * 10;
    }

    protected final int[] m4056b() {
        return this.f2341a;
    }

    protected final int[] m4057c() {
        return this.f2342b;
    }

    protected final float[] m4058d() {
        return this.f2343c;
    }

    protected final float[] m4059e() {
        return this.f2344d;
    }

    protected final int[] m4060f() {
        return this.f2345e;
    }

    protected final int[] m4061g() {
        return this.f2346f;
    }
}
