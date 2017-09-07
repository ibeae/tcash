package com.telkom.mwallet.tcash.purchase.p070a;

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
import com.telkom.mwallet.tcash.purchase.TCashPurchaseActivity;
import com.telkom.mwallet.view.Random2of6PinEditView;

public class C1949n extends C1925o {
    private static final String f5655b = C1947m.class.getSimpleName();
    TCashPurchaseActivity f5656a;
    private EditText f5657c;
    private Button f5658j;
    private TextView f5659k;
    private Random2of6PinEditView f5660l;
    private C1922f f5661m;
    private String f5662n;
    private OnClickListener f5663o = new C19481(this);

    class C19481 implements OnClickListener {
        final /* synthetic */ C1949n f5654a;

        C19481(C1949n c1949n) {
            this.f5654a = c1949n;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    if (this.f5654a.m7820d() && this.f5654a.f5660l.m8024c()) {
                        this.f5654a.f5656a.m7531a(this.f5654a.f5661m);
                        this.f5654a.f5656a.m7541j(this.f5654a.f5660l.getPin());
                        this.f5654a.f5656a.m7539f(this.f5654a.f5657c.getText().toString());
                        this.f5654a.f5656a.m7544p();
                        return;
                    }
                    return;
                case R.id.tcash_forget_pin_button:
                    this.f5654a.m5219p();
                    return;
                default:
                    return;
            }
        }
    }

    private void m7816b(View view) {
        this.f5657c = (EditText) view.findViewById(R.id.tcash_purchase_id_number_edit);
        this.f5658j = (Button) view.findViewById(R.id.tcash_confirm_button);
        this.f5659k = (TextView) view.findViewById(R.id.tcash_forget_pin_button);
        this.f5660l = (Random2of6PinEditView) view.findViewById(R.id.pin_edit_view);
        C1347a.m4910a().m4912a(this.f5660l.getPinViews());
        this.f5658j.setText(R.string.btn_next);
        this.f5658j.setOnClickListener(this.f5663o);
        this.f5659k.setOnClickListener(this.f5663o);
        mo1565b(this.f5662n);
        this.f5661m = new C1922f();
        this.f5661m.m7617b(getString(R.string.tcash_noti_purchase_merchant_msg));
        this.f5661m.m7623j(getString(R.string.merchant_number));
        this.f5657c.requestFocus();
        getActivity().getWindow().setSoftInputMode(4);
    }

    private boolean m7820d() {
        m7822e();
        if (!"".equals(this.f5657c.getText().toString().trim())) {
            return true;
        }
        this.f5657c.setBackgroundResource(R.drawable.field_sct_red);
        return false;
    }

    private void m7822e() {
        this.f5660l.m8023b();
        this.f5657c.setBackgroundResource(R.drawable.edittext_selector_n);
    }

    public void mo1565b(String str) {
        this.f5662n = str;
        if (this.f5657c != null) {
            this.f5657c.setText(str);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5656a = (TCashPurchaseActivity) getActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_purchase_templeate8, null);
        m5202a((ViewGroup) inflate);
        m7816b(inflate);
        return inflate;
    }
}
