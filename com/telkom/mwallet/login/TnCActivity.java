package com.telkom.mwallet.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.C1245f;
import com.skcc.wallet.framework.api.http.model.GetTncRs;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.StartActivity;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.view.waletWebView;

public class TnCActivity extends C1359a {
    private static final String f3905l = TnCActivity.class.getSimpleName();
    public C1326f f3906k = new C16025(this);
    private C1298u f3907m;
    private waletWebView f3908n;
    private waletWebView f3909o;
    private Button f3910p;
    private OnClickListener f3911q = new C15981(this);
    private C1245f f3912r = new C15992(this);
    private C1245f f3913s = new C16003(this);
    private C1326f f3914t = new C16014(this);

    class C15981 implements OnClickListener {
        final /* synthetic */ TnCActivity f3900a;

        C15981(TnCActivity tnCActivity) {
            this.f3900a = tnCActivity;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tnc_agree_button:
                    this.f3900a.mo1505o();
                    return;
                default:
                    return;
            }
        }
    }

    class C15992 implements C1245f {
        final /* synthetic */ TnCActivity f3901a;

        C15992(TnCActivity tnCActivity) {
            this.f3901a = tnCActivity;
        }

        public void mo1487a() {
            this.f3901a.m4990k();
            this.f3901a.h = this.f3901a.m4968a(this.f3901a.f3914t, (int) R.string.no_network, false);
        }

        public void mo1488a(String str) {
        }

        public void mo1489a(String str, int i, String str2, String str3, Object obj) {
            this.f3901a.b.m4647a("time for update", System.currentTimeMillis());
            this.f3901a.m4990k();
            this.f3901a.h = this.f3901a.m4969a(this.f3901a.f3914t, "" + str3);
        }

        public void mo1490a(String str, Object obj) {
            C1216a.m4519a(TnCActivity.f3905l, "onSuccessNetwork");
            this.f3901a.b.m4647a("time for update", System.currentTimeMillis());
            GetTncRs getTncRs = (GetTncRs) obj;
            this.f3901a.f3908n.loadData("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" + getTncRs.getContents(), "text/html", "UTF-8");
        }

        public void mo1491b() {
            this.f3901a.m4990k();
            this.f3901a.h = this.f3901a.m4968a(this.f3901a.f3914t, (int) R.string.no_response, false);
        }

        public void mo1492c() {
            this.f3901a.m4990k();
            this.f3901a.m4989j();
        }
    }

    class C16003 implements C1245f {
        final /* synthetic */ TnCActivity f3902a;

        C16003(TnCActivity tnCActivity) {
            this.f3902a = tnCActivity;
        }

        public void mo1487a() {
            this.f3902a.m4990k();
            this.f3902a.h = this.f3902a.m4968a(this.f3902a.f3914t, (int) R.string.no_network, false);
        }

        public void mo1488a(String str) {
        }

        public void mo1489a(String str, int i, String str2, String str3, Object obj) {
            this.f3902a.b.m4647a("time for update", System.currentTimeMillis());
            this.f3902a.m4990k();
        }

        public void mo1490a(String str, Object obj) {
            C1216a.m4519a(TnCActivity.f3905l, "onSuccessNetwork");
            this.f3902a.b.m4647a("time for update", System.currentTimeMillis());
            this.f3902a.m4990k();
            GetTncRs getTncRs = (GetTncRs) obj;
            this.f3902a.f3909o.loadData("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" + getTncRs.getContents(), "text/html", "UTF-8");
        }

        public void mo1491b() {
            this.f3902a.m4990k();
            this.f3902a.h = this.f3902a.m4968a(this.f3902a.f3914t, (int) R.string.no_response, false);
        }

        public void mo1492c() {
            this.f3902a.m4990k();
            this.f3902a.m4989j();
        }
    }

    class C16014 implements C1326f {
        final /* synthetic */ TnCActivity f3903a;

        C16014(TnCActivity tnCActivity) {
            this.f3903a = tnCActivity;
        }

        public void mo1485a() {
            if (this.f3903a.h != null) {
                this.f3903a.h.dismiss();
            }
            this.f3903a.finish();
        }

        public void mo1486b() {
        }
    }

    class C16025 implements C1326f {
        final /* synthetic */ TnCActivity f3904a;

        C16025(TnCActivity tnCActivity) {
            this.f3904a = tnCActivity;
        }

        public void mo1485a() {
            if (this.f3904a.i != null) {
                this.f3904a.i.dismiss();
            }
            Intent intent = new Intent(this.f3904a, StartActivity.class);
            intent.setFlags(603979776);
            this.f3904a.startActivity(intent);
            this.f3904a.finish();
        }

        public void mo1486b() {
            if (this.f3904a.i != null) {
                this.f3904a.i.dismiss();
            }
        }
    }

    private void m6028q() {
        this.d.m4932a((Context) this, (TextView) findViewById(R.id.titlebar_view), 1);
        this.d.m4932a((Context) this, this.f3910p, 4);
    }

    protected void mo1505o() {
        Intent intent = new Intent(this, VerifyMSISDNActivity.class);
        intent.setFlags(603979776);
        intent.putExtra("verify_msisdn_case", 103);
        startActivity(intent);
        finish();
    }

    public void onBackPressed() {
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_tnc);
        this.f3907m = this.a.m4739a();
        this.b = this.a.m4745e();
        this.f3908n = (waletWebView) findViewById(R.id.tnc_twallet_agree_webview);
        this.f3909o = (waletWebView) findViewById(R.id.tnc_tcash_agree_webview);
        this.f3910p = (Button) findViewById(R.id.tnc_agree_button);
        this.f3910p.setOnClickListener(this.f3911q);
        m6028q();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.h != null) {
            this.h.dismiss();
        }
        if (this.i != null) {
            this.i.dismiss();
        }
        C1216a.m4519a(f3905l, " in onDestroy >>>>>");
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f3905l, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f3905l, " in onResume >>>>>");
        String b = m4984e().m4651b("Telkom_language", "en");
        C1216a.m4522b("LANGUAGE ", "language " + b + "vs " + "English");
        if ("en".equals(b)) {
            this.f3907m.m4709c("wallet_en.htm", this.f3912r);
            this.f3907m.m4709c("tcash_en.htm", this.f3913s);
        } else if ("in".equals(b) || "id".equals(b)) {
            this.f3907m.m4709c("wallet_id.htm", this.f3912r);
            this.f3907m.m4709c("tcash_id.htm", this.f3913s);
        }
    }
}
