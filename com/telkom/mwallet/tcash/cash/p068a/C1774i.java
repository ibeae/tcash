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

public class C1774i extends C1386e {
    private static final String f4600b = C1774i.class.getSimpleName();
    String f4601a;
    private BalanceView f4602c;
    private ImageView f4603j;
    private Button f4604k;
    private OnClickListener f4605l = new C17731(this);

    class C17731 implements OnClickListener {
        final /* synthetic */ C1774i f4599a;

        C17731(C1774i c1774i) {
            this.f4599a = c1774i;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_cash_out_grapari_find_button:
                case R.id.tcash_cash_out_grapari_find_imageview:
                    Intent intent = new Intent(this.f4599a.e, TCashMapActivity.class);
                    intent.putExtra("TCASH_MAP_TITLE", R.string.tcash_cash_out_grapari_title);
                    intent.putExtra("MAP_TYPE", "MAP_MENU_GRAPARI");
                    this.f4599a.startActivity(intent);
                    return;
                default:
                    return;
            }
        }
    }

    public void m6800b(String str) {
        this.f4601a = str;
        if (this.f4602c != null) {
            this.f4602c.setBalance(str);
            this.f4602c.setFont(this.h);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_tcash_cash_out_grapari, null);
        m5209d((int) R.string.tcash_cash_out_grapari_title);
        this.f4602c = (BalanceView) inflate.findViewById(R.id.tcash_balance);
        if (this.f4601a != null) {
            m6800b(this.f4601a);
        }
        this.f4603j = (ImageView) inflate.findViewById(R.id.tcash_cash_out_grapari_find_imageview);
        this.f4604k = (Button) inflate.findViewById(R.id.tcash_cash_out_grapari_find_button);
        this.f4603j.setOnClickListener(this.f4605l);
        this.f4604k.setOnClickListener(this.f4605l);
        this.h.m4934a(this.e, (ViewGroup) inflate, 2);
        this.h.m4932a(this.e, (TextView) inflate.findViewById(R.id.tcash_cash_out_grapari_top_text), 3);
        return inflate;
    }
}
