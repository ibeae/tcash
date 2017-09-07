package com.google.android.gms.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.C0839s;

public final class AdView extends ViewGroup {
    private final C0839s f825a = new C0839s(this);

    public AdView(Context context) {
        super(context);
    }

    public void m1401a() {
        this.f825a.m2772a();
    }

    public void m1402a(AdRequest adRequest) {
        this.f825a.m2775a(adRequest.m1396a());
    }

    public void m1403b() {
        this.f825a.m2783f();
    }

    public void m1404c() {
        this.f825a.m2784g();
    }

    public AdListener getAdListener() {
        return this.f825a.m2778b();
    }

    public AdSize getAdSize() {
        return this.f825a.m2780c();
    }

    public String getAdUnitId() {
        return this.f825a.m2781d();
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.f825a.m2782e();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = ((i3 - i) - measuredWidth) / 2;
            int i6 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
        }
    }

    protected void onMeasure(int i, int i2) {
        int measuredWidth;
        int i3 = 0;
        View childAt = getChildAt(0);
        AdSize adSize = getAdSize();
        if (childAt != null && childAt.getVisibility() != 8) {
            measureChild(childAt, i, i2);
            measuredWidth = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        } else if (adSize != null) {
            Context context = getContext();
            measuredWidth = adSize.m1400b(context);
            i3 = adSize.m1398a(context);
        } else {
            measuredWidth = 0;
        }
        setMeasuredDimension(View.resolveSize(Math.max(measuredWidth, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }

    public void setAdListener(AdListener adListener) {
        this.f825a.m2773a(adListener);
    }

    public void setAdSize(AdSize adSize) {
        this.f825a.m2777a(adSize);
    }

    public void setAdUnitId(String str) {
        this.f825a.m2776a(str);
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        this.f825a.m2774a(inAppPurchaseListener);
    }
}
