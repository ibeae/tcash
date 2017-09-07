package com.skcc.wallet.framework.api.http.model;

public class UnlinkOtherNfcTagRq {
    private CommonHeader commonHeader;
    private String nfcSerialNumber;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getNfcSerialNumber() {
        return this.nfcSerialNumber;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setNfcSerialNumber(String str) {
        this.nfcSerialNumber = str;
    }
}
