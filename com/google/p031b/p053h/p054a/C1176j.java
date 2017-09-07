package com.google.p031b.p053h.p054a;

import com.google.p031b.C1155g;
import com.google.p031b.p034c.C1052b;

public final class C1176j {
    private static final int[] f2535a = new int[]{31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};
    private static final C1176j[] f2536b = C1176j.m4382f();
    private final int f2537c;
    private final int[] f2538d;
    private final C1175b[] f2539e;
    private final int f2540f;

    public static final class C1174a {
        private final int f2531a;
        private final int f2532b;

        C1174a(int i, int i2) {
            this.f2531a = i;
            this.f2532b = i2;
        }

        public int m4373a() {
            return this.f2531a;
        }

        public int m4374b() {
            return this.f2532b;
        }
    }

    public static final class C1175b {
        private final int f2533a;
        private final C1174a[] f2534b;

        C1175b(int i, C1174a... c1174aArr) {
            this.f2533a = i;
            this.f2534b = c1174aArr;
        }

        public int m4375a() {
            return this.f2533a;
        }

        public int m4376b() {
            int i = 0;
            C1174a[] c1174aArr = this.f2534b;
            int i2 = 0;
            while (i < c1174aArr.length) {
                i2 += c1174aArr[i].m4373a();
                i++;
            }
            return i2;
        }

        public int m4377c() {
            return this.f2533a * m4376b();
        }

        public C1174a[] m4378d() {
            return this.f2534b;
        }
    }

    private C1176j(int i, int[] iArr, C1175b... c1175bArr) {
        int i2 = 0;
        this.f2537c = i;
        this.f2538d = iArr;
        this.f2539e = c1175bArr;
        int a = c1175bArr[0].m4375a();
        C1174a[] d = c1175bArr[0].m4378d();
        int length = d.length;
        int i3 = 0;
        while (i2 < length) {
            C1174a c1174a = d[i2];
            i3 += (c1174a.m4374b() + a) * c1174a.m4373a();
            i2++;
        }
        this.f2540f = i3;
    }

    public static C1176j m4379a(int i) {
        if (i % 4 != 1) {
            throw C1155g.m4329a();
        }
        try {
            return C1176j.m4380b((i - 17) >> 2);
        } catch (IllegalArgumentException e) {
            throw C1155g.m4329a();
        }
    }

    public static C1176j m4380b(int i) {
        if (i >= 1 && i <= 40) {
            return f2536b[i - 1];
        }
        throw new IllegalArgumentException();
    }

    static C1176j m4381c(int i) {
        int i2 = 0;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        while (i2 < f2535a.length) {
            int i5 = f2535a[i2];
            if (i5 == i) {
                return C1176j.m4380b(i2 + 7);
            }
            i5 = C1171g.m4364a(i, i5);
            if (i5 < i3) {
                i4 = i2 + 7;
                i3 = i5;
            }
            i2++;
        }
        return i3 <= 3 ? C1176j.m4380b(i4) : null;
    }

