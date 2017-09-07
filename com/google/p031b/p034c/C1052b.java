package com.google.p031b.p034c;

public final class C1052b {
    private final int f2184a;
    private final int f2185b;
    private final int f2186c;
    private final int[] f2187d;

    public C1052b(int i) {
        this(i, i);
    }

    public C1052b(int i, int i2) {
        if (i < 1 || i2 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f2184a = i;
        this.f2185b = i2;
        this.f2186c = (i + 31) >> 5;
        this.f2187d = new int[(this.f2186c * i2)];
    }

    public C1046a m3846a(int i, C1046a c1046a) {
        if (c1046a == null || c1046a.m3802a() < this.f2184a) {
            c1046a = new C1046a(this.f2184a);
        }
        int i2 = i * this.f2186c;
        for (int i3 = 0; i3 < this.f2186c; i3++) {
            c1046a.m3803a(i3 << 5, this.f2187d[i2 + i3]);
        }
        return c1046a;
    }

    public void m3847a(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i4 < 1 || i3 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            int i5 = i + i3;
            int i6 = i2 + i4;
            if (i6 > this.f2185b || i5 > this.f2184a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i2 < i6) {
                int i7 = i2 * this.f2186c;
                for (int i8 = i; i8 < i5; i8++) {
                    int[] iArr = this.f2187d;
                    int i9 = (i8 >> 5) + i7;
                    iArr[i9] = iArr[i9] | (1 << (i8 & 31));
                }
                i2++;
            }
        }
    }

    public boolean m3848a(int i, int i2) {
        return ((this.f2187d[(this.f2186c * i2) + (i >> 5)] >>> (i & 31)) & 1) != 0;
    }

    public int[] m3849a() {
        int i = this.f2184a;
        int i2 = this.f2185b;
        int i3 = i;
        i = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < this.f2185b; i5++) {
            int i6 = 0;
            while (i6 < this.f2186c) {
                int i7;
                int i8 = this.f2187d[(this.f2186c * i5) + i6];
                if (i8 != 0) {
                    if (i5 < i2) {
                        i2 = i5;
                    }
                    if (i5 > i4) {
                        i4 = i5;
                    }
                    if (i6 * 32 < i3) {
                        i7 = 0;
                        while ((i8 << (31 - i7)) == 0) {
                            i7++;
                        }
                        if ((i6 * 32) + i7 < i3) {
                            i7 = (i6 * 32) + i7;
                            if ((i6 * 32) + 31 > i) {
                                i3 = 31;
                                while ((i8 >>> i3) == 0) {
                                    i3--;
                                }
                                if ((i6 * 32) + i3 > i) {
                                    i = (i6 * 32) + i3;
                                    i3 = i2;
                                    i2 = i;
                                    i = i4;
                                }
                            }
                            i3 = i2;
                            i2 = i;
                            i = i4;
                        }
                    }
                    i7 = i3;
                    if ((i6 * 32) + 31 > i) {
                        i3 = 31;
                        while ((i8 >>> i3) == 0) {
                            i3--;
                        }
                        if ((i6 * 32) + i3 > i) {
                            i = (i6 * 32) + i3;
                            i3 = i2;
                            i2 = i;
                            i = i4;
                        }
                    }
                    i3 = i2;
                    i2 = i;
                    i = i4;
                } else {
                    i7 = i3;
                    i3 = i2;
                    i2 = i;
                    i = i4;
                }
                i6++;
                i4 = i;
                i = i2;
                i2 = i3;
                i3 = i7;
            }
        }
        i4 -= i2;
        if (i - i3 < 0 || i4 < 0) {
            return null;
        }
        return new int[]{i3, i2, i, i4};
    }

    public void m3850b(int i, int i2) {
        int i3 = (this.f2186c * i2) + (i >> 5);
        int[] iArr = this.f2187d;
        iArr[i3] = iArr[i3] | (1 << (i & 31));
    }

    public void m3851b(int i, C1046a c1046a) {
        System.arraycopy(c1046a.m3816d(), 0, this.f2187d, this.f2186c * i, this.f2186c);
    }

    public int[] m3852b() {
        int i = 0;
        while (i < this.f2187d.length && this.f2187d[i] == 0) {
            i++;
        }
        if (i == this.f2187d.length) {
            return null;
        }
        int i2 = i / this.f2186c;
        int i3 = (i % this.f2186c) << 5;
        int i4 = this.f2187d[i];
        i = 0;
        while ((i4 << (31 - i)) == 0) {
            i++;
        }
        i3 += i;
        return new int[]{i3, i2};
    }

    public void m3853c(int i, int i2) {
        int i3 = (this.f2186c * i2) + (i >> 5);
        int[] iArr = this.f2187d;
        iArr[i3] = iArr[i3] ^ (1 << (i & 31));
    }

    public int[] m3854c() {
        int length = this.f2187d.length - 1;
        while (length >= 0 && this.f2187d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i = length / this.f2186c;
        int i2 = (length % this.f2186c) << 5;
        int i3 = this.f2187d[length];
        length = 31;
        while ((i3 >>> length) == 0) {
            length--;
        }
        i2 += length;
        return new int[]{i2, i};
    }

    public int m3855d() {
        return this.f2184a;
    }

    public int m3856e() {
        return this.f2185b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1052b)) {
            return false;
        }
        C1052b c1052b = (C1052b) obj;
        if (this.f2184a != c1052b.f2184a || this.f2185b != c1052b.f2185b || this.f2186c != c1052b.f2186c || this.f2187d.length != c1052b.f2187d.length) {
            return false;
        }
        for (int i = 0; i < this.f2187d.length; i++) {
            if (this.f2187d[i] != c1052b.f2187d[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.f2186c + (((((this.f2184a * 31) + this.f2184a) * 31) + this.f2185b) * 31);
        for (int i2 : this.f2187d) {
            i = (i * 31) + i2;
        }
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.f2185b * (this.f2184a + 1));
        for (int i = 0; i < this.f2185b; i++) {
            for (int i2 = 0; i2 < this.f2184a; i2++) {
                stringBuilder.append(m3848a(i2, i) ? "X " : "  ");
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
