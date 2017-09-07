package com.skcc.wallet.framework.api.http.model;

public class CheckEligibilityRq {
    private CommonHeader commonHeader;
    private String isRegistrationYn;
    private String modelNumber;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getIsRegistrationYn() {
        return this.isRegistrationYn;
    }

    public String getModelNumber() {
        return this.modelNumber;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setIsRegistrationYn(String str) {
        this.isRegistrationYn = str;
    }

    public void setModelNumber(String str) {
        this.modelNumber = str;
    }
}
