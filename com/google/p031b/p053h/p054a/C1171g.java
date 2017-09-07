package com.google.p031b.p053h.p054a;

final class C1171g {
    private static final int[][] f2513a = new int[][]{new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};
    private static final int[] f2514b = new int[]{0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};
    private final C1170f f2515c;
    private final byte f2516d;

    private C1171g(int i) {
        this.f2515c = C1170f.m4362a((i >> 3) & 3);
        this.f2516d = (byte) (i & 7);
    }

    static int m4364a(int i, int i2) {
        int i3 = i ^ i2;
        return f2514b[(i3 >>> 28) & 15] + ((((((f2514b[i3 & 15] + f2514b[(i3 >>> 4) & 15]) + f2514b[(i3 >>> 8) & 15]) + f2514b[(i3 >>> 12) & 15]) + f2514b[(i3 >>> 16) & 15]) + f2514b[(i3 >>> 20) & 15]) + f2514b[(i3 >>> 24) & 15]);
    }

    static C1171g m4365b(int i, int i2) {
        C1171g c = C1171g.m4366c(i, i2);
        return c != null ? c : C1171g.m4366c(i ^ 21522, i2 ^ 21522);
    }

    private static C1171g m4366c(int i, int i2) {
        int i3 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[][] iArr = f2513a;
        int length = iArr.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int[] iArr2 = iArr[i4];
            int i6 = iArr2[0];
            if (i6 == i || i6 == i2) {
                return new C1171g(iArr2[1]);
            }
            int i7;
            int a = C1171g.m4364a(i, i6);
            if (a < i3) {
                i3 = iArr2[1];
            } else {
                a = i3;
                i3 = i5;
            }
            if (i != i2) {
                i5 = C1171g.m4364a(i2, i6);
                if (i5 < a) {
                    i3 = iArr2[1];
                    i4++;
                    i7 = i3;
                    i3 = i5;
                    i5 = i7;
                }
            }
            i5 = a;
            i4++;
            i7 = i3;
            i3 = i5;
            i5 = i7;
        }
        return i3 <= 3 ? new C1171g(i5) : null;
    }

    C1170f m4367a() {
        return this.f2515c;
    }

    byte m4368b() {
        return this.f2516d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1171g)) {
            return false;
        }
        C1171g c1171g = (C1171g) obj;
        return this.f2515c == c1171g.f2515c && this.f2516d == c1171g.f2516d;
    }

    public int hashCode() {
        return (this.f2515c.ordinal() << 3) | this.f2516d;
    }
}
