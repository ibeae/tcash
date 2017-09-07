package com.telkom.mwallet.cards;

import android.content.Context;
import android.os.Bundle;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1232g;
import com.skcc.wallet.framework.api.http.model.VCardTransaction;
import com.skcc.wallet.framework.p060b.C1301b;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.p064a.C1349c;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import java.util.List;

public class CardTransactionHistoryActivity extends SlidingFrameActivity {
    public static final String f3045k = CardTransactionHistoryActivity.class.getSimpleName();
    private String f3046A;
    private C1413k f3047B;
    private C1326f f3048C = new C13822(this);
    C1232g f3049l = new C13811(this);
    private final String f3050m = "mW4II3t123";
    private String f3051n;
    private String f3052o;
    private String f3053z;

    class C13811 implements C1232g {
        final /* synthetic */ CardTransactionHistoryActivity f3043a;

        C13811(CardTransactionHistoryActivity cardTransactionHistoryActivity) {
            this.f3043a = cardTransactionHistoryActivity;
        }

        public void mo1487a() {
            this.f3043a.m4990k();
            this.f3043a.h = this.f3043a.m4967a(this.f3043a.f3048C, (int) R.string.no_network);
        }

        public void mo1514a(int i, String str) {
            this.f3043a.m4990k();
            this.f3043a.h = this.f3043a.m4969a(this.f3043a.f3048C, "" + str);
        }

        public void mo1515a(List<VCardTransaction> list) {
            this.f3043a.m4990k();
            C1216a.m4522b("transactions", list.size() + "");
            this.f3043a.f3047B.m5302a((List) list);
        }

        public void mo1491b() {
            this.f3043a.m4990k();
            this.f3043a.h = this.f3043a.m4967a(this.f3043a.f3048C, (int) R.string.no_response);
        }

        public void mo1492c() {
            this.f3043a.m4990k();
            this.f3043a.m4989j();
        }
    }

    class C13822 implements C1326f {
        final /* synthetic */ CardTransactionHistoryActivity f3044a;

        C13822(CardTransactionHistoryActivity cardTransactionHistoryActivity) {
            this.f3044a = cardTransactionHistoryActivity;
        }

        public void mo1485a() {
            if (this.f3044a.h != null) {
                this.f3044a.h.dismiss();
            }
            this.f3044a.finish();
        }

        public void mo1486b() {
        }
    }

    public void mo1505o() {
        C1301b c1301b = new C1301b();
        c1301b.m4738a("session_id", this.f3051n);
        c1301b.m4738a("credential", this.f3052o);
        c1301b.m4738a("merchant_id", this.f3053z);
        c1301b.m4738a("vcard_id", this.f3046A);
        m4972a((Context) this, (int) R.string.loading);
        this.p.m4682a(c1301b, this.f3049l);
    }

    public void onCreate(Bundle bundle) {
        this.f3047B = new C1413k();
        super.m5019a(this.f3047B);
        super.onCreate(bundle);
        this.f3051n = this.b.m4651b("msisdn", "");
        this.f3052o = C1349c.m4927d(this.f3051n, "mW4II3t123");
        this.f3053z = getIntent().getStringExtra("merchant_id");
        this.f3046A = getIntent().getStringExtra("card_id");
        this.f3047B.m5303b(this.f3046A);
        this.f3047B.m5304c(getIntent().getStringExtra("card_image_url"));
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f3045k, " in onDestroy >>>>>");
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f3045k, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f3045k, " in onResume >>>>>");
    }
}
