package com.telkom.mwallet.service;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.core.se.SException;
import com.skcc.wallet.framework.C1302b;
import com.skcc.wallet.framework.api.C1261k;
import com.skcc.wallet.framework.api.C1272r;
import com.telkom.mwallet.CardActivationCheckReceiver;
import com.telkom.mwallet.TelkomApplication;
import java.util.List;

public class C1610a extends Service implements C1261k {
    protected TelkomApplication f3949a;
    private boolean f3950b = false;
    private boolean f3951c = false;
    private C1272r f3952d;

    private void m6061a(boolean z) {
        ((C1302b) getApplicationContext()).m4745e().m4649a("isActivateCheckNeeded", z);
    }

    private boolean m6062e() {
        return ((C1302b) getApplicationContext()).m4745e().m4652b("isActivateCheckNeeded", true);
    }

    public void mo1471a() {
        C1216a.m4519a("CARD", "onSEConnected");
        try {
            ((C1302b) getApplicationContext()).m4742b().m4641c().m4534a("A000000003101001");
            C1216a.m4519a("CARD", "deActivate success");
        } catch (SException e) {
            e.printStackTrace();
            C1216a.m4522b("CARD", "deActivate error : SException");
        } catch (NullPointerException e2) {
            e2.printStackTrace();
            C1216a.m4522b("CARD", "deActivate error : NullPointerException");
        }
        m6061a(false);
        ((C1302b) getApplicationContext()).m4742b().m4640b();
        C1216a.m4519a("CARD", "SE Disconnect");
        ((C1302b) getApplicationContext()).m4743c();
        C1216a.m4519a("CARD", "SE remove");
        m6066d();
        stopSelf();
    }

    public void mo1472b() {
        C1216a.m4519a("CARD", "onSEConnectionFail");
    }

    void m6065c() {
        Intent intent = new Intent(this, CardActivationCheckReceiver.class);
        intent.setAction("ACTION.RESTART.CardActivationCheckService");
        long elapsedRealtime = 60000 + SystemClock.elapsedRealtime();
        ((AlarmManager) getSystemService("alarm")).setRepeating(2, elapsedRealtime, 10000, PendingIntent.getBroadcast(this, 0, intent, 0));
        this.f3951c = false;
    }

    void m6066d() {
        Intent intent = new Intent(this, CardActivationCheckReceiver.class);
        intent.setAction("ACTION.RESTART.CardActivationCheckService");
        ((AlarmManager) getSystemService("alarm")).cancel(PendingIntent.getBroadcast(this, 0, intent, 0));
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        C1216a.m4519a("CARD", "CardActivationCheckService onCreate");
        super.onCreate();
        this.f3949a = (TelkomApplication) getApplication();
        this.f3952d = this.f3949a.m4745e();
        m6066d();
    }

    public void onDestroy() {
        if (m6062e()) {
            m6065c();
        }
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        int i3 = 0;
        m6066d();
        String packageName = ((RunningTaskInfo) ((ActivityManager) getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getPackageName();
        boolean z = packageName.toLowerCase().contains("optus") || packageName.toLowerCase().contains("installer");
        this.f3950b = z;
        C1216a.m4519a("CARD", "isForegroundWallet:" + this.f3950b);
        C1216a.m4519a("CARD", "getActivateCheckNeeded():" + m6062e());
        if (!this.f3950b && m6062e()) {
            C1216a.m4519a("CARD", "wallet app is background or not running!!");
            List runningTasks = ((ActivityManager) getSystemService("activity")).getRunningTasks(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            for (int i4 = 0; i4 < runningTasks.size(); i4++) {
                C1216a.m4519a("CARD", "taskName : " + ((RunningTaskInfo) runningTasks.get(i4)).topActivity.toString());
                if (((RunningTaskInfo) runningTasks.get(i4)).topActivity.toString().contains(getApplicationContext().getPackageName())) {
                    C1216a.m4519a("CARD", "running taskName : " + ((RunningTaskInfo) runningTasks.get(i4)).topActivity.toString());
                    i3 = 1;
                    break;
                }
            }
            if (i3 != 0 || this.f3951c) {
                m6065c();
            } else {
                this.f3951c = true;
                ((C1302b) getApplicationContext()).m4739a().m4678a((C1261k) this);
            }
        } else if (!this.f3950b && !m6062e()) {
            stopSelf();
        } else if (this.f3950b) {
            m6065c();
        }
        return super.onStartCommand(intent, i, i2);
    }
}
