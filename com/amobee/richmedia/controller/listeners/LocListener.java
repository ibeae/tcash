package com.amobee.richmedia.controller.listeners;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.amobee.richmedia.controller.OrmmaLocationController;

public class LocListener implements LocationListener {
    private LocationManager mLocMan;
    OrmmaLocationController mOrmmaLocationController;
    private String mProvider;

    public LocListener(Context context, int i, OrmmaLocationController ormmaLocationController, String str) {
        this.mOrmmaLocationController = ormmaLocationController;
        this.mLocMan = (LocationManager) context.getSystemService("location");
        this.mProvider = str;
    }

    public void onLocationChanged(Location location) {
        this.mOrmmaLocationController.success(location);
    }

    public void onProviderDisabled(String str) {
        this.mOrmmaLocationController.fail();
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
        if (i == 0) {
            this.mOrmmaLocationController.fail();
        }
    }

    public void start() {
        this.mLocMan.requestLocationUpdates(this.mProvider, 0, 0.0f, this);
    }

    public void stop() {
        this.mLocMan.removeUpdates(this);
    }
}
