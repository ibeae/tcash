package com.google.p031b.p034c;

import com.google.p031b.C1043b;
import com.google.p031b.C1196h;
import com.google.p031b.C1198j;

public class C1058h extends C1043b {
    private static final byte[] f2231a = new byte[0];
    private byte[] f2232b = f2231a;
    private final int[] f2233c = new int[32];

    public C1058h(C1196h c1196h) {
        super(c1196h);
    }

    private static int m3878a(int[] iArr) {
        int i;
        int i2;
        int i3 = 0;
        int length = iArr.length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (i = 0; i < length; i++) {
            if (iArr[i] > i4) {
                i4 = iArr[i];
                i5 = i;
            }
            if (iArr[i] > i6) {
                i6 = iArr[i];
            }
        }
        i = 0;
        int i7 = 0;
        while (i3 < length) {
            i4 = i3 - i5;
            i4 *= iArr[i3] * i4;
            if (i4 > i) {
                i = i3;
            } else {
                i4 = i;
                i = i7;
            }
            i3++;
            i7 = i;
            i = i4;
        }
        if (i5 > i7) {
            i2 = i7;
            i7 = i5;
        } else {
            i2 = i5;
        }
        if (i7 - i2 <= (length >> 4)) {
            throw C1198j.m4509a();
        }
        i3 = i7 - 1;
        i5 = -1;
        i = i7 - 1;
        while (i > i2) {
            i4 = i - i2;
            i4 = ((i4 * i4) * (i7 - i)) * (i6 - iArr[i]);
            if (i4 > i5) {
                i5 = i;
            } else {
                i4 = i5;
                i5 = i3;
            }
            i--;
            i3 = i5;
            i5 = i4;
        }
        return i3 << 3;
    }

    private void m3879a(int i) {
        if (this.f2232b.length < i) {
            this.f2232b = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.f2233c[i2] = 0;
        }
    }

    public C1043b mo1420a(C1196h c1196h) {
        return new C1058h(c1196h);
    }

    public C1046a mo1421a(int i, C1046a c1046a) {
        int i2;
        int i3;
        int i4 = 1;
        C1196h a = m3789a();
        int b = a.m4500b();
        if (c1046a == null || c1046a.m3802a() < b) {
            c1046a = new C1046a(b);
        } else {
            c1046a.m3814c();
        }
        m3879a(b);
        byte[] a2 = a.mo1529a(i, this.f2232b);
        int[] iArr = this.f2233c;
        for (i2 = 0; i2 < b; i2++) {
            i3 = (a2[i2] & 255) >> 3;
            iArr[i3] = iArr[i3] + 1;
        }
        i3 = C1058h.m3878a(iArr);
        i2 = a2[1] & 255;
        int i5 = a2[0] & 255;
        while (i4 < b - 1) {
            int i6 = a2[i4 + 1] & 255;
            if (((((i2 << 2) - i5) - i6) >> 1) < i3) {
                c1046a.m3810b(i4);
            }
            i4++;
            i5 = i2;
            i2 = i6;
        }
        return c1046a;
    }

    public C1052b mo1422b() {
        int i;
        int i2;
        C1196h a = m3789a();
        int b = a.m4500b();
        int c = a.m4501c();
        C1052b c1052b = new C1052b(b, c);
        m3879a(b);
        int[] iArr = this.f2233c;
        for (i = 1; i < 5; i++) {
            byte[] a2 = a.mo1529a((c * i) / 5, this.f2232b);
            int i3 = (b << 2) / 5;
            for (i2 = b / 5; i2 < i3; i2++) {
                int i4 = (a2[i2] & 255) >> 3;
                iArr[i4] = iArr[i4] + 1;
            }
        }
        int a3 = C1058h.m3878a(iArr);
        byte[] a4 = a.mo1528a();
        for (i = 0; i < c; i++) {
            int i5 = i * b;
            for (i2 = 0; i2 < b; i2++) {
                if ((a4[i5 + i2] & 255) < a3) {
                    c1052b.m3850b(i2, i);
                }
            }
        }
        return c1052b;
    }
}
