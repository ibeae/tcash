package com.google.p031b.p034c;

import com.google.p031b.C1043b;
import com.google.p031b.C1196h;
import java.lang.reflect.Array;

public final class C1059j extends C1058h {
    private C1052b f2234a;

    public C1059j(C1196h c1196h) {
        super(c1196h);
    }

    private static int m3883a(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    private static void m3884a(byte[] bArr, int i, int i2, int i3, int i4, C1052b c1052b) {
        int i5 = (i2 * i4) + i;
        int i6 = 0;
        while (i6 < 8) {
            for (int i7 = 0; i7 < 8; i7++) {
                if ((bArr[i5 + i7] & 255) <= i3) {
                    c1052b.m3850b(i + i7, i2 + i6);
                }
            }
            i6++;
            i5 += i4;
        }
    }

    private static void m3885a(byte[] bArr, int i, int i2, int i3, int i4, int[][] iArr, C1052b c1052b) {
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = i5 << 3;
            int i7 = i4 - 8;
            if (i6 <= i7) {
                i7 = i6;
            }
            for (int i8 = 0; i8 < i; i8++) {
                i6 = i8 << 3;
                int i9 = i3 - 8;
                if (i6 <= i9) {
                    i9 = i6;
                }
                int a = C1059j.m3883a(i8, 2, i - 3);
                int a2 = C1059j.m3883a(i5, 2, i2 - 3);
                int i10 = 0;
                for (i6 = -2; i6 <= 2; i6++) {
                    int[] iArr2 = iArr[a2 + i6];
                    i10 += iArr2[a + 2] + (((iArr2[a - 2] + iArr2[a - 1]) + iArr2[a]) + iArr2[a + 1]);
                }
                C1059j.m3884a(bArr, i9, i7, i10 / 25, i3, c1052b);
            }
        }
    }

    private static int[][] m3886a(byte[] bArr, int i, int i2, int i3, int i4) {
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i2, i});
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = i5 << 3;
            int i7 = i4 - 8;
            if (i6 <= i7) {
                i7 = i6;
            }
            int i8 = 0;
            while (i8 < i) {
                int i9 = i8 << 3;
                i6 = i3 - 8;
                if (i9 <= i6) {
                    i6 = i9;
                }
                int i10 = 0;
                int i11 = 255;
                i9 = 0;
                int i12 = 0;
                int i13 = (i7 * i3) + i6;
                while (i12 < 8) {
                    int i14 = 0;
                    while (i14 < 8) {
                        i6 = bArr[i13 + i14] & 255;
                        int i15 = i10 + i6;
                        i10 = i6 < i11 ? i6 : i11;
                        if (i6 <= i9) {
                            i6 = i9;
                        }
                        i14++;
                        i11 = i10;
                        i9 = i6;
                        i10 = i15;
                    }
                    if (i9 - i11 > 24) {
                        i6 = i13 + i3;
                        i13 = i12 + 1;
                        i12 = i10;
                        while (i13 < 8) {
                            i10 = i12;
                            for (i12 = 0; i12 < 8; i12++) {
                                i10 += bArr[i6 + i12] & 255;
                            }
                            i13++;
                            i6 += i3;
                            i12 = i10;
                        }
                    } else {
                        i6 = i13;
                        i13 = i12;
                        i12 = i10;
                    }
                    i10 = i13 + 1;
                    i13 = i6 + i3;
                    int i16 = i10;
                    i10 = i12;
                    i12 = i16;
                }
                i6 = i10 >> 6;
                if (i9 - i11 <= 24) {
                    i9 = i11 >> 1;
                    if (i5 > 0 && i8 > 0) {
                        i6 = ((iArr[i5 - 1][i8] + (iArr[i5][i8 - 1] * 2)) + iArr[i5 - 1][i8 - 1]) >> 2;
                        if (i11 < i6) {
                        }
                    }
                    i6 = i9;
                }
                iArr[i5][i8] = i6;
                i8++;
            }
        }
        return iArr;
    }

    public C1043b mo1420a(C1196h c1196h) {
        return new C1059j(c1196h);
    }

    public C1052b mo1422b() {
        if (this.f2234a != null) {
            return this.f2234a;
        }
        C1196h a = m3789a();
        int b = a.m4500b();
        int c = a.m4501c();
        if (b < 40 || c < 40) {
            this.f2234a = super.mo1422b();
        } else {
            byte[] a2 = a.mo1528a();
            int i = b >> 3;
            if ((b & 7) != 0) {
                i++;
            }
            int i2 = c >> 3;
            if ((c & 7) != 0) {
                i2++;
            }
            int[][] a3 = C1059j.m3886a(a2, i, i2, b, c);
            C1052b c1052b = new C1052b(b, c);
            C1059j.m3885a(a2, i, i2, b, c, a3, c1052b);
            this.f2234a = c1052b;
        }
        return this.f2234a;
    }
}
