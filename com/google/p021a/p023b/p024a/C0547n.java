package com.google.p021a.p023b.p024a;

import com.google.p021a.aa;
import com.google.p021a.p023b.p024a.C0516q.C0514a;
import com.google.p021a.p025d.C0527a;
import com.google.p021a.p025d.C0530d;
import com.google.p021a.p025d.C0600c;
import com.google.p021a.p026c.C0596a;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class C0547n extends C0516q<Date> {
    public static final C0514a f527a = new C05461();
    private final DateFormat f528b = new SimpleDateFormat("MMM d, yyyy");

    static class C05461 implements C0514a {
        C05461() {
        }

        public <T> C0516q<T> mo802a(C0537j c0537j, C0596a<T> c0596a) {
            return c0596a.m1197a() == Date.class ? new C0547n() : null;
        }
    }

    public synchronized Date m1010a(C0527a c0527a) {
        Date date;
        if (c0527a.mo811f() == C0600c.NULL) {
            c0527a.mo815j();
            date = null;
        } else {
            try {
                date = new Date(this.f528b.parse(c0527a.mo813h()).getTime());
            } catch (Throwable e) {
                throw new aa(e);
            }
        }
        return date;
    }

    public synchronized void m1012a(C0530d c0530d, Date date) {
        c0530d.mo827b(date == null ? null : this.f528b.format(date));
    }

    public /* synthetic */ Object mo804b(C0527a c0527a) {
        return m1010a(c0527a);
    }
}
