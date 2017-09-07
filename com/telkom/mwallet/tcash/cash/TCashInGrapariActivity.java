package com.telkom.mwallet.tcash.cash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.model.GetTcashBalanceRs;
import com.skcc.wallet.framework.api.http.model.TcashFavorite;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1539j;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import com.telkom.mwallet.tcash.cash.p068a.C1759b;

public class TCashInGrapariActivity extends SlidingFrameActivity {
    private static final String f4469l = TCashInGrapariActivity.class.getSimpleName();
    TcashFavorite f4470k = null;
    private C1298u f4471m;
    private C1539j f4472n;
    private C1759b f4473o;
    private C1326f f4474z = new C17461(this);

    class C17461 implements C1326f {
        final /* synthetic */ TCashInGrapariActivity f4468a;

        C17461(TCashInGrapariActivity tCashInGrapariActivity) {
            this.f4468a = tCashInGrapariActivity;
        }

        public void mo1485a() {
            if (this.f4468a.h != null) {
                this.f4468a.h.dismiss();
            }
        }

        public void mo1486b() {
            if (this.f4468a.h != null) {
                this.f4468a.h.dismiss();
            }
        }
    }

    private void m6668o() {
        this.f4471m.m4729i(this);
        this.d.m4933a((Context) this, (LinearLayout) findViewById(R.id.tcash_top_layout));
    }

    public void mo1487a() {
        m4990k();
        this.h = m4968a(this.f4474z, (int) R.string.no_network, false);
    }

    public void mo1488a(String str) {
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f4474z, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f4469l, "onSuccessNetwork");
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("getTcashBalance".equalsIgnoreCase(str)) {
            this.f4473o.m6756b(String.valueOf(((GetTcashBalanceRs) obj).getTcashBalance()));
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4968a(this.f4474z, (int) R.string.no_response, false);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        this.f4473o = new C1759b();
        super.m5019a(this.f4473o);
        super.onCreate(bundle);
        this.f4471m = this.a.m4739a();
        m6668o();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f4472n != null && this.f4472n.isVisible()) {
            this.f4472n.dismiss();
        }
        C1216a.m4519a(f4469l, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f4469l, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f4469l, " in onResume >>>>>");
    }
}
