package com.telkom.mwallet.tcash.payment.p069a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.telkom.mwallet.R;
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.view.BalanceView;

public class C1851h extends C1386e {
    private static final String f5109b = C1851h.class.getSimpleName();
    String f5110a;
    private BalanceView f5111c;

    public void m7254b(String str) {
        this.f5110a = str;
        if (this.f5111c != null) {
            this.f5111c.setBalance(str);
            this.f5111c.setFont(this.h);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_tcash_payment, null);
        m5209d((int) R.string.title_tcash_others);
        this.f5111c = (BalanceView) inflate.findViewById(R.id.tcash_balance);
        if (this.f5110a != null) {
            m7254b(this.f5110a);
        }
        this.h.m4933a(this.e, (LinearLayout) inflate.findViewById(R.id.tcash_top_layout));
        return inflate;
    }
}
