package com.telkom.mwallet.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.View;

@SuppressLint({"DrawAllocation"})
public class C2009a extends View {
    static int f5834a = 40;
    static int f5835b = 230;
    float f5836c = 1.0f;
    private final float f5837d = 0.8f;
    private float f5838e;
    private RectF f5839f = new RectF();
    private float f5840g = (((float) f5834a) * this.f5836c);
    private float f5841h = (((float) f5835b) * this.f5836c);
    private boolean f5842i = false;
    private Paint f5843j;

    public C2009a(Context context) {
        super(context);
        m8027a();
    }

    private void m8027a() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f5836c = displayMetrics.density;
        float f = ((float) displayMetrics.widthPixels) / this.f5836c;
        int i = 40;
        int i2 = 250;
        if (f == 540.0f || ((double) this.f5836c) == 1.0d) {
            f /= 360.0f;
            i = (int) (((float) 40) * f);
            i2 = (int) (((float) 250) * f);
        }
        f5834a = i;
        f5835b = i2;
        this.f5840g = this.f5836c * ((float) f5834a);
        this.f5841h = this.f5836c * ((float) f5835b);
        this.f5843j = new Paint();
        this.f5843j.setColor(-1303516);
        this.f5843j.setAntiAlias(true);
        this.f5843j.setStyle(Style.STROKE);
        this.f5843j.setStrokeWidth(this.f5840g);
        this.f5843j.setStrokeCap(Cap.ROUND);
    }

    private float m8028b() {
        return (this.f5838e <= 500000.0f ? (this.f5838e * 0.8f) / 500000.0f : (((this.f5838e - 500000.0f) / 4500000.0f) * 0.19999999f) + 0.8f) * 120.0f;
    }

    protected void onDraw(Canvas canvas) {
        float b = m8028b();
        int i = (int) b;
        int i2 = (i != 0 || b <= 0.0f) ? i : 1;
        int i3 = 150 - i2;
        if (this.f5842i) {
            i = (int) (((double) this.f5840g) * 0.125d);
            int i4 = i == 0 ? 1 : i;
            int i5 = 0;
            i = 244;
            while (((double) i5) <= ((double) this.f5840g) * 0.5d) {
                int i6;
                if (i5 % i4 == 0) {
                    int i7 = i + 1;
                    this.f5843j.setARGB(255, i7, i7, i7);
                    this.f5843j.setStrokeWidth(this.f5840g - ((float) i5));
                    canvas.drawArc(this.f5839f, (float) i3, (float) i2, false, this.f5843j);
                    i6 = i7;
                } else {
                    i6 = i;
                }
                i5++;
                i = i6;
            }
        } else {
            canvas.drawArc(this.f5839f, (float) i3, (float) i2, false, this.f5843j);
        }
        super.onDraw(canvas);
    }

    protected void onMeasure(int i, int i2) {
        float f = ((this.f5840g / 2.0f) - (20.0f * this.f5836c)) - ((this.f5841h * 2.0f) / 3.0f);
        float defaultSize = (((float) C2009a.getDefaultSize(getSuggestedMinimumWidth(), i)) - this.f5841h) / 2.0f;
        this.f5839f.set(defaultSize, f, this.f5841h + defaultSize, this.f5841h + f);
        super.onMeasure(i, i2);
    }

    public void setIsShadow(boolean z) {
        this.f5842i = z;
    }

    public void setProgressColor(int i) {
        this.f5843j.setColor(i);
    }

    public void setTCashBalance(float f) {
        this.f5838e = f;
        if (this.f5838e > 5000000.0f) {
            this.f5838e = 5000000.0f;
        }
        invalidate();
    }

    public void setTCashBalance(String str) {
        this.f5838e = Float.parseFloat(str);
        if (this.f5838e > 5000000.0f) {
            this.f5838e = 5000000.0f;
        }
        invalidate();
    }
}
