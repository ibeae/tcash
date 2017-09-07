package com.skcc.wallet.framework.api.http.model;

public class GetCouponDetailRs extends ResultRs {
    private CouponDetail coupon;

    public CouponDetail getCoupon() {
        return this.coupon;
    }

    public void setCoupon(CouponDetail couponDetail) {
        this.coupon = couponDetail;
    }
}
