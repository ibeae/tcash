package com.google.p031b.p053h;

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
import com.google.p031b.p053h.p054a.C1169e;
import com.google.p031b.p053h.p054a.C1173i;
import com.google.p031b.p053h.p055b.C1181c;
import java.util.List;
import java.util.Map;

public class C1177a implements C1014k {
    private static final C1178o[] f2541a = new C1178o[0];
    private final C1169e f2542b = new C1169e();

    private static float m4389a(int[] iArr, C1052b c1052b) {
        int e = c1052b.m3856e();
        int d = c1052b.m3855d();
        int i = iArr[0];
        boolean z = true;
        int i2 = iArr[1];
        int i3 = i;
        int i4 = 0;
        while (i3 < d && i2 < e) {
            boolean z2;
            if (z != c1052b.m3848a(i3, i2)) {
                i = i4 + 1;
                if (i == 5) {
                    break;
                }
                int i5 = i;
                z2 = !z;
                i4 = i5;
            } else {
                z2 = z;
            }
            i3++;
            i2++;
            z = z2;
        }
        if (i3 != d && i2 != e) {
            return ((float) (i3 - iArr[0])) / 7.0f;
        }
        throw C1198j.m4509a();
    }

    private static C1052b m4390a(C1052b c1052b) {
        int[] b = c1052b.m3852b();
        int[] c = c1052b.m3854c();
        if (b == null || c == null) {
            throw C1198j.m4509a();
        }
        float a = C1177a.m4389a(b, c1052b);
        int i = b[1];
        int i2 = c[1];
        int i3 = b[0];
        int i4 = c[0];
        if (i3 >= i4 || i >= i2) {
            throw C1198j.m4509a();
        }
        if (i2 - i != i4 - i3) {
            i4 = (i2 - i) + i3;
        }
        int round = Math.round(((float) ((i4 - i3) + 1)) / a);
        int round2 = Math.round(((float) ((i2 - i) + 1)) / a);
        if (round <= 0 || round2 <= 0) {
            throw C1198j.m4509a();
        } else if (round2 != round) {
            throw C1198j.m4509a();
        } else {
            int i5 = (int) (a / 2.0f);
            int i6 = i + i5;
            i = i3 + i5;
            i4 = (((int) (((float) (round - 1)) * a)) + i) - (i4 - 1);
            if (i4 <= 0) {
                i3 = i;
            } else if (i4 > i5) {
                throw C1198j.m4509a();
            } else {
                i3 = i - i4;
            }
            i4 = (((int) (((float) (round2 - 1)) * a)) + i6) - (i2 - 1);
            if (i4 <= 0) {
                i4 = i6;
            } else if (i4 > i5) {
                throw C1198j.m4509a();
            } else {
                i4 = i6 - i4;
            }
            C1052b c1052b2 = new C1052b(round, round2);
            for (i = 0; i < round2; i++) {
                i5 = i4 + ((int) (((float) i) * a));
                for (i6 = 0; i6 < round; i6++) {
                    if (c1052b.m3848a(((int) (((float) i6) * a)) + i3, i5)) {
                        c1052b2.m3850b(i6, i);
                    }
                }
            }
            return c1052b2;
        }
    }

    public final C1199m mo1414a(C1062c c1062c, Map<C1084e, ?> map) {
        C1055e a;
        C1178o[] e;
        if (map == null || !map.containsKey(C1084e.PURE_BARCODE)) {
            C1010g a2 = new C1181c(c1062c.m3899c()).m4413a((Map) map);
            a = this.f2542b.m4361a(a2.m3660d(), (Map) map);
            e = a2.m3661e();
        } else {
            a = this.f2542b.m4361a(C1177a.m4390a(c1062c.m3899c()), (Map) map);
            e = f2541a;
        }
        if (a.m3871e() instanceof C1173i) {
            ((C1173i) a.m3871e()).m4372a(e);
        }
        C1199m c1199m = new C1199m(a.m3867b(), a.m3866a(), e, C1016a.QR_CODE);
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
