package com.google.p031b.p036b.p037a;

public final class C1031m extends C1019q {
    private final double f2126a;
    private final double f2127b;
    private final double f2128c;
    private final String f2129d;

    C1031m(double d, double d2, double d3, String str) {
        super(C1035r.GEO);
        this.f2126a = d;
        this.f2127b = d2;
        this.f2128c = d3;
        this.f2129d = str;
    }

    public String mo1417a() {
        StringBuilder stringBuilder = new StringBuilder(20);
        stringBuilder.append(this.f2126a);
        stringBuilder.append(", ");
        stringBuilder.append(this.f2127b);
        if (this.f2128c > 0.0d) {
            stringBuilder.append(", ");
            stringBuilder.append(this.f2128c);
            stringBuilder.append('m');
        }
        if (this.f2129d != null) {
            stringBuilder.append(" (");
            stringBuilder.append(this.f2129d);
            stringBuilder.append(')');
        }
        return stringBuilder.toString();
    }
}
