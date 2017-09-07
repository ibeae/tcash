package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.C0666c;
import com.google.android.gms.common.C0672e;
import com.google.android.gms.common.C0673g;
import com.google.android.gms.internal.ek;
import com.google.android.gms.internal.fr;
import com.google.android.gms.internal.fr.C0810a;
import java.io.IOException;

public final class AdvertisingIdClient {

    public static final class Info {
        private final String f827a;
        private final boolean f828b;

        public Info(String str, boolean z) {
            this.f827a = str;
            this.f828b = z;
        }

        public String m1411a() {
            return this.f827a;
        }

        public boolean m1412b() {
            return this.f828b;
        }
    }

    static Info m1413a(Context context, C0673g c0673g) {
        try {
            fr a = C0810a.m2563a(c0673g.m1479a());
            Info info = new Info(a.mo1068a(), a.mo1071a(true));
            try {
                context.unbindService(c0673g);
            } catch (Throwable e) {
                Log.i("AdvertisingIdClient", "getAdvertisingIdInfo unbindService failed.", e);
            }
            return info;
        } catch (Throwable e2) {
            Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
            throw new IOException("Remote exception");
        } catch (InterruptedException e3) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            try {
                context.unbindService(c0673g);
            } catch (Throwable e4) {
                Log.i("AdvertisingIdClient", "getAdvertisingIdInfo unbindService failed.", e4);
            }
        }
    }

    static C0673g m1414a(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            try {
                C0672e.m1474b(context);
                Object c0673g = new C0673g();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (context.bindService(intent, c0673g, 1)) {
                    return c0673g;
                }
                throw new IOException("Connection failure");
            } catch (Throwable e) {
                throw new IOException(e);
            }
        } catch (NameNotFoundException e2) {
            throw new C0666c(9);
        }
    }

    public static Info m1415b(Context context) {
        ek.m2339c("Calling this from your main thread can lead to deadlock");
        return m1413a(context, m1414a(context));
    }
}
