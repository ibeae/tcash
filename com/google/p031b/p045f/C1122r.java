package com.google.p031b.p045f;

import com.google.p031b.C1016a;
import com.google.p031b.C1078l;
import com.google.p031b.C1079d;
import com.google.p031b.C1084e;
import com.google.p031b.C1155g;
import com.google.p031b.C1178o;
import com.google.p031b.C1198j;
import com.google.p031b.C1199m;
import com.google.p031b.C1200n;
import com.google.p031b.C1201p;
import com.google.p031b.p034c.C1046a;
import java.util.Arrays;
import java.util.Map;

public abstract class C1122r extends C1108l {
    static final int[] f2392b = new int[]{1, 1, 1};
    static final int[] f2393c = new int[]{1, 1, 1, 1, 1};
    static final int[][] f2394d = new int[][]{new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
    static final int[][] f2395e = new int[20][];
    private final StringBuilder f2396a = new StringBuilder(20);
    private final C1132q f2397f = new C1132q();
    private final C1125h f2398g = new C1125h();

    static {
        System.arraycopy(f2394d, 0, f2395e, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr = f2394d[i - 10];
            int[] iArr2 = new int[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr2[i2] = iArr[(iArr.length - i2) - 1];
            }
            f2395e[i] = iArr2;
        }
    }

    protected C1122r() {
    }

    static int m4132a(C1046a c1046a, int[] iArr, int i, int[][] iArr2) {
        C1108l.m4045a(c1046a, i, iArr);
        int i2 = 122;
        int i3 = -1;
        int length = iArr2.length;
        int i4 = 0;
        while (i4 < length) {
            int a = C1108l.m4044a(iArr, iArr2[i4], 179);
            if (a < i2) {
                i3 = i4;
            } else {
                a = i2;
            }
            i4++;
            i2 = a;
        }
        if (i3 >= 0) {
            return i3;
        }
        throw C1198j.m4509a();
    }

    static boolean m4133a(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i;
        int i2 = 0;
        for (i = length - 2; i >= 0; i -= 2) {
            int charAt = charSequence.charAt(i) - 48;
            if (charAt < 0 || charAt > 9) {
                throw C1155g.m4329a();
            }
            i2 += charAt;
        }
        i2 *= 3;
        for (i = length - 1; i >= 0; i -= 2) {
            length = charSequence.charAt(i) - 48;
            if (length < 0 || length > 9) {
                throw C1155g.m4329a();
            }
            i2 += length;
        }
        return i2 % 10 == 0;
    }

    static int[] m4134a(C1046a c1046a) {
        int[] iArr = new int[f2392b.length];
        int i = 0;
        int[] iArr2 = null;
        boolean z = false;
        while (!z) {
            Arrays.fill(iArr, 0, f2392b.length, 0);
            iArr2 = C1122r.m4136a(c1046a, i, false, f2392b, iArr);
            int i2 = iArr2[0];
            i = iArr2[1];
            int i3 = i2 - (i - i2);
            if (i3 >= 0) {
                z = c1046a.m3808a(i3, i2, false);
            }
        }
        return iArr2;
    }

    static int[] m4135a(C1046a c1046a, int i, boolean z, int[] iArr) {
        return C1122r.m4136a(c1046a, i, z, iArr, new int[iArr.length]);
    }

    private static int[] m4136a(C1046a c1046a, int i, boolean z, int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int a = c1046a.m3802a();
        int d = z ? c1046a.m3815d(i) : c1046a.m3813c(i);
        int i2 = 0;
        int i3 = z;
        for (int i4 = d; i4 < a; i4++) {
            if ((c1046a.m3807a(i4) ^ i3) != 0) {
                iArr2[i2] = iArr2[i2] + 1;
            } else {
                if (i2 != length - 1) {
                    i2++;
                } else if (C1108l.m4044a(iArr2, iArr, 179) < 122) {
                    return new int[]{d, i4};
                } else {
                    d += iArr2[0] + iArr2[1];
                    System.arraycopy(iArr2, 2, iArr2, 0, length - 2);
                    iArr2[length - 2] = 0;
                    iArr2[length - 1] = 0;
                    i2--;
                }
                iArr2[i2] = 1;
                i3 = i3 == 0 ? 1 : 0;
            }
        }
        throw C1198j.m4509a();
    }

    protected abstract int mo1429a(C1046a c1046a, int[] iArr, StringBuilder stringBuilder);

    public C1199m mo1426a(int i, C1046a c1046a, Map<C1084e, ?> map) {
        return mo1431a(i, c1046a, C1122r.m4134a(c1046a), (Map) map);
    }

    public C1199m mo1431a(int i, C1046a c1046a, int[] iArr, Map<C1084e, ?> map) {
        C1201p c1201p = map == null ? null : (C1201p) map.get(C1084e.NEED_RESULT_POINT_CALLBACK);
        if (c1201p != null) {
            c1201p.mo1530a(new C1178o(((float) (iArr[0] + iArr[1])) / 2.0f, (float) i));
        }
        StringBuilder stringBuilder = this.f2396a;
        stringBuilder.setLength(0);
        int a = mo1429a(c1046a, iArr, stringBuilder);
        if (c1201p != null) {
            c1201p.mo1530a(new C1178o((float) a, (float) i));
        }
        int[] a2 = mo1433a(c1046a, a);
        if (c1201p != null) {
            c1201p.mo1530a(new C1178o(((float) (a2[0] + a2[1])) / 2.0f, (float) i));
        }
        int i2 = a2[1];
        int i3 = (i2 - a2[0]) + i2;
        if (i3 >= c1046a.m3802a() || !c1046a.m3808a(i2, i3, false)) {
            throw C1198j.m4509a();
        }
        String stringBuilder2 = stringBuilder.toString();
        if (stringBuilder2.length() < 8) {
            throw C1155g.m4329a();
        } else if (mo1432a(stringBuilder2)) {
            float f = ((float) (iArr[1] + iArr[0])) / 2.0f;
            float f2 = ((float) (a2[1] + a2[0])) / 2.0f;
            C1016a b = mo1430b();
            C1199m c1199m = new C1199m(stringBuilder2, null, new C1178o[]{new C1178o(f, (float) i), new C1178o(f2, (float) i)}, b);
            try {
                C1199m a3 = this.f2397f.m4178a(i, c1046a, a2[1]);
                c1199m.m4511a(C1200n.UPC_EAN_EXTENSION, a3.m4510a());
                c1199m.m4512a(a3.m4517e());
                c1199m.m4513a(a3.m4515c());
            } catch (C1078l e) {
            }
            if (b == C1016a.EAN_13 || b == C1016a.UPC_A) {
                stringBuilder2 = this.f2398g.m4150a(stringBuilder2);
                if (stringBuilder2 != null) {
                    c1199m.m4511a(C1200n.POSSIBLE_COUNTRY, stringBuilder2);
                }
            }
            return c1199m;
        } else {
            throw C1079d.m3955a();
        }
    }

    boolean mo1432a(String str) {
        return C1122r.m4133a((CharSequence) str);
    }

    int[] mo1433a(C1046a c1046a, int i) {
        return C1122r.m4135a(c1046a, i, false, f2392b);
    }

    abstract C1016a mo1430b();
}
