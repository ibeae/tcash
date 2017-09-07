package com.telkom.mwallet.tcash.payment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1272r;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.C1245f;
import com.skcc.wallet.framework.api.http.model.GetPaymentInfoRs;
import com.skcc.wallet.framework.api.http.model.GetTcashBalanceRs;
import com.skcc.wallet.framework.api.http.model.PayWithTcashRs;
import com.skcc.wallet.framework.api.http.model.TcashFavorite;
import com.skcc.wallet.framework.api.http.model.TcashTransactionRequest;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.C1539j;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.dialog.p063a.C1500i;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.p064a.C1358h;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import com.telkom.mwallet.tcash.TCashActivity;
import com.telkom.mwallet.tcash.payment.p069a.C1845d;
import com.telkom.mwallet.tcash.payment.p069a.C1846e;
import com.telkom.mwallet.tcash.payment.p069a.C1848f;

public class TCashKartuHaloActivity extends SlidingFrameActivity {
    private static final String f4879n = TCashKartuHaloActivity.class.getSimpleName();
    private C1298u f4880A;
    private C1272r f4881B;
    private C1539j f4882C;
    private String f4883D = null;
    private String f4884E = null;
    private String f4885F = null;
    private String f4886G = null;
    private String f4887H;
    private String f4888I = null;
    private C1846e f4889J;
    private boolean f4890K = false;
    private C1326f f4891L = new C18232(this);
    private C1326f f4892M = new C18243(this);
    TcashFavorite f4893k = null;
    int f4894l = -1;
    C1500i f4895m = new C18221(this);
    private C1845d f4896o;
    private C1848f f4897z = null;

    class C18221 implements C1500i {
        final /* synthetic */ TCashKartuHaloActivity f4876a;

        C18221(TCashKartuHaloActivity tCashKartuHaloActivity) {
            this.f4876a = tCashKartuHaloActivity;
        }

        public void mo1546a() {
            if (this.f4876a.f4882C != null) {
                this.f4876a.f4882C.dismiss();
            }
            long j = 0;
            if (this.f4876a.f4885F != null) {
                j = Long.parseLong(this.f4876a.f4885F);
            }
            this.f4876a.f4893k.setAmount(j);
            this.f4876a.f4893k.setDestinationNo(this.f4876a.f4884E);
            this.f4876a.f4893k.setMenuId("1100000");
            this.f4876a.f4893k.setPeriod("");
            this.f4876a.f4893k.setStartDate("");
            this.f4876a.m7012a(this.f4876a.f4893k);
        }

        public void mo1547a(int i) {
            this.f4876a.f4894l = i;
            this.f4876a.f4882C.dismiss();
            String a = C1354g.m4943a(i);
            this.f4876a.f4893k.setAmount(Long.parseLong(this.f4876a.f4885F));
            this.f4876a.f4893k.setDestinationNo(this.f4876a.f4884E);
            this.f4876a.f4893k.setMenuId("1100000");
            this.f4876a.f4893k.setPeriod(C1358h.f2930a);
            this.f4876a.f4893k.setStartDate(a);
            this.f4876a.m7012a(this.f4876a.f4893k);
        }
    }

    class C18232 implements C1326f {
        final /* synthetic */ TCashKartuHaloActivity f4877a;

        C18232(TCashKartuHaloActivity tCashKartuHaloActivity) {
            this.f4877a = tCashKartuHaloActivity;
        }

        public void mo1485a() {
            if (this.f4877a.h != null) {
                this.f4877a.h.dismiss();
            }
            if (this.f4877a.f4893k != null) {
                this.f4877a.f4882C.show(this.f4877a.getSupportFragmentManager(), "reminder_dialog_tag");
            } else if (this.f4877a.f4890K) {
                this.f4877a.m5016B();
            } else {
                Intent intent = new Intent(this.f4877a, TCashActivity.class);
                intent.setFlags(67108864);
                this.f4877a.startActivity(intent);
                this.f4877a.finish();
            }
        }

        public void mo1486b() {
        }
    }

    class C18243 implements C1326f {
        final /* synthetic */ TCashKartuHaloActivity f4878a;

        C18243(TCashKartuHaloActivity tCashKartuHaloActivity) {
            this.f4878a = tCashKartuHaloActivity;
        }

        public void mo1485a() {
            if (this.f4878a.h != null) {
                this.f4878a.h.dismiss();
            }
            this.f4878a.finish();
        }

        public void mo1486b() {
        }
    }

    private void m7012a(TcashFavorite tcashFavorite) {
        this.f4880A.m4699b(tcashFavorite, (C1245f) this);
    }

    private void m7022s() {
        this.f4882C = C1539j.m5687a();
        this.f4882C.m5690a(this.f4895m);
        this.f4880A.m4729i(this);
        m7023t();
    }

