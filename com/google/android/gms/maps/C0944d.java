package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;
import com.google.android.gms.maps.model.CameraPosition;

public class C0944d implements Creator<GoogleMapOptions> {
    static void m3232a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, googleMapOptions.m2821a());
        C0676b.m1507a(parcel, 2, googleMapOptions.m2825b());
        C0676b.m1507a(parcel, 3, googleMapOptions.m2827c());
        C0676b.m1510a(parcel, 4, googleMapOptions.m2840j());
        C0676b.m1514a(parcel, 5, googleMapOptions.m2841k(), i, false);
        C0676b.m1507a(parcel, 6, googleMapOptions.m2829d());
        C0676b.m1507a(parcel, 7, googleMapOptions.m2831e());
        C0676b.m1507a(parcel, 8, googleMapOptions.m2833f());
        C0676b.m1507a(parcel, 9, googleMapOptions.m2835g());
        C0676b.m1507a(parcel, 10, googleMapOptions.m2837h());
        C0676b.m1507a(parcel, 11, googleMapOptions.m2839i());
        C0676b.m1506a(parcel, a);
    }

    public GoogleMapOptions m3233a(Parcel parcel) {
        byte b = (byte) 0;
        int b2 = C0675a.m1487b(parcel);
        CameraPosition cameraPosition = null;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        byte b6 = (byte) 0;
        byte b7 = (byte) 0;
        int i = 0;
        byte b8 = (byte) 0;
        byte b9 = (byte) 0;
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    i2 = C0675a.m1494f(parcel, a);
                    break;
                case 2:
                    b9 = C0675a.m1492d(parcel, a);
                    break;
                case 3:
                    b8 = C0675a.m1492d(parcel, a);
                    break;
                case 4:
                    i = C0675a.m1494f(parcel, a);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) C0675a.m1483a(parcel, a, CameraPosition.CREATOR);
                    break;
                case 6:
                    b7 = C0675a.m1492d(parcel, a);
                    break;
                case 7:
                    b6 = C0675a.m1492d(parcel, a);
                    break;
                case 8:
                    b5 = C0675a.m1492d(parcel, a);
                    break;
                case 9:
                    b4 = C0675a.m1492d(parcel, a);
                    break;
                case 10:
                    b3 = C0675a.m1492d(parcel, a);
                    break;
                case 11:
                    b = C0675a.m1492d(parcel, a);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b2) {
            return new GoogleMapOptions(i2, b9, b8, i, cameraPosition, b7, b6, b5, b4, b3, b);
        }
        throw new C0674a("Overread allowed size end=" + b2, parcel);
    }

    public GoogleMapOptions[] m3234a(int i) {
        return new GoogleMapOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3233a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3234a(i);
    }
}
