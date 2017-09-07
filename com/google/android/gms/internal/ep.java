package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.C0666c;
import com.google.android.gms.internal.el.C0792a;
import java.io.IOException;

public class ep extends el {

    class C0793a {
        final /* synthetic */ ep f1546a;
        private String f1547b;
        private boolean f1548c;

        public C0793a(ep epVar, String str, boolean z) {
            this.f1546a = epVar;
            this.f1547b = str;
            this.f1548c = z;
        }

        public String m2362a() {
            return this.f1547b;
        }

        public boolean m2363b() {
            return this.f1548c;
        }
    }

    protected ep(Context context, fl flVar, fn fnVar) {
        super(context, flVar, fnVar);
    }

    public static ep m2364a(String str, Context context) {
        fl cvVar = new cv();
        el.m2343a(str, context, cvVar);
        return new ep(context, cvVar, new fp(239));
    }

    protected void mo1011c(Context context) {
        super.mo1011c(context);
        try {
            C0793a h = mo1014h(context);
            m2203a(28, h.m2363b() ? 1 : 0);
            String a = h.m2362a();
            if (a != null) {
                m2203a(26, 5);
                m2204a(24, a);
            }
        } catch (C0666c e) {
            try {
                m2204a(24, el.m2349f(context));
            } catch (IOException e2) {
            } catch (C0792a e3) {
            }
        }
    }

    protected void mo1013d(Context context) {
        long j = 1;
        super.mo1011c(context);
        try {
            m2204a(24, el.m2349f(context));
        } catch (C0792a e) {
        }
        try {
            C0793a h = mo1014h(context);
            try {
                if (!h.m2363b()) {
                    j = 0;
                }
                m2203a(28, j);
                String a = h.m2362a();
                if (a != null) {
                    m2204a(30, a);
                }
            } catch (IOException e2) {
            }
        } catch (C0666c e3) {
        } catch (IOException e4) {
            m2203a(28, 1);
        }
    }

    C0793a mo1014h(Context context) {
        int i = 0;
        try {
            String str;
            Info b = AdvertisingIdClient.m1415b(context);
            String a = b.m1411a();
            if (a == null || !a.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$")) {
                str = a;
            } else {
                byte[] bArr = new byte[16];
                int i2 = 0;
                while (i < a.length()) {
                    if (i == 8 || i == 13 || i == 18 || i == 23) {
                        i++;
                    }
                    bArr[i2] = (byte) ((Character.digit(a.charAt(i), 16) << 4) + Character.digit(a.charAt(i + 1), 16));
                    i2++;
                    i += 2;
                }
                str = this.c.mo962a(bArr, true);
            }
            return new C0793a(this, str, b.m1412b());
        } catch (Throwable e) {
            throw new IOException(e);
        }
    }
}
