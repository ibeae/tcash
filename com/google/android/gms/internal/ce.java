package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ce implements SafeParcelable {
    public static final be CREATOR = new be();
    public final int f1111a;
    public final String f1112b;
    public final String f1113c;
    public final String f1114d;
    public final String f1115e;
    public final String f1116f;
    public final String f1117g;
    public final String f1118h;

    public ce(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f1111a = i;
        this.f1112b = str;
        this.f1113c = str2;
        this.f1114d = str3;
        this.f1115e = str4;
        this.f1116f = str5;
        this.f1117g = str6;
        this.f1118h = str7;
    }

    public ce(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(1, str, str2, str3, str4, str5, str6, str7);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        be.m1670a(this, parcel, i);
    }
}
