package com.facebook;

import com.facebook.android.C0426R;
import com.facebook.internal.Utility;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.HttpResponseCode;

public final class FacebookRequestError {
    private static final String BODY_KEY = "body";
    private static final String CODE_KEY = "code";
    private static final int EC_APP_NOT_INSTALLED = 458;
    private static final int EC_APP_TOO_MANY_CALLS = 4;
    private static final int EC_EXPIRED = 463;
    private static final int EC_INVALID_SESSION = 102;
    private static final int EC_INVALID_TOKEN = 190;
    private static final int EC_PASSWORD_CHANGED = 460;
    private static final int EC_PERMISSION_DENIED = 10;
    private static final Range EC_RANGE_PERMISSION = new Range(HttpResponseCode.OK, 299);
    private static final int EC_SERVICE_UNAVAILABLE = 2;
    private static final int EC_UNCONFIRMED_USER = 464;
    private static final int EC_UNKNOWN_ERROR = 1;
    private static final int EC_USER_CHECKPOINTED = 459;
    private static final int EC_USER_TOO_MANY_CALLS = 17;
    private static final String ERROR_CODE_FIELD_KEY = "code";
    private static final String ERROR_CODE_KEY = "error_code";
    private static final String ERROR_IS_TRANSIENT_KEY = "is_transient";
    private static final String ERROR_KEY = "error";
    private static final String ERROR_MESSAGE_FIELD_KEY = "message";
    private static final String ERROR_MSG_KEY = "error_msg";
    private static final String ERROR_REASON_KEY = "error_reason";
    private static final String ERROR_SUB_CODE_KEY = "error_subcode";
    private static final String ERROR_TYPE_FIELD_KEY = "type";
    private static final String ERROR_USER_MSG_KEY = "error_user_msg";
    private static final String ERROR_USER_TITLE_KEY = "error_user_title";
    private static final Range HTTP_RANGE_CLIENT_ERROR = new Range(HttpResponseCode.BAD_REQUEST, 499);
    private static final Range HTTP_RANGE_SERVER_ERROR = new Range(HttpResponseCode.INTERNAL_SERVER_ERROR, 599);
    private static final Range HTTP_RANGE_SUCCESS = new Range(HttpResponseCode.OK, 299);
    public static final int INVALID_ERROR_CODE = -1;
    public static final int INVALID_HTTP_STATUS_CODE = -1;
    private static final int INVALID_MESSAGE_ID = 0;
    private final Object batchRequestResult;
    private final Category category;
    private final HttpURLConnection connection;
    private final int errorCode;
    private final boolean errorIsTransient;
    private final String errorMessage;
    private final String errorType;
    private final String errorUserMessage;
    private final String errorUserTitle;
    private final FacebookException exception;
    private final JSONObject requestResult;
    private final JSONObject requestResultBody;
    private final int requestStatusCode;
    private final boolean shouldNotifyUser;
    private final int subErrorCode;
    private final int userActionMessageId;

    public enum Category {
        AUTHENTICATION_RETRY,
        AUTHENTICATION_REOPEN_SESSION,
        PERMISSION,
        SERVER,
        THROTTLING,
        OTHER,
        BAD_REQUEST,
        CLIENT
    }

    private static class Range {
        private final int end;
        private final int start;

        private Range(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        boolean contains(int i) {
            return this.start <= i && i <= this.end;
        }
    }

    private FacebookRequestError(int i, int i2, int i3, String str, String str2, String str3, String str4, boolean z, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection) {
        this(i, i2, i3, str, str2, str3, str4, z, jSONObject, jSONObject2, obj, httpURLConnection, null);
    }

    private FacebookRequestError(int i, int i2, int i3, String str, String str2, String str3, String str4, boolean z, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        Object obj2;
        Category category;
        int i4;
        this.requestStatusCode = i;
        this.errorCode = i2;
        this.subErrorCode = i3;
        this.errorType = str;
        this.errorMessage = str2;
        this.requestResultBody = jSONObject;
        this.requestResult = jSONObject2;
        this.batchRequestResult = obj;
        this.connection = httpURLConnection;
        this.errorUserTitle = str3;
        this.errorUserMessage = str4;
        this.errorIsTransient = z;
        if (facebookException != null) {
            this.exception = facebookException;
            obj2 = 1;
        } else {
            this.exception = new FacebookServiceException(this, str2);
            obj2 = null;
        }
        Category category2 = null;
        int i5 = 0;
        if (obj2 != null) {
            category = Category.CLIENT;
            i4 = 0;
        } else {
            if (i2 == 1 || i2 == 2) {
                category2 = Category.SERVER;
            } else if (i2 == 4 || i2 == 17) {
                category2 = Category.THROTTLING;
            } else if (i2 == 10 || EC_RANGE_PERMISSION.contains(i2)) {
                category2 = Category.PERMISSION;
                i5 = C0426R.string.com_facebook_requesterror_permissions;
            } else if (i2 == EC_INVALID_SESSION || i2 == EC_INVALID_TOKEN) {
                if (i3 == EC_USER_CHECKPOINTED || i3 == EC_UNCONFIRMED_USER) {
                    category2 = Category.AUTHENTICATION_RETRY;
                    i5 = C0426R.string.com_facebook_requesterror_web_login;
                } else {
                    category2 = Category.AUTHENTICATION_REOPEN_SESSION;
                    i5 = (i3 == EC_APP_NOT_INSTALLED || i3 == EC_EXPIRED) ? C0426R.string.com_facebook_requesterror_relogin : i3 == EC_PASSWORD_CHANGED ? C0426R.string.com_facebook_requesterror_password_changed : C0426R.string.com_facebook_requesterror_reconnect;
                }
            }
            if (category2 != null) {
                category = category2;
                i4 = i5;
            } else if (HTTP_RANGE_CLIENT_ERROR.contains(i)) {
                category = Category.BAD_REQUEST;
                i4 = i5;
            } else if (HTTP_RANGE_SERVER_ERROR.contains(i)) {
                category = Category.SERVER;
                i4 = i5;
            } else {
                category = Category.OTHER;
                i4 = i5;
            }
        }
        boolean z2 = str4 != null && str4.length() > 0;
        this.category = category;
        this.userActionMessageId = i4;
        this.shouldNotifyUser = z2;
    }

