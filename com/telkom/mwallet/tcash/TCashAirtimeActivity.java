package com.telkom.mwallet.tcash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.http.C1245f;
import com.skcc.wallet.framework.api.http.model.DataPackage;
import com.skcc.wallet.framework.api.http.model.Denomination;
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
import com.telkom.mwallet.tcash.fragment.C1784a;
import com.telkom.mwallet.tcash.fragment.C1785b;
import com.telkom.mwallet.tcash.fragment.C1787c;
import java.util.Calendar;

public class TCashAirtimeActivity extends SlidingFrameActivity {
    private static final String f4383n = TCashAirtimeActivity.class.getSimpleName();
    private C1785b f4384A;
    private Calendar f4385B;
    private C1539j f4386C;
    private String f4387D;
    private String f4388E;
    private String f4389F;
    private String f4390G;
    private String f4391H;
    private Denomination f4392I;
    private DataPackage f4393J;
    private TcashFavorite f4394K;
    private C1326f f4395L = new C17311(this);
    private C1326f f4396M = new C17322(this);
    TcashFavorite f4397k = null;
    int f4398l;
    C1500i f4399m = new C17333(this);
    private C1784a f4400o;
    private C1787c f4401z;

    class C17311 implements C1326f {
        final /* synthetic */ TCashAirtimeActivity f4380a;

        C17311(TCashAirtimeActivity tCashAirtimeActivity) {
            this.f4380a = tCashAirtimeActivity;
        }

        public void mo1485a() {
            if (this.f4380a.h != null) {
                this.f4380a.h.dismiss();
            }
            if (this.f4380a.f4397k != null) {
                this.f4380a.f4386C.show(this.f4380a.getSupportFragmentManager(), "reminder_dialog_tag");
            } else {
                this.f4380a.finish();
            }
        }

        public void mo1486b() {
            if (this.f4380a.h != null) {
                this.f4380a.h.dismiss();
            }
        }
    }

    class C17322 implements C1326f {
        final /* synthetic */ TCashAirtimeActivity f4381a;

        C17322(TCashAirtimeActivity tCashAirtimeActivity) {
            this.f4381a = tCashAirtimeActivity;
        }

        public void mo1485a() {
            if (this.f4381a.h != null) {
                this.f4381a.h.dismiss();
            }
            this.f4381a.finish();
        }

        public void mo1486b() {
            if (this.f4381a.h != null) {
                this.f4381a.h.dismiss();
            }
        }
    }

    class C17333 implements C1500i {
        final /* synthetic */ TCashAirtimeActivity f4382a;

        C17333(TCashAirtimeActivity tCashAirtimeActivity) {
            this.f4382a = tCashAirtimeActivity;
        }

        public void mo1546a() {
            if (this.f4382a.f4386C != null) {
                this.f4382a.f4386C.dismiss();
            }
            if (this.f4382a.f4392I != null) {
                this.f4382a.f4397k.setAmount(this.f4382a.f4392I.getAmount());
            } else if (this.f4382a.f4393J != null) {
                this.f4382a.f4397k.setAmount(this.f4382a.f4393J.getDataCapacity());
            }
            this.f4382a.f4397k.setDestinationNo(this.f4382a.f4390G);
            this.f4382a.f4397k.setMenuId(this.f4382a.m6545s());
            this.f4382a.f4397k.setPeriod("");
            this.f4382a.f4397k.setStartDate("");
            this.f4382a.m6530a(this.f4382a.f4397k);
        }

