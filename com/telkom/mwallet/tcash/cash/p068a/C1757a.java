package com.telkom.mwallet.tcash.cash.p068a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.telkom.mwallet.R;
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.view.BalanceView;

public class C1757a extends C1386e {
    private static final String f4525b = C1757a.class.getSimpleName();
    String f4526a;
    private BalanceView f4527c;

    public void m6754b(String str) {
        this.f4526a = str;
        if (this.f4527c != null) {
            this.f4527c.setBalance(str);
            this.f4527c.setFont(this.h);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_tcash_cash_in_atm_bersama, null);
        m5209d((int) R.string.tcash_cash_in_title);
        this.f4527c = (BalanceView) inflate.findViewById(R.id.tcash_balance);
        if (this.f4526a != null) {
            m6754b(this.f4526a);
        }
        this.h.m4934a(this.e, (ViewGroup) inflate, 2);
        this.h.m4932a(this.e, (TextView) inflate.findViewById(R.id.tcash_cash_in_atm_bersama_topup_detail_message_top), 3);
        return inflate;
    }
}
