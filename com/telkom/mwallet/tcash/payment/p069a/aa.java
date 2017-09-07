package com.telkom.mwallet.tcash.payment.p069a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.telkom.mwallet.R;
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.view.BalanceView;

public class aa extends C1386e {
    private static final String f5008a = aa.class.getSimpleName();
    private BalanceView f5009b;
    private String f5010c;
    private String f5011j;
    private String f5012k;

    public void m7195a(String str, String str2) {
        this.f5010c = str;
        this.f5011j = str2;
    }

    public void m7196b(String str) {
        this.f5012k = str;
        if (this.f5009b != null) {
            this.f5009b.setBalance(str);
            this.f5009b.setFont(this.h);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_tcash_payment, null);
        if (!(this.f5011j == null || this.f5011j.isEmpty())) {
            m5210d(this.f5011j);
        }
        this.f5009b = (BalanceView) inflate.findViewById(R.id.tcash_balance);
        if (this.f5012k != null) {
            m7196b(this.f5012k);
        }
        this.h.m4933a(this.e, (LinearLayout) inflate.findViewById(R.id.tcash_top_layout));
        return inflate;
    }
}
