package com.telkom.mwallet.tcash.cash.p068a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.telkom.mwallet.R;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.tcash.cash.TCashInSMSBankingActivity;
import com.telkom.mwallet.tcash.fragment.C1386e;

public class C1770g extends C1386e {
    private static final String f4582a = C1770g.class.getSimpleName();
    private TextView f4583b;
    private TextView f4584c;
    private TextView f4585j;
    private Button f4586k;
    private String f4587l;
    private String f4588m;
    private String f4589n;
    private OnClickListener f4590o = new C17691(this);

    class C17691 implements OnClickListener {
        final /* synthetic */ C1770g f4581a;

        C17691(C1770g c1770g) {
            this.f4581a = c1770g;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    ((TCashInSMSBankingActivity) this.f4581a.getActivity()).m6723p();
                    this.f4581a.f4586k.setEnabled(false);
                    return;
                default:
                    return;
            }
        }
    }

    private void m6794b(View view) {
        this.f4583b = (TextView) view.findViewById(R.id.tcash_sms_banking_snd_simpati_textview);
        this.f4584c = (TextView) view.findViewById(R.id.tcash_sms_banking_snd_number_textview);
        this.f4585j = (TextView) view.findViewById(R.id.tcash_sms_banking_snd_amount_textview);
        this.f4586k = (Button) view.findViewById(R.id.tcash_confirm_button);
        this.f4586k.setOnClickListener(this.f4590o);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.tcash_sms_banking_name_layout);
        if (this.f4587l == null || this.f4587l.isEmpty()) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
            this.f4583b.setText(this.f4587l);
        }
        this.f4584c.setText(this.f4588m);
        if (this.f4589n != null) {
            m6797f(this.f4589n);
        }
    }

    public void m6795b(String str) {
        this.f4587l = str;
        if (this.f4583b != null) {
            this.f4583b.setText(str);
        }
    }

    public void m6796c(String str) {
        this.f4588m = str;
    }

    public void m6797f(String str) {
        this.f4589n = str;
        if (this.f4585j != null) {
            this.f4585j.setText(C1354g.m4955f(str));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_cash_in_sms_banking_second, null);
        m5202a((ViewGroup) inflate);
        m6794b(inflate);
        return inflate;
    }
}
