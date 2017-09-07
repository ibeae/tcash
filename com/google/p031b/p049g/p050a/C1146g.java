package com.google.p031b.p049g.p050a;

import java.util.Formatter;

class C1146g {
    private final C1140c f2478a;
    private final C1141d[] f2479b;

    C1146g(C1140c c1140c) {
        this.f2478a = new C1140c(c1140c);
        this.f2479b = new C1141d[((c1140c.m4223d() - c1140c.m4222c()) + 1)];
    }

    final C1140c m4262a() {
        return this.f2478a;
    }

    final C1141d m4263a(int i) {
        C1141d c = m4267c(i);
        if (c != null) {
            return c;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int b = m4265b(i) - i2;
            if (b >= 0) {
                c = this.f2479b[b];
                if (c != null) {
                    return c;
                }
            }
            b = m4265b(i) + i2;
            if (b < this.f2479b.length) {
                c = this.f2479b[b];
                if (c != null) {
                    return c;
                }
            }
        }
        return null;
    }

    final void m4264a(int i, C1141d c1141d) {
        this.f2479b[m4265b(i)] = c1141d;
    }

    final int m4265b(int i) {
        return i - this.f2478a.m4222c();
    }

    final C1141d[] m4266b() {
        return this.f2479b;
    }

    final C1141d m4267c(int i) {
        return this.f2479b[m4265b(i)];
    }

    public String toString() {
        Formatter formatter = new Formatter();
        C1141d[] c1141dArr = this.f2479b;
        int length = c1141dArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            C1141d c1141d = c1141dArr[i];
            if (c1141d == null) {
                Object[] objArr = new Object[1];
                i3 = i2 + 1;
                objArr[0] = Integer.valueOf(i2);
                formatter.format("%3d:    |   \n", objArr);
            } else {
                r9 = new Object[3];
                i3 = i2 + 1;
                r9[0] = Integer.valueOf(i2);
                r9[1] = Integer.valueOf(c1141d.m4237h());
                r9[2] = Integer.valueOf(c1141d.m4236g());
                formatter.format("%3d: %3d|%3d\n", r9);
            }
            i++;
            i2 = i3;
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}
