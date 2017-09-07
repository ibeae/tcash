package com.skcc.wallet.framework.api.http.model;

public class ChangeTcashPinRq {
    private CommonHeader commonHeader;
    private String currentPin;
    private String newPin;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getCurrentPin() {
        return this.currentPin;
    }

    public String getNewPin() {
        return this.newPin;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setCurrentPin(String str) {
        this.currentPin = str;
    }

    public void setNewPin(String str) {
        this.newPin = str;
    }
}
