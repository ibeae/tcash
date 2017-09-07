package com.telkom.mwallet.coupon;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.tcash.fragment.C1386e;

public class C1465f extends C1386e {
    private static final String f3443j = C1465f.class.getSimpleName();
    EditText f3444a;
    Button f3445b;
    CouponRedeemPINActivity f3446c;
    private OnClickListener f3447k = new C14631(this);
    private C1326f f3448l = new C14642(this);

    class C14631 implements OnClickListener {
        final /* synthetic */ C1465f f3441a;

        C14631(C1465f c1465f) {
            this.f3441a = c1465f;
        }

        public void onClick(View view) {
            if (this.f3441a.m5547d()) {
                Intent intent = new Intent();
                intent.putExtra("BRANCHID", this.f3441a.f3444a.getText().toString());
                this.f3441a.f3446c.setResult(-1, intent);
                this.f3441a.f3446c.finish();
                return;
            }
            this.f3441a.f = C1514b.m5647a((int) R.string.check_all_input_value);
            this.f3441a.f.m5651a(this.f3441a.f3448l);
            this.f3441a.f.show(this.f3441a.m5215l(), "notice_dialog_tag");
        }
    }

    class C14642 implements C1326f {
        final /* synthetic */ C1465f f3442a;

        C14642(C1465f c1465f) {
            this.f3442a = c1465f;
        }

        public void mo1485a() {
            if (this.f3442a.f != null) {
                this.f3442a.f.dismiss();
            }
        }

        public void mo1486b() {
        }
    }

    private void m5545e() {
        this.f3444a.setBackgroundResource(R.drawable.edittext_selector);
    }

    protected boolean m5547d() {
        m5545e();
        if (!this.f3444a.getText().toString().isEmpty()) {
            return true;
        }
        this.f3444a.requestFocus();
        this.f3444a.setBackgroundResource(R.drawable.field_sct_red);
        return false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_coupon_redeem_pin, null);
        m5208c(R.string.title_couponlist);
        this.f3446c = (CouponRedeemPINActivity) getActivity();
        this.f3444a = (EditText) inflate.findViewById(R.id.coupon_branch_id_edittext);
        this.f3445b = (Button) inflate.findViewById(R.id.coupon_redeem_pin_ok_button);
        this.f3445b.setOnClickListener(this.f3447k);
        this.h.m4932a(this.f3446c, (TextView) inflate.findViewById(R.id.coupon_redeem_pin_text), 2);
        this.h.m4932a(this.f3446c, this.f3444a, 2);
        this.h.m4932a(this.f3446c, this.f3445b, 4);
        this.f3444a.requestFocus();
        getActivity().getWindow().setSoftInputMode(4);
        return inflate;
    }
}
