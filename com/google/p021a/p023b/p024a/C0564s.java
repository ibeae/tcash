package com.google.p021a.p023b.p024a;

import com.google.a.b.a.s.AnonymousClass11;
import com.google.p021a.C0623s;
import com.google.p021a.C0624p;
import com.google.p021a.C0625t;
import com.google.p021a.C0626u;
import com.google.p021a.C0627v;
import com.google.p021a.C0628x;
import com.google.p021a.aa;
import com.google.p021a.p023b.C0580d;
import com.google.p021a.p023b.p024a.C0516q;
import com.google.p021a.p023b.p024a.C0516q.C0514a;
import com.google.p021a.p023b.p024a.C0537j;
import com.google.p021a.p023b.p024a.C0564s.C0563a;
import com.google.p021a.p025d.C0527a;
import com.google.p021a.p025d.C0530d;
import com.google.p021a.p025d.C0600c;
import com.google.p021a.p026c.C0596a;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.UUID;

public final class C0564s {
    public static final C0514a f553A = C0564s.m1125a(StringBuffer.class, f595z);
    public static final C0516q<URL> f554B = new C05607();
    public static final C0514a f555C = C0564s.m1125a(URL.class, f554B);
    public static final C0516q<URI> f556D = new C05618();
    public static final C0514a f557E = C0564s.m1125a(URI.class, f556D);
    public static final C0516q<InetAddress> f558F = new C05629();
    public static final C0514a f559G = C0564s.m1127b(InetAddress.class, f558F);
    public static final C0516q<UUID> f560H = new C0516q<UUID>() {
        public UUID m1026a(C0527a c0527a) {
            if (c0527a.mo811f() != C0600c.NULL) {
                return UUID.fromString(c0527a.mo813h());
            }
            c0527a.mo815j();
            return null;
        }

        public void m1028a(C0530d c0530d, UUID uuid) {
            c0530d.mo827b(uuid == null ? null : uuid.toString());
        }

        public /* synthetic */ Object mo804b(C0527a c0527a) {
            return m1026a(c0527a);
        }
    };
    public static final C0514a f561I = C0564s.m1125a(UUID.class, f560H);
    public static final C0514a f562J = new C0514a() {
        public <T> C0516q<T> mo802a(C0537j c0537j, C0596a<T> c0596a) {
            if (c0596a.m1197a() != Timestamp.class) {
                return null;
            }
            final C0516q a = c0537j.m992a(Date.class);
            return new C0516q<Timestamp>(this) {
                final /* synthetic */ AnonymousClass11 f539b;

                public Timestamp m1030a(C0527a c0527a) {
                    Date date = (Date) a.mo804b(c0527a);
                    return date != null ? new Timestamp(date.getTime()) : null;
                }

                public void m1032a(C0530d c0530d, Timestamp timestamp) {
                    a.mo803a(c0530d, timestamp);
                }

                public /* synthetic */ Object mo804b(C0527a c0527a) {
                    return m1030a(c0527a);
                }
            };
        }
    };
    public static final C0516q<Calendar> f563K = new C0516q<Calendar>() {
        public Calendar m1039a(C0527a c0527a) {
            int i = 0;
            if (c0527a.mo811f() == C0600c.NULL) {
                c0527a.mo815j();
                return null;
            }
            c0527a.mo807c();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (c0527a.mo811f() != C0600c.END_OBJECT) {
                String g = c0527a.mo812g();
                int m = c0527a.mo818m();
                if ("year".equals(g)) {
                    i6 = m;
                } else if ("month".equals(g)) {
                    i5 = m;
                } else if ("dayOfMonth".equals(g)) {
                    i4 = m;
                } else if ("hourOfDay".equals(g)) {
                    i3 = m;
                } else if ("minute".equals(g)) {
                    i2 = m;
                } else if ("second".equals(g)) {
                    i = m;
                }
            }
            c0527a.mo809d();
            return new GregorianCalendar(i6, i5, i4, i3, i2, i);
        }

        public void m1041a(C0530d c0530d, Calendar calendar) {
            if (calendar == null) {
                c0530d.mo832f();
                return;
            }
            c0530d.mo830d();
            c0530d.mo823a("year");
            c0530d.mo821a((long) calendar.get(1));
            c0530d.mo823a("month");
            c0530d.mo821a((long) calendar.get(2));
            c0530d.mo823a("dayOfMonth");
            c0530d.mo821a((long) calendar.get(5));
            c0530d.mo823a("hourOfDay");
            c0530d.mo821a((long) calendar.get(11));
            c0530d.mo823a("minute");
            c0530d.mo821a((long) calendar.get(12));
            c0530d.mo823a("second");
            c0530d.mo821a((long) calendar.get(13));
            c0530d.mo831e();
        }

        public /* synthetic */ Object mo804b(C0527a c0527a) {
            return m1039a(c0527a);
        }
    };
    public static final C0514a f564L = C0564s.m1128b(Calendar.class, GregorianCalendar.class, f563K);
    public static final C0516q<Locale> f565M = new C0516q<Locale>() {
        public Locale m1043a(C0527a c0527a) {
            if (c0527a.mo811f() == C0600c.NULL) {
                c0527a.mo815j();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(c0527a.mo813h(), "_");
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            return (nextToken2 == null && nextToken3 == null) ? new Locale(nextToken) : nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
        }

        public void m1045a(C0530d c0530d, Locale locale) {
            c0530d.mo827b(locale == null ? null : locale.toString());
        }

        public /* synthetic */ Object mo804b(C0527a c0527a) {
            return m1043a(c0527a);
        }
    };
    public static final C0514a f566N = C0564s.m1125a(Locale.class, f565M);
    public static final C0516q<C0623s> f567O = new C0516q<C0623s>() {
        public C0623s m1047a(C0527a c0527a) {
            C0623s c0624p;
            switch (c0527a.mo811f()) {
                case NUMBER:
                    return new C0628x(new C0580d(c0527a.mo813h()));
                case BOOLEAN:
                    return new C0628x(Boolean.valueOf(c0527a.mo814i()));
                case STRING:
                    return new C0628x(c0527a.mo813h());
                case NULL:
                    c0527a.mo815j();
                    return C0626u.f737a;
                case BEGIN_ARRAY:
                    c0624p = new C0624p();
                    c0527a.mo805a();
                    while (c0527a.mo810e()) {
                        c0624p.m1281a(m1047a(c0527a));
                    }
                    c0527a.mo806b();
                    return c0624p;
                case BEGIN_OBJECT:
                    c0624p = new C0627v();
                    c0527a.mo807c();
                    while (c0527a.mo810e()) {
                        c0624p.m1287a(c0527a.mo812g(), m1047a(c0527a));
                    }
                    c0527a.mo809d();
                    return c0624p;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public void m1048a(C0530d c0530d, C0623s c0623s) {
            if (c0623s == null || c0623s.m1275j()) {
                c0530d.mo832f();
            } else if (c0623s.m1274i()) {
                C0628x m = c0623s.m1278m();
                if (m.m1300p()) {
                    c0530d.mo822a(m.mo843a());
                } else if (m.m1299o()) {
                    c0530d.mo824a(m.mo848f());
                } else {
                    c0530d.mo827b(m.mo844b());
                }
            } else if (c0623s.m1272g()) {
                c0530d.mo826b();
                Iterator it = c0623s.m1277l().iterator();
                while (it.hasNext()) {
                    m1048a(c0530d, (C0623s) it.next());
                }
                c0530d.mo828c();
            } else if (c0623s.m1273h()) {
                c0530d.mo830d();
                for (Entry entry : c0623s.m1276k().m1288o()) {
                    c0530d.mo823a((String) entry.getKey());
                    m1048a(c0530d, (C0623s) entry.getValue());
                }
                c0530d.mo831e();
            } else {
                throw new IllegalArgumentException("Couldn't write " + c0623s.getClass());
            }
        }

        public /* synthetic */ Object mo804b(C0527a c0527a) {
            return m1047a(c0527a);
        }
    };
    public static final C0514a f568P = C0564s.m1125a(C0623s.class, f567O);
    public static final C0514a f569Q = C0564s.m1124a(Enum.class);
    public static final C0516q<BitSet> f570a = new C05541();
    public static final C0514a f571b = C0564s.m1125a(BitSet.class, f570a);
    public static final C0516q<Boolean> f572c = new C0516q<Boolean>() {
        public Boolean m1035a(C0527a c0527a) {
            if (c0527a.mo811f() != C0600c.NULL) {
                return c0527a.mo811f() == C0600c.STRING ? Boolean.valueOf(Boolean.parseBoolean(c0527a.mo813h())) : Boolean.valueOf(c0527a.mo814i());
            } else {
                c0527a.mo815j();
                return null;
            }
        }

        public void m1036a(C0530d c0530d, Boolean bool) {
            if (bool == null) {
                c0530d.mo832f();
            } else {
                c0530d.mo824a(bool.booleanValue());
            }
        }

        public /* synthetic */ Object mo804b(C0527a c0527a) {
            return m1035a(c0527a);
        }
    };
    public static final C0516q<Boolean> f573d = new C0516q<Boolean>() {
        public Boolean m1060a(C0527a c0527a) {
            if (c0527a.mo811f() != C0600c.NULL) {
                return Boolean.valueOf(c0527a.mo813h());
            }
            c0527a.mo815j();
            return null;
        }

        public void m1061a(C0530d c0530d, Boolean bool) {
            c0530d.mo827b(bool == null ? "null" : bool.toString());
        }

        public /* synthetic */ Object mo804b(C0527a c0527a) {
            return m1060a(c0527a);
        }
    };
    public static final C0514a f574e = C0564s.m1126a(Boolean.TYPE, Boolean.class, f572c);
    public static final C0516q<Number> f575f = new C0516q<Number>() {
        public Number m1064a(C0527a c0527a) {
            if (c0527a.mo811f() == C0600c.NULL) {
                c0527a.mo815j();
                return null;
            }
            try {
                return Byte.valueOf((byte) c0527a.mo818m());
            } catch (Throwable e) {
                throw new aa(e);
            }
        }

        public void m1065a(C0530d c0530d, Number number) {
            c0530d.mo822a(number);
        }

        public /* synthetic */ Object mo804b(C0527a c0527a) {
            return m1064a(c0527a);
        }
    };
    public static final C0514a f576g = C0564s.m1126a(Byte.TYPE, Byte.class, f575f);
    public static final C0516q<Number> f577h = new C0516q<Number>() {
        public Number m1068a(C0527a c0527a) {
            if (c0527a.mo811f() == C0600c.NULL) {
                c0527a.mo815j();
                return null;
            }
            try {
                return Short.valueOf((short) c0527a.mo818m());
            } catch (Throwable e) {
                throw new aa(e);
            }
        }

        public void m1069a(C0530d c0530d, Number number) {
            c0530d.mo822a(number);
        }

        public /* synthetic */ Object mo804b(C0527a c0527a) {
            return m1068a(c0527a);
        }
    };
    public static final C0514a f578i = C0564s.m1126a(Short.TYPE, Short.class, f577h);
    public static final C0516q<Number> f579j = new C0516q<Number>() {
        public Number m1072a(C0527a c0527a) {
            if (c0527a.mo811f() == C0600c.NULL) {
                c0527a.mo815j();
                return null;
            }
            try {
                return Integer.valueOf(c0527a.mo818m());
            } catch (Throwable e) {
                throw new aa(e);
            }
        }

        public void m1073a(C0530d c0530d, Number number) {
            c0530d.mo822a(number);
        }

        public /* synthetic */ Object mo804b(C0527a c0527a) {
            return m1072a(c0527a);
        }
    };
    public static final C0514a f580k = C0564s.m1126a(Integer.TYPE, Integer.class, f579j);
    public static final C0516q<Number> f581l = new C0516q<Number>() {
        public Number m1076a(C0527a c0527a) {
            if (c0527a.mo811f() == C0600c.NULL) {
                c0527a.mo815j();
                return null;
            }
            try {
                return Long.valueOf(c0527a.mo817l());
            } catch (Throwable e) {
                throw new aa(e);
            }
        }

        public void m1077a(C0530d c0530d, Number number) {
            c0530d.mo822a(number);
        }

        public /* synthetic */ Object mo804b(C0527a c0527a) {
            return m1076a(c0527a);
        }
    };
    public static final C0514a f582m = C0564s.m1126a(Long.TYPE, Long.class, f581l);
    public static final C0516q<Number> f583n = new C0516q<Number>() {
        public Number m1080a(C0527a c0527a) {
            if (c0527a.mo811f() != C0600c.NULL) {
                return Float.valueOf((float) c0527a.mo816k());
            }
            c0527a.mo815j();
            return null;
        }

        public void m1081a(C0530d c0530d, Number number) {
            c0530d.mo822a(number);
        }

        public /* synthetic */ Object mo804b(C0527a c0527a) {
            return m1080a(c0527a);
        }
    };
    public static final C0514a f584o = C0564s.m1126a(Float.TYPE, Float.class, f583n);
    public static final C0516q<Number> f585p = new C0516q<Number>() {
        public Number m1084a(C0527a c0527a) {
            if (c0527a.mo811f() != C0600c.NULL) {
                return Double.valueOf(c0527a.mo816k());
            }
            c0527a.mo815j();
            return null;
        }

        public void m1085a(C0530d c0530d, Number number) {
            c0530d.mo822a(number);
        }

        public /* synthetic */ Object mo804b(C0527a c0527a) {
            return m1084a(c0527a);
        }
    };
    public static final C0514a f586q = C0564s.m1126a(Double.TYPE, Double.class, f585p);
    public static final C0516q<Number> f587r = new C05552();
    public static final C0514a f588s = C0564s.m1125a(Number.class, f587r);
    public static final C0516q<Character> f589t = new C05563();
    public static final C0514a f590u = C0564s.m1126a(Character.TYPE, Character.class, f589t);
    public static final C0516q<String> f591v = new C05574();
    public static final C0514a f592w = C0564s.m1125a(String.class, f591v);
    public static final C0516q<StringBuilder> f593x = new C05585();
    public static final C0514a f594y = C0564s.m1125a(StringBuilder.class, f593x);
    public static final C0516q<StringBuffer> f595z = new C05596();

    static class C05541 extends C0516q<BitSet> {
        C05541() {
        }

        public BitSet m1055a(C0527a c0527a) {
            if (c0527a.mo811f() == C0600c.NULL) {
                c0527a.mo815j();
                return null;
            }
            BitSet bitSet = new BitSet();
            c0527a.mo805a();
            C0600c f = c0527a.mo811f();
            int i = 0;
            while (f != C0600c.END_ARRAY) {
                boolean z;
                switch (f) {
                    case NUMBER:
                        if (c0527a.mo818m() == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case BOOLEAN:
                        z = c0527a.mo814i();
                        break;
                    case STRING:
                        String h = c0527a.mo813h();
                        try {
                            if (Integer.parseInt(h) == 0) {
                                z = false;
                                break;
                            }
                            z = true;
                            break;
                        } catch (NumberFormatException e) {
                            throw new aa("Error: Expecting: bitset number value (1, 0), Found: " + h);
                        }
                    default:
                        throw new aa("Invalid bitset value type: " + f);
                }
                if (z) {
                    bitSet.set(i);
                }
                i++;
                f = c0527a.mo811f();
            }
            c0527a.mo806b();
            return bitSet;
        }

        public void m1057a(C0530d c0530d, BitSet bitSet) {
            if (bitSet == null) {
                c0530d.mo832f();
                return;
            }
            c0530d.mo826b();
            for (int i = 0; i < bitSet.length(); i++) {
                c0530d.mo821a((long) (bitSet.get(i) ? 1 : 0));
            }
            c0530d.mo828c();
        }

        public /* synthetic */ Object mo804b(C0527a c0527a) {
            return m1055a(c0527a);
        }
    }

    static class C05552 extends C0516q<Number> {
        C05552() {
        }

        public Number m1088a(C0527a c0527a) {
            C0600c f = c0527a.mo811f();
            switch (f) {
                case NUMBER:
                    return new C0580d(c0527a.mo813h());
                case NULL:
                    c0527a.mo815j();
                    return null;
                default:
                    throw new aa("Expecting number, got: " + f);
            }
        }

        public void m1089a(C0530d c0530d, Number number) {
            c0530d.mo822a(number);
        }

        public /* synthetic */ Object mo804b(C0527a c0527a) {
            return m1088a(c0527a);
        }
    }

    static class C05563 extends C0516q<Character> {
        C05563() {
        }

        public Character m1092a(C0527a c0527a) {
            if (c0527a.mo811f() != C0600c.NULL) {
                return Character.valueOf(c0527a.mo813h().charAt(0));
            }
            c0527a.mo815j();
            return null;
        }

        public void m1093a(C0530d c0530d, Character ch) {
            c0530d.mo827b(ch == null ? null : String.valueOf(ch));
        }

        public /* synthetic */ Object mo804b(C0527a c0527a) {
            return m1092a(c0527a);
        }
    }

    static class C05574 extends C0516q<String> {
        C05574() {
        }

        public String m1096a(C0527a c0527a) {
            C0600c f = c0527a.mo811f();
            if (f != C0600c.NULL) {
                return f == C0600c.BOOLEAN ? Boolean.toString(c0527a.mo814i()) : c0527a.mo813h();
            } else {
                c0527a.mo815j();
                return null;
            }
        }

        public void m1098a(C0530d c0530d, String str) {
            c0530d.mo827b(str);
        }

        public /* synthetic */ Object mo804b(C0527a c0527a) {
            return m1096a(c0527a);
        }
    }

    static class C05585 extends C0516q<StringBuilder> {
        C05585() {
        }

        public StringBuilder m1100a(C0527a c0527a) {
            if (c0527a.mo811f() != C0600c.NULL) {
                return new StringBuilder(c0527a.mo813h());
            }
            c0527a.mo815j();
            return null;
        }

        public void m1102a(C0530d c0530d, StringBuilder stringBuilder) {
            c0530d.mo827b(stringBuilder == null ? null : stringBuilder.toString());
        }

        public /* synthetic */ Object mo804b(C0527a c0527a) {
            return m1100a(c0527a);
        }
    }

    static class C05596 extends C0516q<StringBuffer> {
        C05596() {
        }

        public StringBuffer m1104a(C0527a c0527a) {
            if (c0527a.mo811f() != C0600c.NULL) {
                return new StringBuffer(c0527a.mo813h());
            }
            c0527a.mo815j();
            return null;
        }

        public void m1106a(C0530d c0530d, StringBuffer stringBuffer) {
            c0530d.mo827b(stringBuffer == null ? null : stringBuffer.toString());
        }

        public /* synthetic */ Object mo804b(C0527a c0527a) {
            return m1104a(c0527a);
        }
    }

    static class C05607 extends C0516q<URL> {
        C05607() {
        }

        public URL m1108a(C0527a c0527a) {
            if (c0527a.mo811f() == C0600c.NULL) {
                c0527a.mo815j();
                return null;
            }
            String h = c0527a.mo813h();
            return !"null".equals(h) ? new URL(h) : null;
        }

        public void m1110a(C0530d c0530d, URL url) {
            c0530d.mo827b(url == null ? null : url.toExternalForm());
        }

        public /* synthetic */ Object mo804b(C0527a c0527a) {
            return m1108a(c0527a);
        }
    }

    static class C05618 extends C0516q<URI> {
        C05618() {
        }

        public URI m1112a(C0527a c0527a) {
            URI uri = null;
            if (c0527a.mo811f() == C0600c.NULL) {
                c0527a.mo815j();
            } else {
                try {
                    String h = c0527a.mo813h();
                    if (!"null".equals(h)) {
                        uri = new URI(h);
                    }
                } catch (Throwable e) {
                    throw new C0625t(e);
                }
            }
            return uri;
        }

        public void m1114a(C0530d c0530d, URI uri) {
            c0530d.mo827b(uri == null ? null : uri.toASCIIString());
        }

        public /* synthetic */ Object mo804b(C0527a c0527a) {
            return m1112a(c0527a);
        }
    }

    static class C05629 extends C0516q<InetAddress> {
        C05629() {
        }

        public InetAddress m1116a(C0527a c0527a) {
            if (c0527a.mo811f() != C0600c.NULL) {
                return InetAddress.getByName(c0527a.mo813h());
            }
            c0527a.mo815j();
            return null;
        }

        public void m1118a(C0530d c0530d, InetAddress inetAddress) {
            c0530d.mo827b(inetAddress == null ? null : inetAddress.getHostAddress());
        }

        public /* synthetic */ Object mo804b(C0527a c0527a) {
            return m1116a(c0527a);
        }
    }

    private static final class C0563a<T extends Enum<T>> extends C0516q<T> {
        private final Class<T> f552a;

        public C0563a(Class<T> cls) {
            this.f552a = cls;
        }

        public T m1120a(C0527a c0527a) {
            if (c0527a.mo811f() != C0600c.NULL) {
                return Enum.valueOf(this.f552a, c0527a.mo813h());
            }
            c0527a.mo815j();
            return null;
        }

        public void m1121a(C0530d c0530d, T t) {
            c0530d.mo827b(t == null ? null : t.name());
        }

        public /* synthetic */ Object mo804b(C0527a c0527a) {
            return m1120a(c0527a);
        }
    }

    public static <TT> C0514a m1124a(final Class<TT> cls) {
        return new C0514a() {
            public <T> C0516q<T> mo802a(C0537j c0537j, C0596a<T> c0596a) {
                Class a = c0596a.m1197a();
                return cls.isAssignableFrom(a) ? new C0563a(a) : null;
            }
        };
    }

    public static <TT> C0514a m1125a(final Class<TT> cls, final C0516q<TT> c0516q) {
        return new C0514a() {
            public <T> C0516q<T> mo802a(C0537j c0537j, C0596a<T> c0596a) {
                return c0596a.m1197a() == cls ? c0516q : null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + c0516q + "]";
            }
        };
    }

    public static <TT> C0514a m1126a(final Class<TT> cls, final Class<TT> cls2, final C0516q<? super TT> c0516q) {
        return new C0514a() {
            public <T> C0516q<T> mo802a(C0537j c0537j, C0596a<T> c0596a) {
                Class a = c0596a.m1197a();
                return (a == cls || a == cls2) ? c0516q : null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + c0516q + "]";
            }
        };
    }

    public static <TT> C0514a m1127b(final Class<TT> cls, final C0516q<TT> c0516q) {
        return new C0514a() {
            public <T> C0516q<T> mo802a(C0537j c0537j, C0596a<T> c0596a) {
                return cls.isAssignableFrom(c0596a.m1197a()) ? c0516q : null;
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + c0516q + "]";
            }
        };
    }

    public static <TT> C0514a m1128b(final Class<TT> cls, final Class<? extends TT> cls2, final C0516q<? super TT> c0516q) {
        return new C0514a() {
            public <T> C0516q<T> mo802a(C0537j c0537j, C0596a<T> c0596a) {
                Class a = c0596a.m1197a();
                return (a == cls || a == cls2) ? c0516q : null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + c0516q + "]";
            }
        };
    }
}
