package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.widget.PlacePickerFragment;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class C0671a implements Creator<DataHolder> {
    static void m1462a(DataHolder dataHolder, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1522a(parcel, 1, dataHolder.m1456c(), false);
        C0676b.m1510a(parcel, (int) PlacePickerFragment.DEFAULT_RADIUS_IN_METERS, dataHolder.m1455b());
        C0676b.m1521a(parcel, 2, dataHolder.m1457d(), i, false);
        C0676b.m1510a(parcel, 3, dataHolder.m1458e());
        C0676b.m1512a(parcel, 4, dataHolder.m1459f(), false);
        C0676b.m1506a(parcel, a);
    }

    public DataHolder m1463a(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int b = C0675a.m1487b(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    strArr = C0675a.m1503o(parcel, a);
                    break;
                case 2:
                    cursorWindowArr = (CursorWindow[]) C0675a.m1489b(parcel, a, CursorWindow.CREATOR);
                    break;
                case 3:
                    i = C0675a.m1494f(parcel, a);
                    break;
                case 4:
                    bundle = C0675a.m1501m(parcel, a);
                    break;
                case PlacePickerFragment.DEFAULT_RADIUS_IN_METERS /*1000*/:
                    i2 = C0675a.m1494f(parcel, a);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new C0674a("Overread allowed size end=" + b, parcel);
        }
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.m1454a();
        return dataHolder;
    }

    public DataHolder[] m1464a(int i) {
        return new DataHolder[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1463a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1464a(i);
    }
}
