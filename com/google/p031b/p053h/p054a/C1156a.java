package com.google.p031b.p053h.p054a;

import com.google.p031b.C1155g;
import com.google.p031b.p034c.C1052b;

final class C1156a {
    private final C1052b f2497a;
    private C1176j f2498b;
    private C1171g f2499c;
    private boolean f2500d;

    C1156a(C1052b c1052b) {
        int e = c1052b.m3856e();
        if (e < 21 || (e & 3) != 1) {
            throw C1155g.m4329a();
        }
        this.f2497a = c1052b;
    }

    private int m4330a(int i, int i2, int i3) {
        return this.f2500d ? this.f2497a.m3848a(i2, i) : this.f2497a.m3848a(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    C1171g m4331a() {
        int i = 0;
        if (this.f2499c != null) {
            return this.f2499c;
        }
        int i2;
        int i3 = 0;
        for (i2 = 0; i2 < 6; i2++) {
            i3 = m4330a(i2, 8, i3);
        }
        i3 = m4330a(8, 7, m4330a(8, 8, m4330a(7, 8, i3)));
        for (i2 = 5; i2 >= 0; i2--) {
            i3 = m4330a(8, i2, i3);
        }
        int e = this.f2497a.m3856e();
        int i4 = e - 7;
        for (i2 = e - 1; i2 >= i4; i2--) {
            i = m4330a(8, i2, i);
        }
        for (i2 = e - 8; i2 < e; i2++) {
            i = m4330a(i2, 8, i);
        }
        this.f2499c = C1171g.m4365b(i3, i);
        if (this.f2499c != null) {
            return this.f2499c;
        }
        throw C1155g.m4329a();
    }

    void m4332a(boolean z) {
        this.f2498b = null;
        this.f2499c = null;
        this.f2500d = z;
    }

    C1176j m4333b() {
        if (this.f2498b != null) {
            return this.f2498b;
        }
        int e = this.f2497a.m3856e();
        int i = (e - 17) >> 2;
        if (i <= 6) {
            return C1176j.m4380b(i);
        }
        int i2 = e - 11;
        int i3 = 0;
        for (int i4 = 5; i4 >= 0; i4--) {
            for (i = e - 9; i >= i2; i--) {
                i3 = m4330a(i, i4, i3);
            }
        }
        C1176j c = C1176j.m4381c(i3);
        if (c == null || c.m4387d() != e) {
            int i5 = 0;
            for (int i6 = 5; i6 >= 0; i6--) {
                for (i = e - 9; i >= i2; i--) {
                    i5 = m4330a(i6, i, i5);
                }
            }
            c = C1176j.m4381c(i5);
            if (c == null || c.m4387d() != e) {
                throw C1155g.m4329a();
            }
            this.f2498b = c;
            return c;
        }
        this.f2498b = c;
        return c;
    }

    byte[] m4334c() {
        C1171g a = m4331a();
        C1176j b = m4333b();
        C1159c a2 = C1159c.m4340a(a.m4368b());
        int e = this.f2497a.m3856e();
        a2.m4341a(this.f2497a, e);
        C1052b e2 = b.m4388e();
        byte[] bArr = new byte[b.m4386c()];
        int i = e - 1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (i > 0) {
            if (i == 6) {
                i--;
            }
            int i6 = 0;
            while (i6 < e) {
                int i7 = i5 != 0 ? (e - 1) - i6 : i6;
                for (int i8 = 0; i8 < 2; i8++) {
                    if (!e2.m3848a(i - i8, i7)) {
                        i2++;
                        i3 <<= 1;
                        if (this.f2497a.m3848a(i - i8, i7)) {
                            i3 |= 1;
                        }
                        if (i2 == 8) {
                            i2 = i4 + 1;
                            bArr[i4] = (byte) i3;
                            i3 = 0;
                            i4 = i2;
                            i2 = 0;
                        }
                    }
                }
                i6++;
            }
            i -= 2;
            i5 ^= 1;
        }
        if (i4 == b.m4386c()) {
            return bArr;
        }
        throw C1155g.m4329a();
    }

    void m4335d() {
        if (this.f2499c != null) {
            C1159c.m4340a(this.f2499c.m4368b()).m4341a(this.f2497a, this.f2497a.m3856e());
        }
    }

    void m4336e() {
        for (int i = 0; i < this.f2497a.m3855d(); i++) {
            for (int i2 = i + 1; i2 < this.f2497a.m3856e(); i2++) {
                if (this.f2497a.m3848a(i, i2) != this.f2497a.m3848a(i2, i)) {
                    this.f2497a.m3853c(i2, i);
                    this.f2497a.m3853c(i, i2);
                }
            }
        }
    }
}
