package com.google.android.gms.p027a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface C0651c extends IInterface {

    public static abstract class C0653a extends Binder implements C0651c {

        private static class C0652a implements C0651c {
            private IBinder f808a;

            C0652a(IBinder iBinder) {
                this.f808a = iBinder;
            }

            public IBinder asBinder() {
                return this.f808a;
            }
        }

        public C0653a() {
            attachInterface(this, "com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static C0651c m1383a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0651c)) ? new C0652a(iBinder) : (C0651c) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.dynamic.IObjectWrapper");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }
}
