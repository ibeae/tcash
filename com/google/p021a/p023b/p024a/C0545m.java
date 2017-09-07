package com.google.p021a.p023b.p024a;

import com.google.p021a.aa;
import com.google.p021a.p023b.C0569b;
import com.google.p021a.p023b.C0570e;
import com.google.p021a.p023b.C0579c;
import com.google.p021a.p023b.C0583h;
import com.google.p021a.p023b.p024a.C0516q.C0514a;
import com.google.p021a.p025d.C0527a;
import com.google.p021a.p025d.C0530d;
import com.google.p021a.p025d.C0600c;
import com.google.p021a.p026c.C0596a;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

public class C0545m implements C0514a {
    private final C0579c f526a;

    static abstract class C0542b {
        final String f514g;
        final boolean f515h;
        final boolean f516i;

        protected C0542b(String str, boolean z, boolean z2) {
            this.f514g = str;
            this.f515h = z;
            this.f516i = z2;
        }

        abstract void mo833a(C0527a c0527a, Object obj);

        abstract void mo834a(C0530d c0530d, Object obj);
    }

    public final class C0544a<T> extends C0516q<T> {
        final /* synthetic */ C0545m f523a;
        private final C0570e<T> f524b;
        private final Map<String, C0542b> f525c;

        private C0544a(C0545m c0545m, C0570e<T> c0570e, Map<String, C0542b> map) {
            this.f523a = c0545m;
            this.f524b = c0570e;
            this.f525c = map;
        }

        public void mo803a(C0530d c0530d, T t) {
            if (t == null) {
                c0530d.mo832f();
                return;
            }
            c0530d.mo830d();
            try {
                for (C0542b c0542b : this.f525c.values()) {
                    if (c0542b.f515h) {
                        c0530d.mo823a(c0542b.f514g);
                        c0542b.mo834a(c0530d, (Object) t);
                    }
                }
                c0530d.mo831e();
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            }
        }

        public T mo804b(C0527a c0527a) {
            if (c0527a.mo811f() == C0600c.NULL) {
                c0527a.mo815j();
                return null;
            }
            T a = this.f524b.mo835a();
            try {
                c0527a.mo807c();
                while (c0527a.mo810e()) {
                    C0542b c0542b = (C0542b) this.f525c.get(c0527a.mo812g());
                    if (c0542b == null || !c0542b.f516i) {
                        c0527a.mo819n();
                    } else {
                        c0542b.mo833a(c0527a, (Object) a);
                    }
                }
                c0527a.mo809d();
                return a;
            } catch (Throwable e) {
                throw new aa(e);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public C0545m(C0579c c0579c) {
        this.f526a = c0579c;
    }

    private C0542b m1003a(C0537j c0537j, Field field, String str, C0596a<?> c0596a, boolean z, boolean z2) {
        final boolean a = C0583h.m1177a(c0596a.m1197a());
        final C0537j c0537j2 = c0537j;
        final C0596a<?> c0596a2 = c0596a;
        final Field field2 = field;
        return new C0542b(this, str, z, z2) {
            final C0516q<?> f517a = c0537j2.m991a(c0596a2);
            final /* synthetic */ C0545m f522f;

            void mo833a(C0527a c0527a, Object obj) {
                Object b = this.f517a.mo804b(c0527a);
                if (b != null || !a) {
                    field2.set(obj, b);
                }
            }

            void mo834a(C0530d c0530d, Object obj) {
                new C0552r(c0537j2, this.f517a, c0596a2.m1198b()).mo803a(c0530d, field2.get(obj));
            }
        };
    }

    private Map<String, C0542b> m1004a(C0537j c0537j, C0596a<?> c0596a, Class<?> cls) {
        Map<String, C0542b> linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type b = c0596a.m1198b();
        Class a;
        while (a != Object.class) {
            AccessibleObject[] declaredFields = a.getDeclaredFields();
            AccessibleObject.setAccessible(declaredFields, true);
            for (Field field : declaredFields) {
                boolean b2 = mo840b(a, field, b);
                boolean c = mo841c(a, field, b);
                if (b2 || c) {
                    C0542b a2 = m1003a(c0537j, field, mo839a(a, field, b), C0596a.m1194a(C0569b.m1138a(r14.m1198b(), a, field.getGenericType())), b2, c);
                    a2 = (C0542b) linkedHashMap.put(a2.f514g, a2);
                    if (a2 != null) {
                        throw new IllegalArgumentException(b + " declares multiple JSON fields named " + a2.f514g);
                    }
                }
            }
            C0596a a3 = C0596a.m1194a(C0569b.m1138a(a3.m1198b(), a, a.getGenericSuperclass()));
            a = a3.m1197a();
        }
        return linkedHashMap;
    }

    public <T> C0516q<T> mo802a(C0537j c0537j, C0596a<T> c0596a) {
        Class a = c0596a.m1197a();
        return !Object.class.isAssignableFrom(a) ? null : new C0544a(this.f526a.m1165a((C0596a) c0596a), m1004a(c0537j, (C0596a) c0596a, a));
    }

    protected String mo839a(Class<?> cls, Field field, Type type) {
        return field.getName();
    }

    protected boolean mo840b(Class<?> cls, Field field, Type type) {
        return !field.isSynthetic();
    }

    protected boolean mo841c(Class<?> cls, Field field, Type type) {
        return !field.isSynthetic();
    }
}
