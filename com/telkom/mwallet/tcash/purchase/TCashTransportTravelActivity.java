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
import com.skcc.wallet.framework.api.http.model.TcashTransactionRequest;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.p064a.C1349c;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.p064a.C1358h;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import com.telkom.mwallet.tcash.TCashActivity;
import com.telkom.mwallet.tcash.purchase.p070a.C1959t;
import com.telkom.mwallet.tcash.purchase.p070a.C1960u;
import com.telkom.mwallet.tcash.purchase.p070a.C1962v;
import com.telkom.mwallet.tcash.purchase.p070a.C1964w;

public class TCashTransportTravelActivity extends SlidingFrameActivity {
    private static final String f5426k = TCashTransportTravelActivity.class.getSimpleName();
    private C1298u f5427A;
    private String f5428B;
    private String f5429C;
    private String f5430D;
    private String f5431E;
    private String f5432F;
    private String f5433G;
    private String f5434H;
    private String f5435I;
    private String f5436J = null;
    private String f5437K = null;
    private String f5438L;
    private boolean f5439M = false;
    private C1326f f5440N = new C19051(this);
    private C1326f f5441O = new C19062(this);
    private final String f5442l = "mW4II3t123";
    private C1959t f5443m;
    private C1962v f5444n;
    private C1964w f5445o;
    private C1960u f5446z;

    class C19051 implements C1326f {
        final /* synthetic */ TCashTransportTravelActivity f5424a;

        C19051(TCashTransportTravelActivity tCashTransportTravelActivity) {
            this.f5424a = tCashTransportTravelActivity;
        }

        public void mo1485a() {
            if (this.f5424a.h != null) {
                this.f5424a.h.dismiss();
            }
            if (this.f5424a.f5439M) {
                this.f5424a.m5016B();
                return;
            }
            Intent intent = new Intent(this.f5424a, TCashActivity.class);
            intent.setFlags(67108864);
            this.f5424a.startActivity(intent);
            this.f5424a.finish();
        }

        public void mo1486b() {
        }
    }

    class C19062 implements C1326f {
        final /* synthetic */ TCashTransportTravelActivity f5425a;

        C19062(TCashTransportTravelActivity tCashTransportTravelActivity) {
            this.f5425a = tCashTransportTravelActivity;
        }

        public void mo1485a() {
            if (this.f5425a.h != null) {
                this.f5425a.h.dismiss();
            }
            this.f5425a.finish();
        }

        public void mo1486b() {
        }
    }

    private void m7582r() {
        this.f5427A.m4729i(this);
    }

    public void mo1487a() {
        m4990k();
        this.h = m4967a(this.f5441O, (int) R.string.no_network);
    }

    public void mo1488a(String str) {
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f5441O, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f5426k, "onSuccessNetwork");
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("getPurchaseInfo".equalsIgnoreCase(str)) {
            GetPurchaseInfoRs getPurchaseInfoRs = (GetPurchaseInfoRs) obj;
            if (getPurchaseInfoRs.getTcashTransaction() != null) {
                this.f5438L = getPurchaseInfoRs.getTcashTransaction().getTransactionId();
                this.f5436J = getPurchaseInfoRs.getTcashTransaction().getAmount();
                this.f5437K = getPurchaseInfoRs.getTcashTransaction().getFee();
            }
            mo1505o();
        } else if ("getTcashBalance".equalsIgnoreCase(str)) {
            this.f5446z.m7858c(String.valueOf(((GetTcashBalanceRs) obj).getTcashBalance()));
            m4990k();
        } else if ("purchaseWithTcash".equalsIgnoreCase(str)) {
            PurchaseWithTcashRs purchaseWithTcashRs = (PurchaseWithTcashRs) obj;
            int parseInt = (purchaseWithTcashRs.getTcashTransaction().getAmount() == null || purchaseWithTcashRs.getTcashTransaction().getAmount().isEmpty()) ? 0 : Integer.parseInt(purchaseWithTcashRs.getTcashTransaction().getAmount());
            if (!(purchaseWithTcashRs.getTcashTransaction().getFee() == null || purchaseWithTcashRs.getTcashTransaction().getFee().isEmpty())) {
                parseInt += Integer.parseInt(purchaseWithTcashRs.getTcashTransaction().getFee());
            }
            this.h = C1514b.m5649a((int) R.string.title_success, m5018a((int) R.string.tcash_success_buy_menu_nominal_total_date, this.f5431E, this.f5434H, C1354g.m4955f(parseInt + ""), C1354g.m4946a("dd-MM-yyyy", purchaseWithTcashRs.getTcashTransaction().getTransactionDate())));
            this.h.m5651a(this.f5440N);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4967a(this.f5441O, (int) R.string.no_response);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    public void m7589e(String str) {
        this.f5432F = str;
    }

    public void m7590f(String str) {
        this.f5436J = str;
    }

    public void m7591g(String str) {
        this.f5434H = str;
    }

    public void m7592j(String str) {
        this.f5433G = str;
    }

    public void m7593k(String str) {
        this.f5446z.m7856a(0);
        this.f5444n = new C1962v();
        this.f5444n.m7868b(this.f5430D);
        this.f5444n.m7869c(this.f5431E);
        this.f5444n.m7870f(str);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.tcash_payment_fragment, this.f5444n);
        beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        beginTransaction.commit();
    }

