package com.telkom.mwallet.tcash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1272r;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.C1245f;
import com.skcc.wallet.framework.api.http.model.GetTcashBalanceRs;
import com.skcc.wallet.framework.api.http.model.GetTransferInfoRs;
import com.skcc.wallet.framework.api.http.model.TcashFavorite;
import com.skcc.wallet.framework.api.http.model.TcashTransactionRequest;
import com.skcc.wallet.framework.api.http.model.TransferType;
import com.skcc.wallet.framework.api.http.model.TransferWithTcashRs;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.C1539j;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.dialog.p063a.C1500i;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.p064a.C1358h;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import com.telkom.mwallet.tcash.fragment.C1815m;
import com.telkom.mwallet.tcash.fragment.C1816n;
import com.telkom.mwallet.tcash.fragment.C1818o;
import java.util.HashMap;
import java.util.Map;

public class TCashTransferActivity extends SlidingFrameActivity {
    private static final String f4438n = TCashTransferActivity.class.getSimpleName();
    private C1298u f4439A;
    private C1272r f4440B;
    private C1539j f4441C;
    private String f4442D = null;
    private String f4443E = null;
    private String f4444F;
    private String f4445G = null;
    private String f4446H = null;
    private String f4447I = null;
    private String f4448J = null;
    private TransferType f4449K = null;
    private String f4450L = null;
    private String f4451M = null;
    private C1816n f4452N;
    private Map<String, String> f4453O = null;
    private C1326f f4454P = new C17432(this);
    private C1326f f4455Q = new C17443(this);
    TcashFavorite f4456k = null;
    int f4457l;
    C1500i f4458m = new C17421(this);
    private C1815m f4459o;
    private C1818o f4460z = null;

    class C17421 implements C1500i {
        final /* synthetic */ TCashTransferActivity f4435a;

        C17421(TCashTransferActivity tCashTransferActivity) {
            this.f4435a = tCashTransferActivity;
        }

        public void mo1546a() {
            if (this.f4435a.f4441C != null) {
                this.f4435a.f4441C.dismiss();
            }
            long j = 0;
            if (this.f4435a.f4448J != null) {
                j = Long.parseLong(this.f4435a.f4448J);
            }
            this.f4435a.f4456k.setAmount(j);
            this.f4435a.f4456k.setDestinationNo(this.f4435a.f4447I);
            this.f4435a.f4456k.setMenuId(this.f4435a.f4445G);
            this.f4435a.f4456k.setPeriod("");
            this.f4435a.f4456k.setStartDate("");
            this.f4435a.m6621a(this.f4435a.f4456k);
        }

        public void mo1547a(int i) {
            this.f4435a.f4457l = i;
            this.f4435a.f4441C.dismiss();
            String a = C1354g.m4943a(i);
            long j = 0;
            if (this.f4435a.f4448J != null) {
                j = Long.parseLong(this.f4435a.f4448J);
            }
            this.f4435a.f4456k.setAmount(j);
            this.f4435a.f4456k.setDestinationNo(this.f4435a.f4447I);
            this.f4435a.f4456k.setMenuId(this.f4435a.f4445G);
            this.f4435a.f4456k.setPeriod(C1358h.f2930a);
            this.f4435a.f4456k.setStartDate(a);
            this.f4435a.m6621a(this.f4435a.f4456k);
        }
    }

    class C17432 implements C1326f {
        final /* synthetic */ TCashTransferActivity f4436a;

        C17432(TCashTransferActivity tCashTransferActivity) {
            this.f4436a = tCashTransferActivity;
        }

        public void mo1485a() {
            if (this.f4436a.h != null) {
                this.f4436a.h.dismiss();
            }
            if (this.f4436a.f4456k != null) {
                this.f4436a.f4441C.show(this.f4436a.getSupportFragmentManager(), "reminder_dialog_tag");
            } else {
                this.f4436a.finish();
            }
        }

        public void mo1486b() {
        }
    }

