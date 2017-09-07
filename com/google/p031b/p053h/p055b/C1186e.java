package com.google.p031b.p053h.p055b;

import com.google.p031b.C1084e;
import com.google.p031b.C1178o;
import com.google.p031b.C1198j;
import com.google.p031b.C1201p;
import com.google.p031b.p034c.C1052b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class C1186e {
    private final C1052b f2561a;
    private final List<C1182d> f2562b = new ArrayList();
    private boolean f2563c;
    private final int[] f2564d = new int[5];
    private final C1201p f2565e;

    private static final class C1184a implements Serializable, Comparator<C1182d> {
        private final float f2559a;

        private C1184a(float f) {
            this.f2559a = f;
        }

        public int m4419a(C1182d c1182d, C1182d c1182d2) {
            if (c1182d2.m4418d() != c1182d.m4418d()) {
                return c1182d2.m4418d() - c1182d.m4418d();
            }
            float abs = Math.abs(c1182d2.m4417c() - this.f2559a);
            float abs2 = Math.abs(c1182d.m4417c() - this.f2559a);
            return abs < abs2 ? 1 : abs == abs2 ? 0 : -1;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4419a((C1182d) obj, (C1182d) obj2);
        }
    }

    private static final class C1185b implements Serializable, Comparator<C1182d> {
        private final float f2560a;

        private C1185b(float f) {
            this.f2560a = f;
        }

        public int m4420a(C1182d c1182d, C1182d c1182d2) {
            float abs = Math.abs(c1182d2.m4417c() - this.f2560a);
            float abs2 = Math.abs(c1182d.m4417c() - this.f2560a);
            return abs < abs2 ? -1 : abs == abs2 ? 0 : 1;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4420a((C1182d) obj, (C1182d) obj2);
        }
    }

    public C1186e(C1052b c1052b, C1201p c1201p) {
        this.f2561a = c1052b;
        this.f2565e = c1201p;
    }

    private float m4421a(int i, int i2, int i3, int i4) {
        C1052b c1052b = this.f2561a;
        int e = c1052b.m3856e();
        int[] a = m4424a();
        int i5 = i;
        while (i5 >= 0 && c1052b.m3848a(i2, i5)) {
            a[2] = a[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !c1052b.m3848a(i2, i5) && a[1] <= i3) {
            a[1] = a[1] + 1;
            i5--;
        }
        if (i5 < 0 || a[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && c1052b.m3848a(i2, i5) && a[0] <= i3) {
            a[0] = a[0] + 1;
            i5--;
        }
        if (a[0] > i3) {
            return Float.NaN;
        }
        i5 = i + 1;
        while (i5 < e && c1052b.m3848a(i2, i5)) {
            a[2] = a[2] + 1;
            i5++;
        }
        if (i5 == e) {
            return Float.NaN;
        }
        while (i5 < e && !c1052b.m3848a(i2, i5) && a[3] < i3) {
            a[3] = a[3] + 1;
            i5++;
        }
        if (i5 == e || a[3] >= i3) {
            return Float.NaN;
        }
        while (i5 < e && c1052b.m3848a(i2, i5) && a[4] < i3) {
            a[4] = a[4] + 1;
            i5++;
        }
        return (a[4] >= i3 || Math.abs(((((a[0] + a[1]) + a[2]) + a[3]) + a[4]) - i4) * 5 >= i4 * 2 || !C1186e.m4423a(a)) ? Float.NaN : C1186e.m4422a(a, i5);
    }

    private static float m4422a(int[] iArr, int i) {
        return ((float) ((i - iArr[4]) - iArr[3])) - (((float) iArr[2]) / 2.0f);
    }

    protected static boolean m4423a(int[] iArr) {
        int i;
        boolean z = true;
        int i2 = 0;
        for (i = 0; i < 5; i++) {
            int i3 = iArr[i];
            if (i3 == 0) {
                return false;
            }
            i2 += i3;
        }
        if (i2 < 7) {
            return false;
        }
        i = (i2 << 8) / 7;
        i2 = i / 2;
        if (Math.abs(i - (iArr[0] << 8)) >= i2 || Math.abs(i - (iArr[1] << 8)) >= i2 || Math.abs((i * 3) - (iArr[2] << 8)) >= i2 * 3 || Math.abs(i - (iArr[3] << 8)) >= i2 || Math.abs(i - (iArr[4] << 8)) >= i2) {
            z = false;
        }
        return z;
    }

    private int[] m4424a() {
        this.f2564d[0] = 0;
        this.f2564d[1] = 0;
        this.f2564d[2] = 0;
        this.f2564d[3] = 0;
        this.f2564d[4] = 0;
        return this.f2564d;
    }

    private float m4425b(int i, int i2, int i3, int i4) {
        C1052b c1052b = this.f2561a;
        int d = c1052b.m3855d();
        int[] a = m4424a();
        int i5 = i;
        while (i5 >= 0 && c1052b.m3848a(i5, i2)) {
            a[2] = a[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !c1052b.m3848a(i5, i2) && a[1] <= i3) {
            a[1] = a[1] + 1;
            i5--;
        }
        if (i5 < 0 || a[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && c1052b.m3848a(i5, i2) && a[0] <= i3) {
            a[0] = a[0] + 1;
            i5--;
        }
        if (a[0] > i3) {
            return Float.NaN;
        }
        i5 = i + 1;
        while (i5 < d && c1052b.m3848a(i5, i2)) {
            a[2] = a[2] + 1;
            i5++;
        }
        if (i5 == d) {
            return Float.NaN;
        }
        while (i5 < d && !c1052b.m3848a(i5, i2) && a[3] < i3) {
            a[3] = a[3] + 1;
            i5++;
        }
        if (i5 == d || a[3] >= i3) {
            return Float.NaN;
        }
        while (i5 < d && c1052b.m3848a(i5, i2) && a[4] < i3) {
            a[4] = a[4] + 1;
            i5++;
        }
        return (a[4] >= i3 || Math.abs(((((a[0] + a[1]) + a[2]) + a[3]) + a[4]) - i4) * 5 >= i4 || !C1186e.m4423a(a)) ? Float.NaN : C1186e.m4422a(a, i5);
    }

    private int m4426b() {
        if (this.f2562b.size() <= 1) {
            return 0;
        }
        C1178o c1178o = null;
        for (C1178o c1178o2 : this.f2562b) {
            C1178o c1178o22;
            if (c1178o22.m4418d() < 2) {
                c1178o22 = c1178o;
            } else if (c1178o != null) {
                this.f2563c = true;
                return ((int) (Math.abs(c1178o.m4396a() - c1178o22.m4396a()) - Math.abs(c1178o.m4397b() - c1178o22.m4397b()))) / 2;
            }
            c1178o = c1178o22;
        }
        return 0;
    }

    private boolean m4427c() {
        float f = 0.0f;
        int size = this.f2562b.size();
        float f2 = 0.0f;
        int i = 0;
        for (C1182d c1182d : this.f2562b) {
            float c;
            int i2;
            if (c1182d.m4418d() >= 2) {
                c = c1182d.m4417c() + f2;
                i2 = i + 1;
            } else {
                c = f2;
                i2 = i;
            }
            i = i2;
            f2 = c;
        }
        if (i < 3) {
            return false;
        }
        float f3 = f2 / ((float) size);
        for (C1182d c1182d2 : this.f2562b) {
            f += Math.abs(c1182d2.m4417c() - f3);
        }
        return f <= 0.05f * f2;
    }

    private C1182d[] m4428d() {
        float f = 0.0f;
        int size = this.f2562b.size();
        if (size < 3) {
            throw C1198j.m4509a();
        }
        if (size > 3) {
            float c;
            float f2 = 0.0f;
            float f3 = 0.0f;
            for (C1182d c2 : this.f2562b) {
                c = c2.m4417c();
                f3 += c;
                f2 = (c * c) + f2;
            }
            f3 /= (float) size;
            c = (float) Math.sqrt((double) ((f2 / ((float) size)) - (f3 * f3)));
            Collections.sort(this.f2562b, new C1185b(f3));
            float max = Math.max(0.2f * f3, c);
            int i = 0;
            while (i < this.f2562b.size() && this.f2562b.size() > 3) {
                if (Math.abs(((C1182d) this.f2562b.get(i)).m4417c() - f3) > max) {
                    this.f2562b.remove(i);
                    i--;
                }
                i++;
            }
        }
        if (this.f2562b.size() > 3) {
            for (C1182d c22 : this.f2562b) {
                f += c22.m4417c();
            }
            Collections.sort(this.f2562b, new C1184a(f / ((float) this.f2562b.size())));
            this.f2562b.subList(3, this.f2562b.size()).clear();
        }
        return new C1182d[]{(C1182d) this.f2562b.get(0), (C1182d) this.f2562b.get(1), (C1182d) this.f2562b.get(2)};
    }

    final C1187f m4429a(Map<C1084e, ?> map) {
        int i = (map == null || !map.containsKey(C1084e.TRY_HARDER)) ? 0 : 1;
        int e = this.f2561a.m3856e();
        int d = this.f2561a.m3855d();
        int i2 = (e * 3) / 228;
        i = (i2 < 3 || i != 0) ? 3 : i2;
        int[] iArr = new int[5];
        int i3 = i - 1;
        boolean z = false;
        int i4 = i;
        while (i3 < e && !r6) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            i2 = 0;
            i = 0;
            while (i2 < d) {
                if (this.f2561a.m3848a(i2, i3)) {
                    if ((i & 1) == 1) {
                        i++;
                    }
                    iArr[i] = iArr[i] + 1;
                } else if ((i & 1) != 0) {
                    iArr[i] = iArr[i] + 1;
                } else if (i != 4) {
                    i++;
                    iArr[i] = iArr[i] + 1;
                } else if (!C1186e.m4423a(iArr)) {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i = 3;
                } else if (m4430a(iArr, i3, i2)) {
                    boolean c;
                    if (this.f2563c) {
                        c = m4427c();
                    } else {
                        i = m4426b();
                        if (i > iArr[2]) {
                            i2 = i3 + ((i - iArr[2]) - 2);
                            i = d - 1;
                        } else {
                            i = i2;
                            i2 = i3;
                        }
                        i3 = i2;
                        i2 = i;
                        c = z;
                    }
                    iArr[0] = 0;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    iArr[3] = 0;
                    iArr[4] = 0;
                    z = c;
                    i4 = 2;
                    i = 0;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i = 3;
                }
                i2++;
            }
            if (C1186e.m4423a(iArr) && m4430a(iArr, i3, d)) {
                i4 = iArr[0];
                if (this.f2563c) {
                    z = m4427c();
                }
            }
            i3 += i4;
        }
        C1178o[] d2 = m4428d();
        C1178o.m4395a(d2);
        return new C1187f(d2);
    }

    protected final boolean m4430a(int[] iArr, int i, int i2) {
        boolean z = false;
        int i3 = (((iArr[0] + iArr[1]) + iArr[2]) + iArr[3]) + iArr[4];
        float a = C1186e.m4422a(iArr, i2);
        float a2 = m4421a(i, (int) a, iArr[2], i3);
        if (Float.isNaN(a2)) {
            return false;
        }
        float b = m4425b((int) a, (int) a2, iArr[2], i3);
        if (Float.isNaN(b)) {
            return false;
        }
        float f = ((float) i3) / 7.0f;
        for (int i4 = 0; i4 < this.f2562b.size(); i4++) {
            C1182d c1182d = (C1182d) this.f2562b.get(i4);
            if (c1182d.m4415a(f, a2, b)) {
                this.f2562b.set(i4, c1182d.m4416b(a2, b, f));
                z = true;
                break;
            }
        }
        if (!z) {
            C1178o c1182d2 = new C1182d(b, a2, f);
            this.f2562b.add(c1182d2);
            if (this.f2565e != null) {
                this.f2565e.mo1530a(c1182d2);
            }
        }
        return true;
    }
}
