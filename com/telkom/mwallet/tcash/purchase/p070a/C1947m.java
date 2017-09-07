package com.telkom.mwallet.tcash.purchase.p070a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.skcc.wallet.framework.api.http.model.DataPackage;
import com.skcc.wallet.framework.api.http.model.TypeInsurance;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1506b;
import com.telkom.mwallet.dialog.C1518d.C1511a;
import com.telkom.mwallet.dialog.C1544k;
import com.telkom.mwallet.dialog.C1555n;
import com.telkom.mwallet.dialog.p063a.C1324e;
import com.telkom.mwallet.dialog.p063a.C1494a;
import com.telkom.mwallet.dialog.p063a.C1495b;
import com.telkom.mwallet.dialog.p063a.C1502k;
import com.telkom.mwallet.p064a.C1347a;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.tcash.purchase.TCashPurchaseActivity;
import java.util.Date;
import java.util.List;

public class C1947m extends C1925o {
    private static final String f5624b = C1947m.class.getSimpleName();
    private C1511a f5625A;
    private C1544k f5626B;
    private C1506b f5627C;
    private C1555n f5628D;
    private C1922f f5629E;
    private OnClickListener f5630F = new C19421(this);
    private C1494a f5631G = new C19432(this);
    private C1495b f5632H = new C19443(this);
    private C1324e f5633I = new C19454(this);
    private C1502k f5634J = new C19465(this);
    TCashPurchaseActivity f5635a;
    private Button f5636c;
    private Button f5637j;
    private Button f5638k;
    private Button f5639l;
    private Button f5640m;
    private EditText f5641n;
    private EditText f5642o;
    private EditText f5643p;
    private EditText f5644q;
    private int f5645r = 1980;
    private int f5646s = 1;
    private int f5647t = 1;
    private String f5648u = "";
    private String f5649v;
    private DataPackage f5650w;
    private List<DataPackage> f5651x = null;
    private TypeInsurance f5652y;
    private List<TypeInsurance> f5653z = null;

    class C19421 implements OnClickListener {
        final /* synthetic */ C1947m f5619a;