    class C17443 implements C1326f {
        final /* synthetic */ TCashTransferActivity f4437a;

        C17443(TCashTransferActivity tCashTransferActivity) {
            this.f4437a = tCashTransferActivity;
        }

        public void mo1485a() {
            if (this.f4437a.h != null) {
                this.f4437a.h.dismiss();
            }
            this.f4437a.finish();
        }

        public void mo1486b() {
        }
    }

    private void m6621a(TcashFavorite tcashFavorite) {
        this.f4439A.m4699b(tcashFavorite, (C1245f) this);
    }

    private void m6630s() {
        C1216a.m4519a(f4438n, "initView?");
        this.f4441C = C1539j.m5687a();
        this.f4441C.m5690a(this.f4458m);
        this.f4439A.m4729i(this);
        m6631t();
    }

    private void m6631t() {
        TcashFavorite tcashFavorite = (TcashFavorite) getIntent().getSerializableExtra("Favorite");
        if (tcashFavorite != null && tcashFavorite.getDestinationNo() != null) {
            String destinationNo = tcashFavorite.getDestinationNo();
            if (!destinationNo.isEmpty()) {
                this.f4459o.m6962c(tcashFavorite.getMenuId());
                this.f4459o.m6963f(destinationNo);
                this.f4459o.m6964g(String.valueOf(tcashFavorite.getAmount()));
            }
        }
    }

    public void mo1487a() {
        m4990k();
        this.h = m4967a(this.f4455Q, (int) R.string.no_network);
    }

    public void m6633a(TransferType transferType) {
        this.f4449K = transferType;
        this.f4445G = this.f4449K.getTransferTypeId();
    }

