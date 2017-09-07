package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.SessionDefaultAudience;
import com.facebook.Settings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;

public final class NativeProtocol {
    public static final String ACTION_FEED_DIALOG = "com.facebook.platform.action.request.FEED_DIALOG";
    public static final String ACTION_FEED_DIALOG_REPLY = "com.facebook.platform.action.reply.FEED_DIALOG";
    public static final String ACTION_LIKE_DIALOG = "com.facebook.platform.action.request.LIKE_DIALOG";
    public static final String ACTION_LIKE_DIALOG_REPLY = "com.facebook.platform.action.reply.LIKE_DIALOG";
    public static final String ACTION_MESSAGE_DIALOG = "com.facebook.platform.action.request.MESSAGE_DIALOG";
    public static final String ACTION_MESSAGE_DIALOG_REPLY = "com.facebook.platform.action.reply.MESSAGE_DIALOG";
    public static final String ACTION_OGACTIONPUBLISH_DIALOG = "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
    public static final String ACTION_OGACTIONPUBLISH_DIALOG_REPLY = "com.facebook.platform.action.reply.OGACTIONPUBLISH_DIALOG";
    public static final String ACTION_OGMESSAGEPUBLISH_DIALOG = "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
    public static final String ACTION_OGMESSAGEPUBLISH_DIALOG_REPLY = "com.facebook.platform.action.reply.OGMESSAGEPUBLISH_DIALOG";
    public static final String AUDIENCE_EVERYONE = "everyone";
    public static final String AUDIENCE_FRIENDS = "friends";
    public static final String AUDIENCE_ME = "only_me";
    public static final String BRIDGE_ARG_ACTION_ID_STRING = "action_id";
    public static final String BRIDGE_ARG_APP_NAME_STRING = "app_name";
    public static final String BRIDGE_ARG_ERROR_BUNDLE = "error";
    private static final String CONTENT_SCHEME = "content://";
    public static final int DIALOG_REQUEST_CODE = 64207;
    public static final String ERROR_APPLICATION_ERROR = "ApplicationError";
    public static final String ERROR_NETWORK_ERROR = "NetworkError";
    public static final String ERROR_PERMISSION_DENIED = "PermissionDenied";
    public static final String ERROR_PROTOCOL_ERROR = "ProtocolError";
    public static final String ERROR_SERVICE_DISABLED = "ServiceDisabled";
    public static final String ERROR_UNKNOWN_ERROR = "UnknownError";
    public static final String ERROR_USER_CANCELED = "UserCanceled";
    public static final String EXTRA_ACCESS_TOKEN = "com.facebook.platform.extra.ACCESS_TOKEN";
    public static final String EXTRA_ACTION = "com.facebook.platform.extra.ACTION";
    public static final String EXTRA_ACTION_TYPE = "com.facebook.platform.extra.ACTION_TYPE";
    public static final String EXTRA_APPLICATION_ID = "com.facebook.platform.extra.APPLICATION_ID";
    public static final String EXTRA_APPLICATION_NAME = "com.facebook.platform.extra.APPLICATION_NAME";
    public static final String EXTRA_DATA_FAILURES_FATAL = "com.facebook.platform.extra.DATA_FAILURES_FATAL";
    public static final String EXTRA_DESCRIPTION = "com.facebook.platform.extra.DESCRIPTION";
    public static final String EXTRA_EXPIRES_SECONDS_SINCE_EPOCH = "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH";
    public static final String EXTRA_FRIEND_TAGS = "com.facebook.platform.extra.FRIENDS";
    public static final String EXTRA_GET_INSTALL_DATA_PACKAGE = "com.facebook.platform.extra.INSTALLDATA_PACKAGE";
    public static final String EXTRA_IMAGE = "com.facebook.platform.extra.IMAGE";
    public static final String EXTRA_LIKE_COUNT_STRING_WITHOUT_LIKE = "com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE";
    public static final String EXTRA_LIKE_COUNT_STRING_WITH_LIKE = "com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE";
    public static final String EXTRA_LINK = "com.facebook.platform.extra.LINK";
    public static final String EXTRA_OBJECT_ID = "com.facebook.platform.extra.OBJECT_ID";
    public static final String EXTRA_OBJECT_IS_LIKED = "com.facebook.platform.extra.OBJECT_IS_LIKED";
    public static final String EXTRA_PERMISSIONS = "com.facebook.platform.extra.PERMISSIONS";
    public static final String EXTRA_PHOTOS = "com.facebook.platform.extra.PHOTOS";
    public static final String EXTRA_PLACE_TAG = "com.facebook.platform.extra.PLACE";
    public static final String EXTRA_PREVIEW_PROPERTY_NAME = "com.facebook.platform.extra.PREVIEW_PROPERTY_NAME";
    public static final String EXTRA_PROTOCOL_ACTION = "com.facebook.platform.protocol.PROTOCOL_ACTION";
    public static final String EXTRA_PROTOCOL_BRIDGE_ARGS = "com.facebook.platform.protocol.BRIDGE_ARGS";
    public static final String EXTRA_PROTOCOL_CALL_ID = "com.facebook.platform.protocol.CALL_ID";
    public static final String EXTRA_PROTOCOL_METHOD_ARGS = "com.facebook.platform.protocol.METHOD_ARGS";
    public static final String EXTRA_PROTOCOL_METHOD_RESULTS = "com.facebook.platform.protocol.RESULT_ARGS";
    public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.platform.protocol.PROTOCOL_VERSION";
    static final String EXTRA_PROTOCOL_VERSIONS = "com.facebook.platform.extra.PROTOCOL_VERSIONS";
    public static final String EXTRA_REF = "com.facebook.platform.extra.REF";
    public static final String EXTRA_SOCIAL_SENTENCE_WITHOUT_LIKE = "com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE";
    public static final String EXTRA_SOCIAL_SENTENCE_WITH_LIKE = "com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE";
    public static final String EXTRA_SUBTITLE = "com.facebook.platform.extra.SUBTITLE";
    public static final String EXTRA_TITLE = "com.facebook.platform.extra.TITLE";
    public static final String EXTRA_UNLIKE_TOKEN = "com.facebook.platform.extra.UNLIKE_TOKEN";
    private static final NativeAppInfo FACEBOOK_APP_INFO = new KatanaAppInfo();
    private static final String FACEBOOK_PROXY_AUTH_ACTIVITY = "com.facebook.katana.ProxyAuth";
    public static final String FACEBOOK_PROXY_AUTH_APP_ID_KEY = "client_id";
    public static final String FACEBOOK_PROXY_AUTH_E2E_KEY = "e2e";
    public static final String FACEBOOK_PROXY_AUTH_PERMISSIONS_KEY = "scope";
    private static final String FACEBOOK_TOKEN_REFRESH_ACTIVITY = "com.facebook.katana.platform.TokenRefreshService";
    public static final String IMAGE_URL_KEY = "url";
    public static final String IMAGE_USER_GENERATED_KEY = "user_generated";
    static final String INTENT_ACTION_PLATFORM_ACTIVITY = "com.facebook.platform.PLATFORM_ACTIVITY";
    static final String INTENT_ACTION_PLATFORM_SERVICE = "com.facebook.platform.PLATFORM_SERVICE";
    private static final List<Integer> KNOWN_PROTOCOL_VERSIONS = Arrays.asList(new Integer[]{Integer.valueOf(PROTOCOL_VERSION_20141001), Integer.valueOf(PROTOCOL_VERSION_20140701), Integer.valueOf(PROTOCOL_VERSION_20140324), Integer.valueOf(PROTOCOL_VERSION_20140204), Integer.valueOf(PROTOCOL_VERSION_20131107), Integer.valueOf(PROTOCOL_VERSION_20130618), Integer.valueOf(PROTOCOL_VERSION_20130502), Integer.valueOf(PROTOCOL_VERSION_20121101)});
    public static final int MESSAGE_GET_ACCESS_TOKEN_REPLY = 65537;
    public static final int MESSAGE_GET_ACCESS_TOKEN_REQUEST = 65536;
    public static final int MESSAGE_GET_INSTALL_DATA_REPLY = 65541;
    public static final int MESSAGE_GET_INSTALL_DATA_REQUEST = 65540;
    public static final int MESSAGE_GET_LIKE_STATUS_REPLY = 65543;
    public static final int MESSAGE_GET_LIKE_STATUS_REQUEST = 65542;
    static final int MESSAGE_GET_PROTOCOL_VERSIONS_REPLY = 65539;
    static final int MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST = 65538;
    public static final String METHOD_ARGS_ACTION = "ACTION";
    public static final String METHOD_ARGS_ACTION_TYPE = "ACTION_TYPE";
    public static final String METHOD_ARGS_DATA_FAILURES_FATAL = "DATA_FAILURES_FATAL";
    public static final String METHOD_ARGS_DESCRIPTION = "DESCRIPTION";
    public static final String METHOD_ARGS_FRIEND_TAGS = "FRIENDS";
    public static final String METHOD_ARGS_IMAGE = "IMAGE";
    public static final String METHOD_ARGS_LINK = "LINK";
    public static final String METHOD_ARGS_OBJECT_ID = "object_id";
    public static final String METHOD_ARGS_PHOTOS = "PHOTOS";
    public static final String METHOD_ARGS_PLACE_TAG = "PLACE";
    public static final String METHOD_ARGS_PREVIEW_PROPERTY_NAME = "PREVIEW_PROPERTY_NAME";
    public static final String METHOD_ARGS_REF = "REF";
    public static final String METHOD_ARGS_SUBTITLE = "SUBTITLE";
    public static final String METHOD_ARGS_TITLE = "TITLE";
    public static final int NO_PROTOCOL_AVAILABLE = -1;
    public static final String OPEN_GRAPH_CREATE_OBJECT_KEY = "fbsdk:create_object";
    private static final String PLATFORM_PROVIDER_VERSIONS = ".provider.PlatformProvider/versions";
    private static final String PLATFORM_PROVIDER_VERSION_COLUMN = "version";
    public static final int PROTOCOL_VERSION_20121101 = 20121101;
    public static final int PROTOCOL_VERSION_20130502 = 20130502;
    public static final int PROTOCOL_VERSION_20130618 = 20130618;
    public static final int PROTOCOL_VERSION_20131107 = 20131107;
    public static final int PROTOCOL_VERSION_20140204 = 20140204;
    public static final int PROTOCOL_VERSION_20140324 = 20140324;
    public static final int PROTOCOL_VERSION_20140701 = 20140701;
    public static final int PROTOCOL_VERSION_20141001 = 20141001;
    public static final String STATUS_ERROR_CODE = "com.facebook.platform.status.ERROR_CODE";
    public static final String STATUS_ERROR_DESCRIPTION = "com.facebook.platform.status.ERROR_DESCRIPTION";
    public static final String STATUS_ERROR_JSON = "com.facebook.platform.status.ERROR_JSON";
    public static final String STATUS_ERROR_SUBCODE = "com.facebook.platform.status.ERROR_SUBCODE";
    public static final String STATUS_ERROR_TYPE = "com.facebook.platform.status.ERROR_TYPE";
    private static Map<String, List<NativeAppInfo>> actionToAppInfoMap = buildActionToAppInfoMap();
    private static List<NativeAppInfo> facebookAppInfoList = buildFacebookAppList();

