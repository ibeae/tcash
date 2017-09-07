package com.telkom.mwallet.dialog;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.google.p031b.C1016a;
import com.google.p031b.C1134f;
import com.google.p031b.C1202q;
import com.google.p031b.p034c.C1052b;
import com.google.p031b.p053h.C1188b;
import com.skcc.wallet.framework.C1302b;
import com.skcc.wallet.framework.api.C1225a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.TelkomApplication;
import com.telkom.mwallet.p064a.C1350d;
import java.util.EnumMap;
import java.util.Map;
import twitter4j.HttpResponseCode;

public class C1503a extends DialogFragment {
    private C1350d f3537a;
    private String f3538b;
    private String f3539c;

    class C14931 implements OnClickListener {
        final /* synthetic */ C1503a f3536a;

        C14931(C1503a c1503a) {
            this.f3536a = c1503a;
        }

        public void onClick(View view) {
            this.f3536a.dismiss();
        }
    }

    private void m5628a(ImageView imageView, String str) {
        int applyDimension = (int) TypedValue.applyDimension(1, (float) HttpResponseCode.OK, getResources().getDisplayMetrics());
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

    public void m5629a(String str) {
        this.f3538b = str;
    }

    public void m5630b(String str) {
        this.f3539c = str;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().requestFeature(1);
        this.f3537a = ((TelkomApplication) getActivity().getApplication()).m4899j();
        View inflate = layoutInflater.inflate(R.layout.dialog_card_redeem, viewGroup, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.cardQRcode);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.cardBarcode);
        View view = (Button) inflate.findViewById(R.id.notice_dialog_button_ok);
        if (this.f3539c == null || this.f3539c.length() < 1) {
            imageView.setVisibility(8);
            imageView2.setVisibility(8);
        } else if (this.f3538b.equals(getString(R.string.redeem_type_barcode))) {
            imageView2.setVisibility(0);
            imageView.setVisibility(8);
            new C1225a((C1302b) getActivity().getApplicationContext()).m4532a(imageView2, 230, 80, this.f3539c);
        } else if (this.f3538b.equals(getString(R.string.redeem_type_qrcode))) {
            imageView2.setVisibility(8);
            imageView.setVisibility(0);
            m5628a(imageView, this.f3539c);
        }
        view.setOnClickListener(new C14931(this));
        this.f3537a.m4932a(getActivity(), view, 3);
        return inflate;
    }
}
