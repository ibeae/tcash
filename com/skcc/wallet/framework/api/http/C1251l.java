package com.skcc.wallet.framework.api.http;

public class C1251l extends Exception {
    private int f2662a;
    private String f2663b;
    private String f2664c;
    private Object f2665d;

    public C1251l(int i, String str, String str2, Object obj) {
        this.f2662a = i;
        this.f2664c = str2;
        this.f2663b = str;
        this.f2665d = obj;
    }

    public int m4586a() {
        return this.f2662a;
    }

    public String m4587b() {
        return this.f2663b;
    }

    public Object m4588c() {
        return this.f2665d;
    }

    public String getMessage() {
        return this.f2664c;
    }
}
