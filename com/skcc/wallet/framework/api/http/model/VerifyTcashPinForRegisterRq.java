package com.skcc.wallet.framework.api.http.model;

public class VerifyTcashPinForRegisterRq {
    private CommonHeader commonHeader;
    private String encTcashPin;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getEncTcashPin() {
        return this.encTcashPin;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setEncTcashPin(String str) {
        this.encTcashPin = str;
    }
}
