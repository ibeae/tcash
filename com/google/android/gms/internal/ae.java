package com.google.android.gms.internal;

import com.facebook.AppEventsConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public final class ae implements aa {
    private final ab f890a;

    public ae(ab abVar) {
        this.f890a = abVar;
    }

    private static boolean m1537a(Map<String, String> map) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("custom_close"));
    }

    private static int m1538b(Map<String, String> map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return dk.m2082c();
            }
            if ("l".equalsIgnoreCase(str)) {
                return dk.m2078b();
            }
        }
        return -1;
    }

    public void mo874a(dt dtVar, Map<String, String> map) {
        String str = (String) map.get("a");
        if (str == null) {
            dq.m2120e("Action missing from an open GMSG.");
            return;
        }
        dv f = dtVar.m2142f();
        if ("expand".equalsIgnoreCase(str)) {
            if (dtVar.m2145i()) {
                dq.m2120e("Cannot expand WebView that is already expanded.");
            } else {
                f.m2157a(m1537a(map), m1538b(map));
            }
        } else if ("webapp".equalsIgnoreCase(str)) {
            str = (String) map.get("u");
            if (str != null) {
                f.m2158a(m1537a(map), m1538b(map), str);
            } else {
                f.m2159a(m1537a(map), m1538b(map), (String) map.get("html"), (String) map.get("baseurl"));
            }
        } else if ("in_app_purchase".equalsIgnoreCase(str)) {
            str = (String) map.get("product_id");
            String str2 = (String) map.get("report_urls");
            if (this.f890a == null) {
                return;
            }
            if (str2 == null || str2.isEmpty()) {
                this.f890a.mo1080a(str, new ArrayList());
                return;
            }
            this.f890a.mo1080a(str, new ArrayList(Arrays.asList(str2.split(" "))));
        } else {
            f.m2150a(new ce((String) map.get("i"), (String) map.get("u"), (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
        }
    }
}
