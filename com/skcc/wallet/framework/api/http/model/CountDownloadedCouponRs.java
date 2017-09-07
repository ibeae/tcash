package com.skcc.wallet.framework.api.http.model;

public class CountDownloadedCouponRs extends ResultRs {
    private String count;

    public String getCount() {
        return this.count;
    }

    public void setCount(String str) {
        this.count = str;
    }
}
