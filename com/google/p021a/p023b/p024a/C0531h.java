package com.google.p021a.p023b.p024a;

import com.google.p021a.C0623s;
import com.google.p021a.C0624p;
import com.google.p021a.C0626u;
import com.google.p021a.C0627v;
import com.google.p021a.C0628x;
import com.google.p021a.p025d.C0530d;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class C0531h extends C0530d {
    private static final Writer f494a = new C05291();
    private static final C0628x f495b = new C0628x("closed");
    private final List<C0623s> f496c = new ArrayList();
    private String f497d;
    private C0623s f498e = C0626u.f737a;

    static class C05291 extends Writer {
        C05291() {
        }

        public void close() {
            throw new AssertionError();
        }

        public void flush() {
            throw new AssertionError();
        }

        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    }

    public C0531h() {
        super(f494a);
    }

    private void m960a(C0623s c0623s) {
        if (this.f497d != null) {
            if (!c0623s.m1275j() || m959i()) {
                ((C0627v) m961j()).m1287a(this.f497d, c0623s);
            }
            this.f497d = null;
        } else if (this.f496c.isEmpty()) {
            this.f498e = c0623s;
        } else {
            C0623s j = m961j();
            if (j instanceof C0624p) {
                ((C0624p) j).m1281a(c0623s);
                return;
            }
            throw new IllegalStateException();
        }
    }

    private C0623s m961j() {
        return (C0623s) this.f496c.get(this.f496c.size() - 1);
    }

    public C0530d mo821a(long j) {
        m960a(new C0628x(Long.valueOf(j)));
        return this;
    }

    public C0530d mo822a(Number number) {
        if (number == null) {
            return mo832f();
        }
        if (!m957g()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        m960a(new C0628x(number));
        return this;
    }

    public C0530d mo823a(String str) {
        if (this.f496c.isEmpty() || this.f497d != null) {
            throw new IllegalStateException();
        } else if (m961j() instanceof C0627v) {
            this.f497d = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public C0530d mo824a(boolean z) {
        m960a(new C0628x(Boolean.valueOf(z)));
        return this;
    }

    public C0623s mo825a() {
        if (this.f496c.isEmpty()) {
            return this.f498e;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f496c);
    }

    public C0530d mo826b() {
        C0623s c0624p = new C0624p();
        m960a(c0624p);
        this.f496c.add(c0624p);
        return this;
    }

    public C0530d mo827b(String str) {
        if (str == null) {
            return mo832f();
        }
        m960a(new C0628x(str));
        return this;
    }

    public C0530d mo828c() {
        if (this.f496c.isEmpty() || this.f497d != null) {
            throw new IllegalStateException();
        } else if (m961j() instanceof C0624p) {
            this.f496c.remove(this.f496c.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public void close() {
        if (this.f496c.isEmpty()) {
            this.f496c.add(f495b);
            return;
        }
        throw new IOException("Incomplete document");
    }

    public C0530d mo830d() {
        C0623s c0627v = new C0627v();
        m960a(c0627v);
        this.f496c.add(c0627v);
        return this;
    }

    public C0530d mo831e() {
        if (this.f496c.isEmpty() || this.f497d != null) {
            throw new IllegalStateException();
        } else if (m961j() instanceof C0627v) {
            this.f496c.remove(this.f496c.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public C0530d mo832f() {
        m960a(C0626u.f737a);
        return this;
    }
}
