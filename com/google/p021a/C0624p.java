package com.google.p021a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class C0624p extends C0623s implements Iterable<C0623s> {
    private final List<C0623s> f736a = new ArrayList();

    public Number mo843a() {
        if (this.f736a.size() == 1) {
            return ((C0623s) this.f736a.get(0)).mo843a();
        }
        throw new IllegalStateException();
    }

    public void m1281a(C0623s c0623s) {
        Object obj;
        if (c0623s == null) {
            obj = C0626u.f737a;
        }
        this.f736a.add(obj);
    }

    public String mo844b() {
        if (this.f736a.size() == 1) {
            return ((C0623s) this.f736a.get(0)).mo844b();
        }
        throw new IllegalStateException();
    }

    public double mo845c() {
        if (this.f736a.size() == 1) {
            return ((C0623s) this.f736a.get(0)).mo845c();
        }
        throw new IllegalStateException();
    }

    public long mo846d() {
        if (this.f736a.size() == 1) {
            return ((C0623s) this.f736a.get(0)).mo846d();
        }
        throw new IllegalStateException();
    }

    public int mo847e() {
        if (this.f736a.size() == 1) {
            return ((C0623s) this.f736a.get(0)).mo847e();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof C0624p) && ((C0624p) obj).f736a.equals(this.f736a));
    }

    public boolean mo848f() {
        if (this.f736a.size() == 1) {
            return ((C0623s) this.f736a.get(0)).mo848f();
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        return this.f736a.hashCode();
    }

    public Iterator<C0623s> iterator() {
        return this.f736a.iterator();
    }
}
