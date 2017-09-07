package com.telkom.mwallet.tcash.cash.p068a;

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
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.p064a.C1347a;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.p064a.C1358h;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import com.telkom.mwallet.tcash.cash.TCashInSMSBankingActivity;
import com.telkom.mwallet.tcash.fragment.C1386e;

public class C1767e extends C1386e {
    private static final String f4559a = C1767e.class.getSimpleName();
    private static View f4560u = null;
    private TCashInSMSBankingActivity f4561b;
    private EditText f4562c;
    private EditText f4563j;
    private EditText f4564k;
    private EditText f4565l;
    private Button f4566m;
    private Button f4567n;
    private Button f4568o;
    private Button f4569p;
    private Button f4570q;
    private TextView f4571r;
    private TextView f4572s;
    private String f4573t;
    private String f4574v;
    private String f4575w;
    private OnClickListener f4576x = new C17651(this);
    private C1326f f4577y = new C17662(this);

    class C17651 implements OnClickListener {
        final /* synthetic */ C1767e f4557a;

        C17651(C1767e c1767e) {
            this.f4557a = c1767e;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_mobilenum_picker_button:
                    this.f4557a.startActivityForResult(new Intent("android.intent.action.PICK", Phone.CONTENT_URI), C1358h.f2944o);
                    return;
                case R.id.tcash_sms_banking_other_button:
                    this.f4557a.m6783g();
                    return;
                case R.id.tcash_sms_banking_self_button:
                    this.f4557a.m6781f();
                    return;
                case R.id.tcash_sms_banking_set_favorite_button:
                    if (this.f4557a.f4569p.isSelected()) {
                        this.f4557a.f4569p.setSelected(false);
                        this.f4557a.f4564k.setVisibility(8);
                        return;
                    }
                    this.f4557a.f4569p.setSelected(true);
                    this.f4557a.f4564k.setText("");
                    this.f4557a.f4564k.setVisibility(0);
                    return;
                case R.id.tcash_sms_banking_snd_confirm_button:
                    if (this.f4557a.m6778e()) {
                        this.f4557a.f4561b.m6719f(this.f4557a.f4562c.getText().toString());
                        this.f4557a.f4561b.m6720g(this.f4557a.f4563j.getText().toString());
                        if (this.f4557a.f4565l.getVisibility() == 0) {
                            this.f4557a.f4561b.m6721j(this.f4557a.f4565l.getText().toString());
                        }
                        if (this.f4557a.f4569p.isSelected()) {
                            String obj = this.f4557a.f4564k.getText().toString();
                            if (obj.isEmpty()) {
                                obj = this.f4557a.getString(R.string.hint_favorite_title);
                            }
                            this.f4557a.f4561b.m6718e(obj);
                        } else {
                            this.f4557a.f4561b.m6724q();
                        }
                        this.f4557a.f4561b.mo1505o();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    class C17662 implements C1326f {
        final /* synthetic */ C1767e f4558a;

        C17662(C1767e c1767e) {
            this.f4558a = c1767e;
        }

        public void mo1485a() {
            if (this.f4558a.f != null) {
                this.f4558a.f.dismiss();
            }
        }

        public void mo1486b() {
        }
    }

    private void m6773b(View view) {
        this.f4562c = (EditText) view.findViewById(R.id.tcash_sms_banking_mobile_num_edittext);
        this.f4566m = (Button) view.findViewById(R.id.tcash_mobilenum_picker_button);
        this.f4565l = (EditText) view.findViewById(R.id.tcash_name_edittext);
        this.f4563j = (EditText) view.findViewById(R.id.tcash_sms_banking_amount_edittext);
        this.f4564k = (EditText) view.findViewById(R.id.tcash_sms_banking_title_favorite_edittext);
        C1347a.m4910a().m4914a(this.f4563j, this.f4564k);
        this.f4567n = (Button) view.findViewById(R.id.tcash_sms_banking_self_button);
        this.f4568o = (Button) view.findViewById(R.id.tcash_sms_banking_other_button);
        this.f4569p = (Button) view.findViewById(R.id.tcash_sms_banking_set_favorite_button);
        this.f4570q = (Button) view.findViewById(R.id.tcash_sms_banking_snd_confirm_button);
        this.f4571r = (TextView) view.findViewById(R.id.tcash_sms_banking_self_txt);
        this.f4572s = (TextView) view.findViewById(R.id.tcash_sms_banking_other_txt);
        this.f4567n.setOnClickListener(this.f4576x);
        this.f4568o.setOnClickListener(this.f4576x);
        this.f4566m.setOnClickListener(this.f4576x);
        this.f4569p.setOnClickListener(this.f4576x);
        this.f4570q.setOnClickListener(this.f4576x);
        if (this.f4574v != null) {
            m6789b(this.f4574v);
        } else if (this.f4573t != null) {
            m6789b(this.f4573t);
        } else {
            m6781f();
        }
        if (this.f4575w != null) {
            m6791f(this.f4575w);
        }
    }

    private void m6777d() {
        this.f4562c.setBackgroundResource(R.drawable.edittext_selector_middle);
        this.f4563j.setBackgroundResource(R.drawable.edittext_selector_n);
    }

    private boolean m6778e() {
        m6777d();
        if (!C1354g.m4950b(this.f4562c)) {
            this.f4562c.requestFocus();
            this.f4562c.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if (!"".equals(this.f4563j.getText().toString().trim())) {
            return true;
        } else {
            this.f4563j.requestFocus();
            this.f4563j.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        }
    }

    private void m6781f() {
        this.f4567n.setSelected(true);
        this.f4568o.setSelected(false);
        this.f4562c.setText(this.f4573t);
        this.f4562c.setEnabled(false);
        this.f4563j.setText("");
        this.f4563j.setEnabled(true);
        this.f4566m.setVisibility(8);
        this.f4565l.setVisibility(8);
        this.f4565l.setText(m6785h());
        this.f4571r.setTextColor(getResources().getColor(R.color.n_black));
        this.f4572s.setTextColor(getResources().getColor(R.color.n_darkgray));
    }

    private void m6783g() {
        this.f4568o.setSelected(true);
        this.f4567n.setSelected(false);
        this.f4562c.setText("");
        this.f4562c.setEnabled(true);
        this.f4563j.setText("");
        this.f4563j.setEnabled(true);
        this.f4566m.setVisibility(0);
        this.f4565l.setVisibility(8);
        this.f4572s.setTextColor(getResources().getColor(R.color.n_black));
        this.f4571r.setTextColor(getResources().getColor(R.color.n_darkgray));
    }

    private String m6785h() {
        if (this.e == null) {
            this.e = (SlidingFrameActivity) getActivity();
        }
        if (this.g == null) {
            this.g = this.e.m4984e();
        }
        return C1354g.m4961l(this.g.m4651b("user_info_firstname", "")) + " " + C1354g.m4961l(this.g.m4651b("user_info_lastname", ""));
    }

    public void m6789b(String str) {
        this.f4574v = C1354g.m4958i(str);
        if (this.f4562c != null) {
            if (this.f4573t.equals(this.f4574v)) {
                m6781f();
            } else {
                m6783g();
            }
            this.f4562c.setText(this.f4574v);
        }
    }

    public void m6790c(String str) {
        this.f4573t = C1354g.m4958i(str);
    }

    public void m6791f(String str) {
        this.f4575w = str;
        if (this.f4563j != null) {
            this.f4563j.setText(str);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == C1358h.f2944o && intent != null) {
            Cursor query = getActivity().getContentResolver().query(intent.getData(), null, null, null, null);
            if (query.moveToFirst()) {
                String string = query.getString(query.getColumnIndex("data1"));
                CharSequence string2 = query.getString(query.getColumnIndex("display_name"));
                this.f4562c.setText(C1354g.m4960k(string));
                if (string2 != null && !"".equals(string2)) {
                    this.f4565l.setVisibility(0);
                    this.f4565l.setText(string2);
                }
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f4561b = (TCashInSMSBankingActivity) m5216m();
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_cash_in_sms_banking_first, null);
        m5202a((ViewGroup) inflate);
        m6773b(inflate);
        return inflate;
    }
}
