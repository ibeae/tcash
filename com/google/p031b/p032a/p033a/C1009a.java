package com.google.p031b.p032a.p033a;

import com.facebook.AppEventsConstants;
import com.google.p031b.C1155g;
import com.google.p031b.p032a.C1011a;
import com.google.p031b.p034c.C1052b;
import com.google.p031b.p034c.C1055e;
import com.google.p031b.p034c.p039b.C1047a;
import com.google.p031b.p034c.p039b.C1049c;
import com.google.p031b.p034c.p039b.C1051e;
import java.util.Arrays;

public final class C1009a {
    private static final String[] f2009a = new String[]{"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] f2010b = new String[]{"CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] f2011c = new String[]{"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final String[] f2012d = new String[]{"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};
    private static final String[] f2013e = new String[]{"CTRL_PS", " ", AppEventsConstants.EVENT_PARAM_VALUE_NO, AppEventsConstants.EVENT_PARAM_VALUE_YES, "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};
    private C1011a f2014f;

    private enum C1008a {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    private static int m3652a(int i, boolean z) {
        return ((z ? 88 : 112) + (i * 16)) * i;
    }

    private static int m3653a(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3++;
            }
        }
        return i3;
    }

    private static C1008a m3654a(char c) {
        switch (c) {
            case 'B':
                return C1008a.BINARY;
            case 'D':
                return C1008a.DIGIT;
            case 'L':
                return C1008a.LOWER;
            case 'M':
                return C1008a.MIXED;
            case 'P':
                return C1008a.PUNCT;
            default:
                return C1008a.UPPER;
        }
    }

    private static String m3655a(C1008a c1008a, int i) {
        switch (c1008a) {
            case UPPER:
                return f2009a[i];
            case LOWER:
                return f2010b[i];
            case MIXED:
                return f2011c[i];
            case PUNCT:
                return f2012d[i];
            case DIGIT:
                return f2013e[i];
            default:
                throw new IllegalStateException("Bad table");
        }
    }

    private static String m3656a(boolean[] zArr) {
        int length = zArr.length;
        C1008a c1008a = C1008a.UPPER;
        C1008a c1008a2 = C1008a.UPPER;
        StringBuilder stringBuilder = new StringBuilder(20);
        int i = 0;
        C1008a c1008a3 = c1008a2;
        c1008a2 = c1008a;
        while (i < length) {
            int i2;
            if (c1008a3 != C1008a.BINARY) {
                i2 = c1008a3 == C1008a.DIGIT ? 4 : 5;
                if (length - i < i2) {
                    break;
                }
                int a = C1009a.m3653a(zArr, i, i2);
                i += i2;
                String a2 = C1009a.m3655a(c1008a3, a);
                if (a2.startsWith("CTRL_")) {
                    c1008a = C1009a.m3654a(a2.charAt(5));
                    if (a2.charAt(6) == 'L') {
                        c1008a2 = c1008a;
                    }
                } else {
                    stringBuilder.append(a2);
                    c1008a = c1008a2;
                }
                c1008a3 = c1008a;
            } else if (length - i < 5) {
                break;
            } else {
                i2 = C1009a.m3653a(zArr, i, 5);
                i += 5;
                if (i2 == 0) {
                    if (length - i < 11) {
                        break;
                    }
                    i2 = C1009a.m3653a(zArr, i, 11) + 31;
                    i += 11;
                }
                int i3 = 0;
                while (i3 < i2) {
                    if (length - i < 8) {
                        i2 = length;
                        break;
                    }
                    stringBuilder.append((char) C1009a.m3653a(zArr, i, 8));
                    i3++;
                    i += 8;
                }
                i2 = i;
                i = i2;
                c1008a3 = c1008a2;
            }
        }
        return stringBuilder.toString();
    }

