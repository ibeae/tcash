package com.telkom.mwallet.coupon;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.skcc.wallet.core.p057a.C1216a;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;

public class C1459d extends DialogFragment {
    private static final String f3420a = C1459d.class.getSimpleName();
    private Context f3421b;
    private LinearLayout f3422c;
    private Button f3423d;
    private Button f3424e;
    private Button f3425f;
    private Button f3426g;
    private Button f3427h;
    private Button f3428i;
    private boolean f3429j;
    private boolean f3430k;
    private boolean f3431l;
    private OnClickListener f3432m = new C14581(this);

    class C14581 implements OnClickListener {
        final /* synthetic */ C1459d f3419a;

        C14581(C1459d c1459d) {
            this.f3419a = c1459d;
        }

        public void onClick(View view) {
            CouponDetailActivity couponDetailActivity = (CouponDetailActivity) this.f3419a.getActivity();
            switch (view.getId()) {
                case R.id.coupon_redeem_menu_nfc_button:
                    couponDetailActivity.m5352q();
                    return;
                case R.id.coupon_redeem_menu_pin_button:
                    couponDetailActivity.mo1505o();
                    return;
                case R.id.coupon_redeem_menu_qr_button:
                    couponDetailActivity.m5354s();
                    return;
                case R.id.coupon_redeem_menu_scanner_button:
                    couponDetailActivity.m5351p();
                    return;
                case R.id.coupon_redeem_menu_slide_button:
                    this.f3419a.dismiss();
                    return;
                case R.id.coupon_redeem_menu_ussd_button:
                    couponDetailActivity.m5353r();
                    return;
                default:
                    return;
            }
        }
    }

    public void m5527a(Context context) {
        this.f3421b = context;
    }

    public void m5528a(View view) {
        this.f3422c = (LinearLayout) view.findViewById(R.id.coupon_redeem_menu_button_layout);
        this.f3423d = (Button) view.findViewById(R.id.coupon_redeem_menu_slide_button);
        this.f3424e = (Button) view.findViewById(R.id.coupon_redeem_menu_pin_button);
        this.f3425f = (Button) view.findViewById(R.id.coupon_redeem_menu_qr_button);
        this.f3426g = (Button) view.findViewById(R.id.coupon_redeem_menu_nfc_button);
        this.f3427h = (Button) view.findViewById(R.id.coupon_redeem_menu_ussd_button);
        this.f3428i = (Button) view.findViewById(R.id.coupon_redeem_menu_scanner_button);
        this.f3423d.setOnClickListener(this.f3432m);
        this.f3424e.setOnClickListener(this.f3432m);
        this.f3425f.setOnClickListener(this.f3432m);
        this.f3426g.setOnClickListener(this.f3432m);
        this.f3427h.setOnClickListener(this.f3432m);
        this.f3428i.setOnClickListener(this.f3432m);
        LayoutParams layoutParams = (LayoutParams) this.f3422c.getLayoutParams();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams.width = displayMetrics.widthPixels;
        this.f3422c.setLayoutParams(layoutParams);
        this.f3424e.setEnabled(this.f3430k);
        C1216a.m4522b("nfccheck ", "nfc check " + ((CouponDetailActivity) getActivity()).f3226l.m4651b("is_nfc_yn", "N"));
        if ("N".equals(((CouponDetailActivity) getActivity()).f3226l.m4651b("is_nfc_yn", "Y"))) {
            this.f3426g.setVisibility(8);
        } else {
            this.f3426g.setEnabled(this.f3429j);
        }
        if (VERSION.SDK_INT <= 14) {
            this.f3425f.setVisibility(8);
            this.f3428i.setVisibility(8);
            return;
        }
        this.f3425f.setEnabled(this.f3431l);
    }

    public void m5529a(boolean z) {
        this.f3429j = z;
    }

    public void m5530b(boolean z) {
        this.f3430k = z;
    }

    public void m5531c(boolean z) {
        this.f3431l = z;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setGravity(81);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.dialog_animation;
        View inflate = layoutInflater.inflate(R.layout.fragment_coupon_redeem_menu, viewGroup);
        m5528a(inflate);
        C1359a c1359a = (C1359a) getActivity();
        c1359a.m4982d().m4934a(c1359a.getApplicationContext(), (ViewGroup) inflate, 2);
        c1359a.m4982d().m4932a(c1359a.getApplicationContext(), (TextView) inflate.findViewById(R.id.sub_menu_title_textview), 3);
        return inflate;
    }
}
