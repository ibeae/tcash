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

public class C1876s extends C1872q {
    private static final String f5241b = C1876s.class.getSimpleName();
    TCashPaymentTemplateActivity f5242a;
    private Button f5243c;
    private Button f5244j;
    private Button f5245k;
    private EditText f5246l;
    private EditText f5247m;
    private TextView f5248n;
    private Random2of6PinEditView f5249o;
    private String f5250p = null;
    private String f5251q = null;
    private String f5252r = null;
    private OnClickListener f5253s = new C18751(this);

    class C18751 implements OnClickListener {
        final /* synthetic */ C1876s f5240a;

        C18751(C1876s c1876s) {
            this.f5240a = c1876s;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    if (this.f5240a.m7361e() && this.f5240a.f5249o.m8024c()) {
                        this.f5240a.f5242a.m7179j(this.f5240a.f5249o.getPin());
                        this.f5240a.f5242a.m7178g(this.f5240a.f5246l.getText().toString());
                        String str = "";
                        if (this.f5240a.f5243c.isSelected()) {
                            this.f5240a.f5242a.m7180k(this.f5240a.f5247m.getText().toString());
                            this.f5240a.f5242a.m7181l("PREPAID");
                            str = this.f5240a.getString(R.string.payment_noti_pln_msg1);
                        } else {
                            this.f5240a.f5242a.m7181l("POSTPAID");
                            str = this.f5240a.getString(R.string.payment_noti_pln_msg2);
                        }
                        this.f5240a.f5242a.m7172a(str, this.f5240a.getString(R.string.pdam_id_no));
                        this.f5240a.f5242a.m7184q();
                        return;
                    }
                    return;
                case R.id.tcash_forget_pin_button:
                    this.f5240a.m5219p();
                    return;
                case R.id.tcash_pln_prepaid_menu_button:
                    if (!this.f5240a.f5243c.isSelected()) {
                        this.f5240a.m7364f();
                        return;
                    }
                    return;
                case R.id.tcash_pln_postpaid_menu_button:
                    if (!this.f5240a.f5244j.isSelected()) {
                        this.f5240a.m7366g();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void m7356b(View view) {
        this.f5243c = (Button) view.findViewById(R.id.tcash_pln_prepaid_menu_button);
        this.f5244j = (Button) view.findViewById(R.id.tcash_pln_postpaid_menu_button);
        this.f5246l = (EditText) view.findViewById(R.id.tcash_customerid_edittext);
        this.f5245k = (Button) view.findViewById(R.id.tcash_confirm_button);
        this.f5247m = (EditText) view.findViewById(R.id.tcash_amount_edittext);
        this.f5248n = (TextView) view.findViewById(R.id.tcash_forget_pin_button);
        this.f5249o = (Random2of6PinEditView) view.findViewById(R.id.pin_edit_view);
        C1347a.m4910a().m4912a(this.f5249o.getPinViews());
        this.f5245k.setText(R.string.btn_next);
        this.f5243c.setOnClickListener(this.f5253s);
        this.f5244j.setOnClickListener(this.f5253s);
        this.f5245k.setOnClickListener(this.f5253s);
        this.f5248n.setOnClickListener(this.f5253s);
        if ("1210000".equals(this.f5250p)) {
            m7366g();
        } else {
            this.f5250p = "1220000";
            m7364f();
        }
        mo1554b(this.f5251q);
        m7370g(this.f5252r);
        this.f5246l.requestFocus();
        getActivity().getWindow().setSoftInputMode(4);
    }

    private void m7359d() {
        this.f5249o.m8023b();
        this.f5246l.setBackgroundResource(R.drawable.edittext_selector_n);
        this.f5247m.setBackgroundResource(R.drawable.edittext_selector_n);
    }

    private boolean m7361e() {
        m7359d();
        if ("".equals(this.f5246l.getText().toString().trim())) {
            this.f5246l.requestFocus();
            this.f5246l.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if (this.f5247m.getVisibility() != 0 || (!"".equals(this.f5247m.getText().toString().trim()) && 20000 <= Integer.parseInt(this.f5247m.getText().toString()))) {
            return true;
        } else {
            this.f5247m.requestFocus();
            this.f5247m.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        }
    }

    private void m7364f() {
        this.f5250p = "1220000";
        this.f5247m.setVisibility(0);
        this.f5243c.setSelected(true);
        this.f5243c.setTextColor(getResources().getColor(R.color.n_red));
        this.f5243c.setBackgroundResource(R.drawable.shape_btn_submenu_press);
        this.f5244j.setSelected(false);
        this.f5244j.setTextColor(getResources().getColor(R.color.n_darkgray));
        this.f5244j.setBackgroundResource(R.drawable.shape_btn_submenu);
    }

    private void m7366g() {
        this.f5250p = "1210000";
        this.f5247m.setVisibility(4);
        this.f5244j.setSelected(true);
        this.f5244j.setTextColor(getResources().getColor(R.color.n_red));
        this.f5244j.setBackgroundResource(R.drawable.shape_btn_submenu_press);
        this.f5243c.setSelected(false);
        this.f5243c.setTextColor(getResources().getColor(R.color.n_darkgray));
        this.f5243c.setBackgroundResource(R.drawable.shape_btn_submenu);
    }

    public void mo1554b(String str) {
        this.f5251q = str;
        if (this.f5246l != null) {
            this.f5246l.setText(str);
        }
    }

    public void m7370g(String str) {
        this.f5252r = str;
        if (this.f5247m == null) {
            return;
        }
        if (str == null || str.isEmpty()) {
            m7366g();
            return;
        }
        this.f5247m.setText(str);
        m7364f();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5242a = (TCashPaymentTemplateActivity) getActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_payment_template_first_2, null);
        m5202a((ViewGroup) inflate);
        m7356b(inflate);
        return inflate;
    }
}
