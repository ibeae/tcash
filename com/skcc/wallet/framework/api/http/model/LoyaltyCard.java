package com.skcc.wallet.framework.api.http.model;

public class LoyaltyCard extends LoyaltyCardBase {
    private String loyaltyCardDefaultImageUrl;
    private String loyaltyCardDesc;

    public String getLoyaltyCardDefaultImageUrl() {
        return this.loyaltyCardDefaultImageUrl;
    }

    public String getLoyaltyCardDesc() {
        return this.loyaltyCardDesc;
    }

    public void setLoyaltyCardDefaultImageUrl(String str) {
        this.loyaltyCardDefaultImageUrl = str;
    }

    public void setLoyaltyCardDesc(String str) {
        this.loyaltyCardDesc = str;
    }
}
