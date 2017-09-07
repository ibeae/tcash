package com.google.p021a;

import com.google.p021a.p023b.C0579c;
import com.google.p021a.p023b.C0582g;
import com.google.p021a.p023b.C0587i;
import com.google.p021a.p023b.p024a.C0516q;
import com.google.p021a.p023b.p024a.C0516q.C0514a;
import com.google.p021a.p023b.p024a.C0517a;
import com.google.p021a.p023b.p024a.C0518b;
import com.google.p021a.p023b.p024a.C0519c;
import com.google.p021a.p023b.p024a.C0521d;
import com.google.p021a.p023b.p024a.C0523e;
import com.google.p021a.p023b.p024a.C0525f;
import com.google.p021a.p023b.p024a.C0533i;
import com.google.p021a.p023b.p024a.C0537j;
import com.google.p021a.p023b.p024a.C0537j.C0535a;
import com.google.p021a.p023b.p024a.C0540k;
import com.google.p021a.p023b.p024a.C0545m;
import com.google.p021a.p023b.p024a.C0547n;
import com.google.p021a.p023b.p024a.C0551p;
import com.google.p021a.p023b.p024a.C0564s;
import com.google.p021a.p025d.C0527a;
import com.google.p021a.p025d.C0530d;
import com.google.p021a.p025d.C0600c;
import com.google.p021a.p026c.C0596a;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class C0612j {
    static final C0582g f681a = new C0582g().m1171a();
    static final C0506a f682b = new C0506a();
    static final ag f683c = new ag(true);
    static final ad f684d = new ad(128, 8);
    static final C0513i f685e = new af(new C0622o());
    private static final C0505e f686f = C0612j.m1233a();
    private final C0505e f687g;
    private final C0505e f688h;
    private final C0579c f689i;
    private final C0582g<C0594z<?>> f690j;
    private final C0582g<C0593r<?>> f691k;
    private final boolean f692l;
    private final boolean f693m;
    private final boolean f694n;
    private final boolean f695o;
    private final C0537j f696p;

    class C06092 extends C0516q<Number> {
        final /* synthetic */ C0612j f678a;

        C06092(C0612j c0612j) {
            this.f678a = c0612j;
        }

        public Double m1218a(C0527a c0527a) {
            if (c0527a.mo811f() != C0600c.NULL) {
                return Double.valueOf(c0527a.mo816k());
            }
            c0527a.mo815j();
            return null;
        }

        public void m1219a(C0530d c0530d, Number number) {
            if (number == null) {
                c0530d.mo832f();
                return;
            }
            this.f678a.m1235a(number.doubleValue());
            c0530d.mo822a(number);
        }

        public /* synthetic */ Object mo804b(C0527a c0527a) {
            return m1218a(c0527a);
        }
    }

    class C06103 extends C0516q<Number> {
        final /* synthetic */ C0612j f679a;

        C06103(C0612j c0612j) {
            this.f679a = c0612j;
        }

        public Float m1222a(C0527a c0527a) {
            if (c0527a.mo811f() != C0600c.NULL) {
                return Float.valueOf((float) c0527a.mo816k());
            }
            c0527a.mo815j();
            return null;
        }

        public void m1223a(C0530d c0530d, Number number) {
            if (number == null) {
                c0530d.mo832f();
                return;
            }
            this.f679a.m1235a((double) number.floatValue());
            c0530d.mo822a(number);
        }

        public /* synthetic */ Object mo804b(C0527a c0527a) {
            return m1222a(c0527a);
        }
    }

    class C06114 extends C0516q<Number> {
        final /* synthetic */ C0612j f680a;

        C06114(C0612j c0612j) {
            this.f680a = c0612j;
        }

        public Number m1226a(C0527a c0527a) {
            if (c0527a.mo811f() != C0600c.NULL) {
                return Long.valueOf(c0527a.mo817l());
            }
            c0527a.mo815j();
            return null;
        }

        public void m1227a(C0530d c0530d, Number number) {
            if (number == null) {
                c0530d.mo832f();
            } else {
                c0530d.mo827b(number.toString());
            }
        }

        public /* synthetic */ Object mo804b(C0527a c0527a) {
            return m1226a(c0527a);
        }
    }

    public C0612j() {
        this(f686f, f686f, f685e, f681a, false, f681a, f681a, false, false, true, false, false, ab.DEFAULT, Collections.emptyList());
    }

    C0612j(C0505e c0505e, C0505e c0505e2, final C0513i c0513i, C0582g<C0621n<?>> c0582g, boolean z, C0582g<C0594z<?>> c0582g2, C0582g<C0593r<?>> c0582g3, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, ab abVar, List<C0514a> list) {
        this.f687g = c0505e;
        this.f688h = c0505e2;
        this.f689i = new C0579c(c0582g);
        this.f692l = z;
        this.f690j = c0582g2;
        this.f691k = c0582g3;
        this.f694n = z3;
        this.f693m = z4;
        this.f695o = z5;
        C0514a c06081 = new C0545m(this, this.f689i) {
            final /* synthetic */ C0612j f677b;

            public String mo839a(Class<?> cls, Field field, Type type) {
                return c0513i.mo801a(new C0607h(cls, field));
            }

            public boolean mo840b(Class<?> cls, Field field, Type type) {
                C0505e a = this.f677b.f688h;
                return (a.mo798a(field.getType()) || a.mo797a(new C0607h(cls, field))) ? false : true;
            }

            public boolean mo841c(Class<?> cls, Field field, Type type) {
                C0505e b = this.f677b.f687g;
                return (b.mo798a(field.getType()) || b.mo797a(new C0607h(cls, field))) ? false : true;
            }
        };
        C0535a a = new C0535a().m983a().m984a(C0564s.f592w).m984a(C0564s.f580k).m984a(C0564s.f574e).m984a(C0564s.f576g).m984a(C0564s.f578i).m984a(C0564s.m1126a(Long.TYPE, Long.class, m1230a(abVar))).m984a(C0564s.m1126a(Double.TYPE, Double.class, m1231a(z6))).m984a(C0564s.m1126a(Float.TYPE, Float.class, m1238b(z6))).m984a(new C0525f(c0505e2, c0505e)).m984a(C0564s.f588s).m984a(C0564s.f590u).m984a(C0564s.f594y).m984a(C0564s.f553A).m985a(BigDecimal.class, new C0518b()).m985a(BigInteger.class, new C0519c()).m984a(C0564s.f568P).m984a(C0540k.f512a);
        for (C0514a a2 : list) {
            a.m984a(a2);
        }
        a.m984a(new C0619l(this, c0582g2, c0582g3)).m984a(new C0521d(this.f689i)).m984a(C0564s.f555C).m984a(C0564s.f557E).m984a(C0564s.f561I).m984a(C0564s.f566N).m984a(C0564s.f559G).m984a(C0564s.f571b).m984a(C0523e.f456a).m984a(C0564s.f564L).m984a(C0551p.f533a).m984a(C0547n.f527a).m984a(C0564s.f562J).m984a(new C0533i(this.f689i, z2)).m984a(C0517a.f449a).m984a(C0564s.f569Q).m984a(c06081);
        this.f696p = a.m986b();
    }

    private C0516q<Number> m1230a(ab abVar) {
        return abVar == ab.DEFAULT ? C0564s.f581l : new C06114(this);
    }

    private C0516q<Number> m1231a(boolean z) {
        return z ? C0564s.f585p : new C06092(this);
    }

    private C0530d m1232a(Writer writer) {
        if (this.f694n) {
            writer.write(")]}'\n");
        }
        C0530d c0530d = new C0530d(writer);
        if (this.f695o) {
            c0530d.m951c("  ");
        }
        c0530d.m954d(this.f692l);
        return c0530d;
    }

    private static C0505e m1233a() {
        Collection linkedList = new LinkedList();
        linkedList.add(f682b);
        linkedList.add(f683c);
        linkedList.add(f684d);
        return new C0604d(linkedList);
    }

    private void m1235a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this" + " behavior, use GsonBuilder.serializeSpecialDoubleValues() method.");
        }
    }

    private static void m1237a(Object obj, C0527a c0527a) {
        if (obj != null) {
            try {
                if (c0527a.mo811f() != C0600c.END_DOCUMENT) {
                    throw new C0625t("JSON document was not fully consumed.");
                }
            } catch (Throwable e) {
                throw new aa(e);
            } catch (Throwable e2) {
                throw new C0625t(e2);
            }
        }
    }

    private C0516q<Number> m1238b(boolean z) {
        return z ? C0564s.f583n : new C06103(this);
    }

    public <T> T m1240a(C0527a c0527a, Type type) {
        boolean z = true;
        boolean o = c0527a.m916o();
        c0527a.m902a(true);
        try {
            c0527a.mo811f();
            z = false;
            T b = this.f696p.m991a(C0596a.m1194a(type)).mo804b(c0527a);
            c0527a.m902a(o);
            return b;
        } catch (Throwable e) {
            if (z) {
                c0527a.m902a(o);
                return null;
            }
            throw new aa(e);
        } catch (Throwable e2) {
            throw new aa(e2);
        } catch (Throwable e22) {
            throw new aa(e22);
        } catch (Throwable th) {
            c0527a.m902a(o);
        }
    }

    public <T> T m1241a(Reader reader, Type type) {
        C0527a c0527a = new C0527a(reader);
        Object a = m1240a(c0527a, type);
        C0612j.m1237a(a, c0527a);
        return a;
    }

    public <T> T m1242a(String str, Type type) {
        return str == null ? null : m1241a(new StringReader(str), type);
    }

    public String m1243a(C0623s c0623s) {
        Appendable stringWriter = new StringWriter();
        m1247a(c0623s, stringWriter);
        return stringWriter.toString();
    }

    public String m1244a(Object obj) {
        return obj == null ? m1243a(C0626u.f737a) : m1245a(obj, obj.getClass());
    }

    public String m1245a(Object obj, Type type) {
        Appendable stringWriter = new StringWriter();
        m1249a(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void m1246a(C0623s c0623s, C0530d c0530d) {
        boolean g = c0530d.m957g();
        c0530d.m949b(true);
        boolean h = c0530d.m958h();
        c0530d.m952c(this.f693m);
        boolean i = c0530d.m959i();
        c0530d.m954d(this.f692l);
        try {
            C0587i.m1180a(c0623s, c0530d);
            c0530d.m949b(g);
            c0530d.m952c(h);
            c0530d.m954d(i);
        } catch (Throwable e) {
            throw new C0625t(e);
        } catch (Throwable th) {
            c0530d.m949b(g);
            c0530d.m952c(h);
            c0530d.m954d(i);
        }
    }

    public void m1247a(C0623s c0623s, Appendable appendable) {
        try {
            m1246a(c0623s, m1232a(C0587i.m1179a(appendable)));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void m1248a(Object obj, Type type, C0530d c0530d) {
        C0516q a = this.f696p.m991a(C0596a.m1194a(type));
        boolean g = c0530d.m957g();
        c0530d.m949b(true);
        boolean h = c0530d.m958h();
        c0530d.m952c(this.f693m);
        boolean i = c0530d.m959i();
        c0530d.m954d(this.f692l);
        try {
            a.mo803a(c0530d, obj);
            c0530d.m949b(g);
            c0530d.m952c(h);
            c0530d.m954d(i);
        } catch (Throwable e) {
            throw new C0625t(e);
        } catch (Throwable th) {
            c0530d.m949b(g);
            c0530d.m952c(h);
            c0530d.m954d(i);
        }
    }

    public void m1249a(Object obj, Type type, Appendable appendable) {
        try {
            m1248a(obj, type, m1232a(C0587i.m1179a(appendable)));
        } catch (Throwable e) {
            throw new C0625t(e);
        }
    }

    public String toString() {
        return "{" + "serializeNulls:" + this.f692l + ",serializers:" + this.f690j + ",deserializers:" + this.f691k + ",instanceCreators:" + this.f689i + "}";
    }
}
