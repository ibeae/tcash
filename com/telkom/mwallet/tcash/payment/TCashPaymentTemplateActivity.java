package com.telkom.mwallet.tcash.payment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.C1245f;
import com.skcc.wallet.framework.api.http.model.Denomination;
import com.skcc.wallet.framework.api.http.model.GetPaymentInfoRs;
import com.skcc.wallet.framework.api.http.model.GetServiceDetailRs;
import com.skcc.wallet.framework.api.http.model.GetTcashBalanceRs;
import com.skcc.wallet.framework.api.http.model.PayWithTcashRs;
import com.skcc.wallet.framework.api.http.model.Region;
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
import com.telkom.mwallet.tcash.payment.p069a.C1872q;
import com.telkom.mwallet.tcash.payment.p069a.C1874r;
import com.telkom.mwallet.tcash.payment.p069a.C1876s;
import com.telkom.mwallet.tcash.payment.p069a.C1880t;
import com.telkom.mwallet.tcash.payment.p069a.C1882u;
import com.telkom.mwallet.tcash.payment.p069a.C1886v;
import com.telkom.mwallet.tcash.payment.p069a.C1888w;
import com.telkom.mwallet.tcash.payment.p069a.C1892x;
import com.telkom.mwallet.tcash.payment.p069a.C1894y;
import com.telkom.mwallet.tcash.payment.p069a.C1896z;
import com.telkom.mwallet.tcash.payment.p069a.aa;
import com.telkom.mwallet.tcash.payment.p069a.ab;
import com.telkom.mwallet.tcash.payment.p069a.ac;
import java.util.HashMap;
import java.util.Map;

public class TCashPaymentTemplateActivity extends SlidingFrameActivity {
    private static final String f4968m = TCashPaymentTemplateActivity.class.getSimpleName();
    private C1298u f4969A;
    private C1539j f4970B;
    private String f4971C = null;
    private String f4972D = null;
    private String f4973E = null;
    private String f4974F = null;
    private String f4975G = null;
    private String f4976H = null;
    private String f4977I = null;
    private String f4978J;
    private String f4979K = null;
    private String f4980L = null;
    private String f4981M = null;
    private String f4982N;
    private String f4983O = null;
    private String f4984P = null;
    private Denomination f4985Q;
    private Region f4986R;
    private TcashFavorite f4987S = null;
    private aa f4988T;
    private Map<String, String> f4989U = null;
    private boolean f4990V = false;
    private boolean f4991W = false;
    private C1326f f4992X = new C18341(this);
    private C1326f f4993Y = new C18352(this);
    int f4994k;
    C1500i f4995l = new C18363(this);
    private C1872q f4996n;
    private ac f4997o = null;
    private ab f4998z = null;

    class C18341 implements C1326f {
        final /* synthetic */ TCashPaymentTemplateActivity f4965a;

        C18341(TCashPaymentTemplateActivity tCashPaymentTemplateActivity) {
            this.f4965a = tCashPaymentTemplateActivity;
        }

        public void mo1485a() {
            if (this.f4965a.h != null) {
                this.f4965a.h.dismiss();
            }
            if (this.f4965a.f4987S != null) {
                this.f4965a.f4970B.show(this.f4965a.getSupportFragmentManager(), "reminder_dialog_tag");
            } else if (this.f4965a.f4990V) {
                this.f4965a.m5016B();
            } else {
                Intent intent = new Intent(this.f4965a, TCashActivity.class);
                intent.setFlags(67108864);
                this.f4965a.startActivity(intent);
                this.f4965a.finish();
            }
        }

        public void mo1486b() {
        }
    }

    class C18352 implements C1326f {
        final /* synthetic */ TCashPaymentTemplateActivity f4966a;

        C18352(TCashPaymentTemplateActivity tCashPaymentTemplateActivity) {
            this.f4966a = tCashPaymentTemplateActivity;
        }

        public void mo1485a() {
            if (this.f4966a.h != null) {
                this.f4966a.h.dismiss();
            }
            this.f4966a.finish();
        }

        public void mo1486b() {
        }
    }

    class C18363 implements C1500i {
        final /* synthetic */ TCashPaymentTemplateActivity f4967a;

