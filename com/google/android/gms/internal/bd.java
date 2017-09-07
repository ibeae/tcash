package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public final class bd {
    public static boolean m1669a(Context context, ce ceVar, bk bkVar) {
        if (ceVar == null) {
            dq.m2120e("No intent data for launcher overlay.");
            return false;
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(ceVar.f1113c)) {
            dq.m2120e("Open GMSG did not contain a URL.");
            return false;
        }
        if (TextUtils.isEmpty(ceVar.f1114d)) {
            intent.setData(Uri.parse(ceVar.f1113c));
        } else {
            intent.setDataAndType(Uri.parse(ceVar.f1113c), ceVar.f1114d);
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(ceVar.f1115e)) {
            intent.setPackage(ceVar.f1115e);
        }
        if (!TextUtils.isEmpty(ceVar.f1116f)) {
            String[] split = ceVar.f1116f.split("/", 2);
            if (split.length < 2) {
                dq.m2120e("Could not parse component name from open GMSG: " + ceVar.f1116f);
                return false;
            }
            intent.setClassName(split[0], split[1]);
        }
        try {
            dq.m2119d("Launching an intent: " + intent);
            context.startActivity(intent);
            bkVar.mo1099q();
            return true;
        } catch (ActivityNotFoundException e) {
            dq.m2120e(e.getMessage());
            return false;
        }
    }
}
