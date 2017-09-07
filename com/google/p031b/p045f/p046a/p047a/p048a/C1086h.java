package com.google.p031b.p045f.p046a.p047a.p048a;

import com.google.p031b.p034c.C1046a;

abstract class C1086h extends C1085j {
    C1086h(C1046a c1046a) {
        super(c1046a);
    }

    private static void mo1423a(StringBuilder stringBuilder, int i) {
        int charAt;
        int i2 = 0;
        for (int i3 = 0; i3 < 13; i3++) {
            charAt = stringBuilder.charAt(i3 + i) - 48;
            if ((i3 & 1) == 0) {
                charAt *= 3;
            }
            i2 += charAt;
        }
        charAt = 10 - (i2 % 10);
        if (charAt == 10) {
            charAt = 0;
        }
        stringBuilder.append(charAt);
    }

    protected final void m3976a(StringBuilder stringBuilder, int i, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            int a = m3974c().m4031a((i3 * 10) + i, 10);
            if (a / 100 == 0) {
                stringBuilder.append('0');
            }
            if (a / 10 == 0) {
                stringBuilder.append('0');
            }
            stringBuilder.append(a);
        }
        C1086h.mo1423a(stringBuilder, i2);
    }

    protected final void m3977b(StringBuilder stringBuilder, int i) {
        stringBuilder.append("(01)");
        int length = stringBuilder.length();
        stringBuilder.append('9');
        m3976a(stringBuilder, i, length);
    }
}
