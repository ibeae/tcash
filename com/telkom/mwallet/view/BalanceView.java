package com.telkom.mwallet.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.telkom.mwallet.R;
import com.telkom.mwallet.p064a.C1350d;
import com.telkom.mwallet.p064a.C1354g;

public class BalanceView extends RelativeLayout {
    private String f5816a = "";
    private BalanceView f5817b = ((BalanceView) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.view_balance, this, true).getRootView());
    private TextView f5818c = ((TextView) findViewById(R.id.rp_textview));

    public BalanceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setBalance(long j) {
        String valueOf = String.valueOf(j);
        if (this.f5818c != null) {
            if (valueOf == null || valueOf.length() <= 6) {
                this.f5818c.setTextSize(1, 24.0f);
            } else {
                this.f5818c.setTextSize(1, 18.0f);
            }
            this.f5818c.setText(C1354g.m4955f(valueOf));
        }
    }

    public void setBalance(String str) {
        long j = 0;
        if (!(str == null || str.isEmpty())) {
            try {
                j = Long.parseLong(str);
            } catch (Exception e) {
            }
        }
        setBalance(j);
    }

    public void setFont(C1350d c1350d) {
        c1350d.m4932a(getContext(), this.f5818c, 3);
    }
}
