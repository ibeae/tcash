package com.google.p031b.p045f.p046a.p047a;

import com.google.p031b.C1016a;
import com.google.p031b.C1084e;
import com.google.p031b.C1178o;
import com.google.p031b.C1198j;
import com.google.p031b.C1199m;
import com.google.p031b.p034c.C1046a;
import com.google.p031b.p045f.C1108l;
import com.google.p031b.p045f.p046a.C1109a;
import com.google.p031b.p045f.p046a.C1111b;
import com.google.p031b.p045f.p046a.C1112c;
import com.google.p031b.p045f.p046a.C1115f;
import com.google.p031b.p045f.p046a.p047a.p048a.C1085j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import twitter4j.HttpResponseCode;

public final class C1110d extends C1109a {
    private static final int[] f2347a = new int[]{7, 5, 4, 3, 1};
    private static final int[] f2348b = new int[]{4, 20, 52, 104, 204};
    private static final int[] f2349c = new int[]{0, 348, 1388, 2948, 3988};
    private static final int[][] f2350d = new int[][]{new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    private static final int[][] f2351e = new int[][]{new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, 205}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, 203, 187, 139, 206, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, HttpResponseCode.OK, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, 184, 130, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};
    private static final int[][] f2352f = new int[][]{new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
    private final List<C1106b> f2353g = new ArrayList(11);
    private final List<C1107c> f2354h = new ArrayList();
    private final int[] f2355i = new int[2];
    private boolean f2356j = false;

    private static int m4062a(C1046a c1046a, int i) {
        return c1046a.m3807a(i) ? c1046a.m3813c(c1046a.m3815d(i)) : c1046a.m3815d(c1046a.m3813c(i));
    }

    private C1112c m4063a(C1046a c1046a, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (z) {
            i2 = this.f2355i[0] - 1;
            while (i2 >= 0 && !c1046a.m3807a(i2)) {
                i2--;
            }
            i3 = i2 + 1;
            i2 = this.f2355i[0] - i3;
            i4 = this.f2355i[1];
        } else {
            i3 = this.f2355i[0];
            i4 = c1046a.m3815d(this.f2355i[1] + 1);
            i2 = i4 - this.f2355i[1];
        }
        Object b = m4056b();
        System.arraycopy(b, 0, b, 1, b.length - 1);
        b[0] = i2;
        try {
            return new C1112c(C1109a.m4052a((int[]) b, f2350d), new int[]{i3, i4}, i3, i4, i);
        } catch (C1198j e) {
            return null;
        }
    }

    static C1199m m4064a(List<C1106b> list) {
        String a = C1085j.m3971a(C1105a.m4034a(list)).mo1424a();
        C1178o[] c = ((C1106b) list.get(0)).m4039c().m4085c();
        C1178o[] c2 = ((C1106b) list.get(list.size() - 1)).m4039c().m4085c();
        return new C1199m(a, null, new C1178o[]{c[0], c[1], c2[0], c2[1]}, C1016a.RSS_EXPANDED);
    }

    private List<C1106b> m4065a(List<C1107c> list, int i) {
        while (i < this.f2354h.size()) {
            C1107c c1107c = (C1107c) this.f2354h.get(i);
            this.f2353g.clear();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f2353g.addAll(((C1107c) list.get(i2)).m4041a());
            }
            this.f2353g.addAll(c1107c.m4041a());
            if (C1110d.m4073b(this.f2353g)) {
                if (m4075h()) {
                    return this.f2353g;
                }
                List arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.add(c1107c);
                try {
                    return m4065a(arrayList, i + 1);
                } catch (C1198j e) {
                }
            }
            i++;
        }
        throw C1198j.m4509a();
    }

    private List<C1106b> m4066a(boolean z) {
        List<C1106b> list = null;
        if (this.f2354h.size() > 25) {
            this.f2354h.clear();
        } else {
            this.f2353g.clear();
            if (z) {
                Collections.reverse(this.f2354h);
            }
            try {
                list = m4065a(new ArrayList(), 0);
            } catch (C1198j e) {
            }
            if (z) {
                Collections.reverse(this.f2354h);
            }
        }
        return list;
    }

