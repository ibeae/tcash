package com.telkom.mwallet.tcash.purchase.p070a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.telkom.mwallet.R;
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.view.BalanceView;

public class C1914b extends C1386e {
    private static final String f5464b = C1914b.class.getSimpleName();
    String f5465a;
    private BalanceView f5466c;

    public void m7610b(String str) {
        this.f5465a = str;
        if (this.f5466c != null) {
            this.f5466c.setBalance(str);
            this.f5466c.setFont(this.h);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_tcash_payment, null);
        m5209d((int) R.string.title_tcash_merchant);
        this.f5466c = (BalanceView) inflate.findViewById(R.id.tcash_balance);
        if (this.f5465a != null) {
            m7610b(this.f5465a);
        }
        this.h.m4933a(this.e, (LinearLayout) inflate.findViewById(R.id.tcash_top_layout));
        return inflate;
    }
}
