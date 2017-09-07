package com.facebook;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class AccessToken implements Serializable {
    static final String ACCESS_TOKEN_KEY = "access_token";
    private static final Date ALREADY_EXPIRED_EXPIRATION_TIME = MIN_DATE;
    private static final AccessTokenSource DEFAULT_ACCESS_TOKEN_SOURCE = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
    private static final Date DEFAULT_EXPIRATION_TIME = MAX_DATE;
    private static final Date DEFAULT_LAST_REFRESH_TIME = new Date();
    static final String EXPIRES_IN_KEY = "expires_in";
    private static final Date MAX_DATE = new Date(Long.MAX_VALUE);
    private static final Date MIN_DATE = new Date(Long.MIN_VALUE);
    private static final long serialVersionUID = 1;
    private final List<String> declinedPermissions;
    private final Date expires;
    private final Date lastRefresh;
    private final List<String> permissions;
    private final AccessTokenSource source;
    private final String token;

    private static class SerializationProxyV1 implements Serializable {
        private static final long serialVersionUID = -2488473066578201069L;
        private final Date expires;
        private final Date lastRefresh;
        private final List<String> permissions;
        private final AccessTokenSource source;
        private final String token;

        private SerializationProxyV1(String str, Date date, List<String> list, AccessTokenSource accessTokenSource, Date date2) {
            this.expires = date;
            this.permissions = list;
            this.token = str;
            this.source = accessTokenSource;
            this.lastRefresh = date2;
        }

        private Object readResolve() {
            return new AccessToken(this.token, this.expires, this.permissions, null, this.source, this.lastRefresh);
        }
    }

    private static class SerializationProxyV2 implements Serializable {
        private static final long serialVersionUID = -2488473066578201068L;
        private final List<String> declinedPermissions;
        private final Date expires;
        private final Date lastRefresh;
        private final List<String> permissions;
        private final AccessTokenSource source;
        private final String token;

        private SerializationProxyV2(String str, Date date, List<String> list, List<String> list2, AccessTokenSource accessTokenSource, Date date2) {
            this.expires = date;
            this.permissions = list;
            this.declinedPermissions = list2;
            this.token = str;
            this.source = accessTokenSource;
            this.lastRefresh = date2;
        }

        private Object readResolve() {
            return new AccessToken(this.token, this.expires, this.permissions, this.declinedPermissions, this.source, this.lastRefresh);
        }
    }

    AccessToken(String str, Date date, List<String> list, List<String> list2, AccessTokenSource accessTokenSource, Date date2) {
        List emptyList;
        List emptyList2;
        if (list == null) {
            emptyList = Collections.emptyList();
        }
        if (list2 == null) {
            emptyList2 = Collections.emptyList();
        }
        this.expires = date;
        this.permissions = Collections.unmodifiableList(emptyList);
        this.declinedPermissions = Collections.unmodifiableList(emptyList2);
        this.token = str;
        this.source = accessTokenSource;
        this.lastRefresh = date2;
    }

    private void appendPermissions(StringBuilder stringBuilder) {
        stringBuilder.append(" permissions:");
        if (this.permissions == null) {
            stringBuilder.append("null");
            return;
        }
        stringBuilder.append("[");
        stringBuilder.append(TextUtils.join(", ", this.permissions));
        stringBuilder.append("]");
    }

    static AccessToken createEmptyToken() {
        return new AccessToken("", ALREADY_EXPIRED_EXPIRATION_TIME, null, null, AccessTokenSource.NONE, DEFAULT_LAST_REFRESH_TIME);
    }

    private static AccessToken createFromBundle(List<String> list, Bundle bundle, AccessTokenSource accessTokenSource, Date date) {
        String string = bundle.getString("access_token");
        Date bundleLongAsDate = getBundleLongAsDate(bundle, "expires_in", date);
        if (Utility.isNullOrEmpty(string) || bundleLongAsDate == null) {
            return null;
        }
        return new AccessToken(string, bundleLongAsDate, list, null, accessTokenSource, new Date());
    }

    static AccessToken createFromCache(Bundle bundle) {
        return new AccessToken(bundle.getString(TokenCachingStrategy.TOKEN_KEY), TokenCachingStrategy.getDate(bundle, TokenCachingStrategy.EXPIRATION_DATE_KEY), getPermissionsFromBundle(bundle, TokenCachingStrategy.PERMISSIONS_KEY), getPermissionsFromBundle(bundle, TokenCachingStrategy.DECLINED_PERMISSIONS_KEY), TokenCachingStrategy.getSource(bundle), TokenCachingStrategy.getDate(bundle, TokenCachingStrategy.LAST_REFRESH_DATE_KEY));
    }

    public static AccessToken createFromExistingAccessToken(String str, Date date, Date date2, AccessTokenSource accessTokenSource, List<String> list) {
        return new AccessToken(str, date == null ? DEFAULT_EXPIRATION_TIME : date, list, null, accessTokenSource == null ? DEFAULT_ACCESS_TOKEN_SOURCE : accessTokenSource, date2 == null ? DEFAULT_LAST_REFRESH_TIME : date2);
    }

    public static AccessToken createFromNativeLinkingIntent(Intent intent) {
        Validate.notNull(intent, "intent");
        return intent.getExtras() == null ? null : createFromBundle(null, intent.getExtras(), AccessTokenSource.FACEBOOK_APPLICATION_WEB, new Date());
    }

    static AccessToken createFromNativeLogin(Bundle bundle, AccessTokenSource accessTokenSource) {
        return createNew(bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS), null, bundle.getString(NativeProtocol.EXTRA_ACCESS_TOKEN), getBundleLongAsDate(bundle, NativeProtocol.EXTRA_EXPIRES_SECONDS_SINCE_EPOCH, new Date(0)), accessTokenSource);
    }

    @SuppressLint({"FieldGetter"})
    static AccessToken createFromRefresh(AccessToken accessToken, Bundle bundle) {
        if (accessToken.source == AccessTokenSource.FACEBOOK_APPLICATION_WEB || accessToken.source == AccessTokenSource.FACEBOOK_APPLICATION_NATIVE || accessToken.source == AccessTokenSource.FACEBOOK_APPLICATION_SERVICE) {
            Date bundleLongAsDate = getBundleLongAsDate(bundle, "expires_in", new Date(0));
            return createNew(accessToken.getPermissions(), accessToken.getDeclinedPermissions(), bundle.getString("access_token"), bundleLongAsDate, accessToken.source);
        }
        throw new FacebookException("Invalid token source: " + accessToken.source);
    }

    static AccessToken createFromString(String str, List<String> list, AccessTokenSource accessTokenSource) {
        return new AccessToken(str, DEFAULT_EXPIRATION_TIME, list, null, accessTokenSource, DEFAULT_LAST_REFRESH_TIME);
    }

    static AccessToken createFromTokenWithRefreshedPermissions(AccessToken accessToken, List<String> list, List<String> list2) {
        return new AccessToken(accessToken.token, accessToken.expires, list, list2, accessToken.source, accessToken.lastRefresh);
    }

    static AccessToken createFromWebBundle(List<String> list, Bundle bundle, AccessTokenSource accessTokenSource) {
        List arrayList;
        Date bundleLongAsDate = getBundleLongAsDate(bundle, "expires_in", new Date());
        String string = bundle.getString("access_token");
        String string2 = bundle.getString("granted_scopes");
        if (!Utility.isNullOrEmpty(string2)) {
            arrayList = new ArrayList(Arrays.asList(string2.split(",")));
        }
        String string3 = bundle.getString("denied_scopes");
        List list2 = null;
        if (!Utility.isNullOrEmpty(string3)) {
            list2 = new ArrayList(Arrays.asList(string3.split(",")));
        }
        return createNew(arrayList, list2, string, bundleLongAsDate, accessTokenSource);
    }

    private static AccessToken createNew(List<String> list, List<String> list2, String str, Date date, AccessTokenSource accessTokenSource) {
        if (Utility.isNullOrEmpty(str) || date == null) {
            return createEmptyToken();
        }
        return new AccessToken(str, date, list, list2, accessTokenSource, new Date());
    }

    private static Date getBundleLongAsDate(Bundle bundle, String str, Date date) {
        if (bundle == null) {
            return null;
        }
        long longValue;
        Object obj = bundle.get(str);
        if (obj instanceof Long) {
            longValue = ((Long) obj).longValue();
        } else if (!(obj instanceof String)) {
            return null;
        } else {
            try {
                longValue = Long.parseLong((String) obj);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        if (longValue == 0) {
            return new Date(Long.MAX_VALUE);
        }
        return new Date((longValue * 1000) + date.getTime());
    }

    static List<String> getPermissionsFromBundle(Bundle bundle, String str) {
        Collection stringArrayList = bundle.getStringArrayList(str);
        return stringArrayList == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(stringArrayList));
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Cannot readObject, serialization proxy required");
    }

    private String tokenToString() {
        return this.token == null ? "null" : Settings.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS) ? this.token : "ACCESS_TOKEN_REMOVED";
    }

    private Object writeReplace() {
        return new SerializationProxyV2(this.token, this.expires, this.permissions, this.declinedPermissions, this.source, this.lastRefresh);
    }

    public List<String> getDeclinedPermissions() {
        return this.declinedPermissions;
    }

    public Date getExpires() {
        return this.expires;
    }

    public Date getLastRefresh() {
        return this.lastRefresh;
    }

    public List<String> getPermissions() {
        return this.permissions;
    }

    public AccessTokenSource getSource() {
        return this.source;
    }

    public String getToken() {
        return this.token;
    }

    boolean isInvalid() {
        return Utility.isNullOrEmpty(this.token) || new Date().after(this.expires);
    }

    Bundle toCacheBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(TokenCachingStrategy.TOKEN_KEY, this.token);
        TokenCachingStrategy.putDate(bundle, TokenCachingStrategy.EXPIRATION_DATE_KEY, this.expires);
        bundle.putStringArrayList(TokenCachingStrategy.PERMISSIONS_KEY, new ArrayList(this.permissions));
        bundle.putStringArrayList(TokenCachingStrategy.DECLINED_PERMISSIONS_KEY, new ArrayList(this.declinedPermissions));
        bundle.putSerializable(TokenCachingStrategy.TOKEN_SOURCE_KEY, this.source);
        TokenCachingStrategy.putDate(bundle, TokenCachingStrategy.LAST_REFRESH_DATE_KEY, this.lastRefresh);
        return bundle;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{AccessToken");
        stringBuilder.append(" token:").append(tokenToString());
        appendPermissions(stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
