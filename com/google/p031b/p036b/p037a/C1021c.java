package com.google.p031b.p036b.p037a;

import com.google.p031b.C1199m;

public final class C1021c extends C1018a {
    private static String m3742a(String str) {
        int indexOf = str.indexOf(44);
        return indexOf >= 0 ? str.substring(indexOf + 1) + ' ' + str.substring(0, indexOf) : str;
    }

    public C1022d m3743a(C1199m c1199m) {
        String c = C1017u.m3696c(c1199m);
        if (!c.startsWith("MECARD:")) {
            return null;
        }
        String[] a = C1018a.m3702a("N:", c, true);
        if (a == null) {
            return null;
        }
        String a2 = C1021c.m3742a(a[0]);
        String b = C1018a.m3703b("SOUND:", c, true);
        String[] a3 = C1018a.m3702a("TEL:", c, true);
        String[] a4 = C1018a.m3702a("EMAIL:", c, true);
        String b2 = C1018a.m3703b("NOTE:", c, false);
        String[] a5 = C1018a.m3702a("ADR:", c, true);
        String b3 = C1018a.m3703b("BDAY:", c, true);
        if (!(b3 == null || C1017u.m3692a((CharSequence) b3, 8))) {
            b3 = null;
        }
        String[] a6 = C1018a.m3702a("URL:", c, true);
        return new C1022d(C1017u.m3695b(a2), null, b, a3, null, a4, null, null, b2, a5, null, C1018a.m3703b("ORG:", c, true), b3, null, a6, null);
    }

    public /* synthetic */ C1019q mo1416b(C1199m c1199m) {
        return m3743a(c1199m);
    }
}
