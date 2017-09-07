package com.google.p021a.p023b.p024a;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class C0541l {
    public static Type m996a(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }
}
