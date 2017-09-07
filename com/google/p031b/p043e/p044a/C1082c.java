package com.google.p031b.p043e.p044a;

import com.google.p031b.C1079d;
import com.google.p031b.C1084e;
import com.google.p031b.C1155g;
import com.google.p031b.p034c.C1052b;
import com.google.p031b.p034c.C1055e;
import com.google.p031b.p034c.p039b.C1047a;
import com.google.p031b.p034c.p039b.C1049c;
import com.google.p031b.p034c.p039b.C1051e;
import java.util.Map;

public final class C1082c {
    private final C1049c f2292a = new C1049c(C1047a.f2170h);

    private void m3966a(byte[] bArr, int i, int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = i2 + i3;
        int i7 = i4 == 0 ? 1 : 2;
        int[] iArr = new int[(i6 / i7)];
        int i8 = 0;
        while (i8 < i6) {
            if (i4 == 0 || i8 % 2 == i4 - 1) {
                iArr[i8 / i7] = bArr[i8 + i] & 255;
            }
            i8++;
        }
        try {
            this.f2292a.m3843a(iArr, i3 / i7);
            while (i5 < i2) {
                if (i4 == 0 || i5 % 2 == i4 - 1) {
                    bArr[i5 + i] = (byte) iArr[i5 / i7];
                }
                i5++;
            }
        } catch (C1051e e) {
            throw C1079d.m3955a();
        }
    }

    public C1055e m3967a(C1052b c1052b, Map<C1084e, ?> map) {
        byte[] bArr;
        Object a = new C1080a(c1052b).m3956a();
        m3966a(a, 0, 10, 10, 0);
        int i = a[0] & 15;
        switch (i) {
            case 2:
            case 3:
            case 4:
                m3966a(a, 20, 84, 40, 1);
                m3966a(a, 20, 84, 40, 2);
                bArr = new byte[94];
                break;
            case 5:
                m3966a(a, 20, 68, 56, 1);
                m3966a(a, 20, 68, 56, 2);
                bArr = new byte[78];
                break;
            default:
                throw C1155g.m4329a();
        }
        System.arraycopy(a, 0, bArr, 0, 10);
        System.arraycopy(a, 20, bArr, 10, bArr.length - 10);
        return C1081b.m3960a(bArr, i);
    }
}
