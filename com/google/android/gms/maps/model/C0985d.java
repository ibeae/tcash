package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class C0985d implements Creator<CircleOptions> {
    static void m3604a(CircleOptions circleOptions, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, circleOptions.m3265a());
        C0676b.m1514a(parcel, 2, circleOptions.m3266b(), i, false);
        C0676b.m1508a(parcel, 3, circleOptions.m3267c());
        C0676b.m1509a(parcel, 4, circleOptions.m3268d());
        C0676b.m1510a(parcel, 5, circleOptions.m3269e());
        C0676b.m1510a(parcel, 6, circleOptions.m3270f());
        C0676b.m1509a(parcel, 7, circleOptions.m3271g());
        C0676b.m1519a(parcel, 8, circleOptions.m3272h());
        C0676b.m1506a(parcel, a);
    }

    public CircleOptions m3605a(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int b = C0675a.m1487b(parcel);
        LatLng latLng = null;
        double d = 0.0d;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    i3 = C0675a.m1494f(parcel, a);
                    break;
                case 2:
                    latLng = (LatLng) C0675a.m1483a(parcel, a, LatLng.CREATOR);
                    break;
                case 3:
                    d = C0675a.m1498j(parcel, a);
                    break;
                case 4:
                    f2 = C0675a.m1497i(parcel, a);
                    break;
                case 5:
                    i2 = C0675a.m1494f(parcel, a);
                    break;
                case 6:
                    i = C0675a.m1494f(parcel, a);
                    break;
                case 7:
                    f = C0675a.m1497i(parcel, a);
                    break;
                case 8:
                    z = C0675a.m1491c(parcel, a);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new CircleOptions(i3, latLng, d, f2, i2, i, f, z);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public CircleOptions[] m3606a(int i) {
        return new CircleOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3605a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3606a(i);
    }
}
