package com.telkom.mwallet.tcash.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.skcc.wallet.framework.api.http.model.DataPackage;
import com.skcc.wallet.framework.api.http.model.Denomination;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1506b;
import com.telkom.mwallet.dialog.C1509c;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.dialog.p063a.C1494a;
import com.telkom.mwallet.dialog.p063a.C1496c;
import com.telkom.mwallet.p064a.C1347a;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.p064a.C1358h;
import com.telkom.mwallet.tcash.TCashAirtimeActivity;
import java.util.List;

public class C1784a extends C1386e {
    private static final String f4629a = C1784a.class.getSimpleName();
    private static View f4630y = null;
    private C1506b f4631A;
    private String f4632B;
    private String f4633C;
    private String f4634D;
    private OnTouchListener f4635E = new C17791(this);
    private OnClickListener f4636F = new C17802(this);
    private C1496c f4637G = new C17813(this);
    private C1494a f4638H = new C17824(this);
    private C1326f f4639I = new C17835(this);
    private EditText f4640b;
    private Button f4641c;
    private Button f4642j;
    private EditText f4643k;
    private Button f4644l;
    private Button f4645m;
    private Button f4646n;
    private Button f4647o;
    private Button f4648p;
    private Button f4649q;
    private Button f4650r;
    private TextView f4651s;
    private TextView f4652t;
    private List<Denomination> f4653u = null;
    private List<DataPackage> f4654v = null;
    private Denomination f4655w = null;
    private DataPackage f4656x = null;
    private C1509c f4657z;

    class C17791 implements OnTouchListener {
        final /* synthetic */ C1784a f4624a;

