package com.telkom.mwallet.slidingframe;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.AppEventsConstants;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.http.C1245f;
import com.skcc.wallet.framework.api.http.model.CountDownloadedCouponRs;
import com.skcc.wallet.framework.api.http.model.Coupon;
import com.skcc.wallet.framework.api.http.model.GetAllCouponListRs;
import com.skcc.wallet.framework.p062d.C1318b;
import com.telkom.mwallet.R;
import com.telkom.mwallet.coupon.CouponDetailActivity;
import com.telkom.mwallet.coupon.CouponListActivity;
import com.telkom.mwallet.home.C1385b;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.p064a.C1358h;
import com.telkom.mwallet.p064a.C1358h.C1355a;
import com.telkom.mwallet.p064a.C1358h.C1356b;
import com.telkom.mwallet.p064a.C1358h.C1357c;
import java.io.IOException;
import java.util.List;

public class C1720a extends C1385b {
    public boolean f4339a = false;
    private C1318b f4340b;
    private ListView f4341c;
    private LinearLayout f4342j;
    private LinearLayout f4343k;
    private C1719b f4344l = null;
    private String f4345m = "";
    private TextView f4346n;

    class C17151 implements OnClickListener {
        final /* synthetic */ C1720a f4327a;

        C17151(C1720a c1720a) {
            this.f4327a = c1720a;
        }

        public void onClick(View view) {
            Intent intent = new Intent(this.f4327a.e, CouponListActivity.class);
            intent.setFlags(536870912);
            this.f4327a.startActivity(intent);
            this.f4327a.e.m5017C();
        }
    }

    class C17162 implements OnClickListener {
        final /* synthetic */ C1720a f4328a;

        C17162(C1720a c1720a) {
            this.f4328a = c1720a;
        }

        public void onClick(View view) {
        }
    }

    protected class C1717a implements OnItemClickListener {
        final /* synthetic */ C1720a f4329a;

        protected C1717a(C1720a c1720a) {
            this.f4329a = c1720a;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f4329a.m6435a(i);
        }
    }

    private class C1719b extends ArrayAdapter<Coupon> {
        final /* synthetic */ C1720a f4335a;
        private final LayoutInflater f4336b;
        private final int f4337c;
        private List<?> f4338d;

        class C1718a {
            ImageView f4330a;
            TextView f4331b;
            TextView f4332c;
            LinearLayout f4333d;
            final /* synthetic */ C1719b f4334e;

            C1718a(C1719b c1719b) {
                this.f4334e = c1719b;
            }
        }

        public C1719b(C1720a c1720a, Context context, int i) {
            this.f4335a = c1720a;
            super(context, i);
            this.f4337c = i;
            this.f4336b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        void m6423a(C1718a c1718a) {
            c1718a.f4333d.setVisibility(0);
            c1718a.f4333d.setBackgroundColor(-869619884);
            c1718a.f4331b.setText("Redeemed");
            c1718a.f4332c.setText("Redeemed on " + this.f4335a.f4345m);
            c1718a.f4332c.setVisibility(0);
        }

        protected void m6424a(List<?> list) {
            this.f4338d = list;
        }

        void m6425b(C1718a c1718a) {
            c1718a.f4333d.setVisibility(0);
            c1718a.f4333d.setBackgroundColor(-856941532);
            c1718a.f4331b.setText("Expired");
            c1718a.f4332c.setText("Expired on " + this.f4335a.f4345m);
            c1718a.f4332c.setVisibility(0);
        }

        void m6426c(C1718a c1718a) {
            c1718a.f4333d.setVisibility(0);
            c1718a.f4333d.setBackgroundColor(-644245095);
            c1718a.f4331b.setText("Out of Stock");
            c1718a.f4332c.setVisibility(8);
        }

        public int getCount() {
            return this.f4338d == null ? 0 : this.f4338d.size();
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            C1718a c1718a;
            if (view == null) {
                view = this.f4336b.inflate(this.f4337c, viewGroup, false);
                c1718a = new C1718a(this);
                c1718a.f4333d = (LinearLayout) view.findViewById(R.id.frame_drawer_right_coupon_listitem_status_layout);
                c1718a.f4330a = (ImageView) view.findViewById(R.id.frame_drawer_right_coupon_listitem_imageview);
                c1718a.f4331b = (TextView) view.findViewById(R.id.frame_drawer_right_coupon_listitem_status_text);
                c1718a.f4332c = (TextView) view.findViewById(R.id.frame_drawer_right_coupon_listitem_status_date);
                this.f4335a.h.m4932a(this.f4335a.getActivity(), c1718a.f4331b, 1);
                this.f4335a.h.m4932a(this.f4335a.getActivity(), c1718a.f4332c, 1);
                view.setTag(c1718a);
            } else {
                c1718a = (C1718a) view.getTag();
            }
            Coupon coupon = (Coupon) this.f4338d.get(i);
            c1718a.f4333d.setVisibility(8);
            C1216a.m4522b("SLIDE", " coupon item name " + coupon.getCampaignTitle());
            this.f4335a.m6436a(coupon.getCouponImageUrl(), c1718a.f4330a);
            if (coupon.getCampaignEndDate() != null) {
                this.f4335a.f4345m = C1354g.m4954e(coupon.getCampaignEndDate());
                c1718a.f4332c.setVisibility(0);
            }
            if (C1356b.f2922a.equals(coupon.getCouponStatus())) {
                String couponUserStatus = coupon.getCouponUserStatus();
                if (!(couponUserStatus == null || couponUserStatus.isEmpty() || couponUserStatus.equals(C1357c.f2927c) || couponUserStatus.equals(C1357c.f2925a) || couponUserStatus.equals(C1357c.f2929e))) {
                    if (couponUserStatus.equals(C1357c.f2926b)) {
                        m6423a(c1718a);
                    } else {
                        m6425b(c1718a);
                    }
                }
            } else if (C1356b.f2923b.equals(coupon.getCouponStatus())) {
                if (C1357c.f2926b.equals(coupon.getCouponUserStatus())) {
                    m6423a(c1718a);
                } else {
                    m6426c(c1718a);
                }
            } else if (C1356b.f2924c.equals(coupon.getCouponStatus())) {
                m6423a(c1718a);
            }
            return view;
        }
    }

