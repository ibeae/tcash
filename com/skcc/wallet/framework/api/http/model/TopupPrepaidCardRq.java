package com.skcc.wallet.framework.api.http.model;

public class TopupPrepaidCardRq {
    private String amount;
    private CommonHeader commonHeader;
    private String serviceId;

    public String getAmount() {
        return this.amount;
    }

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getServiceId() {
        return this.serviceId;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setServiceId(String str) {
        this.serviceId = str;
    }
}
