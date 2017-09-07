package com.telkom.mwallet.coupon.p065a;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.skcc.wallet.core.p057a.C1216a;
import java.util.regex.Pattern;

final class C1436b {
    private static final String f3282a = C1436b.class.getSimpleName();
    private static final Pattern f3283b = Pattern.compile(",");
    private final Context f3284c;
    private Point f3285d;
    private Point f3286e;
    private int f3287f;
    private String f3288g;

    C1436b(Context context) {
        this.f3284c = context;
    }

    private static int m5417a(CharSequence charSequence, int i) {
        String[] split = f3283b.split(charSequence);
        int length = split.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            try {
                double parseDouble = Double.parseDouble(split[i2].trim());
                int i4 = (int) (10.0d * parseDouble);
                if (Math.abs(((double) i) - parseDouble) >= ((double) Math.abs(i - i3))) {
                    i4 = i3;
                }
                i2++;
                i3 = i4;
            } catch (NumberFormatException e) {
                return i;
            }
        }
        return i3;
    }

    private static Point m5418a(Parameters parameters, Point point) {
        String str = parameters.get("preview-size-values");
        if (str == null) {
            CharSequence charSequence = parameters.get("preview-size-value");
        } else {
            Object obj = str;
        }
        Point point2 = null;
        if (charSequence != null) {
            C1216a.m4519a(f3282a, "preview-size-values parameter: " + charSequence);
            point2 = C1436b.m5419a(charSequence, point);
        }
        return point2 == null ? new Point((point.x >> 3) << 3, (point.y >> 3) << 3) : point2;
    }

    private static Point m5419a(CharSequence charSequence, Point point) {
        int indexOf;
        int parseInt;
        String[] split = f3283b.split(charSequence);
        int length = split.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = Integer.MAX_VALUE;
        while (i < length) {
            int i5;
            String trim = split[i].trim();
            indexOf = trim.indexOf(120);
            if (indexOf < 0) {
                C1216a.m4524d(f3282a, "Bad preview-size: " + trim);
                i5 = i2;
                i2 = i3;
            } else {
                try {
                    parseInt = Integer.parseInt(trim.substring(0, indexOf));
                    indexOf = Integer.parseInt(trim.substring(indexOf + 1));
                    i5 = Math.abs(parseInt - point.x) + Math.abs(indexOf - point.y);
                    if (i5 == 0) {
                        break;
                    } else if (i5 < i4) {
                        i4 = i5;
                        i2 = parseInt;
                        i5 = indexOf;
                    } else {
                        i5 = i2;
                        i2 = i3;
                    }
                } catch (NumberFormatException e) {
                    C1216a.m4524d(f3282a, "Bad preview-size: " + trim);
                    i5 = i2;
                    i2 = i3;
                }
            }
            i++;
            i3 = i2;
            i2 = i5;
        }
        indexOf = i2;
        parseInt = i3;
        return (parseInt <= 0 || indexOf <= 0) ? null : new Point(parseInt, indexOf);
    }

    private void m5420a(Parameters parameters) {
        if (Build.MODEL.contains("Behold II") && C1437c.f3289a == 3) {
            parameters.set("flash-value", 1);
        } else {
            parameters.set("flash-value", 2);
        }
        parameters.set("flash-mode", "off");
    }

    private void m5421b(Parameters parameters) {
        String str = parameters.get("zoom-supported");
        if (str == null || Boolean.parseBoolean(str)) {
            int parseDouble;
            int i = 27;
            String str2 = parameters.get("max-zoom");
            if (str2 != null) {
                try {
                    parseDouble = (int) (Double.parseDouble(str2) * 10.0d);
                    if (27 <= parseDouble) {
                        parseDouble = 27;
                    }
                    i = parseDouble;
                } catch (NumberFormatException e) {
                    C1216a.m4524d(f3282a, "Bad max-zoom: " + str2);
                }
            }
            String str3 = parameters.get("taking-picture-zoom-max");
            if (str3 != null) {
                try {
                    parseDouble = Integer.parseInt(str3);
                    if (i > parseDouble) {
                        i = parseDouble;
                    }
                } catch (NumberFormatException e2) {
                    C1216a.m4524d(f3282a, "Bad taking-picture-zoom-max: " + str3);
                }
            }
            CharSequence charSequence = parameters.get("mot-zoom-values");
            if (charSequence != null) {
                i = C1436b.m5417a(charSequence, i);
            }
            String str4 = parameters.get("mot-zoom-step");
            if (str4 != null) {
                try {
                    int parseDouble2 = (int) (Double.parseDouble(str4.trim()) * 10.0d);
                    if (parseDouble2 > 1) {
                        i -= i % parseDouble2;
                    }
                } catch (NumberFormatException e3) {
                }
            }
            if (!(str2 == null && charSequence == null)) {
                parameters.set("zoom", String.valueOf(((double) i) / 10.0d));
            }
            if (str3 != null) {
                parameters.set("taking-picture-zoom", i);
            }
        }
    }

    Point m5422a() {
        return this.f3286e;
    }

    void m5423a(Camera camera) {
        camera.setDisplayOrientation(90);
        Parameters parameters = camera.getParameters();
        this.f3287f = parameters.getPreviewFormat();
        this.f3288g = parameters.get("preview-format");
        C1216a.m4519a(f3282a, "Default preview format: " + this.f3287f + '/' + this.f3288g);
        Display defaultDisplay = ((WindowManager) this.f3284c.getSystemService("window")).getDefaultDisplay();
        this.f3285d = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        C1216a.m4519a(f3282a, "Screen resolution: " + this.f3285d);
        this.f3286e = C1436b.m5418a(parameters, this.f3285d);
        C1216a.m4519a(f3282a, "Camera resolution: " + this.f3285d);
    }

    Point m5424b() {
        return this.f3285d;
    }

    void m5425b(Camera camera) {
        Parameters parameters = camera.getParameters();
        C1216a.m4519a(f3282a, "Setting preview size: " + this.f3286e);
        parameters.setPreviewSize(this.f3286e.x, this.f3286e.y);
        m5420a(parameters);
        m5421b(parameters);
        camera.setParameters(parameters);
    }

    int m5426c() {
        return this.f3287f;
    }

    String m5427d() {
        return this.f3288g;
    }
}
