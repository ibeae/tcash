package com.telkom.mwallet.setting.tcash;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.http.C1245f;
import com.skcc.wallet.framework.api.http.model.ResetTcashPinRs;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1518d.C1511a;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.dialog.p063a.C1495b;
import com.telkom.mwallet.home.HomeActivity;
import com.telkom.mwallet.login.C1604b;
import com.telkom.mwallet.login.C1609a;
import com.telkom.mwallet.login.SMSReceiver;
import com.telkom.mwallet.login.SetTcashPinActivity;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import java.util.Date;

public class TCashForgetPINActivity extends SlidingFrameActivity {
    private static View f4147M = null;
    static long f4148l = 2500;
    private static final String f4149z = TCashForgetPINActivity.class.getSimpleName();
    private EditText f4150A;
    private EditText f4151B;
    private EditText f4152C;
    private EditText f4153D;
    private Button f4154E;
    private EditText f4155F;
    private Button f4156G;
    private TextView f4157H;
    private int f4158I = 1980;
    private int f4159J = 1;
    private int f4160K = 1;
    private String f4161L = "";
    private C1511a f4162N;
    private int f4163O = 0;
    private C1604b f4164P = new C16552(this);
    private OnTouchListener f4165Q = new C16563(this);
    private OnClickListener f4166R = new C16574(this);
    private C1495b f4167S = new C16585(this);
    private C1326f f4168T = new C16596(this);
    private C1326f f4169U = new C16607(this);
    private C1326f f4170V = new C16618(this);
    long f4171k = -1;
    Toast f4172m = null;
    SMSReceiver f4173n = null;
    String f4174o = null;

    class C16541 implements OnClickListener {
        final /* synthetic */ TCashForgetPINActivity f4139a;

        C16541(TCashForgetPINActivity tCashForgetPINActivity) {
            this.f4139a = tCashForgetPINActivity;
        }

        public void onClick(View view) {
            this.f4139a.m6308p();
        }
    }

    class C16552 implements C1604b {
        final /* synthetic */ TCashForgetPINActivity f4140a;

        C16552(TCashForgetPINActivity tCashForgetPINActivity) {
            this.f4140a = tCashForgetPINActivity;
        }

        public void mo1534a(String str) {
            if (str != null && str.length() >= 16) {
                String string = this.f4140a.getString(R.string.smshead_en);
                String string2 = this.f4140a.getString(R.string.smshead_id);
                String string3 = this.f4140a.getString(R.string.smstail);
                if (str.contains(string) || str.contains(string2)) {
                    C1216a.m4522b("smscode", ": " + str);
                    String trim = str.trim();
                    if (str.startsWith(string)) {
                        this.f4140a.f4174o = trim.substring(string.length()).trim();
                    } else if (str.startsWith(string2)) {
                        this.f4140a.f4174o = trim.substring(string2.length()).trim();
                    } else {
                        return;
                    }
                    this.f4140a.f4174o = this.f4140a.f4174o.substring(0, this.f4140a.f4174o.indexOf(string3));
                    this.f4140a.f4163O = this.f4140a.f4163O - 1;
                    if (this.f4140a.f4163O == 0 && this.f4140a.f4173n != null) {
                        this.f4140a.unregisterReceiver(this.f4140a.f4173n);
                        this.f4140a.f4173n = null;
                    }
                    this.f4140a.f4153D.setText(this.f4140a.f4174o);
                }
            }
        }
    }

    class C16563 implements OnTouchListener {
        final /* synthetic */ TCashForgetPINActivity f4141a;

