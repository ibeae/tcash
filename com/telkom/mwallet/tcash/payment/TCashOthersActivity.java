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
import com.telkom.mwallet.tcash.payment.p069a.C1850g;
import com.telkom.mwallet.tcash.payment.p069a.C1851h;
import com.telkom.mwallet.tcash.payment.p069a.C1853i;
import java.util.HashMap;
import java.util.Map;

public class TCashOthersActivity extends SlidingFrameActivity {
    private static final String f4901n = TCashOthersActivity.class.getSimpleName();
    private C1298u f4902A;
    private C1539j f4903B;
    private String f4904C = null;
    private String f4905D = null;
    private String f4906E = null;
    private String f4907F = null;
    private String f4908G = null;
    private String f4909H;
    private C1851h f4910I;
    private boolean f4911J = false;
    private Map<String, String> f4912K = null;
    private C1326f f4913L = new C18262(this);
    private C1326f f4914M = new C18273(this);
    TcashFavorite f4915k = null;
    int f4916l = -1;
    C1500i f4917m = new C18251(this);
    private C1850g f4918o;
    private C1853i f4919z = null;

    class C18251 implements C1500i {
        final /* synthetic */ TCashOthersActivity f4898a;

        C18251(TCashOthersActivity tCashOthersActivity) {
            this.f4898a = tCashOthersActivity;
        }

        public void mo1546a() {
            if (this.f4898a.f4903B != null) {
                this.f4898a.f4903B.dismiss();
            }
            long j = 0;
            if (this.f4898a.f4907F != null) {
                j = Long.parseLong(this.f4898a.f4907F);
            }
            this.f4898a.f4915k.setAmount(j);
            this.f4898a.f4915k.setDestinationNo(this.f4898a.f4905D);
            this.f4898a.f4915k.setMenuId("9100000");
            this.f4898a.f4915k.setPeriod("");
            this.f4898a.f4915k.setStartDate("");
            this.f4898a.m7044a(this.f4898a.f4915k);
        }

        public void mo1547a(int i) {
            this.f4898a.f4916l = i;
            this.f4898a.f4903B.dismiss();
            String a = C1354g.m4943a(i);
            this.f4898a.f4915k.setAmount(Long.parseLong(this.f4898a.f4907F));
            this.f4898a.f4915k.setDestinationNo(this.f4898a.f4905D);
            this.f4898a.f4915k.setMenuId("9100000");
            this.f4898a.f4915k.setPeriod(C1358h.f2930a);
            this.f4898a.f4915k.setStartDate(a);
            this.f4898a.m7044a(this.f4898a.f4915k);
        }
    }

    class C18262 implements C1326f {
        final /* synthetic */ TCashOthersActivity f4899a;

        C18262(TCashOthersActivity tCashOthersActivity) {
            this.f4899a = tCashOthersActivity;
        }

        public void mo1485a() {
            if (this.f4899a.h != null) {
                this.f4899a.h.dismiss();
            }
            if (this.f4899a.f4915k != null) {
                this.f4899a.f4903B.show(this.f4899a.getSupportFragmentManager(), "reminder_dialog_tag");
            } else if (this.f4899a.f4911J) {
                this.f4899a.m5016B();
            } else {
                Intent intent = new Intent(this.f4899a, TCashActivity.class);
                intent.setFlags(67108864);
                this.f4899a.startActivity(intent);
                this.f4899a.finish();
            }
        }

        public void mo1486b() {
        }
    }

    class C18273 implements C1326f {
        final /* synthetic */ TCashOthersActivity f4900a;

        C18273(TCashOthersActivity tCashOthersActivity) {
            this.f4900a = tCashOthersActivity;
        }

        public void mo1485a() {
            if (this.f4900a.h != null) {
                this.f4900a.h.dismiss();
            }
            this.f4900a.finish();
        }

        public void mo1486b() {
        }
    }

    private void m7044a(TcashFavorite tcashFavorite) {
        this.f4902A.m4699b(tcashFavorite, (C1245f) this);
    }

    private void m7054s() {
        this.f4903B = C1539j.m5687a();
        this.f4903B.m5690a(this.f4917m);
        this.f4902A.m4729i(this);
        m7055t();
    }

    private void m7055t() {
        TcashFavorite tcashFavorite = (TcashFavorite) getIntent().getSerializableExtra("Favorite");
        if (tcashFavorite != null && tcashFavorite.getDestinationNo() != null) {
            String destinationNo = tcashFavorite.getDestinationNo();
            if (!destinationNo.isEmpty() && destinationNo.length() > 3) {
                this.f4918o.m7252b(destinationNo);
            }
        }
    }

    public void mo1487a() {
        m4990k();
        this.h = m4967a(this.f4914M, (int) R.string.no_network);
    }

