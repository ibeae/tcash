package com.telkom.mwallet.coupon.p065a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build.VERSION;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.SurfaceHolder;
import com.facebook.widget.PlacePickerFragment;
import com.skcc.wallet.core.p057a.C1216a;
import com.telkom.mwallet.coupon.helper.C1482f;
import java.io.IOException;

@SuppressLint({"NewApi"})
public final class C1437c {
    static final int f3289a;
    private static final String f3290b = C1437c.class.getSimpleName();
    private static C1437c f3291c;
    private final Context f3292d;
    private final C1436b f3293e;
    private Camera f3294f;
    private Rect f3295g;
    private Rect f3296h;
    private boolean f3297i;
    private boolean f3298j;
    private final boolean f3299k;
    private final C1439e f3300l;
    private final C1435a f3301m;

    static {
        int parseInt;
        try {
            parseInt = Integer.parseInt(VERSION.SDK);
        } catch (NumberFormatException e) {
            parseInt = 10000;
        }
        f3289a = parseInt;
    }

    private C1437c(Context context) {
        this.f3292d = context;
        this.f3293e = new C1436b(context);
        this.f3299k = f3289a > 3;
        this.f3300l = new C1439e(this.f3293e, this.f3299k);
        this.f3301m = new C1435a();
    }

    public static C1437c m5428a() {
        return f3291c;
    }

    public static void m5429a(Context context) {
        if (f3291c == null) {
            f3291c = new C1437c(context);
        }
    }

    public C1482f m5430a(byte[] bArr, int i, int i2) {
        Rect f = m5438f();
        int c = this.f3293e.m5426c();
        String d = this.f3293e.m5427d();
        switch (c) {
            case 16:
            case 17:
                return new C1482f(bArr, i, i2, f.left, f.top, f.width(), f.height());
            default:
                if ("yuv420p".equals(d)) {
                    return new C1482f(bArr, i, i2, f.left, f.top, f.width(), f.height());
                }
                throw new IllegalArgumentException("Unsupported picture format: " + c + '/' + d);
        }
    }

    public void m5431a(Handler handler, int i) {
        if (this.f3294f != null && this.f3298j) {
            this.f3300l.m5446a(handler, i);
            if (this.f3299k) {
                this.f3294f.setOneShotPreviewCallback(this.f3300l);
            } else {
                this.f3294f.setPreviewCallback(this.f3300l);
            }
        }
    }

    public void m5432a(SurfaceHolder surfaceHolder) {
        if (this.f3294f == null) {
            this.f3294f = Camera.open();
            if (this.f3294f == null) {
                throw new IOException();
            }
            this.f3294f.setDisplayOrientation(90);
            this.f3294f.setPreviewDisplay(surfaceHolder);
            if (!this.f3297i) {
                this.f3297i = true;
                this.f3293e.m5423a(this.f3294f);
            }
            this.f3293e.m5425b(this.f3294f);
            PreferenceManager.getDefaultSharedPreferences(this.f3292d);
        }
    }

    public void m5433b() {
        if (this.f3294f != null) {
            C1438d.m5443a();
            this.f3294f.release();
            this.f3294f = null;
        }
    }

    public void m5434b(Handler handler, int i) {
        if (this.f3294f != null && this.f3298j) {
            this.f3301m.m5416a(handler, i);
            this.f3294f.autoFocus(this.f3301m);
        }
    }

    public void m5435c() {
        if (this.f3294f != null && !this.f3298j) {
            this.f3294f.startPreview();
            this.f3298j = true;
        }
    }

    public void m5436d() {
        if (this.f3294f != null && this.f3298j) {
            if (!this.f3299k) {
                this.f3294f.setPreviewCallback(null);
            }
            this.f3294f.stopPreview();
            this.f3300l.m5446a(null, 0);
            this.f3301m.m5416a(null, 0);
            this.f3298j = false;
        }
    }

    public Rect m5437e() {
        int i = 240;
        DisplayMetrics displayMetrics = this.f3292d.getResources().getDisplayMetrics();
        Point b = this.f3293e.m5424b();
        if (b == null) {
            b = new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        b.set(Math.min(b.x, b.y), Math.max(b.x, b.y));
        float f = (float) b.x;
        if (this.f3295g == null) {
            if (this.f3294f == null) {
                return null;
            }
            int i2 = (int) f;
            C1216a.m4525e("camerae size", "X : " + b.x + "  Y : " + b.y);
            if (b.y == 320) {
                this.f3295g = new Rect(0, 0, 320, 480);
            } else if (b.y == 600) {
                this.f3295g = new Rect(0, 0, 600, PlacePickerFragment.DEFAULT_RADIUS_IN_METERS);
            } else {
                int applyDimension = (int) TypedValue.applyDimension(1, 50.0f, displayMetrics);
                int round = Math.round(((float) b.x) * 0.9f);
                int round2 = Math.round(((float) (b.y - applyDimension)) * 0.85f);
                if (round >= 240) {
                    i = round > i2 ? i2 : round;
                }
                i2 = (int) (((double) (b.x - i)) / 2.0d);
                int i3 = (int) ((((double) (b.y - round2)) / 2.0d) - (((double) applyDimension) * 0.7d));
                this.f3295g = new Rect(i2, i3, i + i2, i3 + round2);
                C1216a.m4519a(f3290b, "Calculated framing rect: " + this.f3295g);
            }
        }
        return this.f3295g;
    }

    public Rect m5438f() {
        if (this.f3296h == null) {
            Point a = this.f3293e.m5422a();
            Point b = this.f3293e.m5424b();
            if (a == null || b == null) {
                return null;
            }
            Rect rect = new Rect(m5437e());
            rect.left = Math.round(((((float) rect.left) * 1.0f) * ((float) a.y)) / ((float) b.x));
            rect.right = Math.round(((((float) rect.right) * 1.0f) * ((float) a.y)) / ((float) b.x));
            rect.top = Math.round(((((float) rect.top) * 1.0f) * ((float) a.x)) / ((float) b.y));
            rect.bottom = Math.round((((float) a.x) * (((float) rect.bottom) * 1.0f)) / ((float) b.y));
            this.f3296h = rect;
        }
        return this.f3296h;
    }
}
