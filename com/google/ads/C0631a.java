package com.google.ads;

import com.google.android.gms.ads.AdRequest;

@Deprecated
public final class C0631a {
    public static final String f751a = AdRequest.f813a;

    public enum C0629a {
        INVALID_REQUEST("Invalid Ad request."),
        NO_FILL("Ad request successful, but no ad returned due to lack of ad inventory."),
        NETWORK_ERROR("A network error occurred."),
        INTERNAL_ERROR("There was an internal error.");
        
        private final String f746e;

        private C0629a(String str) {
            this.f746e = str;
        }

        public String toString() {
            return this.f746e;
        }
    }

    public enum C0630b {
        UNKNOWN,
        MALE,
        FEMALE
    }

    private C0631a() {
    }
}
