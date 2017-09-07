package com.telkom.mwallet.tcash.tap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.skcc.wallet.framework.api.C1273s;
import com.skcc.wallet.framework.api.C1298u;
import com.telkom.mwallet.R;
import com.telkom.mwallet.home.C1385b;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import com.telkom.mwallet.tcash.tap.p071a.C1975a.C1974a;
import com.telkom.mwallet.tcash.tap.p072b.C1987b;
import com.telkom.mwallet.tcash.tap.p072b.C1988a;
import com.telkom.mwallet.tcash.tap.p072b.C1994c;

public class ActivationActivity extends SlidingFrameActivity implements C1971a {
    private static final String f5746k = ActivationActivity.class.getSimpleName();
    private C1298u f5747l;
    private FragmentManager f5748m;

    public static class C1970a extends C1385b {
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            return layoutInflater.inflate(R.layout.activity_tcash_tap_activation, viewGroup, false);
        }
    }

    private C1987b m7880a(Intent intent) {
        if (intent == null) {
            return null;
        }
        C1987b c1988a;
        switch (intent.getIntExtra("extra_activation", 0)) {
            case 1:
                c1988a = new C1988a();
                c1988a.m7920a(C1974a.STICKER);
                return c1988a;
            case 2:
                c1988a = new C1988a();
                c1988a.m7920a(C1974a.NFC);
                return c1988a;
            case 3:
                c1988a = new C1994c();
                c1988a.m7920a(C1974a.STICKER);
                return c1988a;
            case 4:
                c1988a = new C1994c();
                c1988a.m7920a(C1974a.NFC);
                return c1988a;
            default:
                return null;
        }
    }

    public void mo1574a(C1974a c1974a, String str, String str2, C1273s c1273s) {
        if ((C1974a.STICKER == c1974a ? 1 : null) != null) {
            this.f5747l.m4685a(str, c1273s);
        } else {
            this.f5747l.m4711c(str, str2, c1273s);
        }
    }

    public void mo1575b(C1974a c1974a, String str, String str2, C1273s c1273s) {
        if ((C1974a.STICKER == c1974a ? 1 : null) != null) {
            this.f5747l.m4688a(str, str2, c1273s);
        } else {
            this.f5747l.m4704b(str, str2, c1273s);
        }
    }

    public void onCreate(Bundle bundle) {
        super.m5019a(new C1970a());
        super.onCreate(bundle);
        this.f5747l = this.a.m4739a();
        this.f5748m = getSupportFragmentManager();
        Fragment a = m7880a(getIntent());
        if (a != null) {
            FragmentTransaction beginTransaction = this.f5748m.beginTransaction();
            beginTransaction.replace(R.id.tcash_tap_activation_container, a);
            beginTransaction.commit();
            return;
        }
        Log.e(f5746k, "intent is null or extra_activation value is wrong.");
        finish();
    }
}
