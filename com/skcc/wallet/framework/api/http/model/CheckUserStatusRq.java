package com.skcc.wallet.framework.api.http.model;

public class CheckUserStatusRq {
    private String checkMsisdn;
    private CommonHeader commonHeader;

    public String getCheckMsisdn() {
        return this.checkMsisdn;
    }

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public void setCheckMsisdn(String str) {
        this.checkMsisdn = str;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }
}
