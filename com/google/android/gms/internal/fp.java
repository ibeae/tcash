package com.google.android.gms.internal;

import java.io.IOException;

class fp implements fn {
    private fk f1598a;
    private byte[] f1599b;
    private final int f1600c;

    public fp(int i) {
        this.f1600c = i;
        mo1064a();
    }

    public void mo1064a() {
        this.f1599b = new byte[this.f1600c];
        this.f1598a = fk.m2511a(this.f1599b);
    }

    public void mo1065a(int i, long j) {
        this.f1598a.m2517a(i, j);
    }

    public void mo1066a(int i, String str) {
        this.f1598a.m2518a(i, str);
    }

    public byte[] mo1067b() {
        int a = this.f1598a.m2513a();
        if (a < 0) {
            throw new IOException();
        } else if (a == 0) {
            return this.f1599b;
        } else {
            Object obj = new byte[(this.f1599b.length - a)];
            System.arraycopy(this.f1599b, 0, obj, 0, obj.length);
            return obj;
        }
    }
}
