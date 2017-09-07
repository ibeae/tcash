package com.telkom.mwallet.tcash.payment.p069a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.telkom.mwallet.R;
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.view.BalanceView;

public class C1858k extends C1386e {
    private static final String f5146b = C1858k.class.getSimpleName();
    String f5147a;
    private BalanceView f5148c;

    public void m7282b(String str) {
        this.f5147a = str;
        if (this.f5148c != null) {
            this.f5148c.setBalance(str);
            this.f5148c.setFont(this.h);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_tcash_payment, null);
        m5209d((int) R.string.title_tcash_pdam);
        this.f5148c = (BalanceView) inflate.findViewById(R.id.tcash_balance);
        if (this.f5147a != null) {
            m7282b(this.f5147a);
        }
        this.h.m4933a(this.e, (LinearLayout) inflate.findViewById(R.id.tcash_top_layout));
        return inflate;
    }
}
