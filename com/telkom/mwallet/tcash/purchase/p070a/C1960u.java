package com.telkom.mwallet.tcash.purchase.p070a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.telkom.mwallet.R;
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.view.BalanceView;

public class C1960u extends C1386e {
    private static final String f5704a = C1960u.class.getSimpleName();
    private BalanceView f5705b;
    private int f5706c = 0;
    private String f5707j = "";
    private String f5708k;

    public void m7856a(int i) {
        this.f5706c = i;
        if (this.f5705b != null) {
            ((LinearLayout) this.f5705b.getParent()).setVisibility(this.f5706c);
        }
    }

    public void m7857b(String str) {
        if (str != null) {
            this.f5707j = str;
        }
    }

    public void m7858c(String str) {
        this.f5708k = str;
        if (this.f5705b != null) {
            this.f5705b.setBalance(str);
            this.f5705b.setFont(this.h);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_tcash_payment, null);
        m5210d(this.f5707j);
        this.f5705b = (BalanceView) inflate.findViewById(R.id.tcash_balance);
        m7858c(this.f5708k);
        m7856a(this.f5706c);
        this.h.m4933a(this.e, (LinearLayout) inflate.findViewById(R.id.tcash_top_layout));
        return inflate;
    }
}