    private void m6430b(String str) {
        C1216a.m4522b("COUNT", "displayMyCouponCount " + str);
        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str)) {
            this.f4346n.setVisibility(8);
            return;
        }
        this.f4346n.setVisibility(0);
        this.f4346n.setText(str);
    }

    private void m6434h() {
        List b = C1727c.m6488a().m6490b();
        if (this.f4344l == null) {
            this.f4344l = new C1719b(this, getActivity(), R.layout.view_frame_drawer_right_coupon_listitem);
            this.f4341c.setAdapter(this.f4344l);
            this.f4341c.setOnItemClickListener(new C1717a(this));
        }
        this.f4344l.m6424a(b);
        this.f4344l.notifyDataSetChanged();
        if (this.f4344l.getCount() > 0) {
            this.f4342j.setVisibility(8);
            this.f4341c.setVisibility(0);
            return;
        }
        this.f4341c.setVisibility(8);
        this.f4342j.setVisibility(0);
    }

    protected void m6435a(int i) {
        Intent intent = new Intent(getActivity(), CouponDetailActivity.class);
        intent.putExtra("COUPONINDEX", i);
        Coupon coupon = (Coupon) C1727c.m6488a().m6490b().get(i);
        intent.putExtra("CampaignId", coupon.getCampaignId());
        intent.putExtra("MerchantId", coupon.getMerchantId());
        intent.putExtra("couponProfileNo", coupon.getCouponProfileNo());
        startActivity(intent);
    }

    public void m6436a(String str, ImageView imageView) {
        if (str.startsWith("http")) {
            this.f4340b.m4808a(str, imageView);
            return;
        }
        try {
            C1216a.m4522b("imagesub", "image:  ");
            imageView.setImageDrawable(Drawable.createFromStream(getActivity().getAssets().open(str), null));
        } catch (IOException e) {
        }
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a("CouponMenuFragment", "onSuccessNetwork");
        this.g.m4647a("time for update", System.currentTimeMillis());
        m5218o();
        if ("getAllCouponList".equalsIgnoreCase(str)) {
            if (obj != null) {
                GetAllCouponListRs getAllCouponListRs = (GetAllCouponListRs) obj;
                if (getAllCouponListRs.getCouponList() != null) {
                    C1727c.m6488a().m6489a(getAllCouponListRs.getCouponList());
                    m6434h();
                }
            }
        } else if ("countDownloadedCoupon".equalsIgnoreCase(str)) {
            CountDownloadedCouponRs countDownloadedCouponRs = (CountDownloadedCouponRs) obj;
            this.g.m4647a(C1358h.f2937h, System.currentTimeMillis());
            this.g.m4648a(C1358h.f2936g, countDownloadedCouponRs.getCount());
            m6430b(countDownloadedCouponRs.getCount());
        }
    }

    public void m6438d() {
        View currentFocus = getActivity().getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    public void m6439e() {
        List b = C1727c.m6488a().m6490b();
        if (b != null || b.size() > 0) {
            m6434h();
        }
    }

    public void m6440f() {
        long b = this.g.m4650b(C1358h.f2937h, -1);
        if (b <= 0) {
            this.d.m4672a((C1245f) this);
        } else if (System.currentTimeMillis() - b <= 108000000) {
            m6430b(this.g.m4651b(C1358h.f2936g, AppEventsConstants.EVENT_PARAM_VALUE_NO));
        }
    }

    public void m6441g() {
        if (this.f4339a) {
            m6434h();
            return;
        }
        this.d.m4706b(C1355a.f2919a, AppEventsConstants.EVENT_PARAM_VALUE_YES, "10", AppEventsConstants.EVENT_PARAM_VALUE_NO, AppEventsConstants.EVENT_PARAM_VALUE_NO, this);
        this.f4339a = true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.slide_menu_coupon, null);
        this.f4340b = new C1318b(getActivity().getApplication());
        this.f4341c = (ListView) inflate.findViewById(R.id.coupon_menu);
        View view = (TextView) inflate.findViewById(R.id.coupon_seeall);
        View view2 = (TextView) inflate.findViewById(R.id.voucher_seeall);
        view.setOnClickListener(new C17151(this));
        view2.setOnClickListener(new C17162(this));
        View view3 = (TextView) inflate.findViewById(R.id.coupon_title);
        View view4 = (TextView) inflate.findViewById(R.id.voucher_title);
        if (this.h == null) {
            this.h = this.e.m4982d();
        }
        this.f4346n = (TextView) inflate.findViewById(R.id.my_coupon_count);
        this.f4342j = (LinearLayout) inflate.findViewById(R.id.couponlist_nodata_layout);
        this.f4343k = (LinearLayout) inflate.findViewById(R.id.voucherlist_nodata_layout);
        this.h.m4932a(getActivity(), view3, 3);
        this.h.m4932a(getActivity(), view4, 3);
        this.h.m4932a(getActivity(), view, 1);
        this.h.m4932a(getActivity(), view2, 1);
        this.h.m4932a(getActivity(), (TextView) inflate.findViewById(R.id.nodata_list_textview), 1);
        return inflate;
    }

    public void onResume() {
        super.onResume();
        m6439e();
        C1216a.m4522b(" resume", "onCouponMenu Resume");
    }
}
