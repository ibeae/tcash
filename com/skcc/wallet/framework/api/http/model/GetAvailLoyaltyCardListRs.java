package com.skcc.wallet.framework.api.http.model;

import java.util.List;

public class GetAvailLoyaltyCardListRs extends ResultRs {
    private List<LoyaltyCard> loyaltyCardList;

    public List<LoyaltyCard> getLoyaltyCardList() {
        return this.loyaltyCardList;
    }

    public void setLoyaltyCardList(List<LoyaltyCard> list) {
        this.loyaltyCardList = list;
    }
}
