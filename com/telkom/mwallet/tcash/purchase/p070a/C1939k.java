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

public class C1939k extends C1925o {
    private static final String f5596b = C1939k.class.getSimpleName();
    TCashPurchaseActivity f5597a;
    private Button f5598c;
    private EditText f5599j;
    private EditText f5600k;
    private TextView f5601l;
    private Random2of6PinEditView f5602m;
    private String f5603n;
    private long f5604o;
    private C1922f f5605p;
    private OnClickListener f5606q = new C19381(this);

    class C19381 implements OnClickListener {
        final /* synthetic */ C1939k f5595a;

        C19381(C1939k c1939k) {
            this.f5595a = c1939k;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    if (this.f5595a.m7751e() && this.f5595a.f5602m.m8024c()) {
                        this.f5595a.f5597a.m7531a(this.f5595a.f5605p);
                        this.f5595a.f5597a.m7541j(this.f5595a.f5602m.getPin());
                        this.f5595a.f5597a.m7539f(this.f5595a.f5599j.getText().toString());
                        this.f5595a.f5597a.m7540g(this.f5595a.f5600k.getText().toString());
                        this.f5595a.f5597a.m7544p();
                        return;
                    }
                    return;
                case R.id.tcash_forget_pin_button:
                    this.f5595a.m5219p();
                    return;
                default:
                    return;
            }
        }
    }

    private void m7745b(View view) {
        this.f5598c = (Button) view.findViewById(R.id.tcash_confirm_button);
        this.f5599j = (EditText) view.findViewById(R.id.tcash_purchase_id_number_edit);
        this.f5600k = (EditText) view.findViewById(R.id.tcash_amount_edittext);
        this.f5601l = (TextView) view.findViewById(R.id.tcash_forget_pin_button);
        this.f5602m = (Random2of6PinEditView) view.findViewById(R.id.pin_edit_view);
        C1347a.m4910a().m4912a(this.f5602m.getPinViews());
        this.f5598c.setText(R.string.btn_next);
        this.f5598c.setOnClickListener(this.f5606q);
        this.f5601l.setOnClickListener(this.f5606q);
        mo1565b(this.f5603n);
        mo1562a(this.f5604o);
        this.f5605p = new C1922f();
        this.f5605p.m7617b(getString(R.string.tcash_noti_purchase_delivery_msg));
        this.f5605p.m7623j(getString(R.string.hint_mobile_number));
    }

    private void m7749d() {
        this.f5602m.m8023b();
        this.f5599j.setBackgroundResource(R.drawable.edittext_selector_n);
        this.f5600k.setBackgroundResource(R.drawable.edittext_selector_n);
    }

    private boolean m7751e() {
        m7749d();
        if ("".equals(this.f5599j.getText().toString().trim())) {
            this.f5599j.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if (!"".equals(this.f5600k.getText().toString().trim())) {
            return true;
        } else {
            this.f5600k.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        }
    }

    public void mo1562a(long j) {
        this.f5604o = j;
        if (this.f5600k != null && j > 0) {
            this.f5600k.setText(j + "");
        }
    }

    public void mo1565b(String str) {
        this.f5603n = str;
        if (this.f5599j != null) {
            this.f5599j.setText(str);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5597a = (TCashPurchaseActivity) getActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_purchase_templeate5, null);
        m5202a((ViewGroup) inflate);
        m7745b(inflate);
        return inflate;
    }
}
