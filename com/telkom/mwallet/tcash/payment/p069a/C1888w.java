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
import com.telkom.mwallet.tcash.payment.TCashPaymentTemplateActivity;
import com.telkom.mwallet.view.Random2of6PinEditView;

public class C1888w extends C1872q {
    private static final String f5306b = C1888w.class.getSimpleName();
    TCashPaymentTemplateActivity f5307a;
    private Button f5308c;
    private EditText f5309j;
    private TextView f5310k;
    private Random2of6PinEditView f5311l;
    private String f5312m;
    private OnClickListener f5313n = new C18871(this);

    class C18871 implements OnClickListener {
        final /* synthetic */ C1888w f5305a;

        C18871(C1888w c1888w) {
            this.f5305a = c1888w;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    if (!this.f5305a.m7433e()) {
                        return;
                    }
                    if (!C1354g.m4950b(this.f5305a.f5309j)) {
                        this.f5305a.f5309j.requestFocus(this.f5305a.f5309j.length());
                        this.f5305a.f5309j.setBackgroundResource(R.drawable.field_sct_red);
                        return;
                    } else if (this.f5305a.f5311l.m8024c()) {
                        this.f5305a.f5307a.m7178g(this.f5305a.f5309j.getText().toString());
                        this.f5305a.f5307a.m7179j(this.f5305a.f5311l.getPin());
                        this.f5305a.f5307a.m7172a(this.f5305a.getString(R.string.payment_noti_fixedline_msg), this.f5305a.getString(R.string.telephone_phone_number));
                        this.f5305a.f5307a.m7184q();
                        return;
                    } else {
                        return;
                    }
                case R.id.tcash_forget_pin_button:
                    this.f5305a.m5219p();
                    return;
                default:
                    return;
            }
        }
    }

    private void m7429b(View view) {
        this.f5308c = (Button) view.findViewById(R.id.tcash_confirm_button);
        this.f5309j = (EditText) view.findViewById(R.id.tcash_recipient_edittext);
        this.f5310k = (TextView) view.findViewById(R.id.tcash_forget_pin_button);
        this.f5311l = (Random2of6PinEditView) view.findViewById(R.id.pin_edit_view);
        C1347a.m4910a().m4912a(this.f5311l.getPinViews());
        this.f5308c.setText(R.string.btn_next);
        this.f5308c.setOnClickListener(this.f5313n);
        this.f5310k.setOnClickListener(this.f5313n);
        mo1554b(this.f5312m);
        this.f5309j.requestFocus();
        getActivity().getWindow().setSoftInputMode(4);
    }

    private void m7431d() {
        this.f5311l.m8023b();
        this.f5309j.setBackgroundResource(R.drawable.edittext_selector_n);
    }

    private boolean m7433e() {
        m7431d();
        if (!"".equals(this.f5309j.getText().toString().trim())) {
            return true;
        }
        this.f5309j.requestFocus();
        this.f5309j.setBackgroundResource(R.drawable.field_sct_red);
        return false;
    }

    public void mo1554b(String str) {
        this.f5312m = str;
        if (this.f5309j != null) {
            this.f5309j.setText(str);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5307a = (TCashPaymentTemplateActivity) getActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_payment_template_first_6, null);
        m5202a((ViewGroup) inflate);
        m7429b(inflate);
        return inflate;
    }
}
