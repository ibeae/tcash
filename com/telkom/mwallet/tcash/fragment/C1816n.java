package com.telkom.mwallet.tcash.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.telkom.mwallet.R;
import com.telkom.mwallet.tcash.TCashTransferActivity;
import com.telkom.mwallet.view.BalanceView;

public class C1816n extends C1386e {
    private static final String f4829b = C1816n.class.getSimpleName();
    String f4830a;
    private BalanceView f4831c;
    private TCashTransferActivity f4832j;

    public void m6965b(String str) {
        this.f4830a = str;
        if (this.f4831c != null) {
            this.f4831c.setBalance(str);
            this.f4831c.setFont(this.h);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_tcash_payment, null);
        m5209d((int) R.string.title_tcash_transfer);
        this.f4832j = (TCashTransferActivity) getActivity();
        this.f4831c = (BalanceView) inflate.findViewById(R.id.tcash_balance);
        if (this.f4830a != null) {
            m6965b(this.f4830a);
        }
        this.h = this.f4832j.m4982d();
        return inflate;
    }
}
