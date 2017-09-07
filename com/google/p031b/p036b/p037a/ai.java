package com.google.p031b.p036b.p037a;

import com.google.p031b.C1199m;

public final class ai extends C1017u {
    public ah m3737a(C1199m c1199m) {
        String c = C1017u.m3696c(c1199m);
        if (!c.startsWith("WIFI:")) {
            return null;
        }
        String b = C1017u.m3694b("S:", c, ';', false);
        if (b == null || b.isEmpty()) {
            return null;
        }
        String b2 = C1017u.m3694b("P:", c, ';', false);
        String b3 = C1017u.m3694b("T:", c, ';', false);
        if (b3 == null) {
            b3 = "nopass";
        }
        return new ah(b3, b, b2, Boolean.parseBoolean(C1017u.m3694b("H:", c, ';', false)));
    }

    public /* synthetic */ C1019q mo1416b(C1199m c1199m) {
        return m3737a(c1199m);
    }
}
