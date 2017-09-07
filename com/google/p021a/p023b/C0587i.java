package com.google.p021a.p023b;

import com.google.p021a.C0623s;
import com.google.p021a.C0625t;
import com.google.p021a.C0626u;
import com.google.p021a.aa;
import com.google.p021a.p023b.p024a.C0564s;
import com.google.p021a.p025d.C0527a;
import com.google.p021a.p025d.C0530d;
import java.io.Writer;

public final class C0587i {

    private static class C0586a extends Writer {
        private final Appendable f630a;
        private final C0585a f631b;

        static class C0585a implements CharSequence {
            char[] f629a;

            C0585a() {
            }

            public char charAt(int i) {
                return this.f629a[i];
            }

            public int length() {
                return this.f629a.length;
            }

            public CharSequence subSequence(int i, int i2) {
                return new String(this.f629a, i, i2 - i);
            }
        }

        private C0586a(Appendable appendable) {
            this.f631b = new C0585a();
            this.f630a = appendable;
        }

        public void close() {
        }

        public void flush() {
        }

        public void write(int i) {
            this.f630a.append((char) i);
        }

        public void write(char[] cArr, int i, int i2) {
            this.f631b.f629a = cArr;
            this.f630a.append(this.f631b, i, i + i2);
        }
    }

    public static C0623s m1178a(C0527a c0527a) {
        Object obj = 1;
        try {
            c0527a.mo811f();
            obj = null;
            return (C0623s) C0564s.f567O.mo804b(c0527a);
        } catch (Throwable e) {
            if (obj != null) {
                return C0626u.f737a;
            }
            throw new C0625t(e);
        } catch (Throwable e2) {
            throw new aa(e2);
        } catch (Throwable e22) {
            throw new C0625t(e22);
        } catch (Throwable e222) {
            throw new aa(e222);
        }
    }

    public static Writer m1179a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new C0586a(appendable);
    }

    public static void m1180a(C0623s c0623s, C0530d c0530d) {
        C0564s.f567O.mo803a(c0530d, c0623s);
    }
}
