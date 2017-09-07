package com.amobee.adsdk;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.actionbarsherlock.view.Menu;
import com.amobee.pulse3d.Pulse3DView;
import com.amobee.richmedia.view.AmobeeView;
import com.facebook.widget.PlacePickerFragment;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public final class AdManager {
    static final String ADCOLONY = "AdColony";
    static final String ADCOLONY_PKG = "com.jirbo.adcolony.AdColony";
    static final String ADMOB = "adMob";
    static final String ADMOB_PKG = "com.google.ads.AdView";
    static final String AMOBEE = "amobee";
    private static final double DEFAULT_DENSITY = 1.5d;
    private static final int DEFAULT_REFRESH_TIME = 30;
    static final String GMS_ADS_PKG = "com.google.android.gms.ads.AdView";
    static final String GREYSTRIPE = "greystripe";
    static final String GREYSTRIPE_PKG = "com.greystripe.sdk.GSMobileBannerAdView";
    private static int HONEYCOMB_MR2 = 13;
    static final String IQZONE_PKG = "com.IQzone.postitial.Postitial";
    static final String MILLENNIAL = "clMmi";
    static final String MILLENNIAL_PKG = "com.millennialmedia.android.MMAdView";
    private static final int MINIMUM_REFRESH_TIME = 10;
    private static final int MINI_TABLET_WIDTH = 530;
    static final String POSTITIAL_PKG = "com.IQzone.postitial.configuration.module.AmobeePostitialAdProvider";
    static boolean SHOULD_SEND_ANDROID_ID = true;
    static boolean SHOULD_SEND_IMEI = true;
    private static final int TABLET_WIDTH = 720;
    public static final String TAG = "[a•mo•bee]";
    static final String TAPJOY = "Tapjoy";
    static final String TAPJOY_PKG = "com.tapjoy.TapjoyConnect";
    static String amobeeIncFullScreenNW;
    public static DebugLevel debugLevel = DebugLevel.NODEBUG;
    static WindowManager mWindowManager;
    private static AdManager m_instance;
    static boolean pulse3dSupport = false;
    static String pulse3dVersionString = "2";
    String amobeeIncNW;
    private IAmobeeListener amobeeListener = new C02921();
    private Context context;
    SdkMode currentMode = SdkMode.MANUAL;
    boolean isExpanded = false;
    private boolean isTimerActive = false;
    private String mPostitialAdSpace;
    private boolean mUserGestureRequiredToOpenAds = false;
    int m_lastRefreshTime = 0;
    private Parameters m_parameters;
    private int m_secondsBetweenAdcalls = 0;
    private Timer m_timer;
    private String notificationServerURL;
    private ArrayList<AmobeeAdPlaceholder> placeholders;
    private String serverURL;

    class C02921 implements IAmobeeListener {
        C02921() {
        }

        public void amobeeOnAdFailed(AmobeeAdPlaceholder amobeeAdPlaceholder) {
        }

        public void amobeeOnAdRecieved(AmobeeAdPlaceholder amobeeAdPlaceholder) {
        }

        public void amobeeOnError() {
        }

        public void amobeeOnLeavingApplication(AmobeeAdPlaceholder amobeeAdPlaceholder) {
        }

        public void amobeeOnOverlay(AmobeeAdPlaceholder amobeeAdPlaceholder) {
        }

        public void amobeeOnOverlayDismissed(AmobeeAdPlaceholder amobeeAdPlaceholder) {
        }
    }

    class C02997 implements IAmobeeListener {
        C02997() {
        }

        public void amobeeOnAdFailed(AmobeeAdPlaceholder amobeeAdPlaceholder) {
        }

        public void amobeeOnAdRecieved(AmobeeAdPlaceholder amobeeAdPlaceholder) {
        }

        public void amobeeOnError() {
        }

        public void amobeeOnLeavingApplication(AmobeeAdPlaceholder amobeeAdPlaceholder) {
        }

        public void amobeeOnOverlay(AmobeeAdPlaceholder amobeeAdPlaceholder) {
        }

        public void amobeeOnOverlayDismissed(AmobeeAdPlaceholder amobeeAdPlaceholder) {
        }
    }

    static class ClearCacheOlderThanWrapper {
        ClearCacheOlderThanWrapper() {
        }

        public static void createPulse3DAdapterFunc(Context context, int i) {
            Pulse3DView.clearCacheOlderThan(context, 30);
        }
    }

    public enum DebugLevel {
        DEBUG,
        NODEBUG
    }

    enum SdkMode {
        MANUAL,
        TIMER
    }

    private AdManager(Context context) {
        if (doesClassExist(IQZONE_PKG) && doesClassExist(POSTITIAL_PKG)) {
            Log.m811d(TAG, "Postitial class added");
        }
        this.context = context;
        includePulse3D();
        this.m_parameters = new Parameters(context);
        this.placeholders = new ArrayList();
        includeNetworks();
    }

    static void clearCacheOlderThan(Context context, int i) {
        ClearCacheOlderThanWrapper.createPulse3DAdapterFunc(context, i);
    }

    static boolean doesClassExist(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static float getDensity(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }

    public static int getDensityDpi(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics != null ? displayMetrics.densityDpi : 160;
    }

    static synchronized AdManager getInstance() {
        AdManager adManager;
        synchronized (AdManager.class) {
            adManager = m_instance;
        }
        return adManager;
    }

    public static synchronized AdManager getInstance(Context context) {
        AdManager adManager;
        synchronized (AdManager.class) {
            if (m_instance == null) {
                m_instance = new AdManager(context);
            }
            if (context != null) {
                m_instance.context = context;
            }
            adManager = m_instance;
        }
        return adManager;
    }

    static int getOrientation(Context context) {
        if (context != null) {
            mWindowManager = (WindowManager) context.getSystemService("window");
            switch (mWindowManager.getDefaultDisplay().getOrientation()) {
                case 0:
                    return 0;
                case 1:
                    return 90;
                case 2:
                    return 180;
                case 3:
                    return 270;
            }
        }
        return -1;
    }

    static Point getScreenSize(Context context) {
        mWindowManager = (WindowManager) context.getSystemService("window");
        Display defaultDisplay = mWindowManager.getDefaultDisplay();
        Point point = new Point();
        point.x = defaultDisplay.getWidth();
        point.y = defaultDisplay.getHeight();
        return point;
    }

    public static int getStatusBarHeight(Context context) {
        if (!(context instanceof Activity)) {
            return 0;
        }
        if (((((Activity) context).getWindow().getAttributes().flags & 1024) != 0 ? 1 : null) != null) {
            return 0;
        }
        Rect rect = new Rect();
        ((Activity) context).getWindow().findViewById(16908290).getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    private void includeNetworks() {
        this.amobeeIncNW = "";
        if (doesClassExist(MILLENNIAL_PKG) && VERSION.SDK_INT >= 7) {
            this.amobeeIncNW += MILLENNIAL;
        }
        if (doesClassExist(ADMOB_PKG)) {
            this.amobeeIncNW += "," + ADMOB;
        } else if (doesClassExist(GMS_ADS_PKG)) {
            this.amobeeIncNW += "," + ADMOB;
        }
        if (doesClassExist(GREYSTRIPE_PKG)) {
            this.amobeeIncNW += "," + GREYSTRIPE;
        }
        if (doesClassExist(TAPJOY_PKG)) {
            this.amobeeIncNW += "," + TAPJOY;
        }
    }

    static void includeNetworksFullScreen() {
        amobeeIncFullScreenNW = "";
        if (doesClassExist(TAPJOY_PKG)) {
            amobeeIncFullScreenNW += "," + TAPJOY;
        }
        if (doesClassExist(ADCOLONY_PKG)) {
            amobeeIncFullScreenNW += "," + ADCOLONY;
        }
    }

    private void includePulse3D() {
        ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) this.context.getSystemService("activity")).getDeviceConfigurationInfo();
        boolean doesClassExist = doesClassExist("com.amobee.pulse3d.Pulse3DView");
        Log.m811d(TAG, "pulse3dClass: " + doesClassExist);
        boolean z = VERSION.SDK_INT >= 14 && deviceConfigurationInfo.reqGlEsVersion >= Menu.CATEGORY_SYSTEM && doesClassExist;
        pulse3dSupport = z;
        if (pulse3dSupport) {
            clearCacheOlderThan(this.context, 30);
        }
    }

    private synchronized void killTimer() {
        if (this.m_timer != null) {
            this.isTimerActive = false;
            this.m_timer.purge();
            this.m_timer.cancel();
            this.m_timer = null;
        }
    }

    private void toCallAsynchronous(boolean z, final ArrayList<AmobeeAdPlaceholder> arrayList) {
        if (this.m_timer != null) {
            this.m_timer.cancel();
        }
        this.m_timer = new Timer();
        this.isTimerActive = true;
        TimerTask c02964 = new TimerTask() {
            public void run() {
                if (arrayList.size() <= 0) {
                    Log.m811d(AdManager.TAG, "No placeholder has been defined, if you want ads, please define a placeholder");
                    return;
                }
                int i = 0;
                while (i < arrayList.size()) {
                    if (arrayList.get(i) != null) {
                        if (((AmobeeAdPlaceholder) arrayList.get(i)).getCurrentAdapter() == null || !AdManager.this.amobeeIncNW.contains(((AmobeeAdPlaceholder) arrayList.get(i)).getCurrentAdapter().networkName)) {
                            NetworkHelper.doRequest((AmobeeAdPlaceholder) arrayList.get(i));
                        } else if (((AmobeeAdPlaceholder) arrayList.get(i)).getWindowVisibility() != 8 || ((AmobeeAdPlaceholder) arrayList.get(i)).firstRequest) {
                            ((AmobeeAdPlaceholder) arrayList.get(i)).firstRequest = false;
                            Activity activity = (Activity) AdManager.this.context;
                            final ArrayList arrayList = arrayList;
                            activity.runOnUiThread(new Runnable() {
                                public void run() {
                                    ((AmobeeAdPlaceholder) arrayList.get(i)).getCurrentAdapter().getAd();
                                }
                            });
                        } else {
                            return;
                        }
                    }
                    i++;
                }
            }
        };
        if (this.m_secondsBetweenAdcalls == 0) {
            if (this.m_lastRefreshTime > 0) {
                this.m_secondsBetweenAdcalls = this.m_lastRefreshTime;
                this.m_lastRefreshTime = 0;
            } else {
                this.m_secondsBetweenAdcalls = 30;
            }
        }
        this.m_timer.schedule(c02964, (long) (z ? this.m_secondsBetweenAdcalls * PlacePickerFragment.DEFAULT_RADIUS_IN_METERS : 0), (long) (this.m_secondsBetweenAdcalls * PlacePickerFragment.DEFAULT_RADIUS_IN_METERS));
    }

    void addPlaceholder(AmobeeAdPlaceholder amobeeAdPlaceholder) {
        if (!this.placeholders.contains(amobeeAdPlaceholder)) {
            this.placeholders.add(0, amobeeAdPlaceholder);
        }
    }

    void fireOnOverlay(boolean z, final AmobeeAdPlaceholder amobeeAdPlaceholder) {
        if (z) {
            if (amobeeAdPlaceholder == null) {
                getAmobeeListener().amobeeOnOverlay(amobeeAdPlaceholder);
            } else {
                amobeeAdPlaceholder.post(new Runnable() {
                    public void run() {
                        AdManager.this.getAmobeeListener().amobeeOnOverlay(amobeeAdPlaceholder);
                    }
                });
            }
            if (isTimerActive()) {
                setRefreshIntervalExpand(0);
                Log.m811d(TAG, "in onExpand/onResize");
                return;
            }
            return;
        }
        if (amobeeAdPlaceholder == null) {
            getAmobeeListener().amobeeOnOverlayDismissed(amobeeAdPlaceholder);
        } else {
            amobeeAdPlaceholder.post(new Runnable() {
                public void run() {
                    AdManager.this.getAmobeeListener().amobeeOnOverlayDismissed(amobeeAdPlaceholder);
                }
            });
        }
        if (getLastRefreshInterval() >= 0) {
            setRefreshInterval(this.m_lastRefreshTime);
            setlastRefreshTime(0);
            Log.m811d(TAG, "in onExpandClose/onResizeClose");
        }
    }

    public void getAd() {
        getAd(false, this.placeholders);
    }

    public void getAd(final AmobeeAdPlaceholder amobeeAdPlaceholder) {
        if (amobeeAdPlaceholder != null) {
            if (amobeeAdPlaceholder.getCurrentAdapter() == null || !this.amobeeIncNW.contains(amobeeAdPlaceholder.getCurrentAdapter().networkName)) {
                new Thread(new Runnable() {
                    public void run() {
                        NetworkHelper.doRequest(amobeeAdPlaceholder);
                    }
                }).start();
            } else if (amobeeAdPlaceholder.getWindowVisibility() != 8 || amobeeAdPlaceholder.firstRequest) {
                amobeeAdPlaceholder.firstRequest = false;
                amobeeAdPlaceholder.getCurrentAdapter().getAd();
            }
        }
    }

    synchronized void getAd(boolean z, final ArrayList<AmobeeAdPlaceholder> arrayList) {
        Log.m811d(TAG, "getAd()");
        if (isTimerActive()) {
            Log.m811d(TAG, "timer is active - doing nothing on getAd()");
        } else if (!this.isExpanded) {
            if (z && this.currentMode == SdkMode.MANUAL) {
                Log.m811d(TAG, "after expand/resize close we don't refresh the ad in manual mode");
            } else if (this.currentMode == SdkMode.MANUAL) {
                if (arrayList.size() <= 0) {
                    Log.m811d(TAG, "No placeholder has been defined ,if you want ads, pls define a placeholder");
                } else {
                    int i = 0;
                    while (i < arrayList.size()) {
                        if (arrayList.get(i) == null || ((AmobeeAdPlaceholder) arrayList.get(i)).getCurrentAdapter() == null || !this.amobeeIncNW.contains(((AmobeeAdPlaceholder) arrayList.get(i)).getCurrentAdapter().networkName)) {
                            if (arrayList.get(i) != null) {
                                new Thread(new Runnable() {
                                    public void run() {
                                        NetworkHelper.doRequest((AmobeeAdPlaceholder) arrayList.get(i));
                                    }
                                }).start();
                            }
                            i++;
                        } else if (((AmobeeAdPlaceholder) arrayList.get(i)).getWindowVisibility() != 8 || ((AmobeeAdPlaceholder) arrayList.get(i)).firstRequest) {
                            ((AmobeeAdPlaceholder) arrayList.get(i)).firstRequest = false;
                            ((AmobeeAdPlaceholder) arrayList.get(i)).getCurrentAdapter().getAd();
                        }
                    }
                }
            } else if (this.currentMode == SdkMode.TIMER) {
                toCallAsynchronous(z, arrayList);
            }
        }
    }

    public IAmobeeListener getAmobeeListener() {
        return this.amobeeListener;
    }

    Context getContext() {
        return this.context;
    }

    double getDensity() {
        try {
            double d = (double) this.context.getResources().getDisplayMetrics().density;
            if (d != 0.0d) {
                return d;
            }
        } catch (Exception e) {
        }
        return DEFAULT_DENSITY;
    }

    int getLastRefreshInterval() {
        return this.m_lastRefreshTime;
    }

    String getNotificationServerURL() {
        return this.notificationServerURL;
    }

    int getOrientation() {
        return getOrientation(this.context);
    }

    ArrayList<AmobeeAdPlaceholder> getPlaceholders() {
        return this.placeholders;
    }

    public String getPostitialAdSpace() {
        return this.mPostitialAdSpace;
    }

    public int getRefreshInterval() {
        return this.m_secondsBetweenAdcalls;
    }

    Point getScreenSize() {
        return getScreenSize(this.context);
    }

    public String getServerURL() {
        return this.serverURL;
    }

    public boolean getUserGestureRequiredToOpenAds() {
        return this.mUserGestureRequiredToOpenAds;
    }

    public boolean isExpanded() {
        return this.isExpanded;
    }

    boolean isMiniTablet(Context context) {
        float density = (float) getDensity();
        density = Math.min(((float) getScreenSize().x) / density, ((float) getScreenSize().y) / density);
        return density <= 720.0f && density > 530.0f;
    }

    boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    boolean isTimerActive() {
        return this.isTimerActive;
    }

    public Parameters parameters() {
        return this.m_parameters;
    }

    void removePlaceholder(AmobeeAdPlaceholder amobeeAdPlaceholder) {
        this.placeholders.remove(amobeeAdPlaceholder);
        if (this.placeholders.size() < 1) {
            Log.m811d(TAG, "No placeholders left, killing timer, cleaning up.");
            this.isExpanded = false;
            killTimer();
            includeNetworks();
        }
    }

    public void setAmobeeListener(IAmobeeListener iAmobeeListener) {
        if (iAmobeeListener == null) {
            this.amobeeListener = new C02997();
        } else {
            this.amobeeListener = iAmobeeListener;
        }
    }

    synchronized void setIsExpanded(boolean z) {
        this.isExpanded = z;
    }

    public void setNotificationServerURL(String str) {
        this.notificationServerURL = str;
    }

    public void setPostitialAdSpace(String str) {
        this.mPostitialAdSpace = str;
    }

    public void setRefreshInterval(int i) {
        if (i >= 10) {
            Log.m811d(TAG, "refresh interval set to " + i);
        } else if (i > 0 && i < 10) {
            i = 10;
        } else if (i == 0) {
            Log.m811d(TAG, "refresh interval set to 0 - killing timer - stopping ads");
            killTimer();
            this.currentMode = SdkMode.MANUAL;
        } else {
            i = 30;
        }
        if (i > 0) {
            this.currentMode = SdkMode.TIMER;
        }
        int i2 = this.m_secondsBetweenAdcalls;
        this.m_secondsBetweenAdcalls = i;
        this.m_lastRefreshTime = i;
        if (i > 0 && i2 != i && isTimerActive()) {
            toCallAsynchronous(false, this.placeholders);
        }
    }

    void setRefreshIntervalExpand(int i) {
        if (i == 0) {
            this.m_lastRefreshTime = this.m_secondsBetweenAdcalls;
            this.m_secondsBetweenAdcalls = 0;
            killTimer();
        }
    }

    public void setServerURL(String str) {
        this.serverURL = str;
    }

    public void setUseInternalBrowser() {
        AmobeeView.useInternalBrowser = true;
    }

    public void setUserGestureRequiredToOpenAds(boolean z) {
        this.mUserGestureRequiredToOpenAds = z;
    }

    void setlastRefreshTime(int i) {
        this.m_lastRefreshTime = i;
    }
}
