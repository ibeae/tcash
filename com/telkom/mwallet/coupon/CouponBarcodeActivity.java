package com.telkom.mwallet.coupon;

import android.annotation.SuppressLint;
import android.os.Bundle;
import com.skcc.wallet.framework.api.C1272r;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;

@SuppressLint({"ParserError", "ParserError"})
public class CouponBarcodeActivity extends SlidingFrameActivity {
    private static final String f3189k = CouponBarcodeActivity.class.getSimpleName();
    private C1272r f3190l;
    private C1440a f3191m;

    public void onCreate(Bundle bundle) {
        this.f3191m = new C1440a();
        super.m5019a(this.f3191m);
        super.onCreate(bundle);
        this.f3190l = this.a.m4745e();
        String stringExtra = getIntent().getStringExtra("COUPON_SERIAL");
        this.f3191m.m5449a(getIntent().getStringExtra("coupon_codetype"), stringExtra + this.f3190l.m4651b("msisdn", ""));
    }
}
