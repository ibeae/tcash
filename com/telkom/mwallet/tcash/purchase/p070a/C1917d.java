package com.telkom.mwallet.tcash.purchase.p070a;

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
import com.telkom.mwallet.view.Random2of6PinEditView;

public class C1917d extends C1386e {
    private static final String f5468a = C1917d.class.getSimpleName();
    private String f5469A;
    private String f5470B;
    private String f5471C;
    private String f5472D;
    private String f5473E;
    private String f5474F;
    private C1915a f5475G;
    private OnClickListener f5476H = new C19191(this);
    protected Button f5477b;
    protected EditText f5478c;
    protected TextView f5479j;
    protected Random2of6PinEditView f5480k;
    private Button f5481l;
    private TextView f5482m;
    private TextView f5483n;
    private TextView f5484o;
    private TextView f5485p;
    private TextView f5486q;
    private TextView f5487r;
    private TextView f5488s;
    private TextView f5489t;
    private TextView f5490u;
    private TextView f5491v;
    private String f5492w;
    private String f5493x;
    private String f5494y;
    private String f5495z;

    protected interface C1915a {
        void mo1561a(View view);
    }

    class C19191 implements OnClickListener {
        final /* synthetic */ C1917d f5498a;

        C19191(C1917d c1917d) {
            this.f5498a = c1917d;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_forget_pin_button:
                    this.f5498a.m5219p();
                    return;
                case R.id.tcash_set_favorite_button:
                    if (this.f5498a.f5477b.isSelected()) {
                        this.f5498a.f5477b.setSelected(false);
                        this.f5498a.f5478c.setVisibility(8);
                        return;
                    }
                    this.f5498a.f5477b.setSelected(true);
                    this.f5498a.f5478c.setText("");
                    this.f5498a.f5478c.setVisibility(0);
                    return;
                default:
                    if (this.f5498a.f5475G != null) {
                        this.f5498a.f5475G.mo1561a(view);
                        return;
                    }
                    return;
            }
        }
    }

    private void m7615b(View view) {
        this.f5481l = (Button) view.findViewById(R.id.tcash_confirm_button);
        this.f5477b = (Button) view.findViewById(R.id.tcash_set_favorite_button);
        this.f5478c = (EditText) view.findViewById(R.id.tcash_title_favorite_edittext);
        this.f5482m = (TextView) view.findViewById(R.id.tcash_noti_msg_textview);
        this.f5483n = (TextView) view.findViewById(R.id.tcash_noti_title_textview);
        this.f5484o = (TextView) view.findViewById(R.id.tcash_purchase_content_id_txt);
        this.f5485p = (TextView) view.findViewById(R.id.tcash_purchase_content_name_txt);
        this.f5486q = (TextView) view.findViewById(R.id.tcash_purchase_content_amount_txt);
        this.f5487r = (TextView) view.findViewById(R.id.tcash_purchase_content_fee_txt);
        this.f5488s = (TextView) view.findViewById(R.id.tcash_purchase_label_id_txt);
        this.f5489t = (TextView) view.findViewById(R.id.tcash_purchase_label_name_txt);
        this.f5490u = (TextView) view.findViewById(R.id.tcash_purchase_label_amount_txt);
        this.f5491v = (TextView) view.findViewById(R.id.tcash_purchase_label_fee_txt);
        this.f5479j = (TextView) view.findViewById(R.id.tcash_forget_pin_button);
        this.f5480k = (Random2of6PinEditView) view.findViewById(R.id.pin_edit_view);
        C1347a.m4910a().m4913a(this.f5480k.getPinViews(), this.f5478c);
        this.f5481l.setOnClickListener(this.f5476H);
        this.f5477b.setOnClickListener(this.f5476H);
        this.f5479j.setOnClickListener(this.f5476H);
        m7617b(this.f5492w);
        m7618c(this.f5493x);
        m7619f(this.f5494y);
        m7623j(this.f5471C);
        m7620g(this.f5495z);
        m7624k(this.f5472D);
        m7621h(this.f5469A);
        m7625l(this.f5473E);
        m7622i(this.f5470B);
        m7626m(this.f5474F);
    }

    public void m7616a(C1915a c1915a) {
        this.f5475G = c1915a;
    }

    public void m7617b(String str) {
        this.f5492w = str;
        if (this.f5482m != null) {
            this.f5482m.setText(str);
        }
    }

    public void m7618c(String str) {
        this.f5493x = str;
        if (this.f5483n != null) {
            this.f5483n.setText(str);
        }
    }

    public void m7619f(String str) {
        this.f5494y = str;
        if (this.f5484o == null) {
            return;
        }
        if (str != null) {
            this.f5484o.setText(str);
        } else {
            ((LinearLayout) this.f5484o.getParent()).setVisibility(8);
        }
    }

    public void m7620g(String str) {
        this.f5495z = str;
        if (this.f5485p == null) {
            return;
        }
        if (this.f5495z != null) {
            this.f5485p.setText(this.f5495z);
        } else {
            ((LinearLayout) this.f5485p.getParent()).setVisibility(8);
        }
    }

    public void m7621h(String str) {
        this.f5469A = str;
        if (this.f5486q != null) {
            this.f5486q.setText(C1354g.m4955f(str));
        }
    }

    public void m7622i(String str) {
        this.f5470B = str;
        if (this.f5487r != null && str != null && str.length() > 0) {
            this.f5487r.setText(C1354g.m4955f(str));
        }
    }

    public void m7623j(String str) {
        this.f5471C = str;
        if (this.f5488s != null && str != null) {
            this.f5488s.setText(str);
        }
    }

    public void m7624k(String str) {
        this.f5472D = str;
        if (this.f5489t != null && str != null) {
            this.f5489t.setText(str);
        }
    }

    public void m7625l(String str) {
        this.f5473E = str;
        if (this.f5490u != null && str != null) {
            this.f5490u.setText(str);
        }
    }

    public void m7626m(String str) {
        this.f5474F = str;
        if (this.f5491v != null && str != null) {
            this.f5491v.setText(str);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_purchase_second, null);
        m5202a((ViewGroup) inflate);
        m7615b(inflate);
        return inflate;
    }
}
