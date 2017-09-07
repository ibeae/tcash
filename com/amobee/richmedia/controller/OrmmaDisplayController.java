package com.amobee.richmedia.controller;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import com.amobee.adsdk.AdManager;
import com.amobee.adsdk.Log;
import com.amobee.richmedia.controller.OrmmaController.Dimensions;
import com.amobee.richmedia.controller.OrmmaController.Properties;
import com.amobee.richmedia.controller.OrmmaController.ResizeProperties;
import com.amobee.richmedia.controller.util.OrmmaConfigurationBroadcastReceiver;
import com.amobee.richmedia.view.AmobeeView;
import com.amobee.richmedia.view.AmobeeView.ViewState;
import org.json.JSONException;
import org.json.JSONObject;

public class OrmmaDisplayController extends OrmmaController {
    private static final String LOG_TAG = "AmobeeViewDisplayController";
    private boolean bMaxSizeSet = false;
    private OrmmaConfigurationBroadcastReceiver mBroadCastReceiver;
    private float mDensity;
    private int mLastOrientation = -1;
    private int mMaxHeight = -1;
    private int mMaxWidth = -1;
    private WindowManager mWindowManager;

    public OrmmaDisplayController(AmobeeView amobeeView, Context context) {
        super(amobeeView, context);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.mWindowManager.getDefaultDisplay().getMetrics(displayMetrics);
        this.mDensity = this.mOrmmaView.metrics.density;
        this.mLastOrientation = getOrientation();
    }

    private Dimensions getDeviceDimensions(Dimensions dimensions) {
        dimensions.width = (int) (((float) dimensions.width) * this.mDensity);
        dimensions.height = (int) (((float) dimensions.height) * this.mDensity);
        if (dimensions.height < 0) {
            dimensions.height = this.mOrmmaView.getHeight();
        }
        if (dimensions.width < 0) {
            dimensions.width = this.mOrmmaView.getWidth();
        }
        int[] iArr = new int[2];
        this.mOrmmaView.getLocationInWindow(iArr);
        if (dimensions.f435x < 0) {
            dimensions.f435x = iArr[0];
        }
        if (dimensions.f436y < 0) {
            dimensions.f436y = iArr[1] - 0;
        }
        if (dimensions.width > this.mOrmmaView.metrics.widthPixels) {
            dimensions.width = this.mOrmmaView.metrics.widthPixels;
        }
        if (dimensions.height > this.mOrmmaView.metrics.heightPixels) {
            dimensions.height = this.mOrmmaView.metrics.heightPixels;
        }
        return dimensions;
    }

    @JavascriptInterface
    public void close() {
        this.mOrmmaView.close();
    }

    public String dimensions() {
        return "{ \"top\" :" + ((int) (((float) this.mOrmmaView.getTop()) / this.mDensity)) + "," + "\"left\" :" + ((int) (((float) this.mOrmmaView.getLeft()) / this.mDensity)) + "," + "\"bottom\" :" + ((int) (((float) this.mOrmmaView.getBottom()) / this.mDensity)) + "," + "\"right\" :" + ((int) (((float) this.mOrmmaView.getRight()) / this.mDensity)) + "}";
    }

    @JavascriptInterface
    public void expand(String str, String str2, String str3, String str4) {
        if (!this.mOrmmaView.getUserGestureRequiredToOpenAds() || this.mOrmmaView.getUserTouchedTheView()) {
            Dimensions deviceDimensions;
            Properties properties;
            if (str != null) {
                try {
                    if (!(str.equals("") || str.equals("{}") || str.equals("undefined"))) {
                        deviceDimensions = getDeviceDimensions((Dimensions) OrmmaController.getFromJSON(new JSONObject(str), Dimensions.class));
                        if (str3.equals("{}")) {
                            properties = (Properties) OrmmaController.getFromJSON(new JSONObject(str3), Properties.class);
                            if (!str.equals("{}")) {
                                properties.useCustomClose = true;
                            }
                        } else {
                            properties = null;
                        }
                        this.mOrmmaView.expand(deviceDimensions, str2, properties, str4);
                        return;
                    }
                } catch (NumberFormatException e) {
                    this.mOrmmaView.raiseError("expand failed", "expand");
                    return;
                } catch (NullPointerException e2) {
                    this.mOrmmaView.raiseError("expand failed", "expand");
                    return;
                } catch (IllegalAccessException e3) {
                    this.mOrmmaView.raiseError("expand failed", "expand");
                    return;
                } catch (InstantiationException e4) {
                    this.mOrmmaView.raiseError("expand failed", "expand");
                    return;
                } catch (JSONException e5) {
                    this.mOrmmaView.raiseError("expand failed", "expand");
                    return;
                }
            }
            Dimensions dimensions = new Dimensions();
            if (this.bMaxSizeSet) {
                dimensions.height = this.mMaxHeight;
                dimensions.width = this.mMaxWidth;
                deviceDimensions = dimensions;
            } else {
                dimensions.height = this.mOrmmaView.metrics.heightPixels;
                dimensions.width = this.mOrmmaView.metrics.widthPixels;
                deviceDimensions = dimensions;
            }
            if (str3.equals("{}")) {
                properties = null;
            } else {
                properties = (Properties) OrmmaController.getFromJSON(new JSONObject(str3), Properties.class);
                if (str.equals("{}")) {
                    properties.useCustomClose = true;
                }
            }
            this.mOrmmaView.expand(deviceDimensions, str2, properties, str4);
            return;
        }
        Log.m811d(LOG_TAG, "RM Expand blocked: " + str2);
    }

