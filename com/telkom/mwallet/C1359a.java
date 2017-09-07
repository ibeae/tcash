package com.telkom.mwallet;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.amobee.adsdk.AdManager;
import com.amobee.adsdk.AdManager.DebugLevel;
import com.amobee.adsdk.AmobeeAdPlaceholder;
import com.amobee.adsdk.AmobeeInterstitial;
import com.amobee.adsdk.AmobeeInterstitialListener;
import com.amobee.adsdk.IAmobeeListener;
import com.amobee.adsdk.Parameters.Gender;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.core.se.SException;
import com.skcc.wallet.framework.api.C1227c;
import com.skcc.wallet.framework.api.C1260j;
import com.skcc.wallet.framework.api.C1272r;
import com.skcc.wallet.framework.api.http.C1245f;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.C1518d.C1517c;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.home.C1559a;
import com.telkom.mwallet.login.LoginActivity;
import com.telkom.mwallet.p064a.C1350d;
import org.acra.ACRA;
import twitter4j.HttpResponseCode;

public class C1359a extends SlidingFragmentActivity implements C1245f {
    private static final String f2946k = C1359a.class.getSimpleName();
    protected TelkomApplication f2947a;
    protected C1272r f2948b;
    protected C1260j f2949c;
    protected C1350d f2950d;
    protected C1227c f2951e;
    protected ProgressDialog f2952f;
    public C1514b f2953g;
    protected C1514b f2954h;
    protected C1517c f2955i;
    AmobeeAdPlaceholder f2956j = null;
    private boolean f2957l = false;
    private boolean f2958m = false;
    private AdManager f2959n = null;
    private C1341b f2960o = new C13425(this);
    private C1326f f2961p = new C13436(this);

    class C13371 implements IAmobeeListener {
        final /* synthetic */ C1359a f2894a;

        C13371(C1359a c1359a) {
            this.f2894a = c1359a;
        }

        public void amobeeOnAdFailed(AmobeeAdPlaceholder amobeeAdPlaceholder) {
            C1216a.m4519a("AmobeeTestApplication", "amobeeAdFailed");
        }

        public void amobeeOnAdRecieved(AmobeeAdPlaceholder amobeeAdPlaceholder) {
            C1216a.m4519a("AmobeeTestApplication", "amobeeAdRecieved");
        }

        public void amobeeOnError() {
            C1216a.m4519a("AmobeeTestApplication", "amobeeOnError");
        }

        public void amobeeOnLeavingApplication(AmobeeAdPlaceholder amobeeAdPlaceholder) {
            C1216a.m4519a("AmobeeTestApplication", "amobeeOnLeavingApplication");
        }

        public void amobeeOnOverlay(AmobeeAdPlaceholder amobeeAdPlaceholder) {
            C1216a.m4519a("AmobeeTestApplication", "amobeeOnOverlay");
        }

        public void amobeeOnOverlayDismissed(AmobeeAdPlaceholder amobeeAdPlaceholder) {
            C1216a.m4519a("AmobeeTestApplication", "amobeeOnOverlayDismissed");
        }
    }

    class C13382 implements AmobeeInterstitialListener {
        final /* synthetic */ C1359a f2895a;

        C13382(C1359a c1359a) {
            this.f2895a = c1359a;
        }

        public void interstitialClicked(AmobeeInterstitial amobeeInterstitial) {
        }

        public void interstitialClosed(AmobeeInterstitial amobeeInterstitial) {
        }

        public void interstitialFailed(AmobeeInterstitial amobeeInterstitial) {
        }

        public void interstitialRecieved(AmobeeInterstitial amobeeInterstitial) {
            amobeeInterstitial.show(this.f2895a);
        }
    }

    class C13393 implements C1326f {
        final /* synthetic */ C1359a f2896a;

        C13393(C1359a c1359a) {
            this.f2896a = c1359a;
        }

