package com.skcc.wallet.framework.p061c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;

public class C1303a {
    private Context f2790a;

    public C1303a(Context context) {
        this.f2790a = context;
    }

    public String m4747a() {
        return Build.MODEL;
    }

    public String m4748b() {
        return VERSION.RELEASE;
    }

    public String m4749c() {
        PackageInfo packageInfo = null;
        try {
            packageInfo = this.f2790a.getPackageManager().getPackageInfo(this.f2790a.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return packageInfo.versionName;
    }

    public String m4750d() {
        String subscriberId = ((TelephonyManager) this.f2790a.getSystemService("phone")).getSubscriberId();
        return (subscriberId == null || subscriberId.length() < 5) ? "450051012341234" : subscriberId;
    }

    public String m4751e() {
        String deviceId = ((TelephonyManager) this.f2790a.getSystemService("phone")).getDeviceId();
        return deviceId == null ? "IMEI_CODE_IS_NULL" : deviceId;
    }
}
