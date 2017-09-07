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

public class C1759b extends C1386e {
    private static final String f4529b = C1759b.class.getSimpleName();
    String f4530a;
    private BalanceView f4531c;
    private ImageView f4532j;
    private Button f4533k;
    private OnClickListener f4534l = new C17581(this);

    class C17581 implements OnClickListener {
        final /* synthetic */ C1759b f4528a;

        C17581(C1759b c1759b) {
            this.f4528a = c1759b;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_cash_in_grapari_find_button:
                case R.id.tcash_cash_in_grapari_find_imageview:
                    Intent intent = new Intent(this.f4528a.e, TCashMapActivity.class);
                    intent.putExtra("TCASH_MAP_TITLE", R.string.tcash_cash_in_grapari_title);
                    intent.putExtra("MAP_TYPE", "MAP_MENU_GRAPARI");
                    this.f4528a.startActivity(intent);
                    return;
                default:
                    return;
            }
        }
    }

    public void m6756b(String str) {
        this.f4530a = str;
        if (this.f4531c != null) {
            this.f4531c.setBalance(str);
            this.f4531c.setFont(this.h);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_tcash_cash_in_grapari, null);
        m5209d((int) R.string.tcash_cash_in_grapari_title);
        this.f4531c = (BalanceView) inflate.findViewById(R.id.tcash_balance);
        if (this.f4530a != null) {
            m6756b(this.f4530a);
        }
        this.f4532j = (ImageView) inflate.findViewById(R.id.tcash_cash_in_grapari_find_imageview);
        this.f4533k = (Button) inflate.findViewById(R.id.tcash_cash_in_grapari_find_button);
        this.f4532j.setOnClickListener(this.f4534l);
        this.f4533k.setOnClickListener(this.f4534l);
        this.h.m4934a(this.e, (ViewGroup) inflate, 2);
        this.h.m4932a(this.e, (TextView) inflate.findViewById(R.id.tcash_cash_in_grapari_message_top), 3);
        return inflate;
    }
}
