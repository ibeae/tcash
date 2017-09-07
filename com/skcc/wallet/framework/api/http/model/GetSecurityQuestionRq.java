package com.skcc.wallet.framework.api.http.model;

public class GetSecurityQuestionRq {
    private CommonHeader commonHeader;
    private String temporaryCustomerId;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getTemporaryCustomerId() {
        return this.temporaryCustomerId;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setTemporaryCustomerId(String str) {
        this.temporaryCustomerId = str;
    }
}
