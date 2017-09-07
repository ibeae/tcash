package com.google.p031b.p036b.p037a;

import com.google.p031b.C1016a;
import com.google.p031b.C1199m;
import com.google.p031b.p045f.C1133s;

public final class C1037t extends C1017u {
    public C1036s m3776a(C1199m c1199m) {
        C1016a d = c1199m.m4516d();
        if (d != C1016a.UPC_A && d != C1016a.UPC_E && d != C1016a.EAN_8 && d != C1016a.EAN_13) {
            return null;
        }
        String c = C1017u.m3696c(c1199m);
        int length = c.length();
        for (int i = 0; i < length; i++) {
            char charAt = c.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return null;
            }
        }
        return new C1036s(c, d == C1016a.UPC_E ? C1133s.m4180b(c) : c);
    }

    public /* synthetic */ C1019q mo1416b(C1199m c1199m) {
        return m3776a(c1199m);
    }
}
