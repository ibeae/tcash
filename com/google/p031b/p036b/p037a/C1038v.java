package com.google.p031b.p036b.p037a;

import com.google.p031b.C1199m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class C1038v extends C1017u {
    private static void m3778a(Collection<String> collection, Collection<String> collection2, String str) {
        Object obj = null;
        int indexOf = str.indexOf(59);
        if (indexOf < 0) {
            collection.add(str);
            collection2.add(null);
            return;
        }
        collection.add(str.substring(0, indexOf));
        String substring = str.substring(indexOf + 1);
        if (substring.startsWith("via=")) {
            obj = substring.substring(4);
        }
        collection2.add(obj);
    }

    public C1039w m3779a(C1199m c1199m) {
        String c = C1017u.m3696c(c1199m);
        if (!c.startsWith("sms:") && !c.startsWith("SMS:") && !c.startsWith("mms:") && !c.startsWith("MMS:")) {
            return null;
        }
        String str;
        String str2;
        String str3;
        Map d = C1017u.m3699d(c);
        int i = 0;
        if (d == null || d.isEmpty()) {
            str = null;
            str2 = null;
        } else {
            str3 = (String) d.get("subject");
            str = (String) d.get("body");
            str2 = str3;
            i = 1;
        }
        int indexOf = c.indexOf(63, 4);
        str3 = (indexOf < 0 || i == 0) ? c.substring(4) : c.substring(4, indexOf);
        indexOf = -1;
        List arrayList = new ArrayList(1);
        List arrayList2 = new ArrayList(1);
        while (true) {
            int indexOf2 = str3.indexOf(44, indexOf + 1);
            if (indexOf2 > indexOf) {
                C1038v.m3778a(arrayList, arrayList2, str3.substring(indexOf + 1, indexOf2));
                indexOf = indexOf2;
            } else {
                C1038v.m3778a(arrayList, arrayList2, str3.substring(indexOf + 1));
                return new C1039w((String[]) arrayList.toArray(new String[arrayList.size()]), (String[]) arrayList2.toArray(new String[arrayList2.size()]), str2, str);
            }
        }
    }

    public /* synthetic */ C1019q mo1416b(C1199m c1199m) {
        return m3779a(c1199m);
    }
}
