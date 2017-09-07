package com.google.p031b.p049g.p050a;

import com.google.p031b.p049g.C1150a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

final class C1139b {
    private final Map<Integer, Integer> f2448a = new HashMap();

    C1139b() {
    }

    void m4214a(int i) {
        Integer num = (Integer) this.f2448a.get(Integer.valueOf(i));
        if (num == null) {
            num = Integer.valueOf(0);
        }
        this.f2448a.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
    }

    int[] m4215a() {
        Collection arrayList = new ArrayList();
        int i = -1;
        for (Entry entry : this.f2448a.entrySet()) {
            int i2;
            if (((Integer) entry.getValue()).intValue() > i) {
                i = ((Integer) entry.getValue()).intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
                i2 = i;
            } else {
                if (((Integer) entry.getValue()).intValue() == i) {
                    arrayList.add(entry.getKey());
                }
                i2 = i;
            }
            i = i2;
        }
        return C1150a.m4305a(arrayList);
    }
}
