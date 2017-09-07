package com.amobee.adsdk;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.jirbo.adcolony.AdColony;
import com.jirbo.adcolony.AdColonyV4VCListener;
import com.jirbo.adcolony.AdColonyVideoAd;
import com.jirbo.adcolony.AdColonyVideoListener;
import com.tapjoy.TapjoyConnect;
import com.tapjoy.TapjoyFullScreenAdNotifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

public final class AmobeeFullScreen {
    static final int ADCOLONY = 1;
    static final int FULL_SCREEN_ADS = 0;
    static final int OFFER_WALL = 2;
    static final int TAPJOY = 0;
    static final int VIDEO_AD = 1;
    protected ArrayList<Object> m3rdPartyAdapters = new ArrayList();
    private String mAdSpace;
    protected AmobeeFullScreenListener mAmobeeListener = new C03011();
    private Activity mContext;
    private Timer myTimer;
    int networkName = -1;
    int networkNameType = -1;
    String secondParameter = "";

    class C03011 implements AmobeeFullScreenListener {
        C03011() {
        }

        public void amobeeFullScreenFailed(AmobeeFullScreen amobeeFullScreen) {
        }

        public void amobeeFullScreenReady(AmobeeFullScreen amobeeFullScreen) {
        }
    }

    class C03022 implements AmobeeFullScreenListener {
        C03022() {
        }

        public void amobeeFullScreenFailed(AmobeeFullScreen amobeeFullScreen) {
        }

        public void amobeeFullScreenReady(AmobeeFullScreen amobeeFullScreen) {
        }
    }

    class C03043 implements Runnable {
        C03043() {
        }

        public void run() {
            try {
                final HashMap requestAmobeeFullScreen = NetworkHelper.requestAmobeeFullScreen(AmobeeFullScreen.this.mAdSpace, AdManager.getOrientation(AmobeeFullScreen.this.mContext), AdManager.getScreenSize(AmobeeFullScreen.this.mContext));
                if (requestAmobeeFullScreen != null) {
                    AmobeeFullScreen.this.mContext.runOnUiThread(new Runnable() {
                        public void run() {
                            AmobeeFullScreen.this.parse(requestAmobeeFullScreen);
                        }
                    });
                } else {
                    AmobeeFullScreen.this.mAmobeeListener.amobeeFullScreenFailed(AmobeeFullScreen.this);
                }
            } catch (Exception e) {
                AmobeeFullScreen.this.mAmobeeListener.amobeeFullScreenFailed(AmobeeFullScreen.this);
            }
        }
    }

    class C03054 extends TimerTask {
        C03054() {
        }

        public void run() {
            AmobeeFullScreen.this.TimerMethod();
        }
    }

    class C03065 extends TimerTask {
        C03065() {
        }

        public void run() {
            AmobeeFullScreen.this.TimerMethod();
        }
    }

    class C03076 implements Runnable {
        C03076() {
        }

        public void run() {
            AmobeeFullScreen.this.mAmobeeListener.amobeeFullScreenReady(AmobeeFullScreen.this);
        }
    }

    private static class AdcolonyWrapper {

        class C03081 implements AdColonyVideoListener {
            private final /* synthetic */ AdColonyVideoListener val$devListener;

            C03081(AdColonyVideoListener adColonyVideoListener) {
                this.val$devListener = adColonyVideoListener;
            }

            public void onAdColonyVideoFinished() {
                if (this.val$devListener != null) {
                    this.val$devListener.onAdColonyVideoFinished();
                } else {
                    Log.m811d(AdManager.TAG, "could not find AdColonyVideoListener");
                }
            }

            public void onAdColonyVideoStarted() {
                if (this.val$devListener != null) {
                    this.val$devListener.onAdColonyVideoStarted();
                } else {
                    Log.m811d(AdManager.TAG, "could not find AdColonyVideoListener");
                }
            }
        }

        class C03092 implements AdColonyV4VCListener {
            private final /* synthetic */ AdColonyV4VCListener val$devListener;

            C03092(AdColonyV4VCListener adColonyV4VCListener) {
                this.val$devListener = adColonyV4VCListener;
            }

            public void onV4VCResult(boolean z, String str, int i) {
                try {
                    this.val$devListener.onV4VCResult(z, str, i);
                } catch (Exception e) {
                    Log.m811d(AdManager.TAG, "could not find AdColonyV4VCListener");
                }
            }
        }

        private AdcolonyWrapper() {
        }

