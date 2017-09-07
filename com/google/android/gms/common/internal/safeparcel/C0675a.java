package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.actionbarsherlock.view.Menu;
import java.util.ArrayList;
import java.util.List;

public class C0675a {

    public static class C0674a extends RuntimeException {
        public C0674a(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    public static int m1480a(int i) {
        return Menu.USER_MASK & i;
    }

    public static int m1481a(Parcel parcel) {
        return parcel.readInt();
    }

    public static int m1482a(Parcel parcel, int i) {
        return (i & Menu.CATEGORY_MASK) != Menu.CATEGORY_MASK ? (i >> 16) & Menu.USER_MASK : parcel.readInt();
    }

    public static <T extends Parcelable> T m1483a(Parcel parcel, int i, Creator<T> creator) {
        int a = C0675a.m1482a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(a + dataPosition);
        return parcelable;
    }

    private static void m1484a(Parcel parcel, int i, int i2) {
        int a = C0675a.m1482a(parcel, i);
        if (a != i2) {
            throw new C0674a("Expected size " + i2 + " got " + a + " (0x" + Integer.toHexString(a) + ")", parcel);
        }
    }

    private static void m1485a(Parcel parcel, int i, int i2, int i3) {
        if (i2 != i3) {
            throw new C0674a("Expected size " + i3 + " got " + i2 + " (0x" + Integer.toHexString(i2) + ")", parcel);
        }
    }

    public static void m1486a(Parcel parcel, int i, List list, ClassLoader classLoader) {
        int a = C0675a.m1482a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a != 0) {
            parcel.readList(list, classLoader);
            parcel.setDataPosition(a + dataPosition);
        }
    }

    public static int m1487b(Parcel parcel) {
        int a = C0675a.m1481a(parcel);
        int a2 = C0675a.m1482a(parcel, a);
        int dataPosition = parcel.dataPosition();
        if (C0675a.m1480a(a) != 20293) {
            throw new C0674a("Expected object header. Got 0x" + Integer.toHexString(a), parcel);
        }
        a = dataPosition + a2;
        if (a >= dataPosition && a <= parcel.dataSize()) {
            return a;
        }
        throw new C0674a("Size read is invalid start=" + dataPosition + " end=" + a, parcel);
    }

    public static void m1488b(Parcel parcel, int i) {
        parcel.setDataPosition(C0675a.m1482a(parcel, i) + parcel.dataPosition());
    }

    public static <T> T[] m1489b(Parcel parcel, int i, Creator<T> creator) {
        int a = C0675a.m1482a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        T[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArray;
    }

    public static <T> ArrayList<T> m1490c(Parcel parcel, int i, Creator<T> creator) {
        int a = C0675a.m1482a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArrayList;
    }

    public static boolean m1491c(Parcel parcel, int i) {
        C0675a.m1484a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static byte m1492d(Parcel parcel, int i) {
        C0675a.m1484a(parcel, i, 4);
        return (byte) parcel.readInt();
    }

    public static short m1493e(Parcel parcel, int i) {
        C0675a.m1484a(parcel, i, 4);
        return (short) parcel.readInt();
    }

    public static int m1494f(Parcel parcel, int i) {
        C0675a.m1484a(parcel, i, 4);
        return parcel.readInt();
    }

    public static Integer m1495g(Parcel parcel, int i) {
        int a = C0675a.m1482a(parcel, i);
        if (a == 0) {
            return null;
        }
        C0675a.m1485a(parcel, i, a, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static long m1496h(Parcel parcel, int i) {
        C0675a.m1484a(parcel, i, 8);
        return parcel.readLong();
    }

    public static float m1497i(Parcel parcel, int i) {
        C0675a.m1484a(parcel, i, 4);
        return parcel.readFloat();
    }

    public static double m1498j(Parcel parcel, int i) {
        C0675a.m1484a(parcel, i, 8);
        return parcel.readDouble();
    }

    public static String m1499k(Parcel parcel, int i) {
        int a = C0675a.m1482a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(a + dataPosition);
        return readString;
    }

    public static IBinder m1500l(Parcel parcel, int i) {
        int a = C0675a.m1482a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(a + dataPosition);
        return readStrongBinder;
    }

    public static Bundle m1501m(Parcel parcel, int i) {
        int a = C0675a.m1482a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(a + dataPosition);
        return readBundle;
    }

    public static byte[] m1502n(Parcel parcel, int i) {
        int a = C0675a.m1482a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a + dataPosition);
        return createByteArray;
    }

    public static String[] m1503o(Parcel parcel, int i) {
        int a = C0675a.m1482a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(a + dataPosition);
        return createStringArray;
    }

    public static ArrayList<String> m1504p(Parcel parcel, int i) {
        int a = C0675a.m1482a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(a + dataPosition);
        return createStringArrayList;
    }
}
