package com.google.p031b.p049g.p050a;

import android.support.v4.app.NotificationCompat;
import com.google.p031b.C1079d;
import com.google.p031b.C1155g;
import com.google.p031b.C1178o;
import com.google.p031b.C1198j;
import com.google.p031b.p034c.C1052b;
import com.google.p031b.p034c.C1055e;
import com.google.p031b.p049g.C1150a;
import com.google.p031b.p049g.p050a.p051a.C1135a;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class C1149j {
    private static final C1135a f2482a = new C1135a();

    private static int m4280a(int i) {
        return 2 << i;
    }

    private static int m4281a(C1145f c1145f, int i, int i2, boolean z) {
        int i3 = z ? 1 : -1;
        C1141d c1141d = null;
        if (C1149j.m4295a(c1145f, i - i3)) {
            c1141d = c1145f.m4254a(i - i3).m4267c(i2);
        }
        if (c1141d != null) {
            return z ? c1141d.m4234e() : c1141d.m4233d();
        } else {
            c1141d = c1145f.m4254a(i).m4263a(i2);
            if (c1141d != null) {
                return z ? c1141d.m4233d() : c1141d.m4234e();
            } else {
                if (C1149j.m4295a(c1145f, i - i3)) {
                    c1141d = c1145f.m4254a(i - i3).m4263a(i2);
                }
                if (c1141d != null) {
                    return z ? c1141d.m4234e() : c1141d.m4233d();
                } else {
                    int i4 = 0;
                    while (C1149j.m4295a(c1145f, i - i3)) {
                        i -= i3;
                        for (C1141d c1141d2 : c1145f.m4254a(i).m4266b()) {
                            if (c1141d2 != null) {
                                return ((i3 * i4) * (c1141d2.m4234e() - c1141d2.m4233d())) + (z ? c1141d2.m4234e() : c1141d2.m4233d());
                            }
                        }
                        i4++;
                    }
                    return z ? c1145f.m4261e().m4219a() : c1145f.m4261e().m4221b();
                }
            }
        }
    }

    private static int m4282a(int[] iArr) {
        int i = -1;
        for (int max : iArr) {
            i = Math.max(i, max);
        }
        return i;
    }

    private static int m4283a(int[] iArr, int[] iArr2, int i) {
        if ((iArr2 == null || iArr2.length <= (i / 2) + 3) && i >= 0 && i <= NotificationCompat.FLAG_GROUP_SUMMARY) {
            return f2482a.m4188a(iArr, i, iArr2);
        }
        throw C1079d.m3955a();
    }

    private static C1055e m4284a(int i, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) {
        int[] iArr5 = new int[iArr3.length];
        int i2 = 100;
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0) {
                for (i2 = 0; i2 < iArr5.length; i2++) {
                    iArr[iArr3[i2]] = iArr4[i2][iArr5[i2]];
                }
                try {
                    break;
                } catch (C1079d e) {
                    if (iArr5.length == 0) {
                        throw C1079d.m3955a();
                    }
                    for (i2 = 0; i2 < iArr5.length; i2++) {
                        if (iArr5[i2] < iArr4[i2].length - 1) {
                            iArr5[i2] = iArr5[i2] + 1;
                            break;
                        }
                        iArr5[i2] = 0;
                        if (i2 == iArr5.length - 1) {
                            throw C1079d.m3955a();
                        }
                    }
                    i2 = i3;
                }
            } else {
                throw C1079d.m3955a();
            }
        }
        return C1149j.m4287a(iArr, i, iArr2);
    }

    public static C1055e m4285a(C1052b c1052b, C1178o c1178o, C1178o c1178o2, C1178o c1178o3, C1178o c1178o4, int i, int i2) {
        C1146g c1146g = null;
        int i3 = 0;
        C1140c c1140c = new C1140c(c1052b, c1178o, c1178o2, c1178o3, c1178o4);
        C1145f c1145f = null;
        C1146g c1146g2 = null;
        while (i3 < 2) {
            C1146g a = c1178o != null ? C1149j.m4291a(c1052b, c1140c, c1178o, true, i, i2) : c1146g2;
            C1146g a2 = c1178o3 != null ? C1149j.m4291a(c1052b, c1140c, c1178o3, false, i, i2) : c1146g;
            C1145f a3 = C1149j.m4290a((C1147h) a, (C1147h) a2);
            if (a3 == null) {
                throw C1198j.m4509a();
            } else if (i3 != 0 || a3.m4261e() == null || (a3.m4261e().m4222c() >= c1140c.m4222c() && a3.m4261e().m4223d() <= c1140c.m4223d())) {
                a3.m4256a(c1140c);
                c1146g = a2;
                c1145f = a3;
                c1146g2 = a;
                break;
            } else {
                i3++;
                c1146g = a2;
                c1145f = a3;
                c1140c = a3.m4261e();
                c1146g2 = a;
            }
        }
        int b = c1145f.m4258b() + 1;
        c1145f.m4255a(0, c1146g2);
        c1145f.m4255a(b, c1146g);
        boolean z = c1146g2 != null;
        int i4 = 1;
        int i5 = i2;
        i3 = i;
        while (i4 <= b) {
            int i6 = z ? i4 : b - i4;
            if (c1145f.m4254a(i6) == null) {
                C1146g c1147h;
                if (i6 == 0 || i6 == b) {
                    c1147h = new C1147h(c1140c, i6 == 0);
                } else {
                    c1147h = new C1146g(c1140c);
                }
                c1145f.m4255a(i6, c1147h);
                int c = c1140c.m4222c();
                int i7 = -1;
                while (c <= c1140c.m4223d()) {
                    int i8;
                    int a4 = C1149j.m4281a(c1145f, i6, c, z);
                    if (a4 < 0 || a4 > c1140c.m4221b()) {
                        if (i7 == -1) {
                            i8 = i7;
                            c++;
                            i7 = i8;
                        } else {
                            a4 = i7;
                        }
                    }
                    C1141d a5 = C1149j.m4289a(c1052b, c1140c.m4219a(), c1140c.m4221b(), z, a4, c, i3, i5);
                    if (a5 != null) {
                        c1147h.m4264a(c, a5);
                        i3 = Math.min(i3, a5.m4232c());
                        i5 = Math.max(i5, a5.m4232c());
                        i8 = a4;
                    } else {
                        i8 = i7;
                    }
                    c++;
                    i7 = i8;
                }
            }
            i4++;
        }
        return C1149j.m4286a(c1145f);
    }

    private static C1055e m4286a(C1145f c1145f) {
        int i = 0;
        C1139b[][] b = C1149j.m4301b(c1145f);
        C1149j.m4292a(c1145f, b);
        Collection arrayList = new ArrayList();
        int[] iArr = new int[(c1145f.m4259c() * c1145f.m4258b())];
        List arrayList2 = new ArrayList();
        Collection arrayList3 = new ArrayList();
        for (int i2 = 0; i2 < c1145f.m4259c(); i2++) {
            for (int i3 = 0; i3 < c1145f.m4258b(); i3++) {
                Object a = b[i2][i3 + 1].m4215a();
                int b2 = (c1145f.m4258b() * i2) + i3;
                if (a.length == 0) {
                    arrayList.add(Integer.valueOf(b2));
                } else if (a.length == 1) {
                    iArr[b2] = a[0];
                } else {
                    arrayList3.add(Integer.valueOf(b2));
                    arrayList2.add(a);
                }
            }
        }
        int[][] iArr2 = new int[arrayList2.size()][];
        while (i < iArr2.length) {
            iArr2[i] = (int[]) arrayList2.get(i);
            i++;
        }
        return C1149j.m4284a(c1145f.m4260d(), iArr, C1150a.m4305a(arrayList), C1150a.m4305a(arrayList3), iArr2);
    }

    private static C1055e m4287a(int[] iArr, int i, int[] iArr2) {
        if (iArr.length == 0) {
            throw C1155g.m4329a();
        }
        int i2 = 1 << (i + 1);
        int a = C1149j.m4283a(iArr, iArr2, i2);
        C1149j.m4293a(iArr, i2);
        C1055e a2 = C1144e.m4241a(iArr, String.valueOf(i));
        a2.m3864a(Integer.valueOf(a));
        a2.m3868b(Integer.valueOf(iArr2.length));
        return a2;
    }

    private static C1140c m4288a(C1147h c1147h) {
        if (c1147h == null) {
            return null;
        }
        int[] d = c1147h.m4272d();
        if (d == null) {
            return null;
        }
        int length;
        int a = C1149j.m4282a(d);
        int i = 0;
        for (int i2 : d) {
            i += a - i2;
            if (i2 > 0) {
                break;
            }
        }
        C1141d[] b = c1147h.m4266b();
        int i3 = i;
        i = 0;
        while (i3 > 0 && b[i] == null) {
            i3--;
            i++;
        }
        i = 0;
        for (length = d.length - 1; length >= 0; length--) {
            i += a - d[length];
            if (d[length] > 0) {
                break;
            }
        }
        length = i;
        i = b.length - 1;
        while (length > 0 && b[i] == null) {
            length--;
            i--;
        }
        return c1147h.m4262a().m4220a(i3, length, c1147h.m4274f());
    }

    private static C1141d m4289a(C1052b c1052b, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        int b = C1149j.m4297b(c1052b, i, i2, z, i3, i4);
        int[] a = C1149j.m4296a(c1052b, i, i2, z, b, i4);
        if (a == null) {
            return null;
        }
        int i7;
        int a2 = C1150a.m4304a(a);
        if (z) {
            i7 = b;
            b += a2;
        } else {
            for (i7 = 0; i7 < (a.length >> 1); i7++) {
                int i8 = a[i7];
                a[i7] = a[(a.length - 1) - i7];
                a[(a.length - 1) - i7] = i8;
            }
            i7 = b - a2;
        }
        if (!C1149j.m4294a(a2, i5, i6)) {
            return null;
        }
        a2 = C1148i.m4275a(a);
        i8 = C1150a.m4303a((long) a2);
        return i8 == -1 ? null : new C1141d(i7, b, C1149j.m4302c(a2), i8);
    }

    private static C1145f m4290a(C1147h c1147h, C1147h c1147h2) {
        if (c1147h == null && c1147h2 == null) {
            return null;
        }
        C1138a b = C1149j.m4299b(c1147h, c1147h2);
        return b != null ? new C1145f(b, C1140c.m4216a(C1149j.m4288a(c1147h), C1149j.m4288a(c1147h2))) : null;
    }

    private static C1147h m4291a(C1052b c1052b, C1140c c1140c, C1178o c1178o, boolean z, int i, int i2) {
        C1147h c1147h = new C1147h(c1140c, z);
        int i3 = 0;
        while (i3 < 2) {
            int i4 = i3 == 0 ? 1 : -1;
            int a = (int) c1178o.m4396a();
            int b = (int) c1178o.m4397b();
            while (b <= c1140c.m4223d() && b >= c1140c.m4222c()) {
                C1141d a2 = C1149j.m4289a(c1052b, 0, c1052b.m3855d(), z, a, b, i, i2);
                if (a2 != null) {
                    c1147h.m4264a(b, a2);
                    a = z ? a2.m4233d() : a2.m4234e();
                }
                b += i4;
            }
            i3++;
        }
        return c1147h;
    }

    private static void m4292a(C1145f c1145f, C1139b[][] c1139bArr) {
        int[] a = c1139bArr[0][1].m4215a();
        int b = (c1145f.m4258b() * c1145f.m4259c()) - C1149j.m4280a(c1145f.m4260d());
        if (a.length == 0) {
            if (b < 1 || b > 928) {
                throw C1198j.m4509a();
            }
            c1139bArr[0][1].m4214a(b);
        } else if (a[0] != b) {
            c1139bArr[0][1].m4214a(b);
        }
    }

    private static void m4293a(int[] iArr, int i) {
        if (iArr.length < 4) {
            throw C1155g.m4329a();
        }
        int i2 = iArr[0];
        if (i2 > iArr.length) {
            throw C1155g.m4329a();
        } else if (i2 != 0) {
        } else {
            if (i < iArr.length) {
                iArr[0] = iArr.length - i;
                return;
            }
            throw C1155g.m4329a();
        }
    }

    private static boolean m4294a(int i, int i2, int i3) {
        return i2 + -2 <= i && i <= i3 + 2;
    }

    private static boolean m4295a(C1145f c1145f, int i) {
        return i >= 0 && i <= c1145f.m4258b() + 1;
    }

    private static int[] m4296a(C1052b c1052b, int i, int i2, boolean z, int i3, int i4) {
        int[] iArr = new int[8];
        int i5 = z ? 1 : -1;
        boolean z2 = z;
        int i6 = 0;
        while (true) {
            if (((z && i3 < i2) || (!z && i3 >= i)) && i6 < iArr.length) {
                if (c1052b.m3848a(i3, i4) == z2) {
                    iArr[i6] = iArr[i6] + 1;
                    i3 += i5;
                } else {
                    i6++;
                    z2 = !z2;
                }
            }
        }
        return (i6 == iArr.length || (((z && i3 == i2) || (!z && i3 == i)) && i6 == iArr.length - 1)) ? iArr : null;
    }

    private static int m4297b(C1052b c1052b, int i, int i2, boolean z, int i3, int i4) {
        int i5 = 0;
        int i6 = z ? -1 : 1;
        int i7 = i3;
        while (i5 < 2) {
            int i8 = i7;
            while (true) {
                if (((!z || i8 < i) && (z || i8 >= i2)) || z != c1052b.m3848a(i8, i4)) {
                    i6 = -i6;
                } else if (Math.abs(i3 - i8) > 2) {
                    return i3;
                } else {
                    i8 += i6;
                }
            }
            i6 = -i6;
            i5++;
            z = !z;
            i7 = i8;
        }
        return i7;
    }

    private static int m4298b(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    private static C1138a m4299b(C1147h c1147h, C1147h c1147h2) {
        if (c1147h == null || c1147h.m4273e() == null) {
            return c1147h2 == null ? null : c1147h2.m4273e();
        } else {
            if (c1147h2 == null || c1147h2.m4273e() == null) {
                return c1147h != null ? c1147h.m4273e() : null;
            } else {
                C1138a e = c1147h.m4273e();
                C1138a e2 = c1147h2.m4273e();
                return (e.m4209a() == e2.m4209a() || e.m4210b() == e2.m4210b() || e.m4211c() == e2.m4211c()) ? e : null;
            }
        }
    }

    private static int[] m4300b(int i) {
        int[] iArr = new int[8];
        int i2 = 0;
        int length = iArr.length - 1;
        while (true) {
            if ((i & 1) != i2) {
                i2 = i & 1;
                length--;
                if (length < 0) {
                    return iArr;
                }
            }
            iArr[length] = iArr[length] + 1;
            i >>= 1;
        }
    }

    private static C1139b[][] m4301b(C1145f c1145f) {
        int i;
        int i2;
        C1139b[][] c1139bArr = (C1139b[][]) Array.newInstance(C1139b.class, new int[]{c1145f.m4259c(), c1145f.m4258b() + 2});
        for (i = 0; i < c1139bArr.length; i++) {
            for (i2 = 0; i2 < c1139bArr[i].length; i2++) {
                c1139bArr[i][i2] = new C1139b();
            }
        }
        C1146g[] a = c1145f.m4257a();
        int length = a.length;
        i2 = 0;
        i = -1;
        while (i2 < length) {
            C1146g c1146g = a[i2];
            int i3 = i + 1;
            if (c1146g != null) {
                for (C1141d c1141d : c1146g.m4266b()) {
                    if (!(c1141d == null || c1141d.m4237h() == -1)) {
                        c1139bArr[c1141d.m4237h()][i3].m4214a(c1141d.m4236g());
                    }
                }
            }
            i2++;
            i = i3;
        }
        return c1139bArr;
    }

    private static int m4302c(int i) {
        return C1149j.m4298b(C1149j.m4300b(i));
    }
}
