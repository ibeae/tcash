package com.google.p031b.p049g.p050a.p051a;

import com.google.p031b.C1079d;

public final class C1135a {
    private final C1136b f2434a = C1136b.f2435a;

    private int[] m4185a(C1137c c1137c) {
        int a = c1137c.m4199a();
        int[] iArr = new int[a];
        int i = 0;
        for (int i2 = 1; i2 < this.f2434a.m4195c() && i < a; i2++) {
            if (c1137c.m4203b(i2) == 0) {
                iArr[i] = this.f2434a.m4196c(i2);
                i++;
            }
        }
        if (i == a) {
            return iArr;
        }
        throw C1079d.m3955a();
    }

    private int[] m4186a(C1137c c1137c, C1137c c1137c2, int[] iArr) {
        int i;
        int a = c1137c2.m4199a();
        int[] iArr2 = new int[a];
        for (i = 1; i <= a; i++) {
            iArr2[a - i] = this.f2434a.m4198d(i, c1137c2.m4200a(i));
        }
        C1137c c1137c3 = new C1137c(this.f2434a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (i = 0; i < length; i++) {
            int c = this.f2434a.m4196c(iArr[i]);
            iArr3[i] = this.f2434a.m4198d(this.f2434a.m4197c(0, c1137c.m4203b(c)), this.f2434a.m4196c(c1137c3.m4203b(c)));
        }
        return iArr3;
    }

    private C1137c[] m4187a(C1137c c1137c, C1137c c1137c2, int i) {
        if (c1137c.m4199a() >= c1137c2.m4199a()) {
            C1137c c1137c3 = c1137c2;
            c1137c2 = c1137c;
            c1137c = c1137c3;
        }
        C1137c a = this.f2434a.m4190a();
        C1137c b = this.f2434a.m4194b();
        while (c1137c.m4199a() >= i / 2) {
            if (c1137c.m4205b()) {
                throw C1079d.m3955a();
            }
            C1137c a2 = this.f2434a.m4190a();
            int c = this.f2434a.m4196c(c1137c.m4200a(c1137c.m4199a()));
            C1137c c1137c4 = a2;
            a2 = c1137c2;
            while (a2.m4199a() >= c1137c.m4199a() && !a2.m4205b()) {
                int a3 = a2.m4199a() - c1137c.m4199a();
                int d = this.f2434a.m4198d(a2.m4200a(a2.m4199a()), c);
                c1137c4 = c1137c4.m4202a(this.f2434a.m4191a(a3, d));
                a2 = a2.m4204b(c1137c.m4201a(a3, d));
            }
            c1137c2 = c1137c;
            c1137c = a2;
            c1137c3 = b;
            b = c1137c4.m4208c(b).m4204b(a).m4206c();
            a = c1137c3;
        }
        int a4 = b.m4200a(0);
        if (a4 == 0) {
            throw C1079d.m3955a();
        }
        a4 = this.f2434a.m4196c(a4);
        b = b.m4207c(a4);
        a = c1137c.m4207c(a4);
        return new C1137c[]{b, a};
    }

    public int m4188a(int[] iArr, int i, int[] iArr2) {
        C1137c c1137c = new C1137c(this.f2434a, iArr);
        int[] iArr3 = new int[i];
        int i2 = 0;
        for (int i3 = i; i3 > 0; i3--) {
            int b = c1137c.m4203b(this.f2434a.m4189a(i3));
            iArr3[i - i3] = b;
            if (b != 0) {
                i2 = 1;
            }
        }
        if (i2 == 0) {
            return 0;
        }
        C1137c b2 = this.f2434a.m4194b();
        C1137c c1137c2 = b2;
        for (int b3 : iArr2) {
            b3 = this.f2434a.m4189a((iArr.length - 1) - b3);
            c1137c2 = c1137c2.m4208c(new C1137c(this.f2434a, new int[]{this.f2434a.m4197c(0, b3), 1}));
        }
        C1137c[] a = m4187a(this.f2434a.m4191a(i, 1), new C1137c(this.f2434a, iArr3), i);
        c1137c2 = a[0];
        b2 = a[1];
        int[] a2 = m4185a(c1137c2);
        int[] a3 = m4186a(b2, c1137c2, a2);
        for (i2 = 0; i2 < a2.length; i2++) {
            int length = (iArr.length - 1) - this.f2434a.m4192b(a2[i2]);
            if (length < 0) {
                throw C1079d.m3955a();
            }
            iArr[length] = this.f2434a.m4197c(iArr[length], a3[i2]);
        }
        return a2.length;
    }
}
