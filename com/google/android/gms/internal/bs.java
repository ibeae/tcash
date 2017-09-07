package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.ca.C0710a;

public final class bs extends C0710a implements ServiceConnection {
    private boolean f1068a = false;
    private Context f1069b;
    private int f1070c;
    private Intent f1071d;
    private bn f1072e;
    private br f1073f;
    private String f1074g;

    public bs(Context context, String str, boolean z, int i, Intent intent, br brVar) {
        this.f1074g = str;
        this.f1070c = i;
        this.f1071d = intent;
        this.f1068a = z;
        this.f1069b = context;
        this.f1073f = brVar;
    }

    public boolean mo939a() {
        return this.f1068a;
    }

    public String mo940b() {
        return this.f1074g;
    }

    public Intent mo941c() {
        return this.f1071d;
    }

    public int mo942d() {
        return this.f1070c;
    }

    public void mo943e() {
        int a = bu.m1790a(this.f1071d);
        if (this.f1070c == -1 && a == 0) {
            this.f1072e = new bn(this.f1069b);
            Context context = this.f1069b;
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            Context context2 = this.f1069b;
            context.bindService(intent, this, 1);
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        dq.m2117c("In-app billing service connected.");
        this.f1072e.m1736a(iBinder);
        String b = bu.m1794b(bu.m1793b(this.f1071d));
        if (b != null) {
            if (this.f1072e.m1733a(this.f1069b.getPackageName(), b) == 0) {
                bt.m1781a(this.f1069b).m1786a(this.f1073f);
            }
            this.f1069b.unbindService(this);
            this.f1072e.m1735a();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        dq.m2117c("In-app billing service disconnected.");
        this.f1072e.m1735a();
    }
}