        C18363(TCashPaymentTemplateActivity tCashPaymentTemplateActivity) {
            this.f4967a = tCashPaymentTemplateActivity;
        }

        public void mo1546a() {
            if (this.f4967a.f4970B != null) {
                this.f4967a.f4970B.dismiss();
            }
            long j = 0;
            if (!(this.f4967a.f4977I == null || this.f4967a.f4977I.isEmpty())) {
                j = Long.parseLong(this.f4967a.f4977I);
            }
            this.f4967a.f4987S.setAmount(j);
            this.f4967a.f4987S.setDestinationNo(this.f4967a.f4976H);
            this.f4967a.f4987S.setMenuId(this.f4967a.m7164v());
            this.f4967a.f4987S.setPeriod("");
            this.f4967a.f4987S.setStartDate("");
            this.f4967a.m7150a(this.f4967a.f4987S);
        }

        public void mo1547a(int i) {
            this.f4967a.f4994k = i;
            this.f4967a.f4970B.dismiss();
            String a = C1354g.m4943a(i);
            long j = 0;
            if (!(this.f4967a.f4977I == null || this.f4967a.f4977I.isEmpty())) {
                j = Long.parseLong(this.f4967a.f4977I);
            }
            this.f4967a.f4987S.setAmount(j);
            this.f4967a.f4987S.setDestinationNo(this.f4967a.f4976H);
            this.f4967a.f4987S.setMenuId(this.f4967a.m7164v());
            this.f4967a.f4987S.setPeriod(C1358h.f2930a);
            this.f4967a.f4987S.setStartDate(a);
            this.f4967a.m7150a(this.f4967a.f4987S);
        }
    }

    private void m7150a(TcashFavorite tcashFavorite) {
        this.f4969A.m4699b(tcashFavorite, (C1245f) this);
    }

    private void m7162t() {
        this.f4970B = C1539j.m5687a();
        this.f4970B.m5690a(this.f4995l);
        this.f4969A.m4729i(this);
        m7163u();
    }

    private void m7163u() {
        TcashFavorite tcashFavorite = (TcashFavorite) getIntent().getSerializableExtra("Favorite");
        if (tcashFavorite != null) {
            String destinationNo = tcashFavorite.getDestinationNo();
            if (!(destinationNo == null || destinationNo.isEmpty())) {
                this.f4996n.mo1554b(destinationNo);
            }
            this.f4996n.mo1555a(tcashFavorite.getAmount());
        }
    }

    private String m7164v() {
        return this.f4985Q != null ? this.f4985Q.getDenomId() : this.f4986R != null ? this.f4986R.getRegionId() : this.f4972D;
    }

    public void mo1487a() {
        m4990k();
        this.h = m4967a(this.f4993Y, (int) R.string.no_network);
    }

    public void m7166a(Denomination denomination) {
        this.f4985Q = denomination;
        if (denomination != null) {
            this.f4977I = "" + denomination.getAmount();
        }
    }

    public void m7167a(Region region) {
        this.f4986R = region;
    }

    public void m7168a(ab abVar) {
        this.f4998z = abVar;
    }

