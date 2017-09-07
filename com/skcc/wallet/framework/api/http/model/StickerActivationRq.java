package com.skcc.wallet.framework.api.http.model;

public class StickerActivationRq {
    private CommonHeader commonHeader;
    private String serialNumber;
    private String tcashPin;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public String getTcashPin() {
        return this.tcashPin;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setSerialNumber(String str) {
        this.serialNumber = str;
    }

    public void setTcashPin(String str) {
        this.tcashPin = str;
    }
}
