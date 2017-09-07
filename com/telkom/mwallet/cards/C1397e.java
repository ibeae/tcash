package com.telkom.mwallet.cards;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.http.model.ServiceVo;
import com.telkom.mwallet.R;
import com.telkom.mwallet.tcash.fragment.C1386e;

public class C1397e extends C1386e {
    private static final String f3097b = C1397e.class.getSimpleName();
    ServiceVo f3098a;
    private FragmentManager f3099c;
    private TextView f3100j;
    private TextView f3101k;
    private TextView f3102l;
    private TextView f3103m;
    private TextView f3104n;
    private Button f3105o;
    private Button f3106p;
    private Button f3107q;
    private RelativeLayout f3108r;
    private RelativeLayout f3109s;
    private CardHomeActivity f3110t;
    private OnClickListener f3111u = new C13961(this);

    class C13961 implements OnClickListener {
        final /* synthetic */ C1397e f3096a;

        C13961(C1397e c1397e) {
            this.f3096a = c1397e;
        }

        public void onClick(View view) {
            Intent intent;
            switch (view.getId()) {
                case R.id.card_home_card_history_button:
                    intent = new Intent(this.f3096a.f3110t, CardTransactionHistoryActivity.class);
                    intent.putExtra("SELECTED_CARD", this.f3096a.f3098a);
                    this.f3096a.startActivity(intent);
                    return;
                case R.id.card_home_pay_wave_button:
                    this.f3096a.f3110t.mo1505o();
                    return;
                case R.id.card_home_topup_button:
                    intent = new Intent(this.f3096a.f3110t, CardTopupActivity.class);
                    intent.putExtra("SELECTED_CARD", this.f3096a.f3098a);
                    this.f3096a.startActivity(intent);
                    return;
                default:
                    return;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_card_home, null);
        m5208c(R.string.title_cardlist);
        this.f3110t = (CardHomeActivity) getActivity();
        this.f3099c = m5215l();
        C1216a.m4522b("idx ", "idx" + this.f3110t.getIntent().getIntExtra("IDX", -1));
        this.f3098a = (ServiceVo) this.f3110t.getIntent().getSerializableExtra("SELECTED_CARD");
        this.f3100j = (TextView) inflate.findViewById(R.id.cardhome_card_name_textview);
        this.f3101k = (TextView) inflate.findViewById(R.id.cardhome_card_type_textview);
        this.f3102l = (TextView) inflate.findViewById(R.id.card_home_rp_textview);
        this.f3103m = (TextView) inflate.findViewById(R.id.card_home_rp_coin_textview);
        this.f3104n = (TextView) inflate.findViewById(R.id.cardhome_card_number_textview);
        this.f3105o = (Button) inflate.findViewById(R.id.card_home_main_card_button);
        this.f3106p = (Button) inflate.findViewById(R.id.card_home_default_card_button);
        this.f3108r = (RelativeLayout) inflate.findViewById(R.id.card_home_pay_wave_button);
        this.f3109s = (RelativeLayout) inflate.findViewById(R.id.card_home_card_history_button);
        this.f3107q = (Button) inflate.findViewById(R.id.card_home_topup_button);
        if (this.f3098a != null) {
            this.f3100j.setText(this.f3098a.getName());
            this.f3101k.setText(this.f3098a.getCardType());
            this.f3104n.setText(this.f3098a.getDeviceAppletId());
        }
        this.f3105o.setOnClickListener(this.f3111u);
        this.f3106p.setOnClickListener(this.f3111u);
        this.f3108r.setOnClickListener(this.f3111u);
        this.f3109s.setOnClickListener(this.f3111u);
        this.f3107q.setOnClickListener(this.f3111u);
        return inflate;
    }
}
