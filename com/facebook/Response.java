package com.facebook;

import android.content.Context;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.FileLruCache.Limits;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObject.Factory;
import com.facebook.model.GraphObjectList;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import twitter4j.HttpResponseCode;

public class Response {
    static final /* synthetic */ boolean $assertionsDisabled = (!Response.class.desiredAssertionStatus());
    private static final String BODY_KEY = "body";
    private static final String CODE_KEY = "code";
    private static final int INVALID_SESSION_FACEBOOK_ERROR_CODE = 190;
    public static final String NON_JSON_RESPONSE_PROPERTY = "FACEBOOK_NON_JSON_RESULT";
    private static final String RESPONSE_CACHE_TAG = "ResponseCache";
    private static final String RESPONSE_LOG_TAG = "Response";
    public static final String SUCCESS_KEY = "success";
    private static FileLruCache responseCache;
    private final HttpURLConnection connection;
    private final FacebookRequestError error;
    private final GraphObject graphObject;
    private final GraphObjectList<GraphObject> graphObjectList;
    private final boolean isFromCache;
    private final String rawResponse;
    private final Request request;

    interface PagedResults extends GraphObject {
        GraphObjectList<GraphObject> getData();

        PagingInfo getPaging();
    }

    public enum PagingDirection {
        NEXT,
        PREVIOUS
    }

    interface PagingInfo extends GraphObject {
        String getNext();

        String getPrevious();
    }

    Response(Request request, HttpURLConnection httpURLConnection, FacebookRequestError facebookRequestError) {
        this(request, httpURLConnection, null, null, null, false, facebookRequestError);
    }

    Response(Request request, HttpURLConnection httpURLConnection, String str, GraphObject graphObject, GraphObjectList<GraphObject> graphObjectList, boolean z, FacebookRequestError facebookRequestError) {
        this.request = request;
        this.connection = httpURLConnection;
        this.rawResponse = str;
        this.graphObject = graphObject;
        this.graphObjectList = graphObjectList;
        this.isFromCache = z;
        this.error = facebookRequestError;
    }

    Response(Request request, HttpURLConnection httpURLConnection, String str, GraphObject graphObject, boolean z) {
        this(request, httpURLConnection, str, graphObject, null, z, null);
    }

    Response(Request request, HttpURLConnection httpURLConnection, String str, GraphObjectList<GraphObject> graphObjectList, boolean z) {
        this(request, httpURLConnection, str, null, graphObjectList, z, null);
    }

