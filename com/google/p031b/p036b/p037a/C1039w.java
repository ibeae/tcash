package com.google.p031b.p036b.p037a;

public final class C1039w extends C1019q {
    private final String[] f2146a;
    private final String[] f2147b;
    private final String f2148c;
    private final String f2149d;

    public C1039w(String str, String str2, String str3, String str4) {
        super(C1035r.SMS);
        this.f2146a = new String[]{str};
        this.f2147b = new String[]{str2};
        this.f2148c = str3;
        this.f2149d = str4;
    }

    public C1039w(String[] strArr, String[] strArr2, String str, String str2) {
        super(C1035r.SMS);
        this.f2146a = strArr;
        this.f2147b = strArr2;
        this.f2148c = str;
        this.f2149d = str2;
    }

    public String mo1417a() {
        StringBuilder stringBuilder = new StringBuilder(100);
        C1019q.m3707a(this.f2146a, stringBuilder);
        C1019q.m3706a(this.f2148c, stringBuilder);
        C1019q.m3706a(this.f2149d, stringBuilder);
        return stringBuilder.toString();
    }
}
