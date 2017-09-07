package com.telkom.mwallet.tcash.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.skcc.wallet.framework.api.http.model.TransferType;
import com.telkom.mwallet.R;
import com.telkom.mwallet.p064a.C1347a;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.tcash.TCashTransferActivity;
import com.telkom.mwallet.view.Random2of6PinEditView;

public class C1818o extends C1386e {
    private static final String f4834b = C1818o.class.getSimpleName();
    private OnClickListener f4835A = new C18171(this);
    TCashTransferActivity f4836a;
    private TextView f4837c;
    private TextView f4838j;
    private TextView f4839k;
    private TextView f4840l;
    private TextView f4841m;
    private TextView f4842n;
    private TextView f4843o;
    private LinearLayout f4844p;
    private LinearLayout f4845q;
    private Random2of6PinEditView f4846r;
    private Button f4847s;
    private String f4848t = null;
    private String f4849u = null;
    private String f4850v = null;
    private String f4851w = null;
    private TransferType f4852x = null;
    private String f4853y = null;
    private String f4854z = null;

    class C18171 implements OnClickListener {
        final /* synthetic */ C1818o f4833a;

        C18171(C1818o c1818o) {
            this.f4833a = c1818o;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    if (this.f4833a.f4846r.m8024c()) {
                        this.f4833a.f4836a.m6640e(this.f4833a.f4846r.getPin());
                        return;
                    }
                    return;
                case R.id.tcash_forget_pin_button:
                    this.f4833a.m5219p();
                    return;
                default:
                    return;
            }
        }
    }

    private void m6967b(View view) {
        this.f4837c = (TextView) view.findViewById(R.id.tcash_transfer_type);
        this.f4838j = (TextView) view.findViewById(R.id.tcash_beneficiary_textview);
        this.f4839k = (TextView) view.findViewById(R.id.tcash_bankcode_textview);
        this.f4840l = (TextView) view.findViewById(R.id.tcash_amount_textview);
        this.f4843o = (TextView) view.findViewById(R.id.tcash_fee_textview);
        this.f4842n = (TextView) view.findViewById(R.id.tcash_comment_textview);
        this.f4844p = (LinearLayout) view.findViewById(R.id.tcash_fee_layout);
        this.f4845q = (LinearLayout) view.findViewById(R.id.tcash_bankcode_layout);
        this.f4846r = (Random2of6PinEditView) view.findViewById(R.id.pin_edit_view);
        C1347a.m4910a().m4912a(this.f4846r.getPinViews());
        this.f4841m = (TextView) view.findViewById(R.id.tcash_forget_pin_button);
        this.f4847s = (Button) view.findViewById(R.id.tcash_confirm_button);
        this.f4841m.setOnClickListener(this.f4835A);
        this.f4847s.setOnClickListener(this.f4835A);
        if ("4100000".equals(this.f4836a.m6649r())) {
            this.f4845q.setVisibility(8);
            this.f4837c.setText(R.string.noti_transfer_mobile);
        } else if ("4200000".equals(this.f4836a.m6649r())) {
            this.f4845q.setVisibility(0);
            this.f4839k.setText(this.f4849u);
            this.f4837c.setText(R.string.noti_transfer_bank);
        }
        this.f4841m.setText(R.string.tcash_forget_pin);
        this.f4838j.setText(this.f4850v);
        if (this.f4851w != null) {
            m6970f(this.f4851w);
        }
        m6972h(this.f4854z);
        m6971g(this.f4853y);
        m5216m().m4982d().m4932a(getActivity().getApplicationContext(), this.f4841m, 2);
    }

    public void m6968b(String str) {
        this.f4849u = str;
        if (this.f4838j != null) {
            this.f4838j.setText(str);
        }
    }

    public void m6969c(String str) {
        this.f4850v = str;
        if (this.f4838j != null) {
            this.f4838j.setText(str);
        }
    }

    public void m6970f(String str) {
        this.f4851w = str;
        if (this.f4840l != null) {
            this.f4840l.setText(C1354g.m4955f(str));
        }
    }

    public void m6971g(String str) {
        this.f4853y = str;
        if (this.f4842n == null) {
            return;
        }
        if (str == null || str.isEmpty()) {
            ((LinearLayout) this.f4842n.getParent()).setVisibility(8);
        } else {
            this.f4842n.setText(str);
        }
    }

    public void m6972h(String str) {
        this.f4854z = str;
        if (this.f4843o == null) {
            return;
        }
        if (str == null || str.length() <= 0) {
            this.f4844p.setVisibility(8);
            return;
        }
        this.f4843o.setText(C1354g.m4955f(str));
        this.f4844p.setVisibility(0);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f4836a = (TCashTransferActivity) getActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_transfer_second, null);
        m5202a((ViewGroup) inflate);
        m6967b(inflate);
        return inflate;
    }
}
