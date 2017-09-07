package com.google.p021a.p025d;

import com.facebook.internal.ServerProtocol;
import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class C0530d implements Closeable {
    private final Writer f486a;
    private final List<C0599b> f487b = new ArrayList();
    private String f488c;
    private String f489d;
    private boolean f490e;
    private boolean f491f;
    private String f492g;
    private boolean f493h;

    public C0530d(Writer writer) {
        this.f487b.add(C0599b.EMPTY_DOCUMENT);
        this.f489d = ":";
        this.f493h = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f486a = writer;
    }

    private C0599b mo825a() {
        return (C0599b) this.f487b.get(this.f487b.size() - 1);
    }

    private C0530d m935a(C0599b c0599b, C0599b c0599b2, String str) {
        C0599b a = mo825a();
        if (a != c0599b2 && a != c0599b) {
            throw new IllegalStateException("Nesting problem: " + this.f487b);
        } else if (this.f492g != null) {
            throw new IllegalStateException("Dangling name: " + this.f492g);
        } else {
            this.f487b.remove(this.f487b.size() - 1);
            if (a == c0599b2) {
                m941k();
            }
            this.f486a.write(str);
            return this;
        }
    }

    private C0530d m936a(C0599b c0599b, String str) {
        m939e(true);
        this.f487b.add(c0599b);
        this.f486a.write(str);
        return this;
    }

    private void m937a(C0599b c0599b) {
        this.f487b.set(this.f487b.size() - 1, c0599b);
    }

    private void m938d(String str) {
        this.f486a.write("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\b':
                    this.f486a.write("\\b");
                    break;
                case '\t':
                    this.f486a.write("\\t");
                    break;
                case '\n':
                    this.f486a.write("\\n");
                    break;
                case '\f':
                    this.f486a.write("\\f");
                    break;
                case '\r':
                    this.f486a.write("\\r");
                    break;
                case '\"':
                case '\\':
                    this.f486a.write(92);
                    this.f486a.write(charAt);
                    break;
                case '&':
                case '\'':
                case '<':
                case '=':
                case '>':
                    if (!this.f491f) {
                        this.f486a.write(charAt);
                        break;
                    }
                    this.f486a.write(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
                    break;
                case ' ':
                case ' ':
                    this.f486a.write(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
                    break;
                default:
                    if (charAt > '\u001f') {
                        this.f486a.write(charAt);
                        break;
                    }
                    this.f486a.write(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
                    break;
            }
        }
        this.f486a.write("\"");
    }

    private void m939e(boolean z) {
        switch (mo825a()) {
            case EMPTY_DOCUMENT:
                if (this.f490e || z) {
                    m937a(C0599b.NONEMPTY_DOCUMENT);
                    return;
                }
                throw new IllegalStateException("JSON must start with an array or an object.");
            case EMPTY_ARRAY:
                m937a(C0599b.NONEMPTY_ARRAY);
                m941k();
                return;
            case NONEMPTY_ARRAY:
                this.f486a.append(',');
                m941k();
                return;
            case DANGLING_NAME:
                this.f486a.append(this.f489d);
                m937a(C0599b.NONEMPTY_OBJECT);
                return;
            case NONEMPTY_DOCUMENT:
                throw new IllegalStateException("JSON must have only one top-level value.");
            default:
                throw new IllegalStateException("Nesting problem: " + this.f487b);
        }
    }

    private void m940j() {
        if (this.f492g != null) {
            m942l();
            m938d(this.f492g);
            this.f492g = null;
        }
    }

    private void m941k() {
        if (this.f488c != null) {
            this.f486a.write("\n");
            for (int i = 1; i < this.f487b.size(); i++) {
                this.f486a.write(this.f488c);
            }
        }
    }

    private void m942l() {
        C0599b a = mo825a();
        if (a == C0599b.NONEMPTY_OBJECT) {
            this.f486a.write(44);
        } else if (a != C0599b.EMPTY_OBJECT) {
            throw new IllegalStateException("Nesting problem: " + this.f487b);
        }
        m941k();
        m937a(C0599b.DANGLING_NAME);
    }

    public C0530d mo821a(long j) {
        m940j();
        m939e(false);
        this.f486a.write(Long.toString(j));
        return this;
    }

    public C0530d mo822a(Number number) {
        if (number == null) {
            return mo832f();
        }
        m940j();
        CharSequence obj = number.toString();
        if (this.f490e || !(obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            m939e(false);
            this.f486a.append(obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    public C0530d mo823a(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.f492g != null) {
            throw new IllegalStateException();
        } else {
            this.f492g = str;
            return this;
        }
    }

    public C0530d mo824a(boolean z) {
        m940j();
        m939e(false);
        this.f486a.write(z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        return this;
    }

    public C0530d mo826b() {
        m940j();
        return m936a(C0599b.EMPTY_ARRAY, "[");
    }

    public C0530d mo827b(String str) {
        if (str == null) {
            return mo832f();
        }
        m940j();
        m939e(false);
        m938d(str);
        return this;
    }

    public final void m949b(boolean z) {
        this.f490e = z;
    }

    public C0530d mo828c() {
        return m935a(C0599b.EMPTY_ARRAY, C0599b.NONEMPTY_ARRAY, "]");
    }

    public final void m951c(String str) {
        if (str.length() == 0) {
            this.f488c = null;
            this.f489d = ":";
            return;
        }
        this.f488c = str;
        this.f489d = ": ";
    }

    public final void m952c(boolean z) {
        this.f491f = z;
    }

    public void close() {
        this.f486a.close();
        if (mo825a() != C0599b.NONEMPTY_DOCUMENT) {
            throw new IOException("Incomplete document");
        }
    }

    public C0530d mo830d() {
        m940j();
        return m936a(C0599b.EMPTY_OBJECT, "{");
    }

    public final void m954d(boolean z) {
        this.f493h = z;
    }

    public C0530d mo831e() {
        return m935a(C0599b.EMPTY_OBJECT, C0599b.NONEMPTY_OBJECT, "}");
    }

    public C0530d mo832f() {
        if (this.f492g != null) {
            if (this.f493h) {
                m940j();
            } else {
                this.f492g = null;
                return this;
            }
        }
        m939e(false);
        this.f486a.write("null");
        return this;
    }

    public boolean m957g() {
        return this.f490e;
    }

    public final boolean m958h() {
        return this.f491f;
    }

    public final boolean m959i() {
        return this.f493h;
    }
}
