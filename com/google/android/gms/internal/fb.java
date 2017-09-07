package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.widget.PlacePickerFragment;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class fb implements Creator<js> {
    static void m2483a(js jsVar, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1516a(parcel, 1, jsVar.bx, false);
        C0676b.m1510a(parcel, (int) PlacePickerFragment.DEFAULT_RADIUS_IN_METERS, jsVar.bw);
        C0676b.m1506a(parcel, a);
    }

    public js m2484a(Parcel parcel) {
        int b = C0675a.m1487b(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
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
            return new js(i, str);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public js[] m2485a(int i) {
        return new js[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2484a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2485a(i);
    }
}
