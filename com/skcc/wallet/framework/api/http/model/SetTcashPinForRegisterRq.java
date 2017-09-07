package com.skcc.wallet.framework.api.http.model;

public class SetTcashPinForRegisterRq {
    private CommonHeader commonHeader;
    private String encNewPin;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getEncNewPin() {
        return this.encNewPin;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setEncNewPin(String str) {
        this.encNewPin = str;
    }
}
