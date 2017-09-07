package com.telkom.mwallet.setting.tcash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.AppEventsConstants;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.C1245f;
import com.skcc.wallet.framework.api.http.model.GetTcashBalanceRs;
import com.skcc.wallet.framework.api.http.model.GetTcashFavoriteTransactionRs;
import com.skcc.wallet.framework.api.http.model.GetTemplateInfoRs;
import com.skcc.wallet.framework.api.http.model.MenuTemplate;
import com.skcc.wallet.framework.api.http.model.TcashFavorite;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import com.telkom.mwallet.tcash.TCashAirtimeActivity;
import com.telkom.mwallet.tcash.TCashTransferActivity;
import com.telkom.mwallet.tcash.cash.TCashInSMSBankingActivity;
import com.telkom.mwallet.tcash.cash.p068a.C1762c;
import com.telkom.mwallet.tcash.fragment.C1805k;
import com.telkom.mwallet.tcash.payment.TCashFixedLineActivity;
import com.telkom.mwallet.tcash.payment.TCashKartuHaloActivity;
import com.telkom.mwallet.tcash.payment.TCashOthersActivity;
import com.telkom.mwallet.tcash.payment.TCashPDAMActivity;
import com.telkom.mwallet.tcash.payment.TCashPLNActivity;
import com.telkom.mwallet.tcash.payment.TCashPaymentTemplateActivity;
import com.telkom.mwallet.tcash.purchase.TCashMerchantActivty;
import com.telkom.mwallet.tcash.purchase.TCashPurchaseActivity;

public class TCashFavoriteListActivity extends SlidingFrameActivity {
    public static final String f4130k = TCashFavoriteListActivity.class.getSimpleName();
    private C1326f f4131A = new C16512(this);
    private C1326f f4132B = new C16523(this);
    private C1326f f4133C = new C16534(this);
    private FragmentManager f4134l;
    private C1298u f4135m;
    private TcashFavorite f4136n;
    private C1673a f4137o;
    private OnClickListener f4138z = new C16501(this);

    class C16501 implements OnClickListener {
        final /* synthetic */ TCashFavoriteListActivity f4126a;

