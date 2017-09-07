package com.telkom.mwallet.cards;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.model.ServiceVo;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;

public class CardHomeActivity extends SlidingFrameActivity {
    private static final String f3012l = CardHomeActivity.class.getSimpleName();
    ServiceVo f3013k;
    private C1298u f3014m;
    private FragmentManager f3015n;
    private C1397e f3016o;
    private C1326f f3017z = new C13722(this);

    class C13722 implements C1326f {
        final /* synthetic */ CardHomeActivity f3011a;

        C13722(CardHomeActivity cardHomeActivity) {
            this.f3011a = cardHomeActivity;
        }

        public void mo1485a() {
            if (this.f3011a.h != null) {
                this.f3011a.h.dismiss();
            }
            this.f3011a.finish();
        }

        public void mo1486b() {
        }
    }

    public void mo1505o() {
        C1403g c1403g = new C1403g();
        c1403g.m5274a(getApplicationContext());
        c1403g.setStyle(1, R.style.tcash_menu_dialog);
        c1403g.show(this.f3015n, null);
        m4981c(this.f3013k.getDeviceAppletId());
        final String deviceAppletId = this.f3013k.getDeviceAppletId();
        new Handler().postDelayed(new Runnable(this) {
            final /* synthetic */ CardHomeActivity f3010b;

            public void run() {
                this.f3010b.m4983d(deviceAppletId);
            }
        }, 180000);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        this.f3016o = new C1397e();
        super.m5019a(this.f3016o);
        super.onCreate(bundle);
        this.f3013k = (ServiceVo) getIntent().getSerializableExtra("SELECTED_CARD");
        this.f3014m = this.a.m4739a();
        this.f3015n = getSupportFragmentManager();
    }

    protected void onDestroy() {
        if (this.f3013k != null) {
            m4983d(this.f3013k.getDeviceAppletId());
        }
        super.onDestroy();
        C1216a.m4519a(f3012l, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f3012l, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f3012l, " in onResume >>>>>");
    }
}
