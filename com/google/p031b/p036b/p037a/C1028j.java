package com.google.p031b.p036b.p037a;

import com.google.p031b.C1199m;
import java.util.regex.Pattern;

public final class C1028j extends C1018a {
    private static final Pattern f2110a = Pattern.compile("[a-zA-Z0-9@.!#$%&'*+\\-/=?^_`{|}~]+");

    static boolean m3759a(String str) {
        return str != null && f2110a.matcher(str).matches() && str.indexOf(64) >= 0;
    }

    public C1026h m3760a(C1199m c1199m) {
        String c = C1017u.m3696c(c1199m);
        if (!c.startsWith("MATMSG:")) {
            return null;
        }
        String[] a = C1018a.m3702a("TO:", c, true);
        if (a == null) {
            return null;
        }
        String str = a[0];
        return C1028j.m3759a(str) ? new C1026h(str, C1018a.m3703b("SUB:", c, false), C1018a.m3703b("BODY:", c, false), "mailto:" + str) : null;
    }

    public /* synthetic */ C1019q mo1416b(C1199m c1199m) {
        return m3760a(c1199m);
    }
}
