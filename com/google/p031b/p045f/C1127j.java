package com.google.p031b.p045f;

import com.google.p031b.C1014k;
import com.google.p031b.C1016a;
import com.google.p031b.C1078l;
import com.google.p031b.C1084e;
import com.google.p031b.C1198j;
import com.google.p031b.C1199m;
import com.google.p031b.p034c.C1046a;
import com.google.p031b.p045f.p046a.C1114e;
import com.google.p031b.p045f.p046a.p047a.C1110d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class C1127j extends C1108l {
    private final C1108l[] f2409a;

    public C1127j(Map<C1084e, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(C1084e.POSSIBLE_FORMATS);
        boolean z = (map == null || map.get(C1084e.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        Collection arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(C1016a.EAN_13) || collection.contains(C1016a.UPC_A) || collection.contains(C1016a.EAN_8) || collection.contains(C1016a.UPC_E)) {
                arrayList.add(new C1128k(map));
            }
            if (collection.contains(C1016a.CODE_39)) {
                arrayList.add(new C1120d(z));
            }
            if (collection.contains(C1016a.CODE_93)) {
                arrayList.add(new C1121e());
            }
            if (collection.contains(C1016a.CODE_128)) {
                arrayList.add(new C1117b());
            }
            if (collection.contains(C1016a.ITF)) {
                arrayList.add(new C1126i());
            }
            if (collection.contains(C1016a.CODABAR)) {
                arrayList.add(new C1116a());
            }
            if (collection.contains(C1016a.RSS_14)) {
                arrayList.add(new C1114e());
            }
            if (collection.contains(C1016a.RSS_EXPANDED)) {
                arrayList.add(new C1110d());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new C1128k(map));
            arrayList.add(new C1120d());
            arrayList.add(new C1116a());
            arrayList.add(new C1121e());
            arrayList.add(new C1117b());
            arrayList.add(new C1126i());
            arrayList.add(new C1114e());
            arrayList.add(new C1110d());
        }
        this.f2409a = (C1108l[]) arrayList.toArray(new C1108l[arrayList.size()]);
    }

    public C1199m mo1426a(int i, C1046a c1046a, Map<C1084e, ?> map) {
        C1108l[] c1108lArr = this.f2409a;
        int i2 = 0;
        while (i2 < c1108lArr.length) {
            try {
                return c1108lArr[i2].mo1426a(i, c1046a, (Map) map);
            } catch (C1078l e) {
                i2++;
            }
        }
        throw C1198j.m4509a();
    }

    public void mo1415a() {
        for (C1014k a : this.f2409a) {
            a.mo1415a();
        }
    }
}
