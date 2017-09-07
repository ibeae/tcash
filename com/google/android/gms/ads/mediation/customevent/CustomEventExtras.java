package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

@Deprecated
public final class CustomEventExtras implements NetworkExtras {
    private final HashMap<String, Object> f829a = new HashMap();

    public Object m1431a(String str) {
        return this.f829a.get(str);
    }
}
