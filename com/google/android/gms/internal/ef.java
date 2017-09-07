package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.internal.ed.C0781e;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class ef implements Callback {
    private static final Object f1522a = new Object();
    private static ef f1523b;
    private final Context f1524c;
    private final HashMap<String, C0786a> f1525d = new HashMap();
    private final Handler f1526e;

    final class C0786a {
        final /* synthetic */ ef f1514a;
        private final String f1515b;
        private final C0785a f1516c = new C0785a(this);
        private final HashSet<C0781e> f1517d = new HashSet();
        private int f1518e = 0;
        private boolean f1519f;
        private IBinder f1520g;
        private ComponentName f1521h;

        public class C0785a implements ServiceConnection {
            final /* synthetic */ C0786a f1513a;

            public C0785a(C0786a c0786a) {
                this.f1513a = c0786a;
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                synchronized (this.f1513a.f1514a.f1525d) {
                    this.f1513a.f1520g = iBinder;
                    this.f1513a.f1521h = componentName;
                    Iterator it = this.f1513a.f1517d.iterator();
                    while (it.hasNext()) {
                        ((C0781e) it.next()).onServiceConnected(componentName, iBinder);
                    }
                    this.f1513a.f1518e = 1;
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                synchronized (this.f1513a.f1514a.f1525d) {
                    this.f1513a.f1520g = null;
                    this.f1513a.f1521h = componentName;
                    Iterator it = this.f1513a.f1517d.iterator();
                    while (it.hasNext()) {
                        ((C0781e) it.next()).onServiceDisconnected(componentName);
                    }
                    this.f1513a.f1518e = 2;
                }
            }
        }

        public C0786a(ef efVar, String str) {
            this.f1514a = efVar;
            this.f1515b = str;
        }

        public C0785a m2237a() {
            return this.f1516c;
        }

        public void m2238a(C0781e c0781e) {
            this.f1517d.add(c0781e);
        }

        public void m2239a(boolean z) {
            this.f1519f = z;
        }

        public String m2240b() {
            return this.f1515b;
        }

        public void m2241b(C0781e c0781e) {
            this.f1517d.remove(c0781e);
        }

        public boolean m2242c() {
            return this.f1519f;
        }

        public boolean m2243c(C0781e c0781e) {
            return this.f1517d.contains(c0781e);
        }

        public int m2244d() {
            return this.f1518e;
        }

        public boolean m2245e() {
            return this.f1517d.isEmpty();
        }

        public IBinder m2246f() {
            return this.f1520g;
        }

        public ComponentName m2247g() {
            return this.f1521h;
        }
    }

    private ef(Context context) {
        this.f1526e = new Handler(context.getMainLooper(), this);
        this.f1524c = context.getApplicationContext();
    }

    public static ef m2248a(Context context) {
        synchronized (f1522a) {
            if (f1523b == null) {
                f1523b = new ef(context.getApplicationContext());
            }
        }
        return f1523b;
    }

    public boolean m2250a(String str, C0781e c0781e) {
        boolean c;
        synchronized (this.f1525d) {
            C0786a c0786a = (C0786a) this.f1525d.get(str);
            if (c0786a != null) {
                this.f1526e.removeMessages(0, c0786a);
                if (!c0786a.m2243c(c0781e)) {
                    c0786a.m2238a((C0781e) c0781e);
                    switch (c0786a.m2244d()) {
                        case 1:
                            c0781e.onServiceConnected(c0786a.m2247g(), c0786a.m2246f());
                            break;
                        case 2:
                            c0786a.m2239a(this.f1524c.bindService(new Intent(str).setPackage("com.google.android.gms"), c0786a.m2237a(), 129));
                            break;
                        default:
                            break;
                    }
                }
                throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=" + str);
            }
            c0786a = new C0786a(this, str);
            c0786a.m2238a((C0781e) c0781e);
            c0786a.m2239a(this.f1524c.bindService(new Intent(str).setPackage("com.google.android.gms"), c0786a.m2237a(), 129));
            this.f1525d.put(str, c0786a);
            c = c0786a.m2242c();
        }
        return c;
    }

    public void m2251b(String str, C0781e c0781e) {
        synchronized (this.f1525d) {
            C0786a c0786a = (C0786a) this.f1525d.get(str);
            if (c0786a == null) {
                throw new IllegalStateException("Nonexistent connection status for service action: " + str);
            } else if (c0786a.m2243c(c0781e)) {
                c0786a.m2241b(c0781e);
                if (c0786a.m2245e()) {
                    this.f1526e.sendMessageDelayed(this.f1526e.obtainMessage(0, c0786a), 5000);
                }
            } else {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + str);
            }
        }
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                C0786a c0786a = (C0786a) message.obj;
                synchronized (this.f1525d) {
                    if (c0786a.m2245e()) {
                        this.f1524c.unbindService(c0786a.m2237a());
                        this.f1525d.remove(c0786a.m2240b());
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
