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
import com.telkom.mwallet.tcash.payment.TCashPaymentTemplateActivity;

public class ac extends C1386e {
    private static final String f5028a = ac.class.getSimpleName();
    private Button f5029b;
    private Button f5030c;
    private EditText f5031j;
    private TextView f5032k;
    private TextView f5033l;
    private TextView f5034m;
    private TextView f5035n;
    private TextView f5036o;
    private TextView f5037p;
    private TextView f5038q;
    private String f5039r;
    private String f5040s;
    private String f5041t;
    private String f5042u;
    private String f5043v;
    private String f5044w;
    private String f5045x;
    private boolean f5046y;
    private OnClickListener f5047z = new C18401(this);

    class C18401 implements OnClickListener {
        final /* synthetic */ ac f5027a;

        C18401(ac acVar) {
            this.f5027a = acVar;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_payment_confirm_button:
                    TCashPaymentTemplateActivity tCashPaymentTemplateActivity = (TCashPaymentTemplateActivity) this.f5027a.getActivity();
                    if (this.f5027a.f5029b.isSelected()) {
                        String obj = this.f5027a.f5031j.getText().toString();
                        if (obj.isEmpty()) {
                            obj = this.f5027a.getString(R.string.hint_favorite_title);
                        }
                        tCashPaymentTemplateActivity.m7177f(obj);
                    } else {
                        tCashPaymentTemplateActivity.m7186s();
                    }
                    tCashPaymentTemplateActivity.m7185r();
                    return;
                case R.id.tcash_set_favorite_button:
                    if (this.f5027a.f5029b.isSelected()) {
                        this.f5027a.f5029b.setSelected(false);
                        this.f5027a.f5031j.setVisibility(8);
                        return;
                    }
                    this.f5027a.f5029b.setSelected(true);
                    this.f5027a.f5031j.setText("");
                    this.f5027a.f5031j.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    private void m7207b(View view) {
        this.f5030c = (Button) view.findViewById(R.id.tcash_payment_confirm_button);
        this.f5029b = (Button) view.findViewById(R.id.tcash_set_favorite_button);
        this.f5031j = (EditText) view.findViewById(R.id.tcash_title_favorite_edittext);
        C1347a.m4910a().m4914a(this.f5031j);
        this.f5032k = (TextView) view.findViewById(R.id.tcash_noti_msg_textview);
        this.f5033l = (TextView) view.findViewById(R.id.tcash_noti_title_textview);
        this.f5035n = (TextView) view.findViewById(R.id.tcash_customerid_textview);
        this.f5036o = (TextView) view.findViewById(R.id.tcash_name_textview);
        this.f5037p = (TextView) view.findViewById(R.id.tcash_amount_textview);
        this.f5038q = (TextView) view.findViewById(R.id.tcash_fee_textview);
        this.f5034m = (TextView) view.findViewById(R.id.tcash_payment_label_id_txt);
        this.f5030c.setOnClickListener(this.f5047z);
        this.f5029b.setOnClickListener(this.f5047z);
        m7210b(this.f5039r);
        m7211c(this.f5040s);
        m7212f(this.f5041t);
        m7213g(this.f5042u);
        m7214h(this.f5043v);
        m7208a(this.f5044w, this.f5045x);
        m7209a(this.f5046y);
    }

    public void m7208a(String str, String str2) {
        this.f5044w = str;
        this.f5045x = str2;
        if (this.f5032k != null && this.f5034m != null) {
            this.f5032k.setText(str);
            this.f5034m.setText(str2);
        }
    }

    public void m7209a(boolean z) {
        this.f5046y = z;
    }

    public void m7210b(String str) {
        this.f5039r = str;
        if (this.f5033l != null) {
            this.f5033l.setText(str);
        }
    }

    public void m7211c(String str) {
        this.f5040s = str;
        if (this.f5035n == null) {
            return;
        }
        if (this.f5046y) {
            String str2 = "";
            for (int i = 0; i < str.length() - 4; i++) {
                str2 = str2 + "*";
            }
            this.f5035n.setText(str2 + str.substring(str.length() - 4));
            return;
        }
        this.f5035n.setText(str);
    }

    public void m7212f(String str) {
        this.f5041t = str;
        if (this.f5036o == null) {
            return;
        }
        if (this.f5041t != null) {
            this.f5036o.setText(this.f5041t);
        } else {
            ((LinearLayout) this.f5036o.getParent()).setVisibility(8);
        }
    }

    public void m7213g(String str) {
        this.f5042u = str;
        if (this.f5037p != null) {
            this.f5037p.setText(C1354g.m4955f(str));
        }
    }

    public void m7214h(String str) {
        this.f5043v = str;
        if (this.f5038q != null && str != null && str.length() > 0) {
            this.f5038q.setText(C1354g.m4955f(str));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_payment_template_second, null);
        m5202a((ViewGroup) inflate);
        m7207b(inflate);
        return inflate;
    }
}
