package com.google.p031b.p045f.p046a.p047a.p048a;

import com.google.p031b.p034c.C1046a;

public abstract class C1085j {
    private final C1046a f2307a;
    private final C1104s f2308b;

    C1085j(C1046a c1046a) {
        this.f2307a = c1046a;
        this.f2308b = new C1104s(c1046a);
    }

    public static C1085j m3971a(C1046a c1046a) {
        if (c1046a.m3807a(1)) {
            return new C1094g(c1046a);
        }
        if (!c1046a.m3807a(2)) {
            return new C1095k(c1046a);
        }
        switch (C1104s.m4017a(c1046a, 1, 4)) {
            case 4:
                return new C1089a(c1046a);
            case 5:
                return new C1090b(c1046a);
            default:
                switch (C1104s.m4017a(c1046a, 1, 5)) {
                    case 12:
                        return new C1091c(c1046a);
                    case 13:
                        return new C1092d(c1046a);
                    default:
                        switch (C1104s.m4017a(c1046a, 1, 7)) {
                            case 56:
                                return new C1093e(c1046a, "310", "11");
                            case 57:
                                return new C1093e(c1046a, "320", "11");
                            case 58:
                                return new C1093e(c1046a, "310", "13");
                            case 59:
                                return new C1093e(c1046a, "320", "13");
                            case 60:
                                return new C1093e(c1046a, "310", "15");
                            case 61:
                                return new C1093e(c1046a, "320", "15");
                            case 62:
                                return new C1093e(c1046a, "310", "17");
                            case 63:
                                return new C1093e(c1046a, "320", "17");
                            default:
                                throw new IllegalStateException("unknown decoder: " + c1046a);
                        }
                }
        }
    }

    public abstract String mo1424a();

    protected final C1046a m3973b() {
        return this.f2307a;
    }

    protected final C1104s m3974c() {
        return this.f2308b;
    }
}
