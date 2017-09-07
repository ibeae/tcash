package com.telkom.mwallet.coupon;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.http.model.CouponDetail;
import com.telkom.mwallet.R;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.p064a.C1358h.C1356b;
import com.telkom.mwallet.p064a.C1358h.C1357c;
import com.telkom.mwallet.tcash.fragment.C1386e;
import java.text.SimpleDateFormat;

@SuppressLint({"ParserError", "ParserError"})
public class C1446b extends C1386e {
    private static final String f3338b = C1446b.class.getSimpleName();
    private static final SimpleDateFormat f3339c = new SimpleDateFormat("yyyyMMddHHmmss");
    private String f3340A = "";
    private boolean f3341B;
    private boolean f3342C;
    private boolean f3343D;
    private CouponDetailActivity f3344E;
    private OnClickListener f3345F = new C14411(this);
    ImageView f3346a;
    private FragmentManager f3347j;
    private C1459d f3348k;
    private RelativeLayout f3349l;
    private Button f3350m;
    private Button f3351n;
    private Button f3352o;
    private Button f3353p;
    private Button f3354q;
    private TextView f3355r;
    private TextView f3356s;
    private TextView f3357t;
    private TextView f3358u;
    private TextView f3359v;
    private LinearLayout f3360w;
    private CouponDetail f3361x;
    private String f3362y = "";
    private String f3363z = "";

    class C14411 implements OnClickListener {
        final /* synthetic */ C1446b f3319a;

