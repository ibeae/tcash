package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class C0825j {
    public static final C0825j f1644a = new C0825j();

    private C0825j() {
    }

    public static C0825j m2669a() {
        return f1644a;
    }

    public ai m2670a(Context context, C0838r c0838r) {
        Date a = c0838r.m2758a();
        long time = a != null ? a.getTime() : -1;
        String b = c0838r.m2760b();
        int c = c0838r.m2761c();
        Collection d = c0838r.m2762d();
        List unmodifiableList = !d.isEmpty() ? Collections.unmodifiableList(new ArrayList(d)) : null;
        boolean a2 = c0838r.m2759a(context);
        int k = c0838r.m2769k();
        Location e = c0838r.m2763e();
        Bundle a3 = c0838r.m2757a(AdMobAdapter.class);
        boolean f = c0838r.m2764f();
        String g = c0838r.m2765g();
        SearchAdRequest h = c0838r.m2766h();
        return new ai(4, time, a3, c, unmodifiableList, a2, k, f, g, h != null ? new aw(h) : null, e, b, c0838r.m2768j());
    }
}
