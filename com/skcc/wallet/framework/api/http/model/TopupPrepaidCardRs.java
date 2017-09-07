package com.skcc.wallet.framework.api.http.model;

public class TopupPrepaidCardRs extends ResultRs {
    private Double balance;

    public Double getBalance() {
        return this.balance;
    }

    public void setBalance(Double d) {
        this.balance = d;
    }
}
