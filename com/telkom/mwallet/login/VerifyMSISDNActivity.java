package com.telkom.mwallet.login;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1272r;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.C1245f;
import com.skcc.wallet.framework.api.http.model.RequestOtpRs;
import com.skcc.wallet.framework.p061c.C1303a;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.p063a.C1326f;

public class VerifyMSISDNActivity extends C1359a {
    static long f3920n = 2500;
    private static final String f3921o = VerifyMSISDNActivity.class.getSimpleName();
    private int f3922A = 0;
    private String f3923B = null;
    private C1604b f3924C = new C16052(this);
    private C1326f f3925D = new C16063(this);
    private C1326f f3926E = new C16074(this);
    private OnClickListener f3927F = new C16085(this);
    SMSReceiver f3928k = null;
    String f3929l = null;
    long f3930m = -1;
    private C1272r f3931p;
    private C1298u f3932q;
    private EditText f3933r;
    private EditText f3934s;
    private Button f3935t;
    private TextView f3936u;
    private String f3937v;
    private String f3938w;
    private Toast f3939x = null;
    private boolean f3940y = false;
    private C1303a f3941z;

    class C16031 implements OnClickListener {
        final /* synthetic */ VerifyMSISDNActivity f3915a;

        C16031(VerifyMSISDNActivity verifyMSISDNActivity) {
            this.f3915a = verifyMSISDNActivity;
        }

        public void onClick(View view) {
            this.f3915a.m6048p();
        }
    }

    class C16052 implements C1604b {
        final /* synthetic */ VerifyMSISDNActivity f3916a;

        C16052(VerifyMSISDNActivity verifyMSISDNActivity) {
            this.f3916a = verifyMSISDNActivity;
        }

        public void mo1534a(String str) {
            if (str != null && str.length() >= 16) {
                String string = this.f3916a.getString(R.string.smshead_en);
                String string2 = this.f3916a.getString(R.string.smshead_id);
                String string3 = this.f3916a.getString(R.string.smstail);
                if (str.contains(string) || str.contains(string2)) {
                    C1216a.m4522b("smscode", ": " + str);
                    String trim = str.trim();
                    if (str.startsWith(string)) {
                        this.f3916a.f3929l = trim.substring(string.length()).trim();
                    } else if (str.startsWith(string2)) {
                        this.f3916a.f3929l = trim.substring(string2.length()).trim();
                    } else {
                        return;
                    }
                    this.f3916a.f3929l = this.f3916a.f3929l.substring(0, this.f3916a.f3929l.indexOf(string3));
                    this.f3916a.f3922A = this.f3916a.f3922A - 1;
                    if (this.f3916a.f3922A == 0 && this.f3916a.f3928k != null) {
                        this.f3916a.unregisterReceiver(this.f3916a.f3928k);
                        this.f3916a.f3928k = null;
                    }
                    this.f3916a.f3934s.setText(this.f3916a.f3929l);
                }
            }
        }
    }

    class C16063 implements C1326f {
        final /* synthetic */ VerifyMSISDNActivity f3917a;

        C16063(VerifyMSISDNActivity verifyMSISDNActivity) {
            this.f3917a = verifyMSISDNActivity;
        }

        public void mo1485a() {
            if (this.f3917a.h != null) {
                this.f3917a.h.dismiss();
            }
        }

        public void mo1486b() {
        }
    }

    class C16074 implements C1326f {
        final /* synthetic */ VerifyMSISDNActivity f3918a;

        C16074(VerifyMSISDNActivity verifyMSISDNActivity) {
            this.f3918a = verifyMSISDNActivity;
        }

        public void mo1485a() {
            if (this.f3918a.h != null) {
                this.f3918a.h.dismiss();
            }
            Intent intent = new Intent(this.f3918a, LoginActivity.class);
            intent.setFlags(603979776);
            this.f3918a.startActivity(intent);
            this.f3918a.finish();
        }

        public void mo1486b() {
        }
    }

    class C16085 implements OnClickListener {
        final /* synthetic */ VerifyMSISDNActivity f3919a;

