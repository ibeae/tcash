package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ct {
    private static final SimpleDateFormat f1207a = new SimpleDateFormat("yyyyMMdd");

    public static du m1969a(Context context, ds dsVar, String str) {
        try {
            du duVar;
            int i;
            List list;
            List list2;
            List list3;
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("ad_base_url", null);
            String optString2 = jSONObject.optString("ad_url", null);
            String optString3 = jSONObject.optString("ad_size", null);
            String optString4 = jSONObject.optString("ad_html", null);
            long j = -1;
            String optString5 = jSONObject.optString("debug_dialog", null);
            long j2 = jSONObject.has("interstitial_timeout") ? (long) (jSONObject.getDouble("interstitial_timeout") * 1000.0d) : -1;
            String optString6 = jSONObject.optString("orientation", null);
            int i2 = -1;
            if ("portrait".equals(optString6)) {
                i2 = dk.m2082c();
            } else if ("landscape".equals(optString6)) {
                i2 = dk.m2078b();
            }
            if (TextUtils.isEmpty(optString4)) {
                if (TextUtils.isEmpty(optString2)) {
                    dq.m2120e("Could not parse the mediation config: Missing required ad_html or ad_url field.");
                    return new du(0);
                }
                du a = cs.m1965a(context, dsVar.f1365k.f1564b, optString2, null, null);
                optString = a.f1382b;
                optString4 = a.f1383c;
                j = a.f1394n;
                duVar = a;
            } else if (TextUtils.isEmpty(optString)) {
                dq.m2120e("Could not parse the mediation config: Missing required ad_base_url field");
                return new du(0);
            } else {
                duVar = null;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("click_urls");
            List list4 = duVar == null ? null : duVar.f1384d;
            if (optJSONArray != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (i = 0; i < optJSONArray.length(); i++) {
                    list4.add(optJSONArray.getString(i));
                }
                list = list4;
            } else {
                list = list4;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("impression_urls");
            list4 = duVar == null ? null : duVar.f1386f;
            if (optJSONArray2 != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (i = 0; i < optJSONArray2.length(); i++) {
                    list4.add(optJSONArray2.getString(i));
                }
                list2 = list4;
            } else {
                list2 = list4;
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("manual_impression_urls");
            list4 = duVar == null ? null : duVar.f1390j;
            if (optJSONArray3 != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (i = 0; i < optJSONArray3.length(); i++) {
                    list4.add(optJSONArray3.getString(i));
                }
                list3 = list4;
            } else {
                list3 = list4;
            }
            if (duVar != null) {
                if (duVar.f1392l != -1) {
                    i2 = duVar.f1392l;
                }
                if (duVar.f1387g > 0) {
                    j2 = duVar.f1387g;
                }
            }
            String optString7 = jSONObject.optString("active_view");
            String str2 = null;
            boolean optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
            if (optBoolean) {
                str2 = jSONObject.optString("ad_passback_url", null);
            }
            return new du(optString, optString4, list, list2, j2, false, -1, list3, -1, i2, optString3, j, optString5, optBoolean, str2, optString7);
        } catch (JSONException e) {
            dq.m2120e("Could not parse the mediation config: " + e.getMessage());
            return new du(0);
        }
    }

    private static Integer m1970a(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }

    private static String m1971a(int i) {
        return String.format(Locale.US, "#%06x", new Object[]{Integer.valueOf(16777215 & i)});
    }

    public static String m1972a(ds dsVar, cy cyVar, Location location, String str) {
        try {
            Map hashMap = new HashMap();
            if (!(str == null || str.trim() == "")) {
                hashMap.put("eid", str);
            }
            if (dsVar.f1356b != null) {
                hashMap.put("ad_pos", dsVar.f1356b);
            }
            m1974a((HashMap) hashMap, dsVar.f1357c);
            hashMap.put("format", dsVar.f1358d.f921b);
            if (dsVar.f1358d.f925f == -1) {
                hashMap.put("smart_w", "full");
            }
            if (dsVar.f1358d.f922c == -2) {
                hashMap.put("smart_h", "auto");
            }
            if (dsVar.f1358d.f927h != null) {
                StringBuilder stringBuilder = new StringBuilder();
                for (al alVar : dsVar.f1358d.f927h) {
                    if (stringBuilder.length() != 0) {
                        stringBuilder.append("|");
                    }
                    stringBuilder.append(alVar.f925f == -1 ? (int) (((float) alVar.f926g) / cyVar.f1255q) : alVar.f925f);
                    stringBuilder.append("x");
                    stringBuilder.append(alVar.f922c == -2 ? (int) (((float) alVar.f923d) / cyVar.f1255q) : alVar.f922c);
                }
                hashMap.put("sz", stringBuilder);
            }
            hashMap.put("slotname", dsVar.f1359e);
            hashMap.put("pn", dsVar.f1360f.packageName);
            if (dsVar.f1361g != null) {
                hashMap.put("vc", Integer.valueOf(dsVar.f1361g.versionCode));
            }
            hashMap.put("ms", dsVar.f1362h);
            hashMap.put("ms2", dsVar.f1367m);
            hashMap.put("seq_num", dsVar.f1363i);
            hashMap.put("session_id", dsVar.f1364j);
            hashMap.put("js", dsVar.f1365k.f1564b);
            m1976a((HashMap) hashMap, cyVar);
            if (dsVar.f1357c.f891a >= 2 && dsVar.f1357c.f901k != null) {
                m1973a((HashMap) hashMap, dsVar.f1357c.f901k);
            }
            if (dsVar.f1355a >= 2) {
                hashMap.put("quality_signals", dsVar.f1366l);
            }
            if (dq.m2114a(2)) {
                dq.m2119d("Ad Request JSON: " + dk.m2066a(hashMap).toString(2));
            }
            return dk.m2066a(hashMap).toString();
        } catch (JSONException e) {
            dq.m2120e("Problem serializing ad request to JSON: " + e.getMessage());
            return null;
        }
    }

    private static void m1973a(HashMap<String, Object> hashMap, Location location) {
        HashMap hashMap2 = new HashMap();
        Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long valueOf2 = Long.valueOf(location.getTime() * 1000);
        Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        hashMap2.put("radius", valueOf);
        hashMap2.put("lat", valueOf3);
        hashMap2.put("long", valueOf4);
        hashMap2.put("time", valueOf2);
        hashMap.put("uule", hashMap2);
    }

    private static void m1974a(HashMap<String, Object> hashMap, ai aiVar) {
        String a = dh.m2054a();
        if (a != null) {
            hashMap.put("abf", a);
        }
        if (aiVar.f892b != -1) {
            hashMap.put("cust_age", f1207a.format(new Date(aiVar.f892b)));
        }
        if (aiVar.f893c != null) {
            hashMap.put("extras", aiVar.f893c);
        }
        if (aiVar.f894d != -1) {
            hashMap.put("cust_gender", Integer.valueOf(aiVar.f894d));
        }
        if (aiVar.f895e != null) {
            hashMap.put("kw", aiVar.f895e);
        }
        if (aiVar.f897g != -1) {
            hashMap.put("tag_for_child_directed_treatment", Integer.valueOf(aiVar.f897g));
        }
        if (aiVar.f896f) {
            hashMap.put("adtest", "on");
        }
        if (aiVar.f891a >= 2) {
            if (aiVar.f898h) {
                hashMap.put("d_imp_hdr", Integer.valueOf(1));
            }
            if (!TextUtils.isEmpty(aiVar.f899i)) {
                hashMap.put("ppid", aiVar.f899i);
            }
            if (aiVar.f900j != null) {
                m1975a((HashMap) hashMap, aiVar.f900j);
            }
        }
        if (aiVar.f891a >= 3 && aiVar.f902l != null) {
            hashMap.put(NativeProtocol.IMAGE_URL_KEY, aiVar.f902l);
        }
    }

    private static void m1975a(HashMap<String, Object> hashMap, aw awVar) {
        Object obj;
        Object obj2 = null;
        if (Color.alpha(awVar.f963b) != 0) {
            hashMap.put("acolor", m1971a(awVar.f963b));
        }
        if (Color.alpha(awVar.f964c) != 0) {
            hashMap.put("bgcolor", m1971a(awVar.f964c));
        }
        if (!(Color.alpha(awVar.f965d) == 0 || Color.alpha(awVar.f966e) == 0)) {
            hashMap.put("gradientto", m1971a(awVar.f965d));
            hashMap.put("gradientfrom", m1971a(awVar.f966e));
        }
        if (Color.alpha(awVar.f967f) != 0) {
            hashMap.put("bcolor", m1971a(awVar.f967f));
        }
        hashMap.put("bthick", Integer.toString(awVar.f968g));
        switch (awVar.f969h) {
            case 0:
                obj = "none";
                break;
            case 1:
                obj = "dashed";
                break;
            case 2:
                obj = "dotted";
                break;
            case 3:
                obj = "solid";
                break;
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            hashMap.put("btype", obj);
        }
        switch (awVar.f970i) {
            case 0:
                obj2 = "light";
                break;
            case 1:
                obj2 = "medium";
                break;
            case 2:
                obj2 = "dark";
                break;
        }
        if (obj2 != null) {
            hashMap.put("callbuttoncolor", obj2);
        }
        if (awVar.f971j != null) {
            hashMap.put("channel", awVar.f971j);
        }
        if (Color.alpha(awVar.f972k) != 0) {
            hashMap.put("dcolor", m1971a(awVar.f972k));
        }
        if (awVar.f973l != null) {
            hashMap.put("font", awVar.f973l);
        }
        if (Color.alpha(awVar.f974m) != 0) {
            hashMap.put("hcolor", m1971a(awVar.f974m));
        }
        hashMap.put("headersize", Integer.toString(awVar.f975n));
        if (awVar.f976o != null) {
            hashMap.put("q", awVar.f976o);
        }
    }

    private static void m1976a(HashMap<String, Object> hashMap, cy cyVar) {
        hashMap.put("am", Integer.valueOf(cyVar.f1239a));
        hashMap.put("cog", m1970a(cyVar.f1240b));
        hashMap.put("coh", m1970a(cyVar.f1241c));
        if (!TextUtils.isEmpty(cyVar.f1242d)) {
            hashMap.put("carrier", cyVar.f1242d);
        }
        hashMap.put("gl", cyVar.f1243e);
        if (cyVar.f1244f) {
            hashMap.put("simulator", Integer.valueOf(1));
        }
        hashMap.put("ma", m1970a(cyVar.f1245g));
        hashMap.put("sp", m1970a(cyVar.f1246h));
        hashMap.put("hl", cyVar.f1247i);
        if (!TextUtils.isEmpty(cyVar.f1248j)) {
            hashMap.put("mv", cyVar.f1248j);
        }
        hashMap.put("muv", Integer.valueOf(cyVar.f1249k));
        if (cyVar.f1250l != -2) {
            hashMap.put("cnt", Integer.valueOf(cyVar.f1250l));
        }
        hashMap.put("gnt", Integer.valueOf(cyVar.f1251m));
        hashMap.put("pt", Integer.valueOf(cyVar.f1252n));
        hashMap.put("rm", Integer.valueOf(cyVar.f1253o));
        hashMap.put("riv", Integer.valueOf(cyVar.f1254p));
        hashMap.put("u_sd", Float.valueOf(cyVar.f1255q));
        hashMap.put("sh", Integer.valueOf(cyVar.f1257s));
        hashMap.put("sw", Integer.valueOf(cyVar.f1256r));
        Bundle bundle = new Bundle();
        bundle.putInt("active_network_state", cyVar.f1261w);
        bundle.putBoolean("active_network_metered", cyVar.f1260v);
        hashMap.put("connectivity", bundle);
        bundle = new Bundle();
        bundle.putBoolean("is_charging", cyVar.f1259u);
        bundle.putDouble("battery_level", cyVar.f1258t);
        hashMap.put("battery", bundle);
    }
}
