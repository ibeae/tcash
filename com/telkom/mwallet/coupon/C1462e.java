package com.telkom.mwallet.coupon;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.tcash.fragment.C1386e;

public class C1462e extends C1386e {
    private static final String f3435a = C1462e.class.getSimpleName();
    private Button f3436b;
    private String f3437c = null;
    private CouponRedeemNFCActivity f3438j;
    private OnClickListener f3439k = new C14601(this);
    private C1326f f3440l = new C14612(this);

    class C14601 implements OnClickListener {
        final /* synthetic */ C1462e f3433a;

        C14601(C1462e c1462e) {
            this.f3433a = c1462e;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.coupon_redeem_topin_button:
                    this.f3433a.f3438j.startActivityForResult(new Intent(this.f3433a.f3438j, CouponRedeemPINActivity.class), 3);
                    return;
                default:
                    return;
            }
        }
    }

    class C14612 implements C1326f {
        final /* synthetic */ C1462e f3434a;

        C14612(C1462e c1462e) {
            this.f3434a = c1462e;
        }

        public void mo1485a() {
            if (this.f3434a.f != null) {
                this.f3434a.f.dismiss();
            }
        }

        public void mo1486b() {
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_coupon_redeem_nfc, null);
        m5208c(R.string.title_couponlist);
        this.f3438j = (CouponRedeemNFCActivity) getActivity();
        String stringExtra = this.f3438j.getIntent().getStringExtra("PIN_REDEEM");
        this.f3436b = (Button) inflate.findViewById(R.id.coupon_redeem_topin_button);
        View view = (TextView) inflate.findViewById(R.id.coupon_redeem_topin_text);
        if ("N".equalsIgnoreCase(stringExtra)) {
            this.f3436b.setVisibility(8);
            view.setVisibility(8);
        } else {
            this.f3436b.setOnClickListener(this.f3439k);
        }
        this.h.m4932a(this.f3438j, (TextView) inflate.findViewById(R.id.coupon_code_text), 2);
        this.h.m4932a(this.f3438j, this.f3436b, 2);
        this.h.m4932a(this.f3438j, view, 2);
        return inflate;
    }
}
