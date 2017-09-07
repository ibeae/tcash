package com.google.p031b.p034c.p039b;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;

public final class C1047a {
    public static final C1047a f2163a = new C1047a(4201, FragmentTransaction.TRANSIT_ENTER_MASK, 1);
    public static final C1047a f2164b = new C1047a(1033, 1024, 1);
    public static final C1047a f2165c = new C1047a(67, 64, 1);
    public static final C1047a f2166d = new C1047a(19, 16, 1);
    public static final C1047a f2167e = new C1047a(285, NotificationCompat.FLAG_LOCAL_ONLY, 0);
    public static final C1047a f2168f = new C1047a(301, NotificationCompat.FLAG_LOCAL_ONLY, 1);
    public static final C1047a f2169g = f2168f;
    public static final C1047a f2170h = f2165c;
    private int[] f2171i;
    private int[] f2172j;
    private C1048b f2173k;
    private C1048b f2174l;
    private final int f2175m;
    private final int f2176n;
    private final int f2177o;
    private boolean f2178p = false;

    public C1047a(int i, int i2, int i3) {
        this.f2176n = i;
        this.f2175m = i2;
        this.f2177o = i3;
        if (i2 <= 0) {
            m3819e();
        }
    }

    static int m3818b(int i, int i2) {
        return i ^ i2;
    }

    private void m3819e() {
        int i;
        this.f2171i = new int[this.f2175m];
        this.f2172j = new int[this.f2175m];
        int i2 = 1;
        for (i = 0; i < this.f2175m; i++) {
            this.f2171i[i] = i2;
            i2 <<= 1;
            if (i2 >= this.f2175m) {
                i2 = (i2 ^ this.f2176n) & (this.f2175m - 1);
            }
        }
        for (i = 0; i < this.f2175m - 1; i++) {
            this.f2172j[this.f2171i[i]] = i;
        }
        this.f2173k = new C1048b(this, new int[]{0});
        this.f2174l = new C1048b(this, new int[]{1});
        this.f2178p = true;
    }

    private void m3820f() {
        if (!this.f2178p) {
            m3819e();
        }
    }

    int m3821a(int i) {
        m3820f();
        return this.f2171i[i];
    }

    C1048b m3822a() {
        m3820f();
        return this.f2173k;
    }

    C1048b m3823a(int i, int i2) {
        m3820f();
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f2173k;
        } else {
            int[] iArr = new int[(i + 1)];
            iArr[0] = i2;
            return new C1048b(this, iArr);
        }
    }

    int m3824b(int i) {
        m3820f();
        if (i != 0) {
            return this.f2172j[i];
        }
        throw new IllegalArgumentException();
    }

    C1048b m3825b() {
        m3820f();
        return this.f2174l;
    }

    public int m3826c() {
        return this.f2175m;
    }

    int m3827c(int i) {
        m3820f();
        if (i != 0) {
            return this.f2171i[(this.f2175m - this.f2172j[i]) - 1];
        }
        throw new ArithmeticException();
    }

    int m3828c(int i, int i2) {
        m3820f();
        return (i == 0 || i2 == 0) ? 0 : this.f2171i[(this.f2172j[i] + this.f2172j[i2]) % (this.f2175m - 1)];
    }

    public int m3829d() {
        return this.f2177o;
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f2176n) + ',' + this.f2175m + ')';
    }
}
