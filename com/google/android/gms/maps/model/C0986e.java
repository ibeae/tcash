package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class C0986e implements Creator<GroundOverlayOptions> {
    static void m3607a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, groundOverlayOptions.m3274b());
        C0676b.m1513a(parcel, 2, groundOverlayOptions.m3273a(), false);
        C0676b.m1514a(parcel, 3, groundOverlayOptions.m3275c(), i, false);
        C0676b.m1509a(parcel, 4, groundOverlayOptions.m3276d());
        C0676b.m1509a(parcel, 5, groundOverlayOptions.m3277e());
        C0676b.m1514a(parcel, 6, groundOverlayOptions.m3278f(), i, false);
        C0676b.m1509a(parcel, 7, groundOverlayOptions.m3279g());
        C0676b.m1509a(parcel, 8, groundOverlayOptions.m3280h());
        C0676b.m1519a(parcel, 9, groundOverlayOptions.m3284l());
        C0676b.m1509a(parcel, 10, groundOverlayOptions.m3281i());
        C0676b.m1509a(parcel, 11, groundOverlayOptions.m3282j());
        C0676b.m1509a(parcel, 12, groundOverlayOptions.m3283k());
        C0676b.m1506a(parcel, a);
    }

    public GroundOverlayOptions m3608a(Parcel parcel) {
        int b = C0675a.m1487b(parcel);
        int i = 0;
        IBinder iBinder = null;
        LatLng latLng = null;
        float f = 0.0f;
        float f2 = 0.0f;
        LatLngBounds latLngBounds = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        boolean z = false;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    i = C0675a.m1494f(parcel, a);
                    break;
                case 2:
                    iBinder = C0675a.m1500l(parcel, a);
                    break;
                case 3:
                    latLng = (LatLng) C0675a.m1483a(parcel, a, LatLng.CREATOR);
                    break;
                case 4:
                    f = C0675a.m1497i(parcel, a);
                    break;
                case 5:
                    f2 = C0675a.m1497i(parcel, a);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) C0675a.m1483a(parcel, a, LatLngBounds.CREATOR);
                    break;
                case 7:
                    f3 = C0675a.m1497i(parcel, a);
                    break;
                case 8:
                    f4 = C0675a.m1497i(parcel, a);
                    break;
                case 9:
                    z = C0675a.m1491c(parcel, a);
                    break;
                case 10:
                    f5 = C0675a.m1497i(parcel, a);
                    break;
                case 11:
                    f6 = C0675a.m1497i(parcel, a);
                    break;
                case 12:
                    f7 = C0675a.m1497i(parcel, a);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GroundOverlayOptions(i, iBinder, latLng, f, f2, latLngBounds, f3, f4, z, f5, f6, f7);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public GroundOverlayOptions[] m3609a(int i) {
        return new GroundOverlayOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3608a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3609a(i);
    }
}
