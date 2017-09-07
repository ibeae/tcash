package com.google.p021a.p023b;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class C0582g<T> {
    private static final Logger f621a = Logger.getLogger(C0582g.class.getName());
    private final Map<Type, T> f622b = new HashMap();
    private final Map<Type, T> f623c = new HashMap();
    private final List<C0581f<Class<?>, T>> f624d = new ArrayList();
    private final List<C0581f<Class<?>, T>> f625e = new ArrayList();
    private boolean f626f = true;

    private T m1167a(Class<?> cls, boolean z) {
        if (!z) {
            for (C0581f c0581f : this.f625e) {
                if (((Class) c0581f.f619a).isAssignableFrom(cls)) {
                    return c0581f.f620b;
                }
            }
        }
        for (C0581f c0581f2 : this.f624d) {
            if (((Class) c0581f2.f619a).isAssignableFrom(cls)) {
                return c0581f2.f620b;
            }
        }
        return null;
    }

    private void m1168a(StringBuilder stringBuilder, List<C0581f<Class<?>, T>> list) {
        Object obj = 1;
        for (C0581f c0581f : list) {
            Object obj2;
            if (obj != null) {
                obj2 = null;
            } else {
                stringBuilder.append(',');
                obj2 = obj;
            }
            stringBuilder.append(m1170b((Type) c0581f.f619a)).append(':');
            stringBuilder.append(c0581f.f620b);
            obj = obj2;
        }
    }

    private void m1169a(StringBuilder stringBuilder, Map<Type, T> map) {
        Object obj = 1;
        for (Entry entry : map.entrySet()) {
            Object obj2;
            if (obj != null) {
                obj2 = null;
            } else {
                stringBuilder.append(',');
                obj2 = obj;
            }
            stringBuilder.append(m1170b((Type) entry.getKey())).append(':');
            stringBuilder.append(entry.getValue());
            obj = obj2;
        }
    }

    private String m1170b(Type type) {
        return C0569b.m1148e(type).getSimpleName();
    }

    public synchronized C0582g<T> m1171a() {
        this.f626f = false;
        return this;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized T m1172a(java.lang.reflect.Type r3, boolean r4) {
        /*
        r2 = this;
        monitor-enter(r2);
        if (r4 != 0) goto L_0x000d;
    L_0x0003:
        r0 = r2.f623c;	 Catch:{ all -> 0x0026 }
        r0 = r0.get(r3);	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r2);
        return r0;
    L_0x000d:
        r0 = r2.f622b;	 Catch:{ all -> 0x0026 }
        r0 = r0.get(r3);	 Catch:{ all -> 0x0026 }
        if (r0 != 0) goto L_0x000b;
    L_0x0015:
        r1 = com.google.p021a.p023b.C0569b.m1148e(r3);	 Catch:{ all -> 0x0026 }
        if (r1 == r3) goto L_0x0021;
    L_0x001b:
        r0 = r2.m1172a(r1, r4);	 Catch:{ all -> 0x0026 }
        if (r0 != 0) goto L_0x000b;
    L_0x0021:
        r0 = r2.m1167a(r1, r4);	 Catch:{ all -> 0x0026 }
        goto L_0x000b;
    L_0x0026:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.b.g.a(java.lang.reflect.Type, boolean):T");
    }

    public synchronized void m1173a(Type type, T t, boolean z) {
        if (this.f626f) {
            if (m1174a(type)) {
                f621a.log(Level.WARNING, "Overriding the existing type handler for {0}", type);
            }
            (z ? this.f622b : this.f623c).put(type, t);
        } else {
            throw new IllegalStateException("Attempted to modify an unmodifiable map.");
        }
    }

    public synchronized boolean m1174a(Type type) {
        boolean z;
        z = this.f623c.containsKey(type) || this.f622b.containsKey(type);
        return z;
    }

    public synchronized C0582g<T> m1175b() {
        C0582g<T> c0582g;
        c0582g = new C0582g();
        c0582g.f622b.putAll(this.f622b);
        c0582g.f623c.putAll(this.f623c);
        c0582g.f624d.addAll(this.f624d);
        c0582g.f625e.addAll(this.f625e);
        return c0582g;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{userTypeHierarchyList:{");
        m1168a(stringBuilder, this.f625e);
        stringBuilder.append("},systemTypeHierarchyList:{");
        m1168a(stringBuilder, this.f624d);
        stringBuilder.append("},userMap:{");
        m1169a(stringBuilder, this.f623c);
        stringBuilder.append("},systemMap:{");
        m1169a(stringBuilder, this.f622b);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
