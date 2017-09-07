package com.telkom.mwallet.tcash.purchase.p070a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.telkom.mwallet.R;
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.view.BalanceView;

public class C1920e extends C1386e {
    private static final String f5499a = C1920e.class.getSimpleName();
    private BalanceView f5500b;
    private String f5501c;
    private String f5502j;

    public void m7627b(String str) {
        this.f5501c = str;
    }

    public void m7628c(String str) {
        this.f5502j = str;
        if (this.f5500b != null) {
            this.f5500b.setBalance(str);
            this.f5500b.setFont(this.h);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_tcash_payment, null);
        m5210d(this.f5501c);
        this.f5500b = (BalanceView) inflate.findViewById(R.id.tcash_balance);
        if (this.f5502j != null) {
            m7628c(this.f5502j);
        }
        this.h.m4933a(this.e, (LinearLayout) inflate.findViewById(R.id.tcash_top_layout));
        return inflate;
    }
}
