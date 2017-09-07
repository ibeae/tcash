package com.skcc.wallet.framework.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.C1302b;
import com.skcc.wallet.framework.api.http.C1244e;
import com.skcc.wallet.framework.api.http.C1246g;
import com.skcc.wallet.framework.api.http.C1252m;
import com.skcc.wallet.framework.api.http.C1253n;

public class C1260j implements C1246g {
    protected C1252m f2677a = null;
    private C1302b f2678b;
    private String f2679c;
    private BroadcastReceiver f2680d = new C12581(this);
    private BroadcastReceiver f2681e = new C12592(this);
    private boolean f2682f = false;

    class C12581 extends BroadcastReceiver {
        final /* synthetic */ C1260j f2675a;

        C12581(C1260j c1260j) {
            this.f2675a = c1260j;
        }

        public void onReceive(Context context, Intent intent) {
            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            C1260j c1260j = this.f2675a;
            boolean z = networkInfo != null && networkInfo.isConnected();
            c1260j.f2682f = z;
            C1216a.m4519a("NetworkManager", "monitorNetwork onReceive>> isOnLine :: " + this.f2675a.f2682f);
        }
    }

    class C12592 extends BroadcastReceiver {
        final /* synthetic */ C1260j f2676a;

        C12592(C1260j c1260j) {
            this.f2676a = c1260j;
        }

        public void onReceive(Context context, Intent intent) {
            C1216a.m4519a("NetworkManager", "screenMonitor onReceived wake lock ::");
        }
    }

    public C1260j(C1302b c1302b, C1252m c1252m) {
        this.f2678b = c1302b;
        this.f2677a = c1252m;
        this.f2682f = m4619c();
    }

    public String mo1464a() {
        return this.f2679c;
    }

    public void mo1465a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f2679c = str;
        }
    }

    public void m4618b() {
        this.f2679c = null;
    }

    public boolean m4619c() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f2678b.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public boolean mo1466d() {
        C1216a.m4519a("NetworkManager", "isNetworkAvailable? " + this.f2682f);
        return this.f2682f;
    }

    public void m4621e() {
    }

    public C1252m mo1467f() {
        return this.f2677a;
    }

    public C1253n m4623g() {
        return new C1253n(this);
    }

    public C1244e m4624h() {
        return new C1244e(this);
    }
}
