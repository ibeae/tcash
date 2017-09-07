package com.google.android.gms.internal;

import android.os.Bundle;

public class dg {
    private final Object f1314a;
    private int f1315b;
    private int f1316c;
    private final dd f1317d;
    private final String f1318e;

    dg(dd ddVar, String str) {
        this.f1314a = new Object();
        this.f1317d = ddVar;
        this.f1318e = str;
    }

    public dg(String str) {
        this(dd.m2033a(), str);
    }

    public Bundle m2052a() {
        Bundle bundle;
        synchronized (this.f1314a) {
            bundle = new Bundle();
            bundle.putInt("pmnli", this.f1315b);
            bundle.putInt("pmnll", this.f1316c);
        }
        return bundle;
    }

    public void m2053a(int i, int i2) {
        synchronized (this.f1314a) {
            this.f1315b = i;
            this.f1316c = i2;
            this.f1317d.m2039a(this.f1318e, this);
        }
    }
}
