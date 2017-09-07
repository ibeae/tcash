package com.google.p031b.p045f.p046a.p047a;

import com.google.p031b.p034c.C1046a;
import java.util.List;

final class C1105a {
    static C1046a m4034a(List<C1106b> list) {
        int size = (list.size() << 1) - 1;
        C1046a c1046a = new C1046a((((C1106b) list.get(list.size() + -1)).m4038b() == null ? size - 1 : size) * 12);
        int a = ((C1106b) list.get(0)).m4038b().m4081a();
        size = 11;
        int i = 0;
        while (size >= 0) {
            if (((1 << size) & a) != 0) {
                c1046a.m3810b(i);
            }
            size--;
            i++;
        }
        int i2 = i;
        for (size = 1; size < list.size(); size++) {
            C1106b c1106b = (C1106b) list.get(size);
            int a2 = c1106b.m4037a().m4081a();
            a = 11;
            while (a >= 0) {
                if (((1 << a) & a2) != 0) {
                    c1046a.m3810b(i2);
                }
                a--;
                i2++;
            }
            if (c1106b.m4038b() != null) {
                a = c1106b.m4038b().m4081a();
                for (i = 11; i >= 0; i--) {
                    if (((1 << i) & a) != 0) {
                        c1046a.m3810b(i2);
                    }
                    i2++;
                }
            }
        }
        return c1046a;
    }
}
