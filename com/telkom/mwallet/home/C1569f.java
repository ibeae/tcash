package com.telkom.mwallet.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.skcc.wallet.core.p057a.C1216a;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.coupon.CouponListActivity;
import com.telkom.mwallet.coupon.CouponRedeemQRActivity;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.p064a.C1358h;
import com.telkom.mwallet.tcash.TCashActivity;
import com.telkom.mwallet.tcash.TCashAirtimeActivity;
import com.telkom.mwallet.tcash.TCashTransactionHistoryActivity;
import com.telkom.mwallet.tcash.TCashTransferActivity;
import com.telkom.mwallet.tcash.payment.TCashKartuHaloActivity;
import com.telkom.mwallet.tcash.payment.TCashPDAMActivity;
import com.telkom.mwallet.tcash.payment.TCashPLNActivity;
import com.telkom.mwallet.view.C2009a;

public class C1569f extends C1385b {
    static final String f3759a = C1569f.class.getSimpleName();
    private TextView f3760b;
    private Button f3761c;
    private ImageButton f3762j;
    private RelativeLayout f3763k;
    private ScrollView f3764l;
    private C2009a f3765m;
    private String f3766n = null;
    private int f3767o;
    private C1572g f3768p;
    private HomeActivity f3769q;
    private String f3770r;
    private OnClickListener f3771s = new C15682(this);

    class C15671 implements OnGlobalLayoutListener {
        final /* synthetic */ C1569f f3757a;

        C15671(C1569f c1569f) {
            this.f3757a = c1569f;
        }

        public void onGlobalLayout() {
            this.f3757a.f3767o = (this.f3757a.f3764l.getChildAt(0).getHeight() + this.f3757a.m5775e()) + this.f3757a.m5774d();
        }
    }

    class C15682 implements OnClickListener {
        final /* synthetic */ C1569f f3758a;

        C15682(C1569f c1569f) {
            this.f3758a = c1569f;
        }

        public void onClick(View view) {
            Intent intent;
            switch (view.getId()) {
                case R.id.home_add_card:
                    this.f3758a.m5213f(R.string.under_construction);
                    return;
                case R.id.home_button:
                    ((HomeActivity) this.f3758a.getActivity()).m5750q();
                    if (!this.f3758a.f3768p.isVisible()) {
                        int scrollY = this.f3758a.f3764l.getScrollY();
                        int e = (this.f3758a.m5775e() + this.f3758a.m5774d()) - scrollY;
                        boolean b = this.f3758a.g.m4652b("HELP_HOME_MENUHELP_HOME_MENU", false);
                        this.f3758a.f3768p.m5778a(this.f3758a.m5215l(), e, scrollY, this.f3758a.f3767o, b);
                        if (!b) {
                            this.f3758a.g.m4649a("HELP_HOME_MENUHELP_HOME_MENU", true);
                            return;
                        }
                        return;
                    }
                    return;
                case R.id.home_coupon_button:
                    this.f3758a.startActivity(new Intent(this.f3758a.getActivity(), CouponListActivity.class));
                    return;
                case R.id.home_tcash_button:
                    this.f3758a.startActivity(new Intent(this.f3758a.getActivity(), TCashActivity.class));
                    return;
                case R.id.home_cash_in:
                    intent = new Intent(this.f3758a.getActivity(), TCashActivity.class);
                    intent.putExtra("CALL_MENU", "TCASH_CASHIN");
                    this.f3758a.startActivity(intent);
                    return;
                case R.id.home_menu_topup:
                    this.f3758a.startActivity(new Intent(this.f3758a.e, TCashAirtimeActivity.class));
                    return;
                case R.id.home_menu_halo:
                    this.f3758a.startActivity(new Intent(this.f3758a.e, TCashKartuHaloActivity.class));
                    return;
                case R.id.home_menu_pln:
                    this.f3758a.startActivity(new Intent(this.f3758a.e, TCashPLNActivity.class));
                    return;
                case R.id.home_menu_water:
                    this.f3758a.startActivity(new Intent(this.f3758a.e, TCashPDAMActivity.class));
                    return;
                case R.id.home_menu_internet:
                    intent = new Intent(this.f3758a.e, TCashActivity.class);
                    intent.putExtra("CALL_MENU", "TCASH_INTERNET");
                    intent.setFlags(536870912);
                    this.f3758a.startActivity(intent);
                    return;
                case R.id.home_menu_pay:
                    intent = new Intent(this.f3758a.e, TCashActivity.class);
                    intent.putExtra("CALL_MENU", "TCASH_PAYMENT");
                    intent.setFlags(536870912);
                    this.f3758a.startActivity(intent);
                    return;
                case R.id.home_menu_share:
                    if (C1358h.f2933d.equalsIgnoreCase(this.f3758a.f3770r)) {
                        this.f3758a.startActivity(new Intent(this.f3758a.e, TCashTransferActivity.class));
                        return;
                    }
                    this.f3758a.m5213f(R.string.tcash_grade_info);
                    return;
                case R.id.home_menu_scan:
                    intent = new Intent(this.f3758a.e, CouponRedeemQRActivity.class);
                    intent.putExtra("CALL_MENU", "TCASH_PAYMENT");
                    this.f3758a.startActivity(intent);
                    return;
                case R.id.home_menu_token:
                    intent = new Intent(this.f3758a.e, TCashActivity.class);
                    intent.putExtra("CALL_MENU", "TCASH_TOKEN");
                    intent.setFlags(536870912);
                    this.f3758a.startActivity(intent);
                    return;
                case R.id.home_menu_history:
                    this.f3758a.startActivity(new Intent(this.f3758a.e, TCashTransactionHistoryActivity.class));
                    return;
                default:
                    return;
            }
        }
    }

