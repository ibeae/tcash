package com.telkom.mwallet.tcash.payment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import com.facebook.AppEventsConstants;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.C1245f;
import com.skcc.wallet.framework.api.http.model.GetPaymentInfoRs;
import com.skcc.wallet.framework.api.http.model.GetServiceDetailRs;
import com.skcc.wallet.framework.api.http.model.GetTcashBalanceRs;
import com.skcc.wallet.framework.api.http.model.PayWithTcashRs;
import com.skcc.wallet.framework.api.http.model.Region;
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
import com.telkom.mwallet.tcash.payment.p069a.C1857j;
import com.telkom.mwallet.tcash.payment.p069a.C1858k;
import com.telkom.mwallet.tcash.payment.p069a.C1860l;
import java.util.List;

public class TCashPDAMActivity extends SlidingFrameActivity {
    private static final String f4923n = TCashPDAMActivity.class.getSimpleName();
    private C1298u f4924A;
    private C1539j f4925B;
    private String f4926C = null;
    private String f4927D = null;
    private String f4928E;
    private String f4929F = null;
    private String f4930G = null;
    private String f4931H;
    private String f4932I = null;
    private Region f4933J;
    private C1858k f4934K;
    private boolean f4935L = false;
    private C1326f f4936M = new C18292(this);
    private C1326f f4937N = new C18303(this);
    TcashFavorite f4938k = null;
    int f4939l;
    C1500i f4940m = new C18281(this);
    private C1857j f4941o;
    private C1860l f4942z = null;

    class C18281 implements C1500i {
        final /* synthetic */ TCashPDAMActivity f4920a;

        C18281(TCashPDAMActivity tCashPDAMActivity) {
            this.f4920a = tCashPDAMActivity;
        }

        public void mo1546a() {
            if (this.f4920a.f4925B != null) {
                this.f4920a.f4925B.dismiss();
            }
            long j = 0;
            if (this.f4920a.f4929F != null) {
                j = Long.parseLong(this.f4920a.f4929F);
            }
            this.f4920a.f4938k.setAmount(j);
            this.f4920a.f4938k.setDestinationNo(this.f4920a.f4927D);
            this.f4920a.f4938k.setMenuId(this.f4920a.m7092u());
            this.f4920a.f4938k.setPeriod("");
            this.f4920a.f4938k.setStartDate("");
            this.f4920a.m7078a(this.f4920a.f4938k);
        }

        public void mo1547a(int i) {
            this.f4920a.f4939l = i;
            this.f4920a.f4925B.dismiss();
            String a = C1354g.m4943a(i);
            this.f4920a.f4938k.setAmount(Long.parseLong(this.f4920a.f4929F));
            this.f4920a.f4938k.setDestinationNo(this.f4920a.f4927D);
            this.f4920a.f4938k.setMenuId(this.f4920a.m7092u());
            this.f4920a.f4938k.setPeriod(C1358h.f2930a);
            this.f4920a.f4938k.setStartDate(a);
            this.f4920a.m7078a(this.f4920a.f4938k);
        }
    }

    class C18292 implements C1326f {
        final /* synthetic */ TCashPDAMActivity f4921a;

        C18292(TCashPDAMActivity tCashPDAMActivity) {
            this.f4921a = tCashPDAMActivity;
        }

        public void mo1485a() {
            if (this.f4921a.h != null) {
                this.f4921a.h.dismiss();
            }
            if (this.f4921a.f4938k != null) {
                this.f4921a.f4925B.show(this.f4921a.getSupportFragmentManager(), "reminder_dialog_tag");
            } else if (this.f4921a.f4935L) {
                this.f4921a.m5016B();
            } else {
                Intent intent = new Intent(this.f4921a, TCashActivity.class);
                intent.setFlags(67108864);
                this.f4921a.startActivity(intent);
                this.f4921a.finish();
            }
        }

        public void mo1486b() {
        }
    }

    class C18303 implements C1326f {
        final /* synthetic */ TCashPDAMActivity f4922a;

        C18303(TCashPDAMActivity tCashPDAMActivity) {
            this.f4922a = tCashPDAMActivity;
        }

        public void mo1485a() {
            if (this.f4922a.h != null) {
                this.f4922a.h.dismiss();
            }
            this.f4922a.finish();
        }

        public void mo1486b() {
        }
    }

    private void m7078a(TcashFavorite tcashFavorite) {
        this.f4924A.m4699b(tcashFavorite, (C1245f) this);
    }

    private String m7089j(String str) {
        return str.length() == 1 ? "00" + str : str.length() == 2 ? AppEventsConstants.EVENT_PARAM_VALUE_NO + str : str;
    }

    private void m7090s() {
        this.f4925B = C1539j.m5687a();
        this.f4925B.m5690a(this.f4940m);
        this.f4924A.m4729i(this);
        m7091t();
    }

    private void m7091t() {
        TcashFavorite tcashFavorite = (TcashFavorite) getIntent().getSerializableExtra("Favorite");
        if (tcashFavorite != null && tcashFavorite.getDestinationNo() != null) {
            String destinationNo = tcashFavorite.getDestinationNo();
            if (!destinationNo.isEmpty()) {
                this.f4941o.m7281b(destinationNo);
            }
        }
    }

    private String m7092u() {
        return this.f4933J == null ? "1610XXX" : "1610" + m7089j(this.f4933J.getRegionId());
    }

    public void mo1487a() {
        m4990k();
        this.h = m4967a(this.f4937N, (int) R.string.no_network);
    }

    public void m7094a(Region region) {
        this.f4933J = region;
    }

