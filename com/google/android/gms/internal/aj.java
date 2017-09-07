package com.google.android.gms.internal;

import android.content.Context;

public final class aj {
    private final ds f906a;
    private final at f907b;
    private final Context f908c;
    private final Object f909d = new Object();
    private final am f910e;
    private boolean f911f = false;
    private ap f912g;

    public aj(Context context, ds dsVar, at atVar, am amVar) {
        this.f908c = context;
        this.f906a = dsVar;
        this.f907b = atVar;
        this.f910e = amVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.aq m1546a(long r18, long r20) {
        /*
        r17 = this;
        r4 = "Starting mediation.";
        com.google.android.gms.internal.dq.m2112a(r4);
        r0 = r17;
        r4 = r0.f910e;
        r4 = r4.f928a;
        r13 = r4.iterator();
    L_0x000f:
        r4 = r13.hasNext();
        if (r4 == 0) goto L_0x00aa;
    L_0x0015:
        r9 = r13.next();
        r9 = (com.google.android.gms.internal.ak) r9;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Trying mediation network: ";
        r4 = r4.append(r5);
        r5 = r9.f914b;
        r4 = r4.append(r5);
        r4 = r4.toString();
        com.google.android.gms.internal.dq.m2117c(r4);
        r4 = r9.f915c;
        r14 = r4.iterator();
    L_0x0039:
        r4 = r14.hasNext();
        if (r4 == 0) goto L_0x000f;
    L_0x003f:
        r6 = r14.next();
        r6 = (java.lang.String) r6;
        r0 = r17;
        r15 = r0.f909d;
        monitor-enter(r15);
        r0 = r17;
        r4 = r0.f911f;	 Catch:{ all -> 0x0096 }
        if (r4 == 0) goto L_0x0058;
    L_0x0050:
        r4 = new com.google.android.gms.internal.aq;	 Catch:{ all -> 0x0096 }
        r5 = -1;
        r4.<init>(r5);	 Catch:{ all -> 0x0096 }
        monitor-exit(r15);	 Catch:{ all -> 0x0096 }
    L_0x0057:
        return r4;
    L_0x0058:
        r4 = new com.google.android.gms.internal.ap;	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r5 = r0.f908c;	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r7 = r0.f907b;	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r8 = r0.f910e;	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r10 = r0.f906a;	 Catch:{ all -> 0x0096 }
        r10 = r10.f1357c;	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r11 = r0.f906a;	 Catch:{ all -> 0x0096 }
        r11 = r11.f1358d;	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r12 = r0.f906a;	 Catch:{ all -> 0x0096 }
        r12 = r12.f1365k;	 Catch:{ all -> 0x0096 }
        r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12);	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r0.f912g = r4;	 Catch:{ all -> 0x0096 }
        monitor-exit(r15);	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r4 = r0.f912g;
        r0 = r18;
        r2 = r20;
        r4 = r4.m1585a(r0, r2);
        r5 = r4.f953a;
        if (r5 != 0) goto L_0x0099;
    L_0x0090:
        r5 = "Adapter succeeded.";
        com.google.android.gms.internal.dq.m2112a(r5);
        goto L_0x0057;
    L_0x0096:
        r4 = move-exception;
        monitor-exit(r15);	 Catch:{ all -> 0x0096 }
        throw r4;
    L_0x0099:
        r5 = r4.f955c;
        if (r5 == 0) goto L_0x0039;
    L_0x009d:
        r5 = com.google.android.gms.internal.dp.f1344a;
        r6 = new com.google.android.gms.internal.aj$1;
        r0 = r17;
        r6.<init>(r0, r4);
        r5.post(r6);
        goto L_0x0039;
    L_0x00aa:
        r4 = new com.google.android.gms.internal.aq;
        r5 = 1;
        r4.<init>(r5);
        goto L_0x0057;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.aj.a(long, long):com.google.android.gms.internal.aq");
    }

    public void m1547a() {
        synchronized (this.f909d) {
            this.f911f = true;
            if (this.f912g != null) {
                this.f912g.m1586a();
            }
        }
    }
}
