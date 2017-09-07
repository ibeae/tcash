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
import com.telkom.mwallet.tcash.cash.p068a.C1757a;

public class TCashInATMBersamaActivity extends SlidingFrameActivity {
    private static final String f4462l = TCashInATMBersamaActivity.class.getSimpleName();
    TcashFavorite f4463k = null;
    private C1298u f4464m;
    private C1539j f4465n;
    private C1757a f4466o;
    private C1326f f4467z = new C17451(this);

    class C17451 implements C1326f {
        final /* synthetic */ TCashInATMBersamaActivity f4461a;

        C17451(TCashInATMBersamaActivity tCashInATMBersamaActivity) {
            this.f4461a = tCashInATMBersamaActivity;
        }

        public void mo1485a() {
            if (this.f4461a.h != null) {
                this.f4461a.h.dismiss();
            }
        }

        public void mo1486b() {
            if (this.f4461a.h != null) {
                this.f4461a.h.dismiss();
            }
        }
    }

    public void mo1487a() {
        m4990k();
        this.h = m4967a(this.f4467z, (int) R.string.no_network);
    }

    public void mo1488a(String str) {
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        m4990k();
        this.h = m4969a(this.f4467z, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        m4990k();
        if ("getTcashBalance".equalsIgnoreCase(str)) {
            this.f4466o.m6754b(String.valueOf(((GetTcashBalanceRs) obj).getTcashBalance()));
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4967a(this.f4467z, (int) R.string.no_response);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        this.f4466o = new C1757a();
        super.m5019a(this.f4466o);
        super.onCreate(bundle);
        this.f4464m = this.a.m4739a();
        this.f4464m.m4729i(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f4465n != null && this.f4465n.isVisible()) {
            this.f4465n.dismiss();
        }
        C1216a.m4519a(f4462l, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f4462l, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f4462l, " in onResume >>>>>");
    }
}
