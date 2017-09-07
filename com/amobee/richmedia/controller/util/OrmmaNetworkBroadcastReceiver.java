package com.amobee.richmedia.controller.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.amobee.richmedia.controller.OrmmaNetworkController;

public class OrmmaNetworkBroadcastReceiver extends BroadcastReceiver {
    private OrmmaNetworkController mOrmmaNetworkController;

    public OrmmaNetworkBroadcastReceiver(OrmmaNetworkController ormmaNetworkController) {
        this.mOrmmaNetworkController = ormmaNetworkController;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            this.mOrmmaNetworkController.onConnectionChanged();
        }
    }
}
