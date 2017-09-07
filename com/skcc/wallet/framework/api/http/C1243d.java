package com.skcc.wallet.framework.api.http;

public class C1243d {
    private String f2653a;
    private String f2654b;
    private String f2655c;

    public C1243d(String str, String str2) {
        this.f2653a = str;
        this.f2654b = str2;
    }

    public String m4573a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{\"");
        stringBuffer.append(this.f2654b);
        stringBuffer.append("\":");
        stringBuffer.append(this.f2655c);
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    public void m4574a(String str) {
        this.f2655c = str;
    }

    public String m4575b() {
        return this.f2653a;
    }
}
