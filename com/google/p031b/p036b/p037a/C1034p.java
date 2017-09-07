package com.google.p031b.p036b.p037a;

import com.google.p031b.C1016a;
import com.google.p031b.C1199m;

public final class C1034p extends C1017u {
    public C1033o m3773a(C1199m c1199m) {
        if (c1199m.m4516d() != C1016a.EAN_13) {
            return null;
        }
        String c = C1017u.m3696c(c1199m);
        return c.length() == 13 ? (c.startsWith("978") || c.startsWith("979")) ? new C1033o(c) : null : null;
    }

    public /* synthetic */ C1019q mo1416b(C1199m c1199m) {
        return m3773a(c1199m);
    }
}
