package com.telkom.mwallet.tcash.tap.p072b;

import android.app.Activity;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.appsflyer.ServerParameters;
import com.skcc.wallet.core.p057a.C1216a;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.p064a.C1347a;
import com.telkom.mwallet.p064a.C1350d;
import com.telkom.mwallet.tcash.tap.C1971a;
import com.telkom.mwallet.tcash.tap.C1972b;
import com.telkom.mwallet.tcash.tap.p071a.C1975a.C1974a;
import com.telkom.mwallet.tcash.tap.p071a.C1976b;
import com.telkom.mwallet.tcash.tap.p071a.C1977c;
import com.telkom.mwallet.view.Random2of6PinEditView;

public class C1994c extends C1987b {
    static final String f5789a = C1994c.class.getSimpleName();
    private C1971a f5790b;
    private EditText f5791c;
    private Random2of6PinEditView f5792j;
    private TextView f5793k;
    private Button f5794l;

    class C19891 implements OnClickListener {
        final /* synthetic */ C1994c f5783a;

        C19891(C1994c c1994c) {
            this.f5783a = c1994c;
        }

        public void onClick(View view) {
            this.f5783a.m7922e();
        }
    }

    class C19902 implements OnClickListener {
        final /* synthetic */ C1994c f5784a;

        C19902(C1994c c1994c) {
            this.f5784a = c1994c;
        }

        public void onClick(View view) {
            this.f5784a.m7967i();
            if (!this.f5784a.m7966h()) {
                this.f5784a.f5791c.setBackgroundResource(R.drawable.field_sct_red);
            } else if (this.f5784a.f5792j.m8024c()) {
                this.f5784a.m5217n();
                this.f5784a.f5790b.mo1574a(this.f5784a.m7921d(), this.f5784a.f5792j.getPin(), this.f5784a.f5791c.getText().toString().trim(), new C1993a(this.f5784a, this.f5784a.m5216m()));
            }
        }
    }

    private class C1993a extends C1972b {
        final /* synthetic */ C1994c f5788a;

        class C19921 implements C1326f {
            final /* synthetic */ C1993a f5787a;

            C19921(C1993a c1993a) {
                this.f5787a = c1993a;
            }

            public void mo1485a() {
                this.f5787a.c.dismiss();
            }

            public void mo1486b() {
            }
        }

        public C1993a(C1994c c1994c, C1359a c1359a) {
            this.f5788a = c1994c;
            super(c1359a);
        }

        public void mo1576a(int i, String str) {
            C1216a.m4519a(C1994c.f5789a, "onSuccessNetwork");
            this.f5788a.g.m4647a("time for update", System.currentTimeMillis());
            this.f5788a.m5218o();
            this.c = this.b.m4969a(new C19921(this), "" + str);
        }

        public void mo1577a(String str, String str2) {
            C1216a.m4519a(C1994c.f5789a, "onSuccessNetwork");
            this.f5788a.g.m4647a("time for update", System.currentTimeMillis());
            this.f5788a.m5218o();
            new C1976b(this.b).m7896b();
            this.f5788a.g.m4648a("nfc_uid", "");
            this.f5788a.m7970j();
        }
    }

    private void m7964g() {
        this.f5791c.setVisibility(4);
        if (C1974a.NFC == m7921d()) {
            C1977c a = new C1976b(getActivity()).m7894a();
            if (a.m7903c() != null) {
                this.f5791c.setText(a.m7903c());
            } else if (a.m7901b() != null) {
                this.f5791c.setText(a.m7901b());
            } else {
                this.f5791c.setText(m7923f());
            }
        }
    }

    private boolean m7966h() {
        return true;
    }

    private void m7967i() {
        this.f5791c.setBackgroundResource(R.drawable.edittext_selector_n);
        this.f5792j.m8023b();
    }

    private void m7970j() {
        final C1514b a = C1514b.m5648a((int) R.string.title_success, (int) R.string.tcash_tap_popup_deactivation_done);
        a.m5651a(new C1326f(this) {
            final /* synthetic */ C1994c f5786b;

            private void m7949c() {
                a.dismiss();
                this.f5786b.getActivity().setResult(-1);
                this.f5786b.getActivity().finish();
            }

            public void mo1485a() {
                m7949c();
            }

            public void mo1486b() {
                m7949c();
            }
        });
        a.show(m5215l(), "notice_dialog_tag");
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f5790b = (C1971a) activity;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_tap_activation, viewGroup, false);
        C1350d.m4929a().m4933a(getActivity(), (ViewGroup) inflate);
        this.f5791c = (EditText) inflate.findViewById(R.id.tcash_tap_serial_edit);
        m7964g();
        this.f5792j = (Random2of6PinEditView) inflate.findViewById(R.id.pin_edit_view);
        C1347a.m4910a().m4912a(this.f5792j.getPinViews());
        this.f5793k = (TextView) inflate.findViewById(R.id.tcash_forget_pin_button);
        this.f5793k.setOnClickListener(new C19891(this));
        this.f5794l = (Button) inflate.findViewById(R.id.tcash_confirm_button);
        this.f5794l.setOnClickListener(new C19902(this));
        m5208c(R.string.tcash_tap_deactivation);
        C1216a.m4519a(f5789a, "uid = " + new C1976b(getActivity()).m7894a().m7903c());
        C1216a.m4519a(f5789a, "android id = " + Secure.getString(getActivity().getContentResolver(), ServerParameters.ANDROID_ID));
        return inflate;
    }

    public void onDetach() {
        super.onDetach();
        this.f5790b = null;
    }
}
