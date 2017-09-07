package com.skcc.wallet.framework.api.http.model;

public class RegisterUserMobileRq {
    private CommonHeader commonHeader;
    private String encTcashPin;
    private MobileInfo mobileInfo;
    private String token;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getEncTcashPin() {
        return this.encTcashPin;
    }

    public MobileInfo getMobileInfo() {
        return this.mobileInfo;
    }

    public String getToken() {
        return this.token;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setEncTcashPin(String str) {
        this.encTcashPin = str;
    }

    public void setMobileInfo(MobileInfo mobileInfo) {
        this.mobileInfo = mobileInfo;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
