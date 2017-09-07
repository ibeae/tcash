package com.telkom.mwallet.setting.tcash;

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
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.p064a.C1349c;
import com.telkom.mwallet.p064a.C1353f;

public class ChangeTCashPINActivity extends C1359a {
    private static final String f4116k = ChangeTCashPINActivity.class.getSimpleName();
    private C1298u f4117l;
    private C1272r f4118m;
    private EditText f4119n;
    private EditText f4120o;
    private EditText f4121p;
    private Button f4122q;
    private OnClickListener f4123r = new C16471(this);
    private C1326f f4124s = new C16482(this);
    private C1326f f4125t = new C16493(this);

    class C16471 implements OnClickListener {
        final /* synthetic */ ChangeTCashPINActivity f4113a;

        C16471(ChangeTCashPINActivity changeTCashPINActivity) {
            this.f4113a = changeTCashPINActivity;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.change_tcash_pin_done_button:
                    if (this.f4113a.m6238r()) {
                        this.f4113a.m6239s();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    class C16482 implements C1326f {
        final /* synthetic */ ChangeTCashPINActivity f4114a;

        C16482(ChangeTCashPINActivity changeTCashPINActivity) {
            this.f4114a = changeTCashPINActivity;
        }

        public void mo1485a() {
            if (this.f4114a.h != null) {
                this.f4114a.h.dismiss();
            }
            String obj = this.f4114a.f4119n.getText().toString();
            String obj2 = this.f4114a.f4120o.getText().toString();
            String obj3 = this.f4114a.f4121p.getText().toString();
            if (obj.length() < 6) {
                C1353f.m4941a(this.f4114a.f4119n);
            } else if (obj2.length() < 6) {
                C1353f.m4941a(this.f4114a.f4120o);
            } else if (obj3.length() < 6) {
                C1353f.m4941a(this.f4114a.f4121p);
            } else if (!obj2.equals(obj3)) {
                C1353f.m4941a(this.f4114a.f4121p);
            }
        }

        public void mo1486b() {
        }
    }

    class C16493 implements C1326f {
        final /* synthetic */ ChangeTCashPINActivity f4115a;

        C16493(ChangeTCashPINActivity changeTCashPINActivity) {
            this.f4115a = changeTCashPINActivity;
        }

        public void mo1485a() {
            if (this.f4115a.h != null) {
                this.f4115a.h.dismiss();
            }
            this.f4115a.finish();
        }

        public void mo1486b() {
        }
    }

    private String m6230e(String str) {
        String str2 = null;
        try {
            str2 = C1349c.m4915a(this.f4118m.m4651b("SESSION_KEY", ""), str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str2;
    }

    private void m6235o() {
        this.f4119n = (EditText) findViewById(R.id.change_tcash_pin_current_pin_edittext);
        this.f4120o = (EditText) findViewById(R.id.change_tcash_pin_change_pin_edittext);
        this.f4121p = (EditText) findViewById(R.id.change_tcash_pin_confirm_pin_edittext);
        this.f4122q = (Button) findViewById(R.id.change_tcash_pin_done_button);
        this.f4122q.setOnClickListener(this.f4123r);
        this.f4119n.requestFocus();
        getWindow().setSoftInputMode(4);
    }

    private void m6236p() {
        this.d.m4932a((Context) this, (TextView) findViewById(R.id.titlebar_view), 1);
        this.d.m4932a((Context) this, this.f4119n, 2);
        this.d.m4932a((Context) this, this.f4120o, 2);
        this.d.m4932a((Context) this, this.f4121p, 2);
        this.d.m4932a((Context) this, this.f4122q, 4);
    }

    private void m6237q() {
        this.f4119n.setBackgroundResource(R.drawable.edittext_selector_top);
        this.f4120o.setBackgroundResource(R.drawable.edittext_selector_middle);
        this.f4121p.setBackgroundResource(R.drawable.edittext_selector_bottom);
    }

    private boolean m6238r() {
        m6237q();
        String obj = this.f4119n.getText().toString();
        String obj2 = this.f4120o.getText().toString();
        String obj3 = this.f4121p.getText().toString();
        if (obj.isEmpty()) {
            this.f4119n.setBackgroundResource(R.drawable.field_sct_red);
            C1353f.m4941a(this.f4119n);
            return false;
        } else if (obj.length() < 6) {
            this.f4119n.setBackgroundResource(R.drawable.field_sct_red);
            this.h = C1514b.m5648a((int) R.string.title_notice, (int) R.string.pin_short);
            this.h.m5651a(this.f4124s);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
            return false;
        } else if (obj2.isEmpty()) {
            this.f4120o.setBackgroundResource(R.drawable.field_sct_red);
            C1353f.m4941a(this.f4120o);
            return false;
        } else if (obj2.length() < 6) {
            this.f4120o.setBackgroundResource(R.drawable.field_sct_red);
            this.h = C1514b.m5648a((int) R.string.title_notice, (int) R.string.pin_short);
            this.h.m5651a(this.f4124s);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
            return false;
        } else if (obj3.isEmpty()) {
            this.f4121p.setBackgroundResource(R.drawable.field_sct_red);
            C1353f.m4941a(this.f4121p);
            return false;
        } else if (obj3.length() < 6) {
            this.f4121p.setBackgroundResource(R.drawable.field_sct_red);
            this.h = C1514b.m5648a((int) R.string.title_notice, (int) R.string.pin_short);
            this.h.m5651a(this.f4124s);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
            return false;
        } else if (obj2.equals(obj3)) {
            return true;
        } else {
            this.f4121p.setBackgroundResource(R.drawable.field_sct_red);
            this.h = C1514b.m5648a((int) R.string.title_notice, (int) R.string.passcodes_did_not_match);
            this.h.m5651a(this.f4124s);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
            return false;
        }
    }

    private void m6239s() {
        String obj = this.f4119n.getText().toString();
        String obj2 = this.f4120o.getText().toString();
        obj = m6230e(obj);
        obj2 = m6230e(obj2);
        if (!"".equals(obj2) && !"".equals(obj)) {
            m4972a((Context) this, (int) R.string.loading);
            this.f4117l.m4710c(obj, obj2, (C1245f) this);
        }
    }

    public void mo1487a() {
        m4990k();
        this.h = m4968a(this.f4124s, (int) R.string.no_network, false);
    }

    public void mo1488a(String str) {
        m4972a((Context) this, (int) R.string.loading);
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.f4118m.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4970a(this.f4124s, "" + str3, false);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f4116k, "onSuccessNetwork");
        this.f4118m.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("changeTCashPin".equalsIgnoreCase(str)) {
            this.h = C1514b.m5648a((int) R.string.title_success, (int) R.string.tcash_pin_changed);
            this.h.m5651a(this.f4125t);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4968a(this.f4124s, (int) R.string.no_response, false);
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
        this.f4117l = this.a.m4739a();
        this.f4118m = this.a.m4745e();
        setContentView(R.layout.activity_change_tcash_pin);
        m6235o();
        m6236p();
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f4116k, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f4116k, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f4116k, " in onResume >>>>>");
    }
}
