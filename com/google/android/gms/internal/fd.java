package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.widget.PlacePickerFragment;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class fd implements Creator<jw> {
    static void m2489a(jw jwVar, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1516a(parcel, 1, jwVar.f1740e, false);
        C0676b.m1510a(parcel, (int) PlacePickerFragment.DEFAULT_RADIUS_IN_METERS, jwVar.f1739d);
        C0676b.m1510a(parcel, 2, jwVar.f1741f);
        C0676b.m1506a(parcel, a);
    }

    public jw m2490a(Parcel parcel) {
        int i = 0;
        int b = C0675a.m1487b(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    str = C0675a.m1499k(parcel, a);
                    break;
                case 2:
                    i = C0675a.m1494f(parcel, a);
                    break;
                case PlacePickerFragment.DEFAULT_RADIUS_IN_METERS /*1000*/:
                    i2 = C0675a.m1494f(parcel, a);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new jw(i2, str, i);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public jw[] m2491a(int i) {
        return new jw[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2490a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2491a(i);
    }
}