        public void mo1485a() {
            if (this.f2896a.f2954h != null) {
                this.f2896a.f2954h.dismiss();
            }
            this.f2896a.mo1505o();
            Intent intent = new Intent(this.f2896a, StartActivity.class);
            intent.setFlags(335577088);
            this.f2896a.startActivity(intent);
            this.f2896a.finish();
        }

        public void mo1486b() {
        }
    }

    class C13404 implements C1326f {
        final /* synthetic */ C1359a f2897a;

        C13404(C1359a c1359a) {
            this.f2897a = c1359a;
        }

        public void mo1485a() {
            if (this.f2897a.f2954h != null) {
                this.f2897a.f2954h.dismiss();
            }
            this.f2897a.finish();
        }

        public void mo1486b() {
        }
    }

    class C13425 implements C1341b {
        final /* synthetic */ C1359a f2898a;

        C13425(C1359a c1359a) {
            this.f2898a = c1359a;
        }

        public void mo1498a() {
            this.f2898a.f2958m = true;
            this.f2898a.m4991l();
            if (this.f2898a.f2957l) {
                this.f2898a.m4992m();
                this.f2898a.f2948b.m4648a("msisdn_autologout", this.f2898a.f2948b.m4651b("msisdn", ""));
                Intent intent = new Intent(this.f2898a, LoginActivity.class);
                intent.setFlags(335577088);
                this.f2898a.startActivity(intent);
            }
        }
    }

    class C13436 implements C1326f {
        final /* synthetic */ C1359a f2899a;

        C13436(C1359a c1359a) {
            this.f2899a = c1359a;
        }

        public void mo1485a() {
            if (this.f2899a.f2953g != null) {
                this.f2899a.f2953g.dismiss();
            }
            Intent intent = new Intent(this.f2899a, LoginActivity.class);
            intent.setFlags(268468224);
            this.f2899a.startActivity(intent);
        }

        public void mo1486b() {
        }
    }

    public static void m4963a(Object obj, String str) {
        C1216a.m4519a(obj.getClass().getSimpleName(), "" + str);
    }

    private void mo1505o() {
        this.f2947a.m4739a().m4725g(this);
    }

