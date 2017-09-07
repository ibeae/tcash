package com.telkom.mwallet.tcash.fragment;

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
import com.telkom.mwallet.tcash.purchase.TCashMerchantActivty;

public class C1799i extends C1761d {
    private static final String f4725a = C1799i.class.getSimpleName();
    private static boolean f4726l = false;
    private LinearLayout f4727b;
    private Button f4728c;
    private Button f4729d;
    private Button f4730e;
    private Button f4731f;
    private Button f4732g;
    private Button f4733h;
    private Button f4734i;
    private Button f4735j;
    private Button f4736k;
    private TCashActivity f4737m;
    private OnClickListener f4738n = new C17981(this);

    class C17981 implements OnClickListener {
        final /* synthetic */ C1799i f4724a;

        C17981(C1799i c1799i) {
            this.f4724a = c1799i;
        }

        public void onClick(View view) {
            Intent intent = new Intent();
            switch (view.getId()) {
                case R.id.tcash_purchase_delivery_button:
                    this.f4724a.f4737m.m6516e(this.f4724a.f4731f.getText().toString());
                    this.f4724a.f4737m.m6517f("2500");
                    this.f4724a.dismiss();
                    return;
                case R.id.tcash_purchase_digital_services_button:
                    this.f4724a.f4737m.m6516e(this.f4724a.f4729d.getText().toString());
                    this.f4724a.f4737m.m6517f("2400");
                    this.f4724a.dismiss();
                    return;
                case R.id.tcash_purchase_insurance_button:
                    this.f4724a.f4737m.m6516e(this.f4724a.f4735j.getText().toString());
                    this.f4724a.f4737m.m6517f("3310");
                    this.f4724a.dismiss();
                    return;
                case R.id.tcash_purchase_menu_slide_button:
                    this.f4724a.onCancel(this.f4724a.getDialog());
                    return;
                case R.id.tcash_purchase_merchant_button:
                    intent.setClass(this.f4724a.getActivity(), TCashMerchantActivty.class);
                    if (C1799i.f4726l) {
                        intent.putExtra(C1358h.f2940k, C1358h.f2943n);
                    }
                    this.f4724a.startActivity(intent);
                    return;
                case R.id.tcash_purchase_multi_top_up_button:
                    this.f4724a.f4737m.m6516e(this.f4724a.f4730e.getText().toString());
                    this.f4724a.f4737m.m6517f("2300");
                    this.f4724a.dismiss();
                    return;
                case R.id.tcash_purchase_online_game_button:
                    this.f4724a.f4737m.m6516e(this.f4724a.f4734i.getText().toString());
                    this.f4724a.f4737m.m6517f("2200");
                    this.f4724a.dismiss();
                    return;
                case R.id.tcash_purchase_ticket_button:
                    this.f4724a.f4737m.m6516e(this.f4724a.f4732g.getText().toString());
                    this.f4724a.f4737m.m6517f("2600");
                    this.f4724a.dismiss();
                    return;
                case R.id.tcash_purchase_transport_travel_button:
                    this.f4724a.f4737m.m6516e(this.f4724a.f4733h.getText().toString());
                    this.f4724a.f4737m.m6517f("2700");
                    this.f4724a.dismiss();
                    return;
                default:
                    return;
            }
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (f4726l) {
            dismiss();
            ((TCashActivity) getActivity()).finish();
            return;
        }
        dismiss();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f4737m = (TCashActivity) getActivity();
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setGravity(81);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.dialog_animation;
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_purchase_menu, viewGroup, false);
        this.f4727b = (LinearLayout) inflate.findViewById(R.id.tcash_purchase_button_layout);
        this.f4728c = (Button) inflate.findViewById(R.id.tcash_purchase_menu_slide_button);
        this.f4729d = (Button) inflate.findViewById(R.id.tcash_purchase_digital_services_button);
        this.f4730e = (Button) inflate.findViewById(R.id.tcash_purchase_multi_top_up_button);
        this.f4731f = (Button) inflate.findViewById(R.id.tcash_purchase_delivery_button);
        this.f4732g = (Button) inflate.findViewById(R.id.tcash_purchase_ticket_button);
        this.f4733h = (Button) inflate.findViewById(R.id.tcash_purchase_transport_travel_button);
        this.f4734i = (Button) inflate.findViewById(R.id.tcash_purchase_online_game_button);
        this.f4735j = (Button) inflate.findViewById(R.id.tcash_purchase_insurance_button);
        this.f4736k = (Button) inflate.findViewById(R.id.tcash_purchase_merchant_button);
        this.f4728c.setOnClickListener(this.f4738n);
        this.f4729d.setOnClickListener(this.f4738n);
        this.f4730e.setOnClickListener(this.f4738n);
        this.f4731f.setOnClickListener(this.f4738n);
        this.f4732g.setOnClickListener(this.f4738n);
        this.f4733h.setOnClickListener(this.f4738n);
        this.f4734i.setOnClickListener(this.f4738n);
        this.f4735j.setOnClickListener(this.f4738n);
        this.f4736k.setOnClickListener(this.f4738n);
        m6761a((ViewGroup) inflate);
        m6763a((TextView) inflate.findViewById(R.id.sub_menu_title_textview));
        m6762a(this.f4727b);
        m6760a(inflate);
        return inflate;
    }
}
