package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class bo extends di implements ServiceConnection {
    private final Object f1044a = new Object();
    private boolean f1045b = false;
    private Context f1046c;
    private cb f1047d;
    private bn f1048e;
    private bt f1049f;
    private List<br> f1050g = null;
    private bv f1051h;

    public bo(Context context, cb cbVar, bv bvVar) {
        this.f1046c = context;
        this.f1047d = cbVar;
        this.f1051h = bvVar;
        this.f1048e = new bn(context);
        this.f1049f = bt.m1781a(this.f1046c);
        this.f1050g = this.f1049f.m1785a(10);
    }

    private void m1744a(long j) {
        do {
            if (!m1747b(j)) {
                dq.m2120e("Timeout waiting for pending transaction to be processed.");
            }
        } while (!this.f1045b);
    }

    private void m1745a(final br brVar, String str, String str2) {
        final Intent intent = new Intent();
        intent.putExtra("RESPONSE_CODE", 0);
        intent.putExtra("INAPP_PURCHASE_DATA", str);
        intent.putExtra("INAPP_DATA_SIGNATURE", str2);
        dp.f1344a.post(new Runnable(this) {
            final /* synthetic */ bo f1041c;

            public void run() {
                try {
                    if (this.f1041c.f1051h.m1797a(brVar.f1066b, -1, intent)) {
                        this.f1041c.f1047d.mo946a(new bs(this.f1041c.f1046c, brVar.f1067c, true, -1, intent, brVar));
                    } else {
                        this.f1041c.f1047d.mo946a(new bs(this.f1041c.f1046c, brVar.f1067c, false, -1, intent, brVar));
                    }
                } catch (RemoteException e) {
                    dq.m2120e("Fail to verify and dispatch pending transaction");
                }
            }
        });
    }

    private boolean m1747b(long j) {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.f1044a.wait(elapsedRealtime);
        } catch (InterruptedException e) {
            dq.m2120e("waitWithTimeout_lock interrupted");
        }
        return true;
    }

    private void m1749c() {
        if (!this.f1050g.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (br brVar : this.f1050g) {
                hashMap.put(brVar.f1067c, brVar);
            }
            String str = null;
            while (true) {
                Bundle b = this.f1048e.m1737b(this.f1046c.getPackageName(), str);
                if (b == null || bu.m1791a(b) != 0) {
                    break;
                }
                ArrayList stringArrayList = b.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList stringArrayList2 = b.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList stringArrayList3 = b.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                String string = b.getString("INAPP_CONTINUATION_TOKEN");
                for (int i = 0; i < stringArrayList.size(); i++) {
                    if (hashMap.containsKey(stringArrayList.get(i))) {
                        str = (String) stringArrayList.get(i);
                        String str2 = (String) stringArrayList2.get(i);
                        String str3 = (String) stringArrayList3.get(i);
                        br brVar2 = (br) hashMap.get(str);
                        if (brVar2.f1066b.equals(bu.m1792a(str2))) {
                            m1745a(brVar2, str2, str3);
                            hashMap.remove(str);
                        }
                    }
                }
                if (string == null || hashMap.isEmpty()) {
                    break;
                }
                str = string;
            }
            for (String str4 : hashMap.keySet()) {
                this.f1049f.m1786a((br) hashMap.get(str4));
            }
        }
    }

    public void mo931a() {
        synchronized (this.f1044a) {
            Context context = this.f1046c;
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            Context context2 = this.f1046c;
            context.bindService(intent, this, 1);
            m1744a(SystemClock.elapsedRealtime());
            this.f1046c.unbindService(this);
            this.f1048e.m1735a();
        }
    }

    public void mo932b() {
        synchronized (this.f1044a) {
            this.f1046c.unbindService(this);
            this.f1048e.m1735a();
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f1044a) {
            this.f1048e.m1736a(iBinder);
            m1749c();
            this.f1045b = true;
            this.f1044a.notify();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        dq.m2117c("In-app billing service disconnected.");
        this.f1048e.m1735a();
    }
}
