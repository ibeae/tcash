package com.telkom.mwallet.tcash.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.telkom.mwallet.R;
import com.telkom.mwallet.p064a.C1358h;
import com.telkom.mwallet.tcash.TCashActivity;
import com.telkom.mwallet.tcash.payment.TCashFixedLineActivity;
import com.telkom.mwallet.tcash.payment.TCashKartuHaloActivity;
import com.telkom.mwallet.tcash.payment.TCashOthersActivity;
import com.telkom.mwallet.tcash.payment.TCashPDAMActivity;
import com.telkom.mwallet.tcash.payment.TCashPLNActivity;
import com.telkom.mwallet.tcash.purchase.TCashMerchantActivty;

public class C1797h extends C1761d {
    private static final String f4704a = C1797h.class.getSimpleName();
    private Context f4705b;
    private LinearLayout f4706c;
    private Button f4707d;
    private Button f4708e;
    private Button f4709f;
    private Button f4710g;
    private Button f4711h;
    private Button f4712i;
    private Button f4713j;
    private Button f4714k;
    private Button f4715l;
    private Button f4716m;
    private Button f4717n;
    private Button f4718o;
    private Button f4719p;
    private boolean f4720q = false;
    private boolean f4721r = false;
    private TCashActivity f4722s;
    private OnClickListener f4723t = new C17961(this);

    class C17961 implements OnClickListener {
        final /* synthetic */ C1797h f4703a;

        C17961(C1797h c1797h) {
            this.f4703a = c1797h;
        }

        public void onClick(View view) {
            Intent intent = new Intent();
            switch (view.getId()) {
                case R.id.tcash_payment_Internet_button:
                    this.f4703a.f4722s.m6516e(this.f4703a.f4711h.getText().toString());
                    this.f4703a.f4722s.m6518g("1400");
                    this.f4703a.dismiss();
                    return;
                case R.id.tcash_payment_cabletv_button:
                    this.f4703a.f4722s.m6516e(this.f4703a.f4710g.getText().toString());
                    this.f4703a.f4722s.m6518g("1300");
                    this.f4703a.dismiss();
                    return;
                case R.id.tcash_payment_fixedline_button:
                    intent.setClass(this.f4703a.f4705b, TCashFixedLineActivity.class);
                    if (this.f4703a.f4720q) {
                        intent.putExtra(C1358h.f2940k, C1358h.f2943n);
                    }
                    this.f4703a.startActivity(intent);
                    return;
                case R.id.tcash_payment_kartu_halo_button:
                    intent.setClass(this.f4703a.f4705b, TCashKartuHaloActivity.class);
                    if (this.f4703a.f4720q) {
                        intent.putExtra(C1358h.f2940k, C1358h.f2943n);
                    }
                    this.f4703a.startActivity(intent);
                    this.f4703a.getActivity().overridePendingTransition(0, 0);
                    return;
                case R.id.tcash_payment_menu_slide_button:
                    this.f4703a.onCancel(this.f4703a.getDialog());
                    return;
                case R.id.tcash_payment_multifinance_button:
                    this.f4703a.f4722s.m6516e(this.f4703a.f4714k.getText().toString());
                    this.f4703a.f4722s.m6518g("3510");
                    this.f4703a.dismiss();
                    return;
                case R.id.tcash_payment_others_button:
                    intent.setClass(this.f4703a.f4705b, TCashOthersActivity.class);
                    if (this.f4703a.f4720q) {
                        intent.putExtra(C1358h.f2940k, C1358h.f2943n);
                    }
                    this.f4703a.startActivity(intent);
                    return;
                case R.id.tcash_payment_pdam_button:
                    intent.setClass(this.f4703a.f4705b, TCashPDAMActivity.class);
                    if (this.f4703a.f4720q) {
                        intent.putExtra(C1358h.f2940k, C1358h.f2943n);
                    }
                    this.f4703a.startActivity(intent);
                    return;
                case R.id.tcash_payment_pln_button:
                    intent.setClass(this.f4703a.f4705b, TCashPLNActivity.class);
                    if (this.f4703a.f4720q) {
                        intent.putExtra(C1358h.f2940k, C1358h.f2943n);
                    }
                    this.f4703a.startActivity(intent);
                    return;
                case R.id.tcash_payment_ticket_button:
                    this.f4703a.f4722s.m6516e(this.f4703a.f4715l.getText().toString());
                    this.f4703a.f4722s.m6517f("2600");
                    this.f4703a.dismiss();
                    return;
                case R.id.tcash_payment_transport_button:
                    this.f4703a.f4722s.m6516e(this.f4703a.f4716m.getText().toString());
                    this.f4703a.f4722s.m6517f("2700");
                    this.f4703a.dismiss();
                    return;
                case R.id.tcash_payment_insurance_button:
                    this.f4703a.f4722s.m6516e(this.f4703a.f4717n.getText().toString());
                    this.f4703a.f4722s.m6518g("3310");
                    this.f4703a.dismiss();
                    return;
                case R.id.tcash_payment_merchant_button:
                    intent.setClass(this.f4703a.getActivity(), TCashMerchantActivty.class);
                    if (this.f4703a.f4720q) {
                        intent.putExtra(C1358h.f2940k, C1358h.f2943n);
                    }
                    this.f4703a.startActivity(intent);
                    return;
                default:
                    return;
            }
        }
    }