    public String getMaxSize() {
        return this.bMaxSizeSet ? "{ width: " + ((int) (((float) this.mMaxWidth) / this.mDensity)) + ", " + "height: " + ((int) (((float) this.mMaxHeight) / this.mDensity)) + "}" : getScreenSize();
    }

    public int getOrientation() {
        switch (this.mWindowManager.getDefaultDisplay().getOrientation()) {
            case 0:
                return 0;
            case 1:
                return 90;
            case 2:
                return 180;
            case 3:
                return 270;
            default:
                return -1;
        }
    }

    public String getScreenSize() {
        return "{ width: " + ((int) (((float) this.mOrmmaView.metrics.widthPixels) / this.mOrmmaView.metrics.density)) + ", " + "height: " + ((int) (((float) this.mOrmmaView.metrics.heightPixels) / this.mOrmmaView.metrics.density)) + "}";
    }

    public String getSize() {
        return this.mOrmmaView.getSize();
    }

    @JavascriptInterface
    public void hide() {
        this.mOrmmaView.hide();
    }

    public boolean isVisible() {
        return this.mOrmmaView.getVisibility() == 0;
    }

    public void logHTML(String str) {
    }

    public void onMaxSizeChanged() {
        this.mOrmmaView.injectJavaScriptRichMedia("window.ormmaview.fireChangeEvent({ maxSize: " + getMaxSize() + "});");
    }

    public void onOrientationChanged(int i) {
        this.mOrmmaView.injectJavaScriptRichMedia("window.ormmaview.fireChangeEvent({ orientation: " + i + "});");
    }

    public void onOrientationMightBeChanged() {
        if (getOrientation() != this.mLastOrientation) {
            this.mLastOrientation = getOrientation();
            setNewSizeAcoordingToRotation();
            updateJsObjectsNewSizeAndOrientation(this.mLastOrientation);
            if (this.mOrmmaView.isExpanded() || (this.mOrmmaView.mViewState == ViewState.INTERSTITIAL && this.mOrmmaView.amobeeInterstitial != null)) {
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                int statusBarHeight = AdManager.getStatusBarHeight(this.mContext);
                ViewGroup viewGroup = (ViewGroup) this.mOrmmaView.getParent();
                if (this.mOrmmaView.parentView == null && !this.mOrmmaView.hasExpandedView) {
                    if (Integer.parseInt(VERSION.SDK) >= 14) {
                        layoutParams.setMargins(0, statusBarHeight, 0, 0);
                    } else {
                        viewGroup.setPadding(0, statusBarHeight, 0, 0);
                    }
                }
                this.mOrmmaView.setLayoutParams(layoutParams);
            }
        }
    }

    public void onScreenSizeChanged() {
        this.mOrmmaView.injectJavaScriptRichMedia("window.ormmaview.fireChangeEvent({ screenSize: " + getScreenSize() + "});");
    }

    @JavascriptInterface
    public void open(String str, boolean z, boolean z2, boolean z3) {
        if (this.mOrmmaView.getUserGestureRequiredToOpenAds() && !this.mOrmmaView.getUserTouchedTheView()) {
            Log.m811d(LOG_TAG, "RM open blocked: " + str);
        } else if (URLUtil.isValidUrl(str)) {
            this.mOrmmaView.open(str, z, z2, z3);
        } else {
            this.mOrmmaView.raiseError("Invalid url", "open");
        }
    }

