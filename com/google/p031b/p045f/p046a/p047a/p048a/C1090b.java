package com.google.p031b.p045f.p046a.p047a.p048a;

import com.google.p031b.p034c.C1046a;

final class C1090b extends C1088f {
    C1090b(C1046a c1046a) {
        super(c1046a);
    }

    protected int mo1425a(int i) {
        return i < 10000 ? i : i - 10000;
    }

    protected void mo1423a(StringBuilder stringBuilder, int i) {
        if (i < 10000) {
            stringBuilder.append("(3202)");
        } else {
            stringBuilder.append("(3203)");
        }
    }
}
