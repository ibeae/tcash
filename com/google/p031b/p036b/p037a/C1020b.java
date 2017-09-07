package com.google.p031b.p036b.p037a;

import com.google.p031b.C1199m;
import java.util.ArrayList;
import java.util.List;

public final class C1020b extends C1017u {
    private static String[] m3739a(String str, int i, String str2, boolean z) {
        List list = null;
        for (int i2 = 1; i2 <= i; i2++) {
            String b = C1017u.m3694b(str + i2 + ':', str2, '\r', z);
            if (b == null) {
                break;
            }
            if (list == null) {
                list = new ArrayList(i);
            }
            list.add(b);
        }
        return list == null ? null : (String[]) list.toArray(new String[list.size()]);
    }

    public C1022d m3740a(C1199m c1199m) {
        String c = C1017u.m3696c(c1199m);
        if (!c.contains("MEMORY") || !c.contains("\r\n")) {
            return null;
        }
        return new C1022d(C1017u.m3695b(C1017u.m3694b("NAME1:", c, '\r', true)), null, C1017u.m3694b("NAME2:", c, '\r', true), C1020b.m3739a("TEL", 3, c, true), null, C1020b.m3739a("MAIL", 3, c, true), null, null, C1017u.m3694b("MEMORY:", c, '\r', false), C1017u.m3694b("ADD:", c, '\r', true) == null ? null : new String[]{C1017u.m3694b("ADD:", c, '\r', true)}, null, null, null, null, null, null);
    }

    public /* synthetic */ C1019q mo1416b(C1199m c1199m) {
        return m3740a(c1199m);
    }
}
