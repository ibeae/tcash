package com.skcc.wallet.framework.api.http.model;

import java.util.List;

public class GetMyDownloadCouponRs extends ResultRs {
    private List<CouponDetail> couponDetailList;

    public List<CouponDetail> getCouponDetailList() {
        return this.couponDetailList;
    }

    public void setCouponDetailList(List<CouponDetail> list) {
        this.couponDetailList = list;
    }
}
