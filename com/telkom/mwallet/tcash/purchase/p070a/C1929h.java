package com.telkom.mwallet.tcash.purchase.p070a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.skcc.wallet.framework.api.http.model.Denomination;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1509c;
import com.telkom.mwallet.dialog.p063a.C1496c;
import com.telkom.mwallet.p064a.C1347a;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.tcash.purchase.TCashPurchaseActivity;
import com.telkom.mwallet.view.Random2of6PinEditView;
import java.util.List;

public class C1929h extends C1925o {
    private static final String f5527b = C1929h.class.getSimpleName();
    TCashPurchaseActivity f5528a;
    private Button f5529c;
    private Button f5530j;
    private Button f5531k;
    private EditText f5532l;
    private TextView f5533m;
    private Random2of6PinEditView f5534n;
    private List<Denomination> f5535o = null;
    private Denomination f5536p = null;
    private C1509c f5537q;
    private String f5538r;
    private C1922f f5539s;
    private OnClickListener f5540t = new C19271(this);
    private C1496c f5541u = new C19282(this);

    class C19271 implements OnClickListener {
        final /* synthetic */ C1929h f5525a;

        C19271(C1929h c1929h) {
            this.f5525a = c1929h;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    if (this.f5525a.m7674e() && this.f5525a.f5534n.m8024c()) {
                        this.f5525a.f5528a.m7531a(this.f5525a.f5539s);
                        this.f5525a.f5528a.m7538e(this.f5525a.f5536p.getDenomId());
                        this.f5525a.f5528a.m7541j(this.f5525a.f5534n.getPin());
                        this.f5525a.f5528a.m7539f(this.f5525a.f5532l.getText().toString());
                        this.f5525a.f5528a.m7540g(this.f5525a.f5536p.getAmount() + "");
                        this.f5525a.f5528a.m7544p();
                        return;
                    }
                    return;
                case R.id.tcash_forget_pin_button:
                    this.f5525a.m5219p();
                    return;
                case R.id.tcash_purchase_denomination_button:
                case R.id.tcash_purchase_denomination_picker_button:
                    if (this.f5525a.f5535o != null) {
                        this.f5525a.f5537q = C1509c.m5636a((int) R.string.denomination);
                        this.f5525a.f5537q.m5639a(this.f5525a.f5541u);
                        this.f5525a.f5537q.m5640a(this.f5525a.f5535o);
                        this.f5525a.f5537q.show(this.f5525a.getFragmentManager(), "list_dialog_tag");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    class C19282 implements C1496c {
        final /* synthetic */ C1929h f5526a;

        C19282(C1929h c1929h) {
            this.f5526a = c1929h;
        }

        public void mo1548a(Denomination denomination) {
            this.f5526a.f5536p = denomination;
            this.f5526a.f5529c.setText(C1354g.m4957h("" + denomination.getAmount()));
            if (this.f5526a.f5537q != null) {
                this.f5526a.f5537q.dismiss();
            }
        }
    }

    private void m7670b(View view) {
        this.f5529c = (Button) view.findViewById(R.id.tcash_purchase_denomination_button);
        this.f5530j = (Button) view.findViewById(R.id.tcash_purchase_denomination_picker_button);
        this.f5531k = (Button) view.findViewById(R.id.tcash_confirm_button);
        this.f5532l = (EditText) view.findViewById(R.id.tcash_purchase_id_number_edit);
        this.f5533m = (TextView) view.findViewById(R.id.tcash_forget_pin_button);
        this.f5534n = (Random2of6PinEditView) view.findViewById(R.id.pin_edit_view);
        C1347a.m4910a().m4912a(this.f5534n.getPinViews());
        this.f5531k.setText(R.string.btn_next);
        this.f5531k.setOnClickListener(this.f5540t);
        this.f5529c.setOnClickListener(this.f5540t);
        this.f5530j.setOnClickListener(this.f5540t);
        this.f5533m.setOnClickListener(this.f5540t);
        mo1565b(this.f5538r);
        mo1563a(this.f5536p);
        m5216m().m4982d().m4932a(getActivity().getApplicationContext(), this.f5529c, 2);
        this.f5539s = new C1922f();
        this.f5539s.m7617b(getString(R.string.tcash_noti_purchase_multi_top_up_msg));
        this.f5539s.m7623j(getString(R.string.hint_mobile_number));
    }

    private void m7673d() {
        this.f5534n.m8023b();
        this.f5532l.setBackgroundResource(R.drawable.edittext_selector_n);
        this.f5529c.setBackgroundResource(R.drawable.edittext_selector_n);
    }

    private boolean m7674e() {
        m7673d();
        if ("".equals(this.f5532l.getText().toString().trim())) {
            this.f5532l.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if (this.f5536p != null && !"".equals(this.f5529c.getText().toString().trim())) {
            return true;
        } else {
            this.f5529c.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        }
    }

    public void mo1562a(long j) {
        if (this.f5535o != null) {
            for (Denomination denomination : this.f5535o) {
                if (j == denomination.getAmount()) {
                    this.f5541u.mo1548a(denomination);
                    return;
                }
            }
        }
    }

    public void mo1563a(Denomination denomination) {
        this.f5536p = denomination;
        if (this.f5529c != null && denomination != null) {
            this.f5541u.mo1548a(denomination);
        }
    }

    public void mo1564a(List<Denomination> list) {
        this.f5535o = list;
    }

    public void mo1565b(String str) {
        this.f5538r = str;
        if (this.f5532l != null) {
            this.f5532l.setText(str);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5528a = (TCashPurchaseActivity) getActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_purchase_templeate2, null);
        m5202a((ViewGroup) inflate);
        m7670b(inflate);
        return inflate;
    }
}
