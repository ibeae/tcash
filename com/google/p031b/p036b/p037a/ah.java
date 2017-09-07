package com.google.p031b.p036b.p037a;

public final class ah extends C1019q {
    private final String f2070a;
    private final String f2071b;
    private final String f2072c;
    private final boolean f2073d;

    public ah(String str, String str2, String str3, boolean z) {
        super(C1035r.WIFI);
        this.f2070a = str2;
        this.f2071b = str;
        this.f2072c = str3;
        this.f2073d = z;
    }

    public String mo1417a() {
        StringBuilder stringBuilder = new StringBuilder(80);
        C1019q.m3706a(this.f2070a, stringBuilder);
        C1019q.m3706a(this.f2071b, stringBuilder);
        C1019q.m3706a(this.f2072c, stringBuilder);
        C1019q.m3706a(Boolean.toString(this.f2073d), stringBuilder);
        return stringBuilder.toString();
    }
}
