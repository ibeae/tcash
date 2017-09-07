package com.google.p031b.p049g.p050a;

import com.google.p031b.C1178o;
import com.google.p031b.C1198j;
import com.google.p031b.p034c.C1052b;

final class C1140c {
    private C1052b f2449a;
    private C1178o f2450b;
    private C1178o f2451c;
    private C1178o f2452d;
    private C1178o f2453e;
    private int f2454f;
    private int f2455g;
    private int f2456h;
    private int f2457i;

    C1140c(C1052b c1052b, C1178o c1178o, C1178o c1178o2, C1178o c1178o3, C1178o c1178o4) {
        if (!(c1178o == null && c1178o3 == null) && (!(c1178o2 == null && c1178o4 == null) && ((c1178o == null || c1178o2 != null) && (c1178o3 == null || c1178o4 != null)))) {
            m4217a(c1052b, c1178o, c1178o2, c1178o3, c1178o4);
            return;
        }
        throw C1198j.m4509a();
    }

    C1140c(C1140c c1140c) {
        m4217a(c1140c.f2449a, c1140c.f2450b, c1140c.f2451c, c1140c.f2452d, c1140c.f2453e);
    }

    static C1140c m4216a(C1140c c1140c, C1140c c1140c2) {
        return c1140c == null ? c1140c2 : c1140c2 == null ? c1140c : new C1140c(c1140c.f2449a, c1140c.f2450b, c1140c.f2451c, c1140c2.f2452d, c1140c2.f2453e);
    }

    private void m4217a(C1052b c1052b, C1178o c1178o, C1178o c1178o2, C1178o c1178o3, C1178o c1178o4) {
        this.f2449a = c1052b;
        this.f2450b = c1178o;
        this.f2451c = c1178o2;
        this.f2452d = c1178o3;
        this.f2453e = c1178o4;
        m4218i();
    }

    private void m4218i() {
        if (this.f2450b == null) {
            this.f2450b = new C1178o(0.0f, this.f2452d.m4397b());
            this.f2451c = new C1178o(0.0f, this.f2453e.m4397b());
        } else if (this.f2452d == null) {
            this.f2452d = new C1178o((float) (this.f2449a.m3855d() - 1), this.f2450b.m4397b());
            this.f2453e = new C1178o((float) (this.f2449a.m3855d() - 1), this.f2451c.m4397b());
        }
        this.f2454f = (int) Math.min(this.f2450b.m4396a(), this.f2451c.m4396a());
        this.f2455g = (int) Math.max(this.f2452d.m4396a(), this.f2453e.m4396a());
        this.f2456h = (int) Math.min(this.f2450b.m4397b(), this.f2452d.m4397b());
        this.f2457i = (int) Math.max(this.f2451c.m4397b(), this.f2453e.m4397b());
    }

    int m4219a() {
        return this.f2454f;
    }

    C1140c m4220a(int i, int i2, boolean z) {
        int b;
        C1178o c1178o;
        C1178o c1178o2 = this.f2450b;
        C1178o c1178o3 = this.f2451c;
        C1178o c1178o4 = this.f2452d;
        C1178o c1178o5 = this.f2453e;
        if (i > 0) {
            C1178o c1178o6 = z ? this.f2450b : this.f2452d;
            b = ((int) c1178o6.m4397b()) - i;
            if (b < 0) {
                b = 0;
            }
            c1178o = new C1178o(c1178o6.m4396a(), (float) b);
            if (!z) {
                c1178o4 = c1178o;
                c1178o = c1178o2;
            }
        } else {
            c1178o = c1178o2;
        }
        if (i2 > 0) {
            c1178o6 = z ? this.f2451c : this.f2453e;
            b = ((int) c1178o6.m4397b()) + i2;
            if (b >= this.f2449a.m3856e()) {
                b = this.f2449a.m3856e() - 1;
            }
            c1178o2 = new C1178o(c1178o6.m4396a(), (float) b);
            if (!z) {
                c1178o5 = c1178o2;
                c1178o2 = c1178o3;
            }
        } else {
            c1178o2 = c1178o3;
        }
        m4218i();
        return new C1140c(this.f2449a, c1178o, c1178o2, c1178o4, c1178o5);
    }

    int m4221b() {
        return this.f2455g;
    }

    int m4222c() {
        return this.f2456h;
    }

    int m4223d() {
        return this.f2457i;
    }

    C1178o m4224e() {
        return this.f2450b;
    }

    C1178o m4225f() {
        return this.f2452d;
    }

    C1178o m4226g() {
        return this.f2451c;
    }

    C1178o m4227h() {
        return this.f2453e;
    }
}