    @JavascriptInterface
    public void openMap(String str, boolean z) {
        Log.m811d(LOG_TAG, "openMap: url: " + str);
        this.mOrmmaView.openMap(str, z);
    }

    @JavascriptInterface
    public void playAudio(String str, boolean z, boolean z2, boolean z3, boolean z4, String str2, String str3) {
        if (URLUtil.isValidUrl(str)) {
            this.mOrmmaView.playAudio(str, z, z2, z3, z4, str2, str3);
        } else {
            this.mOrmmaView.raiseError("Invalid url", "playAudio");
        }
    }

    @JavascriptInterface
    public void playVideo(String str) {
        this.mOrmmaView.playVideo(str);
    }

    @JavascriptInterface
    public void playVideo(String str, boolean z, boolean z2, boolean z3, boolean z4, int[] iArr, String str2, String str3) {
        Dimensions dimensions = null;
        if (iArr[0] != -1) {
            Dimensions dimensions2 = new Dimensions();
            dimensions2.f435x = iArr[0];
            dimensions2.f436y = iArr[1];
            dimensions2.width = iArr[2];
            dimensions2.height = iArr[3];
            dimensions = getDeviceDimensions(dimensions2);
        }
        if (URLUtil.isValidUrl(str)) {
            this.mOrmmaView.playVideo(str, z, z2, z3, z4, dimensions, str2, str3);
        } else {
            this.mOrmmaView.raiseError("Invalid url", "playVideo");
        }
    }

    @JavascriptInterface
    public void resize(String str) {
        if (!this.mOrmmaView.getUserGestureRequiredToOpenAds() || this.mOrmmaView.getUserTouchedTheView()) {
            try {
                ResizeProperties resizeProperties = (ResizeProperties) OrmmaController.getFromJSON(new JSONObject(str), ResizeProperties.class);
                this.mOrmmaView.resize((int) (this.mDensity * ((float) resizeProperties.width)), (int) (this.mDensity * ((float) resizeProperties.height)), resizeProperties.customClosePosition, resizeProperties.offsetX, resizeProperties.offsetY, resizeProperties.allowOffscreen);
                return;
            } catch (NumberFormatException e) {
                this.mOrmmaView.raiseError("resize failed", "resize");
                return;
            } catch (NullPointerException e2) {
                this.mOrmmaView.raiseError("resize failed", "resize");
                return;
            } catch (IllegalAccessException e3) {
                this.mOrmmaView.raiseError("resize failed", "resize");
                return;
            } catch (InstantiationException e4) {
                this.mOrmmaView.raiseError("resize failed", "resize");
                return;
            } catch (JSONException e5) {
                this.mOrmmaView.raiseError("resize failed", "resize");
                return;
            }
        }
        Log.m811d(LOG_TAG, "RM resize blocked: " + str);
    }

    public void setMaxSize(int i, int i2) {
        this.bMaxSizeSet = true;
        this.mMaxWidth = i;
        this.mMaxHeight = i2;
    }

    public void setNewSizeAcoordingToRotation() {
        ((WindowManager) this.mOrmmaView.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(this.mOrmmaView.metrics);
        this.mOrmmaView.getDefaultPosition();
    }

    @JavascriptInterface
    public void setOrientationProperties(String str) {
        this.mOrmmaView.setOrientationProperties(str);
    }

    @JavascriptInterface
    public void show() {
        this.mOrmmaView.show();
    }

    public void startConfigurationListener() {
        try {
            if (this.mBroadCastReceiver == null) {
                this.mBroadCastReceiver = new OrmmaConfigurationBroadcastReceiver(this);
            }
            this.mContext.registerReceiver(this.mBroadCastReceiver, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
        } catch (Exception e) {
        }
    }

    public void stopAllListeners() {
        stopConfigurationListener();
        this.mBroadCastReceiver = null;
    }

    public void stopConfigurationListener() {
        try {
            this.mContext.unregisterReceiver(this.mBroadCastReceiver);
        } catch (Exception e) {
        }
    }

    @JavascriptInterface
    public void storePicture(String str) {
        this.mOrmmaView.storePicture(str);
    }

    public void updateJsObjectsNewSizeAndOrientation(int i) {
        onMaxSizeChanged();
        onScreenSizeChanged();
        onOrientationChanged(i);
    }

    @JavascriptInterface
    public void useCustomClose(boolean z) {
        this.mOrmmaView.useCustomClose(z);
    }
}
