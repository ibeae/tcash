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
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.tcash.payment.TCashKartuHaloActivity;
import com.telkom.mwallet.view.Random2of6PinEditView;

public class C1845d extends C1386e {
    private static final String f5066b = C1845d.class.getSimpleName();
    TCashKartuHaloActivity f5067a;
    private Button f5068c;
    private Button f5069j;
    private Button f5070k;
    private Button f5071l;
    private EditText f5072m;
    private EditText f5073n;
    private TextView f5074o;
    private TextView f5075p;
    private TextView f5076q;
    private Random2of6PinEditView f5077r;
    private String f5078s;
    private String f5079t;
    private OnClickListener f5080u = new C18441(this);

    class C18441 implements OnClickListener {
        final /* synthetic */ C1845d f5065a;

        C18441(C1845d c1845d) {
            this.f5065a = c1845d;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    if (!this.f5065a.m7230e() || !this.f5065a.f5077r.m8024c()) {
                        return;
                    }
                    if (C1354g.m4950b(this.f5065a.f5072m)) {
                        this.f5065a.f5067a.m7031f(this.f5065a.f5077r.getPin());
                        this.f5065a.f5067a.m7030e(this.f5065a.f5072m.getText().toString());
                        this.f5065a.f5067a.m7034p();
                        return;
                    }
                    this.f5065a.f5072m.requestFocus(this.f5065a.f5072m.length());
                    this.f5065a.f5072m.setBackgroundResource(R.drawable.field_sct_red);
                    return;
                case R.id.tcash_forget_pin_button:
                    this.f5065a.m5219p();
                    return;
                case R.id.tcash_kartu_halo_other_button:
                    this.f5065a.m7233g();
                    return;
                case R.id.tcash_kartu_halo_self_button:
                    this.f5065a.m7231f();
                    return;
                case R.id.tcash_mobilenum_picker_button:
                    this.f5065a.startActivityForResult(new Intent("android.intent.action.PICK", Phone.CONTENT_URI), C1358h.f2944o);
                    return;
                default:
                    return;
            }
        }
    }

    private void m7224b(View view) {
        this.f5068c = (Button) view.findViewById(R.id.tcash_confirm_button);
        this.f5069j = (Button) view.findViewById(R.id.tcash_mobilenum_picker_button);
        this.f5070k = (Button) view.findViewById(R.id.tcash_kartu_halo_self_button);
        this.f5071l = (Button) view.findViewById(R.id.tcash_kartu_halo_other_button);
        this.f5072m = (EditText) view.findViewById(R.id.tcash_kartu_halo_mobile_num_edittext);
        this.f5073n = (EditText) view.findViewById(R.id.tcash_name_edittext);
        this.f5074o = (TextView) view.findViewById(R.id.tcash_kartu_halo_self_txt);
        this.f5075p = (TextView) view.findViewById(R.id.tcash_kartu_halo_other_txt);
        this.f5076q = (TextView) view.findViewById(R.id.tcash_forget_pin_button);
        this.f5077r = (Random2of6PinEditView) view.findViewById(R.id.pin_edit_view);
        C1347a.m4910a().m4912a(this.f5077r.getPinViews());
        this.f5068c.setText(R.string.btn_next);
        this.f5068c.setOnClickListener(this.f5080u);
        this.f5069j.setOnClickListener(this.f5080u);
        this.f5070k.setOnClickListener(this.f5080u);
        this.f5071l.setOnClickListener(this.f5080u);
        this.f5076q.setOnClickListener(this.f5080u);
        if (this.f5079t != null) {
            if (this.f5078s.equals(this.f5079t)) {
                m7231f();
            } else {
                m7233g();
            }
            this.f5072m.setText(this.f5079t);
        } else {
            m7231f();
        }
        this.f5072m.requestFocus();
        getActivity().getWindow().setSoftInputMode(4);
    }

    private void m7228d() {
        this.f5077r.m8023b();
        this.f5072m.setBackgroundResource(R.drawable.edittext_selector_bottom);
    }

    private boolean m7230e() {
        m7228d();
        if (!"".equals(this.f5072m.getText().toString().trim())) {
            return true;
        }
        this.f5072m.requestFocus();
        this.f5072m.setBackgroundResource(R.drawable.field_sct_red);
        return false;
    }

    private void m7231f() {
        this.f5070k.setSelected(true);
        this.f5071l.setSelected(false);
        this.f5072m.setText(this.f5078s);
        this.f5072m.setEnabled(false);
        this.f5069j.setVisibility(8);
        this.f5074o.setTextColor(getResources().getColor(R.color.n_black));
        this.f5075p.setTextColor(getResources().getColor(R.color.n_darkgray));
    }

    private void m7233g() {
        this.f5071l.setSelected(true);
        this.f5070k.setSelected(false);
        this.f5072m.setText("");
        this.f5072m.setEnabled(true);
        this.f5069j.setVisibility(0);
        this.f5075p.setTextColor(getResources().getColor(R.color.n_black));
        this.f5074o.setTextColor(getResources().getColor(R.color.n_darkgray));
    }

    public void m7234b(String str) {
        this.f5079t = str;
        if (this.f5072m != null) {
            if (this.f5078s.equals(str)) {
                m7231f();
            } else {
                m7233g();
            }
            this.f5072m.setText(str);
        }
    }

    public void m7235c(String str) {
        this.f5078s = str;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == C1358h.f2944o && intent != null) {
            Cursor query = getActivity().getContentResolver().query(intent.getData(), null, null, null, null);
            if (query.moveToFirst()) {
                this.f5072m.setText(C1354g.m4960k(query.getString(query.getColumnIndex("data1"))));
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5067a = (TCashKartuHaloActivity) getActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_kartu_halo_first, null);
        m5202a((ViewGroup) inflate);
        m7224b(inflate);
        return inflate;
    }
}
