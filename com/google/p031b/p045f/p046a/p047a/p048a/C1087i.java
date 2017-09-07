package com.google.p031b.p045f.p046a.p047a.p048a;

import com.google.p031b.p034c.C1046a;

abstract class C1087i extends C1086h {
    C1087i(C1046a c1046a) {
        super(c1046a);
    }

    protected abstract int mo1425a(int i);

    protected abstract void mo1423a(StringBuilder stringBuilder, int i);

    protected final void m3980b(StringBuilder stringBuilder, int i, int i2) {
        int a = m3974c().m4031a(i, i2);
        mo1423a(stringBuilder, a);
        int a2 = mo1425a(a);
        int i3 = 100000;
        for (a = 0; a < 5; a++) {
            if (a2 / i3 == 0) {
                stringBuilder.append('0');
            }
            i3 /= 10;
        }
        stringBuilder.append(a2);
    }
}
