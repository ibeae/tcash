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
import com.skcc.wallet.framework.api.http.model.DataPackage;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1506b;
import com.telkom.mwallet.dialog.p063a.C1494a;
import com.telkom.mwallet.p064a.C1347a;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.p064a.C1358h;
import com.telkom.mwallet.tcash.purchase.TCashPurchaseActivity;
import com.telkom.mwallet.view.Random2of6PinEditView;
import java.util.List;

public class C1933i extends C1925o {
    private static final String f5545b = C1933i.class.getSimpleName();
    private static View f5546w = null;
    private C1922f f5547A;
    private OnTouchListener f5548B = new C19301(this);
    private OnClickListener f5549C = new C19312(this);
    private C1494a f5550D = new C19323(this);
    TCashPurchaseActivity f5551a;
    private Button f5552c;
    private Button f5553j;
    private Button f5554k;
    private Button f5555l;
    private Button f5556m;
    private Button f5557n;
    private EditText f5558o;
    private EditText f5559p;
    private TextView f5560q;
    private TextView f5561r;
    private TextView f5562s;
    private Random2of6PinEditView f5563t;
    private List<DataPackage> f5564u = null;
    private DataPackage f5565v = null;
    private C1506b f5566x;
    private String f5567y;
    private String f5568z;

    class C19301 implements OnTouchListener {
        final /* synthetic */ C1933i f5542a;

