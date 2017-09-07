package com.telkom.mwallet.tcash.tap.p071a;

import android.text.TextUtils;
import android.util.Log;
import com.appsflyer.ServerParameters;
import com.telkom.mwallet.tcash.tap.p071a.C1975a.C1974a;
import org.json.JSONException;
import org.json.JSONObject;

public class C1977c {
    static final String f5763a = C1977c.class.getSimpleName();
    private JSONObject f5764b;

    public C1977c(String str) {
        try {
            this.f5764b = new JSONObject(str);
        } catch (JSONException e) {
            Log.e(f5763a, e.getMessage());
        }
    }

    private JSONObject m7897d() {
        if (this.f5764b == null) {
            this.f5764b = new JSONObject();
        }
        return this.f5764b;
    }

    public C1974a m7898a() {
        try {
            return C1974a.valueOf(m7897d().getString("status"));
        } catch (JSONException e) {
            Log.e(f5763a, e.getMessage());
            return C1974a.NONE;
        }
    }

    public void m7899a(C1974a c1974a) {
        try {
            m7897d().put("status", c1974a.name());
        } catch (JSONException e) {
            Log.e(f5763a, e.getMessage());
        }
    }

    public void m7900a(String str) {
        if (TextUtils.isEmpty(str)) {
            m7899a(C1974a.NONE);
        } else {
            m7899a((str.length() > 8 ? 1 : null) != null ? C1974a.NFC : C1974a.STICKER);
        }
    }

    public String m7901b() {
        try {
            return m7897d().getString("serialNumber");
        } catch (JSONException e) {
            Log.e(f5763a, e.getMessage());
            return null;
        }
    }

    public void m7902b(String str) {
        try {
            m7897d().put("serialNumber", str);
        } catch (JSONException e) {
            Log.e(f5763a, e.getMessage());
        }
    }

    public String m7903c() {
        try {
            return m7897d().getString(ServerParameters.AF_USER_ID);
        } catch (JSONException e) {
            Log.e(f5763a, e.getMessage());
            return null;
        }
    }

    public void m7904c(String str) {
        try {
            m7897d().put(ServerParameters.AF_USER_ID, str);
        } catch (JSONException e) {
            Log.e(f5763a, e.getMessage());
        }
    }

    public String toString() {
        return m7897d().toString();
    }
}
