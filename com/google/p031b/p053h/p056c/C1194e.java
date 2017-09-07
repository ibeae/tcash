package com.google.p031b.p053h.p056c;

import com.google.p031b.C1202q;
import com.google.p031b.p034c.C1046a;
import com.google.p031b.p053h.p054a.C1170f;
import com.google.p031b.p053h.p054a.C1176j;

final class C1194e {
    private static final int[][] f2576a = new int[][]{new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] f2577b = new int[][]{new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    private static final int[][] f2578c = new int[][]{new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};
    private static final int[][] f2579d = new int[][]{new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    static int m4472a(int i) {
        int i2 = 0;
        while (i != 0) {
            i >>>= 1;
            i2++;
        }
        return i2;
    }

    static int m4473a(int i, int i2) {
        int a = C1194e.m4472a(i2);
        int i3 = i << (a - 1);
        while (C1194e.m4472a(i3) >= a) {
            i3 ^= i2 << (C1194e.m4472a(i3) - a);
        }
        return i3;
    }

    private static void m4474a(int i, int i2, C1190b c1190b) {
        int i3 = 0;
        while (i3 < 8) {
            if (C1194e.m4485b(c1190b.m4438a(i + i3, i2))) {
                c1190b.m4441a(i + i3, i2, 0);
                i3++;
            } else {
                throw new C1202q();
            }
        }
    }

    static void m4475a(C1046a c1046a, int i, C1190b c1190b) {
        int b = c1190b.m4443b() - 1;
        int a = c1190b.m4439a() - 1;
        int i2 = -1;
        int i3 = 0;
        while (b > 0) {
            int i4;
            int i5;
            if (b == 6) {
                i4 = a;
                i5 = b - 1;
                a = i3;
            } else {
                i4 = a;
                i5 = b;
                a = i3;
            }
            while (i4 >= 0 && i4 < c1190b.m4439a()) {
                for (i3 = 0; i3 < 2; i3++) {
                    int i6 = i5 - i3;
                    if (C1194e.m4485b(c1190b.m4438a(i6, i4))) {
                        boolean a2;
                        if (a < c1046a.m3802a()) {
                            b = a + 1;
                            a2 = c1046a.m3807a(a);
                        } else {
                            b = a;
                            a2 = false;
                        }
                        if (i != -1 && C1193d.m4466a(i, i6, i4)) {
                            a2 = !a2;
                        }
                        c1190b.m4442a(i6, i4, a2);
                        a = b;
                    }
                }
                i4 += i2;
            }
            i2 = -i2;
            b = i5 - 2;
            i3 = a;
            a = i4 + i2;
        }
        if (i3 != c1046a.m3802a()) {
            throw new C1202q("Not all bits consumed: " + i3 + '/' + c1046a.m3802a());
        }
    }

    static void m4476a(C1046a c1046a, C1170f c1170f, C1176j c1176j, int i, C1190b c1190b) {
        C1194e.m4481a(c1190b);
        C1194e.m4480a(c1176j, c1190b);
        C1194e.m4478a(c1170f, i, c1190b);
        C1194e.m4483b(c1176j, c1190b);
        C1194e.m4475a(c1046a, i, c1190b);
    }

    static void m4477a(C1170f c1170f, int i, C1046a c1046a) {
        if (C1195f.m4491b(i)) {
            int a = (c1170f.m4363a() << 3) | i;
            c1046a.m3811b(a, 5);
            c1046a.m3811b(C1194e.m4473a(a, 1335), 10);
            C1046a c1046a2 = new C1046a();
            c1046a2.m3811b(21522, 15);
            c1046a.m3812b(c1046a2);
            if (c1046a.m3802a() != 15) {
                throw new C1202q("should not happen but we got: " + c1046a.m3802a());
            }
            return;
        }
        throw new C1202q("Invalid mask pattern");
    }

    static void m4478a(C1170f c1170f, int i, C1190b c1190b) {
        C1046a c1046a = new C1046a();
        C1194e.m4477a(c1170f, i, c1046a);
        for (int i2 = 0; i2 < c1046a.m3802a(); i2++) {
            boolean a = c1046a.m3807a((c1046a.m3802a() - 1) - i2);
            c1190b.m4442a(f2579d[i2][0], f2579d[i2][1], a);
            if (i2 < 8) {
                c1190b.m4442a((c1190b.m4443b() - i2) - 1, 8, a);
            } else {
                c1190b.m4442a(8, (c1190b.m4439a() - 7) + (i2 - 8), a);
            }
        }
    }

    static void m4479a(C1176j c1176j, C1046a c1046a) {
        c1046a.m3811b(c1176j.m4383a(), 6);
        c1046a.m3811b(C1194e.m4473a(c1176j.m4383a(), 7973), 12);
        if (c1046a.m3802a() != 18) {
            throw new C1202q("should not happen but we got: " + c1046a.m3802a());
        }
    }

    static void m4480a(C1176j c1176j, C1190b c1190b) {
        C1194e.m4490d(c1190b);
        C1194e.m4488c(c1190b);
        C1194e.m4487c(c1176j, c1190b);
        C1194e.m4484b(c1190b);
    }

    static void m4481a(C1190b c1190b) {
        c1190b.m4440a((byte) -1);
    }

    private static void m4482b(int i, int i2, C1190b c1190b) {
        int i3 = 0;
        while (i3 < 7) {
            if (C1194e.m4485b(c1190b.m4438a(i, i2 + i3))) {
                c1190b.m4441a(i, i2 + i3, 0);
                i3++;
            } else {
                throw new C1202q();
            }
        }
    }

    static void m4483b(C1176j c1176j, C1190b c1190b) {
        if (c1176j.m4383a() >= 7) {
            C1046a c1046a = new C1046a();
            C1194e.m4479a(c1176j, c1046a);
            int i = 17;
            int i2 = 0;
            while (i2 < 6) {
                int i3 = i;
                for (i = 0; i < 3; i++) {
                    boolean a = c1046a.m3807a(i3);
                    i3--;
                    c1190b.m4442a(i2, (c1190b.m4439a() - 11) + i, a);
                    c1190b.m4442a((c1190b.m4439a() - 11) + i, i2, a);
                }
                i2++;
                i = i3;
            }
        }
    }

    private static void m4484b(C1190b c1190b) {
        for (int i = 8; i < c1190b.m4443b() - 8; i++) {
            int i2 = (i + 1) % 2;
            if (C1194e.m4485b(c1190b.m4438a(i, 6))) {
                c1190b.m4441a(i, 6, i2);
            }
            if (C1194e.m4485b(c1190b.m4438a(6, i))) {
                c1190b.m4441a(6, i, i2);
            }
        }
    }

    private static boolean m4485b(int i) {
        return i == -1;
    }

    private static void m4486c(int i, int i2, C1190b c1190b) {
        for (int i3 = 0; i3 < 5; i3++) {
            for (int i4 = 0; i4 < 5; i4++) {
                c1190b.m4441a(i + i4, i2 + i3, f2577b[i3][i4]);
            }
        }
    }

    private static void m4487c(C1176j c1176j, C1190b c1190b) {
        if (c1176j.m4383a() >= 2) {
            int a = c1176j.m4383a() - 1;
            int[] iArr = f2578c[a];
            int length = f2578c[a].length;
            for (int i = 0; i < length; i++) {
                for (a = 0; a < length; a++) {
                    int i2 = iArr[i];
                    int i3 = iArr[a];
                    if (!(i3 == -1 || i2 == -1 || !C1194e.m4485b(c1190b.m4438a(i3, i2)))) {
                        C1194e.m4486c(i3 - 2, i2 - 2, c1190b);
                    }
                }
            }
        }
    }

    private static void m4488c(C1190b c1190b) {
        if (c1190b.m4438a(8, c1190b.m4439a() - 8) == (byte) 0) {
            throw new C1202q();
        }
        c1190b.m4441a(8, c1190b.m4439a() - 8, 1);
    }

    private static void m4489d(int i, int i2, C1190b c1190b) {
        for (int i3 = 0; i3 < 7; i3++) {
            for (int i4 = 0; i4 < 7; i4++) {
                c1190b.m4441a(i + i4, i2 + i3, f2576a[i3][i4]);
            }
        }
    }

    private static void m4490d(C1190b c1190b) {
        int length = f2576a[0].length;
        C1194e.m4489d(0, 0, c1190b);
        C1194e.m4489d(c1190b.m4443b() - length, 0, c1190b);
        C1194e.m4489d(0, c1190b.m4443b() - length, c1190b);
        C1194e.m4474a(0, 7, c1190b);
        C1194e.m4474a(c1190b.m4443b() - 8, 7, c1190b);
        C1194e.m4474a(0, c1190b.m4443b() - 8, c1190b);
        C1194e.m4482b(7, 0, c1190b);
        C1194e.m4482b((c1190b.m4439a() - 7) - 1, 0, c1190b);
        C1194e.m4482b(7, c1190b.m4439a() - 7, c1190b);
    }
}
