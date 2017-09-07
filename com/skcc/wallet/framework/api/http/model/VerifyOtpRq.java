package com.skcc.wallet.framework.api.http.model;

public class VerifyOtpRq {
    private CommonHeader commonHeader;
    private String otp;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getOtp() {
        return this.otp;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setOtp(String str) {
        this.otp = str;
    }
}
