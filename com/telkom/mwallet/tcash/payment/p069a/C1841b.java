package com.telkom.mwallet.tcash.payment.p069a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.telkom.mwallet.R;
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.view.BalanceView;

public class C1841b extends C1386e {
    private static final String f5048b = C1841b.class.getSimpleName();
    String f5049a;
    private BalanceView f5050c;

    public void m7215b(String str) {
        this.f5049a = str;
        if (this.f5050c != null) {
            this.f5050c.setBalance(str);
            this.f5050c.setFont(this.h);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_tcash_payment, null);
        m5209d((int) R.string.title_tcash_fixedline);
        this.f5050c = (BalanceView) inflate.findViewById(R.id.tcash_balance);
        if (this.f5049a != null) {
            m7215b(this.f5049a);
        }
        this.h.m4933a(this.e, (LinearLayout) inflate.findViewById(R.id.tcash_top_layout));
        return inflate;
    }
}
