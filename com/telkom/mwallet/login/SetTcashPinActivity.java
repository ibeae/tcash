package com.telkom.mwallet.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.http.C1245f;
import com.skcc.wallet.framework.api.http.model.CheckUserStatusRs;
import com.skcc.wallet.framework.api.http.model.CheckWalletUpdateRs;
import com.skcc.wallet.framework.api.http.model.LoginRs;
import com.skcc.wallet.framework.api.http.model.SetTcashPinForRegisterRs;
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
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class SetTcashPinActivity extends C1359a implements C1245f {
    private static final String f3859k = SetTcashPinActivity.class.getSimpleName();
    private EditText f3860l;
    private EditText f3861m;
    private Button f3862n;
    private String f3863o;
    private C1303a f3864p;
    private C1326f f3865q = new C15902(this);
    private C1326f f3866r = new C15913(this);
    private C1326f f3867s = new C15924(this);

    class C15891 implements OnClickListener {
        final /* synthetic */ SetTcashPinActivity f3855a;

        C15891(SetTcashPinActivity setTcashPinActivity) {
            this.f3855a = setTcashPinActivity;
        }

        public void onClick(View view) {
            if (!this.f3855a.m5933r()) {
                return;
            }
            if (this.f3855a.getIntent().getBooleanExtra("from_sign_up", false)) {
                this.f3855a.m5935t();
            } else if (this.f3855a.getIntent().getBooleanExtra("before_login", false)) {
                this.f3855a.m5936u();
            } else {
                String str = null;
                try {
                    str = C1349c.m4915a(this.f3855a.b.m4651b("SESSION_KEY", ""), this.f3855a.f3860l.getText().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                C1216a.m4519a(SetTcashPinActivity.f3859k, "encTcashPin = " + str);
                this.f3855a.m5922e(str);
            }
        }
    }

    class C15902 implements C1326f {
        final /* synthetic */ SetTcashPinActivity f3856a;

        C15902(SetTcashPinActivity setTcashPinActivity) {
            this.f3856a = setTcashPinActivity;
        }

        public void mo1485a() {
            if (this.f3856a.h != null) {
                this.f3856a.h.dismiss();
            }
            Intent intent = new Intent();
            intent.setClass(this.f3856a.getApplicationContext(), HomeActivity.class);
            intent.setFlags(603979776);
            this.f3856a.startActivity(intent);
            this.f3856a.finish();
        }

        public void mo1486b() {
        }
    }

    class C15913 implements C1326f {
        final /* synthetic */ SetTcashPinActivity f3857a;

        C15913(SetTcashPinActivity setTcashPinActivity) {
            this.f3857a = setTcashPinActivity;
        }

        public void mo1485a() {
            if (this.f3857a.h != null) {
                this.f3857a.h.dismiss();
            }
        }

        public void mo1486b() {
        }
    }

    class C15924 implements C1326f {
        final /* synthetic */ SetTcashPinActivity f3858a;

        C15924(SetTcashPinActivity setTcashPinActivity) {
            this.f3858a = setTcashPinActivity;
        }

        public void mo1485a() {
            if (this.f3858a.h != null) {
                this.f3858a.h.dismiss();
            }
            this.f3858a.m5937v();
        }

        public void mo1486b() {
        }
    }

    private void m5922e(String str) {
        this.a.m4739a().m4731j(str, this);
    }

    private void m5931p() {
        View view = (TextView) findViewById(R.id.titlebar_view_bold);
        this.d.m4932a((Context) this, (TextView) findViewById(R.id.titlebar_view), 1);
        this.d.m4932a((Context) this, view, 3);
        this.d.m4932a((Context) this, this.f3860l, 2);
        this.d.m4932a((Context) this, this.f3861m, 2);
        this.d.m4932a((Context) this, this.f3862n, 4);
    }

    private void m5932q() {
        this.f3860l = (EditText) findViewById(R.id.set_tcash_pin_change_pin_edittext);
        this.f3861m = (EditText) findViewById(R.id.set_tcash_pin_confirm_pin_edittext);
        this.f3862n = (Button) findViewById(R.id.set_tcash_pin_done_button);
        m5931p();
        this.f3862n.setOnClickListener(new C15891(this));
    }

    private boolean m5933r() {
        String obj = this.f3860l.getText().toString();
        String obj2 = this.f3861m.getText().toString();
        if (obj.isEmpty()) {
            this.f3860l.setBackgroundResource(R.drawable.field_sct_red);
            C1353f.m4941a(this.f3860l);
            return false;
        } else if (obj.length() < 6) {
            this.f3860l.setBackgroundResource(R.drawable.field_sct_red);
            this.h = C1514b.m5648a((int) R.string.title_notice, (int) R.string.pin_short);
            this.h.m5651a(this.f3865q);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
            return false;
        } else if (obj2.isEmpty()) {
            this.f3861m.setBackgroundResource(R.drawable.field_sct_red);
            C1353f.m4941a(this.f3861m);
            return false;
        } else if (obj2.length() < 6) {
            this.f3861m.setBackgroundResource(R.drawable.field_sct_red);
            this.h = C1514b.m5648a((int) R.string.title_notice, (int) R.string.pin_short);
            this.h.m5651a(this.f3865q);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
            return false;
        } else if (obj.equals(obj2)) {
            return true;
        } else {
            this.f3861m.setBackgroundResource(R.drawable.field_sct_red);
            this.h = C1514b.m5648a((int) R.string.title_notice, (int) R.string.passcodes_did_not_match);
            this.h.m5651a(this.f3865q);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
            return false;
        }
    }

    private String m5934s() {
        String b = C1349c.m4922b(this.b.m4651b("msisdn", "") + this.f3864p.m4751e() + this.f3864p.m4750d());
        this.b.m4648a("token_data", b);
        return b;
    }

    private void m5935t() {
        PublicKey e;
        Object obj;
        String str = null;
        String b = this.b.m4651b("WALLET_PUBLIC_KEY", "");
        C1216a.m4519a(f3859k, "key = " + b);
        try {
            e = LoginActivity.m5819e(b);
        } catch (IOException e2) {
            e2.printStackTrace();
            obj = str;
        } catch (CertificateException e3) {
            e3.printStackTrace();
            obj = str;
        }
        C1216a.m4519a(f3859k, "public key = " + e);
        try {
            str = C1349c.m4916a(e, this.f3860l.getText().toString());
        } catch (NoSuchAlgorithmException e4) {
            e4.printStackTrace();
        } catch (NoSuchPaddingException e5) {
            e5.printStackTrace();
        } catch (InvalidKeyException e6) {
            e6.printStackTrace();
        } catch (IllegalBlockSizeException e7) {
            e7.printStackTrace();
        } catch (BadPaddingException e8) {
            e8.printStackTrace();
        }
        C1216a.m4519a(f3859k, "encTcashPin = " + str);
        this.a.m4739a().m4733l(str, this);
    }

    private void m5936u() {
        PublicKey e;
        Object obj;
        String str = null;
        String b = this.b.m4651b("WALLET_PUBLIC_KEY", "");
        C1216a.m4519a(f3859k, "key = " + b);
        try {
            e = LoginActivity.m5819e(b);
        } catch (IOException e2) {
            e2.printStackTrace();
            obj = str;
        } catch (CertificateException e3) {
            e3.printStackTrace();
            obj = str;
        }
        C1216a.m4519a(f3859k, "public key = " + e);
        try {
            str = C1349c.m4916a(e, this.f3860l.getText().toString());
        } catch (NoSuchAlgorithmException e4) {
            e4.printStackTrace();
        } catch (NoSuchPaddingException e5) {
            e5.printStackTrace();
        } catch (InvalidKeyException e6) {
            e6.printStackTrace();
        } catch (IllegalBlockSizeException e7) {
            e7.printStackTrace();
        } catch (BadPaddingException e8) {
            e8.printStackTrace();
        }
        C1216a.m4519a(f3859k, "encTcashPin = " + str);
        this.a.m4739a().m4736o(str, this);
    }

    private void m5937v() {
        this.a.m4739a().m4686a("ID", this.f3864p.m4748b(), (C1245f) this);
    }

    public void mo1487a() {
        m4990k();
        this.h = m4967a(this.f3865q, (int) R.string.no_network);
    }

    public void mo1488a(String str) {
        m4972a((Context) this, (int) R.string.loading);
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4970a(this.f3866r, str3, false);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f3859k, "onSuccessNetwork");
        this.b.m4647a("time for update", System.currentTimeMillis());
        if ("setTcashPinForRegister".equalsIgnoreCase(str)) {
            SetTcashPinForRegisterRs setTcashPinForRegisterRs = (SetTcashPinForRegisterRs) obj;
            try {
                this.f3863o = C1349c.m4926c(this.f3860l.getText().toString(), setTcashPinForRegisterRs.getEncTokenKey());
            } catch (Exception e) {
                e.printStackTrace();
            }
            C1216a.m4519a(f3859k, this.f3863o);
            this.b.m4648a("login_token", m5934s());
            this.b.m4648a("TOKEN_KEY", this.f3863o);
            this.b.m4648a("customer_id", setTcashPinForRegisterRs.getCustomerId());
            this.a.m4739a().m4686a("ID", this.f3864p.m4748b(), (C1245f) this);
        } else if ("checkWalletUpdate".equals(str)) {
            CheckWalletUpdateRs checkWalletUpdateRs = (CheckWalletUpdateRs) obj;
            String str2 = null;
            this.f3863o = this.b.m4651b("TOKEN_KEY", "");
            try {
                str2 = C1349c.m4915a(this.f3863o, checkWalletUpdateRs.getTimestamp());
                this.b.m4648a("SESSION_KEY", C1349c.m4915a(this.f3863o, C1349c.m4922b(checkWalletUpdateRs.getTimestamp())));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.a.m4739a().m4693a(this.f3864p.m4750d(), this.f3864p.m4751e(), m5934s(), str2, this);
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
                m4968a(this.f3865q, (int) R.string.cannot_reset_tcash_pin, false);
            } else if ("FULL_SERVICE".equalsIgnoreCase(checkUserStatusRs.getTcashStatus())) {
                startActivity(new Intent(this, TCashForgetPINActivity.class));
                finish();
            }
        } else if ("setTcashPin".equalsIgnoreCase(str)) {
            this.h = C1514b.m5648a((int) R.string.title_success, (int) R.string.set_tcash_pin_success);
            this.h.m5651a(this.f3865q);
            this.h.setCancelable(false);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        } else if ("setTcashPinAfterReset".equalsIgnoreCase(str)) {
            this.h = C1514b.m5648a((int) R.string.title_success, (int) R.string.set_tcash_pin_success);
            this.h.m5651a(this.f3867s);
            this.h.setCancelable(false);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4967a(this.f3865q, (int) R.string.no_response);
    }

    public void onBackPressed() {
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_set_tcash_pin);
        this.f3864p = new C1303a(this);
        m5932q();
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f3859k, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f3859k, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f3859k, " in onResume >>>>>");
    }
}
