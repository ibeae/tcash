package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.widget.PlacePickerFragment;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

public class fc implements Creator<ju> {
    static void m2486a(ju juVar, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1516a(parcel, 1, juVar.m2700a(), false);
        C0676b.m1510a(parcel, (int) PlacePickerFragment.DEFAULT_RADIUS_IN_METERS, juVar.f1729a);
        C0676b.m1514a(parcel, 2, juVar.m2701b(), i, false);
        C0676b.m1516a(parcel, 3, juVar.m2702c(), false);
        C0676b.m1526b(parcel, 4, juVar.m2703d(), false);
        C0676b.m1516a(parcel, 5, juVar.m2704e(), false);
        C0676b.m1516a(parcel, 6, juVar.m2705f(), false);
        C0676b.m1506a(parcel, a);
    }

    public ju m2487a(Parcel parcel) {
        String str = null;
        int b = C0675a.m1487b(parcel);
        int i = 0;
        String str2 = null;
        List list = null;
        String str3 = null;
        LatLng latLng = null;
        String str4 = null;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    str4 = C0675a.m1499k(parcel, a);
                    break;
                case 2:
                    latLng = (LatLng) C0675a.m1483a(parcel, a, LatLng.CREATOR);
                    break;
                case 3:
                    str3 = C0675a.m1499k(parcel, a);
                    break;
                case 4:
                    list = C0675a.m1490c(parcel, a, js.CREATOR);
                    break;
                case 5:
                    str2 = C0675a.m1499k(parcel, a);
                    break;
                case 6:
                    str = C0675a.m1499k(parcel, a);
                    break;
                case PlacePickerFragment.DEFAULT_RADIUS_IN_METERS /*1000*/:
                    i = C0675a.m1494f(parcel, a);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ju(i, str4, latLng, str3, list, str2, str);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public ju[] m2488a(int i) {
        return new ju[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2487a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2488a(i);
    }
}
