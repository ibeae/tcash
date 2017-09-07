package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

public final class C0688b implements C0687d {
    private final Object f984a = new Object();
    private WeakHashMap<db, C0721c> f985b = new WeakHashMap();
    private ArrayList<C0721c> f986c = new ArrayList();

    public C0721c m1647a(al alVar, db dbVar) {
        C0721c c0721c;
        synchronized (this.f984a) {
            if (m1650a(dbVar)) {
                c0721c = (C0721c) this.f985b.get(dbVar);
            } else {
                c0721c = new C0721c(alVar, dbVar);
                c0721c.m1818a((C0687d) this);
                this.f985b.put(dbVar, c0721c);
                this.f986c.add(c0721c);
            }
        }
        return c0721c;
    }

    public void m1648a() {
        synchronized (this.f984a) {
            Iterator it = this.f986c.iterator();
            while (it.hasNext()) {
                ((C0721c) it.next()).m1836j();
            }
        }
    }

    public void mo909a(C0721c c0721c) {
        synchronized (this.f984a) {
            if (!c0721c.m1831e()) {
                this.f986c.remove(c0721c);
            }
        }
    }

    public boolean m1650a(db dbVar) {
        boolean z;
        synchronized (this.f984a) {
            C0721c c0721c = (C0721c) this.f985b.get(dbVar);
            z = c0721c != null && c0721c.m1831e();
        }
        return z;
    }

    public void m1651b() {
        synchronized (this.f984a) {
            Iterator it = this.f986c.iterator();
            while (it.hasNext()) {
                ((C0721c) it.next()).m1837k();
            }
        }
    }

    public void m1652b(db dbVar) {
        synchronized (this.f984a) {
            C0721c c0721c = (C0721c) this.f985b.get(dbVar);
            if (c0721c != null) {
                c0721c.m1828c();
            }
        }
    }

    public void m1653c() {
        synchronized (this.f984a) {
            Iterator it = this.f986c.iterator();
            while (it.hasNext()) {
                ((C0721c) it.next()).m1838l();
            }
        }
    }
}
