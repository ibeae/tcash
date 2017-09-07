package com.skcc.wallet.framework.api.http.model;

public class RequestCouponDownloadRs extends ResultRs {
    private int count;
    private String couponInstanceId;
    private String couponSerialNo;
    private String expiryDate;

    public int getCount() {
        return this.count;
    }

    public String getCouponInstanceId() {
        return this.couponInstanceId;
    }

    public String getCouponSerialNo() {
        return this.couponSerialNo;
    }

    public String getExpiryDate() {
        return this.expiryDate;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setCouponInstanceId(String str) {
        this.couponInstanceId = str;
    }

    public void setCouponSerialNo(String str) {
        this.couponSerialNo = str;
    }

    public void setExpiryDate(String str) {
        this.expiryDate = str;
    }
}
