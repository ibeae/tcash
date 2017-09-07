package com.telkom.mwallet.setting;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import com.facebook.AppEventsConstants;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.C1245f;
import com.skcc.wallet.framework.api.http.model.GetMWalletNotificationRs;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.p064a.C1358h;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;

public class TWalletNewsActivity extends SlidingFrameActivity {
    public static final String f4028k = TWalletNewsActivity.class.getSimpleName();
    private C1298u f4029l;
    private FragmentManager f4030m;
    private C1646g f4031n;
    private C1326f f4032o = new C16271(this);

    class C16271 implements C1326f {
        final /* synthetic */ TWalletNewsActivity f4027a;

        C16271(TWalletNewsActivity tWalletNewsActivity) {
            this.f4027a = tWalletNewsActivity;
        }

        public void mo1485a() {
            if (this.f4027a.h != null) {
                this.f4027a.h.dismiss();
            }
            this.f4027a.finish();
        }

        public void mo1486b() {
        }
    }

    public void mo1487a() {
        m4990k();
        this.h = m4967a(this.f4032o, (int) R.string.no_network);
    }

    public void m6176a(int i) {
        m4972a((Context) this, (int) R.string.loading);
        this.f4029l.m4669a(10, i + 1, (C1245f) this);
    }

    public void mo1488a(String str) {
        m4972a((Context) this, (int) R.string.loading);
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f4032o, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("getMWalletNotification".equalsIgnoreCase(str)) {
            this.f4031n.m6220a(((GetMWalletNotificationRs) obj).getNotifications());
            this.b.m4648a(C1358h.f2934e, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            this.b.m4647a(C1358h.f2935f, System.currentTimeMillis());
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4967a(this.f4032o, (int) R.string.no_response);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    public void onBackPressed() {
        finish();
    }

    public void onCreate(Bundle bundle) {
        this.f4031n = new C1646g();
        super.m5019a(this.f4031n);
        super.onCreate(bundle);
        this.f4029l = this.a.m4739a();
        this.f4030m = getSupportFragmentManager();
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f4028k, " in onDestroy >>>>>");
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f4028k, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f4028k, " in onResume >>>>>");
    }
}
