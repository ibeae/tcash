package com.telkom.mwallet.coupon.p066b;

public class C1444a {
    private String f3334a;
    private C1443b f3335b;
    private String f3336c;
    private long f3337d;

    public static final class C1442a {
        private String f3320a;
        private C1443b f3321b;
        private String f3322c;
        private long f3323d;

        public C1442a m5454a(long j) {
            this.f3323d = j;
            return this;
        }

        public C1442a m5455a(C1443b c1443b) {
            this.f3321b = c1443b;
            return this;
        }

        public C1442a m5456a(String str) {
            this.f3320a = str;
            return this;
        }

        public C1444a m5457a() {
            return new C1444a(this);
        }

        public C1442a m5458b(String str) {
            this.f3322c = str;
            return this;
        }
    }

    public enum C1443b {
        URL,
        TEXT,
        SMS,
        EMAIL,
        CALENDAR,
        TASK,
        CONTACT,
        CALL,
        MOTILINK
    }

    public C1444a(C1442a c1442a) {
        m5462a(c1442a.f3320a);
        m5461a(c1442a.f3321b);
        m5464b(c1442a.f3322c);
        m5460a(c1442a.f3323d);
    }

    public String m5459a() {
        return this.f3334a;
    }

    public void m5460a(long j) {
        this.f3337d = j;
    }

    public void m5461a(C1443b c1443b) {
        this.f3335b = c1443b;
    }

    public void m5462a(String str) {
        this.f3334a = str;
    }

    public C1443b m5463b() {
        return this.f3335b;
    }

    public void m5464b(String str) {
        this.f3336c = str;
    }

    public String m5465c() {
        return this.f3336c;
    }

    public long m5466d() {
        return this.f3337d;
    }
}
