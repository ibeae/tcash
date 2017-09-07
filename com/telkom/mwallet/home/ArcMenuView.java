package com.telkom.mwallet.home;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.skcc.wallet.core.p057a.C1216a;
import com.telkom.mwallet.R;
import java.util.ArrayList;
import java.util.List;
import twitter4j.HttpResponseCode;

public class ArcMenuView extends RelativeLayout {
    private static double f3700e = 0.7853981633974483d;
    private static int f3701f = 52;
    private static int f3702g = 52;
    private static float f3703h = 40.0f;
    private static float f3704i = 40.0f;
    private static float f3705j = 62.0f;
    private static int f3706k = HttpResponseCode.MULTIPLE_CHOICES;
    private static int[] f3707l = new int[]{R.drawable.btn_main_hover_01, R.drawable.btn_main_hover_02, R.drawable.btn_main_hover_03, R.drawable.btn_main_hover_04, R.drawable.btn_main_hover_05};
    private static int f3708n = 0;
    private static int f3709o = 0;
    private static float f3710p = 1.0f;
    private static float f3711q = 300.0f;
    private static int f3712r = 0;
    private static int f3713s = 0;
    private static int f3714t;
    private static float f3715u = 0.0f;
    private static float f3716v = 0.0f;
    int f3717a = f3707l.length;
    double f3718b = 0.0d;
    double f3719c = (((double) (this.f3717a - 5)) * f3700e);
    OnTouchListener f3720d = new C15561(this);
    private ArcMenuView f3721m = ((ArcMenuView) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.view_menu, this, true).getRootView());
    private ImageButton f3722w = ((ImageButton) this.f3721m.findViewById(R.id.menu_home));
    private double f3723x;
    private List<ImageButton> f3724y = new ArrayList();

    class C15561 implements OnTouchListener {
        int f3696a = -1;
        int f3697b = -1;
        double f3698c = 0.0d;
        final /* synthetic */ ArcMenuView f3699d;

        C15561(ArcMenuView arcMenuView) {
            this.f3699d = arcMenuView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            float y;
            float x = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (view instanceof ImageButton) {
                if (VERSION.SDK_INT >= 11) {
                    x += view.getX();
                    y = view.getY() + y2;
                } else {
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    x += (float) layoutParams.leftMargin;
                    y = ((float) layoutParams.topMargin) + y2;
                }
                if (this.f3696a != view.getId()) {
                    this.f3696a = view.getId();
                    this.f3697b = motionEvent.getAction();
                } else if (this.f3697b != 0) {
                    this.f3697b = motionEvent.getAction();
                } else if (motionEvent.getAction() == 1) {
                    view.performClick();
                    return false;
                } else if (motionEvent.getAction() != 2) {
                    this.f3697b = motionEvent.getAction();
                }
            } else {
                this.f3696a = -1;
                this.f3697b = -1;
                y = y2;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    view.setPressed(true);
                    this.f3699d.f3723x = this.f3699d.m5717a(x, y);
                    this.f3698c = this.f3699d.f3723x;
                    break;
                case 1:
                    view.setPressed(false);
                    break;
                case 2:
                    view.setPressed(true);
                    this.f3699d.m5722a(this.f3699d.m5717a(x, y));
                    if (this.f3697b == 0 && Math.abs(this.f3698c - this.f3699d.f3723x) > 0.03d) {
                        this.f3696a = -1;
                        this.f3697b = -1;
                        break;
                    }
                case 3:
                    view.setPressed(false);
                    break;
            }
            return true;
        }
    }

    public ArcMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3721m.setOnTouchListener(this.f3720d);
        m5721a();
    }

    private double m5717a(float f, float f2) {
        float f3 = f - f3715u;
        float f4 = f2 - f3716v;
        double atan2 = Math.atan2((double) f4, (double) f3);
        Math.toDegrees(Math.atan2((double) f4, (double) f3));
        return atan2;
    }

    private void m5721a() {
        int i;
        int i2;
        int i3;
        int i4 = 40;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        f3708n = displayMetrics.widthPixels;
        f3709o = displayMetrics.heightPixels;
        f3710p = displayMetrics.density;
        C1216a.m4522b("XY", " Display Density " + displayMetrics.density);
        C1216a.m4522b("XY", " Display DeviceWidth " + f3708n);
        float f = ((float) f3708n) / f3710p;
        C1216a.m4522b("ArcRadius", "widthdp" + f);
        int i5 = 62;
        int i6 = HttpResponseCode.MULTIPLE_CHOICES;
        if (f == 540.0f || ((double) f3710p) == 1.0d) {
            float f2 = f / 360.0f;
            i = (int) (((float) 52) * f2);
            i2 = (int) (((float) 52) * f2);
            i3 = (int) (((float) 40) * f2);
            i4 = (int) (((float) 40) * f2);
            i5 = (int) (((float) 62) * f2);
            i6 = (int) (((float) 300) * f2);
        } else {
            i2 = 52;
            i = 52;
            i3 = 40;
        }
        f3701f = i;
        f3702g = i2;
        f3703h = (float) i3;
        f3704i = (float) i4;
        f3705j = (float) i5;
        f3706k = i6;
        C1216a.m4522b("ArcRadius", "ArcRadius" + f3706k);
    }

    private void m5722a(double d) {
        this.f3718b -= d - this.f3723x;
        if (this.f3718b < 0.0d) {
            this.f3718b = 0.0d;
        }
        if (this.f3718b > this.f3719c) {
            this.f3718b = this.f3719c;
        }
        m5726c();
        this.f3723x = d;
    }

    private void m5723b() {
        f3714t = f3709o;
        f3715u = (float) (f3708n / 2);
        f3716v = f3711q + ((((float) f3702g) * f3710p) / 2.0f);
        C1216a.m4522b("XY", " yC " + f3716v);
        f3706k = (int) (f3705j * f3710p);
        f3712r = (int) (f3703h * f3710p);
        f3713s = (int) (f3704i * f3710p);
        C1216a.m4522b("XY", " Cx,Cy " + f3715u + "," + f3716v + "=" + (f3715u / 3.0f) + "," + (f3716v / 3.0f));
    }

    private void m5724b(OnClickListener onClickListener) {
        this.f3721m.setOnClickListener(onClickListener);
        for (int i = 0; i < this.f3717a; i++) {
            View imageButton = new ImageButton(getContext());
            imageButton.setBackgroundResource(f3707l[i]);
            imageButton.setVisibility(8);
            imageButton.setScaleType(ScaleType.FIT_XY);
            this.f3721m.addView(imageButton, new LayoutParams(f3712r, f3713s));
            this.f3724y.add(imageButton);
            imageButton.setOnTouchListener(this.f3720d);
            imageButton.setOnClickListener(onClickListener);
        }
    }

    private void m5726c() {
        int i = (int) (this.f3718b / f3700e);
        int i2 = 0;
        while (i2 < this.f3717a) {
            ImageButton imageButton = (ImageButton) this.f3724y.get(i2);
            imageButton.setTag(Integer.valueOf(i2));
            if (i2 < i || i2 > i + 5) {
                imageButton.setVisibility(8);
            } else {
                imageButton.setVisibility(0);
                double d = (((double) i2) * f3700e) - this.f3718b;
                float cos = ((float) (((double) f3715u) - (((double) f3706k) * Math.cos(d)))) - ((float) (f3712r / 2));
                float sin = ((float) (((double) f3716v) - (Math.sin(d) * ((double) f3706k)))) - ((float) (f3713s / 2));
                if (VERSION.SDK_INT >= 11) {
                    imageButton.setX(cos);
                    imageButton.setY(sin);
                } else {
                    LayoutParams layoutParams = (LayoutParams) imageButton.getLayoutParams();
                    layoutParams.leftMargin = (int) cos;
                    layoutParams.topMargin = (int) sin;
                }
            }
            i2++;
        }
    }

    public void m5727a(OnClickListener onClickListener) {
        m5723b();
        m5724b(onClickListener);
        m5726c();
    }

    public void setHomeClickListener(OnClickListener onClickListener) {
        this.f3722w.setOnClickListener(onClickListener);
    }

    public void setHomeTopMargin(int i) {
        LayoutParams layoutParams = (LayoutParams) this.f3722w.getLayoutParams();
        f3711q = (float) i;
        layoutParams.topMargin = (int) f3711q;
        layoutParams.bottomMargin = (int) f3711q;
        this.f3722w.setLayoutParams(layoutParams);
        C1216a.m4522b("XY", "view heightPixels " + getHeight());
    }
}
