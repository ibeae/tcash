package com.skcc.wallet.framework.api.http.model;

public class RequestCouponRedemptionRs extends ResultRs {
    private String couponSerialNo;

    public String getCouponSerialNo() {
        return this.couponSerialNo;
    }

    public void setCouponSerialNo(String str) {
        this.couponSerialNo = str;
    }
}
