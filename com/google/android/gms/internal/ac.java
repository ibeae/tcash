package com.google.android.gms.internal;

import com.facebook.AppEventsConstants;
import java.util.Map;

public class ac implements aa {
    private final ad f889a;

    public ac(ad adVar) {
        this.f889a = adVar;
    }

    public void mo874a(dt dtVar, Map<String, String> map) {
        this.f889a.mo1082a(AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("transparentBackground")));
    }
}
