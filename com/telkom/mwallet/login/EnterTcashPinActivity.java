package com.telkom.mwallet.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.appsflyer.ServerParameters;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.C1245f;
import com.skcc.wallet.framework.api.http.model.CheckUserStatusRs;
import com.skcc.wallet.framework.api.http.model.CheckWalletUpdateRs;
import com.skcc.wallet.framework.api.http.model.LoginRs;
import com.skcc.wallet.framework.api.http.model.MobileInfo;
import com.skcc.wallet.framework.api.http.model.RegisterUserMobileRs;
import com.skcc.wallet.framework.api.http.model.UnlinkOtherNfcTagRs;
import com.skcc.wallet.framework.api.http.model.VerifyTcashPinForRegisterRs;
import com.skcc.wallet.framework.p061c.C1303a;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.home.HomeActivity;
import com.telkom.mwallet.p064a.C1349c;
import com.telkom.mwallet.p064a.C1353f;
import com.telkom.mwallet.setting.tcash.TCashForgetPINActivity;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class EnterTcashPinActivity extends C1359a implements C1245f {
    private static final String f3786k = EnterTcashPinActivity.class.getSimpleName();
    private EditText f3787l;
    private Button f3788m;
    private TextView f3789n;
    private C1303a f3790o;
    private C1298u f3791p;
    private String f3792q;
    private C1326f f3793r = new C15753(this);
    private C1326f f3794s = new C15764(this);

    class C15731 implements OnClickListener {
        final /* synthetic */ EnterTcashPinActivity f3782a;

        C15731(EnterTcashPinActivity enterTcashPinActivity) {
            this.f3782a = enterTcashPinActivity;
        }

        public void onClick(View view) {
            this.f3782a.m5797q();
        }
    }

    class C15742 implements OnClickListener {
        final /* synthetic */ EnterTcashPinActivity f3783a;

        C15742(EnterTcashPinActivity enterTcashPinActivity) {
            this.f3783a = enterTcashPinActivity;
        }

        public void onClick(View view) {
            if (!this.f3783a.m5795o()) {
                return;
            }
            if (this.f3783a.getIntent().getBooleanExtra("from_sign_up", false)) {
                this.f3783a.m5800t();
            } else {
                this.f3783a.m5801u();
            }
        }
    }

    class C15753 implements C1326f {
        final /* synthetic */ EnterTcashPinActivity f3784a;

        C15753(EnterTcashPinActivity enterTcashPinActivity) {
            this.f3784a = enterTcashPinActivity;
        }

        public void mo1485a() {
            if (this.f3784a.h != null) {
                this.f3784a.h.dismiss();
            }
            this.f3784a.m5803w();
        }

        public void mo1486b() {
        }
    }

    class C15764 implements C1326f {
        final /* synthetic */ EnterTcashPinActivity f3785a;

        C15764(EnterTcashPinActivity enterTcashPinActivity) {
            this.f3785a = enterTcashPinActivity;
        }

        public void mo1485a() {
            if (this.f3785a.h != null) {
                this.f3785a.h.dismiss();
            }
        }

        public void mo1486b() {
            if (this.f3785a.h != null) {
                this.f3785a.h.dismiss();
            }
        }
    }

    private void m5788e(String str) {
        this.f3791p.m4735n(str, this);
    }

    private boolean m5795o() {
        String obj = this.f3787l.getText().toString();
        if (obj.isEmpty()) {
            this.f3787l.setBackgroundResource(R.drawable.field_sct_red);
            C1353f.m4941a(this.f3787l);
            return false;
        } else if (obj.length() >= 6) {
            return true;
        } else {
            this.f3787l.setBackgroundResource(R.drawable.field_sct_red);
            this.h = C1514b.m5648a((int) R.string.title_notice, (int) R.string.pin_short);
            this.h.m5651a(this.f3794s);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
            return false;
        }
    }

    private void m5796p() {
        View view = (TextView) findViewById(R.id.titlebar_view_bold);
        this.d.m4932a((Context) this, (TextView) findViewById(R.id.titlebar_view), 1);
        this.d.m4932a((Context) this, view, 3);
        this.d.m4932a((Context) this, this.f3787l, 2);
        this.d.m4932a((Context) this, this.f3788m, 3);
        this.d.m4932a((Context) this, this.f3789n, 2);
    }

    private void m5797q() {
        this.f3791p.m4734m(this.b.m4651b("msisdn", ""), this);
    }

    private PublicKey m5798r() {
        PublicKey e;
        Exception e2;
        String b = this.b.m4651b("WALLET_PUBLIC_KEY", "");
        C1216a.m4519a(f3786k, "key = " + b);
        try {
            e = LoginActivity.m5819e(b);
        } catch (IOException e3) {
            e2 = e3;
            e2.printStackTrace();
            e = null;
            C1216a.m4519a(f3786k, "pubKey = " + e);
            return e;
        } catch (CertificateException e4) {
            e2 = e4;
            e2.printStackTrace();
            e = null;
            C1216a.m4519a(f3786k, "pubKey = " + e);
            return e;
        }
        C1216a.m4519a(f3786k, "pubKey = " + e);
        return e;
    }

    private String m5799s() {
        String a;
        GeneralSecurityException e;
        try {
            a = C1349c.m4916a(m5798r(), this.f3787l.getText().toString());
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            e.printStackTrace();
            a = null;
            C1216a.m4519a(f3786k, "encTcashPin = " + a);
            return a;
        } catch (NoSuchPaddingException e3) {
            e = e3;
            e.printStackTrace();
            a = null;
            C1216a.m4519a(f3786k, "encTcashPin = " + a);
            return a;
        } catch (InvalidKeyException e4) {
            e = e4;
            e.printStackTrace();
            a = null;
            C1216a.m4519a(f3786k, "encTcashPin = " + a);
            return a;
        } catch (IllegalBlockSizeException e5) {
            e = e5;
            e.printStackTrace();
            a = null;
            C1216a.m4519a(f3786k, "encTcashPin = " + a);
            return a;
        } catch (BadPaddingException e6) {
            e = e6;
            e.printStackTrace();
            a = null;
            C1216a.m4519a(f3786k, "encTcashPin = " + a);
            return a;
        }
        C1216a.m4519a(f3786k, "encTcashPin = " + a);
        return a;
    }

    private void m5800t() {
        this.f3791p.m4732k(m5799s(), this);
    }

    private void m5801u() {
        MobileInfo mobileInfo = new MobileInfo();
        mobileInfo.setModelNo(this.f3790o.m4747a());
        mobileInfo.setImei(this.f3790o.m4751e());
        mobileInfo.setImsi(this.f3790o.m4750d());
        mobileInfo.setPushId(this.b.m4651b("gcm_registration_id", ""));
        mobileInfo.setWalletVersion(this.f3790o.m4749c());
        mobileInfo.setOsVer(this.f3790o.m4748b());
        this.f3791p.m4687a(m5799s(), m5802v(), mobileInfo, (C1245f) this);
    }

    private String m5802v() {
        String b = C1349c.m4922b(this.b.m4651b("msisdn", "") + this.f3790o.m4751e() + this.f3790o.m4750d());
        this.b.m4648a("token_data", b);
        return b;
    }

    private void m5803w() {
        this.f3791p.m4686a("ID", this.f3790o.m4748b(), (C1245f) this);
    }

    public void mo1487a() {
        m4990k();
        this.h = m4967a(this.f3794s, (int) R.string.no_network);
    }

    public void mo1488a(String str) {
        m4972a((Context) this, (int) R.string.loading);
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        m4991l();
        if (!"unlinkOtherNfcTag".equalsIgnoreCase(str)) {
            this.h = m4970a(this.f3794s, str3, false);
        } else if (!((UnlinkOtherNfcTagRs) obj).isUnlinkDone()) {
            this.f3791p.m4686a("ID", this.f3790o.m4748b(), (C1245f) this);
        }
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f3786k, "onSuccessNetwork");
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("registerUserMobile".equals(str)) {
            RegisterUserMobileRs registerUserMobileRs = (RegisterUserMobileRs) obj;
            try {
                this.f3792q = C1349c.m4926c(this.f3787l.getText().toString(), registerUserMobileRs.getEncTokenKey());
            } catch (Exception e) {
                e.printStackTrace();
            }
            C1216a.m4519a(f3786k, this.f3792q);
            this.b.m4648a("login_token", m5802v());
            this.b.m4648a("TOKEN_KEY", this.f3792q);
            this.b.m4648a("customer_id", registerUserMobileRs.getCustomerId());
            m5788e(Secure.getString(getContentResolver(), ServerParameters.ANDROID_ID));
        } else if ("verifyTcashPinForRegister".equalsIgnoreCase(str)) {
            VerifyTcashPinForRegisterRs verifyTcashPinForRegisterRs = (VerifyTcashPinForRegisterRs) obj;
            try {
                this.f3792q = C1349c.m4926c(this.f3787l.getText().toString(), verifyTcashPinForRegisterRs.getEncTokenKey());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            C1216a.m4519a(f3786k, this.f3792q);
            this.b.m4648a("login_token", m5802v());
            this.b.m4648a("TOKEN_KEY", this.f3792q);
            this.b.m4648a("customer_id", verifyTcashPinForRegisterRs.getCustomerId());
            m5788e(Secure.getString(getContentResolver(), ServerParameters.ANDROID_ID));
        } else if ("checkWalletUpdate".equals(str)) {
            CheckWalletUpdateRs checkWalletUpdateRs = (CheckWalletUpdateRs) obj;
            String str2 = null;
            try {
                str2 = C1349c.m4915a(this.f3792q, checkWalletUpdateRs.getTimestamp());
                this.b.m4648a("SESSION_KEY", C1349c.m4915a(this.f3792q, C1349c.m4922b(checkWalletUpdateRs.getTimestamp())));
            } catch (Exception e22) {
                e22.printStackTrace();
            }
            this.f3791p.m4693a(this.f3790o.m4750d(), this.f3790o.m4751e(), m5802v(), str2, this);
        } else if ("login".equals(str)) {
            LoginRs loginRs = (LoginRs) obj;
            this.b.m4648a("user_info_firstname", loginRs.getFirstName());
            this.b.m4648a("user_info_lastname", loginRs.getLastName());
            this.b.m4648a("TCASH_STATUS", loginRs.getTcashStatus());
            if ("Normal".equalsIgnoreCase(loginRs.getPinStatus())) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), HomeActivity.class);
                intent.setFlags(603979776);
                startActivity(intent);
                finish();
                return;
            }
            startActivity(new Intent(this, SetTcashPinActivity.class));
            finish();
        } else if ("checkUserStatus".equalsIgnoreCase(str)) {
            CheckUserStatusRs checkUserStatusRs = (CheckUserStatusRs) obj;
            if ("BASIC_SERVICE".equalsIgnoreCase(checkUserStatusRs.getTcashStatus())) {
                this.h = m4968a(this.f3794s, (int) R.string.cannot_reset_tcash_pin, false);
            } else if ("FULL_SERVICE".equalsIgnoreCase(checkUserStatusRs.getTcashStatus())) {
                startActivity(new Intent(this, TCashForgetPINActivity.class));
                finish();
            }
        } else if (!"unlinkOtherNfcTag".equalsIgnoreCase(str)) {
        } else {
            if (((UnlinkOtherNfcTagRs) obj).isUnlinkDone()) {
                this.h = C1514b.m5648a((int) R.string.title_success, (int) R.string.unlink_nfc_tap_popup);
                this.h.m5651a(this.f3793r);
                this.h.setCancelable(false);
                this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
                return;
            }
            this.f3791p.m4686a("ID", this.f3790o.m4748b(), (C1245f) this);
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4967a(this.f3794s, (int) R.string.no_response);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_enter_tcash_pin);
        this.f3790o = new C1303a(this);
        this.f3791p = this.a.m4739a();
        this.f3787l = (EditText) findViewById(R.id.enter_tcash_pin);
        this.f3788m = (Button) findViewById(R.id.verify_tcash_pin_button);
        this.f3789n = (TextView) findViewById(R.id.forgot_tcash_pin_textview);
        this.f3789n.setOnClickListener(new C15731(this));
        this.f3788m.setOnClickListener(new C15742(this));
        m5796p();
        this.f3787l.requestFocus();
        getWindow().setSoftInputMode(4);
    }
}
