package com.google.p031b.p034c;

public final class C1053c {
    private final byte[] f2188a;
    private int f2189b;
    private int f2190c;

    public C1053c(byte[] bArr) {
        this.f2188a = bArr;
    }

    public int m3857a() {
        return this.f2190c;
    }

    public int m3858a(int i) {
        if (i < 1 || i > 32 || i > m3860c()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        int i2;
        int i3;
        if (this.f2190c > 0) {
            i2 = 8 - this.f2190c;
            i3 = i < i2 ? i : i2;
            i2 -= i3;
            i2 = (((255 >> (8 - i3)) << i2) & this.f2188a[this.f2189b]) >> i2;
            i -= i3;
            this.f2190c = i3 + this.f2190c;
            if (this.f2190c == 8) {
                this.f2190c = 0;
                this.f2189b++;
            }
            i3 = i2;
            i2 = i;
        } else {
            i3 = 0;
            i2 = i;
        }
        if (i2 <= 0) {
            return i3;
        }
        while (i2 >= 8) {
            i3 = (i3 << 8) | (this.f2188a[this.f2189b] & 255);
            this.f2189b++;
            i2 -= 8;
        }
        if (i2 <= 0) {
            return i3;
        }
        int i4 = 8 - i2;
        i3 = (i3 << i2) | ((((255 >> i4) << i4) & this.f2188a[this.f2189b]) >> i4);
        this.f2190c = i2 + this.f2190c;
        return i3;
    }

    public int m3859b() {
        return this.f2189b;
    }

    public int m3860c() {
        return ((this.f2188a.length - this.f2189b) * 8) - this.f2190c;
    }
}
