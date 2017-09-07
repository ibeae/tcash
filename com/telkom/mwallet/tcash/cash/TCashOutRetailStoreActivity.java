package com.telkom.mwallet.tcash.cash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1272r;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.C1245f;
import com.skcc.wallet.framework.api.http.model.GetTcashBalanceRs;
import com.skcc.wallet.framework.api.http.model.GetTcashTokenRs;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1531h;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.dialog.p063a.C1498g;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import com.telkom.mwallet.tcash.cash.p068a.C1778k;
import com.telkom.mwallet.tcash.fragment.C1803j;

public class TCashOutRetailStoreActivity extends SlidingFrameActivity {
    private static final String f4519l = TCashOutRetailStoreActivity.class.getSimpleName();
    C1531h f4520k;
    private C1298u f4521m;
    private C1272r f4522n;
    private C1778k f4523o;
    private C1326f f4524z = new C17562(this);

    class C17551 implements C1498g {
        final /* synthetic */ TCashOutRetailStoreActivity f4517a;

        C17551(TCashOutRetailStoreActivity tCashOutRetailStoreActivity) {
            this.f4517a = tCashOutRetailStoreActivity;
        }

        public void mo1544a() {
            this.f4517a.f4520k.dismiss();
        }

        public void mo1545a(String str) {
            this.f4517a.m6746e(str);
        }
    }

    class C17562 implements C1326f {
        final /* synthetic */ TCashOutRetailStoreActivity f4518a;

        C17562(TCashOutRetailStoreActivity tCashOutRetailStoreActivity) {
            this.f4518a = tCashOutRetailStoreActivity;
        }

        public void mo1485a() {
            if (this.f4518a.h != null) {
                this.f4518a.h.dismiss();
            }
        }

        public void mo1486b() {
            if (this.f4518a.h != null) {
                this.f4518a.h.dismiss();
            }
        }
    }

    private void m6746e(String str) {
        m4972a((Context) this, (int) R.string.loading);
        this.f4521m.m4724f(str, (C1245f) this);
    }

    public void mo1487a() {
        m4990k();
        this.h = m4967a(this.f4524z, (int) R.string.no_network);
    }

    public void mo1488a(String str) {
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.f4522n.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f4524z, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f4519l, "onSuccessNetwork");
        this.f4522n.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("getTcashToken".equalsIgnoreCase(str)) {
            GetTcashTokenRs getTcashTokenRs = (GetTcashTokenRs) obj;
            C1803j c1803j = new C1803j();
            c1803j.setStyle(0, R.style.tcash_menu_dialog);
            c1803j.m6918a(getTcashTokenRs.getTcashToken());
            c1803j.m6917a(System.currentTimeMillis());
            c1803j.show(getSupportFragmentManager(), null);
            this.f4522n.m4648a("TCASH_RETAIL_TOKEN", getTcashTokenRs.getTcashToken());
            this.f4522n.m4647a("TCASH_RETAIL_TIME", System.currentTimeMillis());
        } else if ("getTcashBalance".equalsIgnoreCase(str)) {
            this.f4523o.m6805b(String.valueOf(((GetTcashBalanceRs) obj).getTcashBalance()));
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4967a(this.f4524z, (int) R.string.no_response);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    public void mo1505o() {
        if (this.f4520k == null || this.f4520k.getDialog() == null || !this.f4520k.getDialog().isShowing()) {
            this.f4520k = C1531h.m5672a((int) R.string.msg_tcash_token_generated);
            this.f4520k.m5675a(new C17551(this));
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.add(this.f4520k, "pinconfirm");
            try {
                beginTransaction.commitAllowingStateLoss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        this.f4523o = new C1778k();
        super.m5019a(this.f4523o);
        super.onCreate(bundle);
        this.f4521m = this.a.m4739a();
        this.f4522n = this.a.m4745e();
        this.f4521m.m4729i(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f4519l, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f4519l, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f4519l, " in onResume >>>>>");
    }
}
