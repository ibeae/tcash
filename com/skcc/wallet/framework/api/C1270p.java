package com.skcc.wallet.framework.api;

import android.text.TextUtils;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.core.se.ISEMedia;
import com.skcc.wallet.core.se.SEConnectionListener;
import com.skcc.wallet.core.se.SException;
import com.skcc.wallet.core.se.instance.CRSApplication;
import com.skcc.wallet.core.se.instance.CardManager;
import com.skcc.wallet.core.se.instance.Vsdc;
import com.skcc.wallet.core.se.uicc.UICCSimAlliance;
import com.skcc.wallet.framework.C1302b;
import com.skcc.wallet.framework.p061c.C1306c;
import java.io.IOException;

public class C1270p implements SEConnectionListener {
    private ISEMedia f2687a = null;
    private CardManager f2688b = null;
    private CRSApplication f2689c = null;
    private C1261k f2690d = null;
    private C1302b f2691e;
    private boolean f2692f = false;
    private int f2693g = -999;
    private C1226b f2694h = null;

    class C12671 implements Runnable {
        final /* synthetic */ C1270p f2684a;

        class C12661 implements Runnable {
            final /* synthetic */ C12671 f2683a;

            C12661(C12671 c12671) {
                this.f2683a = c12671;
            }

            public void run() {
                boolean selectAppletAID;
                try {
                    selectAppletAID = this.f2683a.f2684a.f2689c.selectAppletAID("A000000003101001");
                } catch (Exception e) {
                    Exception exception = e;
                    exception.printStackTrace();
                    ((C1302b) this.f2683a.f2684a.f2691e.getApplicationContext()).m4740a(exception);
                    selectAppletAID = false;
                }
                if (selectAppletAID) {
                    selectAppletAID = this.f2683a.f2684a.f2691e.m4742b().m4643e();
                }
                if (selectAppletAID) {
                    if (this.f2683a.f2684a.f2690d != null) {
                        this.f2683a.f2684a.f2690d.mo1471a();
                        this.f2683a.f2684a.f2690d = null;
                    }
                } else if (this.f2683a.f2684a.f2690d != null) {
                    this.f2683a.f2684a.f2690d.mo1472b();
                    this.f2683a.f2684a.f2690d = null;
                }
            }
        }

        C12671(C1270p c1270p) {
            this.f2684a = c1270p;
        }

        public void run() {
            C1306c.m4764a(new C12661(this));
        }
    }

    class C12692 implements Runnable {
        final /* synthetic */ C1270p f2686a;

        class C12681 implements Runnable {
            final /* synthetic */ C12692 f2685a;

            C12681(C12692 c12692) {
                this.f2685a = c12692;
            }

            public void run() {
                if (this.f2685a.f2686a.f2687a != null) {
                    this.f2685a.f2686a.m4640b();
                }
                if (this.f2685a.f2686a.f2690d != null) {
                    this.f2685a.f2686a.f2690d.mo1472b();
                    this.f2685a.f2686a.f2690d = null;
                }
            }
        }

        C12692(C1270p c1270p) {
            this.f2686a = c1270p;
        }

        public void run() {
            C1306c.m4764a(new C12681(this));
        }
    }

    public C1270p(C1302b c1302b) {
        this.f2691e = c1302b;
        this.f2687a = new UICCSimAlliance(c1302b);
        this.f2688b = new CardManager(this.f2687a);
        this.f2689c = new CRSApplication(this.f2687a);
        this.f2692f = true;
    }

    public void m4638a() {
        this.f2692f = true;
        if (!m4642d()) {
            C1216a.m4519a("SEManager", "SeMedia>>>>>>>>>>" + this.f2687a);
            if (this.f2687a == null) {
                this.f2687a = new UICCSimAlliance(this.f2691e);
            }
            this.f2687a.setSEListener(this);
            try {
                C1216a.m4519a("SEManager", "SeMedia>>>>>>>>>>" + this.f2687a.openConnection());
            } catch (IOException e) {
                e.printStackTrace();
                onSEConnectionFail();
            }
        }
    }

    public void m4639a(C1261k c1261k) {
        this.f2690d = c1261k;
    }

    public void m4640b() {
        this.f2692f = false;
        if (m4642d()) {
            try {
                this.f2687a.closeConnection();
                C1216a.m4519a("SEManager", "disconnect>>>>>>>>>>>>>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.f2687a = null;
    }

    public C1226b m4641c() {
        if (!this.f2687a.isConnected()) {
            return null;
        }
        if (this.f2694h == null) {
            this.f2694h = new C1226b(this.f2689c, this.f2691e);
        }
        return this.f2694h;
    }

    public boolean m4642d() {
        return this.f2687a != null && this.f2687a.isConnected();
    }

    public boolean m4643e() {
        String str = "A000000003101001";
        try {
            this.f2689c.activateApp(str);
            Vsdc vsdc = new Vsdc(this.f2687a, str);
            vsdc.getData();
            CharSequence cardNumber = vsdc.getCardNumber();
            CharSequence expirationDate = vsdc.getExpirationDate();
            if (TextUtils.isEmpty(cardNumber) || TextUtils.isEmpty(expirationDate)) {
                return false;
            }
            try {
                this.f2689c.deactivateApp(str);
                return true;
            } catch (SException e) {
                e.printStackTrace();
                return false;
            }
        } catch (SException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void onSEConnected() {
        C1216a.m4519a("SEManager", "onSEConnected>>>>>>>>>>>>>>>>>");
        new Thread(new C12671(this)).start();
    }

    public void onSEConnectionFail() {
        C1216a.m4519a("SEManager", "onSEConnectionFail>>>>>>>>>>>>>>>>>");
        new Thread(new C12692(this)).start();
    }

    public void onSEDisconnected() {
        C1216a.m4519a("SEManager", "onSEDisconnected>>>>>>>>>>>>>>>>>");
        if (this.f2692f) {
            m4638a();
            return;
        }
        this.f2687a.setSEListener(null);
        this.f2687a = null;
    }
}
