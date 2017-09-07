package com.google.p031b.p036b.p037a;

public final class C1042z extends C1019q {
    private final String f2150a;
    private final String f2151b;
    private final String f2152c;

    public C1042z(String str, String str2, String str3) {
        super(C1035r.TEL);
        this.f2150a = str;
        this.f2151b = str2;
        this.f2152c = str3;
    }

    public String mo1417a() {
        StringBuilder stringBuilder = new StringBuilder(20);
        C1019q.m3706a(this.f2150a, stringBuilder);
        C1019q.m3706a(this.f2152c, stringBuilder);
        return stringBuilder.toString();
    }
}
