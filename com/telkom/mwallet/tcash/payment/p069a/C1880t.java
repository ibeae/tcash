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

public class C1880t extends C1872q {
    private static final String f5257b = C1880t.class.getSimpleName();
    private static View f5258q = null;
    TCashPaymentTemplateActivity f5259a;
    private Button f5260c;
    private Button f5261j;
    private Button f5262k;
    private EditText f5263l;
    private TextView f5264m;
    private Random2of6PinEditView f5265n;
    private List<Denomination> f5266o = null;
    private Denomination f5267p = null;
    private C1509c f5268r;
    private String f5269s;
    private OnTouchListener f5270t = new C18771(this);
    private OnClickListener f5271u = new C18782(this);
    private C1496c f5272v = new C18793(this);

    class C18771 implements OnTouchListener {
        final /* synthetic */ C1880t f5254a;

        C18771(C1880t c1880t) {
            this.f5254a = c1880t;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f5254a.f5266o == null) {
                return false;
            }
            if (motionEvent.getAction() == 0) {
                C1880t.f5258q = view;
                return false;
            } else if (motionEvent.getAction() != 1) {
                return false;
            } else {
                if (view.equals(C1880t.f5258q)) {
                    switch (view.getId()) {
                        case R.id.tcash_denomination_button:
                        case R.id.tcash_denomination_picker_button:
                            this.f5254a.f5268r = C1509c.m5636a((int) R.string.denomination);
                            this.f5254a.f5268r.m5639a(this.f5254a.f5272v);
                            this.f5254a.f5268r.m5640a(this.f5254a.f5266o);
                            this.f5254a.f5268r.show(this.f5254a.getFragmentManager(), "list_dialog_tag");
                            break;
                    }
                }
                C1880t.f5258q = null;
                return true;
            }
        }
    }

    class C18782 implements OnClickListener {
        final /* synthetic */ C1880t f5255a;

        C18782(C1880t c1880t) {
            this.f5255a = c1880t;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    if (this.f5255a.m7384f() && this.f5255a.f5265n.m8024c()) {
                        this.f5255a.f5259a.m7178g(this.f5255a.f5263l.getText().toString());
                        this.f5255a.f5259a.m7166a(this.f5255a.f5267p);
                        this.f5255a.f5259a.m7179j(this.f5255a.f5265n.getPin());
                        this.f5255a.f5259a.m7172a(this.f5255a.getString(R.string.payment_noti_cable_tv_msg2), this.f5255a.getString(R.string.pdam_id_no));
                        this.f5255a.f5259a.m7184q();
                        return;
                    }
                    return;
                case R.id.tcash_forget_pin_button:
                    this.f5255a.m5219p();
                    return;
                default:
                    return;
            }
        }
    }

    class C18793 implements C1496c {
        final /* synthetic */ C1880t f5256a;

        C18793(C1880t c1880t) {
            this.f5256a = c1880t;
        }

        public void mo1548a(Denomination denomination) {
            this.f5256a.f5267p = denomination;
            this.f5256a.f5260c.setText(C1354g.m4957h("" + denomination.getAmount()));
            if (this.f5256a.f5268r != null) {
                this.f5256a.f5268r.dismiss();
            }
        }
    }

    private void m7378c(View view) {
        this.f5260c = (Button) view.findViewById(R.id.tcash_denomination_button);
        this.f5261j = (Button) view.findViewById(R.id.tcash_denomination_picker_button);
        this.f5263l = (EditText) view.findViewById(R.id.tcash_payment_id_number);
        this.f5262k = (Button) view.findViewById(R.id.tcash_confirm_button);
        this.f5264m = (TextView) view.findViewById(R.id.tcash_forget_pin_button);
        this.f5265n = (Random2of6PinEditView) view.findViewById(R.id.pin_edit_view);
        C1347a.m4910a().m4912a(this.f5265n.getPinViews());
        this.f5262k.setText(R.string.btn_next);
        this.f5260c.setOnTouchListener(this.f5270t);
        this.f5261j.setOnTouchListener(this.f5270t);
        this.f5262k.setOnClickListener(this.f5271u);
        this.f5264m.setOnClickListener(this.f5271u);
        mo1554b(this.f5269s);
        mo1556a(this.f5267p);
        this.f5263l.requestFocus();
        getActivity().getWindow().setSoftInputMode(4);
    }

    private void m7382e() {
        this.f5265n.m8023b();
        this.f5263l.setBackgroundResource(R.drawable.edittext_selector_n);
        this.f5260c.setBackgroundResource(R.drawable.edittext_selector_n);
    }

    private boolean m7384f() {
        m7382e();
        if ("".equals(this.f5263l.getText().toString().trim())) {
            this.f5263l.requestFocus();
            this.f5263l.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if (!"".equals(this.f5260c.getText().toString().trim())) {
            return true;
        } else {
            this.f5260c.requestFocus();
            this.f5260c.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        }
    }

    public void mo1555a(long j) {
        if (this.f5266o != null) {
            for (Denomination denomination : this.f5266o) {
                if (j == denomination.getAmount()) {
                    this.f5272v.mo1548a(denomination);
                    return;
                }
            }
        }
    }

    public void mo1556a(Denomination denomination) {
        this.f5267p = denomination;
        if (this.f5260c != null && denomination != null) {
            this.f5272v.mo1548a(denomination);
        }
    }

    public void mo1557a(List<Denomination> list) {
        this.f5266o = list;
    }

    public void mo1554b(String str) {
        this.f5269s = str;
        if (this.f5263l != null) {
            this.f5263l.setText(str);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5259a = (TCashPaymentTemplateActivity) getActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_payment_template_first_3, null);
        this.h.m4934a(this.e, (ViewGroup) inflate, 2);
        m7378c(inflate);
        return inflate;
    }
}
