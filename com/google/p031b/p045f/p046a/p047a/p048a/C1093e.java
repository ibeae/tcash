package com.google.p031b.p045f.p046a.p047a.p048a;

import com.google.p031b.C1198j;
import com.google.p031b.p034c.C1046a;

final class C1093e extends C1087i {
    private final String f2309a;
    private final String f2310b;

    C1093e(C1046a c1046a, String str, String str2) {
        super(c1046a);
        this.f2309a = str2;
        this.f2310b = str;
    }

    private void m3988c(StringBuilder stringBuilder, int i) {
        int a = m3974c().m4031a(i, 16);
        if (a != 38400) {
            stringBuilder.append('(');
            stringBuilder.append(this.f2309a);
            stringBuilder.append(')');
            int i2 = a % 32;
            a /= 32;
            int i3 = (a % 12) + 1;
            a /= 12;
            if (a / 10 == 0) {
                stringBuilder.append('0');
            }
            stringBuilder.append(a);
            if (i3 / 10 == 0) {
                stringBuilder.append('0');
            }
            stringBuilder.append(i3);
            if (i2 / 10 == 0) {
                stringBuilder.append('0');
            }
            stringBuilder.append(i2);
        }
    }

    protected int mo1425a(int i) {
        return i % 100000;
    }

    public String mo1424a() {
        if (m3973b().m3802a() != 84) {
            throw C1198j.m4509a();
        }
        StringBuilder stringBuilder = new StringBuilder();
        m3977b(stringBuilder, 8);
        m3980b(stringBuilder, 48, 20);
        m3988c(stringBuilder, 68);
        return stringBuilder.toString();
    }

    protected void mo1423a(StringBuilder stringBuilder, int i) {
        int i2 = i / 100000;
        stringBuilder.append('(');
        stringBuilder.append(this.f2310b);
        stringBuilder.append(i2);
        stringBuilder.append(')');
    }
}
