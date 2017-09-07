package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;

public class fg {
    private String f1576a = "googleads.g.doubleclick.net";
    private String f1577b = "/pagead/ads";
    private String f1578c = "ad.doubleclick.net";
    private String[] f1579d = new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private eb f1580e;

    public fg(eb ebVar) {
        this.f1580e = ebVar;
    }

    private Uri m2499a(Uri uri, Context context, String str, boolean z) {
        try {
            boolean a = m2505a(uri);
            if (a) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new fi("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new fi("Query parameter already exists: ms");
            }
            String a2 = z ? this.f1580e.mo967a(context, str) : this.f1580e.mo966a(context);
            return a ? m2501b(uri, "dc_ms", a2) : m2500a(uri, "ms", a2);
        } catch (UnsupportedOperationException e) {
            throw new fi("Provided Uri is not in a valid state");
        }
    }

    private Uri m2500a(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl");
        }
        return indexOf != -1 ? Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append("&").append(uri2.substring(indexOf + 1)).toString()) : uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    private Uri m2501b(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf(";adurl");
        if (indexOf != -1) {
            return Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append(";").append(uri2.substring(indexOf + 1)).toString());
        }
        String encodedPath = uri.getEncodedPath();
        int indexOf2 = uri2.indexOf(encodedPath);
        return Uri.parse(new StringBuilder(uri2.substring(0, encodedPath.length() + indexOf2)).append(";").append(str).append("=").append(str2).append(";").append(uri2.substring(encodedPath.length() + indexOf2)).toString());
    }

    public Uri m2502a(Uri uri, Context context) {
        try {
            return m2499a(uri, context, uri.getQueryParameter("ai"), true);
        } catch (UnsupportedOperationException e) {
            throw new fi("Provided Uri is not in a valid state");
        }
    }

    public eb m2503a() {
        return this.f1580e;
    }

    public void m2504a(MotionEvent motionEvent) {
        this.f1580e.mo969a(motionEvent);
    }

    public boolean m2505a(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.f1578c);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean m2506b(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String endsWith : this.f1579d) {
                if (host.endsWith(endsWith)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }
}
