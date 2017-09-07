package com.telkom.mwallet.tcash.payment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import com.skcc.wallet.core.p057a.C1216a;
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
import com.telkom.mwallet.tcash.payment.p069a.C1838a;
import com.telkom.mwallet.tcash.payment.p069a.C1841b;
import com.telkom.mwallet.tcash.payment.p069a.C1843c;

public class TCashFixedLineActivity extends SlidingFrameActivity {
    private static final String f4858n = TCashFixedLineActivity.class.getSimpleName();
    private C1298u f4859A;
    private C1539j f4860B;
    private String f4861C = null;
    private String f4862D = null;
    private String f4863E = null;
    private String f4864F = null;
    private String f4865G;
    private String f4866H = null;
    private C1841b f4867I;
    private boolean f4868J = false;
    private C1326f f4869K = new C18202(this);
    private C1326f f4870L = new C18213(this);
    TcashFavorite f4871k = null;
    int f4872l;
    C1500i f4873m = new C18191(this);
    private C1838a f4874o;
    private C1843c f4875z = null;

    class C18191 implements C1500i {
        final /* synthetic */ TCashFixedLineActivity f4855a;

        C18191(TCashFixedLineActivity tCashFixedLineActivity) {
            this.f4855a = tCashFixedLineActivity;
        }

        public void mo1546a() {
            if (this.f4855a.f4860B != null) {
                this.f4855a.f4860B.dismiss();
            }
            long j = 0;
            if (this.f4855a.f4863E != null) {
                j = Long.parseLong(this.f4855a.f4863E);
            }
            this.f4855a.f4871k.setAmount(j);
            this.f4855a.f4871k.setDestinationNo(this.f4855a.f4862D);
            this.f4855a.f4871k.setMenuId("1510000");
            this.f4855a.f4871k.setPeriod("");
            this.f4855a.f4871k.setStartDate("");
            this.f4855a.m6980a(this.f4855a.f4871k);
        }

        public void mo1547a(int i) {
            this.f4855a.f4872l = i;
            this.f4855a.f4860B.dismiss();
            String a = C1354g.m4943a(i);
            this.f4855a.f4871k.setAmount(Long.parseLong(this.f4855a.f4863E));
            this.f4855a.f4871k.setDestinationNo(this.f4855a.f4862D);
            this.f4855a.f4871k.setMenuId("1510000");
            this.f4855a.f4871k.setPeriod(C1358h.f2930a);
            this.f4855a.f4871k.setStartDate(a);
            this.f4855a.m6980a(this.f4855a.f4871k);
        }
    }

    class C18202 implements C1326f {
        final /* synthetic */ TCashFixedLineActivity f4856a;

        C18202(TCashFixedLineActivity tCashFixedLineActivity) {
            this.f4856a = tCashFixedLineActivity;
        }

        public void mo1485a() {
            if (this.f4856a.h != null) {
                this.f4856a.h.dismiss();
            }
            if (this.f4856a.f4871k != null) {
                this.f4856a.f4860B.show(this.f4856a.getSupportFragmentManager(), "reminder_dialog_tag");
            } else if (this.f4856a.f4868J) {
                this.f4856a.m5016B();
            } else {
                Intent intent = new Intent(this.f4856a, TCashActivity.class);
                intent.setFlags(67108864);
                this.f4856a.startActivity(intent);
                this.f4856a.finish();
            }
        }

        public void mo1486b() {
        }
    }

    class C18213 implements C1326f {
        final /* synthetic */ TCashFixedLineActivity f4857a;

        C18213(TCashFixedLineActivity tCashFixedLineActivity) {
            this.f4857a = tCashFixedLineActivity;
        }

        public void mo1485a() {
            if (this.f4857a.h != null) {
                this.f4857a.h.dismiss();
            }
            this.f4857a.finish();
        }

        public void mo1486b() {
        }
    }

    private void m6980a(TcashFavorite tcashFavorite) {
        this.f4859A.m4699b(tcashFavorite, (C1245f) this);
    }

    private void m6990s() {
        this.f4860B = C1539j.m5687a();
        this.f4860B.m5690a(this.f4873m);
        this.f4859A.m4729i(this);
        m6991t();
    }

    private void m6991t() {
        TcashFavorite tcashFavorite = (TcashFavorite) getIntent().getSerializableExtra("Favorite");
        if (tcashFavorite != null && tcashFavorite.getDestinationNo() != null) {
            String destinationNo = tcashFavorite.getDestinationNo();
            if (!destinationNo.isEmpty()) {
                this.f4874o.m7194b(destinationNo);
            }
        }
    }

