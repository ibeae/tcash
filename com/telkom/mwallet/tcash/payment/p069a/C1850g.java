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
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.tcash.payment.TCashOthersActivity;
import com.telkom.mwallet.view.Random2of6PinEditView;

public class C1850g extends C1386e {
    private static final String f5099b = C1850g.class.getSimpleName();
    TCashOthersActivity f5100a;
    private Button f5101c;
    private EditText f5102j;
    private EditText f5103k;
    private TextView f5104l;
    private Random2of6PinEditView f5105m;
    private String f5106n;
    private String f5107o;
    private OnClickListener f5108p = new C18491(this);

    class C18491 implements OnClickListener {
        final /* synthetic */ C1850g f5098a;

        C18491(C1850g c1850g) {
            this.f5098a = c1850g;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    if (this.f5098a.m7251e() && this.f5098a.f5105m.m8024c()) {
                        this.f5098a.f5100a.m7063e(this.f5098a.f5102j.getText().toString());
                        this.f5098a.f5100a.m7064f(this.f5098a.f5103k.getText().toString());
                        this.f5098a.f5100a.m7065g(this.f5098a.f5105m.getPin());
                        this.f5098a.f5100a.m7068p();
                        return;
                    }
                    return;
                case R.id.tcash_forget_pin_button:
                    this.f5098a.m5219p();
                    return;
                default:
                    return;
            }
        }
    }

    private void m7246b(View view) {
        this.f5101c = (Button) view.findViewById(R.id.tcash_confirm_button);
        this.f5102j = (EditText) view.findViewById(R.id.tcash_others_partner_code);
        this.f5103k = (EditText) view.findViewById(R.id.tcash_others_billing_code);
        this.f5105m = (Random2of6PinEditView) view.findViewById(R.id.pin_edit_view);
        C1347a.m4910a().m4912a(this.f5105m.getPinViews());
        this.f5104l = (TextView) view.findViewById(R.id.tcash_forget_pin_button);
        this.f5101c.setText(R.string.btn_next);
        this.f5101c.setOnClickListener(this.f5108p);
        this.f5104l.setOnClickListener(this.f5108p);
        m7252b(this.f5106n);
        m7253c(this.f5107o);
        this.f5102j.requestFocus();
        getActivity().getWindow().setSoftInputMode(4);
    }

    private void m7249d() {
        this.f5105m.m8023b();
        this.f5102j.setBackgroundResource(R.drawable.edittext_selector_n);
        this.f5103k.setBackgroundResource(R.drawable.edittext_selector_n);
    }

    private boolean m7251e() {
        m7249d();
        if ("".equals(this.f5102j.getText().toString().trim())) {
            this.f5102j.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if (!"".equals(this.f5103k.getText().toString().trim())) {
            return true;
        } else {
            this.f5103k.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        }
    }

    public void m7252b(String str) {
        this.f5106n = str;
        if (this.f5102j != null) {
            this.f5102j.setText(str);
        }
    }

    public void m7253c(String str) {
        this.f5107o = str;
        if (this.f5103k != null) {
            this.f5103k.setText(str);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5100a = (TCashOthersActivity) getActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_others_first, null);
        m5202a((ViewGroup) inflate);
        m7246b(inflate);
        return inflate;
    }

    public void onPause() {
        super.onPause();
        getActivity().getWindow().setSoftInputMode(2);
    }

    public void onResume() {
        super.onResume();
    }
}
