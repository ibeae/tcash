package com.telkom.mwallet.tcash;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.gms.common.C0663a;
import com.google.android.gms.common.C0665b.C0660b;
import com.google.android.gms.common.C0665b.C0664a;
import com.google.android.gms.location.C0854a;
import com.google.android.gms.maps.C0942b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.C1245f;
import com.skcc.wallet.framework.api.http.model.GetGrafariLocationRs;
import com.skcc.wallet.framework.api.http.model.GetRetailStoreLocationRs;
import com.skcc.wallet.framework.api.http.model.Location;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import com.telkom.mwallet.tcash.fragment.C1795g;
import java.util.Iterator;

public class TCashMapActivity extends SlidingFrameActivity {
    private static final String f4406k = TCashMapActivity.class.getSimpleName();
    private C0664a f4407A = new C17352(this);
    private C0660b f4408B = new C17363(this);
    private C1326f f4409C = new C17374(this);
    private final int f4410l = 0;
    private String f4411m = null;
    private C1298u f4412n;
    private C0854a f4413o;
    private C1795g f4414z;

    class C17341 implements Runnable {
        final /* synthetic */ TCashMapActivity f4402a;

        C17341(TCashMapActivity tCashMapActivity) {
            this.f4402a = tCashMapActivity;
        }

        public void run() {
            this.f4402a.m6570o();
        }
    }

    class C17352 implements C0664a {
        final /* synthetic */ TCashMapActivity f4403a;

        C17352(TCashMapActivity tCashMapActivity) {
            this.f4403a = tCashMapActivity;
        }

        public void mo951a(Bundle bundle) {
            if (((LocationManager) this.f4403a.getSystemService("location")).isProviderEnabled("network")) {
                this.f4403a.m6570o();
            } else {
                this.f4403a.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 0);
            }
        }

        public void a_() {
            this.f4403a.m4990k();
        }
    }

    class C17363 implements C0660b {
        final /* synthetic */ TCashMapActivity f4404a;

        C17363(TCashMapActivity tCashMapActivity) {
            this.f4404a = tCashMapActivity;
        }

        public void mo952a(C0663a c0663a) {
            this.f4404a.m4990k();
            this.f4404a.h = this.f4404a.m4969a(this.f4404a.f4409C, c0663a.toString());
        }
    }

    class C17374 implements C1326f {
        final /* synthetic */ TCashMapActivity f4405a;

        C17374(TCashMapActivity tCashMapActivity) {
            this.f4405a = tCashMapActivity;
        }

        public void mo1485a() {
            if (this.f4405a.h != null) {
                this.f4405a.h.dismiss();
            }
            this.f4405a.finish();
        }

        public void mo1486b() {
        }
    }

    private void m6570o() {
        m4972a((Context) this, (int) R.string.loading);
        if (this.f4413o.m2807a() == null) {
            new Handler().postDelayed(new C17341(this), 1000);
            return;
        }
        LatLng latLng = new LatLng(this.f4413o.m2807a().getLatitude(), this.f4413o.m2807a().getLongitude());
        if (this.f4411m == null || "".equals(this.f4411m)) {
            m4990k();
        } else if ("MAP_MENU_RETAIL_STORE".equals(this.f4411m)) {
            this.f4412n.m4668a(latLng.f1917a, latLng.f1918b, (C1245f) this);
        } else {
            this.f4412n.m4697b(latLng.f1917a, latLng.f1918b, (C1245f) this);
        }
        this.f4414z.m6886a(C0942b.m3226a(latLng, 14.0f));
    }

    public void mo1487a() {
        m4990k();
        this.h = m4967a(this.f4409C, (int) R.string.no_network);
    }

    public void mo1488a(String str) {
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f4409C, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f4406k, "onSuccessNetwork");
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        Iterator it;
        Location location;
        if ("getRetailStoreLocation".equalsIgnoreCase(str)) {
            it = ((GetRetailStoreLocationRs) obj).getLocations().iterator();
            while (it.hasNext()) {
                location = (Location) it.next();
                this.f4414z.m6887a(new MarkerOptions().m3288a(new LatLng(location.getLatitude(), location.getLongitude())));
            }
        } else if ("getGrafariLocation".equalsIgnoreCase(str)) {
            it = ((GetGrafariLocationRs) obj).getLocations().iterator();
            while (it.hasNext()) {
                location = (Location) it.next();
                this.f4414z.m6887a(new MarkerOptions().m3288a(new LatLng(location.getLatitude(), location.getLongitude())));
            }
        }
    }

    public void mo1491b() {
        m4990k();
        this.h = m4967a(this.f4409C, (int) R.string.no_response);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 0:
                if (((LocationManager) getSystemService("location")).isProviderEnabled("network")) {
                    this.f4413o.m2808b();
                    return;
                } else {
                    this.h = m4967a(this.f4409C, (int) R.string.msg_no_location_service);
                    return;
                }
            default:
                return;
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        m4990k();
    }

    public void onCreate(Bundle bundle) {
        this.f4414z = new C1795g();
        super.m5019a(this.f4414z);
        super.onCreate(bundle);
        this.f4412n = this.a.m4739a();
        this.f4411m = getIntent().getStringExtra("MAP_TYPE");
        this.f4413o = new C0854a(this, this.f4407A, this.f4408B);
        this.f4413o.m2808b();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.f4413o.m2809c();
        if (this.h != null) {
            this.h.dismiss();
        }
        C1216a.m4519a(f4406k, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f4406k, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f4406k, " in onResume >>>>>");
    }
}
