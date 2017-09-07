package com.actionbarsherlock.internal;

import android.app.Activity;
import android.content.Context;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.actionbarsherlock.C0247R;

public final class ResourcesCompat {
    private static final String TAG = "ResourcesCompat";

    private ResourcesCompat() {
    }

    public static boolean getResources_getBoolean(Context context, int i) {
        if (VERSION.SDK_INT >= 14) {
            return context.getResources().getBoolean(i);
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f = ((float) displayMetrics.widthPixels) / displayMetrics.density;
        float f2 = ((float) displayMetrics.heightPixels) / displayMetrics.density;
        if (f < f2) {
            f2 = f;
        }
        if (i == C0247R.bool.abs__action_bar_embed_tabs) {
            return f >= 480.0f;
        } else {
            if (i == C0247R.bool.abs__split_action_bar_is_narrow) {
                return f < 480.0f;
            } else {
                if (i == C0247R.bool.abs__action_bar_expanded_action_views_exclusive) {
                    return f2 < 600.0f;
                } else {
                    if (i == C0247R.bool.abs__config_allowActionMenuItemTextWithIcon) {
                        return f >= 480.0f;
                    } else {
                        throw new IllegalArgumentException("Unknown boolean resource ID " + i);
                    }
                }
            }
        }
    }

    public static int getResources_getInteger(Context context, int i) {
        if (VERSION.SDK_INT >= 13) {
            return context.getResources().getInteger(i);
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f = ((float) displayMetrics.widthPixels) / displayMetrics.density;
        if (i == C0247R.integer.abs__max_action_buttons) {
            return f >= 600.0f ? 5 : f >= 500.0f ? 4 : f >= 360.0f ? 3 : 2;
        } else {
            throw new IllegalArgumentException("Unknown integer resource ID " + i);
        }
    }

    public static int loadLogoFromManifest(Activity activity) {
        int i;
        Exception e;
        try {
            String name = activity.getClass().getName();
            String str = activity.getApplicationInfo().packageName;
            XmlResourceParser openXmlResourceParser = activity.createPackageContext(str, 0).getAssets().openXmlResourceParser("AndroidManifest.xml");
            int eventType = openXmlResourceParser.getEventType();
            i = 0;
            while (eventType != 1) {
                if (eventType == 2) {
                    try {
                        String name2 = openXmlResourceParser.getName();
                        if (!"application".equals(name2)) {
                            if ("activity".equals(name2)) {
                                Object obj = null;
                                String str2 = null;
                                Integer num = null;
                                for (eventType = openXmlResourceParser.getAttributeCount() - 1; eventType >= 0; eventType--) {
                                    String attributeName = openXmlResourceParser.getAttributeName(eventType);
                                    if ("logo".equals(attributeName)) {
                                        num = Integer.valueOf(openXmlResourceParser.getAttributeResourceValue(eventType, 0));
                                    } else if ("name".equals(attributeName)) {
                                        str2 = ActionBarSherlockCompat.cleanActivityName(str, openXmlResourceParser.getAttributeValue(eventType));
                                        if (!name.equals(str2)) {
                                            break;
                                        }
                                        int i2 = 1;
                                    }
                                    if (!(num == null || r4 == null)) {
                                        i = num.intValue();
                                    }
                                }
                                if (obj != null) {
                                    break;
                                }
                            }
                        }
                        for (eventType = openXmlResourceParser.getAttributeCount() - 1; eventType >= 0; eventType--) {
                            if ("logo".equals(openXmlResourceParser.getAttributeName(eventType))) {
                                i = openXmlResourceParser.getAttributeResourceValue(eventType, 0);
                                break;
                            }
                        }
                        eventType = i;
                        i = eventType;
                        eventType = openXmlResourceParser.nextToken();
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
                eventType = i;
                try {
                    i = eventType;
                    eventType = openXmlResourceParser.nextToken();
                } catch (Exception e3) {
                    Exception exception = e3;
                    i = eventType;
                    e = exception;
                }
            }
        } catch (Exception e32) {
            e = e32;
            i = 0;
            e.printStackTrace();
            return i;
        }
        return i;
    }
}
