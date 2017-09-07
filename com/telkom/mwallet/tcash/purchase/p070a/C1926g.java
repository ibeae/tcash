package com.telkom.mwallet.tcash.purchase.p070a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.skcc.wallet.framework.api.http.model.Denomination;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1509c;
import com.telkom.mwallet.dialog.p063a.C1496c;
import com.telkom.mwallet.p064a.C1347a;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.tcash.purchase.TCashPurchaseActivity;
import com.telkom.mwallet.view.Random2of6PinEditView;
import java.util.List;

public class C1926g extends C1925o {
    private static final String f5510b = C1926g.class.getSimpleName();
    TCashPurchaseActivity f5511a;
    private Button f5512c;
    private Button f5513j;
    private Button f5514k;
    private TextView f5515l;
    private Random2of6PinEditView f5516m;
    private List<Denomination> f5517n = null;
    private Denomination f5518o = null;
    private C1509c f5519p;
    private String f5520q;
    private String f5521r;
    private C1922f f5522s;
    private OnClickListener f5523t = new C19231(this);
    private C1496c f5524u = new C19242(this);

    class C19231 implements OnClickListener {
        final /* synthetic */ C1926g f5508a;

        C19231(C1926g c1926g) {
            this.f5508a = c1926g;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    if (this.f5508a.m7652e() && this.f5508a.f5516m.m8024c()) {
                        this.f5508a.f5511a.m7531a(this.f5508a.f5522s);
                        this.f5508a.f5511a.m7538e(this.f5508a.f5521r);
                        this.f5508a.f5511a.m7541j(this.f5508a.f5516m.getPin());
                        this.f5508a.f5511a.m7539f(this.f5508a.f5520q);
                        this.f5508a.f5511a.m7540g(this.f5508a.f5518o.getAmount() + "");
                        this.f5508a.f5511a.m7544p();
                        return;
                    }
                    return;
                case R.id.tcash_forget_pin_button:
                    this.f5508a.m5219p();
                    return;
                case R.id.tcash_purchase_denomination_button:
                case R.id.tcash_purchase_denomination_picker_button:
                    if (this.f5508a.f5517n != null) {
                        this.f5508a.f5519p = C1509c.m5636a((int) R.string.denomination);
                        this.f5508a.f5519p.m5639a(this.f5508a.f5524u);
                        this.f5508a.f5519p.m5640a(this.f5508a.f5517n);
                        this.f5508a.f5519p.show(this.f5508a.getFragmentManager(), "list_dialog_tag");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    class C19242 implements C1496c {
        final /* synthetic */ C1926g f5509a;

        C19242(C1926g c1926g) {
            this.f5509a = c1926g;
        }

        public void mo1548a(Denomination denomination) {
            this.f5509a.f5518o = denomination;
            this.f5509a.f5512c.setText(C1354g.m4957h("" + denomination.getAmount()));
            if (this.f5509a.f5519p != null) {
                this.f5509a.f5519p.dismiss();
            }
        }
    }

    private void m7648b(View view) {
        this.f5512c = (Button) view.findViewById(R.id.tcash_purchase_denomination_button);
        this.f5513j = (Button) view.findViewById(R.id.tcash_purchase_denomination_picker_button);
        this.f5514k = (Button) view.findViewById(R.id.tcash_confirm_button);
        this.f5515l = (TextView) view.findViewById(R.id.tcash_forget_pin_button);
        this.f5516m = (Random2of6PinEditView) view.findViewById(R.id.pin_edit_view);
        C1347a.m4910a().m4912a(this.f5516m.getPinViews());
        this.f5514k.setText(R.string.btn_next);
        this.f5514k.setOnClickListener(this.f5523t);
        this.f5512c.setOnClickListener(this.f5523t);
        this.f5513j.setOnClickListener(this.f5523t);
        this.f5515l.setOnClickListener(this.f5523t);
        mo1563a(this.f5518o);
        m5216m().m4982d().m4932a(getActivity().getApplicationContext(), this.f5512c, 2);
        this.f5522s = new C1922f();
        this.f5522s.m7617b(getString(R.string.tcash_noti_purchase_multi_top_up_msg));
        this.f5522s.m7623j(getString(R.string.label_game_name));
    }

    private void m7651d() {
        this.f5516m.m8023b();
        this.f5512c.setBackgroundResource(R.drawable.edittext_selector_n);
    }

    private boolean m7652e() {
        m7651d();
        if (this.f5518o != null && !"".equals(this.f5512c.getText().toString().trim())) {
            return true;
        }
        this.f5512c.setBackgroundResource(R.drawable.field_sct_red);
        return false;
    }

    public void mo1562a(long j) {
        if (this.f5517n != null) {
            for (Denomination denomination : this.f5517n) {
                if (j == denomination.getAmount()) {
                    this.f5524u.mo1548a(denomination);
                    return;
                }
            }
        }
    }

    public void mo1563a(Denomination denomination) {
        this.f5518o = denomination;
        if (this.f5512c != null && denomination != null) {
            this.f5524u.mo1548a(denomination);
        }
    }

    public void mo1564a(List<Denomination> list) {
        this.f5517n = list;
    }

    public void mo1565b(String str) {
        this.f5520q = str;
    }

    public void mo1566c(String str) {
        this.f5521r = str;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5511a = (TCashPurchaseActivity) getActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_purchase_templeate1, null);
        m5202a((ViewGroup) inflate);
        m7648b(inflate);
        return inflate;
    }
}