        C17791(C1784a c1784a) {
            this.f4624a = c1784a;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                C1784a.f4630y = view;
                return false;
            } else if (motionEvent.getAction() != 1) {
                return false;
            } else {
                if (view.equals(C1784a.f4630y)) {
                    switch (view.getId()) {
                        case R.id.tcash_mobilenum_picker_button:
                            this.f4624a.startActivityForResult(new Intent("android.intent.action.PICK", Phone.CONTENT_URI), C1358h.f2944o);
                            break;
                        case R.id.tcash_airtime_denomination_button:
                        case R.id.tcash_airtime_denomination_picker_button:
                            if ("AIRTIME".equals(this.f4624a.f4632B)) {
                                if (this.f4624a.f4653u != null) {
                                    this.f4624a.f4657z = C1509c.m5636a((int) R.string.denomination);
                                    this.f4624a.f4657z.m5639a(this.f4624a.f4637G);
                                    this.f4624a.f4657z.m5640a(this.f4624a.f4653u);
                                    this.f4624a.f4657z.show(this.f4624a.getFragmentManager(), "list_dialog_tag");
                                    break;
                                }
                                return false;
                            } else if (this.f4624a.f4654v != null) {
                                this.f4624a.f4631A = C1506b.m5631a((int) R.string.msg_package);
                                this.f4624a.f4631A.m5634a(this.f4624a.f4638H);
                                this.f4624a.f4631A.m5635a(this.f4624a.f4654v);
                                this.f4624a.f4631A.show(this.f4624a.getFragmentManager(), "list_dialog_tag");
                                break;
                            } else {
                                return false;
                            }
                    }
                }
                C1784a.f4630y = null;
                return true;
            }
        }
    }

    class C17802 implements OnClickListener {
        final /* synthetic */ C1784a f4625a;

        C17802(C1784a c1784a) {
            this.f4625a = c1784a;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_airtime_next_button:
                    if (!this.f4625a.m6825f()) {
                        return;
                    }
                    if (C1354g.m4950b(this.f4625a.f4640b)) {
                        TCashAirtimeActivity tCashAirtimeActivity = (TCashAirtimeActivity) this.f4625a.getActivity();
                        tCashAirtimeActivity.m6555f(this.f4625a.f4632B);
                        tCashAirtimeActivity.m6548a(this.f4625a.f4655w);
                        tCashAirtimeActivity.m6547a(this.f4625a.f4656x);
                        tCashAirtimeActivity.m6556g(this.f4625a.f4640b.getText().toString());
                        if (this.f4625a.f4649q.isSelected()) {
                            String obj = this.f4625a.f4643k.getText().toString();
                            if (obj.isEmpty()) {
                                obj = this.f4625a.getString(R.string.hint_favorite_title);
                            }
                            tCashAirtimeActivity.m6557j(obj);
                        } else {
                            tCashAirtimeActivity.m6560q();
                        }
                        tCashAirtimeActivity.mo1505o();
                        return;
                    }
                    this.f4625a.f4640b.requestFocus(this.f4625a.f4640b.length());
                    this.f4625a.f4640b.setBackgroundResource(R.drawable.field_sct_red);
                    return;
                case R.id.tcash_airtime_other_button:
                    this.f4625a.m6833j();
                    this.f4625a.m6840q();
                    return;
                case R.id.tcash_airtime_self_button:
                    this.f4625a.m6830i();
                    this.f4625a.m6840q();
                    return;
                case R.id.tcash_airtime_set_favorite_button:
                    if (this.f4625a.f4649q.isSelected()) {
                        this.f4625a.f4649q.setSelected(false);
                        this.f4625a.f4643k.setVisibility(8);
                        return;
                    }
                    this.f4625a.f4649q.setSelected(true);
                    this.f4625a.f4643k.setText("");
                    this.f4625a.f4643k.setVisibility(0);
                    return;
                case R.id.tcash_airtime_menu_button:
                    if (!this.f4625a.f4644l.isSelected()) {
                        this.f4625a.m6827g();
                        return;
                    }
                    return;
                case R.id.tcash_data_menu_button:
                    if (!this.f4625a.f4645m.isSelected()) {
                        this.f4625a.f = this.f4625a.m5199a(this.f4625a.f4639I, R.string.tcash_menu_unavailable, false);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    class C17813 implements C1496c {
        final /* synthetic */ C1784a f4626a;

        C17813(C1784a c1784a) {
            this.f4626a = c1784a;
        }

        public void mo1548a(Denomination denomination) {
            this.f4626a.f4655w = denomination;
            this.f4626a.f4641c.setText(C1354g.m4957h("" + denomination.getAmount()));
            if (this.f4626a.f4657z != null) {
                this.f4626a.f4657z.dismiss();
            }
        }
    }

    class C17824 implements C1494a {
        final /* synthetic */ C1784a f4627a;

        C17824(C1784a c1784a) {
            this.f4627a = c1784a;
        }

        public void mo1549a(DataPackage dataPackage) {
            this.f4627a.f4656x = dataPackage;
            this.f4627a.f4641c.setText(dataPackage.getPackageName());
            if (this.f4627a.f4631A != null) {
                this.f4627a.f4631A.dismiss();
            }
        }
    }

    class C17835 implements C1326f {
        final /* synthetic */ C1784a f4628a;

        C17835(C1784a c1784a) {
            this.f4628a = c1784a;
        }

        public void mo1485a() {
            if (this.f4628a.f != null) {
                this.f4628a.f.dismiss();
            }
        }

        public void mo1486b() {
        }
    }

    private void m6819c(View view) {
        this.f4640b = (EditText) view.findViewById(R.id.tcash_airtime_mobile_num_edittext);
        this.f4648p = (Button) view.findViewById(R.id.tcash_mobilenum_picker_button);
        this.f4641c = (Button) view.findViewById(R.id.tcash_airtime_denomination_button);
        this.f4642j = (Button) view.findViewById(R.id.tcash_airtime_denomination_picker_button);
        this.f4643k = (EditText) view.findViewById(R.id.tcash_airtime_title_favorite_edittext);
        C1347a.m4910a().m4914a(this.f4643k);
        this.f4644l = (Button) view.findViewById(R.id.tcash_airtime_menu_button);
        this.f4645m = (Button) view.findViewById(R.id.tcash_data_menu_button);
        this.f4646n = (Button) view.findViewById(R.id.tcash_airtime_self_button);
        this.f4647o = (Button) view.findViewById(R.id.tcash_airtime_other_button);
        this.f4649q = (Button) view.findViewById(R.id.tcash_airtime_set_favorite_button);
        this.f4650r = (Button) view.findViewById(R.id.tcash_airtime_next_button);
        this.f4651s = (TextView) view.findViewById(R.id.tcash_airtime_self_txt);
        this.f4652t = (TextView) view.findViewById(R.id.tcash_airtime_other_txt);
        this.f4644l.setOnClickListener(this.f4636F);
        this.f4645m.setOnClickListener(this.f4636F);
        this.f4646n.setOnClickListener(this.f4636F);
        this.f4647o.setOnClickListener(this.f4636F);
        this.f4648p.setOnTouchListener(this.f4635E);
        this.f4649q.setOnClickListener(this.f4636F);
        this.f4650r.setOnClickListener(this.f4636F);
        this.f4641c.setOnTouchListener(this.f4635E);
        this.f4642j.setOnTouchListener(this.f4635E);
        if ("DATA".equals(this.f4632B)) {
            m6829h();
        } else {
            m6827g();
        }
        if (this.f4634D != null) {
            if (this.f4633C.equals(this.f4634D)) {
                m6830i();
            } else {
                m6833j();
            }
            this.f4640b.setText(this.f4634D);
        } else {
            m6830i();
        }
        m6849a(this.f4655w);
        m6848a(this.f4656x);
        m5216m().m4982d().m4932a(getActivity().getApplicationContext(), this.f4641c, 2);
    }

    private void m6823e() {
        this.f4640b.setBackgroundResource(R.drawable.edittext_selector_bottom);
        this.f4641c.setBackgroundResource(R.drawable.edittext_selector_n);
    }

    private boolean m6825f() {
        m6823e();
        if ("".equals(this.f4640b.getText().toString().trim())) {
            this.f4640b.requestFocus();
            this.f4640b.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if (!"".equals(this.f4641c.getText().toString().trim())) {
            return true;
        } else {
            this.f4641c.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        }
    }

    private void m6827g() {
        this.f4632B = "AIRTIME";
        this.f4644l.setSelected(true);
        this.f4644l.setTextColor(getResources().getColor(R.color.n_red));
        this.f4644l.setBackgroundResource(R.drawable.shape_btn_submenu_press);
        this.f4645m.setSelected(false);
        this.f4645m.setTextColor(getResources().getColor(R.color.n_darkgray));
        this.f4645m.setBackgroundResource(R.drawable.shape_btn_submenu);
        this.f4641c.setHint(R.string.denomination);
        m6830i();
        m6840q();
    }

    private void m6829h() {
        this.f4632B = "DATA";
        this.f4645m.setSelected(true);
        this.f4645m.setTextColor(getResources().getColor(R.color.n_red));
        this.f4645m.setBackgroundResource(R.drawable.shape_btn_submenu_press);
        this.f4644l.setSelected(false);
        this.f4644l.setTextColor(getResources().getColor(R.color.n_darkgray));
        this.f4644l.setBackgroundResource(R.drawable.shape_btn_submenu);
        this.f4641c.setHint(R.string.msg_package);
        m6830i();
        m6840q();
    }

    private void m6830i() {
        m6823e();
        this.f4646n.setSelected(true);
        this.f4647o.setSelected(false);
        this.f4640b.setText(this.f4633C);
        this.f4640b.setEnabled(false);
        this.f4648p.setVisibility(8);
        this.f4651s.setTextColor(getResources().getColor(R.color.n_black));
        this.f4652t.setTextColor(getResources().getColor(R.color.n_darkgray));
    }

    private void m6833j() {
        m6823e();
        this.f4647o.setSelected(true);
        this.f4646n.setSelected(false);
        this.f4640b.setText("");
        this.f4640b.setEnabled(true);
        this.f4648p.setVisibility(0);
        this.f4652t.setTextColor(getResources().getColor(R.color.n_black));
        this.f4651s.setTextColor(getResources().getColor(R.color.n_darkgray));
    }

    private void m6840q() {
        this.f4655w = null;
        this.f4656x = null;
        this.f4641c.setText("");
    }

    public void m6848a(DataPackage dataPackage) {
        this.f4656x = dataPackage;
        if (this.f4641c != null && dataPackage != null) {
            m6829h();
            this.f4638H.mo1549a(dataPackage);
        }
    }

    public void m6849a(Denomination denomination) {
        this.f4655w = denomination;
        if (this.f4641c != null && denomination != null) {
            m6827g();
            this.f4637G.mo1548a(denomination);
        }
    }

    public void m6850a(List<Denomination> list) {
        this.f4653u = list;
    }

    public void m6851b(String str) {
        this.f4634D = str;
        if (this.f4640b != null) {
            if (this.f4633C.equals(str)) {
                m6830i();
            } else {
                m6833j();
            }
            this.f4640b.setText(str);
        }
    }

    public void m6852b(List<DataPackage> list) {
        this.f4654v = list;
    }

    public void m6853c(String str) {
        this.f4633C = str;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == C1358h.f2944o && intent != null) {
            Cursor query = getActivity().getContentResolver().query(intent.getData(), null, null, null, null);
            if (query.moveToFirst()) {
                this.f4640b.setText(C1354g.m4960k(query.getString(query.getColumnIndex("data1"))));
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_airtime_first, null);
        m5202a((ViewGroup) inflate);
        m6819c(inflate);
        return inflate;
    }
}
