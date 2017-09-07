package com.google.p031b.p049g.p052b;

import com.google.p031b.C1062c;
import com.google.p031b.C1084e;
import com.google.p031b.C1178o;
import com.google.p031b.p034c.C1046a;
import com.google.p031b.p034c.C1052b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class C1151a {
    private static final int[] f2486a = new int[]{0, 4, 1, 5};
    private static final int[] f2487b = new int[]{6, 2, 7, 3};
    private static final int[] f2488c = new int[]{8, 1, 1, 1, 1, 1, 1, 3};
    private static final int[] f2489d = new int[]{7, 1, 1, 3, 1, 1, 1, 2, 1};

    private static int m4307a(int[] iArr, int[] iArr2, int i) {
        int i2;
        int length = iArr.length;
        int i3 = 0;
        int i4 = 0;
        for (i2 = 0; i2 < length; i2++) {
            i4 += iArr[i2];
            i3 += iArr2[i2];
        }
        if (i4 < i3) {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        int i5 = (i4 << 8) / i3;
        int i6 = (i * i5) >> 8;
        i3 = 0;
        for (i2 = 0; i2 < length; i2++) {
            int i7 = iArr[i2] << 8;
            int i8 = iArr2[i2] * i5;
            i7 = i7 > i8 ? i7 - i8 : i8 - i7;
            if (i7 > i6) {
                return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            i3 += i7;
        }
        return i3 / i4;
    }

    static C1046a m4308a(C1046a c1046a, C1046a c1046a2) {
        c1046a2.m3814c();
        int a = c1046a.m3802a();
        for (int i = 0; i < a; i++) {
            if (c1046a.m3807a(i)) {
                c1046a2.m3810b((a - 1) - i);
            }
        }
        return c1046a2;
    }

    public static C1152b m4309a(C1062c c1062c, Map<C1084e, ?> map, boolean z) {
        C1052b c = c1062c.m3899c();
        List a = C1151a.m4310a(z, c);
        if (a.isEmpty()) {
            C1151a.m4311a(c);
            a = C1151a.m4310a(z, c);
        }
        return new C1152b(c, a);
    }

    private static List<C1178o[]> m4310a(boolean z, C1052b c1052b) {
        List<C1178o[]> arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i3 < c1052b.m3856e()) {
            Object a = C1151a.m4314a(c1052b, i3, i2);
            if (a[0] != null || a[3] != null) {
                arrayList.add(a);
                if (!z) {
                    break;
                }
                if (a[2] != null) {
                    i = (int) a[2].m4396a();
                    i2 = (int) a[2].m4397b();
                } else {
                    i = (int) a[4].m4396a();
                    i2 = (int) a[4].m4397b();
                }
                i3 = i2;
                i2 = i;
                i = 1;
            } else if (i == 0) {
                break;
            } else {
                for (C1178o[] c1178oArr : arrayList) {
                    if (c1178oArr[1] != null) {
                        i3 = (int) Math.max((float) i3, c1178oArr[1].m4397b());
                    }
                    if (c1178oArr[3] != null) {
                        i3 = Math.max(i3, (int) c1178oArr[3].m4397b());
                    }
                }
                i2 = 0;
                i3 += 5;
                i = 0;
            }
        }
        return arrayList;
    }

    static void m4311a(C1052b c1052b) {
        int d = c1052b.m3855d();
        int e = c1052b.m3856e();
        C1046a c1046a = new C1046a(d);
        C1046a c1046a2 = new C1046a(d);
        C1046a c1046a3 = new C1046a(d);
        for (d = 0; d < ((e + 1) >> 1); d++) {
            c1046a = c1052b.m3846a(d, c1046a);
            c1052b.m3851b(d, C1151a.m4308a(c1052b.m3846a((e - 1) - d, c1046a2), c1046a3));
            c1052b.m3851b((e - 1) - d, C1151a.m4308a(c1046a, c1046a3));
        }
    }

    private static void m4312a(C1178o[] c1178oArr, C1178o[] c1178oArr2, int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            c1178oArr[iArr[i]] = c1178oArr2[i];
        }
    }

    private static int[] m4313a(C1052b c1052b, int i, int i2, int i3, boolean z, int[] iArr, int[] iArr2) {
        int i4;
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int length = iArr.length;
        int i5 = 0;
        while (c1052b.m3848a(i, i2) && i > 0) {
            i4 = i5 + 1;
            if (i5 >= 3) {
                break;
            }
            i--;
            i5 = i4;
        }
        i5 = 0;
        i4 = i;
        int i6 = z;
        while (i < i3) {
            if ((c1052b.m3848a(i, i2) ^ i6) != 0) {
                iArr2[i5] = iArr2[i5] + 1;
            } else {
                if (i5 != length - 1) {
                    i5++;
                } else if (C1151a.m4307a(iArr2, iArr, 204) < 107) {
                    return new int[]{i4, i};
                } else {
                    i4 += iArr2[0] + iArr2[1];
                    System.arraycopy(iArr2, 2, iArr2, 0, length - 2);
                    iArr2[length - 2] = 0;
                    iArr2[length - 1] = 0;
                    i5--;
                }
                iArr2[i5] = 1;
                i6 = i6 == 0 ? 1 : 0;
            }
            i++;
        }
        if (i5 != length - 1 || C1151a.m4307a(iArr2, iArr, 204) >= 107) {
            return null;
        }
        return new int[]{i4, i - 1};
    }

    private static C1178o[] m4314a(C1052b c1052b, int i, int i2) {
        int a;
        int b;
        int e = c1052b.m3856e();
        int d = c1052b.m3855d();
        C1178o[] c1178oArr = new C1178o[8];
        C1151a.m4312a(c1178oArr, C1151a.m4315a(c1052b, e, d, i, i2, f2488c), f2486a);
        if (c1178oArr[4] != null) {
            a = (int) c1178oArr[4].m4396a();
            b = (int) c1178oArr[4].m4397b();
        } else {
            a = i2;
            b = i;
        }
        C1151a.m4312a(c1178oArr, C1151a.m4315a(c1052b, e, d, b, a, f2489d), f2487b);
        return c1178oArr;
    }

    private static C1178o[] m4315a(C1052b c1052b, int i, int i2, int i3, int i4, int[] iArr) {
        int[] iArr2;
        int i5;
        Object obj;
        int i6;
        C1178o[] c1178oArr = new C1178o[4];
        int[] iArr3 = new int[iArr.length];
        int i7 = i3;
        while (i7 < i) {
            int[] a = C1151a.m4313a(c1052b, i4, i7, i2, false, iArr, iArr3);
            int i8;
            int i9;
            if (a != null) {
                iArr2 = a;
                i5 = i7;
                while (i5 > 0) {
                    i7 = i5 - 1;
                    a = C1151a.m4313a(c1052b, i4, i7, i2, false, iArr, iArr3);
                    if (a == null) {
                        i5 = i7 + 1;
                        break;
                    }
                    iArr2 = a;
                    i5 = i7;
                }
                c1178oArr[0] = new C1178o((float) iArr2[0], (float) i5);
                c1178oArr[1] = new C1178o((float) iArr2[1], (float) i5);
                obj = 1;
                i6 = i5;
                i5 = i6 + 1;
                if (obj != null) {
                    iArr2 = new int[]{(int) c1178oArr[0].m4396a(), (int) c1178oArr[1].m4396a()};
                    i8 = 0;
                    i7 = i5;
                    while (i7 < i) {
                        a = C1151a.m4313a(c1052b, iArr2[0], i7, i2, false, iArr, iArr3);
                        if (a == null && Math.abs(iArr2[0] - a[0]) < 5 && Math.abs(iArr2[1] - a[1]) < 5) {
                            i9 = 0;
                        } else if (i8 > 25) {
                            break;
                        } else {
                            i9 = i8 + 1;
                            a = iArr2;
                        }
                        i7++;
                        iArr2 = a;
                        i8 = i9;
                    }
                    i5 = i7 - (i8 + 1);
                    c1178oArr[2] = new C1178o((float) iArr2[0], (float) i5);
                    c1178oArr[3] = new C1178o((float) iArr2[1], (float) i5);
                }
                if (i5 - i6 < 10) {
                    for (i5 = 0; i5 < c1178oArr.length; i5++) {
                        c1178oArr[i5] = null;
                    }
                }
                return c1178oArr;
            }
            i7 += 5;
        }
        obj = null;
        i6 = i7;
        i5 = i6 + 1;
        if (obj != null) {
            iArr2 = new int[]{(int) c1178oArr[0].m4396a(), (int) c1178oArr[1].m4396a()};
            i8 = 0;
            i7 = i5;
            while (i7 < i) {
                a = C1151a.m4313a(c1052b, iArr2[0], i7, i2, false, iArr, iArr3);
                if (a == null) {
                }
                if (i8 > 25) {
                    break;
                }
                i9 = i8 + 1;
                a = iArr2;
                i7++;
                iArr2 = a;
                i8 = i9;
            }
            i5 = i7 - (i8 + 1);
            c1178oArr[2] = new C1178o((float) iArr2[0], (float) i5);
            c1178oArr[3] = new C1178o((float) iArr2[1], (float) i5);
        }
        if (i5 - i6 < 10) {
            for (i5 = 0; i5 < c1178oArr.length; i5++) {
                c1178oArr[i5] = null;
            }
        }
        return c1178oArr;
    }
}
