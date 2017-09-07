package com.p005a.p006a.p013b;

import com.p005a.p006a.p013b.p014a.C0221a;
import com.p005a.p006a.p013b.p014a.C0226e;
import com.p005a.p006a.p020c.C0245a;

public class C0235c {
    public static final String f358a = C0235c.class.getSimpleName();
    private static volatile C0235c f359e;
    private C0242d f360b;
    private C0244e f361c;
    private final C0221a f362d = new C0226e();

    protected C0235c() {
    }

    public static C0235c m775a() {
        if (f359e == null) {
            synchronized (C0235c.class) {
                if (f359e == null) {
                    f359e = new C0235c();
                }
            }
        }
        return f359e;
    }

    public synchronized void m776a(C0242d c0242d) {
        if (c0242d == null) {
            throw new IllegalArgumentException("ImageLoader configuration can not be initialized with null");
        } else if (this.f360b == null) {
            if (c0242d.f415u) {
                C0245a.m803a("Initialize ImageLoader with configuration", new Object[0]);
            }
            this.f361c = new C0244e(c0242d);
            this.f360b = c0242d;
        } else {
            C0245a.m805c("Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.", new Object[0]);
        }
    }
}
