package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class C0990i implements Creator<MarkerOptions> {
    static void m3616a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, markerOptions.m3287a());
        C0676b.m1514a(parcel, 2, markerOptions.m3290c(), i, false);
        C0676b.m1516a(parcel, 3, markerOptions.m3291d(), false);
        C0676b.m1516a(parcel, 4, markerOptions.m3292e(), false);
        C0676b.m1513a(parcel, 5, markerOptions.m3289b(), false);
        C0676b.m1509a(parcel, 6, markerOptions.m3293f());
        C0676b.m1509a(parcel, 7, markerOptions.m3294g());
        C0676b.m1519a(parcel, 8, markerOptions.m3295h());
        C0676b.m1519a(parcel, 9, markerOptions.m3296i());
        C0676b.m1519a(parcel, 10, markerOptions.m3297j());
        C0676b.m1509a(parcel, 11, markerOptions.m3298k());
        C0676b.m1509a(parcel, 12, markerOptions.m3299l());
        C0676b.m1509a(parcel, 13, markerOptions.m3300m());
        C0676b.m1509a(parcel, 14, markerOptions.m3301n());
        C0676b.m1506a(parcel, a);
    }

    public MarkerOptions m3617a(Parcel parcel) {
        int b = C0675a.m1487b(parcel);
        int i = 0;
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f3 = 0.0f;
        float f4 = 0.5f;
        float f5 = 0.0f;
        float f6 = 1.0f;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    i = C0675a.m1494f(parcel, a);
                    break;
                case 2:
                    latLng = (LatLng) C0675a.m1483a(parcel, a, LatLng.CREATOR);
                    break;
                case 3:
                    str = C0675a.m1499k(parcel, a);
                    break;
                case 4:
                    str2 = C0675a.m1499k(parcel, a);
                    break;
                case 5:
                    iBinder = C0675a.m1500l(parcel, a);
                    break;
                case 6:
                    f = C0675a.m1497i(parcel, a);
                    break;
                case 7:
                    f2 = C0675a.m1497i(parcel, a);
                    break;
                case 8:
                    z = C0675a.m1491c(parcel, a);
                    break;
                case 9:
                    z2 = C0675a.m1491c(parcel, a);
                    break;
                case 10:
                    z3 = C0675a.m1491c(parcel, a);
                    break;
                case 11:
                    f3 = C0675a.m1497i(parcel, a);
                    break;
                case 12:
                    f4 = C0675a.m1497i(parcel, a);
                    break;
                case 13:
                    f5 = C0675a.m1497i(parcel, a);
                    break;
                case 14:
                    f6 = C0675a.m1497i(parcel, a);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new MarkerOptions(i, latLng, str, str2, iBinder, f, f2, z, z2, z3, f3, f4, f5, f6);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public MarkerOptions[] m3618a(int i) {
        return new MarkerOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3617a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3618a(i);
    }
}
