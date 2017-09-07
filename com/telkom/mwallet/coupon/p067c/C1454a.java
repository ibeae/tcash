package com.telkom.mwallet.coupon.p067c;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.google.p031b.C1199m;
import com.google.p031b.p036b.p037a.C1019q;
import com.google.p031b.p036b.p037a.C1035r;
import com.skcc.wallet.core.p057a.C1216a;
import com.telkom.mwallet.R;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public abstract class C1454a {
    private static final String f3380a = C1454a.class.getSimpleName();
    private static final DateFormat f3381b = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
    private static final DateFormat f3382c = new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH);
    private static final String[] f3383d = new String[]{"home", "work", "mobile"};
    private static final String[] f3384e = new String[]{"home", "work", "mobile", "fax", "pager", "main"};
    private static final String[] f3385f = new String[]{"home", "work"};
    private static final int[] f3386g = new int[]{1, 2, 4};
    private static final int[] f3387h = new int[]{1, 3, 2, 4, 6, 12};
    private static final int[] f3388i = new int[]{1, 2};
    private final C1019q f3389j;
    private final Activity f3390k;
    private final C1199m f3391l;
    private final String f3392m;
    private final OnClickListener f3393n = new C14531(this);

    class C14531 implements OnClickListener {
        final /* synthetic */ C1454a f3379a;

        C14531(C1454a c1454a) {
            this.f3379a = c1454a;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f3379a.m5494a(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.android.apps.shopper&referrer=utm_source%3Dbarcodescanner%26utm_medium%3Dapps%26utm_campaign%3Dscan")));
        }
    }

    static {
        f3381b.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

    C1454a(Activity activity, C1019q c1019q, C1199m c1199m) {
        this.f3389j = c1019q;
        this.f3390k = activity;
        this.f3391l = c1199m;
        this.f3392m = "";
    }

    public C1019q m5492a() {
        return this.f3389j;
    }

    public abstract void mo1525a(int i);

    void m5494a(Intent intent) {
        if (intent != null) {
            intent.addFlags(524288);
            C1216a.m4519a(f3380a, "Launching intent: " + intent + " with extras: " + intent.getExtras());
            try {
                this.f3390k.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Builder builder = new Builder(m5495b(), 3);
                builder.setTitle(R.string.app_name_tel);
                builder.setMessage(R.string.msg_intent_failed);
                builder.setPositiveButton(R.string.btn_ok, null);
                builder.show();
            }
        }
    }

    Activity m5495b() {
        return this.f3390k;
    }

    public abstract int mo1526c();

    public CharSequence m5497d() {
        return this.f3389j.mo1417a().replace("\r", "");
    }

    public final C1035r m5498e() {
        return this.f3389j.m3709b();
    }
}
