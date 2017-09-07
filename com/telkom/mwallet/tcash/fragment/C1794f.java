package com.telkom.mwallet.tcash.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.home.C1385b;
import com.telkom.mwallet.p064a.C1358h;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import com.telkom.mwallet.tcash.TCashActivity;
import com.telkom.mwallet.tcash.TCashAirtimeActivity;
import com.telkom.mwallet.tcash.TCashTransactionHistoryActivity;
import com.telkom.mwallet.tcash.TCashTransferActivity;
import com.telkom.mwallet.tcash.cash.p068a.C1772h;
import com.telkom.mwallet.view.BalanceView;

public class C1794f extends C1385b {
    public static final String f4683a = C1794f.class.getSimpleName();
    private FragmentManager f4684b;
    private BalanceView f4685c;
    private TextView f4686j;
    private TextView f4687k;
    private TextView f4688l;
    private RelativeLayout f4689m;
    private RelativeLayout f4690n;
    private RelativeLayout f4691o;
    private RelativeLayout f4692p;
    private RelativeLayout f4693q;
    private RelativeLayout f4694r;
    private String f4695s = null;
    private String f4696t = null;
    private TCashActivity f4697u;
    private OnClickListener f4698v = new C17911(this);
    private C1326f f4699w = new C17922(this);
    private C1326f f4700x = new C17933(this);

    class C17911 implements OnClickListener {
        final /* synthetic */ C1794f f4680a;

        C17911(C1794f c1794f) {
            this.f4680a = c1794f;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_airtime_purchase_button:
                    this.f4680a.startActivity(new Intent(this.f4680a.e, TCashAirtimeActivity.class));
                    return;
                case R.id.tcash_cash_in_out_button:
                    C1772h c1772h = new C1772h();
                    c1772h.m6798a(this.f4680a.e.getApplication());
                    c1772h.setStyle(0, R.style.tcash_menu_dialog);
                    c1772h.show(this.f4680a.f4684b, null);
                    return;
                case R.id.tcash_payment_button:
                    C1797h c1797h = new C1797h();
                    c1797h.m6897a(this.f4680a.e.getApplication());
                    c1797h.setStyle(0, R.style.tcash_menu_dialog);
                    c1797h.show(this.f4680a.f4684b, null);
                    return;
                case R.id.tcash_retail_purchase_button:
                    C1799i c1799i = new C1799i();
                    c1799i.setStyle(0, R.style.tcash_menu_dialog);
                    c1799i.show(this.f4680a.f4684b, null);
                    return;
                case R.id.tcash_token_button:
                    this.f4680a.f4697u.m6509a(false);
                    return;
                case R.id.tcash_transaction_history_button:
                    this.f4680a.startActivity(new Intent(this.f4680a.e, TCashTransactionHistoryActivity.class));
                    return;
                case R.id.tcash_transfer_button:
                    if (C1358h.f2933d.equalsIgnoreCase(this.f4680a.f4695s)) {
                        this.f4680a.startActivity(new Intent(this.f4680a.e, TCashTransferActivity.class));
                        return;
                    }
                    this.f4680a.f = this.f4680a.m5199a(this.f4680a.f4700x, R.string.tcash_grade_info, false);
                    return;
                default:
                    return;
            }
        }
    }

    class C17922 implements C1326f {
        final /* synthetic */ C1794f f4681a;

        C17922(C1794f c1794f) {
            this.f4681a = c1794f;
        }

        public void mo1485a() {
            if (this.f4681a.f != null) {
                this.f4681a.f.dismiss();
            }
            this.f4681a.e.finish();
        }

        public void mo1486b() {
        }
    }

    class C17933 implements C1326f {
        final /* synthetic */ C1794f f4682a;

        C17933(C1794f c1794f) {
            this.f4682a = c1794f;
        }

        public void mo1485a() {
            if (this.f4682a.f != null) {
                this.f4682a.f.dismiss();
            }
        }

        public void mo1486b() {
        }
    }

    public void m6884b(String str) {
        this.f4696t = str;
        if (this.f4685c != null) {
            this.f4685c.setBalance(str);
            this.f4685c.setFont(this.h);
        }
    }

    public void m6885c(String str) {
        Log.d(f4683a, str);
        this.f4695s = str;
        if (this.f4686j != null) {
            if (C1358h.f2932c.equals(str)) {
                this.f4686j.setText(R.string.msg_top_desc4);
            } else if (C1358h.f2933d.equals(str)) {
                this.f4686j.setText(R.string.msg_top_desc2);
            }
            this.f4687k.setText(R.string.msg_top_desc1);
            this.f4688l.setText(R.string.msg_top_desc3);
            this.h.m4932a(this.e, this.f4686j, 3);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_tcash, null);
        m5208c(R.string.title_tcash);
        this.f4684b = m5215l();
        this.f4685c = (BalanceView) inflate.findViewById(R.id.tcash_balance);
        if (this.f4696t != null) {
            m6884b(this.f4696t);
        }
        this.f4686j = (TextView) inflate.findViewById(R.id.tcash_rp_detail2_textview);
        this.f4687k = (TextView) inflate.findViewById(R.id.tcash_rp_detail_textview);
        this.f4688l = (TextView) inflate.findViewById(R.id.tcash_rp_detail3_textview);
        if (this.f4695s != null) {
            m6885c(this.f4695s);
        }
        this.f4689m = (RelativeLayout) inflate.findViewById(R.id.tcash_airtime_purchase_button);
        this.f4690n = (RelativeLayout) inflate.findViewById(R.id.tcash_payment_button);
        this.f4691o = (RelativeLayout) inflate.findViewById(R.id.tcash_transfer_button);
        this.f4692p = (RelativeLayout) inflate.findViewById(R.id.tcash_cash_in_out_button);
        this.f4693q = (RelativeLayout) inflate.findViewById(R.id.tcash_token_button);
        this.f4694r = (RelativeLayout) inflate.findViewById(R.id.tcash_transaction_history_button);
        this.f4690n.setOnClickListener(this.f4698v);
        this.f4689m.setOnClickListener(this.f4698v);
        this.f4691o.setOnClickListener(this.f4698v);
        this.f4692p.setOnClickListener(this.f4698v);
        this.f4693q.setOnClickListener(this.f4698v);
        this.f4694r.setOnClickListener(this.f4698v);
        if (getString(R.string.button_cash).length() > 25) {
            ((TextView) inflate.findViewById(R.id.tcash_cash_in_out_text)).setTextSize(1, 14.0f);
        }
        this.e = (SlidingFrameActivity) getActivity();
        this.h = this.e.m4982d();
        this.h.m4932a(this.e, this.f4690n, 2);
        this.h.m4932a(this.e, this.f4689m, 2);
        this.h.m4932a(this.e, this.f4691o, 2);
        this.h.m4932a(this.e, this.f4692p, 2);
        this.h.m4932a(this.e, this.f4693q, 2);
        this.h.m4932a(this.e, this.f4694r, 2);
        this.h.m4932a(this.e, this.f4686j, 2);
        this.h.m4932a(this.e, this.f4687k, 3);
        this.h.m4932a(this.e, this.f4688l, 2);
        ViewGroup viewGroup2 = (LinearLayout) inflate.findViewById(R.id.tcash_bottom_layout);
        this.h.m4933a(this.e, (LinearLayout) inflate.findViewById(R.id.tcash_top_layout));
        this.h.m4933a(this.e, viewGroup2);
        this.f4697u = (TCashActivity) getActivity();
        return inflate;
    }
}
