package com.google.p031b.p045f.p046a.p047a;

import java.util.ArrayList;
import java.util.List;

final class C1107c {
    private final List<C1106b> f2338a;
    private final int f2339b;
    private final boolean f2340c;

    C1107c(List<C1106b> list, int i, boolean z) {
        this.f2338a = new ArrayList(list);
        this.f2339b = i;
        this.f2340c = z;
    }

    List<C1106b> m4041a() {
        return this.f2338a;
    }

    boolean m4042a(List<C1106b> list) {
        return this.f2338a.equals(list);
    }

    int m4043b() {
        return this.f2339b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1107c)) {
            return false;
        }
        C1107c c1107c = (C1107c) obj;
        return this.f2338a.equals(c1107c.m4041a()) && this.f2340c == c1107c.f2340c;
    }

    public int hashCode() {
        return this.f2338a.hashCode() ^ Boolean.valueOf(this.f2340c).hashCode();
    }

    public String toString() {
        return "{ " + this.f2338a + " }";
    }
}
