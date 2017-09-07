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
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.view.BalanceView;

public class C1764d extends C1386e {
    private static final String f4551b = C1764d.class.getSimpleName();
    String f4552a;
    private BalanceView f4553c;
    private ImageView f4554j;
    private Button f4555k;
    private OnClickListener f4556l = new C17631(this);

    class C17631 implements OnClickListener {
        final /* synthetic */ C1764d f4550a;

        C17631(C1764d c1764d) {
            this.f4550a = c1764d;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_cash_in_retail_store_find_button:
                case R.id.tcash_cash_in_retail_store_find_imageview:
                    Intent intent = new Intent(this.f4550a.e, TCashMapActivity.class);
                    intent.putExtra("MAP_TYPE", "MAP_MENU_RETAIL_STORE");
                    this.f4550a.startActivity(intent);
                    return;
                default:
                    return;
            }
        }
    }

    public void m6769b(String str) {
        this.f4552a = str;
        if (this.f4553c != null) {
            this.f4553c.setBalance(str);
            this.f4553c.setFont(this.h);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_tcash_cash_in_retail_store, null);
        m5209d((int) R.string.tcash_cash_in_retail_store_title);
        this.f4553c = (BalanceView) inflate.findViewById(R.id.tcash_balance);
        if (this.f4552a != null) {
            m6769b(this.f4552a);
        }
        this.f4554j = (ImageView) inflate.findViewById(R.id.tcash_cash_in_retail_store_find_imageview);
        this.f4555k = (Button) inflate.findViewById(R.id.tcash_cash_in_retail_store_find_button);
        this.f4554j.setOnClickListener(this.f4556l);
        this.f4555k.setOnClickListener(this.f4556l);
        this.h.m4934a(this.e, (ViewGroup) inflate, 2);
        this.h.m4932a(this.e, (TextView) inflate.findViewById(R.id.tcash_cash_in_retail_store_message_top), 3);
        return inflate;
    }
}
