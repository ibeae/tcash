package com.google.android.gms.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.net.UrlQuerySanitizer.ParameterValuePair;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.nio.CharBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class dk {
    private static final Object f1327a = new Object();
    private static boolean f1328b = true;
    private static String f1329c;
    private static boolean f1330d = false;

    private static final class C0747a extends BroadcastReceiver {
        private C0747a() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                dk.f1328b = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                dk.f1328b = false;
            }
        }
    }

    private static String m2059a(final Context context, String str) {
        String str2;
        synchronized (f1327a) {
            if (f1329c != null) {
                str2 = f1329c;
            } else {
                if (VERSION.SDK_INT >= 17) {
                    f1329c = dn.m2099a(context);
                } else if (dp.m2111b()) {
                    f1329c = m2087e(context);
                } else {
                    dp.f1344a.post(new Runnable() {
                        public void run() {
                            synchronized (dk.f1327a) {
                                dk.f1329c = dk.m2087e(context);
                                dk.f1327a.notifyAll();
                            }
                        }
                    });
                    while (f1329c == null) {
                        try {
                            f1327a.wait();
                        } catch (InterruptedException e) {
                            str2 = f1329c;
                        }
                    }
                }
                f1329c += " (Mobile; " + str + ")";
                str2 = f1329c;
            }
        }
        return str2;
    }

    public static String m2060a(Readable readable) {
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence allocate = CharBuffer.allocate(2048);
        while (true) {
            int read = readable.read(allocate);
            if (read == -1) {
                return stringBuilder.toString();
            }
            allocate.flip();
            stringBuilder.append(allocate, 0, read);
        }
    }

    public static String m2061a(String str) {
        return Uri.parse(str).buildUpon().query(null).build().toString();
    }

    public static Map<String, String> m2062a(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        UrlQuerySanitizer urlQuerySanitizer = new UrlQuerySanitizer();
        urlQuerySanitizer.setAllowUnregisteredParamaters(true);
        urlQuerySanitizer.setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
        urlQuerySanitizer.parseUrl(uri.toString());
        for (ParameterValuePair parameterValuePair : urlQuerySanitizer.getParameterList()) {
            hashMap.put(parameterValuePair.mParameter, parameterValuePair.mValue);
        }
        return hashMap;
    }

    private static JSONArray m2063a(Collection<?> collection) {
        JSONArray jSONArray = new JSONArray();
        for (Object a : collection) {
            m2071a(jSONArray, a);
        }
        return jSONArray;
    }

    static JSONArray m2064a(Object[] objArr) {
        JSONArray jSONArray = new JSONArray();
        for (Object a : objArr) {
            m2071a(jSONArray, a);
        }
        return jSONArray;
    }

    private static JSONObject m2065a(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            m2072a(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    public static JSONObject m2066a(Map<String, ?> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                m2072a(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            throw new JSONException("Could not convert map to JSON: " + e.getMessage());
        }
    }

    public static void m2067a(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(m2059a(context, str));
    }

    public static void m2068a(Context context, String str, List<String> list) {
        for (String c0750do : list) {
            new C0750do(context, str, c0750do).m1741e();
        }
    }

    public static void m2069a(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", m2059a(context, str));
        httpURLConnection.setUseCaches(false);
    }

    public static void m2070a(WebView webView) {
        if (VERSION.SDK_INT >= 11) {
            dm.m2096a(webView);
        }
    }

    private static void m2071a(JSONArray jSONArray, Object obj) {
        if (obj instanceof Bundle) {
            jSONArray.put(m2065a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(m2066a((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(m2063a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONArray.put(m2064a((Object[]) obj));
        } else {
            jSONArray.put(obj);
        }
    }

    private static void m2072a(JSONObject jSONObject, String str, Object obj) {
        if (obj instanceof Bundle) {
            jSONObject.put(str, m2065a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, m2066a((Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, m2063a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, m2063a(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    public static boolean m2073a() {
        return f1328b;
    }

    public static boolean m2074a(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            dq.m2120e("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        }
        boolean z;
        String str = "com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".";
        if ((resolveActivity.activityInfo.configChanges & 16) == 0) {
            dq.m2120e(String.format(str, new Object[]{"keyboard"}));
            z = false;
        } else {
            z = true;
        }
        if ((resolveActivity.activityInfo.configChanges & 32) == 0) {
            dq.m2120e(String.format(str, new Object[]{"keyboardHidden"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 128) == 0) {
            dq.m2120e(String.format(str, new Object[]{"orientation"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & NotificationCompat.FLAG_LOCAL_ONLY) == 0) {
            dq.m2120e(String.format(str, new Object[]{"screenLayout"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & NotificationCompat.FLAG_GROUP_SUMMARY) == 0) {
            dq.m2120e(String.format(str, new Object[]{"uiMode"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 1024) == 0) {
            dq.m2120e(String.format(str, new Object[]{"screenSize"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 2048) != 0) {
            return z;
        }
        dq.m2120e(String.format(str, new Object[]{"smallestScreenSize"}));
        return false;
    }

    public static boolean m2075a(PackageManager packageManager, String str, String str2) {
        return packageManager.checkPermission(str2, str) == 0;
    }

    public static boolean m2076a(ClassLoader classLoader, Class<?> cls, String str) {
        boolean z = false;
        try {
            z = cls.isAssignableFrom(Class.forName(str, false, classLoader));
        } catch (Throwable th) {
        }
        return z;
    }

    public static int m2078b() {
        return VERSION.SDK_INT >= 9 ? 6 : 0;
    }

    public static void m2080b(Context context) {
        if (!f1330d) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            context.getApplicationContext().registerReceiver(new C0747a(), intentFilter);
            f1330d = true;
        }
    }

    public static void m2081b(WebView webView) {
        if (VERSION.SDK_INT >= 11) {
            dm.m2098b(webView);
        }
    }

    public static int m2082c() {
        return VERSION.SDK_INT >= 9 ? 7 : 1;
    }

    public static int m2083c(Context context) {
        int i;
        int i2 = 0;
        if (context instanceof Activity) {
            Window window = ((Activity) context).getWindow();
            Rect rect = new Rect();
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
            i = rect.top;
            i2 = window.findViewById(16908290).getTop() - i;
        } else {
            i = 0;
        }
        return i2 + i;
    }

    public static String m2084d() {
        UUID randomUUID = UUID.randomUUID();
        byte[] toByteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] toByteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String bigInteger = new BigInteger(1, toByteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(toByteArray);
                instance.update(toByteArray2);
                Object obj = new byte[8];
                System.arraycopy(instance.digest(), 0, obj, 0, 8);
                bigInteger = new BigInteger(1, obj).toString();
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return bigInteger;
    }

    private static String m2087e(Context context) {
        return new WebView(context).getSettings().getUserAgentString();
    }
}
