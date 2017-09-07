package com.telkom.mwallet.tcash.payment.p069a;

import android.os.Bundle;
import android.util.Log;
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
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.tcash.payment.TCashPLNActivity;
import com.telkom.mwallet.view.Random2of6PinEditView;
import java.util.List;

public class C1864m extends C1386e {
    private static final String f5168b = C1864m.class.getSimpleName();
    private static View f5169q = null;
    TCashPLNActivity f5170a;
    private Button f5171c;
    private Button f5172j;
    private Button f5173k;
    private Button f5174l;
    private Button f5175m;
    private EditText f5176n;
    private TextView f5177o;
    private Random2of6PinEditView f5178p;
    private List<Denomination> f5179r = null;
    private C1509c f5180s;
    private Denomination f5181t = null;
    private String f5182u = null;
    private String f5183v = null;
    private String f5184w = null;
    private OnTouchListener f5185x = new C18611(this);
    private C1496c f5186y = new C18622(this);
    private OnClickListener f5187z = new C18633(this);

    class C18611 implements OnTouchListener {
        final /* synthetic */ C1864m f5165a;

        C18611(C1864m c1864m) {
            this.f5165a = c1864m;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                C1864m.f5169q = view;
                return false;
            } else if (motionEvent.getAction() != 1) {
                return false;
            } else {
                if (view.equals(C1864m.f5169q)) {
                    switch (view.getId()) {
                        case R.id.tcash_electricity_denomination_button:
                        case R.id.tcash_electricity_denomination_picker_button:
                            if (this.f5165a.f5179r != null) {
                                this.f5165a.f5180s = C1509c.m5636a((int) R.string.denomination);
                                this.f5165a.f5180s.m5639a(this.f5165a.f5186y);
                                this.f5165a.f5180s.m5640a(this.f5165a.f5179r);
                                this.f5165a.f5180s.show(this.f5165a.getFragmentManager(), "list_dialog_tag");
                                break;
                            }
                            return false;
                    }
                }
                C1864m.f5169q = null;
                return true;
            }
        }
    }

    class C18622 implements C1496c {
        final /* synthetic */ C1864m f5166a;

        C18622(C1864m c1864m) {
            this.f5166a = c1864m;
        }

        public void mo1548a(Denomination denomination) {
            Log.d("onPositiveClick", String.valueOf(denomination.getAmount()));
            this.f5166a.f5181t = denomination;
            this.f5166a.f5184w = String.valueOf(denomination.getAmount());
            this.f5166a.f5174l.setText(C1354g.m4957h("" + denomination.getAmount()));
            if (this.f5166a.f5180s != null) {
                this.f5166a.f5180s.dismiss();
            }
        }
    }

    class C18633 implements OnClickListener {
        final /* synthetic */ C1864m f5167a;

        C18633(C1864m c1864m) {
            this.f5167a = c1864m;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    if (this.f5167a.m7305f() && this.f5167a.f5178p.m8024c()) {
                        this.f5167a.f5170a.m7135g(this.f5167a.f5178p.getPin());
                        this.f5167a.f5170a.m7136j(this.f5167a.f5176n.getText().toString());
                        this.f5167a.f5170a.m7134f(this.f5167a.f5182u);
                        if (this.f5167a.f5171c.isSelected()) {
                            this.f5167a.f5170a.m7137k(this.f5167a.f5184w);
                        }
                        this.f5167a.f5170a.m7139p();
                        return;
                    }
                    return;
                case R.id.tcash_forget_pin_button:
                    this.f5167a.m5219p();
                    return;
                case R.id.tcash_pln_prepaid_menu_button:
                    if (!this.f5167a.f5171c.isSelected()) {
                        this.f5167a.m7307g();
                        return;
                    }
                    return;
                case R.id.tcash_pln_postpaid_menu_button:
                    if (!this.f5167a.f5172j.isSelected()) {
                        this.f5167a.m7308h();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void m7299c(View view) {
        this.f5171c = (Button) view.findViewById(R.id.tcash_pln_prepaid_menu_button);
        this.f5172j = (Button) view.findViewById(R.id.tcash_pln_postpaid_menu_button);
        this.f5176n = (EditText) view.findViewById(R.id.tcash_customerid_edittext);
        this.f5173k = (Button) view.findViewById(R.id.tcash_confirm_button);
        this.f5177o = (TextView) view.findViewById(R.id.tcash_forget_pin_button);
        this.f5178p = (Random2of6PinEditView) view.findViewById(R.id.pin_edit_view);
        C1347a.m4910a().m4912a(this.f5178p.getPinViews());
        this.f5173k.setText(R.string.btn_next);
        this.f5174l = (Button) view.findViewById(R.id.tcash_electricity_denomination_button);
        this.f5175m = (Button) view.findViewById(R.id.tcash_electricity_denomination_picker_button);
        this.f5171c.setOnClickListener(this.f5187z);
        this.f5172j.setOnClickListener(this.f5187z);
        this.f5173k.setOnClickListener(this.f5187z);
        this.f5177o.setOnClickListener(this.f5187z);
        this.f5174l.setOnTouchListener(this.f5185x);
        this.f5175m.setOnTouchListener(this.f5185x);
        if ("1210000".equals(this.f5182u)) {
            m7308h();
        } else {
            this.f5182u = "1220000";
            m7307g();
        }
        m7318c(this.f5183v);
        m7319f(this.f5184w);
        this.f5176n.requestFocus();
        getActivity().getWindow().setSoftInputMode(4);
    }

    private void m7303e() {
        this.f5178p.m8023b();
        this.f5176n.setBackgroundResource(R.drawable.edittext_selector_n);
        this.f5181t = null;
        this.f5174l.setText("");
    }

    private boolean m7305f() {
        m7303e();
        if ("".equals(this.f5176n.getText().toString().trim())) {
            this.f5176n.requestFocus();
            this.f5176n.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if (this.f5174l.getVisibility() != 0 || this.f5181t == null || (!"".equals(String.valueOf(this.f5181t.getAmount())) && 20000 <= Integer.parseInt(String.valueOf(this.f5181t.getAmount())))) {
            return true;
        } else {
            this.f5174l.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        }
    }

    private void m7307g() {
        this.f5182u = "1220000";
        this.f5174l.setVisibility(0);
        this.f5175m.setVisibility(0);
        this.f5171c.setSelected(true);
        this.f5171c.setTextColor(getResources().getColor(R.color.n_red));
        this.f5171c.setBackgroundResource(R.drawable.shape_btn_submenu_press);
        this.f5172j.setSelected(false);
        this.f5172j.setTextColor(getResources().getColor(R.color.n_darkgray));
        this.f5172j.setBackgroundResource(R.drawable.shape_btn_submenu);
        this.f5170a.m7134f("1220000");
        this.f5170a.m7140q();
    }

    private void m7308h() {
        this.f5182u = "1210000";
        this.f5174l.setVisibility(4);
        this.f5175m.setVisibility(4);
        this.f5172j.setSelected(true);
        this.f5172j.setTextColor(getResources().getColor(R.color.n_red));
        this.f5172j.setBackgroundResource(R.drawable.shape_btn_submenu_press);
        this.f5171c.setSelected(false);
        this.f5171c.setTextColor(getResources().getColor(R.color.n_darkgray));
        this.f5171c.setBackgroundResource(R.drawable.shape_btn_submenu);
    }

    public void m7316a(List<Denomination> list) {
        this.f5179r = list;
    }

    public void m7317b(String str) {
        this.f5182u = str;
    }

    public void m7318c(String str) {
        this.f5183v = str;
        if (this.f5176n != null) {
            this.f5176n.setText(str);
        }
    }

    public void m7319f(String str) {
        this.f5184w = str;
        if (this.f5181t != null && this.f5181t.getAmount() != 0) {
            if (str == null || str.isEmpty()) {
                m7308h();
                return;
            }
            this.f5174l.setText(C1354g.m4957h("" + str));
            m7307g();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5170a = (TCashPLNActivity) getActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_pln_first, null);
        m5202a((ViewGroup) inflate);
        m7299c(inflate);
        return inflate;
    }
}
