package com.google.p031b.p034c.p039b;

public final class C1049c {
    private final C1047a f2181a;

    public C1049c(C1047a c1047a) {
        this.f2181a = c1047a;
    }

    private int[] m3840a(C1048b c1048b) {
        int i = 0;
        int i2 = 1;
        int b = c1048b.m3834b();
        if (b == 1) {
            return new int[]{c1048b.m3830a(1)};
        }
        int[] iArr = new int[b];
        while (i2 < this.f2181a.m3826c() && i < b) {
            if (c1048b.m3835b(i2) == 0) {
                iArr[i] = this.f2181a.m3827c(i2);
                i++;
            }
            i2++;
        }
        if (i == b) {
            return iArr;
        }
        throw new C1051e("Error locator degree does not match number of roots");
    }

    private int[] m3841a(C1048b c1048b, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            int c = this.f2181a.m3827c(iArr[i]);
            int i2 = 1;
            int i3 = 0;
            while (i3 < length) {
                int c2;
                if (i != i3) {
                    c2 = this.f2181a.m3828c(iArr[i3], c);
                    c2 = this.f2181a.m3828c(i2, (c2 & 1) == 0 ? c2 | 1 : c2 & -2);
                } else {
                    c2 = i2;
                }
                i3++;
                i2 = c2;
            }
            iArr2[i] = this.f2181a.m3828c(c1048b.m3835b(c), this.f2181a.m3827c(i2));
            if (this.f2181a.m3829d() != 0) {
                iArr2[i] = this.f2181a.m3828c(iArr2[i], c);
            }
        }
        return iArr2;
    }

    private C1048b[] m3842a(C1048b c1048b, C1048b c1048b2, int i) {
        if (c1048b.m3834b() >= c1048b2.m3834b()) {
            C1048b c1048b3 = c1048b2;
            c1048b2 = c1048b;
            c1048b = c1048b3;
        }
        C1048b a = this.f2181a.m3822a();
        C1048b b = this.f2181a.m3825b();
        while (c1048b.m3834b() >= i / 2) {
            if (c1048b.m3838c()) {
                throw new C1051e("r_{i-1} was zero");
            }
            C1048b a2 = this.f2181a.m3822a();
            int c = this.f2181a.m3827c(c1048b.m3830a(c1048b.m3834b()));
            C1048b c1048b4 = a2;
            a2 = c1048b2;
            while (a2.m3834b() >= c1048b.m3834b() && !a2.m3838c()) {
                int b2 = a2.m3834b() - c1048b.m3834b();
                int c2 = this.f2181a.m3828c(a2.m3830a(a2.m3834b()), c);
                c1048b4 = c1048b4.m3832a(this.f2181a.m3823a(b2, c2));
                a2 = a2.m3832a(c1048b.m3831a(b2, c2));
            }
            a = c1048b4.m3836b(b).m3832a(a);
            if (a2.m3834b() >= c1048b.m3834b()) {
                throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
            }
            c1048b2 = c1048b;
            c1048b = a2;
            c1048b3 = b;
            b = a;
            a = c1048b3;
        }
        int a3 = b.m3830a(0);
        if (a3 == 0) {
            throw new C1051e("sigmaTilde(0) was zero");
        }
        a3 = this.f2181a.m3827c(a3);
        b = b.m3837c(a3);
        a = c1048b.m3837c(a3);
        return new C1048b[]{b, a};
    }

    public void m3843a(int[] iArr, int i) {
        int i2 = 0;
        C1048b c1048b = new C1048b(this.f2181a, iArr);
        int[] iArr2 = new int[i];
        int i3 = 1;
        for (int i4 = 0; i4 < i; i4++) {
            int b = c1048b.m3835b(this.f2181a.m3821a(this.f2181a.m3829d() + i4));
            iArr2[(iArr2.length - 1) - i4] = b;
            if (b != 0) {
                i3 = 0;
            }
        }
        if (i3 == 0) {
            C1048b[] a = m3842a(this.f2181a.m3823a(i, 1), new C1048b(this.f2181a, iArr2), i);
            C1048b c1048b2 = a[0];
            C1048b c1048b3 = a[1];
            int[] a2 = m3840a(c1048b2);
            int[] a3 = m3841a(c1048b3, a2);
            while (i2 < a2.length) {
                int length = (iArr.length - 1) - this.f2181a.m3824b(a2[i2]);
                if (length < 0) {
                    throw new C1051e("Bad error location");
                }
                iArr[length] = C1047a.m3818b(iArr[length], a3[i2]);
                i2++;
            }
        }
    }
}
