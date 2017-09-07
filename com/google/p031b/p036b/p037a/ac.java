package com.google.p031b.p036b.p037a;

import java.util.regex.Pattern;

public final class ac extends C1019q {
    private static final Pattern f2055a = Pattern.compile(":/*([^/@]+)@[^/]+");
    private final String f2056b;
    private final String f2057c;

    public ac(String str, String str2) {
        super(C1035r.URI);
        this.f2056b = ac.m3711a(str);
        this.f2057c = str2;
    }

    private static String m3711a(String str) {
        String trim = str.trim();
        int indexOf = trim.indexOf(58);
        return indexOf < 0 ? "http://" + trim : ac.m3712a(trim, indexOf) ? "http://" + trim : trim;
    }

    private static boolean m3712a(String str, int i) {
        int indexOf = str.indexOf(47, i + 1);
        int length = indexOf < 0 ? str.length() : indexOf;
        if (length <= i + 1) {
            return false;
        }
        indexOf = i + 1;
        while (indexOf < length) {
            if (str.charAt(indexOf) < '0' || str.charAt(indexOf) > '9') {
                return false;
            }
            indexOf++;
        }
        return true;
    }

    public String mo1417a() {
        StringBuilder stringBuilder = new StringBuilder(30);
        C1019q.m3706a(this.f2057c, stringBuilder);
        C1019q.m3706a(this.f2056b, stringBuilder);
        return stringBuilder.toString();
    }
}
