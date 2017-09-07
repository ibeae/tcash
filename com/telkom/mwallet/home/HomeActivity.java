package com.telkom.mwallet.home;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.model.GetTcashBalanceRs;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.login.LoginActivity;
import com.telkom.mwallet.p064a.C1358h;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import twitter4j.HttpResponseCode;

public class HomeActivity extends SlidingFrameActivity {
    static final String f3727k = HomeActivity.class.getSimpleName();
    private C1326f f3728A = new C15571(this);
    private C1326f f3729B = new C15582(this);
    boolean f3730l = true;
    boolean f3731m = false;
    private C1298u f3732n;
    private C1569f f3733o;
    private String f3734z;

    class C15571 implements C1326f {
        final /* synthetic */ HomeActivity f3725a;

        C15571(HomeActivity homeActivity) {
            this.f3725a = homeActivity;
        }

        public void mo1485a() {
            if (this.f3725a.h != null) {
                this.f3725a.h.dismiss();
            }
        }

        public void mo1486b() {
            if (this.f3725a.h != null) {
                this.f3725a.h.dismiss();
            }
        }
    }

    class C15582 implements C1326f {
        final /* synthetic */ HomeActivity f3726a;

        C15582(HomeActivity homeActivity) {
            this.f3726a = homeActivity;
        }

        public void mo1485a() {
            if (this.f3726a.i != null) {
                this.f3726a.i.dismiss();
            }
            this.f3726a.m5741s();
            Intent intent = new Intent(this.f3726a, LoginActivity.class);
            intent.setFlags(335577088);
            this.f3726a.startActivity(intent);
            this.f3726a.finish();
            C1559a.m5752a().m5759f();
        }

        public void mo1486b() {
            if (this.f3726a.i != null) {
                this.f3726a.i.dismiss();
            }
        }
    }

    private void m5741s() {
        this.a.m4739a().m4725g(this);
    }

    public void mo1487a() {
        m4990k();
        this.h = m4968a(this.f3728A, (int) R.string.no_network, false);
    }

    public void mo1488a(String str) {
        m4973a((Context) this, getString(R.string.loading));
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f3728A, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("getTcashBalance".equalsIgnoreCase(str)) {
            GetTcashBalanceRs getTcashBalanceRs = (GetTcashBalanceRs) obj;
            this.f3733o.m5772b(String.valueOf(getTcashBalanceRs.getTcashBalance()));
            this.b.m4647a(C1358h.f2935f, System.currentTimeMillis());
            this.b.m4648a(C1358h.f2934e, String.valueOf(getTcashBalanceRs.getNewNoticeCount()));
            C1216a.m4522b("Balance", "setbal " + getTcashBalanceRs.getTcashBalance());
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4968a(this.f3728A, (int) R.string.no_response, false);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    public void mo1505o() {
        if (this.f3730l) {
            this.f3730l = false;
        } else if (this.f3733o != null) {
            this.f3732n.m4729i(this);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        C1216a.m4522b(f3727k, "onActivityResult :: " + i);
        if (i2 == -1) {
            String stringExtra = intent.getStringExtra("SCAN_RESULT");
            String stringExtra2 = intent.getStringExtra("SCAN_RESULT_FORMAT");
            if (stringExtra.length() != 21) {
                this.h = m4967a(this.f3728A, (int) R.string.msg_invalid_code);
                return;
            }
            Toast makeText = Toast.makeText(this, "Content:" + stringExtra + " Format:" + stringExtra2, 1);
            makeText.setGravity(48, 25, HttpResponseCode.BAD_REQUEST);
            makeText.show();
            stringExtra.substring(0, 6);
            stringExtra.substring(6, 15);
            stringExtra.substring(15);
        } else if (i2 == 0) {
            Toast makeText2 = Toast.makeText(this, "Scan was Cancelled!", 1);
            makeText2.setGravity(48, 25, HttpResponseCode.BAD_REQUEST);
            makeText2.show();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        this.f3733o = new C1569f();
        super.m5019a(this.f3733o);
        super.onCreate(bundle);
        this.f3732n = this.a.m4739a();
        this.f3734z = this.b.m4651b("TCASH_STATUS", "");
        this.f3733o.m5773c(this.f3734z);
        setVolumeControlStream(3);
        this.f3732n.m4729i(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f3727k, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f3727k, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f3727k, " in onResume >>>>>");
    }

    public boolean m5749p() {
        return C1358h.f2933d.equalsIgnoreCase(this.f3734z);
    }

    protected void m5750q() {
        MediaPlayer create = MediaPlayer.create(this, R.raw.onhover_ogg);
        create.setVolume(0.3f, 0.3f);
        create.start();
        this.f3731m = false;
    }

    public void m5751r() {
        this.h = m4968a(this.f3728A, (int) R.string.tcash_grade_info, true);
    }
}
