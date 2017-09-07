package com.google.p031b.p036b.p037a;

import com.google.p031b.C1016a;
import com.google.p031b.C1199m;
import java.util.HashMap;
import java.util.Map;

public final class C1030l extends C1017u {
    private static String m3765a(int i, String str) {
        if (str.charAt(i) != '(') {
            return null;
        }
        CharSequence substring = str.substring(i + 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < substring.length(); i2++) {
            char charAt = substring.charAt(i2);
            if (charAt == ')') {
                return stringBuilder.toString();
            }
            if (charAt < '0' || charAt > '9') {
                return null;
            }
            stringBuilder.append(charAt);
        }
        return stringBuilder.toString();
    }

    private static String m3766b(int i, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        String substring = str.substring(i);
        for (int i2 = 0; i2 < substring.length(); i2++) {
            char charAt = substring.charAt(i2);
            if (charAt == '(') {
                if (C1030l.m3765a(i2, substring) != null) {
                    break;
                }
                stringBuilder.append('(');
            } else {
                stringBuilder.append(charAt);
            }
        }
        return stringBuilder.toString();
    }

    public C1029k m3767a(C1199m c1199m) {
        if (c1199m.m4516d() != C1016a.RSS_EXPANDED) {
            return null;
        }
        String c = C1017u.m3696c(c1199m);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        Map hashMap = new HashMap();
        int i = 0;
        while (i < c.length()) {
            String a = C1030l.m3765a(i, c);
            if (a == null) {
                return null;
            }
            int length = (a.length() + 2) + i;
            String b = C1030l.m3766b(length, c);
            length += b.length();
            if ("00".equals(a)) {
                str2 = b;
            } else if ("01".equals(a)) {
                str = b;
            } else if ("10".equals(a)) {
                str3 = b;
            } else if ("11".equals(a)) {
                str4 = b;
            } else if ("13".equals(a)) {
                str5 = b;
            } else if ("15".equals(a)) {
                str6 = b;
            } else if ("17".equals(a)) {
                str7 = b;
            } else if ("3100".equals(a) || "3101".equals(a) || "3102".equals(a) || "3103".equals(a) || "3104".equals(a) || "3105".equals(a) || "3106".equals(a) || "3107".equals(a) || "3108".equals(a) || "3109".equals(a)) {
                str9 = "KG";
                str10 = a.substring(3);
                str8 = b;
            } else if ("3200".equals(a) || "3201".equals(a) || "3202".equals(a) || "3203".equals(a) || "3204".equals(a) || "3205".equals(a) || "3206".equals(a) || "3207".equals(a) || "3208".equals(a) || "3209".equals(a)) {
                str9 = "LB";
                str10 = a.substring(3);
                str8 = b;
            } else if ("3920".equals(a) || "3921".equals(a) || "3922".equals(a) || "3923".equals(a)) {
                str12 = a.substring(3);
                str11 = b;
            } else if (!"3930".equals(a) && !"3931".equals(a) && !"3932".equals(a) && !"3933".equals(a)) {
                hashMap.put(a, b);
            } else if (b.length() < 4) {
                return null;
            } else {
                str11 = b.substring(3);
                str13 = b.substring(0, 3);
                str12 = a.substring(3);
            }
            i = length;
        }
        return new C1029k(c, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, hashMap);
    }

    public /* synthetic */ C1019q mo1416b(C1199m c1199m) {
        return m3767a(c1199m);
    }
}
