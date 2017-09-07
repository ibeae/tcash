package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p027a.C0651c.C0653a;
import com.google.android.gms.p027a.C0654d;

public final class cq implements SafeParcelable {
    public static final bm CREATOR = new bm();
    public final int f1189a;
    public final cb f1190b;
    public final bv f1191c;
    public final bx f1192d;
    public final Context f1193e;

    cq(int i, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4) {
        this.f1189a = i;
        this.f1190b = (cb) C0654d.m1385a(C0653a.m1383a(iBinder));
        this.f1191c = (bv) C0654d.m1385a(C0653a.m1383a(iBinder2));
        this.f1192d = (bx) C0654d.m1385a(C0653a.m1383a(iBinder3));
        this.f1193e = (Context) C0654d.m1385a(C0653a.m1383a(iBinder4));
    }

    public cq(bx bxVar, cb cbVar, bv bvVar, Context context) {
        this.f1189a = 1;
        this.f1192d = bxVar;
        this.f1190b = cbVar;
        this.f1191c = bvVar;
        this.f1193e = context;
    }

    public static cq m1953a(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            bundleExtra.setClassLoader(cq.class.getClassLoader());
            return (cq) bundleExtra.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
        } catch (Exception e) {
            return null;
        }
    }

    public static void m1954a(Intent intent, cq cqVar) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", cqVar);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", bundle);
    }

    IBinder m1955a() {
        return C0654d.m1384a(this.f1190b).asBinder();
    }

    IBinder m1956b() {
        return C0654d.m1384a(this.f1191c).asBinder();
    }

    IBinder m1957c() {
        return C0654d.m1384a(this.f1192d).asBinder();
    }

    IBinder m1958d() {
        return C0654d.m1384a(this.f1193e).asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        bm.m1730a(this, parcel, i);
    }
}
