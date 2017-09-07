package com.telkom.mwallet.tcash.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.telkom.mwallet.R;
import com.telkom.mwallet.view.BalanceView;

public class C1785b extends C1386e {
    private static final String f4658b = C1785b.class.getSimpleName();
    String f4659a;
    private BalanceView f4660c;

    public void m6854b(String str) {
        this.f4659a = str;
        if (this.f4660c != null) {
            this.f4660c.setBalance(str);
            this.f4660c.setFont(this.h);
        }
    }

    public void mo1550k() {
        super.mo1550k();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_tcash_aritime, null);
        m5209d((int) R.string.title_tcash_airtime);
        this.h.m4933a(this.e, (LinearLayout) inflate.findViewById(R.id.tcash_top_layout));
        this.f4660c = (BalanceView) inflate.findViewById(R.id.tcash_balance);
        if (this.f4659a != null) {
            m6854b(this.f4659a);
        }
        return inflate;
    }
}
