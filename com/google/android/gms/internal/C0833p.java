package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.at.C0682a;
import com.google.android.gms.p027a.C0651c;
import com.google.android.gms.p027a.C0651c.C0653a;

public interface C0833p extends IInterface {

    public static abstract class C0835a extends Binder implements C0833p {

        private static class C0834a implements C0833p {
            private IBinder f1750a;

            C0834a(IBinder iBinder) {
                this.f1750a = iBinder;
            }

            public IBinder mo1109a(C0651c c0651c, al alVar, String str, at atVar, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    obtain.writeStrongBinder(c0651c != null ? c0651c.asBinder() : null);
                    if (alVar != null) {
                        obtain.writeInt(1);
                        alVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (atVar != null) {
                        iBinder = atVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.f1750a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    iBinder = obtain2.readStrongBinder();
                    return iBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f1750a;
            }
        }

        public static C0833p m2738a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0833p)) ? new C0834a(iBinder) : (C0833p) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    IBinder a = mo1109a(C0653a.m1383a(parcel.readStrongBinder()), parcel.readInt() != 0 ? al.CREATOR.m2708a(parcel) : null, parcel.readString(), C0682a.m1591a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    IBinder mo1109a(C0651c c0651c, al alVar, String str, at atVar, int i);
}
