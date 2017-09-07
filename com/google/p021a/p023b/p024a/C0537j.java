package com.google.p021a.p023b.p024a;

import com.google.p021a.p023b.C0579c;
import com.google.p021a.p023b.p024a.C0516q.C0514a;
import com.google.p021a.p025d.C0527a;
import com.google.p021a.p025d.C0530d;
import com.google.p021a.p026c.C0596a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class C0537j {
    private final ThreadLocal<Map<C0596a<?>, C0536b<?>>> f509a;
    private final List<C0514a> f510b;

    class C05341 extends ThreadLocal<Map<C0596a<?>, C0536b<?>>> {
        final /* synthetic */ C0537j f505a;

        C05341(C0537j c0537j) {
            this.f505a = c0537j;
        }

        protected Map<C0596a<?>, C0536b<?>> m981a() {
            return new HashMap();
        }

        protected /* synthetic */ Object initialValue() {
            return m981a();
        }
    }

    public static final class C0535a {
        boolean f506a = true;
        private final List<C0514a> f507b = new ArrayList();

        public C0535a m983a() {
            this.f506a = false;
            return this;
        }

        public C0535a m984a(C0514a c0514a) {
            this.f507b.add(c0514a);
            return this;
        }

        public <T> C0535a m985a(Class<T> cls, C0516q<T> c0516q) {
            this.f507b.add(C0564s.m1125a(cls, c0516q));
            return this;
        }

        public C0537j m986b() {
            return new C0537j();
        }
    }

    static class C0536b<T> extends C0516q<T> {
        private C0516q<T> f508a;

        C0536b() {
        }

        public void m987a(C0516q<T> c0516q) {
            if (this.f508a != null) {
                throw new AssertionError();
            }
            this.f508a = c0516q;
        }

        public void mo803a(C0530d c0530d, T t) {
            if (this.f508a == null) {
                throw new IllegalStateException();
            }
            this.f508a.mo803a(c0530d, t);
        }

        public T mo804b(C0527a c0527a) {
            if (this.f508a != null) {
                return this.f508a.mo804b(c0527a);
            }
            throw new IllegalStateException();
        }
    }

    private C0537j(C0535a c0535a) {
        this.f509a = new C05341(this);
        C0579c c0579c = new C0579c();
        List arrayList = new ArrayList();
        if (c0535a.f506a) {
            arrayList.add(C0564s.f574e);
            arrayList.add(C0564s.f580k);
            arrayList.add(C0564s.f586q);
            arrayList.add(C0564s.f584o);
            arrayList.add(C0564s.f582m);
            arrayList.add(C0564s.f592w);
        }
        arrayList.addAll(c0535a.f507b);
        if (c0535a.f506a) {
            arrayList.add(new C0521d(c0579c));
            arrayList.add(new C0549o(c0579c));
            arrayList.add(C0517a.f449a);
            arrayList.add(C0540k.f512a);
            arrayList.add(new C0545m(c0579c));
        }
        this.f510b = Collections.unmodifiableList(arrayList);
    }

    public <T> C0516q<T> m990a(C0514a c0514a, C0596a<T> c0596a) {
        Object obj = null;
        for (C0514a c0514a2 : this.f510b) {
            if (obj != null) {
                C0516q<T> a = c0514a2.mo802a(this, c0596a);
                if (a != null) {
                    return a;
                }
            } else if (c0514a2 == c0514a) {
                obj = 1;
            }
        }
        throw new IllegalArgumentException("This MiniGSON cannot serialize " + c0596a);
    }

    public <T> C0516q<T> m991a(C0596a<T> c0596a) {
        Map map = (Map) this.f509a.get();
        C0516q<T> c0516q = (C0536b) map.get(c0596a);
        if (c0516q == null) {
            C0536b c0536b = new C0536b();
            map.put(c0596a, c0536b);
            try {
                for (C0514a a : this.f510b) {
                    c0516q = a.mo802a(this, c0596a);
                    if (c0516q != null) {
                        c0536b.m987a(c0516q);
                    }
                }
                throw new IllegalArgumentException("This MiniGSON cannot handle " + c0596a);
            } finally {
                map.remove(c0596a);
            }
        }
        return c0516q;
    }

    public <T> C0516q<T> m992a(Class<T> cls) {
        return m991a(C0596a.m1196b(cls));
    }
}
