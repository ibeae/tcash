package com.telkom.mwallet.tcash.purchase.p070a;

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
import com.skcc.wallet.framework.api.http.model.Denomination;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1509c;
import com.telkom.mwallet.dialog.p063a.C1496c;
import com.telkom.mwallet.p064a.C1347a;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.p064a.C1358h;
import com.telkom.mwallet.tcash.purchase.TCashPurchaseActivity;
import com.telkom.mwallet.view.Random2of6PinEditView;
import java.util.List;

public class C1937j extends C1925o {
    private static final String f5572b = C1937j.class.getSimpleName();
    private static View f5573v = null;
    private OnTouchListener f5574A = new C19341(this);
    private OnClickListener f5575B = new C19352(this);
    private C1496c f5576C = new C19363(this);
    TCashPurchaseActivity f5577a;
    private Button f5578c;
    private Button f5579j;
    private Button f5580k;
    private Button f5581l;
    private Button f5582m;
    private Button f5583n;
    private EditText f5584o;
    private TextView f5585p;
    private TextView f5586q;
    private TextView f5587r;
    private Random2of6PinEditView f5588s;
    private List<Denomination> f5589t = null;
    private Denomination f5590u = null;
    private C1509c f5591w;
    private String f5592x;
    private String f5593y;
    private C1922f f5594z;

    class C19341 implements OnTouchListener {
        final /* synthetic */ C1937j f5569a;

