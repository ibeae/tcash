package com.google.p031b.p036b.p037a;

import com.google.p031b.C1199m;

public final class aa extends C1017u {
    public C1042z m3704a(C1199m c1199m) {
        String c = C1017u.m3696c(c1199m);
        if (!c.startsWith("tel:") && !c.startsWith("TEL:")) {
            return null;
        }
        String str = c.startsWith("TEL:") ? "tel:" + c.substring(4) : c;
        int indexOf = c.indexOf(63, 4);
        return new C1042z(indexOf < 0 ? c.substring(4) : c.substring(4, indexOf), str, null);
    }

    public /* synthetic */ C1019q mo1416b(C1199m c1199m) {
        return m3704a(c1199m);
    }
}
