package com.amobee.richmedia.controller;

import android.content.Context;
import com.amobee.richmedia.controller.listeners.AccelListener;
import com.amobee.richmedia.view.AmobeeView;
import com.facebook.widget.PlacePickerFragment;

public class OrmmaSensorController extends OrmmaController {
    private static final String LOG_TAG = "AmobeeViewSensorController";
    final int INTERVAL = PlacePickerFragment.DEFAULT_RADIUS_IN_METERS;
    private AccelListener mAccel;
    private float mLastX = 0.0f;
    private float mLastY = 0.0f;
    private float mLastZ = 0.0f;

    public OrmmaSensorController(AmobeeView amobeeView, Context context) {
        super(amobeeView, context);
        this.mAccel = new AccelListener(context, this);
    }

    public float getHeading() {
        return this.mAccel.getHeading();
    }

    public String getTilt() {
        return "{ x : \"" + this.mLastX + "\", y : \"" + this.mLastY + "\", z : \"" + this.mLastZ + "\"}";
    }

    public void onHeadingChange(float f) {
        this.mOrmmaView.injectJavaScriptRichMedia("window.ormmaview.fireChangeEvent({ heading: " + ((int) (((double) f) * 57.29577951308232d)) + "});");
    }

    public void onShake() {
        this.mOrmmaView.injectJavaScript("Ormma.gotShake()");
    }

    public void onTilt(float f, float f2, float f3) {
        this.mLastX = f;
        this.mLastY = f2;
        this.mLastZ = f3;
        this.mOrmmaView.injectJavaScriptRichMedia("window.ormmaview.fireChangeEvent({ tilt: " + getTilt() + "})");
    }

    public void startHeadingListener() {
        this.mAccel.startTrackingHeading();
    }

    public void startShakeListener() {
        this.mAccel.startTrackingShake();
    }

    public void startTiltListener() {
        this.mAccel.startTrackingTilt();
    }

    void stop() {
    }

    public void stopAllListeners() {
        this.mAccel.stopAllListeners();
    }

    public void stopHeadingListener() {
        this.mAccel.stopTrackingHeading();
    }

    public void stopShakeListener() {
        this.mAccel.stopTrackingShake();
    }

    public void stopTiltListener() {
        this.mAccel.stopTrackingTilt();
    }
}
