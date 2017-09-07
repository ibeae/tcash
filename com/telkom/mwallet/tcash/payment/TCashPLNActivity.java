package com.telkom.mwallet.tcash.payment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.C1245f;
import com.skcc.wallet.framework.api.http.model.GetPaymentInfoRs;
import com.skcc.wallet.framework.api.http.model.GetServiceDetailRs;
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
import com.telkom.mwallet.tcash.payment.p069a.C1864m;
import com.telkom.mwallet.tcash.payment.p069a.C1865n;
import com.telkom.mwallet.tcash.payment.p069a.C1867o;

public class TCashPLNActivity extends SlidingFrameActivity {
    private static final String f4946n = TCashPLNActivity.class.getSimpleName();
    private C1298u f4947A;
    private C1539j f4948B;
    private String f4949C;
    private String f4950D = null;
    private String f4951E = null;
    private String f4952F = null;
    private String f4953G = null;
    private String f4954H;
    private String f4955I = null;
    private C1865n f4956J;
    private boolean f4957K = false;
    private C1326f f4958L = new C18322(this);
    private C1326f f4959M = new C18333(this);
    TcashFavorite f4960k = null;
    int f4961l;
    C1500i f4962m = new C18311(this);
    private C1864m f4963o;
    private C1867o f4964z = null;

    class C18311 implements C1500i {
        final /* synthetic */ TCashPLNActivity f4943a;

        C18311(TCashPLNActivity tCashPLNActivity) {
            this.f4943a = tCashPLNActivity;
        }

        public void mo1546a() {
            if (this.f4943a.f4948B != null) {
                this.f4943a.f4948B.dismiss();
            }
            long j = 0;
            if (this.f4943a.f4952F != null) {
                j = Long.parseLong(this.f4943a.f4952F);
            }
            this.f4943a.f4960k.setAmount(j);
            this.f4943a.f4960k.setDestinationNo(this.f4943a.f4951E);
            this.f4943a.f4960k.setMenuId(this.f4943a.f4949C);
            this.f4943a.f4960k.setPeriod("");
            this.f4943a.f4960k.setStartDate("");
            this.f4943a.m7114a(this.f4943a.f4960k);
        }

        public void mo1547a(int i) {
            this.f4943a.f4961l = i;
            this.f4943a.f4948B.dismiss();
            String a = C1354g.m4943a(i);
            this.f4943a.f4960k.setAmount(Long.parseLong(this.f4943a.f4952F));
            this.f4943a.f4960k.setDestinationNo(this.f4943a.f4951E);
            this.f4943a.f4960k.setMenuId(this.f4943a.f4949C);
            this.f4943a.f4960k.setPeriod(C1358h.f2930a);
            this.f4943a.f4960k.setStartDate(a);
            this.f4943a.m7114a(this.f4943a.f4960k);
        }
    }

    class C18322 implements C1326f {
        final /* synthetic */ TCashPLNActivity f4944a;

        C18322(TCashPLNActivity tCashPLNActivity) {
            this.f4944a = tCashPLNActivity;
        }

        public void mo1485a() {
            if (this.f4944a.h != null) {
                this.f4944a.h.dismiss();
            }
            if (this.f4944a.f4960k != null) {
                this.f4944a.f4948B.show(this.f4944a.getSupportFragmentManager(), "reminder_dialog_tag");
            } else if (this.f4944a.f4957K) {
                this.f4944a.m5016B();
            } else {
                Intent intent = new Intent(this.f4944a, TCashActivity.class);
                intent.setFlags(67108864);
                this.f4944a.startActivity(intent);
                this.f4944a.finish();
            }
        }

        public void mo1486b() {
        }
    }

    class C18333 implements C1326f {
        final /* synthetic */ TCashPLNActivity f4945a;

        C18333(TCashPLNActivity tCashPLNActivity) {
            this.f4945a = tCashPLNActivity;
        }

        public void mo1485a() {
            if (this.f4945a.h != null) {
                this.f4945a.h.dismiss();
            }
            this.f4945a.finish();
        }

        public void mo1486b() {
        }
    }

    private void m7114a(TcashFavorite tcashFavorite) {
        this.f4947A.m4699b(tcashFavorite, (C1245f) this);
    }

    private void m7125t() {
        this.f4948B = C1539j.m5687a();
        this.f4948B.m5690a(this.f4962m);
        this.f4947A.m4729i(this);
        m7126u();
    }

    private void m7126u() {
        TcashFavorite tcashFavorite = (TcashFavorite) getIntent().getSerializableExtra("Favorite");
        if (tcashFavorite != null) {
            String destinationNo = tcashFavorite.getDestinationNo();
            if (!(destinationNo == null || destinationNo.isEmpty())) {
                this.f4963o.m7318c(destinationNo);
            }
            String str = "" + tcashFavorite.getAmount();
            if (str != null && !str.isEmpty()) {
                this.f4963o.m7319f(str);
            }
        }
    }

    public void mo1487a() {
        m4990k();
        this.h = m4967a(this.f4959M, (int) R.string.no_network);
    }

