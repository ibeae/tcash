package com.facebook;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.facebook.Request.Callback;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.FetchedAppSettings;
import com.facebook.internal.Validate;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObject.Factory;
import com.facebook.widget.PlacePickerFragment;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.C0005c;

public class AppEventsLogger {
    public static final String ACTION_APP_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_FLUSHED";
    public static final String APP_EVENTS_EXTRA_FLUSH_RESULT = "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT";
    public static final String APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED";
    private static final int APP_SUPPORTS_ATTRIBUTION_ID_RECHECK_PERIOD_IN_SECONDS = 86400;
    private static final int FLUSH_APP_SESSION_INFO_IN_SECONDS = 30;
    private static final int FLUSH_PERIOD_IN_SECONDS = 15;
    private static final int NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER = 100;
    private static final String SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT = "_fbSourceApplicationHasBeenSet";
    private static final String TAG = AppEventsLogger.class.getCanonicalName();
    private static Context applicationContext;
    private static ScheduledThreadPoolExecutor backgroundExecutor;
    private static FlushBehavior flushBehavior = FlushBehavior.AUTO;
    private static String hashedDeviceAndAppId;
    private static boolean isOpenedByApplink;
    private static boolean requestInFlight;
    private static String sourceApplication;
    private static Map<AccessTokenAppIdPair, SessionEventsState> stateMap = new ConcurrentHashMap();
    private static Object staticLock = new Object();
    private final AccessTokenAppIdPair accessTokenAppId;
    private final Context context;

    static class C03773 implements Runnable {
        C03773() {
        }

        public void run() {
            if (AppEventsLogger.getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
                AppEventsLogger.flushAndWait(FlushReason.TIMER);
            }
        }
    }

    static class C03784 implements Runnable {
        C03784() {
        }

        public void run() {
            Set<String> hashSet = new HashSet();
            synchronized (AppEventsLogger.staticLock) {
                for (AccessTokenAppIdPair applicationId : AppEventsLogger.stateMap.keySet()) {
                    hashSet.add(applicationId.getApplicationId());
                }
            }
            for (String queryAppSettings : hashSet) {
                Utility.queryAppSettings(queryAppSettings, true);
            }
        }
    }

    private static class AccessTokenAppIdPair implements Serializable {
        private static final long serialVersionUID = 1;
        private final String accessToken;
        private final String applicationId;

        private static class SerializationProxyV1 implements Serializable {
            private static final long serialVersionUID = -2488473066578201069L;
            private final String accessToken;
            private final String appId;

            private SerializationProxyV1(String str, String str2) {
                this.accessToken = str;
                this.appId = str2;
            }

            private Object readResolve() {
                return new AccessTokenAppIdPair(this.accessToken, this.appId);
            }
        }

        AccessTokenAppIdPair(Session session) {
            this(session.getAccessToken(), session.getApplicationId());
        }

        AccessTokenAppIdPair(String str, String str2) {
            if (Utility.isNullOrEmpty(str)) {
                str = null;
            }
            this.accessToken = str;
            this.applicationId = str2;
        }

