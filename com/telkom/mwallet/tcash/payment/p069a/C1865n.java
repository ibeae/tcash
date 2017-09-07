package com.telkom.mwallet.tcash.payment.p069a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.telkom.mwallet.R;
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.view.BalanceView;

public class C1865n extends C1386e {
    private static final String f5188b = C1865n.class.getSimpleName();
    String f5189a;
    private BalanceView f5190c;

    public void m7320b(String str) {
        this.f5189a = str;
        if (this.f5190c != null) {
            this.f5190c.setBalance(str);
            this.f5190c.setFont(this.h);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_tcash_payment, null);
        m5209d((int) R.string.title_tcash_pln);
        this.f5190c = (BalanceView) inflate.findViewById(R.id.tcash_balance);
        if (this.f5189a != null) {
            m7320b(this.f5189a);
        }
        this.h.m4933a(this.e, (LinearLayout) inflate.findViewById(R.id.tcash_top_layout));
        return inflate;
    }
}
