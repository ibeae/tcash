package com.google.p031b.p036b.p037a;

import java.util.Map;

public final class C1029k extends C1019q {
    private final String f2111a;
    private final String f2112b;
    private final String f2113c;
    private final String f2114d;
    private final String f2115e;
    private final String f2116f;
    private final String f2117g;
    private final String f2118h;
    private final String f2119i;
    private final String f2120j;
    private final String f2121k;
    private final String f2122l;
    private final String f2123m;
    private final String f2124n;
    private final Map<String, String> f2125o;

    public C1029k(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, String> map) {
        super(C1035r.PRODUCT);
        this.f2111a = str;
        this.f2112b = str2;
        this.f2113c = str3;
        this.f2114d = str4;
        this.f2115e = str5;
        this.f2116f = str6;
        this.f2117g = str7;
        this.f2118h = str8;
        this.f2119i = str9;
        this.f2120j = str10;
        this.f2121k = str11;
        this.f2122l = str12;
        this.f2123m = str13;
        this.f2124n = str14;
        this.f2125o = map;
    }

    private static int m3762a(Object obj) {
        return obj == null ? 0 : obj.hashCode();
    }

    private static boolean m3763a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public String mo1417a() {
        return String.valueOf(this.f2111a);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1029k)) {
            return false;
        }
        C1029k c1029k = (C1029k) obj;
        return C1029k.m3763a(this.f2112b, c1029k.f2112b) && C1029k.m3763a(this.f2113c, c1029k.f2113c) && C1029k.m3763a(this.f2114d, c1029k.f2114d) && C1029k.m3763a(this.f2115e, c1029k.f2115e) && C1029k.m3763a(this.f2117g, c1029k.f2117g) && C1029k.m3763a(this.f2118h, c1029k.f2118h) && C1029k.m3763a(this.f2119i, c1029k.f2119i) && C1029k.m3763a(this.f2120j, c1029k.f2120j) && C1029k.m3763a(this.f2121k, c1029k.f2121k) && C1029k.m3763a(this.f2122l, c1029k.f2122l) && C1029k.m3763a(this.f2123m, c1029k.f2123m) && C1029k.m3763a(this.f2124n, c1029k.f2124n) && C1029k.m3763a(this.f2125o, c1029k.f2125o);
    }

    public int hashCode() {
        return ((((((((((((0 ^ C1029k.m3762a(this.f2112b)) ^ C1029k.m3762a(this.f2113c)) ^ C1029k.m3762a(this.f2114d)) ^ C1029k.m3762a(this.f2115e)) ^ C1029k.m3762a(this.f2117g)) ^ C1029k.m3762a(this.f2118h)) ^ C1029k.m3762a(this.f2119i)) ^ C1029k.m3762a(this.f2120j)) ^ C1029k.m3762a(this.f2121k)) ^ C1029k.m3762a(this.f2122l)) ^ C1029k.m3762a(this.f2123m)) ^ C1029k.m3762a(this.f2124n)) ^ C1029k.m3762a(this.f2125o);
    }
}
