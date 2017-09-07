package com.telkom.mwallet.tcash.cash;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.C1245f;
import com.skcc.wallet.framework.api.http.model.GetTcashBalanceRs;
import com.skcc.wallet.framework.api.http.model.SmsBank;
import com.skcc.wallet.framework.api.http.model.TcashFavorite;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.C1539j;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.dialog.p063a.C1500i;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.p064a.C1358h;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import com.telkom.mwallet.tcash.TCashActivity;
import com.telkom.mwallet.tcash.cash.p068a.C1767e;
import com.telkom.mwallet.tcash.cash.p068a.C1768f;
import com.telkom.mwallet.tcash.cash.p068a.C1770g;

public class TCashInSMSBankingActivity extends SlidingFrameActivity {
    private static final String f4489n = TCashInSMSBankingActivity.class.getSimpleName();
    private C1770g f4490A;
    private C1539j f4491B;
    private String f4492C;
    private String f4493D;
    private String f4494E;
    private SmsBank f4495F;
    private PendingIntent f4496G;
    private PendingIntent f4497H;
    private C1768f f4498I;
    private boolean f4499J = false;
    private String f4500K = null;
    private BroadcastReceiver f4501L = new C17491(this);
    private BroadcastReceiver f4502M = new C17502(this);
    private C1326f f4503N = new C17513(this);
    private C1326f f4504O = new C17524(this);
    TcashFavorite f4505k = null;
    int f4506l;
    C1500i f4507m = new C17535(this);
    private C1298u f4508o;
    private C1767e f4509z;

    class C17491 extends BroadcastReceiver {
        final /* synthetic */ TCashInSMSBankingActivity f4484a;

        C17491(TCashInSMSBankingActivity tCashInSMSBankingActivity) {
            this.f4484a = tCashInSMSBankingActivity;
        }

        public void onReceive(Context context, Intent intent) {
            switch (getResultCode()) {
                case -1:
                    Toast.makeText(this.f4484a.getBaseContext(), "SMS sent", 0).show();
                    return;
                case 1:
                    Toast.makeText(this.f4484a.getBaseContext(), "Generic failure", 0).show();
                    return;
                case 2:
                    Toast.makeText(this.f4484a.getBaseContext(), "Radio off", 0).show();
                    return;
                case 3:
                    Toast.makeText(this.f4484a.getBaseContext(), "Null PDU", 0).show();
                    return;
                case 4:
                    Toast.makeText(this.f4484a.getBaseContext(), "No service", 0).show();
                    return;
                default:
                    return;
            }
        }
    }

    class C17502 extends BroadcastReceiver {
        final /* synthetic */ TCashInSMSBankingActivity f4485a;

        C17502(TCashInSMSBankingActivity tCashInSMSBankingActivity) {
            this.f4485a = tCashInSMSBankingActivity;
        }

        public void onReceive(Context context, Intent intent) {
            switch (getResultCode()) {
                case -1:
                    Toast.makeText(this.f4485a.getBaseContext(), "SMS delivered", 0).show();
                    return;
                case 0:
                    Toast.makeText(this.f4485a.getBaseContext(), "SMS not delivered", 0).show();
                    return;
                default:
                    return;
            }
        }
    }

    class C17513 implements C1326f {
        final /* synthetic */ TCashInSMSBankingActivity f4486a;

        C17513(TCashInSMSBankingActivity tCashInSMSBankingActivity) {
            this.f4486a = tCashInSMSBankingActivity;
        }

        public void mo1485a() {
            if (this.f4486a.h != null) {
                this.f4486a.h.dismiss();
            }
            if (this.f4486a.f4505k != null) {
                this.f4486a.f4491B.show(this.f4486a.getSupportFragmentManager(), "reminder_dialog_tag");
            } else if (this.f4486a.f4499J) {
                this.f4486a.m5016B();
            } else {
                Intent intent = new Intent(this.f4486a, TCashActivity.class);
                intent.setFlags(67108864);
                this.f4486a.startActivity(intent);
                this.f4486a.finish();
            }
        }

        public void mo1486b() {
            if (this.f4486a.h != null) {
                this.f4486a.h.dismiss();
            }
        }
    }

    class C17524 implements C1326f {
        final /* synthetic */ TCashInSMSBankingActivity f4487a;

        C17524(TCashInSMSBankingActivity tCashInSMSBankingActivity) {
            this.f4487a = tCashInSMSBankingActivity;
        }

        public void mo1485a() {
            if (this.f4487a.h != null) {
                this.f4487a.h.dismiss();
            }
            this.f4487a.finish();
        }

        public void mo1486b() {
            if (this.f4487a.h != null) {
                this.f4487a.h.dismiss();
            }
        }
    }

    class C17535 implements C1500i {
        final /* synthetic */ TCashInSMSBankingActivity f4488a;

        C17535(TCashInSMSBankingActivity tCashInSMSBankingActivity) {
            this.f4488a = tCashInSMSBankingActivity;
        }

        public void mo1546a() {
            if (this.f4488a.f4491B != null) {
                this.f4488a.f4491B.dismiss();
            }
            long j = 0;
            if (this.f4488a.f4493D != null) {
                j = Long.parseLong(this.f4488a.f4493D);
            }
            this.f4488a.f4505k.setAmount(j);
            this.f4488a.f4505k.setDestinationNo(this.f4488a.f4492C);
            this.f4488a.f4505k.setMenuId(this.f4488a.f4494E);
            this.f4488a.f4505k.setPeriod("");
            this.f4488a.f4505k.setStartDate("");
            this.f4488a.m6694a(this.f4488a.f4505k);
        }

