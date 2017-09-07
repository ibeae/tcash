package com.skcc.wallet.framework.api.http.model;

public class LoyaltyCardDetail extends LoyaltyCardBase {
    private String loyaltyCardDesc;
    private String loyaltyCardImageUrl;
    private String loyaltyCardInstanceId;
    private String loyaltyCardNumber;
    private String loyaltyCardStatus;

    public String getLoyaltyCardDesc() {
        return this.loyaltyCardDesc;
    }

    public String getLoyaltyCardImageUrl() {
        return this.loyaltyCardImageUrl;
    }

    public String getLoyaltyCardInstanceId() {
        return this.loyaltyCardInstanceId;
    }

    public String getLoyaltyCardNumber() {
        return this.loyaltyCardNumber;
    }

    public String getLoyaltyCardStatus() {
        return this.loyaltyCardStatus;
    }

    public void setLoyaltyCardDesc(String str) {
        this.loyaltyCardDesc = str;
    }

    public void setLoyaltyCardImageUrl(String str) {
        this.loyaltyCardImageUrl = str;
    }

    public void setLoyaltyCardInstanceId(String str) {
        this.loyaltyCardInstanceId = str;
    }

    public void setLoyaltyCardNumber(String str) {
        this.loyaltyCardNumber = str;
    }

    public void setLoyaltyCardStatus(String str) {
        this.loyaltyCardStatus = str;
    }
}
