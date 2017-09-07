package com.telkom.mwallet.tcash.fragment;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.widget.PlacePickerFragment;
import com.google.p031b.C1016a;
import com.google.p031b.C1134f;
import com.google.p031b.C1202q;
import com.google.p031b.p034c.C1052b;
import com.google.p031b.p053h.C1188b;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.C1302b;
import com.skcc.wallet.framework.api.C1225a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import com.telkom.mwallet.tcash.TCashActivity;
import java.util.EnumMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class C1803j extends C1761d {
    private static final String f4742c = C1803j.class.getSimpleName();
    Timer f4743a = null;
    TimerTask f4744b = null;
    private LinearLayout f4745d;
    private Button f4746e;
    private ImageView f4747f;
    private ImageView f4748g;
    private TextView f4749h;
    private TextView f4750i;
    private TextView f4751j;
    private EditText f4752k;
    private EditText f4753l;
    private SlidingFrameActivity f4754m;
    private String f4755n;
    private long f4756o;
    private long f4757p;
    private int f4758q;
    private boolean f4759r = false;
    private OnClickListener f4760s = new C18022(this);

    class C18011 extends TimerTask {
        final /* synthetic */ C1803j f4740a;

        class C18001 implements Runnable {
            final /* synthetic */ C18011 f4739a;

            C18001(C18011 c18011) {
                this.f4739a = c18011;
            }

            public void run() {
                this.f4739a.f4740a.m6913c();
            }
        }

        C18011(C1803j c1803j) {
            this.f4740a = c1803j;
        }

        public void run() {
            this.f4740a.f4754m.runOnUiThread(new C18001(this));
        }
    }

    class C18022 implements OnClickListener {
        final /* synthetic */ C1803j f4741a;

        C18022(C1803j c1803j) {
            this.f4741a = c1803j;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_retail_token_close_button:
                    if (this.f4741a.f4759r) {
                        this.f4741a.dismiss();
                        ((TCashActivity) this.f4741a.getActivity()).finish();
                        return;
                    }
                    this.f4741a.dismiss();
                    return;
                default:
                    return;
            }
        }
    }

    private void m6911b() {
        int applyDimension = (int) TypedValue.applyDimension(1, (float) 120, getResources().getDisplayMetrics());
        try {
            C1188b c1188b = new C1188b();
            Map enumMap = new EnumMap(C1134f.class);
            enumMap.put(C1134f.CHARACTER_SET, "UTF-8");
            C1052b a = c1188b.m4435a(this.f4755n, C1016a.QR_CODE, applyDimension, applyDimension, enumMap);
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
            this.f4747f.setImageBitmap(createBitmap);
        } catch (C1202q e2) {
            e2.printStackTrace();
        }
    }

    private void m6912b(View view) {
        this.f4745d = (LinearLayout) view.findViewById(R.id.tcash_retail_token_layout);
        this.f4746e = (Button) view.findViewById(R.id.tcash_retail_token_close_button);
        this.f4747f = (ImageView) view.findViewById(R.id.token_qrcode_imageview);
        this.f4748g = (ImageView) view.findViewById(R.id.token_barcode_imageview);
        this.f4749h = (TextView) view.findViewById(R.id.tcash_retail_token1_edittext);
        this.f4750i = (TextView) view.findViewById(R.id.tcash_retail_token2_edittext);
        this.f4751j = (TextView) view.findViewById(R.id.tcash_retail_token3_edittext);
        this.f4752k = (EditText) view.findViewById(R.id.tcash_retail_token_remain_time1_edittext);
        this.f4753l = (EditText) view.findViewById(R.id.tcash_retail_token_remain_time2_edittext);
        TextView textView = (TextView) view.findViewById(R.id.tcash_retail_token_expired_textview);
        textView = (TextView) view.findViewById(R.id.tcash_retail_token_min_textview);
        this.f4746e.setOnClickListener(this.f4760s);
        m6920b(this.f4755n);
        m6911b();
        new C1225a((C1302b) getActivity().getApplicationContext()).m4532a(this.f4748g, 169, 55, this.f4755n);
        LayoutParams layoutParams = (LayoutParams) this.f4745d.getLayoutParams();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams.width = displayMetrics.widthPixels;
        this.f4745d.setLayoutParams(layoutParams);
        m6761a((ViewGroup) view);
        m6763a((TextView) view.findViewById(R.id.sub_menu_title_textview));
    }

    private void m6913c() {
        this.f4758q = (int) (((this.f4757p - System.currentTimeMillis()) / 1000) / 60);
        int i = this.f4758q % 10;
        this.f4752k.setText("" + ((this.f4758q - i) / 10));
        this.f4753l.setText("" + i);
        m6916e();
        m6915d();
    }

    private void m6915d() {
        long currentTimeMillis = this.f4757p - System.currentTimeMillis();
        if (currentTimeMillis < 0) {
            dismiss();
            return;
        }
        long j = (currentTimeMillis - ((long) ((this.f4758q * 60) * PlacePickerFragment.DEFAULT_RADIUS_IN_METERS))) + 10;
        if (this.f4758q == 0) {
            j = (currentTimeMillis - ((long) ((this.f4758q * 60) * PlacePickerFragment.DEFAULT_RADIUS_IN_METERS))) - 1000;
        }
        C1216a.m4522b("remain", "rtu " + j);
        this.f4744b = new C18011(this);
        this.f4743a = new Timer();
        if (j > 0) {
            this.f4743a.schedule(this.f4744b, j);
        } else {
            this.f4743a.schedule(this.f4744b, 10);
        }
    }

    private void m6916e() {
        if (this.f4744b != null) {
            this.f4744b.cancel();
            this.f4744b = null;
            this.f4743a.cancel();
            this.f4743a = null;
        }
    }

    public void m6917a(long j) {
        this.f4756o = j;
        this.f4757p = (1800000 + j) + 1000;
    }

    public void m6918a(String str) {
        this.f4755n = str;
    }

    public void m6919a(boolean z) {
        this.f4759r = z;
    }

    public void m6920b(String str) {
        if (str.length() >= 10) {
            Object substring = str.substring(0, 4);
            Object substring2 = str.substring(4, 7);
            CharSequence substring3 = str.substring(7, 10);
            C1216a.m4519a("token1", substring);
            this.f4749h.setText(substring);
            this.f4750i.setText(substring2);
            this.f4751j.setText(substring3);
            this.f4749h.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Medium.ttf"));
            C1216a.m4519a("token1 = " + substring, substring2);
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.f4759r) {
            dismiss();
            ((TCashActivity) getActivity()).finish();
            return;
        }
        dismiss();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setGravity(81);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.dialog_animation;
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_retail_token, viewGroup, false);
        this.f4754m = (SlidingFrameActivity) getActivity();
        m6912b(inflate);
        m6913c();
        m6915d();
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
        m6916e();
    }
}
