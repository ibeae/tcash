package com.facebook;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.location.Location;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.appsflyer.MonitorMessages;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphMultiResult;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;
import com.facebook.model.GraphPlace;
import com.facebook.model.GraphUser;
import com.facebook.model.OpenGraphAction;
import com.facebook.model.OpenGraphObject;
import com.facebook.model.OpenGraphObject.Factory;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class Request {
    private static final String ACCEPT_LANGUAGE_HEADER = "Accept-Language";
    private static final String ACCESS_TOKEN_PARAM = "access_token";
    private static final String ATTACHED_FILES_PARAM = "attached_files";
    private static final String ATTACHMENT_FILENAME_PREFIX = "file";
    private static final String BATCH_APP_ID_PARAM = "batch_app_id";
    private static final String BATCH_BODY_PARAM = "body";
    private static final String BATCH_ENTRY_DEPENDS_ON_PARAM = "depends_on";
    private static final String BATCH_ENTRY_NAME_PARAM = "name";
    private static final String BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM = "omit_response_on_success";
    private static final String BATCH_METHOD_PARAM = "method";
    private static final String BATCH_PARAM = "batch";
    private static final String BATCH_RELATIVE_URL_PARAM = "relative_url";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String FORMAT_JSON = "json";
    private static final String FORMAT_PARAM = "format";
    private static final String ISO_8601_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final int MAXIMUM_BATCH_SIZE = 50;
    private static final String ME = "me";
    private static final String MIME_BOUNDARY = "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f";
    private static final String MY_ACTION_FORMAT = "me/%s";
    private static final String MY_FEED = "me/feed";
    private static final String MY_FRIENDS = "me/friends";
    private static final String MY_OBJECTS_FORMAT = "me/objects/%s";
    private static final String MY_PHOTOS = "me/photos";
    private static final String MY_STAGING_RESOURCES = "me/staging_resources";
    private static final String MY_VIDEOS = "me/videos";
    private static final String OBJECT_PARAM = "object";
    private static final String PICTURE_PARAM = "picture";
    private static final String SDK_ANDROID = "android";
    private static final String SDK_PARAM = "sdk";
    private static final String SEARCH = "search";
    private static final String STAGING_PARAM = "file";
    public static final String TAG = Request.class.getSimpleName();
    private static final String USER_AGENT_BASE = "FBAndroidSDK";
    private static final String USER_AGENT_HEADER = "User-Agent";
    private static final String VIDEOS_SUFFIX = "/videos";
    private static String defaultBatchApplicationId;
    private static volatile String userAgent;
    private static Pattern versionPattern = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
    private String batchEntryDependsOn;
    private String batchEntryName;
    private boolean batchEntryOmitResultOnSuccess;
    private Callback callback;
    private GraphObject graphObject;
    private String graphPath;
    private HttpMethod httpMethod;
    private String overriddenURL;
    private Bundle parameters;
    private Session session;
    private boolean skipClientToken;
    private Object tag;
    private String version;

    public interface Callback {
        void onCompleted(Response response);
    }

    private interface KeyValueSerializer {
        void writeString(String str, String str2);
    }

    private static class Attachment {
        private final Request request;
        private final Object value;

        public Attachment(Request request, Object obj) {
            this.request = request;
            this.value = obj;
        }

        public Request getRequest() {
            return this.request;
        }

        public Object getValue() {
            return this.value;
        }
    }

    public interface GraphPlaceListCallback {
        void onCompleted(List<GraphPlace> list, Response response);
    }

    public interface GraphUserCallback {
        void onCompleted(GraphUser graphUser, Response response);
    }

    public interface GraphUserListCallback {
        void onCompleted(List<GraphUser> list, Response response);
    }

    public interface OnProgressCallback extends Callback {
        void onProgress(long j, long j2);
    }

    private static class ParcelFileDescriptorWithMimeType implements Parcelable {
        public static final Creator<ParcelFileDescriptorWithMimeType> CREATOR = new C04051();
        private final ParcelFileDescriptor fileDescriptor;
        private final String mimeType;

        static class C04051 implements Creator<ParcelFileDescriptorWithMimeType> {
            C04051() {
            }

            public ParcelFileDescriptorWithMimeType createFromParcel(Parcel parcel) {
                return new ParcelFileDescriptorWithMimeType(parcel);
            }

            public ParcelFileDescriptorWithMimeType[] newArray(int i) {
                return new ParcelFileDescriptorWithMimeType[i];
            }
        }

        private ParcelFileDescriptorWithMimeType(Parcel parcel) {
            this.mimeType = parcel.readString();
            this.fileDescriptor = parcel.readFileDescriptor();
        }

        public ParcelFileDescriptorWithMimeType(ParcelFileDescriptor parcelFileDescriptor, String str) {
            this.mimeType = str;
            this.fileDescriptor = parcelFileDescriptor;
        }

        public int describeContents() {
            return 1;
        }

        public ParcelFileDescriptor getFileDescriptor() {
            return this.fileDescriptor;
        }

        public String getMimeType() {
            return this.mimeType;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mimeType);
            parcel.writeFileDescriptor(this.fileDescriptor.getFileDescriptor());
        }
    }

    private static class Serializer implements KeyValueSerializer {
        private boolean firstWrite = true;
        private final Logger logger;
        private final OutputStream outputStream;

        public Serializer(OutputStream outputStream, Logger logger) {
            this.outputStream = outputStream;
            this.logger = logger;
        }

        public void write(String str, Object... objArr) {
            if (this.firstWrite) {
                this.outputStream.write("--".getBytes());
                this.outputStream.write(Request.MIME_BOUNDARY.getBytes());
                this.outputStream.write("\r\n".getBytes());
                this.firstWrite = false;
            }
            this.outputStream.write(String.format(str, objArr).getBytes());
        }

        public void writeBitmap(String str, Bitmap bitmap) {
            writeContentDisposition(str, str, "image/png");
            bitmap.compress(CompressFormat.PNG, 100, this.outputStream);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            if (this.logger != null) {
                this.logger.appendKeyValue("    " + str, "<Image>");
            }
        }

        public void writeBytes(String str, byte[] bArr) {
            writeContentDisposition(str, str, "content/unknown");
            this.outputStream.write(bArr);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            if (this.logger != null) {
                this.logger.appendKeyValue("    " + str, String.format("<Data: %d>", new Object[]{Integer.valueOf(bArr.length)}));
            }
        }

        public void writeContentDisposition(String str, String str2, String str3) {
            write("Content-Disposition: form-data; name=\"%s\"", str);
            if (str2 != null) {
                write("; filename=\"%s\"", str2);
            }
            writeLine("", new Object[0]);
            if (str3 != null) {
                writeLine("%s: %s", Request.CONTENT_TYPE_HEADER, str3);
            }
            writeLine("", new Object[0]);
        }

        public void writeFile(String str, ParcelFileDescriptor parcelFileDescriptor, String str2) {
            int i;
            BufferedInputStream bufferedInputStream;
            Throwable th;
            BufferedInputStream bufferedInputStream2;
            InputStream inputStream;
            AutoCloseInputStream autoCloseInputStream = null;
            if (str2 == null) {
                str2 = "content/unknown";
            }
            writeContentDisposition(str, str, str2);
            if (this.outputStream instanceof ProgressNoopOutputStream) {
                ((ProgressNoopOutputStream) this.outputStream).addProgress(parcelFileDescriptor.getStatSize());
                i = 0;
            } else {
                try {
                    InputStream autoCloseInputStream2 = new AutoCloseInputStream(parcelFileDescriptor);
                    try {
                        bufferedInputStream = new BufferedInputStream(autoCloseInputStream2);
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream2 = null;
                        inputStream = autoCloseInputStream2;
                        if (bufferedInputStream2 != null) {
                            bufferedInputStream2.close();
                        }
                        if (autoCloseInputStream != null) {
                            autoCloseInputStream.close();
                        }
                        throw th;
                    }
                    try {
                        byte[] bArr = new byte[8192];
                        i = 0;
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            this.outputStream.write(bArr, 0, read);
                            i += read;
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (autoCloseInputStream2 != null) {
                            autoCloseInputStream2.close();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedInputStream2 = bufferedInputStream;
                        inputStream = autoCloseInputStream2;
                        if (bufferedInputStream2 != null) {
                            bufferedInputStream2.close();
                        }
                        if (autoCloseInputStream != null) {
                            autoCloseInputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bufferedInputStream2 = null;
                    if (bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                    }
                    if (autoCloseInputStream != null) {
                        autoCloseInputStream.close();
                    }
                    throw th;
                }
            }
            writeLine("", new Object[0]);
            writeRecordBoundary();
            if (this.logger != null) {
                this.logger.appendKeyValue("    " + str, String.format("<Data: %d>", new Object[]{Integer.valueOf(i)}));
            }
        }

        public void writeFile(String str, ParcelFileDescriptorWithMimeType parcelFileDescriptorWithMimeType) {
            writeFile(str, parcelFileDescriptorWithMimeType.getFileDescriptor(), parcelFileDescriptorWithMimeType.getMimeType());
        }

        public void writeLine(String str, Object... objArr) {
            write(str, objArr);
            write("\r\n", new Object[0]);
        }

        public void writeObject(String str, Object obj, Request request) {
            if (this.outputStream instanceof RequestOutputStream) {
                ((RequestOutputStream) this.outputStream).setCurrentRequest(request);
            }
            if (Request.isSupportedParameterType(obj)) {
                writeString(str, Request.parameterToString(obj));
            } else if (obj instanceof Bitmap) {
                writeBitmap(str, (Bitmap) obj);
            } else if (obj instanceof byte[]) {
                writeBytes(str, (byte[]) obj);
            } else if (obj instanceof ParcelFileDescriptor) {
                writeFile(str, (ParcelFileDescriptor) obj, null);
            } else if (obj instanceof ParcelFileDescriptorWithMimeType) {
                writeFile(str, (ParcelFileDescriptorWithMimeType) obj);
            } else {
                throw new IllegalArgumentException("value is not a supported type: String, Bitmap, byte[]");
            }
        }

        public void writeRecordBoundary() {
            writeLine("--%s", Request.MIME_BOUNDARY);
        }

        public void writeRequestsAsJson(String str, JSONArray jSONArray, Collection<Request> collection) {
            if (this.outputStream instanceof RequestOutputStream) {
                RequestOutputStream requestOutputStream = (RequestOutputStream) this.outputStream;
                writeContentDisposition(str, null, null);
                write("[", new Object[0]);
                int i = 0;
                for (Request request : collection) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    requestOutputStream.setCurrentRequest(request);
                    if (i > 0) {
                        write(",%s", jSONObject.toString());
                    } else {
                        write("%s", jSONObject.toString());
                    }
                    i++;
                }
                write("]", new Object[0]);
                if (this.logger != null) {
                    this.logger.appendKeyValue("    " + str, jSONArray.toString());
                    return;
                }
                return;
            }
            writeString(str, jSONArray.toString());
        }

        public void writeString(String str, String str2) {
            writeContentDisposition(str, null, null);
            writeLine("%s", str2);
            writeRecordBoundary();
            if (this.logger != null) {
                this.logger.appendKeyValue("    " + str, str2);
            }
        }
    }

    public Request() {
        this(null, null, null, null, null);
    }

    public Request(Session session, String str) {
        this(session, str, null, null, null);
    }

    public Request(Session session, String str, Bundle bundle, HttpMethod httpMethod) {
        this(session, str, bundle, httpMethod, null);
    }

    public Request(Session session, String str, Bundle bundle, HttpMethod httpMethod, Callback callback) {
        this(session, str, bundle, httpMethod, callback, null);
    }

    public Request(Session session, String str, Bundle bundle, HttpMethod httpMethod, Callback callback, String str2) {
        this.batchEntryOmitResultOnSuccess = true;
        this.skipClientToken = false;
        this.session = session;
        this.graphPath = str;
        this.callback = callback;
        this.version = str2;
        setHttpMethod(httpMethod);
        if (bundle != null) {
            this.parameters = new Bundle(bundle);
        } else {
            this.parameters = new Bundle();
        }
        if (this.version == null) {
            this.version = ServerProtocol.getAPIVersion();
        }
    }

    Request(Session session, URL url) {
        this.batchEntryOmitResultOnSuccess = true;
        this.skipClientToken = false;
        this.session = session;
        this.overriddenURL = url.toString();
        setHttpMethod(HttpMethod.GET);
        this.parameters = new Bundle();
    }

    private void addCommonParameters() {
        String accessToken;
        if (this.session != null) {
            if (!this.session.isOpened()) {
                throw new FacebookException("Session provided to a Request in un-opened state.");
            } else if (!this.parameters.containsKey("access_token")) {
                accessToken = this.session.getAccessToken();
                Logger.registerAccessToken(accessToken);
                this.parameters.putString("access_token", accessToken);
            }
        } else if (!(this.skipClientToken || this.parameters.containsKey("access_token"))) {
            accessToken = Settings.getApplicationId();
            String clientToken = Settings.getClientToken();
            if (Utility.isNullOrEmpty(accessToken) || Utility.isNullOrEmpty(clientToken)) {
                Log.d(TAG, "Warning: Sessionless Request needs token but missing either application ID or client token.");
            } else {
                this.parameters.putString("access_token", accessToken + "|" + clientToken);
            }
        }
        this.parameters.putString("sdk", SDK_ANDROID);
        this.parameters.putString(FORMAT_PARAM, FORMAT_JSON);
    }

    private String appendParametersToBaseUrl(String str) {
        Builder encodedPath = new Builder().encodedPath(str);
        for (String str2 : this.parameters.keySet()) {
            Object obj = this.parameters.get(str2);
            if (obj == null) {
                obj = "";
            }
            if (isSupportedParameterType(obj)) {
                encodedPath.appendQueryParameter(str2, parameterToString(obj).toString());
            } else if (this.httpMethod == HttpMethod.GET) {
                throw new IllegalArgumentException(String.format("Unsupported parameter type for GET request: %s", new Object[]{obj.getClass().getSimpleName()}));
            }
        }
        return encodedPath.toString();
    }

    static HttpURLConnection createConnection(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestProperty(USER_AGENT_HEADER, getUserAgent());
        httpURLConnection.setRequestProperty(CONTENT_TYPE_HEADER, getMimeContentType());
        httpURLConnection.setRequestProperty(ACCEPT_LANGUAGE_HEADER, Locale.getDefault().toString());
        httpURLConnection.setChunkedStreamingMode(0);
        return httpURLConnection;
    }

    public static Response executeAndWait(Request request) {
        List executeBatchAndWait = executeBatchAndWait(request);
        if (executeBatchAndWait != null && executeBatchAndWait.size() == 1) {
            return (Response) executeBatchAndWait.get(0);
        }
        throw new FacebookException("invalid state: expected a single response");
    }

    public static List<Response> executeBatchAndWait(RequestBatch requestBatch) {
        Validate.notEmptyAndContainsNoNulls(requestBatch, "requests");
        try {
            return executeConnectionAndWait(toHttpConnection(requestBatch), requestBatch);
        } catch (Throwable e) {
            List<Response> constructErrorResponses = Response.constructErrorResponses(requestBatch.getRequests(), null, new FacebookException(e));
            runCallbacks(requestBatch, constructErrorResponses);
            return constructErrorResponses;
        }
    }

    public static List<Response> executeBatchAndWait(Collection<Request> collection) {
        return executeBatchAndWait(new RequestBatch((Collection) collection));
    }

    public static List<Response> executeBatchAndWait(Request... requestArr) {
        Validate.notNull(requestArr, "requests");
        return executeBatchAndWait(Arrays.asList(requestArr));
    }

    public static RequestAsyncTask executeBatchAsync(RequestBatch requestBatch) {
        Validate.notEmptyAndContainsNoNulls(requestBatch, "requests");
        RequestAsyncTask requestAsyncTask = new RequestAsyncTask(requestBatch);
        requestAsyncTask.executeOnSettingsExecutor();
        return requestAsyncTask;
    }

    public static RequestAsyncTask executeBatchAsync(Collection<Request> collection) {
        return executeBatchAsync(new RequestBatch((Collection) collection));
    }

    public static RequestAsyncTask executeBatchAsync(Request... requestArr) {
        Validate.notNull(requestArr, "requests");
        return executeBatchAsync(Arrays.asList(requestArr));
    }

    public static List<Response> executeConnectionAndWait(HttpURLConnection httpURLConnection, RequestBatch requestBatch) {
        List<Response> fromHttpConnection = Response.fromHttpConnection(httpURLConnection, requestBatch);
        Utility.disconnectQuietly(httpURLConnection);
        if (requestBatch.size() != fromHttpConnection.size()) {
            throw new FacebookException(String.format("Received %d responses while expecting %d", new Object[]{Integer.valueOf(fromHttpConnection.size()), Integer.valueOf(requestBatch.size())}));
        }
        runCallbacks(requestBatch, fromHttpConnection);
        HashSet hashSet = new HashSet();
        Iterator it = requestBatch.iterator();
        while (it.hasNext()) {
            Request request = (Request) it.next();
            if (request.session != null) {
                hashSet.add(request.session);
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            ((Session) it2.next()).extendAccessTokenIfNeeded();
        }
        return fromHttpConnection;
    }

    public static List<Response> executeConnectionAndWait(HttpURLConnection httpURLConnection, Collection<Request> collection) {
        return executeConnectionAndWait(httpURLConnection, new RequestBatch((Collection) collection));
    }

    public static RequestAsyncTask executeConnectionAsync(Handler handler, HttpURLConnection httpURLConnection, RequestBatch requestBatch) {
        Validate.notNull(httpURLConnection, "connection");
        RequestAsyncTask requestAsyncTask = new RequestAsyncTask(httpURLConnection, requestBatch);
        requestBatch.setCallbackHandler(handler);
        requestAsyncTask.executeOnSettingsExecutor();
        return requestAsyncTask;
    }

    public static RequestAsyncTask executeConnectionAsync(HttpURLConnection httpURLConnection, RequestBatch requestBatch) {
        return executeConnectionAsync(null, httpURLConnection, requestBatch);
    }

    @Deprecated
    public static RequestAsyncTask executeGraphPathRequestAsync(Session session, String str, Callback callback) {
        return newGraphPathRequest(session, str, callback).executeAsync();
    }

    @Deprecated
    public static RequestAsyncTask executeMeRequestAsync(Session session, GraphUserCallback graphUserCallback) {
        return newMeRequest(session, graphUserCallback).executeAsync();
    }

    @Deprecated
    public static RequestAsyncTask executeMyFriendsRequestAsync(Session session, GraphUserListCallback graphUserListCallback) {
        return newMyFriendsRequest(session, graphUserListCallback).executeAsync();
    }

    @Deprecated
    public static RequestAsyncTask executePlacesSearchRequestAsync(Session session, Location location, int i, int i2, String str, GraphPlaceListCallback graphPlaceListCallback) {
        return newPlacesSearchRequest(session, location, i, i2, str, graphPlaceListCallback).executeAsync();
    }

    @Deprecated
    public static RequestAsyncTask executePostRequestAsync(Session session, String str, GraphObject graphObject, Callback callback) {
        return newPostRequest(session, str, graphObject, callback).executeAsync();
    }

    @Deprecated
    public static RequestAsyncTask executeStatusUpdateRequestAsync(Session session, String str, Callback callback) {
        return newStatusUpdateRequest(session, str, callback).executeAsync();
    }

    @Deprecated
    public static RequestAsyncTask executeUploadPhotoRequestAsync(Session session, Bitmap bitmap, Callback callback) {
        return newUploadPhotoRequest(session, bitmap, callback).executeAsync();
    }

    @Deprecated
    public static RequestAsyncTask executeUploadPhotoRequestAsync(Session session, File file, Callback callback) {
        return newUploadPhotoRequest(session, file, callback).executeAsync();
    }

    private static String getBatchAppId(RequestBatch requestBatch) {
        if (!Utility.isNullOrEmpty(requestBatch.getBatchApplicationId())) {
            return requestBatch.getBatchApplicationId();
        }
        Iterator it = requestBatch.iterator();
        while (it.hasNext()) {
            Session session = ((Request) it.next()).session;
            if (session != null) {
                return session.getApplicationId();
            }
        }
        return defaultBatchApplicationId;
    }

    public static final String getDefaultBatchApplicationId() {
        return defaultBatchApplicationId;
    }

    private String getGraphPathWithVersion() {
        if (versionPattern.matcher(this.graphPath).matches()) {
            return this.graphPath;
        }
        return String.format("%s/%s", new Object[]{this.version, this.graphPath});
    }

    private static String getMimeContentType() {
        return String.format("multipart/form-data; boundary=%s", new Object[]{MIME_BOUNDARY});
    }

    private static String getUserAgent() {
        if (userAgent == null) {
            userAgent = String.format("%s.%s", new Object[]{USER_AGENT_BASE, FacebookSdkVersion.BUILD});
        }
        return userAgent;
    }

    private static boolean hasOnProgressCallbacks(RequestBatch requestBatch) {
        for (com.facebook.RequestBatch.Callback callback : requestBatch.getCallbacks()) {
            if (callback instanceof com.facebook.RequestBatch.OnProgressCallback) {
                return true;
            }
        }
        Iterator it = requestBatch.iterator();
        while (it.hasNext()) {
            if (((Request) it.next()).getCallback() instanceof OnProgressCallback) {
                return true;
            }
        }
        return false;
    }

    private static boolean isMeRequest(String str) {
        Matcher matcher = versionPattern.matcher(str);
        if (matcher.matches()) {
            str = matcher.group(1);
        }
        return str.startsWith("me/") || str.startsWith("/me/");
    }

    private static boolean isSupportedAttachmentType(Object obj) {
        return (obj instanceof Bitmap) || (obj instanceof byte[]) || (obj instanceof ParcelFileDescriptor) || (obj instanceof ParcelFileDescriptorWithMimeType);
    }

    private static boolean isSupportedParameterType(Object obj) {
        return (obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Date);
    }

    public static Request newCustomAudienceThirdPartyIdRequest(Session session, Context context, Callback callback) {
        return newCustomAudienceThirdPartyIdRequest(session, context, null, callback);
    }

    public static Request newCustomAudienceThirdPartyIdRequest(Session session, Context context, String str, Callback callback) {
        Session activeSession = session == null ? Session.getActiveSession() : session;
        if (!(activeSession == null || activeSession.isOpened())) {
            activeSession = null;
        }
        if (str == null) {
            str = activeSession != null ? activeSession.getApplicationId() : Utility.getMetadataApplicationId(context);
        }
        if (str == null) {
            throw new FacebookException("Facebook App ID cannot be determined");
        }
        String str2 = str + "/custom_audience_third_party_id";
        AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(context);
        Bundle bundle = new Bundle();
        if (activeSession == null) {
            String attributionId = attributionIdentifiers.getAttributionId() != null ? attributionIdentifiers.getAttributionId() : attributionIdentifiers.getAndroidAdvertiserId();
            if (attributionIdentifiers.getAttributionId() != null) {
                bundle.putString("udid", attributionId);
            }
        }
        if (Settings.getLimitEventAndDataUsage(context) || attributionIdentifiers.isTrackingLimited()) {
            bundle.putString("limit_event_usage", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        return new Request(activeSession, str2, bundle, HttpMethod.GET, callback);
    }

    public static Request newDeleteObjectRequest(Session session, String str, Callback callback) {
        return new Request(session, str, null, HttpMethod.DELETE, callback);
    }

    public static Request newGraphPathRequest(Session session, String str, Callback callback) {
        return new Request(session, str, null, null, callback);
    }

    public static Request newMeRequest(Session session, final GraphUserCallback graphUserCallback) {
        return new Request(session, ME, null, null, new Callback() {
            public void onCompleted(Response response) {
                if (graphUserCallback != null) {
                    graphUserCallback.onCompleted((GraphUser) response.getGraphObjectAs(GraphUser.class), response);
                }
            }
        });
    }

    public static Request newMyFriendsRequest(Session session, final GraphUserListCallback graphUserListCallback) {
        return new Request(session, MY_FRIENDS, null, null, new Callback() {
            public void onCompleted(Response response) {
                if (graphUserListCallback != null) {
                    graphUserListCallback.onCompleted(Request.typedListFromResponse(response, GraphUser.class), response);
                }
            }
        });
    }

    public static Request newPlacesSearchRequest(Session session, Location location, int i, int i2, String str, final GraphPlaceListCallback graphPlaceListCallback) {
        if (location == null && Utility.isNullOrEmpty(str)) {
            throw new FacebookException("Either location or searchText must be specified.");
        }
        Bundle bundle = new Bundle(5);
        bundle.putString("type", "place");
        bundle.putInt("limit", i2);
        if (location != null) {
            bundle.putString("center", String.format(Locale.US, "%f,%f", new Object[]{Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())}));
            bundle.putInt("distance", i);
        }
        if (!Utility.isNullOrEmpty(str)) {
            bundle.putString("q", str);
        }
        return new Request(session, SEARCH, bundle, HttpMethod.GET, new Callback() {
            public void onCompleted(Response response) {
                if (graphPlaceListCallback != null) {
                    graphPlaceListCallback.onCompleted(Request.typedListFromResponse(response, GraphPlace.class), response);
                }
            }
        });
    }

    public static Request newPostOpenGraphActionRequest(Session session, OpenGraphAction openGraphAction, Callback callback) {
        if (openGraphAction == null) {
            throw new FacebookException("openGraphAction cannot be null");
        } else if (Utility.isNullOrEmpty(openGraphAction.getType())) {
            throw new FacebookException("openGraphAction must have non-null 'type' property");
        } else {
            return newPostRequest(session, String.format(MY_ACTION_FORMAT, new Object[]{openGraphAction.getType()}), openGraphAction, callback);
        }
    }

    public static Request newPostOpenGraphObjectRequest(Session session, OpenGraphObject openGraphObject, Callback callback) {
        if (openGraphObject == null) {
            throw new FacebookException("openGraphObject cannot be null");
        } else if (Utility.isNullOrEmpty(openGraphObject.getType())) {
            throw new FacebookException("openGraphObject must have non-null 'type' property");
        } else if (Utility.isNullOrEmpty(openGraphObject.getTitle())) {
            throw new FacebookException("openGraphObject must have non-null 'title' property");
        } else {
            String format = String.format(MY_OBJECTS_FORMAT, new Object[]{openGraphObject.getType()});
            Bundle bundle = new Bundle();
            bundle.putString(OBJECT_PARAM, openGraphObject.getInnerJSONObject().toString());
            return new Request(session, format, bundle, HttpMethod.POST, callback);
        }
    }

    public static Request newPostOpenGraphObjectRequest(Session session, String str, String str2, String str3, String str4, String str5, GraphObject graphObject, Callback callback) {
        OpenGraphObject createForPost = Factory.createForPost(OpenGraphObject.class, str, str2, str3, str4, str5);
        if (graphObject != null) {
            createForPost.setData(graphObject);
        }
        return newPostOpenGraphObjectRequest(session, createForPost, callback);
    }

    public static Request newPostRequest(Session session, String str, GraphObject graphObject, Callback callback) {
        Request request = new Request(session, str, null, HttpMethod.POST, callback);
        request.setGraphObject(graphObject);
        return request;
    }

    public static Request newStatusUpdateRequest(Session session, String str, Callback callback) {
        return newStatusUpdateRequest(session, str, (String) null, null, callback);
    }

    public static Request newStatusUpdateRequest(Session session, String str, GraphPlace graphPlace, List<GraphUser> list, Callback callback) {
        List arrayList;
        if (list != null) {
            arrayList = new ArrayList(list.size());
            for (GraphUser id : list) {
                arrayList.add(id.getId());
            }
        } else {
            arrayList = null;
        }
        return newStatusUpdateRequest(session, str, graphPlace == null ? null : graphPlace.getId(), arrayList, callback);
    }

    private static Request newStatusUpdateRequest(Session session, String str, String str2, List<String> list, Callback callback) {
        Bundle bundle = new Bundle();
        bundle.putString(MonitorMessages.MESSAGE, str);
        if (str2 != null) {
            bundle.putString("place", str2);
        }
        if (list != null && list.size() > 0) {
            bundle.putString("tags", TextUtils.join(",", list));
        }
        return new Request(session, MY_FEED, bundle, HttpMethod.POST, callback);
    }

    public static Request newUpdateOpenGraphObjectRequest(Session session, OpenGraphObject openGraphObject, Callback callback) {
        if (openGraphObject == null) {
            throw new FacebookException("openGraphObject cannot be null");
        }
        String id = openGraphObject.getId();
        if (id == null) {
            throw new FacebookException("openGraphObject must have an id");
        }
        Bundle bundle = new Bundle();
        bundle.putString(OBJECT_PARAM, openGraphObject.getInnerJSONObject().toString());
        return new Request(session, id, bundle, HttpMethod.POST, callback);
    }

    public static Request newUpdateOpenGraphObjectRequest(Session session, String str, String str2, String str3, String str4, String str5, GraphObject graphObject, Callback callback) {
        OpenGraphObject createForPost = Factory.createForPost(OpenGraphObject.class, null, str2, str3, str4, str5);
        createForPost.setId(str);
        createForPost.setData(graphObject);
        return newUpdateOpenGraphObjectRequest(session, createForPost, callback);
    }

    public static Request newUploadPhotoRequest(Session session, Bitmap bitmap, Callback callback) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable(PICTURE_PARAM, bitmap);
        return new Request(session, MY_PHOTOS, bundle, HttpMethod.POST, callback);
    }

    public static Request newUploadPhotoRequest(Session session, File file, Callback callback) {
        Parcelable open = ParcelFileDescriptor.open(file, 268435456);
        Bundle bundle = new Bundle(1);
        bundle.putParcelable(PICTURE_PARAM, open);
        return new Request(session, MY_PHOTOS, bundle, HttpMethod.POST, callback);
    }

    public static Request newUploadStagingResourceWithImageRequest(Session session, Bitmap bitmap, Callback callback) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", bitmap);
        return new Request(session, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback);
    }

    public static Request newUploadStagingResourceWithImageRequest(Session session, File file, Callback callback) {
        Parcelable parcelFileDescriptorWithMimeType = new ParcelFileDescriptorWithMimeType(ParcelFileDescriptor.open(file, 268435456), "image/png");
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", parcelFileDescriptorWithMimeType);
        return new Request(session, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback);
    }

    public static Request newUploadVideoRequest(Session session, File file, Callback callback) {
        Parcelable open = ParcelFileDescriptor.open(file, 268435456);
        Bundle bundle = new Bundle(1);
        bundle.putParcelable(file.getName(), open);
        return new Request(session, MY_VIDEOS, bundle, HttpMethod.POST, callback);
    }

    private static String parameterToString(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if ((obj instanceof Boolean) || (obj instanceof Number)) {
            return obj.toString();
        }
        if (obj instanceof Date) {
            return new SimpleDateFormat(ISO_8601_FORMAT_STRING, Locale.US).format(obj);
        }
        throw new IllegalArgumentException("Unsupported parameter type.");
    }

    private static void processGraphObject(GraphObject graphObject, String str, KeyValueSerializer keyValueSerializer) {
        Object obj;
        if (isMeRequest(str)) {
            int indexOf = str.indexOf(":");
            int indexOf2 = str.indexOf("?");
            Object obj2 = (indexOf <= 3 || (indexOf2 != -1 && indexOf >= indexOf2)) ? null : 1;
            obj = obj2;
        } else {
            obj = null;
        }
        for (Entry entry : graphObject.asMap().entrySet()) {
            boolean z = obj != null && ((String) entry.getKey()).equalsIgnoreCase("image");
            processGraphObjectProperty((String) entry.getKey(), entry.getValue(), keyValueSerializer, z);
        }
    }

    private static void processGraphObjectProperty(String str, Object obj, KeyValueSerializer keyValueSerializer, boolean z) {
        Class cls;
        Object obj2;
        Class cls2 = obj.getClass();
        if (GraphObject.class.isAssignableFrom(cls2)) {
            JSONObject innerJSONObject = ((GraphObject) obj).getInnerJSONObject();
            cls = innerJSONObject.getClass();
            obj2 = innerJSONObject;
        } else if (GraphObjectList.class.isAssignableFrom(cls2)) {
            JSONArray innerJSONArray = ((GraphObjectList) obj).getInnerJSONArray();
            cls = innerJSONArray.getClass();
            JSONArray jSONArray = innerJSONArray;
        } else {
            cls = cls2;
            obj2 = obj;
        }
        if (JSONObject.class.isAssignableFrom(cls)) {
            JSONObject jSONObject = (JSONObject) obj2;
            if (z) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    Object[] objArr = new Object[]{str, (String) keys.next()};
                    processGraphObjectProperty(String.format("%s[%s]", objArr), jSONObject.opt((String) keys.next()), keyValueSerializer, z);
                }
            } else if (jSONObject.has("id")) {
                processGraphObjectProperty(str, jSONObject.optString("id"), keyValueSerializer, z);
            } else if (jSONObject.has(NativeProtocol.IMAGE_URL_KEY)) {
                processGraphObjectProperty(str, jSONObject.optString(NativeProtocol.IMAGE_URL_KEY), keyValueSerializer, z);
            } else if (jSONObject.has(NativeProtocol.OPEN_GRAPH_CREATE_OBJECT_KEY)) {
                processGraphObjectProperty(str, jSONObject.toString(), keyValueSerializer, z);
            }
        } else if (JSONArray.class.isAssignableFrom(cls)) {
            jSONArray = (JSONArray) obj2;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                processGraphObjectProperty(String.format("%s[%d]", new Object[]{str, Integer.valueOf(i)}), jSONArray.opt(i), keyValueSerializer, z);
            }
        } else if (String.class.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls)) {
            keyValueSerializer.writeString(str, obj2.toString());
        } else if (Date.class.isAssignableFrom(cls)) {
            keyValueSerializer.writeString(str, new SimpleDateFormat(ISO_8601_FORMAT_STRING, Locale.US).format((Date) obj2));
        }
    }

    private static void processRequest(RequestBatch requestBatch, Logger logger, int i, URL url, OutputStream outputStream) {
        Serializer serializer = new Serializer(outputStream, logger);
        String batchAppId;
        if (i == 1) {
            Request request = requestBatch.get(0);
            Map hashMap = new HashMap();
            for (String batchAppId2 : request.parameters.keySet()) {
                Object obj = request.parameters.get(batchAppId2);
                if (isSupportedAttachmentType(obj)) {
                    hashMap.put(batchAppId2, new Attachment(request, obj));
                }
            }
            if (logger != null) {
                logger.append("  Parameters:\n");
            }
            serializeParameters(request.parameters, serializer, request);
            if (logger != null) {
                logger.append("  Attachments:\n");
            }
            serializeAttachments(hashMap, serializer);
            if (request.graphObject != null) {
                processGraphObject(request.graphObject, url.getPath(), serializer);
                return;
            }
            return;
        }
        batchAppId2 = getBatchAppId(requestBatch);
        if (Utility.isNullOrEmpty(batchAppId2)) {
            throw new FacebookException("At least one request in a batch must have an open Session, or a default app ID must be specified.");
        }
        serializer.writeString(BATCH_APP_ID_PARAM, batchAppId2);
        Map hashMap2 = new HashMap();
        serializeRequestsAsJSON(serializer, requestBatch, hashMap2);
        if (logger != null) {
            logger.append("  Attachments:\n");
        }
        serializeAttachments(hashMap2, serializer);
    }

    static void runCallbacks(final RequestBatch requestBatch, List<Response> list) {
        int size = requestBatch.size();
        final ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            Request request = requestBatch.get(i);
            if (request.callback != null) {
                arrayList.add(new Pair(request.callback, list.get(i)));
            }
        }
        if (arrayList.size() > 0) {
            Runnable c04034 = new Runnable() {
                public void run() {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        ((Callback) pair.first).onCompleted((Response) pair.second);
                    }
                    for (com.facebook.RequestBatch.Callback onBatchCompleted : requestBatch.getCallbacks()) {
                        onBatchCompleted.onBatchCompleted(requestBatch);
                    }
                }
            };
            Handler callbackHandler = requestBatch.getCallbackHandler();
            if (callbackHandler == null) {
                c04034.run();
            } else {
                callbackHandler.post(c04034);
            }
        }
    }

    private static void serializeAttachments(Map<String, Attachment> map, Serializer serializer) {
        for (String str : map.keySet()) {
            Attachment attachment = (Attachment) map.get(str);
            if (isSupportedAttachmentType(attachment.getValue())) {
                serializer.writeObject(str, attachment.getValue(), attachment.getRequest());
            }
        }
    }

    private static void serializeParameters(Bundle bundle, Serializer serializer, Request request) {
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (isSupportedParameterType(obj)) {
                serializer.writeObject(str, obj, request);
            }
        }
    }

    private static void serializeRequestsAsJSON(Serializer serializer, Collection<Request> collection, Map<String, Attachment> map) {
        JSONArray jSONArray = new JSONArray();
        for (Request serializeToBatch : collection) {
            serializeToBatch.serializeToBatch(jSONArray, map);
        }
        serializer.writeRequestsAsJson(BATCH_PARAM, jSONArray, collection);
    }

    private void serializeToBatch(JSONArray jSONArray, Map<String, Attachment> map) {
        JSONObject jSONObject = new JSONObject();
        if (this.batchEntryName != null) {
            jSONObject.put(BATCH_ENTRY_NAME_PARAM, this.batchEntryName);
            jSONObject.put(BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM, this.batchEntryOmitResultOnSuccess);
        }
        if (this.batchEntryDependsOn != null) {
            jSONObject.put(BATCH_ENTRY_DEPENDS_ON_PARAM, this.batchEntryDependsOn);
        }
        String urlForBatchedRequest = getUrlForBatchedRequest();
        jSONObject.put(BATCH_RELATIVE_URL_PARAM, urlForBatchedRequest);
        jSONObject.put(BATCH_METHOD_PARAM, this.httpMethod);
        if (this.session != null) {
            Logger.registerAccessToken(this.session.getAccessToken());
        }
        Iterable arrayList = new ArrayList();
        for (String str : this.parameters.keySet()) {
            Object obj = this.parameters.get(str);
            if (isSupportedAttachmentType(obj)) {
                String format = String.format("%s%d", new Object[]{"file", Integer.valueOf(map.size())});
                arrayList.add(format);
                map.put(format, new Attachment(this, obj));
            }
        }
        if (!arrayList.isEmpty()) {
            jSONObject.put(ATTACHED_FILES_PARAM, TextUtils.join(",", arrayList));
        }
        if (this.graphObject != null) {
            final Iterable arrayList2 = new ArrayList();
            processGraphObject(this.graphObject, urlForBatchedRequest, new KeyValueSerializer() {
                public void writeString(String str, String str2) {
                    arrayList2.add(String.format("%s=%s", new Object[]{str, URLEncoder.encode(str2, "UTF-8")}));
                }
            });
            jSONObject.put(BATCH_BODY_PARAM, TextUtils.join("&", arrayList2));
        }
        jSONArray.put(jSONObject);
    }

    static final void serializeToUrlConnection(RequestBatch requestBatch, HttpURLConnection httpURLConnection) {
        Throwable th;
        Logger logger = new Logger(LoggingBehavior.REQUESTS, "Request");
        int size = requestBatch.size();
        HttpMethod httpMethod = size == 1 ? requestBatch.get(0).httpMethod : HttpMethod.POST;
        httpURLConnection.setRequestMethod(httpMethod.name());
        URL url = httpURLConnection.getURL();
        logger.append("Request:\n");
        logger.appendKeyValue("Id", requestBatch.getId());
        logger.appendKeyValue("URL", url);
        logger.appendKeyValue("Method", httpURLConnection.getRequestMethod());
        logger.appendKeyValue(USER_AGENT_HEADER, httpURLConnection.getRequestProperty(USER_AGENT_HEADER));
        logger.appendKeyValue(CONTENT_TYPE_HEADER, httpURLConnection.getRequestProperty(CONTENT_TYPE_HEADER));
        httpURLConnection.setConnectTimeout(requestBatch.getTimeout());
        httpURLConnection.setReadTimeout(requestBatch.getTimeout());
        if (httpMethod == HttpMethod.POST) {
            httpURLConnection.setDoOutput(true);
            OutputStream progressOutputStream;
            try {
                if (hasOnProgressCallbacks(requestBatch)) {
                    OutputStream progressNoopOutputStream = new ProgressNoopOutputStream(requestBatch.getCallbackHandler());
                    processRequest(requestBatch, null, size, url, progressNoopOutputStream);
                    progressOutputStream = new ProgressOutputStream(new BufferedOutputStream(httpURLConnection.getOutputStream()), requestBatch, progressNoopOutputStream.getProgressMap(), (long) progressNoopOutputStream.getMaxProgress());
                } else {
                    progressOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                }
                try {
                    processRequest(requestBatch, logger, size, url, progressOutputStream);
                    if (progressOutputStream != null) {
                        progressOutputStream.close();
                    }
                    logger.log();
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    if (progressOutputStream != null) {
                        progressOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                progressOutputStream = null;
                if (progressOutputStream != null) {
                    progressOutputStream.close();
                }
                throw th;
            }
        }
        logger.log();
    }

    public static final void setDefaultBatchApplicationId(String str) {
        defaultBatchApplicationId = str;
    }

    public static HttpURLConnection toHttpConnection(RequestBatch requestBatch) {
        try {
            try {
                HttpURLConnection createConnection = createConnection(requestBatch.size() == 1 ? new URL(requestBatch.get(0).getUrlForSingleRequest()) : new URL(ServerProtocol.getGraphUrlBase()));
                serializeToUrlConnection(requestBatch, createConnection);
                return createConnection;
            } catch (Throwable e) {
                throw new FacebookException("could not construct request body", e);
            } catch (Throwable e2) {
                throw new FacebookException("could not construct request body", e2);
            }
        } catch (Throwable e22) {
            throw new FacebookException("could not construct URL for request", e22);
        }
    }

    public static HttpURLConnection toHttpConnection(Collection<Request> collection) {
        Validate.notEmptyAndContainsNoNulls(collection, "requests");
        return toHttpConnection(new RequestBatch((Collection) collection));
    }

    public static HttpURLConnection toHttpConnection(Request... requestArr) {
        return toHttpConnection(Arrays.asList(requestArr));
    }

    private static <T extends GraphObject> List<T> typedListFromResponse(Response response, Class<T> cls) {
        GraphMultiResult graphMultiResult = (GraphMultiResult) response.getGraphObjectAs(GraphMultiResult.class);
        if (graphMultiResult == null) {
            return null;
        }
        GraphObjectList data = graphMultiResult.getData();
        return data == null ? null : data.castToListOf(cls);
    }

    public final Response executeAndWait() {
        return executeAndWait(this);
    }

    public final RequestAsyncTask executeAsync() {
        return executeBatchAsync(this);
    }

    public final String getBatchEntryDependsOn() {
        return this.batchEntryDependsOn;
    }

    public final String getBatchEntryName() {
        return this.batchEntryName;
    }

    public final boolean getBatchEntryOmitResultOnSuccess() {
        return this.batchEntryOmitResultOnSuccess;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final GraphObject getGraphObject() {
        return this.graphObject;
    }

    public final String getGraphPath() {
        return this.graphPath;
    }

    public final HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    public final Bundle getParameters() {
        return this.parameters;
    }

    public final Session getSession() {
        return this.session;
    }

    public final Object getTag() {
        return this.tag;
    }

    final String getUrlForBatchedRequest() {
        if (this.overriddenURL != null) {
            throw new FacebookException("Can't override URL for a batch request");
        }
        String graphPathWithVersion = getGraphPathWithVersion();
        addCommonParameters();
        return appendParametersToBaseUrl(graphPathWithVersion);
    }

    final String getUrlForSingleRequest() {
        if (this.overriddenURL != null) {
            return this.overriddenURL.toString();
        }
        String graphVideoUrlBase = (getHttpMethod() == HttpMethod.POST && this.graphPath != null && this.graphPath.endsWith(VIDEOS_SUFFIX)) ? ServerProtocol.getGraphVideoUrlBase() : ServerProtocol.getGraphUrlBase();
        graphVideoUrlBase = String.format("%s/%s", new Object[]{graphVideoUrlBase, getGraphPathWithVersion()});
        addCommonParameters();
        return appendParametersToBaseUrl(graphVideoUrlBase);
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setBatchEntryDependsOn(String str) {
        this.batchEntryDependsOn = str;
    }

    public final void setBatchEntryName(String str) {
        this.batchEntryName = str;
    }

    public final void setBatchEntryOmitResultOnSuccess(boolean z) {
        this.batchEntryOmitResultOnSuccess = z;
    }

    public final void setCallback(Callback callback) {
        this.callback = callback;
    }

    public final void setGraphObject(GraphObject graphObject) {
        this.graphObject = graphObject;
    }

    public final void setGraphPath(String str) {
        this.graphPath = str;
    }

    public final void setHttpMethod(HttpMethod httpMethod) {
        if (this.overriddenURL == null || httpMethod == HttpMethod.GET) {
            if (httpMethod == null) {
                httpMethod = HttpMethod.GET;
            }
            this.httpMethod = httpMethod;
            return;
        }
        throw new FacebookException("Can't change HTTP method on request with overridden URL.");
    }

    public final void setParameters(Bundle bundle) {
        this.parameters = bundle;
    }

    public final void setSession(Session session) {
        this.session = session;
    }

    public final void setSkipClientToken(boolean z) {
        this.skipClientToken = z;
    }

    public final void setTag(Object obj) {
        this.tag = obj;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "{Request: " + " session: " + this.session + ", graphPath: " + this.graphPath + ", graphObject: " + this.graphObject + ", httpMethod: " + this.httpMethod + ", parameters: " + this.parameters + "}";
    }
}