        static void addV4VCListener(ArrayList<Object> arrayList) {
            AdColonyV4VCListener adColonyV4VCListener = null;
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i) instanceof AdColonyV4VCListener) {
                    adColonyV4VCListener = (AdColonyV4VCListener) arrayList.get(i);
                }
            }
            AdColony.addV4VCListener(new C03092(adColonyV4VCListener));
        }

        static void configure(Activity activity, String str, String str2, String str3) {
            AdColony.configure(activity, str3, new String[]{str, str2});
        }

        static Object findAdColonyVideoListener(ArrayList<Object> arrayList) {
            Object obj = null;
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i) instanceof AdColonyVideoListener) {
                    obj = (AdColonyVideoListener) arrayList.get(i);
                }
            }
            return obj;
        }

        public static void show(ArrayList<Object> arrayList, String str) {
            AdColonyVideoListener adColonyVideoListener;
            try {
                adColonyVideoListener = (AdColonyVideoListener) findAdColonyVideoListener(arrayList);
            } catch (Exception e) {
                adColonyVideoListener = null;
            }
            new AdColonyVideoAd(str).show(new C03081(adColonyVideoListener));
        }

        static void showV4VC(ArrayList<Object> arrayList) {
            AdColonyVideoListener adColonyVideoListener;
            try {
                adColonyVideoListener = (AdColonyVideoListener) findAdColonyVideoListener(arrayList);
            } catch (Exception e) {
                adColonyVideoListener = null;
            }
            new AdColonyVideoAd().offerV4VC(adColonyVideoListener, true);
        }
    }

    private static class TapjoyWrapper {

        class C03101 implements TapjoyFullScreenAdNotifier {
            private final /* synthetic */ AmobeeFullScreen val$amobeeFullScreen;
            private final /* synthetic */ AmobeeFullScreenListener val$amobeeFullScreenListener;

            C03101(AmobeeFullScreenListener amobeeFullScreenListener, AmobeeFullScreen amobeeFullScreen) {
                this.val$amobeeFullScreenListener = amobeeFullScreenListener;
                this.val$amobeeFullScreen = amobeeFullScreen;
            }

            public void getFullScreenAdResponse() {
                this.val$amobeeFullScreenListener.amobeeFullScreenReady(this.val$amobeeFullScreen);
            }

            public void getFullScreenAdResponseFailed(int i) {
                this.val$amobeeFullScreenListener.amobeeFullScreenFailed(this.val$amobeeFullScreen);
            }
        }

        private TapjoyWrapper() {
        }

        static void getTapjoyFullScreenAd(AmobeeFullScreen amobeeFullScreen, AmobeeFullScreenListener amobeeFullScreenListener) {
            TapjoyConnect.getTapjoyConnectInstance().getFullScreenAd(new C03101(amobeeFullScreenListener, amobeeFullScreen));
        }

        static void requestTapjoyConnect(Context context, String str, String str2) {
            TapjoyConnect.requestTapjoyConnect(context, str, str2);
        }

        static void tapjoyShowOffers() {
            TapjoyConnect.getTapjoyConnectInstance().showOffers();
        }

        static void tapjoyshowFullScreenAd() {
            TapjoyConnect.getTapjoyConnectInstance().showFullScreenAd();
        }
    }

    public AmobeeFullScreen(Activity activity) {
        this.mContext = activity;
        AdManager.includeNetworksFullScreen();
        if (this.mContext == null) {
            Log.m811d(AdManager.TAG, "The context is null, please initialize it.");
        }
    }

    private void TimerMethod() {
        this.mContext.runOnUiThread(new C03076());
    }

    private synchronized boolean create3rdPartyFullScreen(String str, String str2, String str3, String str4, String str5) {
        boolean z = false;
        synchronized (this) {
            AdManager.getInstance();
            if (str.equals("Tapjoy") || str2.equals("Tapjoy")) {
                this.networkName = 0;
                if (!(str4 == null || str4.equals(""))) {
                    try {
                        JSONObject jSONObject = new JSONObject(str4);
                        int i = jSONObject.getInt("FullScreenAdType");
                        if (i == 2 || i == 0) {
                            TapjoyWrapper.requestTapjoyConnect(this.mContext, str3, jSONObject.getString("secretKey"));
                            if (jSONObject.getInt("FullScreenAdType") == 0) {
                                TapjoyWrapper.getTapjoyFullScreenAd(this, this.mAmobeeListener);
                                this.networkNameType = 0;
                                z = true;
                            } else if (jSONObject.getInt("FullScreenAdType") == 2) {
                                this.networkNameType = 2;
                                this.mAmobeeListener.amobeeFullScreenReady(this);
                                z = true;
                            }
                        } else {
                            Log.m811d(AdManager.TAG, " Tapjoy has FullScreenAds and OfferWall please check the adSpace");
                        }
                    } catch (JSONException e) {
                        Log.m811d(AdManager.TAG, " Tapjoy json.JSONException");
                    }
                }
            }
            if (str.equals("AdColony") || str2.equals("AdColony")) {
                this.networkName = 1;
                if (!(str4 == null || str4.equals(""))) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str4);
                        int i2 = jSONObject2.getInt("FullScreenAdType");
                        if (i2 == 1 || i2 == 0) {
                            this.secondParameter = jSONObject2.getString("zoneId");
                            String str6 = "";
                            try {
                                str6 = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionName;
                            } catch (NameNotFoundException e2) {
                            }
                            AdcolonyWrapper.configure(this.mContext, str3, this.secondParameter, str6);
                            if (jSONObject2.getInt("FullScreenAdType") == 1) {
                                this.networkNameType = 1;
                                AdcolonyWrapper.addV4VCListener(this.m3rdPartyAdapters);
                                new Timer().schedule(new C03054(), 3000);
                                z = true;
                            } else if (jSONObject2.getInt("FullScreenAdType") == 0) {
                                this.networkNameType = 0;
                                new Timer().schedule(new C03065(), 3000);
                                z = true;
                            }
                        } else {
                            Log.m811d(AdManager.TAG, " AdColony has video ads please check the adSpace");
                        }
                    } catch (JSONException e3) {
                        Log.m811d(AdManager.TAG, " AdColony json.JSONException");
                    }
                }
            }
        }
        return z;
    }

    public void add3rdPartyListener(Object obj) {
        if (obj == null) {
            return;
        }
        if (this.m3rdPartyAdapters.contains(obj)) {
            Log.m811d(AdManager.TAG, "This 3rd Party listener has been added already.");
        } else {
            this.m3rdPartyAdapters.add(obj);
        }
    }

    public void getAmobeeFullScreen(String str) {
        AdManager instance = AdManager.getInstance();
        this.mAdSpace = str;
        if (this.mAdSpace == null || this.mAdSpace.equals("") || instance.getServerURL() == null || instance.getServerURL().equals("")) {
            Log.m811d(AdManager.TAG, "can't get AmobeeFullScreen ad, the server URL & adSpace fields are mandatory, please define them.");
        } else {
            new Thread(new C03043()).start();
        }
    }

    void parse(HashMap<String, String> hashMap) {
        String str = (String) hashMap.get(NetworkHelper.NW);
        String str2 = (String) hashMap.get(NetworkHelper.MEDIATION);
        String str3 = (String) hashMap.get(NetworkHelper.NWID);
        String str4 = (String) hashMap.get(NetworkHelper.NW_MAP_PARAMS);
        String str5 = (String) hashMap.get(NetworkHelper.CORRELATOR);
        if (!((String) hashMap.get(NetworkHelper.STATUS)).equals("6200")) {
            this.mAmobeeListener.amobeeFullScreenFailed(this);
        } else if (str3 == null || str3.equals("") || ((str == null || str.equals("")) && (str2 == null || str2.equals("")))) {
            this.mAmobeeListener.amobeeFullScreenFailed(this);
        } else if (!create3rdPartyFullScreen(str, str2, (String) hashMap.get(NetworkHelper.NWID), str4, str5)) {
            this.mAmobeeListener.amobeeFullScreenFailed(this);
        }
    }

    public void setAmobeeListener(AmobeeFullScreenListener amobeeFullScreenListener) {
        if (amobeeFullScreenListener != null) {
            this.mAmobeeListener = amobeeFullScreenListener;
        } else {
            this.mAmobeeListener = new C03022();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void show(android.app.Activity r3) {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.networkName;	 Catch:{ all -> 0x0017 }
        switch(r0) {
            case 0: goto L_0x000f;
            case 1: goto L_0x0023;
            default: goto L_0x0006;
        };	 Catch:{ all -> 0x0017 }
    L_0x0006:
        r0 = "[a•mo•bee]";
        r1 = "showing amobeeFullScreen ad failed (please call show only after amobeeFullScreenReady is being called).";
        com.amobee.adsdk.Log.m811d(r0, r1);	 Catch:{ all -> 0x0017 }
    L_0x000d:
        monitor-exit(r2);
        return;
    L_0x000f:
        r0 = r2.networkNameType;	 Catch:{ all -> 0x0017 }
        if (r0 != 0) goto L_0x001a;
    L_0x0013:
        com.amobee.adsdk.AmobeeFullScreen.TapjoyWrapper.tapjoyshowFullScreenAd();	 Catch:{ all -> 0x0017 }
        goto L_0x000d;
    L_0x0017:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    L_0x001a:
        r0 = r2.networkNameType;	 Catch:{ all -> 0x0017 }
        r1 = 2;
        if (r0 != r1) goto L_0x0023;
    L_0x001f:
        com.amobee.adsdk.AmobeeFullScreen.TapjoyWrapper.tapjoyShowOffers();	 Catch:{ all -> 0x0017 }
        goto L_0x000d;
    L_0x0023:
        r0 = r2.networkNameType;	 Catch:{ all -> 0x0017 }
        r1 = 1;
        if (r0 != r1) goto L_0x002e;
    L_0x0028:
        r0 = r2.m3rdPartyAdapters;	 Catch:{ all -> 0x0017 }
        com.amobee.adsdk.AmobeeFullScreen.AdcolonyWrapper.showV4VC(r0);	 Catch:{ all -> 0x0017 }
        goto L_0x000d;
    L_0x002e:
        r0 = r2.networkNameType;	 Catch:{ all -> 0x0017 }
        if (r0 != 0) goto L_0x0006;
    L_0x0032:
        r0 = r2.m3rdPartyAdapters;	 Catch:{ all -> 0x0017 }
        r1 = r2.secondParameter;	 Catch:{ all -> 0x0017 }
        com.amobee.adsdk.AmobeeFullScreen.AdcolonyWrapper.show(r0, r1);	 Catch:{ all -> 0x0017 }
        goto L_0x000d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amobee.adsdk.AmobeeFullScreen.show(android.app.Activity):void");
    }
}
