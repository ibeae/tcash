package com.google.p021a.p023b.p024a;

import com.google.p021a.aa;
import com.google.p021a.p023b.p024a.C0516q.C0514a;
import com.google.p021a.p025d.C0527a;
import com.google.p021a.p025d.C0530d;
import com.google.p021a.p025d.C0600c;
import com.google.p021a.p026c.C0596a;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class C0551p extends C0516q<Time> {
    public static final C0514a f533a = new C05501();
    private final DateFormat f534b = new SimpleDateFormat("hh:mm:ss a");

    static class C05501 implements C0514a {
        C05501() {
        }

        public <T> C0516q<T> mo802a(C0537j c0537j, C0596a<T> c0596a) {
            return c0596a.m1197a() == Time.class ? new C0551p() : null;
        }
    }

    public synchronized Time m1020a(C0527a c0527a) {
        Time time;
        if (c0527a.mo811f() == C0600c.NULL) {
            c0527a.mo815j();
            time = null;
        } else {
            try {
                time = new Time(this.f534b.parse(c0527a.mo813h()).getTime());
            } catch (Throwable e) {
                throw new aa(e);
            }
        }
        return time;
    }

    public synchronized void m1022a(C0530d c0530d, Time time) {
        c0530d.mo827b(time == null ? null : this.f534b.format(time));
    }

    public /* synthetic */ Object mo804b(C0527a c0527a) {
        return m1020a(c0527a);
    }
}
