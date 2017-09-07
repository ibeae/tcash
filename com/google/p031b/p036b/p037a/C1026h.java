package com.google.p031b.p036b.p037a;

public final class C1026h extends C1019q {
    private final String f2106a;
    private final String f2107b;
    private final String f2108c;
    private final String f2109d;

    C1026h(String str, String str2, String str3, String str4) {
        super(C1035r.EMAIL_ADDRESS);
        this.f2106a = str;
        this.f2107b = str2;
        this.f2108c = str3;
        this.f2109d = str4;
    }

    public String mo1417a() {
        StringBuilder stringBuilder = new StringBuilder(30);
        C1019q.m3706a(this.f2106a, stringBuilder);
        C1019q.m3706a(this.f2107b, stringBuilder);
        C1019q.m3706a(this.f2108c, stringBuilder);
        return stringBuilder.toString();
    }
}