    private static abstract class NativeAppInfo {
        private static final String FBI_HASH = "a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc";
        private static final String FBL_HASH = "5e8f16062ea3cd2c4a0d547876baa6f38cabf625";
        private static final String FBR_HASH = "8a3c4b262d721acd49a4bf97d5213199c86fa2b9";
        private static final HashSet<String> validAppSignatureHashes = buildAppSignatureHashes();

        private NativeAppInfo() {
        }

        private static HashSet<String> buildAppSignatureHashes() {
            HashSet<String> hashSet = new HashSet();
            hashSet.add(FBR_HASH);
            hashSet.add(FBI_HASH);
            hashSet.add(FBL_HASH);
            return hashSet;
        }

        protected abstract String getPackage();

        public boolean validateSignature(Context context, String str) {
            String str2 = Build.BRAND;
            int i = context.getApplicationInfo().flags;
            if (str2.startsWith("generic") && (i & 2) != 0) {
                return true;
            }
            try {
                for (Signature toByteArray : context.getPackageManager().getPackageInfo(str, 64).signatures) {
                    if (validAppSignatureHashes.contains(Utility.sha1hash(toByteArray.toByteArray()))) {
                        return true;
                    }
                }
                return false;
            } catch (NameNotFoundException e) {
                return false;
            }
        }
    }

