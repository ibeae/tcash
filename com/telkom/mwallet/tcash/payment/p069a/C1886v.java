package com.telkom.mwallet.tcash.payment.p069a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.skcc.wallet.framework.api.http.model.Denomination;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1509c;
import com.telkom.mwallet.dialog.p063a.C1496c;
import com.telkom.mwallet.p064a.C1347a;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.tcash.payment.TCashPaymentTemplateActivity;
import com.telkom.mwallet.view.Random2of6PinEditView;
import java.util.List;

public class C1886v extends C1872q {
    private static final String f5286b = C1886v.class.getSimpleName();
    private static View f5287t = null;
    TCashPaymentTemplateActivity f5288a;
    private Button f5289c;
    private Button f5290j;
    private Button f5291k;
    private Button f5292l;
    private Button f5293m;
    private EditText f5294n;
    private TextView f5295o;
    private RelativeLayout f5296p;
    private Random2of6PinEditView f5297q;
    private List<Denomination> f5298r = null;
    private Denomination f5299s = null;
    private C1509c f5300u;
    private String f5301v = null;
    private OnTouchListener f5302w = new C18831(this);
    private OnClickListener f5303x = new C18842(this);
    private C1496c f5304y = new C18853(this);

    class C18831 implements OnTouchListener {
        final /* synthetic */ C1886v f5283a;

