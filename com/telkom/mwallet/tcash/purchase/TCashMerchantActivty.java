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
import com.telkom.mwallet.tcash.purchase.p070a.C1913a;
import com.telkom.mwallet.tcash.purchase.p070a.C1914b;
import com.telkom.mwallet.tcash.purchase.p070a.C1918c;

public class TCashMerchantActivty extends SlidingFrameActivity {
    private static final String f5357m = TCashMerchantActivty.class.getSimpleName();
    private C1298u f5358A;
    private C1539j f5359B;
    private String f5360C = null;
    private String f5361D = null;
    private String f5362E = null;
    private String f5363F = null;
    private String f5364G;
    private TcashFavorite f5365H = null;
    private boolean f5366I = false;
    private String f5367J;
    private String f5368K;
    private C1326f f5369L = new C18982(this);
    private C1326f f5370M = new C18993(this);
    int f5371k = -1;
    C1500i f5372l = new C18971(this);
    private C1913a f5373n;
    private C1918c f5374o = null;
    private C1914b f5375z;

    class C18971 implements C1500i {
        final /* synthetic */ TCashMerchantActivty f5354a;

        C18971(TCashMerchantActivty tCashMerchantActivty) {
            this.f5354a = tCashMerchantActivty;
        }

        public void mo1546a() {
            if (this.f5354a.f5359B != null) {
                this.f5354a.f5359B.dismiss();
            }
            long j = 0;
            if (!(this.f5354a.f5362E == null || this.f5354a.f5362E.isEmpty())) {
                j = Long.parseLong(this.f5354a.f5362E);
            }
            this.f5354a.f5365H.setAmount(j);
            this.f5354a.f5365H.setDestinationNo(this.f5354a.f5361D);
            this.f5354a.f5365H.setMenuId("8100000");
            this.f5354a.f5365H.setPeriod("");
            this.f5354a.f5365H.setStartDate("");
            this.f5354a.m7481a(this.f5354a.f5365H);
        }

        public void mo1547a(int i) {
            this.f5354a.f5371k = i;
            this.f5354a.f5359B.dismiss();
            String a = C1354g.m4943a(i);
            long j = 0;
            if (!(this.f5354a.f5362E == null || this.f5354a.f5362E.isEmpty())) {
                j = Long.parseLong(this.f5354a.f5362E);
            }
            this.f5354a.f5365H.setAmount(j);
            this.f5354a.f5365H.setDestinationNo(this.f5354a.f5361D);
            this.f5354a.f5365H.setMenuId("8100000");
            this.f5354a.f5365H.setPeriod(C1358h.f2930a);
            this.f5354a.f5365H.setStartDate(a);
            this.f5354a.m7481a(this.f5354a.f5365H);
        }
    }

    class C18982 implements C1326f {
        final /* synthetic */ TCashMerchantActivty f5355a;

        C18982(TCashMerchantActivty tCashMerchantActivty) {
            this.f5355a = tCashMerchantActivty;
        }

        public void mo1485a() {
            if (this.f5355a.h != null) {
                this.f5355a.h.dismiss();
            }
            if (this.f5355a.f5365H != null) {
                this.f5355a.f5359B.show(this.f5355a.getSupportFragmentManager(), "reminder_dialog_tag");
            } else if (this.f5355a.f5366I) {
                this.f5355a.m5016B();
            } else {
                Intent intent = new Intent(this.f5355a, TCashActivity.class);
                intent.setFlags(67108864);
                this.f5355a.startActivity(intent);
                this.f5355a.finish();
            }
        }

        public void mo1486b() {
        }
    }

    class C18993 implements C1326f {
        final /* synthetic */ TCashMerchantActivty f5356a;

        C18993(TCashMerchantActivty tCashMerchantActivty) {
            this.f5356a = tCashMerchantActivty;
        }

        public void mo1485a() {
            if (this.f5356a.h != null) {
                this.f5356a.h.dismiss();
            }
            this.f5356a.finish();
        }

        public void mo1486b() {
        }
    }

    private void m7481a(TcashFavorite tcashFavorite) {
        this.f5358A.m4699b(this.f5365H, (C1245f) this);
    }

    private void m7492s() {
        this.f5359B = C1539j.m5687a();
        this.f5359B.m5690a(this.f5372l);
        this.f5358A.m4729i(this);
        m7493t();
    }

    private void m7493t() {
        TcashFavorite tcashFavorite = (TcashFavorite) getIntent().getSerializableExtra("Favorite");
        if (tcashFavorite != null) {
            if (tcashFavorite.getDestinationNo() != null) {
                String destinationNo = tcashFavorite.getDestinationNo();
                if (!destinationNo.isEmpty() && destinationNo.length() > 3) {
                    this.f5373n.m7606b(destinationNo);
                }
            }
            this.f5373n.m7607c(tcashFavorite.getAmount() + "");
        }
    }

    public void mo1487a() {
        m4990k();
        this.h = m4967a(this.f5370M, (int) R.string.no_network);
    }

