package com.amobee.richmedia.controller;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.amobee.richmedia.controller.listeners.LocListener;
import com.amobee.richmedia.view.AmobeeView;
import com.facebook.widget.PlacePickerFragment;

public class OrmmaLocationController extends OrmmaController {
    private static final String LOG_TAG = "AmobeeViewLocationController";
    final int INTERVAL = PlacePickerFragment.DEFAULT_RADIUS_IN_METERS;
    private boolean allowLocationServices = false;
    private boolean hasPermission = false;
    private LocListener mGps;
    private int mLocListenerCount;
    private LocationManager mLocationManager;
    private LocListener mNetwork;

    public OrmmaLocationController(AmobeeView amobeeView, Context context) {
        super(amobeeView, context);
        try {
            this.mLocationManager = (LocationManager) context.getSystemService("location");
            if (this.mLocationManager.getProvider("gps") != null) {
                this.mGps = new LocListener(context, PlacePickerFragment.DEFAULT_RADIUS_IN_METERS, this, "gps");
            }
            if (this.mLocationManager.getProvider("network") != null) {
                this.mNetwork = new LocListener(context, PlacePickerFragment.DEFAULT_RADIUS_IN_METERS, this, "network");
            }
            this.hasPermission = true;
        } catch (SecurityException e) {
        }
    }

    private static String formatLocation(Location location) {
        return "{ lat: " + location.getLatitude() + ", lon: " + location.getLongitude() + ", acc: " + location.getAccuracy() + "}";
    }

    public void allowLocationServices(boolean z) {
        this.allowLocationServices = z;
    }

    public boolean allowLocationServices() {
        return this.allowLocationServices;
    }

    public void fail() {
        this.mOrmmaView.injectJavaScriptRichMedia("window.ormmaview.fireErrorEvent(\"Location cannot be identified\", \"OrmmaLocationController\")");
    }

    public String getLocation() {
        if (!this.hasPermission) {
            return null;
        }
        Location location = null;
        for (String lastKnownLocation : this.mLocationManager.getProviders(true)) {
            location = this.mLocationManager.getLastKnownLocation(lastKnownLocation);
            if (location != null) {
                break;
            }
        }
        return location != null ? formatLocation(location) : null;
    }

    public void startLocationListener() {
        if (this.mLocListenerCount == 0) {
            if (this.mNetwork != null) {
                this.mNetwork.start();
            }
            if (this.mGps != null) {
                this.mGps.start();
            }
        }
        this.mLocListenerCount++;
    }

    public void stopAllListeners() {
        this.mLocListenerCount = 0;
        try {
            this.mGps.stop();
        } catch (Exception e) {
        }
        try {
            this.mNetwork.stop();
        } catch (Exception e2) {
        }
    }

    public void stopLocationListener() {
        this.mLocListenerCount--;
        if (this.mLocListenerCount == 0) {
            if (this.mNetwork != null) {
                this.mNetwork.stop();
            }
            if (this.mGps != null) {
                this.mGps.stop();
            }
        }
    }

    public void success(Location location) {
        this.mOrmmaView.injectJavaScriptRichMedia("window.ormmaview.fireChangeEvent({ location: " + formatLocation(location) + "})");
    }
}
