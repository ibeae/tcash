package com.telkom.mwallet.coupon;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.ImageView;
import com.google.android.gms.common.C0663a;
import com.google.android.gms.common.C0665b.C0660b;
import com.google.android.gms.common.C0665b.C0664a;
import com.google.android.gms.location.C0854a;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.model.Coupon;
import com.skcc.wallet.framework.api.http.model.GetAllCouponListRs;
import com.skcc.wallet.framework.api.http.model.GetMyDownloadCouponRs;
import com.skcc.wallet.framework.p062d.C1318b;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1527g;
import com.telkom.mwallet.dialog.p063a.C1324e;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.p064a.C1358h.C1355a;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import twitter4j.MediaEntity.Size;

public class CouponListActivity extends SlidingFrameActivity {
    public static final String f3234k = CouponListActivity.class.getSimpleName();
    private C0854a f3235A;
    private List<Coupon> f3236B = null;
    private C1527g f3237C;
    private int f3238D = 100;
    private String f3239E = C1355a.f2919a;
    private String f3240F = "";
    private String f3241G = "";
    private C1457c f3242H;
    private C1324e f3243I = new C14241(this);
    private C0664a f3244J = new C14252(this);
    private C0660b f3245K = new C14263(this);
    private C1326f f3246L = new C14274(this);
    private C1326f f3247M = new C14285(this);
    private final int f3248l = 0;
    private final int f3249m = 10;
    private C1298u f3250n;
    private C1318b f3251o;
    private FragmentManager f3252z;

    class C14241 implements C1324e {
        final /* synthetic */ CouponListActivity f3229a;

        C14241(CouponListActivity couponListActivity) {
            this.f3229a = couponListActivity;
        }

        public void mo1483a(int i) {
        }

        public void mo1484a(String str) {
            if (this.f3229a.f3237C != null) {
                this.f3229a.f3237C.dismiss();
            }
            if ("Nearby".equals(str)) {
                this.f3229a.f3239E = C1355a.f2920b;
            } else if ("Latest".equals(str)) {
                this.f3229a.f3239E = C1355a.f2921c;
            }
            this.f3229a.m5392p();
        }
    }

    class C14252 implements C0664a {
        final /* synthetic */ CouponListActivity f3230a;

        C14252(CouponListActivity couponListActivity) {
            this.f3230a = couponListActivity;
        }

        public void mo951a(Bundle bundle) {
            if (this.f3230a.f3235A.m2807a() != null) {
                Location a = this.f3230a.f3235A.m2807a();
                double longitude = a.getLongitude();
                double latitude = a.getLatitude();
                this.f3230a.f3240F = String.valueOf(longitude);
                this.f3230a.f3241G = String.valueOf(latitude);
                C1216a.m4522b("Location", "Connected longitude: " + this.f3230a.f3240F);
                C1216a.m4522b("Location", "Connected latitude: " + this.f3230a.f3241G);
            } else {
                this.f3230a.f3239E = C1355a.f2919a;
                this.f3230a.h = this.f3230a.m4967a(this.f3230a.f3247M, (int) R.string.no_permission_gps);
            }
            this.f3230a.m5392p();
        }

        public void a_() {
            C1216a.m4522b("location", "Location onDisconnected");
        }
    }

    class C14263 implements C0660b {
        final /* synthetic */ CouponListActivity f3231a;

        C14263(CouponListActivity couponListActivity) {
            this.f3231a = couponListActivity;
        }

        public void mo952a(C0663a c0663a) {
            C1216a.m4522b("location", "Location onConnectionFailed" + c0663a);
        }
    }

    class C14274 implements C1326f {
        final /* synthetic */ CouponListActivity f3232a;

        C14274(CouponListActivity couponListActivity) {
            this.f3232a = couponListActivity;
        }

        public void mo1485a() {
            if (this.f3232a.h != null) {
                this.f3232a.h.dismiss();
            }
            this.f3232a.finish();
        }

        public void mo1486b() {
        }
    }

    class C14285 implements C1326f {
        final /* synthetic */ CouponListActivity f3233a;

        C14285(CouponListActivity couponListActivity) {
            this.f3233a = couponListActivity;
        }

        public void mo1485a() {
            if (this.f3233a.h != null) {
                this.f3233a.h.dismiss();
            }
            this.f3233a.m5392p();
        }

        public void mo1486b() {
        }
    }

