package com.telkom.mwallet.tcash.cash.p068a;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.telkom.mwallet.R;
import com.telkom.mwallet.tcash.TCashMapActivity;
import com.telkom.mwallet.tcash.cash.TCashOutRetailStoreActivity;
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.view.BalanceView;

public class C1778k extends C1386e {
    private static final String f4616b = C1778k.class.getSimpleName();
    String f4617a;
    private BalanceView f4618c;
    private ImageView f4619j;
    private Button f4620k;
    private Button f4621l;
    private TCashOutRetailStoreActivity f4622m;
    private OnClickListener f4623n = new C17771(this);

    class C17771 implements OnClickListener {
        final /* synthetic */ C1778k f4615a;

        C17771(C1778k c1778k) {
            this.f4615a = c1778k;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_cash_out_retail_store_create_token_button:
                    this.f4615a.f4622m.mo1505o();
                    return;
                case R.id.tcash_cash_out_retail_store_find_button:
                case R.id.tcash_cash_out_retail_store_find_imageview:
                    Intent intent = new Intent(this.f4615a.e, TCashMapActivity.class);
                    intent.putExtra("MAP_TYPE", "MAP_MENU_RETAIL_STORE");
                    this.f4615a.startActivity(intent);
                    return;
                default:
                    return;
            }
        }
    }

    public void m6805b(String str) {
        this.f4617a = str;
        if (this.f4618c != null) {
            this.f4618c.setBalance(str);
            this.f4618c.setFont(this.h);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_tcash_cash_out_retail_store, null);
        m5209d((int) R.string.tcash_cash_out_retail_store_title);
        this.f4622m = (TCashOutRetailStoreActivity) getActivity();
        this.f4618c = (BalanceView) inflate.findViewById(R.id.tcash_balance);
        if (this.f4617a != null) {
            m6805b(this.f4617a);
        }
        this.f4619j = (ImageView) inflate.findViewById(R.id.tcash_cash_out_retail_store_find_imageview);
        this.f4620k = (Button) inflate.findViewById(R.id.tcash_cash_out_retail_store_create_token_button);
        this.f4621l = (Button) inflate.findViewById(R.id.tcash_cash_out_retail_store_find_button);
        this.f4619j.setOnClickListener(this.f4623n);
        this.f4620k.setOnClickListener(this.f4623n);
        this.f4621l.setOnClickListener(this.f4623n);
        this.h.m4934a(this.e, (ViewGroup) inflate, 2);
        this.h.m4932a(this.e, (TextView) inflate.findViewById(R.id.tcash_cash_out_retail_store_top_text), 3);
        return inflate;
    }
}
