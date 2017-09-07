package com.google.android.gms.internal;

import android.content.Context;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import twitter4j.HttpResponseCode;

public final class C0750do extends di {
    private final String f1341a;
    private final Context f1342b;
    private final String f1343c;

    public C0750do(Context context, String str, String str2) {
        this.f1342b = context;
        this.f1341a = str;
        this.f1343c = str2;
    }

    public void mo931a() {
        HttpURLConnection httpURLConnection;
        try {
            dq.m2119d("Pinging URL: " + this.f1343c);
            httpURLConnection = (HttpURLConnection) new URL(this.f1343c).openConnection();
            dk.m2069a(this.f1342b, this.f1341a, true, httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < HttpResponseCode.OK || responseCode >= HttpResponseCode.MULTIPLE_CHOICES) {
                dq.m2120e("Received non-success response code " + responseCode + " from pinging URL: " + this.f1343c);
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e) {
            dq.m2120e("Error while parsing ping URL: " + this.f1343c + ". " + e.getMessage());
        } catch (IOException e2) {
            dq.m2120e("Error while pinging URL: " + this.f1343c + ". " + e2.getMessage());
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }

    public void mo932b() {
    }
}
