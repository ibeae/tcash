package com.telkom.mwallet.tcash.cash.p068a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.telkom.mwallet.R;
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.view.BalanceView;

public class C1768f extends C1386e {
    private static final String f4578b = C1768f.class.getSimpleName();
    String f4579a;
    private BalanceView f4580c;

    public void m6792b(String str) {
        this.f4579a = str;
        if (this.f4580c != null) {
            this.f4580c.setBalance(str);
            this.f4580c.setFont(this.h);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_tcash_cash_in_sms_banking, null);
        String stringExtra = getActivity().getIntent().getStringExtra("TCASH_MENU_ID");
        if ("5131000".equals(stringExtra)) {
            m5209d((int) R.string.title_tcash_cash_in_sms_bni);
        } else if ("5133000".equals(stringExtra)) {
            m5209d((int) R.string.title_tcash_cash_in_sms_mega);
        } else if ("5132000".equals(stringExtra)) {
            m5209d((int) R.string.title_tcash_cash_in_sms_mandiri);
        }
        this.f4580c = (BalanceView) inflate.findViewById(R.id.tcash_balance);
        if (this.f4579a != null) {
            m6792b(this.f4579a);
        }
        this.h.m4933a(this.e, (LinearLayout) inflate.findViewById(R.id.tcash_top_layout));
        return inflate;
    }
}
