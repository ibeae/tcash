package com.telkom.mwallet.tcash.cash.p068a;

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
import com.telkom.mwallet.tcash.TCashTransferActivity;
import com.telkom.mwallet.tcash.cash.TCashOutGrapariActivity;
import com.telkom.mwallet.tcash.cash.TCashOutRetailStoreActivity;
import com.telkom.mwallet.tcash.fragment.C1761d;

public class C1776j extends C1761d {
    private static final String f4607a = C1776j.class.getSimpleName();
    private Context f4608b;
    private LinearLayout f4609c;
    private Button f4610d;
    private Button f4611e;
    private Button f4612f;
    private Button f4613g;
    private OnClickListener f4614h = new C17751(this);

    class C17751 implements OnClickListener {
        final /* synthetic */ C1776j f4606a;

        C17751(C1776j c1776j) {
            this.f4606a = c1776j;
        }

        public void onClick(View view) {
            Intent intent = new Intent();
            switch (view.getId()) {
                case R.id.tcash_cash_out_bank_acount_button:
                    intent.setClass(this.f4606a.getActivity().getApplicationContext(), TCashTransferActivity.class);
                    intent.putExtra(C1358h.f2941l, C1358h.f2942m);
                    this.f4606a.startActivity(intent);
                    return;
                case R.id.tcash_cash_out_grapari_button:
                    intent.setClass(this.f4606a.getActivity().getApplicationContext(), TCashOutGrapariActivity.class);
                    this.f4606a.startActivity(intent);
                    return;
                case R.id.tcash_cash_out_retail_store_button:
                    intent.setClass(this.f4606a.getActivity().getApplicationContext(), TCashOutRetailStoreActivity.class);
                    this.f4606a.startActivity(intent);
                    return;
                case R.id.tcash_cash_out_slide_button:
                    ((TCashActivity) this.f4606a.getActivity()).mo1505o();
                    this.f4606a.dismiss();
                    return;
                default:
                    return;
            }
        }
    }

    private void m6801b(View view) {
        this.f4609c = (LinearLayout) view.findViewById(R.id.tcash_cash_out_button_layout);
        this.f4610d = (Button) view.findViewById(R.id.tcash_cash_out_slide_button);
        this.f4611e = (Button) view.findViewById(R.id.tcash_cash_out_bank_acount_button);
        this.f4612f = (Button) view.findViewById(R.id.tcash_cash_out_retail_store_button);
        this.f4613g = (Button) view.findViewById(R.id.tcash_cash_out_grapari_button);
        this.f4610d.setOnClickListener(this.f4614h);
        this.f4611e.setOnClickListener(this.f4614h);
        this.f4612f.setOnClickListener(this.f4614h);
        this.f4613g.setOnClickListener(this.f4614h);
        m6762a(this.f4609c);
    }

    public void m6802a(Context context) {
        this.f4608b = context;
    }

    public void onCancel(DialogInterface dialogInterface) {
        ((TCashActivity) getActivity()).mo1505o();
        dismiss();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setGravity(81);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.dialog_animation;
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_cash_out_menu, viewGroup, false);
        m6801b(inflate);
        m6761a((ViewGroup) inflate);
        m6763a((TextView) inflate.findViewById(R.id.sub_menu_title_textview));
        return inflate;
    }
}