    public C1514b m4967a(C1326f c1326f, int i) {
        Fragment a = C1514b.m5647a(i);
        a.m5651a(c1326f);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add(a, "notice");
        try {
            beginTransaction.commitAllowingStateLoss();
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public C1514b m4968a(C1326f c1326f, int i, boolean z) {
        Fragment a = C1514b.m5647a(i);
        a.m5651a(c1326f);
        if (!z) {
            a.setCancelable(false);
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add(a, "notice");
        try {
            beginTransaction.commitAllowingStateLoss();
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public C1514b m4969a(C1326f c1326f, String str) {
        Fragment a = C1514b.m5650a(str);
        a.m5651a(c1326f);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add(a, "notice");
        try {
            beginTransaction.commitAllowingStateLoss();
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public C1514b m4970a(C1326f c1326f, String str, boolean z) {
        Fragment a = C1514b.m5650a(str);
        a.m5651a(c1326f);
        if (!z) {
            a.setCancelable(false);
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add(a, "notice");
        try {
            beginTransaction.commitAllowingStateLoss();
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void mo1487a() {
    }

    public void m4972a(Context context, int i) {
        if (this.f2952f == null || !this.f2952f.isShowing()) {
            try {
                this.f2952f = ProgressDialog.show(context, getString(R.string.app_name_tel), getString(i), true);
                this.f2952f.setContentView(R.layout.dialog_progress);
                this.f2947a.m4899j().m4932a(context, (TextView) this.f2952f.findViewById(R.id.progressbar_dialog_title), 3);
            } catch (Exception e) {
            }
        }
    }

    public void m4973a(Context context, String str) {
        if (this.f2952f == null || !this.f2952f.isShowing()) {
            try {
                this.f2952f = ProgressDialog.show(context, getString(R.string.app_name_tel), str, true);
                this.f2952f.setContentView(R.layout.dialog_progress);
                View view = (TextView) this.f2952f.findViewById(R.id.progressbar_dialog_message);
                this.f2947a.m4899j().m4932a(context, (TextView) this.f2952f.findViewById(R.id.progressbar_dialog_title), 3);
                this.f2947a.m4899j().m4932a(context, view, 3);
            } catch (Exception e) {
            }
        }
    }

    public void mo1488a(String str) {
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.f2948b.m4647a("time for update", System.currentTimeMillis());
        if (i == HttpResponseCode.UNAUTHORIZED) {
            m4989j();
        } else if ("login".equalsIgnoreCase(str) && i == 30004) {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f2946k, "onSuccessNetwork");
        this.f2948b.m4647a("time for update", System.currentTimeMillis());
    }

    public void addAD(View view) {
        this.f2956j = (AmobeeAdPlaceholder) view.findViewById(R.id.placeholder);
        m4986g();
    }

    public C1517c m4977b(C1326f c1326f, int i, boolean z) {
        Fragment a = C1517c.m5654a(i);
        a.m5656a(c1326f);
        if (!z) {
            a.setCancelable(false);
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add(a, "notice2");
        try {
            beginTransaction.commitAllowingStateLoss();
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void mo1491b() {
    }

    public void m4979b(String str) {
        this.f2954h = C1514b.m5650a(str);
        this.f2954h.m5651a(new C13404(this));
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add(this.f2954h, "notice");
        try {
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
            this.f2954h = null;
        }
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    protected void m4981c(String str) {
        if (!this.f2947a.m4745e().m4651b("is_nfc_yn", "N").equals("n")) {
            try {
                this.f2947a.m4742b();
                this.f2947a.m4742b().m4641c().m4534a(str);
                this.f2947a.m4745e().m4648a("activated_aid", str);
                this.f2947a.m4745e().m4649a("isActivateCheckNeeded", true);
                ACRA.log.mo1627d("CARD", "Activate success");
            } catch (SException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public C1350d m4982d() {
        if (this.f2947a == null) {
            this.f2947a = (TelkomApplication) getApplication();
        }
        if (this.f2950d == null) {
            this.f2950d = this.f2947a.m4899j();
        }
        return this.f2950d;
    }

    protected void m4983d(String str) {
        String b = this.f2947a.m4745e().m4651b("activated_aid", "");
        if (b.equals(str)) {
            try {
                this.f2947a.m4742b().m4641c().m4535b("A000000003101001");
                this.f2947a.m4745e().m4649a("isActivateCheckNeeded", false);
                this.f2947a.m4745e().m4648a("activated_aid", "");
                C1216a.m4519a("CARD", "deActivate success");
            } catch (SException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (!b.isEmpty()) {
            m4983d(b);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.f2947a.m4894a(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    public C1272r m4984e() {
        return this.f2948b;
    }

    public C1227c m4985f() {
        return this.f2951e;
    }

    public void m4986g() {
        this.f2959n = AdManager.getInstance(this);
        AdManager.debugLevel = DebugLevel.NODEBUG;
        this.f2959n.setUserGestureRequiredToOpenAds(true);
        this.f2959n.setServerURL("http://telkomselprod.amobee.com/upsteed/wap/adrequest");
        this.f2959n.parameters().setAdSpace("16226");
        this.f2959n.parameters().setTargetingParameter("acc", "4040581");
        this.f2959n.parameters().setGender(Gender.Male);
        this.f2959n.parameters().setAge(30);
        this.f2959n.parameters().setCountryCode("US");
        this.f2959n.parameters().setZip("12345");
        this.f2959n.parameters().setDma("dmaTest");
        this.f2959n.setAmobeeListener(new C13371(this));
        AmobeeInterstitial amobeeInterstitial = new AmobeeInterstitial();
        amobeeInterstitial.setListener(new C13382(this));
        amobeeInterstitial.getInterstitial("16226");
    }

    public int m4987h() {
        return getResources().getDisplayMetrics().heightPixels - m4988i();
    }

    public int m4988i() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        return identifier > 0 ? getResources().getDimensionPixelSize(identifier) : 0;
    }

    public void m4989j() {
        this.f2954h = m4967a(new C13393(this), (int) R.string.session_timeout);
    }

    public void m4990k() {
        if (this.f2952f != null && this.f2952f.isShowing()) {
            this.f2952f.dismiss();
        }
    }

    public void m4991l() {
        this.f2947a.m4896g().m5613b();
    }

    protected void m4992m() {
        String b = this.f2947a.m4745e().m4651b("activated_aid", "");
        if (!b.isEmpty()) {
            m4983d(b);
        }
    }

    protected void m4993n() {
        this.f2947a.m4896g().m5612a(this.f2960o);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1216a.m4519a(f2946k, " in onCreate >>>>>" + getClass().getSimpleName());
        this.f2947a = (TelkomApplication) getApplication();
        this.f2950d = this.f2947a.m4899j();
        this.f2948b = this.f2947a.m4745e();
        this.f2951e = this.f2947a.m4746f();
        C1559a.m5752a().m5753a(this);
        this.f2948b.m4647a("time for update", 0);
        this.f2949c = this.f2947a.m4744d();
        if (this.f2949c.mo1464a() == null) {
            C1216a.m4519a(f2946k, "get cookie in onCreate");
            this.f2949c.mo1465a(this.f2948b.m4651b("COOKIE", ""));
        }
    }

    protected void onDestroy() {
        if (this.f2952f != null && this.f2952f.isShowing()) {
            this.f2952f.dismiss();
        }
        C1559a.m5752a().m5755b(this);
        if (C1559a.m5752a().m5756c()) {
            this.f2948b.m4648a("msisdn_autologout", "");
        }
        super.onDestroy();
        C1216a.m4519a(f2946k, " in onDestroy >>>>>" + getClass().getSimpleName());
    }

    protected void onPause() {
        this.f2957l = false;
        C1216a.m4519a(f2946k, " in onPause >>>>>");
        if (this.f2952f != null && this.f2952f.isShowing()) {
            this.f2952f.dismiss();
            this.f2952f = null;
        }
        super.onPause();
        if (this.f2959n != null) {
            this.f2959n.setRefreshInterval(0);
        }
        if (this.f2949c.mo1464a() != null) {
            C1216a.m4519a(f2946k, "set cookie in onPause");
            this.f2948b.m4648a("COOKIE", this.f2949c.mo1464a());
        }
    }

    protected void onResume() {
        C1216a.m4519a(f2946k, " in onResume >>>>>");
        this.f2947a.m4894a(true);
        super.onResume();
        this.f2957l = true;
        if (this.f2959n != null) {
            this.f2959n.setRefreshInterval(30);
            this.f2959n.getAd();
        }
    }

    public void onStart() {
        super.onStart();
        if (!this.f2958m || this.f2957l) {
            m4991l();
            this.f2947a.m4896g().m5611a();
            m4993n();
            this.f2958m = false;
            return;
        }
        m4992m();
        this.f2948b.m4648a("msisdn_autologout", this.f2948b.m4651b("msisdn", ""));
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(335577088);
        startActivity(intent);
    }

    public void onStop() {
        super.onStop();
    }

    public void setContentView(int i) {
        if (getSlidingMenu().getMode() == 2) {
            super.setContentView(i);
            return;
        }
        getSlidingMenu().setSlidingEnabled(false);
        super.setContentView(i);
        setBehindContentView((int) R.layout.frame_menu_left);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    public void startActivity(Intent intent) {
        intent.addFlags(67108864);
        super.startActivity(intent);
    }
}
