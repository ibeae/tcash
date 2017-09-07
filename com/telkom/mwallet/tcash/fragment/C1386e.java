package com.telkom.mwallet.tcash.fragment;

import android.content.Intent;
import com.telkom.mwallet.home.C1385b;
import com.telkom.mwallet.setting.tcash.TCashForgetPINActivity;

public class C1386e extends C1385b {
    protected void m5219p() {
        Intent intent = new Intent(getActivity(), TCashForgetPINActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
    }
}