    private void m7023t() {
        TcashFavorite tcashFavorite = (TcashFavorite) getIntent().getSerializableExtra("Favorite");
        if (tcashFavorite != null && tcashFavorite.getDestinationNo() != null) {
            String destinationNo = tcashFavorite.getDestinationNo();
            if (!destinationNo.isEmpty() && destinationNo.length() > 3 && !this.f4881B.m4651b("msisdn", "").equals(destinationNo)) {
                this.f4896o.m7234b(destinationNo);
            }
        }
    }

    public void mo1487a() {
        m4990k();
        this.h = m4967a(this.f4892M, (int) R.string.no_network);
    }

    public void mo1488a(String str) {
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.f4881B.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f4892M, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f4879n, "onSuccessNetwork");
        this.f4881B.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("getTcashBalance".equalsIgnoreCase(str)) {
            this.f4889J.m7236b(String.valueOf(((GetTcashBalanceRs) obj).getTcashBalance()));
        } else if ("getPaymentInfo".equalsIgnoreCase(str)) {
            GetPaymentInfoRs getPaymentInfoRs = (GetPaymentInfoRs) obj;
            if (getPaymentInfoRs.getTcashTransaction() != null) {
                this.f4887H = getPaymentInfoRs.getTcashTransaction().getTransactionId();
                this.f4884E = getPaymentInfoRs.getTcashTransaction().getDestinationNo();
                this.f4885F = getPaymentInfoRs.getTcashTransaction().getAmount();
                this.f4888I = getPaymentInfoRs.getMenu().getDescription();
                this.f4886G = getPaymentInfoRs.getTcashTransaction().getFee();
            }
            mo1505o();
        } else if ("payWithTcash".equalsIgnoreCase(str)) {
            if (obj != null) {
                PayWithTcashRs payWithTcashRs = (PayWithTcashRs) obj;
                String str2 = "";
                this.h = C1514b.m5649a((int) R.string.title_success, m5018a((int) R.string.tcash_success_pay_menu_nominal_amount_date, getString(R.string.title_tcash_kartu), payWithTcashRs.getTcashTransaction().getDestinationNo(), C1354g.m4955f(payWithTcashRs.getTcashTransaction().getAmount()), C1354g.m4951c(payWithTcashRs.getTcashTransaction().getTransactionDate())));
                this.h.m5651a(this.f4891L);
                this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
                return;
            }
            m4990k();
            this.h = m4969a(this.f4892M, "");
        } else if ("setTcashFavoriteTransaction".equalsIgnoreCase(str)) {
            this.f4893k = null;
            this.h = C1514b.m5648a((int) R.string.title_success, (int) R.string.msg_setfavorite_success);
            this.h.m5651a(this.f4891L);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4967a(this.f4892M, (int) R.string.no_response);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    public void m7030e(String str) {
        this.f4884E = str;
    }

    public void m7031f(String str) {
        this.f4883D = str;
    }

    public void m7032g(String str) {
        this.f4893k = new TcashFavorite();
        this.f4893k.setFavoriteMenuName(str);
    }

    public void mo1505o() {
        this.f4897z = new C1848f();
        if (this.f4885F != null) {
            this.f4897z.m7240b(this.f4884E);
            this.f4897z.m7242f(this.f4885F);
            this.f4897z.m7241c(this.f4888I);
            this.f4897z.m7243g(this.f4886G);
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.tcash_payment_fragment, this.f4897z);
        beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        beginTransaction.commit();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        this.f4889J = new C1846e();
        super.m5019a(this.f4889J);
        super.onCreate(bundle);
        this.f4880A = this.a.m4739a();
        this.f4881B = this.a.m4745e();
        this.f4896o = new C1845d();
        this.f4896o.m7235c(this.f4881B.m4651b("msisdn", ""));
        getSupportFragmentManager().beginTransaction().add((int) R.id.tcash_payment_fragment, this.f4896o).commit();
        if (C1358h.f2943n.equals(getIntent().getStringExtra(C1358h.f2940k))) {
            this.f4890K = true;
        }
        m7022s();
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f4879n, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f4879n, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f4879n, " in onResume >>>>>");
    }

    public void m7034p() {
        this.f4885F = null;
        TcashTransactionRequest tcashTransactionRequest = new TcashTransactionRequest();
        tcashTransactionRequest.setMenuId("1100000");
        tcashTransactionRequest.setDestinationNo(this.f4884E);
        m4972a((Context) this, (int) R.string.loading);
        this.f4880A.m4720e(tcashTransactionRequest, (C1245f) this);
    }

    public void m7035q() {
        long parseLong = Long.parseLong(this.f4885F);
        TcashTransactionRequest tcashTransactionRequest = new TcashTransactionRequest();
        tcashTransactionRequest.setTcashPin(this.f4883D);
        tcashTransactionRequest.setMenuId("1100000");
        tcashTransactionRequest.setDestinationNo(this.f4884E);
        tcashTransactionRequest.setAmount(parseLong);
        tcashTransactionRequest.setTcashTransactionId(this.f4887H);
        m4972a((Context) this, (int) R.string.loading);
        this.f4880A.m4723f(tcashTransactionRequest, (C1245f) this);
    }

    public void m7036r() {
        this.f4893k = null;
    }
}
