package com.telkom.mwallet.cards;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1229d;
import com.skcc.wallet.framework.api.C1263m;
import com.skcc.wallet.framework.api.http.C1245f;
import com.skcc.wallet.framework.api.http.model.GetMyLoyaltyCardListRs;
import com.skcc.wallet.framework.p060b.C1301b;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.p064a.C1349c;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;

public class CardListActivity extends SlidingFrameActivity {
    public static final String f3024k = CardListActivity.class.getSimpleName();
    private String f3025A;
    private String f3026B;
    private C1326f f3027C = new C13764(this);
    private C1326f f3028D = new C13775(this);
    private C1326f f3029E = new C13786(this);
    C1245f f3030l = new C13731(this);
    C1229d f3031m = new C13742(this);
    C1263m f3032n = new C13753(this);
    private C1402f f3033o;
    private final String f3034z = "mW4II3t123";

    class C13731 implements C1245f {
        final /* synthetic */ CardListActivity f3018a;

        C13731(CardListActivity cardListActivity) {
            this.f3018a = cardListActivity;
        }

        public void mo1487a() {
            this.f3018a.m4990k();
            this.f3018a.h = this.f3018a.m4967a(this.f3018a.f3028D, (int) R.string.no_network);
        }

        public void mo1488a(String str) {
        }

        public void mo1489a(String str, int i, String str2, String str3, Object obj) {
            this.f3018a.m4990k();
            this.f3018a.h = this.f3018a.m4969a(this.f3018a.f3028D, "" + str3);
        }

        public void mo1490a(String str, Object obj) {
            this.f3018a.m4990k();
            this.f3018a.f3033o.m5270a(((GetMyLoyaltyCardListRs) obj).getLoyaltyCardList());
        }

        public void mo1491b() {
            this.f3018a.m4990k();
            this.f3018a.h = this.f3018a.m4967a(this.f3018a.f3028D, (int) R.string.no_response);
        }

        public void mo1492c() {
            this.f3018a.m4990k();
            this.f3018a.m4989j();
        }
    }

    class C13742 implements C1229d {
        final /* synthetic */ CardListActivity f3019a;

        C13742(CardListActivity cardListActivity) {
            this.f3019a = cardListActivity;
        }

        public void mo1487a() {
            this.f3019a.m4990k();
            this.f3019a.h = this.f3019a.m4967a(this.f3019a.f3028D, (int) R.string.no_network);
        }

        public void mo1508a(int i, String str) {
            this.f3019a.m4990k();
            this.f3019a.h = this.f3019a.m4969a(this.f3019a.f3028D, "" + str);
        }

        public void mo1509a(String str, String str2) {
            this.f3019a.m4990k();
            this.f3019a.e.m4537a(str, str2);
            this.f3019a.f3033o.m5271b(str2);
        }

        public void mo1491b() {
            this.f3019a.m4990k();
            this.f3019a.h = this.f3019a.m4967a(this.f3019a.f3028D, (int) R.string.no_response);
        }

        public void mo1492c() {
            this.f3019a.m4990k();
            this.f3019a.m4989j();
        }
    }

    class C13753 implements C1263m {
        final /* synthetic */ CardListActivity f3020a;

        C13753(CardListActivity cardListActivity) {
            this.f3020a = cardListActivity;
        }

        public void mo1487a() {
            this.f3020a.m4990k();
            this.f3020a.h = this.f3020a.m4967a(this.f3020a.f3029E, (int) R.string.no_network);
        }

        public void mo1510a(int i, String str) {
            this.f3020a.m4990k();
            this.f3020a.h = this.f3020a.m4969a(this.f3020a.f3029E, "" + str);
        }

        public void mo1491b() {
            this.f3020a.m4990k();
            this.f3020a.h = this.f3020a.m4967a(this.f3020a.f3029E, (int) R.string.no_response);
        }

        public void mo1492c() {
            this.f3020a.m4990k();
            this.f3020a.m4989j();
        }

        public void mo1511d() {
            this.f3020a.h = C1514b.m5649a((int) R.string.title_success, this.f3020a.getString(R.string.card_removed));
            this.f3020a.h.m5651a(this.f3020a.f3027C);
            this.f3020a.h.show(this.f3020a.getSupportFragmentManager(), "notice_dialog_tag");
        }
    }

    class C13764 implements C1326f {
        final /* synthetic */ CardListActivity f3021a;

        C13764(CardListActivity cardListActivity) {
            this.f3021a = cardListActivity;
        }

        public void mo1485a() {
            if (this.f3021a.h != null) {
                this.f3021a.mo1505o();
                this.f3021a.h.dismiss();
            }
        }

        public void mo1486b() {
        }
    }

    class C13775 implements C1326f {
        final /* synthetic */ CardListActivity f3022a;

        C13775(CardListActivity cardListActivity) {
            this.f3022a = cardListActivity;
        }

        public void mo1485a() {
            if (this.f3022a.h != null) {
                this.f3022a.h.dismiss();
            }
            this.f3022a.finish();
        }

        public void mo1486b() {
        }
    }

    class C13786 implements C1326f {
        final /* synthetic */ CardListActivity f3023a;

        C13786(CardListActivity cardListActivity) {
            this.f3023a = cardListActivity;
        }

        public void mo1485a() {
            if (this.f3023a.h != null) {
                this.f3023a.h.dismiss();
            }
        }

        public void mo1486b() {
        }
    }

    public void m5166a(String str, String str2) {
        C1301b c1301b = new C1301b();
        c1301b.m4738a("session_id", this.f3025A);
        c1301b.m4738a("credential", this.f3026B);
        c1301b.m4738a("vcard_id", str);
        c1301b.m4738a("merchant_id", str2);
        m4972a((Context) this, (int) R.string.loading);
        this.p.m4680a(c1301b, this.f3031m);
    }

    public void m5167a(String str, String str2, String str3) {
        m4972a((Context) this, (int) R.string.loading);
        this.p.m4691a(str, str2, str3, this.f3032n);
    }

    public void mo1505o() {
        m4972a((Context) this, (int) R.string.loading);
        this.p.m4707c(this.f3030l);
    }

    public void onCreate(Bundle bundle) {
        this.f3033o = new C1402f();
        super.m5019a(this.f3033o);
        super.onCreate(bundle);
        getSlidingMenu().setSlidingEnabled(false);
        this.f3025A = this.b.m4651b("msisdn", "");
        this.f3026B = C1349c.m4927d(this.f3025A, "mW4II3t123");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f3024k, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f3024k, " in onResume >>>>>");
        mo1505o();
    }
}