        C19341(C1937j c1937j) {
            this.f5569a = c1937j;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f5569a.f5589t == null) {
                return false;
            }
            if (motionEvent.getAction() == 0) {
                C1937j.f5573v = view;
                return false;
            } else if (motionEvent.getAction() != 1) {
                return false;
            } else {
                if (view.equals(C1937j.f5573v)) {
                    switch (view.getId()) {
                        case R.id.tcash_purchase_denomination_button:
                        case R.id.tcash_purchase_denomination_picker_button:
                            this.f5569a.f5591w = C1509c.m5636a((int) R.string.denomination);
                            this.f5569a.f5591w.m5639a(this.f5569a.f5576C);
                            this.f5569a.f5591w.m5640a(this.f5569a.f5589t);
                            this.f5569a.f5591w.show(this.f5569a.getFragmentManager(), "list_dialog_tag");
                            break;
                        case R.id.tcash_purchase_mobile_number_picker_button:
                            this.f5569a.startActivityForResult(new Intent("android.intent.action.PICK", Phone.CONTENT_URI), C1358h.f2944o);
                            break;
                    }
                }
                C1937j.f5573v = null;
                return true;
            }
        }
    }

    class C19352 implements OnClickListener {
        final /* synthetic */ C1937j f5570a;

        C19352(C1937j c1937j) {
            this.f5570a = c1937j;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    if (this.f5570a.m7728f() && this.f5570a.f5588s.m8024c()) {
                        this.f5570a.f5577a.m7531a(this.f5570a.f5594z);
                        this.f5570a.f5577a.m7538e(this.f5570a.f5590u.getDenomId());
                        this.f5570a.f5577a.m7541j(this.f5570a.f5588s.getPin());
                        this.f5570a.f5577a.m7539f(this.f5570a.f5584o.getText().toString());
                        this.f5570a.f5577a.m7540g(this.f5570a.f5590u.getAmount() + "");
                        this.f5570a.f5577a.m7544p();
                        return;
                    }
                    return;
                case R.id.tcash_forget_pin_button:
                    this.f5570a.m5219p();
                    return;
                case R.id.tcash_purchase_other_button:
                    this.f5570a.m7731h();
                    this.f5570a.m7734i();
                    return;
                case R.id.tcash_purchase_self_button:
                    this.f5570a.m7729g();
                    this.f5570a.m7734i();
                    return;
                default:
                    return;
            }
        }
    }

    class C19363 implements C1496c {
        final /* synthetic */ C1937j f5571a;

        C19363(C1937j c1937j) {
            this.f5571a = c1937j;
        }

        public void mo1548a(Denomination denomination) {
            this.f5571a.f5590u = denomination;
            this.f5571a.f5578c.setText(C1354g.m4957h("" + denomination.getAmount()));
            if (this.f5571a.f5591w != null) {
                this.f5571a.f5591w.dismiss();
            }
        }
    }

    private void m7722c(View view) {
        this.f5583n = (Button) view.findViewById(R.id.tcash_purchase_mobile_number_picker_button);
        this.f5578c = (Button) view.findViewById(R.id.tcash_purchase_denomination_button);
        this.f5579j = (Button) view.findViewById(R.id.tcash_purchase_denomination_picker_button);
        this.f5581l = (Button) view.findViewById(R.id.tcash_purchase_self_button);
        this.f5582m = (Button) view.findViewById(R.id.tcash_purchase_other_button);
        this.f5580k = (Button) view.findViewById(R.id.tcash_confirm_button);
        this.f5584o = (EditText) view.findViewById(R.id.tcash_purchase_mobile_number_edit);
        this.f5585p = (TextView) view.findViewById(R.id.tcash_purchase_self_txt);
        this.f5586q = (TextView) view.findViewById(R.id.tcash_purchase_other_txt);
        this.f5587r = (TextView) view.findViewById(R.id.tcash_forget_pin_button);
        this.f5588s = (Random2of6PinEditView) view.findViewById(R.id.pin_edit_view);
        C1347a.m4910a().m4912a(this.f5588s.getPinViews());
        this.f5580k.setText(R.string.btn_next);
        this.f5581l.setOnClickListener(this.f5575B);
        this.f5582m.setOnClickListener(this.f5575B);
        this.f5583n.setOnTouchListener(this.f5574A);
        this.f5580k.setOnClickListener(this.f5575B);
        this.f5587r.setOnClickListener(this.f5575B);
        this.f5578c.setOnTouchListener(this.f5574A);
        this.f5579j.setOnTouchListener(this.f5574A);
        mo1569f(this.f5593y);
        mo1563a(this.f5590u);
        m5216m().m4982d().m4932a(getActivity().getApplicationContext(), this.f5578c, 2);
        this.f5594z = new C1922f();
        this.f5594z.m7617b(getString(R.string.tcash_noti_purchase_multi_top_up_msg));
        this.f5594z.m7623j(getString(R.string.hint_mobile_number));
    }

    private void m7725e() {
        this.f5588s.m8023b();
        this.f5584o.setBackgroundResource(R.drawable.edittext_selector_bottom);
        this.f5578c.setBackgroundResource(R.drawable.edittext_selector_n);
    }

    private boolean m7728f() {
        m7725e();
        if ("".equals(this.f5584o.getText().toString().trim())) {
            this.f5584o.requestFocus();
            this.f5584o.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if (!C1354g.m4950b(this.f5584o)) {
            this.f5584o.requestFocus(this.f5584o.length());
            this.f5584o.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if (this.f5590u != null && !"".equals(this.f5578c.getText().toString().trim())) {
            return true;
        } else {
            this.f5578c.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        }
    }

    private void m7729g() {
        m7725e();
        this.f5581l.setSelected(true);
        this.f5582m.setSelected(false);
        this.f5584o.setText(this.f5592x);
        this.f5584o.setEnabled(false);
        this.f5583n.setVisibility(8);
        this.f5585p.setTextColor(getResources().getColor(R.color.n_black));
        this.f5586q.setTextColor(getResources().getColor(R.color.n_darkgray));
    }

    private void m7731h() {
        m7725e();
        this.f5582m.setSelected(true);
        this.f5581l.setSelected(false);
        this.f5584o.setText("");
        this.f5584o.setEnabled(true);
        this.f5583n.setVisibility(0);
        this.f5586q.setTextColor(getResources().getColor(R.color.n_black));
        this.f5585p.setTextColor(getResources().getColor(R.color.n_darkgray));
    }

    private void m7734i() {
        this.f5590u = null;
        this.f5578c.setText("");
    }

    public void mo1562a(long j) {
        if (this.f5589t != null) {
            for (Denomination denomination : this.f5589t) {
                if (j == denomination.getAmount()) {
                    this.f5576C.mo1548a(denomination);
                    return;
                }
            }
        }
    }

    public void mo1563a(Denomination denomination) {
        this.f5590u = denomination;
        if (this.f5578c != null && denomination != null) {
            this.f5576C.mo1548a(denomination);
        }
    }

    public void mo1564a(List<Denomination> list) {
        this.f5589t = list;
    }

    public void mo1569f(String str) {
        this.f5593y = str;
        if (this.f5584o != null && this.f5592x != null) {
            if (str == null || this.f5592x.equals(str)) {
                this.f5593y = this.f5592x;
                m7729g();
            } else {
                m7731h();
            }
            this.f5584o.setText(this.f5593y);
        }
    }

    public void mo1570g(String str) {
        this.f5592x = str;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == C1358h.f2944o && intent != null) {
            Cursor query = getActivity().getContentResolver().query(intent.getData(), null, null, null, null);
            if (query.moveToFirst()) {
                this.f5584o.setText(C1354g.m4960k(query.getString(query.getColumnIndex("data1"))));
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5577a = (TCashPurchaseActivity) getActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_purchase_templeate4, null);
        m5202a((ViewGroup) inflate);
        m7722c(inflate);
        return inflate;
    }
}
