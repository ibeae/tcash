package com.telkom.mwallet.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1272r;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.C1245f;
import com.skcc.wallet.framework.api.http.model.MobileInfo;
import com.skcc.wallet.framework.api.http.model.RegisterUserRs;
import com.skcc.wallet.framework.api.http.model.UserInfo;
import com.skcc.wallet.framework.p061c.C1303a;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1518d.C1511a;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.dialog.p063a.C1495b;
import com.telkom.mwallet.home.HomeActivity;
import com.telkom.mwallet.p064a.C1349c;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.p064a.C1358h;
import java.util.Date;

public class SignUpActivity extends C1359a {
    private static final String f3873m = SignUpActivity.class.getSimpleName();
    private static View f3874p = null;
    private int f3875A = 1;
    private int f3876B = 1;
    private String f3877C = "";
    private boolean f3878D = false;
    private boolean f3879E = false;
    private boolean f3880F = false;
    private OnClickListener f3881G = new C15931(this);
    private OnTouchListener f3882H = new C15942(this);
    private C1495b f3883I = new C15953(this);
    private C1326f f3884J = new C15964(this);
    private C1326f f3885K = new C15975(this);
    C1303a f3886k;
    String f3887l = null;
    private C1298u f3888n;
    private C1272r f3889o;
    private TextView f3890q;
    private EditText f3891r;
    private EditText f3892s;
    private EditText f3893t;
    private Button f3894u;
    private Button f3895v;
    private Button f3896w;
    private Button f3897x;
    private C1511a f3898y;
    private int f3899z = 1980;

    class C15931 implements OnClickListener {
        final /* synthetic */ SignUpActivity f3868a;