        C14411(C1446b c1446b) {
            this.f3319a = c1446b;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.activity_coupon_detail_delete_button:
                    this.f3319a.f3344E.m5358w();
                    return;
                case R.id.activity_coupon_detail_facebook_button:
                    this.f3319a.f3344E.m5359x();
                    return;
                case R.id.activity_coupon_detail_save_button:
                    this.f3319a.f3344E.m5347a(true);
                    return;
                case R.id.activity_coupon_detail_tnc_button:
                    Intent intent = new Intent(this.f3319a.f3344E, CouponTnCActivity.class);
                    intent.putExtra("coupon_tnc", this.f3319a.f3361x.getTncUrl());
                    this.f3319a.startActivity(intent);
                    return;
                case R.id.activity_coupon_detail_use_button:
                    this.f3319a.f3348k = new C1459d();
                    this.f3319a.f3348k.m5527a(this.f3319a.f3344E.getApplicationContext());
                    this.f3319a.f3348k.setStyle(0, R.style.tcash_menu_dialog);
                    this.f3319a.f3348k.m5530b(this.f3319a.f3342C);
                    this.f3319a.f3348k.m5531c(this.f3319a.f3343D);
                    this.f3319a.f3348k.m5529a(this.f3319a.f3341B);
                    this.f3319a.f3348k.show(this.f3319a.f3347j, null);
                    return;
                default:
                    return;
            }
        }
    }

    void m5481a(CouponDetail couponDetail) {
        this.f3361x = couponDetail;
        if (this.f3355r != null) {
            this.f3355r.setText(couponDetail.getCampaignTitle());
            this.f3357t.setText(couponDetail.getCampaignDescription());
            this.f3344E.m5345a(couponDetail.getCouponImageUrl(), this.f3346a);
            this.f3351n.setEnabled(true);
            this.f3352o.setEnabled(true);
            this.f3354q.setEnabled(true);
            if (couponDetail.getCampaignEndDate() != null) {
                this.f3362y = C1354g.m4954e(couponDetail.getCampaignEndDate());
                this.f3363z = C1354g.m4954e(couponDetail.getRedeemDtim());
                this.f3340A = C1354g.m4954e(couponDetail.getCouponExpiryDate());
                this.f3359v.setVisibility(0);
                this.f3356s.setVisibility(0);
                this.f3356s.setText("Expires on " + this.f3362y);
            }
            String couponStatus = couponDetail.getCouponStatus();
            C1216a.m4519a("TTEST", "Detail, couponStatus : " + couponStatus);
            if (C1356b.f2923b.equals(couponStatus)) {
                if (C1357c.f2926b.equals(couponDetail.getCouponUserStatus())) {
                    m5485g();
                } else {
                    m5487i();
                }
                m5482d();
            } else if (C1356b.f2924c.equals(couponStatus)) {
                m5485g();
                m5482d();
            }
            couponStatus = couponDetail.getCouponUserStatus();
            C1216a.m4522b(f3338b, "COUPON_USERSTATUS " + couponStatus);
            if (couponStatus == null || couponStatus.isEmpty() || couponStatus.equals(C1357c.f2927c)) {
                m5484f();
            } else if (couponStatus.equals(C1357c.f2925a) || couponStatus.equals(C1357c.f2929e)) {
                C1216a.m4522b(f3338b, "redeemable   = issued " + couponStatus);
                m5483e();
            } else if (couponStatus.equals(C1357c.f2926b)) {
                m5485g();
                m5482d();
            } else {
                m5486h();
                m5482d();
            }
            C1216a.m4522b(f3338b, "getNfcRedemptionYn " + couponDetail.getNfcRedemptionYn());
            C1216a.m4522b(f3338b, "getPinRedemptionYn " + couponDetail.getPinRedemptionYn());
            C1216a.m4522b(f3338b, "getPosRedemptionYn " + couponDetail.getPosRedemptionYn());
            C1216a.m4522b(f3338b, "getShareFeatureOnOff " + couponDetail.getShareFeatureOnOff());
            if ("Y".equals(couponDetail.getNfcRedemptionYn())) {
                this.f3341B = true;
            } else {
                this.f3341B = false;
            }
            if ("Y".equals(couponDetail.getPinRedemptionYn())) {
                this.f3342C = true;
            } else {
                this.f3342C = false;
            }
            if ("Y".equals(couponDetail.getPosRedemptionYn())) {
                this.f3343D = true;
            } else {
                this.f3343D = false;
            }
            if ("on".equals(couponDetail.getShareFeatureOnOff())) {
                this.f3350m.setClickable(true);
            } else if ("off".equals(couponDetail.getShareFeatureOnOff())) {
                this.f3350m.setClickable(false);
            }
        }
    }

    void m5482d() {
        this.f3351n.setVisibility(0);
        this.f3352o.setVisibility(8);
        this.f3354q.setVisibility(0);
    }

    void m5483e() {
        this.f3351n.setVisibility(0);
        this.f3352o.setVisibility(8);
        this.f3354q.setVisibility(0);
    }

    void m5484f() {
        this.f3351n.setVisibility(0);
        this.f3352o.setVisibility(0);
        this.f3354q.setVisibility(8);
    }

    void m5485g() {
        if (this.f3348k != null) {
            this.f3348k.dismiss();
            this.f3348k = null;
        }
        this.f3351n.setEnabled(false);
        this.f3352o.setEnabled(false);
        this.f3354q.setEnabled(false);
        this.f3358u.setText("Redeemed");
        this.f3359v.setText("Redeemed on " + this.f3363z);
        this.f3356s.setText("Expires on " + this.f3362y);
        this.f3356s.setTextColor(getResources().getColor(R.color.darkgray));
        this.f3359v.setVisibility(0);
        this.f3360w.setVisibility(0);
        this.f3360w.setBackgroundColor(-869619884);
    }

    void m5486h() {
        this.f3351n.setEnabled(false);
        this.f3352o.setEnabled(false);
        this.f3354q.setEnabled(false);
        this.f3358u.setText("Expired");
        this.f3359v.setText("Expired on " + this.f3340A);
        this.f3356s.setText("Expired on " + this.f3340A);
        this.f3356s.setTextColor(getResources().getColor(R.color.n_red));
        this.f3359v.setVisibility(0);
        this.f3360w.setVisibility(0);
        this.f3360w.setBackgroundColor(-856941532);
    }

    void m5487i() {
        this.f3351n.setEnabled(false);
        this.f3352o.setEnabled(false);
        this.f3354q.setEnabled(false);
        this.f3358u.setText("Out of Stock");
        this.f3359v.setText("Redeemed on " + this.f3362y);
        this.f3356s.setText("Expires on " + this.f3362y);
        this.f3356s.setTextColor(getResources().getColor(R.color.darkgray));
        this.f3359v.setVisibility(8);
        this.f3360w.setVisibility(0);
        this.f3360w.setBackgroundColor(-862348903);
    }

    public boolean m5488j() {
        return this.f3352o.getVisibility() == 0;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_coupon_detail, null);
        m5208c(R.string.title_couponlist);
        this.f3344E = (CouponDetailActivity) getActivity();
        this.f3347j = m5215l();
        this.f3349l = (RelativeLayout) inflate.findViewById(R.id.activity_coupon_detail_relative_layout);
        this.f3346a = (ImageView) inflate.findViewById(R.id.activity_coupon_detail_coupon_imageview);
        this.f3350m = (Button) inflate.findViewById(R.id.activity_coupon_detail_facebook_button);
        this.f3351n = (Button) inflate.findViewById(R.id.activity_coupon_detail_use_button);
        this.f3352o = (Button) inflate.findViewById(R.id.activity_coupon_detail_save_button);
        this.f3354q = (Button) inflate.findViewById(R.id.activity_coupon_detail_delete_button);
        this.f3353p = (Button) inflate.findViewById(R.id.activity_coupon_detail_tnc_button);
        this.f3353p.setText(getString(R.string.title_tnc));
        this.f3355r = (TextView) inflate.findViewById(R.id.activity_coupon_detail_campaign_title);
        this.f3356s = (TextView) inflate.findViewById(R.id.activity_coupon_detail_campaign_date);
        this.f3357t = (TextView) inflate.findViewById(R.id.activity_coupon_detail_campaign_desc);
        this.f3358u = (TextView) inflate.findViewById(R.id.activity_coupon_detail_status_text);
        this.f3359v = (TextView) inflate.findViewById(R.id.activity_coupon_detail_status_date);
        this.f3360w = (LinearLayout) inflate.findViewById(R.id.activity_coupon_detail_status_layout);
        this.f3350m.setOnClickListener(this.f3345F);
        this.f3351n.setOnClickListener(this.f3345F);
        this.f3352o.setOnClickListener(this.f3345F);
        this.f3354q.setOnClickListener(this.f3345F);
        this.f3353p.setOnClickListener(this.f3345F);
        this.h.m4932a(this.f3344E, this.f3353p, 1);
        this.h.m4932a(this.f3344E, this.f3351n, 3);
        this.h.m4932a(this.f3344E, this.f3352o, 3);
        this.h.m4932a(this.f3344E, this.f3354q, 3);
        this.h.m4932a(this.f3344E, this.f3355r, 3);
        this.h.m4932a(this.f3344E, this.f3356s, 3);
        this.h.m4932a(this.f3344E, this.f3357t, 1);
        this.h.m4932a(this.f3344E, this.f3358u, 1);
        this.h.m4932a(this.f3344E, this.f3359v, 1);
        this.h.m4932a(this.f3344E, this.f3359v, 1);
        if (this.f3361x != null) {
            m5481a(this.f3361x);
        }
        return inflate;
    }
}
