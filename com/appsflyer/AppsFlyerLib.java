package com.appsflyer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.provider.Settings.Secure;
import android.support.v4.app.FragmentTransaction;
import android.telephony.TelephonyManager;
import com.appsflyer.AdvertisingIdClient.AdInfo;
import com.appsflyer.AppsFlyerProperties.EmailsCryptType;
import com.appsflyer.Foreground.Listener;
import com.appsflyer.cache.CacheManager;
import com.appsflyer.cache.RequestCacheData;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.iid.InstanceID;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.HttpResponseCode;

public class AppsFlyerLib {
    static final String AF_COUNTER_PREF = "appsFlyerCount";
    static final String AF_EVENT_COUNTER_PREF = "appsFlyerInAppEventCount";
    protected static final String AF_SHARED_PREF = "appsflyer-data";
    static final String AF_TIME_PASSED_SINCE_LAST_LAUNCH = "AppsFlyerTimePassedSincePrevLaunch";
    private static final String ANDROID_ID_CACHED_PREF = "androidIdCached";
    public static final String APPS_TRACKING_URL = ("https://t.appsflyer.com/api/v" + SERVER_BUILD_NUMBER + "/androidevent?buildnumber=" + SDK_BUILD_NUMBER + "&app_id=");
    public static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    public static final String ATTRIBUTION_ID_CONTENT_URI = "content://com.facebook.katana.provider.AttributionIdProvider";
    static final String ATTRIBUTION_ID_PREF = "attributionId";
    public static final String BUILD_NUMBER = "4.6.0";
    private static final String CACHED_CHANNEL_PREF = "CACHED_CHANNEL";
    private static final String CACHED_URL_PARAMETER = "&isCachedRequest=true&timeincache=";
    private static final String CALL_SERVER_ACTION = "call server.";
    private static final String CONVERSION_DATA_CACHE_EXPIRATION = "appsflyerConversionDataCacheExpiration";
    private static final String CONVERSION_DATA_URL = "https://api.appsflyer.com/install_data/v3/";
    private static final String CONVERSION_REQUEST_RETRIES = "appsflyerConversionDataRequestRetries";
    private static final String DEEPLINK_ATTR_PREF = "deeplinkAttribution";
    private static final String ERROR_PREFIX = "ERROR: ";
    public static final String EVENTS_TRACKING_URL = ("https://events.appsflyer.com/api/v" + SERVER_BUILD_NUMBER + "/androidevent?buildnumber=" + SDK_BUILD_NUMBER + "&app_id=");
    static final String FIRST_INSTALL_PREF = "appsFlyerFirstInstall";
    private static final String GET_CONVERSION_DATA_TIME = "appsflyerGetConversionDataTiming";
    private static final List<String> IGNORABLE_KEYS = Arrays.asList(new String[]{"is_cache"});
    private static final String IMEI_CACHED_PREF = "imeiCached";
    private static final String INSTALL_STORE_PREF = "INSTALL_STORE";
    private static final String INSTALL_UPDATE_DATE_FORMAT = "yyyy-MM-dd_HHmmZ";
    private static final String IN_APP_EVENTS_API = "1";
    public static final String JENKINS_BUILD_NUMBER = "282";
    public static final String LOG_TAG = (LogMessages.LOG_TAG_PREFIX + SDK_BUILD_NUMBER);
    private static final int NUMBER_OF_CONVERSION_DATA_RETRIES = 5;
    private static final String PREPARE_DATA_ACTION = "collect data for server";
    private static final String PREV_EVENT = "prev_event";
    private static final String PREV_EVENT_NAME = "prev_event_name";
    private static final String PREV_EVENT_TIMESTAMP = "prev_event_timestamp";
    private static final String PREV_EVENT_VALUE = "prev_event_value";
    private static final String PRE_INSTALL_PREF = "preInstallName";
    public static final String PRE_INSTALL_SYSTEM_DEFAULT = "/data/local/tmp/pre_install.appsflyer";
    public static final String PRE_INSTALL_SYSTEM_DEFAULT_ETC = "/etc/pre_install.appsflyer";
    public static final String PRE_INSTALL_SYSTEM_RO_PROP = "ro.appsflyer.preinstall.path";
    private static final int PUSH_PAYLOAD_HISTORY_SIZE_DEFAULT_VALUE = 2;
    private static final long PUSH_PAYLOAD_MAX_AGING_DEFAULT_VALUE = 1800000;
    protected static final String REFERRER_PREF = "referrer";
    private static final String REGISTER_URL = ("https://register.appsflyer.com/api/v" + SERVER_BUILD_NUMBER + "/androidevent?buildnumber=" + SDK_BUILD_NUMBER + "&app_id=");
    public static final String SDK_BUILD_NUMBER = BUILD_NUMBER.substring(BUILD_NUMBER.indexOf(".") + 1);
    static final String SENT_SUCCESSFULLY_PREF = "sentSuccessfully";
    public static final String SERVER_BUILD_NUMBER = BUILD_NUMBER.substring(0, BUILD_NUMBER.indexOf("."));
    private static final String SERVER_RESPONDED_ACTION = "response from server. status=";
    private static final long SIXTY_DAYS = 5184000000L;
    private static final String STATS_URL = "https://stats.appsflyer.com/stats";
    private static final long TEST_MODE_MAX_DURATION = 30000;
    private static final String VALIDATE_URL = "https://sdk-services.appsflyer.com/validate-android-signature";
    private static final String VERSION_CODE = "versionCode";
    private static final String WARNING_PREFIX = "WARNING: ";
    private static ScheduledExecutorService cacheScheduler = null;
    private static AppsFlyerConversionListener conversionDataListener = null;
    private static AppsFlyerLib instance = new AppsFlyerLib();
    private static boolean isDuringCheckCache = false;
    private static long lastCacheCheck;
    private static long timeInApp;
    private static String userCustomAndroidId;
    private static String userCustomImei;
    private static AppsFlyerInAppPurchaseValidatorListener validatorListener = null;
    private boolean isRetargetingTestMode = false;
    Uri latestDeepLink = null;
    private Listener listener;
    private String pushPayload;
    private Map<Long, String> pushPayloadHistory;
    private long testModeStartTime;

    class C03691 implements Listener {
        C03691() {
        }

        public void onBecameBackground(Activity activity) {
            AFLogger.afLog("onBecameBackground");
            AFLogger.afLog("callStatsBackground background call");
            AppsFlyerLib.this.callStatsBackground(activity.getApplicationContext());
        }

        public void onBecameForeground(Activity activity) {
            AFLogger.afLog("onBecameForeground");
            AppsFlyerLib.timeInApp = System.currentTimeMillis();
            AppsFlyerLib.this.trackEvent(activity, null, null);
        }
    }

    private abstract class ValidateInAppPurchase implements Runnable {
        private HashMap<String, String> additionalParams;
        private String appsFlyerDevKey;
        protected WeakReference<Context> ctxReference = null;
        private String currency;
        private ScheduledExecutorService executorService;
        private String googlePublicKey;
        private String price;
        private String purchaseData;
        private String signature;

        public ValidateInAppPurchase(Context context, String str, String str2, String str3, String str4, String str5, String str6, HashMap<String, String> hashMap, ScheduledExecutorService scheduledExecutorService) {
            this.ctxReference = new WeakReference(context);
            this.appsFlyerDevKey = str;
            this.googlePublicKey = str2;
            this.purchaseData = str4;
            this.price = str5;
            this.currency = str6;
            this.additionalParams = hashMap;
            this.signature = str3;
            this.executorService = scheduledExecutorService;
        }

        public abstract String getUrl();

