package com.google.android.gms.internal;

import android.content.Context;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.C0658a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import twitter4j.HttpResponseCode;

public final class al implements SafeParcelable {
    public static final C0826k CREATOR = new C0826k();
    public final int f920a;
    public final String f921b;
    public final int f922c;
    public final int f923d;
    public final boolean f924e;
    public final int f925f;
    public final int f926g;
    public final al[] f927h;

    public al() {
        this(2, "interstitial_mb", 0, 0, true, 0, 0, null);
    }

    al(int i, String str, int i2, int i3, boolean z, int i4, int i5, al[] alVarArr) {
        this.f920a = i;
        this.f921b = str;
        this.f922c = i2;
        this.f923d = i3;
        this.f924e = z;
        this.f925f = i4;
        this.f926g = i5;
        this.f927h = alVarArr;
    }

    public al(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    public al(Context context, AdSize[] adSizeArr) {
        int i;
        int i2;
        int i3 = 0;
        AdSize adSize = adSizeArr[0];
        this.f920a = 2;
        this.f924e = false;
        this.f925f = adSize.m1399b();
        this.f922c = adSize.m1397a();
        int i4 = this.f925f == -1 ? 1 : 0;
        int i5 = this.f922c == -2 ? 1 : 0;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (i4 != 0) {
            this.f926g = m1548a(displayMetrics);
            i = (int) (((float) this.f926g) / displayMetrics.density);
        } else {
            i2 = this.f925f;
            this.f926g = dp.m2104a(displayMetrics, this.f925f);
            i = i2;
        }
        i2 = i5 != 0 ? m1550c(displayMetrics) : this.f922c;
        this.f923d = dp.m2104a(displayMetrics, i2);
        if (i4 == 0 && i5 == 0) {
            this.f921b = adSize.toString();
        } else {
            this.f921b = i + "x" + i2 + "_as";
        }
        if (adSizeArr.length > 1) {
            this.f927h = new al[adSizeArr.length];
            while (i3 < adSizeArr.length) {
                this.f927h[i3] = new al(context, adSizeArr[i3]);
                i3++;
            }
            return;
        }
        this.f927h = null;
    }

    public al(al alVar, al[] alVarArr) {
        this(2, alVar.f921b, alVar.f922c, alVar.f923d, alVar.f924e, alVar.f925f, alVar.f926g, alVarArr);
    }

    public static int m1548a(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int m1549b(DisplayMetrics displayMetrics) {
        return (int) (((float) m1550c(displayMetrics)) * displayMetrics.density);
    }

    private static int m1550c(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        return i <= HttpResponseCode.BAD_REQUEST ? 32 : i <= 720 ? 50 : 90;
    }

    public AdSize m1551a() {
        return C0658a.m1409a(this.f925f, this.f922c, this.f921b);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0826k.m2707a(this, parcel, i);
    }
}
