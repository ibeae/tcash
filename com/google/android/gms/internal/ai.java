package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class ai implements SafeParcelable {
    public static final C0824i CREATOR = new C0824i();
    public final int f891a;
    public final long f892b;
    public final Bundle f893c;
    public final int f894d;
    public final List<String> f895e;
    public final boolean f896f;
    public final int f897g;
    public final boolean f898h;
    public final String f899i;
    public final aw f900j;
    public final Location f901k;
    public final String f902l;
    public final Bundle f903m;

    public ai(int i, long j, Bundle bundle, int i2, List<String> list, boolean z, int i3, boolean z2, String str, aw awVar, Location location, String str2, Bundle bundle2) {
        this.f891a = i;
        this.f892b = j;
        this.f893c = bundle;
        this.f894d = i2;
        this.f895e = list;
        this.f896f = z;
        this.f897g = i3;
        this.f898h = z2;
        this.f899i = str;
        this.f900j = awVar;
        this.f901k = location;
        this.f902l = str2;
        this.f903m = bundle2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0824i.m2666a(this, parcel, i);
    }
}
