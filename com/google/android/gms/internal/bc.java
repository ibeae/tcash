package com.google.android.gms.internal;

import com.google.ads.C0631a.C0629a;
import com.google.ads.C0631a.C0630b;
import com.google.ads.C0632b;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.C0658a;
import java.util.Date;
import java.util.HashSet;

public final class bc {

    static /* synthetic */ class C06981 {
        static final /* synthetic */ int[] f1003a = new int[C0630b.values().length];

        static {
            f1004b = new int[C0629a.values().length];
            try {
                f1004b[C0629a.INTERNAL_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1004b[C0629a.INVALID_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1004b[C0629a.NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1004b[C0629a.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f1003a[C0630b.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f1003a[C0630b.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f1003a[C0630b.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static int m1665a(C0629a c0629a) {
        switch (c0629a) {
            case INVALID_REQUEST:
                return 1;
            case NETWORK_ERROR:
                return 2;
            case NO_FILL:
                return 3;
            default:
                return 0;
        }
    }

    public static C0630b m1666a(int i) {
        switch (i) {
            case 1:
                return C0630b.MALE;
            case 2:
                return C0630b.FEMALE;
            default:
                return C0630b.UNKNOWN;
        }
    }

    public static C0632b m1667a(al alVar) {
        int i = 0;
        C0632b[] c0632bArr = new C0632b[]{C0632b.f752a, C0632b.f753b, C0632b.f754c, C0632b.f755d, C0632b.f756e, C0632b.f757f};
        while (i < c0632bArr.length) {
            if (c0632bArr[i].m1302a() == alVar.f925f && c0632bArr[i].m1304b() == alVar.f922c) {
                return c0632bArr[i];
            }
            i++;
        }
        return new C0632b(C0658a.m1409a(alVar.f925f, alVar.f922c, alVar.f921b));
    }

    public static MediationAdRequest m1668a(ai aiVar) {
        return new MediationAdRequest(new Date(aiVar.f892b), m1666a(aiVar.f894d), aiVar.f895e != null ? new HashSet(aiVar.f895e) : null, aiVar.f896f, aiVar.f901k);
    }
}