        private Object writeReplace() {
            return new SerializationProxyV1(this.accessToken, this.applicationId);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof AccessTokenAppIdPair)) {
                return false;
            }
            AccessTokenAppIdPair accessTokenAppIdPair = (AccessTokenAppIdPair) obj;
            return Utility.areObjectsEqual(accessTokenAppIdPair.accessToken, this.accessToken) && Utility.areObjectsEqual(accessTokenAppIdPair.applicationId, this.applicationId);
        }

        String getAccessToken() {
            return this.accessToken;
        }

        String getApplicationId() {
            return this.applicationId;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = this.accessToken == null ? 0 : this.accessToken.hashCode();
            if (this.applicationId != null) {
                i = this.applicationId.hashCode();
            }
            return hashCode ^ i;
        }
    }

    static class AppEvent implements Serializable {
        private static final long serialVersionUID = 1;
        private static final HashSet<String> validatedIdentifiers = new HashSet();
        private boolean isImplicit;
        private JSONObject jsonObject;
        private String name;

        private static class SerializationProxyV1 implements Serializable {
            private static final long serialVersionUID = -2488473066578201069L;
            private final boolean isImplicit;
            private final String jsonString;

            private SerializationProxyV1(String str, boolean z) {
                this.jsonString = str;
                this.isImplicit = z;
            }

            private Object readResolve() {
                return new AppEvent(this.jsonString, this.isImplicit);
            }
        }

        public AppEvent(Context context, String str, Double d, Bundle bundle, boolean z) {
            try {
                validateIdentifier(str);
                this.name = str;
                this.isImplicit = z;
                this.jsonObject = new JSONObject();
                this.jsonObject.put("_eventName", str);
                this.jsonObject.put("_logTime", System.currentTimeMillis() / 1000);
                this.jsonObject.put("_ui", Utility.getActivityName(context));
                if (d != null) {
                    this.jsonObject.put("_valueToSum", d.doubleValue());
                }
                if (this.isImplicit) {
                    this.jsonObject.put("_implicitlyLogged", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                }
                String appVersion = Settings.getAppVersion();
                if (appVersion != null) {
                    this.jsonObject.put("_appVersion", appVersion);
                }
                if (bundle != null) {
                    for (String appVersion2 : bundle.keySet()) {
                        validateIdentifier(appVersion2);
                        Object obj = bundle.get(appVersion2);
                        if ((obj instanceof String) || (obj instanceof Number)) {
                            this.jsonObject.put(appVersion2, obj.toString());
                        } else {
                            throw new FacebookException(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", new Object[]{obj, appVersion2}));
                        }
                    }
                }
                if (!this.isImplicit) {
                    Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Created app event '%s'", this.jsonObject.toString());
                }
            } catch (JSONException e) {
                Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "JSON encoding for app event failed: '%s'", e.toString());
                this.jsonObject = null;
            } catch (FacebookException e2) {
                Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Invalid app event name or parameter:", e2.toString());
                this.jsonObject = null;
            }
        }

        private AppEvent(String str, boolean z) {
            this.jsonObject = new JSONObject(str);
            this.isImplicit = z;
        }

        private void validateIdentifier(String str) {
            String str2 = "^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$";
            if (str == null || str.length() == 0 || str.length() > 40) {
                if (str == null) {
                    str = "<None Provided>";
                }
                throw new FacebookException(String.format("Identifier '%s' must be less than %d characters", new Object[]{str, Integer.valueOf(40)}));
            }
            synchronized (validatedIdentifiers) {
                boolean contains = validatedIdentifiers.contains(str);
            }
            if (!contains) {
                if (str.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$")) {
                    synchronized (validatedIdentifiers) {
                        validatedIdentifiers.add(str);
                    }
                    return;
                }
                throw new FacebookException(String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", new Object[]{str}));
            }
        }

        private Object writeReplace() {
            return new SerializationProxyV1(this.jsonObject.toString(), this.isImplicit);
        }

        public boolean getIsImplicit() {
            return this.isImplicit;
        }

        public JSONObject getJSONObject() {
            return this.jsonObject;
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return String.format("\"%s\", implicit: %b, json: %s", new Object[]{this.jsonObject.optString("_eventName"), Boolean.valueOf(this.isImplicit), this.jsonObject.toString()});
        }
    }

    public enum FlushBehavior {
        AUTO,
        EXPLICIT_ONLY
    }

    private enum FlushReason {
        EXPLICIT,
        TIMER,
        SESSION_CHANGE,
        PERSISTED_EVENTS,
        EVENT_THRESHOLD,
        EAGER_FLUSHING_EVENT
    }

    private enum FlushResult {
        SUCCESS,
        SERVER_ERROR,
        NO_CONNECTIVITY,
        UNKNOWN_ERROR
    }

    private static class FlushStatistics {
        public int numEvents;
        public FlushResult result;

        private FlushStatistics() {
            this.numEvents = 0;
            this.result = FlushResult.SUCCESS;
        }
    }

    static class PersistedAppSessionInfo {
        private static final String PERSISTED_SESSION_INFO_FILENAME = "AppEventsLogger.persistedsessioninfo";
        private static final Runnable appSessionInfoFlushRunnable = new C03821();
        private static Map<AccessTokenAppIdPair, FacebookTimeSpentData> appSessionInfoMap;
        private static boolean hasChanges = false;
        private static boolean isLoaded = false;
        private static final Object staticLock = new Object();

        static class C03821 implements Runnable {
            C03821() {
            }

            public void run() {
                PersistedAppSessionInfo.saveAppSessionInformation(AppEventsLogger.applicationContext);
            }
        }

        PersistedAppSessionInfo() {
        }

        private static FacebookTimeSpentData getTimeSpentData(Context context, AccessTokenAppIdPair accessTokenAppIdPair) {
            restoreAppSessionInformation(context);
            FacebookTimeSpentData facebookTimeSpentData = (FacebookTimeSpentData) appSessionInfoMap.get(accessTokenAppIdPair);
            if (facebookTimeSpentData != null) {
                return facebookTimeSpentData;
            }
            facebookTimeSpentData = new FacebookTimeSpentData();
            appSessionInfoMap.put(accessTokenAppIdPair, facebookTimeSpentData);
            return facebookTimeSpentData;
        }

        static void onResume(Context context, AccessTokenAppIdPair accessTokenAppIdPair, AppEventsLogger appEventsLogger, long j, String str) {
            synchronized (staticLock) {
                getTimeSpentData(context, accessTokenAppIdPair).onResume(appEventsLogger, j, str);
                onTimeSpentDataUpdate();
            }
        }

        static void onSuspend(Context context, AccessTokenAppIdPair accessTokenAppIdPair, AppEventsLogger appEventsLogger, long j) {
            synchronized (staticLock) {
                getTimeSpentData(context, accessTokenAppIdPair).onSuspend(appEventsLogger, j);
                onTimeSpentDataUpdate();
            }
        }

        private static void onTimeSpentDataUpdate() {
            if (!hasChanges) {
                hasChanges = true;
                AppEventsLogger.backgroundExecutor.schedule(appSessionInfoFlushRunnable, 30, TimeUnit.SECONDS);
            }
        }

        private static void restoreAppSessionInformation(Context context) {
            Closeable objectInputStream;
            Exception e;
            Closeable closeable = null;
            synchronized (staticLock) {
                if (!isLoaded) {
                    try {
                        objectInputStream = new ObjectInputStream(context.openFileInput(PERSISTED_SESSION_INFO_FILENAME));
                        try {
                            appSessionInfoMap = (HashMap) objectInputStream.readObject();
                            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "App session info loaded");
                            Utility.closeQuietly(objectInputStream);
                            context.deleteFile(PERSISTED_SESSION_INFO_FILENAME);
                            if (appSessionInfoMap == null) {
                                appSessionInfoMap = new HashMap();
                            }
                            isLoaded = true;
                            hasChanges = false;
                        } catch (FileNotFoundException e2) {
                            closeable = objectInputStream;
                            Utility.closeQuietly(closeable);
                            context.deleteFile(PERSISTED_SESSION_INFO_FILENAME);
                            if (appSessionInfoMap == null) {
                                appSessionInfoMap = new HashMap();
                            }
                            isLoaded = true;
                            hasChanges = false;
                        } catch (Exception e3) {
                            e = e3;
                            try {
                                Log.d(AppEventsLogger.TAG, "Got unexpected exception: " + e.toString());
                                Utility.closeQuietly(objectInputStream);
                                context.deleteFile(PERSISTED_SESSION_INFO_FILENAME);
                                if (appSessionInfoMap == null) {
                                    appSessionInfoMap = new HashMap();
                                }
                                isLoaded = true;
                                hasChanges = false;
                            } catch (Throwable th) {
                                Throwable th2 = th;
                                Utility.closeQuietly(objectInputStream);
                                context.deleteFile(PERSISTED_SESSION_INFO_FILENAME);
                                if (appSessionInfoMap == null) {
                                    appSessionInfoMap = new HashMap();
                                }
                                isLoaded = true;
                                hasChanges = false;
                                throw th2;
                            }
                        }
                    } catch (FileNotFoundException e4) {
                        Utility.closeQuietly(closeable);
                        context.deleteFile(PERSISTED_SESSION_INFO_FILENAME);
                        if (appSessionInfoMap == null) {
                            appSessionInfoMap = new HashMap();
                        }
                        isLoaded = true;
                        hasChanges = false;
                    } catch (Exception e5) {
                        Exception exception = e5;
                        objectInputStream = null;
                        e = exception;
                        Log.d(AppEventsLogger.TAG, "Got unexpected exception: " + e.toString());
                        Utility.closeQuietly(objectInputStream);
                        context.deleteFile(PERSISTED_SESSION_INFO_FILENAME);
                        if (appSessionInfoMap == null) {
                            appSessionInfoMap = new HashMap();
                        }
                        isLoaded = true;
                        hasChanges = false;
                    } catch (Throwable th3) {
                        Throwable th4 = th3;
                        objectInputStream = null;
                        th2 = th4;
                        Utility.closeQuietly(objectInputStream);
                        context.deleteFile(PERSISTED_SESSION_INFO_FILENAME);
                        if (appSessionInfoMap == null) {
                            appSessionInfoMap = new HashMap();
                        }
                        isLoaded = true;
                        hasChanges = false;
                        throw th2;
                    }
                }
            }
        }

        static void saveAppSessionInformation(Context context) {
            Exception e;
            Throwable th;
            synchronized (staticLock) {
                if (hasChanges) {
                    Closeable objectOutputStream;
                    try {
                        objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(context.openFileOutput(PERSISTED_SESSION_INFO_FILENAME, 0)));
                        try {
                            objectOutputStream.writeObject(appSessionInfoMap);
                            hasChanges = false;
                            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "App session info saved");
                            Utility.closeQuietly(objectOutputStream);
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                Log.d(AppEventsLogger.TAG, "Got unexpected exception: " + e.toString());
                                Utility.closeQuietly(objectOutputStream);
                            } catch (Throwable th2) {
                                th = th2;
                                Utility.closeQuietly(objectOutputStream);
                                throw th;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        objectOutputStream = null;
                        Log.d(AppEventsLogger.TAG, "Got unexpected exception: " + e.toString());
                        Utility.closeQuietly(objectOutputStream);
                    } catch (Throwable th3) {
                        th = th3;
                        objectOutputStream = null;
                        Utility.closeQuietly(objectOutputStream);
                        throw th;
                    }
                }
            }
        }
    }

    static class PersistedEvents {
        static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
        private static Object staticLock = new Object();
        private Context context;
        private HashMap<AccessTokenAppIdPair, List<AppEvent>> persistedEvents = new HashMap();

        private PersistedEvents(Context context) {
            this.context = context;
        }

        public static void persistEvents(Context context, AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState sessionEventsState) {
            Map hashMap = new HashMap();
            hashMap.put(accessTokenAppIdPair, sessionEventsState);
            persistEvents(context, hashMap);
        }

        public static void persistEvents(Context context, Map<AccessTokenAppIdPair, SessionEventsState> map) {
            synchronized (staticLock) {
                PersistedEvents readAndClearStore = readAndClearStore(context);
                for (Entry entry : map.entrySet()) {
                    List eventsToPersist = ((SessionEventsState) entry.getValue()).getEventsToPersist();
                    if (eventsToPersist.size() != 0) {
                        readAndClearStore.addEvents((AccessTokenAppIdPair) entry.getKey(), eventsToPersist);
                    }
                }
                readAndClearStore.write();
            }
        }

        public static PersistedEvents readAndClearStore(Context context) {
            PersistedEvents persistedEvents;
            synchronized (staticLock) {
                persistedEvents = new PersistedEvents(context);
                persistedEvents.readAndClearStore();
            }
            return persistedEvents;
        }

        private void readAndClearStore() {
            Exception e;
            Throwable th;
            Closeable closeable = null;
            Closeable objectInputStream;
            try {
                objectInputStream = new ObjectInputStream(new BufferedInputStream(this.context.openFileInput(PERSISTED_EVENTS_FILENAME)));
                try {
                    HashMap hashMap = (HashMap) objectInputStream.readObject();
                    this.context.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                    this.persistedEvents = hashMap;
                    Utility.closeQuietly(objectInputStream);
                } catch (FileNotFoundException e2) {
                    closeable = objectInputStream;
                    Utility.closeQuietly(closeable);
                } catch (Exception e3) {
                    e = e3;
                    try {
                        Log.d(AppEventsLogger.TAG, "Got unexpected exception: " + e.toString());
                        Utility.closeQuietly(objectInputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        Utility.closeQuietly(objectInputStream);
                        throw th;
                    }
                }
            } catch (FileNotFoundException e4) {
                Utility.closeQuietly(closeable);
            } catch (Exception e5) {
                Exception exception = e5;
                objectInputStream = null;
                e = exception;
                Log.d(AppEventsLogger.TAG, "Got unexpected exception: " + e.toString());
                Utility.closeQuietly(objectInputStream);
            } catch (Throwable th3) {
                Throwable th4 = th3;
                objectInputStream = null;
                th = th4;
                Utility.closeQuietly(objectInputStream);
                throw th;
            }
        }

        private void write() {
            Closeable objectOutputStream;
            Exception e;
            Throwable th;
            try {
                objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(this.context.openFileOutput(PERSISTED_EVENTS_FILENAME, 0)));
                try {
                    objectOutputStream.writeObject(this.persistedEvents);
                    Utility.closeQuietly(objectOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        Log.d(AppEventsLogger.TAG, "Got unexpected exception: " + e.toString());
                        Utility.closeQuietly(objectOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        Utility.closeQuietly(objectOutputStream);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                objectOutputStream = null;
                Log.d(AppEventsLogger.TAG, "Got unexpected exception: " + e.toString());
                Utility.closeQuietly(objectOutputStream);
            } catch (Throwable th3) {
                th = th3;
                objectOutputStream = null;
                Utility.closeQuietly(objectOutputStream);
                throw th;
            }
        }

        public void addEvents(AccessTokenAppIdPair accessTokenAppIdPair, List<AppEvent> list) {
            if (!this.persistedEvents.containsKey(accessTokenAppIdPair)) {
                this.persistedEvents.put(accessTokenAppIdPair, new ArrayList());
            }
            ((List) this.persistedEvents.get(accessTokenAppIdPair)).addAll(list);
        }

        public List<AppEvent> getEvents(AccessTokenAppIdPair accessTokenAppIdPair) {
            return (List) this.persistedEvents.get(accessTokenAppIdPair);
        }

        public Set<AccessTokenAppIdPair> keySet() {
            return this.persistedEvents.keySet();
        }
    }

    static class SessionEventsState {
        public static final String ENCODED_EVENTS_KEY = "encoded_events";
        public static final String EVENT_COUNT_KEY = "event_count";
        public static final String NUM_SKIPPED_KEY = "num_skipped";
        private final int MAX_ACCUMULATED_LOG_EVENTS = PlacePickerFragment.DEFAULT_RADIUS_IN_METERS;
        private List<AppEvent> accumulatedEvents = new ArrayList();
        private AttributionIdentifiers attributionIdentifiers;
        private String hashedDeviceAndAppId;
        private List<AppEvent> inFlightEvents = new ArrayList();
        private int numSkippedEventsDueToFullBuffer;
        private String packageName;

        public SessionEventsState(AttributionIdentifiers attributionIdentifiers, String str, String str2) {
            this.attributionIdentifiers = attributionIdentifiers;
            this.packageName = str;
            this.hashedDeviceAndAppId = str2;
        }

        private byte[] getStringAsByteArray(String str) {
            byte[] bArr = null;
            try {
                bArr = str.getBytes("UTF-8");
            } catch (Exception e) {
                Utility.logd("Encoding exception: ", e);
            }
            return bArr;
        }

        private void populateRequest(Request request, int i, JSONArray jSONArray, boolean z, boolean z2) {
            GraphObject create = Factory.create();
            create.setProperty("event", "CUSTOM_APP_EVENTS");
            if (this.numSkippedEventsDueToFullBuffer > 0) {
                create.setProperty("num_skipped_events", Integer.valueOf(i));
            }
            if (z) {
                Utility.setAppEventAttributionParameters(create, this.attributionIdentifiers, this.hashedDeviceAndAppId, z2);
            }
            try {
                Utility.setAppEventExtendedDeviceInfoParameters(create, AppEventsLogger.applicationContext);
            } catch (Exception e) {
            }
            create.setProperty("application_package_name", this.packageName);
            request.setGraphObject(create);
            Bundle parameters = request.getParameters();
            if (parameters == null) {
                parameters = new Bundle();
            }
            String jSONArray2 = jSONArray.toString();
            if (jSONArray2 != null) {
                parameters.putByteArray("custom_events_file", getStringAsByteArray(jSONArray2));
                request.setTag(jSONArray2);
            }
            request.setParameters(parameters);
        }

        public synchronized void accumulatePersistedEvents(List<AppEvent> list) {
            this.accumulatedEvents.addAll(list);
        }

        public synchronized void addEvent(AppEvent appEvent) {
            if (this.accumulatedEvents.size() + this.inFlightEvents.size() >= PlacePickerFragment.DEFAULT_RADIUS_IN_METERS) {
                this.numSkippedEventsDueToFullBuffer++;
            } else {
                this.accumulatedEvents.add(appEvent);
            }
        }

        public synchronized void clearInFlightAndStats(boolean z) {
            if (z) {
                this.accumulatedEvents.addAll(this.inFlightEvents);
            }
            this.inFlightEvents.clear();
            this.numSkippedEventsDueToFullBuffer = 0;
        }

        public synchronized int getAccumulatedEventCount() {
            return this.accumulatedEvents.size();
        }

        public synchronized List<AppEvent> getEventsToPersist() {
            List<AppEvent> list;
            list = this.accumulatedEvents;
            this.accumulatedEvents = new ArrayList();
            return list;
        }

        public int populateRequest(Request request, boolean z, boolean z2, boolean z3) {
            synchronized (this) {
                int i = this.numSkippedEventsDueToFullBuffer;
                this.inFlightEvents.addAll(this.accumulatedEvents);
                this.accumulatedEvents.clear();
                JSONArray jSONArray = new JSONArray();
                for (AppEvent appEvent : this.inFlightEvents) {
                    if (z || !appEvent.getIsImplicit()) {
                        jSONArray.put(appEvent.getJSONObject());
                    }
                }
                if (jSONArray.length() == 0) {
                    return 0;
                }
                populateRequest(request, i, jSONArray, z2, z3);
                return jSONArray.length();
            }
        }
    }

    private AppEventsLogger(Context context, String str, Session session) {
        Validate.notNull(context, "context");
        this.context = context;
        if (session == null) {
            session = Session.getActiveSession();
        }
        if (session == null || !(str == null || str.equals(session.getApplicationId()))) {
            if (str == null) {
                str = Utility.getMetadataApplicationId(context);
            }
            this.accessTokenAppId = new AccessTokenAppIdPair(null, str);
        } else {
            this.accessTokenAppId = new AccessTokenAppIdPair(session);
        }
        synchronized (staticLock) {
            if (hashedDeviceAndAppId == null) {
                hashedDeviceAndAppId = Utility.getHashedDeviceAndAppID(context, str);
            }
            if (applicationContext == null) {
                applicationContext = context.getApplicationContext();
            }
        }
        initializeTimersIfNeeded();
    }

    private static int accumulatePersistedEvents() {
        PersistedEvents readAndClearStore = PersistedEvents.readAndClearStore(applicationContext);
        int i = 0;
        for (AccessTokenAppIdPair accessTokenAppIdPair : readAndClearStore.keySet()) {
            SessionEventsState sessionEventsState = getSessionEventsState(applicationContext, accessTokenAppIdPair);
            List events = readAndClearStore.getEvents(accessTokenAppIdPair);
            sessionEventsState.accumulatePersistedEvents(events);
            i = events.size() + i;
        }
        return i;
    }

    public static void activateApp(Context context) {
        Settings.sdkInitialize(context);
        activateApp(context, Utility.getMetadataApplicationId(context));
    }

    public static void activateApp(Context context, String str) {
        if (context == null || str == null) {
            throw new IllegalArgumentException("Both context and applicationId must be non-null");
        }
        if (context instanceof Activity) {
            setSourceApplication((Activity) context);
        } else {
            resetSourceApplication();
            Log.d(AppEventsLogger.class.getName(), "To set source application the context of activateApp must be an instance of Activity");
        }
        Settings.publishInstallAsync(context, str, null);
        final AppEventsLogger appEventsLogger = new AppEventsLogger(context, str, null);
        final long currentTimeMillis = System.currentTimeMillis();
        final String sourceApplication = getSourceApplication();
        backgroundExecutor.execute(new Runnable() {
            public void run() {
                appEventsLogger.logAppSessionResumeEvent(currentTimeMillis, sourceApplication);
            }
        });
    }

    private static FlushStatistics buildAndExecuteRequests(FlushReason flushReason, Set<AccessTokenAppIdPair> set) {
        FlushStatistics flushStatistics = new FlushStatistics();
        boolean limitEventAndDataUsage = Settings.getLimitEventAndDataUsage(applicationContext);
        List<Request> arrayList = new ArrayList();
        for (AccessTokenAppIdPair accessTokenAppIdPair : set) {
            Request buildRequestForSession;
            SessionEventsState sessionEventsState = getSessionEventsState(accessTokenAppIdPair);
            if (sessionEventsState != null) {
                buildRequestForSession = buildRequestForSession(accessTokenAppIdPair, sessionEventsState, limitEventAndDataUsage, flushStatistics);
                if (buildRequestForSession != null) {
                    arrayList.add(buildRequestForSession);
                }
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Flushing %d events due to %s.", Integer.valueOf(flushStatistics.numEvents), flushReason.toString());
        for (Request buildRequestForSession2 : arrayList) {
            buildRequestForSession2.executeAndWait();
        }
        return flushStatistics;
    }

    private static Request buildRequestForSession(final AccessTokenAppIdPair accessTokenAppIdPair, final SessionEventsState sessionEventsState, boolean z, final FlushStatistics flushStatistics) {
        FetchedAppSettings queryAppSettings = Utility.queryAppSettings(accessTokenAppIdPair.getApplicationId(), false);
        final Request newPostRequest = Request.newPostRequest(null, String.format("%s/activities", new Object[]{r0}), null, null);
        Bundle parameters = newPostRequest.getParameters();
        if (parameters == null) {
            parameters = new Bundle();
        }
        parameters.putString("access_token", accessTokenAppIdPair.getAccessToken());
        newPostRequest.setParameters(parameters);
        if (queryAppSettings == null) {
            return null;
        }
        int populateRequest = sessionEventsState.populateRequest(newPostRequest, queryAppSettings.supportsImplicitLogging(), queryAppSettings.supportsAttribution(), z);
        if (populateRequest == 0) {
            return null;
        }
        flushStatistics.numEvents = populateRequest + flushStatistics.numEvents;
        newPostRequest.setCallback(new Callback() {
            public void onCompleted(Response response) {
                AppEventsLogger.handleResponse(accessTokenAppIdPair, newPostRequest, response, sessionEventsState, flushStatistics);
            }
        });
        return newPostRequest;
    }

    public static void deactivateApp(Context context) {
        deactivateApp(context, Utility.getMetadataApplicationId(context));
    }

    public static void deactivateApp(Context context, String str) {
        if (context == null || str == null) {
            throw new IllegalArgumentException("Both context and applicationId must be non-null");
        }
        resetSourceApplication();
        final AppEventsLogger appEventsLogger = new AppEventsLogger(context, str, null);
        final long currentTimeMillis = System.currentTimeMillis();
        backgroundExecutor.execute(new Runnable() {
            public void run() {
                appEventsLogger.logAppSessionSuspendEvent(currentTimeMillis);
            }
        });
    }

    static void eagerFlush() {
        if (getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
            flush(FlushReason.EAGER_FLUSHING_EVENT);
        }
    }

    private static void flush(final FlushReason flushReason) {
        Settings.getExecutor().execute(new Runnable() {
            public void run() {
                AppEventsLogger.flushAndWait(flushReason);
            }
        });
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void flushAndWait(com.facebook.AppEventsLogger.FlushReason r4) {
        /*
        r1 = staticLock;
        monitor-enter(r1);
        r0 = requestInFlight;	 Catch:{ all -> 0x0048 }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r1);	 Catch:{ all -> 0x0048 }
    L_0x0008:
        return;
    L_0x0009:
        r0 = 1;
        requestInFlight = r0;	 Catch:{ all -> 0x0048 }
        r2 = new java.util.HashSet;	 Catch:{ all -> 0x0048 }
        r0 = stateMap;	 Catch:{ all -> 0x0048 }
        r0 = r0.keySet();	 Catch:{ all -> 0x0048 }
        r2.<init>(r0);	 Catch:{ all -> 0x0048 }
        monitor-exit(r1);	 Catch:{ all -> 0x0048 }
        accumulatePersistedEvents();
        r0 = 0;
        r0 = buildAndExecuteRequests(r4, r2);	 Catch:{ Exception -> 0x004b }
    L_0x0020:
        r1 = staticLock;
        monitor-enter(r1);
        r2 = 0;
        requestInFlight = r2;	 Catch:{ all -> 0x0054 }
        monitor-exit(r1);	 Catch:{ all -> 0x0054 }
        if (r0 == 0) goto L_0x0008;
    L_0x0029:
        r1 = new android.content.Intent;
        r2 = "com.facebook.sdk.APP_EVENTS_FLUSHED";
        r1.<init>(r2);
        r2 = "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED";
        r3 = r0.numEvents;
        r1.putExtra(r2, r3);
        r2 = "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT";
        r0 = r0.result;
        r1.putExtra(r2, r0);
        r0 = applicationContext;
        r0 = android.support.v4.p001a.C0035i.m60a(r0);
        r0.m65a(r1);
        goto L_0x0008;
    L_0x0048:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0048 }
        throw r0;
    L_0x004b:
        r1 = move-exception;
        r2 = TAG;
        r3 = "Caught unexpected exception while flushing: ";
        com.facebook.internal.Utility.logd(r2, r3, r1);
        goto L_0x0020;
    L_0x0054:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0054 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AppEventsLogger.flushAndWait(com.facebook.AppEventsLogger$FlushReason):void");
    }

    private static void flushIfNecessary() {
        synchronized (staticLock) {
            if (getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY && getAccumulatedEventCount() > 100) {
                flush(FlushReason.EVENT_THRESHOLD);
            }
        }
    }

    private static int getAccumulatedEventCount() {
        int i;
        synchronized (staticLock) {
            i = 0;
            for (SessionEventsState accumulatedEventCount : stateMap.values()) {
                i = accumulatedEventCount.getAccumulatedEventCount() + i;
            }
        }
        return i;
    }

    public static FlushBehavior getFlushBehavior() {
        FlushBehavior flushBehavior;
        synchronized (staticLock) {
            flushBehavior = flushBehavior;
        }
        return flushBehavior;
    }

    @Deprecated
    public static boolean getLimitEventUsage(Context context) {
        return Settings.getLimitEventAndDataUsage(context);
    }

    private static SessionEventsState getSessionEventsState(Context context, AccessTokenAppIdPair accessTokenAppIdPair) {
        SessionEventsState sessionEventsState;
        AttributionIdentifiers attributionIdentifiers = null;
        if (((SessionEventsState) stateMap.get(accessTokenAppIdPair)) == null) {
            attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(context);
        }
        synchronized (staticLock) {
            sessionEventsState = (SessionEventsState) stateMap.get(accessTokenAppIdPair);
            if (sessionEventsState == null) {
                sessionEventsState = new SessionEventsState(attributionIdentifiers, context.getPackageName(), hashedDeviceAndAppId);
                stateMap.put(accessTokenAppIdPair, sessionEventsState);
            }
        }
        return sessionEventsState;
    }

    private static SessionEventsState getSessionEventsState(AccessTokenAppIdPair accessTokenAppIdPair) {
        SessionEventsState sessionEventsState;
        synchronized (staticLock) {
            sessionEventsState = (SessionEventsState) stateMap.get(accessTokenAppIdPair);
        }
        return sessionEventsState;
    }

    static String getSourceApplication() {
        String str = "Unclassified";
        if (isOpenedByApplink) {
            str = "Applink";
        }
        return sourceApplication != null ? str + "(" + sourceApplication + ")" : str;
    }

    private static void handleResponse(AccessTokenAppIdPair accessTokenAppIdPair, Request request, Response response, SessionEventsState sessionEventsState, FlushStatistics flushStatistics) {
        FlushResult flushResult;
        FacebookRequestError error = response.getError();
        String str = "Success";
        FlushResult flushResult2 = FlushResult.SUCCESS;
        String str2;
        if (error == null) {
            str2 = str;
            flushResult = flushResult2;
        } else if (error.getErrorCode() == -1) {
            Object obj = "Failed: No Connectivity";
            flushResult = FlushResult.NO_CONNECTIVITY;
        } else {
            str2 = String.format("Failed:\n  Response: %s\n  Error %s", new Object[]{response.toString(), error.toString()});
            flushResult = FlushResult.SERVER_ERROR;
        }
        if (Settings.isLoggingBehaviorEnabled(LoggingBehavior.APP_EVENTS)) {
            String jSONArray;
            try {
                jSONArray = new JSONArray((String) request.getTag()).toString(2);
            } catch (JSONException e) {
                jSONArray = "<Can't encode events for debug logging>";
            }
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", request.getGraphObject().toString(), obj, jSONArray);
        }
        sessionEventsState.clearInFlightAndStats(error != null);
        if (flushResult == FlushResult.NO_CONNECTIVITY) {
            PersistedEvents.persistEvents(applicationContext, accessTokenAppIdPair, sessionEventsState);
        }
        if (flushResult != FlushResult.SUCCESS && flushStatistics.result != FlushResult.NO_CONNECTIVITY) {
            flushStatistics.result = flushResult;
        }
    }

    private static void initializeTimersIfNeeded() {
        synchronized (staticLock) {
            if (backgroundExecutor != null) {
                return;
            }
            backgroundExecutor = new ScheduledThreadPoolExecutor(1);
            backgroundExecutor.scheduleAtFixedRate(new C03773(), 0, 15, TimeUnit.SECONDS);
            backgroundExecutor.scheduleAtFixedRate(new C03784(), 0, 86400, TimeUnit.SECONDS);
        }
    }

    private void logAppSessionResumeEvent(long j, String str) {
        PersistedAppSessionInfo.onResume(applicationContext, this.accessTokenAppId, this, j, str);
    }

    private void logAppSessionSuspendEvent(long j) {
        PersistedAppSessionInfo.onSuspend(applicationContext, this.accessTokenAppId, this, j);
    }

    private static void logEvent(final Context context, final AppEvent appEvent, final AccessTokenAppIdPair accessTokenAppIdPair) {
        Settings.getExecutor().execute(new Runnable() {
            public void run() {
                AppEventsLogger.getSessionEventsState(context, accessTokenAppIdPair).addEvent(appEvent);
                AppEventsLogger.flushIfNecessary();
            }
        });
    }

    private void logEvent(String str, Double d, Bundle bundle, boolean z) {
        logEvent(this.context, new AppEvent(this.context, str, d, bundle, z), this.accessTokenAppId);
    }

    public static AppEventsLogger newLogger(Context context) {
        return new AppEventsLogger(context, null, null);
    }

    public static AppEventsLogger newLogger(Context context, Session session) {
        return new AppEventsLogger(context, null, session);
    }

    public static AppEventsLogger newLogger(Context context, String str) {
        return new AppEventsLogger(context, str, null);
    }

    public static AppEventsLogger newLogger(Context context, String str, Session session) {
        return new AppEventsLogger(context, str, session);
    }

    private static void notifyDeveloperError(String str) {
        Logger.log(LoggingBehavior.DEVELOPER_ERRORS, "AppEvents", str);
    }

    public static void onContextStop() {
        PersistedEvents.persistEvents(applicationContext, stateMap);
    }

    static void resetSourceApplication() {
        sourceApplication = null;
        isOpenedByApplink = false;
    }

    public static void setFlushBehavior(FlushBehavior flushBehavior) {
        synchronized (staticLock) {
            flushBehavior = flushBehavior;
        }
    }

    @Deprecated
    public static void setLimitEventUsage(Context context, boolean z) {
        Settings.setLimitEventAndDataUsage(context, z);
    }

    private static void setSourceApplication(Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity != null) {
            String packageName = callingActivity.getPackageName();
            if (packageName.equals(activity.getPackageName())) {
                resetSourceApplication();
                return;
            }
            sourceApplication = packageName;
        }
        Intent intent = activity.getIntent();
        if (intent == null || intent.getBooleanExtra(SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT, false)) {
            resetSourceApplication();
            return;
        }
        Bundle a = C0005c.m3a(intent);
        if (a == null) {
            resetSourceApplication();
            return;
        }
        isOpenedByApplink = true;
        a = a.getBundle("referer_app_link");
        if (a == null) {
            sourceApplication = null;
            return;
        }
        sourceApplication = a.getString("package");
        intent.putExtra(SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT, true);
    }

    static void setSourceApplication(String str, boolean z) {
        sourceApplication = str;
        isOpenedByApplink = z;
    }

    public void flush() {
        flush(FlushReason.EXPLICIT);
    }

    public String getApplicationId() {
        return this.accessTokenAppId.getApplicationId();
    }

    boolean isValidForSession(Session session) {
        return this.accessTokenAppId.equals(new AccessTokenAppIdPair(session));
    }

    public void logEvent(String str) {
        logEvent(str, null);
    }

    public void logEvent(String str, double d) {
        logEvent(str, d, null);
    }

    public void logEvent(String str, double d, Bundle bundle) {
        logEvent(str, Double.valueOf(d), bundle, false);
    }

    public void logEvent(String str, Bundle bundle) {
        logEvent(str, null, bundle, false);
    }

    public void logPurchase(BigDecimal bigDecimal, Currency currency) {
        logPurchase(bigDecimal, currency, null);
    }

    public void logPurchase(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        if (bigDecimal == null) {
            notifyDeveloperError("purchaseAmount cannot be null");
        } else if (currency == null) {
            notifyDeveloperError("currency cannot be null");
        } else {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString(AppEventsConstants.EVENT_PARAM_CURRENCY, currency.getCurrencyCode());
            logEvent(AppEventsConstants.EVENT_NAME_PURCHASED, bigDecimal.doubleValue(), bundle);
            eagerFlush();
        }
    }

    public void logSdkEvent(String str, Double d, Bundle bundle) {
        logEvent(str, d, bundle, true);
    }
}
