package com.telkom.mwallet.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import com.telkom.mwallet.R;
import com.telkom.mwallet.coupon.C1473h;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;

public class ScanQRCodeActivity extends SlidingFrameActivity {
    private static final String f3735k = ScanQRCodeActivity.class.getSimpleName();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_coupon_redeem_qr);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.app_fragment_placeholder);
        Fragment c1473h = new C1473h();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add(R.id.app_fragment_placeholder, c1473h, f3735k);
        beginTransaction.commit();
    }
}
