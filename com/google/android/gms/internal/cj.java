package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.ci.C0725a;
import com.google.android.gms.internal.cl.C0731a;
import com.google.android.gms.internal.ds.C0751a;
import com.google.android.gms.internal.dv.C0699a;
import org.json.JSONException;
import org.json.JSONObject;

public class cj extends di implements C0731a, C0699a {
    private final at f1145a;
    private final C0725a f1146b;
    private final dt f1147c;
    private final Object f1148d = new Object();
    private final Context f1149e;
    private final Object f1150f = new Object();
    private final C0751a f1151g;
    private final fg f1152h;
    private di f1153i;
    private du f1154j;
    private boolean f1155k = false;
    private aj f1156l;
    private am f1157m;
    private aq f1158n;

    class C07261 implements Runnable {
        final /* synthetic */ cj f1138a;

        C07261(cj cjVar) {
            this.f1138a = cjVar;
        }

        public void run() {
            this.f1138a.mo932b();
        }
    }

    class C07283 implements Runnable {
        final /* synthetic */ cj f1141a;

        C07283(cj cjVar) {
            this.f1141a = cjVar;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r7 = this;
            r0 = r7.f1141a;
            r6 = r0.f1150f;
            monitor-enter(r6);
            r0 = r7.f1141a;	 Catch:{ all -> 0x005f }
            r0 = r0.f1154j;	 Catch:{ all -> 0x005f }
            r0 = r0.f1385e;	 Catch:{ all -> 0x005f }
            r1 = -2;
            if (r0 == r1) goto L_0x0014;
        L_0x0012:
            monitor-exit(r6);	 Catch:{ all -> 0x005f }
        L_0x0013:
            return;
        L_0x0014:
            r0 = r7.f1141a;	 Catch:{ all -> 0x005f }
            r0 = r0.f1147c;	 Catch:{ all -> 0x005f }
            r0 = r0.m2142f();	 Catch:{ all -> 0x005f }
            r1 = r7.f1141a;	 Catch:{ all -> 0x005f }
            r0.m2152a(r1);	 Catch:{ all -> 0x005f }
            r0 = r7.f1141a;	 Catch:{ all -> 0x005f }
            r0 = r0.f1154j;	 Catch:{ all -> 0x005f }
            r0 = r0.f1385e;	 Catch:{ all -> 0x005f }
            r1 = -3;
            if (r0 != r1) goto L_0x0062;
        L_0x002e:
            r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005f }
            r0.<init>();	 Catch:{ all -> 0x005f }
            r1 = "Loading URL in WebView: ";
            r0 = r0.append(r1);	 Catch:{ all -> 0x005f }
            r1 = r7.f1141a;	 Catch:{ all -> 0x005f }
            r1 = r1.f1154j;	 Catch:{ all -> 0x005f }
            r1 = r1.f1382b;	 Catch:{ all -> 0x005f }
            r0 = r0.append(r1);	 Catch:{ all -> 0x005f }
            r0 = r0.toString();	 Catch:{ all -> 0x005f }
            com.google.android.gms.internal.dq.m2119d(r0);	 Catch:{ all -> 0x005f }
            r0 = r7.f1141a;	 Catch:{ all -> 0x005f }
            r0 = r0.f1147c;	 Catch:{ all -> 0x005f }
            r1 = r7.f1141a;	 Catch:{ all -> 0x005f }
            r1 = r1.f1154j;	 Catch:{ all -> 0x005f }
            r1 = r1.f1382b;	 Catch:{ all -> 0x005f }
            r0.loadUrl(r1);	 Catch:{ all -> 0x005f }
        L_0x005d:
            monitor-exit(r6);	 Catch:{ all -> 0x005f }
            goto L_0x0013;
        L_0x005f:
            r0 = move-exception;
            monitor-exit(r6);	 Catch:{ all -> 0x005f }
            throw r0;
        L_0x0062:
            r0 = "Loading HTML in WebView.";
            com.google.android.gms.internal.dq.m2119d(r0);	 Catch:{ all -> 0x005f }
            r0 = r7.f1141a;	 Catch:{ all -> 0x005f }
            r0 = r0.f1147c;	 Catch:{ all -> 0x005f }
            r1 = r7.f1141a;	 Catch:{ all -> 0x005f }
            r1 = r1.f1154j;	 Catch:{ all -> 0x005f }
            r1 = r1.f1382b;	 Catch:{ all -> 0x005f }
            r1 = com.google.android.gms.internal.dk.m2061a(r1);	 Catch:{ all -> 0x005f }
            r2 = r7.f1141a;	 Catch:{ all -> 0x005f }
            r2 = r2.f1154j;	 Catch:{ all -> 0x005f }
            r2 = r2.f1383c;	 Catch:{ all -> 0x005f }
            r3 = "text/html";
            r4 = "UTF-8";
            r5 = 0;
            r0.loadDataWithBaseURL(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x005f }
            goto L_0x005d;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cj.3.run():void");
        }
    }

    private static final class C0730a extends Exception {
        private final int f1144a;

        public C0730a(String str, int i) {
            super(str);
            this.f1144a = i;
        }

        public int m1862a() {
            return this.f1144a;
        }
    }

    public cj(Context context, C0751a c0751a, fg fgVar, dt dtVar, at atVar, C0725a c0725a) {
        this.f1145a = atVar;
        this.f1146b = c0725a;
        this.f1147c = dtVar;
        this.f1149e = context;
        this.f1151g = c0751a;
        this.f1152h = fgVar;
    }

    private al m1864a(ds dsVar) {
        if (this.f1154j.f1393m == null) {
            throw new C0730a("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.f1154j.f1393m.split("x");
        if (split.length != 2) {
            throw new C0730a("Could not parse the ad size from the ad response: " + this.f1154j.f1393m, 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            for (al alVar : dsVar.f1358d.f927h) {
                float f = this.f1149e.getResources().getDisplayMetrics().density;
                int i = alVar.f925f == -1 ? (int) (((float) alVar.f926g) / f) : alVar.f925f;
                int i2 = alVar.f922c == -2 ? (int) (((float) alVar.f923d) / f) : alVar.f922c;
                if (parseInt == i && parseInt2 == i2) {
                    return new al(alVar, dsVar.f1358d.f927h);
                }
            }
            throw new C0730a("The ad size from the ad response was not one of the requested sizes: " + this.f1154j.f1393m, 0);
        } catch (NumberFormatException e) {
            throw new C0730a("Could not parse the ad size from the ad response: " + this.f1154j.f1393m, 0);
        }
    }

    private void m1866a(ds dsVar, long j) {
        synchronized (this.f1148d) {
            this.f1156l = new aj(this.f1149e, dsVar, this.f1145a, this.f1157m);
        }
        this.f1158n = this.f1156l.m1546a(j, 60000);
        switch (this.f1158n.f953a) {
            case 0:
                return;
            case 1:
                throw new C0730a("No fill from any mediation ad networks.", 3);
            default:
                throw new C0730a("Unexpected mediation result: " + this.f1158n.f953a, 0);
        }
    }

    private void m1868b(long j) {
        dp.f1344a.post(new C07283(this));
        m1873d(j);
    }

    private void m1870c() {
        if (this.f1154j.f1385e != -3) {
            if (TextUtils.isEmpty(this.f1154j.f1383c)) {
                throw new C0730a("No fill from ad server.", 3);
            } else if (this.f1154j.f1388h) {
                try {
                    this.f1157m = new am(this.f1154j.f1383c);
                } catch (JSONException e) {
                    throw new C0730a("Could not parse mediation config: " + this.f1154j.f1383c, 0);
                }
            }
        }
    }

    private void m1871c(long j) {
        while (m1874e(j)) {
            if (this.f1154j != null) {
                synchronized (this.f1148d) {
                    this.f1153i = null;
                }
                if (this.f1154j.f1385e != -2 && this.f1154j.f1385e != -3) {
                    throw new C0730a("There was a problem getting an ad response. ErrorCode: " + this.f1154j.f1385e, this.f1154j.f1385e);
                }
                return;
            }
        }
        throw new C0730a("Timed out waiting for ad response.", 2);
    }

    private void m1873d(long j) {
        while (m1874e(j)) {
            if (this.f1155k) {
                return;
            }
        }
        throw new C0730a("Timed out waiting for WebView to finish loading.", 2);
    }

    private boolean m1874e(long j) {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.f1150f.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            throw new C0730a("Ad request cancelled.", -1);
        }
    }

    public void mo931a() {
        synchronized (this.f1150f) {
            long j;
            al alVar;
            final db dbVar;
            dq.m2112a("AdLoaderBackgroundTask started.");
            eb a = this.f1152h.m2503a();
            ds dsVar = new ds(this.f1151g, a.mo970b(this.f1149e), a.mo966a(this.f1149e));
            al alVar2 = null;
            int i = -2;
            long j2 = -1;
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                di a2 = cl.m1895a(this.f1149e, dsVar, this);
                synchronized (this.f1148d) {
                    this.f1153i = a2;
                    if (this.f1153i == null) {
                        throw new C0730a("Could not start the ad request service.", 0);
                    }
                }
                m1871c(elapsedRealtime);
                j2 = SystemClock.elapsedRealtime();
                m1870c();
                if (dsVar.f1358d.f927h != null) {
                    alVar2 = m1864a(dsVar);
                }
                if (this.f1154j.f1388h) {
                    m1866a(dsVar, elapsedRealtime);
                } else if (this.f1154j.f1396p) {
                    m1876a(elapsedRealtime);
                } else {
                    m1868b(elapsedRealtime);
                }
                j = j2;
                alVar = alVar2;
            } catch (C0730a e) {
                i = e.m1862a();
                if (i == 3 || i == -1) {
                    dq.m2117c(e.getMessage());
                } else {
                    dq.m2120e(e.getMessage());
                }
                if (this.f1154j == null) {
                    this.f1154j = new du(i);
                } else {
                    this.f1154j = new du(i, this.f1154j.f1391k);
                }
                dp.f1344a.post(new C07261(this));
                j = j2;
                alVar = alVar2;
            }
            if (!TextUtils.isEmpty(this.f1154j.f1398r)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.f1154j.f1398r);
                } catch (Throwable e2) {
                    dq.m2116b("Error parsing the JSON for Active View.", e2);
                }
                dbVar = new db(dsVar.f1357c, this.f1147c, this.f1154j.f1384d, i, this.f1154j.f1386f, this.f1154j.f1390j, this.f1154j.f1392l, this.f1154j.f1391k, dsVar.f1363i, this.f1154j.f1388h, this.f1158n == null ? this.f1158n.f954b : null, this.f1158n == null ? this.f1158n.f955c : null, this.f1158n == null ? this.f1158n.f956d : null, this.f1157m, this.f1158n == null ? this.f1158n.f957e : null, this.f1154j.f1389i, alVar, this.f1154j.f1387g, j, this.f1154j.f1394n, this.f1154j.f1395o, r29);
                dp.f1344a.post(new Runnable(this) {
                    final /* synthetic */ cj f1140b;

                    public void run() {
                        synchronized (this.f1140b.f1150f) {
                            this.f1140b.f1146b.mo1076a(dbVar);
                        }
                    }
                });
            }
            JSONObject jSONObject2 = null;
            if (this.f1158n == null) {
            }
            if (this.f1158n == null) {
            }
            if (this.f1158n == null) {
            }
            if (this.f1158n == null) {
            }
            dbVar = new db(dsVar.f1357c, this.f1147c, this.f1154j.f1384d, i, this.f1154j.f1386f, this.f1154j.f1390j, this.f1154j.f1392l, this.f1154j.f1391k, dsVar.f1363i, this.f1154j.f1388h, this.f1158n == null ? this.f1158n.f954b : null, this.f1158n == null ? this.f1158n.f955c : null, this.f1158n == null ? this.f1158n.f956d : null, this.f1157m, this.f1158n == null ? this.f1158n.f957e : null, this.f1154j.f1389i, alVar, this.f1154j.f1387g, j, this.f1154j.f1394n, this.f1154j.f1395o, jSONObject2);
            dp.f1344a.post(/* anonymous class already generated */);
        }
    }

    protected void m1876a(long j) {
        int i;
        int i2;
        al e = this.f1147c.m2141e();
        if (e.f924e) {
            i = this.f1149e.getResources().getDisplayMetrics().widthPixels;
            i2 = this.f1149e.getResources().getDisplayMetrics().heightPixels;
        } else {
            i = e.f926g;
            i2 = e.f923d;
        }
        final ck ckVar = new ck(this, this.f1147c, i, i2);
        dp.f1344a.post(new Runnable(this) {
            final /* synthetic */ cj f1143b;

            public void run() {
                synchronized (this.f1143b.f1150f) {
                    if (this.f1143b.f1154j.f1385e != -2) {
                        return;
                    }
                    this.f1143b.f1147c.m2142f().m2152a(this.f1143b);
                    ckVar.m1890a(this.f1143b.f1154j);
                }
            }
        });
        m1873d(j);
        if (ckVar.m1893c()) {
            dq.m2112a("Ad-Network indicated no fill with passback URL.");
            throw new C0730a("AdNetwork sent passback url", 3);
        } else if (!ckVar.m1894d()) {
            throw new C0730a("AdNetwork timed out", 2);
        }
    }

    public void mo921a(dt dtVar) {
        synchronized (this.f1150f) {
            dq.m2112a("WebView finished loading.");
            this.f1155k = true;
            this.f1150f.notify();
        }
    }

    public void mo948a(du duVar) {
        synchronized (this.f1150f) {
            dq.m2112a("Received ad response.");
            this.f1154j = duVar;
            this.f1150f.notify();
        }
    }

    public void mo932b() {
        synchronized (this.f1148d) {
            if (this.f1153i != null) {
                this.f1153i.m1742f();
            }
            this.f1147c.stopLoading();
            dk.m2070a(this.f1147c);
            if (this.f1156l != null) {
                this.f1156l.m1547a();
            }
        }
    }
}
