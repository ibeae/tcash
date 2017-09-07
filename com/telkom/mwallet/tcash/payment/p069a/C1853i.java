package com.telkom.mwallet.tcash.payment.p069a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.telkom.mwallet.R;
import com.telkom.mwallet.p064a.C1347a;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.tcash.payment.TCashOthersActivity;

public class C1853i extends C1386e {
    private static final String f5113a = C1853i.class.getSimpleName();
    private Button f5114b;
    private Button f5115c;
    private EditText f5116j;
    private TextView f5117k;
    private TextView f5118l;
    private TextView f5119m;
    private TextView f5120n;
    private TextView f5121o;
    private String f5122p;
    private String f5123q;
    private String f5124r;
    private String f5125s;
    private OnClickListener f5126t = new C18521(this);

    class C18521 implements OnClickListener {
        final /* synthetic */ C1853i f5112a;

        C18521(C1853i c1853i) {
            this.f5112a = c1853i;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_payment_confirm_button:
                    TCashOthersActivity tCashOthersActivity = (TCashOthersActivity) this.f5112a.getActivity();
                    if (this.f5112a.f5114b.isSelected()) {
                        String obj = this.f5112a.f5116j.getText().toString();
                        if (obj.isEmpty()) {
                            obj = this.f5112a.getString(R.string.hint_favorite_title);
                        }
                        tCashOthersActivity.m7066j(obj);
                    } else {
                        tCashOthersActivity.m7070r();
                    }
                    tCashOthersActivity.m7069q();
                    return;
                case R.id.tcash_set_favorite_button:
                    if (this.f5112a.f5114b.isSelected()) {
                        this.f5112a.f5114b.setSelected(false);
                        this.f5112a.f5116j.setVisibility(8);
                        return;
                    }
                    this.f5112a.f5114b.setSelected(true);
                    this.f5112a.f5116j.setText("");
                    this.f5112a.f5116j.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    private void m7257b(View view) {
        this.f5115c = (Button) view.findViewById(R.id.tcash_payment_confirm_button);
        this.f5114b = (Button) view.findViewById(R.id.tcash_set_favorite_button);
        this.f5116j = (EditText) view.findViewById(R.id.tcash_title_favorite_edittext);
        C1347a.m4910a().m4914a(this.f5116j);
        this.f5117k = (TextView) view.findViewById(R.id.tcash_noti_title_textview);
        this.f5118l = (TextView) view.findViewById(R.id.tcash_customerid_textview);
        this.f5119m = (TextView) view.findViewById(R.id.tcash_others_billing_code);
        this.f5120n = (TextView) view.findViewById(R.id.tcash_amount_textview);
        this.f5121o = (TextView) view.findViewById(R.id.tcash_fee_textview);
        this.f5117k.setText(R.string.others_billing_code_label);
        this.f5115c.setOnClickListener(this.f5126t);
        this.f5114b.setOnClickListener(this.f5126t);
        m7258b(this.f5122p);
        m7259c(this.f5123q);
        m7260f(this.f5124r);
        m7261g(this.f5125s);
    }

    public void m7258b(String str) {
        this.f5122p = str;
        if (this.f5118l != null) {
            this.f5118l.setText(str);
        }
    }

    public void m7259c(String str) {
        this.f5123q = str;
        if (this.f5119m != null) {
            this.f5119m.setText(str);
        }
    }

    public void m7260f(String str) {
        this.f5124r = str;
        if (this.f5120n != null) {
            this.f5120n.setText(C1354g.m4955f(str));
        }
    }

    public void m7261g(String str) {
        this.f5125s = str;
        if (this.f5121o != null && str != null && str.length() > 0) {
            this.f5121o.setText(C1354g.m4955f(str));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_others_second, null);
        m5202a((ViewGroup) inflate);
        m7257b(inflate);
        return inflate;
    }
}
