package com.telkom.mwallet.setting;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1527g;
import com.telkom.mwallet.dialog.p063a.C1324e;
import com.telkom.mwallet.home.C1385b;
import com.telkom.mwallet.home.HomeActivity;
import com.telkom.mwallet.tcash.tap.TCashTapActivity;
import java.util.Locale;

public class C1636d extends C1385b {
    private static final String f4066a = C1636d.class.getSimpleName();
    private FragmentManager f4067b;
    private RelativeLayout f4068c;
    private RelativeLayout f4069j;
    private RelativeLayout f4070k;
    private RelativeLayout f4071l;
    private C1527g f4072m;
    private OnClickListener f4073n = new C16341(this);
    private C1324e f4074o = new C16352(this);

    class C16341 implements OnClickListener {
        final /* synthetic */ C1636d f4064a;

        C16341(C1636d c1636d) {
            this.f4064a = c1636d;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.setting_main_general_button:
                    C1633c c1633c = new C1633c();
                    c1633c.setStyle(0, R.style.tcash_menu_dialog);
                    c1633c.show(this.f4064a.f4067b, null);
                    return;
                case R.id.setting_main_mycards_button:
                    this.f4064a.m5213f(R.string.under_construction);
                    return;
                case R.id.setting_main_tcash_button:
                    C1639e c1639e = new C1639e();
                    c1639e.setStyle(0, R.style.tcash_menu_dialog);
                    c1639e.show(this.f4064a.f4067b, null);
                    return;
                case R.id.setting_main_tcashtap_button:
                    Intent intent = new Intent(this.f4064a.e, TCashTapActivity.class);
                    intent.setFlags(536870912);
                    this.f4064a.startActivity(intent);
                    return;
                default:
                    return;
            }
        }
    }

    class C16352 implements C1324e {
        final /* synthetic */ C1636d f4065a;

        C16352(C1636d c1636d) {
            this.f4065a = c1636d;
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
            this.f4065a.g.m4648a("Telkom_language", locale.getLanguage());
            this.f4065a.e.getBaseContext().getResources().updateConfiguration(configuration, this.f4065a.e.getBaseContext().getResources().getDisplayMetrics());
            this.f4065a.f4072m.dismiss();
            Intent intent = new Intent(this.f4065a.e, HomeActivity.class);
            intent.setFlags(268468224);
            this.f4065a.startActivity(intent);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_setting_main, null);
        m5208c(R.string.title_setting);
        this.f4067b = m5215l();
        this.f4068c = (RelativeLayout) inflate.findViewById(R.id.setting_main_tcash_button);
        this.f4069j = (RelativeLayout) inflate.findViewById(R.id.setting_main_mycards_button);
        this.f4070k = (RelativeLayout) inflate.findViewById(R.id.setting_main_general_button);
        this.f4071l = (RelativeLayout) inflate.findViewById(R.id.setting_main_tcashtap_button);
        this.f4068c.setOnClickListener(this.f4073n);
        this.f4069j.setOnClickListener(this.f4073n);
        this.f4070k.setOnClickListener(this.f4073n);
        this.f4071l.setOnClickListener(this.f4073n);
        this.h = this.e.m4982d();
        this.h.m4932a(this.e, this.f4068c, 2);
        this.h.m4932a(this.e, this.f4069j, 2);
        this.h.m4932a(this.e, this.f4070k, 2);
        this.h.m4932a(this.e, this.f4071l, 2);
        return inflate;
    }
}
