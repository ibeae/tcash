package com.telkom.mwallet.slidingframe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.AppEventsConstants;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.OnClosedListener;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.OnOpenListener;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.OnOpenedListener;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.model.CountDownloadedCouponRs;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.TelkomApplication;
import com.telkom.mwallet.cards.CardAddListActivity;
import com.telkom.mwallet.cards.CardListActivity;
import com.telkom.mwallet.cards.CardTransactionHistoryActivity;
import com.telkom.mwallet.coupon.CouponListActivity;
import com.telkom.mwallet.home.C1385b;
import com.telkom.mwallet.home.C1559a;
import com.telkom.mwallet.home.C1562c;
import com.telkom.mwallet.home.C1566e;
import com.telkom.mwallet.p064a.C1358h;
import com.telkom.mwallet.tcash.TCashMapActivity;

public class SlidingFrameActivity extends C1359a {
    static boolean f2966w = false;
    static boolean f2967x = false;
    static boolean f2968y = false;
    private FragmentManager f2969k;
    private OnOpenListener f2970l = new C17125(this);
    private OnOpenListener f2971m = new C17136(this);
    private OnOpenedListener f2972n = new C17147(this);
    protected C1298u f2973p;
    C1726b f2974q;
    C1720a f2975r;
    boolean f2976s = false;
    SlidingMenu f2977t;
    C1385b f2978u = null;
    boolean f2979v = false;

    class C17081 implements OnClosedListener {
        final /* synthetic */ SlidingFrameActivity f4320a;

        C17081(SlidingFrameActivity slidingFrameActivity) {
            this.f4320a = slidingFrameActivity;
        }

        public void onClosed() {
            this.f4320a.f2977t.setSlidingEnabled(false);
        }
    }

    class C17092 implements OnClickListener {
        final /* synthetic */ SlidingFrameActivity f4321a;

        C17092(SlidingFrameActivity slidingFrameActivity) {
            this.f4321a = slidingFrameActivity;
        }

        public void onClick(View view) {
            this.f4321a.f2977t.showMenu();
        }
    }

    class C17103 implements OnClickListener {
        final /* synthetic */ SlidingFrameActivity f4322a;

        C17103(SlidingFrameActivity slidingFrameActivity) {
            this.f4322a = slidingFrameActivity;
        }

        public void onClick(View view) {
            Intent intent = new Intent(this.f4322a.getApplicationContext(), CouponListActivity.class);
            intent.setFlags(67108864);
            this.f4322a.startActivity(intent);
        }
    }

    class C17114 implements OnClickListener {
        final /* synthetic */ SlidingFrameActivity f4323a;

        C17114(SlidingFrameActivity slidingFrameActivity) {
            this.f4323a = slidingFrameActivity;
        }

        public void onClick(View view) {
            this.f4323a.startActivity(new Intent(this.f4323a.getApplicationContext(), CardAddListActivity.class));
        }
    }

    class C17125 implements OnOpenListener {
        final /* synthetic */ SlidingFrameActivity f4324a;

        C17125(SlidingFrameActivity slidingFrameActivity) {
            this.f4324a = slidingFrameActivity;
        }

        public void onOpen() {
            if (!SlidingFrameActivity.f2966w) {
                this.f4324a.f2974q.m6487f();
                SlidingFrameActivity.f2966w = true;
            }
            C1216a.m4519a("SlidingFrameActivity", "onOpen");
            this.f4324a.f2974q.m6485d();
        }
    }

    class C17136 implements OnOpenListener {
        final /* synthetic */ SlidingFrameActivity f4325a;

        C17136(SlidingFrameActivity slidingFrameActivity) {
            this.f4325a = slidingFrameActivity;
        }

        public void onOpen() {
            if (!SlidingFrameActivity.f2967x) {
                this.f4325a.f2975r.m6441g();
                SlidingFrameActivity.f2967x = true;
            }
            if (!SlidingFrameActivity.f2968y) {
                this.f4325a.f2975r.m6440f();
                SlidingFrameActivity.f2968y = true;
            }
            this.f4325a.f2975r.m6438d();
        }
    }

    class C17147 implements OnOpenedListener {
        final /* synthetic */ SlidingFrameActivity f4326a;

        C17147(SlidingFrameActivity slidingFrameActivity) {
            this.f4326a = slidingFrameActivity;
        }

