package com.skcc.wallet.framework.api.http.model;

public class SetTcashPinRq {
    private CommonHeader commonHeader;
    private String newPin;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getNewPin() {
        return this.newPin;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setNewPin(String str) {
        this.newPin = str;
    }
}
