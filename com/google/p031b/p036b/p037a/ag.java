package com.google.p031b.p036b.p037a;

import com.facebook.internal.NativeProtocol;
import com.google.p031b.C1199m;
import java.util.List;

public final class ag extends C1017u {
    private static String m3731a(CharSequence charSequence, String str, boolean z) {
        List b = af.m3727b(charSequence, str, z, false);
        return (b == null || b.isEmpty()) ? null : (String) b.get(0);
    }

    private static String m3732a(String str) {
        return str != null ? (str.startsWith("mailto:") || str.startsWith("MAILTO:")) ? str.substring(7) : str : str;
    }

    private static String[] m3733b(CharSequence charSequence, String str, boolean z) {
        List a = af.m3721a(charSequence, str, z, false);
        if (a == null || a.isEmpty()) {
            return null;
        }
        int size = a.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = (String) ((List) a.get(i)).get(0);
        }
        return strArr;
    }

    public C1025g m3734a(C1199m c1199m) {
        String c = C1017u.m3696c(c1199m);
        if (c.indexOf("BEGIN:VEVENT") < 0) {
            return null;
        }
        String a = ag.m3731a("SUMMARY", c, true);
        String a2 = ag.m3731a("DTSTART", c, true);
        if (a2 == null) {
            return null;
        }
        double d;
        double d2;
        String a3 = ag.m3731a("DTEND", c, true);
        String a4 = ag.m3731a("DURATION", c, true);
        String a5 = ag.m3731a("LOCATION", c, true);
        String a6 = ag.m3732a(ag.m3731a("ORGANIZER", c, true));
        String[] b = ag.m3733b("ATTENDEE", c, true);
        if (b != null) {
            for (int i = 0; i < b.length; i++) {
                b[i] = ag.m3732a(b[i]);
            }
        }
        String a7 = ag.m3731a(NativeProtocol.METHOD_ARGS_DESCRIPTION, c, true);
        String a8 = ag.m3731a("GEO", c, true);
        if (a8 == null) {
            d = Double.NaN;
            d2 = Double.NaN;
        } else {
            int indexOf = a8.indexOf(59);
            try {
                d = Double.parseDouble(a8.substring(0, indexOf));
                d2 = Double.parseDouble(a8.substring(indexOf + 1));
            } catch (NumberFormatException e) {
                return null;
            }
        }
        try {
            return new C1025g(a, a2, a3, a4, a5, a6, b, a7, d, d2);
        } catch (IllegalArgumentException e2) {
            return null;
        }
    }

    public /* synthetic */ C1019q mo1416b(C1199m c1199m) {
        return m3734a(c1199m);
    }
}
