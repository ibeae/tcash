package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class cw {
    private String f1217a;
    private String f1218b;
    private String f1219c;
    private List<String> f1220d;
    private String f1221e;
    private String f1222f;
    private List<String> f1223g;
    private long f1224h = -1;
    private boolean f1225i = false;
    private final long f1226j = -1;
    private List<String> f1227k;
    private long f1228l = -1;
    private int f1229m = -1;

    private static String m1990a(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        return (list == null || list.isEmpty()) ? null : (String) list.get(0);
    }

    private static long m1991b(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            try {
                return (long) (Float.parseFloat(str2) * 1000.0f);
            } catch (NumberFormatException e) {
                dq.m2120e("Could not parse float from " + str + " header: " + str2);
            }
        }
        return -1;
    }

    private void m1992b(Map<String, List<String>> map) {
        this.f1217a = m1990a(map, "X-Afma-Ad-Size");
    }

    private static List<String> m1993c(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            if (str2 != null) {
                return Arrays.asList(str2.trim().split("\\s+"));
            }
        }
        return null;
    }

    private void m1994c(Map<String, List<String>> map) {
        List c = m1993c(map, "X-Afma-Click-Tracking-Urls");
        if (c != null) {
            this.f1220d = c;
        }
    }

    private void m1995d(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Debug-Dialog");
        if (list != null && !list.isEmpty()) {
            this.f1221e = (String) list.get(0);
        }
    }

    private void m1996e(Map<String, List<String>> map) {
        List c = m1993c(map, "X-Afma-Tracking-Urls");
        if (c != null) {
            this.f1223g = c;
        }
    }

    private void m1997f(Map<String, List<String>> map) {
        long b = m1991b(map, "X-Afma-Interstitial-Timeout");
        if (b != -1) {
            this.f1224h = b;
        }
    }

    private void m1998g(Map<String, List<String>> map) {
        this.f1222f = m1990a(map, "X-Afma-ActiveView");
    }

    private void m1999h(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Mediation");
        if (list != null && !list.isEmpty()) {
            this.f1225i = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    private void m2000i(Map<String, List<String>> map) {
        List c = m1993c(map, "X-Afma-Manual-Tracking-Urls");
        if (c != null) {
            this.f1227k = c;
        }
    }

    private void m2001j(Map<String, List<String>> map) {
        long b = m1991b(map, "X-Afma-Refresh-Rate");
        if (b != -1) {
            this.f1228l = b;
        }
    }

    private void m2002k(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Orientation");
        if (list != null && !list.isEmpty()) {
            String str = (String) list.get(0);
            if ("portrait".equalsIgnoreCase(str)) {
                this.f1229m = dk.m2082c();
            } else if ("landscape".equalsIgnoreCase(str)) {
                this.f1229m = dk.m2078b();
            }
        }
    }

    public du m2003a(long j) {
        return new du(this.f1218b, this.f1219c, this.f1220d, this.f1223g, this.f1224h, this.f1225i, -1, this.f1227k, this.f1228l, this.f1229m, this.f1217a, j, this.f1221e, this.f1222f);
    }

    public void m2004a(String str, Map<String, List<String>> map, String str2) {
        this.f1218b = str;
        this.f1219c = str2;
        m2005a((Map) map);
    }

    public void m2005a(Map<String, List<String>> map) {
        m1992b(map);
        m1994c(map);
        m1995d(map);
        m1996e(map);
        m1997f(map);
        m1999h(map);
        m2000i(map);
        m2001j(map);
        m2002k(map);
        m1998g(map);
    }
}
