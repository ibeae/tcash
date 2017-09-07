package com.telkom.mwallet.tcash.payment.p069a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.telkom.mwallet.R;
import com.telkom.mwallet.p064a.C1347a;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.tcash.payment.TCashPLNActivity;

public class C1867o extends C1386e {
    private static final String f5192a = C1867o.class.getSimpleName();
    private Button f5193b;
    private Button f5194c;
    private EditText f5195j;
    private TextView f5196k;
    private TextView f5197l;
    private TextView f5198m;
    private TextView f5199n;
    private TextView f5200o;
    private TextView f5201p;
    private String f5202q;
    private String f5203r;
    private String f5204s;
    private String f5205t;
    private String f5206u;
    private OnClickListener f5207v = new C18661(this);

    class C18661 implements OnClickListener {
        final /* synthetic */ C1867o f5191a;

        C18661(C1867o c1867o) {
            this.f5191a = c1867o;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_payment_confirm_button:
                    TCashPLNActivity tCashPLNActivity = (TCashPLNActivity) this.f5191a.getActivity();
                    if (this.f5191a.f5194c.isSelected()) {
                        String obj = this.f5191a.f5195j.getText().toString();
                        if (obj.isEmpty()) {
                            obj = this.f5191a.getString(R.string.hint_favorite_title);
                        }
                        tCashPLNActivity.m7133e(obj);
                    } else {
                        tCashPLNActivity.m7142s();
                    }
                    tCashPLNActivity.m7141r();
                    return;
                case R.id.tcash_set_favorite_button:
                    if (this.f5191a.f5194c.isSelected()) {
                        this.f5191a.f5194c.setSelected(false);
                        this.f5191a.f5195j.setVisibility(8);
                        return;
                    }
                    this.f5191a.f5194c.setSelected(true);
                    this.f5191a.f5195j.setText("");
                    this.f5191a.f5195j.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    private void m7323b(View view) {
        this.f5193b = (Button) view.findViewById(R.id.tcash_payment_confirm_button);
        this.f5194c = (Button) view.findViewById(R.id.tcash_set_favorite_button);
        this.f5195j = (EditText) view.findViewById(R.id.tcash_title_favorite_edittext);
        C1347a.m4910a().m4914a(this.f5195j);
        this.f5196k = (TextView) view.findViewById(R.id.tcash_noti_msg_textview);
        this.f5197l = (TextView) view.findViewById(R.id.tcash_noti_title_textview);
        this.f5198m = (TextView) view.findViewById(R.id.tcash_customerid_textview);
        this.f5199n = (TextView) view.findViewById(R.id.tcash_name_textview);
        this.f5200o = (TextView) view.findViewById(R.id.tcash_amount_textview);
        this.f5201p = (TextView) view.findViewById(R.id.tcash_fee_textview);
        this.f5194c.setOnClickListener(this.f5207v);
        this.f5193b.setOnClickListener(this.f5207v);
        if ("1220000".equals(this.f5202q)) {
            this.f5196k.setText(R.string.payment_noti_pln_msg1);
            this.f5197l.setText(R.string.payment_noti_pln_title1);
        } else {
            this.f5196k.setText(R.string.payment_noti_pln_msg2);
            this.f5197l.setText(R.string.payment_noti_pln_title2);
        }
        m7325c(this.f5203r);
        m7326f(this.f5204s);
        m7327g(this.f5205t);
        m7328h(this.f5206u);
    }

    public void m7324b(String str) {
        this.f5202q = str;
    }

    public void m7325c(String str) {
        this.f5203r = str;
        if (this.f5198m != null) {
            this.f5198m.setText(str);
        }
    }

    public void m7326f(String str) {
        this.f5204s = str;
        if (this.f5199n == null) {
            return;
        }
        if (this.f5204s != null) {
            this.f5199n.setText(this.f5204s);
        } else {
            ((LinearLayout) this.f5199n.getParent()).setVisibility(8);
        }
    }

    public void m7327g(String str) {
        this.f5205t = str;
        if (this.f5200o != null) {
            this.f5200o.setText(C1354g.m4955f(str));
        }
    }

    public void m7328h(String str) {
        this.f5206u = str;
        if (this.f5201p != null && str != null && str.length() > 0) {
            this.f5201p.setText(C1354g.m4955f(str));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_pln_second, null);
        m5202a((ViewGroup) inflate);
        m7323b(inflate);
        return inflate;
    }
}
