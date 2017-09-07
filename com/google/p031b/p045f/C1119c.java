package com.google.p031b.p045f;

import com.google.p031b.C1016a;
import com.google.p031b.C1134f;
import com.google.p031b.p034c.C1052b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class C1119c extends C1118m {
    private static boolean m4117a(CharSequence charSequence, int i, int i2) {
        int i3 = i + i2;
        int length = charSequence.length();
        while (i < i3 && i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < '0' || charAt > '9') {
                if (charAt != 'ñ') {
                    return false;
                }
                i3++;
            }
            i++;
        }
        return i3 <= length;
    }

    public C1052b mo1427a(String str, C1016a c1016a, int i, int i2, Map<C1134f, ?> map) {
        if (c1016a == C1016a.CODE_128) {
            return super.mo1427a(str, c1016a, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + c1016a);
    }

    public boolean[] mo1428a(String str) {
        int i = 0;
        int length = str.length();
        if (length < 1 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
        }
        int i2;
        int i3;
        for (i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt < ' ' || charAt > '~') {
                switch (charAt) {
                    case 'ñ':
                    case 'ò':
                    case 'ó':
                    case 'ô':
                        break;
                    default:
                        throw new IllegalArgumentException("Bad character in input: " + charAt);
                }
            }
        }
        Collection<int[]> arrayList = new ArrayList();
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        int i7 = 0;
        while (i4 < length) {
            i3 = C1119c.m4117a(str, i4, i5 == 99 ? 2 : 4) ? 99 : 100;
            if (i3 == i5) {
                if (i5 != 100) {
                    switch (str.charAt(i4)) {
                        case 'ñ':
                            i2 = 102;
                            i3 = i4 + 1;
                            i4 = i5;
                            break;
                        case 'ò':
                            i2 = 97;
                            i3 = i4 + 1;
                            i4 = i5;
                            break;
                        case 'ó':
                            i2 = 96;
                            i3 = i4 + 1;
                            i4 = i5;
                            break;
                        case 'ô':
                            i3 = i4 + 1;
                            i4 = i5;
                            i2 = 100;
                            break;
                        default:
                            i2 = Integer.parseInt(str.substring(i4, i4 + 2));
                            i3 = i4 + 2;
                            i4 = i5;
                            break;
                    }
                }
                i2 = str.charAt(i4) - 32;
                i3 = i4 + 1;
                i4 = i5;
            } else {
                i2 = i5 == 0 ? i3 == 100 ? 104 : 105 : i3;
                int i8 = i4;
                i4 = i3;
                i3 = i8;
            }
            arrayList.add(C1117b.f2379a[i2]);
            i5 = i7 + (i2 * i6);
            i6 = i3 != 0 ? i6 + 1 : i6;
            i7 = i5;
            i5 = i4;
            i4 = i3;
        }
        arrayList.add(C1117b.f2379a[i7 % 103]);
        arrayList.add(C1117b.f2379a[106]);
        i3 = 0;
        for (int[] iArr : arrayList) {
            int i9 = 0;
            while (i9 < iArr.length) {
                i4 = iArr[i9] + i3;
                i9++;
                i3 = i4;
            }
        }
        boolean[] zArr = new boolean[i3];
        for (int[] iArr2 : arrayList) {
            i += C1118m.m4111a(zArr, i, iArr2, true);
        }
        return zArr;
    }
}
