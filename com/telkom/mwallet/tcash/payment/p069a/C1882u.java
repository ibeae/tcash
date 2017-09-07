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

public class C1882u extends C1872q {
    private static final String f5274b = C1882u.class.getSimpleName();
    private static View f5275m = null;
    TCashPaymentTemplateActivity f5276a;
    private Button f5277c;
    private EditText f5278j;
    private TextView f5279k;
    private Random2of6PinEditView f5280l;
    private String f5281n;
    private OnClickListener f5282o = new C18811(this);

    class C18811 implements OnClickListener {
        final /* synthetic */ C1882u f5273a;

        C18811(C1882u c1882u) {
            this.f5273a = c1882u;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    if (this.f5273a.m7398e() && this.f5273a.f5280l.m8024c()) {
                        this.f5273a.f5276a.m7178g(this.f5273a.f5278j.getText().toString());
                        this.f5273a.f5276a.m7179j(this.f5273a.f5280l.getPin());
                        this.f5273a.f5276a.m7172a(this.f5273a.getString(R.string.payment_noti_cable_tv_msg1), this.f5273a.getString(R.string.pdam_id_no));
                        this.f5273a.f5276a.m7184q();
                        return;
                    }
                    return;
                case R.id.tcash_forget_pin_button:
                    this.f5273a.m5219p();
                    return;
                default:
                    return;
            }
        }
    }

    private void m7394b(View view) {
        this.f5278j = (EditText) view.findViewById(R.id.tcash_payment_id_number);
        this.f5277c = (Button) view.findViewById(R.id.tcash_confirm_button);
        this.f5279k = (TextView) view.findViewById(R.id.tcash_forget_pin_button);
        this.f5280l = (Random2of6PinEditView) view.findViewById(R.id.pin_edit_view);
        C1347a.m4910a().m4912a(this.f5280l.getPinViews());
        this.f5277c.setText(R.string.btn_next);
        this.f5277c.setOnClickListener(this.f5282o);
        this.f5279k.setOnClickListener(this.f5282o);
        mo1554b(this.f5281n);
        this.f5278j.requestFocus();
        getActivity().getWindow().setSoftInputMode(4);
    }

    private void m7396d() {
        this.f5280l.m8023b();
        this.f5278j.setBackgroundResource(R.drawable.edittext_selector_n);
    }

    private boolean m7398e() {
        m7396d();
        if (!"".equals(this.f5278j.getText().toString().trim())) {
            return true;
        }
        this.f5278j.requestFocus();
        this.f5278j.setBackgroundResource(R.drawable.field_sct_red);
        return false;
    }

    public void mo1554b(String str) {
        this.f5281n = str;
        if (this.f5278j != null) {
            this.f5278j.setText(str);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5276a = (TCashPaymentTemplateActivity) getActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_payment_template_first_4, null);
        this.h.m4934a(this.e, (ViewGroup) inflate, 2);
        m7394b(inflate);
        return inflate;
    }
}
