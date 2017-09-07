package com.telkom.mwallet.tcash;

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
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.home.HomeActivity;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import java.util.ArrayList;
import java.util.List;

public class TCashSecurityQsActivity extends SlidingFrameActivity {
    private static final String f4418k = TCashSecurityQsActivity.class.getSimpleName();
    private Button f4419A;
    private String f4420B;
    private OnClickListener f4421C = new C17381(this);
    private C1326f f4422D = new C17392(this);
    private C1326f f4423E = new C17403(this);
    private C1298u f4424l;
    private C1272r f4425m;
    private List<SecurityQuestion> f4426n = new ArrayList();
    private TextView f4427o;
    private EditText f4428z;

    class C17381 implements OnClickListener {
        final /* synthetic */ TCashSecurityQsActivity f4415a;

        C17381(TCashSecurityQsActivity tCashSecurityQsActivity) {
            this.f4415a = tCashSecurityQsActivity;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_security_qs_done_button:
                    this.f4415a.m6593p();
                    if (this.f4415a.m6594q()) {
                        this.f4415a.m6602e(this.f4415a.f4428z.getText().toString());
                        return;
                    }
                    this.f4415a.h = C1514b.m5647a((int) R.string.check_all_input_value);
                    this.f4415a.h.m5651a(this.f4415a.f4422D);
                    this.f4415a.h.show(this.f4415a.getSupportFragmentManager(), "notice_dialog_tag");
                    return;
                default:
                    return;
            }
        }
    }

    class C17392 implements C1326f {
        final /* synthetic */ TCashSecurityQsActivity f4416a;

        C17392(TCashSecurityQsActivity tCashSecurityQsActivity) {
            this.f4416a = tCashSecurityQsActivity;
        }

        public void mo1485a() {
            if (this.f4416a.h != null) {
                this.f4416a.h.dismiss();
            }
        }

        public void mo1486b() {
        }
    }

    class C17403 implements C1326f {
        final /* synthetic */ TCashSecurityQsActivity f4417a;

        C17403(TCashSecurityQsActivity tCashSecurityQsActivity) {
            this.f4417a = tCashSecurityQsActivity;
        }

        public void mo1485a() {
            if (this.f4417a.h != null) {
                this.f4417a.h.dismiss();
            }
            Intent intent = new Intent(this.f4417a, HomeActivity.class);
            intent.setFlags(603979776);
            this.f4417a.startActivity(intent);
            this.f4417a.finish();
        }

        public void mo1486b() {
        }
    }

    private void m6592o() {
        if (this.d == null) {
            this.d = m4982d();
        }
        this.d.m4932a((Context) this, (TextView) findViewById(R.id.titlebar_view), 1);
        this.d.m4932a((Context) this, this.f4427o, 2);
        this.d.m4932a((Context) this, this.f4428z, 2);
        this.d.m4932a((Context) this, this.f4419A, 4);
    }

    private void m6593p() {
        this.f4428z.setBackgroundResource(R.drawable.edittext_selector);
    }

    private boolean m6594q() {
        if (!"".equals(this.f4428z.getText().toString().trim())) {
            return true;
        }
        this.f4428z.requestFocus();
        this.f4428z.setBackgroundResource(R.drawable.field_sct_red);
        return false;
    }

    private void m6595r() {
        this.f4424l.m4702b(this.f4425m.m4651b("customer_id", ""), (C1245f) this);
    }

    public void mo1487a() {
        m4990k();
        this.h = m4967a(this.f4422D, (int) R.string.no_network);
    }

    public void mo1488a(String str) {
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.f4425m.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f4422D, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f4418k, "onSuccessNetwork");
        this.f4425m.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("getSecurityQuestion".equalsIgnoreCase(str)) {
            GetSecurityQuestionRs getSecurityQuestionRs = (GetSecurityQuestionRs) obj;
            for (SecurityQuestion securityQuestion : this.f4426n) {
                if (getSecurityQuestionRs.getSecurityQuestion().getQuestionId().equals(securityQuestion.getQuestionId())) {
                    this.f4420B = securityQuestion.getQuestion();
                    break;
                }
            }
            this.f4427o.setText("Q. " + this.f4420B);
        } else if ("verifyTCashSecurityAnswer".equalsIgnoreCase(str)) {
            this.h = C1514b.m5648a((int) R.string.title_success, (int) R.string.msg_temp_pin_sent);
            this.h.m5651a(this.f4423E);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4967a(this.f4422D, (int) R.string.no_response);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    public void m6602e(String str) {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("FIRST_NAME");
        String stringExtra2 = intent.getStringExtra("LAST_NAME");
        String stringExtra3 = intent.getStringExtra("email");
        this.f4424l.m4695a(intent.getStringExtra("BIRTH_DAY"), intent.getStringExtra("ID_NUMBER"), str, stringExtra, stringExtra2, stringExtra3, this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_tcash_security_qs);
        this.f4424l = this.a.m4739a();
        this.f4425m = this.a.m4745e();
        String[] stringArray = getResources().getStringArray(R.array.security_qs_id);
        String[] stringArray2 = getResources().getStringArray(R.array.security_qs);
        for (int i = 0; i < stringArray.length; i++) {
            this.f4426n.add(new SecurityQuestion(stringArray[i], stringArray2[i], ""));
        }
        this.f4427o = (TextView) findViewById(R.id.tcash_security_qs_question_textview);
        this.f4428z = (EditText) findViewById(R.id.tcash_security_qs_answer_edittext);
        this.f4419A = (Button) findViewById(R.id.tcash_security_qs_done_button);
        this.f4419A.setOnClickListener(this.f4421C);
        m6595r();
        m6592o();
        this.f4428z.requestFocus();
        getWindow().setSoftInputMode(4);
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f4418k, " in onDestroy >>>>>");
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f4418k, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f4418k, " in onResume >>>>>");
    }
}
