package com.google.p031b.p049g;

import com.google.p031b.C1014k;
import com.google.p031b.C1016a;
import com.google.p031b.C1062c;
import com.google.p031b.C1084e;
import com.google.p031b.C1178o;
import com.google.p031b.C1198j;
import com.google.p031b.C1199m;
import com.google.p031b.C1200n;
import com.google.p031b.p034c.C1055e;
import com.google.p031b.p049g.p050a.C1149j;
import com.google.p031b.p049g.p052b.C1151a;
import com.google.p031b.p049g.p052b.C1152b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class C1153b implements C1014k {
    private static int m4318a(C1178o c1178o, C1178o c1178o2) {
        return (c1178o == null || c1178o2 == null) ? 0 : (int) Math.abs(c1178o.m4396a() - c1178o2.m4396a());
    }

    private static int m4319a(C1178o[] c1178oArr) {
        return Math.max(Math.max(C1153b.m4318a(c1178oArr[0], c1178oArr[4]), (C1153b.m4318a(c1178oArr[6], c1178oArr[2]) * 17) / 18), Math.max(C1153b.m4318a(c1178oArr[1], c1178oArr[5]), (C1153b.m4318a(c1178oArr[7], c1178oArr[3]) * 17) / 18));
    }

    private static C1199m[] m4320a(C1062c c1062c, Map<C1084e, ?> map, boolean z) {
        List arrayList = new ArrayList();
        C1152b a = C1151a.m4309a(c1062c, (Map) map, z);
        for (C1178o[] c1178oArr : a.m4317b()) {
            C1055e a2 = C1149j.m4285a(a.m4316a(), c1178oArr[4], c1178oArr[5], c1178oArr[6], c1178oArr[7], C1153b.m4322b(c1178oArr), C1153b.m4319a(c1178oArr));
            C1199m c1199m = new C1199m(a2.m3867b(), a2.m3866a(), c1178oArr, C1016a.PDF_417);
            c1199m.m4511a(C1200n.ERROR_CORRECTION_LEVEL, a2.m3870d());
            C1154c c1154c = (C1154c) a2.m3871e();
            if (c1154c != null) {
                c1199m.m4511a(C1200n.PDF417_EXTRA_METADATA, c1154c);
            }
            arrayList.add(c1199m);
        }
        return (C1199m[]) arrayList.toArray(new C1199m[arrayList.size()]);
    }

    private static int m4321b(C1178o c1178o, C1178o c1178o2) {
        return (c1178o == null || c1178o2 == null) ? ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : (int) Math.abs(c1178o.m4396a() - c1178o2.m4396a());
    }

    private static int m4322b(C1178o[] c1178oArr) {
        return Math.min(Math.min(C1153b.m4321b(c1178oArr[0], c1178oArr[4]), (C1153b.m4321b(c1178oArr[6], c1178oArr[2]) * 17) / 18), Math.min(C1153b.m4321b(c1178oArr[1], c1178oArr[5]), (C1153b.m4321b(c1178oArr[7], c1178oArr[3]) * 17) / 18));
    }

    public C1199m mo1414a(C1062c c1062c, Map<C1084e, ?> map) {
        C1199m[] a = C1153b.m4320a(c1062c, map, false);
        if (a != null && a.length != 0 && a[0] != null) {
            return a[0];
        }
        throw C1198j.m4509a();
    }

    public void mo1415a() {
    }
}
