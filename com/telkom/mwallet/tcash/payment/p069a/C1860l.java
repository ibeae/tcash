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
import com.skcc.wallet.framework.api.http.model.Region;
import com.telkom.mwallet.R;
import com.telkom.mwallet.p064a.C1347a;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.tcash.payment.TCashPDAMActivity;

public class C1860l extends C1386e {
    private static final String f5150a = C1860l.class.getSimpleName();
    private Button f5151b;
    private Button f5152c;
    private EditText f5153j;
    private TextView f5154k;
    private TextView f5155l;
    private TextView f5156m;
    private TextView f5157n;
    private TextView f5158o;
    private String f5159p;
    private String f5160q;
    private String f5161r;
    private String f5162s;
    private Region f5163t;
    private OnClickListener f5164u = new C18591(this);

    class C18591 implements OnClickListener {
        final /* synthetic */ C1860l f5149a;

        C18591(C1860l c1860l) {
            this.f5149a = c1860l;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_payment_confirm_button:
                    TCashPDAMActivity tCashPDAMActivity = (TCashPDAMActivity) this.f5149a.getActivity();
                    if (this.f5149a.f5152c.isSelected()) {
                        String obj = this.f5149a.f5153j.getText().toString();
                        if (obj.isEmpty()) {
                            obj = this.f5149a.getString(R.string.hint_favorite_title);
                        }
                        tCashPDAMActivity.m7100e(obj);
                    } else {
                        tCashPDAMActivity.m7106r();
                    }
                    tCashPDAMActivity.m7105q();
                    return;
                case R.id.tcash_set_favorite_button:
                    if (this.f5149a.f5152c.isSelected()) {
                        this.f5149a.f5152c.setSelected(false);
                        this.f5149a.f5153j.setVisibility(8);
                        return;
                    }
                    this.f5149a.f5152c.setSelected(true);
                    this.f5149a.f5153j.setText("");
                    this.f5149a.f5153j.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    private void m7285b(View view) {
        this.f5151b = (Button) view.findViewById(R.id.tcash_payment_confirm_button);
        this.f5152c = (Button) view.findViewById(R.id.tcash_set_favorite_button);
        this.f5153j = (EditText) view.findViewById(R.id.tcash_title_favorite_edittext);
        C1347a.m4910a().m4914a(this.f5153j);
        this.f5154k = (TextView) view.findViewById(R.id.tcash_customerid_textview);
        this.f5155l = (TextView) view.findViewById(R.id.tcash_name_textview);
        this.f5156m = (TextView) view.findViewById(R.id.tcash_amount_textview);
        this.f5157n = (TextView) view.findViewById(R.id.tcash_fee_textview);
        this.f5158o = (TextView) view.findViewById(R.id.tcash_pdam_selected_area);
        this.f5151b.setOnClickListener(this.f5164u);
        this.f5152c.setOnClickListener(this.f5164u);
        m7286a(this.f5163t);
        m7287b(this.f5159p);
        m7288c(this.f5160q);
        m7290g(this.f5162s);
        m7289f(this.f5161r);
    }

    public void m7286a(Region region) {
        this.f5163t = region;
        if (this.f5158o != null && region != null) {
            this.f5158o.setText(getString(R.string.payment_noti_pdam_title) + " " + region.getRegionName());
        }
    }

    public void m7287b(String str) {
        this.f5159p = str;
        if (this.f5154k != null) {
            this.f5154k.setText(str);
        }
    }

    public void m7288c(String str) {
        this.f5160q = str;
        if (this.f5155l == null) {
            return;
        }
        if (this.f5160q != null) {
            this.f5155l.setText(this.f5160q);
        } else {
            ((LinearLayout) this.f5155l.getParent()).setVisibility(8);
        }
    }

    public void m7289f(String str) {
        this.f5161r = str;
        if (this.f5156m != null) {
            this.f5156m.setText(C1354g.m4955f(str));
        }
    }

    public void m7290g(String str) {
        this.f5162s = str;
        if (this.f5157n != null && str != null && str.length() > 0) {
            this.f5157n.setText(C1354g.m4955f(str));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_pdam_second, null);
        m5202a((ViewGroup) inflate);
        m7285b(inflate);
        return inflate;
    }
}
