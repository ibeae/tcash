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
import com.skcc.wallet.framework.api.C1272r;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.C1245f;
import com.skcc.wallet.framework.api.http.model.GetSecurityQuestionRs;
import com.skcc.wallet.framework.api.http.model.SecurityQuestion;
import com.skcc.wallet.framework.api.http.model.VerifySecurityAnswerRs;
import com.skcc.wallet.framework.p061c.C1303a;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.p064a.C1349c;
import java.util.ArrayList;
import java.util.List;

public class SecurityQsActivity extends C1359a {
    private static final String f3843k = SecurityQsActivity.class.getSimpleName();
    private C1298u f3844l;
    private C1272r f3845m;
    private TextView f3846n;
    private EditText f3847o;
    private Button f3848p;
    private List<SecurityQuestion> f3849q = new ArrayList();
    private String f3850r;
    private String f3851s;
    private OnClickListener f3852t = new C15861(this);
    private C1326f f3853u = new C15872(this);
    private C1326f f3854v = new C15883(this);

    class C15861 implements OnClickListener {
        final /* synthetic */ SecurityQsActivity f3840a;

        C15861(SecurityQsActivity securityQsActivity) {
            this.f3840a = securityQsActivity;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.security_qs_done_button:
                    if (this.f3840a.m5903q()) {
                        this.f3840a.m5899e(this.f3840a.f3847o.getText().toString().trim());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    class C15872 implements C1326f {
        final /* synthetic */ SecurityQsActivity f3841a;

        C15872(SecurityQsActivity securityQsActivity) {
            this.f3841a = securityQsActivity;
        }

        public void mo1485a() {
            if (this.f3841a.h != null) {
                this.f3841a.h.dismiss();
            }
        }

        public void mo1486b() {
        }
    }

    class C15883 implements C1326f {
        final /* synthetic */ SecurityQsActivity f3842a;

        C15883(SecurityQsActivity securityQsActivity) {
            this.f3842a = securityQsActivity;
        }

        public void mo1485a() {
            if (this.f3842a.h != null) {
                this.f3842a.h.dismiss();
            }
            Intent intent = new Intent(this.f3842a, LoginActivity.class);
            intent.setFlags(603979776);
            this.f3842a.startActivity(intent);
            this.f3842a.finish();
        }

        public void mo1486b() {
        }
    }

    private void m5899e(String str) {
        m4972a((Context) this, (int) R.string.loading);
        this.f3844l.m4712c(str, this.f3850r, this.f3845m.m4651b("gcm_registration_id", ""), this.f3845m.m4651b("user_info_walletversion", ""), this);
    }

    private void m5901o() {
        this.d.m4932a((Context) this, (TextView) findViewById(R.id.titlebar_view), 1);
        this.d.m4932a((Context) this, this.f3846n, 2);
        this.d.m4932a((Context) this, this.f3847o, 2);
        this.d.m4932a((Context) this, this.f3848p, 4);
    }

    private void m5902p() {
        m4972a((Context) this, (int) R.string.loading);
        this.f3844l.m4702b(this.f3850r, (C1245f) this);
    }

    private boolean m5903q() {
        if (!"".equals(this.f3847o.getText().toString().trim())) {
            return true;
        }
        this.f3847o.requestFocus();
        this.f3847o.setBackgroundResource(R.drawable.field_sct_red);
        return false;
    }

    public void mo1487a() {
        m4990k();
        this.h = m4967a(this.f3853u, (int) R.string.no_network);
    }

    public void mo1488a(String str) {
        m4972a((Context) this, (int) R.string.loading);
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.f3845m.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f3853u, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f3843k, "onSuccessNetwork");
        this.f3845m.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("getSecurityQuestion".equalsIgnoreCase(str)) {
            GetSecurityQuestionRs getSecurityQuestionRs = (GetSecurityQuestionRs) obj;
            for (SecurityQuestion securityQuestion : this.f3849q) {
                if (getSecurityQuestionRs.getSecurityQuestion().getQuestionId().equals(securityQuestion.getQuestionId())) {
                    this.f3846n.setText("Q. " + securityQuestion.getQuestion());
                    break;
                }
            }
            this.f3845m.m4648a("user_info_firstname", getIntent().getStringExtra("user_info_firstname"));
            this.f3845m.m4648a("user_info_lastname", getIntent().getStringExtra("user_info_lastname"));
        } else if ("verifySecurityAnswer".equalsIgnoreCase(str)) {
            VerifySecurityAnswerRs verifySecurityAnswerRs = (VerifySecurityAnswerRs) obj;
            this.f3845m.m4648a("encrypted_token_data", verifySecurityAnswerRs.getEncryptedToken());
            this.f3845m.m4648a("customer_id", verifySecurityAnswerRs.getCustomerId());
            this.f3845m.m4646a("token_data");
            this.f3845m.m4648a("msisdn", this.f3851s);
            C1303a c1303a = new C1303a(this);
            this.f3845m.m4648a("token_data", C1349c.m4922b(this.f3851s + c1303a.m4751e() + c1303a.m4750d()));
            this.f3845m.m4648a("imsi", c1303a.m4750d());
            if (verifySecurityAnswerRs.getTcashPin() == null || verifySecurityAnswerRs.getTcashPin().trim().length() < 3) {
                this.h = C1514b.m5648a((int) R.string.title_success, (int) R.string.msg_temp_pin_sent);
                this.h.m5651a(this.f3854v);
                this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
                return;
            }
            this.h = C1514b.m5649a((int) R.string.title_success, getString(R.string.sighup_tcash_registered_msg3) + verifySecurityAnswerRs.getTcashPin());
            this.h.m5651a(this.f3854v);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4967a(this.f3853u, (int) R.string.no_response);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.page_back_in_left, R.anim.page_back_out_right);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_security_qs);
        this.f3844l = this.a.m4739a();
        this.f3845m = this.a.m4745e();
        this.f3851s = getIntent().getStringExtra("msisdn");
        this.f3850r = getIntent().getStringExtra("TEMP_CUSTOMERID");
        C1216a.m4522b(f3843k, "temporaryCustomerId" + this.f3850r);
        String[] stringArray = getResources().getStringArray(R.array.security_qs_id);
        String[] stringArray2 = getResources().getStringArray(R.array.security_qs);
        for (int i = 0; i < stringArray.length; i++) {
            this.f3849q.add(new SecurityQuestion(stringArray[i], stringArray2[i], ""));
        }
        this.f3846n = (TextView) findViewById(R.id.security_qs_question_textview2);
        this.f3847o = (EditText) findViewById(R.id.security_qs_answer_edittext);
        this.f3848p = (Button) findViewById(R.id.security_qs_done_button);
        this.f3848p.setOnClickListener(this.f3852t);
        m5902p();
        m5901o();
        this.f3847o.requestFocus();
        getWindow().setSoftInputMode(4);
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f3843k, " in onDestroy >>>>>");
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f3843k, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f3843k, " in onResume >>>>>");
    }
}
