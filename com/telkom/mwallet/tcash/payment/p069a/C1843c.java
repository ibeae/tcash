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
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.tcash.payment.TCashFixedLineActivity;

public class C1843c extends C1386e {
    private static final String f5052a = C1843c.class.getSimpleName();
    private Button f5053b;
    private Button f5054c;
    private EditText f5055j;
    private TextView f5056k;
    private TextView f5057l;
    private TextView f5058m;
    private TextView f5059n;
    private String f5060o;
    private String f5061p;
    private String f5062q;
    private String f5063r;
    private OnClickListener f5064s = new C18421(this);

    class C18421 implements OnClickListener {
        final /* synthetic */ C1843c f5051a;

        C18421(C1843c c1843c) {
            this.f5051a = c1843c;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_payment_confirm_button:
                    TCashFixedLineActivity tCashFixedLineActivity = (TCashFixedLineActivity) this.f5051a.getActivity();
                    if (this.f5051a.f5053b.isSelected()) {
                        String obj = this.f5051a.f5055j.getText().toString();
                        if (obj.isEmpty()) {
                            obj = this.f5051a.getString(R.string.hint_favorite_title);
                        }
                        tCashFixedLineActivity.m6998e(obj);
                    } else {
                        tCashFixedLineActivity.m7004r();
                    }
                    tCashFixedLineActivity.m7003q();
                    return;
                case R.id.tcash_set_favorite_button:
                    if (this.f5051a.f5053b.isSelected()) {
                        this.f5051a.f5053b.setSelected(false);
                        this.f5051a.f5055j.setVisibility(8);
                        return;
                    }
                    this.f5051a.f5053b.setSelected(true);
                    this.f5051a.f5055j.setText("");
                    this.f5051a.f5055j.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    private void m7218b(View view) {
        this.f5054c = (Button) view.findViewById(R.id.tcash_payment_confirm_button);
        this.f5053b = (Button) view.findViewById(R.id.tcash_set_favorite_button);
        this.f5055j = (EditText) view.findViewById(R.id.tcash_title_favorite_edittext);
        this.f5056k = (TextView) view.findViewById(R.id.tcash_customerid_textview);
        this.f5057l = (TextView) view.findViewById(R.id.tcash_name_textview);
        this.f5058m = (TextView) view.findViewById(R.id.tcash_amount_textview);
        this.f5059n = (TextView) view.findViewById(R.id.tcash_fee_textview);
        this.f5054c.setOnClickListener(this.f5064s);
        this.f5053b.setOnClickListener(this.f5064s);
        m7219b(this.f5060o);
        m7220c(this.f5061p);
        m7221f(this.f5062q);
        m7222g(this.f5063r);
    }

    public void m7219b(String str) {
        this.f5060o = str;
        if (this.f5056k != null) {
            this.f5056k.setText(str);
        }
    }

    public void m7220c(String str) {
        this.f5061p = str;
        if (this.f5057l == null) {
            return;
        }
        if (this.f5061p != null) {
            this.f5057l.setText(this.f5061p);
        } else {
            ((LinearLayout) this.f5057l.getParent()).setVisibility(8);
        }
    }

    public void m7221f(String str) {
        this.f5062q = str;
        if (this.f5058m != null) {
            this.f5058m.setText(C1354g.m4955f(str));
        }
    }

    public void m7222g(String str) {
        this.f5063r = str;
        if (this.f5059n != null && str != null && str.length() > 0) {
            this.f5059n.setText(C1354g.m4955f(str));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_fixedline_second, null);
        m5202a((ViewGroup) inflate);
        m7218b(inflate);
        return inflate;
    }
}
