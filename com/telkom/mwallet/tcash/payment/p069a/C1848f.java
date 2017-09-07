package com.telkom.mwallet.tcash.payment.p069a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.telkom.mwallet.R;
import com.telkom.mwallet.p064a.C1347a;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.tcash.payment.TCashKartuHaloActivity;

public class C1848f extends C1386e {
    private static final String f5085a = C1848f.class.getSimpleName();
    private Button f5086b;
    private Button f5087c;
    private EditText f5088j;
    private TextView f5089k;
    private TextView f5090l;
    private TextView f5091m;
    private TextView f5092n;
    private String f5093o;
    private String f5094p;
    private String f5095q;
    private String f5096r;
    private OnClickListener f5097s = new C18471(this);

    class C18471 implements OnClickListener {
        final /* synthetic */ C1848f f5084a;

        C18471(C1848f c1848f) {
            this.f5084a = c1848f;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_kartu_halo_confirm_button:
                    TCashKartuHaloActivity tCashKartuHaloActivity = (TCashKartuHaloActivity) this.f5084a.getActivity();
                    if (this.f5084a.f5086b.isSelected()) {
                        String obj = this.f5084a.f5088j.getText().toString();
                        if (obj.isEmpty()) {
                            obj = this.f5084a.getString(R.string.hint_favorite_title);
                        }
                        tCashKartuHaloActivity.m7032g(obj);
                    } else {
                        tCashKartuHaloActivity.m7036r();
                    }
                    tCashKartuHaloActivity.m7035q();
                    return;
                case R.id.tcash_kartu_halo_set_favorite_button:
                    if (this.f5084a.f5086b.isSelected()) {
                        this.f5084a.f5086b.setSelected(false);
                        this.f5084a.f5088j.setVisibility(8);
                        return;
                    }
                    this.f5084a.f5086b.setSelected(true);
                    this.f5084a.f5088j.setText("");
                    this.f5084a.f5088j.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    private void m7239b(View view) {
        this.f5087c = (Button) view.findViewById(R.id.tcash_kartu_halo_confirm_button);
        this.f5086b = (Button) view.findViewById(R.id.tcash_kartu_halo_set_favorite_button);
        this.f5089k = (TextView) view.findViewById(R.id.tcash_kartu_halo_number_textview);
        this.f5090l = (TextView) view.findViewById(R.id.tcash_kartu_halo_name_textview);
        this.f5091m = (TextView) view.findViewById(R.id.tcash_kartu_halo_amount_textview);
        this.f5092n = (TextView) view.findViewById(R.id.tcash_fee_textview);
        this.f5088j = (EditText) view.findViewById(R.id.tcash_kartu_halo_title_favorite_edittext);
        C1347a.m4910a().m4914a(this.f5088j);
        this.f5087c.setOnClickListener(this.f5097s);
        this.f5086b.setOnClickListener(this.f5097s);
        m7240b(this.f5093o);
        m7241c(this.f5094p);
        m7242f(this.f5095q);
        m7243g(this.f5096r);
    }

    public void m7240b(String str) {
        this.f5093o = str;
        if (this.f5089k != null) {
            this.f5089k.setText(str);
        }
    }

    public void m7241c(String str) {
        this.f5094p = str;
        if (this.f5090l == null) {
            return;
        }
        if (this.f5094p != null) {
            this.f5090l.setText(this.f5094p);
        } else {
            ((LinearLayout) this.f5090l.getParent()).setVisibility(8);
        }
    }

    public void m7242f(String str) {
        this.f5095q = str;
        if (this.f5091m != null) {
            this.f5091m.setText(C1354g.m4955f(str));
        }
    }

    public void m7243g(String str) {
        this.f5096r = str;
        if (this.f5092n != null && str != null && str.length() > 0) {
            this.f5092n.setText(C1354g.m4955f(str));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_kartu_halo_second, null);
        m5202a((ViewGroup) inflate);
        m7239b(inflate);
        return inflate;
    }
}
