package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.actionbarsherlock.view.Menu;
import com.appsflyer.ServerParameters;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public final class dp {
    public static final Handler f1344a = new Handler(Looper.getMainLooper());

    public static int m2103a(Context context, int i) {
        return m2104a(context.getResources().getDisplayMetrics(), i);
    }

    public static int m2104a(DisplayMetrics displayMetrics, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, displayMetrics);
    }

    public static String m2105a(Context context) {
        String string = Secure.getString(context.getContentResolver(), ServerParameters.ANDROID_ID);
        if (string == null || m2110a()) {
            string = "emulator";
        }
        return m2106a(string);
    }

    public static String m2106a(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest.getInstance("MD5").update(str.getBytes());
                return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, r1.digest())});
            } catch (NoSuchAlgorithmException e) {
                i++;
            }
        }
        return null;
    }

    public static void m2107a(ViewGroup viewGroup, al alVar, String str) {
        m2108a(viewGroup, alVar, str, -16777216, -1);
    }

    private static void m2108a(ViewGroup viewGroup, al alVar, String str, int i, int i2) {
        if (viewGroup.getChildCount() == 0) {
            Context context = viewGroup.getContext();
            View textView = new TextView(context);
            textView.setGravity(17);
            textView.setText(str);
            textView.setTextColor(i);
            textView.setBackgroundColor(i2);
            View frameLayout = new FrameLayout(context);
            frameLayout.setBackgroundColor(i);
            int a = m2103a(context, 3);
            frameLayout.addView(textView, new LayoutParams(alVar.f926g - a, alVar.f923d - a, 17));
            viewGroup.addView(frameLayout, alVar.f926g, alVar.f923d);
        }
    }

    public static void m2109a(ViewGroup viewGroup, al alVar, String str, String str2) {
        dq.m2120e(str2);
        m2108a(viewGroup, alVar, str, Menu.CATEGORY_MASK, -16777216);
    }

    public static boolean m2110a() {
        return Build.DEVICE.startsWith("generic");
    }

    public static boolean m2111b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