        public void run() {
            HttpURLConnection httpURLConnection;
            Throwable th;
            HttpURLConnection httpURLConnection2;
            Throwable th2;
            HttpURLConnection httpURLConnection3 = null;
            if (this.appsFlyerDevKey != null && this.appsFlyerDevKey.length() != 0) {
                try {
                    Context context = (Context) this.ctxReference.get();
                    if (context != null) {
                        Map hashMap = new HashMap();
                        hashMap.put("app_id", context.getPackageName());
                        hashMap.put("dev_key", this.appsFlyerDevKey);
                        hashMap.put("public-key", this.googlePublicKey);
                        hashMap.put("sig-data", this.purchaseData);
                        hashMap.put("signature", this.signature);
                        String jSONObject = new JSONObject(hashMap).toString();
                        httpURLConnection = (HttpURLConnection) new URL(getUrl()).openConnection();
                        try {
                            httpURLConnection.setRequestMethod("POST");
                            httpURLConnection.setRequestProperty("Content-Length", jSONObject.getBytes().length + "");
                            httpURLConnection.setRequestProperty("Connection", "close");
                            httpURLConnection.setRequestProperty("Content-Type", "application/json");
                            httpURLConnection.setConnectTimeout(10000);
                            httpURLConnection.setDoOutput(true);
                            OutputStreamWriter outputStreamWriter;
                            try {
                                outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream());
                                try {
                                    outputStreamWriter.write(jSONObject);
                                    if (outputStreamWriter != null) {
                                        outputStreamWriter.close();
                                    }
                                    int responseCode = httpURLConnection.getResponseCode();
                                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                                    StringBuilder stringBuilder = new StringBuilder();
                                    while (true) {
                                        jSONObject = bufferedReader.readLine();
                                        if (jSONObject == null) {
                                            break;
                                        }
                                        stringBuilder.append(jSONObject);
                                    }
                                    String stringBuilder2 = stringBuilder.toString();
                                    JSONObject jSONObject2 = new JSONObject(stringBuilder2);
                                    if (responseCode == HttpResponseCode.OK) {
                                        AFLogger.afLog("Validate response 200 ok: " + jSONObject2.toString());
                                        validateCallback(jSONObject2.getBoolean("result"), this.purchaseData, this.price, this.currency, this.additionalParams, null);
                                    } else {
                                        AFLogger.afLog("Failed Validate request");
                                        validateCallback(false, this.purchaseData, this.price, this.currency, this.additionalParams, stringBuilder2);
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (outputStreamWriter != null) {
                                        outputStreamWriter.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                outputStreamWriter = httpURLConnection3;
                                if (outputStreamWriter != null) {
                                    outputStreamWriter.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                        this.executorService.shutdown();
                    } else if (httpURLConnection3 != null) {
                        httpURLConnection3.disconnect();
                    }
                } catch (Throwable th6) {
                    th = th6;
                    httpURLConnection = httpURLConnection3;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            }
        }

        protected abstract void validateCallback(boolean z, String str, String str2, String str3, HashMap<String, String> hashMap, String str4);
    }

    private class AppsFlyerInAppPurchaseValidator extends ValidateInAppPurchase {
        public AppsFlyerInAppPurchaseValidator(Context context, String str, String str2, String str3, String str4, String str5, String str6, HashMap<String, String> hashMap, ScheduledExecutorService scheduledExecutorService) {
            super(context, str, str2, str3, str4, str5, str6, hashMap, scheduledExecutorService);
        }

        public String getUrl() {
            return AppsFlyerLib.VALIDATE_URL;
        }

        protected void validateCallback(boolean z, String str, String str2, String str3, HashMap<String, String> hashMap, String str4) {
            if (AppsFlyerLib.validatorListener != null) {
                AFLogger.afLog("Validate callback parameters: " + str + " " + str2 + " " + str3);
                if (str4 != null) {
                    AppsFlyerLib.validatorListener.onValidateInAppFailure(str4);
                    AFLogger.afLog("Validate in app purchase failed: error : " + str4);
                } else if (z) {
                    AFLogger.afLog("Validate in app purchase success");
                    AppsFlyerLib.validatorListener.onValidateInApp();
                } else {
                    AFLogger.afLog("Validate in app purchase failed");
                    AppsFlyerLib.validatorListener.onValidateInAppFailure("Failed validating");
                }
                Map hashMap2 = new HashMap();
                hashMap2.put(AFInAppEventParameterName.VALIDATED, Boolean.valueOf(z));
                hashMap2.put(AFInAppEventParameterName.PARAM_2, str);
                hashMap2.put(AFInAppEventParameterName.REVENUE, str2);
                hashMap2.put(AFInAppEventParameterName.CURRENCY, str3);
                if (hashMap != null) {
                    hashMap2.put(AFInAppEventParameterName.PARAM_1, hashMap);
                }
                AppsFlyerLib.this.trackEvent((Context) this.ctxReference.get(), AFInAppEventType.PURCHASE, hashMap2);
            }
        }
    }

    private abstract class AttributionIdFetcher implements Runnable {
        private String appsFlyerDevKey;
        protected WeakReference<Context> ctxReference = null;
        private AtomicInteger currentRequestsCounter = new AtomicInteger(0);
        private ScheduledExecutorService executorService;

        public AttributionIdFetcher(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
            this.ctxReference = new WeakReference(context);
            this.appsFlyerDevKey = str;
            this.executorService = scheduledExecutorService;
        }

        protected abstract void attributionCallback(Map<String, String> map);

        protected abstract void attributionCallbackFailure(String str, int i);

        public abstract String getUrl();

        public void run() {
            InputStreamReader inputStreamReader;
            Throwable th;
            BufferedReader bufferedReader;
            Object obj;
            Reader reader = null;
            if (this.appsFlyerDevKey != null && this.appsFlyerDevKey.length() != 0) {
                this.currentRequestsCounter.incrementAndGet();
                HttpURLConnection httpURLConnection;
                try {
                    Context context = (Context) this.ctxReference.get();
                    if (context == null) {
                        this.currentRequestsCounter.decrementAndGet();
                        if (reader != null) {
                            reader.disconnect();
                            return;
                        }
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    String access$1100 = AppsFlyerLib.this.getCachedChannel(context, AppsFlyerLib.this.getConfiguredChannel(context));
                    String str = "";
                    if (access$1100 != null) {
                        str = "-" + access$1100;
                    }
                    StringBuilder append = new StringBuilder().append(getUrl()).append(context.getPackageName()).append(str).append("?devkey=").append(this.appsFlyerDevKey).append("&device_id=").append(AppsFlyerLib.this.getAppsFlyerUID(context));
                    LogMessages.logMessageMaskKey("Calling server for attribution url: " + append.toString());
                    httpURLConnection = (HttpURLConnection) new URL(append.toString()).openConnection();
                    try {
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setConnectTimeout(10000);
                        httpURLConnection.setRequestProperty("Connection", "close");
                        httpURLConnection.connect();
                        if (httpURLConnection.getResponseCode() == HttpResponseCode.OK) {
                            AppsFlyerLib.this.saveLongToSharedPreferences(context, AppsFlyerLib.GET_CONVERSION_DATA_TIME, (System.currentTimeMillis() - currentTimeMillis) / 1000);
                            StringBuilder stringBuilder = new StringBuilder();
                            try {
                                inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                                try {
                                    BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                                    while (true) {
                                        try {
                                            String readLine = bufferedReader2.readLine();
                                            if (readLine == null) {
                                                break;
                                            }
                                            stringBuilder.append(readLine).append('\n');
                                        } catch (Throwable th2) {
                                            th = th2;
                                            bufferedReader = bufferedReader2;
                                        }
                                    }
                                    if (bufferedReader2 != null) {
                                        bufferedReader2.close();
                                    }
                                    if (inputStreamReader != null) {
                                        inputStreamReader.close();
                                    }
                                    LogMessages.logMessageMaskKey("Attribution data: " + stringBuilder.toString());
                                    if (stringBuilder.length() > 0 && context != null) {
                                        Map access$1300 = AppsFlyerLib.this.attributionStringToMap(stringBuilder.toString());
                                        access$1100 = (String) access$1300.get("iscache");
                                        if (access$1100 != null && "false".equals(access$1100)) {
                                            AppsFlyerLib.this.saveLongToSharedPreferences(context, AppsFlyerLib.CONVERSION_DATA_CACHE_EXPIRATION, System.currentTimeMillis());
                                        }
                                        String jSONObject = new JSONObject(access$1300).toString();
                                        if (jSONObject != null) {
                                            AppsFlyerLib.this.saveDataToSharedPreferences(context, AppsFlyerLib.ATTRIBUTION_ID_PREF, jSONObject);
                                        } else {
                                            AppsFlyerLib.this.saveDataToSharedPreferences(context, AppsFlyerLib.ATTRIBUTION_ID_PREF, stringBuilder.toString());
                                        }
                                        AFLogger.afDebugLog("iscache=" + access$1100 + " caching conversion data");
                                        if (AppsFlyerLib.conversionDataListener != null && this.currentRequestsCounter.intValue() <= 1) {
                                            Map access$1500;
                                            try {
                                                access$1500 = AppsFlyerLib.this.getConversionData(context);
                                            } catch (AttributionIDNotReady e) {
                                                access$1500 = access$1300;
                                            }
                                            attributionCallback(access$1500);
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    if (inputStreamReader != null) {
                                        inputStreamReader.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                Reader reader2 = reader;
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                throw th;
                            }
                        }
                        if (AppsFlyerLib.conversionDataListener != null) {
                            attributionCallbackFailure("Error connection to server: " + httpURLConnection.getResponseCode(), httpURLConnection.getResponseCode());
                        }
                        LogMessages.logMessageMaskKey("AttributionIdFetcher response code: " + httpURLConnection.getResponseCode() + "  url: " + append);
                        this.currentRequestsCounter.decrementAndGet();
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        try {
                            if (AppsFlyerLib.conversionDataListener != null) {
                                attributionCallbackFailure(th.getMessage(), 0);
                            }
                            AFLogger.afLogE(th.getMessage(), th);
                            this.currentRequestsCounter.decrementAndGet();
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            this.executorService.shutdown();
                        } catch (Throwable th6) {
                            th = th6;
                            this.currentRequestsCounter.decrementAndGet();
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    }
                    this.executorService.shutdown();
                } catch (Throwable th7) {
                    th = th7;
                    obj = reader;
                    this.currentRequestsCounter.decrementAndGet();
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            }
        }
    }

    private class CachedRequestSender implements Runnable {
        private WeakReference<Context> ctxReference = null;

        public CachedRequestSender(Context context) {
            this.ctxReference = new WeakReference(context);
        }

        public void run() {
            if (!AppsFlyerLib.isDuringCheckCache) {
                AppsFlyerLib.lastCacheCheck = System.currentTimeMillis();
                if (this.ctxReference != null) {
                    AppsFlyerLib.isDuringCheckCache = true;
                    try {
                        String property = AppsFlyerLib.this.getProperty(AppsFlyerProperties.AF_KEY);
                        synchronized (this.ctxReference) {
                            for (RequestCacheData requestCacheData : CacheManager.getInstance().getCachedRequests((Context) this.ctxReference.get())) {
                                AFLogger.afLog("resending request: " + requestCacheData.getRequestURL());
                                try {
                                    AppsFlyerLib.this.sendRequestToServer(requestCacheData.getRequestURL() + AppsFlyerLib.CACHED_URL_PARAMETER + Long.toString((System.currentTimeMillis() - Long.parseLong(requestCacheData.getCacheKey(), 10)) / 1000), requestCacheData.getPostData(), property, this.ctxReference, requestCacheData.getCacheKey(), false);
                                } catch (Exception e) {
                                    AFLogger.afLog("Failed to resend cached request");
                                }
                            }
                        }
                        AppsFlyerLib.isDuringCheckCache = false;
                    } catch (Exception e2) {
                        try {
                            AFLogger.afLog("failed to check cache.");
                        } finally {
                            AppsFlyerLib.isDuringCheckCache = false;
                        }
                    }
                    AppsFlyerLib.cacheScheduler.shutdown();
                    AppsFlyerLib.cacheScheduler = null;
                }
            }
        }
    }

    private class DataCollector implements Runnable {
        private String appsFlyerKey;
        private Context context;
        private String eventName;
        private String eventValue;
        private ExecutorService executor;
        private boolean isNewAPI;
        private String referrer;

        private DataCollector(Context context, String str, String str2, String str3, String str4, boolean z, ExecutorService executorService) {
            this.context = context;
            this.appsFlyerKey = str;
            this.eventName = str2;
            this.eventValue = str3;
            this.referrer = str4;
            this.isNewAPI = z;
            this.executor = executorService;
        }

        public void run() {
            AppsFlyerLib.this.sendTrackingWithEvent(this.context, this.appsFlyerKey, this.eventName, this.eventValue, this.referrer, this.isNewAPI);
            this.executor.shutdown();
        }
    }

    private class InstallAttributionIdFetcher extends AttributionIdFetcher {
        public InstallAttributionIdFetcher(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
            super(context, str, scheduledExecutorService);
        }

        protected void attributionCallback(Map<String, String> map) {
            AppsFlyerLib.conversionDataListener.onInstallConversionDataLoaded(map);
            ((Context) this.ctxReference.get()).getSharedPreferences(AppsFlyerLib.AF_SHARED_PREF, 0);
            AppsFlyerLib.this.saveIntegerToSharedPreferences((Context) this.ctxReference.get(), AppsFlyerLib.CONVERSION_REQUEST_RETRIES, 0);
        }

        protected void attributionCallbackFailure(String str, int i) {
            AppsFlyerLib.conversionDataListener.onInstallConversionFailure(str);
            if (i >= HttpResponseCode.BAD_REQUEST && i < HttpResponseCode.INTERNAL_SERVER_ERROR) {
                AppsFlyerLib.this.saveIntegerToSharedPreferences((Context) this.ctxReference.get(), AppsFlyerLib.CONVERSION_REQUEST_RETRIES, ((Context) this.ctxReference.get()).getSharedPreferences(AppsFlyerLib.AF_SHARED_PREF, 0).getInt(AppsFlyerLib.CONVERSION_REQUEST_RETRIES, 0) + 1);
            }
        }

        public String getUrl() {
            return AppsFlyerLib.CONVERSION_DATA_URL;
        }
    }

    private class SendToServerRunnable implements Runnable {
        private WeakReference<Context> ctxReference;
        boolean isLaunch;
        Map<String, String> params;
        private String urlString;

        private SendToServerRunnable(String str, Map<String, String> map, Context context, boolean z) {
            this.ctxReference = null;
            this.urlString = str;
            this.params = map;
            this.ctxReference = new WeakReference(context);
            this.isLaunch = z;
        }

        public void run() {
            boolean z = true;
            try {
                String referrer;
                boolean z2;
                Context context = (Context) this.ctxReference.get();
                if (context != null) {
                    referrer = AppsFlyerProperties.getInstance().getReferrer(context);
                    if (referrer != null && referrer.length() > 0 && this.params.get(AppsFlyerLib.REFERRER_PREF) == null) {
                        this.params.put(AppsFlyerLib.REFERRER_PREF, referrer);
                    }
                    boolean equals = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(context.getSharedPreferences(AppsFlyerLib.AF_SHARED_PREF, 0).getString(AppsFlyerLib.SENT_SUCCESSFULLY_PREF, ""));
                    referrer = (String) this.params.get(ServerParameters.EVENT_NAME);
                    int access$500 = AppsFlyerLib.this.getCounter(context, AppsFlyerLib.AF_COUNTER_PREF, referrer == null);
                    this.params.put("counter", Integer.toString(access$500));
                    this.params.put("iaecounter", Integer.toString(AppsFlyerLib.this.getCounter(context, AppsFlyerLib.AF_EVENT_COUNTER_PREF, referrer != null)));
                    this.params.put(ServerParameters.TIME_PASSED_SINCE_LAST_LAUNCH, Long.toString(AppsFlyerLib.this.getTimePassedSinceLastLaunch(context, true)));
                    if (this.isLaunch && access$500 == 1) {
                        AppsFlyerProperties.getInstance().setFirstLaunchCalled();
                    }
                    z2 = equals;
                } else {
                    z2 = false;
                }
                this.params.put("isFirstCall", Boolean.toString(!z2));
                String str = (String) this.params.get(ServerParameters.AF_DEV_KEY);
                if (str == null || str.length() == 0) {
                    AFLogger.afDebugLog("Not sending data yet, waiting for dev key");
                    return;
                }
                this.params.put("af_v", new HashUtils().getHashCode(this.params));
                String jSONObject = new JSONObject(this.params).toString();
                AppsFlyerLib appsFlyerLib = AppsFlyerLib.this;
                referrer = this.urlString;
                WeakReference weakReference = this.ctxReference;
                if (!this.isLaunch || AppsFlyerLib.conversionDataListener == null) {
                    z = false;
                }
                appsFlyerLib.sendRequestToServer(referrer, jSONObject, str, weakReference, null, z);
            } catch (Throwable e) {
                Throwable th = e;
                if (null != null && this.ctxReference != null && !this.urlString.contains(AppsFlyerLib.CACHED_URL_PARAMETER)) {
                    CacheManager.getInstance().cacheRequest(new RequestCacheData(this.urlString, null, AppsFlyerLib.SDK_BUILD_NUMBER), (Context) this.ctxReference.get());
                    AFLogger.afLogE(th.getMessage(), th);
                }
            } catch (Throwable e2) {
                AFLogger.afLogE(e2.getMessage(), e2);
            }
        }
    }

    private AppsFlyerLib() {
    }

    private void addAdvertiserIDData(Context context, Map<String, String> map) {
        String a;
        String bool;
        String str;
        boolean z;
        Object obj;
        String str2;
        AdInfo advertisingIdInfo;
        Object obj2;
        Throwable th;
        Object obj3;
        Throwable th2;
        int i = null;
        boolean z2 = true;
        AFLogger.afLog("Trying to fetch GAID..");
        try {
            Throwable th3;
            Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            Info b = AdvertisingIdClient.m1415b(context);
            if (b != null) {
                a = b.m1411a();
                try {
                    bool = Boolean.toString(!b.m1412b() ? z2 : false);
                    if (a != null) {
                        try {
                            if (a.length() != 0) {
                                str = bool;
                                bool = a;
                            }
                        } catch (Throwable th4) {
                            i = th4;
                            z = z2;
                            obj = a;
                            Object obj4 = bool;
                            bool = i;
                            try {
                                i = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
                            } catch (Throwable th5) {
                                bool = bool + "/" + th5.getClass().getSimpleName();
                                debugAction("GAID", "\tgot error: " + th5.getMessage(), context);
                                String string = AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM);
                                str = AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_ENABLED_PARAM);
                                if (th5.getLocalizedMessage() != null) {
                                    AFLogger.afLog(th5.getLocalizedMessage());
                                } else {
                                    AFLogger.afLog(th5.toString());
                                }
                                debugAction("Could not fetch advertiser id: ", th5.getLocalizedMessage(), context);
                                str2 = bool;
                                bool = string;
                            }
                            bool = bool.getClass().getSimpleName();
                            AFLogger.afLog("WARNING: Google Play Services is missing.");
                            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.ENABLE_GPS_FALLBACK, z2)) {
                                advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                                if (advertisingIdInfo != null) {
                                    a = advertisingIdInfo.getId();
                                    if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                                        z2 = false;
                                    }
                                    str = Boolean.toString(z2);
                                    if (a != null || a.length() == 0) {
                                        str2 = "emptyOrNull (bypass)";
                                        bool = a;
                                    } else {
                                        str2 = bool;
                                        bool = a;
                                    }
                                } else {
                                    str2 = "gpsAdInfo-null (bypass)";
                                    obj2 = th;
                                    obj3 = th2;
                                }
                            } else {
                                str2 = bool;
                                obj2 = th;
                                obj3 = th2;
                            }
                            if (str2 != null) {
                                map.put("gaidError", i + ": " + str2);
                            }
                            if (bool != null) {
                                return;
                            }
                        }
                    }
                    th3 = "emptyOrNull";
                    str = bool;
                    bool = a;
                } catch (Throwable th6) {
                    bool = th6;
                    z = false;
                    obj = a;
                    th = null;
                    i = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
                    bool = bool.getClass().getSimpleName();
                    AFLogger.afLog("WARNING: Google Play Services is missing.");
                    if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.ENABLE_GPS_FALLBACK, z2)) {
                        advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                        if (advertisingIdInfo != null) {
                            a = advertisingIdInfo.getId();
                            if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                                z2 = false;
                            }
                            str = Boolean.toString(z2);
                            if (a != null) {
                            }
                            str2 = "emptyOrNull (bypass)";
                            bool = a;
                        } else {
                            str2 = "gpsAdInfo-null (bypass)";
                            obj2 = th;
                            obj3 = th2;
                        }
                    } else {
                        str2 = bool;
                        obj2 = th;
                        obj3 = th2;
                    }
                    if (str2 != null) {
                        map.put("gaidError", i + ": " + str2);
                    }
                    if (bool != null) {
                        return;
                    }
                }
            }
            bool = null;
            str = null;
            Object obj5 = "gpsAdInfo-null";
            z2 = false;
            z = z2;
            str2 = th3;
            i = -1;
        } catch (Throwable th7) {
            bool = th7;
            z = false;
            th = null;
            th2 = null;
            i = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
            bool = bool.getClass().getSimpleName();
            AFLogger.afLog("WARNING: Google Play Services is missing.");
            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.ENABLE_GPS_FALLBACK, z2)) {
                str2 = bool;
                obj2 = th;
                obj3 = th2;
            } else {
                advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                if (advertisingIdInfo != null) {
                    str2 = "gpsAdInfo-null (bypass)";
                    obj2 = th;
                    obj3 = th2;
                } else {
                    a = advertisingIdInfo.getId();
                    if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                        z2 = false;
                    }
                    str = Boolean.toString(z2);
                    if (a != null) {
                    }
                    str2 = "emptyOrNull (bypass)";
                    bool = a;
                }
            }
            if (str2 != null) {
                map.put("gaidError", i + ": " + str2);
            }
            if (bool != null) {
            }
            return;
        }
        if (str2 != null) {
            map.put("gaidError", i + ": " + str2);
        }
        if (bool != null && str != null) {
            map.put(ServerParameters.ADVERTISING_ID_PARAM, bool);
            map.put(ServerParameters.ADVERTISING_ID_ENABLED_PARAM, str);
            AppsFlyerProperties.getInstance().set(ServerParameters.ADVERTISING_ID_PARAM, bool);
            AppsFlyerProperties.getInstance().set(ServerParameters.ADVERTISING_ID_ENABLED_PARAM, str);
            map.put(ServerParameters.ADVERTISING_ID_WITH_GPS, String.valueOf(z));
        }
    }

    private void addDeviceTracking(Context context, Map<String, String> map) {
        String str = null;
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
            map.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            return;
        }
        String str2;
        SharedPreferences sharedPreferences = context.getSharedPreferences(AF_SHARED_PREF, 0);
        boolean z = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI, true);
        String string = sharedPreferences.getString(IMEI_CACHED_PREF, null);
        if (!z) {
            if (userCustomImei != null) {
                str2 = userCustomImei;
            }
            str2 = null;
        } else if (isIdCollectionAllowed(context)) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                str2 = (String) telephonyManager.getClass().getMethod("getDeviceId", new Class[0]).invoke(telephonyManager, new Object[0]);
                if (str2 == null) {
                    if (userCustomImei != null) {
                        str2 = userCustomImei;
                    } else {
                        if (string != null) {
                            str2 = string;
                        }
                        str2 = null;
                    }
                }
            } catch (Exception e) {
                AFLogger.afLog("WARNING: READ_PHONE_STATE is missing");
                str2 = null;
            }
        } else {
            if (userCustomImei != null) {
                str2 = userCustomImei;
            }
            str2 = null;
        }
        if (str2 != null) {
            saveDataToSharedPreferences(context, IMEI_CACHED_PREF, str2);
            map.put("imei", str2);
        } else {
            AFLogger.afLog("IMEI was not collected.");
        }
        z = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID, true);
        string = sharedPreferences.getString(ANDROID_ID_CACHED_PREF, null);
        if (z) {
            if (isIdCollectionAllowed(context)) {
                try {
                    str2 = Secure.getString(context.getContentResolver(), ServerParameters.ANDROID_ID);
                    if (str2 != null) {
                        str = str2;
                    } else if (userCustomAndroidId != null) {
                        str = userCustomAndroidId;
                    } else if (string != null) {
                        str = string;
                    }
                } catch (Exception e2) {
                }
            } else if (userCustomAndroidId != null) {
                str = userCustomAndroidId;
            }
        } else if (userCustomAndroidId != null) {
            str = userCustomAndroidId;
        }
        if (str != null) {
            saveDataToSharedPreferences(context, ANDROID_ID_CACHED_PREF, str);
            map.put(ServerParameters.ANDROID_ID, str);
            return;
        }
        AFLogger.afLog("Android ID was not collected.");
    }

    private Map<String, String> attributionStringToMap(String str) {
        Map<String, String> hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                if (!IGNORABLE_KEYS.contains(str2)) {
                    hashMap.put(str2, jSONObject.getString(str2));
                }
            }
            return hashMap;
        } catch (JSONException e) {
            AFLogger.afWarnLog(e.getMessage());
            return null;
        }
    }

    private static void broadcastBacktoTestApp(Context context, HashMap<String, String> hashMap) {
        Intent intent = new Intent(MonitorMessages.TEST_INTEGRATION_ACTION);
        intent.putExtra("params", hashMap);
        context.sendBroadcast(intent);
    }

    private void callRegisterBackground(Context context) {
        Map hashMap = new HashMap();
        hashMap.put(ServerParameters.DEV_KEY, getProperty(AppsFlyerProperties.AF_KEY));
        hashMap.put(ServerParameters.AF_USER_ID, getAppsFlyerUID(context));
        hashMap.put(ServerParameters.AFGCM_TOKEN, AppsFlyerProperties.getInstance().getString("gcmToken"));
        hashMap.put(ServerParameters.ADVERTISING_ID_PARAM, AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM));
        hashMap.put(ServerParameters.GOOGLE_INSTANCE_ID, AppsFlyerProperties.getInstance().getString("gcmInstanceId"));
        hashMap.put(ServerParameters.LAUNCH_COUNTER, Integer.toString(getCounter(context, AF_COUNTER_PREF, false)));
        hashMap.put(MonitorMessages.SDK_VERSION, Integer.toString(VERSION.SDK_INT));
        hashMap.put("channel", getConfiguredChannel(context));
        try {
            long j = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
            hashMap.put("install_date", new SimpleDateFormat(INSTALL_UPDATE_DATE_FORMAT, Locale.US).format(new Date(j)));
        } catch (NameNotFoundException e) {
        } catch (NoSuchFieldError e2) {
        }
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_FINGER_PRINT, true)) {
            String uniquePsuedoID = getUniquePsuedoID();
            if (uniquePsuedoID != null) {
                hashMap.put(ServerParameters.DEVICE_FINGER_PRINT_ID, uniquePsuedoID);
            }
        }
        try {
            BackgroundHttpTask backgroundHttpTask = new BackgroundHttpTask(context);
            backgroundHttpTask.bodyParameters = hashMap;
            backgroundHttpTask.execute(new String[]{REGISTER_URL + context.getPackageName()});
        } catch (Throwable th) {
        }
    }

    private void callServer(URL url, String str, String str2, WeakReference<Context> weakReference, String str3, boolean z) {
        OutputStreamWriter outputStreamWriter;
        Throwable th;
        Context context = (Context) weakReference.get();
        HttpURLConnection httpURLConnection;
        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Content-Length", str.getBytes().length + "");
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setDoOutput(true);
                try {
                    outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream());
                    try {
                        outputStreamWriter.write(str);
                        if (outputStreamWriter != null) {
                            outputStreamWriter.close();
                        }
                        int responseCode = httpURLConnection.getResponseCode();
                        AFLogger.afLogM(LogMessages.SERVER_RESPONSE_CODE + responseCode);
                        monitor(context, LOG_TAG, MonitorMessages.SERVER_RESPONSE_CODE, Integer.toString(responseCode));
                        debugAction(SERVER_RESPONDED_ACTION, Integer.toString(responseCode), context);
                        SharedPreferences sharedPreferences = context.getSharedPreferences(AF_SHARED_PREF, 0);
                        if (responseCode == HttpResponseCode.OK) {
                            if (this.latestDeepLink != null) {
                                this.latestDeepLink = null;
                            }
                            if (str3 != null) {
                                CacheManager.getInstance().deleteRequest(str3, context);
                            }
                            if (weakReference.get() != null && str3 == null) {
                                saveDataToSharedPreferences(context, SENT_SUCCESSFULLY_PREF, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                                checkCache(context);
                            }
                        }
                        responseCode = sharedPreferences.getInt(CONVERSION_REQUEST_RETRIES, 0);
                        long j = sharedPreferences.getLong(CONVERSION_DATA_CACHE_EXPIRATION, 0);
                        if (j != 0 && System.currentTimeMillis() - j > SIXTY_DAYS) {
                            saveDataToSharedPreferences(context, ATTRIBUTION_ID_PREF, null);
                            saveLongToSharedPreferences(context, CONVERSION_DATA_CACHE_EXPIRATION, 0);
                        }
                        if (sharedPreferences.getString(ATTRIBUTION_ID_PREF, null) == null && str2 != null && z && conversionDataListener != null && responseCode <= 5) {
                            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
                            newSingleThreadScheduledExecutor.schedule(new InstallAttributionIdFetcher(context.getApplicationContext(), str2, newSingleThreadScheduledExecutor), 10, TimeUnit.MILLISECONDS);
                        } else if (str2 == null) {
                            AFLogger.afWarnLog("AppsFlyer dev key is missing.");
                        } else if (z && conversionDataListener != null && sharedPreferences.getString(ATTRIBUTION_ID_PREF, null) != null && getCounter(context, AF_COUNTER_PREF, false) > 1) {
                            try {
                                Map conversionData = getConversionData(context);
                                if (conversionData != null) {
                                    conversionDataListener.onInstallConversionDataLoaded(conversionData);
                                }
                            } catch (AttributionIDNotReady e) {
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (outputStreamWriter != null) {
                            outputStreamWriter.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    outputStreamWriter = null;
                    if (outputStreamWriter != null) {
                        outputStreamWriter.close();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    private void callStatsBackground(Context context) {
        AFLogger.afLog("app went to background");
        AppsFlyerProperties.getInstance().saveProperties(context);
        long currentTimeMillis = System.currentTimeMillis() - timeInApp;
        Map hashMap = new HashMap();
        String property = getProperty(AppsFlyerProperties.AF_KEY);
        hashMap.put("app_id", context.getPackageName());
        hashMap.put(ServerParameters.DEV_KEY, property);
        hashMap.put(ServerParameters.AF_USER_ID, getAppsFlyerUID(context));
        hashMap.put(ServerParameters.TIME_SPENT_IN_APP, String.valueOf(currentTimeMillis / 1000));
        hashMap.put(ServerParameters.STATUS_TYPE, "user_closed_app");
        hashMap.put(ServerParameters.PLATFORM, "Android");
        hashMap.put(ServerParameters.LAUNCH_COUNTER, Integer.toString(getCounter(context, AF_COUNTER_PREF, false)));
        hashMap.put(ServerParameters.CONVERSION_DATA_TIMING, Long.toString(context.getSharedPreferences(AF_SHARED_PREF, 0).getLong(GET_CONVERSION_DATA_TIME, 0)));
        hashMap.put("channel", getConfiguredChannel(context));
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_FINGER_PRINT, true)) {
            String uniquePsuedoID = getUniquePsuedoID();
            if (uniquePsuedoID != null) {
                hashMap.put(ServerParameters.DEVICE_FINGER_PRINT_ID, uniquePsuedoID);
            }
        }
        try {
            BackgroundHttpTask backgroundHttpTask = new BackgroundHttpTask(context);
            backgroundHttpTask.bodyParameters = hashMap;
            backgroundHttpTask.execute(new String[]{STATS_URL});
        } catch (Throwable th) {
        }
    }

    private void checkCache(Context context) {
        if (!isDuringCheckCache && System.currentTimeMillis() - lastCacheCheck >= 15000 && cacheScheduler == null) {
            cacheScheduler = Executors.newSingleThreadScheduledExecutor();
            cacheScheduler.schedule(new CachedRequestSender(context), 1, TimeUnit.SECONDS);
        }
    }

    private void checkPlatform(Context context, Map<String, String> map) {
        try {
            Class.forName("com.unity3d.player.UnityPlayer");
            map.put("platformextension", "android_unity");
        } catch (ClassNotFoundException e) {
            map.put("platformextension", "android_native");
        } catch (Exception e2) {
        }
    }

    private boolean checkWriteExternalPermission(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    private void debugAction(String str, String str2, Context context) {
        try {
            if (isAppsFlyerPackage(context)) {
                DebugLogQueue.getInstance().push(str + str2);
            }
        } catch (Exception e) {
            AFLogger.afLog(e.toString());
        }
    }

    @SuppressLint({"CommitPrefEdits"})
    private void editorCommit(Editor editor) {
        if (VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    private void endTestMode() {
        AFLogger.afLog("Test mode ended!");
        this.testModeStartTime = 0;
    }

    private String generateOtherSDKsString() {
        return numricBooleanIsClassExist("com.tune.Tune") + numricBooleanIsClassExist("com.adjust.sdk.Adjust") + numricBooleanIsClassExist("com.kochava.android.tracker.Feature") + numricBooleanIsClassExist("io.branch.referral.Branch") + numricBooleanIsClassExist("com.apsalar.sdk.Apsalar") + numricBooleanIsClassExist("com.localytics.android.Localytics") + numricBooleanIsClassExist("com.tenjin.android.TenjinSDK") + numricBooleanIsClassExist("com.talkingdata.sdk.TalkingDataSDK") + numricBooleanIsClassExist("it.partytrack.sdk.Track") + numricBooleanIsClassExist("jp.appAdForce.android.LtvManager");
    }

    private String getCachedChannel(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(AF_SHARED_PREF, 0);
        if (sharedPreferences.contains(CACHED_CHANNEL_PREF)) {
            return sharedPreferences.getString(CACHED_CHANNEL_PREF, null);
        }
        saveDataToSharedPreferences(context, CACHED_CHANNEL_PREF, str);
        return str;
    }

    private String getCachedStore(Context context) {
        String str = null;
        SharedPreferences sharedPreferences = context.getSharedPreferences(AF_SHARED_PREF, 0);
        if (sharedPreferences.contains(INSTALL_STORE_PREF)) {
            return sharedPreferences.getString(INSTALL_STORE_PREF, null);
        }
        if (isAppsFlyerFirstLaunch(context)) {
            str = getCurrentStore(context);
        }
        saveDataToSharedPreferences(context, INSTALL_STORE_PREF, str);
        return str;
    }

    private String getConfiguredChannel(Context context) {
        String string = AppsFlyerProperties.getInstance().getString("channel");
        return string == null ? getManifestMetaData(context, "CHANNEL") : string;
    }

    private Map<String, String> getConversionData(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(AF_SHARED_PREF, 0);
        String referrer = AppsFlyerProperties.getInstance().getReferrer(context);
        if (referrer != null && referrer.length() > 0 && referrer.contains("af_tranid")) {
            return referrerStringToMap(context, referrer);
        }
        String string = sharedPreferences.getString(ATTRIBUTION_ID_PREF, null);
        if (string != null && string.length() > 0) {
            return attributionStringToMap(string);
        }
        throw new AttributionIDNotReady();
    }

    private int getCounter(Context context, String str, boolean z) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(AF_SHARED_PREF, 0);
        int i = sharedPreferences.getInt(str, 0);
        if (!z) {
            return i;
        }
        i++;
        Editor edit = sharedPreferences.edit();
        edit.putInt(str, i);
        editorCommit(edit);
        return i;
    }

    private String getCurrentStore(Context context) {
        return getManifestMetaData(context, "AF_STORE");
    }

    private Uri getDeepLinkUri(Context context) {
        Intent intent = ((Activity) context).getIntent();
        return (intent == null || !"android.intent.action.VIEW".equals(intent.getAction())) ? null : intent.getData();
    }

    private String getFirstInstallDate(SimpleDateFormat simpleDateFormat, Context context) {
        String string = context.getSharedPreferences(AF_SHARED_PREF, 0).getString(FIRST_INSTALL_PREF, null);
        if (string == null) {
            if (isAppsFlyerFirstLaunch(context)) {
                AFLogger.afDebugLog("AppsFlyer: first launch detected");
                string = simpleDateFormat.format(new Date());
            } else {
                string = "";
            }
            saveDataToSharedPreferences(context, FIRST_INSTALL_PREF, string);
        }
        AFLogger.afLog("AppsFlyer: first launch date: " + string);
        return string;
    }

    public static AppsFlyerLib getInstance() {
        return instance;
    }

    private String getManifestMetaData(Context context, String str) {
        String str2 = null;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                Object obj = bundle.get(str);
                if (obj != null) {
                    str2 = obj.toString();
                }
            }
        } catch (Throwable th) {
            AFLogger.afLogE("Could not find " + str + " value in the manifest", th);
        }
        return str2;
    }

    private String getNetwork(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() == 0) {
                return "MOBILE";
            }
        }
        return "unknown";
    }

    private String getPreInstallName(Context context) {
        String str = null;
        SharedPreferences sharedPreferences = context.getSharedPreferences(AF_SHARED_PREF, 0);
        if (sharedPreferences.contains(PRE_INSTALL_PREF)) {
            return sharedPreferences.getString(PRE_INSTALL_PREF, null);
        }
        if (isAppsFlyerFirstLaunch(context)) {
            str = preInstallValueFromFile(context);
            if (str == null) {
                str = getManifestMetaData(context, "AF_PRE_INSTALL_NAME");
            }
        }
        if (str == null) {
            return str;
        }
        saveDataToSharedPreferences(context, PRE_INSTALL_PREF, str);
        return str;
    }

    private String getPushPayloadFromIntent(Context context) {
        if (context instanceof Activity) {
            Intent intent = ((Activity) context).getIntent();
            if (intent != null) {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    String string = extras.getString("af");
                    if (string == null) {
                        return string;
                    }
                    AFLogger.afLog("Push Notification received af payload = " + string);
                    extras.remove("af");
                    ((Activity) context).setIntent(intent.putExtras(extras));
                    return string;
                }
            }
        }
        return null;
    }

    private void getReInstallData(Context context) {
        if (VERSION.SDK_INT >= 18) {
            AFKeystoreWrapper aFKeystoreWrapper = new AFKeystoreWrapper(context);
            if (aFKeystoreWrapper.loadData()) {
                aFKeystoreWrapper.incrementReInstallCounter();
                setProperty(AFKeystoreWrapper.AF_KEYSTORE_UID, aFKeystoreWrapper.getUid());
                setProperty(AFKeystoreWrapper.AF_KEYSTORE_REINSTALL_COUNTER, String.valueOf(aFKeystoreWrapper.getReInstallCounter()));
                return;
            }
            aFKeystoreWrapper.createFirstInstallData(getAppsFlyerUID(context));
            setProperty(AFKeystoreWrapper.AF_KEYSTORE_UID, aFKeystoreWrapper.getUid());
            setProperty(AFKeystoreWrapper.AF_KEYSTORE_REINSTALL_COUNTER, String.valueOf(aFKeystoreWrapper.getReInstallCounter()));
        }
    }

    private long getTimePassedSinceLastLaunch(Context context, boolean z) {
        long j = context.getSharedPreferences(AF_SHARED_PREF, 0).getLong(AF_TIME_PASSED_SINCE_LAST_LAUNCH, 0);
        long currentTimeMillis = System.currentTimeMillis();
        j = j > 0 ? currentTimeMillis - j : -1;
        if (z) {
            saveLongToSharedPreferences(context, AF_TIME_PASSED_SINCE_LAST_LAUNCH, currentTimeMillis);
        }
        return j / 1000;
    }

    private void handleDeepLinkCallback(Context context, Map<String, String> map, Uri uri) {
        Map referrerStringToMap;
        map.put(ServerParameters.DEEP_LINK, uri.toString());
        if (uri.getQueryParameter(ServerParameters.DEEP_LINK) != null) {
            String queryParameter = uri.getQueryParameter("media_source");
            String queryParameter2 = uri.getQueryParameter("is_retargeting");
            if (queryParameter != null && queryParameter2 != null && queryParameter.equals("AppsFlyer_Test") && queryParameter2.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                this.isRetargetingTestMode = true;
            }
            referrerStringToMap = referrerStringToMap(context, uri.getQuery().toString());
            if (uri.getPath() != null) {
                referrerStringToMap.put("path", uri.getPath());
            }
            if (uri.getScheme() != null) {
                referrerStringToMap.put("scheme", uri.getScheme());
            }
            if (uri.getHost() != null) {
                referrerStringToMap.put("host", uri.getHost());
            }
        } else {
            referrerStringToMap = new HashMap();
            referrerStringToMap.put("link", uri.toString());
        }
        saveDataToSharedPreferences(context, DEEPLINK_ATTR_PREF, new JSONObject(referrerStringToMap).toString());
        if (conversionDataListener != null) {
            conversionDataListener.onAppOpenAttribution(referrerStringToMap);
        }
    }

    private boolean isAppsFlyerFirstLaunch(Context context) {
        return !context.getSharedPreferences(AF_SHARED_PREF, 0).contains(AF_COUNTER_PREF);
    }

    private boolean isAppsFlyerPackage(Context context) {
        return context != null && context.getPackageName().length() > 12 && BuildConfig.APPLICATION_ID.equals(context.getPackageName().toLowerCase().substring(0, 13));
    }

    private boolean isGooglePlayServicesAvailable(Context context) {
        try {
            return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0;
        } catch (Throwable th) {
            AFLogger.afLog("WARNING: Google play services is unavailable.");
            return false;
        }
    }

    private boolean isIdCollectionAllowed(Context context) {
        return VERSION.SDK_INT < 19 || !isGooglePlayServicesAvailable(context);
    }

    private boolean isInTestMode(String str) {
        return System.currentTimeMillis() - this.testModeStartTime <= TEST_MODE_MAX_DURATION && str != null && str.contains("AppsFlyer_Test");
    }

    private void lastEventsProcessing(Context context, Map<String, String> map, String str, String str2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(AF_SHARED_PREF, 0);
        Editor edit = sharedPreferences.edit();
        try {
            String string = sharedPreferences.getString(PREV_EVENT_NAME, null);
            if (string != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(PREV_EVENT_TIMESTAMP, sharedPreferences.getLong(PREV_EVENT_TIMESTAMP, -1) + "");
                jSONObject.put(PREV_EVENT_VALUE, sharedPreferences.getString(PREV_EVENT_VALUE, null));
                jSONObject.put(PREV_EVENT_NAME, string);
                map.put(PREV_EVENT, jSONObject.toString());
            }
            edit.putString(PREV_EVENT_NAME, str);
            edit.putString(PREV_EVENT_VALUE, str2);
            edit.putLong(PREV_EVENT_TIMESTAMP, System.currentTimeMillis());
            editorCommit(edit);
        } catch (Throwable e) {
            AFLogger.afLogE("Error while processing previous event.", e);
        }
    }

    private void monitor(Context context, String str, String str2, String str3) {
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.IS_MONITOR, false)) {
            Intent intent = new Intent(MonitorMessages.BROADCAST_ACTION);
            intent.setPackage("com.appsflyer.nightvision");
            intent.putExtra(MonitorMessages.MESSAGE, str2);
            intent.putExtra(MonitorMessages.VALUE, str3);
            intent.putExtra(MonitorMessages.PACKAGE, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            intent.putExtra(MonitorMessages.PROCESS_ID, new Integer(Process.myPid()));
            intent.putExtra(MonitorMessages.EVENT_IDENTIFIER, str);
            intent.putExtra(MonitorMessages.SDK_VERSION, SERVER_BUILD_NUMBER + '.' + SDK_BUILD_NUMBER);
            context.sendBroadcast(intent);
        }
    }

    private int numricBooleanIsClassExist(String str) {
        try {
            Class.forName(str);
            return 1;
        } catch (Throwable th) {
            return 0;
        }
    }

    private String preInstallValueFromFile(Context context) {
        Throwable th;
        String str = null;
        String systemProperty = getSystemProperty(PRE_INSTALL_SYSTEM_RO_PROP);
        if (systemProperty == null) {
            systemProperty = getManifestMetaData(context, "AF_PRE_INSTALL_PATH");
        }
        if (systemProperty == null) {
            systemProperty = PRE_INSTALL_SYSTEM_DEFAULT;
        }
        FileReader fileReader;
        try {
            String str2 = !new File(systemProperty).exists() ? PRE_INSTALL_SYSTEM_DEFAULT_ETC : systemProperty;
            Properties properties = new Properties();
            fileReader = new FileReader(str2);
            try {
                properties.load(fileReader);
                AFLogger.afLog("Found pre_install definition");
                str = properties.getProperty(context.getPackageName());
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable th2) {
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable th4) {
                    }
                }
                throw th;
            }
        } catch (Throwable th5) {
            Throwable th6 = th5;
            fileReader = str;
            th = th6;
            if (fileReader != null) {
                fileReader.close();
            }
            throw th;
        }
        return str;
    }

    private Map<String, String> referrerStringToMap(Context context, String str) {
        Map<String, String> linkedHashMap = new LinkedHashMap();
        String[] split = str.split("&");
        int length = split.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Object substring;
            String str2 = split[i];
            int indexOf = str2.indexOf("=");
            if (indexOf > 0) {
                substring = str2.substring(0, indexOf);
            } else {
                String str3 = str2;
            }
            if (!linkedHashMap.containsKey(substring)) {
                if (substring.equals("c")) {
                    substring = "campaign";
                } else if (substring.equals(MonitorMessages.PROCESS_ID)) {
                    substring = "media_source";
                } else if (substring.equals("af_prt")) {
                    i2 = 1;
                    substring = "agency";
                }
                linkedHashMap.put(substring, new String());
            }
            int i3 = i2;
            Object obj = substring;
            substring = (indexOf <= 0 || str2.length() <= indexOf + 1) ? null : str2.substring(indexOf + 1);
            linkedHashMap.put(obj, substring);
            i++;
            i2 = i3;
        }
        try {
            if (!linkedHashMap.containsKey("install_time")) {
                linkedHashMap.put("install_time", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime)));
            }
        } catch (Exception e) {
            AFLogger.afWarnLog("Could not fetch install time");
        }
        if (!linkedHashMap.containsKey("af_status")) {
            linkedHashMap.put("af_status", "Non-organic");
        }
        if (i2 != 0) {
            linkedHashMap.remove("media_source");
        }
        return linkedHashMap;
    }

    private void registerForAppEvents(Application application) {
        if (this.listener == null) {
            AppsFlyerProperties.getInstance().loadProperties(application.getApplicationContext());
            if (VERSION.SDK_INT >= 14) {
                Foreground.init(application);
                this.listener = new C03691();
                Foreground.getInstance().addListener(this.listener);
                return;
            }
            AFLogger.afLog("SDK<14 call trackAppLaunch manually");
            trackEvent(application.getApplicationContext(), null, null);
        }
    }

    private synchronized void registerOnGCM(final Context context) {
        final String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.GCM_PROJECT_NUMBER);
        if (string != null && AppsFlyerProperties.getInstance().getString("gcmToken") == null) {
            new AsyncTask<Void, Void, GcmToken>() {
                protected GcmToken doInBackground(Void... voidArr) {
                    try {
                        Class.forName("com.google.android.gms.iid.InstanceID");
                        InstanceID instance = InstanceID.getInstance(context);
                        return new GcmToken(System.currentTimeMillis(), instance.getToken(string, "GCM", null), instance.getId());
                    } catch (ClassNotFoundException e) {
                        AFLogger.afLog("Please integrate Google Play Services in order to support uninstall feature");
                    } catch (IOException e2) {
                        AFLogger.afLog("Could not load registration ID");
                    } catch (Throwable th) {
                        AFLogger.afLog("Error registering for uninstall feature");
                    }
                    return null;
                }

                protected void onPostExecute(GcmToken gcmToken) {
                    if (gcmToken != null) {
                        GcmToken gcmToken2 = new GcmToken(AppsFlyerProperties.getInstance().getString("gcmTokenTimestamp"), AppsFlyerProperties.getInstance().getString("gcmToken"), AppsFlyerProperties.getInstance().getString("gcmInstanceId"));
                        if (gcmToken2.update(gcmToken)) {
                            AFLogger.afLog("token=" + gcmToken2.getToken());
                            AFLogger.afLog("instance id=" + gcmToken2.getInstanceId());
                            AppsFlyerLib.this.updateServerGcmToken(gcmToken2, context);
                        }
                    }
                }
            }.execute(new Void[0]);
        }
    }

    private void runInBackground(Context context, String str, String str2, String str3, String str4, boolean z) {
        Object newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        newSingleThreadScheduledExecutor.schedule(new DataCollector(context, str, str2, str3, str4, z, newSingleThreadScheduledExecutor), 5, TimeUnit.MILLISECONDS);
    }

    private void saveDataToSharedPreferences(Context context, String str, String str2) {
        Editor edit = context.getSharedPreferences(AF_SHARED_PREF, 0).edit();
        edit.putString(str, str2);
        editorCommit(edit);
    }

    private void saveIntegerToSharedPreferences(Context context, String str, int i) {
        Editor edit = context.getSharedPreferences(AF_SHARED_PREF, 0).edit();
        edit.putInt(str, i);
        editorCommit(edit);
    }

    private void saveLongToSharedPreferences(Context context, String str, long j) {
        Editor edit = context.getSharedPreferences(AF_SHARED_PREF, 0).edit();
        edit.putLong(str, j);
        editorCommit(edit);
    }

    private void sendRequestToServer(String str, String str2, String str3, WeakReference<Context> weakReference, String str4, boolean z) {
        URL url = new URL(str);
        AFLogger.afLog("url: " + url.toString());
        debugAction(CALL_SERVER_ACTION, "\n" + url.toString() + "\nPOST:" + str2, (Context) weakReference.get());
        LogMessages.logMessageMaskKey(LogMessages.EVENT_DATA + str2);
        monitor((Context) weakReference.get(), LOG_TAG, MonitorMessages.EVENT_DATA, str2);
        try {
            callServer(url, str2, str3, weakReference, str4, z);
        } catch (IOException e) {
            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.USE_HTTP_FALLBACK, false)) {
                debugAction("https failed: " + e.getLocalizedMessage(), "", (Context) weakReference.get());
                callServer(new URL(str.replace("https:", "http:")), str2, str3, weakReference, str4, z);
                return;
            }
            AFLogger.afLog(LogMessages.SERVER_CALL_FAILRED + e.getLocalizedMessage());
            monitor((Context) weakReference.get(), LOG_TAG, MonitorMessages.ERROR, e.getLocalizedMessage());
            throw e;
        }
    }

    private void sendTrackingWithEvent(Context context, String str, String str2, String str3, String str4, boolean z) {
        StringBuilder stringBuilder;
        String property;
        AppsFlyerProperties.getInstance().saveProperties(context);
        AFLogger.afLog("AsendTrackingWithEvent from activity: " + context.getClass().getName().toString());
        boolean z2 = str2 == null;
        Map hashMap = new HashMap();
        addAdvertiserIDData(context, hashMap);
        hashMap.put(ServerParameters.TIMESTAMP, Long.toString(new Date().getTime()));
        debugAction(PREPARE_DATA_ACTION, "", context);
        AFLogger.afLog(LogMessages.EVENT_CREATED_WITH_NAME + (z2 ? "Launch" : str2));
        debugAction("********* sendTrackingWithEvent: ", z2 ? "Launch" : str2, context);
        monitor(context, LOG_TAG, MonitorMessages.EVENT_CREATED_WITH_NAME, z2 ? "Launch" : str2);
        CacheManager.getInstance().init(context);
        try {
            List asList = Arrays.asList(context.getPackageManager().getPackageInfo(context.getPackageName(), FragmentTransaction.TRANSIT_ENTER_MASK).requestedPermissions);
            if (!asList.contains("android.permission.INTERNET")) {
                AFLogger.afWarnLog(LogMessages.PERMISSION_INTERNET_MISSING);
                monitor(context, null, MonitorMessages.PERMISSION_INTERNET_MISSING, null);
            }
            if (!asList.contains("android.permission.ACCESS_NETWORK_STATE")) {
                AFLogger.afWarnLog(LogMessages.PERMISSION_ACCESS_NETWORK_MISSING);
            }
            if (!asList.contains("android.permission.ACCESS_WIFI_STATE")) {
                AFLogger.afWarnLog(LogMessages.PERMISSION_ACCESS_WIFI_MISSING);
            }
        } catch (Exception e) {
        }
        try {
            stringBuilder = new StringBuilder();
            stringBuilder.append(z2 ? APPS_TRACKING_URL : EVENTS_TRACKING_URL).append(context.getPackageName());
            if (z) {
                hashMap.put("af_events_api", "1");
            }
            hashMap.put("brand", Build.BRAND);
            hashMap.put("device", Build.DEVICE);
            hashMap.put("product", Build.PRODUCT);
            hashMap.put(MonitorMessages.SDK_VERSION, Integer.toString(VERSION.SDK_INT));
            hashMap.put("model", Build.MODEL);
            hashMap.put("deviceType", Build.TYPE);
            if (!z2) {
                lastEventsProcessing(context, hashMap, str2, str3);
            } else if (isAppsFlyerFirstLaunch(context)) {
                if (!AppsFlyerProperties.getInstance().isOtherSdkStringDisabled()) {
                    hashMap.put(ServerParameters.OTHER_SDKS, generateOtherSDKsString());
                    hashMap.put(ServerParameters.DEVICE_CURRENT_BATTERY_LEVEL, String.valueOf(getBatteryLevel(context)));
                }
                getReInstallData(context);
            }
            property = getProperty(AFKeystoreWrapper.AF_KEYSTORE_UID);
            String property2 = getProperty(AFKeystoreWrapper.AF_KEYSTORE_REINSTALL_COUNTER);
            if (!(property == null || property2 == null || Integer.valueOf(property2).intValue() <= 0)) {
                hashMap.put(ServerParameters.REINSTALL_COUNTER, property2);
                hashMap.put(ServerParameters.ORIGINAL_AF_UID, property);
            }
            property = getProperty(AppsFlyerProperties.ADDITIONAL_CUSTOM_DATA);
            if (property != null) {
                hashMap.put("customData", property);
            }
            try {
                property = context.getPackageManager().getInstallerPackageName(context.getPackageName());
                if (property != null) {
                    hashMap.put("installer_package", property);
                }
            } catch (Exception e2) {
            }
            property = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.EXTENSION);
            if (property != null && property.length() > 0) {
                hashMap.put(AppsFlyerProperties.EXTENSION, property);
            }
            property = getConfiguredChannel(context);
            property2 = getCachedChannel(context, property);
            if (property2 != null) {
                hashMap.put("channel", property2);
            }
            if (!(property2 == null || property2.equals(property)) || (property2 == null && property != null)) {
                hashMap.put(ServerParameters.LATEST_CHANNEL_SERVER_PARAM, property);
            }
            property = getCachedStore(context);
            if (property != null) {
                hashMap.put(ServerParameters.INSTALL_STORE, property.toLowerCase());
            }
            property = getPreInstallName(context);
            if (property != null) {
                hashMap.put(ServerParameters.PRE_INSTALL_NAME, property.toLowerCase());
            }
            property = getCurrentStore(context);
            if (property != null) {
                hashMap.put(ServerParameters.CURRENT_STORE, property.toLowerCase());
            }
            if (str == null || str.length() < 0) {
                property = getProperty(AppsFlyerProperties.AF_KEY);
                if (property == null || property.length() < 0) {
                    AFLogger.afLog(LogMessages.DEV_KEY_MISSING);
                    monitor(context, LOG_TAG, MonitorMessages.DEV_KEY_MISSING, null);
                    AFLogger.afLog("AppsFlyer will not track this event.");
                    return;
                }
                hashMap.put(ServerParameters.AF_DEV_KEY, property);
            } else {
                hashMap.put(ServerParameters.AF_DEV_KEY, str);
            }
            property = getAppUserId();
            if (property != null) {
                hashMap.put("appUserId", property);
            }
            property = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.USER_EMAILS);
            if (property != null) {
                hashMap.put("user_emails", property);
            } else {
                property = getProperty(AppsFlyerProperties.USER_EMAIL);
                if (property != null) {
                    hashMap.put("sha1_el", HashUtils.toSHA1(property));
                }
            }
            if (str2 != null) {
                hashMap.put(ServerParameters.EVENT_NAME, str2);
                if (str3 != null) {
                    hashMap.put(ServerParameters.EVENT_VALUE, str3);
                }
            }
            if (getProperty(AppsFlyerProperties.APP_ID) != null) {
                hashMap.put(AppsFlyerProperties.APP_ID, getProperty(AppsFlyerProperties.APP_ID));
            }
            property = getProperty(AppsFlyerProperties.CURRENCY_CODE);
            if (property != null) {
                if (property.length() != 3) {
                    AFLogger.afWarnLog("WARNING: currency code should be 3 characters!!! '" + property + "' is not a legal value.");
                }
                hashMap.put("currency", property);
            }
            property = getProperty(AppsFlyerProperties.IS_UPDATE);
            if (property != null) {
                hashMap.put("isUpdate", property);
            }
            hashMap.put("af_preinstalled", Boolean.toString(isPreInstalledApp(context)));
            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_FACEBOOK_ATTR_ID, true)) {
                property = getAttributionId(context.getContentResolver());
                if (property != null) {
                    hashMap.put("fb", property);
                }
            }
            addDeviceTracking(context, hashMap);
            property = Installation.id(context);
            if (property != null) {
                hashMap.put(ServerParameters.AF_USER_ID, property);
            }
        } catch (Exception e3) {
            AFLogger.afLog(ERROR_PREFIX + ERROR_PREFIX + "could not get uid " + e3.getMessage());
        } catch (Throwable th) {
            AFLogger.afLogE(th.getLocalizedMessage(), th);
            return;
        }
        try {
            hashMap.put("lang", Locale.getDefault().getDisplayLanguage());
        } catch (Exception e4) {
        }
        try {
            hashMap.put("lang_code", Locale.getDefault().getLanguage());
        } catch (Exception e5) {
        }
        try {
            hashMap.put("country", Locale.getDefault().getCountry());
        } catch (Exception e6) {
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            hashMap.put("operator", telephonyManager.getSimOperatorName());
            hashMap.put("carrier", telephonyManager.getNetworkOperatorName());
        } catch (Exception e7) {
        }
        try {
            hashMap.put("network", getNetwork(context));
        } catch (Throwable th2) {
            AFLogger.afLog("checking network error " + th2.getMessage());
        }
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_FINGER_PRINT, true)) {
            property = getUniquePsuedoID();
            if (property != null) {
                hashMap.put(ServerParameters.DEVICE_FINGER_PRINT_ID, property);
            }
        }
        checkPlatform(context, hashMap);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(INSTALL_UPDATE_DATE_FORMAT, Locale.US);
        if (VERSION.SDK_INT >= 9) {
            try {
                hashMap.put("installDate", simpleDateFormat.format(new Date(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime)));
            } catch (Exception e8) {
            }
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo.versionCode > context.getSharedPreferences(AF_SHARED_PREF, 0).getInt(VERSION_CODE, 0)) {
                saveIntegerToSharedPreferences(context, CONVERSION_REQUEST_RETRIES, 0);
                saveIntegerToSharedPreferences(context, VERSION_CODE, packageInfo.versionCode);
            }
            hashMap.put("app_version_code", Integer.toString(packageInfo.versionCode));
            hashMap.put("app_version_name", packageInfo.versionName);
            if (VERSION.SDK_INT >= 9) {
                long j = packageInfo.firstInstallTime;
                long j2 = packageInfo.lastUpdateTime;
                hashMap.put("date1", simpleDateFormat.format(new Date(j)));
                hashMap.put("date2", simpleDateFormat.format(new Date(j2)));
                hashMap.put("firstLaunchDate", getFirstInstallDate(simpleDateFormat, context));
            }
        } catch (NameNotFoundException e9) {
        } catch (NoSuchFieldError e10) {
        }
        if (str4.length() > 0) {
            hashMap.put(REFERRER_PREF, str4);
        }
        property = context.getSharedPreferences(AF_SHARED_PREF, 0).getString(ATTRIBUTION_ID_PREF, null);
        if (property != null && property.length() > 0) {
            hashMap.put("installAttribution", property);
        }
        property = AppsFlyerProperties.getInstance().getString("gcmInstanceId");
        if (property != null) {
            hashMap.put(ServerParameters.GOOGLE_INSTANCE_ID, property);
        }
        if (z2) {
            if (this.pushPayload != null) {
                JSONObject jSONObject = new JSONObject(this.pushPayload);
                jSONObject.put("isPush", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                hashMap.put(ServerParameters.DEEP_LINK, jSONObject.toString());
            }
            this.pushPayload = null;
        }
        if (z2 && (context instanceof Activity)) {
            Uri deepLinkUri = getDeepLinkUri(context);
            if (deepLinkUri != null) {
                handleDeepLinkCallback(context, hashMap, deepLinkUri);
            } else if (this.latestDeepLink != null) {
                handleDeepLinkCallback(context, hashMap, this.latestDeepLink);
            }
        }
        if (this.isRetargetingTestMode) {
            hashMap.put("testAppMode_retargeting", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            broadcastBacktoTestApp(context, (HashMap) hashMap);
            AFLogger.afLog("Sent retargeting params to test app");
        }
        if (isInTestMode(str4)) {
            hashMap.put("testAppMode", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            broadcastBacktoTestApp(context, (HashMap) hashMap);
            AFLogger.afLog("Sent params to test app");
            endTestMode();
        }
        if (getProperty(ServerParameters.ADVERTISING_ID_PARAM) == null) {
            addAdvertiserIDData(context, hashMap);
            if (getProperty(ServerParameters.ADVERTISING_ID_PARAM) != null) {
                hashMap.put("GAID_retry", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            } else {
                hashMap.put("GAID_retry", "false");
            }
        }
        AFLogger.afLog("AppsFlyerLib.sendTrackingWithEvent");
        new SendToServerRunnable(stringBuilder.toString(), hashMap, context.getApplicationContext(), z2).run();
    }

    private void startTestMode() {
        AFLogger.afLog("Test mode started..");
        this.testModeStartTime = System.currentTimeMillis();
    }

    public String getAppId() {
        return getProperty(AppsFlyerProperties.APP_ID);
    }

    public String getAppUserId() {
        return getProperty(AppsFlyerProperties.APP_USER_ID);
    }

    public String getAppsFlyerUID(Context context) {
        return Installation.id(context);
    }

    public String getAttributionId(ContentResolver contentResolver) {
        String str = null;
        String[] strArr = new String[]{"aid"};
        Cursor query = contentResolver.query(Uri.parse(ATTRIBUTION_ID_CONTENT_URI), strArr, str, str, str);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    str = query.getString(query.getColumnIndex("aid"));
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Exception e) {
                        }
                    }
                    return str;
                }
            } catch (Exception e2) {
                AFLogger.afWarnLog("Could not collect cursor attribution" + e2);
                if (query != null) {
                    try {
                        query.close();
                    } catch (Exception e3) {
                    }
                }
            } catch (Throwable th) {
                if (query != null) {
                    try {
                        query.close();
                    } catch (Exception e4) {
                    }
                }
            }
        }
        if (query != null) {
            try {
                query.close();
            } catch (Exception e5) {
            }
        }
        return str;
    }

    public float getBatteryLevel(Context context) {
        float f = 1.0f;
        try {
            Intent registerReceiver = context.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver.getIntExtra("level", -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            return (intExtra == -1 || intExtra2 == -1) ? 50.0f : (((float) intExtra) / ((float) intExtra2)) * 100.0f;
        } catch (Throwable th) {
            return f;
        }
    }

    @Deprecated
    public void getConversionData(Context context, final ConversionDataListener conversionDataListener) {
        registerConversionListener(context, new AppsFlyerConversionListener() {
            public void onAppOpenAttribution(Map<String, String> map) {
            }

            public void onAttributionFailure(String str) {
            }

            public void onInstallConversionDataLoaded(Map<String, String> map) {
                conversionDataListener.onConversionDataLoaded(map);
            }

            public void onInstallConversionFailure(String str) {
                conversionDataListener.onConversionFailure(str);
            }
        });
    }

    public String getProperty(String str) {
        return AppsFlyerProperties.getInstance().getString(str);
    }

    public String getSdkVersion() {
        return "version: 4.6.0 (build 282)";
    }

    public String getSystemProperty(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke(null, new Object[]{str});
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getUniquePsuedoID() {
        String str = "35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10);
        try {
            return new UUID((long) str.hashCode(), (long) Build.class.getField("SERIAL").get(null).toString().hashCode()).toString();
        } catch (Exception e) {
            return new UUID((long) str.hashCode(), (long) "serial".hashCode()).toString();
        }
    }

    public boolean isPreInstalledApp(Context context) {
        try {
            return (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 1) != 0;
        } catch (Throwable e) {
            AFLogger.afLogE("Could not check if app is pre installed", e);
            return false;
        }
    }

    public String mapToString(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : map.keySet()) {
            String str2 = (String) map.get(str);
            str2 = str2 == null ? "" : URLEncoder.encode(str2, "UTF-8");
            if (stringBuilder.length() > 0) {
                stringBuilder.append('&');
            }
            stringBuilder.append(str).append('=').append(str2);
        }
        return stringBuilder.toString();
    }

    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(AppsFlyerProperties.IS_MONITOR);
        if (stringExtra != null) {
            AFLogger.afLog("Turning on monitoring.");
            AppsFlyerProperties.getInstance().set(AppsFlyerProperties.IS_MONITOR, stringExtra.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
            monitor(context, null, MonitorMessages.START_TRACKING, context.getPackageName());
            return;
        }
        AFLogger.afLog("****** onReceive called *******");
        debugAction("******* onReceive: ", "", context);
        AppsFlyerProperties.getInstance().setOnReceiveCalled();
        String stringExtra2 = intent.getStringExtra(REFERRER_PREF);
        AFLogger.afLog(LogMessages.PLAY_STORE_REFERRER_RECIEVED + stringExtra2);
        if (stringExtra2 != null) {
            stringExtra = intent.getStringExtra("TestIntegrationMode");
            if (stringExtra != null && stringExtra.equals("AppsFlyer_Test")) {
                Editor edit = context.getSharedPreferences(AF_SHARED_PREF, 0).edit();
                edit.clear();
                editorCommit(edit);
                AppsFlyerProperties.getInstance().setFirstLaunchCalled(false);
                startTestMode();
            }
            debugAction("onReceive called. referrer: ", stringExtra2, context);
            saveDataToSharedPreferences(context, REFERRER_PREF, stringExtra2);
            AppsFlyerProperties.getInstance().setReferrer(stringExtra2);
            if (AppsFlyerProperties.getInstance().isFirstLaunchCalled()) {
                AFLogger.afLog("onReceive: isLaunchCalled");
                runInBackground(context, null, null, null, stringExtra2, false);
            }
        }
    }

    public void registerConversionListener(Context context, AppsFlyerConversionListener appsFlyerConversionListener) {
        if (appsFlyerConversionListener != null) {
            conversionDataListener = appsFlyerConversionListener;
        }
    }

    public void registerValidatorListener(Context context, AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener) {
        AFLogger.afDebugLog("registerValidatorListener called");
        if (appsFlyerInAppPurchaseValidatorListener == null) {
            AFLogger.afDebugLog("registerValidatorListener null listener");
        } else {
            validatorListener = appsFlyerInAppPurchaseValidatorListener;
        }
    }

    public void reportTrackSession(Context context) {
        trackEvent(context, null, null);
    }

    public void sendDeepLinkData(Activity activity) {
        AFLogger.afLog("getDeepLinkData with activity " + activity.getIntent().getDataString());
        registerForAppEvents(activity.getApplication());
    }

    public void sendPushNotificationData(Activity activity) {
        Object th;
        this.pushPayload = getPushPayloadFromIntent(activity);
        if (this.pushPayload != null) {
            long j;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.pushPayloadHistory == null) {
                AFLogger.afLog("pushes: initializing pushes history..");
                this.pushPayloadHistory = new ConcurrentHashMap();
                j = currentTimeMillis;
            } else {
                try {
                    long j2 = AppsFlyerProperties.getInstance().getLong(AppsFlyerProperties.PUSH_PAYLOAD_MAX_AGING, PUSH_PAYLOAD_MAX_AGING_DEFAULT_VALUE);
                    j = currentTimeMillis;
                    for (Long l : this.pushPayloadHistory.keySet()) {
                        try {
                            JSONObject jSONObject = new JSONObject(this.pushPayload);
                            JSONObject jSONObject2 = new JSONObject((String) this.pushPayloadHistory.get(l));
                            if (jSONObject.get(MonitorMessages.PROCESS_ID).equals(jSONObject2.get(MonitorMessages.PROCESS_ID))) {
                                AFLogger.afLog("PushNotificationMeasurement: A previous payload with same PID was already acknowledged! (old: " + jSONObject2 + ", new: " + jSONObject + ")");
                                this.pushPayload = null;
                                return;
                            }
                            if (currentTimeMillis - l.longValue() > j2) {
                                this.pushPayloadHistory.remove(l);
                            }
                            j = l.longValue() <= j ? l.longValue() : j;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    j = currentTimeMillis;
                    AFLogger.afLog("Error while handling push notification measurement: " + th.getClass().getSimpleName());
                    if (this.pushPayloadHistory.size() == AppsFlyerProperties.getInstance().getInt(AppsFlyerProperties.PUSH_PAYLOAD_HISTORY_SIZE, 2)) {
                        AFLogger.afLog("pushes: removing oldest overflowing push (oldest push:" + j + ")");
                        this.pushPayloadHistory.remove(Long.valueOf(j));
                    }
                    this.pushPayloadHistory.put(Long.valueOf(currentTimeMillis), this.pushPayload);
                    registerForAppEvents(activity.getApplication());
                }
            }
            if (this.pushPayloadHistory.size() == AppsFlyerProperties.getInstance().getInt(AppsFlyerProperties.PUSH_PAYLOAD_HISTORY_SIZE, 2)) {
                AFLogger.afLog("pushes: removing oldest overflowing push (oldest push:" + j + ")");
                this.pushPayloadHistory.remove(Long.valueOf(j));
            }
            this.pushPayloadHistory.put(Long.valueOf(currentTimeMillis), this.pushPayload);
            registerForAppEvents(activity.getApplication());
        }
    }

    public void setAdditionalData(HashMap<String, Object> hashMap) {
        AppsFlyerProperties.getInstance().setCustomData(new JSONObject(hashMap).toString());
    }

    public void setAndroidIdData(String str) {
        userCustomAndroidId = str;
    }

    public void setAppId(String str) {
        setProperty(AppsFlyerProperties.APP_ID, str);
    }

    @Deprecated
    public void setAppUserId(String str) {
        setCustomerUserId(str);
    }

    public void setCollectAndroidID(boolean z) {
        setProperty(AppsFlyerProperties.COLLECT_ANDROID_ID, Boolean.toString(z));
    }

    public void setCollectFingerPrint(boolean z) {
        setProperty(AppsFlyerProperties.COLLECT_FINGER_PRINT, Boolean.toString(z));
    }

    public void setCollectIMEI(boolean z) {
        setProperty(AppsFlyerProperties.COLLECT_IMEI, Boolean.toString(z));
    }

    public void setCollectMACAddress(boolean z) {
        setProperty(AppsFlyerProperties.COLLECT_MAC, Boolean.toString(z));
    }

    public void setCurrencyCode(String str) {
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.CURRENCY_CODE, str);
    }

    public void setCustomerUserId(String str) {
        AFLogger.afLog("setCustomerUserId = " + str);
        setProperty(AppsFlyerProperties.APP_USER_ID, str);
    }

    public void setDebugLog(boolean z) {
        AppsFlyerProperties.getInstance().enableLogOutput(z);
    }

    void setDeepLinkData(Intent intent) {
        if (intent != null) {
            try {
                if ("android.intent.action.VIEW".equals(intent.getAction())) {
                    this.latestDeepLink = intent.getData();
                    AFLogger.afDebugLog("Unity setDeepLinkData = " + this.latestDeepLink);
                }
            } catch (Throwable th) {
            }
        }
    }

    public void setDeviceTrackingDisabled(boolean z) {
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, z);
    }

    public void setExtension(String str) {
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EXTENSION, str);
    }

    @Deprecated
    public void setGCMProjectID(String str) {
        setGCMProjectNumber(str);
    }

    public void setGCMProjectNumber(Context context, String str) {
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.GCM_PROJECT_NUMBER, str);
        registerOnGCM(context);
    }

    @Deprecated
    public void setGCMProjectNumber(String str) {
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.GCM_PROJECT_NUMBER, str);
    }

    public void setImeiData(String str) {
        userCustomImei = str;
    }

    public void setIsUpdate(boolean z) {
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.IS_UPDATE, z);
    }

    protected void setProperty(String str, String str2) {
        AppsFlyerProperties.getInstance().set(str, str2);
    }

    public void setUseHTTPFalback(boolean z) {
        setProperty(AppsFlyerProperties.USE_HTTP_FALLBACK, Boolean.toString(z));
    }

    @Deprecated
    public void setUserEmail(String str) {
        setProperty(AppsFlyerProperties.USER_EMAIL, str);
    }

    public void setUserEmails(EmailsCryptType emailsCryptType, String... strArr) {
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EMAIL_CRYPT_TYPE, emailsCryptType.getValue());
        HashMap hashMap = new HashMap();
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : strArr) {
            stringBuilder.append(append);
            stringBuilder.append(",");
        }
        switch (emailsCryptType) {
            case MD5:
                hashMap.put("md5_el_arr", HashUtils.toMD5(stringBuilder.toString()));
                break;
            case NONE:
                hashMap.put("plain_el_arr", stringBuilder.toString());
                break;
            default:
                hashMap.put("sha1_el_arr", HashUtils.toSHA1(stringBuilder.toString()));
                break;
        }
        AppsFlyerProperties.getInstance().setUserEmails(new JSONObject(hashMap).toString());
    }

    public void setUserEmails(String... strArr) {
        setUserEmails(EmailsCryptType.NONE, strArr);
    }

    public void startTracking(Application application, String str) {
        AFLogger.afLogM("Build Number: 282");
        setProperty(AppsFlyerProperties.AF_KEY, str);
        LogMessages.setDevKey(str);
        registerForAppEvents(application);
        if (AppsFlyerProperties.getInstance().getString("gcmToken") == null && AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.GCM_PROJECT_NUMBER) != null) {
            registerOnGCM(application.getApplicationContext());
        }
    }

    public void trackAppLaunch(Context context, String str) {
        runInBackground(context, str, null, null, "", true);
    }

    public void trackEvent(Context context, String str, Map<String, Object> map) {
        Map hashMap;
        if (map == null) {
            hashMap = new HashMap();
        }
        JSONObject jSONObject = new JSONObject(hashMap);
        String referrer = AppsFlyerProperties.getInstance().getReferrer(context);
        String jSONObject2 = jSONObject.toString();
        if (referrer == null) {
            referrer = "";
        }
        runInBackground(context, null, str, jSONObject2, referrer, true);
    }

    public void trackLocation(Context context, double d, double d2) {
        Map hashMap = new HashMap();
        hashMap.put(AFInAppEventParameterName.LONGTITUDE, Double.toString(d2));
        hashMap.put(AFInAppEventParameterName.LATITUDE, Double.toString(d));
        trackEvent(context, AFInAppEventType.LOCATION_COORDINATES, hashMap);
    }

    public void unregisterConversionListener() {
        conversionDataListener = null;
    }

    void updateServerGcmToken(GcmToken gcmToken, Context context) {
        AFLogger.afLog("updateServerGcmToken called");
        AppsFlyerProperties.getInstance().set("gcmToken", gcmToken.getToken());
        AppsFlyerProperties.getInstance().set("gcmInstanceId", gcmToken.getInstanceId());
        AppsFlyerProperties.getInstance().set("gcmTokenTimestamp", String.valueOf(gcmToken.getTokenTimestamp()));
        callRegisterBackground(context);
    }

    public void validateAndTrackInAppPurchase(Context context, String str, String str2, String str3, String str4, String str5, HashMap<String, String> hashMap) {
        AFLogger.afLog("Validate in app called with parameters: " + str3 + " " + str4 + " " + str5);
        if (str != null && str4 != null && str2 != null && str5 != null && str3 != null) {
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            newSingleThreadScheduledExecutor.schedule(new AppsFlyerInAppPurchaseValidator(context.getApplicationContext(), getProperty(AppsFlyerProperties.AF_KEY), str, str2, str3, str4, str5, hashMap, newSingleThreadScheduledExecutor), 10, TimeUnit.MILLISECONDS);
        } else if (validatorListener != null) {
            validatorListener.onValidateInAppFailure("Please provide purchase parameters");
        }
    }
}
