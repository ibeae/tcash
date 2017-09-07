package com.telkom.mwallet.tcash.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.skcc.wallet.framework.api.http.model.DataPackage;
import com.skcc.wallet.framework.api.http.model.Denomination;
import com.telkom.mwallet.R;
import com.telkom.mwallet.p064a.C1347a;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.tcash.TCashAirtimeActivity;
import com.telkom.mwallet.view.Random2of6PinEditView;

public class C1787c extends C1386e {
    private static final String f4662a = C1787c.class.getSimpleName();
    private TextView f4663b;
    private TextView f4664c;
    private TextView f4665j;
    private TextView f4666k;
    private TextView f4667l;
    private LinearLayout f4668m;
    private Random2of6PinEditView f4669n;
    private Button f4670o;
    private String f4671p;
    private String f4672q;
    private Denomination f4673r;
    private DataPackage f4674s;
    private String f4675t;
    private OnClickListener f4676u = new C17861(this);

    class C17861 implements OnClickListener {
        final /* synthetic */ C1787c f4661a;

        C17861(C1787c c1787c) {
            this.f4661a = c1787c;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    if (this.f4661a.f4669n.m8024c()) {
                        ((TCashAirtimeActivity) this.f4661a.getActivity()).m6554e(this.f4661a.f4669n.getPin());
                        return;
                    }
                    return;
                case R.id.tcash_forget_pin_button:
                    this.f4661a.m5219p();
                    return;
                default:
                    return;
            }
        }
    }

    private void m6857b(View view) {
        this.f4663b = (TextView) view.findViewById(R.id.tcash_noti_title_textview);
        this.f4664c = (TextView) view.findViewById(R.id.tcash_airtime_snd_number_textview);
        this.f4665j = (TextView) view.findViewById(R.id.tcash_airtime_snd_amount_textview);
        this.f4666k = (TextView) view.findViewById(R.id.tcash_fee_textview);
        this.f4667l = (TextView) view.findViewById(R.id.tcash_forget_pin_button);
        this.f4668m = (LinearLayout) view.findViewById(R.id.tcash_fee_layout);
        this.f4669n = (Random2of6PinEditView) view.findViewById(R.id.pin_edit_view);
        C1347a.m4910a().m4912a(this.f4669n.getPinViews());
        this.f4670o = (Button) view.findViewById(R.id.tcash_confirm_button);
        this.f4667l.setOnClickListener(this.f4676u);
        this.f4670o.setOnClickListener(this.f4676u);
        if ("AIRTIME".equals(this.f4671p)) {
            this.f4663b.setText(R.string.tcash_noti_airtime_title1);
        } else {
            this.f4663b.setText(R.string.tcash_noti_airtime_title2);
        }
        this.f4664c.setText(this.f4672q);
        m6859a(this.f4673r);
        m6858a(this.f4674s);
        m6862f(this.f4675t);
        m5216m().m4982d().m4932a(getActivity().getApplicationContext(), this.f4667l, 2);
    }

    public void m6858a(DataPackage dataPackage) {
        this.f4674s = dataPackage;
        if (this.f4665j != null && dataPackage != null) {
            this.f4665j.setText(C1354g.m4955f(String.valueOf(dataPackage.getDataCapacity())));
        }
    }

    public void m6859a(Denomination denomination) {
        this.f4673r = denomination;
        if (this.f4665j != null && this.f4673r != null) {
            this.f4665j.setText(C1354g.m4955f(String.valueOf(this.f4673r.getAmount())));
        }
    }

    public void m6860b(String str) {
        this.f4671p = str;
    }

    public void m6861c(String str) {
        this.f4672q = str;
    }

    public void m6862f(String str) {
        this.f4675t = str;
        if (this.f4666k == null) {
            return;
        }
        if (str == null || str.length() <= 0) {
            this.f4668m.setVisibility(8);
            return;
        }
        this.f4666k.setText(C1354g.m4955f(str));
        this.f4668m.setVisibility(0);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_airtime_second, null);
        m5202a((ViewGroup) inflate);
        m6857b(inflate);
        return inflate;
    }
}
