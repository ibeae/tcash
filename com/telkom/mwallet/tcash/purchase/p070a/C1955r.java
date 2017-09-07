package com.telkom.mwallet.tcash.purchase.p070a;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.telkom.mwallet.R;
import com.telkom.mwallet.p064a.C1347a;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.tcash.purchase.TCashTicketActivity;
import com.telkom.mwallet.view.Random2of6PinEditView;

public class C1955r extends C1386e {
    private static final String f5679a = C1955r.class.getSimpleName();
    private Button f5680b;
    private TextView f5681c;
    private TextView f5682j;
    private LinearLayout f5683k;
    private Random2of6PinEditView f5684l;
    private String f5685m;
    private String f5686n;
    private String f5687o;
    private String f5688p;
    private String f5689q;
    private TCashTicketActivity f5690r;
    private OnClickListener f5691s = new C19541(this);

    class C19541 implements OnClickListener {
        final /* synthetic */ C1955r f5678a;

        C19541(C1955r c1955r) {
            this.f5678a = c1955r;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    if (this.f5678a.f5684l.m8024c()) {
                        this.f5678a.f5690r.m7564e(this.f5678a.f5684l.getPin());
                        this.f5678a.f5690r.m7567j(this.f5678a.f5687o);
                        this.f5678a.f5690r.m7566g(this.f5678a.f5688p);
                        this.f5678a.f5690r.m7565f(this.f5678a.f5689q);
                        this.f5678a.f5690r.m7570p();
                        return;
                    }
                    return;
                case R.id.tcash_forget_pin_button:
                    this.f5678a.m5219p();
                    return;
                default:
                    return;
            }
        }
    }

    private void m7837a(String str, String str2) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.view_label_content, null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.tcash_purchase_content_id_txt);
        ((TextView) linearLayout.findViewById(R.id.tcash_purchase_label_id_txt)).setText(str);
        textView.setText(str2);
        this.f5683k.addView(linearLayout);
    }

    private void m7839b(View view) {
        this.f5680b = (Button) view.findViewById(R.id.tcash_confirm_button);
        this.f5681c = (TextView) view.findViewById(R.id.tcash_noti_title_textview);
        this.f5682j = (TextView) view.findViewById(R.id.tcash_forget_pin_button);
        this.f5683k = (LinearLayout) view.findViewById(R.id.tcash_purchase_label_content_layout);
        this.f5684l = (Random2of6PinEditView) view.findViewById(R.id.pin_edit_view);
        C1347a.m4910a().m4912a(this.f5684l.getPinViews());
        this.f5680b.setText(R.string.btn_next);
        this.f5680b.setOnClickListener(this.f5691s);
        this.f5682j.setOnClickListener(this.f5691s);
        m7845b(this.f5685m);
        m7842d();
    }

    private void m7842d() {
        if (this.f5686n != null && !this.f5686n.isEmpty()) {
            Uri parse = Uri.parse(this.f5686n);
            this.f5687o = parse.getQueryParameter("trx_id");
            this.f5688p = parse.getQueryParameter("booking_code");
            this.f5689q = parse.getQueryParameter("price");
            m7837a(getResources().getString(R.string.label_ticket_number), this.f5688p);
            m7837a(getResources().getString(R.string.amount), C1354g.m4955f(this.f5689q));
        }
    }

    public void m7845b(String str) {
        this.f5685m = str;
        if (this.f5681c != null) {
            this.f5681c.setText(str);
        }
    }

    public void m7846c(String str) {
        this.f5686n = str;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5690r = (TCashTicketActivity) getActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_ticket_second, null);
        m5202a((ViewGroup) inflate);
        m7839b(inflate);
        return inflate;
    }
}
