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

public class C1941l extends C1925o {
    private static final String f5608b = C1941l.class.getSimpleName();
    TCashPurchaseActivity f5609a;
    private Button f5610c;
    private EditText f5611j;
    private EditText f5612k;
    private TextView f5613l;
    private Random2of6PinEditView f5614m;
    private String f5615n;
    private long f5616o;
    private C1922f f5617p;
    private OnClickListener f5618q = new C19401(this);

    class C19401 implements OnClickListener {
        final /* synthetic */ C1941l f5607a;

        C19401(C1941l c1941l) {
            this.f5607a = c1941l;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    if (this.f5607a.m7762e() && this.f5607a.f5614m.m8024c()) {
                        this.f5607a.f5609a.m7531a(this.f5607a.f5617p);
                        this.f5607a.f5609a.m7541j(this.f5607a.f5614m.getPin());
                        this.f5607a.f5609a.m7539f(this.f5607a.f5611j.getText().toString());
                        this.f5607a.f5609a.m7540g(this.f5607a.f5612k.getText().toString());
                        this.f5607a.f5609a.m7544p();
                        return;
                    }
                    return;
                case R.id.tcash_forget_pin_button:
                    this.f5607a.m5219p();
                    return;
                default:
                    return;
            }
        }
    }

    private void m7756b(View view) {
        this.f5610c = (Button) view.findViewById(R.id.tcash_confirm_button);
        this.f5611j = (EditText) view.findViewById(R.id.tcash_purchase_id_number_edit);
        this.f5612k = (EditText) view.findViewById(R.id.tcash_amount_edittext);
        this.f5613l = (TextView) view.findViewById(R.id.tcash_forget_pin_button);
        this.f5614m = (Random2of6PinEditView) view.findViewById(R.id.pin_edit_view);
        C1347a.m4910a().m4912a(this.f5614m.getPinViews());
        this.f5610c.setText(R.string.btn_next);
        this.f5610c.setOnClickListener(this.f5618q);
        this.f5613l.setOnClickListener(this.f5618q);
        mo1565b(this.f5615n);
        mo1562a(this.f5616o);
        this.f5617p = new C1922f();
        this.f5617p.m7617b(getString(R.string.tcash_noti_purchase_merchant_msg));
        this.f5617p.m7623j(getString(R.string.merchant_number));
    }

    private void m7760d() {
        this.f5614m.m8023b();
        this.f5611j.setBackgroundResource(R.drawable.edittext_selector_n);
        this.f5612k.setBackgroundResource(R.drawable.edittext_selector_n);
    }

    private boolean m7762e() {
        m7760d();
        if ("".equals(this.f5611j.getText().toString().trim())) {
            this.f5611j.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if (!"".equals(this.f5612k.getText().toString().trim())) {
            return true;
        } else {
            this.f5612k.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        }
    }

    public void mo1562a(long j) {
        this.f5616o = j;
        if (this.f5612k != null && j > 0) {
            this.f5612k.setText(j + "");
        }
    }

    public void mo1565b(String str) {
        this.f5615n = str;
        if (this.f5611j != null) {
            this.f5611j.setText(str);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5609a = (TCashPurchaseActivity) getActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_purchase_templeate6, null);
        m5202a((ViewGroup) inflate);
        m7756b(inflate);
        return inflate;
    }
}