    public FacebookRequestError(int i, String str, String str2) {
        this(-1, i, -1, str, str2, null, null, false, null, null, null, null, null);
    }

    FacebookRequestError(HttpURLConnection httpURLConnection, Exception exception) {
        this(-1, -1, -1, null, null, null, null, false, null, null, null, httpURLConnection, exception instanceof FacebookException ? (FacebookException) exception : new FacebookException((Throwable) exception));
    }

    static FacebookRequestError checkResponseAndCreateError(JSONObject jSONObject, Object obj, HttpURLConnection httpURLConnection) {
        try {
            if (jSONObject.has("code")) {
                int i = jSONObject.getInt("code");
                Object stringPropertyAsJSON = Utility.getStringPropertyAsJSON(jSONObject, BODY_KEY, Response.NON_JSON_RESPONSE_PROPERTY);
                if (stringPropertyAsJSON != null && (stringPropertyAsJSON instanceof JSONObject)) {
                    JSONObject jSONObject2 = (JSONObject) stringPropertyAsJSON;
                    String str = null;
                    String str2 = null;
                    String str3 = null;
                    String str4 = null;
                    boolean z = false;
                    int i2 = -1;
                    int i3 = -1;
                    Object obj2 = null;
                    if (jSONObject2.has("error")) {
                        JSONObject jSONObject3 = (JSONObject) Utility.getStringPropertyAsJSON(jSONObject2, "error", null);
                        str = jSONObject3.optString(ERROR_TYPE_FIELD_KEY, null);
                        str2 = jSONObject3.optString("message", null);
                        i2 = jSONObject3.optInt("code", -1);
                        i3 = jSONObject3.optInt(ERROR_SUB_CODE_KEY, -1);
                        str3 = jSONObject3.optString(ERROR_USER_MSG_KEY, null);
                        str4 = jSONObject3.optString(ERROR_USER_TITLE_KEY, null);
                        z = jSONObject3.optBoolean(ERROR_IS_TRANSIENT_KEY, false);
                        obj2 = 1;
                    } else if (jSONObject2.has(ERROR_CODE_KEY) || jSONObject2.has(ERROR_MSG_KEY) || jSONObject2.has(ERROR_REASON_KEY)) {
                        str = jSONObject2.optString(ERROR_REASON_KEY, null);
                        str2 = jSONObject2.optString(ERROR_MSG_KEY, null);
                        i2 = jSONObject2.optInt(ERROR_CODE_KEY, -1);
                        i3 = jSONObject2.optInt(ERROR_SUB_CODE_KEY, -1);
                        obj2 = 1;
                    }
                    if (obj2 != null) {
                        return new FacebookRequestError(i, i2, i3, str, str2, str4, str3, z, jSONObject2, jSONObject, obj, httpURLConnection);
                    }
                }
                if (!HTTP_RANGE_SUCCESS.contains(i)) {
                    return new FacebookRequestError(i, -1, -1, null, null, null, null, false, jSONObject.has(BODY_KEY) ? (JSONObject) Utility.getStringPropertyAsJSON(jSONObject, BODY_KEY, Response.NON_JSON_RESPONSE_PROPERTY) : null, jSONObject, obj, httpURLConnection);
                }
            }
        } catch (JSONException e) {
        }
        return null;
    }

    public Object getBatchRequestResult() {
        return this.batchRequestResult;
    }

    public Category getCategory() {
        return this.category;
    }

    public HttpURLConnection getConnection() {
        return this.connection;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public boolean getErrorIsTransient() {
        return this.errorIsTransient;
    }

    public String getErrorMessage() {
        return this.errorMessage != null ? this.errorMessage : this.exception.getLocalizedMessage();
    }

    public String getErrorType() {
        return this.errorType;
    }

    public String getErrorUserMessage() {
        return this.errorUserMessage;
    }

    public String getErrorUserTitle() {
        return this.errorUserTitle;
    }

    public FacebookException getException() {
        return this.exception;
    }

    public JSONObject getRequestResult() {
        return this.requestResult;
    }

    public JSONObject getRequestResultBody() {
        return this.requestResultBody;
    }

    public int getRequestStatusCode() {
        return this.requestStatusCode;
    }

    public int getSubErrorCode() {
        return this.subErrorCode;
    }

    public int getUserActionMessageId() {
        return this.userActionMessageId;
    }

    public boolean shouldNotifyUser() {
        return this.shouldNotifyUser;
    }

    public String toString() {
        return "{HttpStatus: " + this.requestStatusCode + ", errorCode: " + this.errorCode + ", errorType: " + this.errorType + ", errorMessage: " + getErrorMessage() + "}";
    }
}
