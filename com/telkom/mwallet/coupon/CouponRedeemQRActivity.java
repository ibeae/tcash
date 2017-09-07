package com.telkom.mwallet.coupon;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import twitter4j.HttpResponseCode;

public class CouponRedeemQRActivity extends SlidingFrameActivity {
    private static final String f3267k = CouponRedeemQRActivity.class.getSimpleName();
    private FragmentManager f3268l;
    private C1467g f3269m;
    private C1326f f3270n = new C14311(this);

    class C14311 implements C1326f {
        final /* synthetic */ CouponRedeemQRActivity f3266a;

        C14311(CouponRedeemQRActivity couponRedeemQRActivity) {
            this.f3266a = couponRedeemQRActivity;
        }

        public void mo1485a() {
            if (this.f3266a.h != null) {
                this.f3266a.h.dismiss();
            }
        }

        public void mo1486b() {
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        Toast makeText = Toast.makeText(this, "Scan was Cancelled!", 1);
        makeText.setGravity(48, 25, HttpResponseCode.BAD_REQUEST);
        makeText.show();
    }

    public void onCreate(Bundle bundle) {
        this.f3269m = new C1467g();
        super.m5019a(this.f3269m);
        super.onCreate(bundle);
        this.f3268l = getSupportFragmentManager();
        if ("TCASH_PAYMENT".equals(getIntent().getStringExtra("CALL_MENU"))) {
            this.f3269m.m5552a(true);
        }
    }
}
