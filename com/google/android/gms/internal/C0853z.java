package com.google.android.gms.internal;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.AppEventsConstants;
import java.util.HashMap;
import java.util.Map;

public final class C0853z {
    public static final aa f1803a = new C08451();
    public static final aa f1804b = new C08462();
    public static final aa f1805c = new C08473();
    public static final aa f1806d = new C08484();
    public static final aa f1807e = new C08495();
    public static final aa f1808f = new C08506();
    public static final aa f1809g = new C08517();
    public static final aa f1810h = new C08528();
    public static final aa f1811i = new af();

    static class C08451 implements aa {
        C08451() {
        }

        public void mo874a(dt dtVar, Map<String, String> map) {
        }
    }

    static class C08462 implements aa {
        C08462() {
        }

        public void mo874a(dt dtVar, Map<String, String> map) {
            String str = (String) map.get("urls");
            if (TextUtils.isEmpty(str)) {
                dq.m2120e("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            Map hashMap = new HashMap();
            PackageManager packageManager = dtVar.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) != null));
            }
            dtVar.m2134a("openableURLs", hashMap);
        }
    }

    static class C08473 implements aa {
        C08473() {
        }

        public void mo874a(dt dtVar, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                dq.m2120e("URL missing from click GMSG.");
                return;
            }
            Uri a;
            Uri parse = Uri.parse(str);
            try {
                fg g = dtVar.m2143g();
                if (g != null && g.m2506b(parse)) {
                    a = g.m2502a(parse, dtVar.getContext());
                    new C0750do(dtVar.getContext(), dtVar.m2144h().f1564b, a.toString()).m1741e();
                }
            } catch (fi e) {
                dq.m2120e("Unable to append parameter to URL: " + str);
            }
            a = parse;
            new C0750do(dtVar.getContext(), dtVar.m2144h().f1564b, a.toString()).m1741e();
        }
    }

    static class C08484 implements aa {
        C08484() {
        }

        public void mo874a(dt dtVar, Map<String, String> map) {
            bf d = dtVar.m2140d();
            if (d == null) {
                dq.m2120e("A GMSG tried to close something that wasn't an overlay.");
            } else {
                d.m1688a();
            }
        }
    }

    static class C08495 implements aa {
        C08495() {
        }

        public void mo874a(dt dtVar, Map<String, String> map) {
            bf d = dtVar.m2140d();
            if (d == null) {
                dq.m2120e("A GMSG tried to use a custom close button on something that wasn't an overlay.");
            } else {
                d.m1697b(AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("custom_close")));
            }
        }
    }

    static class C08506 implements aa {
        C08506() {
        }

        public void mo874a(dt dtVar, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                dq.m2120e("URL missing from httpTrack GMSG.");
            } else {
                new C0750do(dtVar.getContext(), dtVar.m2144h().f1564b, str).m1741e();
            }
        }
    }

    static class C08517 implements aa {
        C08517() {
        }

        public void mo874a(dt dtVar, Map<String, String> map) {
            dq.m2117c("Received log message: " + ((String) map.get("string")));
        }
    }

    static class C08528 implements aa {
        C08528() {
        }

        public void mo874a(dt dtVar, Map<String, String> map) {
            String str = (String) map.get("ty");
            String str2 = (String) map.get("td");
            try {
                int parseInt = Integer.parseInt((String) map.get("tx"));
                int parseInt2 = Integer.parseInt(str);
                int parseInt3 = Integer.parseInt(str2);
                fg g = dtVar.m2143g();
                if (g != null) {
                    g.m2503a().mo968a(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException e) {
                dq.m2120e("Could not parse touch parameters from gmsg.");
            }
        }
    }
}