    private static C1176j[] m4382f() {
        r0 = new C1176j[40];
        int[] iArr = new int[0];
        C1175b[] c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(7, new C1174a(1, 19));
        c1175bArr[1] = new C1175b(10, new C1174a(1, 16));
        c1175bArr[2] = new C1175b(13, new C1174a(1, 13));
        c1175bArr[3] = new C1175b(17, new C1174a(1, 9));
        r0[0] = new C1176j(1, iArr, c1175bArr);
        iArr = new int[]{6, 18};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(10, new C1174a(1, 34));
        c1175bArr[1] = new C1175b(16, new C1174a(1, 28));
        c1175bArr[2] = new C1175b(22, new C1174a(1, 22));
        c1175bArr[3] = new C1175b(28, new C1174a(1, 16));
        r0[1] = new C1176j(2, iArr, c1175bArr);
        iArr = new int[]{6, 22};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(15, new C1174a(1, 55));
        c1175bArr[1] = new C1175b(26, new C1174a(1, 44));
        c1175bArr[2] = new C1175b(18, new C1174a(2, 17));
        c1175bArr[3] = new C1175b(22, new C1174a(2, 13));
        r0[2] = new C1176j(3, iArr, c1175bArr);
        iArr = new int[]{6, 26};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(20, new C1174a(1, 80));
        c1175bArr[1] = new C1175b(18, new C1174a(2, 32));
        c1175bArr[2] = new C1175b(26, new C1174a(2, 24));
        c1175bArr[3] = new C1175b(16, new C1174a(4, 9));
        r0[3] = new C1176j(4, iArr, c1175bArr);
        iArr = new int[]{6, 30};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(26, new C1174a(1, 108));
        c1175bArr[1] = new C1175b(24, new C1174a(2, 43));
        c1175bArr[2] = new C1175b(18, new C1174a(2, 15), new C1174a(2, 16));
        c1175bArr[3] = new C1175b(22, new C1174a(2, 11), new C1174a(2, 12));
        r0[4] = new C1176j(5, iArr, c1175bArr);
        iArr = new int[]{6, 34};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(18, new C1174a(2, 68));
        c1175bArr[1] = new C1175b(16, new C1174a(4, 27));
        c1175bArr[2] = new C1175b(24, new C1174a(4, 19));
        c1175bArr[3] = new C1175b(28, new C1174a(4, 15));
        r0[5] = new C1176j(6, iArr, c1175bArr);
        iArr = new int[]{6, 22, 38};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(20, new C1174a(2, 78));
        c1175bArr[1] = new C1175b(18, new C1174a(4, 31));
        c1175bArr[2] = new C1175b(18, new C1174a(2, 14), new C1174a(4, 15));
        c1175bArr[3] = new C1175b(26, new C1174a(4, 13), new C1174a(1, 14));
        r0[6] = new C1176j(7, iArr, c1175bArr);
        iArr = new int[]{6, 24, 42};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(24, new C1174a(2, 97));
        c1175bArr[1] = new C1175b(22, new C1174a(2, 38), new C1174a(2, 39));
        c1175bArr[2] = new C1175b(22, new C1174a(4, 18), new C1174a(2, 19));
        c1175bArr[3] = new C1175b(26, new C1174a(4, 14), new C1174a(2, 15));
        r0[7] = new C1176j(8, iArr, c1175bArr);
        iArr = new int[]{6, 26, 46};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(30, new C1174a(2, 116));
        c1175bArr[1] = new C1175b(22, new C1174a(3, 36), new C1174a(2, 37));
        c1175bArr[2] = new C1175b(20, new C1174a(4, 16), new C1174a(4, 17));
        c1175bArr[3] = new C1175b(24, new C1174a(4, 12), new C1174a(4, 13));
        r0[8] = new C1176j(9, iArr, c1175bArr);
        iArr = new int[]{6, 28, 50};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(18, new C1174a(2, 68), new C1174a(2, 69));
        c1175bArr[1] = new C1175b(26, new C1174a(4, 43), new C1174a(1, 44));
        c1175bArr[2] = new C1175b(24, new C1174a(6, 19), new C1174a(2, 20));
        c1175bArr[3] = new C1175b(28, new C1174a(6, 15), new C1174a(2, 16));
        r0[9] = new C1176j(10, iArr, c1175bArr);
        iArr = new int[]{6, 30, 54};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(20, new C1174a(4, 81));
        c1175bArr[1] = new C1175b(30, new C1174a(1, 50), new C1174a(4, 51));
        c1175bArr[2] = new C1175b(28, new C1174a(4, 22), new C1174a(4, 23));
        c1175bArr[3] = new C1175b(24, new C1174a(3, 12), new C1174a(8, 13));
        r0[10] = new C1176j(11, iArr, c1175bArr);
        iArr = new int[]{6, 32, 58};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(24, new C1174a(2, 92), new C1174a(2, 93));
        c1175bArr[1] = new C1175b(22, new C1174a(6, 36), new C1174a(2, 37));
        c1175bArr[2] = new C1175b(26, new C1174a(4, 20), new C1174a(6, 21));
        c1175bArr[3] = new C1175b(28, new C1174a(7, 14), new C1174a(4, 15));
        r0[11] = new C1176j(12, iArr, c1175bArr);
        iArr = new int[]{6, 34, 62};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(26, new C1174a(4, 107));
        c1175bArr[1] = new C1175b(22, new C1174a(8, 37), new C1174a(1, 38));
        c1175bArr[2] = new C1175b(24, new C1174a(8, 20), new C1174a(4, 21));
        c1175bArr[3] = new C1175b(22, new C1174a(12, 11), new C1174a(4, 12));
        r0[12] = new C1176j(13, iArr, c1175bArr);
        iArr = new int[]{6, 26, 46, 66};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(30, new C1174a(3, 115), new C1174a(1, 116));
        c1175bArr[1] = new C1175b(24, new C1174a(4, 40), new C1174a(5, 41));
        c1175bArr[2] = new C1175b(20, new C1174a(11, 16), new C1174a(5, 17));
        c1175bArr[3] = new C1175b(24, new C1174a(11, 12), new C1174a(5, 13));
        r0[13] = new C1176j(14, iArr, c1175bArr);
        iArr = new int[]{6, 26, 48, 70};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(22, new C1174a(5, 87), new C1174a(1, 88));
        c1175bArr[1] = new C1175b(24, new C1174a(5, 41), new C1174a(5, 42));
        c1175bArr[2] = new C1175b(30, new C1174a(5, 24), new C1174a(7, 25));
        c1175bArr[3] = new C1175b(24, new C1174a(11, 12), new C1174a(7, 13));
        r0[14] = new C1176j(15, iArr, c1175bArr);
        iArr = new int[]{6, 26, 50, 74};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(24, new C1174a(5, 98), new C1174a(1, 99));
        c1175bArr[1] = new C1175b(28, new C1174a(7, 45), new C1174a(3, 46));
        c1175bArr[2] = new C1175b(24, new C1174a(15, 19), new C1174a(2, 20));
        c1175bArr[3] = new C1175b(30, new C1174a(3, 15), new C1174a(13, 16));
        r0[15] = new C1176j(16, iArr, c1175bArr);
        iArr = new int[]{6, 30, 54, 78};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(28, new C1174a(1, 107), new C1174a(5, 108));
        c1175bArr[1] = new C1175b(28, new C1174a(10, 46), new C1174a(1, 47));
        c1175bArr[2] = new C1175b(28, new C1174a(1, 22), new C1174a(15, 23));
        c1175bArr[3] = new C1175b(28, new C1174a(2, 14), new C1174a(17, 15));
        r0[16] = new C1176j(17, iArr, c1175bArr);
        iArr = new int[]{6, 30, 56, 82};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(30, new C1174a(5, 120), new C1174a(1, 121));
        c1175bArr[1] = new C1175b(26, new C1174a(9, 43), new C1174a(4, 44));
        c1175bArr[2] = new C1175b(28, new C1174a(17, 22), new C1174a(1, 23));
        c1175bArr[3] = new C1175b(28, new C1174a(2, 14), new C1174a(19, 15));
        r0[17] = new C1176j(18, iArr, c1175bArr);
        iArr = new int[]{6, 30, 58, 86};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(28, new C1174a(3, 113), new C1174a(4, 114));
        c1175bArr[1] = new C1175b(26, new C1174a(3, 44), new C1174a(11, 45));
        c1175bArr[2] = new C1175b(26, new C1174a(17, 21), new C1174a(4, 22));
        c1175bArr[3] = new C1175b(26, new C1174a(9, 13), new C1174a(16, 14));
        r0[18] = new C1176j(19, iArr, c1175bArr);
        iArr = new int[]{6, 34, 62, 90};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(28, new C1174a(3, 107), new C1174a(5, 108));
        c1175bArr[1] = new C1175b(26, new C1174a(3, 41), new C1174a(13, 42));
        c1175bArr[2] = new C1175b(30, new C1174a(15, 24), new C1174a(5, 25));
        c1175bArr[3] = new C1175b(28, new C1174a(15, 15), new C1174a(10, 16));
        r0[19] = new C1176j(20, iArr, c1175bArr);
        iArr = new int[]{6, 28, 50, 72, 94};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(28, new C1174a(4, 116), new C1174a(4, 117));
        c1175bArr[1] = new C1175b(26, new C1174a(17, 42));
        c1175bArr[2] = new C1175b(28, new C1174a(17, 22), new C1174a(6, 23));
        c1175bArr[3] = new C1175b(30, new C1174a(19, 16), new C1174a(6, 17));
        r0[20] = new C1176j(21, iArr, c1175bArr);
        iArr = new int[]{6, 26, 50, 74, 98};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(28, new C1174a(2, 111), new C1174a(7, 112));
        c1175bArr[1] = new C1175b(28, new C1174a(17, 46));
        c1175bArr[2] = new C1175b(30, new C1174a(7, 24), new C1174a(16, 25));
        c1175bArr[3] = new C1175b(24, new C1174a(34, 13));
        r0[21] = new C1176j(22, iArr, c1175bArr);
        iArr = new int[]{6, 30, 54, 78, 102};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(30, new C1174a(4, 121), new C1174a(5, 122));
        c1175bArr[1] = new C1175b(28, new C1174a(4, 47), new C1174a(14, 48));
        c1175bArr[2] = new C1175b(30, new C1174a(11, 24), new C1174a(14, 25));
        c1175bArr[3] = new C1175b(30, new C1174a(16, 15), new C1174a(14, 16));
        r0[22] = new C1176j(23, iArr, c1175bArr);
        iArr = new int[]{6, 28, 54, 80, 106};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(30, new C1174a(6, 117), new C1174a(4, 118));
        c1175bArr[1] = new C1175b(28, new C1174a(6, 45), new C1174a(14, 46));
        c1175bArr[2] = new C1175b(30, new C1174a(11, 24), new C1174a(16, 25));
        c1175bArr[3] = new C1175b(30, new C1174a(30, 16), new C1174a(2, 17));
        r0[23] = new C1176j(24, iArr, c1175bArr);
        iArr = new int[]{6, 32, 58, 84, 110};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(26, new C1174a(8, 106), new C1174a(4, 107));
        c1175bArr[1] = new C1175b(28, new C1174a(8, 47), new C1174a(13, 48));
        c1175bArr[2] = new C1175b(30, new C1174a(7, 24), new C1174a(22, 25));
        c1175bArr[3] = new C1175b(30, new C1174a(22, 15), new C1174a(13, 16));
        r0[24] = new C1176j(25, iArr, c1175bArr);
        iArr = new int[]{6, 30, 58, 86, 114};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(28, new C1174a(10, 114), new C1174a(2, 115));
        c1175bArr[1] = new C1175b(28, new C1174a(19, 46), new C1174a(4, 47));
        c1175bArr[2] = new C1175b(28, new C1174a(28, 22), new C1174a(6, 23));
        c1175bArr[3] = new C1175b(30, new C1174a(33, 16), new C1174a(4, 17));
        r0[25] = new C1176j(26, iArr, c1175bArr);
        iArr = new int[]{6, 34, 62, 90, 118};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(30, new C1174a(8, 122), new C1174a(4, 123));
        c1175bArr[1] = new C1175b(28, new C1174a(22, 45), new C1174a(3, 46));
        c1175bArr[2] = new C1175b(30, new C1174a(8, 23), new C1174a(26, 24));
        c1175bArr[3] = new C1175b(30, new C1174a(12, 15), new C1174a(28, 16));
        r0[26] = new C1176j(27, iArr, c1175bArr);
        iArr = new int[]{6, 26, 50, 74, 98, 122};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(30, new C1174a(3, 117), new C1174a(10, 118));
        c1175bArr[1] = new C1175b(28, new C1174a(3, 45), new C1174a(23, 46));
        c1175bArr[2] = new C1175b(30, new C1174a(4, 24), new C1174a(31, 25));
        c1175bArr[3] = new C1175b(30, new C1174a(11, 15), new C1174a(31, 16));
        r0[27] = new C1176j(28, iArr, c1175bArr);
        iArr = new int[]{6, 30, 54, 78, 102, 126};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(30, new C1174a(7, 116), new C1174a(7, 117));
        c1175bArr[1] = new C1175b(28, new C1174a(21, 45), new C1174a(7, 46));
        c1175bArr[2] = new C1175b(30, new C1174a(1, 23), new C1174a(37, 24));
        c1175bArr[3] = new C1175b(30, new C1174a(19, 15), new C1174a(26, 16));
        r0[28] = new C1176j(29, iArr, c1175bArr);
        iArr = new int[]{6, 26, 52, 78, 104, 130};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(30, new C1174a(5, 115), new C1174a(10, 116));
        c1175bArr[1] = new C1175b(28, new C1174a(19, 47), new C1174a(10, 48));
        c1175bArr[2] = new C1175b(30, new C1174a(15, 24), new C1174a(25, 25));
        c1175bArr[3] = new C1175b(30, new C1174a(23, 15), new C1174a(25, 16));
        r0[29] = new C1176j(30, iArr, c1175bArr);
        iArr = new int[]{6, 30, 56, 82, 108, 134};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(30, new C1174a(13, 115), new C1174a(3, 116));
        c1175bArr[1] = new C1175b(28, new C1174a(2, 46), new C1174a(29, 47));
        c1175bArr[2] = new C1175b(30, new C1174a(42, 24), new C1174a(1, 25));
        c1175bArr[3] = new C1175b(30, new C1174a(23, 15), new C1174a(28, 16));
        r0[30] = new C1176j(31, iArr, c1175bArr);
        iArr = new int[]{6, 34, 60, 86, 112, 138};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(30, new C1174a(17, 115));
        c1175bArr[1] = new C1175b(28, new C1174a(10, 46), new C1174a(23, 47));
        c1175bArr[2] = new C1175b(30, new C1174a(10, 24), new C1174a(35, 25));
        c1175bArr[3] = new C1175b(30, new C1174a(19, 15), new C1174a(35, 16));
        r0[31] = new C1176j(32, iArr, c1175bArr);
        iArr = new int[]{6, 30, 58, 86, 114, 142};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(30, new C1174a(17, 115), new C1174a(1, 116));
        c1175bArr[1] = new C1175b(28, new C1174a(14, 46), new C1174a(21, 47));
        c1175bArr[2] = new C1175b(30, new C1174a(29, 24), new C1174a(19, 25));
        c1175bArr[3] = new C1175b(30, new C1174a(11, 15), new C1174a(46, 16));
        r0[32] = new C1176j(33, iArr, c1175bArr);
        iArr = new int[]{6, 34, 62, 90, 118, 146};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(30, new C1174a(13, 115), new C1174a(6, 116));
        c1175bArr[1] = new C1175b(28, new C1174a(14, 46), new C1174a(23, 47));
        c1175bArr[2] = new C1175b(30, new C1174a(44, 24), new C1174a(7, 25));
        c1175bArr[3] = new C1175b(30, new C1174a(59, 16), new C1174a(1, 17));
        r0[33] = new C1176j(34, iArr, c1175bArr);
        iArr = new int[]{6, 30, 54, 78, 102, 126, 150};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(30, new C1174a(12, 121), new C1174a(7, 122));
        c1175bArr[1] = new C1175b(28, new C1174a(12, 47), new C1174a(26, 48));
        c1175bArr[2] = new C1175b(30, new C1174a(39, 24), new C1174a(14, 25));
        c1175bArr[3] = new C1175b(30, new C1174a(22, 15), new C1174a(41, 16));
        r0[34] = new C1176j(35, iArr, c1175bArr);
        iArr = new int[]{6, 24, 50, 76, 102, 128, 154};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(30, new C1174a(6, 121), new C1174a(14, 122));
        c1175bArr[1] = new C1175b(28, new C1174a(6, 47), new C1174a(34, 48));
        c1175bArr[2] = new C1175b(30, new C1174a(46, 24), new C1174a(10, 25));
        c1175bArr[3] = new C1175b(30, new C1174a(2, 15), new C1174a(64, 16));
        r0[35] = new C1176j(36, iArr, c1175bArr);
        iArr = new int[]{6, 28, 54, 80, 106, 132, 158};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(30, new C1174a(17, 122), new C1174a(4, 123));
        c1175bArr[1] = new C1175b(28, new C1174a(29, 46), new C1174a(14, 47));
        c1175bArr[2] = new C1175b(30, new C1174a(49, 24), new C1174a(10, 25));
        c1175bArr[3] = new C1175b(30, new C1174a(24, 15), new C1174a(46, 16));
        r0[36] = new C1176j(37, iArr, c1175bArr);
        iArr = new int[]{6, 32, 58, 84, 110, 136, 162};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(30, new C1174a(4, 122), new C1174a(18, 123));
        c1175bArr[1] = new C1175b(28, new C1174a(13, 46), new C1174a(32, 47));
        c1175bArr[2] = new C1175b(30, new C1174a(48, 24), new C1174a(14, 25));
        c1175bArr[3] = new C1175b(30, new C1174a(42, 15), new C1174a(32, 16));
        r0[37] = new C1176j(38, iArr, c1175bArr);
        iArr = new int[]{6, 26, 54, 82, 110, 138, 166};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(30, new C1174a(20, 117), new C1174a(4, 118));
        c1175bArr[1] = new C1175b(28, new C1174a(40, 47), new C1174a(7, 48));
        c1175bArr[2] = new C1175b(30, new C1174a(43, 24), new C1174a(22, 25));
        c1175bArr[3] = new C1175b(30, new C1174a(10, 15), new C1174a(67, 16));
        r0[38] = new C1176j(39, iArr, c1175bArr);
        iArr = new int[]{6, 30, 58, 86, 114, 142, 170};
        c1175bArr = new C1175b[4];
        c1175bArr[0] = new C1175b(30, new C1174a(19, 118), new C1174a(6, 119));
        c1175bArr[1] = new C1175b(28, new C1174a(18, 47), new C1174a(31, 48));
        c1175bArr[2] = new C1175b(30, new C1174a(34, 24), new C1174a(34, 25));
        c1175bArr[3] = new C1175b(30, new C1174a(20, 15), new C1174a(61, 16));
        r0[39] = new C1176j(40, iArr, c1175bArr);
        return r0;
    }

