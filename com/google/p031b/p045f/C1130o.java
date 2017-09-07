package com.google.p031b.p045f;

import com.google.p031b.C1016a;
import com.google.p031b.C1178o;
import com.google.p031b.C1198j;
import com.google.p031b.C1199m;
import com.google.p031b.C1200n;
import com.google.p031b.p034c.C1046a;
import java.util.EnumMap;
import java.util.Map;

final class C1130o {
    private final int[] f2412a = new int[4];
    private final StringBuilder f2413b = new StringBuilder();

    C1130o() {
    }

    private static Map<C1200n, Object> m4169a(String str) {
        if (str.length() != 2) {
            return null;
        }
        Map<C1200n, Object> enumMap = new EnumMap(C1200n.class);
        enumMap.put(C1200n.ISSUE_NUMBER, Integer.valueOf(str));
        return enumMap;
    }

    int m4170a(C1046a c1046a, int[] iArr, StringBuilder stringBuilder) {
        int[] iArr2 = this.f2412a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int a = c1046a.m3802a();
        int i = iArr[1];
        int i2 = 0;
        for (int i3 = 0; i3 < 2 && i < a; i3++) {
            int a2 = C1122r.m4132a(c1046a, iArr2, i, C1122r.f2395e);
            stringBuilder.append((char) ((a2 % 10) + 48));
            int i4 = 0;
            while (i4 < iArr2.length) {
                int i5 = iArr2[i4] + i;
                i4++;
                i = i5;
            }
            if (a2 >= 10) {
                i2 |= 1 << (1 - i3);
            }
            if (i3 != 1) {
                i = c1046a.m3815d(c1046a.m3813c(i));
            }
        }
        if (stringBuilder.length() != 2) {
            throw C1198j.m4509a();
        } else if (Integer.parseInt(stringBuilder.toString()) % 4 == i2) {
            return i;
        } else {
            throw C1198j.m4509a();
        }
    }

    C1199m m4171a(int i, C1046a c1046a, int[] iArr) {
        StringBuilder stringBuilder = this.f2413b;
        stringBuilder.setLength(0);
        int a = m4170a(c1046a, iArr, stringBuilder);
        String stringBuilder2 = stringBuilder.toString();
        Map a2 = C1130o.m4169a(stringBuilder2);
        C1199m c1199m = new C1199m(stringBuilder2, null, new C1178o[]{new C1178o(((float) (iArr[0] + iArr[1])) / 2.0f, (float) i), new C1178o((float) a, (float) i)}, C1016a.UPC_EAN_EXTENSION);
        if (a2 != null) {
            c1199m.m4512a(a2);
        }
        return c1199m;
    }
}