    public void mo1488a(String str) {
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f5370M, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f5357m, "onSuccessNetwork");
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("getPurchaseInfo".equalsIgnoreCase(str)) {
            GetPurchaseInfoRs getPurchaseInfoRs = (GetPurchaseInfoRs) obj;
            if (getPurchaseInfoRs.getTcashTransaction() != null) {
                this.f5364G = getPurchaseInfoRs.getTcashTransaction().getTransactionId();
                this.f5361D = getPurchaseInfoRs.getTcashTransaction().getDestinationNo();
                this.f5362E = getPurchaseInfoRs.getTcashTransaction().getAmount();
                this.f5363F = getPurchaseInfoRs.getTcashTransaction().getFee();
                this.f5367J = getPurchaseInfoRs.getTcashTransaction().getInfo();
            }
            mo1505o();
        } else if ("purchaseWithTcash".equalsIgnoreCase(str)) {
            PurchaseWithTcashRs purchaseWithTcashRs = (PurchaseWithTcashRs) obj;
            if (this.f5367J == null || "".equals(this.f5367J)) {
                this.f5368K = getString(R.string.merchant);
            } else {
                this.f5368K = this.f5367J;
            }
            this.h = C1514b.m5649a((int) R.string.title_success, m5018a((int) R.string.tcash_success_pay_menu_amount_fee_date, this.f5368K, C1354g.m4955f(purchaseWithTcashRs.getTcashTransaction().getAmount()), C1354g.m4955f(purchaseWithTcashRs.getTcashTransaction().getFee()), C1354g.m4951c(purchaseWithTcashRs.getTcashTransaction().getTransactionDate())));
            this.h.m5651a(this.f5369L);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        } else if ("getTcashBalance".equalsIgnoreCase(str)) {
            this.f5375z.m7610b(String.valueOf(((GetTcashBalanceRs) obj).getTcashBalance()));
        } else if ("setTcashFavoriteTransaction".equalsIgnoreCase(str)) {
            this.f5365H = null;
            this.h = C1514b.m5648a((int) R.string.title_success, (int) R.string.msg_setfavorite_success);
            this.h.m5651a(this.f5369L);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4967a(this.f5370M, (int) R.string.no_response);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    public void m7500e(String str) {
        this.f5361D = str;
    }

    public void m7501f(String str) {
        this.f5362E = str;
    }

    public void m7502g(String str) {
        this.f5360C = str;
    }

    public void m7503j(String str) {
        this.f5365H = new TcashFavorite();
        this.f5365H.setFavoriteMenuName(str);
    }

    public void mo1505o() {
        this.f5374o = new C1918c();
        if (this.f5367J == null || "".equals(this.f5367J)) {
            this.f5374o.m7618c(getString(R.string.merchant));
        } else {
            this.f5374o.m7618c(this.f5367J);
        }
        this.f5374o.m7623j(getString(R.string.merchant_number));
        this.f5374o.m7619f(this.f5361D);
        this.f5374o.m7621h(this.f5362E);
        this.f5374o.m7622i(this.f5363F);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.tcash_payment_fragment, this.f5374o);
        beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        beginTransaction.commit();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        this.f5375z = new C1914b();
        super.m5019a(this.f5375z);
        super.onCreate(bundle);
        this.f5358A = this.a.m4739a();
        this.b = this.a.m4745e();
        this.f5373n = new C1913a();
        getSupportFragmentManager().beginTransaction().add((int) R.id.tcash_payment_fragment, this.f5373n).commit();
        m7492s();
        if (C1358h.f2943n.equals(getIntent().getStringExtra(C1358h.f2940k))) {
            this.f5366I = true;
        }
        if (getIntent().hasExtra("MERCHANT_CODE")) {
            this.f5361D = getIntent().getStringExtra("MERCHANT_CODE");
            this.f5373n.m7606b(this.f5361D);
        }
        if (getIntent().hasExtra("AMOUNT")) {
            this.f5362E = getIntent().getStringExtra("AMOUNT");
            this.f5373n.m7607c(this.f5362E);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f5357m, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f5357m, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f5357m, " in onResume >>>>>");
    }

    public void m7505p() {
        long j = 0;
        if (!(this.f5362E == null || this.f5362E.isEmpty())) {
            j = Long.parseLong(this.f5362E);
        }
        TcashTransactionRequest tcashTransactionRequest = new TcashTransactionRequest();
        tcashTransactionRequest.setMenuId("8100000");
        tcashTransactionRequest.setDestinationNo(this.f5361D);
        tcashTransactionRequest.setAmount(j);
        m4972a((Context) this, (int) R.string.loading);
        this.f5358A.m4675a(tcashTransactionRequest, (C1245f) this);
    }

    public void m7506q() {
        long j = 0;
        if (!(this.f5362E == null || this.f5362E.isEmpty())) {
            j = Long.parseLong(this.f5362E);
        }
        TcashTransactionRequest tcashTransactionRequest = new TcashTransactionRequest();
        tcashTransactionRequest.setTcashPin(this.f5360C);
        tcashTransactionRequest.setMenuId("8100000");
        tcashTransactionRequest.setFee(this.f5363F);
        tcashTransactionRequest.setDestinationNo(this.f5361D);
        tcashTransactionRequest.setAmount(j);
        tcashTransactionRequest.setTcashTransactionId(this.f5364G);
        m4972a((Context) this, (int) R.string.loading);
        this.f5358A.m4700b(tcashTransactionRequest, (C1245f) this);
    }

    public void m7507r() {
        this.f5365H = null;
    }
}
