package com.skcc.wallet.framework.api.http.model;

public class StickerDeactivationRq {
    private CommonHeader commonHeader;
    private String tcashPin;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getTcashPin() {
        return this.tcashPin;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setTcashPin(String str) {
        this.tcashPin = str;
    }
}