    private boolean[] m3657b(boolean[] zArr) {
        C1047a c1047a;
        int i = 8;
        if (this.f2014f.m3662a() <= 2) {
            i = 6;
            c1047a = C1047a.f2165c;
        } else if (this.f2014f.m3662a() <= 8) {
            c1047a = C1047a.f2169g;
        } else if (this.f2014f.m3662a() <= 22) {
            i = 10;
            c1047a = C1047a.f2164b;
        } else {
            i = 12;
            c1047a = C1047a.f2163a;
        }
        int b = this.f2014f.m3663b();
        int length = zArr.length / i;
        int i2 = length - b;
        int[] iArr = new int[length];
        int length2 = zArr.length % i;
        int i3 = 0;
        while (i3 < length) {
            iArr[i3] = C1009a.m3653a(zArr, length2, i);
            i3++;
            length2 += i;
        }
        try {
            new C1049c(c1047a).m3843a(iArr, i2);
            int i4 = (1 << i) - 1;
            int i5 = 0;
            for (i3 = 0; i3 < b; i3++) {
                length2 = iArr[i3];
                if (length2 == 0 || length2 == i4) {
                    throw C1155g.m4329a();
                }
                if (length2 == 1 || length2 == i4 - 1) {
                    i5++;
                }
            }
            boolean[] zArr2 = new boolean[((b * i) - i5)];
            i2 = 0;
            i3 = 0;
            while (i2 < b) {
                int i6 = iArr[i2];
                if (i6 == 1 || i6 == i4 - 1) {
                    Arrays.fill(zArr2, i3, (i3 + i) - 1, i6 > 1);
                    i5 = (i - 1) + i3;
                } else {
                    length2 = i - 1;
                    while (length2 >= 0) {
                        length = i3 + 1;
                        zArr2[i3] = ((1 << length2) & i6) != 0;
                        length2--;
                        i3 = length;
                    }
                    i5 = i3;
                }
                i2++;
                i3 = i5;
            }
            return zArr2;
        } catch (C1051e e) {
            throw C1155g.m4329a();
        }
    }

    public C1055e m3658a(C1011a c1011a) {
        this.f2014f = c1011a;
        return new C1055e(null, C1009a.m3656a(m3657b(m3659a(c1011a.m3660d()))), null, null);
    }

    boolean[] m3659a(C1052b c1052b) {
        int i;
        int i2;
        int i3;
        int i4;
        boolean c = this.f2014f.m3664c();
        int a = this.f2014f.m3662a();
        int i5 = c ? (a * 4) + 11 : (a * 4) + 14;
        int[] iArr = new int[i5];
        boolean[] zArr = new boolean[C1009a.m3652a(a, c)];
        if (c) {
            for (i = 0; i < iArr.length; i++) {
                iArr[i] = i;
            }
        } else {
            i2 = i5 / 2;
            i3 = ((i5 + 1) + ((((i5 / 2) - 1) / 15) * 2)) / 2;
            for (i = 0; i < i2; i++) {
                i4 = (i / 15) + i;
                iArr[(i2 - i) - 1] = (i3 - i4) - 1;
                iArr[i2 + i] = (i4 + i3) + 1;
            }
        }
        i4 = 0;
        for (int i6 = 0; i6 < a; i6++) {
            i = c ? ((a - i6) * 4) + 9 : ((a - i6) * 4) + 12;
            int i7 = i6 * 2;
            int i8 = (i5 - 1) - i7;
            for (i3 = 0; i3 < i; i3++) {
                int i9 = i3 * 2;
                for (i2 = 0; i2 < 2; i2++) {
                    zArr[(i4 + i9) + i2] = c1052b.m3848a(iArr[i7 + i2], iArr[i7 + i3]);
                    zArr[(((i * 2) + i4) + i9) + i2] = c1052b.m3848a(iArr[i7 + i3], iArr[i8 - i2]);
                    zArr[(((i * 4) + i4) + i9) + i2] = c1052b.m3848a(iArr[i8 - i2], iArr[i8 - i3]);
                    zArr[(((i * 6) + i4) + i9) + i2] = c1052b.m3848a(iArr[i8 - i3], iArr[i7 + i2]);
                }
            }
            i4 = (i * 8) + i4;
        }
        return zArr;
    }
}
