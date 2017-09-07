package com.telkom.mwallet.tcash.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.C1245f;
import com.skcc.wallet.framework.api.http.model.GetPurchaseInfoRs;
import com.skcc.wallet.framework.api.http.model.GetServiceDetailRs;
import com.skcc.wallet.framework.api.http.model.GetTcashBalanceRs;
import com.skcc.wallet.framework.api.http.model.PurchaseWithTcashRs;
import com.skcc.wallet.framework.api.http.model.TcashFavorite;
import com.skcc.wallet.framework.api.http.model.TcashTransaction;
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
import com.telkom.mwallet.tcash.purchase.p070a.C1920e;
import com.telkom.mwallet.tcash.purchase.p070a.C1922f;
import com.telkom.mwallet.tcash.purchase.p070a.C1925o;
import com.telkom.mwallet.tcash.purchase.p070a.C1926g;
import com.telkom.mwallet.tcash.purchase.p070a.C1929h;
import com.telkom.mwallet.tcash.purchase.p070a.C1933i;
import com.telkom.mwallet.tcash.purchase.p070a.C1937j;
import com.telkom.mwallet.tcash.purchase.p070a.C1939k;
import com.telkom.mwallet.tcash.purchase.p070a.C1941l;
import com.telkom.mwallet.tcash.purchase.p070a.C1947m;
import com.telkom.mwallet.tcash.purchase.p070a.C1949n;
import java.util.HashMap;
import java.util.Map;

public class TCashPurchaseActivity extends SlidingFrameActivity {
    private static final String f5379m = TCashPurchaseActivity.class.getSimpleName();
    private C1298u f5380A;
    private C1539j f5381B;
    private String f5382C = null;
    private String f5383D = null;
    private String f5384E;
    private String f5385F;
    private String f5386G = null;
    private String f5387H = null;
    private String f5388I = null;
    private String f5389J = null;
    private String f5390K;
    private TcashFavorite f5391L = null;
    private Map<String, String> f5392M = null;
    private boolean f5393N = false;
    private C1326f f5394O = new C19012(this);
    private C1326f f5395P = new C19023(this);
    int f5396k = -1;
    C1500i f5397l = new C19001(this);
    private C1925o f5398n;
    private C1922f f5399o;
    private C1920e f5400z;

    class C19001 implements C1500i {
        final /* synthetic */ TCashPurchaseActivity f5376a;

        C19001(TCashPurchaseActivity tCashPurchaseActivity) {
            this.f5376a = tCashPurchaseActivity;
        }

        public void mo1546a() {
            if (this.f5376a.f5381B != null) {
                this.f5376a.f5381B.dismiss();
            }
            long j = 0;
            if (!(this.f5376a.f5388I == null || this.f5376a.f5388I.isEmpty())) {
                j = Long.parseLong(this.f5376a.f5388I);
            }
            this.f5376a.f5391L.setAmount(j);
            this.f5376a.f5391L.setDestinationNo(this.f5376a.f5387H);
            this.f5376a.f5391L.setMenuId(this.f5376a.f5384E);
            this.f5376a.f5391L.setPeriod("");
            this.f5376a.f5391L.setStartDate("");
            this.f5376a.m7516a(this.f5376a.f5391L);
        }

        public void mo1547a(int i) {
            this.f5376a.f5396k = i;
            this.f5376a.f5381B.dismiss();
            String a = C1354g.m4943a(i);
            long j = 0;
            if (!(this.f5376a.f5388I == null || this.f5376a.f5388I.isEmpty())) {
                j = Long.parseLong(this.f5376a.f5388I);
            }
            this.f5376a.f5391L.setAmount(j);
            this.f5376a.f5391L.setDestinationNo(this.f5376a.f5387H);
            this.f5376a.f5391L.setMenuId(this.f5376a.f5384E);
            this.f5376a.f5391L.setPeriod(C1358h.f2930a);
            this.f5376a.f5391L.setStartDate(a);
            this.f5376a.m7516a(this.f5376a.f5391L);
        }
    }

