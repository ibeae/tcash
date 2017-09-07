package com.google.p021a.p023b.p024a;

import com.google.p021a.C0623s;
import com.google.p021a.C0628x;
import com.google.p021a.aa;
import com.google.p021a.p023b.C0569b;
import com.google.p021a.p023b.C0570e;
import com.google.p021a.p023b.C0579c;
import com.google.p021a.p023b.C0587i;
import com.google.p021a.p023b.p024a.C0516q.C0514a;
import com.google.p021a.p025d.C0527a;
import com.google.p021a.p025d.C0530d;
import com.google.p021a.p025d.C0600c;
import com.google.p021a.p026c.C0596a;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class C0533i implements C0514a {
    private final C0579c f503a;
    private final boolean f504b;

    private final class C0532a<K, V> extends C0516q<Map<K, V>> {
        final /* synthetic */ C0533i f499a;
        private final C0516q<K> f500b;
        private final C0516q<V> f501c;
        private final C0570e<? extends Map<K, V>> f502d;

        public C0532a(C0533i c0533i, C0537j c0537j, Type type, C0516q<K> c0516q, Type type2, C0516q<V> c0516q2, C0570e<? extends Map<K, V>> c0570e) {
            this.f499a = c0533i;
            this.f500b = new C0552r(c0537j, c0516q, type);
            this.f501c = new C0552r(c0537j, c0516q2, type2);
            this.f502d = c0570e;
        }

        private String m973b(C0623s c0623s) {
            if (c0623s.m1274i()) {
                C0628x m = c0623s.m1278m();
                if (m.m1300p()) {
                    return String.valueOf(m.mo843a());
                }
                if (m.m1299o()) {
                    return Boolean.toString(m.mo848f());
                }
                if (m.m1301q()) {
                    return m.mo844b();
                }
                throw new AssertionError();
            } else if (c0623s.m1275j()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }

        public Map<K, V> m974a(C0527a c0527a) {
            C0600c f = c0527a.mo811f();
            if (f == C0600c.NULL) {
                c0527a.mo815j();
                return null;
            }
            Map<K, V> map = (Map) this.f502d.mo835a();
            Object b;
            if (f == C0600c.BEGIN_ARRAY) {
                c0527a.mo805a();
                while (c0527a.mo810e()) {
                    c0527a.mo805a();
                    b = this.f500b.mo804b(c0527a);
                    if (map.put(b, this.f501c.mo804b(c0527a)) != null) {
                        throw new aa("duplicate key: " + b);
                    }
                    c0527a.mo806b();
                }
                c0527a.mo806b();
                return map;
            }
            c0527a.mo807c();
            while (c0527a.mo810e()) {
                b = this.f500b.m846a(new C0628x(c0527a.mo812g()));
                if (map.put(b, this.f501c.mo804b(c0527a)) != null) {
                    throw new aa("duplicate key: " + b);
                }
            }
            c0527a.mo809d();
            return map;
        }

        public void m976a(C0530d c0530d, Map<K, V> map) {
            int i = 0;
            if (map == null) {
                c0530d.mo832f();
            } else if (this.f499a.f504b) {
                List arrayList = new ArrayList(map.size());
                List arrayList2 = new ArrayList(map.size());
                int i2 = 0;
                for (Entry entry : map.entrySet()) {
                    C0623s a = this.f500b.m845a(entry.getKey());
                    arrayList.add(a);
                    arrayList2.add(entry.getValue());
                    int i3 = (a.m1272g() || a.m1273h()) ? 1 : 0;
                    i2 = i3 | i2;
                }
                if (i2 != 0) {
                    c0530d.mo826b();
                    while (i < arrayList.size()) {
                        c0530d.mo826b();
                        C0587i.m1180a((C0623s) arrayList.get(i), c0530d);
                        this.f501c.mo803a(c0530d, arrayList2.get(i));
                        c0530d.mo828c();
                        i++;
                    }
                    c0530d.mo828c();
                    return;
                }
                c0530d.mo830d();
                while (i < arrayList.size()) {
                    c0530d.mo823a(m973b((C0623s) arrayList.get(i)));
                    this.f501c.mo803a(c0530d, arrayList2.get(i));
                    i++;
                }
                c0530d.mo831e();
            } else {
                c0530d.mo830d();
                for (Entry entry2 : map.entrySet()) {
                    c0530d.mo823a(String.valueOf(entry2.getKey()));
                    this.f501c.mo803a(c0530d, entry2.getValue());
                }
                c0530d.mo831e();
            }
        }

        public /* synthetic */ Object mo804b(C0527a c0527a) {
            return m974a(c0527a);
        }
    }

    public C0533i(C0579c c0579c, boolean z) {
        this.f503a = c0579c;
        this.f504b = z;
    }

    private C0516q<?> m978a(C0537j c0537j, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? C0564s.f573d : c0537j.m991a(C0596a.m1194a(type));
    }

    public <T> C0516q<T> mo802a(C0537j c0537j, C0596a<T> c0596a) {
        Type b = c0596a.m1198b();
        if (!Map.class.isAssignableFrom(c0596a.m1197a())) {
            return null;
        }
        Type[] b2 = C0569b.m1145b(b, C0569b.m1148e(b));
        C0516q a = m978a(c0537j, b2[0]);
        C0516q a2 = c0537j.m991a(C0596a.m1194a(b2[1]));
        C0570e a3 = this.f503a.m1165a((C0596a) c0596a);
        return new C0532a(this, c0537j, b2[0], a, b2[1], a2, a3);
    }
}
