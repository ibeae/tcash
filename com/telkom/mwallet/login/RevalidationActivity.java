package com.telkom.mwallet.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1272r;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.model.VerifyUserRs;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1518d.C1511a;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.dialog.p063a.C1495b;
import com.telkom.mwallet.p064a.C1354g;
import java.util.Date;
import twitter4j.MediaEntity.Size;

public class RevalidationActivity extends C1359a {
    private static View f3815A = null;
    private static final String f3816k = RevalidationActivity.class.getSimpleName();
    private C1511a f3817B;
    private OnTouchListener f3818C = new C15801(this);
    private OnClickListener f3819D = new C15812(this);
    private C1495b f3820E = new C15823(this);
    private C1326f f3821F = new C15834(this);
    private C1326f f3822G = new C15845(this);
    private C1326f f3823H = new C15856(this);
    private C1298u f3824l;
    private C1272r f3825m;
    private EditText f3826n;
    private EditText f3827o;
    private EditText f3828p;
    private EditText f3829q;
    private Button f3830r;
    private Button f3831s;
    private RelativeLayout f3832t;
    private Button f3833u;
    private int f3834v = -1;
    private int f3835w = 1980;
    private int f3836x = 1;
    private int f3837y = 1;
    private String f3838z = "";

    class C15801 implements OnTouchListener {
        final /* synthetic */ RevalidationActivity f3809a;

