package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class dd {
    public static final String f1298a = f1299c.f1300b;
    private static final dd f1299c = new dd();
    public final String f1300b = dk.m2084d();
    private final Object f1301d = new Object();
    private final de f1302e = new de(this.f1300b);
    private BigInteger f1303f = BigInteger.ONE;
    private final HashSet<dc> f1304g = new HashSet();
    private final HashMap<String, dg> f1305h = new HashMap();
    private boolean f1306i = false;

    private dd() {
    }

    public static Bundle m2032a(Context context, df dfVar, String str) {
        return f1299c.m2040b(context, dfVar, str);
    }

    public static dd m2033a() {
        return f1299c;
    }

    public static void m2034a(HashSet<dc> hashSet) {
        f1299c.m2041b(hashSet);
    }

    public static String m2035b() {
        return f1299c.m2042c();
    }

    public static de m2036d() {
        return f1299c.m2043e();
    }

    public static boolean m2037f() {
        return f1299c.m2044g();
    }

    public void m2038a(dc dcVar) {
        synchronized (this.f1301d) {
            this.f1304g.add(dcVar);
        }
    }

    public void m2039a(String str, dg dgVar) {
        synchronized (this.f1301d) {
            this.f1305h.put(str, dgVar);
        }
    }

    public Bundle m2040b(Context context, df dfVar, String str) {
        Bundle bundle;
        synchronized (this.f1301d) {
            bundle = new Bundle();
            bundle.putBundle("app", this.f1302e.m2047a(context, str));
            Bundle bundle2 = new Bundle();
            for (String str2 : this.f1305h.keySet()) {
                bundle2.putBundle(str2, ((dg) this.f1305h.get(str2)).m2052a());
            }
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f1304g.iterator();
            while (it.hasNext()) {
                arrayList.add(((dc) it.next()).m2031d());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            dfVar.mo1081a(this.f1304g);
            this.f1304g.clear();
        }
        return bundle;
    }

    public void m2041b(HashSet<dc> hashSet) {
        synchronized (this.f1301d) {
            this.f1304g.addAll(hashSet);
        }
    }

    public String m2042c() {
        String bigInteger;
        synchronized (this.f1301d) {
            bigInteger = this.f1303f.toString();
            this.f1303f = this.f1303f.add(BigInteger.ONE);
        }
        return bigInteger;
    }

    public de m2043e() {
        de deVar;
        synchronized (this.f1301d) {
            deVar = this.f1302e;
        }
        return deVar;
    }

    public boolean m2044g() {
        boolean z;
        synchronized (this.f1301d) {
            z = this.f1306i;
            this.f1306i = true;
        }
        return z;
    }
}
