package com.google.p031b.p049g.p050a;

import java.util.Formatter;

final class C1145f {
    private final C1138a f2474a;
    private final C1146g[] f2475b = new C1146g[(this.f2477d + 2)];
    private C1140c f2476c;
    private final int f2477d;

    C1145f(C1138a c1138a, C1140c c1140c) {
        this.f2474a = c1138a;
        this.f2477d = c1138a.m4209a();
        this.f2476c = c1140c;
    }

    private static int m4245a(int i, int i2, C1141d c1141d) {
        if (c1141d == null || c1141d.m4228a()) {
            return i2;
        }
        if (!c1141d.m4229a(i)) {
            return i2 + 1;
        }
        c1141d.m4231b(i);
        return 0;
    }

    private void m4246a(int i, int i2, C1141d[] c1141dArr) {
        C1141d c1141d = c1141dArr[i2];
        C1141d[] b = this.f2475b[i - 1].m4266b();
        C1141d[] b2 = this.f2475b[i + 1] != null ? this.f2475b[i + 1].m4266b() : b;
        C1141d[] c1141dArr2 = new C1141d[14];
        c1141dArr2[2] = b[i2];
        c1141dArr2[3] = b2[i2];
        if (i2 > 0) {
            c1141dArr2[0] = c1141dArr[i2 - 1];
            c1141dArr2[4] = b[i2 - 1];
            c1141dArr2[5] = b2[i2 - 1];
        }
        if (i2 > 1) {
            c1141dArr2[8] = c1141dArr[i2 - 2];
            c1141dArr2[10] = b[i2 - 2];
            c1141dArr2[11] = b2[i2 - 2];
        }
        if (i2 < c1141dArr.length - 1) {
            c1141dArr2[1] = c1141dArr[i2 + 1];
            c1141dArr2[6] = b[i2 + 1];
            c1141dArr2[7] = b2[i2 + 1];
        }
        if (i2 < c1141dArr.length - 2) {
            c1141dArr2[9] = c1141dArr[i2 + 2];
            c1141dArr2[12] = b[i2 + 2];
            c1141dArr2[13] = b2[i2 + 2];
        }
        int length = c1141dArr2.length;
        int i3 = 0;
        while (i3 < length && !C1145f.m4248a(c1141d, c1141dArr2[i3])) {
            i3++;
        }
    }

    private void m4247a(C1146g c1146g) {
        if (c1146g != null) {
            ((C1147h) c1146g).m4269a(this.f2474a);
        }
    }

    private static boolean m4248a(C1141d c1141d, C1141d c1141d2) {
        if (c1141d2 == null || !c1141d2.m4228a() || c1141d2.m4235f() != c1141d.m4235f()) {
            return false;
        }
        c1141d.m4231b(c1141d2.m4237h());
        return true;
    }

    private int m4249f() {
        int g = m4250g();
        if (g == 0) {
            return 0;
        }
        for (int i = 1; i < this.f2477d + 1; i++) {
            C1141d[] b = this.f2475b[i].m4266b();
            int i2 = 0;
            while (i2 < b.length) {
                if (!(b[i2] == null || b[i2].m4228a())) {
                    m4246a(i, i2, b);
                }
                i2++;
            }
        }
        return g;
    }

    private int m4250g() {
        m4251h();
        return m4253j() + m4252i();
    }

    private void m4251h() {
        int i = 0;
        if (this.f2475b[0] != null && this.f2475b[this.f2477d + 1] != null) {
            C1141d[] b = this.f2475b[0].m4266b();
            C1141d[] b2 = this.f2475b[this.f2477d + 1].m4266b();
            while (i < b.length) {
                if (!(b[i] == null || b2[i] == null || b[i].m4237h() != b2[i].m4237h())) {
                    for (int i2 = 1; i2 <= this.f2477d; i2++) {
                        C1141d c1141d = this.f2475b[i2].m4266b()[i];
                        if (c1141d != null) {
                            c1141d.m4231b(b[i].m4237h());
                            if (!c1141d.m4228a()) {
                                this.f2475b[i2].m4266b()[i] = null;
                            }
                        }
                    }
                }
                i++;
            }
        }
    }

    private int m4252i() {
        if (this.f2475b[this.f2477d + 1] == null) {
            return 0;
        }
        C1141d[] b = this.f2475b[this.f2477d + 1].m4266b();
        int i = 0;
        for (int i2 = 0; i2 < b.length; i2++) {
            if (b[i2] != null) {
                int h = b[i2].m4237h();
                int i3 = i;
                i = 0;
                for (int i4 = this.f2477d + 1; i4 > 0 && i < 2; i4--) {
                    C1141d c1141d = this.f2475b[i4].m4266b()[i2];
                    if (c1141d != null) {
                        i = C1145f.m4245a(h, i, c1141d);
                        if (!c1141d.m4228a()) {
                            i3++;
                        }
                    }
                }
                i = i3;
            }
        }
        return i;
    }

    private int m4253j() {
        if (this.f2475b[0] == null) {
            return 0;
        }
        C1141d[] b = this.f2475b[0].m4266b();
        int i = 0;
        for (int i2 = 0; i2 < b.length; i2++) {
            if (b[i2] != null) {
                int h = b[i2].m4237h();
                int i3 = i;
                int i4 = 0;
                for (i = 1; i < this.f2477d + 1 && i4 < 2; i++) {
                    C1141d c1141d = this.f2475b[i].m4266b()[i2];
                    if (c1141d != null) {
                        i4 = C1145f.m4245a(h, i4, c1141d);
                        if (!c1141d.m4228a()) {
                            i3++;
                        }
                    }
                }
                i = i3;
            }
        }
        return i;
    }

    C1146g m4254a(int i) {
        return this.f2475b[i];
    }

    void m4255a(int i, C1146g c1146g) {
        this.f2475b[i] = c1146g;
    }

    public void m4256a(C1140c c1140c) {
        this.f2476c = c1140c;
    }

    C1146g[] m4257a() {
        m4247a(this.f2475b[0]);
        m4247a(this.f2475b[this.f2477d + 1]);
        int i = 928;
        while (true) {
            int f = m4249f();
            if (f > 0 && f < r0) {
                i = f;
            }
        }
        return this.f2475b;
    }

    int m4258b() {
        return this.f2477d;
    }

    int m4259c() {
        return this.f2474a.m4211c();
    }

    int m4260d() {
        return this.f2474a.m4210b();
    }

    C1140c m4261e() {
        return this.f2476c;
    }

    public String toString() {
        C1146g c1146g = this.f2475b[0];
        if (c1146g == null) {
            c1146g = this.f2475b[this.f2477d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i = 0; i < c1146g.m4266b().length; i++) {
            formatter.format("CW %3d:", new Object[]{Integer.valueOf(i)});
            for (int i2 = 0; i2 < this.f2477d + 2; i2++) {
                if (this.f2475b[i2] == null) {
                    formatter.format("    |   ", new Object[0]);
                } else {
                    if (this.f2475b[i2].m4266b()[i] == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        formatter.format(" %3d|%3d", new Object[]{Integer.valueOf(this.f2475b[i2].m4266b()[i].m4237h()), Integer.valueOf(this.f2475b[i2].m4266b()[i].m4236g())});
                    }
                }
            }
            formatter.format("\n", new Object[0]);
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}
