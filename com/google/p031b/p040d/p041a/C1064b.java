package com.google.p031b.p040d.p041a;

import com.google.p031b.p040d.p041a.C1072e.C1070a;
import com.google.p031b.p040d.p041a.C1072e.C1071b;

final class C1064b {
    private final int f2251a;
    private final byte[] f2252b;

    private C1064b(int i, byte[] bArr) {
        this.f2251a = i;
        this.f2252b = bArr;
    }

    static C1064b[] m3912a(byte[] bArr, C1072e c1072e) {
        int i;
        int i2;
        C1071b g = c1072e.m3938g();
        C1070a[] b = g.m3929b();
        int i3 = 0;
        for (C1070a a : b) {
            i3 += a.m3926a();
        }
        C1064b[] c1064bArr = new C1064b[i3];
        int length = b.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            C1070a c1070a = b[i4];
            i3 = i5;
            i5 = 0;
            while (i5 < c1070a.m3926a()) {
                int b2 = c1070a.m3927b();
                i = i3 + 1;
                c1064bArr[i3] = new C1064b(b2, new byte[(g.m3928a() + b2)]);
                i5++;
                i3 = i;
            }
            i4++;
            i5 = i3;
        }
        i = c1064bArr[0].f2252b.length - g.m3928a();
        length = i - 1;
        int i6 = 0;
        for (i2 = 0; i2 < length; i2++) {
            i3 = 0;
            while (i3 < i5) {
                i4 = i6 + 1;
                c1064bArr[i3].f2252b[i2] = bArr[i6];
                i3++;
                i6 = i4;
            }
        }
        length = c1072e.m3932a() == 24 ? 1 : 0;
        i3 = length != 0 ? 8 : i5;
        i4 = 0;
        while (i4 < i3) {
            i2 = i6 + 1;
            c1064bArr[i4].f2252b[i - 1] = bArr[i6];
            i4++;
            i6 = i2;
        }
        int length2 = c1064bArr[0].f2252b.length;
        i3 = i6;
        while (i < length2) {
            i4 = 0;
            i6 = i3;
            while (i4 < i5) {
                i3 = (length == 0 || i4 <= 7) ? i : i - 1;
                i2 = i6 + 1;
                c1064bArr[i4].f2252b[i3] = bArr[i6];
                i4++;
                i6 = i2;
            }
            i++;
            i3 = i6;
        }
        if (i3 == bArr.length) {
            return c1064bArr;
        }
        throw new IllegalArgumentException();
    }

    int m3913a() {
        return this.f2251a;
    }

    byte[] m3914b() {
        return this.f2252b;
    }
}
