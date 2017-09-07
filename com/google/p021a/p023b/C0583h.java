package com.google.p021a.p023b;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class C0583h {
    private static final Map<Class<?>, Class<?>> f627a;
    private static final Map<Class<?>, Class<?>> f628b;

    static {
        Map hashMap = new HashMap(16);
        Map hashMap2 = new HashMap(16);
        C0583h.m1176a(hashMap, hashMap2, Boolean.TYPE, Boolean.class);
        C0583h.m1176a(hashMap, hashMap2, Byte.TYPE, Byte.class);
        C0583h.m1176a(hashMap, hashMap2, Character.TYPE, Character.class);
        C0583h.m1176a(hashMap, hashMap2, Double.TYPE, Double.class);
        C0583h.m1176a(hashMap, hashMap2, Float.TYPE, Float.class);
        C0583h.m1176a(hashMap, hashMap2, Integer.TYPE, Integer.class);
        C0583h.m1176a(hashMap, hashMap2, Long.TYPE, Long.class);
        C0583h.m1176a(hashMap, hashMap2, Short.TYPE, Short.class);
        C0583h.m1176a(hashMap, hashMap2, Void.TYPE, Void.class);
        f627a = Collections.unmodifiableMap(hashMap);
        f628b = Collections.unmodifiableMap(hashMap2);
    }

    private static void m1176a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static boolean m1177a(Type type) {
        return f627a.containsKey(type);
    }
}
