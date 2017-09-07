package com.google.p031b.p036b.p037a;

import com.google.p031b.C1199m;

public final class C1024f extends C1018a {
    public ac m3750a(C1199m c1199m) {
        String a = c1199m.m4510a();
        if (!a.startsWith("MEBKM:")) {
            return null;
        }
        String b = C1018a.m3703b("TITLE:", a, true);
        String[] a2 = C1018a.m3702a("URL:", a, true);
        if (a2 == null) {
            return null;
        }
        a = a2[0];
        return ad.m3714a(a) ? new ac(a, b) : null;
    }

    public /* synthetic */ C1019q mo1416b(C1199m c1199m) {
        return m3750a(c1199m);
    }
}
