package com.telkom.mwallet.setting;

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
import com.skcc.wallet.framework.api.http.model.GetUserProfileRs;
import com.skcc.wallet.framework.api.http.model.SecurityQuestion;
import com.skcc.wallet.framework.api.http.model.UserInfo;
import com.skcc.wallet.framework.p061c.C1303a;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1518d.C1511a;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.dialog.p063a.C1495b;
import com.telkom.mwallet.home.HomeActivity;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.p064a.C1358h;
import java.util.Date;

public class ProfileActivity extends C1359a {
    private static final String f3993l = ProfileActivity.class.getSimpleName();
    private static View f3994w = null;
    private String f3995A = "";
    private OnClickListener f3996B = new C16191(this);
    private OnTouchListener f3997C = new C16202(this);
    private C1495b f3998D = new C16213(this);
    private C1326f f3999E = new C16224(this);
    private C1326f f4000F = new C16235(this);
    C1303a f4001k;
    private C1298u f4002m;
    private C1272r f4003n;
    private EditText f4004o;
    private EditText f4005p;
    private Button f4006q;
    private EditText f4007r;
    private Button f4008s;
    private Button f4009t;
    private Button f4010u;
    private C1511a f4011v;
    private int f4012x = 1990;
    private int f4013y = 1;
    private int f4014z = 1;

    class C16191 implements OnClickListener {
        final /* synthetic */ ProfileActivity f3988a;

