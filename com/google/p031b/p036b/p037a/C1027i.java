package com.google.p031b.p036b.p037a;

import com.google.p031b.C1199m;
import java.util.Map;

public final class C1027i extends C1017u {
    public C1026h m3757a(C1199m c1199m) {
        String str = null;
        String c = C1017u.m3696c(c1199m);
        if (!c.startsWith("mailto:") && !c.startsWith("MAILTO:")) {
            return C1028j.m3759a(c) ? new C1026h(c, null, null, "mailto:" + c) : null;
        } else {
            String str2;
            String substring = c.substring(7);
            int indexOf = substring.indexOf(63);
            if (indexOf >= 0) {
                substring = substring.substring(0, indexOf);
            }
            substring = C1017u.m3700e(substring);
            Map d = C1017u.m3699d(c);
            if (d != null) {
                str2 = substring.isEmpty() ? (String) d.get("to") : substring;
                substring = (String) d.get("subject");
                str = (String) d.get("body");
            } else {
                str2 = substring;
                substring = null;
            }
            return new C1026h(str2, substring, str, c);
        }
    }

    public /* synthetic */ C1019q mo1416b(C1199m c1199m) {
        return m3757a(c1199m);
    }
}
