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

public final class C1120d extends C1108l {
    static final int[] f2380a = new int[]{52, 289, 97, 352, 49, HttpResponseCode.NOT_MODIFIED, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, HttpResponseCode.BAD_REQUEST, 208, 133, 388, 196, 148, 168, 162, 138, 42};
    private static final char[] f2381b = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".toCharArray();
    private static final int f2382c = f2380a[39];
    private final boolean f2383d;
    private final boolean f2384e;
    private final StringBuilder f2385f;
    private final int[] f2386g;

    public C1120d() {
        this(false);
    }

    public C1120d(boolean z) {
        this(z, false);
    }

    public C1120d(boolean z, boolean z2) {
        this.f2383d = z;
        this.f2384e = z2;
        this.f2385f = new StringBuilder(20);
        this.f2386g = new int[9];
    }

    private static char m4120a(int i) {
        for (int i2 = 0; i2 < f2380a.length; i2++) {
            if (f2380a[i2] == i) {
                return f2381b[i2];
            }
        }
        throw C1198j.m4509a();
    }

    private static int m4121a(int[] iArr) {
        int i;
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            int i3;
            int i4 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            for (int i5 : iArr) {
                if (i5 < i4 && i5 > r0) {
                    i4 = i5;
                }
            }
            i2 = 0;
            int i52 = 0;
            i = 0;
            for (i3 = 0; i3 < length; i3++) {
                int i6 = iArr[i3];
                if (i6 > i4) {
                    i2 |= 1 << ((length - 1) - i3);
                    i++;
                    i52 += i6;
                }
            }
            if (i == 3) {
                break;
            } else if (i <= 3) {
                return -1;
            } else {
                i2 = i4;
            }
        }
        int i7 = i;
        for (i = 0; i < length && i7 > 0; i++) {
            i3 = iArr[i];
            if (i3 > i4) {
                i7--;
                if ((i3 << 1) >= i52) {
                    return -1;
                }
            }
        }
        return i2;
    }

    private static String m4122a(CharSequence charSequence) {
        int length = charSequence.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        int i = 0;
        while (i < length) {
            int i2;
            char charAt = charSequence.charAt(i);
            if (charAt == '+' || charAt == '$' || charAt == '%' || charAt == '/') {
                char charAt2 = charSequence.charAt(i + 1);
                switch (charAt) {
                    case '$':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            charAt = (char) (charAt2 - 64);
                            break;
                        }
                        throw C1155g.m4329a();
                        break;
                    case '%':
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
                    case '+':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            charAt = (char) (charAt2 + 32);
                            break;
                        }
                        throw C1155g.m4329a();
                        break;
                    case '/':
                        if (charAt2 >= 'A' && charAt2 <= 'O') {
                            charAt = (char) (charAt2 - 32);
                            break;
                        } else if (charAt2 == 'Z') {
                            charAt = ':';
                            break;
                        } else {
                            throw C1155g.m4329a();
                        }
                    default:
                        charAt = '\u0000';
                        break;
                }
                stringBuilder.append(charAt);
                i2 = i + 1;
            } else {
                stringBuilder.append(charAt);
                i2 = i;
            }
            i = i2 + 1;
        }
        return stringBuilder.toString();
    }

    private static int[] m4123a(C1046a c1046a, int[] iArr) {
        int a = c1046a.m3802a();
        int c = c1046a.m3813c(0);
        int length = iArr.length;
        int i = c;
        int i2 = 0;
        int i3 = 0;
        while (i < a) {
            if ((c1046a.m3807a(i) ^ i2) != 0) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else if (C1120d.m4121a(iArr) == f2382c && c1046a.m3808a(Math.max(0, c - ((i - c) >> 1)), c, false)) {
                    return new int[]{c, i};
                } else {
                    c += iArr[0] + iArr[1];
                    System.arraycopy(iArr, 2, iArr, 0, length - 2);
                    iArr[length - 2] = 0;
                    iArr[length - 1] = 0;
                    i3--;
                }
                iArr[i3] = 1;
                i2 = i2 == 0 ? 1 : 0;
            }
            i++;
        }
        throw C1198j.m4509a();
    }

    public C1199m mo1426a(int i, C1046a c1046a, Map<C1084e, ?> map) {
        int a;
        int i2;
        int[] iArr = this.f2386g;
        Arrays.fill(iArr, 0);
        CharSequence charSequence = this.f2385f;
        charSequence.setLength(0);
        int c = c1046a.m3813c(C1120d.m4123a(c1046a, iArr)[1]);
        int a2 = c1046a.m3802a();
        while (true) {
            C1108l.m4045a(c1046a, c, iArr);
            a = C1120d.m4121a(iArr);
            if (a < 0) {
                throw C1198j.m4509a();
            }
            char a3 = C1120d.m4120a(a);
            charSequence.append(a3);
            i2 = c;
            for (int i3 : iArr) {
                i2 += i3;
            }
            a = c1046a.m3813c(i2);
            if (a3 == '*') {
                break;
            }
            c = a;
        }
        charSequence.setLength(charSequence.length() - 1);
        int i4 = 0;
        for (int i32 : iArr) {
            i4 += i32;
        }
        i2 = (a - c) - i4;
        if (a == a2 || (i2 >> 1) >= i4) {
            if (this.f2383d) {
                int length = charSequence.length() - 1;
                i2 = 0;
                for (a = 0; a < length; a++) {
                    i2 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(this.f2385f.charAt(a));
                }
                if (charSequence.charAt(length) != f2381b[i2 % 43]) {
                    throw C1079d.m3955a();
                }
                charSequence.setLength(length);
            }
            if (charSequence.length() == 0) {
                throw C1198j.m4509a();
            }
            float f = ((float) c) + (((float) i4) / 2.0f);
            return new C1199m(this.f2384e ? C1120d.m4122a(charSequence) : charSequence.toString(), null, new C1178o[]{new C1178o(((float) (r6[1] + r6[0])) / 2.0f, (float) i), new C1178o(f, (float) i)}, C1016a.CODE_39);
        }
        throw C1198j.m4509a();
    }
}