    class C19012 implements C1326f {
        final /* synthetic */ TCashPurchaseActivity f5377a;

        C19012(TCashPurchaseActivity tCashPurchaseActivity) {
            this.f5377a = tCashPurchaseActivity;
        }

        public void mo1485a() {
            if (this.f5377a.h != null) {
                this.f5377a.h.dismiss();
            }
            if (this.f5377a.f5391L != null) {
                this.f5377a.f5381B.show(this.f5377a.getSupportFragmentManager(), "reminder_dialog_tag");
            } else if (this.f5377a.f5393N) {
                this.f5377a.m5016B();
            } else {
                Intent intent = new Intent(this.f5377a, TCashActivity.class);
                intent.setFlags(67108864);
                this.f5377a.startActivity(intent);
                this.f5377a.finish();
            }
        }

        public void mo1486b() {
        }
    }

    class C19023 implements C1326f {
        final /* synthetic */ TCashPurchaseActivity f5378a;

        C19023(TCashPurchaseActivity tCashPurchaseActivity) {
            this.f5378a = tCashPurchaseActivity;
        }

        public void mo1485a() {
            if (this.f5378a.h != null) {
                this.f5378a.h.dismiss();
            }
            this.f5378a.finish();
        }

        public void mo1486b() {
        }
    }

    private String m7515a(TcashTransaction tcashTransaction) {
        String str = "";
        if (this.f5383D.equals("TPH0001") || this.f5383D.equals("TPH0002")) {
            return m5018a((int) R.string.tcash_success_topup_menu_nominal_amount_date, this.f5382C, tcashTransaction.getDestinationNo(), C1354g.m4955f(tcashTransaction.getAmount()), C1354g.m4951c(tcashTransaction.getTransactionDate()));
        } else if (this.f5383D.equals("TPH0003")) {
            return m5018a((int) R.string.tcash_success_buy_menu_nominal_amount_date, this.f5382C, tcashTransaction.getDestinationNo(), C1354g.m4955f(tcashTransaction.getAmount()), C1354g.m4951c(tcashTransaction.getTransactionDate()));
        } else if (this.f5383D.equals("TPH0004")) {
            return m5018a((int) R.string.tcash_success_topup_menu_amount_date, this.f5382C, C1354g.m4955f(tcashTransaction.getAmount()), C1354g.m4951c(tcashTransaction.getTransactionDate()));
        } else if (this.f5383D.equals("TPH0005")) {
            return m5018a((int) R.string.tcash_success_pay_menu_amount_date, this.f5382C, C1354g.m4955f(tcashTransaction.getAmount()), C1354g.m4946a("dd/MM/yyyy", tcashTransaction.getTransactionDate()));
        } else if (this.f5383D.equals("TPH0006")) {
            return m5018a((int) R.string.tcash_success_pay_menu_amount_fee_date, this.f5382C, C1354g.m4955f(tcashTransaction.getAmount()), C1354g.m4955f(tcashTransaction.getFee()), C1354g.m4951c(tcashTransaction.getTransactionDate()));
        } else if (this.f5383D.equals("TPH0007")) {
            return m5018a((int) R.string.tcash_success_buy_menu_amount_fee_date, this.f5382C, C1354g.m4955f(tcashTransaction.getAmount()), C1354g.m4955f(tcashTransaction.getFee()), C1354g.m4946a("dd/MM/yyyy", tcashTransaction.getTransactionDate()));
        } else if (!this.f5383D.equals("TPH0008")) {
            return str;
        } else {
            return m5018a((int) R.string.tcash_success_pay_menu_nominal_amount_date, this.f5382C, C1354g.m4955f(tcashTransaction.getAmount()), C1354g.m4955f(tcashTransaction.getFee()), C1354g.m4951c(tcashTransaction.getTransactionDate()));
        }
    }

    private void m7516a(TcashFavorite tcashFavorite) {
        this.f5380A.m4699b(tcashFavorite, (C1245f) this);
    }

    private void m7528s() {
        this.f5381B = C1539j.m5687a();
        this.f5381B.m5690a(this.f5397l);
        this.f5380A.m4729i(this);
        m7529t();
    }

