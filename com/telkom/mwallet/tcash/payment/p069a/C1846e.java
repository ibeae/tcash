package com.telkom.mwallet.tcash.payment.p069a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.telkom.mwallet.R;
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.view.BalanceView;

public class C1846e extends C1386e {
    private static final String f5081b = C1846e.class.getSimpleName();
    String f5082a;
    private BalanceView f5083c;

    public void m7236b(String str) {
        this.f5082a = str;
        if (this.f5083c != null) {
            this.f5083c.setBalance(str);
            this.f5083c.setFont(this.h);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_tcash_payment, null);
        m5209d((int) R.string.title_tcash_kartu);
        this.f5083c = (BalanceView) inflate.findViewById(R.id.tcash_balance);
        if (this.f5082a != null) {
            m7236b(this.f5082a);
        }
        this.h.m4933a(this.e, (LinearLayout) inflate.findViewById(R.id.tcash_top_layout));
        return inflate;
    }
}
