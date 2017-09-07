package com.google.p031b.p045f;

import com.google.p031b.C1016a;
import com.google.p031b.C1198j;
import com.google.p031b.p034c.C1046a;

public final class C1133s extends C1122r {
    private static final int[] f2420a = new int[]{1, 1, 1, 1, 1, 1};
    private static final int[][] f2421f = new int[][]{new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};
    private final int[] f2422g = new int[4];

    private static void m4179a(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 <= 1; i2++) {
            for (int i3 = 0; i3 < 10; i3++) {
                if (i == f2421f[i2][i3]) {
                    stringBuilder.insert(0, (char) (i2 + 48));
                    stringBuilder.append((char) (i3 + 48));
                    return;
                }
            }
        }
        throw C1198j.m4509a();
    }

    public static String m4180b(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder stringBuilder = new StringBuilder(12);
        stringBuilder.append(str.charAt(0));
        char c = cArr[5];
        switch (c) {
            case '0':
            case '1':
            case '2':
                stringBuilder.append(cArr, 0, 2);
                stringBuilder.append(c);
                stringBuilder.append("0000");
                stringBuilder.append(cArr, 2, 3);
                break;
            case '3':
                stringBuilder.append(cArr, 0, 3);
                stringBuilder.append("00000");
                stringBuilder.append(cArr, 3, 2);
                break;
            case '4':
                stringBuilder.append(cArr, 0, 4);
                stringBuilder.append("00000");
                stringBuilder.append(cArr[4]);
                break;
            default:
                stringBuilder.append(cArr, 0, 5);
                stringBuilder.append("0000");
                stringBuilder.append(c);
                break;
        }
        stringBuilder.append(str.charAt(7));
        return stringBuilder.toString();
    }

    protected int mo1429a(C1046a c1046a, int[] iArr, StringBuilder stringBuilder) {
        int[] iArr2 = this.f2422g;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int a = c1046a.m3802a();
        int i = iArr[1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < 6 && i < a) {
            int a2 = C1122r.m4132a(c1046a, iArr2, i, e);
            stringBuilder.append((char) ((a2 % 10) + 48));
            int i4 = i;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            if (a2 >= 10) {
                i3 |= 1 << (5 - i2);
            }
            i2++;
            i = i4;
        }
        C1133s.m4179a(stringBuilder, i3);
        return i;
    }

    protected boolean mo1432a(String str) {
        return super.mo1432a(C1133s.m4180b(str));
    }

    protected int[] mo1433a(C1046a c1046a, int i) {
        return C1122r.m4135a(c1046a, i, true, f2420a);
    }

    C1016a mo1430b() {
        return C1016a.UPC_E;
    }
}