    public void mo1487a() {
        m4990k();
        this.h = m4967a(this.f4870L, (int) R.string.no_network);
    }

    public void mo1488a(String str) {
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f4870L, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f4858n, "onSuccessNetwork");
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("getTcashBalance".equalsIgnoreCase(str)) {
            this.f4867I.m7215b(String.valueOf(((GetTcashBalanceRs) obj).getTcashBalance()));
        } else if ("setTcashFavoriteTransaction".equalsIgnoreCase(str)) {
            this.f4871k = null;
            this.h = C1514b.m5648a((int) R.string.title_success, (int) R.string.msg_setfavorite_success);
            this.h.m5651a(this.f4869K);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        } else if ("getPaymentInfo".equalsIgnoreCase(str)) {
            GetPaymentInfoRs getPaymentInfoRs = (GetPaymentInfoRs) obj;
            if (getPaymentInfoRs.getTcashTransaction() != null) {
                this.f4865G = getPaymentInfoRs.getTcashTransaction().getTransactionId();
                this.f4862D = getPaymentInfoRs.getTcashTransaction().getDestinationNo();
                this.f4863E = getPaymentInfoRs.getTcashTransaction().getAmount();
                this.f4866H = getPaymentInfoRs.getMenu().getDescription();
                this.f4864F = getPaymentInfoRs.getTcashTransaction().getFee();
            }
            mo1505o();
        } else if ("payWithTcash".equalsIgnoreCase(str)) {
            PayWithTcashRs payWithTcashRs = (PayWithTcashRs) obj;
            this.h = C1514b.m5649a((int) R.string.title_success, m5018a((int) R.string.tcash_success_pay_menu_nominal_amount_date, getString(R.string.title_tcash_fixedline), payWithTcashRs.getTcashTransaction().getDestinationNo(), C1354g.m4955f(payWithTcashRs.getTcashTransaction().getAmount()), C1354g.m4951c(payWithTcashRs.getTcashTransaction().getTransactionDate())));
            this.h.m5651a(this.f4869K);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4967a(this.f4870L, (int) R.string.no_response);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    public void m6998e(String str) {
        this.f4871k = new TcashFavorite();
        this.f4871k.setFavoriteMenuName(str);
    }

    public void m6999f(String str) {
        this.f4862D = str;
    }

    public void m7000g(String str) {
        this.f4861C = str;
    }

    public void mo1505o() {
        this.f4875z = new C1843c();
        if (this.f4863E != null) {
            this.f4875z.m7221f(this.f4863E);
            this.f4875z.m7219b(this.f4862D);
            this.f4875z.m7220c(this.f4866H);
            this.f4875z.m7222g(this.f4864F);
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.tcash_payment_fragment, this.f4875z);
        beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        beginTransaction.commit();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        this.f4867I = new C1841b();
        super.m5019a(this.f4867I);
        super.onCreate(bundle);
        this.f4859A = this.a.m4739a();
        this.f4874o = new C1838a();
        getSupportFragmentManager().beginTransaction().add((int) R.id.tcash_payment_fragment, this.f4874o).commit();
        if (C1358h.f2943n.equals(getIntent().getStringExtra(C1358h.f2940k))) {
            this.f4868J = true;
        }
        m6990s();
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f4858n, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f4858n, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f4858n, " in onResume >>>>>");
    }

    public void m7002p() {
        this.f4863E = null;
        TcashTransactionRequest tcashTransactionRequest = new TcashTransactionRequest();
        tcashTransactionRequest.setMenuId("1510000");
        tcashTransactionRequest.setDestinationNo(this.f4862D);
        m4972a((Context) this, (int) R.string.loading);
        this.f4859A.m4720e(tcashTransactionRequest, (C1245f) this);
    }

    public void m7003q() {
        long parseLong = Long.parseLong(this.f4863E);
        TcashTransactionRequest tcashTransactionRequest = new TcashTransactionRequest();
        tcashTransactionRequest.setTcashPin(this.f4861C);
        tcashTransactionRequest.setMenuId("1510000");
        tcashTransactionRequest.setFee(this.f4864F);
        tcashTransactionRequest.setDestinationNo(this.f4862D);
        tcashTransactionRequest.setAmount(parseLong);
        tcashTransactionRequest.setTcashTransactionId(this.f4865G);
        m4972a((Context) this, (int) R.string.loading);
        this.f4859A.m4723f(tcashTransactionRequest, (C1245f) this);
    }

    public void m7004r() {
        this.f4871k = null;
    }
}
