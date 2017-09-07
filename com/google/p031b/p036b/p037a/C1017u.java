package com.google.p031b.p036b.p037a;

import com.google.p031b.C1199m;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public abstract class C1017u {
    private static final C1017u[] f2047a = new C1017u[]{new C1024f(), new C1021c(), new C1028j(), new C1020b(), new af(), new C1023e(), new ag(), new C1027i(), new C1041y(), new aa(), new C1038v(), new C1040x(), new C1032n(), new ai(), new ae(), new ad(), new C1034p(), new C1037t(), new C1030l()};
    private static final Pattern f2048b = Pattern.compile("\\d*");
    private static final Pattern f2049c = Pattern.compile("[a-zA-Z0-9]*");
    private static final Pattern f2050d = Pattern.compile("&");
    private static final Pattern f2051e = Pattern.compile("=");

    protected static int m3690a(char c) {
        return (c < '0' || c > '9') ? (c < 'a' || c > 'f') ? (c < 'A' || c > 'F') ? -1 : (c - 65) + 10 : (c - 97) + 10 : c - 48;
    }

    private static void m3691a(CharSequence charSequence, Map<String, String> map) {
        String[] split = f2051e.split(charSequence, 2);
        if (split.length == 2) {
            try {
                map.put(split[0], C1017u.m3700e(split[1]));
            } catch (IllegalArgumentException e) {
            }
        }
    }

    protected static boolean m3692a(CharSequence charSequence, int i) {
        return charSequence != null && i == charSequence.length() && f2048b.matcher(charSequence).matches();
    }

    static String[] m3693a(String str, String str2, char c, boolean z) {
        int length = str2.length();
        int i = 0;
        List list = null;
        while (i < length) {
            i = str2.indexOf(str, i);
            if (i < 0) {
                break;
            }
            int length2 = i + str.length();
            Object obj = 1;
            List list2 = list;
            int i2 = length2;
            while (obj != null) {
                int indexOf = str2.indexOf(c, i2);
                if (indexOf < 0) {
                    i2 = str2.length();
                    obj = null;
                } else if (str2.charAt(indexOf - 1) == '\\') {
                    i2 = indexOf + 1;
                } else {
                    if (list2 == null) {
                        list2 = new ArrayList(3);
                    }
                    String c2 = C1017u.m3697c(str2.substring(length2, indexOf));
                    if (z) {
                        c2 = c2.trim();
                    }
                    if (!c2.isEmpty()) {
                        list2.add(c2);
                    }
                    i2 = indexOf + 1;
                    obj = null;
                }
            }
            int i3 = i2;
            list = list2;
            i = i3;
        }
        return (list == null || list.isEmpty()) ? null : (String[]) list.toArray(new String[list.size()]);
    }

    static String m3694b(String str, String str2, char c, boolean z) {
        String[] a = C1017u.m3693a(str, str2, c, z);
        return a == null ? null : a[0];
    }

    protected static String[] m3695b(String str) {
        if (str == null) {
            return null;
        }
        return new String[]{str};
    }

    protected static String m3696c(C1199m c1199m) {
        String a = c1199m.m4510a();
        return a.startsWith("﻿") ? a.substring(1) : a;
    }

    protected static String m3697c(String str) {
        int indexOf = str.indexOf(92);
        if (indexOf < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(length - 1);
        stringBuilder.append(str.toCharArray(), 0, indexOf);
        indexOf = 0;
        for (int i = indexOf; i < length; i++) {
            char charAt = str.charAt(i);
            if (indexOf == 0 && charAt == '\\') {
                indexOf = 1;
            } else {
                stringBuilder.append(charAt);
                indexOf = 0;
            }
        }
        return stringBuilder.toString();
    }

    public static C1019q m3698d(C1199m c1199m) {
        for (C1017u b : f2047a) {
            C1019q b2 = b.mo1416b(c1199m);
            if (b2 != null) {
                return b2;
            }
        }
        return new ab(c1199m.m4510a(), null);
    }

    static Map<String, String> m3699d(String str) {
        int indexOf = str.indexOf(63);
        if (indexOf < 0) {
            return null;
        }
        Map hashMap = new HashMap(3);
        for (CharSequence a : f2050d.split(str.substring(indexOf + 1))) {
            C1017u.m3691a(a, hashMap);
        }
        return hashMap;
    }

    static String m3700e(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public abstract C1019q mo1416b(C1199m c1199m);
}