        C19421(C1947m c1947m) {
            this.f5619a = c1947m;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_insurance_city_button:
                    this.f5619a.f5626B = C1544k.m5697a((int) R.string.signup_hint_city);
                    this.f5619a.f5626B.m5699a(this.f5619a.f5633I);
                    this.f5619a.f5626B.show(this.f5619a.m5215l(), "list_dialog_tag");
                    return;
                case R.id.tcash_insurance_date_birth_button:
                    this.f5619a.f5625A = C1511a.m5642a(this.f5619a.f5645r, this.f5619a.f5646s, this.f5619a.f5647t);
                    this.f5619a.f5625A.m5645a(this.f5619a.f5632H);
                    this.f5619a.f5625A.m5644a(new Date().getTime());
                    this.f5619a.f5625A.show(this.f5619a.m5215l(), "date_dialog_tag");
                    return;
                case R.id.tcash_insurance_type_button:
                    this.f5619a.f5628D = C1555n.m5712a((int) R.string.msg_type_insurance);
                    this.f5619a.f5628D.m5715a(this.f5619a.f5634J);
                    this.f5619a.f5628D.m5716a(this.f5619a.f5653z);
                    this.f5619a.f5628D.show(this.f5619a.getFragmentManager(), "list_dialog_tag");
                    return;
                case R.id.tcash_package_button:
                    this.f5619a.f5627C = C1506b.m5631a((int) R.string.msg_package);
                    this.f5619a.f5627C.m5634a(this.f5619a.f5631G);
                    this.f5619a.f5627C.m5635a(this.f5619a.f5651x);
                    this.f5619a.f5627C.show(this.f5619a.getFragmentManager(), "list_dialog_tag");
                    return;
                case R.id.tcash_purchase_next_button:
                    if (this.f5619a.m7790e()) {
                        this.f5619a.f5635a.m7531a(this.f5619a.f5629E);
                        this.f5619a.f5635a.m7539f(this.f5619a.f5649v);
                        this.f5619a.f5635a.m7535a("insuranceType", this.f5619a.f5652y.getDataValue() + "");
                        this.f5619a.f5635a.m7535a("name", this.f5619a.f5641n.getText().toString());
                        this.f5619a.f5635a.m7535a("dateOfBirth", this.f5619a.f5637j.getText().toString());
                        this.f5619a.f5635a.m7535a("address", this.f5619a.f5643p.getText().toString());
                        this.f5619a.f5635a.m7535a("city", this.f5619a.f5638k.getText().toString());
                        this.f5619a.f5635a.m7535a("heirs", this.f5619a.f5644q.getText().toString());
                        this.f5619a.f5635a.m7535a("packageId", this.f5619a.f5650w.getDataCapacity() + "");
                        this.f5619a.f5635a.m7544p();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    class C19432 implements C1494a {
        final /* synthetic */ C1947m f5620a;

        C19432(C1947m c1947m) {
            this.f5620a = c1947m;
        }

        public void mo1549a(DataPackage dataPackage) {
            this.f5620a.f5650w = dataPackage;
            this.f5620a.f5639l.setText(this.f5620a.f5650w.getPackageName());
            if (this.f5620a.f5627C != null) {
                this.f5620a.f5627C.dismiss();
            }
        }
    }

    class C19443 implements C1495b {
        final /* synthetic */ C1947m f5621a;

        C19443(C1947m c1947m) {
            this.f5621a = c1947m;
        }

        public void mo1533a(int i, int i2, int i3) {
            if (this.f5621a.f5625A != null) {
                this.f5621a.f5625A.dismiss();
            }
            this.f5621a.f5645r = i;
            this.f5621a.f5646s = i2 + 1;
            this.f5621a.f5647t = i3;
            this.f5621a.f5648u = C1354g.m4944a(i, i2, i3);
            this.f5621a.f5637j.setText(this.f5621a.f5648u);
        }
    }

    class C19454 implements C1324e {
        final /* synthetic */ C1947m f5622a;

        C19454(C1947m c1947m) {
            this.f5622a = c1947m;
        }

        public void mo1483a(int i) {
        }

        public void mo1484a(String str) {
            this.f5622a.f5638k.setText(str.substring(0, str.indexOf(44)));
        }
    }

    class C19465 implements C1502k {
        final /* synthetic */ C1947m f5623a;

        C19465(C1947m c1947m) {
            this.f5623a = c1947m;
        }

        public void mo1571a(TypeInsurance typeInsurance) {
            this.f5623a.f5652y = typeInsurance;
            this.f5623a.f5636c.setText(this.f5623a.f5652y.getDataName());
            if (this.f5623a.f5628D != null) {
                this.f5623a.f5628D.dismiss();
            }
        }
    }

    private void m7784b(View view) {
        this.f5636c = (Button) view.findViewById(R.id.tcash_insurance_type_button);
        this.f5637j = (Button) view.findViewById(R.id.tcash_insurance_date_birth_button);
        this.f5638k = (Button) view.findViewById(R.id.tcash_insurance_city_button);
        this.f5639l = (Button) view.findViewById(R.id.tcash_package_button);
        this.f5640m = (Button) view.findViewById(R.id.tcash_purchase_next_button);
        this.f5641n = (EditText) view.findViewById(R.id.tcash_name_edittext);
        this.f5642o = (EditText) view.findViewById(R.id.tcash_purchase_id_number_edit);
        this.f5643p = (EditText) view.findViewById(R.id.tcash_insurance_address_edit);
        this.f5644q = (EditText) view.findViewById(R.id.tcash_insurance_heirs_edit);
        C1347a.m4910a().m4914a(this.f5644q);
        this.f5640m.setText(R.string.btn_next);
        this.f5636c.setOnClickListener(this.f5630F);
        this.f5637j.setOnClickListener(this.f5630F);
        this.f5638k.setOnClickListener(this.f5630F);
        this.f5639l.setOnClickListener(this.f5630F);
        this.f5640m.setOnClickListener(this.f5630F);
        this.f5629E = new C1922f();
        this.f5629E.m7617b(getString(R.string.tcash_noti_purchase_insurance_msg));
        this.f5629E.m7623j(getString(R.string.label_insurance_name));
        this.f5629E.m7624k(getString(R.string.msg_package));
        this.f5629E.m7631a(8);
        this.f5629E.m7632b(0);
    }

    private void m7788d() {
        this.f5636c.setBackgroundResource(R.drawable.edittext_selector_top);
        this.f5637j.setBackgroundResource(R.drawable.edittext_selector_middle);
        this.f5638k.setBackgroundResource(R.drawable.edittext_selector_middle);
        this.f5639l.setBackgroundResource(R.drawable.edittext_selector_middle);
        this.f5642o.setBackgroundResource(R.drawable.edittext_selector_middle);
    }

    private boolean m7790e() {
        m7788d();
        if ("".equals(this.f5636c.getText().toString().trim())) {
            this.f5636c.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if ("".equals(this.f5641n.getText().toString().trim())) {
            this.f5641n.requestFocus();
            this.f5641n.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if ("".equals(this.f5637j.getText().toString().trim())) {
            this.f5637j.requestFocus();
            this.f5637j.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if ("".equals(this.f5642o.getText().toString().trim())) {
            this.f5642o.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if ("".equals(this.f5643p.getText().toString().trim())) {
            this.f5643p.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if ("".equals(this.f5638k.getText().toString().trim())) {
            this.f5638k.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if (!"".equals(this.f5639l.getText().toString().trim())) {
            return true;
        } else {
            this.f5639l.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        }
    }

    public void mo1565b(String str) {
        this.f5649v = str;
    }

    public void mo1568b(List<DataPackage> list) {
        this.f5651x = list;
    }

    public void mo1572c(List<TypeInsurance> list) {
        this.f5653z = list;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5635a = (TCashPurchaseActivity) getActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_purchase_templeate7, null);
        m5202a((ViewGroup) inflate);
        m7784b(inflate);
        return inflate;
    }
}
