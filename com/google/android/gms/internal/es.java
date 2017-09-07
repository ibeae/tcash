package com.google.android.gms.internal;

import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.location.C0798d;
import com.google.android.gms.location.C0798d.C0799a;
import java.util.HashMap;

public class es {
    private final ew<er> f1552a;
    private final Context f1553b;
    private ContentProviderClient f1554c = null;
    private boolean f1555d = false;
    private HashMap<Object, C0800a> f1556e = new HashMap();

    private static class C0800a extends C0799a {
        private Handler f1551a;

        public void mo1050a(Location location) {
            if (this.f1551a == null) {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = location;
            this.f1551a.sendMessage(obtain);
        }
    }

    public es(Context context, ew<er> ewVar) {
        this.f1553b = context;
        this.f1552a = ewVar;
    }

    public Location m2443a() {
        this.f1552a.mo1051a();
        try {
            return ((er) this.f1552a.mo1052c()).mo1019a(this.f1553b.getPackageName());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void m2444a(boolean z) {
        this.f1552a.mo1051a();
        ((er) this.f1552a.mo1052c()).mo1043a(z);
        this.f1555d = z;
    }

    public void m2445b() {
        try {
            synchronized (this.f1556e) {
                for (C0798d c0798d : this.f1556e.values()) {
                    if (c0798d != null) {
                        ((er) this.f1552a.mo1052c()).mo1035a(c0798d);
                    }
                }
                this.f1556e.clear();
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void m2446c() {
        if (this.f1555d) {
            try {
                m2444a(false);
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
