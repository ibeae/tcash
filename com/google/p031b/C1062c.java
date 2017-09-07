package com.google.p031b;

import com.google.p031b.p034c.C1046a;
import com.google.p031b.p034c.C1052b;

public final class C1062c {
    private final C1043b f2246a;
    private C1052b f2247b;

    public C1062c(C1043b c1043b) {
        if (c1043b == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.f2246a = c1043b;
    }

    public int m3896a() {
        return this.f2246a.m3791c();
    }

    public C1046a m3897a(int i, C1046a c1046a) {
        return this.f2246a.mo1421a(i, c1046a);
    }

    public int m3898b() {
        return this.f2246a.m3792d();
    }

    public C1052b m3899c() {
        if (this.f2247b == null) {
            this.f2247b = this.f2246a.mo1422b();
        }
        return this.f2247b;
    }

    public boolean m3900d() {
        return this.f2246a.m3789a().m4502d();
    }

    public C1062c m3901e() {
        return new C1062c(this.f2246a.mo1420a(this.f2246a.m3789a().m4503e()));
    }
}
