package com.google.p031b.p034c;

public final class C1046a {
    private int[] f2161a;
    private int f2162b;

    public C1046a() {
        this.f2162b = 0;
        this.f2161a = new int[1];
    }

    public C1046a(int i) {
        this.f2162b = i;
        this.f2161a = C1046a.m3801f(i);
    }

    private void m3800e(int i) {
        if (i > this.f2161a.length * 32) {
            Object f = C1046a.m3801f(i);
            System.arraycopy(this.f2161a, 0, f, 0, this.f2161a.length);
            this.f2161a = f;
        }
    }

    private static int[] m3801f(int i) {
        return new int[((i + 31) / 32)];
    }

    public int m3802a() {
        return this.f2162b;
    }

    public void m3803a(int i, int i2) {
        this.f2161a[i / 32] = i2;
    }

    public void m3804a(int i, byte[] bArr, int i2, int i3) {
        int i4 = 0;
        int i5 = i;
        while (i4 < i3) {
            int i6 = i5;
            i5 = 0;
            for (int i7 = 0; i7 < 8; i7++) {
                if (m3807a(i6)) {
                    i5 |= 1 << (7 - i7);
                }
                i6++;
            }
            bArr[i2 + i4] = (byte) i5;
            i4++;
            i5 = i6;
        }
    }

    public void m3805a(C1046a c1046a) {
        int i = c1046a.f2162b;
        m3800e(this.f2162b + i);
        for (int i2 = 0; i2 < i; i2++) {
            m3806a(c1046a.m3807a(i2));
        }
    }

    public void m3806a(boolean z) {
        m3800e(this.f2162b + 1);
        if (z) {
            int[] iArr = this.f2161a;
            int i = this.f2162b / 32;
            iArr[i] = iArr[i] | (1 << (this.f2162b & 31));
        }
        this.f2162b++;
    }

    public boolean m3807a(int i) {
        return (this.f2161a[i / 32] & (1 << (i & 31))) != 0;
    }

    public boolean m3808a(int i, int i2, boolean z) {
        if (i2 < i) {
            throw new IllegalArgumentException();
        } else if (i2 == i) {
            return true;
        } else {
            int i3 = i2 - 1;
            int i4 = i / 32;
            int i5 = i3 / 32;
            int i6 = i4;
            while (i6 <= i5) {
                int i7;
                int i8 = i6 > i4 ? 0 : i & 31;
                int i9 = i6 < i5 ? 31 : i3 & 31;
                if (i8 == 0 && i9 == 31) {
                    i8 = -1;
                } else {
                    i7 = i8;
                    i8 = 0;
                    while (i7 <= i9) {
                        int i10 = (1 << i7) | i8;
                        i7++;
                        i8 = i10;
                    }
                }
                i7 = this.f2161a[i6] & i8;
                if (!z) {
                    i8 = 0;
                }
                if (i7 != i8) {
                    return false;
                }
                i6++;
            }
            return true;
        }
    }

    public int m3809b() {
        return (this.f2162b + 7) / 8;
    }

    public void m3810b(int i) {
        int[] iArr = this.f2161a;
        int i2 = i / 32;
        iArr[i2] = iArr[i2] | (1 << (i & 31));
    }

    public void m3811b(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        m3800e(this.f2162b + i2);
        while (i2 > 0) {
            m3806a(((i >> (i2 + -1)) & 1) == 1);
            i2--;
        }
    }

    public void m3812b(C1046a c1046a) {
        if (this.f2161a.length != c1046a.f2161a.length) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        for (int i = 0; i < this.f2161a.length; i++) {
            int[] iArr = this.f2161a;
            iArr[i] = iArr[i] ^ c1046a.f2161a[i];
        }
    }

    public int m3813c(int i) {
        if (i >= this.f2162b) {
            return this.f2162b;
        }
        int i2 = i / 32;
        int i3 = this.f2161a[i2] & (((1 << (i & 31)) - 1) ^ -1);
        while (i3 == 0) {
            i2++;
            if (i2 == this.f2161a.length) {
                return this.f2162b;
            }
            i3 = this.f2161a[i2];
        }
        i3 = Integer.numberOfTrailingZeros(i3) + (i2 * 32);
        return i3 > this.f2162b ? this.f2162b : i3;
    }

    public void m3814c() {
        int length = this.f2161a.length;
        for (int i = 0; i < length; i++) {
            this.f2161a[i] = 0;
        }
    }

    public int m3815d(int i) {
        if (i >= this.f2162b) {
            return this.f2162b;
        }
        int i2 = i / 32;
        int i3 = (this.f2161a[i2] ^ -1) & (((1 << (i & 31)) - 1) ^ -1);
        while (i3 == 0) {
            i2++;
            if (i2 == this.f2161a.length) {
                return this.f2162b;
            }
            i3 = this.f2161a[i2] ^ -1;
        }
        i3 = Integer.numberOfTrailingZeros(i3) + (i2 * 32);
        return i3 > this.f2162b ? this.f2162b : i3;
    }

    public int[] m3816d() {
        return this.f2161a;
    }

    public void m3817e() {
        int i;
        int i2 = 1;
        int[] iArr = new int[this.f2161a.length];
        int i3 = (this.f2162b - 1) / 32;
        int i4 = i3 + 1;
        for (i = 0; i < i4; i++) {
            long j = (long) this.f2161a[i];
            j = ((j & 1431655765) << 1) | ((j >> 1) & 1431655765);
            j = ((j & 858993459) << 2) | ((j >> 2) & 858993459);
            j = ((j & 252645135) << 4) | ((j >> 4) & 252645135);
            j = ((j & 16711935) << 8) | ((j >> 8) & 16711935);
            iArr[i3 - i] = (int) (((j & 65535) << 16) | ((j >> 16) & 65535));
        }
        if (this.f2162b != i4 * 32) {
            int i5 = (i4 * 32) - this.f2162b;
            i3 = 1;
            for (i = 0; i < 31 - i5; i++) {
                i3 = (i3 << 1) | 1;
            }
            i = (iArr[0] >> i5) & i3;
            while (i2 < i4) {
                int i6 = iArr[i2];
                iArr[i2 - 1] = i | (i6 << (32 - i5));
                i = (i6 >> i5) & i3;
                i2++;
            }
            iArr[i4 - 1] = i;
        }
        this.f2161a = iArr;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.f2162b);
        for (int i = 0; i < this.f2162b; i++) {
            if ((i & 7) == 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(m3807a(i) ? 'X' : '.');
        }
        return stringBuilder.toString();
    }
}