    public void mo1488a(String str) {
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f4993Y, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f4968m, "onSuccessNetwork");
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("getServiceDetail".equalsIgnoreCase(str)) {
            GetServiceDetailRs getServiceDetailRs = (GetServiceDetailRs) obj;
            this.f4996n.mo1557a(getServiceDetailRs.getMenu().getDenominations());
            this.f4996n.mo1559b(getServiceDetailRs.getMenu().getRegions());
            m7163u();
        } else if ("getPaymentInfo".equalsIgnoreCase(str)) {
            GetPaymentInfoRs getPaymentInfoRs = (GetPaymentInfoRs) obj;
            if (getPaymentInfoRs.getTcashTransaction() != null) {
                this.f4978J = getPaymentInfoRs.getTcashTransaction().getTransactionId();
                this.f4976H = getPaymentInfoRs.getTcashTransaction().getDestinationNo();
                this.f4977I = getPaymentInfoRs.getTcashTransaction().getAmount();
                this.f4979K = getPaymentInfoRs.getMenu().getDescription();
                this.f4980L = getPaymentInfoRs.getTcashTransaction().getFee();
            }
            if (this.f4981M.equals("TPM0008") || this.f4981M.equals("TPM0009")) {
                m7183p();
            } else {
                mo1505o();
            }
        } else if ("payWithTcash".equalsIgnoreCase(str)) {
            String str2 = "";
            TcashTransaction tcashTransaction = ((PayWithTcashRs) obj).getTcashTransaction();
            if (this.f4981M.equals("TPM0002")) {
                if ("PREPAID".equals(this.f4975G)) {
                    str2 = m5018a((int) R.string.tcash_success_purchase_menu_nominal_amount_date, this.f4973E, tcashTransaction.getDestinationNo(), C1354g.m4955f(tcashTransaction.getAmount()), C1354g.m4951c(tcashTransaction.getTransactionDate()));
                } else {
                    str2 = m5018a((int) R.string.tcash_success_pay_menu_nominal_amount_date, this.f4973E, tcashTransaction.getDestinationNo(), C1354g.m4955f(tcashTransaction.getAmount()), C1354g.m4951c(tcashTransaction.getTransactionDate()));
                }
            } else if (this.f4981M.equals("TPM0003")) {
                str2 = m5018a((int) R.string.tcash_success_topup_menu_nominal_amount_date, this.f4973E, tcashTransaction.getDestinationNo(), C1354g.m4955f(tcashTransaction.getAmount()), C1354g.m4951c(tcashTransaction.getTransactionDate()));
            } else if (this.f4981M.equals("TPM0008") || this.f4981M.equals("TPM0009")) {
                str2 = m5018a((int) R.string.tcash_success_pay_menu_company_nominal_amount_date, this.f4973E, tcashTransaction.getDestinationNo(), C1354g.m4955f(tcashTransaction.getAmount()), C1354g.m4951c(tcashTransaction.getTransactionDate()));
            } else {
                str2 = m5018a((int) R.string.tcash_success_pay_menu_nominal_amount_date, this.f4973E, tcashTransaction.getDestinationNo(), C1354g.m4955f(tcashTransaction.getAmount()), C1354g.m4951c(tcashTransaction.getTransactionDate()));
            }
            this.h = C1514b.m5649a((int) R.string.title_success, str2);
            this.h.m5651a(this.f4992X);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        } else if ("setTcashFavoriteTransaction".equalsIgnoreCase(str)) {
            this.f4987S = null;
            this.h = C1514b.m5648a((int) R.string.title_success, (int) R.string.msg_setfavorite_success);
            this.h.m5651a(this.f4992X);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        } else if ("getTcashBalance".equalsIgnoreCase(str)) {
            this.f4988T.m7196b(String.valueOf(((GetTcashBalanceRs) obj).getTcashBalance()));
        }
    }

    public void m7172a(String str, String str2) {
        this.f4983O = str;
        this.f4984P = str2;
    }

    public void mo1491b() {
        m4990k();
        this.h = m4967a(this.f4993Y, (int) R.string.no_response);
    }

    public void m7174b(String str, String str2) {
        if (str2 != null && !str2.isEmpty()) {
            if (this.f4989U == null) {
                this.f4989U = new HashMap();
            }
            this.f4989U.put(str, str2);
        }
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    public void m7176e(String str) {
        if (!(str == null || "".equals(str))) {
            this.f4977I = str;
        }
        this.f4991W = true;
        mo1505o();
    }

    public void m7177f(String str) {
        this.f4987S = new TcashFavorite();
        this.f4987S.setFavoriteMenuName(str);
    }

    public void m7178g(String str) {
        this.f4976H = str;
    }

    public void m7179j(String str) {
        this.f4974F = str;
    }

    public void m7180k(String str) {
        this.f4977I = str;
    }

    public void m7181l(String str) {
        this.f4975G = str;
    }

    public void mo1505o() {
        this.f4997o = new ac();
        this.f4997o.m7210b(this.f4973E);
        this.f4997o.m7211c(this.f4976H);
        this.f4997o.m7212f(this.f4979K);
        this.f4997o.m7213g(this.f4977I);
        this.f4997o.m7214h(this.f4980L);
        this.f4997o.m7208a(this.f4983O, this.f4984P);
        this.f4997o.m7209a(this.f4991W);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.tcash_payment_fragment, this.f4997o);
        beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        beginTransaction.commit();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        this.f4988T = new aa();
        super.m5019a(this.f4988T);
        super.onCreate(bundle);
        this.f4969A = this.a.m4739a();
        this.f4971C = getIntent().getStringExtra("TCASH_MENU_NAME");
        this.f4972D = getIntent().getStringExtra("TCASH_SUB_MENU_ID");
        this.f4973E = getIntent().getStringExtra("TCASH_SUB_MENU_NAME");
        this.f4981M = getIntent().getStringExtra("TCASH_TEMPLATE_ID");
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (this.f4981M.equals("TPM0001")) {
            this.f4996n = new C1874r();
        } else if (this.f4981M.equals("TPM0002")) {
            this.f4996n = new C1876s();
        } else if (this.f4981M.equals("TPM0003")) {
            this.f4996n = new C1880t();
            m4972a((Context) this, (int) R.string.loading);
            this.f4969A.m4726g(m7164v(), this);
        } else if (this.f4981M.equals("TPM0004")) {
            this.f4996n = new C1882u();
        } else if (this.f4981M.equals("TPM0005")) {
            this.f4996n = new C1886v();
            m4972a((Context) this, (int) R.string.loading);
            this.f4969A.m4726g(m7164v(), this);
        } else if (this.f4981M.equals("TPM0006")) {
            this.f4996n = new C1888w();
        } else if (this.f4981M.equals("TPM0007")) {
            this.f4996n = new C1892x();
            m4972a((Context) this, (int) R.string.loading);
            this.f4969A.m4726g(m7164v(), this);
        } else if (this.f4981M.equals("TPM0008") || this.f4981M.equals("TPM0009")) {
            this.f4996n = new C1894y();
            this.f4996n.mo1560f(this.f4981M);
        } else if (this.f4981M.equals("TPM0010")) {
            this.f4996n = new C1896z();
        } else {
            this.f4996n = new C1880t();
            m4972a((Context) this, (int) R.string.loading);
            this.f4969A.m4726g(m7164v(), this);
        }
        beginTransaction.add(R.id.tcash_payment_fragment, this.f4996n, f4968m).commit();
        if (C1358h.f2943n.equals(getIntent().getStringExtra(C1358h.f2940k))) {
            this.f4990V = true;
        }
        this.f4988T.m7195a(this.f4971C, this.f4973E);
        this.f4996n.mo1553c(this.b.m4651b("msisdn", ""));
        m7162t();
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f4968m, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f4968m, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f4968m, " in onResume >>>>>");
    }

    public void m7183p() {
        if (this.f4998z != null) {
            this.f4998z.m7200b(this.f4976H);
            this.f4998z.m7201c(this.f4977I);
            this.f4998z.m7202f(this.f4982N);
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.tcash_payment_fragment, this.f4998z);
            beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            beginTransaction.commit();
        }
    }

    public void m7184q() {
        TcashTransactionRequest tcashTransactionRequest = new TcashTransactionRequest();
        tcashTransactionRequest.setMenuId(m7164v());
        tcashTransactionRequest.setDestinationNo(this.f4976H);
        tcashTransactionRequest.setEtcParam(this.f4989U);
        if (this.f4977I != null) {
            tcashTransactionRequest.setAmount(Long.parseLong(this.f4977I));
        }
        m4972a((Context) this, (int) R.string.loading);
        this.f4969A.m4720e(tcashTransactionRequest, (C1245f) this);
    }

    public void m7185r() {
        long j = 0;
        if (this.f4977I != null) {
            j = Long.parseLong(this.f4977I);
        }
        TcashTransactionRequest tcashTransactionRequest = new TcashTransactionRequest();
        tcashTransactionRequest.setTcashPin(this.f4974F);
        tcashTransactionRequest.setMenuId(m7164v());
        tcashTransactionRequest.setDestinationNo(this.f4976H);
        tcashTransactionRequest.setAmount(j);
        tcashTransactionRequest.setTcashTransactionId(this.f4978J);
        tcashTransactionRequest.setEtcParam(this.f4989U);
        m4972a((Context) this, (int) R.string.loading);
        this.f4969A.m4723f(tcashTransactionRequest, (C1245f) this);
    }

    public void m7186s() {
        this.f4987S = null;
    }
}
