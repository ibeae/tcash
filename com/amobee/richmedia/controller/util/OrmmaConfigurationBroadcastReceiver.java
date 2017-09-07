package com.amobee.richmedia.controller.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.amobee.richmedia.controller.OrmmaDisplayController;

public class OrmmaConfigurationBroadcastReceiver extends BroadcastReceiver {
    private int mLastOrientation = this.mOrmmaDisplayController.getOrientation();
    private OrmmaDisplayController mOrmmaDisplayController;

    public OrmmaConfigurationBroadcastReceiver(OrmmaDisplayController ormmaDisplayController) {
        this.mOrmmaDisplayController = ormmaDisplayController;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.CONFIGURATION_CHANGED")) {
            this.mOrmmaDisplayController.onOrientationMightBeChanged();
        }
    }
}