    public void mo1488a(String str) {
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f4959M, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f4946n, "onSuccessNetwork");
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("getServiceDetail".equalsIgnoreCase(str)) {
            this.f4963o.m7316a(((GetServiceDetailRs) obj).getMenu().getDenominations());
        } else if ("setTcashFavoriteTransaction".equalsIgnoreCase(str)) {
            this.f4960k = null;
            this.h = C1514b.m5648a((int) R.string.title_success, (int) R.string.msg_setfavorite_success);
            this.h.m5651a(this.f4958L);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        } else if ("getTcashBalance".equalsIgnoreCase(str)) {
            this.f4956J.m7320b(String.valueOf(((GetTcashBalanceRs) obj).getTcashBalance()));
        } else if ("getPaymentInfo".equalsIgnoreCase(str)) {
            GetPaymentInfoRs getPaymentInfoRs = (GetPaymentInfoRs) obj;
            if (getPaymentInfoRs.getTcashTransaction() != null) {
                this.f4954H = getPaymentInfoRs.getTcashTransaction().getTransactionId();
                this.f4951E = getPaymentInfoRs.getTcashTransaction().getDestinationNo();
                this.f4952F = getPaymentInfoRs.getTcashTransaction().getAmount();
                this.f4955I = getPaymentInfoRs.getMenu().getDescription();
                this.f4953G = getPaymentInfoRs.getTcashTransaction().getFee();
            }
            mo1505o();
        } else if ("payWithTcash".equalsIgnoreCase(str)) {
            PayWithTcashRs payWithTcashRs = (PayWithTcashRs) obj;
            if ("1220000".equals(this.f4949C)) {
                this.h = C1514b.m5649a((int) R.string.title_success, m5018a((int) R.string.electricity_success_prepaid_popup, getString(R.string.title_tcash_pln), payWithTcashRs.getTcashTransaction().getDestinationNo(), C1354g.m4955f(payWithTcashRs.getTcashTransaction().getAmount()), C1354g.m4951c(payWithTcashRs.getTcashTransaction().getTransactionDate())));
            } else {
                this.h = C1514b.m5649a((int) R.string.title_success, m5018a((int) R.string.electricity_success_postpaid_popup, getString(R.string.title_tcash_pln), payWithTcashRs.getTcashTransaction().getDestinationNo(), C1354g.m4955f(payWithTcashRs.getTcashTransaction().getAmount()), C1354g.m4951c(payWithTcashRs.getTcashTransaction().getTransactionDate())));
            }
            this.h.m5651a(this.f4958L);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4967a(this.f4959M, (int) R.string.no_response);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    public void m7133e(String str) {
        this.f4960k = new TcashFavorite();
        this.f4960k.setFavoriteMenuName(str);
    }

    public void m7134f(String str) {
        this.f4949C = str;
    }

    public void m7135g(String str) {
        this.f4950D = str;
    }

    public void m7136j(String str) {
        this.f4951E = str;
    }

    public void m7137k(String str) {
        this.f4952F = str;
    }

    public void mo1505o() {
        this.f4964z = new C1867o();
        this.f4964z.m7324b(this.f4949C);
        this.f4964z.m7325c(this.f4951E);
        this.f4964z.m7327g(this.f4952F);
        this.f4964z.m7326f(this.f4955I);
        this.f4964z.m7328h(this.f4953G);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.tcash_payment_fragment, this.f4964z);
        beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        beginTransaction.commit();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        this.f4956J = new C1865n();
        super.m5019a(this.f4956J);
        super.onCreate(bundle);
        this.f4947A = this.a.m4739a();
        if (C1358h.f2943n.equals(getIntent().getStringExtra(C1358h.f2940k))) {
            this.f4957K = true;
        }
        this.f4949C = getIntent().getStringExtra("TCASH_MENU_ID");
        this.f4963o = new C1864m();
        this.f4963o.m7317b(this.f4949C);
        getSupportFragmentManager().beginTransaction().add((int) R.id.tcash_payment_fragment, this.f4963o).commit();
        m7125t();
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f4946n, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f4946n, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f4946n, " in onResume >>>>>");
    }

    public void m7139p() {
        TcashTransactionRequest tcashTransactionRequest = new TcashTransactionRequest();
        tcashTransactionRequest.setMenuId(this.f4949C);
        tcashTransactionRequest.setDestinationNo(this.f4951E);
        if (!(this.f4952F == null || this.f4952F.isEmpty())) {
            tcashTransactionRequest.setAmount(Long.parseLong(this.f4952F));
        }
        m4972a((Context) this, (int) R.string.loading);
        this.f4947A.m4720e(tcashTransactionRequest, (C1245f) this);
    }

    public void m7140q() {
        m4972a((Context) this, (int) R.string.loading);
        this.f4947A.m4726g(this.f4949C, this);
    }

    public void m7141r() {
        long parseLong = Long.parseLong(this.f4952F);
        TcashTransactionRequest tcashTransactionRequest = new TcashTransactionRequest();
        tcashTransactionRequest.setTcashPin(this.f4950D);
        tcashTransactionRequest.setMenuId(this.f4949C);
        tcashTransactionRequest.setFee(this.f4953G);
        tcashTransactionRequest.setDestinationNo(this.f4951E);
        tcashTransactionRequest.setAmount(parseLong);
        tcashTransactionRequest.setTcashTransactionId(this.f4954H);
        m4972a((Context) this, (int) R.string.loading);
        this.f4947A.m4723f(tcashTransactionRequest, (C1245f) this);
    }

    public void m7142s() {
        this.f4960k = null;
    }
}
