package com.google.p031b.p045f;

import com.google.p031b.C1016a;
import com.google.p031b.C1134f;
import com.google.p031b.p034c.C1052b;
import java.util.Map;

public abstract class C1118m {
    protected static int m4111a(boolean[] zArr, int i, int[] iArr, boolean z) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = i;
        while (i2 < length) {
            int i5 = iArr[i2];
            int i6 = i4;
            i4 = 0;
            while (i4 < i5) {
                int i7 = i6 + 1;
                zArr[i6] = z;
                i4++;
                i6 = i7;
            }
            i3 += i5;
            i2++;
            z = !z;
            i4 = i6;
        }
        return i3;
    }

    private static C1052b m4112a(boolean[] zArr, int i, int i2, int i3) {
        int length = zArr.length;
        int i4 = length + i3;
        int max = Math.max(i, i4);
        int max2 = Math.max(1, i2);
        int i5 = max / i4;
        i4 = (max - (length * i5)) / 2;
        C1052b c1052b = new C1052b(max, max2);
        max = 0;
        while (max < length) {
            if (zArr[max]) {
                c1052b.m3847a(i4, 0, i5, max2);
            }
            max++;
            i4 += i5;
        }
        return c1052b;
    }

    public int m4113a() {
        return 10;
    }

    public final C1052b m4114a(String str, C1016a c1016a, int i, int i2) {
        return mo1427a(str, c1016a, i, i2, null);
    }

    public C1052b mo1427a(String str, C1016a c1016a, int i, int i2, Map<C1134f, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i + 'x' + i2);
        } else {
            int intValue;
            int a = m4113a();
            if (map != null) {
                Integer num = (Integer) map.get(C1134f.MARGIN);
                if (num != null) {
                    intValue = num.intValue();
                    return C1118m.m4112a(mo1428a(str), i, i2, intValue);
                }
            }
            intValue = a;
            return C1118m.m4112a(mo1428a(str), i, i2, intValue);
        }
    }

    public abstract boolean[] mo1428a(String str);
}
