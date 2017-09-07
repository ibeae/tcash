package com.google.p031b.p053h.p056c;

import java.lang.reflect.Array;

public final class C1190b {
    private final byte[][] f2571a;
    private final int f2572b;
    private final int f2573c;

    public C1190b(int i, int i2) {
        this.f2571a = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{i2, i});
        this.f2572b = i;
        this.f2573c = i2;
    }

    public byte m4438a(int i, int i2) {
        return this.f2571a[i2][i];
    }

    public int m4439a() {
        return this.f2573c;
    }

    public void m4440a(byte b) {
        for (int i = 0; i < this.f2573c; i++) {
            for (int i2 = 0; i2 < this.f2572b; i2++) {
                this.f2571a[i][i2] = b;
            }
        }
    }

    public void m4441a(int i, int i2, int i3) {
        this.f2571a[i2][i] = (byte) i3;
    }

    public void m4442a(int i, int i2, boolean z) {
        this.f2571a[i2][i] = (byte) (z ? 1 : 0);
    }

    public int m4443b() {
        return this.f2572b;
    }

    public byte[][] m4444c() {
        return this.f2571a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(((this.f2572b * 2) * this.f2573c) + 2);
        for (int i = 0; i < this.f2573c; i++) {
            for (int i2 = 0; i2 < this.f2572b; i2++) {
                switch (this.f2571a[i][i2]) {
                    case (byte) 0:
                        stringBuilder.append(" 0");
                        break;
                    case (byte) 1:
                        stringBuilder.append(" 1");
                        break;
                    default:
                        stringBuilder.append("  ");
                        break;
                }
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
