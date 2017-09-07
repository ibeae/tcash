package com.telkom.mwallet.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1272r;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.C1245f;
import com.skcc.wallet.framework.p061c.C1303a;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.login.LoginActivity;
import com.telkom.mwallet.p064a.C1349c;
import com.telkom.mwallet.p064a.C1353f;
import javax.crypto.BadPaddingException;

public class ChangePinCodeActivity extends C1359a {
    private static final String f3973k = ProfileActivity.class.getSimpleName();
    private C1298u f3974l;
    private C1272r f3975m;
    private String f3976n;
    private String f3977o;
    private EditText f3978p;
    private EditText f3979q;
    private EditText f3980r;
    private TextView f3981s;
    private TextView f3982t;
    private Button f3983u;
    private int f3984v = -1;
    private OnClickListener f3985w = new C16161(this);
    private C1326f f3986x = new C16172(this);
    private C1326f f3987y = new C16183(this);

    class C16161 implements OnClickListener {
        final /* synthetic */ ChangePinCodeActivity f3970a;

        C16161(ChangePinCodeActivity changePinCodeActivity) {
            this.f3970a = changePinCodeActivity;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.change_pin_code_done_button:
                    if (!this.f3970a.m6101s()) {
                        return;
                    }
                    if (this.f3970a.f3984v != 201 || this.f3970a.m6099q()) {
                        this.f3970a.m6102t();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    class C16172 implements C1326f {
        final /* synthetic */ ChangePinCodeActivity f3971a;

        C16172(ChangePinCodeActivity changePinCodeActivity) {
            this.f3971a = changePinCodeActivity;
        }

        public void mo1485a() {
            if (this.f3971a.h != null) {
                this.f3971a.h.dismiss();
            }
            String obj = this.f3971a.f3978p.getText().toString();
            String obj2 = this.f3971a.f3979q.getText().toString();
            String obj3 = this.f3971a.f3980r.getText().toString();
            if (obj.length() < 6) {
                C1353f.m4941a(this.f3971a.f3978p);
            } else if (obj2.length() < 6) {
                C1353f.m4941a(this.f3971a.f3979q);
            } else if (obj3.length() < 6) {
                C1353f.m4941a(this.f3971a.f3980r);
            } else if (!obj2.equals(obj3)) {
                C1353f.m4941a(this.f3971a.f3980r);
            }
        }

        public void mo1486b() {
        }
    }

    class C16183 implements C1326f {
        final /* synthetic */ ChangePinCodeActivity f3972a;

        C16183(ChangePinCodeActivity changePinCodeActivity) {
            this.f3972a = changePinCodeActivity;
        }

        public void mo1485a() {
            if (this.f3972a.h != null) {
                this.f3972a.h.dismiss();
            }
            if (this.f3972a.f3984v == 202) {
                this.f3972a.m6103u();
            } else {
                this.f3972a.finish();
            }
        }

        public void mo1486b() {
        }
    }

    private void m6088e(String str) {
        C1303a c1303a = new C1303a(this);
        this.f3976n = C1349c.m4922b(this.f3975m.m4651b("msisdn", "") + c1303a.m4751e() + c1303a.m4750d());
        try {
            this.f3977o = C1349c.m4915a(str, this.f3976n);
        } catch (Exception e) {
            this.h = C1514b.m5647a((int) R.string.unexpected_error);
            this.h.m5651a(this.f3986x);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
            e.printStackTrace();
        }
    }

    private void m6090f(String str) {
        this.f3976n = this.f3975m.m4651b("token_data", "");
        if ("".equals(this.f3976n)) {
            C1303a c1303a = new C1303a(this);
            this.f3976n = C1349c.m4922b(this.f3975m.m4651b("msisdn", "") + c1303a.m4751e() + this.f3975m.m4651b("imsi", c1303a.m4750d()));
        }
        try {
            this.f3977o = C1349c.m4915a(str, this.f3976n);
        } catch (Exception e) {
            this.h = C1514b.m5647a((int) R.string.unexpected_error);
            this.h.m5651a(this.f3986x);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
            e.printStackTrace();
        }
    }

    private void m6097o() {
        this.f3984v = getIntent().getIntExtra("change_pin_case", -1);
        this.f3978p = (EditText) findViewById(R.id.change_pin_code_current_pin_edittext);
        this.f3979q = (EditText) findViewById(R.id.change_pin_code_change_pin_edittext);
        this.f3980r = (EditText) findViewById(R.id.change_pin_code_confirm_pin_edittext);
        this.f3981s = (TextView) findViewById(R.id.titlebar_view);
        this.f3982t = (TextView) findViewById(R.id.change_pin_code_text);
        this.f3983u = (Button) findViewById(R.id.change_pin_code_done_button);
        this.f3983u.setOnClickListener(this.f3985w);
        if (this.f3984v == 202) {
            this.f3978p.setVisibility(8);
            this.f3982t.setVisibility(0);
            this.f3981s.setText(R.string.title_change_pin_login);
        } else {
            this.f3978p.setVisibility(0);
            this.f3982t.setVisibility(8);
        }
        this.f3978p.requestFocus();
        getWindow().setSoftInputMode(4);
    }

    private void m6098p() {
        this.d.m4932a((Context) this, this.f3981s, 1);
        this.d.m4932a((Context) this, this.f3978p, 2);
        this.d.m4932a((Context) this, this.f3979q, 2);
        this.d.m4932a((Context) this, this.f3980r, 2);
        this.d.m4932a((Context) this, this.f3983u, 4);
    }

    private boolean m6099q() {
        try {
            this.f3976n = C1349c.m4923b(this.f3978p.getText().toString(), this.f3975m.m4651b("encrypted_token_data", ""));
            return true;
        } catch (BadPaddingException e) {
            this.h = C1514b.m5647a((int) R.string.passcode_does_not_match);
            this.h.m5651a(this.f3986x);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private void m6100r() {
        this.f3978p.setBackgroundResource(R.drawable.edittext_selector_top);
        this.f3979q.setBackgroundResource(R.drawable.edittext_selector_middle);
        this.f3980r.setBackgroundResource(R.drawable.edittext_selector_bottom);
    }

    private boolean m6101s() {
        m6100r();
        String obj = this.f3978p.getText().toString();
        String obj2 = this.f3979q.getText().toString();
        String obj3 = this.f3980r.getText().toString();
        if (this.f3984v == 201) {
            if (obj.isEmpty()) {
                this.f3978p.setBackgroundResource(R.drawable.field_sct_red);
                C1353f.m4941a(this.f3978p);
                return false;
            } else if (obj.length() < 6) {
                this.f3978p.setBackgroundResource(R.drawable.field_sct_red);
                this.h = C1514b.m5648a((int) R.string.title_notice, (int) R.string.pin_short);
                this.h.m5651a(this.f3986x);
                this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
                return false;
            }
        }
        if (obj2.isEmpty()) {
            this.f3979q.setBackgroundResource(R.drawable.field_sct_red);
            C1353f.m4941a(this.f3979q);
            return false;
        } else if (obj2.length() < 6) {
            this.f3979q.setBackgroundResource(R.drawable.field_sct_red);
            this.h = C1514b.m5648a((int) R.string.title_notice, (int) R.string.pin_short);
            this.h.m5651a(this.f3986x);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
            return false;
        } else if (obj3.isEmpty()) {
            this.f3980r.setBackgroundResource(R.drawable.field_sct_red);
            C1353f.m4941a(this.f3980r);
            return false;
        } else if (obj3.length() < 6) {
            this.f3980r.setBackgroundResource(R.drawable.field_sct_red);
            this.h = C1514b.m5648a((int) R.string.title_notice, (int) R.string.pin_short);
            this.h.m5651a(this.f3986x);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
            return false;
        } else if (obj2.equals(obj3)) {
            return true;
        } else {
            this.f3980r.setBackgroundResource(R.drawable.field_sct_red);
            this.h = C1514b.m5648a((int) R.string.title_notice, (int) R.string.passcodes_did_not_match);
            this.h.m5651a(this.f3986x);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
            return false;
        }
    }

    private void m6102t() {
        String obj = this.f3979q.getText().toString();
        m6088e(obj);
        m6090f(obj);
        m4972a((Context) this, (int) R.string.loading);
        this.f3974l.m4703b(this.f3976n, this.f3977o, (C1245f) this);
    }

    private void m6103u() {
        this.f3974l.m4725g(this);
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(335577088);
        startActivity(intent);
        finish();
    }

    public void mo1487a() {
        m4990k();
        this.h = m4968a(this.f3986x, (int) R.string.no_network, false);
    }

    public void mo1488a(String str) {
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        m4991l();
        this.f3975m.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4970a(this.f3986x, "" + str3, false);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f3973k, "onSuccessNetwork");
        this.f3975m.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("changeMWalletPin".equalsIgnoreCase(str)) {
            if (this.f3984v == 202) {
                this.h = C1514b.m5648a((int) R.string.title_success, (int) R.string.pin_changed_successfully);
            } else {
                this.h = C1514b.m5648a((int) R.string.title_success, (int) R.string.pin_changed);
            }
            this.h.m5651a(this.f3987y);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
            this.f3975m.m4648a("token_data", this.f3976n);
            this.f3975m.m4648a("encrypted_token_data", this.f3977o);
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4968a(this.f3986x, (int) R.string.no_response, false);
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
        this.f3974l = this.a.m4739a();
        this.f3975m = this.a.m4745e();
        setContentView(R.layout.activity_change_pin_code);
        m6097o();
        m6098p();
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f3973k, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f3973k, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f3973k, " in onResume >>>>>");
    }
}
