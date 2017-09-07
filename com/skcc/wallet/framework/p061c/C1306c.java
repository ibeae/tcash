package com.skcc.wallet.framework.p061c;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.skcc.wallet.framework.C1302b;

public class C1306c {
    public static void m4763a(Context context) {
        ((C1302b) context).m4745e().m4648a("walletPkgName", ((RunningTaskInfo) ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getPackageName());
    }

    public static void m4764a(Runnable runnable) {
        Looper.prepare();
        new Handler(Looper.getMainLooper()).post(runnable);
        Looper.loop();
    }
}
