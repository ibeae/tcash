package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.widget.PlacePickerFragment;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class C0856c implements Creator<LocationRequest> {
    static void m2813a(LocationRequest locationRequest, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, locationRequest.f1812a);
        C0676b.m1510a(parcel, (int) PlacePickerFragment.DEFAULT_RADIUS_IN_METERS, locationRequest.m2806a());
        C0676b.m1511a(parcel, 2, locationRequest.f1813b);
        C0676b.m1511a(parcel, 3, locationRequest.f1814c);
        C0676b.m1519a(parcel, 4, locationRequest.f1815d);
        C0676b.m1511a(parcel, 5, locationRequest.f1816e);
        C0676b.m1510a(parcel, 6, locationRequest.f1817f);
        C0676b.m1509a(parcel, 7, locationRequest.f1818g);
        C0676b.m1506a(parcel, a);
    }

    public LocationRequest m2814a(Parcel parcel) {
        boolean z = false;
        int b = C0675a.m1487b(parcel);
        int i = 102;
        long j = 3600000;
        long j2 = 600000;
        long j3 = Long.MAX_VALUE;
        int i2 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        float f = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    i = C0675a.m1494f(parcel, a);
                    break;
                case 2:
                    j = C0675a.m1496h(parcel, a);
                    break;
                case 3:
                    j2 = C0675a.m1496h(parcel, a);
                    break;
                case 4:
                    z = C0675a.m1491c(parcel, a);
                    break;
                case 5:
                    j3 = C0675a.m1496h(parcel, a);
                    break;
                case 6:
                    i2 = C0675a.m1494f(parcel, a);
                    break;
                case 7:
                    f = C0675a.m1497i(parcel, a);
                    break;
                case PlacePickerFragment.DEFAULT_RADIUS_IN_METERS /*1000*/:
                    i3 = C0675a.m1494f(parcel, a);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new LocationRequest(i3, i, j, j2, z, j3, i2, f);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public LocationRequest[] m2815a(int i) {
        return new LocationRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2814a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2815a(i);
    }
}