        public void mo1547a(int i) {
            this.f4382a.f4398l = i;
            this.f4382a.f4386C.dismiss();
            String a = C1354g.m4943a(i);
            if (this.f4382a.f4392I != null) {
                this.f4382a.f4397k.setAmount(this.f4382a.f4392I.getAmount());
            } else if (this.f4382a.f4393J != null) {
                this.f4382a.f4397k.setAmount(this.f4382a.f4393J.getDataCapacity());
            }
            this.f4382a.f4397k.setDestinationNo(this.f4382a.f4390G);
            this.f4382a.f4397k.setMenuId(this.f4382a.m6545s());
            this.f4382a.f4397k.setPeriod(C1358h.f2930a);
            this.f4382a.f4397k.setStartDate(a);
            C1216a.m4522b("myfavorite", "favorite day " + i);
            C1216a.m4522b("myfavorite", "favorite startdate " + a);
            C1216a.m4522b("airtime favorite", "favorite" + this.f4382a.f4397k.getFavoriteMenuName());
            this.f4382a.m6530a(this.f4382a.f4397k);
        }
    }

    private String m6529a(TcashTransaction tcashTransaction) {
        String str = "";
        if (this.f4393J != null) {
            return m5018a((int) R.string.tcash_success_buy_data_mobile_package_amount_date, tcashTransaction.getDestinationNo(), this.f4393J.getPackageName(), C1354g.m4955f(tcashTransaction.getAmount()), C1354g.m4946a("dd,MM,yyyy", tcashTransaction.getTransactionDate()));
        }
        return m5018a((int) R.string.tcash_success_buy_airtime_mobile_amount_date, tcashTransaction.getDestinationNo(), C1354g.m4955f(tcashTransaction.getAmount()), C1354g.m4946a("dd,MM,yyyy", tcashTransaction.getTransactionDate()));
    }

    private void m6530a(TcashFavorite tcashFavorite) {
        this.p.m4699b(tcashFavorite, (C1245f) this);
    }

    private void m6544r() {
        this.f4394K = (TcashFavorite) getIntent().getSerializableExtra("Favorite");
        if (this.f4394K != null && this.f4394K.getDestinationNo() != null) {
            String destinationNo = this.f4394K.getDestinationNo();
            if (!destinationNo.isEmpty() && destinationNo.length() > 3 && !this.b.m4651b("msisdn", "").equals(destinationNo)) {
                this.f4400o.m6851b(destinationNo);
            }
        }
    }

    private String m6545s() {
        return this.f4392I != null ? this.f4392I.getDenomId() : this.f4393J != null ? "3100" + this.f4393J.getPackageId() : "3100XXX";
    }

    public void mo1487a() {
        m4990k();
        this.h = m4968a(this.f4396M, (int) R.string.no_network, false);
    }

    public void m6547a(DataPackage dataPackage) {
        this.f4393J = dataPackage;
    }

    public void m6548a(Denomination denomination) {
        this.f4392I = denomination;
    }

