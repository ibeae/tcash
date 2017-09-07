package com.google.p031b.p040d;

import com.google.p031b.C1014k;
import com.google.p031b.C1016a;
import com.google.p031b.C1062c;
import com.google.p031b.C1084e;
import com.google.p031b.C1178o;
import com.google.p031b.C1198j;
import com.google.p031b.C1199m;
import com.google.p031b.C1200n;
import com.google.p031b.p034c.C1010g;
import com.google.p031b.p034c.C1052b;
import com.google.p031b.p034c.C1055e;
import com.google.p031b.p040d.p041a.C1068d;
import com.google.p031b.p040d.p042b.C1077a;
import java.util.List;
import java.util.Map;

public final class C1073a implements C1014k {
    private static final C1178o[] f2279a = new C1178o[0];
    private final C1068d f2280b = new C1068d();

    private static int m3939a(int[] iArr, C1052b c1052b) {
        int d = c1052b.m3855d();
        int i = iArr[0];
        int i2 = iArr[1];
        while (i < d && c1052b.m3848a(i, i2)) {
            i++;
        }
        if (i == d) {
            throw C1198j.m4509a();
        }
        i -= iArr[0];
        if (i != 0) {
            return i;
        }
        throw C1198j.m4509a();
    }

    private static C1052b m3940a(C1052b c1052b) {
        int[] b = c1052b.m3852b();
        int[] c = c1052b.m3854c();
        if (b == null || c == null) {
            throw C1198j.m4509a();
        }
        int a = C1073a.m3939a(b, c1052b);
        int i = b[1];
        int i2 = c[1];
        int i3 = b[0];
        int i4 = ((c[0] - i3) + 1) / a;
        i2 = ((i2 - i) + 1) / a;
        if (i4 <= 0 || i2 <= 0) {
            throw C1198j.m4509a();
        }
        int i5 = a >> 1;
        i += i5;
        int i6 = i3 + i5;
        C1052b c1052b2 = new C1052b(i4, i2);
        for (i5 = 0; i5 < i2; i5++) {
            int i7 = i + (i5 * a);
            for (i3 = 0; i3 < i4; i3++) {
                if (c1052b.m3848a((i3 * a) + i6, i7)) {
                    c1052b2.m3850b(i3, i5);
                }
            }
        }
        return c1052b2;
    }

    public C1199m mo1414a(C1062c c1062c, Map<C1084e, ?> map) {
        C1055e a;
        C1178o[] e;
        if (map == null || !map.containsKey(C1084e.PURE_BARCODE)) {
            C1010g a2 = new C1077a(c1062c.m3899c()).m3954a();
            a = this.f2280b.m3925a(a2.m3660d());
            e = a2.m3661e();
        } else {
            a = this.f2280b.m3925a(C1073a.m3940a(c1062c.m3899c()));
            e = f2279a;
        }
        C1199m c1199m = new C1199m(a.m3867b(), a.m3866a(), e, C1016a.DATA_MATRIX);
        List c = a.m3869c();
        if (c != null) {
            c1199m.m4511a(C1200n.BYTE_SEGMENTS, c);
        }
        String d = a.m3870d();
        if (d != null) {
            c1199m.m4511a(C1200n.ERROR_CORRECTION_LEVEL, d);
        }
        return c1199m;
    }

    public void mo1415a() {
    }
}