    public int m4383a() {
        return this.f2537c;
    }

    public C1175b m4384a(C1170f c1170f) {
        return this.f2539e[c1170f.ordinal()];
    }

    public int[] m4385b() {
        return this.f2538d;
    }

    public int m4386c() {
        return this.f2540f;
    }

    public int m4387d() {
        return (this.f2537c * 4) + 17;
    }

    C1052b m4388e() {
        int d = m4387d();
        C1052b c1052b = new C1052b(d);
        c1052b.m3847a(0, 0, 9, 9);
        c1052b.m3847a(d - 8, 0, 8, 9);
        c1052b.m3847a(0, d - 8, 9, 8);
        int length = this.f2538d.length;
        int i = 0;
        while (i < length) {
            int i2 = this.f2538d[i] - 2;
            int i3 = 0;
            while (i3 < length) {
                if (!((i == 0 && (i3 == 0 || i3 == length - 1)) || (i == length - 1 && i3 == 0))) {
                    c1052b.m3847a(this.f2538d[i3] - 2, i2, 5, 5);
                }
                i3++;
            }
            i++;
        }
        c1052b.m3847a(6, 9, 1, d - 17);
        c1052b.m3847a(9, 6, d - 17, 1);
        if (this.f2537c > 6) {
            c1052b.m3847a(d - 11, 0, 3, 6);
            c1052b.m3847a(0, d - 11, 6, 3);
        }
        return c1052b;
    }

    public String toString() {
        return String.valueOf(this.f2537c);
    }
}
