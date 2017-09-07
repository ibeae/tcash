package com.skcc.wallet.framework.api.http.model;

public class VerifyOtpAndMakePinRq {
    private CommonHeader commonHeader;
    private MobileInfo mobileInfo = null;
    private String otp;
    private String temporaryCustomerId = null;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public MobileInfo getMobileInfo() {
        return this.mobileInfo;
    }

    public String getOtp() {
        return this.otp;
    }

    public String getTemporaryCustomerId() {
        return this.temporaryCustomerId;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setMobileInfo(MobileInfo mobileInfo) {
        this.mobileInfo = mobileInfo;
    }

    public void setOtp(String str) {
        this.otp = str;
    }

    public void setTemporaryCustomerId(String str) {
        this.temporaryCustomerId = str;
    }
}
