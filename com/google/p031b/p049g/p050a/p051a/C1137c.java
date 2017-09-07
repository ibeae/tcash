package com.google.p031b.p049g.p050a.p051a;

final class C1137c {
    private final C1136b f2441a;
    private final int[] f2442b;

    C1137c(C1136b c1136b, int[] iArr) {
        int i = 1;
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f2441a = c1136b;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f2442b = iArr;
            return;
        }
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.f2442b = c1136b.m4190a().f2442b;
            return;
        }
        this.f2442b = new int[(length - i)];
        System.arraycopy(iArr, i, this.f2442b, 0, this.f2442b.length);
    }

    int m4199a() {
        return this.f2442b.length - 1;
    }

    int m4200a(int i) {
        return this.f2442b[(this.f2442b.length - 1) - i];
    }

    C1137c m4201a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f2441a.m4190a();
        } else {
            int length = this.f2442b.length;
            int[] iArr = new int[(length + i)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.f2441a.m4198d(this.f2442b[i3], i2);
            }
            return new C1137c(this.f2441a, iArr);
        }
    }

    C1137c m4202a(C1137c c1137c) {
        if (!this.f2441a.equals(c1137c.f2441a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (m4205b()) {
            return c1137c;
        } else {
            if (c1137c.m4205b()) {
                return this;
            }
            Object obj = this.f2442b;
            Object obj2 = c1137c.f2442b;
            if (obj.length <= obj2.length) {
                Object obj3 = obj2;
                obj2 = obj;
                obj = obj3;
            }
            Object obj4 = new int[obj.length];
            int length = obj.length - r1.length;
            System.arraycopy(obj, 0, obj4, 0, length);
            for (int i = length; i < obj.length; i++) {
                obj4[i] = this.f2441a.m4193b(r1[i - length], obj[i]);
            }
            return new C1137c(this.f2441a, obj4);
        }
    }

    int m4203b(int i) {
        int i2 = 0;
        if (i == 0) {
            return m4200a(0);
        }
        int length = this.f2442b.length;
        int i3;
        if (i == 1) {
            int[] iArr = this.f2442b;
            int length2 = iArr.length;
            i3 = 0;
            while (i2 < length2) {
                i2++;
                i3 = this.f2441a.m4193b(i3, iArr[i2]);
            }
            return i3;
        }
        i3 = this.f2442b[0];
        i2 = 1;
        while (i2 < length) {
            int b = this.f2441a.m4193b(this.f2441a.m4198d(i, i3), this.f2442b[i2]);
            i2++;
            i3 = b;
        }
        return i3;
    }

    C1137c m4204b(C1137c c1137c) {
        if (this.f2441a.equals(c1137c.f2441a)) {
            return c1137c.m4205b() ? this : m4202a(c1137c.m4206c());
        } else {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
    }

    boolean m4205b() {
        return this.f2442b[0] == 0;
    }

    C1137c m4206c() {
        int length = this.f2442b.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = this.f2441a.m4197c(0, this.f2442b[i]);
        }
        return new C1137c(this.f2441a, iArr);
    }

    C1137c m4207c(int i) {
        if (i == 0) {
            return this.f2441a.m4190a();
        }
        if (i == 1) {
            return this;
        }
        int length = this.f2442b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f2441a.m4198d(this.f2442b[i2], i);
        }
        return new C1137c(this.f2441a, iArr);
    }

    C1137c m4208c(C1137c c1137c) {
        if (!this.f2441a.equals(c1137c.f2441a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (m4205b() || c1137c.m4205b()) {
            return this.f2441a.m4190a();
        } else {
            int[] iArr = this.f2442b;
            int length = iArr.length;
            int[] iArr2 = c1137c.f2442b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    iArr3[i + i3] = this.f2441a.m4193b(iArr3[i + i3], this.f2441a.m4198d(i2, iArr2[i3]));
                }
            }
            return new C1137c(this.f2441a, iArr3);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(m4199a() * 8);
        for (int a = m4199a(); a >= 0; a--) {
            int a2 = m4200a(a);
            if (a2 != 0) {
                if (a2 < 0) {
                    stringBuilder.append(" - ");
                    a2 = -a2;
                } else if (stringBuilder.length() > 0) {
                    stringBuilder.append(" + ");
                }
                if (a == 0 || a2 != 1) {
                    stringBuilder.append(a2);
                }
                if (a != 0) {
                    if (a == 1) {
                        stringBuilder.append('x');
                    } else {
                        stringBuilder.append("x^");
                        stringBuilder.append(a);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
}
