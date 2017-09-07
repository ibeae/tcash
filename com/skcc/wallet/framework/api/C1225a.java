package com.skcc.wallet.framework.api;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.TypedValue;
import android.widget.ImageView;
import com.google.p031b.C1016a;
import com.google.p031b.p034c.C1052b;
import com.google.p031b.p045f.C1119c;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.C1302b;
import twitter4j.HttpResponseCode;

public class C1225a {
    private C1302b f2612a;

    public C1225a(C1302b c1302b) {
        this.f2612a = c1302b;
    }

    public void m4532a(ImageView imageView, int i, int i2, String str) {
        try {
            C1052b a = new C1119c().m4114a(str, C1016a.CODE_128, (int) TypedValue.applyDimension(1, (float) i, this.f2612a.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, (float) i2, this.f2612a.getResources().getDisplayMetrics()));
            int d = a.m3855d();
            int e = a.m3856e();
            C1216a.m4519a("gg", "barcode image -> width:" + d + ", height:" + e + ", getTopLeftOnBit:" + a.m3852b()[0]);
            int[] iArr = new int[(d * e)];
            for (int i3 = 0; i3 < e; i3++) {
                int i4 = i3 * d;
                for (int i5 = 0; i5 < d; i5++) {
                    iArr[i4 + i5] = a.m3848a(i5, i3) ? -16777216 : -1;
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(d, e, Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, d, 0, 0, d, e);
            imageView.setImageBitmap(createBitmap);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void m4533a(ImageView imageView, String str) {
        try {
            C1052b a = new C1119c().m4114a(str, C1016a.CODE_128, (int) HttpResponseCode.INTERNAL_SERVER_ERROR, (int) HttpResponseCode.OK);
            int d = a.m3855d();
            int e = a.m3856e();
            C1216a.m4519a("gg", "barcode image -> width:" + d + ", height:" + e + ", getTopLeftOnBit:" + a.m3852b()[0]);
            int[] iArr = new int[(d * e)];
            for (int i = 0; i < e; i++) {
                int i2 = i * d;
                for (int i3 = 0; i3 < d; i3++) {
                    iArr[i2 + i3] = a.m3848a(i3, i) ? -16777216 : -1;
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(d, e, Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, d, 0, 0, d, e);
            imageView.setImageBitmap(createBitmap);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
