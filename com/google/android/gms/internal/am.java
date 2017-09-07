package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class am {
    public final List<ak> f928a;
    public final long f929b;
    public final List<String> f930c;
    public final List<String> f931d;
    public final List<String> f932e;
    public final String f933f;
    public final long f934g;
    public int f935h;
    public int f936i;

    public am(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (dq.m2114a(2)) {
            dq.m2119d("Mediation Response JSON: " + jSONObject.toString(2));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        List arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            ak akVar = new ak(jSONArray.getJSONObject(i2));
            arrayList.add(akVar);
            if (i < 0 && m1552a(akVar)) {
                i = i2;
            }
        }
        this.f935h = i;
        this.f936i = jSONArray.length();
        this.f928a = Collections.unmodifiableList(arrayList);
        this.f933f = jSONObject.getString("qdata");
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            this.f929b = optJSONObject.optLong("ad_network_timeout_millis", -1);
            this.f930c = ar.m1588a(optJSONObject, "click_urls");
            this.f931d = ar.m1588a(optJSONObject, "imp_urls");
            this.f932e = ar.m1588a(optJSONObject, "nofill_urls");
            long optLong = optJSONObject.optLong("refresh", -1);
            this.f934g = optLong > 0 ? optLong * 1000 : -1;
            return;
        }
        this.f929b = -1;
        this.f930c = null;
        this.f931d = null;
        this.f932e = null;
        this.f934g = -1;
    }

    private boolean m1552a(ak akVar) {
        for (String equals : akVar.f915c) {
            if (equals.equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                return true;
            }
        }
        return false;
    }
}
