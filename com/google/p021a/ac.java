package com.google.p021a;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class ac<K, V> extends LinkedHashMap<K, V> implements C0512b<K, V> {
    private final int f444a;

    public ac(int i) {
        super(i, 0.7f, true);
        this.f444a = i;
    }

    public synchronized V mo799a(K k) {
        return get(k);
    }

    public synchronized void mo800a(K k, V v) {
        put(k, v);
    }

    protected boolean removeEldestEntry(Entry<K, V> entry) {
        return size() > this.f444a;
    }
}
