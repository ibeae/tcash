package com.google.p031b.p040d.p041a;

import com.google.p031b.C1079d;
import com.google.p031b.p034c.C1052b;
import com.google.p031b.p034c.C1055e;
import com.google.p031b.p034c.p039b.C1047a;
import com.google.p031b.p034c.p039b.C1049c;
import com.google.p031b.p034c.p039b.C1051e;

public final class C1068d {
    private final C1049c f2266a = new C1049c(C1047a.f2168f);

    private void m3924a(byte[] bArr, int i) {
        int i2 = 0;
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        try {
            this.f2266a.m3843a(iArr, bArr.length - i);
            while (i2 < i) {
                bArr[i2] = (byte) iArr[i2];
                i2++;
            }
        } catch (C1051e e) {
            throw C1079d.m3955a();
        }
    }

    public C1055e m3925a(C1052b c1052b) {
        int i;
        C1063a c1063a = new C1063a(c1052b);
        C1064b[] a = C1064b.m3912a(c1063a.m3909b(), c1063a.m3905a());
        int length = a.length;
        int i2 = 0;
        for (C1064b a2 : a) {
            i2 += a2.m3913a();
        }
        byte[] bArr = new byte[i2];
        for (i = 0; i < length; i++) {
            C1064b c1064b = a[i];
            byte[] b = c1064b.m3914b();
            int a3 = c1064b.m3913a();
            m3924a(b, a3);
            for (i2 = 0; i2 < a3; i2++) {
                bArr[(i2 * length) + i] = b[i2];
            }
        }
        return C1067c.m3916a(bArr);
    }
}
