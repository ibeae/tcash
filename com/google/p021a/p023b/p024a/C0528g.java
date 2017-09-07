package com.google.p021a.p023b.p024a;

import com.google.p021a.C0623s;
import com.google.p021a.C0624p;
import com.google.p021a.C0626u;
import com.google.p021a.C0627v;
import com.google.p021a.C0628x;
import com.google.p021a.p025d.C0527a;
import com.google.p021a.p025d.C0600c;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public final class C0528g extends C0527a {
    private static final Reader f483a = new C05261();
    private static final Object f484b = new Object();
    private final List<Object> f485c = new ArrayList();

    static class C05261 extends Reader {
        C05261() {
        }

        public void close() {
            throw new AssertionError();
        }

        public int read(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    }

    public C0528g(C0623s c0623s) {
        super(f483a);
        this.f485c.add(c0623s);
    }

    private void m917a(C0600c c0600c) {
        if (mo811f() != c0600c) {
            throw new IllegalStateException("Expected " + c0600c + " but was " + mo811f());
        }
    }

    private Object m918p() {
        return this.f485c.get(this.f485c.size() - 1);
    }

    private Object m919q() {
        return this.f485c.remove(this.f485c.size() - 1);
    }

    public void mo805a() {
        m917a(C0600c.BEGIN_ARRAY);
        this.f485c.add(((C0624p) m918p()).iterator());
    }

    public void mo806b() {
        m917a(C0600c.END_ARRAY);
        m919q();
        m919q();
    }

    public void mo807c() {
        m917a(C0600c.BEGIN_OBJECT);
        this.f485c.add(((C0627v) m918p()).m1288o().iterator());
    }

    public void close() {
        this.f485c.clear();
        this.f485c.add(f484b);
    }

    public void mo809d() {
        m917a(C0600c.END_OBJECT);
        m919q();
        m919q();
    }

    public boolean mo810e() {
        C0600c f = mo811f();
        return (f == C0600c.END_OBJECT || f == C0600c.END_ARRAY) ? false : true;
    }

    public C0600c mo811f() {
        if (this.f485c.isEmpty()) {
            return C0600c.END_DOCUMENT;
        }
        Object p = m918p();
        if (p instanceof Iterator) {
            boolean z = this.f485c.get(this.f485c.size() - 2) instanceof C0627v;
            Iterator it = (Iterator) p;
            if (!it.hasNext()) {
                return z ? C0600c.END_OBJECT : C0600c.END_ARRAY;
            } else {
                if (z) {
                    return C0600c.NAME;
                }
                this.f485c.add(it.next());
                return mo811f();
            }
        } else if (p instanceof C0627v) {
            return C0600c.BEGIN_OBJECT;
        } else {
            if (p instanceof C0624p) {
                return C0600c.BEGIN_ARRAY;
            }
            if (p instanceof C0628x) {
                C0628x c0628x = (C0628x) p;
                if (c0628x.m1301q()) {
                    return C0600c.STRING;
                }
                if (c0628x.m1299o()) {
                    return C0600c.BOOLEAN;
                }
                if (c0628x.m1300p()) {
                    return C0600c.NUMBER;
                }
                throw new AssertionError();
            } else if (p instanceof C0626u) {
                return C0600c.NULL;
            } else {
                if (p == f484b) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    public String mo812g() {
        m917a(C0600c.NAME);
        Entry entry = (Entry) ((Iterator) m918p()).next();
        this.f485c.add(entry.getValue());
        return (String) entry.getKey();
    }

    public String mo813h() {
        C0600c f = mo811f();
        if (f == C0600c.STRING || f == C0600c.NUMBER) {
            return ((C0628x) m919q()).mo844b();
        }
        throw new IllegalStateException("Expected " + C0600c.STRING + " but was " + f);
    }

    public boolean mo814i() {
        m917a(C0600c.BOOLEAN);
        return ((C0628x) m919q()).mo848f();
    }

    public void mo815j() {
        m917a(C0600c.NULL);
        m919q();
    }

    public double mo816k() {
        C0600c f = mo811f();
        if (f == C0600c.NUMBER || f == C0600c.STRING) {
            double c = ((C0628x) m918p()).mo845c();
            if (m916o() || !(Double.isNaN(c) || Double.isInfinite(c))) {
                m919q();
                return c;
            }
            throw new NumberFormatException("JSON forbids NaN and infinities: " + c);
        }
        throw new IllegalStateException("Expected " + C0600c.NUMBER + " but was " + f);
    }

    public long mo817l() {
        C0600c f = mo811f();
        if (f == C0600c.NUMBER || f == C0600c.STRING) {
            long d = ((C0628x) m918p()).mo846d();
            m919q();
            return d;
        }
        throw new IllegalStateException("Expected " + C0600c.NUMBER + " but was " + f);
    }

    public int mo818m() {
        C0600c f = mo811f();
        if (f == C0600c.NUMBER || f == C0600c.STRING) {
            int e = ((C0628x) m918p()).mo847e();
            m919q();
            return e;
        }
        throw new IllegalStateException("Expected " + C0600c.NUMBER + " but was " + f);
    }

    public void mo819n() {
        if (mo811f() == C0600c.NAME) {
            mo812g();
        } else {
            m919q();
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