    public void mo1488a(String str) {
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f4914M, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f4901n, "onSuccessNetwork");
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("getTcashBalance".equalsIgnoreCase(str)) {
            this.f4910I.m7254b(String.valueOf(((GetTcashBalanceRs) obj).getTcashBalance()));
        } else if ("getPaymentInfo".equalsIgnoreCase(str)) {
            GetPaymentInfoRs getPaymentInfoRs = (GetPaymentInfoRs) obj;
            if (getPaymentInfoRs.getTcashTransaction() != null) {
                this.f4909H = getPaymentInfoRs.getTcashTransaction().getTransactionId();
                this.f4905D = getPaymentInfoRs.getTcashTransaction().getDestinationNo();
                this.f4907F = getPaymentInfoRs.getTcashTransaction().getAmount();
                this.f4908G = getPaymentInfoRs.getTcashTransaction().getFee();
            }
            mo1505o();
        } else if ("payWithTcash".equalsIgnoreCase(str)) {
            PayWithTcashRs payWithTcashRs = (PayWithTcashRs) obj;
            String str2 = "";
            this.h = C1514b.m5649a((int) R.string.title_success, m5018a((int) R.string.tcash_success_pay_menu_nominal_amount_date, getString(R.string.title_tcash_others), payWithTcashRs.getTcashTransaction().getDestinationNo(), C1354g.m4955f(payWithTcashRs.getTcashTransaction().getAmount()), C1354g.m4951c(payWithTcashRs.getTcashTransaction().getTransactionDate())));
            this.h.m5651a(this.f4913L);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        } else if ("setTcashFavoriteTransaction".equalsIgnoreCase(str)) {
            this.f4915k = null;
            this.h = C1514b.m5648a((int) R.string.title_success, (int) R.string.msg_setfavorite_success);
            this.h.m5651a(this.f4913L);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        }
    }

    public void m7060a(String str, String str2) {
        if (str2 != null && !str2.isEmpty()) {
            if (this.f4912K == null) {
                this.f4912K = new HashMap();
            }
            this.f4912K.put(str, str2);
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4967a(this.f4914M, (int) R.string.no_response);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    public void m7063e(String str) {
        this.f4905D = str;
    }

    public void m7064f(String str) {
        this.f4906E = str;
        m7060a("billingCode", str);
    }

    public void m7065g(String str) {
        this.f4904C = str;
    }

    public void m7066j(String str) {
        this.f4915k = new TcashFavorite();
        this.f4915k.setFavoriteMenuName(str);
    }

    public void mo1505o() {
        this.f4919z = new C1853i();
        if (this.f4907F != null) {
            this.f4919z.m7258b(this.f4905D);
            this.f4919z.m7259c(this.f4906E);
            this.f4919z.m7260f(this.f4907F);
            this.f4919z.m7261g(this.f4908G);
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.tcash_payment_fragment, this.f4919z);
        beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        beginTransaction.commit();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        this.f4910I = new C1851h();
        super.m5019a(this.f4910I);
        super.onCreate(bundle);
        this.f4902A = this.a.m4739a();
        this.f4918o = new C1850g();
        getSupportFragmentManager().beginTransaction().add((int) R.id.tcash_payment_fragment, this.f4918o).commit();
        if (C1358h.f2943n.equals(getIntent().getStringExtra(C1358h.f2940k))) {
            this.f4911J = true;
        }
        m7054s();
        if (getIntent().hasExtra("PARTNER_CODE")) {
            this.f4905D = getIntent().getStringExtra("PARTNER_CODE");
            this.f4918o.m7252b(this.f4905D);
        }
        if (getIntent().hasExtra("BILLING_CODE")) {
            this.f4906E = getIntent().getStringExtra("BILLING_CODE");
            this.f4918o.m7253c(this.f4906E);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f4901n, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f4901n, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f4901n, " in onResume >>>>>");
    }

    public void m7068p() {
        this.f4907F = null;
        TcashTransactionRequest tcashTransactionRequest = new TcashTransactionRequest();
        tcashTransactionRequest.setMenuId("9100000");
        tcashTransactionRequest.setDestinationNo(this.f4905D);
        tcashTransactionRequest.setEtcParam(this.f4912K);
        m4972a((Context) this, (int) R.string.loading);
        this.f4902A.m4720e(tcashTransactionRequest, (C1245f) this);
    }

    public void m7069q() {
        long j = 0;
        if (this.f4907F != null) {
            j = Long.parseLong(this.f4907F);
        }
        TcashTransactionRequest tcashTransactionRequest = new TcashTransactionRequest();
        tcashTransactionRequest.setTcashPin(this.f4904C);
        tcashTransactionRequest.setMenuId("9100000");
        tcashTransactionRequest.setFee(this.f4908G);
        tcashTransactionRequest.setDestinationNo(this.f4905D);
        tcashTransactionRequest.setAmount(j);
        tcashTransactionRequest.setEtcParam(this.f4912K);
        tcashTransactionRequest.setTcashTransactionId(this.f4909H);
        m4972a((Context) this, (int) R.string.loading);
        this.f4902A.m4723f(tcashTransactionRequest, (C1245f) this);
    }

    public void m7070r() {
        this.f4915k = null;
    }
}
