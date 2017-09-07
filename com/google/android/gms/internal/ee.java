package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.C0663a;
import com.google.android.gms.common.C0665b.C0660b;
import com.google.android.gms.common.p028a.C0662a.C0659a;
import java.util.ArrayList;
import java.util.Iterator;

public final class ee {
    final ArrayList<C0659a> f1507a = new ArrayList();
    private final C0735b f1508b;
    private final ArrayList<C0659a> f1509c = new ArrayList();
    private boolean f1510d = false;
    private final ArrayList<C0660b> f1511e = new ArrayList();
    private final Handler f1512f;

    public interface C0735b {
        boolean mo954g();

        Bundle mo955l();

        boolean mo956n();
    }

    final class C0784a extends Handler {
        final /* synthetic */ ee f1506a;

        public C0784a(ee eeVar, Looper looper) {
            this.f1506a = eeVar;
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                synchronized (this.f1506a.f1509c) {
                    if (this.f1506a.f1508b.mo956n() && this.f1506a.f1508b.mo954g() && this.f1506a.f1509c.contains(message.obj)) {
                        ((C0659a) message.obj).mo972a(this.f1506a.f1508b.mo955l());
                    }
                }
                return;
            }
            Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
        }
    }

    public ee(Context context, Looper looper, C0735b c0735b) {
        this.f1508b = c0735b;
        this.f1512f = new C0784a(this, looper);
    }

    protected void m2227a() {
        synchronized (this.f1509c) {
            m2229a(this.f1508b.mo955l());
        }
    }

    public void m2228a(int i) {
        this.f1512f.removeMessages(1);
        synchronized (this.f1509c) {
            this.f1510d = true;
            Iterator it = new ArrayList(this.f1509c).iterator();
            while (it.hasNext()) {
                C0659a c0659a = (C0659a) it.next();
                if (!this.f1508b.mo956n()) {
                    break;
                } else if (this.f1509c.contains(c0659a)) {
                    c0659a.mo971a(i);
                }
            }
            this.f1510d = false;
        }
    }

    public void m2229a(Bundle bundle) {
        boolean z = true;
        synchronized (this.f1509c) {
            ek.m2335a(!this.f1510d);
            this.f1512f.removeMessages(1);
            this.f1510d = true;
            if (this.f1507a.size() != 0) {
                z = false;
            }
            ek.m2335a(z);
            Iterator it = new ArrayList(this.f1509c).iterator();
            while (it.hasNext()) {
                C0659a c0659a = (C0659a) it.next();
                if (!this.f1508b.mo956n() || !this.f1508b.mo954g()) {
                    break;
                } else if (!this.f1507a.contains(c0659a)) {
                    c0659a.mo972a(bundle);
                }
            }
            this.f1507a.clear();
            this.f1510d = false;
        }
    }

    public void m2230a(C0659a c0659a) {
        ek.m2332a((Object) c0659a);
        synchronized (this.f1509c) {
            if (this.f1509c.contains(c0659a)) {
                Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + c0659a + " is already registered");
            } else {
                this.f1509c.add(c0659a);
            }
        }
        if (this.f1508b.mo954g()) {
            this.f1512f.sendMessage(this.f1512f.obtainMessage(1, c0659a));
        }
    }

    public void m2231a(C0663a c0663a) {
        this.f1512f.removeMessages(1);
        synchronized (this.f1511e) {
            Iterator it = new ArrayList(this.f1511e).iterator();
            while (it.hasNext()) {
                C0660b c0660b = (C0660b) it.next();
                if (!this.f1508b.mo956n()) {
                    return;
                } else if (this.f1511e.contains(c0660b)) {
                    c0660b.mo952a(c0663a);
                }
            }
        }
    }

    public void m2232a(C0660b c0660b) {
        ek.m2332a((Object) c0660b);
        synchronized (this.f1511e) {
            if (this.f1511e.contains(c0660b)) {
                Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + c0660b + " is already registered");
            } else {
                this.f1511e.add(c0660b);
            }
        }
    }
}
