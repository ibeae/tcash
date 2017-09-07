package com.skcc.wallet.framework.api.http.model;

import java.util.List;

public class GetAllCouponListRs extends ResultRs {
    private List<Coupon> couponList;

    public List<Coupon> getCouponList() {
        return this.couponList;
    }

    public void setCouponList(List<Coupon> list) {
        this.couponList = list;
    }
}
