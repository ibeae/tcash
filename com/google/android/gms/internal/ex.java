package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.widget.PlacePickerFragment;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class ex implements Creator<jk> {
    static void m2463a(jk jkVar, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, jkVar.m2687b());
        C0676b.m1510a(parcel, (int) PlacePickerFragment.DEFAULT_RADIUS_IN_METERS, jkVar.m2686a());
        C0676b.m1510a(parcel, 2, jkVar.m2688c());
        C0676b.m1514a(parcel, 3, jkVar.m2689d(), i, false);
        C0676b.m1506a(parcel, a);
    }

    public jk m2464a(Parcel parcel) {
        int i = 0;
        int b = C0675a.m1487b(parcel);
        int i2 = -1;
        jm jmVar = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    i = C0675a.m1494f(parcel, a);
                    break;
                case 2:
                    i2 = C0675a.m1494f(parcel, a);
                    break;
                case 3:
                    jmVar = (jm) C0675a.m1483a(parcel, a, jm.CREATOR);
                    break;
                case PlacePickerFragment.DEFAULT_RADIUS_IN_METERS /*1000*/:
                    i3 = C0675a.m1494f(parcel, a);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new jk(i3, i, i2, jmVar);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public jk[] m2465a(int i) {
        return new jk[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2464a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2465a(i);
    }
}
