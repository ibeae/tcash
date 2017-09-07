package com.google.android.gms.internal;

import android.content.Intent;

public class bv {
    private final String f1080a;

    public bv(String str) {
        this.f1080a = str;
    }

    public String m1796a() {
        return dk.m2084d();
    }

    public boolean m1797a(String str, int i, Intent intent) {
        if (str == null || intent == null) {
            return false;
        }
        String b = bu.m1793b(intent);
        String c = bu.m1795c(intent);
        if (b == null || c == null) {
            return false;
        }
        if (!str.equals(bu.m1792a(b))) {
            dq.m2120e("Developer payload not match.");
            return false;
        } else if (this.f1080a == null || bw.m1799a(this.f1080a, b, c)) {
            return true;
        } else {
            dq.m2120e("Fail to verify signature.");
            return false;
        }
    }
}
