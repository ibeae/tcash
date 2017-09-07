package com.telkom.mwallet.cards;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1230e;
import com.skcc.wallet.framework.api.C1264n;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.model.GetUserProfileRs;
import com.skcc.wallet.framework.api.http.model.VCard;
import com.skcc.wallet.framework.p060b.C1301b;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.p064a.C1349c;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;

public class CardAddDetailActivity extends SlidingFrameActivity {
    public static final String f2980k = CardAddDetailActivity.class.getSimpleName();
    private C1387a f2981A;
    private C1230e f2982B = new C13621(this);
    private C1264n f2983C = new C13632(this);
    private C1326f f2984D = new C13643(this);
    private C1326f f2985E = new C13654(this);
    private C1298u f2986l;
    private String f2987m = "mW4II3t123";
    private String f2988n;
    private String f2989o;
    private String f2990z;

    class C13621 implements C1230e {
        final /* synthetic */ CardAddDetailActivity f2962a;

        C13621(CardAddDetailActivity cardAddDetailActivity) {
            this.f2962a = cardAddDetailActivity;
        }

        public void mo1487a() {
            this.f2962a.m4990k();
            this.f2962a.h = this.f2962a.m4968a(this.f2962a.f2984D, (int) R.string.no_network, false);
        }

        public void mo1500a(int i, String str) {
            this.f2962a.m4990k();
            this.f2962a.h = C1514b.m5648a((int) R.string.title_failed, (int) R.string.msg_card_failed);
            this.f2962a.h.m5651a(this.f2962a.f2985E);
            this.f2962a.h.show(this.f2962a.getSupportFragmentManager(), "notice_dialog_tag");
        }

        public void mo1501a(VCard vCard) {
            this.f2962a.f2986l.m4692a(this.f2962a.f2988n, this.f2962a.f2989o, this.f2962a.f2990z, this.f2962a.f2983C);
        }

        public void mo1491b() {
            this.f2962a.m4990k();
            this.f2962a.h = this.f2962a.m4968a(this.f2962a.f2984D, (int) R.string.no_response, false);
        }

        public void mo1492c() {
            this.f2962a.m4990k();
            this.f2962a.m4989j();
        }
    }

    class C13632 implements C1264n {
        final /* synthetic */ CardAddDetailActivity f2963a;

        C13632(CardAddDetailActivity cardAddDetailActivity) {
            this.f2963a = cardAddDetailActivity;
        }

        public void mo1487a() {
            this.f2963a.m4990k();
            this.f2963a.h = this.f2963a.m4968a(this.f2963a.f2984D, (int) R.string.no_network, false);
        }

        public void mo1502a(int i, String str) {
            this.f2963a.m4990k();
            this.f2963a.h = this.f2963a.m4969a(this.f2963a.f2984D, "" + str);
        }

        public void mo1491b() {
            this.f2963a.m4990k();
            this.f2963a.h = this.f2963a.m4968a(this.f2963a.f2984D, (int) R.string.no_response, false);
        }

        public void mo1492c() {
            this.f2963a.m4990k();
            this.f2963a.m4989j();
        }

        public void mo1503d() {
            this.f2963a.m4990k();
            this.f2963a.h = C1514b.m5648a((int) R.string.title_success, (int) R.string.msg_card_added);
            this.f2963a.h.m5651a(this.f2963a.f2985E);
            this.f2963a.h.show(this.f2963a.getSupportFragmentManager(), "notice_dialog_tag");
        }
    }

    class C13643 implements C1326f {
        final /* synthetic */ CardAddDetailActivity f2964a;

        C13643(CardAddDetailActivity cardAddDetailActivity) {
            this.f2964a = cardAddDetailActivity;
        }

        public void mo1485a() {
            if (this.f2964a.h != null) {
                this.f2964a.h.dismiss();
            }
        }

        public void mo1486b() {
        }
    }

    class C13654 implements C1326f {
        final /* synthetic */ CardAddDetailActivity f2965a;

        C13654(CardAddDetailActivity cardAddDetailActivity) {
            this.f2965a = cardAddDetailActivity;
        }

        public void mo1485a() {
            if (this.f2965a.h != null) {
                this.f2965a.h.dismiss();
            }
            Intent intent = new Intent(this.f2965a, CardListActivity.class);
            intent.setFlags(67108864);
            this.f2965a.startActivity(intent);
            this.f2965a.finish();
        }

        public void mo1486b() {
        }
    }

    public void mo1487a() {
        m4990k();
        this.h = m4968a(this.f2984D, (int) R.string.no_network, false);
    }

    public void mo1488a(String str) {
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f2984D, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a("BaseActivity", "onSuccessNetwork");
        this.b.m4647a("time for update", System.currentTimeMillis());
        if ("getUserProfile".equalsIgnoreCase(str)) {
            m5057e(((GetUserProfileRs) obj).getUserInfo().getEmail());
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4968a(this.f2984D, (int) R.string.no_response, false);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    public void m5057e(String str) {
        String b = this.b.m4651b("msisdn", "");
        String d = C1349c.m4927d(b, this.f2987m);
        C1301b c1301b = new C1301b();
        c1301b.m4738a("session_Id", b);
        c1301b.m4738a("credential", d);
        c1301b.m4738a("msisdn", b);
        c1301b.m4738a("email", str);
        c1301b.m4738a("merchant_id", this.f2988n);
        this.f2986l.m4681a(c1301b, this.f2982B);
    }

    public void m5058f(String str) {
        this.f2990z = str;
    }

    void mo1505o() {
        m4972a((Context) this, (int) R.string.loading);
        this.f2986l.m4714d(this);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        this.f2981A = new C1387a();
        super.m5019a(this.f2981A);
        super.onCreate(bundle);
        this.f2986l = this.a.m4739a();
        this.f2989o = getIntent().getStringExtra("loyaltyCardProfileNo");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f2980k, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f2980k, " in onResume >>>>>");
    }
}