        public void onOpened() {
            if (this.f4326a.f2977t.isSecondaryMenuShowing()) {
                if (!this.f4326a.b.m4652b("HELP_COUPON", false)) {
                    C1562c.m5762a(this.f4326a.b).show(this.f4326a.getSupportFragmentManager(), "helpCoupon");
                    this.f4326a.b.m4649a("HELP_COUPON", true);
                }
            } else if (this.f4326a.f2977t.isMenuShowing()) {
                if (this.f4326a.f2978u != null && (this.f4326a.f2978u.getActivity() instanceof TCashMapActivity)) {
                    this.f4326a.f2977t.setSlidingEnabled(true);
                } else if (this.f4326a.f2978u != null && (this.f4326a.f2978u.getActivity() instanceof CardListActivity)) {
                    this.f4326a.f2977t.setSlidingEnabled(true);
                }
                if (!this.f4326a.b.m4652b("HELP_NEVI", false)) {
                    C1566e.m5764a(this.f4326a.b).show(this.f4326a.getSupportFragmentManager(), "helpNevi");
                    this.f4326a.b.m4649a("HELP_NEVI", true);
                }
            }
        }
    }

    private int mo1505o() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        return (int) (((float) displayMetrics.widthPixels) - (displayMetrics.density * 300.0f));
    }

    public void m5015A() {
        C1216a.m4522b("load", "reloadMyCouponCount");
        if (this.f2973p == null) {
            this.f2973p = ((TelkomApplication) getApplication()).m4739a();
        }
    }

    protected void m5016B() {
        C1559a.m5752a().m5754b();
    }

    public void m5017C() {
        this.f2977t.showContent();
    }

    public String m5018a(int i, String... strArr) {
        if (strArr == null) {
            return "";
        }
        if (strArr.length == 3) {
            return String.format(getString(i), new Object[]{strArr[0], strArr[1], strArr[2]});
        } else if (strArr.length == 4) {
            return String.format(getString(i), new Object[]{strArr[0], strArr[1], strArr[2], strArr[3]});
        } else if (strArr.length != 5) {
            return "";
        } else {
            return String.format(getString(i), new Object[]{strArr[0], strArr[1], strArr[2], strArr[3], strArr[4]});
        }
    }

    public void m5019a(C1385b c1385b) {
        this.f2978u = c1385b;
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a("SlidingFrameActivity", "onSuccessNetwork");
        this.b.m4647a("time for update", System.currentTimeMillis());
        if ("countDownloadedCoupon".equalsIgnoreCase(str)) {
            CountDownloadedCouponRs countDownloadedCouponRs = (CountDownloadedCouponRs) obj;
            this.b.m4647a(C1358h.f2937h, System.currentTimeMillis());
            this.b.m4648a(C1358h.f2936g, countDownloadedCouponRs.getCount());
            m5026i(countDownloadedCouponRs.getCount());
        }
    }

    protected void m5021b(int i) {
        super.setContentView(i);
    }

    public void m5022c(int i) {
        getSupportActionBar().show();
        getSupportActionBar().setDisplayOptions(16);
        getSupportActionBar().setCustomView((int) R.layout.view_actionbar);
        ImageView imageView = (ImageView) findViewById(R.id.titlebar_title_imageview);
        imageView.setImageResource(i);
        imageView.setVisibility(0);
        ((TextView) findViewById(R.id.titlebar_title_textview)).setVisibility(8);
        m5028z();
    }

    public void m5023d(int i) {
        getSupportActionBar().show();
        getSupportActionBar().setDisplayOptions(16);
        getSupportActionBar().setCustomView((int) R.layout.view_actionbar);
        View view = (TextView) findViewById(R.id.titlebar_title_textview);
        String string = getString(i);
        if (string != null && string.length() > 25) {
            view.setTextSize(1, 18.0f);
        } else if (string != null && string.length() > 20) {
            view.setTextSize(1, 21.0f);
        }
        view.setText(i);
        m4982d().m4932a((Context) this, view, 1);
        m5028z();
    }

    public void m5024e(int i) {
        getSupportActionBar().show();
        getSupportActionBar().setDisplayOptions(16);
        getSupportActionBar().setCustomView((int) R.layout.view_actionbar);
        View view = (TextView) findViewById(R.id.titlebar_title_textview);
        view.setTextSize(1, 17.0f);
        view.setText(i);
        m4982d().m4932a((Context) this, view, 1);
        m5028z();
    }

    public FragmentManager getSupportFragmentManager() {
        if (this.f2969k == null) {
            this.f2969k = super.getSupportFragmentManager();
        }
        return this.f2969k;
    }

    public void m5025h(String str) {
        getSupportActionBar().show();
        getSupportActionBar().setDisplayOptions(16);
        getSupportActionBar().setCustomView((int) R.layout.view_actionbar);
        View view = (TextView) findViewById(R.id.titlebar_title_textview);
        view.setTextSize(1, 17.0f);
        view.setText(str);
        m4982d().m4932a((Context) this, view, 1);
        m5028z();
    }

    protected void m5026i(String str) {
        C1216a.m4522b("COUNT", "displayMyCouponCount count " + str);
        TextView textView = (TextView) findViewById(R.id.title_my_coupon_count);
        if (textView != null) {
            if (getClass().getSimpleName().equals(CardListActivity.f3024k) || getClass().getSimpleName().equals(CardTransactionHistoryActivity.f3045k)) {
                textView.setVisibility(8);
            } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(str);
            }
        }
    }

    public void onBackPressed() {
        if (this.f2978u != null) {
            this.f2978u.mo1550k();
        }
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f2978u != null) {
            TelkomApplication telkomApplication = (TelkomApplication) getApplication();
            this.f2973p = telkomApplication.m4739a();
            this.f2974q = new C1726b();
            this.f2977t = getSlidingMenu();
            this.f2977t.setMode(2);
            this.f2977t.setOnOpenListener(this.f2970l);
            this.f2977t.setOnOpenedListener(this.f2972n);
            setContentView(R.layout.frame_content);
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, this.f2978u).commit();
            setBehindContentView((int) R.layout.frame_menu_left);
            if (bundle == null) {
                FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
                beginTransaction.replace(R.id.menu_left, this.f2974q);
                beginTransaction.commit();
            } else {
                this.f2974q = (C1726b) getSupportFragmentManager().findFragmentById(R.id.menu_left);
            }
            this.f2977t.setShadowWidthRes(R.dimen.shadow_width);
            this.f2977t.setShadowDrawable((int) R.drawable.shadow);
            this.f2977t.setBehindOffset(mo1505o());
            this.f2977t.setFadeDegree(0.35f);
            this.f2977t.setTouchModeAbove(1);
            this.f2977t.setSecondaryMenu((int) R.layout.frame_menu_right);
            this.f2977t.setSecondaryShadowDrawable((int) R.drawable.shadowright);
            this.f2977t.setSecondaryOnOpenListner(this.f2971m);
            this.f2975r = new C1720a();
            getSupportFragmentManager().beginTransaction().replace(R.id.menu_right, this.f2975r).commit();
            if (this instanceof TCashMapActivity) {
                this.f2977t.setSlidingEnabled(false);
                this.f2977t.setOnClosedListener(new C17081(this));
            }
            this.f2973p = telkomApplication.m4739a();
        }
    }

    protected void onResume() {
        super.onResume();
        f2966w = false;
        f2967x = false;
        f2968y = false;
    }

    public C1298u m5027y() {
        return this.f2973p;
    }

    protected void m5028z() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.titlebar_menu_image_layout);
        if (this.f2978u == null) {
            relativeLayout.setVisibility(4);
        } else {
            relativeLayout.setOnClickListener(new C17092(this));
        }
        ImageView imageView = (ImageView) findViewById(R.id.titlebar_chat_imageview);
        if (this.f2978u == null) {
            imageView.setVisibility(4);
        } else if (!getClass().getSimpleName().equals(CouponListActivity.f3234k)) {
            imageView.setOnClickListener(new C17103(this));
        }
        ImageView imageView2 = (ImageView) findViewById(R.id.titlebar_add_imageview);
        if (getClass().getSimpleName().equals(CardListActivity.f3024k) || getClass().getSimpleName().equals(CardTransactionHistoryActivity.f3045k)) {
            imageView.setVisibility(8);
            imageView2.setVisibility(0);
            if (this.f2978u == null) {
                imageView2.setVisibility(4);
            } else {
                imageView2.setOnClickListener(new C17114(this));
            }
        }
    }
}
