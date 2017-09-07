package com.skcc.wallet.framework.api.http.model;

public class GetLoyaltyInfoRq {
    private CommonHeader commonHeader;

    public GetLoyaltyInfoRq() {
        this.commonHeader = null;
    }

    public GetLoyaltyInfoRq(String str, String str2) {
        this.commonHeader = null;
        this.commonHeader = new CommonHeader();
        this.commonHeader.setMsisdn(str);
        this.commonHeader.setTid(str2);
    }

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }
}
