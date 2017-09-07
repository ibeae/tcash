package com.telkom.mwallet.tcash.cash;

import android.content.Intent;
import android.os.Bundle;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.model.GetTcashBalanceRs;
import com.skcc.wallet.framework.api.http.model.TcashFavorite;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1539j;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import com.telkom.mwallet.tcash.cash.p068a.C1774i;

public class TCashOutGrapariActivity extends SlidingFrameActivity {
    private static final String f4511l = TCashOutGrapariActivity.class.getSimpleName();
    TcashFavorite f4512k = null;
    private C1298u f4513m;
    private C1539j f4514n;
    private C1774i f4515o;
    private C1326f f4516z = new C17541(this);

    class C17541 implements C1326f {
        final /* synthetic */ TCashOutGrapariActivity f4510a;

        C17541(TCashOutGrapariActivity tCashOutGrapariActivity) {
            this.f4510a = tCashOutGrapariActivity;
        }

        public void mo1485a() {
            if (this.f4510a.h != null) {
                this.f4510a.h.dismiss();
            }
        }

        public void mo1486b() {
            if (this.f4510a.h != null) {
                this.f4510a.h.dismiss();
            }
        }
    }

    public void mo1487a() {
        m4990k();
        this.h = m4968a(this.f4516z, (int) R.string.no_network, false);
    }

    public void mo1488a(String str) {
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f4516z, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f4511l, "onSuccessNetwork");
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("getTcashBalance".equalsIgnoreCase(str)) {
            this.f4515o.m6800b(String.valueOf(((GetTcashBalanceRs) obj).getTcashBalance()));
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4968a(this.f4516z, (int) R.string.no_response, false);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        this.f4515o = new C1774i();
        super.m5019a(this.f4515o);
        super.onCreate(bundle);
        this.f4513m = this.a.m4739a();
        this.f4513m.m4729i(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f4514n != null && this.f4514n.isVisible()) {
            this.f4514n.dismiss();
        }
        C1216a.m4519a(f4511l, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f4511l, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f4511l, " in onResume >>>>>");
    }
}
