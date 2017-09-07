package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class C0984c implements Creator<CameraPosition> {
    static void m3601a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, cameraPosition.m3264a());
        C0676b.m1514a(parcel, 2, cameraPosition.f1892a, i, false);
        C0676b.m1509a(parcel, 3, cameraPosition.f1893b);
        C0676b.m1509a(parcel, 4, cameraPosition.f1894c);
        C0676b.m1509a(parcel, 5, cameraPosition.f1895d);
        C0676b.m1506a(parcel, a);
    }

    public CameraPosition m3602a(Parcel parcel) {
        float f = 0.0f;
        int b = C0675a.m1487b(parcel);
        int i = 0;
        LatLng latLng = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
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
                    f3 = C0675a.m1497i(parcel, a);
                    break;
                case 4:
                    f2 = C0675a.m1497i(parcel, a);
                    break;
                case 5:
                    f = C0675a.m1497i(parcel, a);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new CameraPosition(i, latLng, f3, f2, f);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public CameraPosition[] m3603a(int i) {
        return new CameraPosition[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3602a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3603a(i);
    }
}
