package com.skcc.wallet.framework.api.http.model;

public class VerifySecurityAnswerRq {
    private String answer = null;
    private CommonHeader commonHeader;
    private MobileInfo mobileInfo = null;
    private String temporaryCustomerId = null;

    public String getAnswer() {
        return this.answer;
    }

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public MobileInfo getMobileInfo() {
        return this.mobileInfo;
    }

    public String getTemporaryCustomerId() {
        return this.temporaryCustomerId;
    }

    public void setAnswer(String str) {
        this.answer = str;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setMobileInfo(MobileInfo mobileInfo) {
        this.mobileInfo = mobileInfo;
    }

    public void setTemporaryCustomerId(String str) {
        this.temporaryCustomerId = str;
    }
}
