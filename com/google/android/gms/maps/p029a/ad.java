package com.google.android.gms.maps.p029a;

import android.os.Bundle;
import android.os.Parcelable;

public final class ad {
    private ad() {
    }

    public static void m2886a(Bundle bundle, String str, Parcelable parcelable) {
        bundle.setClassLoader(ad.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle("map_state");
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        bundle2.setClassLoader(ad.class.getClassLoader());
        bundle2.putParcelable(str, parcelable);
        bundle.putBundle("map_state", bundle2);
    }
}
