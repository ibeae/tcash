package com.google.p031b.p036b.p037a;

import com.google.p031b.C1199m;

public final class ae extends C1017u {
    public ac m3717a(C1199m c1199m) {
        String str = null;
        String c = C1017u.m3696c(c1199m);
        if (!c.startsWith("urlto:") && !c.startsWith("URLTO:")) {
            return null;
        }
        int indexOf = c.indexOf(58, 6);
        if (indexOf < 0) {
            return null;
        }
        if (indexOf > 6) {
            str = c.substring(6, indexOf);
        }
        return new ac(c.substring(indexOf + 1), str);
    }

    public /* synthetic */ C1019q mo1416b(C1199m c1199m) {
        return m3717a(c1199m);
    }
}
