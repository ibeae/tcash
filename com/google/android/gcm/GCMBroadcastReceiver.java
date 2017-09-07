package com.google.android.gcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class GCMBroadcastReceiver extends BroadcastReceiver {
    private static boolean f778a = false;

    static final String m1311b(Context context) {
        return context.getPackageName() + ".GCMIntentService";
    }

    protected String m1312a(Context context) {
        return m1311b(context);
    }

    public final void onReceive(Context context, Intent intent) {
        String name;
        Log.v("GCMBroadcastReceiver", "onReceive: " + intent.getAction());
        if (!f778a) {
            f778a = true;
            name = getClass().getName();
            if (!name.equals(GCMBroadcastReceiver.class.getName())) {
                C0639b.m1330a(name);
            }
        }
        name = m1312a(context);
        Log.v("GCMBroadcastReceiver", "GCM IntentService class: " + name);
        C0638a.m1315a(context, intent, name);
        setResult(-1, null, null);
    }
}
