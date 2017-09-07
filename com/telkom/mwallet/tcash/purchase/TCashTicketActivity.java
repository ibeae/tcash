package com.telkom.mwallet.tcash.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.C1245f;
import com.skcc.wallet.framework.api.http.model.GetPurchaseInfoRs;
import com.skcc.wallet.framework.api.http.model.GetTcashBalanceRs;
import com.skcc.wallet.framework.api.http.model.PurchaseWithTcashRs;
import com.skcc.wallet.framework.api.http.model.TcashTransaction;
import com.skcc.wallet.framework.api.http.model.TcashTransactionRequest;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.p064a.C1349c;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.p064a.C1358h;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import com.telkom.mwallet.tcash.TCashActivity;
import com.telkom.mwallet.tcash.purchase.p070a.C1952p;
import com.telkom.mwallet.tcash.purchase.p070a.C1953q;
import com.telkom.mwallet.tcash.purchase.p070a.C1955r;
import com.telkom.mwallet.tcash.purchase.p070a.C1957s;

public class TCashTicketActivity extends SlidingFrameActivity {
    private static final String f5403k = TCashTicketActivity.class.getSimpleName();
    private C1298u f5404A;
    private String f5405B;
    private String f5406C;
    private String f5407D;
    private String f5408E;
    private String f5409F;
    private String f5410G;
    private String f5411H;
    private String f5412I;
    private String f5413J = null;
    private String f5414K = null;
    private String f5415L;
    private boolean f5416M = false;
    private C1326f f5417N = new C19031(this);
    private C1326f f5418O = new C19042(this);
    private final String f5419l = "mW4II3t123";
    private C1952p f5420m;
    private C1955r f5421n;
    private C1957s f5422o;
    private C1953q f5423z;

    class C19031 implements C1326f {
        final /* synthetic */ TCashTicketActivity f5401a;

        C19031(TCashTicketActivity tCashTicketActivity) {
            this.f5401a = tCashTicketActivity;
        }

        public void mo1485a() {
            if (this.f5401a.h != null) {
                this.f5401a.h.dismiss();
            }
            if (this.f5401a.f5416M) {
                this.f5401a.m5016B();
                return;
            }
            Intent intent = new Intent(this.f5401a, TCashActivity.class);
            intent.setFlags(67108864);
            this.f5401a.startActivity(intent);
            this.f5401a.finish();
        }

        public void mo1486b() {
        }
    }

    class C19042 implements C1326f {
        final /* synthetic */ TCashTicketActivity f5402a;

        C19042(TCashTicketActivity tCashTicketActivity) {
            this.f5402a = tCashTicketActivity;
        }

        public void mo1485a() {
            if (this.f5402a.h != null) {
                this.f5402a.h.dismiss();
            }
            this.f5402a.finish();
        }

        public void mo1486b() {
        }
    }

    private void m7557r() {
        this.f5404A.m4729i(this);
    }

    public void mo1487a() {
        m4990k();
        this.h = m4967a(this.f5418O, (int) R.string.no_network);
    }

    public void mo1488a(String str) {
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f5418O, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f5403k, "onSuccessNetwork");
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("getPurchaseInfo".equalsIgnoreCase(str)) {
            GetPurchaseInfoRs getPurchaseInfoRs = (GetPurchaseInfoRs) obj;
            if (getPurchaseInfoRs.getTcashTransaction() != null) {
                this.f5415L = getPurchaseInfoRs.getTcashTransaction().getTransactionId();
                this.f5413J = getPurchaseInfoRs.getTcashTransaction().getAmount();
                this.f5414K = getPurchaseInfoRs.getTcashTransaction().getFee();
            }
            mo1505o();
        } else if ("purchaseWithTcash".equalsIgnoreCase(str)) {
            TcashTransaction tcashTransaction = ((PurchaseWithTcashRs) obj).getTcashTransaction();
            int parseInt = (tcashTransaction.getAmount() == null || tcashTransaction.getAmount().isEmpty()) ? 0 : Integer.parseInt(tcashTransaction.getAmount());
            if (!(tcashTransaction.getFee() == null || tcashTransaction.getFee().isEmpty())) {
                parseInt += Integer.parseInt(tcashTransaction.getFee());
            }
            this.h = C1514b.m5649a((int) R.string.title_success, m5018a((int) R.string.tcash_success_buy_menu_nominal_total_date, this.f5408E, this.f5410G, C1354g.m4955f(parseInt + ""), C1354g.m4946a("dd-MM-yyyy", tcashTransaction.getTransactionDate())));
            this.h.m5651a(this.f5417N);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        } else if ("getTcashBalance".equalsIgnoreCase(str)) {
            this.f5423z.m7835c(String.valueOf(((GetTcashBalanceRs) obj).getTcashBalance()));
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4967a(this.f5418O, (int) R.string.no_response);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    public void m7564e(String str) {
        this.f5411H = str;
    }

    public void m7565f(String str) {
        this.f5413J = str;
    }

    public void m7566g(String str) {
        this.f5410G = str;
    }

    public void m7567j(String str) {
        this.f5409F = str;
    }

    public void m7568k(String str) {
        this.f5423z.m7833a(0);
        this.f5421n = new C1955r();
        this.f5421n.m7845b(this.f5408E);
        this.f5421n.m7846c(str);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.tcash_payment_fragment, this.f5421n);
        beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        beginTransaction.commit();
    }

