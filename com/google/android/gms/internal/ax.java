package com.google.android.gms.internal;

import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

public final class ax implements MediationAdRequest {
    private final Date f977a;
    private final int f978b;
    private final Set<String> f979c;
    private final boolean f980d;
    private final int f981e;

    public ax(Date date, int i, Set<String> set, boolean z, int i2) {
        this.f977a = date;
        this.f978b = i;
        this.f979c = set;
        this.f980d = z;
        this.f981e = i2;
    }

    public Date mo894a() {
        return this.f977a;
    }

    public int mo895b() {
        return this.f978b;
    }

    public Set<String> mo896c() {
        return this.f979c;
    }

    public boolean mo897d() {
        return this.f980d;
    }
}
