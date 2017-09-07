package com.google.android.gms.internal;

import com.facebook.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class cx {
    private final List<String> f1230a;
    private final List<String> f1231b;
    private final String f1232c;
    private final String f1233d;
    private final String f1234e;
    private final String f1235f;
    private final String f1236g;
    private final boolean f1237h;
    private final int f1238i;

    public cx(Map<String, String> map) {
        this.f1236g = (String) map.get(NativeProtocol.IMAGE_URL_KEY);
        this.f1233d = (String) map.get("base_uri");
        this.f1234e = (String) map.get("post_parameters");
        this.f1237h = m2006a((String) map.get("drt_include"));
        this.f1232c = (String) map.get("activation_overlay_url");
        this.f1231b = m2007b((String) map.get("check_packages"));
        this.f1238i = m2008c((String) map.get("request_id"));
        this.f1235f = (String) map.get("type");
        this.f1230a = m2007b((String) map.get("errors"));
    }

    private static boolean m2006a(String str) {
        return str != null && (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES) || str.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
    }

    private List<String> m2007b(String str) {
        return str == null ? null : Arrays.asList(str.split(","));
    }

    private int m2008c(String str) {
        return str == null ? 0 : Integer.parseInt(str);
    }

    public List<String> m2009a() {
        return this.f1230a;
    }

    public String m2010b() {
        return this.f1234e;
    }

    public String m2011c() {
        return this.f1236g;
    }

    public String m2012d() {
        return this.f1235f;
    }

    public boolean m2013e() {
        return this.f1237h;
    }
}
