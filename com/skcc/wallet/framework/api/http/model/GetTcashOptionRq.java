package com.skcc.wallet.framework.api.http.model;

public class GetTcashOptionRq {
    private CommonHeader commonHeader;
    private String type;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getType() {
        return this.type;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setType(String str) {
        this.type = str;
    }
}