        C16501(TCashFavoriteListActivity tCashFavoriteListActivity) {
            this.f4126a = tCashFavoriteListActivity;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_favorite_cash_in_button:
                    this.f4126a.mo1505o();
                    return;
                default:
                    return;
            }
        }
    }

    class C16512 implements C1326f {
        final /* synthetic */ TCashFavoriteListActivity f4127a;

        C16512(TCashFavoriteListActivity tCashFavoriteListActivity) {
            this.f4127a = tCashFavoriteListActivity;
        }

        public void mo1485a() {
            if (this.f4127a.h != null) {
                this.f4127a.h.dismiss();
            }
            this.f4127a.finish();
        }

        public void mo1486b() {
        }
    }

    class C16523 implements C1326f {
        final /* synthetic */ TCashFavoriteListActivity f4128a;

        C16523(TCashFavoriteListActivity tCashFavoriteListActivity) {
            this.f4128a = tCashFavoriteListActivity;
        }

        public void mo1485a() {
            if (this.f4128a.h != null) {
                this.f4128a.h.dismiss();
            }
        }

        public void mo1486b() {
            if (this.f4128a.h != null) {
                this.f4128a.h.dismiss();
            }
        }
    }

    class C16534 implements C1326f {
        final /* synthetic */ TCashFavoriteListActivity f4129a;

        C16534(TCashFavoriteListActivity tCashFavoriteListActivity) {
            this.f4129a = tCashFavoriteListActivity;
        }

        public void mo1485a() {
            if (this.f4129a.h != null) {
                this.f4129a.h.dismiss();
            }
            this.f4129a.f4137o.m6355a(this.f4129a.f4136n);
        }

        public void mo1486b() {
        }
    }

    private void m6262q() {
        this.f4134l = getSupportFragmentManager();
    }

    public void mo1487a() {
        m4990k();
        this.h = m4968a(this.f4131A, (int) R.string.no_network, false);
    }

    public void m6264a(TcashFavorite tcashFavorite) {
        this.f4136n = tcashFavorite;
        m4972a((Context) this, (int) R.string.loading);
        this.f4135m.m4728h(tcashFavorite.getMenuId(), this);
    }

    public void m6265a(TcashFavorite tcashFavorite, MenuTemplate menuTemplate) {
        Intent intent = new Intent();
        String menuId = tcashFavorite.getMenuId();
        C1216a.m4522b("sel", "menuId[" + menuId + "]");
        if (menuId.startsWith("3100")) {
            intent.setClass(this, TCashAirtimeActivity.class);
            intent.putExtra("Favorite", tcashFavorite);
            intent.putExtra("TCASH_MENU_ID", menuId);
            startActivity(intent);
            finish();
        } else if ("1100000".equals(menuId)) {
            intent.setClass(this, TCashKartuHaloActivity.class);
            intent.putExtra("Favorite", tcashFavorite);
            startActivity(intent);
            finish();
        } else if ("1210000".equals(menuId) || "1220000".equals(menuId)) {
            intent.setClass(this, TCashPLNActivity.class);
            intent.putExtra("Favorite", tcashFavorite);
            intent.putExtra("TCASH_MENU_ID", menuId);
            startActivity(intent);
            finish();
        } else if ("1510000".equals(menuId)) {
            intent.setClass(this, TCashFixedLineActivity.class);
            intent.putExtra("Favorite", tcashFavorite);
            startActivity(intent);
            finish();
        } else if (menuId.startsWith("1610")) {
            intent.setClass(this, TCashPDAMActivity.class);
            intent.putExtra("Favorite", tcashFavorite);
            intent.putExtra("TCASH_MENU_ID", menuId);
            startActivity(intent);
            finish();
        } else if (menuId.startsWith("13") || menuId.startsWith("14") || menuId.startsWith("3410") || menuId.startsWith("3510")) {
            intent.setClass(this, TCashPaymentTemplateActivity.class);
            intent.putExtra("TCASH_MENU_ID", menuId);
            intent.putExtra("TCASH_SUB_MENU_ID", menuTemplate.getSubMenuId());
            intent.putExtra("TCASH_MENU_NAME", menuTemplate.getMenuName());
            intent.putExtra("TCASH_SUB_MENU_NAME", menuTemplate.getSubMenuName());
            intent.putExtra("TCASH_TEMPLATE_ID", menuTemplate.getTemplateName());
            intent.putExtra("Favorite", tcashFavorite);
            startActivity(intent);
            finish();
        } else if (menuId.startsWith("9100000")) {
            intent.setClass(this, TCashOthersActivity.class);
            intent.putExtra("Favorite", tcashFavorite);
            startActivity(intent);
            finish();
        } else if (menuId.startsWith("2400") || menuId.startsWith("2500") || menuId.startsWith("2300") || menuId.startsWith("2200")) {
            intent.setClass(this, TCashPurchaseActivity.class);
            intent.putExtra("TCASH_MENU_ID", menuId);
            intent.putExtra("TCASH_SUB_MENU_ID", menuTemplate.getSubMenuId());
            intent.putExtra("TCASH_SUB_MENU_NAME", menuTemplate.getSubMenuName());
            intent.putExtra("TCASH_TEMPLATE_ID", menuTemplate.getTemplateName());
            intent.putExtra("Favorite", tcashFavorite);
            startActivity(intent);
            finish();
        } else if (menuId.startsWith("8100000")) {
            intent.setClass(this, TCashMerchantActivty.class);
            intent.putExtra("Favorite", tcashFavorite);
            startActivity(intent);
            finish();
        } else if ("4100000".equals(menuId)) {
            intent.setClass(this, TCashTransferActivity.class);
            intent.putExtra("Favorite", tcashFavorite);
            startActivity(intent);
            finish();
        } else if ("4200000".equals(menuId)) {
            intent.setClass(this, TCashTransferActivity.class);
            intent.putExtra("Favorite", tcashFavorite);
            startActivity(intent);
            finish();
        } else if ("5131000".equals(menuId) || "5133000".equals(menuId) || "5132000".equals(menuId)) {
            intent.setClass(this, TCashInSMSBankingActivity.class);
            intent.putExtra("Favorite", tcashFavorite);
            intent.putExtra("TCASH_MENU_ID", menuId);
            startActivity(intent);
            finish();
        }
    }

    public void mo1488a(String str) {
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f4131A, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f4130k, "onSuccessNetwork");
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("getTcashBalance".equalsIgnoreCase(str)) {
            this.f4137o.m6357b(String.valueOf(((GetTcashBalanceRs) obj).getTcashBalance()));
        } else if ("getTemplateInfo".equalsIgnoreCase(str)) {
            m6265a(this.f4136n, ((GetTemplateInfoRs) obj).getMenuTemplate());
        } else if ("getTcashFavoriteTransaction".equalsIgnoreCase(str)) {
            this.f4137o.m6356a(((GetTcashFavoriteTransactionRs) obj).getTcashFavorites());
        } else if ("removeTcashFavoriteTransaction".equalsIgnoreCase(str)) {
            this.h = C1514b.m5648a((int) R.string.title_success, (int) R.string.favorite_delete_message);
            this.h.m5651a(this.f4133C);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        } else if ("changeTcashFavoriteTransaction".equalsIgnoreCase(str)) {
            this.f4135m.m4719e(this);
            this.h = C1514b.m5648a((int) R.string.title_success, (int) R.string.favorite_edite_message);
            this.h.m5651a(this.f4132B);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4968a(this.f4131A, (int) R.string.no_response, false);
    }

    public void m6270b(TcashFavorite tcashFavorite) {
        this.f4136n = tcashFavorite;
        this.f4135m.m4730i(this.f4136n.getFavoriteMenuId(), this);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    public void m6272c(TcashFavorite tcashFavorite) {
        this.f4135m.m4674a(tcashFavorite, (C1245f) this);
    }

    public String m6273e(String str) {
        String str2 = "";
        return (str == null || str.isEmpty()) ? str2 : (str.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_YES) || str.startsWith("3410") || str.startsWith("3510") || str.startsWith("9100000")) ? getString(R.string.button_payment) : (str.startsWith("2") || str.startsWith("3310") || str.startsWith("8100000")) ? getString(R.string.button_retail_purchase) : str.startsWith("3100") ? getString(R.string.button_airtime_data_purchase) : str.startsWith("4") ? getString(R.string.button_transfer) : str.startsWith("51") ? getString(R.string.title_cash_in) : str.startsWith("52") ? getString(R.string.title_cash_out) : str2;
    }

    public void mo1505o() {
        C1762c c1762c = new C1762c();
        c1762c.m6766a(getApplicationContext());
        c1762c.setStyle(0, R.style.tcash_menu_dialog);
        c1762c.show(this.f4134l, null);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        this.f4137o = new C1673a();
        super.m5019a(this.f4137o);
        super.onCreate(bundle);
        this.f4134l = getSupportFragmentManager();
        this.f4135m = this.a.m4739a();
        this.f4136n = new TcashFavorite();
        m6262q();
        m4972a((Context) this, (int) R.string.loading);
        this.f4135m.m4729i(this);
        this.f4135m.m4719e(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f4130k, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f4130k, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f4130k, " in onResume >>>>>");
    }

    public void m6275p() {
        C1805k c1805k = new C1805k();
        c1805k.m6922a(getApplicationContext());
        c1805k.setStyle(0, R.style.tcash_menu_dialog);
        c1805k.show(this.f4134l, null);
    }
}
