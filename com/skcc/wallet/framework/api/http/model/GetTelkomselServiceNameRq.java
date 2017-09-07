package com.skcc.wallet.framework.api.http.model;

public class GetTelkomselServiceNameRq {
    private CommonHeader commonHeader;
    private String destinationNo;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getDestinationNo() {
        return this.destinationNo;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setDestinationNo(String str) {
        this.destinationNo = str;
    }
}
