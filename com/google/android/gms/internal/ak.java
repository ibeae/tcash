package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ak {
    public final String f913a;
    public final String f914b;
    public final List<String> f915c;
    public final String f916d;
    public final String f917e;
    public final List<String> f918f;
    public final String f919g;

    public ak(JSONObject jSONObject) {
        String str = null;
        this.f914b = jSONObject.getString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        List arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.f915c = Collections.unmodifiableList(arrayList);
        this.f916d = jSONObject.optString("allocation_id", null);
        this.f918f = ar.m1588a(jSONObject, "imp_urls");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        this.f913a = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        this.f919g = optJSONObject2 != null ? optJSONObject2.toString() : null;
        if (optJSONObject2 != null) {
            str = optJSONObject2.optString("class_name");
        }
        this.f917e = str;
    }
}
