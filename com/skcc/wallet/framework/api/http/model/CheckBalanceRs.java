package com.skcc.wallet.framework.api.http.model;

public class CheckBalanceRs extends MyCardResult {
    private String balance;
    private String cardId;

    public String getBalance() {
        return this.balance;
    }

    public String getCardId() {
        return this.cardId;
    }

    public void setBalance(String str) {
        this.balance = str;
    }

    public void setCardId(String str) {
        this.cardId = str;
    }
}
