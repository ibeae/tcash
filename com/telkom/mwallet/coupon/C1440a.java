package com.telkom.mwallet.coupon;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.p031b.C1016a;
import com.google.p031b.C1134f;
import com.google.p031b.C1202q;
import com.google.p031b.p034c.C1052b;
import com.google.p031b.p053h.C1188b;
import com.skcc.wallet.framework.C1302b;
import com.skcc.wallet.framework.api.C1225a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.tcash.fragment.C1386e;
import java.util.EnumMap;
import java.util.Map;

@SuppressLint({"ParserError", "ParserError"})
public class C1440a extends C1386e {
    private static final String f3310c = C1440a.class.getSimpleName();
    ImageView f3311a;
    ImageView f3312b;
    private C1225a f3313j;
    private Button f3314k;
    private CouponBarcodeActivity f3315l;
    private String f3316m;
    private String f3317n;
    private OnClickListener f3318o = new C14341(this);

    class C14341 implements OnClickListener {
        final /* synthetic */ C1440a f3278a;

        C14341(C1440a c1440a) {
            this.f3278a = c1440a;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.coupon_redeem_topin_button:
                    this.f3278a.startActivity(new Intent(this.f3278a.f3315l, CouponRedeemPINActivity.class));
                    this.f3278a.f3315l.finish();
                    return;
                default:
                    return;
            }
        }
    }

    private void m5448a(ImageView imageView, String str) {
        int applyDimension = (int) TypedValue.applyDimension(1, (float) 280, getResources().getDisplayMetrics());
        try {
            C1188b c1188b = new C1188b();
            Map enumMap = new EnumMap(C1134f.class);
            enumMap.put(C1134f.CHARACTER_SET, "UTF-8");
            C1052b a = c1188b.m4435a(str, C1016a.QR_CODE, applyDimension, applyDimension, enumMap);
            applyDimension = a.m3855d();
            int e = a.m3856e();
            int[] iArr = new int[(applyDimension * e)];
            for (int i = 0; i < e; i++) {
                int i2 = i * applyDimension;
                for (int i3 = 0; i3 < applyDimension; i3++) {
                    iArr[i2 + i3] = a.m3848a(i3, i) ? -16777216 : -1;
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(applyDimension, e, Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, applyDimension, 0, 0, applyDimension, e);
            imageView.setImageBitmap(createBitmap);
        } catch (C1202q e2) {
            e2.printStackTrace();
        }
    }

    public void m5449a(String str, String str2) {
        if (this.f3312b == null) {
            this.f3316m = str;
            this.f3317n = str2;
        } else if (str2 == null || str2.length() < 1) {
            this.f3312b.setVisibility(8);
            this.f3311a.setVisibility(8);
        } else if (str.equals("barcode")) {
            this.f3312b.setVisibility(0);
            this.f3311a.setVisibility(8);
            this.f3313j = new C1225a((C1302b) this.f3315l.getApplicationContext());
            this.f3313j.m4533a(this.f3312b, str2);
        } else if (str.equals("qrcode")) {
            this.f3312b.setVisibility(8);
            this.f3311a.setVisibility(0);
            m5448a(this.f3311a, str2);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.coupon_act_detail, null);
        m5208c(R.string.title_couponlist);
        this.f3315l = (CouponBarcodeActivity) getActivity();
        this.f3311a = (ImageView) inflate.findViewById(R.id.couponQRcode);
        this.f3312b = (ImageView) inflate.findViewById(R.id.couponBarcode);
        String stringExtra = this.f3315l.getIntent().getStringExtra("PIN_REDEEM");
        this.f3314k = (Button) inflate.findViewById(R.id.coupon_redeem_topin_button);
        View view = (TextView) inflate.findViewById(R.id.coupon_redeem_topin_text);
        if ("N".equalsIgnoreCase(stringExtra)) {
            this.f3314k.setVisibility(8);
            view.setVisibility(8);
        } else {
            this.f3314k.setOnClickListener(this.f3318o);
        }
        if (this.f3316m != null) {
            m5449a(this.f3316m, this.f3317n);
        }
        this.h.m4932a(this.f3315l, (TextView) inflate.findViewById(R.id.coupon_code_text), 2);
        this.h.m4932a(this.f3315l, this.f3314k, 2);
        this.h.m4932a(this.f3315l, view, 2);
        return inflate;
    }
}
