package com.google.p031b.p053h.p054a;

import com.google.p031b.p053h.p054a.C1176j.C1174a;
import com.google.p031b.p053h.p054a.C1176j.C1175b;

final class C1157b {
    private final int f2501a;
    private final byte[] f2502b;

    private C1157b(int i, byte[] bArr) {
        this.f2501a = i;
        this.f2502b = bArr;
    }

    static C1157b[] m4337a(byte[] bArr, C1176j c1176j, C1170f c1170f) {
        if (bArr.length != c1176j.m4386c()) {
            throw new IllegalArgumentException();
        }
        int i;
        C1175b a = c1176j.m4384a(c1170f);
        C1174a[] d = a.m4378d();
        int i2 = 0;
        for (C1174a a2 : d) {
            i2 += a2.m4373a();
        }
        C1157b[] c1157bArr = new C1157b[i2];
        int length = d.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            C1174a c1174a = d[i3];
            i2 = i4;
            i4 = 0;
            while (i4 < c1174a.m4373a()) {
                int b = c1174a.m4374b();
                i = i2 + 1;
                c1157bArr[i2] = new C1157b(b, new byte[(a.m4375a() + b)]);
                i4++;
                i2 = i;
            }
            i3++;
            i4 = i2;
        }
        i = c1157bArr[0].f2502b.length;
        i2 = c1157bArr.length - 1;
        while (i2 >= 0 && c1157bArr[i2].f2502b.length != i) {
            i2--;
        }
        length = i2 + 1;
        i -= a.m4375a();
        int i5 = 0;
        i2 = 0;
        while (i5 < i) {
            i3 = i2;
            i2 = 0;
            while (i2 < i4) {
                int i6 = i3 + 1;
                c1157bArr[i2].f2502b[i5] = bArr[i3];
                i2++;
                i3 = i6;
            }
            i5++;
            i2 = i3;
        }
        i3 = length;
        while (i3 < i4) {
            i6 = i2 + 1;
            c1157bArr[i3].f2502b[i] = bArr[i2];
            i3++;
            i2 = i6;
        }
        int length2 = c1157bArr[0].f2502b.length;
        while (i < length2) {
            i3 = 0;
            i6 = i2;
            while (i3 < i4) {
                i5 = i6 + 1;
                c1157bArr[i3].f2502b[i3 < length ? i : i + 1] = bArr[i6];
                i3++;
                i6 = i5;
            }
            i++;
            i2 = i6;
        }
        return c1157bArr;
    }

    int m4338a() {
        return this.f2501a;
    }

    byte[] m4339b() {
        return this.f2502b;
    }
}
