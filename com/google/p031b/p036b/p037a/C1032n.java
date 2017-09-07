package com.google.p031b.p036b.p037a;

import com.google.p031b.C1199m;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class C1032n extends C1017u {
    private static final Pattern f2130a = Pattern.compile("geo:([\\-0-9.]+),([\\-0-9.]+)(?:,([\\-0-9.]+))?(?:\\?(.*))?", 2);

    public C1031m m3770a(C1199m c1199m) {
        double d = 0.0d;
        Matcher matcher = f2130a.matcher(C1017u.m3696c(c1199m));
        if (!matcher.matches()) {
            return null;
        }
        String group = matcher.group(4);
        try {
            double parseDouble = Double.parseDouble(matcher.group(1));
            if (parseDouble > 90.0d || parseDouble < -90.0d) {
                return null;
            }
            double parseDouble2 = Double.parseDouble(matcher.group(2));
            if (parseDouble2 > 180.0d || parseDouble2 < -180.0d) {
                return null;
            }
            if (matcher.group(3) != null) {
                double parseDouble3 = Double.parseDouble(matcher.group(3));
                if (parseDouble3 < 0.0d) {
                    return null;
                }
                d = parseDouble3;
            }
            return new C1031m(parseDouble, parseDouble2, d, group);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public /* synthetic */ C1019q mo1416b(C1199m c1199m) {
        return m3770a(c1199m);
    }
}
