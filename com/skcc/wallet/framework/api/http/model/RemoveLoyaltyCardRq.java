package com.skcc.wallet.framework.api.http.model;

public class RemoveLoyaltyCardRq {
    private CommonHeader commonHeader;
    private String loyaltyCardInstanceId;
    private String loyaltyCardProfileNo;
    private String merchantId;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getLoyaltyCardInstanceId() {
        return this.loyaltyCardInstanceId;
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

    public void setLoyaltyCardInstanceId(String str) {
        this.loyaltyCardInstanceId = str;
    }

    public void setLoyaltyCardProfileNo(String str) {
        this.loyaltyCardProfileNo = str;
    }

    public void setMerchantId(String str) {
        this.merchantId = str;
    }
}
