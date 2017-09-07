package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.SystemClock;
import android.text.TextUtils;
import com.facebook.widget.PlacePickerFragment;
import com.google.android.gms.internal.cr.C0737a;
import com.google.android.gms.internal.dv.C0699a;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import twitter4j.HttpResponseCode;

public final class cs extends C0737a {
    private static final Object f1201a = new Object();
    private static cs f1202b;
    private final Context f1203c;
    private final cz f1204d;
    private final ag f1205e;
    private final C0843w f1206f;

    cs(Context context, C0843w c0843w, ag agVar, cz czVar) {
        this.f1203c = context;
        this.f1204d = czVar;
        this.f1205e = agVar;
        this.f1206f = c0843w;
    }

    public static cs m1963a(Context context, C0843w c0843w, ag agVar, cz czVar) {
        cs csVar;
        synchronized (f1201a) {
            if (f1202b == null) {
                f1202b = new cs(context.getApplicationContext(), c0843w, agVar, czVar);
            }
            csVar = f1202b;
        }
        return csVar;
    }

    private static du m1964a(Context context, C0843w c0843w, ag agVar, cz czVar, ds dsVar) {
        dq.m2112a("Starting ad request from service.");
        agVar.mo876a();
        cy cyVar = new cy(context);
        if (cyVar.f1250l == -1) {
            dq.m2112a("Device is offline.");
            return new du(2);
        }
        final cu cuVar = new cu(dsVar.f1360f.packageName);
        if (dsVar.f1357c.f893c != null) {
            String string = dsVar.f1357c.f893c.getString("_ad");
            if (string != null) {
                return ct.m1969a(context, dsVar, string);
            }
        }
        Location a = agVar.mo875a(250);
        final String a2 = c0843w.m2794a();
        String a3 = ct.m1972a(dsVar, cyVar, a, c0843w.m2795b());
        if (a3 == null) {
            return new du(0);
        }
        final C0699a a4 = m1966a(a3);
        final Context context2 = context;
        final ds dsVar2 = dsVar;
        dp.f1344a.post(new Runnable() {
            public void run() {
                dt a = dt.m2125a(context2, new al(), false, false, null, dsVar2.f1365k);
                a.setWillNotDraw(true);
                cuVar.m1984a(a);
                dv f = a.m2142f();
                f.m2155a("/invalidRequest", cuVar.f1210a);
                f.m2155a("/loadAdURL", cuVar.f1211b);
                f.m2155a("/log", C0853z.f1809g);
                f.m2152a(a4);
                dq.m2112a("Loading the JS library.");
                a.loadUrl(a2);
            }
        });
        cx b = cuVar.m1985b();
        if (b == null || TextUtils.isEmpty(b.m2011c())) {
            return new du(cuVar.m1983a());
        }
        a3 = null;
        if (b.m2013e()) {
            a3 = czVar.mo964a(dsVar.f1361g.packageName);
        }
        return m1965a(context, dsVar.f1365k.f1564b, b.m2011c(), a3, b);
    }

    public static du m1965a(Context context, String str, String str2, String str3, cx cxVar) {
        HttpURLConnection httpURLConnection;
        try {
            int responseCode;
            du duVar;
            cw cwVar = new cw();
            URL url = new URL(str2);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            URL url2 = url;
            int i = 0;
            while (true) {
                httpURLConnection = (HttpURLConnection) url2.openConnection();
                dk.m2069a(context, str, false, httpURLConnection);
                if (!TextUtils.isEmpty(str3)) {
                    httpURLConnection.addRequestProperty("x-afma-drt-cookie", str3);
                }
                if (!(cxVar == null || TextUtils.isEmpty(cxVar.m2010b()))) {
                    httpURLConnection.setDoOutput(true);
                    byte[] bytes = cxVar.m2010b().getBytes();
                    httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                    bufferedOutputStream.write(bytes);
                    bufferedOutputStream.close();
                }
                responseCode = httpURLConnection.getResponseCode();
                Map headerFields = httpURLConnection.getHeaderFields();
                if (responseCode < HttpResponseCode.OK || responseCode >= HttpResponseCode.MULTIPLE_CHOICES) {
                    m1967a(url2.toString(), headerFields, null, responseCode);
                    if (responseCode < HttpResponseCode.MULTIPLE_CHOICES || responseCode >= HttpResponseCode.BAD_REQUEST) {
                        break;
                    }
                    Object headerField = httpURLConnection.getHeaderField("Location");
                    if (TextUtils.isEmpty(headerField)) {
                        dq.m2120e("No location header to follow redirect.");
                        duVar = new du(0);
                        httpURLConnection.disconnect();
                        return duVar;
                    }
                    url2 = new URL(headerField);
                    i++;
                    if (i > 5) {
                        dq.m2120e("Too many redirects.");
                        duVar = new du(0);
                        httpURLConnection.disconnect();
                        return duVar;
                    }
                    cwVar.m2005a(headerFields);
                    httpURLConnection.disconnect();
                } else {
                    String url3 = url2.toString();
                    String a = dk.m2060a(new InputStreamReader(httpURLConnection.getInputStream()));
                    m1967a(url3, headerFields, a, responseCode);
                    cwVar.m2004a(url3, headerFields, a);
                    duVar = cwVar.m2003a(elapsedRealtime);
                    httpURLConnection.disconnect();
                    return duVar;
                }
            }
            dq.m2120e("Received error HTTP response code: " + responseCode);
            duVar = new du(0);
            httpURLConnection.disconnect();
            return duVar;
        } catch (IOException e) {
            dq.m2120e("Error while connecting to ad server: " + e.getMessage());
            return new du(2);
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }

    private static C0699a m1966a(final String str) {
        return new C0699a() {
            public void mo921a(dt dtVar) {
                String format = String.format("javascript:%s(%s);", new Object[]{"AFMA_buildAdURL", str});
                dq.m2119d("About to execute: " + format);
                dtVar.loadUrl(format);
            }
        };
    }

    private static void m1967a(String str, Map<String, List<String>> map, String str2, int i) {
        if (dq.m2114a(2)) {
            dq.m2119d("Http Response: {\n  URL:\n    " + str + "\n  Headers:");
            if (map != null) {
                for (String str3 : map.keySet()) {
                    dq.m2119d("    " + str3 + ":");
                    for (String str32 : (List) map.get(str32)) {
                        dq.m2119d("      " + str32);
                    }
                }
            }
            dq.m2119d("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += PlacePickerFragment.DEFAULT_RADIUS_IN_METERS) {
                    dq.m2119d(str2.substring(i2, Math.min(str2.length(), i2 + PlacePickerFragment.DEFAULT_RADIUS_IN_METERS)));
                }
            } else {
                dq.m2119d("    null");
            }
            dq.m2119d("  Response Code:\n    " + i + "\n}");
        }
    }

    public du mo961a(ds dsVar) {
        return m1964a(this.f1203c, this.f1206f, this.f1205e, this.f1204d, dsVar);
    }
}
