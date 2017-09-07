package com.telkom.mwallet.tcash.tap;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings.Secure;
import com.appsflyer.ServerParameters;
import com.skcc.wallet.framework.api.C1272r;
import com.skcc.wallet.framework.api.C1298u;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import com.telkom.mwallet.tcash.tap.p071a.C1976b;
import com.telkom.mwallet.tcash.tap.p071a.C1977c;
import com.telkom.mwallet.tcash.tap.p072b.C2004d;
import java.util.Locale;

public class TCashTapActivity extends SlidingFrameActivity {
    static final String f5753k = TCashTapActivity.class.getSimpleName();
    private C1298u f5754l;
    private C2004d f5755m;
    private C1272r f5756n;

    private class C1973a extends C1972b {
        final /* synthetic */ TCashTapActivity f5752a;

        public C1973a(TCashTapActivity tCashTapActivity, C1359a c1359a) {
            this.f5752a = tCashTapActivity;
            super(c1359a);
        }

        public void mo1576a(int i, String str) {
            this.f5752a.b.m4647a("time for update", System.currentTimeMillis());
            this.f5752a.m4990k();
            C1976b c1976b = new C1976b(this.b);
            c1976b.m7896b();
            this.f5752a.f5755m.m8013a(c1976b.m7894a());
        }

        public void mo1577a(String str, String str2) {
            this.f5752a.b.m4647a("time for update", System.currentTimeMillis());
            this.f5752a.m4990k();
            C1977c c1977c = new C1977c();
            c1977c.m7900a(str2);
            c1977c.m7902b(str);
            c1977c.m7904c(str2);
            new C1976b(this.b).m7895a(c1977c);
            this.f5752a.f5755m.m8013a(c1977c);
        }
    }

    public void onCreate(Bundle bundle) {
        this.f5755m = new C2004d();
        super.m5019a(this.f5755m);
        super.onCreate(bundle);
        Secure.getString(getContentResolver(), ServerParameters.ANDROID_ID).toUpperCase(Locale.US);
        this.f5754l = this.a.m4739a();
        this.f5756n = this.a.m4745e();
        m4973a((Context) this, getString(R.string.loading));
        this.f5754l.m4679a(new C1973a(this, this));
    }
}
