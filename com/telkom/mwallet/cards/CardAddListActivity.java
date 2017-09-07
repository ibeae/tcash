package com.telkom.mwallet.cards;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1230e;
import com.skcc.wallet.framework.api.C1231f;
import com.skcc.wallet.framework.api.C1264n;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.model.GetUserProfileRs;
import com.skcc.wallet.framework.api.http.model.LoyaltyCard;
import com.skcc.wallet.framework.api.http.model.VCard;
import com.skcc.wallet.framework.p060b.C1301b;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.p064a.C1349c;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import java.util.ArrayList;
import java.util.List;

public class CardAddListActivity extends SlidingFrameActivity {
    public static final String f2996k = CardAddListActivity.class.getSimpleName();
    private String f2997A;
    private C1230e f2998B = new C13672(this);
    private C1264n f2999C = new C13683(this);
    private C1326f f3000D = new C13694(this);
    private C1326f f3001E = new C13705(this);
    private C1298u f3002l;
    private C1392b f3003m;
    private String f3004n = "mW4II3t123";
    private String f3005o;
    private String f3006z;

    class C13661 implements C1231f {
        final /* synthetic */ CardAddListActivity f2991a;

        C13661(CardAddListActivity cardAddListActivity) {
            this.f2991a = cardAddListActivity;
        }

        public void mo1487a() {
            this.f2991a.m4990k();
            this.f2991a.h = this.f2991a.m4968a(this.f2991a.f3001E, (int) R.string.no_network, false);
        }

        public void mo1506a(int i, String str) {
            this.f2991a.m4990k();
            this.f2991a.h = this.f2991a.m4970a(this.f2991a.f3001E, "" + str, false);
        }

        public void mo1507a(List<LoyaltyCard> list) {
            List arrayList;
            this.f2991a.m4990k();
            if (list == null) {
                arrayList = new ArrayList();
            }
            this.f2991a.f3003m.m5244a(arrayList);
        }

        public void mo1491b() {
            this.f2991a.m4990k();
            this.f2991a.h = this.f2991a.m4968a(this.f2991a.f3001E, (int) R.string.no_response, false);
        }

        public void mo1492c() {
            this.f2991a.m4990k();
            this.f2991a.m4989j();
        }
    }

    class C13672 implements C1230e {
        final /* synthetic */ CardAddListActivity f2992a;

        C13672(CardAddListActivity cardAddListActivity) {
            this.f2992a = cardAddListActivity;
        }

        public void mo1487a() {
            this.f2992a.m4990k();
            this.f2992a.h = this.f2992a.m4968a(this.f2992a.f3001E, (int) R.string.no_network, false);
        }

        public void mo1500a(int i, String str) {
            this.f2992a.m4990k();
            this.f2992a.h = this.f2992a.m4969a(this.f2992a.f3001E, "" + str);
        }

        public void mo1501a(VCard vCard) {
            this.f2992a.f2997A = vCard.getCardId();
            this.f2992a.f3002l.m4692a(this.f2992a.f3005o, this.f2992a.f3006z, this.f2992a.f2997A, this.f2992a.f2999C);
        }

        public void mo1491b() {
            this.f2992a.m4990k();
            this.f2992a.h = this.f2992a.m4968a(this.f2992a.f3001E, (int) R.string.no_response, false);
        }

        public void mo1492c() {
            this.f2992a.m4990k();
            this.f2992a.m4989j();
        }
    }

    class C13683 implements C1264n {
        final /* synthetic */ CardAddListActivity f2993a;

        C13683(CardAddListActivity cardAddListActivity) {
            this.f2993a = cardAddListActivity;
        }

        public void mo1487a() {
            this.f2993a.m4990k();
            this.f2993a.h = this.f2993a.m4968a(this.f2993a.f3001E, (int) R.string.no_network, false);
        }

        public void mo1502a(int i, String str) {
            this.f2993a.m4990k();
            this.f2993a.h = this.f2993a.m4969a(this.f2993a.f3001E, "" + str);
        }

        public void mo1491b() {
            this.f2993a.m4990k();
            this.f2993a.h = this.f2993a.m4968a(this.f2993a.f3001E, (int) R.string.no_response, false);
        }

        public void mo1492c() {
            this.f2993a.m4990k();
            this.f2993a.m4989j();
        }

        public void mo1503d() {
            this.f2993a.m4990k();
            this.f2993a.h = C1514b.m5648a((int) R.string.title_success, (int) R.string.msg_card_added);
            this.f2993a.h.m5651a(this.f2993a.f3000D);
            this.f2993a.h.show(this.f2993a.getSupportFragmentManager(), "notice_dialog_tag");
        }
    }

    class C13694 implements C1326f {
        final /* synthetic */ CardAddListActivity f2994a;

        C13694(CardAddListActivity cardAddListActivity) {
            this.f2994a = cardAddListActivity;
        }

        public void mo1485a() {
            if (this.f2994a.h != null) {
                this.f2994a.h.dismiss();
            }
            this.f2994a.finish();
        }

        public void mo1486b() {
        }
    }

    class C13705 implements C1326f {
        final /* synthetic */ CardAddListActivity f2995a;

        C13705(CardAddListActivity cardAddListActivity) {
            this.f2995a = cardAddListActivity;
        }

        public void mo1485a() {
            if (this.f2995a.h != null) {
                this.f2995a.h.dismiss();
            }
            this.f2995a.finish();
        }

        public void mo1486b() {
        }
    }

    private void m5104p() {
        m4972a((Context) this, (int) R.string.loading);
        this.f3002l.m4671a(new C13661(this));
    }

    public void mo1487a() {
        m4990k();
        this.h = m4968a(this.f3001E, (int) R.string.no_network, false);
    }

    public void mo1488a(String str) {
        m4972a((Context) this, (int) R.string.loading);
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f3001E, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("getUserProfile".equalsIgnoreCase(str)) {
            m5113g(((GetUserProfileRs) obj).getUserInfo().getEmail());
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4968a(this.f3001E, (int) R.string.no_response, false);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    public void m5111e(String str) {
        this.f3005o = str;
    }

    public void m5112f(String str) {
        this.f3006z = str;
    }

    public void m5113g(String str) {
        String b = this.b.m4651b("msisdn", "");
        String d = C1349c.m4927d(b, this.f3004n);
        C1301b c1301b = new C1301b();
        c1301b.m4738a("session_Id", b);
        c1301b.m4738a("credential", d);
        c1301b.m4738a("msisdn", b);
        c1301b.m4738a("email", str);
        c1301b.m4738a("merchant_id", this.f3005o);
        this.f3002l.m4681a(c1301b, this.f2998B);
    }

    void mo1505o() {
        m4972a((Context) this, (int) R.string.loading);
        this.f3002l.m4714d(this);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        this.f3003m = new C1392b();
        super.m5019a(this.f3003m);
        super.onCreate(bundle);
        this.f3002l = this.a.m4739a();
        m5104p();
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f2996k, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f2996k, " in onResume >>>>>");
    }
}
