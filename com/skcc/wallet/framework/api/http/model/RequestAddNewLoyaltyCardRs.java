package com.skcc.wallet.framework.api.http.model;

public class RequestAddNewLoyaltyCardRs extends ResultRs {
    private LoyaltyCardDetail LoyaltyCardDetail;

    public LoyaltyCardDetail getLoyaltyCardDetail() {
        return this.LoyaltyCardDetail;
    }

    public void setLoyaltyCardDetail(LoyaltyCardDetail loyaltyCardDetail) {
        this.LoyaltyCardDetail = loyaltyCardDetail;
    }
}
