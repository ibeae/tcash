package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p027a.C0651c.C0653a;
import com.google.android.gms.p027a.C0654d;

public final class ch implements SafeParcelable {
    public static final bg CREATOR = new bg();
    public final int f1121a;
    public final ce f1122b;
    public final fs f1123c;
    public final bh f1124d;
    public final dt f1125e;
    public final C0817y f1126f;
    public final String f1127g;
    public final boolean f1128h;
    public final String f1129i;
    public final bk f1130j;
    public final int f1131k;
    public final int f1132l;
    public final String f1133m;
    public final ev f1134n;
    public final ab f1135o;
    public final String f1136p;
    public final C0842v f1137q;

    ch(int i, ce ceVar, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i2, int i3, String str3, ev evVar, IBinder iBinder6, String str4, C0842v c0842v) {
        this.f1121a = i;
        this.f1122b = ceVar;
        this.f1123c = (fs) C0654d.m1385a(C0653a.m1383a(iBinder));
        this.f1124d = (bh) C0654d.m1385a(C0653a.m1383a(iBinder2));
        this.f1125e = (dt) C0654d.m1385a(C0653a.m1383a(iBinder3));
        this.f1126f = (C0817y) C0654d.m1385a(C0653a.m1383a(iBinder4));
        this.f1127g = str;
        this.f1128h = z;
        this.f1129i = str2;
        this.f1130j = (bk) C0654d.m1385a(C0653a.m1383a(iBinder5));
        this.f1131k = i2;
        this.f1132l = i3;
        this.f1133m = str3;
        this.f1134n = evVar;
        this.f1135o = (ab) C0654d.m1385a(C0653a.m1383a(iBinder6));
        this.f1136p = str4;
        this.f1137q = c0842v;
    }

    public ch(ce ceVar, fs fsVar, bh bhVar, bk bkVar, ev evVar) {
        this.f1121a = 4;
        this.f1122b = ceVar;
        this.f1123c = fsVar;
        this.f1124d = bhVar;
        this.f1125e = null;
        this.f1126f = null;
        this.f1127g = null;
        this.f1128h = false;
        this.f1129i = null;
        this.f1130j = bkVar;
        this.f1131k = -1;
        this.f1132l = 4;
        this.f1133m = null;
        this.f1134n = evVar;
        this.f1135o = null;
        this.f1136p = null;
        this.f1137q = null;
    }

    public ch(fs fsVar, bh bhVar, bk bkVar, dt dtVar, int i, ev evVar, String str, C0842v c0842v) {
        this.f1121a = 4;
        this.f1122b = null;
        this.f1123c = fsVar;
        this.f1124d = bhVar;
        this.f1125e = dtVar;
        this.f1126f = null;
        this.f1127g = null;
        this.f1128h = false;
        this.f1129i = null;
        this.f1130j = bkVar;
        this.f1131k = i;
        this.f1132l = 1;
        this.f1133m = null;
        this.f1134n = evVar;
        this.f1135o = null;
        this.f1136p = str;
        this.f1137q = c0842v;
    }

    public ch(fs fsVar, bh bhVar, bk bkVar, dt dtVar, boolean z, int i, ev evVar) {
        this.f1121a = 4;
        this.f1122b = null;
        this.f1123c = fsVar;
        this.f1124d = bhVar;
        this.f1125e = dtVar;
        this.f1126f = null;
        this.f1127g = null;
        this.f1128h = z;
        this.f1129i = null;
        this.f1130j = bkVar;
        this.f1131k = i;
        this.f1132l = 2;
        this.f1133m = null;
        this.f1134n = evVar;
        this.f1135o = null;
        this.f1136p = null;
        this.f1137q = null;
    }

    public ch(fs fsVar, bh bhVar, C0817y c0817y, bk bkVar, dt dtVar, boolean z, int i, String str, ev evVar, ab abVar) {
        this.f1121a = 4;
        this.f1122b = null;
        this.f1123c = fsVar;
        this.f1124d = bhVar;
        this.f1125e = dtVar;
        this.f1126f = c0817y;
        this.f1127g = null;
        this.f1128h = z;
        this.f1129i = null;
        this.f1130j = bkVar;
        this.f1131k = i;
        this.f1132l = 3;
        this.f1133m = str;
        this.f1134n = evVar;
        this.f1135o = abVar;
        this.f1136p = null;
        this.f1137q = null;
    }

    public ch(fs fsVar, bh bhVar, C0817y c0817y, bk bkVar, dt dtVar, boolean z, int i, String str, String str2, ev evVar, ab abVar) {
        this.f1121a = 4;
        this.f1122b = null;
        this.f1123c = fsVar;
        this.f1124d = bhVar;
        this.f1125e = dtVar;
        this.f1126f = c0817y;
        this.f1127g = str2;
        this.f1128h = z;
        this.f1129i = str;
        this.f1130j = bkVar;
        this.f1131k = i;
        this.f1132l = 3;
        this.f1133m = null;
        this.f1134n = evVar;
        this.f1135o = abVar;
        this.f1136p = null;
        this.f1137q = null;
    }

    public static ch m1852a(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(ch.class.getClassLoader());
            return (ch) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e) {
            return null;
        }
    }

    public static void m1853a(Intent intent, ch chVar) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", chVar);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    IBinder m1854a() {
        return C0654d.m1384a(this.f1123c).asBinder();
    }

    IBinder m1855b() {
        return C0654d.m1384a(this.f1124d).asBinder();
    }

    IBinder m1856c() {
        return C0654d.m1384a(this.f1125e).asBinder();
    }

    IBinder m1857d() {
        return C0654d.m1384a(this.f1126f).asBinder();
    }

    public int describeContents() {
        return 0;
    }

    IBinder m1858e() {
        return C0654d.m1384a(this.f1135o).asBinder();
    }

    IBinder m1859f() {
        return C0654d.m1384a(this.f1130j).asBinder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        bg.m1707a(this, parcel, i);
    }
}
