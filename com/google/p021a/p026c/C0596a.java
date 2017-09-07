package com.google.p021a.p026c;

import com.google.p021a.p023b.C0565a;
import com.google.p021a.p023b.C0569b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class C0596a<T> {
    final Class<? super T> f640a;
    final Type f641b;
    final int f642c;

    protected C0596a() {
        this.f641b = C0596a.m1195a(getClass());
        this.f640a = C0569b.m1148e(this.f641b);
        this.f642c = this.f641b.hashCode();
    }

    C0596a(Type type) {
        this.f641b = C0569b.m1147d((Type) C0565a.m1129a((Object) type));
        this.f640a = C0569b.m1148e(this.f641b);
        this.f642c = this.f641b.hashCode();
    }

    public static C0596a<?> m1194a(Type type) {
        return new C0596a(type);
    }

    static Type m1195a(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            return C0569b.m1147d(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        }
        throw new RuntimeException("Missing type parameter.");
    }

    public static <T> C0596a<T> m1196b(Class<T> cls) {
        return new C0596a(cls);
    }

    public final Class<? super T> m1197a() {
        return this.f640a;
    }

    public final Type m1198b() {
        return this.f641b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C0596a) && C0569b.m1141a(this.f641b, ((C0596a) obj).f641b);
    }

    public final int hashCode() {
        return this.f642c;
    }

    public final String toString() {
        return C0569b.m1149f(this.f641b);
    }
}
