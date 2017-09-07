package com.google.android.gms.internal;

public abstract class di {
    private final Runnable f1042a = new C07431(this);
    private volatile Thread f1043b;

    class C07431 implements Runnable {
        final /* synthetic */ di f1321a;

        C07431(di diVar) {
            this.f1321a = diVar;
        }

        public final void run() {
            this.f1321a.f1043b = Thread.currentThread();
            this.f1321a.mo931a();
        }
    }

    public abstract void mo931a();

    public abstract void mo932b();

    public final void m1741e() {
        dj.m2058a(this.f1042a);
    }

    public final void m1742f() {
        mo932b();
        if (this.f1043b != null) {
            this.f1043b.interrupt();
        }
    }
}
