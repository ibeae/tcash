package com.google.p031b.p045f;

import com.google.p031b.C1014k;
import com.google.p031b.C1062c;
import com.google.p031b.C1078l;
import com.google.p031b.C1084e;
import com.google.p031b.C1178o;
import com.google.p031b.C1198j;
import com.google.p031b.C1199m;
import com.google.p031b.C1200n;
import com.google.p031b.p034c.C1046a;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public abstract class C1108l implements C1014k {
    protected static int m4044a(int[] iArr, int[] iArr2, int i) {
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

    protected static void m4045a(C1046a c1046a, int i, int[] iArr) {
        int length = iArr.length;
        Arrays.fill(iArr, 0, length, 0);
        int a = c1046a.m3802a();
        if (i >= a) {
            throw C1198j.m4509a();
        }
        int i2;
        int i3 = !c1046a.m3807a(i) ? 1 : 0;
        int i4 = 0;
        while (i < a) {
            if ((c1046a.m3807a(i) ^ i3) != 0) {
                iArr[i4] = iArr[i4] + 1;
                i2 = i3;
            } else {
                i2 = i4 + 1;
                if (i2 == length) {
                    break;
                }
                iArr[i2] = 1;
                int i5 = i2;
                i2 = i3 == 0 ? 1 : 0;
                i4 = i5;
            }
            i++;
            i3 = i2;
        }
        i2 = i4;
        if (i2 == length) {
            return;
        }
        if (i2 != length - 1 || i != a) {
            throw C1198j.m4509a();
        }
    }

    private C1199m m4046b(C1062c c1062c, Map<C1084e, ?> map) {
        Object obj;
        int max;
        int i;
        C1046a c1046a;
        Map map2;
        int i2;
        int i3;
        int i4;
        Map enumMap;
        C1199m a;
        C1178o[] c;
        int a2 = c1062c.m3896a();
        int b = c1062c.m3898b();
        C1046a c1046a2 = new C1046a(a2);
        int i5 = b >> 1;
        if (map != null) {
            if (map.containsKey(C1084e.TRY_HARDER)) {
                obj = 1;
                max = Math.max(1, b >> (obj == null ? 8 : 5));
                i = obj == null ? b : 15;
                c1046a = c1046a2;
                map2 = map;
                for (i2 = 0; i2 < i; i2++) {
                    i3 = (i2 + 1) >> 1;
                    if (((i2 & 1) != 0 ? 1 : null) == null) {
                        i3 = -i3;
                    }
                    i4 = i5 + (i3 * max);
                    if (i4 < 0 || i4 >= b) {
                        break;
                    }
                    try {
                        c1046a = c1062c.m3897a(i4, c1046a);
                        i3 = 0;
                        while (i3 < 2) {
                            if (i3 == 1) {
                                c1046a.m3817e();
                                if (map2 != null && map2.containsKey(C1084e.NEED_RESULT_POINT_CALLBACK)) {
                                    enumMap = new EnumMap(C1084e.class);
                                    enumMap.putAll(map2);
                                    enumMap.remove(C1084e.NEED_RESULT_POINT_CALLBACK);
                                    a = mo1426a(i4, c1046a, enumMap);
                                    if (i3 == 1) {
                                        a.m4511a(C1200n.ORIENTATION, Integer.valueOf(180));
                                        c = a.m4515c();
                                        if (c != null) {
                                            c[0] = new C1178o((((float) a2) - c[0].m4396a()) - 1.0f, c[0].m4397b());
                                            c[1] = new C1178o((((float) a2) - c[1].m4396a()) - 1.0f, c[1].m4397b());
                                        }
                                    }
                                    return a;
                                }
                            }
                            enumMap = map2;
                            try {
                                a = mo1426a(i4, c1046a, enumMap);
                                if (i3 == 1) {
                                    a.m4511a(C1200n.ORIENTATION, Integer.valueOf(180));
                                    c = a.m4515c();
                                    if (c != null) {
                                        c[0] = new C1178o((((float) a2) - c[0].m4396a()) - 1.0f, c[0].m4397b());
                                        c[1] = new C1178o((((float) a2) - c[1].m4396a()) - 1.0f, c[1].m4397b());
                                    }
                                }
                                return a;
                            } catch (C1078l e) {
                                i3++;
                                map2 = enumMap;
                            }
                        }
                        continue;
                    } catch (C1198j e2) {
                    }
                }
                throw C1198j.m4509a();
            }
        }
        obj = null;
        if (obj == null) {
        }
        max = Math.max(1, b >> (obj == null ? 8 : 5));
        if (obj == null) {
        }
        c1046a = c1046a2;
        map2 = map;
        for (i2 = 0; i2 < i; i2++) {
            i3 = (i2 + 1) >> 1;
            if ((i2 & 1) != 0) {
            }
            if (((i2 & 1) != 0 ? 1 : null) == null) {
                i3 = -i3;
            }
            i4 = i5 + (i3 * max);
            c1046a = c1062c.m3897a(i4, c1046a);
            i3 = 0;
            while (i3 < 2) {
                if (i3 == 1) {
                    c1046a.m3817e();
                    enumMap = new EnumMap(C1084e.class);
                    enumMap.putAll(map2);
                    enumMap.remove(C1084e.NEED_RESULT_POINT_CALLBACK);
                    a = mo1426a(i4, c1046a, enumMap);
                    if (i3 == 1) {
                        a.m4511a(C1200n.ORIENTATION, Integer.valueOf(180));
                        c = a.m4515c();
                        if (c != null) {
                            c[0] = new C1178o((((float) a2) - c[0].m4396a()) - 1.0f, c[0].m4397b());
                            c[1] = new C1178o((((float) a2) - c[1].m4396a()) - 1.0f, c[1].m4397b());
                        }
                    }
                    return a;
                }
                enumMap = map2;
                a = mo1426a(i4, c1046a, enumMap);
                if (i3 == 1) {
                    a.m4511a(C1200n.ORIENTATION, Integer.valueOf(180));
                    c = a.m4515c();
                    if (c != null) {
                        c[0] = new C1178o((((float) a2) - c[0].m4396a()) - 1.0f, c[0].m4397b());
                        c[1] = new C1178o((((float) a2) - c[1].m4396a()) - 1.0f, c[1].m4397b());
                    }
                }
                return a;
            }
            continue;
        }
        throw C1198j.m4509a();
    }

    protected static void m4047b(C1046a c1046a, int i, int[] iArr) {
        int length = iArr.length;
        boolean a = c1046a.m3807a(i);
        while (i > 0 && length >= 0) {
            i--;
            if (c1046a.m3807a(i) != a) {
                length--;
                a = !a;
            }
        }
        if (length >= 0) {
            throw C1198j.m4509a();
        }
        C1108l.m4045a(c1046a, i + 1, iArr);
    }

    public abstract C1199m mo1426a(int i, C1046a c1046a, Map<C1084e, ?> map);

    public C1199m mo1414a(C1062c c1062c, Map<C1084e, ?> map) {
        try {
            return m4046b(c1062c, map);
        } catch (C1198j e) {
            Object obj = (map == null || !map.containsKey(C1084e.TRY_HARDER)) ? null : 1;
            if (obj == null || !c1062c.m3900d()) {
                throw e;
            }
            C1062c e2 = c1062c.m3901e();
            C1199m b = m4046b(e2, map);
            Map e3 = b.m4517e();
            int intValue = (e3 == null || !e3.containsKey(C1200n.ORIENTATION)) ? 270 : (((Integer) e3.get(C1200n.ORIENTATION)).intValue() + 270) % 360;
            b.m4511a(C1200n.ORIENTATION, Integer.valueOf(intValue));
            C1178o[] c = b.m4515c();
            if (c != null) {
                int b2 = e2.m3898b();
                for (intValue = 0; intValue < c.length; intValue++) {
                    c[intValue] = new C1178o((((float) b2) - c[intValue].m4397b()) - 1.0f, c[intValue].m4396a());
                }
            }
            return b;
        }
    }

    public void mo1415a() {
    }
}
