package com.google.android.gms.internal;

import android.content.Context;
import com.facebook.AppEventsConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ar {
    public static List<String> m1588a(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        List arrayList = new ArrayList(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.getString(i));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static void m1589a(Context context, String str, db dbVar, String str2, boolean z, List<String> list) {
        String str3 = z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        for (String replaceAll : list) {
            String replaceAll2 = replaceAll2.replaceAll("@gw_adlocid@", str2).replaceAll("@gw_adnetrefresh@", str3).replaceAll("@gw_qdata@", dbVar.f1276o.f933f).replaceAll("@gw_sdkver@", str).replaceAll("@gw_sessid@", dd.f1298a).replaceAll("@gw_seqnum@", dbVar.f1270i);
            if (dbVar.f1273l != null) {
                replaceAll2 = replaceAll2.replaceAll("@gw_adnetid@", dbVar.f1273l.f914b).replaceAll("@gw_allocid@", dbVar.f1273l.f916d);
            }
            new C0750do(context, str, replaceAll2).m1741e();
        }
    }
}
