package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ds implements SafeParcelable {
    public static final co CREATOR = new co();
    public final int f1355a;
    public final Bundle f1356b;
    public final ai f1357c;
    public final al f1358d;
    public final String f1359e;
    public final ApplicationInfo f1360f;
    public final PackageInfo f1361g;
    public final String f1362h;
    public final String f1363i;
    public final String f1364j;
    public final ev f1365k;
    public final Bundle f1366l;
    public final String f1367m;

    public static final class C0751a {
        public final Bundle f1345a;
        public final ai f1346b;
        public final al f1347c;
        public final String f1348d;
        public final ApplicationInfo f1349e;
        public final PackageInfo f1350f;
        public final String f1351g;
        public final String f1352h;
        public final Bundle f1353i;
        public final ev f1354j;

        public C0751a(Bundle bundle, ai aiVar, al alVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, ev evVar, Bundle bundle2) {
            this.f1345a = bundle;
            this.f1346b = aiVar;
            this.f1347c = alVar;
            this.f1348d = str;
            this.f1349e = applicationInfo;
            this.f1350f = packageInfo;
            this.f1351g = str2;
            this.f1352h = str3;
            this.f1354j = evVar;
            this.f1353i = bundle2;
        }
    }

    ds(int i, Bundle bundle, ai aiVar, al alVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, ev evVar, Bundle bundle2, String str5) {
        this.f1355a = i;
        this.f1356b = bundle;
        this.f1357c = aiVar;
        this.f1358d = alVar;
        this.f1359e = str;
        this.f1360f = applicationInfo;
        this.f1361g = packageInfo;
        this.f1362h = str2;
        this.f1363i = str3;
        this.f1364j = str4;
        this.f1365k = evVar;
        this.f1366l = bundle2;
        this.f1367m = str5;
    }

    public ds(Bundle bundle, ai aiVar, al alVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, ev evVar, Bundle bundle2, String str5) {
        this(3, bundle, aiVar, alVar, str, applicationInfo, packageInfo, str2, str3, str4, evVar, bundle2, str5);
    }

    public ds(C0751a c0751a, String str, String str2) {
        this(c0751a.f1345a, c0751a.f1346b, c0751a.f1347c, c0751a.f1348d, c0751a.f1349e, c0751a.f1350f, str, c0751a.f1351g, c0751a.f1352h, c0751a.f1354j, c0751a.f1353i, str2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        co.m1947a(this, parcel, i);
    }
}
