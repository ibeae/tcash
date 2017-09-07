package com.telkom.mwallet.setting;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1298u;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;

public class TWalletNewsDetailActivity extends SlidingFrameActivity {
    public static final String f4034k = TWalletNewsDetailActivity.class.getSimpleName();
    private C1298u f4035l;
    private FragmentManager f4036m;
    private C1641f f4037n;
    private C1326f f4038o = new C16281(this);

    class C16281 implements C1326f {
        final /* synthetic */ TWalletNewsDetailActivity f4033a;

        C16281(TWalletNewsDetailActivity tWalletNewsDetailActivity) {
            this.f4033a = tWalletNewsDetailActivity;
        }

        public void mo1485a() {
            if (this.f4033a.h != null) {
                this.f4033a.h.dismiss();
            }
            this.f4033a.finish();
        }

        public void mo1486b() {
        }
    }

    public void onBackPressed() {
        finish();
    }

    public void onCreate(Bundle bundle) {
        this.f4037n = new C1641f();
        super.m5019a(this.f4037n);
        super.onCreate(bundle);
        this.f4035l = this.a.m4739a();
        this.f4036m = getSupportFragmentManager();
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f4034k, " in onDestroy >>>>>");
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f4034k, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f4034k, " in onResume >>>>>");
    }
}
