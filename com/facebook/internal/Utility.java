package com.facebook.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.appsflyer.ServerParameters;
import com.facebook.FacebookException;
import com.facebook.Request;
import com.facebook.Settings;
import com.facebook.model.GraphObject;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class Utility {
    private static final String APPLICATION_FIELDS = "fields";
    private static final String APP_SETTINGS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_SETTINGS.%s";
    private static final String APP_SETTINGS_PREFS_STORE = "com.facebook.internal.preferences.APP_SETTINGS";
    private static final String APP_SETTING_DIALOG_CONFIGS = "android_dialog_configs";
    private static final String[] APP_SETTING_FIELDS = new String[]{APP_SETTING_SUPPORTS_ATTRIBUTION, APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING, APP_SETTING_NUX_CONTENT, APP_SETTING_NUX_ENABLED, APP_SETTING_DIALOG_CONFIGS};
    private static final String APP_SETTING_NUX_CONTENT = "gdpv4_nux_content";
    private static final String APP_SETTING_NUX_ENABLED = "gdpv4_nux_enabled";
    private static final String APP_SETTING_SUPPORTS_ATTRIBUTION = "supports_attribution";
    private static final String APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING = "supports_implicit_sdk_logging";
    public static final int DEFAULT_STREAM_BUFFER_SIZE = 8192;
    private static final String DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR = "\\|";
    private static final String DIALOG_CONFIG_NAME_KEY = "name";
    private static final String DIALOG_CONFIG_URL_KEY = "url";
    private static final String DIALOG_CONFIG_VERSIONS_KEY = "versions";
    private static final String EXTRA_APP_EVENTS_INFO_FORMAT_VERSION = "a1";
    private static final String HASH_ALGORITHM_MD5 = "MD5";
    private static final String HASH_ALGORITHM_SHA1 = "SHA-1";
    static final String LOG_TAG = "FacebookSDK";
    private static final String URL_SCHEME = "https";
    private static final String UTF8 = "UTF-8";
    private static Map<String, FetchedAppSettings> fetchedAppSettings = new ConcurrentHashMap();
    private static AsyncTask<Void, Void, GraphObject> initialAppSettingsLoadTask;

    public static class DialogFeatureConfig {
        private String dialogName;
        private Uri fallbackUrl;
        private String featureName;
        private int[] featureVersionSpec;

        private DialogFeatureConfig(String str, String str2, Uri uri, int[] iArr) {
            this.dialogName = str;
            this.featureName = str2;
            this.fallbackUrl = uri;
            this.featureVersionSpec = iArr;
        }

        private static DialogFeatureConfig parseDialogConfig(JSONObject jSONObject) {
            Uri uri = null;
            String optString = jSONObject.optString(Utility.DIALOG_CONFIG_NAME_KEY);
            if (Utility.isNullOrEmpty(optString)) {
                return null;
            }
            String[] split = optString.split(Utility.DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR);
            if (split.length != 2) {
                return null;
            }
            String str = split[0];
            String str2 = split[1];
            if (Utility.isNullOrEmpty(str) || Utility.isNullOrEmpty(str2)) {
                return null;
            }
            optString = jSONObject.optString("url");
            if (!Utility.isNullOrEmpty(optString)) {
                uri = Uri.parse(optString);
            }
            return new DialogFeatureConfig(str, str2, uri, parseVersionSpec(jSONObject.optJSONArray(Utility.DIALOG_CONFIG_VERSIONS_KEY)));
        }

        private static int[] parseVersionSpec(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            int length = jSONArray.length();
            int[] iArr = new int[length];
            for (int i = 0; i < length; i++) {
                int optInt = jSONArray.optInt(i, -1);
                if (optInt == -1) {
                    String optString = jSONArray.optString(i);
                    if (!Utility.isNullOrEmpty(optString)) {
                        try {
                            optInt = Integer.parseInt(optString);
                        } catch (Exception e) {
                            Utility.logd(Utility.LOG_TAG, e);
                            optInt = -1;
                        }
                    }
                }
                iArr[i] = optInt;
            }
            return iArr;
        }

        public String getDialogName() {
            return this.dialogName;
        }

        public Uri getFallbackUrl() {
            return this.fallbackUrl;
        }

        public String getFeatureName() {
            return this.featureName;
        }

        public int[] getVersionSpec() {
            return this.featureVersionSpec;
        }
    }

    public static class FetchedAppSettings {
        private Map<String, Map<String, DialogFeatureConfig>> dialogConfigMap;
        private String nuxContent;
        private boolean nuxEnabled;
        private boolean supportsAttribution;
        private boolean supportsImplicitLogging;

        private FetchedAppSettings(boolean z, boolean z2, String str, boolean z3, Map<String, Map<String, DialogFeatureConfig>> map) {
            this.supportsAttribution = z;
            this.supportsImplicitLogging = z2;
            this.nuxContent = str;
            this.nuxEnabled = z3;
            this.dialogConfigMap = map;
        }

        public Map<String, Map<String, DialogFeatureConfig>> getDialogConfigurations() {
            return this.dialogConfigMap;
        }

        public String getNuxContent() {
            return this.nuxContent;
        }

        public boolean getNuxEnabled() {
            return this.nuxEnabled;
        }

        public boolean supportsAttribution() {
            return this.supportsAttribution;
        }

        public boolean supportsImplicitLogging() {
            return this.supportsImplicitLogging;
        }
    }

    public static <T> boolean areObjectsEqual(T t, T t2) {
        return t == null ? t2 == null : t.equals(t2);
    }

    public static <T> ArrayList<T> arrayList(T... tArr) {
        ArrayList<T> arrayList = new ArrayList(tArr.length);
        for (Object add : tArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static <T> List<T> asListNoNulls(T... tArr) {
        List arrayList = new ArrayList();
        for (Object obj : tArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static Uri buildUri(String str, String str2, Bundle bundle) {
        Builder builder = new Builder();
        builder.scheme(URL_SCHEME);
        builder.authority(str);
        builder.path(str2);
        for (String str3 : bundle.keySet()) {
            Object obj = bundle.get(str3);
            if (obj instanceof String) {
                builder.appendQueryParameter(str3, (String) obj);
            }
        }
        return builder.build();
    }

    public static void clearCaches(Context context) {
        ImageDownloader.clearCache(context);
    }

    private static void clearCookiesForDomain(Context context, String str) {
        CookieSyncManager.createInstance(context).sync();
        CookieManager instance = CookieManager.getInstance();
        String cookie = instance.getCookie(str);
        if (cookie != null) {
            for (String split : cookie.split(";")) {
                String[] split2 = split.split("=");
                if (split2.length > 0) {
                    instance.setCookie(str, split2[0].trim() + "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
                }
            }
            instance.removeExpiredCookie();
        }
    }

    public static void clearFacebookCookies(Context context) {
        clearCookiesForDomain(context, "facebook.com");
        clearCookiesForDomain(context, ".facebook.com");
        clearCookiesForDomain(context, "https://facebook.com");
        clearCookiesForDomain(context, "https://.facebook.com");
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static String coerceValueIfNullOrEmpty(String str, String str2) {
        return isNullOrEmpty(str) ? str2 : str;
    }

    static Map<String, Object> convertJSONObjectToHashMap(JSONObject jSONObject) {
        Map hashMap = new HashMap();
        JSONArray names = jSONObject.names();
        for (int i = 0; i < names.length(); i++) {
            try {
                String string = names.getString(i);
                Object obj = jSONObject.get(string);
                if (obj instanceof JSONObject) {
                    obj = convertJSONObjectToHashMap((JSONObject) obj);
                }
                hashMap.put(string, obj);
            } catch (JSONException e) {
            }
        }
        return hashMap;
    }

    public static void deleteDirectory(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                for (File deleteDirectory : file.listFiles()) {
                    deleteDirectory(deleteDirectory);
                }
            }
            file.delete();
        }
    }

    public static void disconnectQuietly(URLConnection uRLConnection) {
        if (uRLConnection instanceof HttpURLConnection) {
            ((HttpURLConnection) uRLConnection).disconnect();
        }
    }

    public static String getActivityName(Context context) {
        return context == null ? "null" : context == context.getApplicationContext() ? "unknown" : context.getClass().getSimpleName();
    }

    private static GraphObject getAppSettingsQueryResponse(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(APPLICATION_FIELDS, TextUtils.join(",", APP_SETTING_FIELDS));
        Request newGraphPathRequest = Request.newGraphPathRequest(null, str, null);
        newGraphPathRequest.setSkipClientToken(true);
        newGraphPathRequest.setParameters(bundle);
        return newGraphPathRequest.executeAndWait().getGraphObject();
    }

    public static DialogFeatureConfig getDialogFeatureConfig(String str, String str2, String str3) {
        if (isNullOrEmpty(str2) || isNullOrEmpty(str3)) {
            return null;
        }
        FetchedAppSettings fetchedAppSettings = (FetchedAppSettings) fetchedAppSettings.get(str);
        if (fetchedAppSettings != null) {
            Map map = (Map) fetchedAppSettings.getDialogConfigurations().get(str2);
            if (map != null) {
                return (DialogFeatureConfig) map.get(str3);
            }
        }
        return null;
    }

    public static String getHashedDeviceAndAppID(Context context, String str) {
        String string = Secure.getString(context.getContentResolver(), ServerParameters.ANDROID_ID);
        return string == null ? null : sha1hash(string + str);
    }

    public static String getMetadataApplicationId(Context context) {
        Validate.notNull(context, "context");
        Settings.loadDefaultsFromMetadata(context);
        return Settings.getApplicationId();
    }

    public static Method getMethodQuietly(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public static Method getMethodQuietly(String str, String str2, Class<?>... clsArr) {
        try {
            return getMethodQuietly(Class.forName(str), str2, (Class[]) clsArr);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static Object getStringPropertyAsJSON(JSONObject jSONObject, String str, String str2) {
        Object opt = jSONObject.opt(str);
        Object nextValue = (opt == null || !(opt instanceof String)) ? opt : new JSONTokener((String) opt).nextValue();
        if (nextValue == null || (nextValue instanceof JSONObject) || (nextValue instanceof JSONArray)) {
            return nextValue;
        }
        if (str2 != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt(str2, nextValue);
            return jSONObject2;
        }
        throw new FacebookException("Got an unexpected non-JSON object.");
    }

    private static String hashBytes(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        byte[] digest = messageDigest.digest();
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : digest) {
            stringBuilder.append(Integer.toHexString((b >> 4) & 15));
            stringBuilder.append(Integer.toHexString((b >> 0) & 15));
        }
        return stringBuilder.toString();
    }

    private static String hashWithAlgorithm(String str, String str2) {
        return hashWithAlgorithm(str, str2.getBytes());
    }

    private static String hashWithAlgorithm(String str, byte[] bArr) {
        try {
            return hashBytes(MessageDigest.getInstance(str), bArr);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static int[] intersectRanges(int[] iArr, int[] iArr2) {
        int i = 0;
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null) {
            return iArr;
        }
        int[] iArr3 = new int[(iArr.length + iArr2.length)];
        int i2 = 0;
        int i3 = 0;
        while (i2 < iArr.length && i < iArr2.length) {
            int i4 = iArr[i2];
            int i5 = iArr2[i];
            int i6 = i2 < iArr.length + -1 ? iArr[i2 + 1] : Integer.MAX_VALUE;
            int i7 = i < iArr2.length + -1 ? iArr2[i + 1] : Integer.MAX_VALUE;
            if (i4 < i5) {
                if (i6 <= i5) {
                    i2 += 2;
                    i7 = Integer.MAX_VALUE;
                    i5 = Integer.MIN_VALUE;
                } else if (i6 > i7) {
                    i += 2;
                } else {
                    i2 += 2;
                    i7 = i6;
                }
            } else if (i7 <= i4) {
                i += 2;
                i7 = Integer.MAX_VALUE;
                i5 = Integer.MIN_VALUE;
            } else if (i7 > i6) {
                i2 += 2;
                i7 = i6;
                i5 = i4;
            } else {
                i += 2;
                i5 = i4;
            }
            if (i5 != Integer.MIN_VALUE) {
                i6 = i3 + 1;
                iArr3[i3] = i5;
                if (i7 == Integer.MAX_VALUE) {
                    i3 = i6;
                    break;
                }
                i3 = i6 + 1;
                iArr3[i6] = i7;
            }
        }
        return Arrays.copyOf(iArr3, i3);
    }

    public static Object invokeMethodQuietly(Object obj, Method method, Object... objArr) {
        Object obj2 = null;
        try {
            obj2 = method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e2) {
        }
        return obj2;
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static <T> boolean isNullOrEmpty(Collection<T> collection) {
        return collection == null || collection.size() == 0;
    }

    public static <T> boolean isSubset(Collection<T> collection, Collection<T> collection2) {
        if (collection2 == null || collection2.size() == 0) {
            return collection == null || collection.size() == 0;
        } else {
            HashSet hashSet = new HashSet(collection2);
            for (T contains : collection) {
                if (!hashSet.contains(contains)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void loadAppSettingsAsync(final Context context, final String str) {
        JSONObject jSONObject = null;
        if (!isNullOrEmpty(str) && !fetchedAppSettings.containsKey(str) && initialAppSettingsLoadTask == null) {
            final String format = String.format(APP_SETTINGS_PREFS_KEY_FORMAT, new Object[]{str});
            initialAppSettingsLoadTask = new AsyncTask<Void, Void, GraphObject>() {
                protected GraphObject doInBackground(Void... voidArr) {
                    return Utility.getAppSettingsQueryResponse(str);
                }

                protected void onPostExecute(GraphObject graphObject) {
                    if (graphObject != null) {
                        JSONObject innerJSONObject = graphObject.getInnerJSONObject();
                        Utility.parseAppSettingsFromJSON(str, innerJSONObject);
                        context.getSharedPreferences(Utility.APP_SETTINGS_PREFS_STORE, 0).edit().putString(format, innerJSONObject.toString()).apply();
                    }
                    Utility.initialAppSettingsLoadTask = null;
                }
            };
            initialAppSettingsLoadTask.execute((Void[]) null);
            format = context.getSharedPreferences(APP_SETTINGS_PREFS_STORE, 0).getString(format, null);
            if (!isNullOrEmpty(format)) {
                try {
                    jSONObject = new JSONObject(format);
                } catch (Exception e) {
                    logd(LOG_TAG, e);
                }
                if (jSONObject != null) {
                    parseAppSettingsFromJSON(str, jSONObject);
                }
            }
        }
    }

    public static void logd(String str, Exception exception) {
        if (Settings.isDebugEnabled() && str != null && exception != null) {
            Log.d(str, exception.getClass().getSimpleName() + ": " + exception.getMessage());
        }
    }

    public static void logd(String str, String str2) {
        if (Settings.isDebugEnabled() && str != null && str2 != null) {
            Log.d(str, str2);
        }
    }

    public static void logd(String str, String str2, Throwable th) {
        if (Settings.isDebugEnabled() && !isNullOrEmpty(str)) {
            Log.d(str, str2, th);
        }
    }

    static String md5hash(String str) {
        return hashWithAlgorithm(HASH_ALGORITHM_MD5, str);
    }

    private static FetchedAppSettings parseAppSettingsFromJSON(String str, JSONObject jSONObject) {
        FetchedAppSettings fetchedAppSettings = new FetchedAppSettings(jSONObject.optBoolean(APP_SETTING_SUPPORTS_ATTRIBUTION, false), jSONObject.optBoolean(APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING, false), jSONObject.optString(APP_SETTING_NUX_CONTENT, ""), jSONObject.optBoolean(APP_SETTING_NUX_ENABLED, false), parseDialogConfigurations(jSONObject.optJSONObject(APP_SETTING_DIALOG_CONFIGS)));
        fetchedAppSettings.put(str, fetchedAppSettings);
        return fetchedAppSettings;
    }

    private static Map<String, Map<String, DialogFeatureConfig>> parseDialogConfigurations(JSONObject jSONObject) {
        Map hashMap = new HashMap();
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    DialogFeatureConfig access$400 = DialogFeatureConfig.parseDialogConfig(optJSONArray.optJSONObject(i));
                    if (access$400 != null) {
                        String dialogName = access$400.getDialogName();
                        Map map = (Map) hashMap.get(dialogName);
                        if (map == null) {
                            map = new HashMap();
                            hashMap.put(dialogName, map);
                        }
                        map.put(access$400.getFeatureName(), access$400);
                    }
                }
            }
        }
        return hashMap;
    }

    public static Bundle parseUrlQueryString(String str) {
        Bundle bundle = new Bundle();
        if (!isNullOrEmpty(str)) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                try {
                    if (split2.length == 2) {
                        bundle.putString(URLDecoder.decode(split2[0], UTF8), URLDecoder.decode(split2[1], UTF8));
                    } else if (split2.length == 1) {
                        bundle.putString(URLDecoder.decode(split2[0], UTF8), "");
                    }
                } catch (Exception e) {
                    logd(LOG_TAG, e);
                }
            }
        }
        return bundle;
    }

    public static void putObjectInBundle(Bundle bundle, String str, Object obj) {
        if (obj instanceof String) {
            bundle.putString(str, (String) obj);
        } else if (obj instanceof Parcelable) {
            bundle.putParcelable(str, (Parcelable) obj);
        } else if (obj instanceof byte[]) {
            bundle.putByteArray(str, (byte[]) obj);
        } else {
            throw new FacebookException("attempted to add unsupported type to Bundle");
        }
    }

    public static FetchedAppSettings queryAppSettings(String str, boolean z) {
        if (!z && fetchedAppSettings.containsKey(str)) {
            return (FetchedAppSettings) fetchedAppSettings.get(str);
        }
        GraphObject appSettingsQueryResponse = getAppSettingsQueryResponse(str);
        return appSettingsQueryResponse == null ? null : parseAppSettingsFromJSON(str, appSettingsQueryResponse.getInnerJSONObject());
    }

    public static String readStreamToString(InputStream inputStream) {
        Closeable inputStreamReader;
        Throwable th;
        Closeable closeable = null;
        try {
            Closeable bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream);
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    char[] cArr = new char[2048];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (read != -1) {
                            stringBuilder.append(cArr, 0, read);
                        } else {
                            String stringBuilder2 = stringBuilder.toString();
                            closeQuietly(bufferedInputStream);
                            closeQuietly(inputStreamReader);
                            return stringBuilder2;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    closeable = bufferedInputStream;
                    closeQuietly(closeable);
                    closeQuietly(inputStreamReader);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader = null;
                closeable = bufferedInputStream;
                closeQuietly(closeable);
                closeQuietly(inputStreamReader);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStreamReader = null;
            closeQuietly(closeable);
            closeQuietly(inputStreamReader);
            throw th;
        }
    }

    public static boolean safeGetBooleanFromResponse(GraphObject graphObject, String str) {
        Boolean valueOf = Boolean.valueOf(false);
        if (graphObject != null) {
            valueOf = graphObject.getProperty(str);
        }
        if (!(valueOf instanceof Boolean)) {
            valueOf = Boolean.valueOf(false);
        }
        return valueOf.booleanValue();
    }

    public static String safeGetStringFromResponse(GraphObject graphObject, String str) {
        String str2 = "";
        if (graphObject != null) {
            str2 = graphObject.getProperty(str);
        }
        if (!(str2 instanceof String)) {
            str2 = "";
        }
        return str2;
    }

    public static void setAppEventAttributionParameters(GraphObject graphObject, AttributionIdentifiers attributionIdentifiers, String str, boolean z) {
        boolean z2 = true;
        if (!(attributionIdentifiers == null || attributionIdentifiers.getAttributionId() == null)) {
            graphObject.setProperty("attribution", attributionIdentifiers.getAttributionId());
        }
        if (attributionIdentifiers != null && attributionIdentifiers.getAndroidAdvertiserId() != null) {
            graphObject.setProperty("advertiser_id", attributionIdentifiers.getAndroidAdvertiserId());
            graphObject.setProperty("advertiser_tracking_enabled", Boolean.valueOf(!attributionIdentifiers.isTrackingLimited()));
        } else if (str != null) {
            graphObject.setProperty("advertiser_id", str);
        }
        String str2 = "application_tracking_enabled";
        if (z) {
            z2 = false;
        }
        graphObject.setProperty(str2, Boolean.valueOf(z2));
    }

    public static void setAppEventExtendedDeviceInfoParameters(GraphObject graphObject, Context context) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(EXTRA_APP_EVENTS_INFO_FORMAT_VERSION);
        String packageName = context.getPackageName();
        int i = -1;
        Object obj = "";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            i = packageInfo.versionCode;
            obj = packageInfo.versionName;
        } catch (NameNotFoundException e) {
        }
        jSONArray.put(packageName);
        jSONArray.put(i);
        jSONArray.put(obj);
        graphObject.setProperty("extinfo", jSONArray.toString());
    }

    static String sha1hash(String str) {
        return hashWithAlgorithm(HASH_ALGORITHM_SHA1, str);
    }

    static String sha1hash(byte[] bArr) {
        return hashWithAlgorithm(HASH_ALGORITHM_SHA1, bArr);
    }

    public static boolean stringsEqualOrEmpty(String str, String str2) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        return (isEmpty && isEmpty2) ? true : (isEmpty || isEmpty2) ? false : str.equals(str2);
    }

    public static JSONArray tryGetJSONArrayFromResponse(GraphObject graphObject, String str) {
        if (graphObject == null) {
            return null;
        }
        Object property = graphObject.getProperty(str);
        return !(property instanceof JSONArray) ? null : (JSONArray) property;
    }

    public static JSONObject tryGetJSONObjectFromResponse(GraphObject graphObject, String str) {
        if (graphObject == null) {
            return null;
        }
        Object property = graphObject.getProperty(str);
        return !(property instanceof JSONObject) ? null : (JSONObject) property;
    }

    public static <T> Collection<T> unmodifiableCollection(T... tArr) {
        return Collections.unmodifiableCollection(Arrays.asList(tArr));
    }
}
