package com.telkom.mwallet.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1272r;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.model.LoginRs;
import com.skcc.wallet.framework.p061c.C1303a;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.home.HomeActivity;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.p064a.C1358h;
import com.telkom.mwallet.setting.ChangePinCodeActivity;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class LoginActivity extends C1359a {
    private static final String f3798p = LoginActivity.class.getSimpleName();
    final int f3799k = 30011;
    String f3800l;
    ScrollView f3801m;
    EditText f3802n;
    Button f3803o;
    private C1272r f3804q;
    private C1303a f3805r;
    private OnClickListener f3806s = new C15771(this);
    private C1326f f3807t = new C15782(this);
    private C1326f f3808u = new C15793(this);

    class C15771 implements OnClickListener {
        final /* synthetic */ LoginActivity f3795a;

        C15771(LoginActivity loginActivity) {
            this.f3795a = loginActivity;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.login_btn:
                    if (C1354g.m4950b(this.f3795a.f3802n)) {
                        if (this.f3795a.f3800l.length() <= 0) {
                            this.f3795a.f3804q.m4648a("msisdn", C1354g.m4958i(this.f3795a.f3802n.getText().toString()));
                            this.f3795a.mo1505o();
                        } else if ("".equals(this.f3795a.f3804q.m4651b("login_token", ""))) {
                            this.f3795a.f3804q.m4648a("msisdn", C1354g.m4958i(this.f3795a.f3802n.getText().toString()));
                            this.f3795a.mo1505o();
                        } else {
                            this.f3795a.f3804q.m4648a("msisdn", this.f3795a.f3800l);
                            Intent intent = new Intent();
                            intent.setClass(this.f3795a.getApplicationContext(), HomeActivity.class);
                            intent.setFlags(603979776);
                            this.f3795a.startActivity(intent);
                        }
                        this.f3795a.finish();
                        return;
                    }
                    this.f3795a.f3802n.requestFocus(this.f3795a.f3802n.length());
                    this.f3795a.h = C1514b.m5647a((int) R.string.check_mobile_number);
                    this.f3795a.h.m5651a(this.f3795a.f3807t);
                    this.f3795a.h.show(this.f3795a.getSupportFragmentManager(), "notice_dialog_tag");
                    return;
                default:
                    return;
            }
        }
    }

    class C15782 implements C1326f {
        final /* synthetic */ LoginActivity f3796a;

        C15782(LoginActivity loginActivity) {
            this.f3796a = loginActivity;
        }

        public void mo1485a() {
            if (this.f3796a.h != null) {
                this.f3796a.h.dismiss();
            }
        }

        public void mo1486b() {
        }
    }

    class C15793 implements C1326f {
        final /* synthetic */ LoginActivity f3797a;

        C15793(LoginActivity loginActivity) {
            this.f3797a = loginActivity;
        }

        public void mo1485a() {
            if (this.f3797a.h != null) {
                this.f3797a.h.dismiss();
            }
            this.f3797a.finish();
        }

        public void mo1486b() {
        }
    }

    public static PublicKey m5819e(String str) {
        return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(str.getBytes()))).getPublicKey();
    }

    private void m5823p() {
        this.f3801m = (ScrollView) findViewById(R.id.scrollview);
    }

    private void m5824q() {
        this.d.m4932a((Context) this, (TextView) findViewById(R.id.titlebar_view), 1);
        this.d.m4932a((Context) this, this.f3802n, 2);
        this.d.m4932a((Context) this, this.f3803o, 4);
    }

    private void m5825r() {
        this.f3804q.m4646a(C1358h.f2935f);
        this.f3804q.m4646a(C1358h.f2934e);
        this.f3804q.m4646a(C1358h.f2937h);
        this.f3804q.m4646a(C1358h.f2936g);
    }

    private void m5826s() {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(603979776);
        startActivity(intent);
        finish();
    }

    private void m5827t() {
        Intent intent = new Intent(this, ChangePinCodeActivity.class);
        intent.putExtra("change_pin_case", 202);
        startActivity(intent);
    }

    private void m5828u() {
        Intent intent = new Intent(this, RevalidationActivity.class);
        intent.putExtra("verify_msisdn_case", 102);
        intent.putExtra("msisdn", this.f3802n.getText().toString());
        startActivity(intent);
    }

    public void mo1487a() {
        m4990k();
        this.h = m4968a(this.f3807t, (int) R.string.no_network, false);
    }

    public void mo1488a(String str) {
        m4973a((Context) this, getString(R.string.loading));
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.f3804q.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        m4991l();
        if ("login".equalsIgnoreCase(str)) {
            LoginRs loginRs = (LoginRs) obj;
            if (i == 30004) {
                m5828u();
            } else if (i == 30001) {
                m5828u();
            } else if (i == 30008) {
                this.h = m4970a(this.f3808u, "" + loginRs.getResult().getMessage(), false);
            } else if (i == 30011) {
                this.f3804q.m4648a("tcash_status", loginRs.getTcashStatus());
                this.f3804q.m4648a("imsi", this.f3805r.m4750d());
                m5827t();
            }
        }
        C1216a.m4519a(f3798p, "onFailNetwork ::" + i);
    }

    public void mo1490a(String str, Object obj) {
        Exception e;
        C1216a.m4519a(f3798p, "onSuccessNetwork");
        this.f3804q.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("login".equalsIgnoreCase(str)) {
            LoginRs loginRs = (LoginRs) obj;
            int code = loginRs.getResult().getCode();
            if (code == 30004) {
                m5828u();
            } else if (code == 30001) {
                m5828u();
            } else if (code == 30008) {
                this.h = m4970a(this.f3808u, "" + loginRs.getResult().getMessage(), false);
            } else if (code == 30011) {
                this.f3804q.m4648a("tcash_status", loginRs.getTcashStatus());
                this.f3804q.m4648a("imsi", this.f3805r.m4750d());
                m5827t();
            } else if (code == 0) {
                this.f3804q.m4648a("tcash_status", loginRs.getTcashStatus());
                this.f3804q.m4648a("imsi", this.f3805r.m4750d());
                m5826s();
            }
        } else if ("getWalletCertificate".equalsIgnoreCase(str)) {
            String str2 = (String) obj;
            Object obj2 = null;
            try {
                obj2 = m5819e(str2);
                this.f3804q.m4653c("WALLET_PUBLIC_KEY", str2);
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                System.out.println(obj2);
            } catch (CertificateException e3) {
                e = e3;
                e.printStackTrace();
                System.out.println(obj2);
            }
            System.out.println(obj2);
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4968a(this.f3807t, (int) R.string.no_response, false);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    protected void mo1505o() {
        Intent intent = new Intent(this, VerifyMSISDNActivity.class);
        intent.putExtra("verify_msisdn_case", 103);
        startActivity(intent);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_login);
        this.f3804q = this.a.m4745e();
        C1298u a = this.a.m4739a();
        this.f3805r = new C1303a(this);
        this.f3804q.m4648a("timeout_key", "no_timeout");
        ((RelativeLayout) findViewById(R.id.pageArea)).getLayoutParams().height = m4987h();
        this.f3802n = (EditText) findViewById(R.id.login_mobile_num_edit);
        this.f3800l = this.f3804q.m4651b("msisdn_autologout", "");
        C1216a.m4523c("", "MSISID----->" + this.f3800l);
        if (this.f3800l.length() > 0) {
            C1216a.m4523c("", "ID-----------> " + this.f3800l);
            this.f3802n.setText(this.f3800l);
            this.f3802n.setSelection(this.f3802n.getText().length());
        }
        this.f3802n.addTextChangedListener(new C1609a(this.f3802n));
        this.f3802n.setRawInputType(3);
        this.f3802n.setHint(R.string.input_mobile_number);
        this.f3803o = (Button) findViewById(R.id.login_btn);
        this.f3803o.setOnClickListener(this.f3806s);
        m5823p();
        m5824q();
        m5825r();
        this.f3802n.requestFocus();
        getWindow().setSoftInputMode(4);
        if ("".equals(this.f3804q.m4651b("WALLET_PUBLIC_KEY", ""))) {
            a.m4727h(this);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f3798p, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f3798p, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f3798p, " in onResume >>>>>");
    }

    public void onStart() {
        super.onStart();
        m4991l();
    }
}
