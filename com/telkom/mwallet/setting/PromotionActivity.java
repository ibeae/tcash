package com.telkom.mwallet.setting;

import android.os.Bundle;
import com.skcc.wallet.core.p057a.C1216a;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;

public class PromotionActivity extends SlidingFrameActivity {
    private static final String f4015k = PromotionActivity.class.getSimpleName();
    private C1631b f4016l;

    public void onBackPressed() {
        m5016B();
    }

    public void onCreate(Bundle bundle) {
        this.f4016l = new C1631b();
        super.m5019a(this.f4016l);
        super.onCreate(bundle);
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f4015k, " in onDestroy >>>>>");
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f4015k, " in onPause >>>>>");
    }
}
