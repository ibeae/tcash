package com.google.p021a;

import com.google.p021a.C0597c.C0595a;
import com.google.p021a.p023b.C0582g;
import com.google.p021a.p023b.p024a.C0516q.C0514a;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class C0613k {
    private static final C0620m f697a = new C0620m();
    private static final C0605f f698b = new C0605f();
    private static final C0606g f699c = new C0606g();
    private final Set<C0505e> f700d = new HashSet();
    private final Set<C0505e> f701e = new HashSet();
    private double f702f;
    private ad f703g;
    private boolean f704h;
    private boolean f705i;
    private ab f706j;
    private C0513i f707k;
    private final C0582g<C0621n<?>> f708l;
    private final C0582g<C0594z<?>> f709m;
    private final C0582g<C0593r<?>> f710n;
    private final List<C0514a> f711o = new ArrayList();
    private boolean f712p;
    private String f713q;
    private int f714r;
    private int f715s;
    private boolean f716t = false;
    private boolean f717u;
    private boolean f718v;
    private boolean f719w;
    private boolean f720x;

    public C0613k() {
        this.f701e.add(C0612j.f682b);
        this.f701e.add(C0612j.f683c);
        this.f700d.add(C0612j.f682b);
        this.f700d.add(C0612j.f683c);
        this.f702f = -1.0d;
        this.f704h = true;
        this.f719w = false;
        this.f718v = true;
        this.f703g = C0612j.f684d;
        this.f705i = false;
        this.f706j = ab.DEFAULT;
        this.f707k = C0612j.f685e;
        this.f708l = new C0582g();
        this.f709m = new C0582g();
        this.f710n = new C0582g();
        this.f712p = false;
        this.f714r = 2;
        this.f715s = 2;
        this.f717u = false;
        this.f720x = false;
    }

    private static <T> void m1250a(Class<?> cls, C0582g<T> c0582g, T t) {
        if (!c0582g.m1174a(cls)) {
            c0582g.m1173a(cls, t, false);
        }
    }

    private static void m1251a(String str, int i, int i2, C0582g<C0594z<?>> c0582g, C0582g<C0593r<?>> c0582g2) {
        Object obj = null;
        if (str != null && !"".equals(str.trim())) {
            obj = new C0595a(str);
        } else if (!(i == 2 || i2 == 2)) {
            obj = new C0595a(i, i2);
        }
        if (obj != null) {
            C0613k.m1250a(Date.class, c0582g, obj);
            C0613k.m1250a(Date.class, c0582g2, obj);
            C0613k.m1250a(Timestamp.class, c0582g, obj);
            C0613k.m1250a(Timestamp.class, c0582g2, obj);
            C0613k.m1250a(java.sql.Date.class, c0582g, obj);
            C0613k.m1250a(java.sql.Date.class, c0582g2, obj);
        }
    }

    public C0613k m1252a() {
        this.f718v = false;
        return this;
    }

    public C0612j m1253b() {
        Collection linkedList = new LinkedList(this.f701e);
        Collection linkedList2 = new LinkedList(this.f700d);
        linkedList.add(this.f703g);
        linkedList2.add(this.f703g);
        if (!this.f704h) {
            linkedList.add(f697a);
            linkedList2.add(f697a);
        }
        if (this.f702f != -1.0d) {
            ah ahVar = new ah(this.f702f);
            linkedList.add(ahVar);
            linkedList2.add(ahVar);
        }
        if (this.f705i) {
            linkedList.add(f698b);
            linkedList2.add(f699c);
        }
        C0613k.m1251a(this.f713q, this.f714r, this.f715s, this.f709m, this.f710n);
        return new C0612j(new C0604d(linkedList), new C0604d(linkedList2), this.f707k, this.f708l.m1175b().m1171a(), this.f712p, this.f709m.m1175b().m1171a(), this.f710n.m1175b().m1171a(), this.f716t, this.f720x, this.f718v, this.f719w, this.f717u, this.f706j, this.f711o);
    }
}
