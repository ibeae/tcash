package com.google.p021a.p023b.p024a;

import com.google.p021a.p023b.C0569b;
import com.google.p021a.p023b.C0570e;
import com.google.p021a.p023b.C0579c;
import com.google.p021a.p023b.p024a.C0516q.C0514a;
import com.google.p021a.p025d.C0527a;
import com.google.p021a.p025d.C0530d;
import com.google.p021a.p025d.C0600c;
import com.google.p021a.p026c.C0596a;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Map.Entry;

public final class C0549o implements C0514a {
    private final C0579c f532a;

    private final class C0548a<V> extends C0516q<Map<String, V>> {
        final /* synthetic */ C0549o f529a;
        private final C0516q<V> f530b;
        private final C0570e<? extends Map<String, V>> f531c;

        public C0548a(C0549o c0549o, C0516q<V> c0516q, C0570e<? extends Map<String, V>> c0570e) {
            this.f529a = c0549o;
            this.f530b = c0516q;
            this.f531c = c0570e;
        }

        public Map<String, V> m1014a(C0527a c0527a) {
            if (c0527a.mo811f() == C0600c.NULL) {
                c0527a.mo815j();
                return null;
            }
            Map<String, V> map = (Map) this.f531c.mo835a();
            c0527a.mo807c();
            while (c0527a.mo810e()) {
                map.put(c0527a.mo812g(), this.f530b.mo804b(c0527a));
            }
            c0527a.mo809d();
            return map;
        }

        public void m1016a(C0530d c0530d, Map<String, V> map) {
            if (map == null) {
                c0530d.mo832f();
                return;
            }
            c0530d.mo830d();
            for (Entry entry : map.entrySet()) {
                c0530d.mo823a((String) entry.getKey());
                this.f530b.mo803a(c0530d, entry.getValue());
            }
            c0530d.mo831e();
        }

        public /* synthetic */ Object mo804b(C0527a c0527a) {
            return m1014a(c0527a);
        }
    }

    public C0549o(C0579c c0579c) {
        this.f532a = c0579c;
    }

    public <T> C0516q<T> mo802a(C0537j c0537j, C0596a<T> c0596a) {
        Type b = c0596a.m1198b();
        if (!(b instanceof ParameterizedType)) {
            return null;
        }
        Class a = c0596a.m1197a();
        if (!Map.class.isAssignableFrom(a)) {
            return null;
        }
        Type[] b2 = C0569b.m1145b(b, a);
        return b2[0] == String.class ? new C0548a(this, c0537j.m991a(C0596a.m1194a(b2[1])), this.f532a.m1165a((C0596a) c0596a)) : null;
    }
}
