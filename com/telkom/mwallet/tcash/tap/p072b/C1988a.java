package com.telkom.mwallet.tcash.tap.p072b;

import android.app.Activity;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.appsflyer.AppsFlyerLib;
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
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class C1988a extends C1987b {
    static final String f5776a = C1988a.class.getSimpleName();
    private C1971a f5777b;
    private EditText f5778c;
    private Random2of6PinEditView f5779j;
    private TextView f5780k;
    private Button f5781l;
    private int f5782m;

    class C19791 implements OnClickListener {
        final /* synthetic */ C1988a f5766a;

        C19791(C1988a c1988a) {
            this.f5766a = c1988a;
        }

        public void onClick(View view) {
            this.f5766a.m7922e();
        }
    }

    class C19802 implements OnClickListener {
        final /* synthetic */ C1988a f5767a;

        C19802(C1988a c1988a) {
            this.f5767a = c1988a;
        }

        public void onClick(View view) {
            this.f5767a.m7946p();
            if (!this.f5767a.m7939j()) {
                this.f5767a.f5778c.setBackgroundResource(R.drawable.field_sct_red);
            } else if (this.f5767a.f5779j.m8024c()) {
                this.f5767a.m5217n();
                if (this.f5767a.m7933g()) {
                    C1977c a = new C1976b(this.f5767a.getActivity()).m7894a();
                    this.f5767a.f5777b.mo1574a(a.m7898a(), this.f5767a.f5779j.getPin(), C1974a.NFC == a.m7898a() ? this.f5767a.m7923f() : a.m7901b(), new C1986b(this.f5767a, this.f5767a.m5216m()));
                    return;
                }
                this.f5767a.f5777b.mo1575b(this.f5767a.m7921d(), this.f5767a.f5779j.getPin(), this.f5767a.f5778c.getText().toString().trim(), new C1984a(this.f5767a, this.f5767a.m5216m()));
            }
        }
    }

    private class C1984a extends C1972b {
        final /* synthetic */ C1988a f5772a;

        class C19831 implements C1326f {
            final /* synthetic */ C1984a f5771a;

            C19831(C1984a c1984a) {
                this.f5771a = c1984a;
            }

            public void mo1485a() {
                this.f5771a.c.dismiss();
            }

            public void mo1486b() {
            }
        }

        public C1984a(C1988a c1988a, C1359a c1359a) {
            this.f5772a = c1988a;
            super(c1359a);
        }

        public void mo1576a(int i, String str) {
            this.f5772a.g.m4647a("time for update", System.currentTimeMillis());
            this.f5772a.m5218o();
            this.c = this.b.m4969a(new C19831(this), "" + str);
        }

        public void mo1577a(String str, String str2) {
            C1216a.m4519a(C1988a.f5776a, "onSuccessNetwork");
            this.f5772a.g.m4647a("time for update", System.currentTimeMillis());
            Map hashMap = new HashMap();
            hashMap.put("ANDROID_ID", Secure.getString(this.f5772a.getActivity().getContentResolver(), ServerParameters.ANDROID_ID).toUpperCase(Locale.US));
            AppsFlyerLib.getInstance().trackEvent(this.f5772a.getActivity(), "NFC Activation", hashMap);
            this.f5772a.m5218o();
            C1976b c1976b = new C1976b(this.b);
            C1977c c1977c = new C1977c();
            c1977c.m7899a(this.f5772a.m7921d());
            c1977c.m7902b(str);
            c1977c.m7904c(str2);
            c1976b.m7895a(c1977c);
            this.f5772a.g.m4648a("nfc_uid", str2);
            this.f5772a.m7924a(C1974a.STICKER == this.f5772a.m7921d() ? R.string.tcash_tap_popup_activation_sticker_success : R.string.tcash_tap_popup_activation_nfc_success);
        }
    }

    private class C1986b extends C1972b {
        final /* synthetic */ C1988a f5774a;

        class C19851 implements C1326f {
            final /* synthetic */ C1986b f5773a;

            C19851(C1986b c1986b) {
                this.f5773a = c1986b;
            }

            public void mo1485a() {
                this.f5773a.c.dismiss();
            }

            public void mo1486b() {
            }
        }

        public C1986b(C1988a c1988a, C1359a c1359a) {
            this.f5774a = c1988a;
            super(c1359a);
        }

        public void mo1576a(int i, String str) {
            this.f5774a.g.m4647a("time for update", System.currentTimeMillis());
            this.f5774a.m5218o();
            this.c = this.b.m4969a(new C19851(this), "" + str);
        }

        public void mo1577a(String str, String str2) {
            C1216a.m4519a(C1988a.f5776a, "onSuccessNetwork");
            this.f5774a.g.m4647a("time for update", System.currentTimeMillis());
            new C1976b(this.f5774a.getActivity()).m7896b();
            this.f5774a.f5777b.mo1575b(this.f5774a.m7921d(), this.f5774a.f5779j.getPin(), this.f5774a.f5778c.getText().toString().trim(), new C1984a(this.f5774a, this.f5774a.m5216m()));
        }
    }

    private void m7924a(int i) {
        final C1514b a = C1514b.m5648a((int) R.string.title_success, i);
        a.m5651a(new C1326f(this) {
            final /* synthetic */ C1988a f5769b;

            private void m7907c() {
                a.dismiss();
                this.f5769b.getActivity().setResult(-1);
                this.f5769b.getActivity().finish();
            }

            public void mo1485a() {
                m7907c();
            }

            public void mo1486b() {
                m7907c();
            }
        });
        a.show(m5215l(), "notice_dialog_tag");
    }

    private boolean m7933g() {
        C1977c a = new C1976b(getActivity()).m7894a();
        return (a == null || C1974a.NONE == a.m7898a()) ? false : true;
    }

    private void m7935h() {
        switch (m7921d()) {
            case STICKER:
                this.f5782m = R.string.tcash_tap_activation_sticker;
                break;
            default:
                this.f5782m = R.string.tcash_tap_activation_nfc;
                break;
        }
        m5208c(this.f5782m);
    }

    private void m7937i() {
        switch (m7921d()) {
            case STICKER:
                this.f5778c.setVisibility(0);
                return;
            default:
                this.f5778c.setVisibility(4);
                this.f5778c.setText(m7923f());
                return;
        }
    }

    private boolean m7939j() {
        return !TextUtils.isEmpty(this.f5778c.getText().toString().trim());
    }

    private void m7946p() {
        this.f5778c.setBackgroundResource(R.drawable.edittext_selector_n);
        this.f5779j.m8023b();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f5777b = (C1971a) activity;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_tap_activation, viewGroup, false);
        C1350d.m4929a().m4933a(getActivity(), (ViewGroup) inflate);
        this.f5778c = (EditText) inflate.findViewById(R.id.tcash_tap_serial_edit);
        m7937i();
        this.f5779j = (Random2of6PinEditView) inflate.findViewById(R.id.pin_edit_view);
        C1347a.m4910a().m4912a(this.f5779j.getPinViews());
        this.f5780k = (TextView) inflate.findViewById(R.id.tcash_forget_pin_button);
        this.f5780k.setOnClickListener(new C19791(this));
        this.f5781l = (Button) inflate.findViewById(R.id.tcash_confirm_button);
        this.f5781l.setOnClickListener(new C19802(this));
        m7935h();
        return inflate;
    }

    public void onDetach() {
        super.onDetach();
        this.f5777b = null;
    }
}
