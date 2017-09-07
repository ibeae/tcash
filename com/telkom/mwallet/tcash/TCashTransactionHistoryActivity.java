package com.telkom.mwallet.tcash;

import android.content.Context;
import android.os.Bundle;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.C1245f;
import com.skcc.wallet.framework.api.http.model.GetTcashTransactionHistoryRs;
import com.skcc.wallet.framework.api.http.model.ServiceVo;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import com.telkom.mwallet.tcash.fragment.C1810l;

public class TCashTransactionHistoryActivity extends SlidingFrameActivity {
    private static final String f4430l = TCashTransactionHistoryActivity.class.getSimpleName();
    ServiceVo f4431k;
    private C1298u f4432m;
    private C1810l f4433n;
    private C1326f f4434o = new C17411(this);

    class C17411 implements C1326f {
        final /* synthetic */ TCashTransactionHistoryActivity f4429a;

        C17411(TCashTransactionHistoryActivity tCashTransactionHistoryActivity) {
            this.f4429a = tCashTransactionHistoryActivity;
        }

        public void mo1485a() {
            if (this.f4429a.h != null) {
                this.f4429a.h.dismiss();
            }
            this.f4429a.finish();
        }

        public void mo1486b() {
        }
    }

    public void mo1487a() {
        m4990k();
        this.h = m4967a(this.f4434o, (int) R.string.no_network);
    }

    public void m6608a(int i) {
        m4973a((Context) this, getString(R.string.loading));
        this.f4432m.m4670a(10, (long) (i + 1), (C1245f) this);
    }

    public void mo1488a(String str) {
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f4434o, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f4430l, "onSuccessNetwork");
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("getTcashTransactionHistory".equalsIgnoreCase(str)) {
            this.f4433n.m6933a(((GetTcashTransactionHistoryRs) obj).getTransactions());
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4967a(this.f4434o, (int) R.string.no_response);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    public void onBackPressed() {
        finish();
    }

    public void onCreate(Bundle bundle) {
        this.f4433n = new C1810l();
        super.m5019a(this.f4433n);
        super.onCreate(bundle);
        this.f4432m = this.a.m4739a();
        this.f4431k = (ServiceVo) getIntent().getSerializableExtra("SELECTED_CARD");
        m4972a((Context) this, (int) R.string.loading);
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f4430l, " in onDestroy >>>>>");
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f4430l, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f4430l, " in onResume >>>>>");
    }
}
