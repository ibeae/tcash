package com.google.android.gms.internal;

import android.content.Context;
import com.facebook.widget.PlacePickerFragment;
import java.util.regex.Pattern;

public final class em {
    private static Pattern f1545a = null;

    public static int m2354a(int i) {
        return i / PlacePickerFragment.DEFAULT_RADIUS_IN_METERS;
    }

    public static boolean m2355a(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    public static int m2356b(int i) {
        return (i % PlacePickerFragment.DEFAULT_RADIUS_IN_METERS) / 100;
    }

    public static boolean m2357c(int i) {
        return m2356b(i) == 3;
    }
}
