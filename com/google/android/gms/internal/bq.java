package com.google.android.gms.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.bz.C0709a;

public class bq extends C0709a implements ServiceConnection {
    private final Activity f1056a;
    private final bt f1057b;
    private Context f1058c;
    private cb f1059d;
    private bx f1060e;
    private bn f1061f;
    private br f1062g;
    private bv f1063h;
    private String f1064i;

    public static void m1765a(Context context, boolean z, cq cqVar) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.purchase.InAppPurchaseActivity");
        intent.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", z);
        cq.m1954a(intent, cqVar);
        context.startActivity(intent);
    }

    private void m1766a(String str, boolean z, int i, Intent intent) {
        try {
            this.f1059d.mo946a(new bs(this.f1058c, str, z, i, intent, this.f1062g));
        } catch (RemoteException e) {
            dq.m2120e("Fail to invoke PlayStorePurchaseListener.");
        }
    }

    public void mo936a() {
        cq a = cq.m1953a(this.f1056a.getIntent());
        this.f1059d = a.f1190b;
        this.f1063h = a.f1191c;
        this.f1060e = a.f1192d;
        this.f1061f = new bn(this.f1056a.getApplicationContext());
        this.f1058c = a.f1193e;
        Activity activity = this.f1056a;
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        this.f1056a.getApplicationContext();
        activity.bindService(intent, this, 1);
    }

    public void mo937a(int i, int i2, Intent intent) {
        if (i == 1001) {
            try {
                int a = bu.m1790a(intent);
                if (i2 != -1 || a != 0) {
                    this.f1057b.m1786a(this.f1062g);
                    m1766a(this.f1060e.mo933a(), false, i2, intent);
                } else if (this.f1063h.m1797a(this.f1064i, i2, intent)) {
                    m1766a(this.f1060e.mo933a(), true, i2, intent);
                } else {
                    m1766a(this.f1060e.mo933a(), false, i2, intent);
                }
                this.f1060e.mo935c(a);
            } catch (RemoteException e) {
                dq.m2120e("Fail to process purchase result.");
            } finally {
                this.f1064i = null;
                this.f1056a.finish();
            }
        }
    }

    public void mo938b() {
        this.f1056a.unbindService(this);
        this.f1061f.m1735a();
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Throwable e;
        this.f1061f.m1736a(iBinder);
        try {
            this.f1064i = this.f1063h.m1796a();
            Bundle a = this.f1061f.m1734a(this.f1056a.getPackageName(), this.f1060e.mo933a(), this.f1064i);
            PendingIntent pendingIntent = (PendingIntent) a.getParcelable("BUY_INTENT");
            if (pendingIntent == null) {
                int a2 = bu.m1791a(a);
                this.f1060e.mo935c(a2);
                m1766a(this.f1060e.mo933a(), false, a2, null);
                this.f1056a.finish();
                return;
            }
            this.f1062g = new br(this.f1060e.mo933a(), this.f1064i);
            this.f1057b.m1788b(this.f1062g);
            this.f1056a.startIntentSenderForResult(pendingIntent.getIntentSender(), 1001, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
        } catch (RemoteException e2) {
            e = e2;
            dq.m2118c("Error when connecting in-app billing service", e);
            this.f1056a.finish();
        } catch (SendIntentException e3) {
            e = e3;
            dq.m2118c("Error when connecting in-app billing service", e);
            this.f1056a.finish();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        dq.m2117c("In-app billing service disconnected.");
        this.f1061f.m1735a();
    }
}