    public void mo1488a(String str) {
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f4396M, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f4383n, "onSuccessNetwork");
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("getTcashBalance".equalsIgnoreCase(str)) {
            this.f4384A.m6854b(String.valueOf(((GetTcashBalanceRs) obj).getTcashBalance()));
        } else if ("getServiceDetail".equalsIgnoreCase(str)) {
            GetServiceDetailRs getServiceDetailRs = (GetServiceDetailRs) obj;
            this.f4400o.m6850a(getServiceDetailRs.getMenu().getDenominations());
            this.f4400o.m6852b(getServiceDetailRs.getMenu().getDataPackages());
            if (this.f4391H != null) {
                String substring = this.f4391H.substring(4);
                try {
                    for (Denomination denomination : getServiceDetailRs.getMenu().getDenominations()) {
                        if (denomination.getDenomId().equals(substring)) {
                            this.f4400o.m6849a(denomination);
                            break;
                        }
                    }
                    for (DataPackage dataPackage : getServiceDetailRs.getMenu().getDataPackages()) {
                        if (dataPackage.getPackageId().equals(substring)) {
                            this.f4400o.m6848a(dataPackage);
                            break;
                        }
                    }
                } catch (NumberFormatException e) {
                }
            } else {
                this.f4392I = null;
                this.f4393J = null;
            }
            m6544r();
        } else if ("getPurchaseInfo".equalsIgnoreCase(str)) {
            GetPurchaseInfoRs getPurchaseInfoRs = (GetPurchaseInfoRs) obj;
            if (getPurchaseInfoRs.getTcashTransaction() != null) {
                this.f4388E = getPurchaseInfoRs.getTcashTransaction().getTransactionId();
                this.f4389F = getPurchaseInfoRs.getTcashTransaction().getFee();
            }
            m6559p();
        } else if ("purchaseWithTcash".equalsIgnoreCase(str)) {
            this.h = C1514b.m5649a((int) R.string.title_success, m6529a(((PurchaseWithTcashRs) obj).getTcashTransaction()));
            this.h.m5651a(this.f4395L);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        } else if ("setTcashFavoriteTransaction".equalsIgnoreCase(str)) {
            this.f4397k = null;
            this.h = C1514b.m5648a((int) R.string.title_success, (int) R.string.msg_setfavorite_success);
            this.h.m5651a(this.f4395L);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4968a(this.f4396M, (int) R.string.no_response, false);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    public void m6554e(String str) {
        TcashTransactionRequest tcashTransactionRequest = new TcashTransactionRequest();
        tcashTransactionRequest.setTcashPin(str);
        tcashTransactionRequest.setMenuId(m6545s());
        tcashTransactionRequest.setDestinationNo(this.f4390G);
        if (this.f4392I != null) {
            tcashTransactionRequest.setAmount(this.f4392I.getAmount());
        } else if (this.f4393J != null) {
            tcashTransactionRequest.setAmount(this.f4393J.getDataCapacity());
        }
        tcashTransactionRequest.setTcashTransactionId(this.f4388E);
        m4972a((Context) this, (int) R.string.loading);
        this.p.m4700b(tcashTransactionRequest, (C1245f) this);
    }

    public void m6555f(String str) {
        this.f4387D = str;
    }

    public void m6556g(String str) {
        this.f4390G = str;
    }

    public void m6557j(String str) {
        this.f4397k = new TcashFavorite();
        this.f4397k.setFavoriteMenuName(str);
    }

    public void mo1505o() {
        TcashTransactionRequest tcashTransactionRequest = new TcashTransactionRequest();
        tcashTransactionRequest.setMenuId(m6545s());
        tcashTransactionRequest.setDestinationNo(this.f4390G);
        if (this.f4392I != null) {
            tcashTransactionRequest.setAmount(this.f4392I.getAmount());
        } else if (this.f4393J != null) {
            tcashTransactionRequest.setAmount(this.f4393J.getDataCapacity());
        }
        m4972a((Context) this, (int) R.string.loading);
        this.p.m4675a(tcashTransactionRequest, (C1245f) this);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        this.f4384A = new C1785b();
        super.m5019a(this.f4384A);
        super.onCreate(bundle);
        this.f4385B = Calendar.getInstance();
        this.f4386C = C1539j.m5688a(this.f4385B.get(5));
        this.f4386C.m5690a(this.f4399m);
        this.f4391H = getIntent().getStringExtra("TCASH_MENU_ID");
        this.f4400o = new C1784a();
        this.f4400o.m6853c(this.b.m4651b("msisdn", ""));
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add(R.id.tcash_airtime_fragment, this.f4400o, f4383n);
        beginTransaction.commit();
        m4972a((Context) this, (int) R.string.loading);
        this.p.m4726g(m6545s(), this);
        this.p.m4729i(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f4386C != null && this.f4386C.isVisible()) {
            this.f4386C.dismiss();
        }
        C1216a.m4519a(f4383n, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f4383n, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f4383n, " in onResume >>>>>");
    }

    public void m6559p() {
        this.f4401z = new C1787c();
        this.f4401z.m6860b(this.f4387D);
        this.f4401z.m6861c(this.f4390G);
        this.f4401z.m6859a(this.f4392I);
        this.f4401z.m6858a(this.f4393J);
        this.f4401z.m6862f(this.f4389F);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.tcash_airtime_fragment, this.f4401z, f4383n);
        beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        beginTransaction.commit();
    }

    public void m6560q() {
        this.f4397k = null;
    }
}
