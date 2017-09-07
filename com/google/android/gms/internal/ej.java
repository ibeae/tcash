package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ej {

    public static final class C0791a {
        private final List<String> f1531a;
        private final Object f1532b;

        private C0791a(Object obj) {
            this.f1532b = ek.m2332a(obj);
            this.f1531a = new ArrayList();
        }

        public C0791a m2328a(String str, Object obj) {
            this.f1531a.add(((String) ek.m2332a((Object) str)) + "=" + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.f1532b.getClass().getSimpleName()).append('{');
            int size = this.f1531a.size();
            for (int i = 0; i < size; i++) {
                append.append((String) this.f1531a.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }
    }

    public static int m2329a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static C0791a m2330a(Object obj) {
        return new C0791a(obj);
    }

    public static boolean m2331a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
