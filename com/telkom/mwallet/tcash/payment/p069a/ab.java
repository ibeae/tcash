package com.telkom.mwallet.tcash.payment.p069a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.AppEventsConstants;
import com.telkom.mwallet.R;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.tcash.payment.TCashPaymentTemplateActivity;

public class ab extends C1386e {
    private static final String f5014a = ab.class.getSimpleName();
    private Button f5015b;
    private TextView f5016c;
    private TextView f5017j;
    private TextView f5018k;
    private TextView f5019l;
    private EditText f5020m;
    private String f5021n;
    private String f5022o;
    private String f5023p;
    private String f5024q;
    private String f5025r;
    private OnClickListener f5026s = new C18391(this);

    class C18391 implements OnClickListener {
        final /* synthetic */ ab f5013a;

        C18391(ab abVar) {
            this.f5013a = abVar;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_payment_next_button:
                    TCashPaymentTemplateActivity tCashPaymentTemplateActivity = (TCashPaymentTemplateActivity) this.f5013a.getActivity();
                    tCashPaymentTemplateActivity.m7172a(this.f5013a.getString(R.string.payment_noti_multi_finance_msg), this.f5013a.f5025r);
                    if ("".equals(this.f5013a.f5020m.getText().toString().trim())) {
                        tCashPaymentTemplateActivity.m7176e("");
                        return;
                    } else {
                        tCashPaymentTemplateActivity.m7176e(this.f5013a.f5020m.getText().toString());
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private void m7199b(View view) {
        this.f5015b = (Button) view.findViewById(R.id.tcash_payment_next_button);
        this.f5016c = (TextView) view.findViewById(R.id.tcash_customerid_textview);
        this.f5017j = (TextView) view.findViewById(R.id.tcash_payment_your_bill_textview);
        this.f5018k = (TextView) view.findViewById(R.id.tcash_payment_min_payment_textview);
        this.f5019l = (TextView) view.findViewById(R.id.tcash_payment_label_id_txt);
        this.f5020m = (EditText) view.findViewById(R.id.tcash_payment_put);
        this.f5015b.setOnClickListener(this.f5026s);
        if (this.f5024q != null) {
            m7203g(this.f5024q);
        }
        if (this.f5025r != null) {
            m7204h(this.f5025r);
        }
        if (this.f5021n != null) {
            m7200b(this.f5021n);
        }
        if (this.f5022o != null) {
            m7201c(C1354g.m4955f(this.f5022o));
        }
        m7202f(C1354g.m4955f(AppEventsConstants.EVENT_PARAM_VALUE_NO));
        this.f5020m.requestFocus();
        getActivity().getWindow().setSoftInputMode(4);
    }

    public void m7200b(String str) {
        this.f5021n = str;
        if (this.f5016c != null) {
            String str2 = "";
            for (int i = 0; i < str.length() - 4; i++) {
                str2 = str2 + "*";
            }
            this.f5016c.setText(str2 + str.substring(str.length() - 4));
        }
    }

    public void m7201c(String str) {
        this.f5022o = str;
        if (this.f5017j != null) {
            this.f5017j.setText(str);
        }
    }

    public void m7202f(String str) {
        this.f5023p = str;
        if (this.f5018k != null) {
            this.f5018k.setText(str);
        }
    }

    public void m7203g(String str) {
        this.f5024q = str;
        if (this.f5019l != null) {
            this.f5019l.setText(str);
        }
    }

    public void m7204h(String str) {
        this.f5025r = str;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_payment_template_middle, null);
        m5202a((ViewGroup) inflate);
        m7199b(inflate);
        return inflate;
    }
}
