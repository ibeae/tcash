package com.skcc.wallet.framework.api.http.model;

import java.util.List;

public class GetAllCardListRs extends ResultRs {
    private List<ServiceVo> cards;

    public List<ServiceVo> getCards() {
        return this.cards;
    }

    public void setCards(List<ServiceVo> list) {
        this.cards = list;
    }
}
