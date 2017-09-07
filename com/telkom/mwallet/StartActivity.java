package com.telkom.mwallet;

import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.telephony.TelephonyManager;
import com.appsflyer.AppsFlyerLib;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1261k;
import com.skcc.wallet.framework.api.C1272r;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.C1245f;
import com.skcc.wallet.framework.api.http.model.CheckWalletUpdateRs;
import com.skcc.wallet.framework.api.http.model.LoginRs;
import com.skcc.wallet.framework.p061c.C1303a;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.C1518d.C1517c;
import com.telkom.mwallet.dialog.C1527g;
import com.telkom.mwallet.dialog.p063a.C1324e;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.home.HomeActivity;
import com.telkom.mwallet.login.LoginActivity;
import com.telkom.mwallet.login.RevalidationActivity;
import com.telkom.mwallet.login.SetTcashPinActivity;
import com.telkom.mwallet.p064a.C1349c;
import com.telkom.mwallet.p064a.C1351e;
import com.telkom.mwallet.p064a.C1358h;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StartActivity extends FragmentActivity implements C1245f {
    public static Boolean f2863a = Boolean.valueOf(false);
    static long f2864e;
    static long f2865f;
    private static final String f2866g = StartActivity.class.getSimpleName();
    protected TelkomApplication f2867b;
    protected C1514b f2868c;
    protected C1517c f2869d;
    private C1298u f2870h;
    private C1272r f2871i;
    private String f2872j;
    private C1527g f2873k;
    private C1303a f2874l;
    private C1261k f2875m = new C13283(this);
    private C1326f f2876n = new C13305(this);
    private C1326f f2877o = new C13326(this);
    private C1326f f2878p = new C13337(this);
    private C1326f f2879q = new C13348(this);
    private C1326f f2880r = new C13359(this);
    private C1324e f2881s = new C1324e(this) {
        final /* synthetic */ StartActivity f2852a;

        {
            this.f2852a = r1;
        }

        public void mo1483a(int i) {
        }

        public void mo1484a(String str) {
            Configuration configuration = new Configuration();
            Locale locale = null;
            if ("English".equals(str)) {
                locale = new Locale("en");
            } else if ("Bahasa Indonesia".equals(str)) {
                locale = new Locale("id");
            }
            Locale.setDefault(locale);
            configuration.locale = locale;
            this.f2852a.f2871i.m4648a("Telkom_language", locale.getLanguage());
            this.f2852a.getBaseContext().getResources().updateConfiguration(configuration, this.f2852a.getBaseContext().getResources().getDisplayMetrics());
            this.f2852a.f2873k.dismiss();
            this.f2852a.startActivity(new Intent(this.f2852a, LoginActivity.class));
            this.f2852a.finish();
        }
    };

    class C13251 implements Runnable {
        final /* synthetic */ StartActivity f2853a;

        C13251(StartActivity startActivity) {
            this.f2853a = startActivity;
        }

        public void run() {
            StartActivity.f2865f = (System.currentTimeMillis() - 100) + 60000;
            this.f2853a.m4871g();
            C1216a.m4522b("TIAMESTAMP", "pending " + (System.currentTimeMillis() - StartActivity.f2864e));
        }
    }

    class C13272 implements C1326f {
        final /* synthetic */ StartActivity f2854a;

        C13272(StartActivity startActivity) {
            this.f2854a = startActivity;
        }

        public void mo1485a() {
            if (this.f2854a.f2868c != null) {
                this.f2854a.f2868c.dismiss();
            }
            this.f2854a.m4881m();
            Intent intent = new Intent(this.f2854a, StartActivity.class);
            intent.setFlags(335577088);
            this.f2854a.startActivity(intent);
            this.f2854a.finish();
        }

        public void mo1486b() {
        }
    }

    class C13283 implements C1261k {
        final /* synthetic */ StartActivity f2855a;

        C13283(StartActivity startActivity) {
            this.f2855a = startActivity;
        }

        public void mo1471a() {
            C1216a.m4522b("START", "START SE Connexted");
            this.f2855a.f2871i.m4648a("is_nfc_yn", "Y");
            this.f2855a.m4880l();
        }

        public void mo1472b() {
            this.f2855a.m4861a((int) R.string.error_se_connection);
        }
    }

    class C13294 implements C1245f {
        final /* synthetic */ StartActivity f2856a;

        C13294(StartActivity startActivity) {
            this.f2856a = startActivity;
        }

        public void mo1487a() {
            this.f2856a.f2868c = this.f2856a.m4882a(this.f2856a.f2876n, (int) R.string.no_network, false);
        }

        public void mo1488a(String str) {
            C1216a.m4519a("onStartNetwork", str);
        }

        public void mo1489a(String str, int i, String str2, String str3, Object obj) {
            C1216a.m4519a("onFailNetwork", str);
            this.f2856a.f2871i.m4647a("time for update", System.currentTimeMillis());
            this.f2856a.f2868c = this.f2856a.m4884a(this.f2856a.f2876n, "" + str3, false);
        }

        public void mo1490a(String str, Object obj) {
            C1216a.m4519a(StartActivity.f2866g, "onSuccessNetwork");
            this.f2856a.f2871i.m4647a("time for update", System.currentTimeMillis());
            CheckWalletUpdateRs checkWalletUpdateRs = (CheckWalletUpdateRs) obj;
            this.f2856a.f2871i.m4648a("timestamp", checkWalletUpdateRs.getTimestamp());
            if ("Y".equals(checkWalletUpdateRs.getUpdateYn())) {
                this.f2856a.f2872j = checkWalletUpdateRs.getAppDownloadUrl();
                if ("N".equals(checkWalletUpdateRs.getUpdateOptionYn())) {
                    this.f2856a.f2868c = C1514b.m5648a((int) R.string.title_update, (int) R.string.mandatory_version_upgrade);
                    this.f2856a.f2868c.m5651a(this.f2856a.f2878p);
                    this.f2856a.f2868c.show(this.f2856a.getSupportFragmentManager(), "notice_dialog_tag");
                    return;
                }
                this.f2856a.f2869d = C1517c.m5655a(R.string.title_update, R.string.optional_version_upgrade);
                this.f2856a.f2869d.m5656a(this.f2856a.f2879q);
                this.f2856a.f2869d.m5658c(R.string.btn_skip);
                this.f2856a.f2869d.m5657b(R.string.btn_update);
                this.f2856a.f2869d.show(this.f2856a.getSupportFragmentManager(), "notice_dialog_tag");
                return;
            }
            this.f2856a.m4879k();
        }

        public void mo1491b() {
            this.f2856a.f2868c = this.f2856a.m4882a(this.f2856a.f2876n, (int) R.string.no_response, false);
        }

        public void mo1492c() {
            this.f2856a.m4891d();
        }
    }

    class C13305 implements C1326f {
        final /* synthetic */ StartActivity f2857a;

        C13305(StartActivity startActivity) {
            this.f2857a = startActivity;
        }

        public void mo1485a() {
            if (this.f2857a.f2868c != null) {
                this.f2857a.f2868c.dismiss();
            }
            this.f2857a.finish();
        }

        public void mo1486b() {
        }
    }

    class C13326 implements C1326f {
        final /* synthetic */ StartActivity f2859a;

        class C13311 implements Runnable {
            final /* synthetic */ C13326 f2858a;

            C13311(C13326 c13326) {
                this.f2858a = c13326;
            }

            public void run() {
                StartActivity.f2865f = (System.currentTimeMillis() - 100) + 60000;
                this.f2858a.f2859a.m4871g();
                C1216a.m4522b("TIAMESTAMP", "pending " + (System.currentTimeMillis() - StartActivity.f2864e));
            }
        }

        C13326(StartActivity startActivity) {
            this.f2859a = startActivity;
        }

        public void mo1485a() {
            if (this.f2859a.f2868c != null) {
                this.f2859a.f2868c.dismiss();
            }
            new Handler().postDelayed(new C13311(this), 100);
        }

        public void mo1486b() {
        }
    }

    class C13337 implements C1326f {
        final /* synthetic */ StartActivity f2860a;

        C13337(StartActivity startActivity) {
            this.f2860a = startActivity;
        }

        public void mo1485a() {
            if (this.f2860a.f2868c != null) {
                this.f2860a.f2868c.dismiss();
            }
            if (this.f2860a.f2872j != null && this.f2860a.f2872j.length() >= 10) {
                this.f2860a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f2860a.f2872j)));
                this.f2860a.finish();
            }
        }

        public void mo1486b() {
        }
    }

    class C13348 implements C1326f {
        final /* synthetic */ StartActivity f2861a;

        C13348(StartActivity startActivity) {
            this.f2861a = startActivity;
        }

        public void mo1485a() {
            if (this.f2861a.f2869d != null) {
                this.f2861a.f2869d.dismiss();
            }
            this.f2861a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f2861a.f2872j)));
            this.f2861a.finish();
        }

        public void mo1486b() {
            if (this.f2861a.f2869d != null) {
                this.f2861a.f2869d.dismiss();
            }
            this.f2861a.m4879k();
        }
    }

    class C13359 implements C1326f {
        final /* synthetic */ StartActivity f2862a;

        C13359(StartActivity startActivity) {
            this.f2862a = startActivity;
        }

        public void mo1485a() {
            if (this.f2862a.f2868c != null) {
                this.f2862a.f2868c.dismiss();
            }
            this.f2862a.startActivity(new Intent(this.f2862a, RevalidationActivity.class));
            this.f2862a.finish();
        }

        public void mo1486b() {
        }
    }

    private void m4861a(int i) {
        this.f2868c = m4882a(this.f2876n, i, false);
        this.f2870h.m4701b(getString(i));
    }

    private void m4870f() {
        try {
            this.f2871i.m4648a(C1358h.f2945p, getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void m4871g() {
        C1216a.m4522b("check", "checkDeviceVal ");
        C1216a.m4519a(f2866g, "isRooted =" + String.valueOf(C1351e.m4935a(this)));
        if (C1351e.m4935a(this)) {
            m4861a((int) R.string.error_rooting);
            return;
        }
        m4874h();
        C1216a.m4522b("nfccheck ", "nfc check " + this.f2871i.m4651b("is_nfc_yn", "N"));
        m4876i();
    }

    private void m4874h() {
        Object obj;
        if (this.f2867b.m4898i() == null) {
            this.f2871i.m4648a("is_nfc_yn", "N");
            obj = null;
        } else {
            this.f2871i.m4648a("is_nfc_yn", "Y");
            obj = 1;
        }
        if (obj != null) {
            C1216a.m4519a(f2866g, "nfc uid = " + this.f2871i.m4651b("nfc_uid", ""));
        }
    }

    private void m4876i() {
        C1216a.m4522b("check", "checkUICCValidation " + (System.currentTimeMillis() - f2864e));
        this.f2871i.m4648a("is_offline", "N");
        if (!f2863a.booleanValue()) {
            m4880l();
        } else if (m4878j()) {
            m4861a((int) R.string.error_uicc);
        } else {
            try {
                this.f2870h.m4678a(this.f2875m);
            } catch (Exception e) {
                m4861a((int) R.string.error_se_connection);
            }
        }
    }

    private boolean m4878j() {
        return ((TelephonyManager) getSystemService("phone")).getSimState() == 1;
    }

    private void m4879k() {
        C1216a.m4522b("check", "goToLogin " + (System.currentTimeMillis() - f2864e));
        String b = this.f2871i.m4651b("Telkom_language", "");
        if (b == null || "".equals(b)) {
            List arrayList = new ArrayList();
            arrayList.add("Bahasa Indonesia");
            arrayList.add("English");
            this.f2873k = C1527g.m5667a((int) R.string.language_select);
            this.f2873k.m5671a(arrayList);
            this.f2873k.m5670a(this.f2881s);
            this.f2873k.show(getSupportFragmentManager(), "list_dialog_tag");
            return;
        }
        Configuration configuration = new Configuration();
        Locale locale = new Locale(b);
        Locale.setDefault(locale);
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        if ("".equals(this.f2871i.m4651b("login_token", ""))) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }
        this.f2870h.m4686a("ID", this.f2874l.m4748b(), (C1245f) this);
    }

    private void m4880l() {
        String str;
        NameNotFoundException e;
        C1216a.m4522b("check", "checkUpdate ");
        String str2 = "1.0.0";
        try {
            str = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            try {
                this.f2871i.m4648a("user_info_walletversion", str);
            } catch (NameNotFoundException e2) {
                e = e2;
                e.printStackTrace();
                this.f2870h.m4686a(getString(R.string.wallet_id), str, new C13294(this));
            }
        } catch (NameNotFoundException e3) {
            NameNotFoundException nameNotFoundException = e3;
            str = str2;
            e = nameNotFoundException;
            e.printStackTrace();
            this.f2870h.m4686a(getString(R.string.wallet_id), str, new C13294(this));
        }
        this.f2870h.m4686a(getString(R.string.wallet_id), str, new C13294(this));
    }

    private void m4881m() {
        this.f2867b.m4739a().m4725g(this);
    }

    public C1514b m4882a(C1326f c1326f, int i, boolean z) {
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

    public C1514b m4883a(C1326f c1326f, String str) {
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

    public C1514b m4884a(C1326f c1326f, String str, boolean z) {
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
        this.f2868c = m4883a(this.f2876n, getString(R.string.no_network));
    }

    public void mo1488a(String str) {
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        if (i == 30004) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }
        this.f2868c = m4883a(this.f2876n, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        this.f2871i.m4647a("time for update", System.currentTimeMillis());
        if ("checkWalletUpdate".equals(str)) {
            CheckWalletUpdateRs checkWalletUpdateRs = (CheckWalletUpdateRs) obj;
            String str2 = null;
            if (!"".equals(this.f2871i.m4651b("login_token", "")) && !"".equals(this.f2871i.m4651b("TOKEN_KEY", ""))) {
                String b = this.f2871i.m4651b("login_token", "");
                String b2 = this.f2871i.m4651b("TOKEN_KEY", "");
                try {
                    str2 = C1349c.m4915a(this.f2871i.m4651b("TOKEN_KEY", ""), checkWalletUpdateRs.getTimestamp());
                    this.f2871i.m4648a("SESSION_KEY", C1349c.m4915a(b2, C1349c.m4922b(checkWalletUpdateRs.getTimestamp())));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.f2870h.m4693a(this.f2874l.m4750d(), this.f2874l.m4751e(), b, str2, this);
            }
        } else if ("login".equals(str)) {
            LoginRs loginRs = (LoginRs) obj;
            this.f2871i.m4648a("user_info_firstname", loginRs.getFirstName());
            this.f2871i.m4648a("user_info_lastname", loginRs.getLastName());
            this.f2871i.m4648a("TCASH_STATUS", loginRs.getTcashStatus());
            if ("Normal".equalsIgnoreCase(loginRs.getPinStatus())) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), HomeActivity.class);
                intent.setFlags(603979776);
                startActivity(intent);
                finish();
                return;
            }
            startActivity(new Intent(this, SetTcashPinActivity.class));
            finish();
        }
    }

    public void mo1491b() {
        this.f2868c = m4883a(this.f2876n, getString(R.string.no_response));
    }

    public void mo1492c() {
        m4891d();
    }

    public void m4891d() {
        this.f2868c = m4883a(new C13272(this), getString(R.string.session_timeout));
    }

    public void onBackPressed() {
        finish();
    }

    public void onCreate(Bundle bundle) {
        f2864e = System.currentTimeMillis();
        super.onCreate(bundle);
        setContentView(R.layout.activity_start);
        this.f2874l = new C1303a(this);
        C1216a.m4522b("TIAMESTAMP", "onCreate " + (System.currentTimeMillis() - f2864e));
        Locale locale = new Locale("id");
        Configuration configuration = new Configuration();
        if (Locale.getDefault() == null || "".equals(Locale.getDefault())) {
            getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        }
        C1216a.m4522b("TIAMESTAMP", "checkLocale " + (System.currentTimeMillis() - f2864e));
        this.f2867b = (TelkomApplication) getApplication();
        this.f2870h = this.f2867b.m4739a();
        this.f2871i = this.f2867b.m4745e();
        this.f2867b.m4746f().m4536a();
        m4870f();
        C1216a.m4522b("TIAMESTAMP", "drawtime " + (System.currentTimeMillis() - f2864e));
        AppsFlyerLib.getInstance().setGCMProjectNumber(this.f2867b, "716323091458");
        AppsFlyerLib.getInstance().startTracking(getApplication(), "3H7jk4zZdQCTCp3et9U47G");
        if (getIntent().getBooleanExtra("byPush", false)) {
            this.f2868c = m4883a(this.f2877o, getIntent().getStringExtra("pushMessage"));
            this.f2868c.setCancelable(false);
            return;
        }
        new Handler().postDelayed(new C13251(this), 100);
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f2866g, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        finish();
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f2866g, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f2866g, " in onResume >>>>>" + (System.currentTimeMillis() - f2864e));
    }
}
