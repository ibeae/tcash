package com.telkom.mwallet.tcash.purchase.p070a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.telkom.mwallet.R;
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.view.BalanceView;

public class C1953q extends C1386e {
    private static final String f5673a = C1953q.class.getSimpleName();
    private BalanceView f5674b;
    private int f5675c = 0;
    private String f5676j = "";
    private String f5677k;

    public void m7833a(int i) {
        this.f5675c = i;
        if (this.f5674b != null) {
            ((LinearLayout) this.f5674b.getParent()).setVisibility(this.f5675c);
        }
    }

    public void m7834b(String str) {
        if (str != null) {
            this.f5676j = str;
        }
    }

    public void m7835c(String str) {
        this.f5677k = str;
        if (this.f5674b != null) {
            this.f5674b.setBalance(str);
            this.f5674b.setFont(this.h);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_tcash_payment, null);
        m5210d(this.f5676j);
        this.f5674b = (BalanceView) inflate.findViewById(R.id.tcash_balance);
        m7835c(this.f5677k);
        m7833a(this.f5675c);
        this.h.m4933a(this.e, (LinearLayout) inflate.findViewById(R.id.tcash_top_layout));
        return inflate;
    }
}
