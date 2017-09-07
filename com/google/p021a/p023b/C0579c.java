package com.google.p021a.p023b;

import com.google.p021a.C0621n;
import com.google.p021a.p026c.C0596a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public final class C0579c {
    private final C0582g<C0621n<?>> f617a;

    class C05733 implements C0570e<T> {
        final /* synthetic */ C0579c f608a;

        C05733(C0579c c0579c) {
            this.f608a = c0579c;
        }

        public T mo835a() {
            return new TreeSet();
        }
    }

    class C05744 implements C0570e<T> {
        final /* synthetic */ C0579c f609a;

        C05744(C0579c c0579c) {
            this.f609a = c0579c;
        }

        public T mo835a() {
            return new LinkedHashSet();
        }
    }

    class C05755 implements C0570e<T> {
        final /* synthetic */ C0579c f610a;

        C05755(C0579c c0579c) {
            this.f610a = c0579c;
        }

        public T mo835a() {
            return new LinkedList();
        }
    }

    class C05766 implements C0570e<T> {
        final /* synthetic */ C0579c f611a;

        C05766(C0579c c0579c) {
            this.f611a = c0579c;
        }

        public T mo835a() {
            return new ArrayList();
        }
    }

    class C05777 implements C0570e<T> {
        final /* synthetic */ C0579c f612a;

        C05777(C0579c c0579c) {
            this.f612a = c0579c;
        }

        public T mo835a() {
            return new LinkedHashMap();
        }
    }

    public C0579c() {
        this(new C0582g());
    }

    public C0579c(C0582g<C0621n<?>> c0582g) {
        this.f617a = c0582g;
    }

    private <T> C0570e<T> m1162a(Class<? super T> cls) {
        try {
            final Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new C0570e<T>(this) {
                final /* synthetic */ C0579c f607b;

                public T mo835a() {
                    try {
                        return declaredConstructor.newInstance(null);
                    } catch (Throwable e) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e);
                    } catch (InvocationTargetException e2) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e2.getTargetException());
                    } catch (IllegalAccessException e3) {
                        throw new AssertionError(e3);
                    }
                }
            };
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private <T> C0570e<T> m1163a(final Type type, final Class<? super T> cls) {
        return new C0570e<T>(this) {
            final /* synthetic */ C0579c f615c;
            private final C0588j f616d = C0588j.m1181a();

            public T mo835a() {
                try {
                    return this.f616d.mo836a(cls);
                } catch (Throwable e) {
                    throw new RuntimeException("Unable to invoke no-args constructor for " + type + ". " + "Register an InstanceCreator with Gson for this type may fix this problem.", e);
                }
            }
        };
    }

    private <T> C0570e<T> m1164b(Class<? super T> cls) {
        return Collection.class.isAssignableFrom(cls) ? SortedSet.class.isAssignableFrom(cls) ? new C05733(this) : Set.class.isAssignableFrom(cls) ? new C05744(this) : Queue.class.isAssignableFrom(cls) ? new C05755(this) : new C05766(this) : Map.class.isAssignableFrom(cls) ? new C05777(this) : null;
    }

    public <T> C0570e<T> m1165a(C0596a<T> c0596a) {
        final Type b = c0596a.m1198b();
        Class a = c0596a.m1197a();
        final C0621n c0621n = (C0621n) this.f617a.m1172a(b, false);
        if (c0621n != null) {
            return new C0570e<T>(this) {
                final /* synthetic */ C0579c f605c;

                public T mo835a() {
                    return c0621n.m1264a(b);
                }
            };
        }
        C0570e<T> a2 = m1162a(a);
        if (a2 != null) {
            return a2;
        }
        a2 = m1164b(a);
        return a2 == null ? m1163a(b, a) : a2;
    }

    public String toString() {
        return this.f617a.toString();
    }
}
