package com.telkom.mwallet.cards;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1274t;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.model.ServiceVo;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;

public class CardTopupActivity extends SlidingFrameActivity {
    private static final String f3037l = CardTopupActivity.class.getSimpleName();
    ServiceVo f3038k;
    private C1298u f3039m;
    private FragmentManager f3040n;
    private C1410j f3041o;
    private C1326f f3042z = new C13802(this);

    class C13791 implements C1274t {
        final /* synthetic */ CardTopupActivity f3035a;

        C13791(CardTopupActivity cardTopupActivity) {
            this.f3035a = cardTopupActivity;
        }

        public void mo1487a() {
            this.f3035a.m4990k();
            this.f3035a.h = this.f3035a.m4968a(this.f3035a.f3042z, (int) R.string.no_network, false);
        }

        public void mo1512a(int i, String str) {
            this.f3035a.m4990k();
            this.f3035a.h = this.f3035a.m4970a(this.f3035a.f3042z, "" + str, false);
        }

        public void mo1513a(Double d) {
            this.f3035a.m4990k();
            this.f3035a.f3041o.m5295a(d.doubleValue());
        }

        public void mo1491b() {
            this.f3035a.m4990k();
            this.f3035a.h = this.f3035a.m4968a(this.f3035a.f3042z, (int) R.string.no_response, false);
        }

        public void mo1492c() {
            this.f3035a.m4990k();
            this.f3035a.m4989j();
        }
    }

    class C13802 implements C1326f {
        final /* synthetic */ CardTopupActivity f3036a;

        C13802(CardTopupActivity cardTopupActivity) {
            this.f3036a = cardTopupActivity;
        }

        public void mo1485a() {
            if (this.f3036a.h != null) {
                this.f3036a.h.dismiss();
            }
            this.f3036a.finish();
        }

        public void mo1486b() {
        }
    }

    public void m5183e(String str) {
        m4972a((Context) this, (int) R.string.loading);
        this.f3039m.m4689a(this.f3038k.getServiceId(), str, new C13791(this));
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        this.f3041o = new C1410j();
        super.m5019a(this.f3041o);
        super.onCreate(bundle);
        this.f3039m = this.a.m4739a();
        this.f3040n = getSupportFragmentManager();
        this.f3038k = (ServiceVo) getIntent().getSerializableExtra("SELECTED_CARD");
    }

    protected void onDestroy() {
        m4983d(this.f3038k.getDeviceAppletId());
        super.onDestroy();
        C1216a.m4519a(f3037l, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f3037l, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f3037l, " in onResume >>>>>");
    }
}
