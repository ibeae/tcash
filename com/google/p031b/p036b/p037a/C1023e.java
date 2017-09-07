package com.google.p031b.p036b.p037a;

import com.google.p031b.C1199m;
import java.util.ArrayList;
import java.util.List;

public final class C1023e extends C1018a {
    private static String m3746a(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 != null) {
            str = str + ' ' + str2;
        }
        return str;
    }

    private static String[] m3747a(String str, String str2, String str3) {
        List arrayList = new ArrayList(3);
        if (str != null) {
            arrayList.add(str);
        }
        if (str2 != null) {
            arrayList.add(str2);
        }
        if (str3 != null) {
            arrayList.add(str3);
        }
        int size = arrayList.size();
        return size == 0 ? null : (String[]) arrayList.toArray(new String[size]);
    }

    public C1022d m3748a(C1199m c1199m) {
        String c = C1017u.m3696c(c1199m);
        if (!c.startsWith("BIZCARD:")) {
            return null;
        }
        String a = C1023e.m3746a(C1018a.m3703b("N:", c, true), C1018a.m3703b("X:", c, true));
        String b = C1018a.m3703b("T:", c, true);
        String b2 = C1018a.m3703b("C:", c, true);
        return new C1022d(C1017u.m3695b(a), null, null, C1023e.m3747a(C1018a.m3703b("B:", c, true), C1018a.m3703b("M:", c, true), C1018a.m3703b("F:", c, true)), null, C1017u.m3695b(C1018a.m3703b("E:", c, true)), null, null, null, C1018a.m3702a("A:", c, true), null, b2, null, b, null, null);
    }

    public /* synthetic */ C1019q mo1416b(C1199m c1199m) {
        return m3748a(c1199m);
    }
}