        C16563(TCashForgetPINActivity tCashForgetPINActivity) {
            this.f4141a = tCashForgetPINActivity;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                TCashForgetPINActivity.f4147M = view;
            } else if (motionEvent.getAction() == 1) {
                if (view.equals(TCashForgetPINActivity.f4147M)) {
                    switch (view.getId()) {
                        case R.id.forget_tcashpin_birth_select_button:
                            this.f4141a.f4162N = C1511a.m5642a(this.f4141a.f4158I, this.f4141a.f4159J, this.f4141a.f4160K);
                            this.f4141a.f4162N.m5645a(this.f4141a.f4167S);
                            this.f4141a.f4162N.m5644a(new Date().getTime());
                            this.f4141a.f4162N.show(this.f4141a.getSupportFragmentManager(), "date_dialog_tag");
                            break;
                    }
                }
                TCashForgetPINActivity.f4147M = null;
                return true;
            }
            return false;
        }
    }

    class C16574 implements OnClickListener {
        final /* synthetic */ TCashForgetPINActivity f4142a;

        C16574(TCashForgetPINActivity tCashForgetPINActivity) {
            this.f4142a = tCashForgetPINActivity;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.forget_tcashpin_done_button:
                    this.f4142a.m6314s();
                    if (this.f4142a.m6312r()) {
                        this.f4142a.m6318u();
                        return;
                    }
                    this.f4142a.h = C1514b.m5647a((int) R.string.check_all_input_value);
                    this.f4142a.h.m5651a(this.f4142a.f4168T);
                    this.f4142a.h.show(this.f4142a.getSupportFragmentManager(), "notice_dialog_tag");
                    return;
                default:
                    return;
            }
        }
    }

    class C16585 implements C1495b {
        final /* synthetic */ TCashForgetPINActivity f4143a;

        C16585(TCashForgetPINActivity tCashForgetPINActivity) {
            this.f4143a = tCashForgetPINActivity;
        }

        public void mo1533a(int i, int i2, int i3) {
            if (this.f4143a.f4162N != null) {
                this.f4143a.f4162N.dismiss();
            }
            this.f4143a.f4158I = i;
            this.f4143a.f4159J = i2 + 1;
            this.f4143a.f4160K = i3;
            this.f4143a.f4161L = C1354g.m4944a(i, i2, i3);
            this.f4143a.f4154E.setText(this.f4143a.f4161L);
        }
    }

    class C16596 implements C1326f {
        final /* synthetic */ TCashForgetPINActivity f4144a;

        C16596(TCashForgetPINActivity tCashForgetPINActivity) {
            this.f4144a = tCashForgetPINActivity;
        }

        public void mo1485a() {
            if (this.f4144a.h != null) {
                this.f4144a.h.dismiss();
            }
        }

        public void mo1486b() {
        }
    }

    class C16607 implements C1326f {
        final /* synthetic */ TCashForgetPINActivity f4145a;

        C16607(TCashForgetPINActivity tCashForgetPINActivity) {
            this.f4145a = tCashForgetPINActivity;
        }

        public void mo1485a() {
            if (this.f4145a.h != null) {
                this.f4145a.h.dismiss();
            }
            Intent intent = new Intent(this.f4145a, HomeActivity.class);
            intent.setFlags(603979776);
            this.f4145a.startActivity(intent);
            this.f4145a.finish();
        }

        public void mo1486b() {
        }
    }

    class C16618 implements C1326f {
        final /* synthetic */ TCashForgetPINActivity f4146a;

        C16618(TCashForgetPINActivity tCashForgetPINActivity) {
            this.f4146a = tCashForgetPINActivity;
        }

        public void mo1485a() {
            if (this.f4146a.h != null) {
                this.f4146a.h.dismiss();
            }
            Intent intent = new Intent(this.f4146a, SetTcashPinActivity.class);
            intent.putExtra("before_login", true);
            this.f4146a.startActivity(intent);
            this.f4146a.finish();
        }

        public void mo1486b() {
        }
    }

    private void m6308p() {
        long b = this.b.m4650b("OTPTIME", -1);
        C1216a.m4522b("otp", "request otp");
        if (b > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            b = currentTimeMillis - b;
            C1216a.m4522b("otp", "request timeGap " + b);
            if (b < 30000) {
                if (this.f4171k < 0 || currentTimeMillis > this.f4171k + f4148l) {
                    this.f4172m = Toast.makeText(this, R.string.otp_time_noti, 0);
                    this.f4172m.show();
                    this.f4171k = currentTimeMillis;
                    return;
                }
                return;
            }
        }
        m4972a((Context) this, (int) R.string.loading);
        C1216a.m4522b("otp", "request start otp");
        this.p.m4698b((C1245f) this);
    }

    private void m6310q() {
        this.d.m4932a((Context) this, (TextView) findViewById(R.id.titlebar_view), 1);
        this.d.m4932a((Context) this, this.f4150A, 2);
        this.d.m4932a((Context) this, this.f4151B, 2);
        this.d.m4932a((Context) this, this.f4152C, 2);
        this.d.m4932a((Context) this, this.f4154E, 2);
        this.d.m4932a((Context) this, this.f4153D, 2);
        this.d.m4932a((Context) this, this.f4155F, 2);
        this.d.m4932a((Context) this, this.f4156G, 4);
    }

    private boolean m6312r() {
        if ("".equals(this.f4150A.getText().toString().trim())) {
            this.f4150A.requestFocus();
            this.f4150A.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if ("".equals(this.f4151B.getText().toString().trim())) {
            this.f4151B.requestFocus();
            this.f4151B.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if ("".equals(this.f4152C.getText().toString().trim())) {
            this.f4152C.requestFocus();
            this.f4152C.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if ("".equals(this.f4154E.getText().toString().trim())) {
            this.f4154E.requestFocus();
            this.f4154E.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if ("".equals(this.f4153D.getText().toString().trim())) {
            this.f4153D.requestFocus();
            this.f4153D.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if (!"".equals(this.f4155F.getText().toString().trim())) {
            return true;
        } else {
            this.f4155F.requestFocus();
            this.f4155F.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        }
    }

    private void m6314s() {
        this.f4150A.setBackgroundResource(R.drawable.edittext_selector_top);
        this.f4151B.setBackgroundResource(R.drawable.edittext_selector_middle);
        this.f4152C.setBackgroundResource(R.drawable.edittext_selector_middle);
        this.f4154E.setBackgroundResource(R.drawable.edittext_selector_middle);
        this.f4153D.setBackgroundResource(R.drawable.edittext_selector_middle);
        this.f4155F.setBackgroundResource(R.drawable.edittext_selector_bottom);
    }

    private void m6316t() {
        this.f4163O++;
        this.f4174o = null;
        if (this.f4173n == null) {
            C1216a.m4522b("OTP", "reg Receiver on cnt " + this.f4163O);
            this.f4173n = new SMSReceiver(this.f4164P);
            registerReceiver(this.f4173n, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
        }
    }

    private void m6318u() {
        String trim = this.f4154E.getText().toString().trim();
        this.p.m4718d(this.f4155F.getText().toString().trim(), trim, this.f4151B.getText().toString().trim(), this.f4152C.getText().toString().trim(), this.f4153D.getText().toString().trim(), this);
    }

    public void mo1487a() {
        m4990k();
        this.h = m4967a(this.f4168T, (int) R.string.no_network);
        this.f4156G.setEnabled(true);
        this.f4156G.setClickable(true);
    }

    public void mo1488a(String str) {
        m4972a((Context) this, (int) R.string.loading);
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f4168T, "" + str3);
        this.f4156G.setEnabled(true);
        this.f4156G.setClickable(true);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f4149z, "onSuccessNetwork");
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("verifyTCashSecurityAnswer".equalsIgnoreCase(str)) {
            this.f4156G.setEnabled(true);
            this.f4156G.setClickable(true);
            this.h = C1514b.m5648a((int) R.string.title_success, (int) R.string.msg_temp_pin_sent);
            this.h.m5651a(this.f4169U);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        } else if ("requestOtp".equalsIgnoreCase(str)) {
            this.b.m4647a("OTPTIME", System.currentTimeMillis());
            m6316t();
        } else if ("resetTcashPin".equalsIgnoreCase(str)) {
            ResetTcashPinRs resetTcashPinRs = (ResetTcashPinRs) obj;
            this.h = C1514b.m5648a((int) R.string.title_success, (int) R.string.reset_tcash_pin_succeeded);
            this.h.m5651a(this.f4170V);
            this.h.setCancelable(false);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4967a(this.f4168T, (int) R.string.no_response);
        this.f4156G.setEnabled(true);
        this.f4156G.setClickable(true);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
        this.f4156G.setEnabled(true);
        this.f4156G.setClickable(true);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        C1216a.m4522b(f4149z, "forget Tcash pin " + i);
        switch (i) {
            case 1001:
                if (i2 == -1) {
                    finish();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_tcash_forget_pin);
        this.p = this.a.m4739a();
        this.b = this.a.m4745e();
        CharSequence b = this.b.m4651b("msisdn", "");
        this.f4150A = (EditText) findViewById(R.id.forget_tcashpin_mobilenum_edittext);
        this.f4151B = (EditText) findViewById(R.id.forget_tcashpin_firstname_edittext);
        this.f4152C = (EditText) findViewById(R.id.forget_tcashpin_lastname_edittext);
        this.f4153D = (EditText) findViewById(R.id.enter_otp_edittext);
        this.f4154E = (Button) findViewById(R.id.forget_tcashpin_birth_select_button);
        this.f4155F = (EditText) findViewById(R.id.forget_tcashpin_identity_number_edittext);
        this.f4150A.setText(b);
        this.f4150A.addTextChangedListener(new C1609a(this.f4150A));
        this.f4150A.setRawInputType(3);
        this.f4150A.setHint(R.string.input_mobile_number);
        this.f4154E.setOnTouchListener(this.f4165Q);
        this.f4156G = (Button) findViewById(R.id.forget_tcashpin_done_button);
        this.f4156G.setOnClickListener(this.f4166R);
        m6310q();
        this.f4157H = (TextView) findViewById(R.id.request_new_otp_button);
        this.f4157H.setOnClickListener(new C16541(this));
        this.f4150A.requestFocus();
        getWindow().setSoftInputMode(4);
        m6308p();
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f4149z, " in onDestroy >>>>>");
        if (this.f4173n != null) {
            unregisterReceiver(this.f4173n);
            this.f4173n = null;
            this.f4163O = 0;
        }
        this.b.m4647a("OTPTIME", 0);
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f4149z, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f4149z, " in onResume >>>>>");
    }
}
