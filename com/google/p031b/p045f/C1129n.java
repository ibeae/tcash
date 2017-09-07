package com.google.p031b.p045f;

import com.google.p031b.C1016a;
import com.google.p031b.C1062c;
import com.google.p031b.C1084e;
import com.google.p031b.C1155g;
import com.google.p031b.C1199m;
import com.google.p031b.p034c.C1046a;
import java.util.Map;

public final class C1129n extends C1122r {
    private final C1122r f2411a = new C1123f();

    private static C1199m m4163a(C1199m c1199m) {
        String a = c1199m.m4510a();
        if (a.charAt(0) == '0') {
            return new C1199m(a.substring(1), null, c1199m.m4515c(), C1016a.UPC_A);
        }
        throw C1155g.m4329a();
    }

    protected int mo1429a(C1046a c1046a, int[] iArr, StringBuilder stringBuilder) {
        return this.f2411a.mo1429a(c1046a, iArr, stringBuilder);
    }

    public C1199m mo1426a(int i, C1046a c1046a, Map<C1084e, ?> map) {
        return C1129n.m4163a(this.f2411a.mo1426a(i, c1046a, (Map) map));
    }

    public C1199m mo1431a(int i, C1046a c1046a, int[] iArr, Map<C1084e, ?> map) {
        return C1129n.m4163a(this.f2411a.mo1431a(i, c1046a, iArr, (Map) map));
    }

    public C1199m mo1414a(C1062c c1062c, Map<C1084e, ?> map) {
        return C1129n.m4163a(this.f2411a.mo1414a(c1062c, map));
    }

    C1016a mo1430b() {
        return C1016a.UPC_A;
    }
}