    private static class KatanaAppInfo extends NativeAppInfo {
        static final String KATANA_PACKAGE = "com.facebook.katana";

        private KatanaAppInfo() {
            super();
        }

        protected String getPackage() {
            return KATANA_PACKAGE;
        }
    }

    private static class MessengerAppInfo extends NativeAppInfo {
        static final String MESSENGER_PACKAGE = "com.facebook.orca";

        private MessengerAppInfo() {
            super();
        }

        protected String getPackage() {
            return MESSENGER_PACKAGE;
        }
    }

    private static class WakizashiAppInfo extends NativeAppInfo {
        static final String WAKIZASHI_PACKAGE = "com.facebook.wakizashi";

        private WakizashiAppInfo() {
            super();
        }

        protected String getPackage() {
            return WAKIZASHI_PACKAGE;
        }
    }

    private static Map<String, List<NativeAppInfo>> buildActionToAppInfoMap() {
        Map<String, List<NativeAppInfo>> hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MessengerAppInfo());
        hashMap.put(ACTION_OGACTIONPUBLISH_DIALOG, facebookAppInfoList);
        hashMap.put(ACTION_FEED_DIALOG, facebookAppInfoList);
        hashMap.put(ACTION_LIKE_DIALOG, facebookAppInfoList);
        hashMap.put(ACTION_MESSAGE_DIALOG, arrayList);
        hashMap.put(ACTION_OGMESSAGEPUBLISH_DIALOG, arrayList);
        return hashMap;
    }

    private static List<NativeAppInfo> buildFacebookAppList() {
        List<NativeAppInfo> arrayList = new ArrayList();
        arrayList.add(FACEBOOK_APP_INFO);
        arrayList.add(new WakizashiAppInfo());
        return arrayList;
    }

    private static Uri buildPlatformProviderVersionURI(NativeAppInfo nativeAppInfo) {
        return Uri.parse(CONTENT_SCHEME + nativeAppInfo.getPackage() + PLATFORM_PROVIDER_VERSIONS);
    }

    public static int computeLatestAvailableVersionFromVersionSpec(TreeSet<Integer> treeSet, int i, int[] iArr) {
        int length = iArr.length - 1;
        Iterator descendingIterator = treeSet.descendingIterator();
        int i2 = -1;
        int i3 = length;
        while (descendingIterator.hasNext()) {
            int intValue = ((Integer) descendingIterator.next()).intValue();
            length = Math.max(i2, intValue);
            i2 = i3;
            while (i2 >= 0 && iArr[i2] > intValue) {
                i2--;
            }
            if (i2 < 0) {
                return -1;
            }
            if (iArr[i2] == intValue) {
                return i2 % 2 == 0 ? Math.min(length, i) : -1;
            } else {
                i3 = i2;
                i2 = length;
            }
        }
        return -1;
    }

    public static Intent createPlatformActivityIntent(Context context, String str, String str2, int i, String str3, Bundle bundle) {
        Intent findActivityIntent = findActivityIntent(context, INTENT_ACTION_PLATFORM_ACTIVITY, str2);
        if (findActivityIntent == null) {
            return null;
        }
        findActivityIntent.putExtra(EXTRA_PROTOCOL_VERSION, i).putExtra(EXTRA_PROTOCOL_ACTION, str2).putExtra(EXTRA_APPLICATION_ID, Utility.getMetadataApplicationId(context));
        if (isVersionCompatibleWithBucketedIntent(i)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("action_id", str);
            bundle2.putString(BRIDGE_ARG_APP_NAME_STRING, str3);
            findActivityIntent.putExtra(EXTRA_PROTOCOL_BRIDGE_ARGS, bundle2);
            if (bundle == null) {
                bundle = new Bundle();
            }
            findActivityIntent.putExtra(EXTRA_PROTOCOL_METHOD_ARGS, bundle);
            return findActivityIntent;
        }
        findActivityIntent.putExtra(EXTRA_PROTOCOL_CALL_ID, str);
        findActivityIntent.putExtra(EXTRA_APPLICATION_NAME, str3);
        findActivityIntent.putExtras(bundle);
        return findActivityIntent;
    }

    public static Intent createPlatformServiceIntent(Context context) {
        for (NativeAppInfo nativeAppInfo : facebookAppInfoList) {
            Intent validateServiceIntent = validateServiceIntent(context, new Intent(INTENT_ACTION_PLATFORM_SERVICE).setPackage(nativeAppInfo.getPackage()).addCategory("android.intent.category.DEFAULT"), nativeAppInfo);
            if (validateServiceIntent != null) {
                return validateServiceIntent;
            }
        }
        return null;
    }

    public static Intent createProxyAuthIntent(Context context, String str, List<String> list, String str2, boolean z, SessionDefaultAudience sessionDefaultAudience) {
        for (NativeAppInfo nativeAppInfo : facebookAppInfoList) {
            Intent putExtra = new Intent().setClassName(nativeAppInfo.getPackage(), FACEBOOK_PROXY_AUTH_ACTIVITY).putExtra("client_id", str);
            if (!Utility.isNullOrEmpty((Collection) list)) {
                putExtra.putExtra("scope", TextUtils.join(",", list));
            }
            if (!Utility.isNullOrEmpty(str2)) {
                putExtra.putExtra("e2e", str2);
            }
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN);
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_RETURN_SCOPES, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_DEFAULT_AUDIENCE, sessionDefaultAudience.getNativeProtocolAudience());
            if (!Settings.getPlatformCompatibilityEnabled()) {
                putExtra.putExtra(ServerProtocol.DIALOG_PARAM_LEGACY_OVERRIDE, ServerProtocol.GRAPH_API_VERSION);
                if (z) {
                    putExtra.putExtra(ServerProtocol.DIALOG_PARAM_AUTH_TYPE, ServerProtocol.DIALOG_REREQUEST_AUTH_TYPE);
                }
            }
            Intent validateActivityIntent = validateActivityIntent(context, putExtra, nativeAppInfo);
            if (validateActivityIntent != null) {
                return validateActivityIntent;
            }
        }
        return null;
    }

    public static Intent createTokenRefreshIntent(Context context) {
        for (NativeAppInfo nativeAppInfo : facebookAppInfoList) {
            Intent validateServiceIntent = validateServiceIntent(context, new Intent().setClassName(nativeAppInfo.getPackage(), FACEBOOK_TOKEN_REFRESH_ACTIVITY), nativeAppInfo);
            if (validateServiceIntent != null) {
                return validateServiceIntent;
            }
        }
        return null;
    }

    private static Intent findActivityIntent(Context context, String str, String str2) {
        List<NativeAppInfo> list = (List) actionToAppInfoMap.get(str2);
        if (list == null) {
            return null;
        }
        Intent intent = null;
        for (NativeAppInfo nativeAppInfo : list) {
            intent = validateActivityIntent(context, new Intent().setAction(str).setPackage(nativeAppInfo.getPackage()).addCategory("android.intent.category.DEFAULT"), nativeAppInfo);
            if (intent != null) {
                return intent;
            }
        }
        return intent;
    }

    private static TreeSet<Integer> getAllAvailableProtocolVersionsForAppInfo(Context context, NativeAppInfo nativeAppInfo) {
        Throwable th;
        TreeSet<Integer> treeSet = new TreeSet();
        Cursor query;
        try {
            query = context.getContentResolver().query(buildPlatformProviderVersionURI(nativeAppInfo), new String[]{"version"}, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    try {
                        treeSet.add(Integer.valueOf(query.getInt(query.getColumnIndex("version"))));
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
            if (query != null) {
                query.close();
            }
            return treeSet;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public static Bundle getBridgeArgumentsFromIntent(Intent intent) {
        return !isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent)) ? null : intent.getBundleExtra(EXTRA_PROTOCOL_BRIDGE_ARGS);
    }

    public static UUID getCallIdFromIntent(Intent intent) {
        UUID uuid = null;
        if (intent != null) {
            String string;
            if (isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
                Bundle bundleExtra = intent.getBundleExtra(EXTRA_PROTOCOL_BRIDGE_ARGS);
                if (bundleExtra != null) {
                    string = bundleExtra.getString("action_id");
                } else {
                    Object obj = uuid;
                }
            } else {
                string = intent.getStringExtra(EXTRA_PROTOCOL_CALL_ID);
            }
            if (string != null) {
                try {
                    uuid = UUID.fromString(string);
                } catch (IllegalArgumentException e) {
                }
            }
        }
        return uuid;
    }

    public static Bundle getErrorDataFromResultIntent(Intent intent) {
        if (!isErrorResult(intent)) {
            return null;
        }
        Bundle bridgeArgumentsFromIntent = getBridgeArgumentsFromIntent(intent);
        return bridgeArgumentsFromIntent != null ? bridgeArgumentsFromIntent.getBundle("error") : intent.getExtras();
    }

    public static Exception getExceptionFromErrorData(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString(STATUS_ERROR_TYPE);
        String string2 = bundle.getString(STATUS_ERROR_DESCRIPTION);
        return (string == null || !string.equalsIgnoreCase(ERROR_USER_CANCELED)) ? new FacebookException(string2) : new FacebookOperationCanceledException(string2);
    }

    public static int getLatestAvailableProtocolVersionForAction(Context context, String str, int[] iArr) {
        return getLatestAvailableProtocolVersionForAppInfoList(context, (List) actionToAppInfoMap.get(str), iArr);
    }

    private static int getLatestAvailableProtocolVersionForAppInfo(Context context, NativeAppInfo nativeAppInfo, int[] iArr) {
        return computeLatestAvailableVersionFromVersionSpec(getAllAvailableProtocolVersionsForAppInfo(context, nativeAppInfo), getLatestKnownVersion(), iArr);
    }

    private static int getLatestAvailableProtocolVersionForAppInfoList(Context context, List<NativeAppInfo> list, int[] iArr) {
        if (list == null) {
            return -1;
        }
        for (NativeAppInfo latestAvailableProtocolVersionForAppInfo : list) {
            int latestAvailableProtocolVersionForAppInfo2 = getLatestAvailableProtocolVersionForAppInfo(context, latestAvailableProtocolVersionForAppInfo, iArr);
            if (latestAvailableProtocolVersionForAppInfo2 != -1) {
                return latestAvailableProtocolVersionForAppInfo2;
            }
        }
        return -1;
    }

    public static int getLatestAvailableProtocolVersionForService(Context context, int i) {
        return getLatestAvailableProtocolVersionForAppInfoList(context, facebookAppInfoList, new int[]{i});
    }

    public static final int getLatestKnownVersion() {
        return ((Integer) KNOWN_PROTOCOL_VERSIONS.get(0)).intValue();
    }

    public static int getProtocolVersionFromIntent(Intent intent) {
        return intent.getIntExtra(EXTRA_PROTOCOL_VERSION, 0);
    }

    public static Bundle getSuccessResultsFromIntent(Intent intent) {
        int protocolVersionFromIntent = getProtocolVersionFromIntent(intent);
        Bundle extras = intent.getExtras();
        return (!isVersionCompatibleWithBucketedIntent(protocolVersionFromIntent) || extras == null) ? extras : extras.getBundle(EXTRA_PROTOCOL_METHOD_RESULTS);
    }

    public static boolean isErrorResult(Intent intent) {
        Bundle bridgeArgumentsFromIntent = getBridgeArgumentsFromIntent(intent);
        return bridgeArgumentsFromIntent != null ? bridgeArgumentsFromIntent.containsKey("error") : intent.hasExtra(STATUS_ERROR_TYPE);
    }

    public static boolean isVersionCompatibleWithBucketedIntent(int i) {
        return KNOWN_PROTOCOL_VERSIONS.contains(Integer.valueOf(i)) && i >= PROTOCOL_VERSION_20140701;
    }

    static Intent validateActivityIntent(Context context, Intent intent, NativeAppInfo nativeAppInfo) {
        if (intent == null) {
            return null;
        }
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        return resolveActivity == null ? null : !nativeAppInfo.validateSignature(context, resolveActivity.activityInfo.packageName) ? null : intent;
    }

    static Intent validateServiceIntent(Context context, Intent intent, NativeAppInfo nativeAppInfo) {
        if (intent == null) {
            return null;
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        return resolveService == null ? null : !nativeAppInfo.validateSignature(context, resolveService.serviceInfo.packageName) ? null : intent;
    }
}
