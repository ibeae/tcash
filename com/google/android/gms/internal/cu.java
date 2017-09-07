package com.google.android.gms.internal;

import java.util.Map;

public final class cu {
    public final aa f1210a = new C07401(this);
    public final aa f1211b = new C07412(this);
    private final Object f1212c = new Object();
    private dt f1213d;
    private String f1214e;
    private int f1215f = -2;
    private cx f1216g;

    class C07401 implements aa {
        final /* synthetic */ cu f1208a;

        C07401(cu cuVar) {
            this.f1208a = cuVar;
        }

        public void mo874a(dt dtVar, Map<String, String> map) {
            synchronized (this.f1208a.f1212c) {
                cx cxVar = new cx(map);
                dq.m2120e("Invalid " + cxVar.m2012d() + " request error: " + cxVar.m2009a());
                this.f1208a.f1215f = 1;
                this.f1208a.f1212c.notify();
            }
        }
    }

    class C07412 implements aa {
        final /* synthetic */ cu f1209a;

        C07412(cu cuVar) {
            this.f1209a = cuVar;
        }

        public void mo874a(dt dtVar, Map<String, String> map) {
            synchronized (this.f1209a.f1212c) {
                cx cxVar = new cx(map);
                String c = cxVar.m2011c();
                if (c == null) {
                    dq.m2120e("URL missing in loadAdUrl GMSG.");
                    return;
                }
                if (c.contains("%40mediation_adapters%40")) {
                    dq.m2119d("Ad request URL modified to " + c.replaceAll("%40mediation_adapters%40", dh.m2055a(dtVar.getContext(), (String) map.get("check_adapters"), this.f1209a.f1214e)));
                }
                this.f1209a.f1216g = cxVar;
                this.f1209a.f1212c.notify();
            }
        }
    }

    public cu(String str) {
        this.f1214e = str;
    }

    public int m1983a() {
        int i;
        synchronized (this.f1212c) {
            i = this.f1215f;
        }
        return i;
    }

    public void m1984a(dt dtVar) {
        synchronized (this.f1212c) {
            this.f1213d = dtVar;
        }
    }

    public cx m1985b() {
        cx cxVar;
        synchronized (this.f1212c) {
            while (this.f1216g == null && this.f1215f == -2) {
                try {
                    this.f1212c.wait();
                } catch (InterruptedException e) {
                    dq.m2120e("Ad request service was interrupted.");
                    cxVar = null;
                }
            }
            cxVar = this.f1216g;
        }
        return cxVar;
    }
}
