package com.google.p031b.p045f;

import com.google.p031b.C1016a;
import com.google.p031b.C1079d;
import com.google.p031b.C1084e;
import com.google.p031b.C1155g;
import com.google.p031b.C1178o;
import com.google.p031b.C1198j;
import com.google.p031b.C1199m;
import com.google.p031b.p034c.C1046a;
import java.util.Arrays;
import java.util.Map;
import twitter4j.HttpResponseCode;

public final class C1121e extends C1108l {
    private static final char[] f2387a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();
    private static final int[] f2388b = new int[]{276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, HttpResponseCode.ENHANCE_YOUR_CLAIM, 418, HttpResponseCode.NOT_FOUND, 402, 394, 360, 356, 354, 308, 282, 344, 332, 326, HttpResponseCode.MULTIPLE_CHOICES, 278, 436, 434, 428, HttpResponseCode.UNPROCESSABLE_ENTITY, HttpResponseCode.NOT_ACCEPTABLE, 410, 364, 358, 310, 314, HttpResponseCode.FOUND, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
    private static final int f2389c = f2388b[47];
    private final StringBuilder f2390d = new StringBuilder(20);
    private final int[] f2391e = new int[6];

    private static char m4125a(int i) {
        for (int i2 = 0; i2 < f2388b.length; i2++) {
            if (f2388b[i2] == i) {
                return f2387a[i2];
            }
        }
        throw C1198j.m4509a();
    }

    private static int m4126a(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            i++;
            i2 = iArr[i] + i2;
        }
        i = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = ((iArr[i3] << 8) * 9) / i2;
            int i5 = i4 >> 8;
            int i6 = (i4 & 255) > 127 ? i5 + 1 : i5;
            if (i6 < 1 || i6 > 4) {
                return -1;
            }
            if ((i3 & 1) == 0) {
                i5 = 0;
                while (i5 < i6) {
                    i5++;
                    i = (i << 1) | 1;
                }
            } else {
                i <<= i6;
            }
        }
        return i;
    }

    private static String m4127a(CharSequence charSequence) {
        int length = charSequence.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        int i = 0;
        while (i < length) {
            int i2;
            char charAt = charSequence.charAt(i);
            if (charAt < 'a' || charAt > 'd') {
                stringBuilder.append(charAt);
                i2 = i;
            } else if (i >= length - 1) {
                throw C1155g.m4329a();
            } else {
                char charAt2 = charSequence.charAt(i + 1);
                switch (charAt) {
                    case 'a':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            charAt = (char) (charAt2 - 64);
                            break;
                        }
                        throw C1155g.m4329a();
                        break;
                    case 'b':
                        if (charAt2 < 'A' || charAt2 > 'E') {
                            if (charAt2 >= 'F' && charAt2 <= 'W') {
                                charAt = (char) (charAt2 - 11);
                                break;
                            }
                            throw C1155g.m4329a();
                        }
                        charAt = (char) (charAt2 - 38);
                        break;
                        break;
                    case 'c':
                        if (charAt2 >= 'A' && charAt2 <= 'O') {
                            charAt = (char) (charAt2 - 32);
                            break;
                        } else if (charAt2 == 'Z') {
                            charAt = ':';
                            break;
                        } else {
                            throw C1155g.m4329a();
                        }
                    case 'd':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            charAt = (char) (charAt2 + 32);
                            break;
                        }
                        throw C1155g.m4329a();
                        break;
                    default:
                        charAt = '\u0000';
                        break;
                }
                stringBuilder.append(charAt);
                i2 = i + 1;
            }
            i = i2 + 1;
        }
        return stringBuilder.toString();
    }

    private static void m4128a(CharSequence charSequence, int i, int i2) {
        int i3 = 1;
        int i4 = i - 1;
        int i5 = 0;
        while (i4 >= 0) {
            int indexOf = ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i4)) * i3) + i5;
            i5 = i3 + 1;
            if (i5 > i2) {
                i5 = 1;
            }
            i4--;
            i3 = i5;
            i5 = indexOf;
        }
        if (charSequence.charAt(i) != f2387a[i5 % 47]) {
            throw C1079d.m3955a();
        }
    }

    private int[] m4129a(C1046a c1046a) {
        int a = c1046a.m3802a();
        int c = c1046a.m3813c(0);
        Arrays.fill(this.f2391e, 0);
        int[] iArr = this.f2391e;
        int length = iArr.length;
        int i = 0;
        int i2 = c;
        c = 0;
        for (int i3 = c; i3 < a; i3++) {
            if ((c1046a.m3807a(i3) ^ i) != 0) {
                iArr[c] = iArr[c] + 1;
            } else {
                if (c != length - 1) {
                    c++;
                } else if (C1121e.m4126a(iArr) == f2389c) {
                    return new int[]{i2, i3};
                } else {
                    i2 += iArr[0] + iArr[1];
                    System.arraycopy(iArr, 2, iArr, 0, length - 2);
                    iArr[length - 2] = 0;
                    iArr[length - 1] = 0;
                    c--;
                }
                iArr[c] = 1;
                i = i == 0 ? 1 : 0;
            }
        }
        throw C1198j.m4509a();
    }

    private static void m4130b(CharSequence charSequence) {
        int length = charSequence.length();
        C1121e.m4128a(charSequence, length - 2, 20);
        C1121e.m4128a(charSequence, length - 1, 15);
    }

    public C1199m mo1426a(int i, C1046a c1046a, Map<C1084e, ?> map) {
        int c = c1046a.m3813c(m4129a(c1046a)[1]);
        int a = c1046a.m3802a();
        int[] iArr = this.f2391e;
        Arrays.fill(iArr, 0);
        CharSequence charSequence = this.f2390d;
        charSequence.setLength(0);
        while (true) {
            C1108l.m4045a(c1046a, c, iArr);
            int a2 = C1121e.m4126a(iArr);
            if (a2 < 0) {
                throw C1198j.m4509a();
            }
            char a3 = C1121e.m4125a(a2);
            charSequence.append(a3);
            int i2 = c;
            for (int i3 : iArr) {
                i2 += i3;
            }
            a2 = c1046a.m3813c(i2);
            if (a3 == '*') {
                break;
            }
            c = a2;
        }
        charSequence.deleteCharAt(charSequence.length() - 1);
        int i4 = 0;
        for (int i32 : iArr) {
            i4 += i32;
        }
        if (a2 == a || !c1046a.m3807a(a2)) {
            throw C1198j.m4509a();
        } else if (charSequence.length() < 2) {
            throw C1198j.m4509a();
        } else {
            C1121e.m4130b(charSequence);
            charSequence.setLength(charSequence.length() - 2);
            float f = ((float) c) + (((float) i4) / 2.0f);
            return new C1199m(C1121e.m4127a(charSequence), null, new C1178o[]{new C1178o(((float) (r4[1] + r4[0])) / 2.0f, (float) i), new C1178o(f, (float) i)}, C1016a.CODE_93);
        }
    }
}
