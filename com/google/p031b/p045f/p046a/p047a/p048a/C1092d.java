package com.google.p031b.p045f.p046a.p047a.p048a;

import com.google.p031b.C1198j;
import com.google.p031b.p034c.C1046a;

final class C1092d extends C1086h {
    C1092d(C1046a c1046a) {
        super(c1046a);
    }

    public String mo1424a() {
        if (m3973b().m3802a() < 48) {
            throw C1198j.m4509a();
        }
        StringBuilder stringBuilder = new StringBuilder();
        m3977b(stringBuilder, 8);
        int a = m3974c().m4031a(48, 2);
        stringBuilder.append("(393");
        stringBuilder.append(a);
        stringBuilder.append(')');
        a = m3974c().m4031a(50, 10);
        if (a / 100 == 0) {
            stringBuilder.append('0');
        }
        if (a / 10 == 0) {
            stringBuilder.append('0');
        }
        stringBuilder.append(a);
        stringBuilder.append(m3974c().m4032a(60, null).m4007a());
        return stringBuilder.toString();
    }
}
