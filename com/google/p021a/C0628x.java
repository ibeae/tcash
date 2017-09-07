package com.google.p021a;

import com.google.p021a.p023b.C0565a;
import com.google.p021a.p023b.C0580d;
import java.math.BigInteger;

public final class C0628x extends C0623s {
    private static final Class<?>[] f739a = new Class[]{Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    private Object f740b;

    public C0628x(Boolean bool) {
        m1292a((Object) bool);
    }

    public C0628x(Number number) {
        m1292a((Object) number);
    }

    public C0628x(String str) {
        m1292a((Object) str);
    }

    private static boolean m1289a(C0628x c0628x) {
        if (!(c0628x.f740b instanceof Number)) {
            return false;
        }
        Number number = (Number) c0628x.f740b;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    private static boolean m1290b(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class cls = obj.getClass();
        for (Class isAssignableFrom : f739a) {
            if (isAssignableFrom.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public Number mo843a() {
        return this.f740b instanceof String ? new C0580d((String) this.f740b) : (Number) this.f740b;
    }

    void m1292a(Object obj) {
        if (obj instanceof Character) {
            this.f740b = String.valueOf(((Character) obj).charValue());
            return;
        }
        boolean z = (obj instanceof Number) || C0628x.m1290b(obj);
        C0565a.m1130a(z);
        this.f740b = obj;
    }

    public String mo844b() {
        return m1300p() ? mo843a().toString() : m1299o() ? mo849n().toString() : (String) this.f740b;
    }

    public double mo845c() {
        return m1300p() ? mo843a().doubleValue() : Double.parseDouble(mo844b());
    }

    public long mo846d() {
        return m1300p() ? mo843a().longValue() : Long.parseLong(mo844b());
    }

    public int mo847e() {
        return m1300p() ? mo843a().intValue() : Integer.parseInt(mo844b());
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0628x c0628x = (C0628x) obj;
        if (this.f740b == null) {
            return c0628x.f740b == null;
        } else {
            if (C0628x.m1289a(this) && C0628x.m1289a(c0628x)) {
                return mo843a().longValue() == c0628x.mo843a().longValue();
            } else {
                if (!(this.f740b instanceof Number) || !(c0628x.f740b instanceof Number)) {
                    return this.f740b.equals(c0628x.f740b);
                }
                double doubleValue = mo843a().doubleValue();
                double doubleValue2 = c0628x.mo843a().doubleValue();
                if (doubleValue == doubleValue2 || (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2))) {
                    z = true;
                }
                return z;
            }
        }
    }

    public boolean mo848f() {
        return m1299o() ? mo849n().booleanValue() : Boolean.parseBoolean(mo844b());
    }

    public int hashCode() {
        if (this.f740b == null) {
            return 31;
        }
        long longValue;
        if (C0628x.m1289a(this)) {
            longValue = mo843a().longValue();
            return (int) (longValue ^ (longValue >>> 32));
        } else if (!(this.f740b instanceof Number)) {
            return this.f740b.hashCode();
        } else {
            longValue = Double.doubleToLongBits(mo843a().doubleValue());
            return (int) (longValue ^ (longValue >>> 32));
        }
    }

    Boolean mo849n() {
        return (Boolean) this.f740b;
    }

    public boolean m1299o() {
        return this.f740b instanceof Boolean;
    }

    public boolean m1300p() {
        return this.f740b instanceof Number;
    }

    public boolean m1301q() {
        return this.f740b instanceof String;
    }
}
