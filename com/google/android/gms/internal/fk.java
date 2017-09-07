package com.google.android.gms.internal;

import java.io.IOException;

public final class fk {
    private final byte[] f1584a;
    private final int f1585b;
    private int f1586c;

    public static class C0807a extends IOException {
        C0807a(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private fk(byte[] bArr, int i, int i2) {
        this.f1584a = bArr;
        this.f1586c = i;
        this.f1585b = i + i2;
    }

    public static fk m2511a(byte[] bArr) {
        return m2512a(bArr, 0, bArr.length);
    }

    public static fk m2512a(byte[] bArr, int i, int i2) {
        return new fk(bArr, i, i2);
    }

    public int m2513a() {
        return this.f1585b - this.f1586c;
    }

    public void m2514a(byte b) {
        if (this.f1586c == this.f1585b) {
            throw new C0807a(this.f1586c, this.f1585b);
        }
        byte[] bArr = this.f1584a;
        int i = this.f1586c;
        this.f1586c = i + 1;
        bArr[i] = b;
    }

    public void m2515a(int i) {
        m2514a((byte) i);
    }

    public void m2516a(int i, int i2) {
        m2521b(fm.m2525a(i, i2));
    }

    public void m2517a(int i, long j) {
        m2516a(i, 0);
        m2519a(j);
    }

    public void m2518a(int i, String str) {
        m2516a(i, 2);
        m2520a(str);
    }

    public void m2519a(long j) {
        m2522b(j);
    }

    public void m2520a(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        m2521b(bytes.length);
        m2523b(bytes);
    }

    public void m2521b(int i) {
        while ((i & -128) != 0) {
            m2515a((i & 127) | 128);
            i >>>= 7;
        }
        m2515a(i);
    }

    public void m2522b(long j) {
        while ((-128 & j) != 0) {
            m2515a((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m2515a((int) j);
    }

    public void m2523b(byte[] bArr) {
        m2524b(bArr, 0, bArr.length);
    }

    public void m2524b(byte[] bArr, int i, int i2) {
        if (this.f1585b - this.f1586c >= i2) {
            System.arraycopy(bArr, i, this.f1584a, this.f1586c, i2);
            this.f1586c += i2;
            return;
        }
        throw new C0807a(this.f1586c, this.f1585b);
    }
}
