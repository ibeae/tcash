package com.skcc.wallet.framework.api.http.model;

public class TopupSmsBankRq {
    private CommonHeader commonHeader;
    private SmsBank smsBank;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public SmsBank getSmsBank() {
        return this.smsBank;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setSmsBank(SmsBank smsBank) {
        this.smsBank = smsBank;
    }
}
