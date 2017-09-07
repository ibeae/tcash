package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;

public final class bj extends FrameLayout implements OnClickListener {
    private final Activity f1035a;
    private final ImageButton f1036b;

    public bj(Activity activity, int i) {
        super(activity);
        this.f1035a = activity;
        setOnClickListener(this);
        this.f1036b = new ImageButton(activity);
        this.f1036b.setImageResource(17301527);
        this.f1036b.setBackgroundColor(0);
        this.f1036b.setOnClickListener(this);
        this.f1036b.setPadding(0, 0, 0, 0);
        int a = dp.m2103a((Context) activity, i);
        addView(this.f1036b, new LayoutParams(a, a, 17));
    }

    public void m1728a(boolean z) {
        this.f1036b.setVisibility(z ? 4 : 0);
    }

    public void onClick(View view) {
        this.f1035a.finish();
    }
}
