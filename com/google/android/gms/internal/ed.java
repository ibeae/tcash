package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.C0663a;
import com.google.android.gms.common.C0665b.C0660b;
import com.google.android.gms.common.C0665b.C0664a;
import com.google.android.gms.common.C0672e;
import com.google.android.gms.common.p028a.C0662a.C0659a;
import com.google.android.gms.common.p028a.C0662a.C0661b;
import com.google.android.gms.internal.ee.C0735b;
import com.google.android.gms.internal.eh.C0779a;
import com.google.android.gms.internal.ei.C0789a;
import java.util.ArrayList;

public abstract class ed<T extends IInterface> implements C0735b {
    public static final String[] f1177d = new String[]{"service_esmobile", "service_googleme"};
    private final Context f1178a;
    final Handler f1179b;
    boolean f1180c;
    private final Looper f1181e;
    private T f1182f;
    private final ArrayList<C0777b<?>> f1183g;
    private C0781e f1184h;
    private volatile int f1185i;
    private final String[] f1186j;
    private final ee f1187k;

    final class C0776a extends Handler {
        final /* synthetic */ ed f1494a;

        public C0776a(ed edVar, Looper looper) {
            this.f1494a = edVar;
            super(looper);
        }

        public void handleMessage(Message message) {
            C0777b c0777b;
            if (message.what == 1 && !this.f1494a.m1934h()) {
                c0777b = (C0777b) message.obj;
                c0777b.mo974a();
                c0777b.m2214c();
            } else if (message.what == 3) {
                this.f1494a.f1187k.m2231a(new C0663a(((Integer) message.obj).intValue(), null));
            } else if (message.what == 4) {
                this.f1494a.m1915a(1);
                this.f1494a.f1182f = null;
                this.f1494a.f1187k.m2228a(((Integer) message.obj).intValue());
            } else if (message.what == 2 && !this.f1494a.mo954g()) {
                c0777b = (C0777b) message.obj;
                c0777b.mo974a();
                c0777b.m2214c();
            } else if (message.what == 2 || message.what == 1) {
                ((C0777b) message.obj).m2213b();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle this message.");
            }
        }
    }

    protected abstract class C0777b<TListener> {
        final /* synthetic */ ed f1495a;
        private TListener f1496b;
        private boolean f1497c = false;

        public C0777b(ed edVar, TListener tListener) {
            this.f1495a = edVar;
            this.f1496b = tListener;
        }

        protected abstract void mo974a();

        protected abstract void mo975a(TListener tListener);

        public void m2213b() {
            synchronized (this) {
                Object obj = this.f1496b;
                if (this.f1497c) {
                    Log.w("GmsClient", "Callback proxy " + this + " being reused. This is not safe.");
                }
            }
            if (obj != null) {
                try {
                    mo975a(obj);
                } catch (RuntimeException e) {
                    mo974a();
                    throw e;
                }
            }
            mo974a();
            synchronized (this) {
                this.f1497c = true;
            }
            m2214c();
        }

        public void m2214c() {
            m2215d();
            synchronized (this.f1495a.f1183g) {
                this.f1495a.f1183g.remove(this);
            }
        }

        public void m2215d() {
            synchronized (this) {
                this.f1496b = null;
            }
        }
    }

    public static final class C0778c implements C0659a {
        private final C0664a f1498a;

        public C0778c(C0664a c0664a) {
            this.f1498a = c0664a;
        }

        public void mo971a(int i) {
            this.f1498a.a_();
        }

        public void mo972a(Bundle bundle) {
            this.f1498a.mo951a(bundle);
        }

        public boolean equals(Object obj) {
            return obj instanceof C0778c ? this.f1498a.equals(((C0778c) obj).f1498a) : this.f1498a.equals(obj);
        }
    }

    public static final class C0780d extends C0779a {
        private ed f1499a;

        public C0780d(ed edVar) {
            this.f1499a = edVar;
        }

        public void mo973a(int i, IBinder iBinder, Bundle bundle) {
            ek.m2333a((Object) "onPostInitComplete can be called only once per call to getServiceFromBroker", this.f1499a);
            this.f1499a.m1922a(i, iBinder, bundle);
            this.f1499a = null;
        }
    }

    final class C0781e implements ServiceConnection {
        final /* synthetic */ ed f1500a;

        C0781e(ed edVar) {
            this.f1500a = edVar;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.f1500a.m1929c(iBinder);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.f1500a.f1179b.sendMessage(this.f1500a.f1179b.obtainMessage(4, Integer.valueOf(1)));
        }
    }

    public static final class C0782f implements C0661b {
        private final C0660b f1501a;

        public C0782f(C0660b c0660b) {
            this.f1501a = c0660b;
        }

        public void mo952a(C0663a c0663a) {
            this.f1501a.mo952a(c0663a);
        }

        public boolean equals(Object obj) {
            return obj instanceof C0782f ? this.f1501a.equals(((C0782f) obj).f1501a) : this.f1501a.equals(obj);
        }
    }

    protected final class C0783g extends C0777b<Boolean> {
        public final int f1502b;
        public final Bundle f1503c;
        public final IBinder f1504d;
        final /* synthetic */ ed f1505e;

        public C0783g(ed edVar, int i, IBinder iBinder, Bundle bundle) {
            this.f1505e = edVar;
            super(edVar, Boolean.valueOf(true));
            this.f1502b = i;
            this.f1504d = iBinder;
            this.f1503c = bundle;
        }

        protected void mo974a() {
        }

