package com.telkom.mwallet.tcash.cash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.model.GetTcashBalanceRs;
import com.skcc.wallet.framework.api.http.model.TcashFavorite;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1539j;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import com.telkom.mwallet.tcash.TCashMapActivity;
import com.telkom.mwallet.tcash.cash.p068a.C1764d;

public class TCashInRetailStoreActivity extends SlidingFrameActivity {
    private static final String f4477l = TCashInRetailStoreActivity.class.getSimpleName();
    private C1326f f4478A = new C17482(this);
    TcashFavorite f4479k = null;
    private C1298u f4480m;
    private C1539j f4481n;
    private C1764d f4482o;
    private OnClickListener f4483z = new C17471(this);

    class C17471 implements OnClickListener {
        final /* synthetic */ TCashInRetailStoreActivity f4475a;

        C17471(TCashInRetailStoreActivity tCashInRetailStoreActivity) {
            this.f4475a = tCashInRetailStoreActivity;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_cash_in_retail_store_find_button:
                case R.id.tcash_cash_in_retail_store_find_imageview:
                    Intent intent = new Intent(this.f4475a, TCashMapActivity.class);
                    intent.putExtra("MAP_TYPE", "MAP_MENU_RETAIL_STORE");
                    this.f4475a.startActivity(intent);
                    return;
                default:
                    return;
            }
        }
    }

    class C17482 implements C1326f {
        final /* synthetic */ TCashInRetailStoreActivity f4476a;

        C17482(TCashInRetailStoreActivity tCashInRetailStoreActivity) {
            this.f4476a = tCashInRetailStoreActivity;
        }

        public void mo1485a() {
            if (this.f4476a.h != null) {
                this.f4476a.h.dismiss();
            }
        }

        public void mo1486b() {
            if (this.f4476a.h != null) {
                this.f4476a.h.dismiss();
            }
        }
    }

    public void mo1487a() {
        m4990k();
        this.h = m4968a(this.f4478A, (int) R.string.no_network, false);
    }

    public void mo1488a(String str) {
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f4478A, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f4477l, "onSuccessNetwork");
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("getTcashBalance".equalsIgnoreCase(str)) {
            this.f4482o.m6769b(String.valueOf(((GetTcashBalanceRs) obj).getTcashBalance()));
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4968a(this.f4478A, (int) R.string.no_response, false);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        this.f4482o = new C1764d();
        super.m5019a(this.f4482o);
        super.onCreate(bundle);
        this.f4480m = this.a.m4739a();
        this.f4480m.m4729i(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f4481n != null && this.f4481n.isVisible()) {
            this.f4481n.dismiss();
        }
        C1216a.m4519a(f4477l, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f4477l, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f4477l, " in onResume >>>>>");
    }
}
