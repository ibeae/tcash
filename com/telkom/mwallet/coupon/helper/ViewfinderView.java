package com.telkom.mwallet.coupon.helper;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.google.p031b.C1178o;
import com.telkom.mwallet.R;
import com.telkom.mwallet.coupon.p065a.C1437c;
import java.util.Collection;
import java.util.HashSet;

public final class ViewfinderView extends View {
    private static final int[] f3480a = new int[]{0, 64, 128, 192, 255, 192, 128, 64};
    private final Paint f3481b = new Paint();
    private Bitmap f3482c;
    private Bitmap f3483d;
    private final int f3484e;
    private final int f3485f;
    private int f3486g;
    private Collection<C1178o> f3487h;
    private Collection<C1178o> f3488i;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = getResources();
        this.f3484e = resources.getColor(R.color.viewfinder_laser);
        this.f3485f = resources.getColor(R.color.possible_result_points);
        this.f3486g = 0;
        this.f3487h = new HashSet(5);
    }

    private void m5584a(Canvas canvas, Rect rect, Bitmap bitmap) {
        Rect rect2 = new Rect();
        rect2.left = (rect.left + ((rect.width() - bitmap.getWidth()) / 2)) + 4;
        rect2.top = (rect.top + ((rect.height() - bitmap.getHeight()) / 2)) + 4;
        rect2.right = (rect2.left + bitmap.getWidth()) - 4;
        rect2.bottom = (rect2.top + bitmap.getHeight()) - 4;
        canvas.drawBitmap(bitmap, (float) rect2.left, (float) rect2.top, this.f3481b);
    }

    public void m5585a() {
        this.f3482c = null;
        invalidate();
    }

    public void m5586a(C1178o c1178o) {
        this.f3487h.add(c1178o);
    }

    public void onDraw(Canvas canvas) {
        Rect e = C1437c.m5428a().m5437e();
        Rect f = C1437c.m5428a().m5438f();
        if (e != null && f != null) {
            if (this.f3483d != null) {
                m5584a(canvas, e, this.f3483d);
            }
            if (this.f3482c != null) {
                this.f3481b.setAlpha(255);
                canvas.drawBitmap(this.f3482c, (float) e.left, (float) e.top, this.f3481b);
                return;
            }
            Collection collection = this.f3487h;
            Collection collection2 = this.f3488i;
            if (collection.isEmpty()) {
                this.f3488i = null;
            } else {
                this.f3487h = new HashSet(5);
                this.f3488i = collection;
                this.f3481b.setAlpha(255);
                this.f3481b.setColor(this.f3485f);
            }
            if (collection2 != null) {
                this.f3481b.setAlpha(127);
                this.f3481b.setColor(this.f3485f);
            }
            postInvalidateDelayed(100, e.left, e.top, e.right, e.bottom);
        }
    }
}
