package com.skcc.wallet.framework.api.http.model;

public class GetRetailStoreLocationRq {
    private CommonHeader commonHeader;
    private double latitude;
    private double longitude;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }
}
