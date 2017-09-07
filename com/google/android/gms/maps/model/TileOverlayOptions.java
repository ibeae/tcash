package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.p030a.C0979i;
import com.google.android.gms.maps.model.p030a.C0979i.C0981a;
import com.google.android.gms.maps.p029a.af;

public final class TileOverlayOptions implements SafeParcelable {
    public static final C0999r CREATOR = new C0999r();
    private final int f1977a;
    private C0979i f1978b;
    private C0953s f1979c;
    private boolean f1980d;
    private float f1981e;
    private boolean f1982f;

    class C09541 implements C0953s {
        final /* synthetic */ TileOverlayOptions f1975a;
        private final C0979i f1976c = this.f1975a.f1978b;

        C09541(TileOverlayOptions tileOverlayOptions) {
            this.f1975a = tileOverlayOptions;
        }
    }

    public TileOverlayOptions() {
        this.f1980d = true;
        this.f1982f = true;
        this.f1977a = 1;
    }

    TileOverlayOptions(int i, IBinder iBinder, boolean z, float f, boolean z2) {
        this.f1980d = true;
        this.f1982f = true;
        this.f1977a = i;
        this.f1978b = C0981a.m3593a(iBinder);
        this.f1979c = this.f1978b == null ? null : new C09541(this);
        this.f1980d = z;
        this.f1981e = f;
        this.f1982f = z2;
    }

    int m3327a() {
        return this.f1977a;
    }

    IBinder m3328b() {
        return this.f1978b.asBinder();
    }

    public float m3329c() {
        return this.f1981e;
    }

    public boolean m3330d() {
        return this.f1980d;
    }

    public int describeContents() {
        return 0;
    }

    public boolean m3331e() {
        return this.f1982f;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (af.m2895a()) {
            ad.m3598a(this, parcel, i);
        } else {
            C0999r.m3640a(this, parcel, i);
        }
    }
}
