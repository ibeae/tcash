package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.actionbarsherlock.view.Menu;
import java.util.List;

public class C0676b {
    public static int m1505a(Parcel parcel) {
        return C0676b.m1524b(parcel, 20293);
    }

    public static void m1506a(Parcel parcel, int i) {
        C0676b.m1527c(parcel, i);
    }

    public static void m1507a(Parcel parcel, int i, byte b) {
        C0676b.m1525b(parcel, i, 4);
        parcel.writeInt(b);
    }

    public static void m1508a(Parcel parcel, int i, double d) {
        C0676b.m1525b(parcel, i, 8);
        parcel.writeDouble(d);
    }

    public static void m1509a(Parcel parcel, int i, float f) {
        C0676b.m1525b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void m1510a(Parcel parcel, int i, int i2) {
        C0676b.m1525b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void m1511a(Parcel parcel, int i, long j) {
        C0676b.m1525b(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void m1512a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int b = C0676b.m1524b(parcel, i);
            parcel.writeBundle(bundle);
            C0676b.m1527c(parcel, b);
        } else if (z) {
            C0676b.m1525b(parcel, i, 0);
        }
    }

    public static void m1513a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int b = C0676b.m1524b(parcel, i);
            parcel.writeStrongBinder(iBinder);
            C0676b.m1527c(parcel, b);
        } else if (z) {
            C0676b.m1525b(parcel, i, 0);
        }
    }

    public static void m1514a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int b = C0676b.m1524b(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            C0676b.m1527c(parcel, b);
        } else if (z) {
            C0676b.m1525b(parcel, i, 0);
        }
    }

    public static void m1515a(Parcel parcel, int i, Integer num, boolean z) {
        if (num != null) {
            C0676b.m1525b(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            C0676b.m1525b(parcel, i, 0);
        }
    }

    public static void m1516a(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int b = C0676b.m1524b(parcel, i);
            parcel.writeString(str);
            C0676b.m1527c(parcel, b);
        } else if (z) {
            C0676b.m1525b(parcel, i, 0);
        }
    }

    public static void m1517a(Parcel parcel, int i, List<String> list, boolean z) {
        if (list != null) {
            int b = C0676b.m1524b(parcel, i);
            parcel.writeStringList(list);
            C0676b.m1527c(parcel, b);
        } else if (z) {
            C0676b.m1525b(parcel, i, 0);
        }
    }

    public static void m1518a(Parcel parcel, int i, short s) {
        C0676b.m1525b(parcel, i, 4);
        parcel.writeInt(s);
    }

    public static void m1519a(Parcel parcel, int i, boolean z) {
        C0676b.m1525b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void m1520a(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int b = C0676b.m1524b(parcel, i);
            parcel.writeByteArray(bArr);
            C0676b.m1527c(parcel, b);
        } else if (z) {
            C0676b.m1525b(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void m1521a(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int b = C0676b.m1524b(parcel, i);
            parcel.writeInt(r3);
            for (Parcelable parcelable : tArr) {
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    C0676b.m1523a(parcel, parcelable, i2);
                }
            }
            C0676b.m1527c(parcel, b);
        } else if (z) {
            C0676b.m1525b(parcel, i, 0);
        }
    }

    public static void m1522a(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr != null) {
            int b = C0676b.m1524b(parcel, i);
            parcel.writeStringArray(strArr);
            C0676b.m1527c(parcel, b);
        } else if (z) {
            C0676b.m1525b(parcel, i, 0);
        }
    }

    private static <T extends Parcelable> void m1523a(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    private static int m1524b(Parcel parcel, int i) {
        parcel.writeInt(Menu.CATEGORY_MASK | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void m1525b(Parcel parcel, int i, int i2) {
        if (i2 >= Menu.USER_MASK) {
            parcel.writeInt(Menu.CATEGORY_MASK | i);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt((i2 << 16) | i);
    }

    public static <T extends Parcelable> void m1526b(Parcel parcel, int i, List<T> list, boolean z) {
        if (list != null) {
            int b = C0676b.m1524b(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    C0676b.m1523a(parcel, parcelable, 0);
                }
            }
            C0676b.m1527c(parcel, b);
        } else if (z) {
            C0676b.m1525b(parcel, i, 0);
        }
    }

    private static void m1527c(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        int i2 = dataPosition - i;
        parcel.setDataPosition(i - 4);
        parcel.writeInt(i2);
        parcel.setDataPosition(dataPosition);
    }

    public static void m1528c(Parcel parcel, int i, List list, boolean z) {
        if (list != null) {
            int b = C0676b.m1524b(parcel, i);
            parcel.writeList(list);
            C0676b.m1527c(parcel, b);
        } else if (z) {
            C0676b.m1525b(parcel, i, 0);
        }
    }
}
