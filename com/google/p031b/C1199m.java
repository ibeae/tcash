package com.google.p031b;

import java.util.EnumMap;
import java.util.Map;

public final class C1199m {
    private final String f2590a;
    private final byte[] f2591b;
    private C1178o[] f2592c;
    private final C1016a f2593d;
    private Map<C1200n, Object> f2594e;
    private final long f2595f;

    public C1199m(String str, byte[] bArr, C1178o[] c1178oArr, C1016a c1016a) {
        this(str, bArr, c1178oArr, c1016a, System.currentTimeMillis());
    }

    public C1199m(String str, byte[] bArr, C1178o[] c1178oArr, C1016a c1016a, long j) {
        this.f2590a = str;
        this.f2591b = bArr;
        this.f2592c = c1178oArr;
        this.f2593d = c1016a;
        this.f2594e = null;
        this.f2595f = j;
    }

    public String m4510a() {
        return this.f2590a;
    }

    public void m4511a(C1200n c1200n, Object obj) {
        if (this.f2594e == null) {
            this.f2594e = new EnumMap(C1200n.class);
        }
        this.f2594e.put(c1200n, obj);
    }

    public void m4512a(Map<C1200n, Object> map) {
        if (map == null) {
            return;
        }
        if (this.f2594e == null) {
            this.f2594e = map;
        } else {
            this.f2594e.putAll(map);
        }
    }

    public void m4513a(C1178o[] c1178oArr) {
        Object obj = this.f2592c;
        if (obj == null) {
            this.f2592c = c1178oArr;
        } else if (c1178oArr != null && c1178oArr.length > 0) {
            Object obj2 = new C1178o[(obj.length + c1178oArr.length)];
            System.arraycopy(obj, 0, obj2, 0, obj.length);
            System.arraycopy(c1178oArr, 0, obj2, obj.length, c1178oArr.length);
            this.f2592c = obj2;
        }
    }

    public byte[] m4514b() {
        return this.f2591b;
    }

    public C1178o[] m4515c() {
        return this.f2592c;
    }

    public C1016a m4516d() {
        return this.f2593d;
    }

    public Map<C1200n, Object> m4517e() {
        return this.f2594e;
    }

    public String toString() {
        return this.f2590a;
    }
}
