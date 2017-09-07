package com.google.android.gms.internal;

import android.content.Intent;
import android.net.Uri;

public class eg {
    private static final Uri f1527a = Uri.parse("http://plus.google.com/");
    private static final Uri f1528b = f1527a.buildUpon().appendPath("circles").appendPath("find").build();

    public static Intent m2252a() {
        return new Intent("android.settings.DATE_SETTINGS");
    }

    public static Intent m2253a(String str) {
        Uri fromParts = Uri.fromParts("package", str, null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(fromParts);
        return intent;
    }

    public static Intent m2254b(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(m2255c(str));
        intent.setPackage("com.android.vending");
        intent.addFlags(524288);
        return intent;
    }

    private static Uri m2255c(String str) {
        return Uri.parse("market://details").buildUpon().appendQueryParameter("id", str).build();
    }
}