    static List<Response> constructErrorResponses(List<Request> list, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        int size = list.size();
        List<Response> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new Response((Request) list.get(i), httpURLConnection, new FacebookRequestError(httpURLConnection, facebookException)));
        }
        return arrayList;
    }

    private static Response createResponseFromObject(Request request, HttpURLConnection httpURLConnection, Object obj, boolean z, Object obj2) {
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            FacebookRequestError checkResponseAndCreateError = FacebookRequestError.checkResponseAndCreateError(jSONObject, obj2, httpURLConnection);
            if (checkResponseAndCreateError != null) {
                if (checkResponseAndCreateError.getErrorCode() == INVALID_SESSION_FACEBOOK_ERROR_CODE) {
                    Session session = request.getSession();
                    if (session != null) {
                        session.closeAndClearTokenInformation();
                    }
                }
                return new Response(request, httpURLConnection, checkResponseAndCreateError);
            }
            Object stringPropertyAsJSON = Utility.getStringPropertyAsJSON(jSONObject, BODY_KEY, NON_JSON_RESPONSE_PROPERTY);
            if (stringPropertyAsJSON instanceof JSONObject) {
                GraphObject create = Factory.create((JSONObject) stringPropertyAsJSON);
                return new Response(request, httpURLConnection, stringPropertyAsJSON.toString(), create, z);
            } else if (stringPropertyAsJSON instanceof JSONArray) {
                GraphObjectList createList = Factory.createList((JSONArray) stringPropertyAsJSON, GraphObject.class);
                return new Response(request, httpURLConnection, stringPropertyAsJSON.toString(), createList, z);
            } else {
                obj = JSONObject.NULL;
            }
        }
        if (obj == JSONObject.NULL) {
            return new Response(request, httpURLConnection, obj.toString(), (GraphObject) null, z);
        }
        throw new FacebookException("Got unexpected object type in response, class: " + obj.getClass().getSimpleName());
    }

    private static List<Response> createResponsesFromObject(HttpURLConnection httpURLConnection, List<Request> list, Object obj, boolean z) {
        int i = 0;
        if ($assertionsDisabled || httpURLConnection != null || z) {
            JSONArray jSONArray;
            int size = list.size();
            List<Response> arrayList = new ArrayList(size);
            if (size == 1) {
                Request request = (Request) list.get(0);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(BODY_KEY, obj);
                    jSONObject.put(CODE_KEY, httpURLConnection != null ? httpURLConnection.getResponseCode() : HttpResponseCode.OK);
                    jSONArray = new JSONArray();
                    jSONArray.put(jSONObject);
                } catch (Exception e) {
                    arrayList.add(new Response(request, httpURLConnection, new FacebookRequestError(httpURLConnection, e)));
                    jSONArray = obj;
                } catch (Exception e2) {
                    arrayList.add(new Response(request, httpURLConnection, new FacebookRequestError(httpURLConnection, e2)));
                }
                if ((jSONArray instanceof JSONArray) || jSONArray.length() != size) {
                    throw new FacebookException("Unexpected number of results");
                }
                jSONArray = jSONArray;
                while (i < jSONArray.length()) {
                    request = (Request) list.get(i);
                    try {
                        arrayList.add(createResponseFromObject(request, httpURLConnection, jSONArray.get(i), z, obj));
                    } catch (Exception e3) {
                        arrayList.add(new Response(request, httpURLConnection, new FacebookRequestError(httpURLConnection, e3)));
                    } catch (Exception e32) {
                        arrayList.add(new Response(request, httpURLConnection, new FacebookRequestError(httpURLConnection, e32)));
                    }
                    i++;
                }
                return arrayList;
            }
            jSONArray = obj;
            if (jSONArray instanceof JSONArray) {
            }
            throw new FacebookException("Unexpected number of results");
        }
        throw new AssertionError();
    }

    static List<Response> createResponsesFromStream(InputStream inputStream, HttpURLConnection httpURLConnection, RequestBatch requestBatch, boolean z) {
        Logger.log(LoggingBehavior.INCLUDE_RAW_RESPONSES, RESPONSE_LOG_TAG, "Response (raw)\n  Size: %d\n  Response:\n%s\n", Integer.valueOf(Utility.readStreamToString(inputStream).length()), r0);
        return createResponsesFromString(Utility.readStreamToString(inputStream), httpURLConnection, requestBatch, z);
    }

    static List<Response> createResponsesFromString(String str, HttpURLConnection httpURLConnection, RequestBatch requestBatch, boolean z) {
        Logger.log(LoggingBehavior.REQUESTS, RESPONSE_LOG_TAG, "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", requestBatch.getId(), Integer.valueOf(str.length()), createResponsesFromObject(httpURLConnection, requestBatch, new JSONTokener(str).nextValue(), z));
        return createResponsesFromObject(httpURLConnection, requestBatch, new JSONTokener(str).nextValue(), z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.util.List<com.facebook.Response> fromHttpConnection(java.net.HttpURLConnection r8, com.facebook.RequestBatch r9) {
        /*
        r2 = 0;
        r6 = 1;
        r5 = 0;
        r0 = r9 instanceof com.facebook.internal.CacheableRequestBatch;
        if (r0 == 0) goto L_0x011d;
    L_0x0007:
        r0 = r9;
        r0 = (com.facebook.internal.CacheableRequestBatch) r0;
        r3 = getResponseCache();
        r1 = r0.getCacheKeyOverride();
        r4 = com.facebook.internal.Utility.isNullOrEmpty(r1);
        if (r4 == 0) goto L_0x0026;
    L_0x0018:
        r4 = r9.size();
        if (r4 != r6) goto L_0x0044;
    L_0x001e:
        r1 = r9.get(r5);
        r1 = r1.getUrlForSingleRequest();
    L_0x0026:
        r0 = r0.getForceRoundTrip();
        if (r0 != 0) goto L_0x0117;
    L_0x002c:
        if (r3 == 0) goto L_0x0117;
    L_0x002e:
        r0 = com.facebook.internal.Utility.isNullOrEmpty(r1);
        if (r0 != 0) goto L_0x0117;
    L_0x0034:
        r2 = r3.get(r1);	 Catch:{ FacebookException -> 0x006a, JSONException -> 0x0073, IOException -> 0x007c, all -> 0x0085 }
        if (r2 == 0) goto L_0x004e;
    L_0x003a:
        r0 = 0;
        r4 = 1;
        r0 = createResponsesFromStream(r2, r0, r9, r4);	 Catch:{ FacebookException -> 0x0113, JSONException -> 0x0073, IOException -> 0x007c, all -> 0x0085 }
        com.facebook.internal.Utility.closeQuietly(r2);
    L_0x0043:
        return r0;
    L_0x0044:
        r4 = com.facebook.LoggingBehavior.REQUESTS;
        r5 = "ResponseCache";
        r6 = "Not using cache for cacheable request because no key was specified";
        com.facebook.internal.Logger.log(r4, r5, r6);
        goto L_0x0026;
    L_0x004e:
        com.facebook.internal.Utility.closeQuietly(r2);
        r0 = r3;
        r7 = r1;
        r1 = r2;
        r2 = r7;
    L_0x0055:
        r3 = r8.getResponseCode();	 Catch:{ FacebookException -> 0x009c, JSONException -> 0x00b4, IOException -> 0x00d2, SecurityException -> 0x00f0 }
        r4 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r3 < r4) goto L_0x008a;
    L_0x005d:
        r1 = r8.getErrorStream();	 Catch:{ FacebookException -> 0x009c, JSONException -> 0x00b4, IOException -> 0x00d2, SecurityException -> 0x00f0 }
    L_0x0061:
        r0 = 0;
        r0 = createResponsesFromStream(r1, r8, r9, r0);	 Catch:{ FacebookException -> 0x009c, JSONException -> 0x00b4, IOException -> 0x00d2, SecurityException -> 0x00f0 }
        com.facebook.internal.Utility.closeQuietly(r1);
        goto L_0x0043;
    L_0x006a:
        r0 = move-exception;
        r0 = r2;
    L_0x006c:
        com.facebook.internal.Utility.closeQuietly(r0);
        r2 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x0055;
    L_0x0073:
        r0 = move-exception;
        com.facebook.internal.Utility.closeQuietly(r2);
        r0 = r3;
        r7 = r1;
        r1 = r2;
        r2 = r7;
        goto L_0x0055;
    L_0x007c:
        r0 = move-exception;
        com.facebook.internal.Utility.closeQuietly(r2);
        r0 = r3;
        r7 = r1;
        r1 = r2;
        r2 = r7;
        goto L_0x0055;
    L_0x0085:
        r0 = move-exception;
        com.facebook.internal.Utility.closeQuietly(r2);
        throw r0;
    L_0x008a:
        r1 = r8.getInputStream();	 Catch:{ FacebookException -> 0x009c, JSONException -> 0x00b4, IOException -> 0x00d2, SecurityException -> 0x00f0 }
        if (r0 == 0) goto L_0x0061;
    L_0x0090:
        if (r2 == 0) goto L_0x0061;
    L_0x0092:
        if (r1 == 0) goto L_0x0061;
    L_0x0094:
        r0 = r0.interceptAndPut(r2, r1);	 Catch:{ FacebookException -> 0x009c, JSONException -> 0x00b4, IOException -> 0x00d2, SecurityException -> 0x00f0 }
        if (r0 == 0) goto L_0x0061;
    L_0x009a:
        r1 = r0;
        goto L_0x0061;
    L_0x009c:
        r0 = move-exception;
        r2 = com.facebook.LoggingBehavior.REQUESTS;	 Catch:{ all -> 0x010e }
        r3 = "Response";
        r4 = "Response <Error>: %s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x010e }
        r6 = 0;
        r5[r6] = r0;	 Catch:{ all -> 0x010e }
        com.facebook.internal.Logger.log(r2, r3, r4, r5);	 Catch:{ all -> 0x010e }
        r0 = constructErrorResponses(r9, r8, r0);	 Catch:{ all -> 0x010e }
        com.facebook.internal.Utility.closeQuietly(r1);
        goto L_0x0043;
    L_0x00b4:
        r0 = move-exception;
        r2 = com.facebook.LoggingBehavior.REQUESTS;	 Catch:{ all -> 0x010e }
        r3 = "Response";
        r4 = "Response <Error>: %s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x010e }
        r6 = 0;
        r5[r6] = r0;	 Catch:{ all -> 0x010e }
        com.facebook.internal.Logger.log(r2, r3, r4, r5);	 Catch:{ all -> 0x010e }
        r2 = new com.facebook.FacebookException;	 Catch:{ all -> 0x010e }
        r2.<init>(r0);	 Catch:{ all -> 0x010e }
        r0 = constructErrorResponses(r9, r8, r2);	 Catch:{ all -> 0x010e }
        com.facebook.internal.Utility.closeQuietly(r1);
        goto L_0x0043;
    L_0x00d2:
        r0 = move-exception;
        r2 = com.facebook.LoggingBehavior.REQUESTS;	 Catch:{ all -> 0x010e }
        r3 = "Response";
        r4 = "Response <Error>: %s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x010e }
        r6 = 0;
        r5[r6] = r0;	 Catch:{ all -> 0x010e }
        com.facebook.internal.Logger.log(r2, r3, r4, r5);	 Catch:{ all -> 0x010e }
        r2 = new com.facebook.FacebookException;	 Catch:{ all -> 0x010e }
        r2.<init>(r0);	 Catch:{ all -> 0x010e }
        r0 = constructErrorResponses(r9, r8, r2);	 Catch:{ all -> 0x010e }
        com.facebook.internal.Utility.closeQuietly(r1);
        goto L_0x0043;
    L_0x00f0:
        r0 = move-exception;
        r2 = com.facebook.LoggingBehavior.REQUESTS;	 Catch:{ all -> 0x010e }
        r3 = "Response";
        r4 = "Response <Error>: %s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x010e }
        r6 = 0;
        r5[r6] = r0;	 Catch:{ all -> 0x010e }
        com.facebook.internal.Logger.log(r2, r3, r4, r5);	 Catch:{ all -> 0x010e }
        r2 = new com.facebook.FacebookException;	 Catch:{ all -> 0x010e }
        r2.<init>(r0);	 Catch:{ all -> 0x010e }
        r0 = constructErrorResponses(r9, r8, r2);	 Catch:{ all -> 0x010e }
        com.facebook.internal.Utility.closeQuietly(r1);
        goto L_0x0043;
    L_0x010e:
        r0 = move-exception;
        com.facebook.internal.Utility.closeQuietly(r1);
        throw r0;
    L_0x0113:
        r0 = move-exception;
        r0 = r2;
        goto L_0x006c;
    L_0x0117:
        r0 = r3;
        r7 = r1;
        r1 = r2;
        r2 = r7;
        goto L_0x0055;
    L_0x011d:
        r0 = r2;
        r1 = r2;
        goto L_0x0055;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.Response.fromHttpConnection(java.net.HttpURLConnection, com.facebook.RequestBatch):java.util.List<com.facebook.Response>");
    }

    static FileLruCache getResponseCache() {
        if (responseCache == null) {
            Context staticContext = Session.getStaticContext();
            if (staticContext != null) {
                responseCache = new FileLruCache(staticContext, RESPONSE_CACHE_TAG, new Limits());
            }
        }
        return responseCache;
    }

    public final HttpURLConnection getConnection() {
        return this.connection;
    }

    public final FacebookRequestError getError() {
        return this.error;
    }

    public final GraphObject getGraphObject() {
        return this.graphObject;
    }

    public final <T extends GraphObject> T getGraphObjectAs(Class<T> cls) {
        if (this.graphObject == null) {
            return null;
        }
        if (cls != null) {
            return this.graphObject.cast(cls);
        }
        throw new NullPointerException("Must pass in a valid interface that extends GraphObject");
    }

    public final GraphObjectList<GraphObject> getGraphObjectList() {
        return this.graphObjectList;
    }

    public final <T extends GraphObject> GraphObjectList<T> getGraphObjectListAs(Class<T> cls) {
        return this.graphObjectList == null ? null : this.graphObjectList.castToListOf(cls);
    }

    public final boolean getIsFromCache() {
        return this.isFromCache;
    }

    public String getRawResponse() {
        return this.rawResponse;
    }

    public Request getRequest() {
        return this.request;
    }

    public Request getRequestForPagedResults(PagingDirection pagingDirection) {
        String next;
        if (this.graphObject != null) {
            PagingInfo paging = ((PagedResults) this.graphObject.cast(PagedResults.class)).getPaging();
            if (paging != null) {
                next = pagingDirection == PagingDirection.NEXT ? paging.getNext() : paging.getPrevious();
                if (Utility.isNullOrEmpty(next)) {
                    return null;
                }
                if (next == null && next.equals(this.request.getUrlForSingleRequest())) {
                    return null;
                }
                try {
                    return new Request(this.request.getSession(), new URL(next));
                } catch (MalformedURLException e) {
                    return null;
                }
            }
        }
        next = null;
        if (Utility.isNullOrEmpty(next)) {
            return null;
        }
        if (next == null) {
        }
        return new Request(this.request.getSession(), new URL(next));
    }

    public String toString() {
        String format;
        try {
            String str = "%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(this.connection != null ? this.connection.getResponseCode() : HttpResponseCode.OK);
            format = String.format(str, objArr);
        } catch (IOException e) {
            format = "unknown";
        }
        return "{Response: " + " responseCode: " + format + ", graphObject: " + this.graphObject + ", error: " + this.error + ", isFromCache:" + this.isFromCache + "}";
    }
}
