package com.google.android.gms.internal;

import com.facebook.AppEventsConstants;
import java.util.HashMap;
import java.util.Map;

class fv implements fx {
    private dt f1631a;

    public fv(dt dtVar) {
        this.f1631a = dtVar;
    }

    public void mo1101a(C0721c c0721c, boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("isVisible", z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.f1631a.m2134a("onAdVisibilityChanged", hashMap);
    }
}