    private void m7529t() {
        TcashFavorite tcashFavorite = (TcashFavorite) getIntent().getSerializableExtra("Favorite");
        if (tcashFavorite != null) {
            if (tcashFavorite.getDestinationNo() != null) {
                String destinationNo = tcashFavorite.getDestinationNo();
                if (!destinationNo.isEmpty() && destinationNo.length() > 3) {
                    this.f5398n.mo1565b(destinationNo);
                    this.f5398n.mo1569f(destinationNo);
                }
            }
            this.f5398n.mo1562a(tcashFavorite.getAmount());
        }
    }

    public void mo1487a() {
        m4990k();
        this.h = m4967a(this.f5395P, (int) R.string.no_network);
    }

    public void m7531a(C1922f c1922f) {
        this.f5399o = c1922f;
    }

    public void mo1488a(String str) {
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f5395P, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f5379m, "onSuccessNetwork");
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("getServiceDetail".equalsIgnoreCase(str)) {
            GetServiceDetailRs getServiceDetailRs = (GetServiceDetailRs) obj;
            this.f5398n.mo1564a(getServiceDetailRs.getMenu().getDenominations());
            this.f5398n.mo1568b(getServiceDetailRs.getMenu().getDataPackages());
            this.f5398n.mo1572c(getServiceDetailRs.getMenu().getTypeInsurances());
            m7529t();
        } else if ("getPurchaseInfo".equalsIgnoreCase(str)) {
            GetPurchaseInfoRs getPurchaseInfoRs = (GetPurchaseInfoRs) obj;
            if (getPurchaseInfoRs.getTcashTransaction() != null) {
                this.f5390K = getPurchaseInfoRs.getTcashTransaction().getTransactionId();
                this.f5387H = getPurchaseInfoRs.getTcashTransaction().getDestinationNo();
                this.f5388I = getPurchaseInfoRs.getTcashTransaction().getAmount();
                this.f5389J = getPurchaseInfoRs.getTcashTransaction().getFee();
            }
            mo1505o();
        } else if ("purchaseWithTcash".equalsIgnoreCase(str)) {
            this.h = C1514b.m5649a((int) R.string.title_success, m7515a(((PurchaseWithTcashRs) obj).getTcashTransaction()));
            this.h.m5651a(this.f5394O);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        } else if ("setTcashFavoriteTransaction".equalsIgnoreCase(str)) {
            this.f5391L = null;
            this.h = C1514b.m5648a((int) R.string.title_success, (int) R.string.msg_setfavorite_success);
            this.h.m5651a(this.f5394O);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        } else if ("getTcashBalance".equalsIgnoreCase(str)) {
            this.f5400z.m7628c(String.valueOf(((GetTcashBalanceRs) obj).getTcashBalance()));
        }
    }

    public void m7535a(String str, String str2) {
        if (str2 != null && !str2.isEmpty()) {
            if (this.f5392M == null) {
                this.f5392M = new HashMap();
            }
            this.f5392M.put(str, str2);
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4967a(this.f5395P, (int) R.string.no_response);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    public void m7538e(String str) {
        this.f5384E = str;
    }

    public void m7539f(String str) {
        this.f5387H = str;
    }

    public void m7540g(String str) {
        this.f5388I = str;
    }

    public void m7541j(String str) {
        this.f5386G = str;
    }

    public void m7542k(String str) {
        this.f5391L = new TcashFavorite();
        this.f5391L.setFavoriteMenuName(str);
    }

    public void mo1505o() {
        if (this.f5399o != null) {
            this.f5399o.m7618c(this.f5382C);
            this.f5399o.m7619f(this.f5387H);
            this.f5399o.m7621h(this.f5388I);
            this.f5399o.m7622i(this.f5389J);
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.tcash_payment_fragment, this.f5399o);
            beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            beginTransaction.commit();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        this.f5400z = new C1920e();
        super.m5019a(this.f5400z);
        super.onCreate(bundle);
        this.f5384E = getIntent().getStringExtra("TCASH_MENU_ID");
        this.f5385F = getIntent().getStringExtra("TCASH_SUB_MENU_ID");
        this.f5382C = getIntent().getStringExtra("TCASH_SUB_MENU_NAME");
        this.f5383D = getIntent().getStringExtra("TCASH_TEMPLATE_ID");
        this.f5380A = this.a.m4739a();
        this.b = this.a.m4745e();
        this.f5400z.m7627b(this.f5382C);
        if (this.f5383D.equals("TPH0001")) {
            this.f5398n = new C1926g();
            this.f5398n.mo1565b(this.f5382C);
            this.f5398n.mo1566c(this.f5384E);
            m4972a((Context) this, (int) R.string.loading);
            this.f5380A.m4726g(this.f5385F, this);
        } else if (this.f5383D.equals("TPH0002")) {
            this.f5398n = new C1929h();
            m4972a((Context) this, (int) R.string.loading);
            this.f5380A.m4726g(this.f5385F, this);
        } else if (this.f5383D.equals("TPH0003")) {
            this.f5398n = new C1933i();
            this.f5398n.mo1570g(this.b.m4651b("msisdn", ""));
            m4972a((Context) this, (int) R.string.loading);
            this.f5380A.m4726g(this.f5385F, this);
        } else if (this.f5383D.equals("TPH0004")) {
            this.f5398n = new C1937j();
            this.f5398n.mo1570g(this.b.m4651b("msisdn", ""));
            m4972a((Context) this, (int) R.string.loading);
            this.f5380A.m4726g(this.f5385F, this);
        } else if (this.f5383D.equals("TPH0005")) {
            this.f5398n = new C1939k();
        } else if (this.f5383D.equals("TPH0006")) {
            this.f5398n = new C1941l();
        } else if (this.f5383D.equals("TPH0007")) {
            this.f5398n = new C1947m();
            this.f5398n.mo1565b(this.f5382C);
            m4972a((Context) this, (int) R.string.loading);
            this.f5380A.m4726g(this.f5385F, this);
        } else if (this.f5383D.equals("TPH0008")) {
            this.f5398n = new C1949n();
        }
        if (this.f5398n != null) {
            getSupportFragmentManager().beginTransaction().add((int) R.id.tcash_payment_fragment, this.f5398n).commit();
        }
        m7528s();
        if (C1358h.f2943n.equals(getIntent().getStringExtra(C1358h.f2940k))) {
            this.f5393N = true;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f5379m, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f5379m, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f5379m, " in onResume >>>>>");
    }

    public void m7544p() {
        long j = 0;
        if (!(this.f5388I == null || this.f5388I.isEmpty())) {
            j = Long.parseLong(this.f5388I);
        }
        TcashTransactionRequest tcashTransactionRequest = new TcashTransactionRequest();
        tcashTransactionRequest.setMenuId(this.f5384E);
        tcashTransactionRequest.setDestinationNo(this.f5387H);
        tcashTransactionRequest.setAmount(j);
        tcashTransactionRequest.setEtcParam(this.f5392M);
        m4972a((Context) this, (int) R.string.loading);
        this.f5380A.m4675a(tcashTransactionRequest, (C1245f) this);
    }

    public void m7545q() {
        long j = 0;
        if (!(this.f5388I == null || this.f5388I.isEmpty())) {
            j = Long.parseLong(this.f5388I);
        }
        TcashTransactionRequest tcashTransactionRequest = new TcashTransactionRequest();
        tcashTransactionRequest.setTcashPin(this.f5386G);
        tcashTransactionRequest.setMenuId(this.f5384E);
        tcashTransactionRequest.setFee(this.f5389J);
        tcashTransactionRequest.setDestinationNo(this.f5387H);
        tcashTransactionRequest.setAmount(j);
        tcashTransactionRequest.setEtcParam(this.f5392M);
        tcashTransactionRequest.setTcashTransactionId(this.f5390K);
        m4972a((Context) this, (int) R.string.loading);
        this.f5380A.m4700b(tcashTransactionRequest, (C1245f) this);
    }

    public void m7546r() {
        this.f5391L = null;
    }
}