    public void mo1505o() {
        this.f5422o = new C1957s();
        this.f5422o.m7618c(this.f5408E + " " + getString(R.string.title_tcash_ticket));
        this.f5422o.m7623j(getString(R.string.label_ticket_number));
        this.f5422o.m7619f(this.f5410G);
        this.f5422o.m7621h(this.f5413J);
        this.f5422o.m7622i(this.f5414K);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.tcash_payment_fragment, this.f5422o);
        beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        beginTransaction.commit();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        this.f5423z = new C1953q();
        super.m5019a(this.f5423z);
        super.onCreate(bundle);
        this.f5408E = getIntent().getStringExtra("TCASH_SUB_MENU_NAME");
        this.f5407D = getIntent().getStringExtra("TCASH_SUB_MENU_ID");
        this.f5412I = getIntent().getStringExtra(C1358h.f2939j);
        this.f5404A = this.a.m4739a();
        this.b = this.a.m4745e();
        this.f5405B = this.b.m4651b("msisdn", "");
        this.f5406C = C1349c.m4927d(this.f5405B, "mW4II3t123");
        this.f5423z.m7834b(this.f5408E);
        this.f5423z.m7833a(8);
        this.f5420m = new C1952p();
        this.f5420m.m7831c(this.f5405B);
        this.f5420m.m7832f(this.f5406C);
        this.f5420m.m7830b(this.f5412I);
        getSupportFragmentManager().beginTransaction().add((int) R.id.tcash_payment_fragment, this.f5420m).commit();
        m7557r();
        if (C1358h.f2943n.equals(getIntent().getStringExtra(C1358h.f2940k))) {
            this.f5416M = true;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f5403k, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f5403k, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f5403k, " in onResume >>>>>");
    }

    public void m7570p() {
        long j = 0;
        if (!(this.f5413J == null || this.f5413J.isEmpty())) {
            j = Long.parseLong(this.f5413J);
        }
        TcashTransactionRequest tcashTransactionRequest = new TcashTransactionRequest();
        tcashTransactionRequest.setMenuId(this.f5407D);
        tcashTransactionRequest.setDestinationNo(this.f5409F);
        tcashTransactionRequest.setAmount(j);
        m4972a((Context) this, (int) R.string.loading);
        this.f5404A.m4675a(tcashTransactionRequest, (C1245f) this);
    }

    public void m7571q() {
        long j = 0;
        if (!(this.f5413J == null || this.f5413J.isEmpty())) {
            j = Long.parseLong(this.f5413J);
        }
        TcashTransactionRequest tcashTransactionRequest = new TcashTransactionRequest();
        tcashTransactionRequest.setTcashPin(this.f5411H);
        tcashTransactionRequest.setMenuId(this.f5407D);
        tcashTransactionRequest.setDestinationNo(this.f5409F);
        tcashTransactionRequest.setFee(this.f5414K);
        tcashTransactionRequest.setAmount(j);
        tcashTransactionRequest.setTcashTransactionId(this.f5415L);
        m4972a((Context) this, (int) R.string.loading);
        this.f5404A.m4700b(tcashTransactionRequest, (C1245f) this);
    }
}
