package com.google.p031b.p053h.p056c;

final class C1193d {
    static int m4464a(C1190b c1190b) {
        return C1193d.m4465a(c1190b, true) + C1193d.m4465a(c1190b, false);
    }

    private static int m4465a(C1190b c1190b, boolean z) {
        int a = z ? c1190b.m4439a() : c1190b.m4443b();
        int b = z ? c1190b.m4443b() : c1190b.m4439a();
        byte[][] c = c1190b.m4444c();
        int i = 0;
        int i2 = 0;
        while (i < a) {
            byte b2 = (byte) -1;
            int i3 = 0;
            int i4 = 0;
            while (i3 < b) {
                int i5;
                int i6;
                byte b3;
                byte b4 = z ? c[i][i3] : c[i3][i];
                byte b5;
                if (b4 == b2) {
                    b5 = b2;
                    i5 = i4 + 1;
                    i6 = i2;
                    b3 = b5;
                } else {
                    if (i4 >= 5) {
                        i2 += (i4 - 5) + 3;
                    }
                    i5 = 1;
                    b5 = b4;
                    i6 = i2;
                    b3 = b5;
                }
                i3++;
                i4 = i5;
                b2 = b3;
                i2 = i6;
            }
            if (i4 >= 5) {
                i2 += (i4 - 5) + 3;
            }
            i++;
        }
        return i2;
    }

    static boolean m4466a(int i, int i2, int i3) {
        int i4;
        switch (i) {
            case 0:
                i4 = (i3 + i2) & 1;
                break;
            case 1:
                i4 = i3 & 1;
                break;
            case 2:
                i4 = i2 % 3;
                break;
            case 3:
                i4 = (i3 + i2) % 3;
                break;
            case 4:
                i4 = ((i3 >>> 1) + (i2 / 3)) & 1;
                break;
            case 5:
                i4 = i3 * i2;
                i4 = (i4 % 3) + (i4 & 1);
                break;
            case 6:
                i4 = i3 * i2;
                i4 = ((i4 % 3) + (i4 & 1)) & 1;
                break;
            case 7:
                i4 = (((i3 * i2) % 3) + ((i3 + i2) & 1)) & 1;
                break;
            default:
                throw new IllegalArgumentException("Invalid mask pattern: " + i);
        }
        return i4 == 0;
    }

    private static boolean m4467a(byte[] bArr, int i, int i2) {
        while (i < i2) {
            if (i >= 0 && i < bArr.length && bArr[i] == (byte) 1) {
                return false;
            }
            i++;
        }
        return true;
    }

    private static boolean m4468a(byte[][] bArr, int i, int i2, int i3) {
        while (i2 < i3) {
            if (i2 >= 0 && i2 < bArr.length && bArr[i2][i] == (byte) 1) {
                return false;
            }
            i2++;
        }
        return true;
    }

    static int m4469b(C1190b c1190b) {
        byte[][] c = c1190b.m4444c();
        int b = c1190b.m4443b();
        int a = c1190b.m4439a();
        int i = 0;
        int i2 = 0;
        while (i < a - 1) {
            int i3 = 0;
            while (i3 < b - 1) {
                byte b2 = c[i][i3];
                if (b2 == c[i][i3 + 1] && b2 == c[i + 1][i3] && b2 == c[i + 1][i3 + 1]) {
                    i2++;
                }
                i3++;
            }
            i++;
        }
        return i2 * 3;
    }

    static int m4470c(C1190b c1190b) {
        byte[][] c = c1190b.m4444c();
        int b = c1190b.m4443b();
        int a = c1190b.m4439a();
        int i = 0;
        int i2 = 0;
        while (i < a) {
            int i3 = 0;
            while (i3 < b) {
                byte[] bArr = c[i];
                if (i3 + 6 < b && bArr[i3] == (byte) 1 && bArr[i3 + 1] == (byte) 0 && bArr[i3 + 2] == (byte) 1 && bArr[i3 + 3] == (byte) 1 && bArr[i3 + 4] == (byte) 1 && bArr[i3 + 5] == (byte) 0 && bArr[i3 + 6] == (byte) 1 && (C1193d.m4467a(bArr, i3 - 4, i3) || C1193d.m4467a(bArr, i3 + 7, i3 + 11))) {
                    i2++;
                }
                if (i + 6 < a && c[i][i3] == (byte) 1 && c[i + 1][i3] == (byte) 0 && c[i + 2][i3] == (byte) 1 && c[i + 3][i3] == (byte) 1 && c[i + 4][i3] == (byte) 1 && c[i + 5][i3] == (byte) 0 && c[i + 6][i3] == (byte) 1 && (C1193d.m4468a(c, i3, i - 4, i) || C1193d.m4468a(c, i3, i + 7, i + 11))) {
                    i2++;
                }
                i3++;
            }
            i++;
        }
        return i2 * 40;
    }

    static int m4471d(C1190b c1190b) {
        int i;
        byte[][] c = c1190b.m4444c();
        int b = c1190b.m4443b();
        int a = c1190b.m4439a();
        int i2 = 0;
        for (int i3 = 0; i3 < a; i3++) {
            byte[] bArr = c[i3];
            for (i = 0; i < b; i++) {
                if (bArr[i] == (byte) 1) {
                    i2++;
                }
            }
        }
        i = c1190b.m4439a() * c1190b.m4443b();
        return ((Math.abs((i2 * 2) - i) * 10) / i) * 10;
    }
}
