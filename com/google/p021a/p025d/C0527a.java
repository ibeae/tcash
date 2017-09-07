package com.google.p021a.p025d;

import com.facebook.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class C0527a implements Closeable {
    private static final char[] f468a = ")]}'\n".toCharArray();
    private final C0603f f469b = new C0603f();
    private final Reader f470c;
    private boolean f471d = false;
    private final char[] f472e = new char[1024];
    private int f473f = 0;
    private int f474g = 0;
    private int f475h = 1;
    private int f476i = 1;
    private final List<C0599b> f477j = new ArrayList();
    private boolean f478k;
    private C0600c f479l;
    private String f480m;
    private String f481n;
    private boolean f482o;

    public C0527a(Reader reader) {
        m882a(C0599b.EMPTY_DOCUMENT);
        this.f482o = false;
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f470c = reader;
    }

    private void m875A() {
        char c;
        do {
            if (this.f473f < this.f474g || m884a(1)) {
                char[] cArr = this.f472e;
                int i = this.f473f;
                this.f473f = i + 1;
                c = cArr[i];
                if (c == '\r') {
                    return;
                }
            } else {
                return;
            }
        } while (c != '\n');
    }

    private String m876B() {
        StringBuilder stringBuilder = null;
        do {
            int i = this.f473f;
            while (this.f473f < this.f474g) {
                char[] cArr = this.f472e;
                int i2 = this.f473f;
                this.f473f = i2 + 1;
                switch (cArr[i2]) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        m900z();
                        break;
                    default:
                }
                this.f473f--;
                if (this.f482o) {
                    return "skipped!";
                }
                if (stringBuilder == null) {
                    return this.f469b.m1199a(this.f472e, i, this.f473f - i);
                }
                stringBuilder.append(this.f472e, i, this.f473f - i);
                return stringBuilder.toString();
            }
            if (stringBuilder == null) {
                stringBuilder = new StringBuilder();
            }
            stringBuilder.append(this.f472e, i, this.f473f - i);
        } while (m884a(1));
        return stringBuilder.toString();
    }

    private char m877C() {
        if (this.f473f != this.f474g || m884a(1)) {
            char[] cArr = this.f472e;
            int i = this.f473f;
            this.f473f = i + 1;
            char c = cArr[i];
            switch (c) {
                case 'b':
                    return '\b';
                case 'f':
                    return '\f';
                case 'n':
                    return '\n';
                case 'r':
                    return '\r';
                case 't':
                    return '\t';
                case 'u':
                    if (this.f473f + 4 <= this.f474g || m884a(4)) {
                        String a = this.f469b.m1199a(this.f472e, this.f473f, 4);
                        this.f473f += 4;
                        return (char) Integer.parseInt(a, 16);
                    }
                    throw m887b("Unterminated escape sequence");
                default:
                    return c;
            }
        }
        throw m887b("Unterminated escape sequence");
    }

    private C0600c m878D() {
        String B = m876B();
        if (B.length() == 0) {
            throw m887b("Expected literal value");
        }
        this.f481n = B;
        this.f478k = true;
        this.f479l = null;
        return null;
    }

    private void m879E() {
        if (this.f481n.equalsIgnoreCase("null")) {
            this.f479l = C0600c.NULL;
        } else if (this.f481n.equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) || this.f481n.equalsIgnoreCase("false")) {
            this.f479l = C0600c.BOOLEAN;
        } else {
            try {
                Double.parseDouble(this.f481n);
                this.f479l = C0600c.NUMBER;
            } catch (NumberFormatException e) {
                m900z();
                this.f479l = C0600c.STRING;
            }
        }
    }

    private CharSequence m880F() {
        CharSequence stringBuilder = new StringBuilder();
        int min = Math.min(this.f473f, 20);
        stringBuilder.append(this.f472e, this.f473f - min, min);
        stringBuilder.append(this.f472e, this.f473f, Math.min(this.f474g - this.f473f, 20));
        return stringBuilder;
    }

    private String m881a(char c) {
        StringBuilder stringBuilder = null;
        do {
            int i = this.f473f;
            while (this.f473f < this.f474g) {
                char[] cArr = this.f472e;
                int i2 = this.f473f;
                this.f473f = i2 + 1;
                char c2 = cArr[i2];
                if (c2 != c) {
                    StringBuilder stringBuilder2;
                    int i3;
                    int i4;
                    if (c2 == '\\') {
                        if (stringBuilder == null) {
                            stringBuilder = new StringBuilder();
                        }
                        stringBuilder.append(this.f472e, i, (this.f473f - i) - 1);
                        stringBuilder.append(m877C());
                        stringBuilder2 = stringBuilder;
                        i3 = this.f473f;
                    } else {
                        i4 = i;
                        stringBuilder2 = stringBuilder;
                        i3 = i4;
                    }
                    i4 = i3;
                    stringBuilder = stringBuilder2;
                    i = i4;
                } else if (this.f482o) {
                    return "skipped!";
                } else {
                    if (stringBuilder == null) {
                        return this.f469b.m1199a(this.f472e, i, (this.f473f - i) - 1);
                    }
                    stringBuilder.append(this.f472e, i, (this.f473f - i) - 1);
                    return stringBuilder.toString();
                }
            }
            if (stringBuilder == null) {
                stringBuilder = new StringBuilder();
            }
            stringBuilder.append(this.f472e, i, this.f473f - i);
        } while (m884a(1));
        throw m887b("Unterminated string");
    }

    private void m882a(C0599b c0599b) {
        this.f477j.add(c0599b);
    }

    private void m883a(C0600c c0600c) {
        m890p();
        if (this.f479l != c0600c) {
            throw new IllegalStateException("Expected " + c0600c + " but was " + mo811f());
        }
        m892r();
    }

    private boolean m884a(int i) {
        int i2;
        for (i2 = 0; i2 < this.f473f; i2++) {
            if (this.f472e[i2] == '\n') {
                this.f475h++;
                this.f476i = 1;
            } else {
                this.f476i++;
            }
        }
        if (this.f474g != this.f473f) {
            this.f474g -= this.f473f;
            System.arraycopy(this.f472e, this.f473f, this.f472e, 0, this.f474g);
        } else {
            this.f474g = 0;
        }
        this.f473f = 0;
        do {
            i2 = this.f470c.read(this.f472e, this.f474g, this.f472e.length - this.f474g);
            if (i2 == -1) {
                return false;
            }
            this.f474g = i2 + this.f474g;
            if (this.f475h == 1 && this.f476i == 1 && this.f474g > 0 && this.f472e[0] == '﻿') {
                this.f473f++;
                this.f476i--;
            }
        } while (this.f474g < i);
        return true;
    }

    private boolean m885a(String str) {
        while (true) {
            if (this.f473f + str.length() > this.f474g && !m884a(str.length())) {
                return false;
            }
            int i = 0;
            while (i < str.length()) {
                if (this.f472e[this.f473f + i] != str.charAt(i)) {
                    this.f473f++;
                } else {
                    i++;
                }
            }
            return true;
        }
    }

    private C0600c m886b(boolean z) {
        C0600c c0600c;
        if (z) {
            m888b(C0599b.NONEMPTY_ARRAY);
        } else {
            switch (m899y()) {
                case 44:
                    break;
                case 59:
                    m900z();
                    break;
                case 93:
                    m894t();
                    this.f478k = true;
                    c0600c = C0600c.END_ARRAY;
                    this.f479l = c0600c;
                    return c0600c;
                default:
                    throw m887b("Unterminated array");
            }
        }
        switch (m899y()) {
            case 44:
            case 59:
                break;
            case 93:
                if (z) {
                    m894t();
                    this.f478k = true;
                    c0600c = C0600c.END_ARRAY;
                    this.f479l = c0600c;
                    return c0600c;
                }
                break;
            default:
                this.f473f--;
                return m896v();
        }
        m900z();
        this.f473f--;
        this.f478k = true;
        this.f481n = "null";
        c0600c = C0600c.NULL;
        this.f479l = c0600c;
        return c0600c;
    }

    private IOException m887b(String str) {
        throw new C0602e(str + " at line " + m897w() + " column " + m898x());
    }

    private void m888b(C0599b c0599b) {
        this.f477j.set(this.f477j.size() - 1, c0599b);
    }

    private C0600c m889c(boolean z) {
        C0600c c0600c;
        if (z) {
            switch (m899y()) {
                case 125:
                    m894t();
                    this.f478k = true;
                    c0600c = C0600c.END_OBJECT;
                    this.f479l = c0600c;
                    return c0600c;
                default:
                    this.f473f--;
                    break;
            }
        }
        switch (m899y()) {
            case 44:
            case 59:
                break;
            case 125:
                m894t();
                this.f478k = true;
                c0600c = C0600c.END_OBJECT;
                this.f479l = c0600c;
                return c0600c;
            default:
                throw m887b("Unterminated object");
        }
        int y = m899y();
        switch (y) {
            case 34:
                break;
            case 39:
                m900z();
                break;
            default:
                m900z();
                this.f473f--;
                this.f480m = m876B();
                if (this.f480m.length() == 0) {
                    throw m887b("Expected name");
                }
                break;
        }
        this.f480m = m881a((char) y);
        m888b(C0599b.DANGLING_NAME);
        this.f478k = true;
        c0600c = C0600c.NAME;
        this.f479l = c0600c;
        return c0600c;
    }

    private C0600c m890p() {
        if (this.f478k) {
            return this.f479l;
        }
        C0600c v;
        switch (m893s()) {
            case EMPTY_DOCUMENT:
                if (this.f471d) {
                    m891q();
                }
                m888b(C0599b.NONEMPTY_DOCUMENT);
                v = m896v();
                if (this.f471d || v == C0600c.BEGIN_ARRAY || v == C0600c.BEGIN_OBJECT) {
                    return v;
                }
                m887b("Expected JSON document to start with '[' or '{'");
                return v;
            case EMPTY_ARRAY:
                return m886b(true);
            case NONEMPTY_ARRAY:
                return m886b(false);
            case EMPTY_OBJECT:
                return m889c(true);
            case DANGLING_NAME:
                return m895u();
            case NONEMPTY_OBJECT:
                return m889c(false);
            case NONEMPTY_DOCUMENT:
                try {
                    v = m896v();
                    if (this.f471d) {
                        return v;
                    }
                    throw m887b("Expected EOF");
                } catch (EOFException e) {
                    this.f478k = true;
                    v = C0600c.END_DOCUMENT;
                    this.f479l = v;
                    return v;
                }
            case CLOSED:
                throw new IllegalStateException("JsonReader is closed");
            default:
                throw new AssertionError();
        }
    }

    private void m891q() {
        m899y();
        this.f473f--;
        if (this.f473f + f468a.length <= this.f474g || m884a(f468a.length)) {
            int i = 0;
            while (i < f468a.length) {
                if (this.f472e[this.f473f + i] == f468a[i]) {
                    i++;
                } else {
                    return;
                }
            }
            this.f473f += f468a.length;
        }
    }

    private C0600c m892r() {
        m890p();
        C0600c c0600c = this.f479l;
        this.f478k = false;
        this.f479l = null;
        this.f481n = null;
        this.f480m = null;
        return c0600c;
    }

    private C0599b m893s() {
        return (C0599b) this.f477j.get(this.f477j.size() - 1);
    }

    private C0599b m894t() {
        return (C0599b) this.f477j.remove(this.f477j.size() - 1);
    }

    private C0600c m895u() {
        switch (m899y()) {
            case 58:
                break;
            case 61:
                m900z();
                if ((this.f473f < this.f474g || m884a(1)) && this.f472e[this.f473f] == '>') {
                    this.f473f++;
                    break;
                }
            default:
                throw m887b("Expected ':'");
        }
        m888b(C0599b.NONEMPTY_OBJECT);
        return m896v();
    }

    private C0600c m896v() {
        C0600c c0600c;
        int y = m899y();
        switch (y) {
            case 34:
                break;
            case 39:
                m900z();
                break;
            case 91:
                m882a(C0599b.EMPTY_ARRAY);
                this.f478k = true;
                c0600c = C0600c.BEGIN_ARRAY;
                this.f479l = c0600c;
                return c0600c;
            case 123:
                m882a(C0599b.EMPTY_OBJECT);
                this.f478k = true;
                c0600c = C0600c.BEGIN_OBJECT;
                this.f479l = c0600c;
                return c0600c;
            default:
                this.f473f--;
                return m878D();
        }
        this.f481n = m881a((char) y);
        this.f478k = true;
        c0600c = C0600c.STRING;
        this.f479l = c0600c;
        return c0600c;
    }

    private int m897w() {
        int i = this.f475h;
        for (int i2 = 0; i2 < this.f473f; i2++) {
            if (this.f472e[i2] == '\n') {
                i++;
            }
        }
        return i;
    }

    private int m898x() {
        int i = this.f476i;
        for (int i2 = 0; i2 < this.f473f; i2++) {
            i = this.f472e[i2] == '\n' ? 1 : i + 1;
        }
        return i;
    }

    private int m899y() {
        while (true) {
            if (this.f473f < this.f474g || m884a(1)) {
                char[] cArr = this.f472e;
                int i = this.f473f;
                this.f473f = i + 1;
                char c = cArr[i];
                switch (c) {
                    case '\t':
                    case '\n':
                    case '\r':
                    case ' ':
                        break;
                    case '#':
                        m900z();
                        m875A();
                        continue;
                    case '/':
                        if (this.f473f == this.f474g && !m884a(1)) {
                            break;
                        }
                        m900z();
                        switch (this.f472e[this.f473f]) {
                            case '*':
                                this.f473f++;
                                if (m885a("*/")) {
                                    this.f473f += 2;
                                    continue;
                                    continue;
                                } else {
                                    throw m887b("Unterminated comment");
                                }
                            case '/':
                                this.f473f++;
                                m875A();
                                continue;
                            default:
                                break;
                        }
                    default:
                        break;
                }
                return c;
            }
            throw new EOFException("End of input");
        }
    }

    private void m900z() {
        if (!this.f471d) {
            throw m887b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    public void mo805a() {
        m883a(C0600c.BEGIN_ARRAY);
    }

    public final void m902a(boolean z) {
        this.f471d = z;
    }

    public void mo806b() {
        m883a(C0600c.END_ARRAY);
    }

    public void mo807c() {
        m883a(C0600c.BEGIN_OBJECT);
    }

    public void close() {
        this.f478k = false;
        this.f481n = null;
        this.f479l = null;
        this.f477j.clear();
        this.f477j.add(C0599b.CLOSED);
        this.f470c.close();
    }

    public void mo809d() {
        m883a(C0600c.END_OBJECT);
    }

    public boolean mo810e() {
        m890p();
        return (this.f479l == C0600c.END_OBJECT || this.f479l == C0600c.END_ARRAY) ? false : true;
    }

    public C0600c mo811f() {
        m890p();
        if (this.f479l == null) {
            m879E();
        }
        return this.f479l;
    }

    public String mo812g() {
        m890p();
        if (this.f479l != C0600c.NAME) {
            throw new IllegalStateException("Expected a name but was " + mo811f());
        }
        String str = this.f480m;
        m892r();
        return str;
    }

    public String mo813h() {
        mo811f();
        if (this.f481n == null || !(this.f479l == C0600c.STRING || this.f479l == C0600c.NUMBER)) {
            throw new IllegalStateException("Expected a string but was " + mo811f());
        }
        String str = this.f481n;
        m892r();
        return str;
    }

    public boolean mo814i() {
        m890p();
        if (this.f481n == null || this.f479l == C0600c.STRING) {
            throw new IllegalStateException("Expected a boolean but was " + mo811f());
        }
        boolean z;
        if (this.f481n.equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
            z = true;
        } else if (this.f481n.equalsIgnoreCase("false")) {
            z = false;
        } else {
            throw new IllegalStateException("Not a boolean: " + this.f481n);
        }
        m892r();
        return z;
    }

    public void mo815j() {
        m890p();
        if (this.f481n == null || this.f479l == C0600c.STRING) {
            throw new IllegalStateException("Expected null but was " + mo811f());
        } else if (this.f481n.equalsIgnoreCase("null")) {
            m892r();
        } else {
            throw new IllegalStateException("Not a null: " + this.f481n);
        }
    }

    public double mo816k() {
        m890p();
        if (this.f481n == null) {
            throw new IllegalStateException("Expected a double but was " + mo811f());
        }
        double parseDouble = Double.parseDouble(this.f481n);
        if (parseDouble >= 1.0d && this.f481n.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            throw new NumberFormatException("JSON forbids octal prefixes: " + this.f481n);
        } else if (this.f471d || !(Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            m892r();
            return parseDouble;
        } else {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + this.f481n);
        }
    }

    public long mo817l() {
        long parseLong;
        m890p();
        if (this.f481n == null) {
            throw new IllegalStateException("Expected a long but was " + mo811f());
        }
        try {
            parseLong = Long.parseLong(this.f481n);
        } catch (NumberFormatException e) {
            double parseDouble = Double.parseDouble(this.f481n);
            parseLong = (long) parseDouble;
            if (((double) parseLong) != parseDouble) {
                throw new NumberFormatException(this.f481n);
            }
        }
        if (parseLong < 1 || !this.f481n.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            m892r();
            return parseLong;
        }
        throw new NumberFormatException("JSON forbids octal prefixes: " + this.f481n);
    }

    public int mo818m() {
        int parseInt;
        m890p();
        if (this.f481n == null) {
            throw new IllegalStateException("Expected an int but was " + mo811f());
        }
        try {
            parseInt = Integer.parseInt(this.f481n);
        } catch (NumberFormatException e) {
            double parseDouble = Double.parseDouble(this.f481n);
            parseInt = (int) parseDouble;
            if (((double) parseInt) != parseDouble) {
                throw new NumberFormatException(this.f481n);
            }
        }
        if (((long) parseInt) < 1 || !this.f481n.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            m892r();
            return parseInt;
        }
        throw new NumberFormatException("JSON forbids octal prefixes: " + this.f481n);
    }

    public void mo819n() {
        this.f482o = true;
        int i = 0;
        while (true) {
            try {
                C0600c r = m892r();
                if (r == C0600c.BEGIN_ARRAY || r == C0600c.BEGIN_OBJECT) {
                    i++;
                    continue;
                } else if (r == C0600c.END_ARRAY || r == C0600c.END_OBJECT) {
                    i--;
                    continue;
                }
                if (i == 0) {
                    break;
                }
            } finally {
                this.f482o = false;
            }
        }
    }

    public final boolean m916o() {
        return this.f471d;
    }

    public String toString() {
        return getClass().getSimpleName() + " near " + m880F();
    }
}
