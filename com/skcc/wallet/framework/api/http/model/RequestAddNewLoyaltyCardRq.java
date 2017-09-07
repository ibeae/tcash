package com.skcc.wallet.framework.api.http.model;

public class RequestAddNewLoyaltyCardRq {
    private CommonHeader commonHeader;
    private String loyaltyCardNumber;
    private String loyaltyCardProfileNo;
    private String merchantId;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getLoyaltyCardNumber() {
        return this.loyaltyCardNumber;
    }

    public String getLoyaltyCardProfileNo() {
        return this.loyaltyCardProfileNo;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setLoyaltyCardNumber(String str) {
        this.loyaltyCardNumber = str;
    }

    public void setLoyaltyCardProfileNo(String str) {
        this.loyaltyCardProfileNo = str;
    }

    public void setMerchantId(String str) {
        this.merchantId = str;
    }
}
