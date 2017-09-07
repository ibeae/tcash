package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.amobee.richmedia.view.AmobeeView;
import java.util.Map;

public final class af implements aa {
    private static int m1540a(DisplayMetrics displayMetrics, Map<String, String> map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            try {
                i = dp.m2104a(displayMetrics, Integer.parseInt(str2));
            } catch (NumberFormatException e) {
                dq.m2120e("Could not parse " + str + " in a video GMSG: " + str2);
            }
        }
        return i;
    }

    public void mo874a(dt dtVar, Map<String, String> map) {
        String str = (String) map.get(AmobeeView.ACTION_KEY);
        if (str == null) {
            dq.m2120e("Action missing from video GMSG.");
            return;
        }
        bf d = dtVar.m2140d();
        if (d == null) {
            dq.m2120e("Could not get ad overlay for a video GMSG.");
            return;
        }
        boolean equalsIgnoreCase = "new".equalsIgnoreCase(str);
        boolean equalsIgnoreCase2 = "position".equalsIgnoreCase(str);
        int a;
        if (equalsIgnoreCase || equalsIgnoreCase2) {
            DisplayMetrics displayMetrics = dtVar.getContext().getResources().getDisplayMetrics();
            a = m1540a(displayMetrics, map, "x", 0);
            int a2 = m1540a(displayMetrics, map, "y", 0);
            int a3 = m1540a(displayMetrics, map, "w", -1);
            int a4 = m1540a(displayMetrics, map, "h", -1);
            if (equalsIgnoreCase && d.m1694b() == null) {
                d.m1695b(a, a2, a3, a4);
                return;
            } else {
                d.m1690a(a, a2, a3, a4);
                return;
            }
        }
        bi b = d.m1694b();
        if (b == null) {
            bi.m1716a(dtVar, "no_video_view", null);
        } else if ("click".equalsIgnoreCase(str)) {
            displayMetrics = dtVar.getContext().getResources().getDisplayMetrics();
            int a5 = m1540a(displayMetrics, map, "x", 0);
            a = m1540a(displayMetrics, map, "y", 0);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) a5, (float) a, 0);
            b.m1721a(obtain);
            obtain.recycle();
        } else if ("controls".equalsIgnoreCase(str)) {
            str = (String) map.get("enabled");
            if (str == null) {
                dq.m2120e("Enabled parameter missing from controls video GMSG.");
            } else {
                b.m1723a(Boolean.parseBoolean(str));
            }
        } else if ("currentTime".equalsIgnoreCase(str)) {
            str = (String) map.get("time");
            if (str == null) {
                dq.m2120e("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                b.m1720a((int) (Float.parseFloat(str) * 1000.0f));
            } catch (NumberFormatException e) {
                dq.m2120e("Could not parse time parameter from currentTime video GMSG: " + str);
            }
        } else if ("hide".equalsIgnoreCase(str)) {
            b.setVisibility(4);
        } else if ("load".equalsIgnoreCase(str)) {
            b.m1724b();
        } else if ("pause".equalsIgnoreCase(str)) {
            b.m1725c();
        } else if ("play".equalsIgnoreCase(str)) {
            b.m1726d();
        } else if ("show".equalsIgnoreCase(str)) {
            b.setVisibility(0);
        } else if ("src".equalsIgnoreCase(str)) {
            b.m1722a((String) map.get("src"));
        } else {
            dq.m2120e("Unknown video action: " + str);
        }
    }
}
