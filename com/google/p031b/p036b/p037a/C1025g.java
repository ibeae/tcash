package com.google.p031b.p036b.p037a;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class C1025g extends C1019q {
    private static final Pattern f2090a = Pattern.compile("P(?:(\\d+)W)?(?:(\\d+)D)?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+)S)?)?");
    private static final long[] f2091b = new long[]{604800000, 86400000, 3600000, 60000, 1000};
    private static final Pattern f2092c = Pattern.compile("[0-9]{8}(T[0-9]{6}Z?)?");
    private static final DateFormat f2093d = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
    private static final DateFormat f2094e = new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH);
    private final String f2095f;
    private final Date f2096g;
    private final boolean f2097h;
    private final Date f2098i;
    private final boolean f2099j;
    private final String f2100k;
    private final String f2101l;
    private final String[] f2102m;
    private final String f2103n;
    private final double f2104o;
    private final double f2105p;

    static {
        f2093d.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

    public C1025g(String str, String str2, String str3, String str4, String str5, String str6, String[] strArr, String str7, double d, double d2) {
        super(C1035r.CALENDAR);
        this.f2095f = str;
        try {
            this.f2096g = C1025g.m3754a(str2);
            if (str3 == null) {
                long a = C1025g.m3752a((CharSequence) str4);
                this.f2098i = a < 0 ? null : new Date(a + this.f2096g.getTime());
            } else {
                try {
                    this.f2098i = C1025g.m3754a(str3);
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e.toString());
                }
            }
            this.f2097h = str2.length() == 8;
            boolean z = str3 != null && str3.length() == 8;
            this.f2099j = z;
            this.f2100k = str5;
            this.f2101l = str6;
            this.f2102m = strArr;
            this.f2103n = str7;
            this.f2104o = d;
            this.f2105p = d2;
        } catch (ParseException e2) {
            throw new IllegalArgumentException(e2.toString());
        }
    }

    private static long m3752a(CharSequence charSequence) {
        long j = -1;
        if (charSequence != null) {
            Matcher matcher = f2090a.matcher(charSequence);
            if (matcher.matches()) {
                j = 0;
                for (int i = 0; i < f2091b.length; i++) {
                    String group = matcher.group(i + 1);
                    if (group != null) {
                        j += ((long) Integer.parseInt(group)) * f2091b[i];
                    }
                }
            }
        }
        return j;
    }

    private static String m3753a(boolean z, Date date) {
        if (date == null) {
            return null;
        }
        return (z ? DateFormat.getDateInstance(2) : DateFormat.getDateTimeInstance(2, 2)).format(date);
    }

    private static Date m3754a(String str) {
        if (!f2092c.matcher(str).matches()) {
            throw new ParseException(str, 0);
        } else if (str.length() == 8) {
            return f2093d.parse(str);
        } else {
            if (str.length() != 16 || str.charAt(15) != 'Z') {
                return f2094e.parse(str);
            }
            Date parse = f2094e.parse(str.substring(0, 15));
            Calendar gregorianCalendar = new GregorianCalendar();
            long time = parse.getTime() + ((long) gregorianCalendar.get(15));
            gregorianCalendar.setTime(new Date(time));
            return new Date(time + ((long) gregorianCalendar.get(16)));
        }
    }

    public String mo1417a() {
        StringBuilder stringBuilder = new StringBuilder(100);
        C1019q.m3706a(this.f2095f, stringBuilder);
        C1019q.m3706a(C1025g.m3753a(this.f2097h, this.f2096g), stringBuilder);
        C1019q.m3706a(C1025g.m3753a(this.f2099j, this.f2098i), stringBuilder);
        C1019q.m3706a(this.f2100k, stringBuilder);
        C1019q.m3706a(this.f2101l, stringBuilder);
        C1019q.m3707a(this.f2102m, stringBuilder);
        C1019q.m3706a(this.f2103n, stringBuilder);
        return stringBuilder.toString();
    }
}