        C18831(C1886v c1886v) {
            this.f5283a = c1886v;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f5283a.f5298r == null) {
                return false;
            }
            if (motionEvent.getAction() == 0) {
                C1886v.f5287t = view;
                return false;
            } else if (motionEvent.getAction() != 1) {
                return false;
            } else {
                if (view.equals(C1886v.f5287t)) {
                    switch (view.getId()) {
                        case R.id.tcash_denomination_button:
                        case R.id.tcash_denomination_picker_button:
                            this.f5283a.f5300u = C1509c.m5636a((int) R.string.denomination);
                            this.f5283a.f5300u.m5639a(this.f5283a.f5304y);
                            this.f5283a.f5300u.m5640a(this.f5283a.f5298r);
                            this.f5283a.f5300u.show(this.f5283a.getFragmentManager(), "list_dialog_tag");
                            break;
                    }
                }
                C1886v.f5287t = null;
                return true;
            }
        }
    }

    class C18842 implements OnClickListener {
        final /* synthetic */ C1886v f5284a;

        C18842(C1886v c1886v) {
            this.f5284a = c1886v;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    if (this.f5284a.m7413f() && this.f5284a.f5297q.m8024c()) {
                        this.f5284a.f5288a.m7179j(this.f5284a.f5297q.getPin());
                        this.f5284a.f5288a.m7178g(this.f5284a.f5294n.getText().toString());
                        String str = "";
                        if (this.f5284a.f5289c.isSelected()) {
                            this.f5284a.f5288a.m7166a(this.f5284a.f5299s);
                            this.f5284a.f5288a.m7181l("PREPAID");
                        } else {
                            this.f5284a.f5288a.m7181l("POSTPAID");
                        }
                        this.f5284a.f5288a.m7172a(this.f5284a.getString(R.string.payment_noti_pln_msg2), this.f5284a.getString(R.string.pdam_id_no));
                        this.f5284a.f5288a.m7184q();
                        return;
                    }
                    return;
                case R.id.tcash_forget_pin_button:
                    this.f5284a.m5219p();
                    return;
                case R.id.tcash_template_postpaid_menu_button:
                    if (!this.f5284a.f5290j.isSelected()) {
                        this.f5284a.m7416h();
                        return;
                    }
                    return;
                case R.id.tcash_template_prepaid_menu_button:
                    if (!this.f5284a.f5289c.isSelected()) {
                        this.f5284a.m7414g();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    class C18853 implements C1496c {
        final /* synthetic */ C1886v f5285a;

        C18853(C1886v c1886v) {
            this.f5285a = c1886v;
        }

        public void mo1548a(Denomination denomination) {
            this.f5285a.f5299s = denomination;
            this.f5285a.f5291k.setText(C1354g.m4957h("" + denomination.getAmount()));
            if (this.f5285a.f5300u != null) {
                this.f5285a.f5300u.dismiss();
            }
        }
    }

    private void m7407c(View view) {
        this.f5289c = (Button) view.findViewById(R.id.tcash_template_prepaid_menu_button);
        this.f5290j = (Button) view.findViewById(R.id.tcash_template_postpaid_menu_button);
        this.f5291k = (Button) view.findViewById(R.id.tcash_denomination_button);
        this.f5292l = (Button) view.findViewById(R.id.tcash_denomination_picker_button);
        this.f5296p = (RelativeLayout) view.findViewById(R.id.tcash_denomination_layout);
        this.f5294n = (EditText) view.findViewById(R.id.tcash_customerid_edittext);
        this.f5293m = (Button) view.findViewById(R.id.tcash_confirm_button);
        this.f5295o = (TextView) view.findViewById(R.id.tcash_forget_pin_button);
        this.f5297q = (Random2of6PinEditView) view.findViewById(R.id.pin_edit_view);
        C1347a.m4910a().m4912a(this.f5297q.getPinViews());
        this.f5293m.setText(R.string.btn_next);
        this.f5291k.setOnTouchListener(this.f5302w);
        this.f5292l.setOnTouchListener(this.f5302w);
        this.f5289c.setOnClickListener(this.f5303x);
        this.f5290j.setOnClickListener(this.f5303x);
        this.f5293m.setOnClickListener(this.f5303x);
        this.f5295o.setOnClickListener(this.f5303x);
        mo1554b(this.f5301v);
        this.f5294n.requestFocus();
        getActivity().getWindow().setSoftInputMode(4);
    }

    private void m7410e() {
        this.f5297q.m8023b();
        this.f5294n.setBackgroundResource(R.drawable.edittext_selector_n);
        this.f5291k.setBackgroundResource(R.drawable.edittext_selector_n);
    }

    private boolean m7413f() {
        m7410e();
        if ("".equals(this.f5294n.getText().toString().trim())) {
            this.f5294n.requestFocus();
            this.f5294n.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if (!"".equals(this.f5291k.getText().toString().trim())) {
            return true;
        } else {
            this.f5291k.requestFocus();
            this.f5291k.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        }
    }

    private void m7414g() {
        this.f5296p.setVisibility(0);
        this.f5289c.setSelected(true);
        this.f5289c.setTextColor(getResources().getColor(R.color.n_red));
        this.f5289c.setBackgroundResource(R.drawable.shape_btn_submenu_press);
        this.f5290j.setSelected(false);
        this.f5290j.setTextColor(getResources().getColor(R.color.n_darkgray));
        this.f5290j.setBackgroundResource(R.drawable.shape_btn_submenu);
        this.h.m4932a(this.e, this.f5289c, 3);
        this.h.m4932a(this.e, this.f5290j, 2);
    }

    private void m7416h() {
        this.f5296p.setVisibility(4);
        this.f5290j.setSelected(true);
        this.f5290j.setTextColor(getResources().getColor(R.color.n_red));
        this.f5290j.setBackgroundResource(R.drawable.shape_btn_submenu_press);
        this.f5289c.setSelected(false);
        this.f5289c.setTextColor(getResources().getColor(R.color.n_darkgray));
        this.f5289c.setBackgroundResource(R.drawable.shape_btn_submenu);
        this.h.m4932a(this.e, this.f5289c, 2);
        this.h.m4932a(this.e, this.f5290j, 3);
    }

    public void mo1555a(long j) {
        if (this.f5296p != null) {
            m7414g();
            if (this.f5298r != null) {
                for (Denomination denomination : this.f5298r) {
                    if (j == denomination.getAmount()) {
                        this.f5304y.mo1548a(denomination);
                        return;
                    }
                }
                return;
            }
            return;
        }
        m7416h();
    }

    public void mo1556a(Denomination denomination) {
        this.f5299s = denomination;
        if (this.f5291k != null && denomination != null) {
            this.f5304y.mo1548a(denomination);
        }
    }

    public void mo1557a(List<Denomination> list) {
        this.f5298r = list;
    }

    public void mo1554b(String str) {
        this.f5301v = str;
        if (this.f5294n != null) {
            this.f5294n.setText(str);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5288a = (TCashPaymentTemplateActivity) getActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_payment_template_first_5, null);
        this.h.m4934a(this.e, (ViewGroup) inflate, 2);
        m7407c(inflate);
        return inflate;
    }
}
