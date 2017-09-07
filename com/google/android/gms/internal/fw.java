package com.google.android.gms.internal;

import android.os.Handler;
import java.lang.ref.WeakReference;

public final class fw {
    private final C0819a f1636a;
    private final Runnable f1637b;
    private ai f1638c;
    private boolean f1639d;
    private boolean f1640e;
    private long f1641f;

    public static class C0819a {
        private final Handler f1635a;

        public C0819a(Handler handler) {
            this.f1635a = handler;
        }

        public void m2642a(Runnable runnable) {
            this.f1635a.removeCallbacks(runnable);
        }

        public boolean m2643a(Runnable runnable, long j) {
            return this.f1635a.postDelayed(runnable, j);
        }
    }

    public fw(ft ftVar) {
        this(ftVar, new C0819a(dp.f1344a));
    }

    fw(final ft ftVar, C0819a c0819a) {
        this.f1639d = false;
        this.f1640e = false;
        this.f1641f = 0;
        this.f1636a = c0819a;
        this.f1637b = new Runnable(this) {
            final /* synthetic */ fw f1633b;
            private final WeakReference<ft> f1634c = new WeakReference(ftVar);

            public void run() {
                this.f1633b.f1639d = false;
                ft ftVar = (ft) this.f1634c.get();
                if (ftVar != null) {
                    ftVar.m2620b(this.f1633b.f1638c);
                }
            }
        };
    }

    public void m2646a() {
        this.f1639d = false;
        this.f1636a.m2642a(this.f1637b);
    }

    public void m2647a(ai aiVar) {
        m2648a(aiVar, 60000);
    }

    public void m2648a(ai aiVar, long j) {
        if (this.f1639d) {
            dq.m2120e("An ad refresh is already scheduled.");
            return;
        }
        this.f1638c = aiVar;
        this.f1639d = true;
        this.f1641f = j;
        if (!this.f1640e) {
            dq.m2117c("Scheduling ad refresh " + j + " milliseconds from now.");
            this.f1636a.m2643a(this.f1637b, j);
        }
    }

    public void m2649b() {
        this.f1640e = true;
        if (this.f1639d) {
            this.f1636a.m2642a(this.f1637b);
        }
    }

    public void m2650c() {
        this.f1640e = false;
        if (this.f1639d) {
            this.f1639d = false;
            m2648a(this.f1638c, this.f1641f);
        }
    }
}
