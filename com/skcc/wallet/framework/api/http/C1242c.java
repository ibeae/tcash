package com.skcc.wallet.framework.api.http;

public class C1242c {
    protected int f2649a = -1;
    protected String f2650b = "";
    protected String f2651c = "";
    protected String f2652d = "";

    public int m4565a() {
        return this.f2649a;
    }

    public void m4566a(int i) {
        this.f2649a = i;
    }

    public void m4567a(String str) {
        this.f2650b = str;
    }

    public String m4568b() {
        return this.f2650b;
    }

    public void m4569b(String str) {
        this.f2651c = str;
    }

    public String m4570c() {
        return this.f2651c;
    }

    public void m4571c(String str) {
        this.f2652d = str;
    }

    public String m4572d() {
        return this.f2652d;
    }

    public String toString() {
        return "httpCode::" + String.valueOf(this.f2649a) + ", httpMsg::" + this.f2650b + "\nres::" + this.f2651c + "\ncookie::" + this.f2652d + "\n";
    }
}
