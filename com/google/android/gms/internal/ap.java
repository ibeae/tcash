package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.aq.C0681a;
import com.google.android.gms.p027a.C0654d;

public final class ap implements C0681a {
    private final String f942a;
    private final at f943b;
    private final long f944c;
    private final ak f945d;
    private final ai f946e;
    private final al f947f;
    private final Context f948g;
    private final Object f949h = new Object();
    private final ev f950i;
    private au f951j;
    private int f952k = -2;

    public ap(Context context, String str, at atVar, am amVar, ak akVar, ai aiVar, al alVar, ev evVar) {
        this.f948g = context;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            this.f942a = m1576a(akVar);
        } else {
            this.f942a = str;
        }
        this.f943b = atVar;
        this.f944c = amVar.f929b != -1 ? amVar.f929b : 10000;
        this.f945d = akVar;
        this.f946e = aiVar;
        this.f947f = alVar;
        this.f950i = evVar;
    }

    private String m1576a(ak akVar) {
        try {
            if (!TextUtils.isEmpty(akVar.f917e)) {
                if (CustomEvent.class.isAssignableFrom(Class.forName(akVar.f917e, false, ap.class.getClassLoader()))) {
                    return "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
                }
            }
        } catch (ClassNotFoundException e) {
            dq.m2120e("Could not create custom event adapter.");
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    private void m1577a(long j, long j2, long j3, long j4) {
        while (this.f952k == -2) {
            m1582b(j, j2, j3, j4);
        }
    }

    private void m1578a(ao aoVar) {
        try {
            if (this.f950i.f1566d < 4100000) {
                if (this.f947f.f924e) {
                    this.f951j.mo886a(C0654d.m1384a(this.f948g), this.f946e, this.f945d.f919g, aoVar);
                } else {
                    this.f951j.mo888a(C0654d.m1384a(this.f948g), this.f947f, this.f946e, this.f945d.f919g, (av) aoVar);
                }
            } else if (this.f947f.f924e) {
                this.f951j.mo887a(C0654d.m1384a(this.f948g), this.f946e, this.f945d.f919g, this.f945d.f913a, (av) aoVar);
            } else {
                this.f951j.mo889a(C0654d.m1384a(this.f948g), this.f947f, this.f946e, this.f945d.f919g, this.f945d.f913a, aoVar);
            }
        } catch (Throwable e) {
            dq.m2118c("Could not request ad from mediation adapter.", e);
            mo883a(5);
        }
    }

    private au m1581b() {
        dq.m2117c("Instantiating mediation adapter: " + this.f942a);
        try {
            return this.f943b.mo884a(this.f942a);
        } catch (Throwable e) {
            dq.m2113a("Could not instantiate mediation adapter: " + this.f942a, e);
            return null;
        }
    }

    private void m1582b(long j, long j2, long j3, long j4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = j2 - (elapsedRealtime - j);
        elapsedRealtime = j4 - (elapsedRealtime - j3);
        if (j5 <= 0 || elapsedRealtime <= 0) {
            dq.m2117c("Timed out waiting for adapter.");
            this.f952k = 3;
            return;
        }
        try {
            this.f949h.wait(Math.min(j5, elapsedRealtime));
        } catch (InterruptedException e) {
            this.f952k = -1;
        }
    }

    public aq m1585a(long j, long j2) {
        aq aqVar;
        synchronized (this.f949h) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            final ao aoVar = new ao();
            dp.f1344a.post(new Runnable(this) {
                final /* synthetic */ ap f941b;

                public void run() {
                    synchronized (this.f941b.f949h) {
                        if (this.f941b.f952k != -2) {
                            return;
                        }
                        this.f941b.f951j = this.f941b.m1581b();
                        if (this.f941b.f951j == null) {
                            this.f941b.mo883a(4);
                            return;
                        }
                        aoVar.m1568a(this.f941b);
                        this.f941b.m1578a(aoVar);
                    }
                }
            });
            m1577a(elapsedRealtime, this.f944c, j, j2);
            aqVar = new aq(this.f945d, this.f951j, this.f942a, aoVar, this.f952k);
        }
        return aqVar;
    }

    public void m1586a() {
        synchronized (this.f949h) {
            try {
                if (this.f951j != null) {
                    this.f951j.mo891c();
                }
            } catch (Throwable e) {
                dq.m2118c("Could not destroy mediation adapter.", e);
            }
            this.f952k = -1;
            this.f949h.notify();
        }
    }

    public void mo883a(int i) {
        synchronized (this.f949h) {
            this.f952k = i;
            this.f949h.notify();
        }
    }
}
