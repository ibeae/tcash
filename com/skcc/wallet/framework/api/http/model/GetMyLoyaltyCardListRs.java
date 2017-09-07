package com.skcc.wallet.framework.api.http.model;

import java.util.List;

public class GetMyLoyaltyCardListRs extends ResultRs {
    private List<LoyaltyCardDetail> loyaltyCardList;

    public List<LoyaltyCardDetail> getLoyaltyCardList() {
        return this.loyaltyCardList;
    }

    public void setLoyaltyCardList(List<LoyaltyCardDetail> list) {
        this.loyaltyCardList = list;
    }
}
