package com.telkom.mwallet;

import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.view.LayoutInflater;
import com.google.android.gcm.C0639b;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.C1302b;
import com.telkom.mwallet.p064a.C1350d;
import com.telkom.mwallet.service.C1610a;

public class TelkomApplication extends C1302b {
    private static final String f2882b = TelkomApplication.class.getSimpleName();
    private static C1490d f2883g;
    private static LayoutInflater f2884h;
    private NfcAdapter f2885c;
    private C1350d f2886d;
    private boolean f2887e = false;
    private boolean f2888f = false;
    private double f2889i = -1.0d;
    private double f2890j = -1.0d;
    private int f2891k = 0;

    private void m4892k() {
        startService(new Intent(this, C1610a.class));
    }

    private void m4893l() {
        C0639b.m1326a((Context) this);
        C0639b.m1331b(this);
        String e = C0639b.m1335e(this);
        System.out.println(">>>>>>>>>>>GCM>>>>>>>> " + e);
        if (e.equals("")) {
            C0639b.m1329a((Context) this, "716323091458");
            return;
        }
        m4895b(e);
    }

    public void m4894a(boolean z) {
        this.f2888f = z;
    }

    public void m4895b(String str) {
        m4745e().m4648a("gcm_registration_id", str);
    }

    public C1490d m4896g() {
        if (f2883g == null) {
            f2883g = new C1490d(this);
        }
        return f2883g;
    }

    public boolean m4897h() {
        return this.f2888f;
    }

    public NfcAdapter m4898i() {
        return this.f2885c;
    }

    public C1350d m4899j() {
        return this.f2886d;
    }

    public void onCreate() {
        super.onCreate();
        f2884h = (LayoutInflater) getSystemService("layout_inflater");
        this.f2885c = ((NfcManager) getSystemService("nfc")).getDefaultAdapter();
        this.f2886d = C1350d.m4929a();
        m4893l();
        m4892k();
    }

    public void onLowMemory() {
        super.onLowMemory();
        C1216a.m4523c(f2882b, "onLowMemory in TelkomApplication...>>>>>>  ");
        f2883g = null;
    }
}
