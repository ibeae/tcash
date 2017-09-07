package com.google.android.gms.maps.p029a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p027a.C0651c;
import com.google.android.gms.p027a.C0651c.C0653a;

public interface C0914r extends IInterface {

    public static abstract class C0916a extends Binder implements C0914r {

        private static class C0915a implements C0914r {
            private IBinder f1869a;

            C0915a(IBinder iBinder) {
                this.f1869a = iBinder;
            }

            public void mo1265a(C0651c c0651c) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                    obtain.writeStrongBinder(c0651c != null ? c0651c.asBinder() : null);
                    this.f1869a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f1869a;
            }
        }

        public static C0914r m3195a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0914r)) ? new C0915a(iBinder) : (C0914r) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                    mo1265a(C0653a.m1383a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo1265a(C0651c c0651c);
}
