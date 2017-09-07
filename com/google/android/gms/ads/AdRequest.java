package com.google.android.gms.ads;

import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.internal.C0838r;
import com.google.android.gms.internal.C0838r.C0837a;
import java.util.Date;

public final class AdRequest {
    public static final String f813a = C0838r.f1763a;
    private final C0838r f814b;

    public static final class Builder {
        private final C0837a f812a = new C0837a();

        public Builder m1389a(int i) {
            this.f812a.m2751a(i);
            return this;
        }

        public Builder m1390a(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.f812a.m2752a(cls, bundle);
            return this;
        }

        public Builder m1391a(String str) {
            this.f812a.m2753a(str);
            return this;
        }

        public Builder m1392a(Date date) {
            this.f812a.m2754a(date);
            return this;
        }

        public Builder m1393a(boolean z) {
            this.f812a.m2755a(z);
            return this;
        }

        public AdRequest m1394a() {
            return new AdRequest();
        }

        public Builder m1395b(String str) {
            this.f812a.m2756b(str);
            return this;
        }
    }

    private AdRequest(Builder builder) {
        this.f814b = new C0838r(builder.f812a);
    }

    C0838r m1396a() {
        return this.f814b;
    }
}
