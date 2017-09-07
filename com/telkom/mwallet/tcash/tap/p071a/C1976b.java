package com.telkom.mwallet.tcash.tap.p071a;

import android.content.Context;
import com.skcc.wallet.framework.api.C1272r;
import com.telkom.mwallet.TelkomApplication;
import com.telkom.mwallet.p064a.C1349c;
import com.telkom.mwallet.tcash.tap.p071a.C1975a.C1974a;

public class C1976b {
    static final String f5761a = C1976b.class.getSimpleName();
    private C1272r f5762b;

    public C1976b(Context context) {
        this.f5762b = ((TelkomApplication) context.getApplicationContext()).m4745e();
    }

    private String m7892c() {
        return C1349c.m4922b("activation_key" + this.f5762b.m4651b("customer_id", ""));
    }

    private boolean m7893d() {
        String b = this.f5762b.m4651b("activation_key", null);
        String c = m7892c();
        if (b != null && c.equals(b)) {
            return true;
        }
        this.f5762b.m4648a("activation_key", c);
        this.f5762b.m4646a("activation");
        return false;
    }

    public C1977c m7894a() {
        m7893d();
        String b = this.f5762b.m4651b("activation", null);
        return b != null ? new C1977c(b) : null;
    }

    public void m7895a(C1977c c1977c) {
        m7893d();
        this.f5762b.m4648a("activation", c1977c.toString());
    }

    public void m7896b() {
        C1977c c1977c = new C1977c();
        c1977c.m7899a(C1974a.NONE);
        c1977c.m7902b(null);
        c1977c.m7904c(null);
        m7895a(c1977c);
    }
}
