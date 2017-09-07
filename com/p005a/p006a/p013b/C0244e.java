package com.p005a.p006a.p013b;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

class C0244e {
    final C0242d f419a;
    private Executor f420b;
    private Executor f421c;
    private ExecutorService f422d;
    private final Map<Integer, String> f423e = Collections.synchronizedMap(new HashMap());
    private final Map<String, ReentrantLock> f424f = new WeakHashMap();
    private final AtomicBoolean f425g = new AtomicBoolean(false);
    private final AtomicBoolean f426h = new AtomicBoolean(false);
    private final AtomicBoolean f427i = new AtomicBoolean(false);
    private final Object f428j = new Object();

    C0244e(C0242d c0242d) {
        this.f419a = c0242d;
        this.f420b = c0242d.f403i;
        this.f421c = c0242d.f404j;
        this.f422d = Executors.newCachedThreadPool();
    }
}
