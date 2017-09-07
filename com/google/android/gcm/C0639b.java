package com.google.android.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.acra.ACRAConstants;

public final class C0639b {
    private static GCMBroadcastReceiver f786a;
    private static String f787b;

    static String m1324a(Context context, String str) {
        SharedPreferences l = C0639b.m1342l(context);
        String string = l.getString("regId", "");
        int k = C0639b.m1341k(context);
        Log.v("GCMRegistrar", "Saving regId on app version " + k);
        Editor edit = l.edit();
        edit.putString("regId", str);
        edit.putInt("appVersion", k);
        edit.commit();
        return string;
    }

    static String m1325a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("No senderIds");
        }
        StringBuilder stringBuilder = new StringBuilder(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            stringBuilder.append(',').append(strArr[i]);
        }
        return stringBuilder.toString();
    }

    public static void m1326a(Context context) {
        int i = VERSION.SDK_INT;
        if (i < 8) {
            throw new UnsupportedOperationException("Device must be at least API Level 8 (instead of " + i + ")");
        }
        try {
            context.getPackageManager().getPackageInfo("com.google.android.gsf", 0);
        } catch (NameNotFoundException e) {
            throw new UnsupportedOperationException("Device does not have package com.google.android.gsf");
        }
    }

    static void m1327a(Context context, int i) {
        Editor edit = C0639b.m1342l(context).edit();
        edit.putInt("backoff_ms", i);
        edit.commit();
    }

    private static void m1328a(Context context, Set<String> set, String str) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        Intent intent = new Intent(str);
        intent.setPackage(packageName);
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 32);
        if (queryBroadcastReceivers.isEmpty()) {
            throw new IllegalStateException("No receivers for action " + str);
        }
        if (Log.isLoggable("GCMRegistrar", 2)) {
            Log.v("GCMRegistrar", "Found " + queryBroadcastReceivers.size() + " receivers for action " + str);
        }
        for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
            String str2 = resolveInfo.activityInfo.name;
            if (!set.contains(str2)) {
                throw new IllegalStateException("Receiver " + str2 + " is not set with permission " + "com.google.android.c2dm.permission.SEND");
            }
        }
    }

    public static void m1329a(Context context, String... strArr) {
        C0639b.m1339i(context);
        C0639b.m1332b(context, strArr);
    }

    static void m1330a(String str) {
        Log.v("GCMRegistrar", "Setting the name of retry receiver class to " + str);
        f787b = str;
    }

    public static void m1331b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        String str = packageName + ".permission.C2D_MESSAGE";
        try {
            packageManager.getPermissionInfo(str, FragmentTransaction.TRANSIT_ENTER_MASK);
            try {
                ActivityInfo[] activityInfoArr = packageManager.getPackageInfo(packageName, 2).receivers;
                if (activityInfoArr == null || activityInfoArr.length == 0) {
                    throw new IllegalStateException("No receiver for package " + packageName);
                }
                if (Log.isLoggable("GCMRegistrar", 2)) {
                    Log.v("GCMRegistrar", "number of receivers for " + packageName + ": " + activityInfoArr.length);
                }
                Set hashSet = new HashSet();
                for (ActivityInfo activityInfo : activityInfoArr) {
                    if ("com.google.android.c2dm.permission.SEND".equals(activityInfo.permission)) {
                        hashSet.add(activityInfo.name);
                    }
                }
                if (hashSet.isEmpty()) {
                    throw new IllegalStateException("No receiver allowed to receive com.google.android.c2dm.permission.SEND");
                }
                C0639b.m1328a(context, hashSet, "com.google.android.c2dm.intent.REGISTRATION");
                C0639b.m1328a(context, hashSet, "com.google.android.c2dm.intent.RECEIVE");
            } catch (NameNotFoundException e) {
                throw new IllegalStateException("Could not get receivers for package " + packageName);
            }
        } catch (NameNotFoundException e2) {
            throw new IllegalStateException("Application does not define permission " + str);
        }
    }

    static void m1332b(Context context, String... strArr) {
        String a = C0639b.m1325a(strArr);
        Log.v("GCMRegistrar", "Registering app " + context.getPackageName() + " of senders " + a);
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage("com.google.android.gsf");
        intent.putExtra("app", PendingIntent.getBroadcast(context, 0, new Intent(), 0));
        intent.putExtra("sender", a);
        context.startService(intent);
    }

    static void m1333c(Context context) {
        Log.v("GCMRegistrar", "Unregistering app " + context.getPackageName());
        Intent intent = new Intent("com.google.android.c2dm.intent.UNREGISTER");
        intent.setPackage("com.google.android.gsf");
        intent.putExtra("app", PendingIntent.getBroadcast(context, 0, new Intent(), 0));
        context.startService(intent);
    }

    static synchronized void m1334d(Context context) {
        synchronized (C0639b.class) {
            if (f786a == null) {
                if (f787b == null) {
                    Log.e("GCMRegistrar", "internal error: retry receiver class not set yet");
                    f786a = new GCMBroadcastReceiver();
                } else {
                    try {
                        f786a = (GCMBroadcastReceiver) Class.forName(f787b).newInstance();
                    } catch (Exception e) {
                        Log.e("GCMRegistrar", "Could not create instance of " + f787b + ". Using " + GCMBroadcastReceiver.class.getName() + " directly.");
                        f786a = new GCMBroadcastReceiver();
                    }
                }
                String packageName = context.getPackageName();
                IntentFilter intentFilter = new IntentFilter("com.google.android.gcm.intent.RETRY");
                intentFilter.addCategory(packageName);
                packageName = packageName + ".permission.C2D_MESSAGE";
                Log.v("GCMRegistrar", "Registering receiver");
                context.registerReceiver(f786a, intentFilter, packageName, null);
            }
        }
    }

    public static String m1335e(Context context) {
        SharedPreferences l = C0639b.m1342l(context);
        String string = l.getString("regId", "");
        int i = l.getInt("appVersion", Integer.MIN_VALUE);
        int k = C0639b.m1341k(context);
        if (i == Integer.MIN_VALUE || i == k) {
            return string;
        }
        Log.v("GCMRegistrar", "App version changed from " + i + " to " + k + "; resetting registration id");
        C0639b.m1337g(context);
        return "";
    }

    public static boolean m1336f(Context context) {
        return C0639b.m1335e(context).length() > 0;
    }

    static String m1337g(Context context) {
        return C0639b.m1324a(context, "");
    }

    public static boolean m1338h(Context context) {
        SharedPreferences l = C0639b.m1342l(context);
        boolean z = l.getBoolean("onServer", false);
        Log.v("GCMRegistrar", "Is registered on server: " + z);
        if (z) {
            long j = l.getLong("onServerExpirationTime", -1);
            if (System.currentTimeMillis() > j) {
                Log.v("GCMRegistrar", "flag expired on: " + new Timestamp(j));
                return false;
            }
        }
        return z;
    }

    static void m1339i(Context context) {
        Log.d("GCMRegistrar", "resetting backoff for " + context.getPackageName());
        C0639b.m1327a(context, (int) ACRAConstants.DEFAULT_CONNECTION_TIMEOUT);
    }

    static int m1340j(Context context) {
        return C0639b.m1342l(context).getInt("backoff_ms", ACRAConstants.DEFAULT_CONNECTION_TIMEOUT);
    }

    private static int m1341k(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            throw new RuntimeException("Coult not get package name: " + e);
        }
    }

    private static SharedPreferences m1342l(Context context) {
        return context.getSharedPreferences("com.google.android.gcm", 0);
    }
}