    private void m4067a(int i) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4 = null;
        Object obj5 = 1;
        int a = C1109a.m4051a(m4060f());
        int a2 = C1109a.m4051a(m4061g());
        int i2 = (a + a2) - i;
        Object obj6 = (a & 1) == 1 ? 1 : null;
        Object obj7 = (a2 & 1) == 0 ? 1 : null;
        if (a > 13) {
            obj = 1;
            obj2 = null;
        } else if (a < 4) {
            obj = null;
            int i3 = 1;
        } else {
            obj = null;
            obj2 = null;
        }
        if (a2 > 13) {
            obj3 = null;
            obj4 = 1;
        } else if (a2 < 4) {
            int i4 = 1;
        } else {
            obj3 = null;
        }
        int i5;
        if (i2 == 1) {
            if (obj6 != null) {
                if (obj7 != null) {
                    throw C1198j.m4509a();
                }
                obj = obj2;
                obj5 = obj3;
                obj3 = 1;
            } else if (obj7 == null) {
                throw C1198j.m4509a();
            } else {
                i5 = 1;
                obj5 = obj3;
                obj3 = obj;
                obj = obj2;
            }
        } else if (i2 == -1) {
            if (obj6 != null) {
                if (obj7 != null) {
                    throw C1198j.m4509a();
                }
                r12 = obj3;
                obj3 = obj;
                r3 = 1;
                obj5 = r12;
            } else if (obj7 == null) {
                throw C1198j.m4509a();
            } else {
                obj3 = obj;
                obj = obj2;
            }
        } else if (i2 != 0) {
            throw C1198j.m4509a();
        } else if (obj6 != null) {
            if (obj7 == null) {
                throw C1198j.m4509a();
            } else if (a < a2) {
                i5 = 1;
                r12 = obj3;
                obj3 = obj;
                r3 = 1;
                obj5 = r12;
            } else {
                i4 = 1;
                obj = obj2;
            }
        } else if (obj7 != null) {
            throw C1198j.m4509a();
        } else {
            obj5 = obj3;
            obj3 = obj;
            obj = obj2;
        }
        if (obj != null) {
            if (obj3 != null) {
                throw C1198j.m4509a();
            }
            C1109a.m4053a(m4060f(), m4058d());
        }
        if (obj3 != null) {
            C1109a.m4054b(m4060f(), m4058d());
        }
        if (obj5 != null) {
            if (obj4 != null) {
                throw C1198j.m4509a();
            }
            C1109a.m4053a(m4061g(), m4058d());
        }
        if (obj4 != null) {
            C1109a.m4054b(m4061g(), m4059e());
        }
    }

    private void m4068a(int i, boolean z) {
        boolean z2 = false;
        boolean z3 = false;
        int i2 = 0;
        while (i2 < this.f2354h.size()) {
            C1107c c1107c = (C1107c) this.f2354h.get(i2);
            if (c1107c.m4043b() > i) {
                z2 = c1107c.m4042a(this.f2353g);
                break;
            }
            i2++;
            z3 = c1107c.m4042a(this.f2353g);
        }
        if (!z2 && !r1 && !C1110d.m4071a(this.f2353g, this.f2354h)) {
            this.f2354h.add(i2, new C1107c(this.f2353g, i, z));
            C1110d.m4069a(this.f2353g, this.f2354h);
        }
    }

    private static void m4069a(List<C1106b> list, List<C1107c> list2) {
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            C1107c c1107c = (C1107c) it.next();
            if (c1107c.m4041a().size() != list.size()) {
                Object obj;
                for (C1106b c1106b : c1107c.m4041a()) {
                    for (C1106b equals : list) {
                        if (c1106b.equals(equals)) {
                            obj = 1;
                            continue;
                            break;
                        }
                    }
                    obj = null;
                    continue;
                    if (obj == null) {
                        obj = null;
                        break;
                    }
                }
                int i = 1;
                if (obj != null) {
                    it.remove();
                }
            }
        }
    }

    private static boolean m4070a(C1112c c1112c, boolean z, boolean z2) {
        return (c1112c.m4083a() == 0 && z && z2) ? false : true;
    }

    private static boolean m4071a(Iterable<C1106b> iterable, Iterable<C1107c> iterable2) {
        for (C1107c c1107c : iterable2) {
            for (C1106b c1106b : iterable) {
                Object obj;
                for (C1106b equals : c1107c.m4041a()) {
                    if (c1106b.equals(equals)) {
                        obj = 1;
                        continue;
                        break;
                    }
                }
                obj = null;
                continue;
                if (obj == null) {
                    Object obj2 = null;
                    continue;
                    break;
                }
            }
            int i = 1;
            continue;
            if (obj2 != null) {
                return true;
            }
        }
        return false;
    }

    private void m4072b(C1046a c1046a, List<C1106b> list, int i) {
        int[] b = m4056b();
        b[0] = 0;
        b[1] = 0;
        b[2] = 0;
        b[3] = 0;
        int a = c1046a.m3802a();
        if (i < 0) {
            i = list.isEmpty() ? 0 : ((C1106b) list.get(list.size() - 1)).m4039c().m4084b()[1];
        }
        Object obj = list.size() % 2 != 0 ? 1 : null;
        if (this.f2356j) {
            obj = obj == null ? 1 : null;
        }
        int i2 = 0;
        int i3 = i;
        while (i3 < a) {
            i2 = !c1046a.m3807a(i3) ? 1 : 0;
            if (i2 == 0) {
                break;
            }
            i3++;
        }
        int i4 = i3;
        i3 = 0;
        int i5 = i2;
        i2 = i4;
        for (int i6 = i3; i6 < a; i6++) {
            if ((c1046a.m3807a(i6) ^ i5) != 0) {
                b[i3] = b[i3] + 1;
            } else {
                if (i3 == 3) {
                    if (obj != null) {
                        C1110d.m4074c(b);
                    }
                    if (C1109a.m4055b(b)) {
                        this.f2355i[0] = i2;
                        this.f2355i[1] = i6;
                        return;
                    }
                    if (obj != null) {
                        C1110d.m4074c(b);
                    }
                    i2 += b[0] + b[1];
                    b[0] = b[2];
                    b[1] = b[3];
                    b[2] = 0;
                    b[3] = 0;
                    i3--;
                } else {
                    i3++;
                }
                b[i3] = 1;
                i5 = i5 == 0 ? 1 : 0;
            }
        }
        throw C1198j.m4509a();
    }

    private static boolean m4073b(List<C1106b> list) {
        for (int[] iArr : f2352f) {
            if (list.size() <= iArr.length) {
                boolean z;
                for (int i = 0; i < list.size(); i++) {
                    if (((C1106b) list.get(i)).m4039c().m4083a() != iArr[i]) {
                        z = false;
                        break;
                    }
                }
                z = true;
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void m4074c(int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length / 2; i++) {
            int i2 = iArr[i];
            iArr[i] = iArr[(length - i) - 1];
            iArr[(length - i) - 1] = i2;
        }
    }

    private boolean m4075h() {
        boolean z = true;
        C1106b c1106b = (C1106b) this.f2353g.get(0);
        C1111b a = c1106b.m4037a();
        C1111b b = c1106b.m4038b();
        if (b == null) {
            return false;
        }
        int i = 2;
        int b2 = b.m4082b();
        for (int i2 = 1; i2 < this.f2353g.size(); i2++) {
            c1106b = (C1106b) this.f2353g.get(i2);
            b2 += c1106b.m4037a().m4082b();
            i++;
            b = c1106b.m4038b();
            if (b != null) {
                b2 += b.m4082b();
                i++;
            }
        }
        if ((b2 % 211) + ((i - 4) * 211) != a.m4081a()) {
            z = false;
        }
        return z;
    }

    C1106b m4076a(C1046a c1046a, List<C1106b> list, int i) {
        boolean z;
        C1112c a;
        boolean z2 = list.size() % 2 == 0;
        if (this.f2356j) {
            z = !z2;
        } else {
            z = z2;
        }
        int i2 = -1;
        boolean z3 = true;
        do {
            m4072b(c1046a, list, i2);
            a = m4063a(c1046a, i, z);
            if (a == null) {
                i2 = C1110d.m4062a(c1046a, this.f2355i[0]);
                continue;
            } else {
                z3 = false;
                continue;
            }
        } while (z3);
        C1111b a2 = m4077a(c1046a, a, z, true);
        if (list.isEmpty() || !((C1106b) list.get(list.size() - 1)).m4040d()) {
            C1111b a3;
            try {
                a3 = m4077a(c1046a, a, z, false);
            } catch (C1198j e) {
                a3 = null;
            }
            return new C1106b(a2, a3, a, true);
        }
        throw C1198j.m4509a();
    }

    C1111b m4077a(C1046a c1046a, C1112c c1112c, boolean z, boolean z2) {
        int i;
        int length;
        int[] c = m4057c();
        c[0] = 0;
        c[1] = 0;
        c[2] = 0;
        c[3] = 0;
        c[4] = 0;
        c[5] = 0;
        c[6] = 0;
        c[7] = 0;
        if (z2) {
            C1108l.m4047b(c1046a, c1112c.m4084b()[0], c);
        } else {
            C1108l.m4045a(c1046a, c1112c.m4084b()[1], c);
            i = 0;
            for (length = c.length - 1; i < length; length--) {
                int i2 = c[i];
                c[i] = c[length];
                c[length] = i2;
                i++;
            }
        }
        float a = ((float) C1109a.m4051a(c)) / ((float) 17);
        float f = ((float) (c1112c.m4084b()[1] - c1112c.m4084b()[0])) / 15.0f;
        if (Math.abs(a - f) / f > 0.3f) {
            throw C1198j.m4509a();
        }
        int length2;
        int[] f2 = m4060f();
        int[] g = m4061g();
        float[] d = m4058d();
        float[] e = m4059e();
        for (length = 0; length < c.length; length++) {
            float f3 = (1.0f * ((float) c[length])) / a;
            i = (int) (0.5f + f3);
            if (i < 1) {
                if (f3 < 0.3f) {
                    throw C1198j.m4509a();
                }
                i = 1;
            } else if (i > 8) {
                if (f3 > 8.7f) {
                    throw C1198j.m4509a();
                }
                i = 8;
            }
            int i3 = length >> 1;
            if ((length & 1) == 0) {
                f2[i3] = i;
                d[i3] = f3 - ((float) i);
            } else {
                g[i3] = i;
                e[i3] = f3 - ((float) i);
            }
        }
        m4067a(17);
        int a2 = ((z2 ? 0 : 1) + ((c1112c.m4083a() * 4) + (z ? 0 : 2))) - 1;
        i2 = 0;
        i = f2.length - 1;
        length = 0;
        while (i >= 0) {
            if (C1110d.m4070a(c1112c, z, z2)) {
                length += f2351e[a2][i * 2] * f2[i];
            }
            i--;
            i2 = f2[i] + i2;
        }
        i = 0;
        for (length2 = g.length - 1; length2 >= 0; length2--) {
            if (C1110d.m4070a(c1112c, z, z2)) {
                i += f2351e[a2][(length2 * 2) + 1] * g[length2];
            }
        }
        length += i;
        if ((i2 & 1) != 0 || i2 > 13 || i2 < 4) {
            throw C1198j.m4509a();
        }
        i = (13 - i2) / 2;
        length2 = f2347a[i];
        return new C1111b(f2349c[i] + ((C1115f.m4100a(f2, length2, true) * f2348b[i]) + C1115f.m4100a(g, 9 - length2, false)), length);
    }

    public C1199m mo1426a(int i, C1046a c1046a, Map<C1084e, ?> map) {
        this.f2353g.clear();
        this.f2356j = false;
        try {
            return C1110d.m4064a(m4079a(i, c1046a));
        } catch (C1198j e) {
            this.f2353g.clear();
            this.f2356j = true;
            return C1110d.m4064a(m4079a(i, c1046a));
        }
    }

    List<C1106b> m4079a(int i, C1046a c1046a) {
        while (true) {
            try {
                this.f2353g.add(m4076a(c1046a, this.f2353g, i));
            } catch (C1198j e) {
                if (this.f2353g.isEmpty()) {
                    throw e;
                } else if (m4075h()) {
                    return this.f2353g;
                } else {
                    boolean z = !this.f2354h.isEmpty();
                    m4068a(i, false);
                    if (z) {
                        List<C1106b> a = m4066a(false);
                        if (a != null) {
                            return a;
                        }
                        a = m4066a(true);
                        if (a != null) {
                            return a;
                        }
                    }
                    throw C1198j.m4509a();
                }
            }
        }
    }

    public void mo1415a() {
        this.f2353g.clear();
        this.f2354h.clear();
    }
}
