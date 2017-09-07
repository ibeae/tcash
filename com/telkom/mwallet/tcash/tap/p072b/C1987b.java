package com.telkom.mwallet.tcash.tap.p072b;

import android.content.Intent;
import android.provider.Settings.Secure;
import com.appsflyer.ServerParameters;
import com.telkom.mwallet.home.C1385b;
import com.telkom.mwallet.setting.tcash.TCashForgetPINActivity;
import com.telkom.mwallet.tcash.tap.p071a.C1975a.C1974a;

public class C1987b extends C1385b {
    private C1974a f5775a;

    public void m7920a(C1974a c1974a) {
        this.f5775a = c1974a;
    }

    public C1974a m7921d() {
        return this.f5775a;
    }

    protected void m7922e() {
        Intent intent = new Intent(getActivity(), TCashForgetPINActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
    }

    protected String m7923f() {
        return Secure.getString(getActivity().getContentResolver(), ServerParameters.ANDROID_ID);
    }
}
