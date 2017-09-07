package com.google.p021a;

import com.google.p021a.p023b.C0587i;
import com.google.p021a.p025d.C0530d;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public abstract class C0623s {
    public Number mo843a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String mo844b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double mo845c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public long mo846d() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int mo847e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean mo848f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean m1272g() {
        return this instanceof C0624p;
    }

    public boolean m1273h() {
        return this instanceof C0627v;
    }

    public boolean m1274i() {
        return this instanceof C0628x;
    }

    public boolean m1275j() {
        return this instanceof C0626u;
    }

    public C0627v m1276k() {
        if (m1273h()) {
            return (C0627v) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public C0624p m1277l() {
        if (m1272g()) {
            return (C0624p) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public C0628x m1278m() {
        if (m1274i()) {
            return (C0628x) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    Boolean mo849n() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            Writer stringWriter = new StringWriter();
            C0530d c0530d = new C0530d(stringWriter);
            c0530d.m949b(true);
            C0587i.m1180a(this, c0530d);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
