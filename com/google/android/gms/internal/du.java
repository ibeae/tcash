package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

public final class du implements SafeParcelable {
    public static final cp CREATOR = new cp();
    public final int f1381a;
    public final String f1382b;
    public final String f1383c;
    public final List<String> f1384d;
    public final int f1385e;
    public final List<String> f1386f;
    public final long f1387g;
    public final boolean f1388h;
    public final long f1389i;
    public final List<String> f1390j;
    public final long f1391k;
    public final int f1392l;
    public final String f1393m;
    public final long f1394n;
    public final String f1395o;
    public final boolean f1396p;
    public final String f1397q;
    public final String f1398r;

    public du(int i) {
        this(7, null, null, null, i, null, -1, false, -1, null, -1, -1, null, -1, null, false, null, null);
    }

    public du(int i, long j) {
        this(7, null, null, null, i, null, -1, false, -1, null, j, -1, null, -1, null, false, null, null);
    }

    du(int i, String str, String str2, List<String> list, int i2, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i3, String str3, long j4, String str4, boolean z2, String str5, String str6) {
        this.f1381a = i;
        this.f1382b = str;
        this.f1383c = str2;
        this.f1384d = list != null ? Collections.unmodifiableList(list) : null;
        this.f1385e = i2;
        this.f1386f = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.f1387g = j;
        this.f1388h = z;
        this.f1389i = j2;
        this.f1390j = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.f1391k = j3;
        this.f1392l = i3;
        this.f1393m = str3;
        this.f1394n = j4;
        this.f1395o = str4;
        this.f1396p = z2;
        this.f1397q = str5;
        this.f1398r = str6;
    }

    public du(String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, String str5) {
        this(7, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, false, null, str5);
    }

    public du(String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, boolean z2, String str5, String str6) {
        this(7, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, z2, str5, str6);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        cp.m1950a(this, parcel, i);
    }
}
