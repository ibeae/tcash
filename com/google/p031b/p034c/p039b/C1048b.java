package com.google.p031b.p034c.p039b;

final class C1048b {
    private final C1047a f2179a;
    private final int[] f2180b;

    C1048b(C1047a c1047a, int[] iArr) {
        int i = 1;
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f2179a = c1047a;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f2180b = iArr;
            return;
        }
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.f2180b = c1047a.m3822a().f2180b;
            return;
        }
        this.f2180b = new int[(length - i)];
        System.arraycopy(iArr, i, this.f2180b, 0, this.f2180b.length);
    }

    int m3830a(int i) {
        return this.f2180b[(this.f2180b.length - 1) - i];
    }

    C1048b m3831a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f2179a.m3822a();
        } else {
            int length = this.f2180b.length;
            int[] iArr = new int[(length + i)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.f2179a.m3828c(this.f2180b[i3], i2);
            }
            return new C1048b(this.f2179a, iArr);
        }
    }

    C1048b m3832a(C1048b c1048b) {
        if (!this.f2179a.equals(c1048b.f2179a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (m3838c()) {
            return c1048b;
        } else {
            if (c1048b.m3838c()) {
                return this;
            }
            Object obj = this.f2180b;
            Object obj2 = c1048b.f2180b;
            if (obj.length <= obj2.length) {
                Object obj3 = obj2;
                obj2 = obj;
                obj = obj3;
            }
            Object obj4 = new int[obj.length];
            int length = obj.length - r1.length;
            System.arraycopy(obj, 0, obj4, 0, length);
            for (int i = length; i < obj.length; i++) {
                obj4[i] = C1047a.m3818b(r1[i - length], obj[i]);
            }
            return new C1048b(this.f2179a, obj4);
        }
    }

    int[] m3833a() {
        return this.f2180b;
    }

    int m3834b() {
        return this.f2180b.length - 1;
    }

    int m3835b(int i) {
        int i2 = 0;
        if (i == 0) {
            return m3830a(0);
        }
        int length = this.f2180b.length;
        int i3;
        if (i == 1) {
            int[] iArr = this.f2180b;
            int length2 = iArr.length;
            i3 = 0;
            while (i2 < length2) {
                int b = C1047a.m3818b(i3, iArr[i2]);
                i2++;
                i3 = b;
            }
            return i3;
        }
        i3 = this.f2180b[0];
        i2 = 1;
        while (i2 < length) {
            b = C1047a.m3818b(this.f2179a.m3828c(i, i3), this.f2180b[i2]);
            i2++;
            i3 = b;
        }
        return i3;
    }

    C1048b m3836b(C1048b c1048b) {
        if (!this.f2179a.equals(c1048b.f2179a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (m3838c() || c1048b.m3838c()) {
            return this.f2179a.m3822a();
        } else {
            int[] iArr = this.f2180b;
            int length = iArr.length;
            int[] iArr2 = c1048b.f2180b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    iArr3[i + i3] = C1047a.m3818b(iArr3[i + i3], this.f2179a.m3828c(i2, iArr2[i3]));
                }
            }
            return new C1048b(this.f2179a, iArr3);
        }
    }

    C1048b m3837c(int i) {
        if (i == 0) {
            return this.f2179a.m3822a();
        }
        if (i == 1) {
            return this;
        }
        int length = this.f2180b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f2179a.m3828c(this.f2180b[i2], i);
        }
        return new C1048b(this.f2179a, iArr);
    }

    boolean m3838c() {
        return this.f2180b[0] == 0;
    }

    C1048b[] m3839c(C1048b c1048b) {
        if (!this.f2179a.equals(c1048b.f2179a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (c1048b.m3838c()) {
            throw new IllegalArgumentException("Divide by 0");
        } else {
            C1048b a = this.f2179a.m3822a();
            int c = this.f2179a.m3827c(c1048b.m3830a(c1048b.m3834b()));
            C1048b c1048b2 = a;
            a = this;
            while (a.m3834b() >= c1048b.m3834b() && !a.m3838c()) {
                int b = a.m3834b() - c1048b.m3834b();
                int c2 = this.f2179a.m3828c(a.m3830a(a.m3834b()), c);
                C1048b a2 = c1048b.m3831a(b, c2);
                c1048b2 = c1048b2.m3832a(this.f2179a.m3823a(b, c2));
                a = a.m3832a(a2);
            }
            return new C1048b[]{c1048b2, a};
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(m3834b() * 8);
        for (int b = m3834b(); b >= 0; b--) {
            int a = m3830a(b);
            if (a != 0) {
                if (a < 0) {
                    stringBuilder.append(" - ");
                    a = -a;
                } else if (stringBuilder.length() > 0) {
                    stringBuilder.append(" + ");
                }
                if (b == 0 || a != 1) {
                    a = this.f2179a.m3824b(a);
                    if (a == 0) {
                        stringBuilder.append('1');
                    } else if (a == 1) {
                        stringBuilder.append('a');
                    } else {
                        stringBuilder.append("a^");
                        stringBuilder.append(a);
                    }
                }
                if (b != 0) {
                    if (b == 1) {
                        stringBuilder.append('x');
                    } else {
                        stringBuilder.append("x^");
                        stringBuilder.append(b);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
}
