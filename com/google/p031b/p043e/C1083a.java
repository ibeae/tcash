package com.google.p031b.p043e;

import com.google.p031b.C1014k;
import com.google.p031b.C1016a;
import com.google.p031b.C1062c;
import com.google.p031b.C1084e;
import com.google.p031b.C1178o;
import com.google.p031b.C1198j;
import com.google.p031b.C1199m;
import com.google.p031b.C1200n;
import com.google.p031b.p034c.C1052b;
import com.google.p031b.p034c.C1055e;
import com.google.p031b.p043e.p044a.C1082c;
import java.util.Map;

public final class C1083a implements C1014k {
    private static final C1178o[] f2293a = new C1178o[0];
    private final C1082c f2294b = new C1082c();

    private static C1052b m3968a(C1052b c1052b) {
        int[] a = c1052b.m3849a();
        if (a == null) {
            throw C1198j.m4509a();
        }
        int i = a[0];
        int i2 = a[1];
        int i3 = a[2];
        int i4 = a[3];
        C1052b c1052b2 = new C1052b(30, 33);
        for (int i5 = 0; i5 < 33; i5++) {
            int i6 = i2 + (((i5 * i4) + (i4 / 2)) / 33);
            for (int i7 = 0; i7 < 30; i7++) {
                if (c1052b.m3848a(((((i7 * i3) + (i3 / 2)) + (((i5 & 1) * i3) / 2)) / 30) + i, i6)) {
                    c1052b2.m3850b(i7, i5);
                }
            }
        }
        return c1052b2;
    }

    public C1199m mo1414a(C1062c c1062c, Map<C1084e, ?> map) {
        if (map == null || !map.containsKey(C1084e.PURE_BARCODE)) {
            throw C1198j.m4509a();
        }
        C1055e a = this.f2294b.m3967a(C1083a.m3968a(c1062c.m3899c()), map);
        C1199m c1199m = new C1199m(a.m3867b(), a.m3866a(), f2293a, C1016a.MAXICODE);
        String d = a.m3870d();
        if (d != null) {
            c1199m.m4511a(C1200n.ERROR_CORRECTION_LEVEL, d);
        }
        return c1199m;
    }

    public void mo1415a() {
    }
}
