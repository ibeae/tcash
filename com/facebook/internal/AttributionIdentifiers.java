package com.facebook.internal;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Looper;
import android.util.Log;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.ServerParameters;
import com.facebook.FacebookException;
import java.lang.reflect.Method;

public class AttributionIdentifiers {
    private static final String ANDROID_ID_COLUMN_NAME = "androidid";
    private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    private static final Uri ATTRIBUTION_ID_CONTENT_URI = Uri.parse(AppsFlyerLib.ATTRIBUTION_ID_CONTENT_URI);
    private static final int CONNECTION_RESULT_SUCCESS = 0;
    private static final long IDENTIFIER_REFRESH_INTERVAL_MILLIS = 3600000;
    private static final String LIMIT_TRACKING_COLUMN_NAME = "limit_tracking";
    private static final String TAG = AttributionIdentifiers.class.getCanonicalName();
    private static AttributionIdentifiers recentlyFetchedIdentifiers;
    private String androidAdvertiserId;
    private String attributionId;
    private long fetchTime;
    private boolean limitTracking;

    private static AttributionIdentifiers getAndroidId(Context context) {
        AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new FacebookException("getAndroidId cannot be called on the main thread.");
            }
            Method methodQuietly = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", Context.class);
            if (methodQuietly == null) {
                return attributionIdentifiers;
            }
            Object invokeMethodQuietly = Utility.invokeMethodQuietly(null, methodQuietly, context);
            if (!(invokeMethodQuietly instanceof Integer) || ((Integer) invokeMethodQuietly).intValue() != 0) {
                return attributionIdentifiers;
            }
            methodQuietly = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", Context.class);
            if (methodQuietly == null) {
                return attributionIdentifiers;
            }
            Object invokeMethodQuietly2 = Utility.invokeMethodQuietly(null, methodQuietly, context);
            if (invokeMethodQuietly2 == null) {
                return attributionIdentifiers;
            }
            methodQuietly = Utility.getMethodQuietly(invokeMethodQuietly2.getClass(), "getId", new Class[0]);
            Method methodQuietly2 = Utility.getMethodQuietly(invokeMethodQuietly2.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
            if (methodQuietly == null || methodQuietly2 == null) {
                return attributionIdentifiers;
            }
            attributionIdentifiers.androidAdvertiserId = (String) Utility.invokeMethodQuietly(invokeMethodQuietly2, methodQuietly, new Object[0]);
            attributionIdentifiers.limitTracking = ((Boolean) Utility.invokeMethodQuietly(invokeMethodQuietly2, methodQuietly2, new Object[0])).booleanValue();
            return attributionIdentifiers;
        } catch (Exception e) {
            Utility.logd(ServerParameters.ANDROID_ID, e);
        }
    }

    public static AttributionIdentifiers getAttributionIdentifiers(Context context) {
        if (recentlyFetchedIdentifiers != null && System.currentTimeMillis() - recentlyFetchedIdentifiers.fetchTime < IDENTIFIER_REFRESH_INTERVAL_MILLIS) {
            return recentlyFetchedIdentifiers;
        }
        AttributionIdentifiers androidId = getAndroidId(context);
        try {
            Cursor query = context.getContentResolver().query(ATTRIBUTION_ID_CONTENT_URI, new String[]{"aid", ANDROID_ID_COLUMN_NAME, LIMIT_TRACKING_COLUMN_NAME}, null, null, null);
            if (query == null || !query.moveToFirst()) {
                return androidId;
            }
            int columnIndex = query.getColumnIndex("aid");
            int columnIndex2 = query.getColumnIndex(ANDROID_ID_COLUMN_NAME);
            int columnIndex3 = query.getColumnIndex(LIMIT_TRACKING_COLUMN_NAME);
            androidId.attributionId = query.getString(columnIndex);
            if (columnIndex2 > 0 && columnIndex3 > 0 && androidId.getAndroidAdvertiserId() == null) {
                androidId.androidAdvertiserId = query.getString(columnIndex2);
                androidId.limitTracking = Boolean.parseBoolean(query.getString(columnIndex3));
            }
            query.close();
            androidId.fetchTime = System.currentTimeMillis();
            recentlyFetchedIdentifiers = androidId;
            return androidId;
        } catch (Exception e) {
            Log.d(TAG, "Caught unexpected exception in getAttributionId(): " + e.toString());
            return null;
        }
    }

    public String getAndroidAdvertiserId() {
        return this.androidAdvertiserId;
    }

    public String getAttributionId() {
        return this.attributionId;
    }

    public boolean isTrackingLimited() {
        return this.limitTracking;
    }
}