        C15801(RevalidationActivity revalidationActivity) {
            this.f3809a = revalidationActivity;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                RevalidationActivity.f3815A = view;
            } else if (motionEvent.getAction() == 1) {
                if (view.equals(RevalidationActivity.f3815A)) {
                    switch (view.getId()) {
                        case R.id.revalidation_birth_select_button:
                            this.f3809a.f3817B = C1511a.m5642a(this.f3809a.f3835w, this.f3809a.f3836x, this.f3809a.f3837y);
                            this.f3809a.f3817B.m5645a(this.f3809a.f3820E);
                            this.f3809a.f3817B.m5644a(new Date().getTime());
                            this.f3809a.f3817B.show(this.f3809a.getSupportFragmentManager(), "date_dialog_tag");
                            break;
                    }
                }
                RevalidationActivity.f3815A = null;
                return true;
            }
            return false;
        }
    }

    class C15812 implements OnClickListener {
        final /* synthetic */ RevalidationActivity f3810a;

        C15812(RevalidationActivity revalidationActivity) {
            this.f3810a = revalidationActivity;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.revalidation_done_button:
                    this.f3810a.m5874s();
                    if (!this.f3810a.m5872r()) {
                        this.f3810a.h = C1514b.m5647a((int) R.string.check_all_input_value);
                        this.f3810a.h.m5651a(this.f3810a.f3821F);
                        this.f3810a.h.show(this.f3810a.getSupportFragmentManager(), "notice_dialog_tag");
                        return;
                    } else if (!C1354g.m4950b(this.f3810a.f3826n)) {
                        this.f3810a.f3826n.requestFocus(this.f3810a.f3826n.length());
                        this.f3810a.f3826n.setBackgroundResource(R.drawable.field_sct_red);
                        this.f3810a.h = C1514b.m5647a((int) R.string.check_mobile_number);
                        this.f3810a.h.m5651a(this.f3810a.f3821F);
                        this.f3810a.h.show(this.f3810a.getSupportFragmentManager(), "notice_dialog_tag");
                        return;
                    } else if (C1354g.m4948a(this.f3810a.f3829q)) {
                        this.f3810a.m5876t();
                        return;
                    } else {
                        this.f3810a.f3829q.requestFocus(this.f3810a.f3829q.length());
                        this.f3810a.f3829q.setBackgroundResource(R.drawable.field_sct_red);
                        this.f3810a.h = C1514b.m5647a((int) R.string.check_email);
                        this.f3810a.h.m5651a(this.f3810a.f3821F);
                        this.f3810a.h.show(this.f3810a.getSupportFragmentManager(), "notice_dialog_tag");
                        return;
                    }
                default:
                    return;
            }
        }
    }

    class C15823 implements C1495b {
        final /* synthetic */ RevalidationActivity f3811a;

        C15823(RevalidationActivity revalidationActivity) {
            this.f3811a = revalidationActivity;
        }

        public void mo1533a(int i, int i2, int i3) {
            if (this.f3811a.f3817B != null) {
                this.f3811a.f3817B.dismiss();
            }
            this.f3811a.f3835w = i;
            this.f3811a.f3836x = i2 + 1;
            this.f3811a.f3837y = i3;
            this.f3811a.f3838z = C1354g.m4944a(i, i2, i3);
            this.f3811a.f3830r.setText(this.f3811a.f3838z);
        }
    }

    class C15834 implements C1326f {
        final /* synthetic */ RevalidationActivity f3812a;

        C15834(RevalidationActivity revalidationActivity) {
            this.f3812a = revalidationActivity;
        }

        public void mo1485a() {
            if (this.f3812a.h != null) {
                this.f3812a.finish();
            }
        }

        public void mo1486b() {
        }
    }

    class C15845 implements C1326f {
        final /* synthetic */ RevalidationActivity f3813a;

        C15845(RevalidationActivity revalidationActivity) {
            this.f3813a = revalidationActivity;
        }

        public void mo1485a() {
            if (this.f3813a.h != null) {
                this.f3813a.h.dismiss();
            }
        }

        public void mo1486b() {
        }
    }

    class C15856 implements C1326f {
        final /* synthetic */ RevalidationActivity f3814a;

        C15856(RevalidationActivity revalidationActivity) {
            this.f3814a = revalidationActivity;
        }

        public void mo1485a() {
            if (this.f3814a.h != null) {
                this.f3814a.h.dismiss();
            }
            this.f3814a.f3825m.m4645a();
            this.f3814a.finish();
        }

        public void mo1486b() {
        }
    }

    private void m5869q() {
        this.d.m4932a((Context) this, (TextView) findViewById(R.id.titlebar_view), 1);
        this.d.m4932a((Context) this, this.f3826n, 2);
        this.d.m4932a((Context) this, this.f3827o, 2);
        this.d.m4932a((Context) this, this.f3828p, 2);
        this.d.m4932a((Context) this, this.f3830r, 2);
        this.d.m4932a((Context) this, this.f3829q, 2);
        this.d.m4932a((Context) this, this.f3833u, 4);
    }

    private boolean m5872r() {
        if ("".equals(this.f3826n.getText().toString().trim())) {
            this.f3826n.requestFocus();
            this.f3826n.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if (this.f3834v == Size.CROP && "".equals(this.f3830r.getText().toString().trim())) {
            this.f3830r.requestFocus();
            this.f3830r.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if (!"".equals(this.f3829q.getText().toString().trim())) {
            return true;
        } else {
            this.f3829q.requestFocus();
            this.f3829q.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        }
    }

    private void m5874s() {
        this.f3826n.setBackgroundResource(R.drawable.edittext_selector_top);
        this.f3827o.setBackgroundResource(R.drawable.edittext_selector_middle);
        this.f3828p.setBackgroundResource(R.drawable.edittext_selector_middle);
        this.f3830r.setBackgroundResource(R.drawable.edittext_selector_middle);
        this.f3829q.setBackgroundResource(R.drawable.edittext_selector_middle);
    }

    private void m5876t() {
        m4972a((Context) this, (int) R.string.loading);
        String trim = this.f3827o.getText().toString().trim();
        String trim2 = this.f3828p.getText().toString().trim();
        String trim3 = this.f3830r.getText().toString().trim();
        String trim4 = this.f3829q.getText().toString().trim();
        String i = C1354g.m4958i(this.f3826n.getText().toString().trim());
        this.f3826n.setText(i);
        this.f3825m.m4648a("msisdn", i);
        if (this.f3834v == 102) {
            this.f3824l.m4694a(getIntent().getStringExtra("USER_TYPED_PIN"), trim, trim2, trim3, trim4, this);
            return;
        }
        this.f3824l.m4705b(trim, trim2, trim3, trim4, this);
    }

    public void mo1487a() {
        m4990k();
        this.h = m4967a(this.f3821F, (int) R.string.no_network);
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.f3825m.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        m4991l();
        if (!"verifyUser".equalsIgnoreCase(str)) {
            this.h = m4970a(this.f3823H, "" + str3, false);
        } else if (i == 30003) {
            mo1505o();
        } else if (i == 30004) {
            this.h = m4968a(this.f3822G, (int) R.string.revalidation_wrong, false);
        } else {
            this.h = m4970a(this.f3823H, "" + str3, false);
        }
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f3816k, "onSuccessNetwork");
        this.f3825m.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("verifyUser".equalsIgnoreCase(str)) {
            VerifyUserRs verifyUserRs = (VerifyUserRs) obj;
            int code = verifyUserRs.getResult().getCode();
            if (!"verifyUser".equalsIgnoreCase(str)) {
                return;
            }
            if (code == 30003) {
                mo1505o();
            } else if (code == 30004) {
                this.h = m4968a(this.f3822G, (int) R.string.revalidation_wrong, false);
            } else if (code == 0) {
                m5885a(verifyUserRs.getTemporaryCustomerId(), verifyUserRs.getFirstName(), verifyUserRs.getLastName());
            } else {
                this.h = m4970a(this.f3823H, "" + verifyUserRs.getResult().getMessage(), false);
            }
        }
    }

    protected void m5885a(String str, String str2, String str3) {
        this.f3825m.m4648a("user_info_firstname", str2);
        this.f3825m.m4648a("user_info_lastname", str3);
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), VerifyMSISDNActivity.class);
        intent.putExtra("verify_msisdn_case", this.f3834v);
        intent.putExtra("TEMP_CUSTOMERID", str);
        intent.putExtra("msisdn", this.f3826n.getText().toString());
        startActivity(intent);
        finish();
    }

    public void mo1491b() {
        m4990k();
        this.h = m4967a(this.f3821F, (int) R.string.no_response);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    protected void mo1505o() {
        String i = C1354g.m4958i(this.f3826n.getText().toString());
        Intent intent = new Intent();
        intent.putExtra("msisdn", i);
        intent.putExtra("verify_msisdn_case", 103);
        intent.setClass(this, VerifyMSISDNActivity.class);
        startActivity(intent);
        finish();
    }

    public void onBackPressed() {
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_revalidation);
        this.f3824l = this.a.m4739a();
        this.f3825m = this.a.m4745e();
        ((RelativeLayout) findViewById(R.id.pageArea)).getLayoutParams().height = m4987h();
        m4986g();
        this.f3834v = getIntent().getIntExtra("verify_msisdn_case", Size.CROP);
        CharSequence stringExtra = getIntent().getStringExtra("msisdn");
        C1216a.m4522b("msisdn ", "saved " + this.f3825m.m4651b("msisdn", ""));
        C1216a.m4522b("msisdn ", "new " + stringExtra);
        this.f3826n = (EditText) findViewById(R.id.revalidation_mobilenum_edittext);
        this.f3827o = (EditText) findViewById(R.id.revalidation_firstname_edittext);
        this.f3828p = (EditText) findViewById(R.id.revalidation_lastname_edittext);
        this.f3829q = (EditText) findViewById(R.id.revalidation_email_edittext);
        this.f3830r = (Button) findViewById(R.id.revalidation_birth_select_button);
        this.f3831s = (Button) findViewById(R.id.revalidation_birth_picker_button);
        this.f3832t = (RelativeLayout) findViewById(R.id.revalidation_birth_layout);
        this.f3826n.setText(stringExtra);
        if (this.f3834v == Size.CROP) {
            this.f3832t.setVisibility(0);
        } else {
            this.f3832t.setVisibility(8);
        }
        this.f3826n.addTextChangedListener(new C1609a(this.f3826n));
        this.f3826n.setRawInputType(3);
        this.f3826n.setHint(R.string.input_mobile_number);
        this.f3830r.setOnTouchListener(this.f3818C);
        this.f3831s.setOnTouchListener(this.f3818C);
        this.f3833u = (Button) findViewById(R.id.revalidation_done_button);
        this.f3833u.setOnClickListener(this.f3819D);
        m5869q();
        this.f3826n.requestFocus();
        getWindow().setSoftInputMode(4);
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f3816k, " in onDestroy >>>>>");
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f3816k, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f3816k, " in onResume >>>>>");
    }
}
