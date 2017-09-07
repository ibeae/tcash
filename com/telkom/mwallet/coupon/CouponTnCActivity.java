package com.telkom.mwallet.coupon;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import com.skcc.wallet.core.p057a.C1216a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.StartActivity;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import com.telkom.mwallet.view.C2012b;

public class CouponTnCActivity extends SlidingFrameActivity {
    private static final String f3273l = CouponTnCActivity.class.getSimpleName();
    public C1326f f3274k = new C14332(this);
    private WebView f3275m;
    private Button f3276n;
    private OnClickListener f3277o = new C14321(this);

    class C14321 implements OnClickListener {
        final /* synthetic */ CouponTnCActivity f3271a;

        C14321(CouponTnCActivity couponTnCActivity) {
            this.f3271a = couponTnCActivity;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tnc_agree_button:
                    this.f3271a.finish();
                    return;
                default:
                    return;
            }
        }
    }

    class C14332 implements C1326f {
        final /* synthetic */ CouponTnCActivity f3272a;

        C14332(CouponTnCActivity couponTnCActivity) {
            this.f3272a = couponTnCActivity;
        }

        public void mo1485a() {
            if (this.f3272a.i != null) {
                this.f3272a.i.dismiss();
            }
            Intent intent = new Intent(this.f3272a, StartActivity.class);
            intent.setFlags(603979776);
            this.f3272a.startActivity(intent);
            this.f3272a.finish();
        }

        public void mo1486b() {
            if (this.f3272a.i != null) {
                this.f3272a.i.dismiss();
            }
        }
    }

    private void m5415o() {
        this.d.m4932a((Context) this, (TextView) findViewById(R.id.titlebar_view), 1);
        this.d.m4932a((Context) this, this.f3276n, 4);
    }

    public void onBackPressed() {
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_coupon_tnc);
        this.f3275m = (WebView) findViewById(R.id.info_webview);
        this.f3275m.setWebViewClient(new C2012b(this));
        this.f3276n = (Button) findViewById(R.id.tnc_agree_button);
        this.f3276n.setText(getString(R.string.btn_ok));
        this.f3276n.setOnClickListener(this.f3277o);
        m5415o();
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f3273l, " in onDestroy >>>>>");
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f3273l, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f3273l, " in onResume >>>>>");
        String stringExtra = getIntent().getStringExtra("coupon_tnc");
        this.f3275m.loadUrl(stringExtra);
        C1216a.m4519a(f3273l, "loadUrl  >>>>>" + stringExtra);
    }
}
