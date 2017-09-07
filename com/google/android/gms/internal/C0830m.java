package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.C0640R;
import com.google.android.gms.ads.AdSize;

public final class C0830m {
    private final AdSize[] f1746a;
    private final String f1747b;

    public C0830m(Context context, AttributeSet attributeSet) {
        int i = 1;
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C0640R.styleable.AdsAttrs);
        String string = obtainAttributes.getString(0);
        String string2 = obtainAttributes.getString(1);
        int i2 = !TextUtils.isEmpty(string) ? 1 : 0;
        if (TextUtils.isEmpty(string2)) {
            i = 0;
        }
        if (i2 != 0 && r1 == 0) {
            this.f1746a = C0830m.m2713a(string);
        } else if (i2 == 0 && r1 != 0) {
            this.f1746a = C0830m.m2713a(string2);
        } else if (i2 == 0 || r1 == 0) {
            throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
        } else {
            throw new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
        }
        this.f1747b = obtainAttributes.getString(2);
        if (TextUtils.isEmpty(this.f1747b)) {
            throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
        }
    }

    private static AdSize[] m2713a(String str) {
        String[] split = str.split("\\s*,\\s*");
        AdSize[] adSizeArr = new AdSize[split.length];
        for (int i = 0; i < split.length; i++) {
            String trim = split[i].trim();
            if (trim.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$")) {
                String[] split2 = trim.split("[xX]");
                split2[0] = split2[0].trim();
                split2[1] = split2[1].trim();
                try {
                    adSizeArr[i] = new AdSize("FULL_WIDTH".equals(split2[0]) ? -1 : Integer.parseInt(split2[0]), "AUTO_HEIGHT".equals(split2[1]) ? -2 : Integer.parseInt(split2[1]));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": " + trim);
                }
            } else if ("BANNER".equals(trim)) {
                adSizeArr[i] = AdSize.f815a;
            } else if ("LARGE_BANNER".equals(trim)) {
                adSizeArr[i] = AdSize.f817c;
            } else if ("FULL_BANNER".equals(trim)) {
                adSizeArr[i] = AdSize.f816b;
            } else if ("LEADERBOARD".equals(trim)) {
                adSizeArr[i] = AdSize.f818d;
            } else if ("MEDIUM_RECTANGLE".equals(trim)) {
                adSizeArr[i] = AdSize.f819e;
            } else if ("SMART_BANNER".equals(trim)) {
                adSizeArr[i] = AdSize.f821g;
            } else if ("WIDE_SKYSCRAPER".equals(trim)) {
                adSizeArr[i] = AdSize.f820f;
            } else {
                throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": " + trim);
            }
        }
        if (adSizeArr.length != 0) {
            return adSizeArr;
        }
        throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": " + str);
    }

    public String m2714a() {
        return this.f1747b;
    }

    public AdSize[] m2715a(boolean z) {
        if (z || this.f1746a.length == 1) {
            return this.f1746a;
        }
        throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
    }
}