        protected void m2223a(Boolean bool) {
            if (bool == null) {
                this.f1505e.m1915a(1);
                return;
            }
            switch (this.f1502b) {
                case 0:
                    try {
                        if (this.f1505e.mo960b().equals(this.f1504d.getInterfaceDescriptor())) {
                            this.f1505e.f1182f = this.f1505e.mo959b(this.f1504d);
                            if (this.f1505e.f1182f != null) {
                                this.f1505e.m1915a(3);
                                this.f1505e.f1187k.m2227a();
                                return;
                            }
                        }
                    } catch (RemoteException e) {
                    }
                    ef.m2248a(this.f1505e.f1178a).m2251b(this.f1505e.mo957a(), this.f1505e.f1184h);
                    this.f1505e.f1184h = null;
                    this.f1505e.m1915a(1);
                    this.f1505e.f1182f = null;
                    this.f1505e.f1187k.m2231a(new C0663a(8, null));
                    return;
                case 10:
                    this.f1505e.m1915a(1);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    PendingIntent pendingIntent = this.f1503c != null ? (PendingIntent) this.f1503c.getParcelable("pendingIntent") : null;
                    if (this.f1505e.f1184h != null) {
                        ef.m2248a(this.f1505e.f1178a).m2251b(this.f1505e.mo957a(), this.f1505e.f1184h);
                        this.f1505e.f1184h = null;
                    }
                    this.f1505e.m1915a(1);
                    this.f1505e.f1182f = null;
                    this.f1505e.f1187k.m2231a(new C0663a(this.f1502b, pendingIntent));
                    return;
            }
        }

        protected /* synthetic */ void mo975a(Object obj) {
            m2223a((Boolean) obj);
        }
    }

    protected ed(Context context, Looper looper, C0659a c0659a, C0661b c0661b, String... strArr) {
        this.f1183g = new ArrayList();
        this.f1185i = 1;
        this.f1180c = false;
        this.f1178a = (Context) ek.m2332a((Object) context);
        this.f1181e = (Looper) ek.m2333a((Object) looper, (Object) "Looper must not be null");
        this.f1187k = new ee(context, looper, this);
        this.f1179b = new C0776a(this, looper);
        m1926a(strArr);
        this.f1186j = strArr;
        m1923a((C0659a) ek.m2332a((Object) c0659a));
        m1924a((C0661b) ek.m2332a((Object) c0661b));
    }

    @Deprecated
    protected ed(Context context, C0664a c0664a, C0660b c0660b, String... strArr) {
        this(context, context.getMainLooper(), new C0778c(c0664a), new C0782f(c0660b), strArr);
    }

    private void m1915a(int i) {
        int i2 = this.f1185i;
        this.f1185i = i;
        if (i2 == i) {
            return;
        }
        if (i == 3) {
            m1930d();
        } else if (i2 == 3 && i == 1) {
            m1931e();
        }
    }

    protected abstract String mo957a();

    protected void m1922a(int i, IBinder iBinder, Bundle bundle) {
        this.f1179b.sendMessage(this.f1179b.obtainMessage(1, new C0783g(this, i, iBinder, bundle)));
    }

    public void m1923a(C0659a c0659a) {
        this.f1187k.m2230a(c0659a);
    }

    public void m1924a(C0661b c0661b) {
        this.f1187k.m2232a((C0660b) c0661b);
    }

    protected abstract void mo958a(ei eiVar, C0780d c0780d);

    protected void m1926a(String... strArr) {
    }

    protected abstract T mo959b(IBinder iBinder);

    protected abstract String mo960b();

    protected final void m1929c(IBinder iBinder) {
        try {
            mo958a(C0789a.m2327a(iBinder), new C0780d(this));
        } catch (RemoteException e) {
            Log.w("GmsClient", "service died");
        }
    }

    protected void m1930d() {
    }

    protected void m1931e() {
    }

    public void m1932f() {
        this.f1180c = true;
        m1915a(2);
        int a = C0672e.m1465a(this.f1178a);
        if (a != 0) {
            m1915a(1);
            this.f1179b.sendMessage(this.f1179b.obtainMessage(3, Integer.valueOf(a)));
            return;
        }
        if (this.f1184h != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect().");
            this.f1182f = null;
            ef.m2248a(this.f1178a).m2251b(mo957a(), this.f1184h);
        }
        this.f1184h = new C0781e(this);
        if (!ef.m2248a(this.f1178a).m2250a(mo957a(), this.f1184h)) {
            Log.e("GmsClient", "unable to connect to service: " + mo957a());
            this.f1179b.sendMessage(this.f1179b.obtainMessage(3, Integer.valueOf(9)));
        }
    }

    public boolean mo954g() {
        return this.f1185i == 3;
    }

    public boolean m1934h() {
        return this.f1185i == 2;
    }

    public void mo1053i() {
        this.f1180c = false;
        synchronized (this.f1183g) {
            int size = this.f1183g.size();
            for (int i = 0; i < size; i++) {
                ((C0777b) this.f1183g.get(i)).m2215d();
            }
            this.f1183g.clear();
        }
        m1915a(1);
        this.f1182f = null;
        if (this.f1184h != null) {
            ef.m2248a(this.f1178a).m2251b(mo957a(), this.f1184h);
            this.f1184h = null;
        }
    }

    public final Context m1936j() {
        return this.f1178a;
    }

    protected final void m1937k() {
        if (!mo954g()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public Bundle mo955l() {
        return null;
    }

    public final T m1939m() {
        m1937k();
        return this.f1182f;
    }

    public boolean mo956n() {
        return this.f1180c;
    }
}