        C16191(ProfileActivity profileActivity) {
            this.f3988a = profileActivity;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.profile_birth_date_button:
                case R.id.profile_birth_date_picker_button:
                    this.f3988a.f4011v = C1511a.m5642a(this.f3988a.f4012x, this.f3988a.f4013y, this.f3988a.f4014z);
                    this.f3988a.f4011v.m5645a(this.f3988a.f3998D);
                    this.f3988a.f4011v.m5644a(new Date().getTime());
                    this.f3988a.f4011v.show(this.f3988a.getSupportFragmentManager(), "date_dialog_tag");
                    return;
                case R.id.profile_cancel_button:
                    this.f3988a.finish();
                    return;
                case R.id.profile_gennder_female_button:
                    if (this.f3988a.f4009t.isSelected()) {
                        this.f3988a.f4009t.setSelected(false);
                        this.f3988a.f4008s.setSelected(true);
                        return;
                    }
                    this.f3988a.f4009t.setSelected(true);
                    this.f3988a.f4008s.setSelected(false);
                    return;
                case R.id.profile_gennder_male_button:
                    if (this.f3988a.f4008s.isSelected()) {
                        this.f3988a.f4008s.setSelected(false);
                        this.f3988a.f4009t.setSelected(true);
                        return;
                    }
                    this.f3988a.f4008s.setSelected(true);
                    this.f3988a.f4009t.setSelected(false);
                    return;
                case R.id.profile_submit_button:
                    this.f3988a.m6142q();
                    if (!this.f3988a.m6144r()) {
                        this.f3988a.h = C1514b.m5647a((int) R.string.check_all_input_value);
                        this.f3988a.h.m5651a(this.f3988a.f3999E);
                        this.f3988a.h.show(this.f3988a.getSupportFragmentManager(), "notice_dialog_tag");
                        return;
                    } else if (C1354g.m4948a(this.f3988a.f4007r)) {
                        this.f3988a.m6150u();
                        return;
                    } else {
                        this.f3988a.f4007r.requestFocus(this.f3988a.f4007r.length());
                        this.f3988a.f4007r.setBackgroundResource(R.drawable.field_sct_red);
                        this.f3988a.h = C1514b.m5647a((int) R.string.check_email);
                        this.f3988a.h.m5651a(this.f3988a.f3999E);
                        this.f3988a.h.show(this.f3988a.getSupportFragmentManager(), "notice_dialog_tag");
                        return;
                    }
                default:
                    return;
            }
        }
    }

    class C16202 implements OnTouchListener {
        final /* synthetic */ ProfileActivity f3989a;

        C16202(ProfileActivity profileActivity) {
            this.f3989a = profileActivity;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                ProfileActivity.f3994w = view;
            } else if (motionEvent.getAction() == 1) {
                if (view.equals(ProfileActivity.f3994w)) {
                    switch (view.getId()) {
                        case R.id.profile_birth_date_button:
                            this.f3989a.f4011v = C1511a.m5642a(this.f3989a.f4012x, this.f3989a.f4013y, this.f3989a.f4014z);
                            this.f3989a.f4011v.m5645a(this.f3989a.f3998D);
                            this.f3989a.f4011v.m5644a(new Date().getTime());
                            this.f3989a.f4011v.show(this.f3989a.getSupportFragmentManager(), "date_dialog_tag");
                            break;
                    }
                }
                ProfileActivity.f3994w = null;
                return true;
            }
            return false;
        }
    }

    class C16213 implements C1495b {
        final /* synthetic */ ProfileActivity f3990a;

        C16213(ProfileActivity profileActivity) {
            this.f3990a = profileActivity;
        }

        public void mo1533a(int i, int i2, int i3) {
            if (this.f3990a.f4011v != null) {
                this.f3990a.f4011v.dismiss();
            }
            this.f3990a.f4012x = i;
            this.f3990a.f4013y = i2 + 1;
            this.f3990a.f4014z = i3;
            this.f3990a.f3995A = C1354g.m4944a(i, i2, i3);
            this.f3990a.f4006q.setText(this.f3990a.f3995A);
        }
    }

    class C16224 implements C1326f {
        final /* synthetic */ ProfileActivity f3991a;

        C16224(ProfileActivity profileActivity) {
            this.f3991a = profileActivity;
        }

        public void mo1485a() {
            if (this.f3991a.h != null) {
                this.f3991a.h.dismiss();
            }
        }

        public void mo1486b() {
        }
    }

    class C16235 implements C1326f {
        final /* synthetic */ ProfileActivity f3992a;

        C16235(ProfileActivity profileActivity) {
            this.f3992a = profileActivity;
        }

        public void mo1485a() {
            if (this.f3992a.h != null) {
                this.f3992a.h.dismiss();
            }
            this.f3992a.m6152v();
        }

        public void mo1486b() {
        }
    }

    private void m6121a(UserInfo userInfo, SecurityQuestion securityQuestion) {
        this.f4004o.setText(userInfo.getFirstName());
        this.f4005p.setText(userInfo.getLastName());
        this.f4006q.setText(userInfo.getDateOfBirth());
        this.f4007r.setText(userInfo.getEmail());
        if ("Male".equalsIgnoreCase(userInfo.getGender())) {
            this.f4008s.setSelected(true);
            this.f4009t.setSelected(false);
            return;
        }
        this.f4008s.setSelected(false);
        this.f4009t.setSelected(true);
    }

    private void m6142q() {
        this.f4004o.setBackgroundResource(R.drawable.edittext_selector_top);
        this.f4005p.setBackgroundResource(R.drawable.edittext_selector_middle);
        this.f4006q.setBackgroundResource(R.drawable.edittext_selector_middle);
        this.f4007r.setBackgroundResource(R.drawable.edittext_selector_n);
    }

    private boolean m6144r() {
        if ("".equals(this.f4004o.getText().toString().trim())) {
            this.f4004o.requestFocus();
            this.f4004o.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if ("".equals(this.f4005p.getText().toString().trim())) {
            this.f4005p.requestFocus();
            this.f4005p.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if ("".equals(this.f4006q.getText().toString().trim())) {
            this.f4006q.requestFocus();
            this.f4006q.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if (!"".equals(this.f4007r.getText().toString().trim())) {
            return true;
        } else {
            this.f4007r.requestFocus();
            this.f4007r.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        }
    }

    private void m6146s() {
        this.d.m4934a((Context) this, (ViewGroup) getWindow().getDecorView().findViewById(16908290), 2);
        this.d.m4932a((Context) this, (TextView) findViewById(R.id.titlebar_view), 1);
        this.d.m4932a((Context) this, this.f4010u, 4);
    }

    private void m6148t() {
        m4972a((Context) this, (int) R.string.loading);
        this.f4002m.m4714d(this);
    }

    private void m6150u() {
        UserInfo userInfo = new UserInfo();
        userInfo.setFirstName(this.f4004o.getText().toString());
        userInfo.setLastName(this.f4005p.getText().toString());
        userInfo.setDateOfBirth(this.f4006q.getText().toString());
        if (this.f4008s.isSelected()) {
            userInfo.setGender("Male");
        } else {
            userInfo.setGender("Female");
        }
        userInfo.setEmail(this.f4007r.getText().toString());
        userInfo.setMno(C1358h.f2931b);
        m4972a((Context) this, (int) R.string.loading);
        this.f4002m.m4676a(userInfo, (C1245f) this);
    }

    private void m6152v() {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
        finish();
    }

    public void mo1487a() {
        m4990k();
        this.h = m4968a(this.f3999E, (int) R.string.no_network, false);
    }

    public void mo1488a(String str) {
        m4972a((Context) this, (int) R.string.loading);
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.f4003n.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f3999E, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a("BaseActivity", "onSuccessNetwork");
        this.f4003n.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("getUserProfile".equalsIgnoreCase(str)) {
            GetUserProfileRs getUserProfileRs = (GetUserProfileRs) obj;
            m6121a(getUserProfileRs.getUserInfo(), getUserProfileRs.getSecurityQuestion());
        } else if ("setUserProfile".equalsIgnoreCase(str)) {
            mo1505o();
            this.h = C1514b.m5647a((int) R.string.profile_changed);
            this.h.m5651a(this.f4000F);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4968a(this.f3999E, (int) R.string.no_response, false);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    protected void mo1505o() {
        this.f4003n.m4648a("user_info_firstname", this.f4004o.getText().toString());
        this.f4003n.m4648a("user_info_lastname", this.f4005p.getText().toString());
        this.f4003n.m4648a("user_info_dateofbirth", this.f4006q.getText().toString());
        this.f4003n.m4648a("user_info_email", this.f4007r.getText().toString());
    }

    public void onBackPressed() {
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_profile);
        this.f4002m = this.a.m4739a();
        this.f4003n = this.a.m4745e();
        this.f4001k = new C1303a(this);
        this.f4004o = (EditText) findViewById(R.id.profile_first_name_edittext);
        this.f4005p = (EditText) findViewById(R.id.profile_last_name_edittext);
        this.f4006q = (Button) findViewById(R.id.profile_birth_date_button);
        this.f4007r = (EditText) findViewById(R.id.profile_email_edittext);
        this.f4008s = (Button) findViewById(R.id.profile_gennder_male_button);
        this.f4009t = (Button) findViewById(R.id.profile_gennder_female_button);
        this.f4010u = (Button) findViewById(R.id.profile_submit_button);
        this.f4006q.setOnTouchListener(this.f3997C);
        this.f4008s.setSelected(true);
        this.f4008s.setOnClickListener(this.f3996B);
        this.f4009t.setOnClickListener(this.f3996B);
        this.f4010u.setOnClickListener(this.f3996B);
        m6148t();
        m6146s();
        this.f4004o.requestFocus();
        getWindow().setSoftInputMode(4);
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f3993l, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f3993l, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f3993l, " in onResume >>>>>");
    }
}
