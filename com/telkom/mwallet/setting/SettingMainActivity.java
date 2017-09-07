package com.telkom.mwallet.setting;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.skcc.wallet.core.p057a.C1216a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.StartActivity;
import com.telkom.mwallet.dialog.C1527g;
import com.telkom.mwallet.dialog.p063a.C1324e;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.home.C1559a;
import com.telkom.mwallet.home.HomeActivity;
import com.telkom.mwallet.login.LoginActivity;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SettingMainActivity extends SlidingFrameActivity {
    private static final String f4020k = SettingMainActivity.class.getSimpleName();
    private C1326f f4021A = new C16263(this);
    private FragmentManager f4022l;
    private C1527g f4023m;
    private C1636d f4024n;
    private OnClickListener f4025o = new C16241(this);
    private C1324e f4026z = new C16252(this);

    class C16241 implements OnClickListener {
        final /* synthetic */ SettingMainActivity f4017a;

        C16241(SettingMainActivity settingMainActivity) {
            this.f4017a = settingMainActivity;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.setting_main_general_button:
                    C1633c c1633c = new C1633c();
                    c1633c.setStyle(0, R.style.tcash_menu_dialog);
                    c1633c.show(this.f4017a.f4022l, null);
                    return;
                case R.id.setting_main_tcash_button:
                    C1639e c1639e = new C1639e();
                    c1639e.setStyle(0, R.style.tcash_menu_dialog);
                    c1639e.show(this.f4017a.f4022l, null);
                    return;
                default:
                    return;
            }
        }
    }

    class C16252 implements C1324e {
        final /* synthetic */ SettingMainActivity f4018a;

        C16252(SettingMainActivity settingMainActivity) {
            this.f4018a = settingMainActivity;
        }

        public void mo1483a(int i) {
        }

        public void mo1484a(String str) {
            Configuration configuration = new Configuration();
            Locale locale = null;
            String b = this.f4018a.b.m4651b("Telkom_language", "");
            if ("English".equals(str)) {
                if (!"en".equals(b)) {
                    locale = new Locale("en");
                } else {
                    return;
                }
            } else if ("Bahasa Indonesia".equals(str)) {
                if (!"in".equals(b) && !"id".equals(b)) {
                    locale = new Locale("id");
                } else {
                    return;
                }
            }
            Locale.setDefault(locale);
            configuration.locale = locale;
            this.f4018a.b.m4648a("Telkom_language", locale.getLanguage());
            this.f4018a.getBaseContext().getResources().updateConfiguration(configuration, this.f4018a.getBaseContext().getResources().getDisplayMetrics());
            this.f4018a.f4023m.dismiss();
            Intent intent = new Intent(this.f4018a, HomeActivity.class);
            intent.setFlags(268468224);
            this.f4018a.startActivity(intent);
            this.f4018a.finish();
        }
    }

    class C16263 implements C1326f {
        final /* synthetic */ SettingMainActivity f4019a;

        C16263(SettingMainActivity settingMainActivity) {
            this.f4019a = settingMainActivity;
        }

        public void mo1485a() {
            Intent intent = new Intent(this.f4019a, StartActivity.class);
            intent.setFlags(268468224);
            this.f4019a.startActivity(intent);
            this.f4019a.finish();
        }

        public void mo1486b() {
            this.f4019a.finish();
        }
    }

    public void mo1505o() {
        List arrayList = new ArrayList();
        arrayList.add("Bahasa Indonesia");
        arrayList.add("English");
        this.f4023m = C1527g.m5667a((int) R.string.language_select);
        this.f4023m.m5671a(arrayList);
        this.f4023m.m5670a(this.f4026z);
        this.f4023m.show(getSupportFragmentManager(), "list_dialog_tag");
    }

    public void onBackPressed() {
        m5016B();
    }

    public void onCreate(Bundle bundle) {
        this.f4024n = new C1636d();
        super.m5019a(this.f4024n);
        super.onCreate(bundle);
        this.f4022l = getSupportFragmentManager();
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f4020k, " in onDestroy >>>>>");
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f4020k, " in onPause >>>>>");
    }

    public void m6170p() {
        C1559a.m5752a().m5759f();
        this.p.m4725g(this);
        this.b.m4648a("login_token", "");
        this.b.m4648a("TOKEN_KEY", "");
        this.b.m4648a("msisdn", "");
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(335577088);
        startActivity(intent);
        finish();
    }
}
