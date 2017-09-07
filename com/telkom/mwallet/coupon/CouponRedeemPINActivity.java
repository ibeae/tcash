package com.telkom.mwallet.coupon;

import android.os.Bundle;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;

public class CouponRedeemPINActivity extends SlidingFrameActivity {
    private static final String f3263k = CouponRedeemPINActivity.class.getSimpleName();
    private C1465f f3264l;
    private C1326f f3265m = new C14301(this);

    class C14301 implements C1326f {
        final /* synthetic */ CouponRedeemPINActivity f3262a;

        C14301(CouponRedeemPINActivity couponRedeemPINActivity) {
            this.f3262a = couponRedeemPINActivity;
        }

        public void mo1485a() {
            if (this.f3262a.h != null) {
                this.f3262a.h.dismiss();
            }
        }

        public void mo1486b() {
        }
    }

    public void onCreate(Bundle bundle) {
        this.f3264l = new C1465f();
        super.m5019a(this.f3264l);
        super.onCreate(bundle);
    }
}
