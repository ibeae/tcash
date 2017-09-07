package com.google.p021a.p023b.p024a;

import com.google.p021a.p023b.C0569b;
import com.google.p021a.p023b.C0570e;
import com.google.p021a.p023b.C0579c;
import com.google.p021a.p023b.p024a.C0516q.C0514a;
import com.google.p021a.p025d.C0527a;
import com.google.p021a.p025d.C0530d;
import com.google.p021a.p025d.C0600c;
import com.google.p021a.p026c.C0596a;
import java.lang.reflect.Type;
import java.util.Collection;

public final class C0521d implements C0514a {
    private final C0579c f455a;

    private final class C0520a<E> extends C0516q<Collection<E>> {
        final /* synthetic */ C0521d f452a;
        private final C0516q<E> f453b;
        private final C0570e<? extends Collection<E>> f454c;

        public C0520a(C0521d c0521d, C0537j c0537j, Type type, C0516q<E> c0516q, C0570e<? extends Collection<E>> c0570e) {
            this.f452a = c0521d;
            this.f453b = new C0552r(c0537j, c0516q, type);
            this.f454c = c0570e;
        }

        public Collection<E> m859a(C0527a c0527a) {
            if (c0527a.mo811f() == C0600c.NULL) {
                c0527a.mo815j();
                return null;
            }
            Collection<E> collection = (Collection) this.f454c.mo835a();
            c0527a.mo805a();
            while (c0527a.mo810e()) {
                collection.add(this.f453b.mo804b(c0527a));
            }
            c0527a.mo806b();
            return collection;
        }

        public void m861a(C0530d c0530d, Collection<E> collection) {
            if (collection == null) {
                c0530d.mo832f();
                return;
            }
            c0530d.mo826b();
            for (E a : collection) {
                this.f453b.mo803a(c0530d, a);
            }
            c0530d.mo828c();
        }

        public /* synthetic */ Object mo804b(C0527a c0527a) {
            return m859a(c0527a);
        }
    }

    public C0521d(C0579c c0579c) {
        this.f455a = c0579c;
    }

    public <T> C0516q<T> mo802a(C0537j c0537j, C0596a<T> c0596a) {
        Type b = c0596a.m1198b();
        Class a = c0596a.m1197a();
        if (!Collection.class.isAssignableFrom(a)) {
            return null;
        }
        Type a2 = C0569b.m1136a(b, a);
        return new C0520a(this, c0537j, a2, c0537j.m991a(C0596a.m1194a(a2)), this.f455a.m1165a((C0596a) c0596a));
    }
}
