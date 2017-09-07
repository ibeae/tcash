package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class dc {
    private final dd f1286a;
    private final LinkedList<C0742a> f1287b;
    private final Object f1288c;
    private final String f1289d;
    private final String f1290e;
    private long f1291f;
    private long f1292g;
    private boolean f1293h;
    private long f1294i;
    private long f1295j;
    private long f1296k;
    private long f1297l;

    private static final class C0742a {
        private long f1284a = -1;
        private long f1285b = -1;

        public long m2019a() {
            return this.f1285b;
        }

        public void m2020b() {
            this.f1285b = SystemClock.elapsedRealtime();
        }

        public void m2021c() {
            this.f1284a = SystemClock.elapsedRealtime();
        }

        public Bundle m2022d() {
            Bundle bundle = new Bundle();
            bundle.putLong("topen", this.f1284a);
            bundle.putLong("tclose", this.f1285b);
            return bundle;
        }
    }

    public dc(dd ddVar, String str, String str2) {
        this.f1288c = new Object();
        this.f1291f = -1;
        this.f1292g = -1;
        this.f1293h = false;
        this.f1294i = -1;
        this.f1295j = 0;
        this.f1296k = -1;
        this.f1297l = -1;
        this.f1286a = ddVar;
        this.f1289d = str;
        this.f1290e = str2;
        this.f1287b = new LinkedList();
    }

    public dc(String str, String str2) {
        this(dd.m2033a(), str, str2);
    }

    public void m2023a() {
        synchronized (this.f1288c) {
            if (this.f1297l != -1 && this.f1292g == -1) {
                this.f1292g = SystemClock.elapsedRealtime();
                this.f1286a.m2038a(this);
            }
            dd ddVar = this.f1286a;
            dd.m2036d().m2050c();
        }
    }

    public void m2024a(long j) {
        synchronized (this.f1288c) {
            this.f1297l = j;
            if (this.f1297l != -1) {
                this.f1286a.m2038a(this);
            }
        }
    }

    public void m2025a(ai aiVar) {
        synchronized (this.f1288c) {
            this.f1296k = SystemClock.elapsedRealtime();
            dd ddVar = this.f1286a;
            dd.m2036d().m2048a(aiVar, this.f1296k);
        }
    }

    public void m2026a(boolean z) {
        synchronized (this.f1288c) {
            if (this.f1297l != -1) {
                this.f1294i = SystemClock.elapsedRealtime();
                if (!z) {
                    this.f1292g = this.f1294i;
                    this.f1286a.m2038a(this);
                }
            }
        }
    }

    public void m2027b() {
        synchronized (this.f1288c) {
            if (this.f1297l != -1) {
                C0742a c0742a = new C0742a();
                c0742a.m2021c();
                this.f1287b.add(c0742a);
                this.f1295j++;
                dd ddVar = this.f1286a;
                dd.m2036d().m2049b();
                this.f1286a.m2038a(this);
            }
        }
    }

    public void m2028b(long j) {
        synchronized (this.f1288c) {
            if (this.f1297l != -1) {
                this.f1291f = j;
                this.f1286a.m2038a(this);
            }
        }
    }

    public void m2029b(boolean z) {
        synchronized (this.f1288c) {
            if (this.f1297l != -1) {
                this.f1293h = z;
                this.f1286a.m2038a(this);
            }
        }
    }

    public void m2030c() {
        synchronized (this.f1288c) {
            if (!(this.f1297l == -1 || this.f1287b.isEmpty())) {
                C0742a c0742a = (C0742a) this.f1287b.getLast();
                if (c0742a.m2019a() == -1) {
                    c0742a.m2020b();
                    this.f1286a.m2038a(this);
                }
            }
        }
    }

    public Bundle m2031d() {
        Bundle bundle;
        synchronized (this.f1288c) {
            bundle = new Bundle();
            bundle.putString("seqnum", this.f1289d);
            bundle.putString("slotid", this.f1290e);
            bundle.putBoolean("ismediation", this.f1293h);
            bundle.putLong("treq", this.f1296k);
            bundle.putLong("tresponse", this.f1297l);
            bundle.putLong("timp", this.f1292g);
            bundle.putLong("tload", this.f1294i);
            bundle.putLong("pcc", this.f1295j);
            bundle.putLong("tfetch", this.f1291f);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f1287b.iterator();
            while (it.hasNext()) {
                arrayList.add(((C0742a) it.next()).m2022d());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }
}
