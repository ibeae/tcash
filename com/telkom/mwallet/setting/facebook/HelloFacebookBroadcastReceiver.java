package com.telkom.mwallet.setting.facebook;

import android.os.Bundle;
import com.facebook.FacebookBroadcastReceiver;
import com.skcc.wallet.core.p057a.C1216a;

public class HelloFacebookBroadcastReceiver extends FacebookBroadcastReceiver {
    protected void onFailedAppCall(String str, String str2, Bundle bundle) {
        C1216a.m4519a("HelloFacebook", String.format("Photo uploaded by call " + str + " failed.", new Object[0]));
    }

    protected void onSuccessfulAppCall(String str, String str2, Bundle bundle) {
        C1216a.m4519a("HelloFacebook", String.format("Photo uploaded by call " + str + " succeeded.", new Object[0]));
    }
}
