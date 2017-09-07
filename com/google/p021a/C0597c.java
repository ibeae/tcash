package com.google.p021a;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

final class C0597c {

    static final class C0595a implements C0593r<Date>, C0594z<Date> {
        private final DateFormat f637a;
        private final DateFormat f638b;
        private final DateFormat f639c;

        C0595a() {
            this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
        }

        public C0595a(int i, int i2) {
            this(DateFormat.getDateTimeInstance(i, i2, Locale.US), DateFormat.getDateTimeInstance(i, i2));
        }

        C0595a(String str) {
            this(new SimpleDateFormat(str, Locale.US), new SimpleDateFormat(str));
        }

        C0595a(DateFormat dateFormat, DateFormat dateFormat2) {
            this.f637a = dateFormat;
            this.f638b = dateFormat2;
            this.f639c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
            this.f639c.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        private Date m1189a(C0623s c0623s) {
            Date parse;
            synchronized (this.f638b) {
                try {
                    parse = this.f638b.parse(c0623s.mo844b());
                } catch (ParseException e) {
                    try {
                        parse = this.f637a.parse(c0623s.mo844b());
                    } catch (ParseException e2) {
                        try {
                            parse = this.f639c.parse(c0623s.mo844b());
                        } catch (Throwable e3) {
                            throw new aa(c0623s.mo844b(), e3);
                        }
                    }
                }
            }
            return parse;
        }

        public C0623s m1191a(Date date, Type type, C0616y c0616y) {
            C0623s c0628x;
            synchronized (this.f638b) {
                c0628x = new C0628x(this.f637a.format(date));
            }
            return c0628x;
        }

        public Date m1192a(C0623s c0623s, Type type, C0614q c0614q) {
            if (c0623s instanceof C0628x) {
                Date a = m1189a(c0623s);
                if (type == Date.class) {
                    return a;
                }
                if (type == Timestamp.class) {
                    return new Timestamp(a.getTime());
                }
                if (type == java.sql.Date.class) {
                    return new java.sql.Date(a.getTime());
                }
                throw new IllegalArgumentException(getClass() + " cannot deserialize to " + type);
            }
            throw new C0507w("The date should be a string value");
        }

        public /* synthetic */ Object mo838b(C0623s c0623s, Type type, C0614q c0614q) {
            return m1192a(c0623s, type, c0614q);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(C0595a.class.getSimpleName());
            stringBuilder.append('(').append(this.f638b.getClass().getSimpleName()).append(')');
            return stringBuilder.toString();
        }
    }
}
