package com.skcc.wallet.framework.api.http.model;

public class GetAllCouponListRq {
    private CommonHeader commonHeader;
    private String latitude;
    private String longitude;
    private String orderType;
    private String returnCount;
    private String startNumber;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getOrderType() {
        return this.orderType;
    }

    public String getReturnCount() {
        return this.returnCount;
    }

    public String getStartNumber() {
        return this.startNumber;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setOrderType(String str) {
        this.orderType = str;
    }

    public void setReturnCount(String str) {
        this.returnCount = str;
    }

    public void setStartNumber(String str) {
        this.startNumber = str;
    }
}
