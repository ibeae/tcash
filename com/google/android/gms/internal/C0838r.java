package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class C0838r {
    public static final String f1763a = dp.m2106a("emulator");
    private final Date f1764b;
    private final String f1765c;
    private final int f1766d;
    private final Set<String> f1767e;
    private final Location f1768f;
    private final boolean f1769g;
    private final Bundle f1770h;
    private final Map<Class<? extends Object>, Object> f1771i;
    private final String f1772j;
    private final SearchAdRequest f1773k;
    private final int f1774l;
    private final Set<String> f1775m;

    public static final class C0837a {
        private final HashSet<String> f1752a = new HashSet();
        private final Bundle f1753b = new Bundle();
        private final HashMap<Class<? extends Object>, Object> f1754c = new HashMap();
        private final HashSet<String> f1755d = new HashSet();
        private Date f1756e;
        private String f1757f;
        private int f1758g = -1;
        private Location f1759h;
        private boolean f1760i = false;
        private String f1761j;
        private int f1762k = -1;

        public void m2751a(int i) {
            this.f1758g = i;
        }

        public void m2752a(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.f1753b.putBundle(cls.getName(), bundle);
        }

        public void m2753a(String str) {
            this.f1752a.add(str);
        }

        public void m2754a(Date date) {
            this.f1756e = date;
        }

        public void m2755a(boolean z) {
            this.f1762k = z ? 1 : 0;
        }

        public void m2756b(String str) {
            this.f1755d.add(str);
        }
    }

    public C0838r(C0837a c0837a) {
        this(c0837a, null);
    }

    public C0838r(C0837a c0837a, SearchAdRequest searchAdRequest) {
        this.f1764b = c0837a.f1756e;
        this.f1765c = c0837a.f1757f;
        this.f1766d = c0837a.f1758g;
        this.f1767e = Collections.unmodifiableSet(c0837a.f1752a);
        this.f1768f = c0837a.f1759h;
        this.f1769g = c0837a.f1760i;
        this.f1770h = c0837a.f1753b;
        this.f1771i = Collections.unmodifiableMap(c0837a.f1754c);
        this.f1772j = c0837a.f1761j;
        this.f1773k = searchAdRequest;
        this.f1774l = c0837a.f1762k;
        this.f1775m = Collections.unmodifiableSet(c0837a.f1755d);
    }

    public Bundle m2757a(Class<? extends MediationAdapter> cls) {
        return this.f1770h.getBundle(cls.getName());
    }

    public Date m2758a() {
        return this.f1764b;
    }

    public boolean m2759a(Context context) {
        return this.f1775m.contains(dp.m2105a(context));
    }

    public String m2760b() {
        return this.f1765c;
    }

    public int m2761c() {
        return this.f1766d;
    }

    public Set<String> m2762d() {
        return this.f1767e;
    }

    public Location m2763e() {
        return this.f1768f;
    }

    public boolean m2764f() {
        return this.f1769g;
    }

    public String m2765g() {
        return this.f1772j;
    }

    public SearchAdRequest m2766h() {
        return this.f1773k;
    }

    public Map<Class<? extends Object>, Object> m2767i() {
        return this.f1771i;
    }

    public Bundle m2768j() {
        return this.f1770h;
    }

    public int m2769k() {
        return this.f1774l;
    }
}
