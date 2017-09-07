package com.google.p031b.p049g.p050a.p051a;

public final class C1136b {
    public static final C1136b f2435a = new C1136b(929, 3);
    private final int[] f2436b;
    private final int[] f2437c;
    private final C1137c f2438d;
    private final C1137c f2439e;
    private final int f2440f;

    private C1136b(int i, int i2) {
        int i3;
        this.f2440f = i;
        this.f2436b = new int[i];
        this.f2437c = new int[i];
        int i4 = 1;
        for (i3 = 0; i3 < i; i3++) {
            this.f2436b[i3] = i4;
            i4 = (i4 * i2) % i;
        }
        for (i3 = 0; i3 < i - 1; i3++) {
            this.f2437c[this.f2436b[i3]] = i3;
        }
        this.f2438d = new C1137c(this, new int[]{0});
        this.f2439e = new C1137c(this, new int[]{1});
    }

    int m4189a(int i) {
        return this.f2436b[i];
    }

    C1137c m4190a() {
        return this.f2438d;
    }

    C1137c m4191a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f2438d;
        } else {
            int[] iArr = new int[(i + 1)];
            iArr[0] = i2;
            return new C1137c(this, iArr);
        }
    }

    int m4192b(int i) {
        if (i != 0) {
            return this.f2437c[i];
        }
        throw new IllegalArgumentException();
    }

    int m4193b(int i, int i2) {
        return (i + i2) % this.f2440f;
    }

    C1137c m4194b() {
        return this.f2439e;
    }

    int m4195c() {
        return this.f2440f;
    }

    int m4196c(int i) {
        if (i != 0) {
            return this.f2436b[(this.f2440f - this.f2437c[i]) - 1];
        }
        throw new ArithmeticException();
    }

    int m4197c(int i, int i2) {
        return ((this.f2440f + i) - i2) % this.f2440f;
    }

    int m4198d(int i, int i2) {
        return (i == 0 || i2 == 0) ? 0 : this.f2436b[(this.f2437c[i] + this.f2437c[i2]) % (this.f2440f - 1)];
    }
}
