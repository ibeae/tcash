package com.google.android.gms.internal;

import java.util.Map;

public final class C0844x implements aa {
    private final C0817y f1802a;

    public C0844x(C0817y c0817y) {
        this.f1802a = c0817y;
    }

    public void mo874a(dt dtVar, Map<String, String> map) {
        String str = (String) map.get("name");
        if (str == null) {
            dq.m2120e("App event with no name parameter.");
        } else {
            this.f1802a.mo1079a(str, (String) map.get("info"));
        }
    }
}