        C15931(SignUpActivity signUpActivity) {
            this.f3868a = signUpActivity;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.signup_cancel_button:
                    this.f3868a.finish();
                    return;
                case R.id.signup_gennder_female_button:
                    if (this.f3868a.f3896w.isSelected()) {
                        this.f3868a.f3896w.setSelected(false);
                        this.f3868a.f3895v.setSelected(true);
                        return;
                    }
                    this.f3868a.f3896w.setSelected(true);
                    this.f3868a.f3895v.setSelected(false);
                    return;
                case R.id.signup_gennder_male_button:
                    if (this.f3868a.f3895v.isSelected()) {
                        this.f3868a.f3895v.setSelected(false);
                        this.f3868a.f3896w.setSelected(true);
                        return;
                    }
                    this.f3868a.f3895v.setSelected(true);
                    this.f3868a.f3896w.setSelected(false);
                    return;
                case R.id.signup_submit_button:
                    this.f3868a.m5976r();
                    if (!this.f3868a.m5978s()) {
                        this.f3868a.h = C1514b.m5647a((int) R.string.check_all_input_value);
                        this.f3868a.h.m5651a(this.f3868a.f3884J);
                        this.f3868a.h.show(this.f3868a.getSupportFragmentManager(), "notice_dialog_tag");
                        return;
                    } else if (C1354g.m4948a(this.f3868a.f3893t)) {
                        this.f3868a.m5982u();
                        return;
                    } else {
                        this.f3868a.f3893t.requestFocus(this.f3868a.f3893t.length());
                        this.f3868a.f3893t.setBackgroundResource(R.drawable.field_sct_red);
                        this.f3868a.h = C1514b.m5648a((int) R.string.warning, (int) R.string.check_email);
                        this.f3868a.h.m5651a(this.f3868a.f3884J);
                        this.f3868a.h.show(this.f3868a.getSupportFragmentManager(), "notice_dialog_tag");
                        return;
                    }
                default:
                    return;
            }
        }
    }

    class C15942 implements OnTouchListener {
        final /* synthetic */ SignUpActivity f3869a;

        C15942(SignUpActivity signUpActivity) {
            this.f3869a = signUpActivity;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                SignUpActivity.f3874p = view;
            } else if (motionEvent.getAction() == 1) {
                if (view.equals(SignUpActivity.f3874p)) {
                    switch (view.getId()) {
                        case R.id.signup_birth_date_button:
                            this.f3869a.f3898y = C1511a.m5642a(this.f3869a.f3899z, this.f3869a.f3875A, this.f3869a.f3876B);
                            this.f3869a.f3898y.m5645a(this.f3869a.f3883I);
                            this.f3869a.f3898y.m5644a(new Date().getTime());
                            this.f3869a.f3898y.show(this.f3869a.getSupportFragmentManager(), "date_dialog_tag");
                            break;
                    }
                }
                SignUpActivity.f3874p = null;
                return true;
            }
            return false;
        }
    }

    class C15953 implements C1495b {
        final /* synthetic */ SignUpActivity f3870a;

        C15953(SignUpActivity signUpActivity) {
            this.f3870a = signUpActivity;
        }

        public void mo1533a(int i, int i2, int i3) {
            if (this.f3870a.f3898y != null) {
                this.f3870a.f3898y.dismiss();
            }
            this.f3870a.f3899z = i;
            this.f3870a.f3875A = i2 + 1;
            this.f3870a.f3876B = i3;
            this.f3870a.f3877C = C1354g.m4944a(i, i2, i3);
            this.f3870a.f3894u.setText(this.f3870a.f3877C);
        }
    }

    class C15964 implements C1326f {
        final /* synthetic */ SignUpActivity f3871a;

        C15964(SignUpActivity signUpActivity) {
            this.f3871a = signUpActivity;
        }

        public void mo1485a() {
            if (this.f3871a.h != null) {
                this.f3871a.h.dismiss();
            }
        }

        public void mo1486b() {
        }
    }

    class C15975 implements C1326f {
        final /* synthetic */ SignUpActivity f3872a;

        C15975(SignUpActivity signUpActivity) {
            this.f3872a = signUpActivity;
        }

        public void mo1485a() {
            if (this.f3872a.h != null) {
                this.f3872a.h.dismiss();
            }
            this.f3872a.m5984v();
        }

        public void mo1486b() {
        }
    }

    private void m5974q() {
        this.d.m4934a((Context) this, (ViewGroup) getWindow().getDecorView().findViewById(16908290), 2);
        this.d.m4932a((Context) this, (TextView) findViewById(R.id.titlebar_view), 1);
        this.d.m4932a((Context) this, this.f3897x, 4);
    }

    private void m5976r() {
        this.f3891r.setBackgroundResource(R.drawable.edittext_selector_top);
        this.f3892s.setBackgroundResource(R.drawable.edittext_selector_middle);
        this.f3894u.setBackgroundResource(R.drawable.edittext_selector_middle);
        this.f3893t.setBackgroundResource(R.drawable.edittext_selector_top);
    }

    private boolean m5978s() {
        if ("".equals(this.f3891r.getText().toString().trim())) {
            this.f3891r.requestFocus();
            this.f3891r.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if ("".equals(this.f3892s.getText().toString().trim())) {
            this.f3892s.requestFocus();
            this.f3892s.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if ("".equals(this.f3894u.getText().toString().trim())) {
            this.f3894u.requestFocus();
            this.f3894u.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if (!"".equals(this.f3893t.getText().toString().trim())) {
            return true;
        } else {
            this.f3893t.requestFocus();
            this.f3893t.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        }
    }

    private String m5980t() {
        C1303a c1303a = new C1303a(this);
        String b = C1349c.m4922b(this.f3889o.m4651b("msisdn", "") + c1303a.m4751e() + c1303a.m4750d());
        this.f3889o.m4648a("token_data", b);
        return b;
    }

    private void m5982u() {
        m4972a((Context) this, (int) R.string.loading);
        String t = m5980t();
        UserInfo userInfo = new UserInfo();
        userInfo.setFirstName(this.f3891r.getText().toString());
        userInfo.setLastName(this.f3892s.getText().toString());
        userInfo.setDateOfBirth(this.f3894u.getText().toString());
        if (this.f3895v.isSelected()) {
            userInfo.setGender("Male");
        } else {
            userInfo.setGender("Female");
        }
        userInfo.setEmail(this.f3893t.getText().toString());
        userInfo.setMno(C1358h.f2931b);
        userInfo.setToken(t);
        MobileInfo mobileInfo = new MobileInfo();
        mobileInfo.setModelNo(this.f3886k.m4747a());
        mobileInfo.setImei(this.f3886k.m4751e());
        mobileInfo.setImsi(this.f3886k.m4750d());
        mobileInfo.setPushId(this.f3889o.m4651b("gcm_registration_id", ""));
        mobileInfo.setWalletVersion(this.f3886k.m4749c());
        mobileInfo.setOsVer(this.f3886k.m4748b());
        this.f3888n.m4677a(userInfo, mobileInfo, (C1245f) this);
    }

    private void m5984v() {
        if (this.f3880F) {
            Intent intent = new Intent();
            intent.setClass(getApplicationContext(), HomeActivity.class);
            intent.setFlags(603979776);
            startActivity(intent);
            finish();
            return;
        }
        this.f3878D = true;
    }

    public void mo1487a() {
        m4990k();
        this.h = m4968a(this.f3884J, (int) R.string.no_network, false);
    }

    public void mo1488a(String str) {
        m4972a((Context) this, (int) R.string.loading);
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.f3889o.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if (i != 30003) {
            this.h = m4969a(this.f3884J, "" + str3);
        }
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f3873m, "onSuccessNetwork");
        this.f3889o.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("registerUser".equalsIgnoreCase(str)) {
            RegisterUserRs registerUserRs = (RegisterUserRs) obj;
            Intent intent;
            if ("Normal".equalsIgnoreCase(registerUserRs.getPinStatus())) {
                intent = new Intent(this, EnterTcashPinActivity.class);
                intent.putExtra("from_sign_up", true);
                startActivity(intent);
                finish();
            } else if ("Disabled".equalsIgnoreCase(registerUserRs.getPinStatus())) {
                intent = new Intent(this, SetTcashPinActivity.class);
                intent.putExtra("from_sign_up", true);
                startActivity(intent);
                finish();
            }
            mo1505o();
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4968a(this.f3884J, (int) R.string.no_response, false);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    protected void mo1505o() {
        this.f3889o.m4648a("user_info_firstname", this.f3891r.getText().toString());
        this.f3889o.m4648a("user_info_lastname", this.f3892s.getText().toString());
        this.f3889o.m4648a("user_info_dateofbirth", this.f3894u.getText().toString());
        this.f3889o.m4648a("user_info_email", this.f3893t.getText().toString());
    }

    public void onBackPressed() {
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sign_up);
        this.f3888n = this.a.m4739a();
        this.f3889o = this.a.m4745e();
        this.f3886k = new C1303a(this);
        this.f3890q = (TextView) findViewById(R.id.signup_tcash_subtype_textview);
        this.f3891r = (EditText) findViewById(R.id.signup_first_name_edittext);
        this.f3892s = (EditText) findViewById(R.id.signup_last_name_edittext);
        this.f3893t = (EditText) findViewById(R.id.signup_email_edittext);
        this.f3894u = (Button) findViewById(R.id.signup_birth_date_button);
        this.f3895v = (Button) findViewById(R.id.signup_gennder_male_button);
        this.f3896w = (Button) findViewById(R.id.signup_gennder_female_button);
        this.f3897x = (Button) findViewById(R.id.signup_submit_button);
        this.f3894u.setOnTouchListener(this.f3882H);
        this.f3895v.setSelected(true);
        this.f3895v.setOnClickListener(this.f3881G);
        this.f3896w.setOnClickListener(this.f3881G);
        this.f3897x.setOnClickListener(this.f3881G);
        m5974q();
        this.f3891r.requestFocus();
        getWindow().setSoftInputMode(4);
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f3873m, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f3873m, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f3873m, " in onResume >>>>>");
    }
}
