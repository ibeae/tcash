package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.widget.PlacePickerFragment;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class C0858e implements Creator<C0855b> {
    static void m2817a(C0855b c0855b, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, c0855b.f1821a);
        C0676b.m1510a(parcel, (int) PlacePickerFragment.DEFAULT_RADIUS_IN_METERS, c0855b.m2812a());
        C0676b.m1510a(parcel, 2, c0855b.f1822b);
        C0676b.m1511a(parcel, 3, c0855b.f1823c);
        C0676b.m1506a(parcel, a);
    }

    public C0855b m2818a(Parcel parcel) {
        int i = 1;
        int b = C0675a.m1487b(parcel);
        int i2 = 0;
        long j = 0;
        int i3 = 1;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    i3 = C0675a.m1494f(parcel, a);
                    break;
                case 2:
                    i = C0675a.m1494f(parcel, a);
                    break;
                case 3:
                    j = C0675a.m1496h(parcel, a);
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
            return new C0855b(i2, i3, i, j);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public C0855b[] m2819a(int i) {
        return new C0855b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2818a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2819a(i);
    }
}