    public void mo1488a(String str) {
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.f4440B.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f4455Q, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f4438n, "onSuccessNetwork");
        this.f4440B.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("getTcashBalance".equalsIgnoreCase(str)) {
            this.f4452N.m6965b(String.valueOf(((GetTcashBalanceRs) obj).getTcashBalance()));
        } else if ("setTcashFavoriteTransaction".equalsIgnoreCase(str)) {
            this.f4456k = null;
            this.h = C1514b.m5648a((int) R.string.title_success, (int) R.string.msg_setfavorite_success);
            this.h.m5651a(this.f4454P);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        } else if ("getTransferInfo".equalsIgnoreCase(str)) {
            GetTransferInfoRs getTransferInfoRs = (GetTransferInfoRs) obj;
            if (getTransferInfoRs.getTcashTransaction() != null) {
                this.f4444F = getTransferInfoRs.getTcashTransaction().getTransactionId();
                this.f4451M = getTransferInfoRs.getTcashTransaction().getFee();
            }
            mo1505o();
        } else if ("transferWithTcash".equalsIgnoreCase(str)) {
            TransferWithTcashRs transferWithTcashRs = (TransferWithTcashRs) obj;
            this.h = C1514b.m5649a((int) R.string.title_success, m5018a((int) R.string.tcash_success_paid_menu_nominal_amount_date, getString(R.string.title_tcash_transfer), transferWithTcashRs.getTcashTransaction().getDestinationNo(), C1354g.m4955f(transferWithTcashRs.getTcashTransaction().getAmount()), C1354g.m4951c(transferWithTcashRs.getTcashTransaction().getTransactionDate())));
            this.h.m5651a(this.f4454P);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        }
    }

    public void m6637a(String str, String str2) {
        if (str2 != null && !str2.isEmpty()) {
            if (this.f4453O == null) {
                this.f4453O = new HashMap();
            }
            this.f4453O.put(str, str2);
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4967a(this.f4455Q, (int) R.string.no_response);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    public void m6640e(String str) {
        long parseLong = Long.parseLong(this.f4448J);
        TcashTransactionRequest tcashTransactionRequest = new TcashTransactionRequest();
        tcashTransactionRequest.setTcashPin(str);
        tcashTransactionRequest.setMenuId(this.f4445G);
        tcashTransactionRequest.setTransferTypeId(this.f4445G);
        tcashTransactionRequest.setBankCode(C1354g.m4959j(this.f4446H));
        tcashTransactionRequest.setDestinationNo(this.f4447I);
        tcashTransactionRequest.setAmount(parseLong);
        tcashTransactionRequest.setEtcParam(this.f4453O);
        tcashTransactionRequest.setTcashTransactionId(this.f4444F);
        m4972a((Context) this, (int) R.string.loading);
        this.f4439A.m4715d(tcashTransactionRequest, (C1245f) this);
    }

    public void m6641f(String str) {
        this.f4456k = new TcashFavorite();
        this.f4456k.setFavoriteMenuName(str);
    }

    public void m6642g(String str) {
        this.f4446H = str;
    }

    public void m6643j(String str) {
        this.f4447I = str;
    }

    public void m6644k(String str) {
        this.f4448J = str;
    }

    public void m6645l(String str) {
        this.f4450L = str;
        m6637a("comment", str);
    }

    public void mo1505o() {
        this.f4460z = new C1818o();
        C1216a.m4522b("transfer", "to:" + this.f4447I + " amount:" + this.f4448J + " " + this.f4450L);
        if (this.f4448J != null) {
            this.f4460z.m6968b(this.f4446H);
            this.f4460z.m6969c(this.f4447I);
            this.f4460z.m6970f(this.f4448J);
            this.f4460z.m6971g(this.f4450L);
            this.f4460z.m6972h(this.f4451M);
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.tcash_payment_fragment, this.f4460z);
        beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        beginTransaction.commit();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        this.f4452N = new C1816n();
        super.m5019a(this.f4452N);
        super.onCreate(bundle);
        this.f4439A = this.a.m4739a();
        this.f4440B = this.a.m4745e();
        this.f4459o = new C1815m();
        this.f4443E = this.f4440B.m4651b("msisdn", "");
        this.f4459o.m6961b(this.f4443E);
        if (getIntent().hasExtra("MSISDN") || getIntent().hasExtra("AMOUNT")) {
            if (getIntent().hasExtra("MSISDN")) {
                this.f4442D = getIntent().getStringExtra("MSISDN");
                this.f4459o.m6963f(this.f4442D);
                this.f4459o.m6960a(true);
            }
            if (getIntent().hasExtra("AMOUNT")) {
                this.f4448J = getIntent().getStringExtra("AMOUNT");
                this.f4459o.m6964g(this.f4448J);
            }
            getSupportFragmentManager().beginTransaction().add((int) R.id.tcash_payment_fragment, this.f4459o).commit();
            this.f4441C = C1539j.m5687a();
            this.f4441C.m5690a(this.f4458m);
            return;
        }
        getSupportFragmentManager().beginTransaction().add((int) R.id.tcash_payment_fragment, this.f4459o).commit();
        m6630s();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.h != null) {
            this.h.dismiss();
        }
        C1216a.m4519a(f4438n, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f4438n, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f4438n, " in onResume >>>>>");
    }

    public void m6647p() {
        long parseLong = Long.parseLong(this.f4448J);
        TcashTransactionRequest tcashTransactionRequest = new TcashTransactionRequest();
        tcashTransactionRequest.setMenuId(this.f4445G);
        tcashTransactionRequest.setTransferTypeId(this.f4445G);
        tcashTransactionRequest.setDestinationNo(this.f4447I);
        tcashTransactionRequest.setAmount(parseLong);
        tcashTransactionRequest.setBankCode(C1354g.m4959j(this.f4446H));
        tcashTransactionRequest.setEtcParam(this.f4453O);
        m4972a((Context) this, (int) R.string.loading);
        this.f4439A.m4708c(tcashTransactionRequest, (C1245f) this);
    }

    public void m6648q() {
        this.f4456k = null;
    }

    public String m6649r() {
        return this.f4445G;
    }
}
