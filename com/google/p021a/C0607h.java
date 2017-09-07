package com.google.p021a;

import com.google.p021a.p023b.C0565a;
import com.google.p021a.p023b.C0581f;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class C0607h {
    private static final C0512b<C0581f<Class<?>, String>, Collection<Annotation>> f667a = new ac(C0607h.m1207f());
    private final Class<?> f668b;
    private final Field f669c;
    private final Class<?> f670d;
    private final boolean f671e;
    private final int f672f;
    private final String f673g;
    private Type f674h;
    private Collection<Annotation> f675i;

    C0607h(Class<?> cls, Field field) {
        this.f668b = (Class) C0565a.m1129a((Object) cls);
        this.f673g = field.getName();
        this.f670d = field.getType();
        this.f671e = field.isSynthetic();
        this.f672f = field.getModifiers();
        this.f669c = field;
    }

    private static <T extends Annotation> T m1206a(Collection<Annotation> collection, Class<T> cls) {
        for (Annotation annotation : collection) {
            if (annotation.annotationType() == cls) {
                return annotation;
            }
        }
        return null;
    }

    private static int m1207f() {
        int i = 2000;
        try {
            i = Integer.parseInt(System.getProperty("com.google.gson.annotation_cache_size_hint", String.valueOf(2000)));
        } catch (NumberFormatException e) {
        }
        return i;
    }

    public String m1208a() {
        return this.f673g;
    }

    public <T extends Annotation> T m1209a(Class<T> cls) {
        return C0607h.m1206a(m1213d(), cls);
    }

    public boolean m1210a(int i) {
        return (this.f672f & i) != 0;
    }

    public Type m1211b() {
        if (this.f674h == null) {
            this.f674h = this.f669c.getGenericType();
        }
        return this.f674h;
    }

    public Class<?> m1212c() {
        return this.f670d;
    }

    public Collection<Annotation> m1213d() {
        if (this.f675i == null) {
            C0581f c0581f = new C0581f(this.f668b, this.f673g);
            Collection collection = (Collection) f667a.mo799a(c0581f);
            if (collection == null) {
                collection = Collections.unmodifiableCollection(Arrays.asList(this.f669c.getAnnotations()));
                f667a.mo800a(c0581f, collection);
            }
            this.f675i = collection;
        }
        return this.f675i;
    }

    boolean m1214e() {
        return this.f671e;
    }
}
