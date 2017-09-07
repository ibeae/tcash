package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;
import java.util.List;

public class C0992k implements Creator<PolylineOptions> {
    static void m3622a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, polylineOptions.m3311a());
        C0676b.m1526b(parcel, 2, polylineOptions.m3312b(), false);
        C0676b.m1509a(parcel, 3, polylineOptions.m3313c());
        C0676b.m1510a(parcel, 4, polylineOptions.m3314d());
        C0676b.m1509a(parcel, 5, polylineOptions.m3315e());
        C0676b.m1519a(parcel, 6, polylineOptions.m3316f());
        C0676b.m1519a(parcel, 7, polylineOptions.m3317g());
        C0676b.m1506a(parcel, a);
    }

    public PolylineOptions m3623a(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int b = C0675a.m1487b(parcel);
        List list = null;
        boolean z2 = false;
        int i = 0;
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    i2 = C0675a.m1494f(parcel, a);
                    break;
                case 2:
                    list = C0675a.m1490c(parcel, a, LatLng.CREATOR);
                    break;
                case 3:
                    f2 = C0675a.m1497i(parcel, a);
                    break;
                case 4:
                    i = C0675a.m1494f(parcel, a);
                    break;
                case 5:
                    f = C0675a.m1497i(parcel, a);
                    break;
                case 6:
                    z2 = C0675a.m1491c(parcel, a);
                    break;
                case 7:
                    z = C0675a.m1491c(parcel, a);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new PolylineOptions(i2, list, f2, i, f, z2, z);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public PolylineOptions[] m3624a(int i) {
        return new PolylineOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3623a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3624a(i);
    }
}
