package com.google.p031b.p045f;

import com.google.p031b.C1016a;
import com.google.p031b.C1084e;
import com.google.p031b.C1155g;
import com.google.p031b.C1178o;
import com.google.p031b.C1198j;
import com.google.p031b.C1199m;
import com.google.p031b.p034c.C1046a;
import java.util.Map;

public final class C1126i extends C1108l {
    static final int[][] f2404a = new int[][]{new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};
    private static final int[] f2405b = new int[]{48, 44, 24, 20, 18, 16, 14, 12, 10, 8, 6};
    private static final int[] f2406d = new int[]{1, 1, 1, 1};
    private static final int[] f2407e = new int[]{1, 1, 3};
    private int f2408c = -1;

    private static int m4151a(int[] iArr) {
        int i = 107;
        int i2 = -1;
        int length = f2404a.length;
        int i3 = 0;
        while (i3 < length) {
            int a = C1108l.m4044a(iArr, f2404a[i3], 199);
            if (a < i) {
                i2 = i3;
            } else {
                a = i;
            }
            i3++;
            i = a;
        }
        if (i2 >= 0) {
            return i2;
        }
        throw C1198j.m4509a();
    }

    private void m4152a(C1046a c1046a, int i) {
        int i2 = this.f2408c * 10;
        if (i2 >= i) {
            i2 = i;
        }
        int i3 = i2;
        i2 = i - 1;
        while (i3 > 0 && i2 >= 0 && !c1046a.m3807a(i2)) {
            i3--;
            i2--;
        }
        if (i3 != 0) {
            throw C1198j.m4509a();
        }
    }

    private static void m4153a(C1046a c1046a, int i, int i2, StringBuilder stringBuilder) {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        int i3 = i;
        while (i3 < i2) {
            int i4;
            C1108l.m4045a(c1046a, i3, iArr);
            for (i4 = 0; i4 < 5; i4++) {
                int i5 = i4 << 1;
                iArr2[i4] = iArr[i5];
                iArr3[i4] = iArr[i5 + 1];
            }
            stringBuilder.append((char) (C1126i.m4151a(iArr2) + 48));
            stringBuilder.append((char) (C1126i.m4151a(iArr3) + 48));
            i4 = i3;
            for (int i6 : iArr) {
                i4 += i6;
            }
            i3 = i4;
        }
    }

    private static int m4154c(C1046a c1046a) {
        int a = c1046a.m3802a();
        int c = c1046a.m3813c(0);
        if (c != a) {
            return c;
        }
        throw C1198j.m4509a();
    }

    private static int[] m4155c(C1046a c1046a, int i, int[] iArr) {
        int length = iArr.length;
        Object obj = new int[length];
        int a = c1046a.m3802a();
        int i2 = i;
        int i3 = 0;
        int i4 = 0;
        while (i < a) {
            if ((c1046a.m3807a(i) ^ i4) != 0) {
                obj[i3] = obj[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else if (C1108l.m4044a((int[]) obj, iArr, 199) < 107) {
                    return new int[]{i2, i};
                } else {
                    i2 += obj[0] + obj[1];
                    System.arraycopy(obj, 2, obj, 0, length - 2);
                    obj[length - 2] = null;
                    obj[length - 1] = null;
                    i3--;
                }
                obj[i3] = 1;
                i4 = i4 == 0 ? 1 : 0;
            }
            i++;
        }
        throw C1198j.m4509a();
    }

    public C1199m mo1426a(int i, C1046a c1046a, Map<C1084e, ?> map) {
        int i2;
        int[] a = m4157a(c1046a);
        int[] b = m4158b(c1046a);
        StringBuilder stringBuilder = new StringBuilder(20);
        C1126i.m4153a(c1046a, a[1], b[0], stringBuilder);
        String stringBuilder2 = stringBuilder.toString();
        int[] iArr = map != null ? (int[]) map.get(C1084e.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = f2405b;
        }
        int length = stringBuilder2.length();
        for (int i3 : r0) {
            if (length == i3) {
                i2 = 1;
                break;
            }
        }
        i2 = 0;
        if (i2 == 0) {
            throw C1155g.m4329a();
        }
        return new C1199m(stringBuilder2, null, new C1178o[]{new C1178o((float) a[1], (float) i), new C1178o((float) b[0], (float) i)}, C1016a.ITF);
    }

    int[] m4157a(C1046a c1046a) {
        int[] c = C1126i.m4155c(c1046a, C1126i.m4154c(c1046a), f2406d);
        this.f2408c = (c[1] - c[0]) >> 2;
        m4152a(c1046a, c[0]);
        return c;
    }

    int[] m4158b(C1046a c1046a) {
        c1046a.m3817e();
        try {
            int[] c = C1126i.m4155c(c1046a, C1126i.m4154c(c1046a), f2407e);
            m4152a(c1046a, c[0]);
            int i = c[0];
            c[0] = c1046a.m3802a() - c[1];
            c[1] = c1046a.m3802a() - i;
            return c;
        } finally {
            c1046a.m3817e();
        }
    }
}
