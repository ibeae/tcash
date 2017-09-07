package com.telkom.mwallet;

import android.app.Application;
import android.os.Handler;
import com.skcc.wallet.core.p057a.C1216a;
import java.util.Timer;
import java.util.TimerTask;

public class C1490d {
    private static final String f3522a = C1490d.class.getSimpleName();
    private TelkomApplication f3523b;
    private Timer f3524c;
    private C1341b f3525d;
    private int f3526e = 0;
    private Handler f3527f;

    class C14891 extends TimerTask {
        final /* synthetic */ C1490d f3521a;

        class C14881 implements Runnable {
            final /* synthetic */ C14891 f3520a;

            C14881(C14891 c14891) {
                this.f3520a = c14891;
            }

            public void run() {
                this.f3520a.f3521a.f3526e = 0;
                if (this.f3520a.f3521a.f3525d != null) {
                    this.f3520a.f3521a.f3525d.mo1498a();
                }
                this.f3520a.f3521a.f3524c.cancel();
            }
        }

        C14891(C1490d c1490d) {
            this.f3521a = c1490d;
        }

        public void run() {
            if (this.f3521a.f3523b.m4897h()) {
                this.f3521a.f3526e = 0;
                this.f3521a.f3523b.m4894a(false);
            }
            C1216a.m4519a(C1490d.f3522a, " Session Check " + this.f3521a.f3526e);
            if (C1490d.m5606c(this.f3521a) >= 600) {
                this.f3521a.f3527f.post(new C14881(this));
            }
        }
    }

    public C1490d(Application application) {
        this.f3523b = (TelkomApplication) application;
        this.f3527f = new Handler();
    }

    static /* synthetic */ int m5606c(C1490d c1490d) {
        int i = c1490d.f3526e + 1;
        c1490d.f3526e = i;
        return i;
    }

    public void m5611a() {
        this.f3524c = new Timer();
        this.f3524c.scheduleAtFixedRate(new C14891(this), 0, 1000);
    }

    public void m5612a(C1341b c1341b) {
        this.f3525d = c1341b;
    }

    public void m5613b() {
        if (this.f3524c != null) {
            this.f3524c.cancel();
        }
    }
}
