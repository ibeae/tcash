package com.google.p031b.p040d.p042b;

import com.google.p031b.C1178o;
import com.google.p031b.C1198j;
import com.google.p031b.p034c.C1010g;
import com.google.p031b.p034c.C1052b;
import com.google.p031b.p034c.C1056i;
import com.google.p031b.p034c.p038a.C1044a;
import com.google.p031b.p034c.p038a.C1045b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class C1077a {
    private final C1052b f2284a;
    private final C1045b f2285b;

    private static final class C1075a {
        private final C1178o f2281a;
        private final C1178o f2282b;
        private final int f2283c;

        private C1075a(C1178o c1178o, C1178o c1178o2, int i) {
            this.f2281a = c1178o;
            this.f2282b = c1178o2;
            this.f2283c = i;
        }

        C1178o m3943a() {
            return this.f2281a;
        }

        C1178o m3944b() {
            return this.f2282b;
        }

        public int m3945c() {
            return this.f2283c;
        }

        public String toString() {
            return this.f2281a + "/" + this.f2282b + '/' + this.f2283c;
        }
    }

    private static final class C1076b implements Serializable, Comparator<C1075a> {
        private C1076b() {
        }

        public int m3946a(C1075a c1075a, C1075a c1075a2) {
            return c1075a.m3945c() - c1075a2.m3945c();
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m3946a((C1075a) obj, (C1075a) obj2);
        }
    }

    public C1077a(C1052b c1052b) {
        this.f2284a = c1052b;
        this.f2285b = new C1045b(c1052b);
    }

    private static int m3947a(C1178o c1178o, C1178o c1178o2) {
        return C1044a.m3795a(C1178o.m4393a(c1178o, c1178o2));
    }

    private static C1052b m3948a(C1052b c1052b, C1178o c1178o, C1178o c1178o2, C1178o c1178o3, C1178o c1178o4, int i, int i2) {
        return C1056i.m3872a().mo1418a(c1052b, i, i2, 0.5f, 0.5f, ((float) i) - 0.5f, 0.5f, ((float) i) - 0.5f, ((float) i2) - 0.5f, 0.5f, ((float) i2) - 0.5f, c1178o.m4396a(), c1178o.m4397b(), c1178o4.m4396a(), c1178o4.m4397b(), c1178o3.m4396a(), c1178o3.m4397b(), c1178o2.m4396a(), c1178o2.m4397b());
    }

    private C1178o m3949a(C1178o c1178o, C1178o c1178o2, C1178o c1178o3, C1178o c1178o4, int i) {
        float a = ((float) C1077a.m3947a(c1178o, c1178o2)) / ((float) i);
        int a2 = C1077a.m3947a(c1178o3, c1178o4);
        C1178o c1178o5 = new C1178o((((c1178o4.m4396a() - c1178o3.m4396a()) / ((float) a2)) * a) + c1178o4.m4396a(), (a * ((c1178o4.m4397b() - c1178o3.m4397b()) / ((float) a2))) + c1178o4.m4397b());
        float a3 = ((float) C1077a.m3947a(c1178o, c1178o3)) / ((float) i);
        int a4 = C1077a.m3947a(c1178o2, c1178o4);
        C1178o c1178o6 = new C1178o((((c1178o4.m4396a() - c1178o2.m4396a()) / ((float) a4)) * a3) + c1178o4.m4396a(), (a3 * ((c1178o4.m4397b() - c1178o2.m4397b()) / ((float) a4))) + c1178o4.m4397b());
        return !m3952a(c1178o5) ? m3952a(c1178o6) ? c1178o6 : null : (!m3952a(c1178o6) || Math.abs(m3953b(c1178o3, c1178o5).m3945c() - m3953b(c1178o2, c1178o5).m3945c()) <= Math.abs(m3953b(c1178o3, c1178o6).m3945c() - m3953b(c1178o2, c1178o6).m3945c())) ? c1178o5 : c1178o6;
    }

    private C1178o m3950a(C1178o c1178o, C1178o c1178o2, C1178o c1178o3, C1178o c1178o4, int i, int i2) {
        float a = ((float) C1077a.m3947a(c1178o, c1178o2)) / ((float) i);
        int a2 = C1077a.m3947a(c1178o3, c1178o4);
        C1178o c1178o5 = new C1178o((((c1178o4.m4396a() - c1178o3.m4396a()) / ((float) a2)) * a) + c1178o4.m4396a(), (a * ((c1178o4.m4397b() - c1178o3.m4397b()) / ((float) a2))) + c1178o4.m4397b());
        float a3 = ((float) C1077a.m3947a(c1178o, c1178o3)) / ((float) i2);
        int a4 = C1077a.m3947a(c1178o2, c1178o4);
        C1178o c1178o6 = new C1178o((((c1178o4.m4396a() - c1178o2.m4396a()) / ((float) a4)) * a3) + c1178o4.m4396a(), (a3 * ((c1178o4.m4397b() - c1178o2.m4397b()) / ((float) a4))) + c1178o4.m4397b());
        return !m3952a(c1178o5) ? m3952a(c1178o6) ? c1178o6 : null : !m3952a(c1178o6) ? c1178o5 : Math.abs(i - m3953b(c1178o3, c1178o5).m3945c()) + Math.abs(i2 - m3953b(c1178o2, c1178o5).m3945c()) <= Math.abs(i - m3953b(c1178o3, c1178o6).m3945c()) + Math.abs(i2 - m3953b(c1178o2, c1178o6).m3945c()) ? c1178o5 : c1178o6;
    }

    private static void m3951a(Map<C1178o, Integer> map, C1178o c1178o) {
        Integer num = (Integer) map.get(c1178o);
        map.put(c1178o, Integer.valueOf(num == null ? 1 : num.intValue() + 1));
    }

    private boolean m3952a(C1178o c1178o) {
        return c1178o.m4396a() >= 0.0f && c1178o.m4396a() < ((float) this.f2284a.m3855d()) && c1178o.m4397b() > 0.0f && c1178o.m4397b() < ((float) this.f2284a.m3856e());
    }

    private C1075a m3953b(C1178o c1178o, C1178o c1178o2) {
        int a = (int) c1178o.m4396a();
        int b = (int) c1178o.m4397b();
        int a2 = (int) c1178o2.m4396a();
        int b2 = (int) c1178o2.m4397b();
        Object obj = Math.abs(b2 - b) > Math.abs(a2 - a) ? 1 : null;
        if (obj == null) {
            int i = b2;
            b2 = a2;
            a2 = i;
            int i2 = b;
            b = a;
            a = i2;
        }
        int abs = Math.abs(b2 - b);
        int abs2 = Math.abs(a2 - a);
        int i3 = (-abs) >> 1;
        int i4 = a < a2 ? 1 : -1;
        int i5 = b < b2 ? 1 : -1;
        int i6 = 0;
        boolean a3 = this.f2284a.m3848a(obj != null ? a : b, obj != null ? b : a);
        int i7 = a;
        int i8 = i3;
        while (b != b2) {
            boolean a4 = this.f2284a.m3848a(obj != null ? i7 : b, obj != null ? b : i7);
            if (a4 != a3) {
                i6++;
                a3 = a4;
            }
            a = i8 + abs2;
            if (a > 0) {
                if (i7 == a2) {
                    a2 = i6;
                    break;
                }
                i7 += i4;
                a -= abs;
            }
            b += i5;
            i8 = a;
        }
        a2 = i6;
        return new C1075a(c1178o, c1178o2, a2);
    }

    public C1010g m3954a() {
        C1178o[] a = this.f2285b.m3799a();
        C1178o c1178o = a[0];
        C1178o c1178o2 = a[1];
        C1178o c1178o3 = a[2];
        C1178o c1178o4 = a[3];
        List arrayList = new ArrayList(4);
        arrayList.add(m3953b(c1178o, c1178o2));
        arrayList.add(m3953b(c1178o, c1178o3));
        arrayList.add(m3953b(c1178o2, c1178o4));
        arrayList.add(m3953b(c1178o3, c1178o4));
        Collections.sort(arrayList, new C1076b());
        C1075a c1075a = (C1075a) arrayList.get(0);
        C1075a c1075a2 = (C1075a) arrayList.get(1);
        Map hashMap = new HashMap();
        C1077a.m3951a(hashMap, c1075a.m3943a());
        C1077a.m3951a(hashMap, c1075a.m3944b());
        C1077a.m3951a(hashMap, c1075a2.m3943a());
        C1077a.m3951a(hashMap, c1075a2.m3944b());
        C1178o c1178o5 = null;
        C1178o c1178o6 = null;
        C1178o c1178o7 = null;
        for (Entry entry : hashMap.entrySet()) {
            C1178o c1178o8;
            C1178o c1178o9 = (C1178o) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                c1178o8 = c1178o9;
                c1178o9 = c1178o7;
                c1178o7 = c1178o5;
            } else if (c1178o5 == null) {
                c1178o8 = c1178o6;
                C1178o c1178o10 = c1178o7;
                c1178o7 = c1178o9;
                c1178o9 = c1178o10;
            } else {
                c1178o8 = c1178o6;
                c1178o7 = c1178o5;
            }
            c1178o6 = c1178o8;
            c1178o5 = c1178o7;
            c1178o7 = c1178o9;
        }
        if (c1178o5 == null || c1178o6 == null || c1178o7 == null) {
            throw C1198j.m4509a();
        }
        C1052b a2;
        a = new C1178o[]{c1178o5, c1178o6, c1178o7};
        C1178o.m4395a(a);
        c1178o7 = a[0];
        c1178o9 = a[1];
        c1178o6 = a[2];
        c1178o5 = !hashMap.containsKey(c1178o) ? c1178o : !hashMap.containsKey(c1178o2) ? c1178o2 : !hashMap.containsKey(c1178o3) ? c1178o3 : c1178o4;
        int c = m3953b(c1178o6, c1178o5).m3945c();
        int c2 = m3953b(c1178o7, c1178o5).m3945c();
        if ((c & 1) == 1) {
            c++;
        }
        c += 2;
        if ((c2 & 1) == 1) {
            c2++;
        }
        int i = c2 + 2;
        int c3;
        if (c * 4 >= i * 7 || i * 4 >= c * 7) {
            c1178o4 = m3950a(c1178o9, c1178o7, c1178o6, c1178o5, c, i);
            if (c1178o4 == null) {
                c1178o4 = c1178o5;
            }
            c3 = m3953b(c1178o6, c1178o4).m3945c();
            int c4 = m3953b(c1178o7, c1178o4).m3945c();
            if ((c3 & 1) == 1) {
                c3++;
            }
            if ((c4 & 1) == 1) {
                c4++;
            }
            a2 = C1077a.m3948a(this.f2284a, c1178o6, c1178o9, c1178o7, c1178o4, c3, c4);
        } else {
            c1178o4 = m3949a(c1178o9, c1178o7, c1178o6, c1178o5, Math.min(i, c));
            if (c1178o4 == null) {
                c1178o4 = c1178o5;
            }
            c3 = Math.max(m3953b(c1178o6, c1178o4).m3945c(), m3953b(c1178o7, c1178o4).m3945c()) + 1;
            if ((c3 & 1) == 1) {
                c3++;
            }
            a2 = C1077a.m3948a(this.f2284a, c1178o6, c1178o9, c1178o7, c1178o4, c3, c3);
        }
        return new C1010g(a2, new C1178o[]{c1178o6, c1178o9, c1178o7, c1178o4});
    }
}