        public void mo1547a(int i) {
            this.f4488a.f4506l = i;
            this.f4488a.f4491B.dismiss();
            String a = C1354g.m4943a(i);
            this.f4488a.f4505k.setAmount(Long.parseLong(this.f4488a.f4493D));
            this.f4488a.f4505k.setDestinationNo(this.f4488a.f4492C);
            this.f4488a.f4505k.setMenuId(this.f4488a.f4494E);
            this.f4488a.f4505k.setPeriod(C1358h.f2930a);
            this.f4488a.f4505k.setStartDate(a);
            this.f4488a.m6694a(this.f4488a.f4505k);
        }
    }

    private void m6694a(TcashFavorite tcashFavorite) {
        this.f4508o.m4699b(tcashFavorite, (C1245f) this);
    }

    private void m6709r() {
        this.f4491B = C1539j.m5687a();
        this.f4491B.m5690a(this.f4507m);
        this.f4508o.m4729i(this);
        m6710s();
    }

    private void m6710s() {
        TcashFavorite tcashFavorite = (TcashFavorite) getIntent().getSerializableExtra("Favorite");
        if (tcashFavorite != null && tcashFavorite.getDestinationNo() != null) {
            String destinationNo = tcashFavorite.getDestinationNo();
            if (!destinationNo.isEmpty()) {
                this.f4509z.m6789b(destinationNo);
            }
        }
    }

    private void m6711t() {
        String str = "SMS_SENT";
        String str2 = "SMS_DELIVERED";
        this.f4496G = PendingIntent.getBroadcast(this, 0, new Intent(str), 0);
        this.f4497H = PendingIntent.getBroadcast(this, 0, new Intent(str2), 0);
        registerReceiver(this.f4501L, new IntentFilter(str));
        registerReceiver(this.f4502M, new IntentFilter(str2));
    }

    public void mo1487a() {
        m4990k();
        this.h = m4968a(this.f4504O, (int) R.string.no_network, false);
    }

    public void mo1488a(String str) {
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f4504O, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f4489n, "onSuccessNetwork");
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("getTcashBalance".equalsIgnoreCase(str)) {
            this.f4498I.m6792b(String.valueOf(((GetTcashBalanceRs) obj).getTcashBalance()));
        } else if ("topupSmsBank".equalsIgnoreCase(str)) {
            this.h = C1514b.m5648a((int) R.string.title_success, (int) R.string.notice_msg_sms_banking_check);
            this.h.m5651a(this.f4503N);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        } else if ("setTcashFavoriteTransaction".equalsIgnoreCase(str)) {
            this.f4505k = null;
            this.h = C1514b.m5648a((int) R.string.title_success, (int) R.string.msg_setfavorite_success);
            this.h.m5651a(this.f4503N);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4968a(this.f4504O, (int) R.string.no_response, false);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    public void m6718e(String str) {
        this.f4505k = new TcashFavorite();
        this.f4505k.setFavoriteMenuName(str);
    }

    public void m6719f(String str) {
        this.f4492C = str;
    }

    public void m6720g(String str) {
        this.f4493D = str;
    }

    public void m6721j(String str) {
        this.f4500K = str;
    }

    public void mo1505o() {
        this.f4490A = new C1770g();
        this.f4490A.m6796c(this.f4492C);
        this.f4490A.m6797f(this.f4493D);
        if (this.f4500K != null) {
            this.f4490A.m6795b(this.f4500K);
        }
        this.f4495F = new SmsBank();
        this.f4495F.setDestinationNo(this.f4492C);
        this.f4495F.setAmount(this.f4493D);
        if ("5131000".equals(this.f4494E)) {
            this.f4495F.setBankCode("bni");
        } else if ("5133000".equals(this.f4494E)) {
            this.f4495F.setBankCode("mega");
        } else if ("5132000".equals(this.f4494E)) {
            this.f4495F.setBankCode("mandiri");
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.tcash_cash_in_sms_banking_fragment, this.f4490A, f4489n);
        beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        beginTransaction.commit();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        this.f4498I = new C1768f();
        super.m5019a(this.f4498I);
        super.onCreate(bundle);
        this.f4494E = getIntent().getStringExtra("TCASH_MENU_ID");
        TcashFavorite tcashFavorite = (TcashFavorite) getIntent().getSerializableExtra("Favorite");
        this.f4508o = this.a.m4739a();
        this.f4509z = new C1767e();
        this.f4509z.m6790c(this.b.m4651b("msisdn", ""));
        if (tcashFavorite != null) {
            this.f4493D = "" + tcashFavorite.getAmount();
            this.f4509z.m6791f(this.f4493D);
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add(R.id.tcash_cash_in_sms_banking_fragment, this.f4509z, f4489n);
        beginTransaction.commit();
        if (C1358h.f2943n.equals(getIntent().getStringExtra(C1358h.f2940k))) {
            this.f4499J = true;
        }
        m6709r();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f4491B != null && this.f4491B.isVisible()) {
            this.f4491B.dismiss();
        }
        unregisterReceiver(this.f4501L);
        unregisterReceiver(this.f4502M);
        C1216a.m4519a(f4489n, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f4489n, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        m6711t();
        C1216a.m4519a(f4489n, " in onResume >>>>>");
    }

    public void m6723p() {
        m4972a((Context) this, (int) R.string.loading);
        this.f4508o.m4673a(this.f4495F, (C1245f) this);
    }

    public void m6724q() {
        this.f4505k = null;
    }
}
