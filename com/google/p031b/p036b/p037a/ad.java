package com.google.p031b.p036b.p037a;

import com.google.p031b.C1199m;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ad extends C1017u {
    private static final Pattern f2058a = Pattern.compile("[a-zA-Z0-9]{2,}:");
    private static final Pattern f2059b = Pattern.compile("([a-zA-Z0-9\\-]+\\.)+[a-zA-Z]{2,}(:\\d{1,5})?(/|\\?|$)");

    static boolean m3714a(String str) {
        if (str.contains(" ")) {
            return false;
        }
        Matcher matcher = f2058a.matcher(str);
        if (matcher.find() && matcher.start() == 0) {
            return true;
        }
        matcher = f2059b.matcher(str);
        return matcher.find() && matcher.start() == 0;
    }

    public ac m3715a(C1199m c1199m) {
        String c = C1017u.m3696c(c1199m);
        if (c.startsWith("URL:") || c.startsWith("URI:")) {
            return new ac(c.substring(4).trim(), null);
        }
        c = c.trim();
        return ad.m3714a(c) ? new ac(c, null) : null;
    }

    public /* synthetic */ C1019q mo1416b(C1199m c1199m) {
        return m3715a(c1199m);
    }
}
