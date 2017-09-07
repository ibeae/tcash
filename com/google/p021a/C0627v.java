package com.google.p021a;

import com.google.p021a.p023b.C0565a;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class C0627v extends C0623s {
    private final Map<String, C0623s> f738a = new LinkedHashMap();

    public void m1287a(String str, C0623s c0623s) {
        Object obj;
        if (c0623s == null) {
            obj = C0626u.f737a;
        }
        this.f738a.put(C0565a.m1129a((Object) str), obj);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof C0627v) && ((C0627v) obj).f738a.equals(this.f738a));
    }

    public int hashCode() {
        return this.f738a.hashCode();
    }

    public Set<Entry<String, C0623s>> m1288o() {
        return this.f738a.entrySet();
    }
}
