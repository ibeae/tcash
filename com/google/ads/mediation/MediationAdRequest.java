package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.C0631a.C0630b;
import java.util.Date;
import java.util.Set;

@Deprecated
public final class MediationAdRequest {
    private final Date f759d;
    private final C0630b f760e;
    private final Set<String> f761f;
    private final boolean f762g;
    private final Location f763h;

    public MediationAdRequest(Date date, C0630b c0630b, Set<String> set, boolean z, Location location) {
        this.f759d = date;
        this.f760e = c0630b;
        this.f761f = set;
        this.f762g = z;
        this.f763h = location;
    }

    public Integer getAgeInYears() {
        return null;
    }

    public Date getBirthday() {
        return this.f759d;
    }

    public C0630b getGender() {
        return this.f760e;
    }

    public Set<String> getKeywords() {
        return this.f761f;
    }

    public Location getLocation() {
        return this.f763h;
    }

    public boolean isTesting() {
        return this.f762g;
    }
}
