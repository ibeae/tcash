package com.facebook;

import android.os.Bundle;
import com.appsflyer.MonitorMessages;
import com.facebook.internal.Validate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class TokenCachingStrategy {
    public static final String DECLINED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.DeclinedPermissions";
    public static final String EXPIRATION_DATE_KEY = "com.facebook.TokenCachingStrategy.ExpirationDate";
    private static final long INVALID_BUNDLE_MILLISECONDS = Long.MIN_VALUE;
    private static final String IS_SSO_KEY = "com.facebook.TokenCachingStrategy.IsSSO";
    public static final String LAST_REFRESH_DATE_KEY = "com.facebook.TokenCachingStrategy.LastRefreshDate";
    public static final String PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.Permissions";
    public static final String TOKEN_KEY = "com.facebook.TokenCachingStrategy.Token";
    public static final String TOKEN_SOURCE_KEY = "com.facebook.TokenCachingStrategy.AccessTokenSource";
    public static final String USER_FBID_KEY = "com.facebook.TokenCachingStrategy.UserFBID";

    static Date getDate(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        long j = bundle.getLong(str, Long.MIN_VALUE);
        return j != Long.MIN_VALUE ? new Date(j) : null;
    }

    public static Date getExpirationDate(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return getDate(bundle, EXPIRATION_DATE_KEY);
    }

    public static long getExpirationMilliseconds(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return bundle.getLong(EXPIRATION_DATE_KEY);
    }

    public static Date getLastRefreshDate(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return getDate(bundle, LAST_REFRESH_DATE_KEY);
    }

    public static long getLastRefreshMilliseconds(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return bundle.getLong(LAST_REFRESH_DATE_KEY);
    }

    public static List<String> getPermissions(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return bundle.getStringArrayList(PERMISSIONS_KEY);
    }

    public static AccessTokenSource getSource(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return bundle.containsKey(TOKEN_SOURCE_KEY) ? (AccessTokenSource) bundle.getSerializable(TOKEN_SOURCE_KEY) : bundle.getBoolean(IS_SSO_KEY) ? AccessTokenSource.FACEBOOK_APPLICATION_WEB : AccessTokenSource.WEB_VIEW;
    }

    public static String getToken(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return bundle.getString(TOKEN_KEY);
    }

    public static boolean hasTokenInformation(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        String string = bundle.getString(TOKEN_KEY);
        return (string == null || string.length() == 0 || bundle.getLong(EXPIRATION_DATE_KEY, 0) == 0) ? false : true;
    }

    static void putDate(Bundle bundle, String str, Date date) {
        bundle.putLong(str, date.getTime());
    }

    public static void putDeclinedPermissions(Bundle bundle, List<String> list) {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(list, MonitorMessages.VALUE);
        bundle.putStringArrayList(DECLINED_PERMISSIONS_KEY, list instanceof ArrayList ? (ArrayList) list : new ArrayList(list));
    }

    public static void putExpirationDate(Bundle bundle, Date date) {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(date, MonitorMessages.VALUE);
        putDate(bundle, EXPIRATION_DATE_KEY, date);
    }

    public static void putExpirationMilliseconds(Bundle bundle, long j) {
        Validate.notNull(bundle, "bundle");
        bundle.putLong(EXPIRATION_DATE_KEY, j);
    }

    public static void putLastRefreshDate(Bundle bundle, Date date) {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(date, MonitorMessages.VALUE);
        putDate(bundle, LAST_REFRESH_DATE_KEY, date);
    }

    public static void putLastRefreshMilliseconds(Bundle bundle, long j) {
        Validate.notNull(bundle, "bundle");
        bundle.putLong(LAST_REFRESH_DATE_KEY, j);
    }

    public static void putPermissions(Bundle bundle, List<String> list) {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(list, MonitorMessages.VALUE);
        bundle.putStringArrayList(PERMISSIONS_KEY, list instanceof ArrayList ? (ArrayList) list : new ArrayList(list));
    }

    public static void putSource(Bundle bundle, AccessTokenSource accessTokenSource) {
        Validate.notNull(bundle, "bundle");
        bundle.putSerializable(TOKEN_SOURCE_KEY, accessTokenSource);
    }

    public static void putToken(Bundle bundle, String str) {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(str, MonitorMessages.VALUE);
        bundle.putString(TOKEN_KEY, str);
    }

    public abstract void clear();

    public abstract Bundle load();

    public abstract void save(Bundle bundle);
}
