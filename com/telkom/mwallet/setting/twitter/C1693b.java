package com.telkom.mwallet.setting.twitter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

public class C1693b {
    private Context f4268a;

    public C1693b(Context context) {
        this.f4268a = context;
    }

    public boolean m6377a() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f4268a.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo == null) {
            return false;
        }
        for (NetworkInfo state : allNetworkInfo) {
            if (state.getState() == State.CONNECTED) {
                return true;
            }
        }
        return false;
    }
}