        C16085(VerifyMSISDNActivity verifyMSISDNActivity) {
            this.f3919a = verifyMSISDNActivity;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.verify_msisdn_verifyotp_button:
                    this.f3919a.f3931p.m4648a("msisdn", this.f3919a.f3933r.getText().toString());
                    this.f3919a.m6050r();
                    return;
                default:
                    return;
            }
        }
    }

    private void m6047o() {
        this.f3922A++;
        this.f3929l = null;
        if (this.f3928k == null) {
            C1216a.m4522b("OTP", "reg Receiver on cnt " + this.f3922A);
            this.f3928k = new SMSReceiver(this.f3924C);
            registerReceiver(this.f3928k, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
        }
    }

    private void m6048p() {
        long b = this.f3931p.m4650b("OTPTIME", -1);
        C1216a.m4522b("otp", "request otp");
        if (b > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            b = currentTimeMillis - b;
            C1216a.m4522b("otp", "request timeGap " + b);
            if (b < 30000) {
                if (this.f3930m < 0 || currentTimeMillis > this.f3930m + f3920n) {
                    this.f3939x = Toast.makeText(this, R.string.otp_time_noti, 0);
                    this.f3939x.show();
                    this.f3930m = currentTimeMillis;
                    return;
                }
                return;
            }
        }
        m4972a((Context) this, (int) R.string.loading);
        C1216a.m4522b("otp", "request start otp");
        this.f3932q.m4698b((C1245f) this);
    }

    private void m6049q() {
        View view = (TextView) findViewById(R.id.titlebar_view_bold);
        this.d.m4932a((Context) this, (TextView) findViewById(R.id.titlebar_view), 1);
        this.d.m4932a((Context) this, view, 3);
        this.d.m4932a((Context) this, this.f3934s, 2);
        this.d.m4932a((Context) this, this.f3935t, 3);
        this.d.m4932a((Context) this, this.f3936u, 2);
    }

    private void m6050r() {
        this.f3934s.setBackgroundResource(R.drawable.edittext_selector_top);
        String obj = this.f3934s.getText().toString();
        if (obj == null || obj.length() < 3) {
            this.f3934s.setBackgroundResource(R.drawable.field_sct_red);
            return;
        }
        m4972a((Context) this, (int) R.string.loading);
        this.f3932q.m4684a(this.f3934s.getText().toString(), (C1245f) this);
    }

    private void m6051s() {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), SignUpActivity.class);
        startActivity(intent);
    }

    public void mo1487a() {
        m4990k();
        this.h = m4967a(this.f3925D, (int) R.string.no_network);
    }

    public void mo1488a(String str) {
        m4972a((Context) this, (int) R.string.loading);
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        m4991l();
        this.f3931p.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f3925D, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f3921o, "onSuccessNetwork");
        this.f3931p.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("requestOtp".equalsIgnoreCase(str)) {
            this.f3931p.m4647a("OTPTIME", System.currentTimeMillis());
            m6047o();
            this.f3940y = ((RequestOtpRs) obj).isRegisteredMsisdn();
            C1216a.m4519a(f3921o, "isRegistered = " + this.f3940y);
        } else if (!"verifyOtp".equalsIgnoreCase(str)) {
        } else {
            if (this.f3940y) {
                startActivity(new Intent(this, EnterTcashPinActivity.class));
                finish();
                return;
            }
            m6051s();
            if (this.f3939x != null) {
                this.f3939x.cancel();
            }
            finish();
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4967a(this.f3925D, (int) R.string.no_response);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    public void onBackPressed() {
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_verify_msisdn);
        this.f3932q = this.a.m4739a();
        this.f3931p = this.a.m4745e();
        this.f3937v = getIntent().getStringExtra("TEMP_CUSTOMERID");
        C1216a.m4522b("verify", "temporaryCustomerId" + this.f3937v);
        this.f3933r = (EditText) findViewById(R.id.verify_msisdn_mobilenum_edittext);
        this.f3934s = (EditText) findViewById(R.id.verify_msisdn_otp_edittext);
        this.f3938w = this.f3931p.m4651b("msisdn", "");
        this.f3933r.setText(this.f3938w);
        this.f3933r.setEnabled(false);
        this.f3933r.setFocusable(false);
        this.f3935t = (Button) findViewById(R.id.verify_msisdn_verifyotp_button);
        this.f3935t.setOnClickListener(this.f3927F);
        this.f3936u = (TextView) findViewById(R.id.request_new_code_button);
        this.f3936u.setOnClickListener(new C16031(this));
        m6048p();
        m6049q();
        this.f3941z = new C1303a(this);
        this.f3934s.requestFocus();
        getWindow().setSoftInputMode(4);
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f3921o, " in onDestroy >>>>>");
        if (this.f3928k != null) {
            unregisterReceiver(this.f3928k);
            this.f3928k = null;
            this.f3922A = 0;
        }
        this.f3931p.m4647a("OTPTIME", 0);
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f3921o, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f3921o, " in onResume >>>>>");
    }
}