    public void mo1505o() {
        this.f5445o = new C1964w();
        this.f5445o.m7618c(this.f5431E + " " + getString(R.string.title_tcash_ticket));
        if ("2700001".equals(this.f5430D)) {
            this.f5445o.m7623j(getString(R.string.label_ticket_number));
        } else {
            this.f5445o.m7623j(getString(R.string.label_transport_travel_booking_number));
        }
        this.f5445o.m7619f(this.f5434H);
        this.f5445o.m7621h(this.f5436J);
        this.f5445o.m7622i(this.f5437K);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.tcash_payment_fragment, this.f5445o);
        beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        beginTransaction.commit();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        this.f5446z = new C1960u();
        super.m5019a(this.f5446z);
        super.onCreate(bundle);
        this.f5431E = getIntent().getStringExtra("TCASH_SUB_MENU_NAME");
        this.f5430D = getIntent().getStringExtra("TCASH_SUB_MENU_ID");
        this.f5435I = getIntent().getStringExtra(C1358h.f2939j);
        this.f5427A = this.a.m4739a();
        this.b = this.a.m4745e();
        this.f5428B = this.b.m4651b("msisdn", "");
        this.f5429C = C1349c.m4927d(this.f5428B, "mW4II3t123");
        this.f5446z.m7857b(this.f5431E);
        this.f5446z.m7856a(8);
        this.f5443m = new C1959t();
        this.f5443m.m7853b(this.f5428B);
        this.f5443m.m7854c(this.f5429C);
        this.f5443m.m7855f(this.f5435I);
        getSupportFragmentManager().beginTransaction().add((int) R.id.tcash_payment_fragment, this.f5443m).commit();
        m7582r();
        if (C1358h.f2943n.equals(getIntent().getStringExtra(C1358h.f2940k))) {
            this.f5439M = true;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f5426k, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f5426k, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f5426k, " in onResume >>>>>");
    }

    public void m7595p() {
        long j = 0;
        if (!(this.f5436J == null || this.f5436J.isEmpty())) {
            j = Long.parseLong(this.f5436J);
        }
        TcashTransactionRequest tcashTransactionRequest = new TcashTransactionRequest();
        tcashTransactionRequest.setMenuId(this.f5430D);
        tcashTransactionRequest.setDestinationNo(this.f5433G);
        tcashTransactionRequest.setAmount(j);
        m4972a((Context) this, (int) R.string.loading);
        this.f5427A.m4675a(tcashTransactionRequest, (C1245f) this);
    }

    public void m7596q() {
        long j = 0;
        if (!(this.f5436J == null || this.f5436J.isEmpty())) {
            j = Long.parseLong(this.f5436J);
        }
        TcashTransactionRequest tcashTransactionRequest = new TcashTransactionRequest();
        tcashTransactionRequest.setTcashPin(this.f5432F);
        tcashTransactionRequest.setDestinationNo(this.f5433G);
        tcashTransactionRequest.setMenuId(this.f5430D);
        tcashTransactionRequest.setFee(this.f5437K);
        tcashTransactionRequest.setAmount(j);
        tcashTransactionRequest.setTcashTransactionId(this.f5438L);
        m4972a((Context) this, (int) R.string.loading);
        this.f5427A.m4700b(tcashTransactionRequest, (C1245f) this);
    }
}
