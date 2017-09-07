package com.telkom.mwallet.tcash.cash.p068a;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.telkom.mwallet.R;
import com.telkom.mwallet.tcash.TCashActivity;
import com.telkom.mwallet.tcash.fragment.C1761d;

public class C1772h extends C1761d {
    public static final String f4592a = C1772h.class.getSimpleName();
    private Context f4593b;
    private LinearLayout f4594c;
    private Button f4595d;
    private Button f4596e;
    private Button f4597f;
    private OnClickListener f4598g = new C17711(this);

    class C17711 implements OnClickListener {
        final /* synthetic */ C1772h f4591a;

        C17711(C1772h c1772h) {
            this.f4591a = c1772h;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_cash_in_button:
                    ((TCashActivity) this.f4591a.getActivity()).m6513b(false);
                    this.f4591a.dismiss();
                    return;
                case R.id.tcash_cash_out_button:
                    ((TCashActivity) this.f4591a.getActivity()).m6520p();
                    this.f4591a.dismiss();
                    return;
                case R.id.tcash_cash_slide_button:
                    this.f4591a.dismiss();
                    return;
                default:
                    return;
            }
        }
    }

    public void m6798a(Context context) {
        this.f4593b = context;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setGravity(81);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.dialog_animation;
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_cash_menu, viewGroup, false);
        this.f4594c = (LinearLayout) inflate.findViewById(R.id.tcash_cash_button_layout);
        this.f4595d = (Button) inflate.findViewById(R.id.tcash_cash_slide_button);
        this.f4596e = (Button) inflate.findViewById(R.id.tcash_cash_in_button);
        this.f4597f = (Button) inflate.findViewById(R.id.tcash_cash_out_button);
        this.f4595d.setOnClickListener(this.f4598g);
        this.f4596e.setOnClickListener(this.f4598g);
        this.f4597f.setOnClickListener(this.f4598g);
        m6761a((ViewGroup) inflate);
        m6763a((TextView) inflate.findViewById(R.id.sub_menu_title_textview));
        m6762a(this.f4594c);
        m6760a(inflate);
        return inflate;
    }
}
