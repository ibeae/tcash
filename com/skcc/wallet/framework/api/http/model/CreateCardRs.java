package com.skcc.wallet.framework.api.http.model;

public class CreateCardRs extends MyCardResult {
    private VCard vCard = new VCard();

    public String getCardId() {
        return this.vCard.getCardId();
    }

    public VCard getVCard() {
        return this.vCard;
    }

    public String getValidUntil() {
        return this.vCard.getValidUntil();
    }

    public void setCardId(String str) {
        this.vCard.setCardId(str);
    }

    public void setVCard(VCard vCard) {
        this.vCard = vCard;
    }

    public void setValidUntil(String str) {
        this.vCard.setValidUntil(str);
    }
}
