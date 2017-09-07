package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class aw implements SafeParcelable {
    public static final C0841u CREATOR = new C0841u();
    public final int f962a;
    public final int f963b;
    public final int f964c;
    public final int f965d;
    public final int f966e;
    public final int f967f;
    public final int f968g;
    public final int f969h;
    public final int f970i;
    public final String f971j;
    public final int f972k;
    public final String f973l;
    public final int f974m;
    public final int f975n;
    public final String f976o;

    aw(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str, int i10, String str2, int i11, int i12, String str3) {
        this.f962a = i;
        this.f963b = i2;
        this.f964c = i3;
        this.f965d = i4;
        this.f966e = i5;
        this.f967f = i6;
        this.f968g = i7;
        this.f969h = i8;
        this.f970i = i9;
        this.f971j = str;
        this.f972k = i10;
        this.f973l = str2;
        this.f974m = i11;
        this.f975n = i12;
        this.f976o = str3;
    }

    public aw(SearchAdRequest searchAdRequest) {
        this.f962a = 1;
        this.f963b = searchAdRequest.m1435a();
        this.f964c = searchAdRequest.m1436b();
        this.f965d = searchAdRequest.m1437c();
        this.f966e = searchAdRequest.m1438d();
        this.f967f = searchAdRequest.m1439e();
        this.f968g = searchAdRequest.m1440f();
        this.f969h = searchAdRequest.m1441g();
        this.f970i = searchAdRequest.m1442h();
        this.f971j = searchAdRequest.m1443i();
        this.f972k = searchAdRequest.m1444j();
        this.f973l = searchAdRequest.m1445k();
        this.f974m = searchAdRequest.m1446l();
        this.f975n = searchAdRequest.m1447m();
        this.f976o = searchAdRequest.m1448n();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0841u.m2791a(this, parcel, i);
    }
}