    public void mo1488a(String str) {
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f4937N, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f4923n, "onSuccessNetwork");
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("getServiceDetail".equalsIgnoreCase(str)) {
            GetServiceDetailRs getServiceDetailRs = (GetServiceDetailRs) obj;
            if (getServiceDetailRs.getMenu() != null) {
                List regions = getServiceDetailRs.getMenu().getRegions();
                if (regions != null) {
                    this.f4941o.m7280a(regions);
                    if (this.f4928E == null || this.f4928E.length() <= 5) {
                        this.f4933J = null;
                        return;
                    }
                    try {
                        int parseInt = Integer.parseInt(this.f4928E.substring(4));
                        if (parseInt > 0) {
                            this.f4933J = (Region) regions.get(parseInt - 1);
                            this.f4941o.m7279a(this.f4933J);
                        }
                    } catch (NumberFormatException e) {
                    }
                }
            }
        } else if ("getPaymentInfo".equalsIgnoreCase(str)) {
            GetPaymentInfoRs getPaymentInfoRs = (GetPaymentInfoRs) obj;
            if (getPaymentInfoRs.getTcashTransaction() != null) {
                this.f4931H = getPaymentInfoRs.getTcashTransaction().getTransactionId();
                this.f4927D = getPaymentInfoRs.getTcashTransaction().getDestinationNo();
                this.f4929F = getPaymentInfoRs.getTcashTransaction().getAmount();
                this.f4932I = getPaymentInfoRs.getMenu().getDescription();
                this.f4930G = getPaymentInfoRs.getTcashTransaction().getFee();
            }
            mo1505o();
        } else if ("setTcashFavoriteTransaction".equalsIgnoreCase(str)) {
            this.f4938k = null;
            this.h = C1514b.m5648a((int) R.string.title_success, (int) R.string.msg_setfavorite_success);
            this.h.m5651a(this.f4936M);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        } else if ("payWithTcash".equalsIgnoreCase(str)) {
            PayWithTcashRs payWithTcashRs = (PayWithTcashRs) obj;
            this.h = C1514b.m5649a((int) R.string.title_success, m5018a((int) R.string.tcash_success_pay_menu_area_nominal_amount_date, getString(R.string.title_tcash_pdam), this.f4933J.getRegionName(), payWithTcashRs.getTcashTransaction().getDestinationNo(), C1354g.m4955f(payWithTcashRs.getTcashTransaction().getAmount()), C1354g.m4951c(payWithTcashRs.getTcashTransaction().getTransactionDate())));
            this.h.m5651a(this.f4936M);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        } else if ("getTcashBalance".equalsIgnoreCase(str)) {
            this.f4934K.m7282b(String.valueOf(((GetTcashBalanceRs) obj).getTcashBalance()));
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4967a(this.f4937N, (int) R.string.no_response);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    public void m7100e(String str) {
        this.f4938k = new TcashFavorite();
        this.f4938k.setFavoriteMenuName(str);
    }

    public void m7101f(String str) {
        this.f4927D = str;
    }

    public void m7102g(String str) {
        this.f4926C = str;
    }

    public void mo1505o() {
        this.f4942z = new C1860l();
        if (this.f4933J != null) {
            this.f4942z.m7286a(this.f4933J);
            this.f4942z.m7287b(this.f4927D);
            this.f4942z.m7289f(this.f4929F);
            this.f4942z.m7288c(this.f4932I);
            this.f4942z.m7290g(this.f4930G);
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.tcash_payment_fragment, this.f4942z);
        beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        beginTransaction.commit();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        this.f4934K = new C1858k();
        super.m5019a(this.f4934K);
        super.onCreate(bundle);
        this.f4924A = this.a.m4739a();
        this.f4928E = getIntent().getStringExtra("TCASH_MENU_ID");
        this.f4941o = new C1857j();
        getSupportFragmentManager().beginTransaction().add((int) R.id.tcash_payment_fragment, this.f4941o).commit();
        if (C1358h.f2943n.equals(getIntent().getStringExtra(C1358h.f2940k))) {
            this.f4935L = true;
        }
        m7090s();
        m4972a((Context) this, (int) R.string.loading);
        this.f4924A.m4726g(m7092u(), this);
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f4923n, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f4923n, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f4923n, " in onResume >>>>>");
    }

    public void m7104p() {
        this.f4929F = null;
        TcashTransactionRequest tcashTransactionRequest = new TcashTransactionRequest();
        tcashTransactionRequest.setMenuId(m7092u());
        tcashTransactionRequest.setDestinationNo(this.f4927D);
        tcashTransactionRequest.setRegionId(this.f4933J.getRegionId());
        m4972a((Context) this, (int) R.string.loading);
        this.f4924A.m4720e(tcashTransactionRequest, (C1245f) this);
    }

    public void m7105q() {
        long parseLong = Long.parseLong(this.f4929F);
        TcashTransactionRequest tcashTransactionRequest = new TcashTransactionRequest();
        tcashTransactionRequest.setTcashPin(this.f4926C);
        tcashTransactionRequest.setMenuId(m7092u());
        tcashTransactionRequest.setFee(this.f4930G);
        tcashTransactionRequest.setDestinationNo(this.f4927D);
        tcashTransactionRequest.setAmount(parseLong);
        tcashTransactionRequest.setTcashTransactionId(this.f4931H);
        tcashTransactionRequest.setRegionId(this.f4933J.getRegionId());
        m4972a((Context) this, (int) R.string.loading);
        this.f4924A.m4723f(tcashTransactionRequest, (C1245f) this);
    }

    public void m7106r() {
        this.f4938k = null;
    }
}
