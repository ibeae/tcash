package com.telkom.mwallet.tcash.payment.p069a;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
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
import com.telkom.mwallet.p064a.C1358h;
import com.telkom.mwallet.tcash.payment.TCashPaymentTemplateActivity;
import com.telkom.mwallet.view.Random2of6PinEditView;

public class C1874r extends C1872q {
    private static final String f5225b = C1874r.class.getSimpleName();
    TCashPaymentTemplateActivity f5226a;
    private Button f5227c;
    private Button f5228j;
    private Button f5229k;
    private Button f5230l;
    private EditText f5231m;
    private EditText f5232n;
    private TextView f5233o;
    private TextView f5234p;
    private TextView f5235q;
    private Random2of6PinEditView f5236r;
    private String f5237s;
    private String f5238t;
    private OnClickListener f5239u = new C18731(this);

    class C18731 implements OnClickListener {
        final /* synthetic */ C1874r f5224a;

        C18731(C1874r c1874r) {
            this.f5224a = c1874r;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    if (!this.f5224a.m7350e() || !this.f5224a.f5236r.m8024c()) {
                        return;
                    }
                    if (C1354g.m4950b(this.f5224a.f5231m)) {
                        String string = this.f5224a.getString(R.string.payment_noti_kartu_msg);
                        String string2 = this.f5224a.getString(R.string.customerId_kartu);
                        this.f5224a.f5226a.m7179j(this.f5224a.f5236r.getPin());
                        this.f5224a.f5226a.m7178g(this.f5224a.f5231m.getText().toString());
                        this.f5224a.f5226a.m7172a(string, string2);
                        this.f5224a.f5226a.m7184q();
                        return;
                    }
                    this.f5224a.f5231m.requestFocus(this.f5224a.f5231m.length());
                    this.f5224a.f5231m.setBackgroundResource(R.drawable.field_sct_red);
                    return;
                case R.id.tcash_forget_pin_button:
                    this.f5224a.m5219p();
                    return;
                case R.id.tcash_mobilenum_picker_button:
                    this.f5224a.startActivityForResult(new Intent("android.intent.action.PICK", Phone.CONTENT_URI), C1358h.f2944o);
                    return;
                case R.id.tcash_template_other_button:
                    this.f5224a.m7353g();
                    return;
                case R.id.tcash_template_self_button:
                    this.f5224a.m7351f();
                    return;
                default:
                    return;
            }
        }
    }

    private void m7344b(View view) {
        this.f5227c = (Button) view.findViewById(R.id.tcash_confirm_button);
        this.f5228j = (Button) view.findViewById(R.id.tcash_mobilenum_picker_button);
        this.f5229k = (Button) view.findViewById(R.id.tcash_template_self_button);
        this.f5230l = (Button) view.findViewById(R.id.tcash_template_other_button);
        this.f5231m = (EditText) view.findViewById(R.id.tcash_template_mobile_num_edittext);
        this.f5232n = (EditText) view.findViewById(R.id.tcash_name_edittext);
        this.f5233o = (TextView) view.findViewById(R.id.tcash_template_self_txt);
        this.f5234p = (TextView) view.findViewById(R.id.tcash_template_other_txt);
        this.f5235q = (TextView) view.findViewById(R.id.tcash_forget_pin_button);
        this.f5236r = (Random2of6PinEditView) view.findViewById(R.id.pin_edit_view);
        C1347a.m4910a().m4912a(this.f5236r.getPinViews());
        this.f5227c.setText(R.string.btn_next);
        this.f5227c.setOnClickListener(this.f5239u);
        this.f5228j.setOnClickListener(this.f5239u);
        this.f5229k.setOnClickListener(this.f5239u);
        this.f5230l.setOnClickListener(this.f5239u);
        this.f5235q.setOnClickListener(this.f5239u);
        if (this.f5238t != null) {
            if (this.f5237s.equals(this.f5238t)) {
                m7351f();
            } else {
                m7353g();
            }
            this.f5231m.setText(this.f5238t);
        } else {
            m7351f();
        }
        this.f5231m.requestFocus();
        getActivity().getWindow().setSoftInputMode(4);
    }

    private void m7348d() {
        this.f5236r.m8023b();
        this.f5231m.setBackgroundResource(R.drawable.edittext_selector_bottom);
    }

    private boolean m7350e() {
        m7348d();
        if (!"".equals(this.f5231m.getText().toString().trim())) {
            return true;
        }
        this.f5231m.requestFocus();
        this.f5231m.setBackgroundResource(R.drawable.field_sct_red);
        return false;
    }

    private void m7351f() {
        this.f5229k.setSelected(true);
        this.f5230l.setSelected(false);
        this.f5231m.setText(this.f5237s);
        this.f5231m.setEnabled(false);
        this.f5228j.setVisibility(8);
        this.f5233o.setTextColor(getResources().getColor(R.color.n_black));
        this.f5234p.setTextColor(getResources().getColor(R.color.n_darkgray));
    }

    private void m7353g() {
        this.f5230l.setSelected(true);
        this.f5229k.setSelected(false);
        this.f5231m.setText("");
        this.f5231m.setEnabled(true);
        this.f5228j.setVisibility(0);
        this.f5234p.setTextColor(getResources().getColor(R.color.n_black));
        this.f5233o.setTextColor(getResources().getColor(R.color.n_darkgray));
    }

    public void mo1553c(String str) {
        this.f5237s = str;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == C1358h.f2944o && intent != null) {
            Cursor query = getActivity().getContentResolver().query(intent.getData(), null, null, null, null);
            if (query.moveToFirst()) {
                this.f5231m.setText(C1354g.m4960k(query.getString(query.getColumnIndex("data1"))));
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5226a = (TCashPaymentTemplateActivity) getActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_payment_template_first_1, null);
        this.h.m4934a(this.e, (ViewGroup) inflate, 2);
        m7344b(inflate);
        return inflate;
    }
}
