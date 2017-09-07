package com.skcc.wallet.framework.api.http.model;

public class VCard {
    private String balance;
    private String cardId;
    private boolean isLoded;
    private String validUntil;

    public String getBalance() {
        return this.balance;
    }

    public String getCardId() {
        return this.cardId;
    }

    public String getValidUntil() {
        return this.validUntil;
    }

    public boolean isLoded() {
        return this.isLoded;
    }

    public void setBalance(String str) {
        this.balance = str;
    }

    public void setCardId(String str) {
        this.cardId = str;
    }

    public void setLoded(boolean z) {
        this.isLoded = z;
    }

    public void setValidUntil(String str) {
        this.validUntil = str;
    }
}
