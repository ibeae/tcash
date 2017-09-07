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
import com.telkom.mwallet.tcash.payment.TCashFixedLineActivity;
import com.telkom.mwallet.view.Random2of6PinEditView;

public class C1838a extends C1386e {
    private static final String f5000b = C1838a.class.getSimpleName();
    TCashFixedLineActivity f5001a;
    private Button f5002c;
    private EditText f5003j;
    private TextView f5004k;
    private Random2of6PinEditView f5005l;
    private String f5006m;
    private OnClickListener f5007n = new C18371(this);

    class C18371 implements OnClickListener {
        final /* synthetic */ C1838a f4999a;

        C18371(C1838a c1838a) {
            this.f4999a = c1838a;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    if (!this.f4999a.m7193e()) {
                        return;
                    }
                    if (!C1354g.m4950b(this.f4999a.f5003j)) {
                        this.f4999a.f5003j.requestFocus(this.f4999a.f5003j.length());
                        this.f4999a.f5003j.setBackgroundResource(R.drawable.field_sct_red);
                        return;
                    } else if (this.f4999a.f5005l.m8024c()) {
                        this.f4999a.f5001a.m6999f(this.f4999a.f5003j.getText().toString());
                        this.f4999a.f5001a.m7000g(this.f4999a.f5005l.getPin());
                        this.f4999a.f5001a.m7002p();
                        return;
                    } else {
                        return;
                    }
                case R.id.tcash_forget_pin_button:
                    this.f4999a.m5219p();
                    return;
                default:
                    return;
            }
        }
    }

    private void m7189b(View view) {
        this.f5002c = (Button) view.findViewById(R.id.tcash_confirm_button);
        this.f5003j = (EditText) view.findViewById(R.id.tcash_recipient_edittext);
        this.f5004k = (TextView) view.findViewById(R.id.tcash_forget_pin_button);
        this.f5005l = (Random2of6PinEditView) view.findViewById(R.id.pin_edit_view);
        C1347a.m4910a().m4912a(this.f5005l.getPinViews());
        this.f5002c.setText(R.string.btn_next);
        this.f5002c.setOnClickListener(this.f5007n);
        this.f5004k.setOnClickListener(this.f5007n);
        m7194b(this.f5006m);
        this.f5003j.requestFocus();
        getActivity().getWindow().setSoftInputMode(4);
    }

    private void m7191d() {
        this.f5005l.m8023b();
        this.f5003j.setBackgroundResource(R.drawable.edittext_selector_n);
    }

    private boolean m7193e() {
        m7191d();
        if (!"".equals(this.f5003j.getText().toString().trim())) {
            return true;
        }
        this.f5003j.requestFocus();
        this.f5003j.setBackgroundResource(R.drawable.field_sct_red);
        return false;
    }

    public void m7194b(String str) {
        this.f5006m = str;
        if (this.f5003j != null) {
            this.f5003j.setText(str);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5001a = (TCashFixedLineActivity) getActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_fixedline_first, null);
        m5202a((ViewGroup) inflate);
        m7189b(inflate);
        return inflate;
    }
}