    private void m5381q() {
        this.f3238D = Size.CROP;
        m4972a((Context) this, (int) R.string.loading);
        this.f3250n.m4722f(this);
    }

    public void mo1487a() {
        m4990k();
        this.h = m4967a(this.f3246L, (int) R.string.no_network);
    }

    void m5383a(int i) {
        this.f3238D = 100;
        String str = this.f3239E;
        String str2 = "10";
        if (C1355a.f2920b.equals(str)) {
            LocationManager locationManager = (LocationManager) getSystemService("location");
            boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
            boolean isProviderEnabled2 = locationManager.isProviderEnabled("network");
            if (!isProviderEnabled && !isProviderEnabled2) {
                startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 0);
                return;
            } else if (this.f3235A.m2810d()) {
                Location a = this.f3235A.m2807a();
                double longitude = a.getLongitude();
                double latitude = a.getLatitude();
                this.f3240F = String.valueOf(longitude);
                this.f3241G = String.valueOf(latitude);
            } else {
                this.f3235A.m2808b();
                return;
            }
        }
        m4972a((Context) this, (int) R.string.loading);
        this.f3250n.m4706b(str, Integer.toString(i + 1), str2, this.f3241G, this.f3240F, this);
    }

    public void mo1488a(String str) {
        m4972a((Context) this, (int) R.string.loading);
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f3246L, "" + str3);
    }

    public void m5386a(String str, ImageView imageView) {
        if (str.startsWith("http")) {
            this.f3251o.m4808a(str, imageView);
            return;
        }
        try {
            C1216a.m4522b("imagesub", "image:  ");
            imageView.setImageDrawable(Drawable.createFromStream(getAssets().open(str), null));
        } catch (IOException e) {
        }
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f3234k, "onSuccessNetwork");
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("getAllCouponList".equalsIgnoreCase(str)) {
            this.f3242H.m5524b(((GetAllCouponListRs) obj).getCouponList());
        } else if ("getMyDownloadCoupon".equalsIgnoreCase(str)) {
            this.f3242H.m5522a(((GetMyDownloadCouponRs) obj).getCouponDetailList());
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4967a(this.f3246L, (int) R.string.no_response);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    public void m5390e(String str) {
        this.f3239E = str;
    }

    void mo1505o() {
        this.f3242H.m5525d();
        m5381q();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 0:
                LocationManager locationManager = (LocationManager) getSystemService("location");
                boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
                boolean isProviderEnabled2 = locationManager.isProviderEnabled("network");
                if (!isProviderEnabled && !isProviderEnabled2) {
                    this.f3239E = C1355a.f2919a;
                    this.h = m4967a(this.f3247M, (int) R.string.no_permission_gps);
                    m5392p();
                    return;
                } else if (!this.f3235A.m2810d()) {
                    this.f3235A.m2808b();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void onBackPressed() {
        m5016B();
    }

    public void onCreate(Bundle bundle) {
        this.f3242H = new C1457c();
        super.m5019a(this.f3242H);
        super.onCreate(bundle);
        this.f3250n = this.a.m4739a();
        this.f3251o = new C1318b(this.a);
        this.f3252z = getSupportFragmentManager();
        this.f3236B = new ArrayList();
        this.f3237C = C1527g.m5667a((int) R.string.title_list_dialog);
        List arrayList = new ArrayList();
        arrayList.add(getString(R.string.list_dialog_coupon_item1));
        arrayList.add(getString(R.string.list_dialog_coupon_item2));
        this.f3237C.m5671a(arrayList);
        this.f3237C.m5670a(this.f3243I);
        this.f3235A = new C0854a(this, this.f3244J, this.f3245K);
        C1216a.m4522b("Location", "Location start ");
        this.f3238D = getIntent().getIntExtra("COUPON_LIST_MODE", 100);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.f3251o.m4809b();
        this.f3251o.m4807a();
        C1216a.m4519a(f3234k, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f3238D = intent.getIntExtra("COUPON_LIST_MODE", 100);
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f3234k, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f3234k, " in onResume >>>>>");
        if (this.f3238D == Size.CROP) {
            mo1505o();
        } else if (this.f3238D == 100) {
            if (C1355a.f2920b.equals(this.f3239E)) {
                this.f3235A.m2808b();
            }
            m5392p();
        }
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        if (this.f3235A != null && this.f3235A.m2810d()) {
            this.f3235A.m2809c();
        }
        super.onStop();
    }

    void m5392p() {
        this.f3242H.m5526e();
        m5383a(0);
    }
}
