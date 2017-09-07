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
import com.telkom.mwallet.tcash.purchase.TCashTransportTravelActivity;
import com.telkom.mwallet.view.Random2of6PinEditView;

public class C1962v extends C1386e {
    private static final String f5710a = C1962v.class.getSimpleName();
    private Button f5711b;
    private TextView f5712c;
    private TextView f5713j;
    private LinearLayout f5714k;
    private Random2of6PinEditView f5715l;
    private String f5716m;
    private String f5717n;
    private String f5718o;
    private String f5719p;
    private String f5720q;
    private String f5721r;
    private TCashTransportTravelActivity f5722s;
    private OnClickListener f5723t = new C19611(this);

    class C19611 implements OnClickListener {
        final /* synthetic */ C1962v f5709a;

        C19611(C1962v c1962v) {
            this.f5709a = c1962v;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    if (this.f5709a.f5715l.m8024c()) {
                        this.f5709a.f5722s.m7589e(this.f5709a.f5715l.getPin());
                        this.f5709a.f5722s.m7592j(this.f5709a.f5719p);
                        this.f5709a.f5722s.m7591g(this.f5709a.f5720q);
                        this.f5709a.f5722s.m7590f(this.f5709a.f5721r);
                        this.f5709a.f5722s.m7595p();
                        return;
                    }
                    return;
                case R.id.tcash_forget_pin_button:
                    this.f5709a.m5219p();
                    return;
                default:
                    return;
            }
        }
    }

    private void m7860a(String str, String str2) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.view_label_content, null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.tcash_purchase_content_id_txt);
        ((TextView) linearLayout.findViewById(R.id.tcash_purchase_label_id_txt)).setText(str);
        textView.setText(str2);
        this.f5714k.addView(linearLayout);
    }

    private void m7862b(View view) {
        this.f5711b = (Button) view.findViewById(R.id.tcash_confirm_button);
        this.f5712c = (TextView) view.findViewById(R.id.tcash_noti_title_textview);
        this.f5713j = (TextView) view.findViewById(R.id.tcash_forget_pin_button);
        this.f5714k = (LinearLayout) view.findViewById(R.id.tcash_purchase_label_content_layout);
        this.f5715l = (Random2of6PinEditView) view.findViewById(R.id.pin_edit_view);
        C1347a.m4910a().m4912a(this.f5715l.getPinViews());
        this.f5711b.setText(R.string.btn_next);
        this.f5711b.setOnClickListener(this.f5723t);
        this.f5713j.setOnClickListener(this.f5723t);
        m7869c(this.f5717n);
        m7865d();
    }

    private void m7865d() {
        if (this.f5718o != null && !this.f5718o.isEmpty()) {
            Uri parse = Uri.parse(this.f5718o);
            this.f5719p = parse.getQueryParameter("trx_id");
            this.f5720q = parse.getQueryParameter("booking_code");
            this.f5721r = parse.getQueryParameter("price");
            if ("2700001".equals(this.f5716m)) {
                m7860a(getResources().getString(R.string.label_ticket_number), this.f5720q);
            } else {
                m7860a(getResources().getString(R.string.label_transport_travel_booking_number), this.f5720q);
            }
            m7860a(getResources().getString(R.string.amount), C1354g.m4955f(this.f5721r));
        }
    }

    public void m7868b(String str) {
        this.f5716m = str;
    }

    public void m7869c(String str) {
        this.f5717n = str;
        if (this.f5712c != null) {
            this.f5712c.setText(str);
        }
    }

    public void m7870f(String str) {
        this.f5718o = str;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5722s = (TCashTransportTravelActivity) getActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_ticket_second, null);
        m5202a((ViewGroup) inflate);
        m7862b(inflate);
        return inflate;
    }
}
