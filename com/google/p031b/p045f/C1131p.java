package com.google.p031b.p045f;

import com.facebook.AppEventsConstants;
import com.google.p031b.C1016a;
import com.google.p031b.C1178o;
import com.google.p031b.C1198j;
import com.google.p031b.C1199m;
import com.google.p031b.C1200n;
import com.google.p031b.p034c.C1046a;
import java.util.EnumMap;
import java.util.Map;

final class C1131p {
    private static final int[] f2414a = new int[]{24, 20, 18, 17, 12, 6, 3, 10, 9, 5};
    private final int[] f2415b = new int[4];
    private final StringBuilder f2416c = new StringBuilder();

    C1131p() {
    }

    private static int m4172a(int i) {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == f2414a[i2]) {
                return i2;
            }
        }
        throw C1198j.m4509a();
    }

    private static int m4173a(CharSequence charSequence) {
        int i;
        int length = charSequence.length();
        int i2 = 0;
        for (i = length - 2; i >= 0; i -= 2) {
            i2 += charSequence.charAt(i) - 48;
        }
        i2 *= 3;
        for (i = length - 1; i >= 0; i -= 2) {
            i2 += charSequence.charAt(i) - 48;
        }
        return (i2 * 3) % 10;
    }

    private static Map<C1200n, Object> m4174a(String str) {
        if (str.length() != 5) {
            return null;
        }
        String b = C1131p.m4175b(str);
        if (b == null) {
            return null;
        }
        Map<C1200n, Object> enumMap = new EnumMap(C1200n.class);
        enumMap.put(C1200n.SUGGESTED_PRICE, b);
        return enumMap;
    }

    private static String m4175b(String str) {
        String str2;
        switch (str.charAt(0)) {
            case '0':
                str2 = "£";
                break;
            case '5':
                str2 = "$";
                break;
            case '9':
                if (!"90000".equals(str)) {
                    if (!"99991".equals(str)) {
                        if (!"99990".equals(str)) {
                            str2 = "";
                            break;
                        }
                        return "Used";
                    }
                    return "0.00";
                }
                return null;
            default:
                str2 = "";
                break;
        }
        int parseInt = Integer.parseInt(str.substring(1));
        String valueOf = String.valueOf(parseInt / 100);
        parseInt %= 100;
        return str2 + valueOf + '.' + (parseInt < 10 ? AppEventsConstants.EVENT_PARAM_VALUE_NO + parseInt : String.valueOf(parseInt));
    }

    int m4176a(C1046a c1046a, int[] iArr, StringBuilder stringBuilder) {
        int[] iArr2 = this.f2415b;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int a = c1046a.m3802a();
        int i = iArr[1];
        int i2 = 0;
        for (int i3 = 0; i3 < 5 && i < a; i3++) {
            int a2 = C1122r.m4132a(c1046a, iArr2, i, C1122r.f2395e);
            stringBuilder.append((char) ((a2 % 10) + 48));
            int i4 = 0;
            while (i4 < iArr2.length) {
                int i5 = iArr2[i4] + i;
                i4++;
                i = i5;
            }
            if (a2 >= 10) {
                i2 |= 1 << (4 - i3);
            }
            if (i3 != 4) {
                i = c1046a.m3815d(c1046a.m3813c(i));
            }
        }
        if (stringBuilder.length() != 5) {
            throw C1198j.m4509a();
        }
        if (C1131p.m4173a(stringBuilder.toString()) == C1131p.m4172a(i2)) {
            return i;
        }
        throw C1198j.m4509a();
    }

    C1199m m4177a(int i, C1046a c1046a, int[] iArr) {
        StringBuilder stringBuilder = this.f2416c;
        stringBuilder.setLength(0);
        int a = m4176a(c1046a, iArr, stringBuilder);
        String stringBuilder2 = stringBuilder.toString();
        Map a2 = C1131p.m4174a(stringBuilder2);
        C1199m c1199m = new C1199m(stringBuilder2, null, new C1178o[]{new C1178o(((float) (iArr[0] + iArr[1])) / 2.0f, (float) i), new C1178o((float) a, (float) i)}, C1016a.UPC_EAN_EXTENSION);
        if (a2 != null) {
            c1199m.m4512a(a2);
        }
        return c1199m;
    }
}
