package com.google.p031b.p045f.p046a;

import com.google.p031b.C1016a;
import com.google.p031b.C1084e;
import com.google.p031b.C1178o;
import com.google.p031b.C1198j;
import com.google.p031b.C1199m;
import com.google.p031b.C1201p;
import com.google.p031b.p034c.C1046a;
import com.google.p031b.p045f.C1108l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class C1114e extends C1109a {
    private static final int[] f2364a = new int[]{1, 10, 34, 70, 126};
    private static final int[] f2365b = new int[]{4, 20, 48, 81};
    private static final int[] f2366c = new int[]{0, 161, 961, 2015, 2715};
    private static final int[] f2367d = new int[]{0, 336, 1036, 1516};
    private static final int[] f2368e = new int[]{8, 6, 4, 3, 1};
    private static final int[] f2369f = new int[]{2, 4, 6, 8};
    private static final int[][] f2370g = new int[][]{new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    private final List<C1113d> f2371h = new ArrayList();
    private final List<C1113d> f2372i = new ArrayList();

    private C1111b m4089a(C1046a c1046a, C1112c c1112c, boolean z) {
        int i;
        int length;
        int i2;
        int[] c = m4057c();
        c[0] = 0;
        c[1] = 0;
        c[2] = 0;
        c[3] = 0;
        c[4] = 0;
        c[5] = 0;
        c[6] = 0;
        c[7] = 0;
        if (z) {
            C1108l.m4047b(c1046a, c1112c.m4084b()[0], c);
        } else {
            C1108l.m4045a(c1046a, c1112c.m4084b()[1] + 1, c);
            i = 0;
            for (length = c.length - 1; i < length; length--) {
                i2 = c[i];
                c[i] = c[length];
                c[length] = i2;
                i++;
            }
        }
        length = z ? 16 : 15;
        float a = ((float) C1109a.m4051a(c)) / ((float) length);
        int[] f = m4060f();
        int[] g = m4061g();
        float[] d = m4058d();
        float[] e = m4059e();
        for (i = 0; i < c.length; i++) {
            float f2 = ((float) c[i]) / a;
            i2 = (int) (0.5f + f2);
            if (i2 < 1) {
                i2 = 1;
            } else if (i2 > 8) {
                i2 = 8;
            }
            int i3 = i >> 1;
            if ((i & 1) == 0) {
                f[i3] = i2;
                d[i3] = f2 - ((float) i2);
            } else {
                g[i3] = i2;
                e[i3] = f2 - ((float) i2);
            }
        }
        m4094a(z, length);
        length = f.length - 1;
        int i4 = 0;
        int i5 = 0;
        while (length >= 0) {
            i = (i4 * 9) + f[length];
            length--;
            i4 = i;
            i5 = f[length] + i5;
        }
        i2 = 0;
        i = 0;
        for (length = g.length - 1; length >= 0; length--) {
            i2 = (i2 * 9) + g[length];
            i += g[length];
        }
        i2 = i4 + (i2 * 3);
        if (z) {
            if ((i5 & 1) != 0 || i5 > 12 || i5 < 4) {
                throw C1198j.m4509a();
            }
            length = (12 - i5) / 2;
            i = f2368e[length];
            i4 = 9 - i;
            return new C1111b(((C1115f.m4100a(f, i, false) * f2364a[length]) + C1115f.m4100a(g, i4, true)) + f2366c[length], i2);
        } else if ((i & 1) != 0 || i > 10 || i < 4) {
            throw C1198j.m4509a();
        } else {
            length = (10 - i) / 2;
            i = f2369f[length];
            return new C1111b((C1115f.m4100a(f, i, true) + (C1115f.m4100a(g, 9 - i, false) * f2365b[length])) + f2367d[length], i2);
        }
    }

    private C1112c m4090a(C1046a c1046a, int i, boolean z, int[] iArr) {
        int a;
        boolean a2 = c1046a.m3807a(iArr[0]);
        int i2 = iArr[0] - 1;
        while (i2 >= 0 && (c1046a.m3807a(i2) ^ a2) != 0) {
            i2--;
        }
        int i3 = i2 + 1;
        i2 = iArr[0] - i3;
        Object b = m4056b();
        System.arraycopy(b, 0, b, 1, b.length - 1);
        b[0] = i2;
        int a3 = C1109a.m4052a((int[]) b, f2370g);
        int i4 = iArr[1];
        if (z) {
            a = (c1046a.m3802a() - 1) - i3;
            i4 = (c1046a.m3802a() - 1) - i4;
        } else {
            a = i3;
        }
        return new C1112c(a3, new int[]{i3, iArr[1]}, a, i4, i);
    }

    private C1113d m4091a(C1046a c1046a, boolean z, int i, Map<C1084e, ?> map) {
        try {
            int[] a = m4095a(c1046a, 0, z);
            C1112c a2 = m4090a(c1046a, i, z, a);
            C1201p c1201p = map == null ? null : (C1201p) map.get(C1084e.NEED_RESULT_POINT_CALLBACK);
            if (c1201p != null) {
                float f = ((float) (a[0] + a[1])) / 2.0f;
                if (z) {
                    f = ((float) (c1046a.m3802a() - 1)) - f;
                }
                c1201p.mo1530a(new C1178o(f, (float) i));
            }
            C1111b a3 = m4089a(c1046a, a2, true);
            C1111b a4 = m4089a(c1046a, a2, false);
            return new C1113d((a3.m4081a() * 1597) + a4.m4081a(), a3.m4082b() + (a4.m4082b() * 4), a2);
        } catch (C1198j e) {
            return null;
        }
    }

    private static C1199m m4092a(C1113d c1113d, C1113d c1113d2) {
        int length;
        String valueOf = String.valueOf((4537077 * ((long) c1113d.m4081a())) + ((long) c1113d2.m4081a()));
        StringBuilder stringBuilder = new StringBuilder(14);
        for (length = 13 - valueOf.length(); length > 0; length--) {
            stringBuilder.append('0');
        }
        stringBuilder.append(valueOf);
        int i = 0;
        for (int i2 = 0; i2 < 13; i2++) {
            length = stringBuilder.charAt(i2) - 48;
            if ((i2 & 1) == 0) {
                length *= 3;
            }
            i += length;
        }
        length = 10 - (i % 10);
        if (length == 10) {
            length = 0;
        }
        stringBuilder.append(length);
        C1178o[] c = c1113d.m4086c().m4085c();
        C1178o[] c2 = c1113d2.m4086c().m4085c();
        return new C1199m(String.valueOf(stringBuilder.toString()), null, new C1178o[]{c[0], c[1], c2[0], c2[1]}, C1016a.RSS_14);
    }

    private static void m4093a(Collection<C1113d> collection, C1113d c1113d) {
        if (c1113d != null) {
            Object obj;
            for (C1113d c1113d2 : collection) {
                if (c1113d2.m4081a() == c1113d.m4081a()) {
                    c1113d2.m4088e();
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                collection.add(c1113d);
            }
        }
    }

    private void m4094a(boolean z, int i) {
        Object obj;
        Object obj2;
        Object obj3;
        int i2;
        Object obj4 = null;
        Object obj5 = 1;
        int a = C1109a.m4051a(m4060f());
        int a2 = C1109a.m4051a(m4061g());
        int i3 = (a + a2) - i;
        Object obj6 = (a & 1) == (z ? 1 : 0) ? 1 : null;
        Object obj7 = (a2 & 1) == 1 ? 1 : null;
        int i4;
        if (z) {
            if (a > 12) {
                obj = 1;
                obj2 = null;
            } else if (a < 4) {
                obj = null;
                i4 = 1;
            } else {
                obj = null;
                obj2 = null;
            }
            if (a2 > 12) {
                obj3 = null;
                obj4 = 1;
            } else {
                if (a2 < 4) {
                    i2 = 1;
                }
                obj3 = null;
            }
        } else {
            if (a > 11) {
                obj = 1;
                obj2 = null;
            } else if (a < 5) {
                obj = null;
                i4 = 1;
            } else {
                obj = null;
                obj2 = null;
            }
            if (a2 > 10) {
                obj3 = null;
                int i5 = 1;
            } else {
                if (a2 < 4) {
                    i2 = 1;
                }
                obj3 = null;
            }
        }
        if (i3 == 1) {
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
        } else if (i3 == -1) {
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
        } else if (i3 != 0) {
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
                i2 = 1;
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

    private int[] m4095a(C1046a c1046a, int i, boolean z) {
        int[] b = m4056b();
        b[0] = 0;
        b[1] = 0;
        b[2] = 0;
        b[3] = 0;
        int a = c1046a.m3802a();
        boolean z2 = false;
        int i2 = i;
        while (i2 < a) {
            z2 = !c1046a.m3807a(i2);
            if (z == z2) {
                break;
            }
            i2++;
        }
        int i3 = z2;
        int i4 = i2;
        i2 = 0;
        for (int i5 = i2; i5 < a; i5++) {
            if ((c1046a.m3807a(i5) ^ i3) != 0) {
                b[i2] = b[i2] + 1;
            } else {
                if (i2 != 3) {
                    i2++;
                } else if (C1109a.m4055b(b)) {
                    return new int[]{i4, i5};
                } else {
                    i4 += b[0] + b[1];
                    b[0] = b[2];
                    b[1] = b[3];
                    b[2] = 0;
                    b[3] = 0;
                    i2--;
                }
                b[i2] = 1;
                i3 = i3 == 0 ? 1 : 0;
            }
        }
        throw C1198j.m4509a();
    }

    private static boolean m4096b(C1113d c1113d, C1113d c1113d2) {
        int b = (c1113d.m4082b() + (c1113d2.m4082b() * 16)) % 79;
        int a = (c1113d.m4086c().m4083a() * 9) + c1113d2.m4086c().m4083a();
        if (a > 72) {
            a--;
        }
        if (a > 8) {
            a--;
        }
        return b == a;
    }

    public C1199m mo1426a(int i, C1046a c1046a, Map<C1084e, ?> map) {
        C1114e.m4093a(this.f2371h, m4091a(c1046a, false, i, (Map) map));
        c1046a.m3817e();
        C1114e.m4093a(this.f2372i, m4091a(c1046a, true, i, (Map) map));
        c1046a.m3817e();
        int size = this.f2371h.size();
        for (int i2 = 0; i2 < size; i2++) {
            C1113d c1113d = (C1113d) this.f2371h.get(i2);
            if (c1113d.m4087d() > 1) {
                int size2 = this.f2372i.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    C1113d c1113d2 = (C1113d) this.f2372i.get(i3);
                    if (c1113d2.m4087d() > 1 && C1114e.m4096b(c1113d, c1113d2)) {
                        return C1114e.m4092a(c1113d, c1113d2);
                    }
                }
                continue;
            }
        }
        throw C1198j.m4509a();
    }

    public void mo1415a() {
        this.f2371h.clear();
        this.f2372i.clear();
    }
}
