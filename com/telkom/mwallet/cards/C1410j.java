package com.telkom.mwallet.cards;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.skcc.wallet.framework.api.http.model.ServiceVo;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1527g;
import com.telkom.mwallet.dialog.p063a.C1324e;
import com.telkom.mwallet.tcash.fragment.C1386e;
import java.util.ArrayList;
import java.util.List;

public class C1410j extends C1386e {
    private static final String f3157c = C1410j.class.getSimpleName();
    C1527g f3158a;
    ServiceVo f3159b;
    private FragmentManager f3160j;
    private TextView f3161k;
    private TextView f3162l;
    private Button f3163m;
    private Button f3164n;
    private Button f3165o;
    private Button f3166p;
    private Button f3167q;
    private CardTopupActivity f3168r;
    private OnClickListener f3169s = new C14071(this);
    private C1324e f3170t = new C14082(this);
    private C1324e f3171u = new C14093(this);

    class C14071 implements OnClickListener {
        final /* synthetic */ C1410j f3154a;

        C14071(C1410j c1410j) {
            this.f3154a = c1410j;
        }

        public void onClick(View view) {
            List arrayList;
            switch (view.getId()) {
                case R.id.card_topup_amount_button:
                case R.id.card_topup_amount_picker_button:
                    arrayList = new ArrayList();
                    arrayList.add("10");
                    arrayList.add("20");
                    arrayList.add("30");
                    arrayList.add("40");
                    this.f3154a.f3158a = C1527g.m5667a((int) R.id.dialog_title);
                    this.f3154a.f3158a.m5671a(arrayList);
                    this.f3154a.f3158a.m5670a(this.f3154a.f3171u);
                    this.f3154a.f3158a.show(this.f3154a.f3160j, "list_dialog_tag");
                    return;
                case R.id.card_topup_next_button:
                    String charSequence = this.f3154a.f3165o.getText().toString();
                    if (charSequence != null && !charSequence.equals("")) {
                        C1406i c1406i = new C1406i();
                        c1406i.m5282a(this.f3154a.f3168r.getApplicationContext());
                        c1406i.m5283a(this.f3154a.f3159b);
                        c1406i.m5284a(this.f3154a.f3165o.getText().toString());
                        c1406i.setStyle(0, R.style.tcash_menu_dialog);
                        c1406i.show(this.f3154a.f3160j, null);
                        return;
                    }
                    return;
                case R.id.card_topup_type_button:
                case R.id.card_topup_type_picker_button:
                    arrayList = new ArrayList();
                    arrayList.add(this.f3154a.getString(R.string.str_tcash));
                    this.f3154a.f3158a = C1527g.m5667a((int) R.id.dialog_title);
                    this.f3154a.f3158a.m5671a(arrayList);
                    this.f3154a.f3158a.m5670a(this.f3154a.f3170t);
                    this.f3154a.f3158a.show(this.f3154a.f3160j, "list_dialog_tag");
                    return;
                default:
                    return;
            }
        }
    }

    class C14082 implements C1324e {
        final /* synthetic */ C1410j f3155a;

        C14082(C1410j c1410j) {
            this.f3155a = c1410j;
        }

        public void mo1483a(int i) {
        }

        public void mo1484a(String str) {
            if (this.f3155a.f3158a != null) {
                this.f3155a.f3158a.dismiss();
            }
            this.f3155a.f3163m.setText(str);
        }
    }

    class C14093 implements C1324e {
        final /* synthetic */ C1410j f3156a;

        C14093(C1410j c1410j) {
            this.f3156a = c1410j;
        }

        public void mo1483a(int i) {
        }

        public void mo1484a(String str) {
            if (this.f3156a.f3158a != null) {
                this.f3156a.f3158a.dismiss();
            }
            this.f3156a.f3165o.setText(str);
        }
    }

    void m5295a(double d) {
        String substring;
        CharSequence substring2;
        String valueOf = String.valueOf(d);
        if (valueOf.contains(".")) {
            substring = valueOf.substring(0, valueOf.indexOf(46));
            substring2 = valueOf.substring(valueOf.indexOf(46), valueOf.length());
        } else {
            substring2 = "00";
            substring = valueOf;
        }
        this.f3161k.setText("RP." + substring);
        this.f3162l.setText(substring2);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_card_topup, null);
        m5208c(R.string.title_cardlist);
        this.f3168r = (CardTopupActivity) getActivity();
        this.f3160j = m5215l();
        this.f3161k = (TextView) inflate.findViewById(R.id.card_topup_rp_textview);
        this.f3162l = (TextView) inflate.findViewById(R.id.card_topup_rp_coin_textview);
        this.f3163m = (Button) inflate.findViewById(R.id.card_topup_type_button);
        this.f3164n = (Button) inflate.findViewById(R.id.card_topup_type_picker_button);
        this.f3165o = (Button) inflate.findViewById(R.id.card_topup_amount_button);
        this.f3166p = (Button) inflate.findViewById(R.id.card_topup_amount_picker_button);
        this.f3167q = (Button) inflate.findViewById(R.id.card_topup_next_button);
        this.f3163m.setOnClickListener(this.f3169s);
        this.f3164n.setOnClickListener(this.f3169s);
        this.f3165o.setOnClickListener(this.f3169s);
        this.f3166p.setOnClickListener(this.f3169s);
        this.f3167q.setOnClickListener(this.f3169s);
        this.f3159b = (ServiceVo) this.f3168r.getIntent().getSerializableExtra("SELECTED_CARD");
        this.f3163m.setText(this.f3159b.getCardType());
        return inflate;
    }
}