    public void m6897a(Context context) {
        this.f4705b = context;
    }

    public void m6898a(boolean z) {
        this.f4720q = z;
    }

    public void m6899b(boolean z) {
        this.f4721r = z;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.f4720q) {
            dismiss();
            ((TCashActivity) getActivity()).finish();
            return;
        }
        dismiss();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setGravity(81);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.dialog_animation;
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_payment_menu, viewGroup, false);
        this.f4722s = (TCashActivity) getActivity();
        this.f4706c = (LinearLayout) inflate.findViewById(R.id.tcash_payment_button_layout);
        this.f4707d = (Button) inflate.findViewById(R.id.tcash_payment_menu_slide_button);
        this.f4708e = (Button) inflate.findViewById(R.id.tcash_payment_kartu_halo_button);
        this.f4709f = (Button) inflate.findViewById(R.id.tcash_payment_pln_button);
        this.f4710g = (Button) inflate.findViewById(R.id.tcash_payment_cabletv_button);
        this.f4711h = (Button) inflate.findViewById(R.id.tcash_payment_Internet_button);
        this.f4712i = (Button) inflate.findViewById(R.id.tcash_payment_fixedline_button);
        this.f4713j = (Button) inflate.findViewById(R.id.tcash_payment_pdam_button);
        this.f4714k = (Button) inflate.findViewById(R.id.tcash_payment_multifinance_button);
        this.f4715l = (Button) inflate.findViewById(R.id.tcash_payment_ticket_button);
        this.f4716m = (Button) inflate.findViewById(R.id.tcash_payment_transport_button);
        this.f4717n = (Button) inflate.findViewById(R.id.tcash_payment_insurance_button);
        this.f4718o = (Button) inflate.findViewById(R.id.tcash_payment_merchant_button);
        this.f4719p = (Button) inflate.findViewById(R.id.tcash_payment_others_button);
        this.f4707d.setOnClickListener(this.f4723t);
        this.f4708e.setOnClickListener(this.f4723t);
        this.f4710g.setOnClickListener(this.f4723t);
        this.f4709f.setOnClickListener(this.f4723t);
        this.f4712i.setOnClickListener(this.f4723t);
        this.f4711h.setOnClickListener(this.f4723t);
        this.f4713j.setOnClickListener(this.f4723t);
        this.f4714k.setOnClickListener(this.f4723t);
        this.f4715l.setOnClickListener(this.f4723t);
        this.f4716m.setOnClickListener(this.f4723t);
        this.f4717n.setOnClickListener(this.f4723t);
        this.f4718o.setOnClickListener(this.f4723t);
        this.f4719p.setOnClickListener(this.f4723t);
        m6761a((ViewGroup) inflate);
        m6763a((TextView) inflate.findViewById(R.id.sub_menu_title_textview));
        m6762a(this.f4706c);
        m6760a(inflate);
        if (this.f4721r) {
            this.f4722s.m6516e(getString(R.string.button_internet));
            this.f4722s.m6518g("1400");
        }
        return inflate;
    }

    public void onResume() {
        super.onResume();
    }
}
