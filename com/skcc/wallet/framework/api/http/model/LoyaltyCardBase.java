package com.skcc.wallet.framework.api.http.model;

public class LoyaltyCardBase {
    private String loyaltyCardName;
    private String loyaltyCardProfileNo;
    private String loyaltyCardType;
    private String merchantId;

    public String getLoyaltyCardName() {
        return this.loyaltyCardName;
    }

    public String getLoyaltyCardProfileNo() {
        return this.loyaltyCardProfileNo;
    }

    public String getLoyaltyCardType() {
        return this.loyaltyCardType;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public void setLoyaltyCardName(String str) {
        this.loyaltyCardName = str;
    }

    public void setLoyaltyCardProfileNo(String str) {
        this.loyaltyCardProfileNo = str;
    }

    public void setLoyaltyCardType(String str) {
        this.loyaltyCardType = str;
    }

    public void setMerchantId(String str) {
        this.merchantId = str;
    }
}
