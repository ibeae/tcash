package com.google.android.gms.common;

import android.app.PendingIntent;
import com.google.android.gms.internal.ej;

public final class C0663a {
    public static final C0663a f845a = new C0663a(0, null);
    private final PendingIntent f846b;
    private final int f847c;

    public C0663a(int i, PendingIntent pendingIntent) {
        this.f847c = i;
        this.f846b = pendingIntent;
    }

    private String m1452a() {
        switch (this.f847c) {
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            case 13:
                return "CANCELED";
            case 14:
                return "TIMEOUT";
            case 15:
                return "INTERRUPTED";
            default:
                return "unknown status code " + this.f847c;
        }
    }

    public String toString() {
        return ej.m2330a((Object) this).m2328a("statusCode", m1452a()).m2328a("resolution", this.f846b).toString();
    }
}
