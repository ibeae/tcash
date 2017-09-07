package com.google.p031b.p036b.p037a;

import com.google.p031b.C1199m;

public final class C1041y extends C1017u {
    public C1026h m3784a(C1199m c1199m) {
        String str = null;
        String c = C1017u.m3696c(c1199m);
        if (!c.startsWith("smtp:") && !c.startsWith("SMTP:")) {
            return null;
        }
        String substring = c.substring(5);
        int indexOf = substring.indexOf(58);
        if (indexOf >= 0) {
            c = substring.substring(indexOf + 1);
            substring = substring.substring(0, indexOf);
            indexOf = c.indexOf(58);
            if (indexOf >= 0) {
                str = c.substring(indexOf + 1);
                c = c.substring(0, indexOf);
            }
        } else {
            c = null;
        }
        return new C1026h(substring, c, str, "mailto:" + substring);
    }

    public /* synthetic */ C1019q mo1416b(C1199m c1199m) {
        return m3784a(c1199m);
    }
}
