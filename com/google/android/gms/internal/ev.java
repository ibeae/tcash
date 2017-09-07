package com.google.android.gms.internal;

import android.os.Parcel;
import com.facebook.AppEventsConstants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ev implements SafeParcelable {
    public static final dr CREATOR = new dr();
    public final int f1563a;
    public String f1564b;
    public int f1565c;
    public int f1566d;
    public boolean f1567e;

    public ev(int i, int i2, boolean z) {
        this(1, "afma-sdk-a-v" + i + "." + i2 + "." + (z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES), i, i2, z);
    }

    ev(int i, String str, int i2, int i3, boolean z) {
        this.f1563a = i;
        this.f1564b = str;
        this.f1565c = i2;
        this.f1566d = i3;
        this.f1567e = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        dr.m2121a(this, parcel, i);
    }
}
