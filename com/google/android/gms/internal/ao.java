package com.google.android.gms.internal;

import com.google.android.gms.internal.aq.C0681a;
import com.google.android.gms.internal.av.C0679a;

public final class ao extends C0679a {
    private final Object f937a = new Object();
    private C0681a f938b;
    private an f939c;

    public void mo877a() {
        synchronized (this.f937a) {
            if (this.f939c != null) {
                this.f939c.mo1092j();
            }
        }
    }

    public void mo878a(int i) {
        synchronized (this.f937a) {
            if (this.f938b != null) {
                this.f938b.mo883a(i == 3 ? 1 : 2);
                this.f938b = null;
            }
        }
    }

    public void m1567a(an anVar) {
        synchronized (this.f937a) {
            this.f939c = anVar;
        }
    }

    public void m1568a(C0681a c0681a) {
        synchronized (this.f937a) {
            this.f938b = c0681a;
        }
    }

    public void mo879b() {
        synchronized (this.f937a) {
            if (this.f939c != null) {
                this.f939c.mo1093k();
            }
        }
    }

    public void mo880c() {
        synchronized (this.f937a) {
            if (this.f939c != null) {
                this.f939c.mo1094l();
            }
        }
    }

    public void mo881d() {
        synchronized (this.f937a) {
            if (this.f939c != null) {
                this.f939c.mo1095m();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo882e() {
        /*
        r3 = this;
        r1 = r3.f937a;
        monitor-enter(r1);
        r0 = r3.f938b;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0012;
    L_0x0007:
        r0 = r3.f938b;	 Catch:{ all -> 0x001d }
        r2 = 0;
        r0.mo883a(r2);	 Catch:{ all -> 0x001d }
        r0 = 0;
        r3.f938b = r0;	 Catch:{ all -> 0x001d }
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
    L_0x0011:
        return;
    L_0x0012:
        r0 = r3.f939c;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x001b;
    L_0x0016:
        r0 = r3.f939c;	 Catch:{ all -> 0x001d }
        r0.mo1096n();	 Catch:{ all -> 0x001d }
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        goto L_0x0011;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ao.e():void");
    }
}
