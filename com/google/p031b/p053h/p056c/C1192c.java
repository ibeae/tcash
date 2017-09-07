package com.google.p031b.p053h.p056c;

import com.google.p031b.C1134f;
import com.google.p031b.C1202q;
import com.google.p031b.p034c.C1046a;
import com.google.p031b.p034c.C1054d;
import com.google.p031b.p034c.p039b.C1047a;
import com.google.p031b.p034c.p039b.C1050d;
import com.google.p031b.p053h.p054a.C1170f;
import com.google.p031b.p053h.p054a.C1172h;
import com.google.p031b.p053h.p054a.C1176j;
import com.google.p031b.p053h.p054a.C1176j.C1175b;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class C1192c {
    private static final int[] f2575a = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    static int m4445a(int i) {
        return i < f2575a.length ? f2575a[i] : -1;
    }

    private static int m4446a(C1046a c1046a, C1170f c1170f, C1176j c1176j, C1190b c1190b) {
        int i = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i2 = -1;
        int i3 = 0;
        while (i3 < 8) {
            C1194e.m4476a(c1046a, c1170f, c1176j, i3, c1190b);
            int a = C1192c.m4447a(c1190b);
            if (a < i) {
                i2 = i3;
            } else {
                a = i;
            }
            i3++;
            i = a;
        }
        return i2;
    }

    private static int m4447a(C1190b c1190b) {
        return ((C1193d.m4464a(c1190b) + C1193d.m4469b(c1190b)) + C1193d.m4470c(c1190b)) + C1193d.m4471d(c1190b);
    }

    static C1046a m4448a(C1046a c1046a, int i, int i2, int i3) {
        if (c1046a.m3809b() != i2) {
            throw new C1202q("Number of bits and data bytes does not match");
        }
        Collection<C1189a> arrayList = new ArrayList(i3);
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i4 < i3) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            C1192c.m4452a(i, i2, i3, i4, iArr, iArr2);
            int i8 = iArr[0];
            byte[] bArr = new byte[i8];
            c1046a.m3804a(i7 * 8, bArr, 0, i8);
            byte[] a = C1192c.m4462a(bArr, iArr2[0]);
            arrayList.add(new C1189a(bArr, a));
            int max = Math.max(i6, i8);
            i4++;
            i5 = Math.max(i5, a.length);
            i6 = max;
            i7 = iArr[0] + i7;
        }
        if (i2 != i7) {
            throw new C1202q("Data bytes does not match offset");
        }
        C1046a c1046a2 = new C1046a();
        for (max = 0; max < i6; max++) {
            for (C1189a a2 : arrayList) {
                byte[] a3 = a2.m4436a();
                if (max < a3.length) {
                    c1046a2.m3811b(a3[max], 8);
                }
            }
        }
        for (max = 0; max < i5; max++) {
            for (C1189a a22 : arrayList) {
                a3 = a22.m4437b();
                if (max < a3.length) {
                    c1046a2.m3811b(a3[max], 8);
                }
            }
        }
        if (i == c1046a2.m3809b()) {
            return c1046a2;
        }
        throw new C1202q("Interleaving error: " + i + " and " + c1046a2.m3809b() + " differ.");
    }

    private static C1172h m4449a(String str, String str2) {
        int i = 0;
        if ("Shift_JIS".equals(str2)) {
            return C1192c.m4461a(str) ? C1172h.KANJI : C1172h.BYTE;
        } else {
            int i2 = 0;
            int i3 = 0;
            while (i < str.length()) {
                int charAt = str.charAt(i);
                if (charAt >= '0' && charAt <= '9') {
                    i3 = 1;
                } else if (C1192c.m4445a(charAt) == -1) {
                    return C1172h.BYTE;
                } else {
                    i2 = 1;
                }
                i++;
            }
            return i2 != 0 ? C1172h.ALPHANUMERIC : i3 != 0 ? C1172h.NUMERIC : C1172h.BYTE;
        }
    }

    private static C1176j m4450a(int i, C1170f c1170f) {
        for (int i2 = 1; i2 <= 40; i2++) {
            C1176j b = C1176j.m4380b(i2);
            if (b.m4386c() - b.m4384a(c1170f).m4377c() >= (i + 7) / 8) {
                return b;
            }
        }
        throw new C1202q("Data too big");
    }

    public static C1195f m4451a(String str, C1170f c1170f, Map<C1134f, ?> map) {
        String str2 = map == null ? null : (String) map.get(C1134f.CHARACTER_SET);
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        C1172h a = C1192c.m4449a(str, str2);
        C1046a c1046a = new C1046a();
        if (a == C1172h.BYTE && !"ISO-8859-1".equals(str2)) {
            C1054d a2 = C1054d.m3862a(str2);
            if (a2 != null) {
                C1192c.m4455a(a2, c1046a);
            }
        }
        C1192c.m4456a(a, c1046a);
        C1046a c1046a2 = new C1046a();
        C1192c.m4460a(str, a, c1046a2, str2);
        C1176j a3 = C1192c.m4450a((a.m4371a(C1192c.m4450a((c1046a.m3802a() + a.m4371a(C1176j.m4380b(1))) + c1046a2.m3802a(), c1170f)) + c1046a.m3802a()) + c1046a2.m3802a(), c1170f);
        C1046a c1046a3 = new C1046a();
        c1046a3.m3805a(c1046a);
        C1192c.m4454a(a == C1172h.BYTE ? c1046a2.m3809b() : str.length(), a3, a, c1046a3);
        c1046a3.m3805a(c1046a2);
        C1175b a4 = a3.m4384a(c1170f);
        int c = a3.m4386c() - a4.m4377c();
        C1192c.m4453a(c, c1046a3);
        C1046a a5 = C1192c.m4448a(c1046a3, a3.m4386c(), c, a4.m4376b());
        C1195f c1195f = new C1195f();
        c1195f.m4494a(c1170f);
        c1195f.m4495a(a);
        c1195f.m4496a(a3);
        int d = a3.m4387d();
        C1190b c1190b = new C1190b(d, d);
        d = C1192c.m4446a(a5, c1170f, a3, c1190b);
        c1195f.m4493a(d);
        C1194e.m4476a(a5, c1170f, a3, d, c1190b);
        c1195f.m4497a(c1190b);
        return c1195f;
    }

    static void m4452a(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        if (i4 >= i3) {
            throw new C1202q("Block ID too large");
        }
        int i5 = i % i3;
        int i6 = i3 - i5;
        int i7 = i / i3;
        int i8 = i7 + 1;
        int i9 = i2 / i3;
        int i10 = i9 + 1;
        i7 -= i9;
        i8 -= i10;
        if (i7 != i8) {
            throw new C1202q("EC bytes mismatch");
        } else if (i3 != i6 + i5) {
            throw new C1202q("RS blocks mismatch");
        } else {
            if (i != (i5 * (i10 + i8)) + ((i9 + i7) * i6)) {
                throw new C1202q("Total bytes mismatch");
            } else if (i4 < i6) {
                iArr[0] = i9;
                iArr2[0] = i7;
            } else {
                iArr[0] = i10;
                iArr2[0] = i8;
            }
        }
    }

    static void m4453a(int i, C1046a c1046a) {
        int i2 = i << 3;
        if (c1046a.m3802a() > i2) {
            throw new C1202q("data bits cannot fit in the QR Code" + c1046a.m3802a() + " > " + i2);
        }
        int i3;
        for (i3 = 0; i3 < 4 && c1046a.m3802a() < i2; i3++) {
            c1046a.m3806a(false);
        }
        i3 = c1046a.m3802a() & 7;
        if (i3 > 0) {
            while (i3 < 8) {
                c1046a.m3806a(false);
                i3++;
            }
        }
        int b = i - c1046a.m3809b();
        for (i3 = 0; i3 < b; i3++) {
            c1046a.m3811b((i3 & 1) == 0 ? 236 : 17, 8);
        }
        if (c1046a.m3802a() != i2) {
            throw new C1202q("Bits size does not equal capacity");
        }
    }

    static void m4454a(int i, C1176j c1176j, C1172h c1172h, C1046a c1046a) {
        int a = c1172h.m4371a(c1176j);
        if (i >= (1 << a)) {
            throw new C1202q(i + " is bigger than " + ((1 << a) - 1));
        }
        c1046a.m3811b(i, a);
    }

    private static void m4455a(C1054d c1054d, C1046a c1046a) {
        c1046a.m3811b(C1172h.ECI.m4370a(), 4);
        c1046a.m3811b(c1054d.m3863a(), 8);
    }

    static void m4456a(C1172h c1172h, C1046a c1046a) {
        c1046a.m3811b(c1172h.m4370a(), 4);
    }

    static void m4457a(CharSequence charSequence, C1046a c1046a) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int charAt = charSequence.charAt(i) - 48;
            if (i + 2 < length) {
                c1046a.m3811b(((charAt * 100) + ((charSequence.charAt(i + 1) - 48) * 10)) + (charSequence.charAt(i + 2) - 48), 10);
                i += 3;
            } else if (i + 1 < length) {
                c1046a.m3811b((charAt * 10) + (charSequence.charAt(i + 1) - 48), 7);
                i += 2;
            } else {
                c1046a.m3811b(charAt, 4);
                i++;
            }
        }
    }

    static void m4458a(String str, C1046a c1046a) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i = 0; i < length; i += 2) {
                int i2 = ((bytes[i] & 255) << 8) | (bytes[i + 1] & 255);
                i2 = (i2 < 33088 || i2 > 40956) ? (i2 < 57408 || i2 > 60351) ? -1 : i2 - 49472 : i2 - 33088;
                if (i2 == -1) {
                    throw new C1202q("Invalid byte sequence");
                }
                c1046a.m3811b((i2 & 255) + ((i2 >> 8) * 192), 13);
            }
        } catch (Throwable e) {
            throw new C1202q(e);
        }
    }

    static void m4459a(String str, C1046a c1046a, String str2) {
        try {
            for (byte b : str.getBytes(str2)) {
                c1046a.m3811b(b, 8);
            }
        } catch (Throwable e) {
            throw new C1202q(e);
        }
    }

    static void m4460a(String str, C1172h c1172h, C1046a c1046a, String str2) {
        switch (c1172h) {
            case NUMERIC:
                C1192c.m4457a((CharSequence) str, c1046a);
                return;
            case ALPHANUMERIC:
                C1192c.m4463b(str, c1046a);
                return;
            case BYTE:
                C1192c.m4459a(str, c1046a, str2);
                return;
            case KANJI:
                C1192c.m4458a(str, c1046a);
                return;
            default:
                throw new C1202q("Invalid mode: " + c1172h);
        }
    }

    private static boolean m4461a(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                int i2 = bytes[i] & 255;
                if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException e) {
            return false;
        }
    }

    static byte[] m4462a(byte[] bArr, int i) {
        int i2 = 0;
        int length = bArr.length;
        int[] iArr = new int[(length + i)];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        new C1050d(C1047a.f2167e).m3845a(iArr, i);
        byte[] bArr2 = new byte[i];
        while (i2 < i) {
            bArr2[i2] = (byte) iArr[length + i2];
            i2++;
        }
        return bArr2;
    }

    static void m4463b(CharSequence charSequence, C1046a c1046a) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int a = C1192c.m4445a(charSequence.charAt(i));
            if (a == -1) {
                throw new C1202q();
            } else if (i + 1 < length) {
                int a2 = C1192c.m4445a(charSequence.charAt(i + 1));
                if (a2 == -1) {
                    throw new C1202q();
                }
                c1046a.m3811b((a * 45) + a2, 11);
                i += 2;
            } else {
                c1046a.m3811b(a, 6);
                i++;
            }
        }
    }
}