    private void m5770f() {
        this.f3763k.removeAllViews();
        this.f3765m = new C2009a(getActivity());
        View c2009a = new C2009a(getActivity());
        c2009a.setTCashBalance(5000000.0f);
        c2009a.setIsShadow(true);
        this.f3763k.addView(c2009a);
        this.f3763k.addView(this.f3765m);
        if (this.f3766n != null) {
            m5772b(this.f3766n);
        }
    }

    private void m5771g() {
        if (!this.g.m4652b("HELP_HOME", false)) {
            C1564d.m5763a(this.g, this.f3767o).show(m5215l(), "helpHome");
            this.g.m4649a("HELP_HOME", true);
        }
    }

    public void m5772b(String str) {
        this.f3766n = str;
        if (this.f3760b != null && this.f3765m != null) {
            this.f3765m.setTCashBalance(str);
            this.f3760b.setText(C1354g.m4955f(str));
            if (this.e != null && this.f3760b != null) {
                this.h.m4932a(this.e, this.f3760b, 3);
            }
        }
    }

    public void m5773c(String str) {
        this.f3770r = str;
    }

    public int m5774d() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        return identifier > 0 ? getResources().getDimensionPixelSize(identifier) : 0;
    }

    public int m5775e() {
        TypedValue typedValue = new TypedValue();
        return getActivity().getTheme().resolveAttribute(16843499, typedValue, true) ? TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics()) : 50;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_home, null);
        m5211e((int) R.drawable.logo_tcash);
        this.f3760b = (TextView) inflate.findViewById(R.id.tcash_balance);
        this.f3761c = (Button) inflate.findViewById(R.id.home_cash_in);
        this.f3762j = (ImageButton) inflate.findViewById(R.id.home_tcash_button);
        this.f3763k = (RelativeLayout) inflate.findViewById(R.id.home_tcash_progress);
        this.f3764l = (ScrollView) inflate.findViewById(R.id.scroll_frame);
        this.f3762j.setOnClickListener(this.f3771s);
        this.f3761c.setOnClickListener(this.f3771s);
        this.f3769q = (HomeActivity) getActivity();
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.home_menu_halo);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.home_menu_pln);
        LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.home_menu_water);
        LinearLayout linearLayout4 = (LinearLayout) inflate.findViewById(R.id.home_menu_internet);
        ((LinearLayout) inflate.findViewById(R.id.home_menu_topup)).setOnClickListener(this.f3771s);
        linearLayout.setOnClickListener(this.f3771s);
        linearLayout2.setOnClickListener(this.f3771s);
        linearLayout3.setOnClickListener(this.f3771s);
        linearLayout4.setOnClickListener(this.f3771s);
        linearLayout = (LinearLayout) inflate.findViewById(R.id.home_menu_share);
        linearLayout2 = (LinearLayout) inflate.findViewById(R.id.home_menu_scan);
        linearLayout3 = (LinearLayout) inflate.findViewById(R.id.home_menu_token);
        linearLayout4 = (LinearLayout) inflate.findViewById(R.id.home_menu_history);
        ((LinearLayout) inflate.findViewById(R.id.home_menu_pay)).setOnClickListener(this.f3771s);
        linearLayout.setOnClickListener(this.f3771s);
        linearLayout2.setOnClickListener(this.f3771s);
        linearLayout3.setOnClickListener(this.f3771s);
        linearLayout4.setOnClickListener(this.f3771s);
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        this.f3769q.mo1505o();
        m5770f();
        C1216a.m4519a(f3759a, " in onResume >>>>>");
        if (this.f3768p == null) {
            this.f3768p = C1572g.m5777a((C1359a) getActivity());
        }
        this.f3764l.getViewTreeObserver().addOnGlobalLayoutListener(new C15671(this));
        m5771g();
    }
}