        C19301(C1933i c1933i) {
            this.f5542a = c1933i;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f5542a.f5564u == null) {
                return false;
            }
            if (motionEvent.getAction() == 0) {
                C1933i.f5546w = view;
                return false;
            } else if (motionEvent.getAction() != 1) {
                return false;
            } else {
                if (view.equals(C1933i.f5546w)) {
                    switch (view.getId()) {
                        case R.id.tcash_purchase_mobile_number_picker_button:
                            this.f5542a.startActivityForResult(new Intent("android.intent.action.PICK", Phone.CONTENT_URI), C1358h.f2944o);
                            break;
                        case R.id.tcash_purchase_package_button:
                        case R.id.tcash_purchase_package_picker_button:
                            this.f5542a.f5566x = C1506b.m5631a((int) R.string.msg_package);
                            this.f5542a.f5566x.m5634a(this.f5542a.f5550D);
                            this.f5542a.f5566x.m5635a(this.f5542a.f5564u);
                            this.f5542a.f5566x.show(this.f5542a.getFragmentManager(), "list_dialog_tag");
                            break;
                    }
                }
                C1933i.f5546w = null;
                return true;
            }
        }
    }

    class C19312 implements OnClickListener {
        final /* synthetic */ C1933i f5543a;

        C19312(C1933i c1933i) {
            this.f5543a = c1933i;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    if (!this.f5543a.m7698f()) {
                        return;
                    }
                    if (!C1354g.m4950b(this.f5543a.f5558o)) {
                        this.f5543a.f5558o.requestFocus(this.f5543a.f5558o.length());
                        this.f5543a.f5558o.setBackgroundResource(R.drawable.field_sct_red);
                        return;
                    } else if (this.f5543a.f5563t.m8024c()) {
                        this.f5543a.f5551a.m7531a(this.f5543a.f5547A);
                        this.f5543a.f5551a.m7538e(this.f5543a.f5565v.getPackageId());
                        this.f5543a.f5551a.m7541j(this.f5543a.f5563t.getPin());
                        this.f5543a.f5551a.m7539f(this.f5543a.f5558o.getText().toString());
                        this.f5543a.f5551a.m7540g(this.f5543a.f5565v.getDataCapacity() + "");
                        this.f5543a.f5551a.m7544p();
                        return;
                    } else {
                        return;
                    }
                case R.id.tcash_forget_pin_button:
                    this.f5543a.m5219p();
                    return;
                case R.id.tcash_purchase_other_button:
                    this.f5543a.m7701h();
                    this.f5543a.m7704i();
                    return;
                case R.id.tcash_purchase_self_button:
                    this.f5543a.m7699g();
                    this.f5543a.m7704i();
                    return;
                default:
                    return;
            }
        }
    }

    class C19323 implements C1494a {
        final /* synthetic */ C1933i f5544a;

        C19323(C1933i c1933i) {
            this.f5544a = c1933i;
        }

        public void mo1549a(DataPackage dataPackage) {
            this.f5544a.f5565v = dataPackage;
            this.f5544a.f5552c.setText(dataPackage.getPackageName());
            this.f5544a.f5559p.setText(dataPackage.getDataCapacity() + "");
            if (this.f5544a.f5566x != null) {
                this.f5544a.f5566x.dismiss();
            }
        }
    }

    private void m7692c(View view) {
        this.f5558o = (EditText) view.findViewById(R.id.tcash_purchase_mobile_number_edit);
        this.f5556m = (Button) view.findViewById(R.id.tcash_purchase_mobile_number_picker_button);
        this.f5552c = (Button) view.findViewById(R.id.tcash_purchase_package_button);
        this.f5553j = (Button) view.findViewById(R.id.tcash_purchase_package_picker_button);
        this.f5554k = (Button) view.findViewById(R.id.tcash_purchase_self_button);
        this.f5555l = (Button) view.findViewById(R.id.tcash_purchase_other_button);
        this.f5557n = (Button) view.findViewById(R.id.tcash_confirm_button);
        this.f5559p = (EditText) view.findViewById(R.id.tcash_amount_edittext);
        this.f5560q = (TextView) view.findViewById(R.id.tcash_purchase_self_txt);
        this.f5561r = (TextView) view.findViewById(R.id.tcash_purchase_other_txt);
        this.f5562s = (TextView) view.findViewById(R.id.tcash_forget_pin_button);
        this.f5563t = (Random2of6PinEditView) view.findViewById(R.id.pin_edit_view);
        C1347a.m4910a().m4912a(this.f5563t.getPinViews());
        this.f5557n.setText(R.string.btn_next);
        this.f5554k.setOnClickListener(this.f5549C);
        this.f5555l.setOnClickListener(this.f5549C);
        this.f5556m.setOnTouchListener(this.f5548B);
        this.f5557n.setOnClickListener(this.f5549C);
        this.f5562s.setOnClickListener(this.f5549C);
        this.f5552c.setOnTouchListener(this.f5548B);
        this.f5553j.setOnTouchListener(this.f5548B);
        mo1569f(this.f5568z);
        mo1567a(this.f5565v);
        m5216m().m4982d().m4932a(getActivity().getApplicationContext(), this.f5552c, 2);
        this.f5547A = new C1922f();
        this.f5547A.m7617b(getString(R.string.tcash_noti_purchase_digital_services_msg));
        this.f5547A.m7623j(getString(R.string.hint_mobile_number));
    }

    private void m7695e() {
        this.f5563t.m8023b();
        this.f5558o.setBackgroundResource(R.drawable.edittext_selector_middle);
        this.f5552c.setBackgroundResource(R.drawable.edittext_selector_middle);
    }

    private boolean m7698f() {
        m7695e();
        if ("".equals(this.f5558o.getText().toString().trim())) {
            this.f5558o.requestFocus();
            this.f5558o.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if (this.f5565v != null && !"".equals(this.f5552c.getText().toString().trim())) {
            return true;
        } else {
            this.f5552c.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        }
    }

    private void m7699g() {
        m7695e();
        this.f5554k.setSelected(true);
        this.f5555l.setSelected(false);
        this.f5558o.setText(this.f5567y);
        this.f5558o.setEnabled(false);
        this.f5559p.setText("");
        this.f5556m.setVisibility(8);
        this.f5560q.setTextColor(getResources().getColor(R.color.n_black));
        this.f5561r.setTextColor(getResources().getColor(R.color.n_darkgray));
    }

    private void m7701h() {
        m7695e();
        this.f5555l.setSelected(true);
        this.f5554k.setSelected(false);
        this.f5558o.setText("");
        this.f5558o.setEnabled(true);
        this.f5559p.setText("");
        this.f5556m.setVisibility(0);
        this.f5561r.setTextColor(getResources().getColor(R.color.n_black));
        this.f5560q.setTextColor(getResources().getColor(R.color.n_darkgray));
    }

    private void m7704i() {
        this.f5565v = null;
        this.f5552c.setText("");
    }

    public void mo1562a(long j) {
        if (this.f5564u != null) {
            for (DataPackage dataPackage : this.f5564u) {
                if (j == dataPackage.getDataCapacity()) {
                    this.f5550D.mo1549a(dataPackage);
                    return;
                }
            }
        }
    }

    public void mo1567a(DataPackage dataPackage) {
        this.f5565v = dataPackage;
        if (this.f5552c != null && dataPackage != null) {
            this.f5550D.mo1549a(dataPackage);
        }
    }

    public void mo1568b(List<DataPackage> list) {
        this.f5564u = list;
    }

    public void mo1569f(String str) {
        this.f5568z = str;
        if (this.f5558o != null && this.f5567y != null) {
            if (str == null || this.f5567y.equals(str)) {
                this.f5568z = this.f5567y;
                m7699g();
            } else {
                m7701h();
            }
            this.f5558o.setText(this.f5568z);
        }
    }

    public void mo1570g(String str) {
        this.f5567y = str;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == C1358h.f2944o && intent != null) {
            Cursor query = getActivity().getContentResolver().query(intent.getData(), null, null, null, null);
            if (query.moveToFirst()) {
                this.f5558o.setText(C1354g.m4960k(query.getString(query.getColumnIndex("data1"))));
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5551a = (TCashPurchaseActivity) getActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_purchase_templeate3, null);
        m5202a((ViewGroup) inflate);
        m7692c(inflate);
        return inflate;
    }
}
