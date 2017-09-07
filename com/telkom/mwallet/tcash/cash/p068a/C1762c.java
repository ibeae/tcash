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
import com.telkom.mwallet.setting.tcash.TCashFavoriteListActivity;
import com.telkom.mwallet.tcash.TCashActivity;
import com.telkom.mwallet.tcash.cash.TCashInATMBersamaActivity;
import com.telkom.mwallet.tcash.cash.TCashInGrapariActivity;
import com.telkom.mwallet.tcash.cash.TCashInRetailStoreActivity;
import com.telkom.mwallet.tcash.fragment.C1761d;

public class C1762c extends C1761d {
    private static final String f4540a = C1762c.class.getSimpleName();
    private Context f4541b;
    private LinearLayout f4542c;
    private Button f4543d;
    private Button f4544e;
    private Button f4545f;
    private Button f4546g;
    private Button f4547h;
    private boolean f4548i = false;
    private OnClickListener f4549j = new C17601(this);

    class C17601 implements OnClickListener {
        final /* synthetic */ C1762c f4535a;

        C17601(C1762c c1762c) {
            this.f4535a = c1762c;
        }

        public void onClick(View view) {
            Intent intent = new Intent();
            switch (view.getId()) {
                case R.id.tcash_cash_in_ATM_Banking_button:
                    intent.setClass(this.f4535a.getActivity().getApplicationContext(), TCashInATMBersamaActivity.class);
                    this.f4535a.startActivity(intent);
                    return;
                case R.id.tcash_cash_in_SMS_Banking_button:
                    if (TCashActivity.class.getSimpleName().equals(this.f4535a.getActivity().getClass().getSimpleName())) {
                        ((TCashActivity) this.f4535a.getActivity()).m6515c(this.f4535a.f4548i);
                    } else {
                        ((TCashFavoriteListActivity) this.f4535a.getActivity()).m6275p();
                    }
                    this.f4535a.dismiss();
                    return;
                case R.id.tcash_cash_in_grapari_button:
                    intent.setClass(this.f4535a.getActivity().getApplicationContext(), TCashInGrapariActivity.class);
                    this.f4535a.startActivity(intent);
                    return;
                case R.id.tcash_cash_in_retail_store_button:
                    intent.setClass(this.f4535a.getActivity().getApplicationContext(), TCashInRetailStoreActivity.class);
                    this.f4535a.startActivity(intent);
                    return;
                case R.id.tcash_cash_in_slide_button:
                    if (TCashActivity.class.getSimpleName().equals(this.f4535a.getActivity().getClass().getSimpleName())) {
                        ((TCashActivity) this.f4535a.getActivity()).mo1505o();
                    } else {
                        this.f4535a.dismiss();
                    }
                    this.f4535a.dismiss();
                    return;
                default:
                    return;
            }
        }
    }

    private void m6765b(View view) {
        this.f4542c = (LinearLayout) view.findViewById(R.id.tcash_cash_in_button_layout);
        this.f4543d = (Button) view.findViewById(R.id.tcash_cash_in_slide_button);
        this.f4544e = (Button) view.findViewById(R.id.tcash_cash_in_SMS_Banking_button);
        this.f4545f = (Button) view.findViewById(R.id.tcash_cash_in_ATM_Banking_button);
        this.f4546g = (Button) view.findViewById(R.id.tcash_cash_in_retail_store_button);
        this.f4547h = (Button) view.findViewById(R.id.tcash_cash_in_grapari_button);
        this.f4543d.setOnClickListener(this.f4549j);
        this.f4544e.setOnClickListener(this.f4549j);
        this.f4545f.setOnClickListener(this.f4549j);
        this.f4546g.setOnClickListener(this.f4549j);
        this.f4547h.setOnClickListener(this.f4549j);
        m6762a(this.f4542c);
    }

    public void m6766a(Context context) {
        this.f4541b = context;
    }

    public void m6767a(boolean z) {
        this.f4548i = z;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.f4548i) {
            dismiss();
            ((TCashActivity) getActivity()).finish();
            return;
        }
        if (TCashActivity.class.getSimpleName().equals(getActivity().getClass().getSimpleName())) {
            ((TCashActivity) getActivity()).mo1505o();
        }
        dismiss();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setGravity(81);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.dialog_animation;
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_cash_in_menu, viewGroup, false);
        m6765b(inflate);
        m6761a((ViewGroup) inflate);
        m6763a((TextView) inflate.findViewById(R.id.sub_menu_title_textview));
        return inflate;
    }
}
