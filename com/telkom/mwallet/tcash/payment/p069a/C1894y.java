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
import com.telkom.mwallet.tcash.payment.TCashPaymentTemplateActivity;
import com.telkom.mwallet.view.Random2of6PinEditView;

public class C1894y extends C1872q {
    private static final String f5334b = C1894y.class.getSimpleName();
    TCashPaymentTemplateActivity f5335a;
    private Button f5336c;
    private EditText f5337j;
    private TextView f5338k;
    private Random2of6PinEditView f5339l;
    private ab f5340m;
    private String f5341n;
    private String f5342o;
    private OnClickListener f5343p = new C18931(this);

    class C18931 implements OnClickListener {
        final /* synthetic */ C1894y f5333a;

        C18931(C1894y c1894y) {
            this.f5333a = c1894y;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    if (this.f5333a.m7462e() && this.f5333a.f5339l.m8024c()) {
                        this.f5333a.f5335a.m7168a(this.f5333a.f5340m);
                        this.f5333a.f5335a.m7178g(this.f5333a.f5337j.getText().toString());
                        this.f5333a.f5335a.m7179j(this.f5333a.f5339l.getPin());
                        this.f5333a.f5335a.m7184q();
                        return;
                    }
                    return;
                case R.id.tcash_forget_pin_button:
                    this.f5333a.m5219p();
                    return;
                default:
                    return;
            }
        }
    }

    private void m7457b(View view) {
        this.f5336c = (Button) view.findViewById(R.id.tcash_confirm_button);
        this.f5337j = (EditText) view.findViewById(R.id.tcash_payment_id_number);
        this.f5338k = (TextView) view.findViewById(R.id.tcash_forget_pin_button);
        this.f5339l = (Random2of6PinEditView) view.findViewById(R.id.pin_edit_view);
        C1347a.m4910a().m4912a(this.f5339l.getPinViews());
        this.f5336c.setText(R.string.btn_next);
        this.f5336c.setOnClickListener(this.f5343p);
        this.f5338k.setOnClickListener(this.f5343p);
        mo1554b(this.f5341n);
        mo1560f(this.f5342o);
        this.f5337j.requestFocus();
        getActivity().getWindow().setSoftInputMode(4);
    }

    private void m7460d() {
        this.f5339l.m8023b();
        this.f5337j.setBackgroundResource(R.drawable.edittext_selector_n);
    }

    private boolean m7462e() {
        m7460d();
        if (!"".equals(this.f5337j.getText().toString().trim())) {
            return true;
        }
        this.f5337j.requestFocus();
        this.f5337j.setBackgroundResource(R.drawable.field_sct_red);
        return false;
    }

    public void mo1554b(String str) {
        this.f5341n = str;
        if (this.f5337j != null) {
            this.f5337j.setText(str);
        }
    }

    public void mo1560f(String str) {
        this.f5342o = str;
        if (str != null && this.f5337j != null) {
            this.f5340m = new ab();
            if (str.equals("TPM0008")) {
                this.f5337j.setHint(getString(R.string.tcash_credit_card_number));
                this.f5340m.m7203g(getString(R.string.tcash_credit_card_no));
                this.f5340m.m7204h(getString(R.string.tcash_credit_card_no));
                return;
            }
            this.f5337j.setHint(getString(R.string.id_number));
            this.f5340m.m7203g(getString(R.string.id_number));
            this.f5340m.m7204h(getString(R.string.pdam_id_no));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5335a = (TCashPaymentTemplateActivity) getActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_payment_template_first_8, null);
        m5202a((ViewGroup) inflate);
        m7457b(inflate);
        return inflate;
    }
}
