package com.google.p031b;

import com.google.p031b.p032a.C1015b;
import com.google.p031b.p040d.C1073a;
import com.google.p031b.p043e.C1083a;
import com.google.p031b.p045f.C1127j;
import com.google.p031b.p049g.C1153b;
import com.google.p031b.p053h.C1177a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class C1197i implements C1014k {
    private Map<C1084e, ?> f2587a;
    private C1014k[] f2588b;

    private C1199m m4504b(C1062c c1062c) {
        if (this.f2588b != null) {
            C1014k[] c1014kArr = this.f2588b;
            int length = c1014kArr.length;
            int i = 0;
            while (i < length) {
                try {
                    return c1014kArr[i].mo1414a(c1062c, this.f2587a);
                } catch (C1078l e) {
                    i++;
                }
            }
        }
        throw C1198j.m4509a();
    }

    public C1199m m4505a(C1062c c1062c) {
        if (this.f2588b == null) {
            m4508a(null);
        }
        return m4504b(c1062c);
    }

    public C1199m mo1414a(C1062c c1062c, Map<C1084e, ?> map) {
        m4508a((Map) map);
        return m4504b(c1062c);
    }

    public void mo1415a() {
        if (this.f2588b != null) {
            for (C1014k a : this.f2588b) {
                a.mo1415a();
            }
        }
    }

    public void m4508a(Map<C1084e, ?> map) {
        Object obj = null;
        this.f2587a = map;
        Object obj2 = (map == null || !map.containsKey(C1084e.TRY_HARDER)) ? null : 1;
        Collection collection = map == null ? null : (Collection) map.get(C1084e.POSSIBLE_FORMATS);
        Collection arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(C1016a.UPC_A) || collection.contains(C1016a.UPC_E) || collection.contains(C1016a.EAN_13) || collection.contains(C1016a.EAN_8) || collection.contains(C1016a.CODABAR) || collection.contains(C1016a.CODE_39) || collection.contains(C1016a.CODE_93) || collection.contains(C1016a.CODE_128) || collection.contains(C1016a.ITF) || collection.contains(C1016a.RSS_14) || collection.contains(C1016a.RSS_EXPANDED)) {
                obj = 1;
            }
            if (obj != null && obj2 == null) {
                arrayList.add(new C1127j(map));
            }
            if (collection.contains(C1016a.QR_CODE)) {
                arrayList.add(new C1177a());
            }
            if (collection.contains(C1016a.DATA_MATRIX)) {
                arrayList.add(new C1073a());
            }
            if (collection.contains(C1016a.AZTEC)) {
                arrayList.add(new C1015b());
            }
            if (collection.contains(C1016a.PDF_417)) {
                arrayList.add(new C1153b());
            }
            if (collection.contains(C1016a.MAXICODE)) {
                arrayList.add(new C1083a());
            }
            if (!(obj == null || obj2 == null)) {
                arrayList.add(new C1127j(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (obj2 == null) {
                arrayList.add(new C1127j(map));
            }
            arrayList.add(new C1177a());
            arrayList.add(new C1073a());
            arrayList.add(new C1015b());
            arrayList.add(new C1153b());
            arrayList.add(new C1083a());
            if (obj2 != null) {
                arrayList.add(new C1127j(map));
            }
        }
        this.f2588b = (C1014k[]) arrayList.toArray(new C1014k[arrayList.size()]);
    }
}
