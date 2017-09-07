package com.google.p021a.p023b.p024a;

import com.google.p021a.aa;
import com.google.p021a.p023b.p024a.C0516q.C0514a;
import com.google.p021a.p025d.C0527a;
import com.google.p021a.p025d.C0530d;
import com.google.p021a.p025d.C0600c;
import com.google.p021a.p026c.C0596a;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class C0523e extends C0516q<Date> {
    public static final C0514a f456a = new C05221();
    private final DateFormat f457b = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    private final DateFormat f458c = DateFormat.getDateTimeInstance(2, 2);
    private final DateFormat f459d = C0523e.m865a();

    static class C05221 implements C0514a {
        C05221() {
        }

        public <T> C0516q<T> mo802a(C0537j c0537j, C0596a<T> c0596a) {
            return c0596a.m1197a() == Date.class ? new C0523e() : null;
        }
    }

    private static DateFormat m865a() {
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    private synchronized Date m866a(String str) {
        Date parse;
        try {
            parse = this.f458c.parse(str);
        } catch (ParseException e) {
            try {
                parse = this.f457b.parse(str);
            } catch (ParseException e2) {
                try {
                    parse = this.f459d.parse(str);
                } catch (Throwable e3) {
                    throw new aa(str, e3);
                }
            }
        }
        return parse;
    }

    public Date m867a(C0527a c0527a) {
        if (c0527a.mo811f() != C0600c.NULL) {
            return m866a(c0527a.mo813h());
        }
        c0527a.mo815j();
        return null;
    }

    public synchronized void m869a(C0530d c0530d, Date date) {
        if (date == null) {
            c0530d.mo832f();
        } else {
            c0530d.mo827b(this.f457b.format(date));
        }
    }

    public /* synthetic */ Object mo804b(C0527a c0527a) {
        return m867a(c0527a);
    }
}
