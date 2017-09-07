package com.skcc.wallet.framework.api.http.model;

public class GetCardTransactionHistoryRq {
    private String cardType;
    private CommonHeader commonHeader;
    private String deviceAppletId;

    public String getCardType() {
        return this.cardType;
    }

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getDeviceAppletId() {
        return this.deviceAppletId;
    }

    public void setCardType(String str) {
        this.cardType = str;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setDeviceAppletId(String str) {
        this.deviceAppletId = str;
    }
}
