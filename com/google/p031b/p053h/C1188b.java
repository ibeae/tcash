package com.google.p031b.p053h;

import com.google.p031b.C1016a;
import com.google.p031b.C1134f;
import com.google.p031b.p034c.C1052b;
import com.google.p031b.p053h.p054a.C1170f;
import com.google.p031b.p053h.p056c.C1190b;
import com.google.p031b.p053h.p056c.C1192c;
import com.google.p031b.p053h.p056c.C1195f;
import java.util.Map;

public final class C1188b {
    private static C1052b m4434a(C1195f c1195f, int i, int i2, int i3) {
        C1190b a = c1195f.m4492a();
        if (a == null) {
            throw new IllegalStateException();
        }
        int b = a.m4443b();
        int a2 = a.m4439a();
        int i4 = (i3 << 1) + b;
        int i5 = (i3 << 1) + a2;
        int max = Math.max(i, i4);
        int max2 = Math.max(i2, i5);
        int min = Math.min(max / i4, max2 / i5);
        i5 = (max - (b * min)) / 2;
        i4 = (max2 - (a2 * min)) / 2;
        C1052b c1052b = new C1052b(max, max2);
        max2 = i4;
        for (int i6 = 0; i6 < a2; i6++) {
            max = 0;
            i4 = i5;
            while (max < b) {
                if (a.m4438a(max, i6) == (byte) 1) {
                    c1052b.m3847a(i4, max2, min, min);
                }
                max++;
                i4 += min;
            }
            max2 += min;
        }
        return c1052b;
    }

    public C1052b m4435a(String str, C1016a c1016a, int i, int i2, Map<C1134f, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (c1016a != C1016a.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + c1016a);
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        } else {
            int intValue;
            C1170f c1170f = C1170f.L;
            if (map != null) {
                C1170f c1170f2 = (C1170f) map.get(C1134f.ERROR_CORRECTION);
                if (c1170f2 != null) {
                    c1170f = c1170f2;
                }
                Integer num = (Integer) map.get(C1134f.MARGIN);
                if (num != null) {
                    intValue = num.intValue();
                    return C1188b.m4434a(C1192c.m4451a(str, c1170f, (Map) map), i, i2, intValue);
                }
            }
            intValue = 4;
            return C1188b.m4434a(C1192c.m4451a(str, c1170f, (Map) map), i, i2, intValue);
        }
    }
}
