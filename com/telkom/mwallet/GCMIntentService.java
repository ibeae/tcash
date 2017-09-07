package com.telkom.mwallet;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import com.appsflyer.MonitorMessages;
import com.google.android.gcm.C0638a;
import com.google.android.gcm.C0639b;
import com.skcc.wallet.core.p057a.C1216a;
import java.util.List;

public class GCMIntentService extends C0638a {
    private static final String f2849a = GCMIntentService.class.getSimpleName();
    private Context f2850b;

    public GCMIntentService() {
        super("716323091458");
    }

    private void m4827a(Context context, String str, String str2, Class cls, boolean z) {
        try {
            Intent intent;
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            Builder builder = new Builder(context);
            builder.setSmallIcon(R.drawable.ic_logo);
            builder.setAutoCancel(true);
            builder.setContentTitle(getString(R.string.app_name_tel));
            builder.setStyle(new BigTextStyle().bigText(str));
            builder.setContentText(str);
            if (z) {
                intent = new Intent(context, cls);
                intent.putExtra("byPush", true);
                intent.putExtra("pushMessage", str);
                intent.addFlags(268435456);
            } else {
                intent = new Intent(context, StartActivity.class);
                intent.putExtra("byPush", true);
                intent.putExtra("pushMessage", str);
                intent.addFlags(67108864);
                intent.addFlags(536870912);
            }
            builder.setContentIntent(PendingIntent.getActivity(context, 0, intent, 134217728));
            notificationManager.notify(Integer.parseInt(str2), builder.build());
        } catch (Exception e) {
        }
    }

    protected void mo1477a(Context context, int i) {
        C1216a.m4523c(f2849a, "Received deleted messages notification");
    }

    protected void mo1478a(Context context, Intent intent) {
        this.f2850b = context;
        if (intent.getAction().equals("com.google.android.c2dm.intent.RECEIVE")) {
            Bundle extras = intent.getExtras();
            if (extras != null && extras.containsKey("data")) {
                C1216a.m4521a(f2849a, "gcm Message = ", extras.toString());
                String string = extras.getString(MonitorMessages.MESSAGE);
                CharSequence string2 = extras.getString("data");
                extras.getString("eventCategory");
                extras.getString("event");
                String string3 = extras.getString("tid");
                if (!TextUtils.isEmpty(string2)) {
                    String packageName = context.getPackageName();
                    ActivityManager activityManager = (ActivityManager) getSystemService("activity");
                    List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                    activityManager.getRunningTasks(1);
                    for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (packageName.equals(runningAppProcessInfo.processName)) {
                        }
                        if (runningAppProcessInfo.importance == 100 && packageName.equals(runningAppProcessInfo.processName)) {
                        }
                    }
                    m4827a(context, string, string3, StartActivity.class, false);
                }
            }
        }
    }

    protected boolean mo1479a(Context context, String str) {
        C1216a.m4523c(f2849a, "Received recoverable error: " + str);
        return super.mo1479a(context, str);
    }

    public void mo1480b(Context context, String str) {
        C1216a.m4523c(f2849a, "Received error: " + str);
    }

    protected void mo1481c(Context context, String str) {
        C1216a.m4523c(f2849a, "Received Device registered: regId = " + str);
        ((TelkomApplication) context.getApplicationContext()).m4895b(str);
    }

    protected void mo1482d(Context context, String str) {
        C1216a.m4523c(f2849a, "Received  Device unregistered");
        if (!C0639b.m1338h(context)) {
            C1216a.m4523c(f2849a, "Ignoring unregister callback");
        }
    }
}
