package com.google.p031b.p045f;

import com.google.p031b.C1014k;
import com.google.p031b.C1016a;
import com.google.p031b.C1078l;
import com.google.p031b.C1084e;
import com.google.p031b.C1198j;
import com.google.p031b.C1199m;
import com.google.p031b.p034c.C1046a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class C1128k extends C1108l {
    private final C1122r[] f2410a;

    public C1128k(Map<C1084e, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(C1084e.POSSIBLE_FORMATS);
        Collection arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(C1016a.EAN_13)) {
                arrayList.add(new C1123f());
            } else if (collection.contains(C1016a.UPC_A)) {
                arrayList.add(new C1129n());
            }
            if (collection.contains(C1016a.EAN_8)) {
                arrayList.add(new C1124g());
            }
            if (collection.contains(C1016a.UPC_E)) {
                arrayList.add(new C1133s());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new C1123f());
            arrayList.add(new C1124g());
            arrayList.add(new C1133s());
        }
        this.f2410a = (C1122r[]) arrayList.toArray(new C1122r[arrayList.size()]);
    }

    public C1199m mo1426a(int i, C1046a c1046a, Map<C1084e, ?> map) {
        int[] a = C1122r.m4134a(c1046a);
        C1122r[] c1122rArr = this.f2410a;
        int length = c1122rArr.length;
        int i2 = 0;
        while (i2 < length) {
            try {
                C1199m a2 = c1122rArr[i2].mo1431a(i, c1046a, a, (Map) map);
                int i3 = (a2.m4516d() == C1016a.EAN_13 && a2.m4510a().charAt(0) == '0') ? 1 : 0;
                Collection collection = map == null ? null : (Collection) map.get(C1084e.POSSIBLE_FORMATS);
                i2 = (collection == null || collection.contains(C1016a.UPC_A)) ? 1 : 0;
                if (i3 == 0 || i2 == 0) {
                    return a2;
                }
                C1199m c1199m = new C1199m(a2.m4510a().substring(1), a2.m4514b(), a2.m4515c(), C1016a.UPC_A);
                c1199m.m4512a(a2.m4517e());
                return c1199m;
            } catch (C1078l e) {
                i2++;
            }
        }
        throw C1198j.m4509a();
    }

    public void mo1415a() {
        for (C1014k a : this.f2410a) {
            a.mo1415a();
        }
    }
}
