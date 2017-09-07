package com.google.p031b.p040d.p041a;

import com.google.p031b.C1155g;
import com.google.p031b.p034c.C1052b;

final class C1063a {
    private final C1052b f2248a;
    private final C1052b f2249b;
    private final C1072e f2250c;

    C1063a(C1052b c1052b) {
        int e = c1052b.m3856e();
        if (e < 8 || e > 144 || (e & 1) != 0) {
            throw C1155g.m4329a();
        }
        this.f2250c = C1063a.m3902b(c1052b);
        this.f2248a = m3904a(c1052b);
        this.f2249b = new C1052b(this.f2248a.m3855d(), this.f2248a.m3856e());
    }

    private static C1072e m3902b(C1052b c1052b) {
        return C1072e.m3930a(c1052b.m3856e(), c1052b.m3855d());
    }

    int m3903a(int i, int i2) {
        int i3 = (m3906a(i + -1, 0, i, i2) ? 1 : 0) << 1;
        if (m3906a(i - 1, 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m3906a(i - 1, 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m3906a(0, i2 - 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m3906a(0, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m3906a(1, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m3906a(2, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        return m3906a(3, i2 + -1, i, i2) ? i3 | 1 : i3;
    }

    C1052b m3904a(C1052b c1052b) {
        int b = this.f2250c.m3933b();
        int c = this.f2250c.m3934c();
        if (c1052b.m3856e() != b) {
            throw new IllegalArgumentException("Dimension of bitMarix must match the version size");
        }
        int d = this.f2250c.m3935d();
        int e = this.f2250c.m3936e();
        int i = b / d;
        int i2 = c / e;
        C1052b c1052b2 = new C1052b(i2 * e, i * d);
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = i3 * d;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = i5 * e;
                for (c = 0; c < d; c++) {
                    int i7 = (((d + 2) * i3) + 1) + c;
                    int i8 = i4 + c;
                    for (b = 0; b < e; b++) {
                        if (c1052b.m3848a((((e + 2) * i5) + 1) + b, i7)) {
                            c1052b2.m3850b(i6 + b, i8);
                        }
                    }
                }
            }
        }
        return c1052b2;
    }

    C1072e m3905a() {
        return this.f2250c;
    }

    boolean m3906a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (i < 0) {
            i5 = i + i3;
            i6 = (4 - ((i3 + 4) & 7)) + i2;
        } else {
            i6 = i2;
            i5 = i;
        }
        if (i6 < 0) {
            i6 += i4;
            i5 += 4 - ((i4 + 4) & 7);
        }
        this.f2249b.m3850b(i6, i5);
        return this.f2248a.m3848a(i6, i5);
    }

    int m3907b(int i, int i2) {
        int i3 = (m3906a(i + -3, 0, i, i2) ? 1 : 0) << 1;
        if (m3906a(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m3906a(i - 1, 0, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m3906a(0, i2 - 4, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m3906a(0, i2 - 3, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m3906a(0, i2 - 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m3906a(0, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        return m3906a(1, i2 + -1, i, i2) ? i3 | 1 : i3;
    }

    int m3908b(int i, int i2, int i3, int i4) {
        int i5 = 0;
        if (m3906a(i - 2, i2 - 2, i3, i4)) {
            i5 = 1;
        }
        i5 <<= 1;
        if (m3906a(i - 2, i2 - 1, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (m3906a(i - 1, i2 - 2, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (m3906a(i - 1, i2 - 1, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (m3906a(i - 1, i2, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (m3906a(i, i2 - 2, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (m3906a(i, i2 - 1, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        return m3906a(i, i2, i3, i4) ? i5 | 1 : i5;
    }

    byte[] m3909b() {
        Object obj = null;
        byte[] bArr = new byte[this.f2250c.m3937f()];
        int e = this.f2248a.m3856e();
        int d = this.f2248a.m3855d();
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        int i = 0;
        int i2 = 4;
        int i3 = 0;
        while (true) {
            int i4;
            if (i2 == e && i == 0 && r4 == null) {
                i4 = i3 + 1;
                bArr[i3] = (byte) m3903a(e, d);
                int i5 = i + 2;
                i = i4;
                i4 = i2 - 2;
                i2 = i5;
                obj4 = 1;
            } else if (i2 == e - 2 && i == 0 && (d & 3) != 0 && r3 == null) {
                i4 = i3 + 1;
                bArr[i3] = (byte) m3907b(e, d);
                int i6 = i + 2;
                i = i4;
                i4 = i2 - 2;
                i2 = i6;
                i6 = 1;
            } else if (i2 == e + 4 && i == 2 && (d & 7) == 0 && r2 == null) {
                i4 = i3 + 1;
                bArr[i3] = (byte) m3910c(e, d);
                int i7 = i + 2;
                i = i4;
                i4 = i2 - 2;
                i2 = i7;
                i7 = 1;
            } else if (i2 == e - 2 && i == 0 && (d & 7) == 4 && r0 == null) {
                i4 = i3 + 1;
                bArr[i3] = (byte) m3911d(e, d);
                int i8 = i + 2;
                i = i4;
                i4 = i2 - 2;
                i2 = i8;
                i8 = 1;
            } else {
                i4 = i;
                int i9 = i2;
                i2 = i3;
                i3 = i9;
                while (true) {
                    if (i3 >= e || i4 < 0 || this.f2249b.m3848a(i4, i3)) {
                        i = i2;
                    } else {
                        i = i2 + 1;
                        bArr[i2] = (byte) m3908b(i3, i4, e, d);
                    }
                    i3 -= 2;
                    i2 = i4 + 2;
                    if (i3 < 0 || i2 >= d) {
                        i3++;
                        i4 = i2 + 3;
                        i2 = i;
                    } else {
                        i4 = i2;
                        i2 = i;
                    }
                }
                i3++;
                i4 = i2 + 3;
                i2 = i;
                while (true) {
                    if (i3 < 0 || i4 >= d || this.f2249b.m3848a(i4, i3)) {
                        i = i2;
                    } else {
                        i = i2 + 1;
                        bArr[i2] = (byte) m3908b(i3, i4, e, d);
                    }
                    i3 += 2;
                    i2 = i4 - 2;
                    if (i3 >= e || i2 < 0) {
                        i4 = i3 + 3;
                        i2++;
                    } else {
                        i4 = i2;
                        i2 = i;
                    }
                }
                i4 = i3 + 3;
                i2++;
            }
            if (i4 >= e && i2 >= d) {
                break;
            }
            i3 = i;
            i = i2;
            i2 = i4;
        }
        if (i == this.f2250c.m3937f()) {
            return bArr;
        }
        throw C1155g.m4329a();
    }

    int m3910c(int i, int i2) {
        int i3 = (m3906a(i + -1, 0, i, i2) ? 1 : 0) << 1;
        if (m3906a(i - 1, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m3906a(0, i2 - 3, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m3906a(0, i2 - 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m3906a(0, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m3906a(1, i2 - 3, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m3906a(1, i2 - 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        return m3906a(1, i2 + -1, i, i2) ? i3 | 1 : i3;
    }

    int m3911d(int i, int i2) {
        int i3 = (m3906a(i + -3, 0, i, i2) ? 1 : 0) << 1;
        if (m3906a(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m3906a(i - 1, 0, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m3906a(0, i2 - 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m3906a(0, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m3906a(1, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m3906a(2, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        return m3906a(3, i2 + -1, i, i2) ? i3 | 1 : i3;
    }
}
