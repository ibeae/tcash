package com.google.p031b.p036b.p037a;

import com.google.p031b.C1199m;

public final class C1040x extends C1017u {
    public C1039w m3782a(C1199m c1199m) {
        String c = C1017u.m3696c(c1199m);
        if (!c.startsWith("smsto:") && !c.startsWith("SMSTO:") && !c.startsWith("mmsto:") && !c.startsWith("MMSTO:")) {
            return null;
        }
        String substring = c.substring(6);
        int indexOf = substring.indexOf(58);
        if (indexOf >= 0) {
            c = substring.substring(indexOf + 1);
            substring = substring.substring(0, indexOf);
        } else {
            c = null;
        }
        return new C1039w(substring, null, null, c);
    }

    public /* synthetic */ C1019q mo1416b(C1199m c1199m) {
        return m3782a(c1199m);
    }
}
