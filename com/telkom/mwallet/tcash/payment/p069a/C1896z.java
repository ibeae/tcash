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

public class C1896z extends C1872q {
    private static final String f5345b = C1896z.class.getSimpleName();
    TCashPaymentTemplateActivity f5346a;
    private Button f5347c;
    private EditText f5348j;
    private EditText f5349k;
    private TextView f5350l;
    private Random2of6PinEditView f5351m;
    private String f5352n;
    private OnClickListener f5353o = new C18951(this);

    class C18951 implements OnClickListener {
        final /* synthetic */ C1896z f5344a;

        C18951(C1896z c1896z) {
            this.f5344a = c1896z;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    if (this.f5344a.m7472e() && this.f5344a.f5351m.m8024c()) {
                        this.f5344a.f5346a.m7178g(this.f5344a.f5348j.getText().toString());
                        this.f5344a.f5346a.m7174b("billingCode", this.f5344a.f5349k.getText().toString());
                        this.f5344a.f5346a.m7179j(this.f5344a.f5351m.getPin());
                        this.f5344a.f5346a.m7172a(this.f5344a.getString(R.string.payment_noti_cable_tv_msg1), this.f5344a.getString(R.string.id_number));
                        this.f5344a.f5346a.m7184q();
                        return;
                    }
                    return;
                case R.id.tcash_forget_pin_button:
                    this.f5344a.m5219p();
                    return;
                default:
                    return;
            }
        }
    }

    private void m7467b(View view) {
        this.f5347c = (Button) view.findViewById(R.id.tcash_confirm_button);
        this.f5348j = (EditText) view.findViewById(R.id.tcash_others_partner_code);
        this.f5349k = (EditText) view.findViewById(R.id.tcash_others_billing_code);
        this.f5351m = (Random2of6PinEditView) view.findViewById(R.id.pin_edit_view);
        C1347a.m4910a().m4912a(this.f5351m.getPinViews());
        this.f5350l = (TextView) view.findViewById(R.id.tcash_forget_pin_button);
        this.f5347c.setText(R.string.btn_next);
        this.f5347c.setOnClickListener(this.f5353o);
        this.f5350l.setOnClickListener(this.f5353o);
        mo1554b(this.f5352n);
        this.f5348j.requestFocus();
        getActivity().getWindow().setSoftInputMode(4);
    }

    private void m7470d() {
        this.f5351m.m8023b();
        this.f5348j.setBackgroundResource(R.drawable.edittext_selector_n);
        this.f5349k.setBackgroundResource(R.drawable.edittext_selector_n);
    }

    private boolean m7472e() {
        m7470d();
        if ("".equals(this.f5348j.getText().toString().trim())) {
            this.f5348j.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if (!"".equals(this.f5349k.getText().toString().trim())) {
            return true;
        } else {
            this.f5349k.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        }
    }

    public void mo1554b(String str) {
        this.f5352n = str;
        if (this.f5348j != null) {
            this.f5348j.setText(str);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5346a = (TCashPaymentTemplateActivity) getActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_payment_template_first_9, null);
        this.h.m4934a(this.e, (ViewGroup) inflate, 2);
        m7467b(inflate);
        return inflate;
    }
}
