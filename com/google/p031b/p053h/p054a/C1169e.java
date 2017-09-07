package com.google.p031b.p053h.p054a;

import com.google.p031b.C1078l;
import com.google.p031b.C1079d;
import com.google.p031b.C1084e;
import com.google.p031b.C1155g;
import com.google.p031b.p034c.C1052b;
import com.google.p031b.p034c.C1055e;
import com.google.p031b.p034c.p039b.C1047a;
import com.google.p031b.p034c.p039b.C1049c;
import com.google.p031b.p034c.p039b.C1051e;
import java.util.Map;

public final class C1169e {
    private final C1049c f2505a = new C1049c(C1047a.f2167e);

    private C1055e m4359a(C1156a c1156a, Map<C1084e, ?> map) {
        C1176j b = c1156a.m4333b();
        C1170f a = c1156a.m4331a().m4367a();
        C1157b[] a2 = C1157b.m4337a(c1156a.m4334c(), b, a);
        int i = 0;
        for (C1157b a3 : a2) {
            i += a3.m4338a();
        }
        byte[] bArr = new byte[i];
        int length = a2.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            C1157b c1157b = a2[i2];
            byte[] b2 = c1157b.m4339b();
            int a4 = c1157b.m4338a();
            m4360a(b2, a4);
            i = i3;
            i3 = 0;
            while (i3 < a4) {
                int i4 = i + 1;
                bArr[i] = b2[i3];
                i3++;
                i = i4;
            }
            i2++;
            i3 = i;
        }
        return C1168d.m4353a(bArr, b, a, (Map) map);
    }

    private void m4360a(byte[] bArr, int i) {
        int i2 = 0;
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        try {
            this.f2505a.m3843a(iArr, bArr.length - i);
            while (i2 < i) {
                bArr[i2] = (byte) iArr[i2];
                i2++;
            }
        } catch (C1051e e) {
            throw C1079d.m3955a();
        }
    }

    public C1055e m4361a(C1052b c1052b, Map<C1084e, ?> map) {
        C1055e a;
        C1079d c1079d;
        C1078l c1078l = null;
        C1156a c1156a = new C1156a(c1052b);
        try {
            a = m4359a(c1156a, (Map) map);
        } catch (C1155g e) {
            C1155g c1155g = e;
            c1079d = c1078l;
            try {
                c1156a.m4335d();
                c1156a.m4332a(true);
                c1156a.m4333b();
                c1156a.m4331a();
                c1156a.m4336e();
                a = m4359a(c1156a, (Map) map);
                a.m3865a(new C1173i(true));
                return a;
            } catch (C1155g e2) {
                if (c1155g != null) {
                    throw c1155g;
                } else if (c1079d != null) {
                    throw c1079d;
                } else {
                    throw e2;
                }
            } catch (C1079d e3) {
                if (c1155g != null) {
                    throw c1155g;
                } else if (c1079d != null) {
                    throw c1079d;
                } else {
                    throw e3;
                }
            }
        } catch (C1079d e4) {
            c1079d = e4;
            C1078l c1078l2 = c1078l;
            c1156a.m4335d();
            c1156a.m4332a(true);
            c1156a.m4333b();
            c1156a.m4331a();
            c1156a.m4336e();
            a = m4359a(c1156a, (Map) map);
            a.m3865a(new C1173i(true));
            return a;
        }
        return a;
    }
}
